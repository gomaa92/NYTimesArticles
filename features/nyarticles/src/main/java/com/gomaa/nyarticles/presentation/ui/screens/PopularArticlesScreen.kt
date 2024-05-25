package com.gomaa.nyarticles.presentation.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gomaa.nyarticles.presentation.model.ArticleUiEntity
import com.gomaa.nyarticles.presentation.ui.components.ArticleDetailBottomSheet
import com.gomaa.nyarticles.presentation.ui.components.ArticlesList
import com.gomaa.nyarticles.presentation.ui.components.CoinLoader
import com.gomaa.nyarticles.presentation.ui.components.EmptyStateUi
import com.gomaa.nyarticles.presentation.ui.components.ErrorStateUi
import com.gomaa.nyarticles.presentation.ui.components.FilterChipRow
import com.gomaa.nyarticles.presentation.viewmodel.PopularArticlesEvent
import com.gomaa.nyarticles.presentation.viewmodel.PopularArticlesViewModel

import com.gomaa.utils.initializeFilterOptions
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularArticlesScreen(
    viewModel: PopularArticlesViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    var filterOptions by remember { mutableStateOf(initializeFilterOptions()) }
    LaunchedEffect(true) {
        viewModel.dispatch(PopularArticlesEvent.FetchPopularArticles(1))
    }
    val articles = viewModel.uiState.collectAsState().value.articles
    val isLoading = viewModel.uiState.collectAsState().value.isLoading
    val isError = viewModel.uiState.collectAsState().value.isError
    val isEmptyState = viewModel.uiState.collectAsState().value.isEmptyResponse

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            skipHiddenState = false
        )
    )
    val coroutineScope = rememberCoroutineScope()
    var selectedItem by remember { mutableStateOf<ArticleUiEntity?>(null) }

    BackHandler(enabled = scaffoldState.bottomSheetState.isVisible) {
        coroutineScope.launch {
            scaffoldState.bottomSheetState.hide()
        }
    }
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            selectedItem?.let {
                ArticleDetailBottomSheet(article = it) {
                    scope.launch { scaffoldState.bottomSheetState.hide() }
                }
            }
        },
        sheetPeekHeight = 0.dp
    ) {
        when {
            isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CoinLoader()
                }
            }

            articles.isNotEmpty() -> {
                Column {
                    FilterChipRow(
                        filterOptions = filterOptions,
                        onFilterSelected = { period ->
                            filterOptions = filterOptions.map { option ->
                                option.copy(isSelected = option.period == period)
                            }
                            viewModel.dispatch(PopularArticlesEvent.FetchPopularArticles(period))
                        },
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ArticlesList(
                        articles = articles,
                    ) { item ->
                        selectedItem = item
                        coroutineScope.launch {
                            scaffoldState.bottomSheetState.expand()
                        }

                    }
                }
            }

            isEmptyState -> {
                EmptyStateUi()
            }

            isError -> {
                ErrorStateUi(
                    ctaButtonOnClick = {
                        filterOptions = filterOptions.map { option ->
                            option.copy(isSelected = option.period == 1)
                        }
                        viewModel.dispatch(
                            PopularArticlesEvent.FetchPopularArticles(
                                1
                            )
                        )
                    }
                )
            }
        }
    }
}

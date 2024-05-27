package com.gomaa.presentation.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gomaa.presentation.model.ArticleUiEntity
import com.gomaa.presentation.ui.components.ArticleDetailBottomSheet
import com.gomaa.presentation.ui.components.ArticlesList
import com.gomaa.presentation.ui.components.CoinLoader
import com.gomaa.presentation.ui.components.EmptyStateUi
import com.gomaa.presentation.ui.components.ErrorStateUi
import com.gomaa.presentation.ui.components.FilterChipRow
import com.gomaa.presentation.viewmodel.PopularArticlesEvent
import com.gomaa.presentation.viewmodel.PopularArticlesViewModel
import com.gomaa.utils.initializeFilterOptions
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularArticlesScreen(
    viewModel: PopularArticlesViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(true) {
        viewModel.dispatch(PopularArticlesEvent.FetchPopularArticles(1))
    }
    val articles = viewModel.uiState.collectAsState().value.articles
    val isLoading = viewModel.uiState.collectAsState().value.isLoading
    val isError = viewModel.uiState.collectAsState().value.isError
    val isEmptyState = viewModel.uiState.collectAsState().value.isEmptyResponse

    var filterOptions by remember { mutableStateOf(initializeFilterOptions()) }
    var selectedItem by remember { mutableStateOf<ArticleUiEntity?>(null) }
    var visibleState by remember { mutableStateOf(false) }

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            skipHiddenState = false
        )
    )
    BackHandler(enabled = scaffoldState.bottomSheetState.isVisible) {
        visibleState = false
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            AnimatedVisibility(
                visible = visibleState,
                enter = expandVertically(
                    animationSpec = spring(
                        stiffness =  Spring.StiffnessMediumLow,
                        visibilityThreshold = IntSize.VisibilityThreshold
                    )
                ),
                exit = shrinkVertically(
                    animationSpec = spring(
                        stiffness =  Spring.StiffnessMediumLow,
                        visibilityThreshold = IntSize.VisibilityThreshold
                    )
                )
            ) {
                selectedItem?.let {
                    ArticleDetailBottomSheet(article = it) {
                        visibleState = false
                    }
                }
            }
        },
        sheetDragHandle = {},
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
                        visibleState = true
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

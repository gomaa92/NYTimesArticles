package com.gomaa.utils

data class FilterOption(val title: Int, val period: Int, var isSelected: Boolean)

fun initializeFilterOptions(): List<FilterOption> {
    return listOf(
        FilterOption(title = R.string.last_day, period = 1, isSelected = true),
        FilterOption(title = R.string.last_week, period = 7, isSelected = false),
        FilterOption(title = R.string.last_month, period = 30, isSelected = false)
    )
}

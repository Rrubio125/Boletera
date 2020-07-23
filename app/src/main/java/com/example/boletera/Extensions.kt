package com.example.boletera

import android.content.Context
import android.graphics.Color

fun EventCategory.getNameForCategory(context: Context): String {
    return when (this.type) {
        EventCategoryType.WORKSHOP -> context.getString(R.string.taller)
        EventCategoryType.CULTURAL -> context.getString(R.string.cultural)
        EventCategoryType.CONFERENCE -> context.getString(R.string.conference)
        EventCategoryType.CONCERT -> context.getString(R.string.concert)
        EventCategoryType.FESTIVAL -> context.getString(R.string.festival)
        EventCategoryType.SPORTS -> context.getString(R.string.sport)
    }
}

fun EventCategory.getIconResourceForCategory(): Int {
    return when (this.type) {
        EventCategoryType.WORKSHOP -> R.drawable.ic_star
        EventCategoryType.CULTURAL -> R.drawable.ic_theaters
        EventCategoryType.CONFERENCE -> R.drawable.ic_mic
        EventCategoryType.CONCERT -> R.drawable.ic_music
        EventCategoryType.FESTIVAL -> R.drawable.ic_flower
        EventCategoryType.SPORTS -> R.drawable.ic_bike
    }
}

fun EventCategory.getColorForCategory(): Int {
    return when (this.type) {
        EventCategoryType.SPORTS,
        EventCategoryType.WORKSHOP -> R.color.colorOrange
        EventCategoryType.CULTURAL -> R.color.colorBoletera_btn
        EventCategoryType.CONFERENCE -> R.color.colorStar
        EventCategoryType.CONCERT -> R.color.colorPurple
        EventCategoryType.FESTIVAL -> R.color.colorYellow

    }
}
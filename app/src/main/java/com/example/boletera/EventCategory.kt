package com.example.boletera

data class EventCategory(val type: EventCategoryType)

enum class EventCategoryType {
    CULTURAL,
    SPORTS,
    FESTIVAL,
    CONFERENCE,
    WORKSHOP,
    CONCERT
}
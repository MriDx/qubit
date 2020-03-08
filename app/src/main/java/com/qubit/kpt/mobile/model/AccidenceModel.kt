package com.qubit.kpt.mobile.model
import com.qubit.kpt.mobile.common.Util
import java.util.*

object AccidenceModel {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<AccidenceItem> = ArrayList()

    /**
     * This value will be use to not trigger commutation with API
     */
    val MOCKED = Util.getProperty("app.create-mock")
        .toBoolean()

    private val COUNT = Util.getProperty("app.event_count")
        .toInt()

    init {
        if (MOCKED) {
            createMock()
        } else {
            // TODO: get data from API
            throw RuntimeException("The communication with backend isn't implemented")
        }
    }

    private fun createMock() {
        for (i in 1..COUNT) {
            addItem(createDummyAccidenceItem(i))
        }
    }

    private fun addItem(item: AccidenceItem) {
        ITEMS.add(item)
    }

    private fun createDummyAccidenceItem(position: Int): AccidenceItem {
        return AccidenceItem( "Address $position", makeComment(position),
            "Created at $position", "$position km")
    }

    private fun makeComment(position: Int): String {
        val buildingCount = COUNT - position
        return "Now $buildingCount building is on the fire \nPlease help"
    }

    /**
     * AccidenceItem
     * Model representing model of event extracted from API
     */
    data class AccidenceItem(val address: String, val comment: String,
                             val createdAt: String, val distance: String) {
        override fun toString(): String = "ADDRESS=$address COMMENT=$comment " +
                "CREATE_AT=$createdAt DISTANCE=$distance"
    }
}


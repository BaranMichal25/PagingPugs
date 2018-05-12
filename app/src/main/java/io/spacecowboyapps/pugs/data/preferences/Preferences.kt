package io.spacecowboyapps.pugs.data.preferences

interface Preferences {

    fun getLastUpdate(): Long

    fun putLastUpdate(timestamp: Long)
}
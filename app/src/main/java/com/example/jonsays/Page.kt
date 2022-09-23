package com.example.jonsays

import androidx.room.*

@Entity(tableName = "pages")
data class Page(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var title: String,
    var image: String,
    var favorite: Boolean = false,

    var btn1: String,
    var btn2: String,
    var btn3: String,
    var btn4: String,
    var btn5: String,
    var btn6: String,
    var btn7: String,
    var btn8: String,
    var btn9: String,
    var btn10: String,

    var sound1: String,
    var sound2: String,
    var sound3: String,
    var sound4: String,
    var sound5: String,
    var sound6: String,
    var sound7: String,
    var sound8: String,
    var sound9: String,
    var sound10: String,
) {
}

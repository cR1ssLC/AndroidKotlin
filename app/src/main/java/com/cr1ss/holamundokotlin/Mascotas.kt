package com.cr1ss.holamundokotlin

import com.cr1ss.holamundokotlin.R

data class Mascotas(
    val id: Int,
    val name: String,
    val age: Double,
    val photo: Int,
) {
    companion object {
        val fakeMascotas = listOf(
            Mascotas(1, "Box", 13.0, R.drawable.dog_1),
            Mascotas(2, "Lorem ipsum lorem ipsum lorem ipsum", 19.0, R.drawable.dog_2),
            Mascotas(3, "Kitty", 3.5, R.drawable.dog_3),
            Mascotas(4, "George", 2.0, R.drawable.dog_4),
            Mascotas(5, "Choco", 10.5, R.drawable.dog_5),
            Mascotas(6, "Negro", 2.0, R.drawable.dog_1),
            Mascotas(3, "Kitty", 3.5, R.drawable.dog_3),
            Mascotas(4, "George", 2.0, R.drawable.dog_4),
            Mascotas(3, "Kitty", 3.5, R.drawable.dog_3),
            Mascotas(4, "George", 2.0, R.drawable.dog_4),
            Mascotas(3, "Kitty", 3.5, R.drawable.dog_3),
            Mascotas(4, "George", 2.0, R.drawable.dog_4),
        )
    }
}
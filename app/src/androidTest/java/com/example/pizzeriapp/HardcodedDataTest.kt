package com.example.pizzeriapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pizzeriapp.Hardcoded.Pizza
import com.example.pizzeriapp.Hardcoded.Rolls
import com.example.pizzeriapp.Hardcoded.Sets
import com.example.pizzeriapp.Hardcoded.Another
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HardcodedDataTest {

    @Test
    fun rollsListHasCorrectSize() {
        assertEquals(3, Rolls.size)
    }

    @Test
    fun pizzaListHasCorrectTitles() {
        val titles = Pizza.map { it.title }
        assertTrue(titles.contains("Делюкс"))
        assertTrue(titles.contains("Буффало"))
    }

    @Test
    fun allItemsHavePositivePrice() {
        val all = Rolls + Pizza + Sets + Another
        assertTrue(all.all { it.price > 0 })
    }

    @Test
    fun sushiCategoryItemsAreCorrect() {
        assertTrue(Rolls.all { it.category == "Суші" })
    }
}

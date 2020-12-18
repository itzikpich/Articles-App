package com.itzikpichhadze.zemingoapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
        val m = mutableMapOf<Int, Int>()
        m[1] = 2
        m[3] to 4
        println(m.keys)

    }
}
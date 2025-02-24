package ca.uwaterloo.cs446.dp.singleton

import org.junit.Test
import org.junit.Assert.*

class SingletonTests {
    @Test
    fun test_SingletonKotlin() {
        val s1 = SingletonKotlin
        val s2 = SingletonKotlin
        assertTrue(s1 == s2)
    }

    @Test
    fun test_SingletonTraditional() {
        val s1 = SingletonTraditional.getInstance()
        val s2 = SingletonTraditional.getInstance()
        assertTrue(s1 == s2)
    }

    @Test
    fun test_SingletonTraditionalThreadsafe() {
        val s1 = SingletonTraditionalThreadsafe.getInstance()
        val s2 = SingletonTraditionalThreadsafe.getInstance()
        assertTrue(s1 == s2)
    }
}
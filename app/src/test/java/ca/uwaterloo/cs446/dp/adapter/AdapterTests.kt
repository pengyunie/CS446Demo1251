package ca.uwaterloo.cs446.dp.adapter

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class AdapterTests {
    private val outContent = ByteArrayOutputStream()
    private val originalOut: PrintStream = System.out

    @Before
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
    }

    @After
    fun restoreStreams() {
        System.setOut(originalOut)
    }

    @Test
    fun testDrawLine() {
        val line = Line()
        val lineShape: Shape = LineAdapter(line)
        lineShape.draw(7, 23, 37, 70)
        assertEquals("Line from point A(7;23), to point B(37;70)", outContent.toString().trim())
    }

    @Test
    fun testDrawRectangle() {
        val rectangle = Rectangle()
        val rectangleShape: Shape = RectangleAdapter(rectangle)
        rectangleShape.draw(7, 23, 37, 70)
        assertEquals(
            "Rectangle with coordinate left-down point (7;23), width: 30, height: 47",
            outContent.toString().trim()
        )
    }

    @Test
    fun testDrawCircle() {
        val circle = Circle()
        val circleShape: Shape = CircleAdapter(circle)
        circleShape.draw(7, 23, 37, 70)
        assertEquals(
            "Circle with centre at (22;46), with a radius of 15", outContent.toString().trim()
        )
    }
}
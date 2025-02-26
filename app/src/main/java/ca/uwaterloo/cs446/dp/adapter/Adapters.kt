package ca.uwaterloo.cs446.dp.adapter

import kotlin.math.abs
import kotlin.math.min

// the target interface
interface Shape {
    fun draw(x1: Int, y1: Int, x2: Int, y2: Int)
}


// the adapters
class LineAdapter(line: Line) : Shape {
    private val adaptee = line

    override fun draw(x1: Int, y1: Int, x2: Int, y2: Int) {
        adaptee.draw(x1, y1, x2, y2)
    }
}

class RectangleAdapter(rectangle: Rectangle) : Shape {
    private val adaptee = rectangle

    override fun draw(x1: Int, y1: Int, x2: Int, y2: Int) {
        val x = min(x1.toDouble(), x2.toDouble()).toInt()
        val y = min(y1.toDouble(), y2.toDouble()).toInt()
        val width = abs((x2 - x1).toDouble()).toInt()
        val height = abs((y2 - y1).toDouble()).toInt()

        adaptee.draw(x, y, width, height)
    }
}

class CircleAdapter(circle: Circle) : Shape {
    private val adaptee = circle

    override fun draw(x1: Int, y1: Int, x2: Int, y2: Int) {
        val xc = (x1 + x2) / 2
        val yc = (y1 + y2) / 2
        val radius = min((xc - x1).toDouble(), (yc - y1).toDouble()).toInt()
        adaptee.draw(xc, yc, radius)
    }
}

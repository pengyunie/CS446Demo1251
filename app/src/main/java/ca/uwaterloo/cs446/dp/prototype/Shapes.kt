package ca.uwaterloo.cs446.dp.prototype

// the Prototype interface
interface Shape : Cloneable {
    public override fun clone(): Shape
    fun draw()
    fun changeColor(color: String)
}

// concrete Prototype classes
class Circle(var radius: Double, var x: Double, var y: Double, var color: String) : Shape {
    override fun clone(): Shape {
        return Circle(radius, x, y, color)
    }

    override fun draw() {
        println("Drawing a $color circle at ($x, $y) with r=$radius")
    }

    override fun changeColor(color: String) {
        this.color = color
    }
}

class Line(var x1: Double, var y1: Double, var x2: Double, var y2: Double, var color: String) :
    Shape {
    override fun clone(): Shape {
        return Line(x1, y1, x2, y2, color)
    }

    override fun draw() {
        println("Drawing a $color line from ($x1, $y1) to ($x2, $y2)")
    }

    override fun changeColor(color: String) {
        this.color = color
    }
}

class CompositeShape(var shapes: MutableList<Shape> = mutableListOf()) : Shape {
    // + Composite pattern

    override fun clone(): Shape {
        val clonedShapes: MutableList<Shape> = mutableListOf()
        for (shape in shapes) {
            clonedShapes.add(shape.clone())
        }
        return CompositeShape(clonedShapes)
    }

    override fun draw() {
        println("Drawing a composite shape...")
        for (shape in shapes) {
            shape.draw()
        }
        println("...end of composite shape")
    }

    override fun changeColor(color: String) {
        for (shape in shapes) {
            shape.changeColor(color)
        }
    }
}

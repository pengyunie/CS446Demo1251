package ca.uwaterloo.cs446.dp.adapter


// client code, using the shapes through adapters
fun main() {
    // Old objects
    val line = Line()
    val rectangle = Rectangle()
    val circle = Circle()

    // Adapt them with adapters
    val shapes: MutableList<Shape> = ArrayList()
    shapes.add(LineAdapter(line))
    shapes.add(RectangleAdapter(rectangle))
    shapes.add(CircleAdapter(circle))

    // Code can now operate using common interface
    val x1 = 7
    val y1 = 23
    val x2 = 37
    val y2 = 70
    for (shape in shapes) {
        shape.draw(x1, y1, x2, y2)
    }
}

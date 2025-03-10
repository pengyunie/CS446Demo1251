package ca.uwaterloo.cs446.dp.prototype

object ShapeRegistry { // + Singleton pattern
    private val shapes = mutableMapOf<String, Shape>()

    fun addShape(key: String, shape: Shape) {
        shapes[key] = shape
    }

    fun getShape(key: String): Shape? {
        return shapes[key]?.clone()
    }

    // initialize the registry with some common prototypes
    init {
        addShape("UnitCircle", Circle(1.0, 0.0, 0.0, "black"))
        addShape(
            "CircledPlus", CompositeShape(
                mutableListOf(
                    Circle(1.0, 0.0, 0.0, "black"),
                    Line(-1.0, 0.0, 1.0, 0.0, "black"),
                    Line(0.0, -1.0, 0.0, 1.0, "black")
                )
            )
        )
    }
}
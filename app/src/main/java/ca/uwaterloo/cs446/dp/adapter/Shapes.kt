package ca.uwaterloo.cs446.dp.adapter

// the adaptees
// consider these classes are defined in other components or third-party libraries and cannot be modified

class Line {
    fun draw(x1: Int, y1: Int, x2: Int, y2: Int) {
        println("Line from point A($x1;$y1), to point B($x2;$y2)")
    }
}

class Rectangle {
    fun draw(x: Int, y: Int, width: Int, height: Int) {
        println(
            "Rectangle with coordinate left-down point ($x;$y), width: $width, height: $height"
        )
    }
}

class Circle {
    fun draw(x: Int, y: Int, radius: Int) {
        println("Circle with centre at ($x;$y), with a radius of $radius")
    }
}

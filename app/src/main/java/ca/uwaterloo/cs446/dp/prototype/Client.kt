package ca.uwaterloo.cs446.dp.prototype

fun main() {
    // get a prototype from the registry
    var myCircledPlus = ShapeRegistry.getShape("CircledPlus")!!
    myCircledPlus.changeColor("red")
    myCircledPlus.draw()

    // it shouldn't affect the prototype in the registry
    ShapeRegistry.getShape("CircledPlus")!!.draw()
}
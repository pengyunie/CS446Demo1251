package ca.uwaterloo.cs446.dp.abstractfactory

interface Checkbox {
    fun render()
    fun onClick(f: () -> Unit) {
        f()
    }
}

class AndroidCheckbox : Checkbox {
    override fun render() {
        println("Rendering an Android style checkbox")
    }
}

class WindowsCheckbox : Checkbox {
    override fun render() {
        println("Rendering a Windows style checkbox")
    }
}
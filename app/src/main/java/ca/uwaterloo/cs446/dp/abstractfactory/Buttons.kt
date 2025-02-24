package ca.uwaterloo.cs446.dp.abstractfactory

interface Button {
    fun render()
    fun onClick(f: () -> Unit) {
        f()
    }
}

class AndroidButton : Button {
    override fun render() {
        println("Rendering an Android style button")
    }
}

class WindowsButton : Button {
    override fun render() {
        println("Rendering a Windows style button")
    }
}
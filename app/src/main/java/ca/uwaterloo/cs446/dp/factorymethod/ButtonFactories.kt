package ca.uwaterloo.cs446.dp.factorymethod

abstract class ButtonFactory {
    abstract fun createButton(): Button
}

class AndroidButtonFactory : ButtonFactory() {
    override fun createButton() = AndroidButton()
}

class WindowsButtonFactory : ButtonFactory() {
    override fun createButton() = WindowsButton()
}

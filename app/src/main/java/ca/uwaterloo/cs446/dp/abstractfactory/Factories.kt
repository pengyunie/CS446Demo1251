package ca.uwaterloo.cs446.dp.abstractfactory

abstract class AbstractFactory {
    abstract fun createButton(): Button
    abstract fun createCheckbox(): Checkbox
}

class AndroidFactory : AbstractFactory() {
    override fun createButton() = AndroidButton()
    override fun createCheckbox() = AndroidCheckbox()
}

class WindowsFactory : AbstractFactory() {
    override fun createButton() = WindowsButton()
    override fun createCheckbox() = WindowsCheckbox()
}

package ca.uwaterloo.cs446.dp.abstractfactory

// simulating some client code using factory
@Suppress("UNREACHABLE_CODE")
fun application() {
    val config = TODO("readApplicationConfigFile")
    val factory = when (config) {
        "Android" -> AndroidFactory()
        "Windows" -> WindowsFactory()
        else -> throw IllegalStateException()
    }
    val form = Form(factory)
    form.render()
    val dialog = Dialog(factory)
    dialog.render()
    // ... others can use the buttonFactory as well
}

class Dialog(factory: AbstractFactory) {
    private val okButton: Button = factory.createButton()

    init {
        okButton.onClick { close() }
    }

    fun close() {}
    fun render() {
        okButton.render()
    }
}

class Form(factory: AbstractFactory) {
    private val submitButton: Button = factory.createButton()
    private val option1: Checkbox = factory.createCheckbox()
    private val option2: Checkbox = factory.createCheckbox()

    fun render() {
        submitButton.render()
        option1.render()
        option2.render()
    }
}

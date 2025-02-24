package ca.uwaterloo.cs446.dp.factorymethod

// simulating some client code using factory
@Suppress("UNREACHABLE_CODE")
fun application() {
    val config = TODO("readApplicationConfigFile")
    val buttonFactory = when (config) {
        "Android" -> AndroidButtonFactory()
        "Windows" -> WindowsButtonFactory()
        else -> throw IllegalStateException()
    }
    val dialog = Dialog(buttonFactory)
    dialog.render()
    // ... others can use the buttonFactory as well
}

class Dialog(buttonFactory: ButtonFactory) {
    private val okButton: Button = buttonFactory.createButton()

    init {
        okButton.onClick { close() }
    }

    fun close() {}
    fun render() {
        okButton.render()
    }
}

package ca.uwaterloo.cs446.dp.observer

class OctObserver : NumberObserver {
    private var octValue: String = "NaN"

    override fun update(context: NumberSubject) {
        octValue = context.getState().toString(8)
    }

    override fun getValue(): String = octValue
}

class HexObserver : NumberObserver {
    private var hexValue: String = "NaN"

    override fun update(context: NumberSubject) {
        hexValue = context.getState().toString(16)
    }

    override fun getValue(): String = hexValue
}

class BinObserver : NumberObserver {
    private var binValue: String = "NaN"

    override fun update(context: NumberSubject) {
        binValue = context.getState().toString(2)
    }

    override fun getValue(): String = binValue
}

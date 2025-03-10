package ca.uwaterloo.cs446.dp.memento

// the Originator
class TextBuffer {
    // state
    var text: String = ""
        private set  // can read from outside of the class, but cannot write

    var cursorPosition: Int = 0
        private set

    // the Memento
    data class Memento(val text: String, val cursorPosition: Int)

    fun save(): Memento {
        println("save [cursor@$cursorPosition, text=$text]")
        return Memento(text, cursorPosition)
    }

    fun restore(memento: Memento) {
        text = memento.text
        cursorPosition = memento.cursorPosition
        println("restore [cursor@$cursorPosition, text=$text]")
    }

    // other operations
    fun insert(chars: String) {
        text = text.substring(0, cursorPosition) + chars + text.substring(cursorPosition)
        cursorPosition += chars.length
        println("insert [cursor@$cursorPosition, text=$text]")
    }

    fun delete() {
        if (cursorPosition > 0) {
            text = text.substring(0, cursorPosition - 1) + text.substring(cursorPosition)
            cursorPosition--
        }
        println("delete [cursor@$cursorPosition, text=$text]")
    }

    fun moveTo(position: Int) {
        cursorPosition = position.coerceIn(0, text.length)
        println("move [cursor@$cursorPosition]")
    }
}
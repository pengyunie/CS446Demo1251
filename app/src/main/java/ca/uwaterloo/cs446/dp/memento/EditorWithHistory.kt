package ca.uwaterloo.cs446.dp.memento

// the Client
class EditorWithHistory {
    private val textBuffer = TextBuffer()
    private val history = TextBufferHistory(textBuffer)

    fun insert(chars: String) {
        textBuffer.insert(chars)
        history.save()
    }

    fun delete() {
        textBuffer.delete()
        history.save()
    }

    fun moveTo(position: Int) {
        textBuffer.moveTo(position)
    }

    fun undo() {
        history.undo()
    }

    fun redo() {
        history.redo()
    }
}

fun main() {
    val editor = EditorWithHistory()
    editor.insert("Hello, world!")
    editor.moveTo(12)
    for (i in 1..5) {
        editor.delete()
    }
    editor.undo()

    editor.insert("Kotlin")
    editor.redo()

    editor.undo()
    editor.redo()
}

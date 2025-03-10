package ca.uwaterloo.cs446.dp.memento

// the Caretaker
class TextBufferHistory(private val textBuffer: TextBuffer) {
    private val mementos = mutableListOf<TextBuffer.Memento>()
    private var currentIndex = -1

    fun undo(): Boolean {
        if (currentIndex <= 0) {
            println("Cannot undo")
            return false
        }

        currentIndex--
        textBuffer.restore(mementos[currentIndex])
        return true
    }

    fun redo(): Boolean {
        if (currentIndex >= mementos.size - 1) {
            println("Cannot redo")
            return false
        }

        currentIndex++
        textBuffer.restore(mementos[currentIndex])
        return true
    }

    fun save() {
        // when saving a new state, invalidate any future snapshots
        while (currentIndex < mementos.size - 1) {
            mementos.removeAt(mementos.lastIndex)
        }

        mementos.add(textBuffer.save())
        currentIndex = mementos.size - 1
    }
}
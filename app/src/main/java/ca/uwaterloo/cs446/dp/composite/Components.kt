package ca.uwaterloo.cs446.dp.composite

// the component interface
interface IFile {
    fun getName(): String
    fun ls(): List<String>
}

// leaf
open class File(private val name: String) : IFile {
    override fun getName() = name
    override fun ls() = listOf(name)
}

class HiddenFile(private val name: String) : File(name) {
    override fun ls(): List<String> = emptyList()
}


// composite
class Directory(private val name: String) : IFile {
    private val children: MutableList<IFile> = ArrayList()

    fun add(child: IFile) {
        children.add(child)
    }

    override fun getName() = name

    override fun ls(): List<String> {
        val result = ArrayList<String>()

        result.add(getName())

        for (child in children) {
            result.addAll(child.ls())
        }

        return result
    }
}

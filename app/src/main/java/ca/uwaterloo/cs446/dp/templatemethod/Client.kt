package ca.uwaterloo.cs446.dp.templatemethod

fun main() {
    val compilers = arrayOf(
        AndroidCompiler(),
        IPhoneCompiler(),
    )

    for (compiler in compilers) {
        compiler.compile()
    }
}
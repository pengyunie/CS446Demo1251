package ca.uwaterloo.cs446.dp.templatemethod

// The common interface of the application
abstract class CrossCompiler {
    fun compile() {
        scanSources()
        fetchDependencies()
        compileToTarget()
    }

    protected fun scanSources() {
        println("Scanning source files...")
    }

    protected abstract fun fetchDependencies()
    protected abstract fun compileToTarget()
}

// The concrete applications
class AndroidCompiler : CrossCompiler() {
    override fun fetchDependencies() {
        println("Fetching dependencies for Android...")
    }

    override fun compileToTarget() {
        println("Compiling to target: Android SDK 35")
    }
}

class IPhoneCompiler : CrossCompiler() {
    override fun fetchDependencies() {
        println("Fetching dependencies for iOS")
    }

    override fun compileToTarget() {
        println("Compiling to target: iOS 18")
    }
}


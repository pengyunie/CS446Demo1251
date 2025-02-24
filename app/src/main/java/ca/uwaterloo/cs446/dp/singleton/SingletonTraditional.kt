package ca.uwaterloo.cs446.dp.singleton

class SingletonTraditional private constructor() {
    companion object {
        private var instance: SingletonTraditional? = null
        fun getInstance(): SingletonTraditional {
            if (instance == null) { instance = SingletonTraditional() }
            return instance!!
        }
    }
}
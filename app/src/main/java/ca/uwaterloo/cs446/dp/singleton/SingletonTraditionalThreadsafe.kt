package ca.uwaterloo.cs446.dp.singleton

class SingletonTraditionalThreadsafe private constructor() {
    companion object {
        @Volatile
        private var instance: SingletonTraditionalThreadsafe? = null
        fun getInstance(): SingletonTraditionalThreadsafe =
            instance ?: synchronized(this) {
                instance ?: SingletonTraditionalThreadsafe().also { instance = it }
            }
    }
}
package ca.uwaterloo.cs446.dp.observer

interface NumberObserver {
    // common interface for observer
    fun update(context: NumberSubject)

    // specific interface for this demo
    fun getValue(): String
}
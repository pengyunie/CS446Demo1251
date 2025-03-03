package ca.uwaterloo.cs446.dp.observer

class NumberSubject {
    // common interface for Subject
    private val observers: MutableList<NumberObserver> = ArrayList()

    fun attach(observer: NumberObserver) {
        observers.add(observer)
    }

    fun detach(observer: NumberObserver) {
        observers.remove(observer)
    }

    fun notifyObservers() {
        for (observer in observers) {
            observer.update(this)
        }
    }

    // specific business logic for this demo
    private var state: Int = 0
    fun getState(): Int = state
    fun setState(state: Int) {
        this.state = state
        notifyObservers()
    }
}
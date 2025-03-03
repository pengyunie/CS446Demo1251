package ca.uwaterloo.cs446.dp.observer

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*


class ObserverTests {
    private var sub: NumberSubject? = null

    @Before
    fun setup() {
        sub = NumberSubject()
    }

    @Test
    fun testOctObserver() {
        val observer = OctObserver()
        sub!!.attach(observer)

        sub!!.setState(8)
        assertEquals("10", observer.getValue())

        sub!!.setState(10)
        assertEquals("12", observer.getValue())
    }

    @Test
    fun testHexObserver() {
        val observer = HexObserver()
        sub!!.attach(observer)

        sub!!.setState(8)
        assertEquals("8", observer.getValue())

        sub!!.setState(10)
        assertEquals("a", observer.getValue())
    }

    @Test
    fun testBinObserver() {
        val observer = BinObserver()
        sub!!.attach(observer)

        sub!!.setState(8)
        assertEquals("1000", observer.getValue())

        sub!!.setState(10)
        assertEquals("1010", observer.getValue())
    }

    @Test
    fun testMultipleObservers() {
        val octObserver = OctObserver()
        val hexObserver = HexObserver()
        val binObserver = BinObserver()

        for (observer in arrayOf(octObserver, hexObserver, binObserver)) {
            sub!!.attach(observer)
        }

        sub!!.setState(8)
        assertEquals("10", octObserver.getValue())
        assertEquals("8", hexObserver.getValue())
        assertEquals("1000", binObserver.getValue())

        sub!!.setState(10)
        assertEquals("12", octObserver.getValue())
        assertEquals("a", hexObserver.getValue())
        assertEquals("1010", binObserver.getValue())
    }
}
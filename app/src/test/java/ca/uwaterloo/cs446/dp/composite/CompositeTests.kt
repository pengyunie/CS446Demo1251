package ca.uwaterloo.cs446.dp.composite

import org.junit.Test
import org.junit.Assert.*

class CompositeTests {
    @Test
    fun testLsDirectoryEmpty() {
        val photos = Directory("PHOTOS")
        assertEquals(listOf("PHOTOS"), photos.ls())
    }

    @Test
    fun testLsDirectoryNonEmpty() {
        val photos = Directory("PHOTOS")
        val shanghai = Directory("SHANGHAI")
        val kyoto = Directory("KYOTO")
        val opt = File("Oriental Pearl Tower")
        val bund = File("The Bund")
        val kiyomizu = File("Kiyomizu Dera")

        shanghai.add(opt)
        shanghai.add(bund)
        kyoto.add(kiyomizu)

        photos.add(shanghai)
        photos.add(kyoto)

        assertEquals(
            listOf(
                "PHOTOS",
                "SHANGHAI",
                "Oriental Pearl Tower",
                "The Bund",
                "KYOTO",
                "Kiyomizu Dera"
            ), photos.ls()
        )
    }

    @Test
    fun testLsFile() {
        val file = File("Important Document")
        assertEquals(listOf("Important Document"), file.ls())
    }

    @Test
    fun testLsHiddenFile() {
        val file = HiddenFile("Hidden Document")
        assertEquals(emptyList<String>(), file.ls())
    }

    @Test
    fun testLsHiddenFileInDirectory() {
        val dir = Directory("DIR")
        val file = File("Visible")
        val hFile = HiddenFile("Invisible")

        dir.add(file)
        dir.add(hFile)

        assertEquals(listOf("DIR", "Visible"), dir.ls())
    }
}
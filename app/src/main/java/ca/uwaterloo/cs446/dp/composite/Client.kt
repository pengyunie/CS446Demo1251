package ca.uwaterloo.cs446.dp.composite


fun main() {
    val photos = Directory("PHOTOS")
    val shanghai = Directory("SHANGHAI")
    val kyoto = Directory("KYOTO")
    val opt = File("Oriental Pearl Tower")
    val bund = File("The Bund")
    val kiyomizu = File("Kiyomizu Dera")
    val hidden: File = HiddenFile("Secret")

    shanghai.add(opt)
    shanghai.add(bund)
    kyoto.add(kiyomizu)
    kyoto.add(hidden)

    photos.add(shanghai)
    photos.add(kyoto)

    // List of components
    val components: MutableList<IFile> = ArrayList()

    components.add(photos)
    components.add(opt)
    components.add(hidden)

    // Client code can treat components the same
    for (component in components) {
        println("> ls " + component.getName())
        component.ls().forEach(::println)
        println()
    }
}

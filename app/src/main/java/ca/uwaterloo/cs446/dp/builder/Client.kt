package ca.uwaterloo.cs446.dp.builder

fun main() {
    val planA = TravelPlan.Builder()
        .setDestination("San Francisco")
        .setDuration(3)
        .setTransportationDeparture("UA2462")
        .setTransportationReturn("AC4067")
        .setHotel("5-Star Resort")
        .addActivity(1, "City Tour")
        .addActivity(2, "Visit Yosemite")
        .addActivity(1, "Meet friend A at Google")
        .addActivity(3, "Meet friend B at Meta")
        .build()

    println(planA)

    val planB = TravelPlan.Builder()
        .setDestination("Toronto")
        .setDuration(1)
        .addActivity("Visit CN Tower")
        .addActivity("Visit Art Gallery of Ontario")
        .build()

    println(planB)
}
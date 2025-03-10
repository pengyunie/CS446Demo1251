package ca.uwaterloo.cs446.dp.builder

class TravelPlan private constructor(
    val destination: String,
    val durationDays: Int,
    val hotel: String?,
    val transportations: Pair<String?, String?>,
    val activities: List<List<String>>,
) {
    // Builder class
    class Builder {
        private var destination: String? = null
        private var durationDays: Int = -1
        private var hotel: String? = null
        private var transportationDeparture: String? = null
        private var transportationReturn: String? = null
        private var activities: MutableList<MutableList<String>>? = null

        fun setDestination(destination: String) = apply { this.destination = destination }
        // Equivalent to:
        // fun setDestination(destination: String): Builder {
        //     this.destination = destination
        //     return this
        // }

        fun setDuration(days: Int) = apply {
            require(days > 0) {
                "Duration must be a positive number of days"
            }
            durationDays = days
            activities = ArrayList()
            for (i in 1..days) {
                activities!!.add(ArrayList())
            }
        }

        fun setHotel(hotel: String) = apply { this.hotel = hotel }

        fun setTransportationDeparture(transportation: String) =
            apply { transportationDeparture = transportation }

        fun setTransportationReturn(transportation: String) =
            apply { transportationReturn = transportation }

        fun addActivity(day: Int, activity: String) =
            apply { activities?.get(day - 1)?.add(activity) }

        fun addActivity(activity: String) = addActivity(1, activity)

        fun build(): TravelPlan {
            require(destination != null) {
                "Destination must be set"
            }
            require(durationDays > 0) {
                "Duration must be a positive number of days"
            }
            return TravelPlan(
                destination!!,
                durationDays,
                hotel,
                Pair(transportationDeparture, transportationReturn),
                activities!!.toList()
            )
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Travel plan to $destination, $durationDays days\n")
        hotel?.let { sb.append("- Hotel: $it\n") }
        transportations.first?.let { sb.append("- Departure: $it\n") }
        transportations.second?.let { sb.append("- Return: $it\n") }
        for (i in 1..durationDays) {
            sb.append("- Day $i\n")
            val dayActivities = activities[i - 1]
            for (activity in dayActivities) {
                sb.append("  - $activity\n")
            }
        }
        return sb.toString()
    }
}
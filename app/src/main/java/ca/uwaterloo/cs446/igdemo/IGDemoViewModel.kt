package ca.uwaterloo.cs446.igdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.executeAsync

// ViewModel

// Data class representing all UI states
data class IGDemoUiState(
    val clickedDogImage: String? = null,  // Currently selected image
    val dogImages: List<String> = emptyList(),  // List of dog image URLs
)

class IGDemoViewModel : ViewModel() {
    // Private mutable state flow (single source of truth)
    private val _uiState = MutableStateFlow(IGDemoUiState())

    // Public immutable state exposure
    val uiState: StateFlow<IGDemoUiState> = _uiState.asStateFlow()

    init {
        // Fetch data upon launch of the ViewModel (in a separate thread)
        viewModelScope.launch {
            // Update state with new dog images
            _uiState.update { currentState ->
                currentState.copy(dogImages = fetchDogImages())
            }
        }
    }

    // State update method for click events
    fun updateClickedDogImage(clickedDogImage: String?) {
        _uiState.update { currentState ->
            currentState.copy(clickedDogImage = clickedDogImage)
        }
    }
}

// Model

suspend fun fetchDogImages(): List<String> = withContext(Dispatchers.IO) {
    val request = okhttp3.Request(
        url = "https://dog.ceo/api/breeds/image/random/10".toHttpUrl()
    )
    val response = OkHttpClient().newCall(request).executeAsync()

    val json = response.body.string()
    val responseBody = Json.decodeFromString<DogCeoResponseBody>(json)
    return@withContext responseBody.message
}

@Serializable
data class DogCeoResponseBody(
    val message: List<String>,
    val status: String,
)

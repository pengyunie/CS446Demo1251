package ca.uwaterloo.cs446.igdemo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import kotlin.concurrent.thread

// ViewModel

data class IGDemoUiState(
    val clickedDogImage: String? = null,
    val dogImages: List<String> = emptyList(),
)

class IGDemoViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(IGDemoUiState())
    val uiState: StateFlow<IGDemoUiState> = _uiState.asStateFlow()

    init {
        thread {
            _uiState.update { currentState ->
                currentState.copy(dogImages = fetchDogImages())
            }
        }
    }

    fun updateClickedDogImage(clickedDogImage: String?) {
        _uiState.update { currentState ->
            currentState.copy(clickedDogImage = clickedDogImage)
        }
    }
}

// Model

fun fetchDogImages(): List<String> {
    val request = okhttp3.Request(
        url = "https://dog.ceo/api/breeds/image/random/10".toHttpUrl()
    )
    val response = OkHttpClient().newCall(request).execute()

    val json = response.body.string()
    val responseBody = Json.decodeFromString<DogCeoResponseBody>(json)
    return responseBody.message
}

@Serializable
data class DogCeoResponseBody(
    val message: List<String>,
    val status: String,
)

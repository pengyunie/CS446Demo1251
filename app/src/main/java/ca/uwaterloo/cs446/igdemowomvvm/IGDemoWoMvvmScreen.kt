package ca.uwaterloo.cs446.igdemowomvvm

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.uwaterloo.cs446.ui.theme.CS446Demo1251Theme
import ca.uwaterloo.cs446.ui.theme.InstagramOrange
import ca.uwaterloo.cs446.ui.theme.InstagramPeach
import ca.uwaterloo.cs446.ui.theme.InstagramPurple
import coil.compose.AsyncImage
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import kotlin.concurrent.thread


@Composable
fun IGDemoWoMvvmScreen() {
    // State management for tracking clicked dog image
    //   remember - the variable's lifecycle now is the same as the Composable
    //              meaning that its value won't be erased due to recomposition
    //   remember with mutableStateOf - the change to the value also triggers recomposition
    //   you can change to rememberSaveable so that it survives configuration changes as well,
    //       but MVVM is recommended for Views with multiple/complex state variables (like this one)
    val clickedDogImage = remember { mutableStateOf<String?>(null) }
    // List to hold dog images (initialized as empty)
    var dogImages: List<String> = emptyList()
    thread {
        dogImages = fetchDogImages()
    }.join()  // This blocks the main thread - not recommended in real apps

    // Main screen layout container
    Scaffold(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) { innerPadding ->
        // Vertical layout container
        Column(Modifier.padding(innerPadding)) {
            // Screen title
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Instagram",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            // Horizontal scrollable row for stories
            Row(
                Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                // Loop through dog images to create story avatars
                for (dogImage in dogImages) {
                    StoryAvatar(imageUrl = dogImage, onClick = {
                        clickedDogImage.value = dogImage
                    })
                }
            }
        }

        // Fullscreen overlay when an image is clicked
        if (clickedDogImage.value != null) {
            FullScreenStory(imageUrl = clickedDogImage.value!!, onClick = {
                clickedDogImage.value = null
            })
        }
    }
}

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

@Composable
fun FullScreenStory(imageUrl: String, onClick: () -> Unit) {
    AsyncImage(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onClick() },
        model = imageUrl,
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Preview(showBackground = true)
@Composable
fun FullScreenStoryPreview() {
    CS446Demo1251Theme {
        FullScreenStory("unusedInPreview", {})
    }
}

@Composable
fun StoryAvatar(imageUrl: String, onClick: () -> Unit) {
    Box(Modifier
        .padding(end = 8.dp)
        .border(
            width = 2.dp, brush = Brush.verticalGradient(
                listOf(
                    Color.InstagramOrange, Color.InstagramPeach, Color.InstagramPurple
                )
            ), shape = CircleShape
        )
        .padding(6.dp)
        .size(60.dp)
        .clip(CircleShape)
        .background(Color.LightGray)
        .clickable { onClick() }) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StoryAvatarPreview() {
    CS446Demo1251Theme {
        StoryAvatar("unusedInPreview", {})
    }
}

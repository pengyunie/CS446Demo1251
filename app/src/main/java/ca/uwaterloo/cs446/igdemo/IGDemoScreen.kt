package ca.uwaterloo.cs446.igdemo

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.uwaterloo.cs446.ui.theme.CS446Demo1251Theme
import ca.uwaterloo.cs446.ui.theme.InstagramOrange
import ca.uwaterloo.cs446.ui.theme.InstagramPeach
import ca.uwaterloo.cs446.ui.theme.InstagramPurple
import coil.compose.AsyncImage


@Composable
fun IGDemoScreen(
    viewModel: IGDemoViewModel = viewModel()
) {
    // Get UI state from the ViewModel
    // This state survives recomposition and recreation (e.g., screen rotation) of the Composable
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

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
                for (dogImage in uiState.dogImages) {
                    StoryAvatar(imageUrl = dogImage, onClick = {
                        viewModel.updateClickedDogImage(dogImage)
                    })
                }
            }
        }

        // Fullscreen overlay when an image is clicked
        if (uiState.clickedDogImage != null) {
            FullScreenStory(imageUrl = uiState.clickedDogImage!!, onClick = {
                viewModel.updateClickedDogImage(null)
            })
        }
    }
}

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

package com.example.glassmorphicbutton

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.glassmorphicbutton.ui.theme.GlassmorphicButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlassmorphicButtonTheme {

                GlassmorphismButton("Hello")

            }
        }
    }
}

@Composable
fun GlassmorphismButton(text: String) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .blur(1.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { /* Handle click */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White.copy(alpha = 0.15f) // Semi-transparent background
            ),
            border = BorderStroke(1.dp, Color.White.copy(alpha = 0.3f)), // Light border
            modifier = Modifier
                // ⚠️ This part requires a custom/library solution for a *background* blur
                // Modifier.blur() only blurs the content of the composable itself.
                // You'd use a custom modifier or a library like Haze here.
                .clip(RoundedCornerShape(12.dp))
                .shadow(4.dp) // Subtle shadow for depth

        ) {
            Text(text = text, color = Color.Red)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GlassmorphicButtonTheme {
        GlassmorphismButton("Hello")
    }
}
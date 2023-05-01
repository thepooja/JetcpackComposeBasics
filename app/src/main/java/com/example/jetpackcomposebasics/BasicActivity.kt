package com.example.jetpackcomposebasics

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebasics.ui.theme.ui.theme.JetpackComposeBasicsTheme


class BasicActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeBasicsTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                   // messageCard("Android")
                    messageCard2(msg = message("Android","JetpackCompose"))
                }
            }

        }
    }

    // Lesson 1 --> Composable
    @Composable
    fun messageCard(name:String){
        Text(text = "Hello $name!")
    }

    // Preview Your Composable functions
   /* @Preview
    @Composable
    fun previewCard(){
        messageCard("Android")
    }*/


    // Lesson 2 --> Layouts
     data class message(val author:String,val body:String)
    @Composable
    fun messageCard2(msg:message)
    {
        // Add padding around our message
        // Adding an image element and Row
        Row(modifier = Modifier.padding(all = 8.dp))
        {
            Image(
                painter = painterResource(R.drawable.profile_picture),
                contentDescription = "Screeshot",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    // Add a border to image using MaterialTheme.colorScheme
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))

            // Adding Column function--> arrange elements vertically
            Column {
                Text(text = msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                    )
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))
                Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                    Text(text = msg.body,
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

            }
        }
    }

    // Enable Dark Theme
    /*Note : You can create multiple previews in your file as separate functions,
    or add multiple annotations to the same function.*/
    @Preview(name = "Light Mode")
    @Preview(
        uiMode = UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun previewMessageCard(){
        // Adding a Matreial Theme
        JetpackComposeBasicsTheme {
            Surface {
                messageCard2(msg = message(author = "Pooja Mantri",
                    body = "Hey, take a look at Jetpack Compose, it's great!"))
            }
        }

    }
}
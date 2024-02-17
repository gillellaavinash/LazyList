package com.example.compose_lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_lazylist.ui.theme.Compose_LazylistTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_LazylistTheme {
                LazyListsExample1(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun LazyListsExample1(
    modifier: Modifier = Modifier
){
    val fruits by remember {
        mutableStateOf(fruits)
    }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            items(fruits.size) {
                Card(
                    modifier = Modifier.padding(15.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(Color.LightGray)
                ) {
                    Column(
                        modifier = Modifier.padding(1.dp)
                    )
                    {
                        Text(
                            text = fruits[it].name,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            //textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        )
                        Box(modifier = Modifier.aspectRatio(5f)) {
                            Image(
                                painter = painterResource(id = fruits[it].image),
                                contentDescription = "Fruit",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .align(androidx.compose.ui.Alignment.CenterStart)
                                    .clickable {
                                        fruits[it].name
                                    }
                            )
                        }
                        Text(
                            text = fruits[it].description,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
                //Divider(modifier.padding(16.dp), thickness = 1.dp, color = Color.Black)
            }
        }
}

data class Fruits(
    val name: String,
    val image: Int,
    val description: String
)

val fruits = listOf(
    Fruits(
        name = "Apple",
        image = R.drawable.apple,
        description = "Apple is a fruit"
    ),
    Fruits(
        name = "Banana",
        image = R.drawable.banana,
        description = "Banana is a fruit"
    ),
    Fruits(
        name = "Cherry",
        image = R.drawable.cherry,
        description = "Cherry is a fruit"
    ),
    Fruits(
        name = "Grapes",
        image = R.drawable.grapes,
        description = "Grapes is a fruit"
    ),
    Fruits(
        name = "Kiwi",
        image = R.drawable.kiwi,
        description = "Kiwi is a fruit"
    ),
    Fruits(
        name = "Mango",
        image = R.drawable.mango,
        description = "Mango is a fruit"
    ),
    Fruits(
        name = "Orange",
        image = R.drawable.orange,
        description = "Orange is a fruit"
    ),
    Fruits(
        name = "Pineapple",
        image = R.drawable.pineapple,
        description = "Pineapple is a fruit"
    ),
    Fruits(
        name = "Pomegranate",
        image = R.drawable.pomegranate,
        "Pomegranate is a fruit"
        ),
    Fruits(
        name = "Strawberry",
        image = R.drawable.strawberry,
        description = "Strawberry is a fruit"
        ),
    Fruits(
        name = "Watermelon",
        image = R.drawable.watermelon,
        description = "Watermelon is a fruit"
        ),
)
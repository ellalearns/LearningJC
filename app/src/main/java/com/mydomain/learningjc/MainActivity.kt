package com.mydomain.learningjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val info = Info()
            val listElements = info.allIslands.size
            MainScreenComp(listElements, info)
        }
    }
}

val lexend = FontFamily(
    Font(R.font.lexend_bold, FontWeight.Bold),
    Font(R.font.lexend_regular, FontWeight.Normal),
    Font(R.font.lexend_semibold, FontWeight.SemiBold),
    Font(R.font.lexend_extralight, FontWeight.ExtraLight),
    Font(R.font.lexend_medium, FontWeight.Medium),
    Font(R.font.lexend_extrabold, FontWeight.ExtraBold),
    Font(R.font.lexend_thin, FontWeight.Thin),
    Font(R.font.lexend_light, FontWeight.Light),
    Font(R.font.lexend_black, FontWeight.Black)
)

@Composable
fun MainScreenComp(
    listElements: Int,
    info: Info
) {
    var currIsland by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 25.dp,
                        bottomEnd = 25.dp
                    )
                )
                .fillMaxHeight()
                .weight(0.7f)
        ) {
            Image(
                painter = painterResource(id = info.islandPics[currIsland]), contentDescription = "",
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Column (
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(50.dp)
                        .padding(10.dp)
                )
            }
            Column (
                modifier = Modifier
                    .align(
                        Alignment.TopEnd
                    )
                    .padding(20.dp)
            ) {
                Icon(
                    Icons.Rounded.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier
                        .background(
                            color = if (info.heart[currIsland]) Color.Yellow else Color.LightGray,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(50.dp)
                        .padding(10.dp)
                        .clickable {
                            info.heart[currIsland] = !info.heart[currIsland]
                        }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Icon(
                    Icons.Rounded.Share,
                    contentDescription = null,
                    modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(50.dp)
                        .padding(10.dp)
                )
            }
            LazyRow (
                Modifier.align(Alignment.BottomCenter)
            ) {
                items (count = listElements) {
                    Column (
                        Modifier
                            .padding(10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(50.dp)
                                .height(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Divider (
                                color = Color.Black,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(2.dp)
                            )
                        }
                    }
                }
            }
            Column (
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 10.dp, bottom = 30.dp)
            ) {
                if (currIsland > 0) {
                    Icon (
                        Icons.Rounded.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp)
                            .clickable {
                                if (currIsland > 0) {
                                    currIsland -= 1
                                }
                            }
                    )
                }
            }
            Column (
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 10.dp, bottom = 30.dp)
            ) {
                if (currIsland < 3) {
                    Icon (
                        Icons.Rounded.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp)
                            .clickable {
                                if (currIsland < (listElements - 1)) {
                                    currIsland += 1
                                }
                            }
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .weight(1f)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier
                    .width(5.dp))
                Text(
                    text = info.ratings[currIsland],
                    fontFamily = lexend,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier
                    .width(5.dp))
                Text(
                    text = "(" + info.numberOfRatings[currIsland] + ")",
                    fontFamily = lexend,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color.LightGray
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text (
                text = info.allIslands[currIsland],
                fontFamily = lexend,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Row {
                    Icon(
                        Icons.Rounded.Place,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = info.distance[currIsland],
                        fontFamily = lexend,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Row {
                    Icon(
                        Icons.Rounded.AddCircle,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Mobile ticket",
                        fontFamily = lexend,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Description",
                fontFamily = lexend,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            var maxLines by remember {
                mutableStateOf(5)
            }
            Text(
                text = info.description[currIsland],
                lineHeight = 20.sp,
                color = Color.DarkGray,
                maxLines = maxLines,
                modifier = Modifier.clickable {
                    maxLines = 5
                },
                overflow = TextOverflow.Ellipsis
            )
            if (maxLines == 5) {
                Text(
                    text = "Read More",
                    modifier = Modifier
                        .clickable {
                            maxLines = 100
                        }
                )
            }
        }
    }
}







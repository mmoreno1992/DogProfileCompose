package dev.mmoreno.dogprofilecompose

import android.graphics.Matrix
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MainDogProfile() {
    Card(
        elevation = 6.dp, modifier = Modifier.fillMaxSize()
            .padding(top = 24.dp, bottom = 24.dp, start = 16.dp, end = 16.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp)
        ) {
            val (dogImage, breedText, dogLocation, statusRow, buttonsRow) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.husky),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .width(100.dp)
                    .height(100.dp)
                    .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                    .constrainAs(dogImage) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    },
            )
            Text("Husky Siberian",
                modifier = Modifier.constrainAs(breedText) {
                    top.linkTo(dogImage.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            Text("Germany",
                modifier = Modifier.constrainAs(dogLocation) {
                    top.linkTo(breedText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(statusRow) {
                        top.linkTo(dogLocation.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ProfileStats(count = "150", statusName = "Followers")
                ProfileStats(count = "150", statusName = "Following")
                ProfileStats(count = "150", statusName = "Posts")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(buttonsRow) {
                        top.linkTo(statusRow.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text("Follow User")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text("Direct Message")
                }
            }
        }
    }
}

@Composable
fun ProfileStats(count: String, statusName: String) {
    Column {
        Text(text = count, modifier = Modifier.align(Alignment.CenterHorizontally))
        Text(text = statusName, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainDogProfile() {
    MainDogProfile()
}
package com.example.hw2_potato.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw2_potato.R
import com.example.hw2_potato.model.CheckState

@Composable
fun PotatoImage(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    val checkStates = remember {
        listOf(
            CheckState("arms", R.drawable.arms, mutableStateOf(true)),
            CheckState("ears", R.drawable.ears, mutableStateOf(true)),
            CheckState("eyebrows", R.drawable.eyebrows, mutableStateOf(true)),
            CheckState("eyes", R.drawable.eyes, mutableStateOf(true)),
            CheckState("glasses", R.drawable.glasses, mutableStateOf(true)),
            CheckState("hat", R.drawable.hat, mutableStateOf(true)),
            CheckState("mouth", R.drawable.mouth, mutableStateOf(true)),
            CheckState("mustache", R.drawable.mustache, mutableStateOf(true)),
            CheckState("nose", R.drawable.nose, mutableStateOf(true)),
            CheckState("shoes", R.drawable.shoes, mutableStateOf(true))
        )
    }
    if (isPortrait) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(250.dp)
                    .background(Color.White), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.body),
                    contentDescription = "body"
                )
                checkStates.forEach { checkState ->
                    if (checkState.state.value) {
                        Image(
                            painter = painterResource(id = checkState.resId),
                            contentDescription = checkState.name
                        )
                    }
                }
            }
            Text(text = "201912326 박호준",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .padding(horizontal = 12.dp)
            ) {
                checkStates.chunked(5).forEach { columParts ->
                    Column(modifier = Modifier.weight(1f)) {
                        columParts.forEach { checkState ->
                            PotatoCheckBox(
                                label = checkState.name,
                                checked = checkState.state.value,
                                onCheckedChange = { checkState.state.value = it })
                        }
                    }
                }
            }
        }
    } else {
        Column {
            Spacer(modifier = Modifier.height((24.dp)))
            Text(text = "201912326 박호준",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Row(modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(250.dp)
                    .background(Color.White), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.body),
                    contentDescription = "body"
                )
                checkStates.forEach { checkState ->
                    if (checkState.state.value) {
                        Image(
                            painter = painterResource(id = checkState.resId),
                            contentDescription = checkState.name
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .padding(horizontal = 12.dp)
            ) {
                checkStates.chunked(5).forEach { columParts ->
                    Column(modifier = Modifier.weight(1f)) {
                        columParts.forEach { checkState ->
                            PotatoCheckBox(
                                label = checkState.name,
                                checked = checkState.state.value,
                                onCheckedChange = { checkState.state.value = it })
                        }
                    }
                }
            }
        }
    }

}

@Preview(name = "Landscape Preview",
    showBackground = true,
    widthDp = 640,
    heightDp = 360,
    uiMode = Configuration.UI_MODE_TYPE_NORMAL or Configuration.ORIENTATION_LANDSCAPE)
@Composable
private fun PotatoImageLandPrev() {
    PotatoImage()
}
@Preview(name = "Portrait Preview",
    showBackground = true,
    widthDp = 360,
    heightDp = 640)
@Composable
private fun PotatoImagePortraitPrev() {
    PotatoImage()
}


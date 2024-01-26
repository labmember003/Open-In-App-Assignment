package com.falcon.openinapp_assignment

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.falcon.openinapp_assignment.ui.theme.OpenInAppAssignmentTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenInAppAssignmentTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreen() {
    val scope = rememberCoroutineScope()
    val list = listOf("Links", "Courses", "Plus", "Campaigns", "Profile")
    val pageState = rememberPagerState(0)
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(16.dp)
    ) {
        HorizontalPager(
            pageCount = list.size,
            state = pageState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(bottom = 8.dp),
            pageContent = { pageNumber ->
//                val specificContent = content.filter {
//                    it.contentType == list[pageNumber]
//                }
//                LaunchedEffect(key1 = pageNumber) {
//                    currentType.value = list[pageNumber]
//                    Log.i("catcatcatwty2", pageNumber.toString())
//                }
//                NotesList(specificContent, navController, getIcon(list[pageNumber], true), modalSheetState)
            }
        )

        TabRow(
            selectedTabIndex = pageState.currentPage,
            indicator = {},
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            list.forEachIndexed { index, _ ->
                Tab(
                    modifier = Modifier.fillMaxWidth(),
                    selectedContentColor = colorResource(R.color.icon_blue),
                    text = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = getIcon(list[index], pageState.currentPage == index)),
                                contentDescription = "Icon",
                                modifier = Modifier
                                    .size(20.dp)
                            )
                            if (pageState.currentPage == index) {
                                androidx.compose.material.Text(
                                    list[index],
                                    fontSize = 13.sp,
                                    // on below line we are specifying the text color
                                    // for the text in that tab
                                    color = if (pageState.currentPage == index) colorResource(R.color.icon_blue) else Color.Black,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(bottom = 10.dp)
                                )
                            }
                            if (pageState.currentPage == index) {

                            }
                        }

                    },
                    // on below line we are specifying
                    // the tab which is selected.
                    selected = pageState.currentPage == index,
                    // on below line we are specifying the
                    // on click for the tab which is selected.
                    onClick = {
                        // on below line we are specifying the scope.
                        Log.i("happppy", pageState.currentPage.toString())
                        Log.i("happppy2", index.toString())
                        scope.launch {
                            pageState.scrollToPage(index)
                        }
                    }
                )
            }
        }
    }
}

fun getIcon(contentName: String, selected: Boolean): Int {
    if (selected) {
        when (contentName) {
            "Links" -> {
                return R.drawable.link
            }
            "Courses" -> {
                return R.drawable.files
            }
            "Plus" -> {
                return R.drawable.plus
            }
            "Campaigns" -> {
                return R.drawable.fast_forward
            }
            "Profile" -> {
                return R.drawable.user
            }
            else -> return R.drawable.error
        }
    }
    else {
        when (contentName) {
            "Links" -> {
                return R.drawable.link
            }
            "Courses" -> {
                return R.drawable.files
            }
            "Plus" -> {
                return R.drawable.plus
            }
            "Campaigns" -> {
                return R.drawable.fast_forward
            }
            "Profile" -> {
                return R.drawable.user
            }
            else -> return R.drawable.error
        }
    }
}
package com.falcon.openinapp_assignment

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.falcon.openinapp_assignment.ui.theme.OpenInAppAssignmentTheme
import kotlinx.coroutines.launch
import org.bouncycastle.math.raw.Mod
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import kotlinx.coroutines.CoroutineScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
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
    val currentType = remember {
        mutableStateOf("Type")
    }
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.icon_blue))
    ) {
        DashboardHeading()
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
//            .verticalScroll(rememberScrollState())
        ) {
            HorizontalPager(
                pageCount = list.size,
                state = pageState,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                ,
                pageContent = { pageNumber ->
                LaunchedEffect(key1 = pageNumber) {
                    currentType.value = list[pageNumber]
                    Log.i("catcatcatwty2", pageNumber.toString())
                }
                    if (pageNumber == 0) {
                        MainScreenContent()
                    }
                    else {
                        ComingSoonScreen()
                    }
                }
            )

            BottomNavigation(pageState, list, scope)
        }
    }

}

@Composable
fun ComingSoonScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        LottieAnimation(animationID = R.raw.coming_soon_cat)
        androidx.compose.material3.Text(
            text = "Coming Soon"
        )
    }
}

@Composable
fun LottieAnimation(animationID: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(animationID))
    com.airbnb.lottie.compose.LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier
            .size(400.dp)
    )
}

@Composable
fun MainScreenContent() {
    androidx.compose.material.Card(
        modifier = Modifier
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(16.dp, 16.dp))
            .fillMaxSize(),
        backgroundColor = colorResource(id = R.color.light_grey)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp, 32.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Good Morning",
                fontSize = 16.sp,
                color = colorResource(id = R.color.grey),
                fontFamily = FontFamily(Font(R.font.nunito_light_1)),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Ajay Manva",
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_bold_1)),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Image(
                        painter = painterResource(R.drawable.hello),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .size(35.dp)
                    )
                }
                TimePeriod()
            }
            Chart()
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                val list = listOf(
                    PickCardItem(R.drawable.avatar, "123", "Today’s clicks"),
                    PickCardItem(R.drawable.avatar__1_, "Ahamedabad", "Top Location"),
                    PickCardItem(R.drawable.avatar__2_, "Instagram", "Top Source")
                )
                items(list){ it ->
                    PickCard(it.image, it.title, it.description)
                }
            }
            ViewAnalyticsCard()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row {
                    TopLinksCard()
                    RecentLinksCard()
                }
                Image(
                    painter = painterResource(R.drawable.input_container),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(35.dp)
                )
            }
            LinkCard()
            LinkCard()
            LinkCard()
            LinkCard()
            ViewAllLinksCard()
            WhatsappCard()
            Spacer(modifier = Modifier.height(60.dp))
        }

    }

}

@Composable
fun WhatsappCard() {
    val context = LocalContext.current
    androidx.compose.material.Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                openWhatsAppChat(context, "+918800136151")
            },
        backgroundColor = colorResource(id = R.color.background_green),
        border = BorderStroke(1.dp, colorResource(id = R.color.background_green))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(16.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.vector),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(35.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Talk with us",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.nunito_bold_1)),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}

@Composable
private fun RecentLinksCard() {
    androidx.compose.material.Card(
        shape = RoundedCornerShape(32.dp),
        modifier = Modifier
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        backgroundColor = colorResource(id = R.color.white),
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
        ) {
            Text(
                text = "Recent Links",
                fontSize = 12.sp,
                color = colorResource(id = R.color.dark_grey),
                fontFamily = FontFamily(Font(R.font.nunito_extralight)),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}

@Composable
private fun TopLinksCard() {
    androidx.compose.material.Card(
        shape = RoundedCornerShape(32.dp),
        modifier = Modifier
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        backgroundColor = colorResource(id = R.color.icon_blue),
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
        ) {
            Text(
                text = "Top Links",
                fontSize = 12.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.nunito_extralight)),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}


@Composable
private fun ViewAllLinksCard() {
    androidx.compose.material.Card(
        modifier = Modifier
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .fillMaxWidth(),
        backgroundColor = Color.White,
        border = BorderStroke(1.dp, colorResource(id = R.color.dark_grey))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(8.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.link),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(35.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "View all Links",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.nunito_extralight)),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LinkCard() {
    androidx.compose.material.Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(16.dp))
            .padding(8.dp)
            .fillMaxWidth(),
        backgroundColor = Color.White,
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                ImageNameDate()
                ClicksColumn()
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                val clipboardManager = LocalContext.current.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val link = remember {
                    mutableStateOf("https://www.instagram.com/")
                }
                Text(
                    text = link.value,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.icon_blue),
                    fontFamily = FontFamily(Font(R.font.nunito_bold_1)),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Image(
                    painter = painterResource(R.drawable.copy),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            clipboardManager.setPrimaryClip(
                                ClipData.newPlainText(
                                    "Copied Code",
                                    link.value
                                )
                            )
                        }
                )
            }
        }
    }
}

@Composable
private fun ClicksColumn() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = "2323",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.nunito_bold_1)),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold
            )
        )
        Text(
            text = "Clicks",
            fontSize = 14.sp,
            color = colorResource(id = R.color.dark_grey),
            fontFamily = FontFamily(Font(R.font.nunito_light_1)),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
private fun ImageNameDate() {
    Row {
        Image(
            painter = painterResource(R.drawable.hello),
            contentDescription = "Icon",
            modifier = Modifier
                .size(35.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Sample link name...",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.nunito_bold_1)),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = "22 Aug 2022",
                fontSize = 14.sp,
                color = colorResource(id = R.color.dark_grey),
                fontFamily = FontFamily(Font(R.font.nunito_light_1)),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}

@Composable
private fun ViewAnalyticsCard() {
    androidx.compose.material.Card(
        modifier = Modifier
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .fillMaxWidth(),
        backgroundColor = Color.White,
        border = BorderStroke(1.dp, colorResource(id = R.color.dark_grey))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(8.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.price_boost),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(35.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "View Analytics",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.nunito_extralight)),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PickCard(
    image: Int, title: String, description: String
) {
    androidx.compose.material.Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(8.dp),
        backgroundColor = Color.White
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(35.dp)
            )
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(0.dp, 16.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold_1)),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = description,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.grey),
                    fontFamily = FontFamily(Font(R.font.nunito_light_1)),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

        }
    }
}

@Composable
private fun Chart() {
    val steps = 5
    val pointsData: List<Point> =
        listOf(Point(0f, 40f), Point(1f, 90f), Point(2f, 0f), Point(3f, 60f), Point(4f, 10f))
    val xAxisData = AxisData.Builder()
        .axisStepSize(100.dp)
        .backgroundColor(Color.White)
        .steps(pointsData.size - 1)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(colorResource(id = R.color.black))
        .axisLabelColor(colorResource(id = R.color.black))
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(Color.White)
        .labelAndAxisLinePadding(5.dp)
        .labelData { i ->
            val yScale = 100 / steps
            (i * yScale).toString()
        }
        .axisLineColor(colorResource(id = R.color.black))
        .axisLabelColor(colorResource(id = R.color.black))
        .build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(),
                    IntersectionPoint(),
                    SelectionHighlightPoint(),
                    ShadowUnderLine(),
                    SelectionHighlightPopUp()
                )
            ),
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(),
        backgroundColor = Color.White
    )
    LineChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        lineChartData = lineChartData
    )
}

@Composable
fun TimePeriod() {
    androidx.compose.material.Card(
        modifier = Modifier
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        backgroundColor = Color.White,
        border = BorderStroke(1.dp, colorResource(id = R.color.icon_blue))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(8.dp),
        ) {
            Text(
                text = "22 Aug - 23 Sept",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.nunito_extralight)),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun BottomNavigation(
    pageState: PagerState,
    list: List<String>,
    scope: CoroutineScope
) {
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
                        if (getIcon(list[index], false) != R.drawable.plus) {
                            Image(
                                painter = painterResource(
                                    id = getIcon(
                                        list[index],
                                        pageState.currentPage == index
                                    )
                                ),
                                contentDescription = "Icon",
                                modifier = Modifier
                                    .size(25.dp)
                            )
                        } else {

                            Box(
                                modifier = Modifier
                                    .size(40.dp) // Adjust the size of the circle as needed
                                    .background(
                                        colorResource(id = R.color.icon_blue),
                                        shape = CircleShape
                                    )
                            ) {
                                // Your content inside the circular shape
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxSize()
                                ) {
                                    Image(
                                        painter = painterResource(
                                            id = getIcon(
                                                list[index],
                                                pageState.currentPage == index
                                            )
                                        ),
                                        contentDescription = "Icon",
                                        modifier = Modifier
                                            .size(25.dp)
                                    )
                                }

                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        if (getIcon(list[index], false) != R.drawable.plus) {
                            androidx.compose.material.Text(
                                list[index],
                                fontSize = 11.sp,
                                // on below line we are specifying the text color
                                // for the text in that tab
                                color = Color.Black,
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

@Composable
private fun DashboardHeading() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Dashboard",
            fontSize = 24.sp,
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.nunito_bold_1)),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold
            )
        )
        Image(
            painter = painterResource(id = R.drawable.frame_7),
            contentDescription = "menu icon",
            modifier = Modifier
                .size(40.dp)
        )
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
fun openWhatsAppChat(context: Context, phoneNumber: String) {
    try {
        val uri = Uri.parse("whatsapp://send?phone=$phoneNumber")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context.startActivity(intent)
    } catch (e: Exception) {
        // Handle exceptions, e.g., if WhatsApp is not installed on the device
        e.printStackTrace()
    }
}
@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mysootheapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysootheapp.ui.theme.MySootheAppTheme
import androidx.compose.material3.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheAppTheme {
                // Call MySootheAppLandscape when in landscape mode
                if (isInLandscapeMode()) {
                    MySootheAppLandscape()
                } else {
                    // Call MySootheAppPortrait or another appropriate composable for portrait mode
                    MySootheAppPortrait()
                }
            }
        }
    }

    private fun isInLandscapeMode(): Boolean {
        val orientation = resources.configuration.orientation
        return orientation == Configuration.ORIENTATION_LANDSCAPE
    }
}


@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        colors = TextFieldDefaults.textFieldColors (
            unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(R.string.search_placeholder))
        },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
    )
}


@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar()
}


@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview(){
    AlignYourBodyElement(
        drawable = R.drawable.yoga,
        text = R.string.ab1_inversion
    )
}


@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(88.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FavoriteCollectionCardPreview(){
    FavoriteCollectionCard(
        drawable = R.drawable.nature_meditation,
        text = R.string.t_nature_meditation,
        modifier = Modifier.padding(8.dp)
    )
}

data class AlignYourBodyItem(@DrawableRes val drawable: Int, @StringRes val text: Int)
val alignYourBodyData: List<AlignYourBodyItem> = listOf(
    AlignYourBodyItem(R.drawable.yoga, R.string.ab1_inversion),
    AlignYourBodyItem(R.drawable.yoga, R.string.ab1_inversion),
    AlignYourBodyItem(R.drawable.yoga, R.string.ab1_inversion),
    AlignYourBodyItem(R.drawable.yoga, R.string.ab1_inversion),
    AlignYourBodyItem(R.drawable.yoga, R.string.ab1_inversion),
    AlignYourBodyItem(R.drawable.yoga, R.string.ab1_inversion),
    AlignYourBodyItem(R.drawable.yoga, R.string.ab1_inversion),
    // Add more items as needed
)


@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}

@Composable
fun AlignYourBodyScreen() {
    MySootheAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn {
                item {
                    Text(
                        text = "Align Your Body",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(8.dp)
                    )
                }
                item {
                    AlignYourBodyRow(modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlignYourBodyPreview(){
    AlignYourBodyScreen()
}


data class FavoriteCollectionItem(@DrawableRes val drawable: Int, @StringRes val text: Int)
val favoriteCollectionsData: List<FavoriteCollectionItem> = listOf(
    FavoriteCollectionItem(R.drawable.nature_meditation, R.string.t_nature_meditation),
    FavoriteCollectionItem(R.drawable.nature_meditation, R.string.t_nature_meditation),
    FavoriteCollectionItem(R.drawable.nature_meditation, R.string.t_nature_meditation),
    FavoriteCollectionItem(R.drawable.nature_meditation, R.string.t_nature_meditation),
    FavoriteCollectionItem(R.drawable.nature_meditation, R.string.t_nature_meditation),
    FavoriteCollectionItem(R.drawable.nature_meditation, R.string.t_nature_meditation),
    FavoriteCollectionItem(R.drawable.nature_meditation, R.string.t_nature_meditation),
    // Add more items as needed
)

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = modifier.height(168.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(item.drawable, item.text, Modifier.height(80.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteCollectionsGridPreview(){
    FavoriteCollectionsGrid()
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))

        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }

        Spacer(Modifier.height(24.dp))
    }
}


@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier)
    {
        NavigationBarItem(
            onClick = {},
            selected = false,
            icon = {
                Icon(imageVector = Icons.Default.Face, contentDescription = null)
            },
            label = {
                Text(text = stringResource(R.string.bottom_navigation_home))
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(R.string.bottom_navigation_profile))
            }
        )
    }
}

@Composable
fun MySootheAppPortrait(modifier: Modifier = Modifier) {
    MySootheAppTheme{
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) {
                padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Composable
private fun AppNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background
    ){
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_home))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_profile))
                }
            )
        }
    }
}

@Composable
fun MySootheAppLandscape() {
    MySootheAppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                AppNavigationRail()
                HomeScreen()
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 180)
@Composable
fun ScreenContentPreview(){
    MySootheAppTheme {
        HomeScreen()
    }
}
















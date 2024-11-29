package com.mlefrapper.foodly.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.mlefrapper.foodly.R

@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            onSearch(newText.text)
        },
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = stringResource(R.string.search_bar_search_content_description),
            )
        },
        trailingIcon = {
            if (text.text.isNotEmpty()) {
                IconButton(
                    onClick = {
                        text = TextFieldValue("")
                    },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(R.string.search_bar_clear),
                    )
                }
            }
        },
        placeholder = {
            Text(
                text = stringResource(R.string.search_bar_hint),
            )
        },
        shape = RectangleShape,
        singleLine = true,
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar(onSearch = {})
}

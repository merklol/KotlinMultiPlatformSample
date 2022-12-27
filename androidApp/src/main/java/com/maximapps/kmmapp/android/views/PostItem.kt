package com.maximapps.kmmapp.android.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maximapps.kmmapp.Post

@Composable
fun PostItem(post: Post) {
    Column {
        Column(modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp)) {
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                text = post.title
            )
            Text(post.body)
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))
        Divider(Modifier.fillMaxWidth().height(1.dp).padding(start = 16.dp))
    }
}
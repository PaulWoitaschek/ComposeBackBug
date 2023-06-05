package de.woitaschek.composedropdownbackbug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.PopupProperties

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                var expanded by remember { mutableStateOf(false) }
                Button(onClick = { expanded = true }) {
                    Text("Expand")
                }
                DropdownMenu(
                    properties = PopupProperties(
                        focusable = true,
                        dismissOnClickOutside = false,
                        dismissOnBackPress = true
                    ),
                    content = {
                        Text(text = "Content")
                    },
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    },
                )
            }
        }
    }
}

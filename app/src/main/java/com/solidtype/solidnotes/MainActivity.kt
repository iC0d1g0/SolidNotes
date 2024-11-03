package com.solidtype.solidnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.solidtype.solidnotes.notes.presentation.add_edit_note.AddEditNoteScreen
import com.solidtype.solidnotes.notes.presentation.notes.NotesScreen
import com.solidtype.solidnotes.notes.presentation.util.Pantallas
import com.solidtype.solidnotes.ui.theme.SolidNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolidNotesTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Pantallas.NotesScreens.route
                    ) {
                        composable(route = Pantallas.NotesScreens.route) {
                            NotesScreen(navController = navController)
                        }
                        composable(
                            route = Pantallas.AddEditNoteScreens.route +
                                    "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ) {
                            val color = it.arguments?.getInt("noteColor") ?: -1
                           AddEditNoteScreen(
                                navController = navController,
                                noteColor = color
                            )


                        }
                    }
                }
            }
        }
    }
}

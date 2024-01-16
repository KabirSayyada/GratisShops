package com.savlanet.gratisshops.splash

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
@SuppressLint("StaticFieldLeak")
class SplashViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    //private val userRepository: UserRepository,
) : ViewModel() {

    //val uiState = mutableStateOf<UiState>(UiState.Idle)

    //val APP_LAUNCHED = booleanPreferencesKey("launched")

    /** Is the app launched before or not? */
    //val isAppLaunchedBefore = context.dataStore.data.map {
      //  it[APP_LAUNCHED] ?: false
  //  }


}

//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

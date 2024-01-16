package com.savlanet.gratisshops.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.savlanet.gratisshops.presentation.impl.BrandsRepository
import com.savlanet.gratisshops.sealed.DataResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val brandsRepository: BrandsRepository,
) : ViewModel() {}
  /*  val searchQuery = mutableStateOf("")

    val homeAdvertisementsUiState = mutableStateOf<UiState>(UiState.Success)
    val advertisements: MutableList<Advertisement> = mutableStateListOf()

    val brandsUiState = mutableStateOf<UiState>(UiState.Loading)
    val brands: MutableList<Manufacturer> = mutableStateListOf()

    val currentSelectedBrandIndex = mutableStateOf(0)

    fun updateCurrentSelectedBrandId(index: Int) {
        currentSelectedBrandIndex.value = index
    }

    fun updateSearchInputValue(value: String) {
        this.searchQuery.value = value
    }

    fun getHomeAdvertisements() {
        if (advertisements.isNotEmpty()) return

        /** start loading */
        homeAdvertisementsUiState.value = UiState.Loading
        viewModelScope.launch {
            brandsRepository.getBrandsAdvertisements().let {
                when (it) {
                    is DataResponse.Success -> {
                        /** Got a response from the server successfully */
                        homeAdvertisementsUiState.value = UiState.Success
                        it.data?.let { responseAds ->
                            advertisements.addAll(responseAds)
                        }
                    }
                    is DataResponse.Error -> {
                        /** An error happened when fetching data from the server */
                        homeAdvertisementsUiState.value =
                            UiState.Error(
                                error = (it.error
                                    ?: com.savlanet.gratisshops.presentation.checkout.Error.Network) as com.savlanet.gratisshops.presentation.checkout.Error
                            )
                    }
                }
            }
        }
    }
}

*/
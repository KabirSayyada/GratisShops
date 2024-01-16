package com.savlanet.gratisshops.presentation.cart

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.savlanet.gratisshops.model.OrderLine
import com.savlanet.gratisshops.model.ProductRepo
import com.savlanet.gratisshops.model.SnackbarManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.savlanet.gratisshops.R
import com.savlanet.gratisshops.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
* Holds the contents of the cart and allows changes to it.
*
* TODO: Move data to Repository so it can be displayed and changed consistently throughout the app.
*/
@HiltViewModel
class CartViewModel @Inject constructor(
    //private val snackbarManager: SnackbarManager,

) : ViewModel() {

    private val productRepository: ProductRepo = ProductRepo

    private val _orderLines: MutableStateFlow<List<OrderLine>> =
        MutableStateFlow(productRepository.getCart())
    val orderLines: StateFlow<List<OrderLine>> get() = _orderLines

    val produc = mutableStateOf<Product?>(null)

    val isSyncingCart = mutableStateOf(false)

    // Logic to show errors every few requests
    private var requestCount = 0
    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0

    fun increaseSnackCount(productId: Long) {
        if (!shouldRandomlyFail()) {
            val currentCount = _orderLines.value.first { it.product.id == productId }.count
            updateSnackCount(productId, currentCount + 1)
        } else {
            SnackbarManager.showMessage(R.string.cart_increase_error)
        }
    }

    fun decreaseSnackCount(productId: Long) {
        if (!shouldRandomlyFail()) {
            val currentCount = _orderLines.value.first { it.product.id == productId }.count
            if (currentCount == 1) {
                // remove snack from cart
                removeSnack(productId)
            } else {
                // update quantity in cart
                updateSnackCount(productId, currentCount - 1)
            }
        } else {
            SnackbarManager.showMessage(R.string.cart_decrease_error)
        }
    }

    fun removeSnack(productId: Long) {
        _orderLines.value = _orderLines.value.filter { it.product.id != productId }
    }

    private fun updateSnackCount(productId: Long, count: Int) {
        _orderLines.value = _orderLines.value.map {
            if (it.product.id == productId) {
                it.copy(count = count)
            } else {
                it
            }
        }
    }
    fun syncCartItems(
        onSyncSuccess: () -> Unit,
        onSyncFailed: (reason: Int) -> Unit,

    ) {
        isSyncingCart.value = true
        viewModelScope.launch {
            delay(4000)
            isSyncingCart.value = false
            onSyncSuccess()
        }
    }

    /**
     * Factory for CartViewModel that takes SnackbarManager as a dependency
     */

    companion object {
        fun provideFactory(
            snackbarManager: SnackbarManager = SnackbarManager,
            productRepository: ProductRepo = ProductRepo
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CartViewModel() as T
            }
        }  
    }
}

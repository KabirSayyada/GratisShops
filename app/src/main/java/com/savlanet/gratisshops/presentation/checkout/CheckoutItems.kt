package com.savlanet.gratisshops.presentation.checkout
/*
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.savlanet.gratisshops.R
import com.savlanet.gratisshops.model.Product
import com.savlanet.gratisshops.presentation.impl.Manufacturer


@Entity
data class Location(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val address: String,
    val city: String,
    val country: String,
)

@Entity
data class PaymentProvider(
    @PrimaryKey val id: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
)

data class UserPaymentProviderDetails(
    @Embedded
    val userPaymentProvider: UserPaymentProvider,
    @Relation(
        parentColumn = "providerId",
        entityColumn = "id",
    )
    val paymentProvider: PaymentProvider,
)

@Entity(tableName = "userPaymentProviders", primaryKeys = ["providerId", "cardNumber"])
data class UserPaymentProvider(
    val providerId: String,
    val cardNumber: String,
)


    sealed class UiState {
    object Idle : UiState()
    object Loading : UiState()
    object Success : UiState()
    class Error(val error: com.savlanet.gratisshops.presentation.checkout.Error) : UiState()
}

sealed class Error(@StringRes var title: Int, @StringRes var message: Int){
    object Network: Error(
        title = R.string.net_conn_err_title,
        message = R.string.net_conn_err_message,
    )
    object Empty: Error(
        title = R.string.no_avail_data_err_title,
        message = R.string.no_avail_data_err_body,
    )
    class Custom(
        title: Int,
        message: Int = R.string.unknown_err_body,
    ): Error(
        title = title,
        message = message,
    )
    object Unknown: Error(
        title = R.string.unknown_err_title,
        message = R.string.unknown_err_body,
    )
}


*/
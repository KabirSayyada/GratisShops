package com.savlanet.gratisshops.presentation.checkout
/*
import androidx.room.Database
import androidx.room.RoomDatabase
import com.savlanet.gratisshops.R
import com.savlanet.gratisshops.model.Advertisement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider
import javax.inject.Inject

@Database(
    entities = [
        Advertisement::class,
        PaymentProvider::class,
        UserPaymentProvider::class,
        Location::class,
    ],
    version = 1, exportSchema = false
)

abstract class RoomDb : RoomDatabase() {
    abstract fun getDao(): RoomDao

    class PopulateDataClass @Inject constructor(
        private val client: Provider<RoomDb>,
        private val scope: CoroutineScope,
    ) : RoomDatabase.Callback() {

        private val advertisements = listOf(
            Advertisement(1, R.drawable.we_are_hiring_ad, 1, 0),
            Advertisement(2, R.drawable.discount_ad, 2, 0),
            Advertisement(3, R.drawable.style_ad, 3, 0),
            Advertisement(4, R.drawable.snacks_ad, 4, 0),
            Advertisement(5, R.drawable.kicks_ad, 5, 0),
            Advertisement(6, R.drawable.grocery_ad, 6, 0),

        )

    private val paymentProviders = listOf(
        PaymentProvider(
            id = "apple",
            title = R.string.apple_pay,
            icon = R.drawable.ic_apple,
        ),
        PaymentProvider(
            id = "master",
            title = R.string.master_card,
            icon = R.drawable.ic_master_card,
        ),
        PaymentProvider(
            id = "visa",
            title = R.string.visa,
            icon = R.drawable.ic_visa,
        ),
    )

    private val userLocation = Location(
        address = "No5, sky residence ",
        city = "Lagos",
        country = "Nigeria",
    )

    private val userPaymentAccounts = listOf(
        UserPaymentProvider(
            providerId = "apple",
            cardNumber = "8402-5739-2039-6352"
        ),
        UserPaymentProvider(
            providerId = "master",
            cardNumber = "3323-8202-4748-9982"
        ),
        UserPaymentProvider(
            providerId = "visa",
            cardNumber = "7483-02836-4839-6142"
        ),
    )

        init {

    scope.launch {
        populateDatabase(dao = client.get().getDao(), scope = scope)
    }
}

    private suspend fun populateDatabase(dao: RoomDao, scope: CoroutineScope) {

        /** insert advertisements */
        scope.launch {
            advertisements.forEach {
                dao.insertAdvertisement(it)
            }
        }

        /** Insert payment providers */
        scope.launch {
            paymentProviders.forEach {
                dao.savePaymentProvider(paymentProvider = it)
            }
        }
        /** Insert user's payment providers */
        scope.launch {
            userPaymentAccounts.forEach {
                dao.saveUserPaymentProvider(it)
            }
        }
        /** Insert user's location */
        scope.launch {
            dao.saveLocation(location = userLocation)
        }
    }
}
}

 */
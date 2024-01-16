package com.savlanet.gratisshops.presentation.checkout
/*
import androidx.room.*
import com.savlanet.gratisshops.model.Advertisement

@Dao
interface RoomDao {

    @Transaction
    @Query("SELECT * FROM userPaymentProviders")
    suspend fun getUserPaymentProviders(): List<UserPaymentProviderDetails>

    /** Locations operations */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocation(location: Location)

    @Query("SELECT * FROM location")
    suspend fun getUserLocations(): List<Location>

    /** Payment providers operations */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePaymentProvider(paymentProvider: PaymentProvider)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserPaymentProvider(userPaymentProvider: UserPaymentProvider)

    /** Advertisements operations */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAdvertisement(advertisement: Advertisement)

    @Query("SELECT * FROM advertisement")
    suspend fun getAdvertisements(): List<Advertisement>




}

 */
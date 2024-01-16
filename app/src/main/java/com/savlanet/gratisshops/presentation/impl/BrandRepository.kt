package com.savlanet.gratisshops.presentation.impl

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composer.Companion.Empty
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.savlanet.gratisshops.model.Advertisement
import com.savlanet.gratisshops.sealed.DataResponse
import javax.inject.Inject

class BrandsRepository @Inject constructor(
   // private val dao: RoomDao,
) {}
    /*suspend fun getBrandsAdvertisements(): DataResponse<List<Advertisement>> {
        /** First we should check the local storage */
        dao.getAdvertisements().let {
            return if (it.isNotEmpty()) {
                DataResponse.Success(data = it)
            } else {
                /** Now we should fetch from the remote server */
                DataResponse.Error(error = com.savlanet.gratisshops.sealed.Error.Empty)
            }
        }
    }

}





@Entity
data class Manufacturer(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    @DrawableRes val icon: Int,
) {
    @Ignore
    val products = mutableListOf<Product>()
}
*/

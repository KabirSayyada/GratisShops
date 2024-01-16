package com.savlanet.gratisshops.sealed

import androidx.annotation.StringRes
import com.savlanet.gratisshops.R

sealed class DataResponse<T>(
    var data: T? = null,
    var error: com.savlanet.gratisshops.sealed.Error? = null,
) {
    class Success<T>(data: T) : DataResponse<T>(data = data)
    class Error<T>(error: com.savlanet.gratisshops.sealed.Error) : DataResponse<T>(error = error)
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
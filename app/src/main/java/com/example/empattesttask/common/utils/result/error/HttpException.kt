package com.example.empattesttask.common.utils.result.error

class HttpException(
    val statusCode: Int,
    val statusMessage: String? = null,
    val url: String? = null,
    val errorBody: CustomError? = null,
    cause: Throwable? = null
) : Exception(null, cause)
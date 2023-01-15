package com.example.empattesttask.common.utils.result.error

interface IHttpResponse {
    val statusCode: Int?
    val statusMessage: String?
    val url: String?
    val errorBody: CustomError?
}
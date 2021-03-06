package com.example.data.networking

import com.example.data.networking.models.AccessToken
import com.example.data.networking.models.FilesModel
import com.example.data.networking.models.Subjects
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AkashAPICalls {

    @GET("token")
    suspend fun getToken(): Response<AccessToken>

    @GET("api/getSubjects/branchId/{branchId}")
    suspend fun getSubjects(
        @Path("branchId") branchId: Int
    ): Response<List<Subjects>>

    @POST("api/getDocumentsByKey")
    suspend fun getFilesBySubject(
        @Query("key") key: String,
        @Query("page") page: Int
    ): Response<FilesModel>

}
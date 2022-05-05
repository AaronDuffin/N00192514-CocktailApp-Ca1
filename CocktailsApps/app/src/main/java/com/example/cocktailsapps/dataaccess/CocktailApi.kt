package com.example.cocktailsapps.dataaccess

import com.example.cocktailsapps.data.CocktailEntity
import com.example.cocktailsapps.data.CocktailResponse
import retrofit2.Response
import retrofit2.http.GET

interface CocktailApi {

    // I simply get the json file, however you will probably have an API endpoint in here from a proper Rest API
    @GET("search.php?s=Vodka")
    suspend fun getCocktails() : CocktailResponse
}
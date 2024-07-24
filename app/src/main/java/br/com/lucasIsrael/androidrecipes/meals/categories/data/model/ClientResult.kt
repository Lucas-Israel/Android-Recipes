package br.com.lucasIsrael.androidrecipes.meals.categories.data.model

sealed class ClientResult<out T> {

    /**
     * Creates a new response object for a successful response
     * @param data the response data.
     */
    data class ClientSuccess<T>(val data: T) : ClientResult<T>()

    /**
     * Exception when the service response results in error
     * @param errorCode the code received from a failed request
     * @param errorMessage the message received from a failed request
     */
    data class ClientError(val errorCode: Int, val errorMessage: String) : ClientResult<Nothing>()
}
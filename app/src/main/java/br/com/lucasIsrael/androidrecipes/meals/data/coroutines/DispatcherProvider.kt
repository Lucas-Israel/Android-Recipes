package br.com.lucasIsrael.androidrecipes.meals.data.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object DispatcherProvider { val IO: CoroutineContext = Dispatchers.IO }
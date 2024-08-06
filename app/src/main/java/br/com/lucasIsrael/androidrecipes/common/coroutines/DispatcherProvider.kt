package br.com.lucasIsrael.androidrecipes.common.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object DispatcherProvider { val IO: CoroutineContext = Dispatchers.IO }

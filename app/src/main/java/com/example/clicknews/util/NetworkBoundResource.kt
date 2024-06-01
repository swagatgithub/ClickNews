package com.example.clicknews.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun <ResultType , RequestType> netWorkBoundResource(
    query : () -> Flow<ResultType> ,
    fetch : suspend () -> RequestType ,
    saveFetchResult : suspend (RequestType) -> Unit ,
    shouldFetch : (ResultType) -> Boolean = {true}
) = channelFlow<Int> {
    kotlinx.coroutines.delay(200)
}



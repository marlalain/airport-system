package com.pauloelienay.customerservice.extensions

import org.slf4j.LoggerFactory

inline fun <reified T : Any> logger() = LoggerFactory.getLogger(T::class.java)!!
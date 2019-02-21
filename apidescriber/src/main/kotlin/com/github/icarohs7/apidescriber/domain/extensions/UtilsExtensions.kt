package com.github.icarohs7.apidescriber.domain.extensions

/**
 * Return the value if it's not null
 * or the default otherwise
 */
fun <T : Any> T?.valueOr(default: T): T = this ?: default
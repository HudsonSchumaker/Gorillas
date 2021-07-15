package br.com.schumaker.gorillas.common

import java.time.LocalDateTime

/**
 * @author Hudson Schumaker
 */
data class ErrorView(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)

package br.com.schumaker.gorillas.user.exception

import graphql.ErrorClassification
import graphql.ErrorType
import graphql.GraphQLError
import graphql.language.SourceLocation

/**
 * @author Hudson Schumaker
 */
class AuthenticationException: GraphQLError {
    override fun getMessage(): String {
        return "Wrong user name and/or password"
    }

    override fun getLocations(): MutableList<SourceLocation>? {
        return null
    }

    override fun getErrorType(): ErrorClassification {
        return ErrorType.ValidationError
    }
}

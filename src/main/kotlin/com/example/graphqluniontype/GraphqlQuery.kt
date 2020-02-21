package com.example.graphqluniontype

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class GraphqlQuery : GraphQLQueryResolver {

    fun animals() = listOf(Cat("Tom", Size(10, 15)), Mouse("Jerry", Size(1, 2)))
}

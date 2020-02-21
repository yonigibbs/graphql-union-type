package com.example.graphqluniontype

import com.graphql.spring.boot.test.GraphQLTestTemplate
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GraphqlUnionTypeApplicationTests(@Autowired private val client : GraphQLTestTemplate) {

    @Test
    fun `gets size data for cats and mice`() {
        val response = client.postForResource("request.graphql")
        assertNotNull(response)
        val errorMessage = try{
            response.get("errors[0].message").toString()
        } catch (e: Exception) {
            // Ignore - means no errors occurred
            null
        }

        if (errorMessage != null)
            error(errorMessage)

        val firstName = response.get("$.data.animals[0].name")
        assertEquals("Tom", firstName)
    }
}

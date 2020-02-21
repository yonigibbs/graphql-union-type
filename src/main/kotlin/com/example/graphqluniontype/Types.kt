package com.example.graphqluniontype

import com.coxautodev.graphql.tools.SchemaParserDictionary
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Types {

    @Bean
    fun parserDictionary(): SchemaParserDictionary = SchemaParserDictionary().add(
        mapOf(
            "Cat" to Cat::class.java,
            "Mouse" to Mouse::class.java
        )
    )
}

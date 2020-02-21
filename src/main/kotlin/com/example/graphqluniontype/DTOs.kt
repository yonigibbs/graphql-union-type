package com.example.graphqluniontype

data class Size(val height: Int, val weight: Int)

interface Animal {
    val name: String
}

// TODO: To make test work, change `Size?` to `Size` below
data class Mouse(override val name: String, val size: Size?) : Animal

data class Cat(override val name: String, val size: Size) : Animal

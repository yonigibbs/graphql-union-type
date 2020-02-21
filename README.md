# graphql-union-type
Repro for this issue: https://github.com/graphql-java-kickstart/graphql-spring-boot/issues/347

To replicate, simply run `./gradlew test`. There is a single unit test which will fail with this error:

```
Validation error of type FieldsConflict: size: fields have different nullability shapes @ 'animals'
```

This is caused by the existence of a union type with two types in it which share a common field,
where that field has different nullability on each type, as shown below:

```
type Size {
    height: Int!
    weight: Int!
}

type Cat {
    name: String!
    size: Size!         # `size` is REQUIRED on `Cat`
}

type Mouse {
    name: String!
    size: Size         # `size` is OPTIONAL on `Mouse`
}
```

If the nullability is the same on both, this is avoided. Search for the two `TODO`s in the code to
see what to change to make the unit test pass.

samples for [blog post](https://blog.pchudzik.com/201701/spock-groups/)

Spock tests grouping using junit @Category example.

To run execute all tests:

```./gradlew test```

When no test is defined to be included all will be executed

To run all tests excluding database tests
```./gradlew test -Dgroups=-db```

To run only database tests
```./gradle test -Dgroups=db```

Available test groups:
```
fast - fast tests
slow - slow tests
it   - integration tests
db   - database tests
```

It's possible to mix includes and excludes:
```./gradlew test -Dgroups=slow,-db```

More examples on my blog - https://blog.pchudzik.com/201701/spock-groups/

# Restaurant App

This is a project to test your SQL and Java skills.  You will be parsing a csv file, writing some logic, reading a SQL database (H2) schema, and writing some SQL.


## CSVRestaurantService


1. Implement parse

2. Implement getOpenRestaurants(final DayOfWeek dayOfWeek, final LocalTime localTime)


## SQLRestaurantService

Schema: src/main/resource/schema.sql
Data:   src/main/resource/data.sql

1. Implement getOpen
2. Implement getRestaurantsWithMenuOfSizeGreaterThanOrEqualTo

## JooqRestaurantService (Bonus)

As a bonus you can show your skills with learning a new libary.

Jooq (https://www.jooq.org) is a Java library that makes writing SQL easier.
You will re-implement the methods in SQLRestaurantService, but using the Jooq DSL.

1. Implement getOpen
2. Implement getRestaurantsWithMenuOfSizeGreaterThanOrEqualTo

## Testing



## Submitting your solution

Make a zip file with your solution and email it for evaluation.

```
git archive -o latest.zip HEAD
```


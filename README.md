# Minimum Spring 3 MVC Example

Want to build a Spring 3 MVC webapp that connects to a database? Here's a bare-minimum example!

## Purpose

I've been trying to bone up on Java EE web development. The JAX-RS-like interface that Spring offers is very compelling. That plus Spring's DI framework being an industry standard, it felt right. And actually getting a web app up and running (pure routing and HTML) was pretty easy. But when it came to adding persistence, I got really lost.

I tried following a bunch of tutorials. I tried using some Maven archetypes to generate the "perfect" setup for me. Unfortunately, for me, almost none of what is out there worked for me. Java IDEs also have conflicting styles, many times generated out-date code and obfuscate what is actually underneath doing the work.

So I set out to build a simple web app that did things right being informed by "good" Java EE development standards. Spring/Spring MVC for the the web and DI. JPA-based persistence using Eclipselink since I only wanted simplest method for connecting to and querying the database.

The Maven config also includes a plugin to run a jetty server of the app. One of the other things that complicated my learning process was I was trying to deploy to JBoss EAP 6, which makes some more assumptions about your setup (JTA data sources, class loading changes, at odds with my IDE and it's method of packaging).

## Running

Dependencies not managed:

* Maven
* PostgreSQL

The schema:

    CREATE TABLE words (
        id integer NOT NULL,
        value character varying(255),
        count integer DEFAULT 0,
        classification character varying(255) DEFAULT 'unclassified'::character varying
    );

    CREATE SEQUENCE words_id_seq
        START WITH 1
        INCREMENT BY 1
        NO MINVALUE
        NO MAXVALUE
        CACHE 1;
    
    ALTER SEQUENCE words_id_seq OWNED BY words.id;

Run with:

    $ mvn package jetty:start

And connect on http://localhost:8080

## TODO

I'm thinking I'll probably code the "real version" of this app using Spring Data JPA because I'm liking what I'm seeing using [CrudRepository](http://static.springsource.org/spring-data/data-jpa/docs/current/reference/html/#repositories.core-concepts)

## LICENSE

Copyright © 2012 Ryan Briones <ryan.briones@brionesandco.com>. "Minimum Spring 3 MVC Example" source distributed under the MIT License. See LICENSE for details. 
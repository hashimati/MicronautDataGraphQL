package com.mygroup.countrygraphql.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import com.coxautodev.graphql.tools.SchemaParserBuilder;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class CountryFactory {



    @Bean
    @Singleton
    public GraphQL graphQL(CountryQueryResolver resolver)
    {
        SchemaParserBuilder builder = SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(resolver);

        GraphQLSchema graphQLSchema = builder.build().makeExecutableSchema();
        return GraphQL.newGraphQL(graphQLSchema).build();

    }
}

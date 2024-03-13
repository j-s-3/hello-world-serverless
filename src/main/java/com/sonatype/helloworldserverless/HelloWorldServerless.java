package com.sonatype.helloworldserverless;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloWorldServerless
{
  public static void main(String[] args) {
    SpringApplication.run(HelloWorldServerless.class, args);
  }

  @Bean
  public Function<String, String> uppercase() {
    return String::toUpperCase;
  }
}

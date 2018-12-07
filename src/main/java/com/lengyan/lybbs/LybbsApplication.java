package com.lengyan.lybbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LybbsApplication {

  public static void main(String[] args) {
    SpringApplication.run(LybbsApplication.class, args);
  }
}

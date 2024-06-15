package io.reactive.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class LazyStream {
    public static final Logger log = LoggerFactory.getLogger(LazyStream.class);

    public static void main(String[] args) {
        /*
        Java Stream is lazy by default, it will not execute
        since there is no terminal command in first statement
         */
        Stream.of(1)
                .peek(i -> log.info("received : {}", i));

        Stream.of(2)
                .peek(i -> log.info("received : {}", i))
                .toArray();
    }
}

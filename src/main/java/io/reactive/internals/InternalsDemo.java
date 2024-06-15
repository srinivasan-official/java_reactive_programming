package io.reactive.internals;

import io.reactive.internals.publisher.PublisherImpl;
import io.reactive.internals.subscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class InternalsDemo {
    public static void main(String[] args) throws InterruptedException {
//        demo1(); //Should not do anything since we haven't requested
//        demo2(); // Getting items in batches
//        demo3(); // Subscriber can cancel the request
//        demo4(); // Producer can send error signals
    }

    public static void demo1() {
        Publisher<String> publisher = new PublisherImpl();
        Subscriber<String> subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    public static void demo2() throws InterruptedException {
        Publisher<String> publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
    }

    public static void demo3() throws InterruptedException {
        Publisher<String> publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
    }

    public static void demo4() throws InterruptedException {
        Publisher<String> publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(11);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
    }
}

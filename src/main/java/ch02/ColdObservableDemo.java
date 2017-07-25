package ch02;

import io.reactivex.Observable;

/**
 * Created by Fahim on 25-Jul-17.
 */
public class ColdObservableDemo {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        // First observer
        source.subscribe(s -> System.out.println("Observer 1 Received " + s));

        source = source.map(s -> s.substring(0, 3));

        // Second observer
        source.subscribe(s -> System.out.println("Observer 2 Received: " + s));
    }
}

package ch02;

import io.reactivex.Observable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fahim on 24-Jul-17.
 */
public class Launcher {
  public static void main(String[] args) {
    Observable<String> source = Observable.create(emitter -> {
      try {
        emitter.onNext("Alpha");
        emitter.onNext("Beta");
        emitter.onNext("Gamma");
        emitter.onNext("Delta");
        emitter.onNext("Epsilon");
        //emitter.onNext(null);     // Null values are generally not allowed in 2.x operators and sources
        emitter.onComplete();
      } catch (Exception e) {
        emitter.onError(e);
      }
    });

    //source.subscribe(s -> System.out.println("Received: " + s), Throwable::printStackTrace);
    source.map(String::length)
        .filter(i -> i >= 5)
        .subscribe(integer -> System.out.println("Length: " + integer));

    // Using just()
    Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
    observable.map(String::length)
        .filter(i -> i >= 5)
        .subscribe(integer -> System.out.println("Length: " + integer));

    // Using fromIterable()
    List<String> items = Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
    Observable<String> itemObservable = Observable.fromIterable(items);
    itemObservable.map(String::length)
        .filter(i -> i >= 5)
        .subscribe(integer -> System.out.println("Length: " + integer));
  }
}

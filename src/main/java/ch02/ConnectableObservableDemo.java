package ch02;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

/**
 * Created by Fahim on 25-Jul-17.
 */
public class ConnectableObservableDemo {
  public static void main(String[] args) {
    ConnectableObservable<String> source =
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").publish();

    // Set up observer 1
    source.subscribe(s -> {
      System.out.println("Observer 1 = " + s);
    });

    // Set up observer 2
    source.map(String::toUpperCase)
        .subscribe(s -> {
          System.out.println("Observer 2 = " + s.length());
        });

    source.connect();
  }

  private static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

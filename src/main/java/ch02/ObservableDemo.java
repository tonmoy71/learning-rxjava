package ch02;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fahim on 25-Jul-17.
 */
public class ObservableDemo {

  public static final int INTERVAL_MILLIS = 5000;

  public static void main(String[] args) {
    //actAsColdObservable();

    actAsHotObservable();
  }

  private static void actAsHotObservable() {
    System.out.println("Using Hot Observable...");

    ConnectableObservable<Long> secondsHot = Observable.interval(1, TimeUnit.SECONDS).publish();

    // Observer 1
    secondsHot.subscribe(aLong -> System.out.println("Observer 1: " + aLong));
    secondsHot.connect();

    sleep(INTERVAL_MILLIS);

    // Observer 2
    secondsHot.subscribe(aLong -> System.out.println("Observer 2:  " + aLong));

    sleep(INTERVAL_MILLIS);
  }

  private static void actAsColdObservable() {
    Observable<Long> secondsCold = Observable.interval(1, TimeUnit.SECONDS);
    System.out.println("Using Cold Observable...");

    // Observer 1
    secondsCold.subscribe(aLong -> System.out.println("Observer 1: " + aLong));

    sleep(INTERVAL_MILLIS);

    // Observer 2
    secondsCold.subscribe(aLong -> System.out.println("Observer 2: " + aLong));

    sleep(INTERVAL_MILLIS);
  }

  private static void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

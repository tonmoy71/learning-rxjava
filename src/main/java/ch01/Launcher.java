package ch01;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fahim on 24-Jul-17.
 */

public class Launcher {
  public static void main(String[] args) {
    Observable<String> myStrings =
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
    // myStrings.subscribe(s -> System.out.println(s));

    Observable<Long> secondIntervals = Observable.interval(1, TimeUnit.SECONDS);
    secondIntervals
        .subscribe(aLong -> System.out.println(aLong));

        /* Hold main thread for 5 seconds
         * So, observable above has chance to fire */
    sleep(5000);
  }

  private static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

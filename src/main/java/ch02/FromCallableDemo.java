package ch02;

import io.reactivex.Observable;

/**
 * Created by Fahim on 25-Jul-17.
 */
public class FromCallableDemo {
  public static void main(String[] args) {

    /*  Will cause Exception, unhandled
        Observable.just(1 / 0)
                .subscribe(System.out::println, throwable -> System.out.println("Error captured = " + throwable));
    */

    Observable.fromCallable(() -> 1 / 0)
        .subscribe(integer -> System.out.println("Received integer = " + integer),
            throwable -> System.out.println("Error captured = " + throwable));
  }
}

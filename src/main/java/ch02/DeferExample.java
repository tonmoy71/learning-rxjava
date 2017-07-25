package ch02;

import io.reactivex.Observable;

/**
 * Created by Fahim on 25-Jul-17.
 */
public class DeferExample {
    private static int start = 1;
    private static int count = 5;

    public static void main(String[] args) {
        Observable<Integer> source = Observable.defer(() -> Observable.range(start, count));

        // Observer 1
        source.subscribe(integer -> System.out.println("Observer 1 = " + integer));

        // Modification
        start = 99;
        count = 10;
        System.out.println("Modifying the source observable");

        // Observer 2
        source.subscribe(integer -> System.out.println("Observer 2 = " + integer));

    }
}

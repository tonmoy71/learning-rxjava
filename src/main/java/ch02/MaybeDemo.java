package ch02;

import io.reactivex.Maybe;

/**
 * Created by Fahim on 25-Jul-17.
 */
public class MaybeDemo {
    public static void main(String[] args) {
        // Has emission
        Maybe<Integer> presentSource = Maybe.just(4);

        presentSource.subscribe(integer -> System.out.println("Observer 1 received: " + integer),
                throwable -> System.out.println("Error = " + throwable),
                () -> System.out.println("Observer 1 done!"));      // For a single item emission, onComplete() will not be invoked

        // No emission
        Maybe<Integer> emptySource = Maybe.empty();

        emptySource.subscribe(integer -> System.out.println("Observer 2 received: " + integer),
                throwable -> System.out.println("Error = " + throwable),
                () -> System.out.println("Observer 2 done!"));



    }
}

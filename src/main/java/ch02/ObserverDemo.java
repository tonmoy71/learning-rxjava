package ch02;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by Fahim on 25-Jul-17.
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        System.out.println("Using anonymous inner class");
        Observer<Integer> myObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Received " + integer);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done!");
            }
        };

        observable.map(String::length)
                .filter(i -> i >= 5)
                .subscribe(myObserver);

        // Using lambdas
        System.out.println("Using lambdas...");
        Consumer<Integer> onNext = i -> System.out.println("Received: " + i);

        Action onComplete = () -> System.out.println("Done");

        Consumer<Throwable> onError = Throwable::printStackTrace;

        observable.map(String::length)
                .filter(i -> i >= 2)
                .subscribe(onNext, onError, onComplete);
    }


}

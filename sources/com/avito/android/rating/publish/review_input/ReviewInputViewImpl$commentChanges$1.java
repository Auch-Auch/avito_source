package com.avito.android.rating.publish.review_input;

import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
public final class ReviewInputViewImpl$commentChanges$1<T> implements ObservableOnSubscribe<String> {
    public final /* synthetic */ ReviewInputViewImpl a;

    public static final class a implements Cancellable {
        public final /* synthetic */ ReviewInputViewImpl$commentChanges$1 a;
        public final /* synthetic */ ReviewInputViewImpl$commentChanges$1$watcher$1 b;

        public a(ReviewInputViewImpl$commentChanges$1 reviewInputViewImpl$commentChanges$1, ReviewInputViewImpl$commentChanges$1$watcher$1 reviewInputViewImpl$commentChanges$1$watcher$1) {
            this.a = reviewInputViewImpl$commentChanges$1;
            this.b = reviewInputViewImpl$commentChanges$1$watcher$1;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.a.b.removeTextChangedListener(this.b);
        }
    }

    public ReviewInputViewImpl$commentChanges$1(ReviewInputViewImpl reviewInputViewImpl) {
        this.a = reviewInputViewImpl;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<String> observableEmitter) {
        ReviewInputViewImpl$commentChanges$1$watcher$1 reviewInputViewImpl$commentChanges$1$watcher$1 = new ReviewInputViewImpl$commentChanges$1$watcher$1(observableEmitter);
        this.a.b.addTextChangedListener(reviewInputViewImpl$commentChanges$1$watcher$1);
        observableEmitter.setCancellable(new a(this, reviewInputViewImpl$commentChanges$1$watcher$1));
    }
}

package a2.k.a.f;

import android.widget.RatingBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class n extends InitialValueObservable<Float> {
    public final RatingBar a;

    public static final class a extends MainThreadDisposable implements RatingBar.OnRatingBarChangeListener {
        public final RatingBar b;
        public final Observer<? super Float> c;

        public a(@NotNull RatingBar ratingBar, @NotNull Observer<? super Float> observer) {
            Intrinsics.checkParameterIsNotNull(ratingBar, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = ratingBar;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnRatingBarChangeListener(null);
        }

        @Override // android.widget.RatingBar.OnRatingBarChangeListener
        public void onRatingChanged(@NotNull RatingBar ratingBar, float f, boolean z) {
            Intrinsics.checkParameterIsNotNull(ratingBar, "ratingBar");
            if (!isDisposed()) {
                this.c.onNext(Float.valueOf(f));
            }
        }
    }

    public n(@NotNull RatingBar ratingBar) {
        Intrinsics.checkParameterIsNotNull(ratingBar, "view");
        this.a = ratingBar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public Float getInitialValue() {
        return Float.valueOf(this.a.getRating());
    }

    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super Float> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            this.a.setOnRatingBarChangeListener(aVar);
            observer.onSubscribe(aVar);
        }
    }
}

package a2.k.a.d;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@RequiresApi(16)
public final class r extends Observable<Unit> {
    public final View a;

    public static final class a extends MainThreadDisposable implements ViewTreeObserver.OnDrawListener {
        public final View b;
        public final Observer<? super Unit> c;

        public a(@NotNull View view, @NotNull Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            if (!isDisposed()) {
                this.c.onNext(Unit.INSTANCE);
            }
        }
    }

    public r(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.a = view;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.getViewTreeObserver().addOnDrawListener(aVar);
        }
    }
}

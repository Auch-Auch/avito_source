package a2.k.a.d;

import android.view.View;
import android.view.ViewTreeObserver;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class t extends Observable<Unit> {
    public final View a;
    public final Function0<Boolean> b;

    public static final class a extends MainThreadDisposable implements ViewTreeObserver.OnPreDrawListener {
        public final View b;
        public final Function0<Boolean> c;
        public final Observer<? super Unit> d;

        public a(@NotNull View view, @NotNull Function0<Boolean> function0, @NotNull Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(function0, "proceedDrawingPass");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = function0;
            this.d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (isDisposed()) {
                return true;
            }
            this.d.onNext(Unit.INSTANCE);
            try {
                return this.c.invoke().booleanValue();
            } catch (Exception e) {
                this.d.onError(e);
                dispose();
                return true;
            }
        }
    }

    public t(@NotNull View view, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(function0, "proceedDrawingPass");
        this.a = view;
        this.b = function0;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, this.b, observer);
            observer.onSubscribe(aVar);
            this.a.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }
}

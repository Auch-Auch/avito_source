package a2.k.b.d;

import android.view.MotionEvent;
import android.view.View;
import com.jakewharton.rxbinding4.internal.Preconditions;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class q extends Observable<MotionEvent> {
    public final View a;
    public final Function1<MotionEvent, Boolean> b;

    public static final class a extends MainThreadDisposable implements View.OnTouchListener {
        public final View b;
        public final Function1<MotionEvent, Boolean> c;
        public final Observer<? super MotionEvent> d;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super android.view.MotionEvent, java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull View view, @NotNull Function1<? super MotionEvent, Boolean> function1, @NotNull Observer<? super MotionEvent> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(function1, "handled");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = function1;
            this.d = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnTouchListener(null);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View view, @NotNull MotionEvent motionEvent) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            Intrinsics.checkParameterIsNotNull(motionEvent, "event");
            if (isDisposed()) {
                return false;
            }
            try {
                if (!this.c.invoke(motionEvent).booleanValue()) {
                    return false;
                }
                this.d.onNext(motionEvent);
                return true;
            } catch (Exception e) {
                this.d.onError(e);
                dispose();
                return false;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super android.view.MotionEvent, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public q(@NotNull View view, @NotNull Function1<? super MotionEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        this.a = view;
        this.b = function1;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super MotionEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, this.b, observer);
            observer.onSubscribe(aVar);
            this.a.setOnTouchListener(aVar);
        }
    }
}

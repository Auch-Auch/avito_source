package a2.k.b.d;

import android.view.KeyEvent;
import android.view.View;
import com.jakewharton.rxbinding4.internal.Preconditions;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class k extends Observable<KeyEvent> {
    public final View a;
    public final Function1<KeyEvent, Boolean> b;

    public static final class a extends MainThreadDisposable implements View.OnKeyListener {
        public final View b;
        public final Function1<KeyEvent, Boolean> c;
        public final Observer<? super KeyEvent> d;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super android.view.KeyEvent, java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull View view, @NotNull Function1<? super KeyEvent, Boolean> function1, @NotNull Observer<? super KeyEvent> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(function1, "handled");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = function1;
            this.d = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnKeyListener(null);
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(@NotNull View view, int i, @NotNull KeyEvent keyEvent) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            Intrinsics.checkParameterIsNotNull(keyEvent, "event");
            if (isDisposed()) {
                return false;
            }
            try {
                if (!this.c.invoke(keyEvent).booleanValue()) {
                    return false;
                }
                this.d.onNext(keyEvent);
                return true;
            } catch (Exception e) {
                this.d.onError(e);
                dispose();
                return false;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super android.view.KeyEvent, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public k(@NotNull View view, @NotNull Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        this.a = view;
        this.b = function1;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super KeyEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, this.b, observer);
            observer.onSubscribe(aVar);
            this.a.setOnKeyListener(aVar);
        }
    }
}

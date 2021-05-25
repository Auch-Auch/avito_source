package a2.k.b.f;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class x extends Observable<Integer> {
    public final TextView a;
    public final Function1<Integer, Boolean> b;

    public static final class a extends MainThreadDisposable implements TextView.OnEditorActionListener {
        public final TextView b;
        public final Observer<? super Integer> c;
        public final Function1<Integer, Boolean> d;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull TextView textView, @NotNull Observer<? super Integer> observer, @NotNull Function1<? super Integer, Boolean> function1) {
            Intrinsics.checkParameterIsNotNull(textView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            Intrinsics.checkParameterIsNotNull(function1, "handled");
            this.b = textView;
            this.c = observer;
            this.d = function1;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnEditorActionListener(null);
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(@NotNull TextView textView, int i, @Nullable KeyEvent keyEvent) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            try {
                if (isDisposed() || !this.d.invoke(Integer.valueOf(i)).booleanValue()) {
                    return false;
                }
                this.c.onNext(Integer.valueOf(i));
                return true;
            } catch (Exception e) {
                this.c.onError(e);
                dispose();
                return false;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public x(@NotNull TextView textView, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        this.a = textView;
        this.b = function1;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer, this.b);
            observer.onSubscribe(aVar);
            this.a.setOnEditorActionListener(aVar);
        }
    }
}

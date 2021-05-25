package a2.k.a.d;

import android.view.View;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class n extends Observable<Unit> {
    public final View a;
    public final Function0<Boolean> b;

    public static final class a extends MainThreadDisposable implements View.OnLongClickListener {
        public final View b;
        public final Function0<Boolean> c;
        public final Observer<? super Unit> d;

        public a(@NotNull View view, @NotNull Function0<Boolean> function0, @NotNull Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(function0, "handled");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = function0;
            this.d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnLongClickListener(null);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            if (isDisposed()) {
                return false;
            }
            try {
                if (!this.c.invoke().booleanValue()) {
                    return false;
                }
                this.d.onNext(Unit.INSTANCE);
                return true;
            } catch (Exception e) {
                this.d.onError(e);
                dispose();
                return false;
            }
        }
    }

    public n(@NotNull View view, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(function0, "handled");
        this.a = view;
        this.b = function0;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, this.b, observer);
            observer.onSubscribe(aVar);
            this.a.setOnLongClickListener(aVar);
        }
    }
}

package a2.k.a.d;

import android.view.View;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class e extends Observable<Unit> {
    public final View a;
    public final boolean b;

    public static final class a extends MainThreadDisposable implements View.OnAttachStateChangeListener {
        public final View b;
        public final boolean c;
        public final Observer<? super Unit> d;

        public a(@NotNull View view, boolean z, @NotNull Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = z;
            this.d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            if (this.c && !isDisposed()) {
                this.d.onNext(Unit.INSTANCE);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            if (!this.c && !isDisposed()) {
                this.d.onNext(Unit.INSTANCE);
            }
        }
    }

    public e(@NotNull View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.a = view;
        this.b = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, this.b, observer);
            observer.onSubscribe(aVar);
            this.a.addOnAttachStateChangeListener(aVar);
        }
    }
}

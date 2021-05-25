package a2.k.a.d;

import android.view.View;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.view.ViewAttachAttachedEvent;
import com.jakewharton.rxbinding3.view.ViewAttachDetachedEvent;
import com.jakewharton.rxbinding3.view.ViewAttachEvent;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class d extends Observable<ViewAttachEvent> {
    public final View a;

    public static final class a extends MainThreadDisposable implements View.OnAttachStateChangeListener {
        public final View b;
        public final Observer<? super ViewAttachEvent> c;

        public a(@NotNull View view, @NotNull Observer<? super ViewAttachEvent> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            if (!isDisposed()) {
                this.c.onNext(new ViewAttachAttachedEvent(this.b));
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            if (!isDisposed()) {
                this.c.onNext(new ViewAttachDetachedEvent(this.b));
            }
        }
    }

    public d(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.a = view;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super ViewAttachEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.addOnAttachStateChangeListener(aVar);
        }
    }
}

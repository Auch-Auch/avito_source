package a2.k.b.d;

import android.view.View;
import com.jakewharton.rxbinding4.internal.Preconditions;
import com.jakewharton.rxbinding4.view.ViewLayoutChangeEvent;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class l extends Observable<ViewLayoutChangeEvent> {
    public final View a;

    public static final class a extends MainThreadDisposable implements View.OnLayoutChangeListener {
        public final View b;
        public final Observer<? super ViewLayoutChangeEvent> c;

        public a(@NotNull View view, @NotNull Observer<? super ViewLayoutChangeEvent> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.removeOnLayoutChangeListener(this);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            if (!isDisposed()) {
                this.c.onNext(new ViewLayoutChangeEvent(view, i, i2, i3, i4, i5, i6, i7, i8));
            }
        }
    }

    public l(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.a = view;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super ViewLayoutChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.addOnLayoutChangeListener(aVar);
        }
    }
}

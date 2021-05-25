package a2.k.b.d;

import android.view.View;
import com.jakewharton.rxbinding4.internal.Preconditions;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class f extends Observable<Unit> {
    public final View a;

    public static final class a extends MainThreadDisposable implements View.OnClickListener {
        public final View b;
        public final Observer<? super Unit> c;

        public a(@NotNull View view, @NotNull Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = observer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            if (!isDisposed()) {
                this.c.onNext(Unit.INSTANCE);
            }
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnClickListener(null);
        }
    }

    public f(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.a = view;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnClickListener(aVar);
        }
    }
}

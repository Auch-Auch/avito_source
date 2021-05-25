package a2.k.a.d;

import android.view.View;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.view.ViewScrollChangeEvent;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@RequiresApi(23)
public final class o extends Observable<ViewScrollChangeEvent> {
    public final View a;

    public static final class a extends MainThreadDisposable implements View.OnScrollChangeListener {
        public final View b;
        public final Observer<? super ViewScrollChangeEvent> c;

        public a(@NotNull View view, @NotNull Observer<? super ViewScrollChangeEvent> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnScrollChangeListener(null);
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(@NotNull View view, int i, int i2, int i3, int i4) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            if (!isDisposed()) {
                this.c.onNext(new ViewScrollChangeEvent(view, i, i2, i3, i4));
            }
        }
    }

    public o(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.a = view;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super ViewScrollChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnScrollChangeListener(aVar);
        }
    }
}

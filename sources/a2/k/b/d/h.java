package a2.k.b.d;

import android.view.View;
import com.jakewharton.rxbinding4.InitialValueObservable;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class h extends InitialValueObservable<Boolean> {
    public final View a;

    public static final class a extends MainThreadDisposable implements View.OnFocusChangeListener {
        public final View b;
        public final Observer<? super Boolean> c;

        public a(@NotNull View view, @NotNull Observer<? super Boolean> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnFocusChangeListener(null);
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(@NotNull View view, boolean z) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            if (!isDisposed()) {
                this.c.onNext(Boolean.valueOf(z));
            }
        }
    }

    public h(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.a = view;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public Boolean getInitialValue() {
        return Boolean.valueOf(this.a.hasFocus());
    }

    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super Boolean> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        a aVar = new a(this.a, observer);
        observer.onSubscribe(aVar);
        this.a.setOnFocusChangeListener(aVar);
    }
}

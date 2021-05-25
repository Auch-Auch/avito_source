package a2.k.a.f;

import android.widget.CompoundButton;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class i extends InitialValueObservable<Boolean> {
    public final CompoundButton a;

    public static final class a extends MainThreadDisposable implements CompoundButton.OnCheckedChangeListener {
        public final CompoundButton b;
        public final Observer<? super Boolean> c;

        public a(@NotNull CompoundButton compoundButton, @NotNull Observer<? super Boolean> observer) {
            Intrinsics.checkParameterIsNotNull(compoundButton, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = compoundButton;
            this.c = observer;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(@NotNull CompoundButton compoundButton, boolean z) {
            Intrinsics.checkParameterIsNotNull(compoundButton, "compoundButton");
            if (!isDisposed()) {
                this.c.onNext(Boolean.valueOf(z));
            }
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnCheckedChangeListener(null);
        }
    }

    public i(@NotNull CompoundButton compoundButton) {
        Intrinsics.checkParameterIsNotNull(compoundButton, "view");
        this.a = compoundButton;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public Boolean getInitialValue() {
        return Boolean.valueOf(this.a.isChecked());
    }

    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super Boolean> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnCheckedChangeListener(aVar);
        }
    }
}

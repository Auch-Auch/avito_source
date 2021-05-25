package a2.k.b.f;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding4.InitialValueObservable;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class f extends InitialValueObservable<Integer> {
    public final AdapterView<?> a;

    public static final class a extends MainThreadDisposable implements AdapterView.OnItemSelectedListener {
        public final AdapterView<?> b;
        public final Observer<? super Integer> c;

        public a(@NotNull AdapterView<?> adapterView, @NotNull Observer<? super Integer> observer) {
            Intrinsics.checkParameterIsNotNull(adapterView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = adapterView;
            this.c = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnItemSelectedListener(null);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@NotNull AdapterView<?> adapterView, @Nullable View view, int i, long j) {
            Intrinsics.checkParameterIsNotNull(adapterView, "adapterView");
            if (!isDisposed()) {
                this.c.onNext(Integer.valueOf(i));
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@NotNull AdapterView<?> adapterView) {
            Intrinsics.checkParameterIsNotNull(adapterView, "adapterView");
            if (!isDisposed()) {
                this.c.onNext(-1);
            }
        }
    }

    public f(@NotNull AdapterView<?> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        this.a = adapterView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public Integer getInitialValue() {
        return Integer.valueOf(this.a.getSelectedItemPosition());
    }

    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            this.a.setOnItemSelectedListener(aVar);
            observer.onSubscribe(aVar);
        }
    }
}

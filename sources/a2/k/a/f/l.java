package a2.k.a.f;

import android.widget.RadioGroup;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class l extends InitialValueObservable<Integer> {
    public final RadioGroup a;

    public static final class a extends MainThreadDisposable implements RadioGroup.OnCheckedChangeListener {
        public int b = -1;
        public final RadioGroup c;
        public final Observer<? super Integer> d;

        public a(@NotNull RadioGroup radioGroup, @NotNull Observer<? super Integer> observer) {
            Intrinsics.checkParameterIsNotNull(radioGroup, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.c = radioGroup;
            this.d = observer;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(@NotNull RadioGroup radioGroup, int i) {
            Intrinsics.checkParameterIsNotNull(radioGroup, "radioGroup");
            if (!isDisposed() && i != this.b) {
                this.b = i;
                this.d.onNext(Integer.valueOf(i));
            }
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.c.setOnCheckedChangeListener(null);
        }
    }

    public l(@NotNull RadioGroup radioGroup) {
        Intrinsics.checkParameterIsNotNull(radioGroup, "view");
        this.a = radioGroup;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public Integer getInitialValue() {
        return Integer.valueOf(this.a.getCheckedRadioButtonId());
    }

    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            this.a.setOnCheckedChangeListener(aVar);
            observer.onSubscribe(aVar);
        }
    }
}

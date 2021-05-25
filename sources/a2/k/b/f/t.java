package a2.k.b.f;

import android.widget.SeekBar;
import com.jakewharton.rxbinding4.InitialValueObservable;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class t extends InitialValueObservable<Integer> {
    public final SeekBar a;
    public final Boolean b;

    public static final class a extends MainThreadDisposable implements SeekBar.OnSeekBarChangeListener {
        public final SeekBar b;
        public final Boolean c;
        public final Observer<? super Integer> d;

        public a(@NotNull SeekBar seekBar, @Nullable Boolean bool, @NotNull Observer<? super Integer> observer) {
            Intrinsics.checkParameterIsNotNull(seekBar, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = seekBar;
            this.c = bool;
            this.d = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnSeekBarChangeListener(null);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@NotNull SeekBar seekBar, int i, boolean z) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
            if (!isDisposed()) {
                Boolean bool = this.c;
                if (bool == null || Intrinsics.areEqual(bool, Boolean.valueOf(z))) {
                    this.d.onNext(Integer.valueOf(i));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
        }
    }

    public t(@NotNull SeekBar seekBar, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        this.a = seekBar;
        this.b = bool;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public Integer getInitialValue() {
        return Integer.valueOf(this.a.getProgress());
    }

    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, this.b, observer);
            this.a.setOnSeekBarChangeListener(aVar);
            observer.onSubscribe(aVar);
        }
    }
}

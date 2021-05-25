package a2.k.a.f;

import android.widget.SeekBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.widget.SeekBarChangeEvent;
import com.jakewharton.rxbinding3.widget.SeekBarProgressChangeEvent;
import com.jakewharton.rxbinding3.widget.SeekBarStartChangeEvent;
import com.jakewharton.rxbinding3.widget.SeekBarStopChangeEvent;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class s extends InitialValueObservable<SeekBarChangeEvent> {
    public final SeekBar a;

    public static final class a extends MainThreadDisposable implements SeekBar.OnSeekBarChangeListener {
        public final SeekBar b;
        public final Observer<? super SeekBarChangeEvent> c;

        public a(@NotNull SeekBar seekBar, @NotNull Observer<? super SeekBarChangeEvent> observer) {
            Intrinsics.checkParameterIsNotNull(seekBar, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = seekBar;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnSeekBarChangeListener(null);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@NotNull SeekBar seekBar, int i, boolean z) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
            if (!isDisposed()) {
                this.c.onNext(new SeekBarProgressChangeEvent(seekBar, i, z));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
            if (!isDisposed()) {
                this.c.onNext(new SeekBarStartChangeEvent(seekBar));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
            if (!isDisposed()) {
                this.c.onNext(new SeekBarStopChangeEvent(seekBar));
            }
        }
    }

    public s(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        this.a = seekBar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public SeekBarChangeEvent getInitialValue() {
        SeekBar seekBar = this.a;
        return new SeekBarProgressChangeEvent(seekBar, seekBar.getProgress(), false);
    }

    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super SeekBarChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            this.a.setOnSeekBarChangeListener(aVar);
            observer.onSubscribe(aVar);
        }
    }
}

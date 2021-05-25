package com.avito.android.lib.design.input;

import android.text.Editable;
import android.text.TextWatcher;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxbinding4.InitialValueObservable;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class InputTextObservable3 extends InitialValueObservable<CharSequence> {
    public final Input a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/lib/design/input/InputTextObservable3$Listener;", "Lio/reactivex/rxjava3/android/MainThreadDisposable;", "Landroid/text/TextWatcher;", "", "s", "", Tracker.Events.CREATIVE_START, "count", "after", "", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "onDispose", "()V", "Lio/reactivex/rxjava3/core/Observer;", "c", "Lio/reactivex/rxjava3/core/Observer;", "observer", "Lcom/avito/android/lib/design/input/Input;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/input/Input;", "view", "<init>", "(Lcom/avito/android/lib/design/input/Input;Lio/reactivex/rxjava3/core/Observer;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Listener extends MainThreadDisposable implements TextWatcher {
        public final Input b;
        public final Observer<? super CharSequence> c;

        public Listener(@NotNull Input input, @NotNull Observer<? super CharSequence> observer) {
            Intrinsics.checkNotNullParameter(input, "view");
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.b = input;
            this.c = observer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "s");
            if (!isDisposed()) {
                this.c.onNext(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(charSequence, "s");
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.removeTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(charSequence, "s");
        }
    }

    public InputTextObservable3(@NotNull Input input) {
        Intrinsics.checkNotNullParameter(input, "view");
        this.a = input;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public CharSequence getInitialValue() {
        Editable text = this.a.m90getText();
        return text != null ? text : "";
    }

    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super CharSequence> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Listener listener = new Listener(this.a, observer);
        observer.onSubscribe(listener);
        this.a.addTextChangedListener(listener);
    }
}

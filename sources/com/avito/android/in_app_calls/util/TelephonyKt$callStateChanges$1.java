package com.avito.android.in_app_calls.util;

import android.telephony.TelephonyManager;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class TelephonyKt$callStateChanges$1<T> implements ObservableOnSubscribe<Integer> {
    public final /* synthetic */ TelephonyManager a;

    public static final class a implements Cancellable {
        public final /* synthetic */ TelephonyKt$callStateChanges$1 a;
        public final /* synthetic */ TelephonyKt$callStateChanges$1$listener$1 b;

        public a(TelephonyKt$callStateChanges$1 telephonyKt$callStateChanges$1, TelephonyKt$callStateChanges$1$listener$1 telephonyKt$callStateChanges$1$listener$1) {
            this.a = telephonyKt$callStateChanges$1;
            this.b = telephonyKt$callStateChanges$1$listener$1;
        }

        @Override // io.reactivex.functions.Cancellable
        public final void cancel() {
            this.a.a.listen(this.b, 0);
        }
    }

    public TelephonyKt$callStateChanges$1(TelephonyManager telephonyManager) {
        this.a = telephonyManager;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(@NotNull ObservableEmitter<Integer> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        TelephonyKt$callStateChanges$1$listener$1 telephonyKt$callStateChanges$1$listener$1 = new TelephonyKt$callStateChanges$1$listener$1(observableEmitter);
        try {
            this.a.listen(telephonyKt$callStateChanges$1$listener$1, 32);
            observableEmitter.setCancellable(new a(this, telephonyKt$callStateChanges$1$listener$1));
        } catch (Exception e) {
            if (!observableEmitter.isDisposed()) {
                observableEmitter.onError(e);
            }
        }
    }
}

package com.avito.android.in_app_calls.util;

import android.telephony.PhoneStateListener;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/avito/android/in_app_calls/util/TelephonyKt$callStateChanges$1$listener$1", "Landroid/telephony/PhoneStateListener;", "", "state", "", "phoneNumber", "", "onCallStateChanged", "(ILjava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class TelephonyKt$callStateChanges$1$listener$1 extends PhoneStateListener {
    public final /* synthetic */ ObservableEmitter a;

    public TelephonyKt$callStateChanges$1$listener$1(ObservableEmitter observableEmitter) {
        this.a = observableEmitter;
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, @Nullable String str) {
        ObservableEmitter observableEmitter = this.a;
        Intrinsics.checkNotNullExpressionValue(observableEmitter, "emitter");
        if (!observableEmitter.isDisposed()) {
            this.a.onNext(Integer.valueOf(i));
        }
    }
}

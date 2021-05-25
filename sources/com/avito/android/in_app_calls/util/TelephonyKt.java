package com.avito.android.in_app_calls.util;

import android.telephony.TelephonyManager;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/telephony/TelephonyManager;", "Lio/reactivex/Observable;", "", "callStateChanges", "(Landroid/telephony/TelephonyManager;)Lio/reactivex/Observable;", "in-app-calls_release"}, k = 2, mv = {1, 4, 2})
public final class TelephonyKt {
    @NotNull
    public static final Observable<Integer> callStateChanges(@NotNull TelephonyManager telephonyManager) {
        Intrinsics.checkNotNullParameter(telephonyManager, "$this$callStateChanges");
        Observable<Integer> create = Observable.create(new TelephonyKt$callStateChanges$1(telephonyManager));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…       }\n        }\n\n    }");
        return create;
    }
}

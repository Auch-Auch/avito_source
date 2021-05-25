package com.avito.android.payment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\r\u001a\u00020\t*\u00020\f¢\u0006\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0017\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010¨\u0006\u001a"}, d2 = {"Landroid/content/Context;", "context", "", AnalyticFieldsName.orderId, "Landroid/content/Intent;", "createSberbankOnlinePaymentIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "getSbolPaymentResult", "(Landroid/content/Intent;)Ljava/lang/String;", "", "isSuccess", "(Ljava/lang/String;)Z", "", "isVersionSupported", "(I)Z", "RESULT_SUCCESS", "Ljava/lang/String;", "Landroid/content/ComponentName;", AuthSource.SEND_ABUSE, "Landroid/content/ComponentName;", "getSberbankOnlineComponentName", "()Landroid/content/ComponentName;", "sberbankOnlineComponentName", "SBERBANK_ONLINE_MIN_VERSION_CODE", "I", "RESULT_FAILURE", "payment-core_release"}, k = 2, mv = {1, 4, 2})
public final class SberbankOnlineKt {
    @NotNull
    public static final String RESULT_FAILURE = "FAILURE";
    @NotNull
    public static final String RESULT_SUCCESS = "SUCCESS";
    public static final int SBERBANK_ONLINE_MIN_VERSION_CODE = 2018101200;
    @NotNull
    public static final ComponentName a = new ComponentName("ru.sberbankmobile", "ru.sberbank.mobile.external.InvoicingActivity");

    @NotNull
    public static final Intent createSberbankOnlinePaymentIntent(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Intent intent = new Intent();
        intent.setComponent(a);
        intent.putExtra("ru.sberbank.mobile.extra.EXTRA_ORDER_UUID", str);
        return intent;
    }

    @NotNull
    public static final ComponentName getSberbankOnlineComponentName() {
        return a;
    }

    @Nullable
    public static final String getSbolPaymentResult(@Nullable Intent intent) {
        if (intent != null) {
            return intent.getStringExtra("ru.sberbank.mobile.extra.EXTRA_RESULT");
        }
        return null;
    }

    public static final boolean isSuccess(@Nullable String str) {
        return Intrinsics.areEqual(str, RESULT_SUCCESS);
    }

    public static final boolean isVersionSupported(int i) {
        return i >= 2018101200;
    }
}

package com.avito.android.analytics_adjust.utils;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics_adjust/utils/AdjustContentType;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue$analytics_adjust_release", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "PRODUCT", "analytics-adjust_release"}, k = 1, mv = {1, 4, 2})
public enum AdjustContentType {
    PRODUCT(BaseAnalyticKt.ANALYTIC_MODULE_PRODUCT);
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    AdjustContentType(String str) {
        this.a = str;
    }

    @NotNull
    public final String getValue$analytics_adjust_release() {
        return this.a;
    }
}

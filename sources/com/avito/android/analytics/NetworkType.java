package com.avito.android.analytics;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/analytics/NetworkType;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStr", "()Ljava/lang/String;", "str", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CLASS_NONE", "CLASS_GPRS", "CLASS_2G", "CLASS_2G_PLUS", "CLASS_3G", "CLASS_3G_PLUS", "CLASS_4G", "CLASS_WIFI", "CLASS_UNKNOWN", "analytics_release"}, k = 1, mv = {1, 4, 2})
public enum NetworkType {
    CLASS_NONE("NONE"),
    CLASS_GPRS("GPRS"),
    CLASS_2G("2G"),
    CLASS_2G_PLUS("2G_plus"),
    CLASS_3G("3G"),
    CLASS_3G_PLUS("3G_plus"),
    CLASS_4G("4G"),
    CLASS_WIFI("Wi-Fi"),
    CLASS_UNKNOWN("UNKNOWN");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    NetworkType(String str) {
        this.a = str;
    }

    @NotNull
    public final String getStr() {
        return this.a;
    }
}

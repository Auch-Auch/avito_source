package com.avito.android.advert_core.analytics.toolbar;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert_core/analytics/toolbar/BackFromPage;", "", "", "isNotNone", "()Z", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "NONE", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public enum BackFromPage {
    NONE("");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    BackFromPage(String str) {
        this.a = str;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }

    public final boolean isNotNone() {
        return !Intrinsics.areEqual(this.a, "");
    }
}

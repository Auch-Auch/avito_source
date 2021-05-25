package com.avito.android.remote.interceptor;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/interceptor/AppHeaderProvider;", "Lcom/avito/android/remote/interceptor/HeaderProvider;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "", "c", "Z", "isMandatory", "()Z", AuthSource.SEND_ABUSE, "getKey", "key", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public class AppHeaderProvider implements HeaderProvider {
    @NotNull
    public final String a = "X-App";
    @NotNull
    public final String b = "avito";
    public final boolean c = true;

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getKey() {
        return this.a;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getValue() {
        return this.b;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    public boolean isMandatory() {
        return this.c;
    }
}

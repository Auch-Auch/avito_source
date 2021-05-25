package com.avito.android.remote.interceptor;

import com.avito.android.remote.UserAgentProvider;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/interceptor/UserAgentHeaderProvider;", "Lcom/avito/android/remote/interceptor/HeaderProvider;", "", "c", "Z", "isMandatory", "()Z", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", AuthSource.BOOKING_ORDER, "getValue", "value", "Lcom/avito/android/remote/UserAgentProvider;", "userAgentProvider", "<init>", "(Lcom/avito/android/remote/UserAgentProvider;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class UserAgentHeaderProvider implements HeaderProvider {
    @NotNull
    public final String a = "User-Agent";
    @Nullable
    public final String b;
    public final boolean c;

    public UserAgentHeaderProvider(@NotNull UserAgentProvider userAgentProvider) {
        Intrinsics.checkNotNullParameter(userAgentProvider, "userAgentProvider");
        this.b = userAgentProvider.getUserAgent();
        this.c = true;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getKey() {
        return this.a;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @Nullable
    public String getValue() {
        return this.b;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    public boolean isMandatory() {
        return this.c;
    }
}

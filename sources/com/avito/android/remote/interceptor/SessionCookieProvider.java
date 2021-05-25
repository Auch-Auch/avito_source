package com.avito.android.remote.interceptor;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00068\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/interceptor/SessionCookieProvider;", "Lcom/avito/android/remote/interceptor/HeaderProvider;", "", "getValue", "()Ljava/lang/String;", "value", "", "isMandatory", "Z", "()Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getKey", "key", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "<init>", "(Lcom/avito/android/account/AccountStorageInteractor;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class SessionCookieProvider implements HeaderProvider {
    @NotNull
    public final String a = "sessid";
    public final AccountStorageInteractor b;

    @Inject
    public SessionCookieProvider(@NotNull AccountStorageInteractor accountStorageInteractor) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        this.b = accountStorageInteractor;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getKey() {
        return this.a;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @Nullable
    public String getValue() {
        return this.b.toBlocking().getSession();
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    public boolean isMandatory() {
        return false;
    }
}

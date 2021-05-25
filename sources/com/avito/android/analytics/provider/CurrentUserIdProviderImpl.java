package com.avito.android.analytics.provider;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/analytics/provider/CurrentUserIdProviderImpl;", "Lcom/avito/android/analytics/provider/CurrentUserIdProvider;", "", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStorageInteractor;", "accountInteractor", "<init>", "(Lcom/avito/android/account/AccountStorageInteractor;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class CurrentUserIdProviderImpl implements CurrentUserIdProvider {
    public final AccountStorageInteractor a;

    @Inject
    public CurrentUserIdProviderImpl(@NotNull AccountStorageInteractor accountStorageInteractor) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountInteractor");
        this.a = accountStorageInteractor;
    }

    @Override // com.avito.android.analytics.provider.CurrentUserIdProvider
    @Nullable
    public String getCurrentUserId() {
        return this.a.getCurrentUserId();
    }
}

package com.avito.android.account;

import com.avito.android.remote.model.ProfileInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\t\u0010\u0007J\u0011\u0010\n\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/account/BlockingAccountStorageInteractor;", "", "Lcom/avito/android/remote/model/ProfileInfo;", "getProfile", "()Lcom/avito/android/remote/model/ProfileInfo;", "", "getUserId", "()Ljava/lang/String;", "getSession", "getPushToken", "getRefreshToken", "", "isAuthorized", "()Z", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public interface BlockingAccountStorageInteractor {
    @Nullable
    ProfileInfo getProfile();

    @Nullable
    String getPushToken();

    @Nullable
    String getRefreshToken();

    @Nullable
    String getSession();

    @Nullable
    String getUserId();

    boolean isAuthorized();
}

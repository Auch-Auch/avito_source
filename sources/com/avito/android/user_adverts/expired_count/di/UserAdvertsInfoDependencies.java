package com.avito.android.user_adverts.expired_count.di;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.preferences.UserAdvertsInfoStorage;
import com.avito.android.user_advert.UserAdvertsInfoCache;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/user_adverts/expired_count/di/UserAdvertsInfoDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "userAdvertsApi", "()Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "Lcom/avito/android/preferences/UserAdvertsInfoStorage;", "userAdvertInfoStorage", "()Lcom/avito/android/preferences/UserAdvertsInfoStorage;", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "()Lcom/avito/android/account/AccountStorageInteractor;", "Lcom/avito/android/user_advert/UserAdvertsInfoCache;", "userAdvertsInfoCache", "()Lcom/avito/android/user_advert/UserAdvertsInfoCache;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertsInfoDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies
    @NotNull
    AccountStorageInteractor accountStorageInteractor();

    @NotNull
    UserAdvertsInfoStorage userAdvertInfoStorage();

    @NotNull
    UserAdvertsApi userAdvertsApi();

    @NotNull
    UserAdvertsInfoCache userAdvertsInfoCache();
}

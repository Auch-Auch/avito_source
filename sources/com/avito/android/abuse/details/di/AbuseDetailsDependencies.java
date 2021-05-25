package com.avito.android.abuse.details.di;

import com.avito.android.abuse.details.remote.AbuseApi;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.di.CoreComponentDependencies;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/abuse/details/di/AbuseDetailsDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/abuse/details/remote/AbuseApi;", "abuseApi", "()Lcom/avito/android/abuse/details/remote/AbuseApi;", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "()Lcom/avito/android/account/AccountStorageInteractor;", "abuse_release"}, k = 1, mv = {1, 4, 2})
public interface AbuseDetailsDependencies extends CoreComponentDependencies {
    @NotNull
    AbuseApi abuseApi();

    @Override // com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponentDependencies, com.avito.android.webview.di.WebViewDependencies, com.avito.android.profile.password_change.di.PasswordChangeDependencies, com.avito.android.profile.password_setting.di.PasswordSettingDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies
    @NotNull
    AccountStorageInteractor accountStorageInteractor();
}

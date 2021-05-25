package com.avito.android.user_adverts.expired_count.di;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.preferences.UserAdvertsInfoStorage;
import com.avito.android.user_advert.UserAdvertsInfoCache;
import com.avito.android.user_adverts.expired_count.UserAdvertsInfoInteractorImpl;
import com.avito.android.user_adverts.expired_count.UserAdvertsInfoService;
import com.avito.android.user_adverts.expired_count.UserAdvertsInfoService_MembersInjector;
import com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoComponent;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import dagger.internal.Preconditions;
public final class DaggerUserAdvertsInfoComponent implements UserAdvertsInfoComponent {
    public final UserAdvertsInfoDependencies a;

    public static final class b implements UserAdvertsInfoComponent.Builder {
        public UserAdvertsInfoDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoComponent.Builder
        public UserAdvertsInfoComponent build() {
            Preconditions.checkBuilderRequirement(this.a, UserAdvertsInfoDependencies.class);
            return new DaggerUserAdvertsInfoComponent(this.a, null);
        }

        @Override // com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoComponent.Builder
        public UserAdvertsInfoComponent.Builder dependentOn(UserAdvertsInfoDependencies userAdvertsInfoDependencies) {
            this.a = (UserAdvertsInfoDependencies) Preconditions.checkNotNull(userAdvertsInfoDependencies);
            return this;
        }
    }

    public DaggerUserAdvertsInfoComponent(UserAdvertsInfoDependencies userAdvertsInfoDependencies, a aVar) {
        this.a = userAdvertsInfoDependencies;
    }

    public static UserAdvertsInfoComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoComponent
    public void inject(UserAdvertsInfoService userAdvertsInfoService) {
        UserAdvertsInfoService_MembersInjector.injectInteractor(userAdvertsInfoService, new UserAdvertsInfoInteractorImpl((UserAdvertsApi) Preconditions.checkNotNullFromComponent(this.a.userAdvertsApi()), (UserAdvertsInfoStorage) Preconditions.checkNotNullFromComponent(this.a.userAdvertInfoStorage()), (AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor()), (UserAdvertsInfoCache) Preconditions.checkNotNullFromComponent(this.a.userAdvertsInfoCache())));
    }
}

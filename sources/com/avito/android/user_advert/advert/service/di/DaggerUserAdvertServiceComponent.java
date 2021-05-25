package com.avito.android.user_advert.advert.service.di;

import android.app.Application;
import com.avito.android.Features;
import com.avito.android.PublishIntentFactory;
import com.avito.android.UserAdvertIntentFactory;
import com.avito.android.UserAdvertsIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.user_advert.advert.service.UserAdvertInteractorImpl;
import com.avito.android.user_advert.advert.service.UserAdvertService;
import com.avito.android.user_advert.advert.service.UserAdvertService_MembersInjector;
import com.avito.android.user_advert.advert.service.di.UserAdvertServiceComponent;
import com.avito.android.user_advert_api.remote.UserAdvertApi;
import dagger.internal.Preconditions;
public final class DaggerUserAdvertServiceComponent implements UserAdvertServiceComponent {
    public final UserAdvertServiceDependencies a;

    public static final class b implements UserAdvertServiceComponent.Builder {
        public UserAdvertServiceDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.user_advert.advert.service.di.UserAdvertServiceComponent.Builder
        public UserAdvertServiceComponent build() {
            Preconditions.checkBuilderRequirement(this.a, UserAdvertServiceDependencies.class);
            return new DaggerUserAdvertServiceComponent(this.a, null);
        }

        @Override // com.avito.android.user_advert.advert.service.di.UserAdvertServiceComponent.Builder
        public UserAdvertServiceComponent.Builder dependentOn(UserAdvertServiceDependencies userAdvertServiceDependencies) {
            this.a = (UserAdvertServiceDependencies) Preconditions.checkNotNull(userAdvertServiceDependencies);
            return this;
        }
    }

    public DaggerUserAdvertServiceComponent(UserAdvertServiceDependencies userAdvertServiceDependencies, a aVar) {
        this.a = userAdvertServiceDependencies;
    }

    public static UserAdvertServiceComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.user_advert.advert.service.di.UserAdvertServiceComponent
    public void inject(UserAdvertService userAdvertService) {
        UserAdvertService_MembersInjector.injectAnalytics(userAdvertService, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        UserAdvertService_MembersInjector.injectUserAdvertIntentFactory(userAdvertService, (UserAdvertIntentFactory) Preconditions.checkNotNullFromComponent(this.a.userAdvertIntentFactory()));
        UserAdvertService_MembersInjector.injectUserAdvertsIntentFactory(userAdvertService, (UserAdvertsIntentFactory) Preconditions.checkNotNullFromComponent(this.a.userAdvertsIntentFactory()));
        UserAdvertService_MembersInjector.injectPublishIntentFactory(userAdvertService, (PublishIntentFactory) Preconditions.checkNotNullFromComponent(this.a.publishIntentFactory()));
        UserAdvertService_MembersInjector.injectNotificationManagerCompat(userAdvertService, UserAdvertServiceModule_ProvideNotificationManagerFactory.provideNotificationManager((Application) Preconditions.checkNotNullFromComponent(this.a.application())));
        UserAdvertService_MembersInjector.injectInteractor(userAdvertService, new UserAdvertInteractorImpl((UserAdvertApi) Preconditions.checkNotNullFromComponent(this.a.userAdvertApi()), (Features) Preconditions.checkNotNullFromComponent(this.a.features()), (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics())));
    }
}

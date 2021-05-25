package com.avito.android.advert_core.phone_request.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.PhoneRequestDeepLinkAnalyticsData;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.phone_request.PhoneRequestDeepLinkActivity;
import com.avito.android.advert_core.phone_request.PhoneRequestDeepLinkActivity_MembersInjector;
import com.avito.android.advert_core.phone_request.PhoneRequestDeepLinkAnalyticsInteractorImpl;
import com.avito.android.advert_core.phone_request.PhoneRequestPresenterImpl;
import com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkActivityComponent;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.async_phone.AsyncPhoneAuthRouter;
import com.avito.android.async_phone.AsyncPhoneInteractor;
import com.avito.android.async_phone.AsyncPhoneInteractorImpl;
import com.avito.android.async_phone.AsyncPhoneInteractorImpl_Factory;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.async_phone.AsyncPhonePresenterImpl;
import com.avito.android.async_phone.AsyncPhonePresenterImpl_Factory;
import com.avito.android.async_phone.AsyncPhoneTracker;
import com.avito.android.async_phone.AsyncPhoneTrackerImpl;
import com.avito.android.async_phone.AsyncPhoneTrackerImpl_Factory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerPhoneRequestDeepLinkActivityComponent implements PhoneRequestDeepLinkActivityComponent {
    public final PhoneRequestDeepLinkDependencies a;
    public final PhoneRequestLink b;
    public final PhoneRequestDeepLinkAnalyticsData c;
    public Provider<AsyncPhoneApi> d;
    public Provider<SchedulersFactory3> e;
    public Provider<AsyncPhoneInteractorImpl> f;
    public Provider<AsyncPhoneInteractor> g;
    public Provider<TypedErrorThrowableConverter> h;
    public Provider<ScreenTrackerFactory> i;
    public Provider<Screen> j;
    public Provider<AsyncPhoneTrackerImpl> k;
    public Provider<AsyncPhoneTracker> l;
    public Provider<AccountStateProvider> m;
    public Provider<Features> n;
    public Provider<AsyncPhoneAuthRouter> o;
    public Provider<AsyncPhonePresenterImpl> p;
    public Provider<AsyncPhonePresenter> q;

    public static final class b implements PhoneRequestDeepLinkActivityComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkActivityComponent.Factory
        public PhoneRequestDeepLinkActivityComponent create(PhoneRequestDeepLinkDependencies phoneRequestDeepLinkDependencies, AsyncPhoneAuthRouter asyncPhoneAuthRouter, Screen screen, PhoneRequestLink phoneRequestLink, PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData) {
            Preconditions.checkNotNull(phoneRequestDeepLinkDependencies);
            Preconditions.checkNotNull(asyncPhoneAuthRouter);
            Preconditions.checkNotNull(screen);
            Preconditions.checkNotNull(phoneRequestLink);
            return new DaggerPhoneRequestDeepLinkActivityComponent(phoneRequestDeepLinkDependencies, asyncPhoneAuthRouter, screen, phoneRequestLink, phoneRequestDeepLinkAnalyticsData, null);
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final PhoneRequestDeepLinkDependencies a;

        public c(PhoneRequestDeepLinkDependencies phoneRequestDeepLinkDependencies) {
            this.a = phoneRequestDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<AsyncPhoneApi> {
        public final PhoneRequestDeepLinkDependencies a;

        public d(PhoneRequestDeepLinkDependencies phoneRequestDeepLinkDependencies) {
            this.a = phoneRequestDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AsyncPhoneApi get() {
            return (AsyncPhoneApi) Preconditions.checkNotNullFromComponent(this.a.asyncPhoneApi());
        }
    }

    public static class e implements Provider<Features> {
        public final PhoneRequestDeepLinkDependencies a;

        public e(PhoneRequestDeepLinkDependencies phoneRequestDeepLinkDependencies) {
            this.a = phoneRequestDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<SchedulersFactory3> {
        public final PhoneRequestDeepLinkDependencies a;

        public f(PhoneRequestDeepLinkDependencies phoneRequestDeepLinkDependencies) {
            this.a = phoneRequestDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class g implements Provider<ScreenTrackerFactory> {
        public final PhoneRequestDeepLinkDependencies a;

        public g(PhoneRequestDeepLinkDependencies phoneRequestDeepLinkDependencies) {
            this.a = phoneRequestDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class h implements Provider<TypedErrorThrowableConverter> {
        public final PhoneRequestDeepLinkDependencies a;

        public h(PhoneRequestDeepLinkDependencies phoneRequestDeepLinkDependencies) {
            this.a = phoneRequestDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerPhoneRequestDeepLinkActivityComponent(PhoneRequestDeepLinkDependencies phoneRequestDeepLinkDependencies, AsyncPhoneAuthRouter asyncPhoneAuthRouter, Screen screen, PhoneRequestLink phoneRequestLink, PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData, a aVar) {
        this.a = phoneRequestDeepLinkDependencies;
        this.b = phoneRequestLink;
        this.c = phoneRequestDeepLinkAnalyticsData;
        d dVar = new d(phoneRequestDeepLinkDependencies);
        this.d = dVar;
        f fVar = new f(phoneRequestDeepLinkDependencies);
        this.e = fVar;
        AsyncPhoneInteractorImpl_Factory create = AsyncPhoneInteractorImpl_Factory.create(dVar, fVar);
        this.f = create;
        this.g = SingleCheck.provider(create);
        this.h = new h(phoneRequestDeepLinkDependencies);
        this.i = new g(phoneRequestDeepLinkDependencies);
        this.j = InstanceFactory.create(screen);
        AsyncPhoneTrackerImpl_Factory create2 = AsyncPhoneTrackerImpl_Factory.create(this.i, TimerFactory_Factory.create(), this.j);
        this.k = create2;
        this.l = SingleCheck.provider(create2);
        this.m = new c(phoneRequestDeepLinkDependencies);
        this.n = new e(phoneRequestDeepLinkDependencies);
        Factory create3 = InstanceFactory.create(asyncPhoneAuthRouter);
        this.o = create3;
        Provider<AsyncPhoneInteractor> provider = this.g;
        Provider<TypedErrorThrowableConverter> provider2 = this.h;
        AsyncPhonePresenterImpl_Factory create4 = AsyncPhonePresenterImpl_Factory.create(provider, provider2, this.l, this.e, this.m, this.n, create3, provider2);
        this.p = create4;
        this.q = SingleCheck.provider(create4);
    }

    public static PhoneRequestDeepLinkActivityComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkActivityComponent
    public void inject(PhoneRequestDeepLinkActivity phoneRequestDeepLinkActivity) {
        PhoneRequestDeepLinkActivity_MembersInjector.injectActivityIntentFactory(phoneRequestDeepLinkActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        PhoneRequestDeepLinkActivity_MembersInjector.injectPresenter(phoneRequestDeepLinkActivity, new PhoneRequestPresenterImpl(this.b, new PhoneRequestDeepLinkAnalyticsInteractorImpl(this.c, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics())), (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()), this.q.get()));
        PhoneRequestDeepLinkActivity_MembersInjector.injectPhoneNumberFormatter(phoneRequestDeepLinkActivity, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.providePhoneNumberFormatterWithCountryCode());
    }
}

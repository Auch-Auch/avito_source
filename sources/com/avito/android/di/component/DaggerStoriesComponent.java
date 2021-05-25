package com.avito.android.di.component;

import android.content.res.Resources;
import android.webkit.CookieManager;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl_Factory;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.component.StoriesComponent;
import com.avito.android.remote.StoriesApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.interceptor.FingerprintHeaderProvider;
import com.avito.android.server_time.ServerTimeSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.stories.StoriesActivity;
import com.avito.android.stories.StoriesActivity_MembersInjector;
import com.avito.android.stories.StoriesArguments;
import com.avito.android.stories.StoriesInteractorImpl;
import com.avito.android.stories.StoriesPresenterImpl;
import com.avito.android.stories.di.StoriesModule_ProvideCookieManager$serp_core_releaseFactory;
import com.avito.android.stories.di.StoriesModule_ProvideCookieProvider$serp_core_releaseFactory;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerStoriesComponent implements StoriesComponent {
    public final StoriesDependencies a;
    public final StoriesArguments b;
    public final Resources c;
    public Provider<CookieManager> d = DoubleCheck.provider(StoriesModule_ProvideCookieManager$serp_core_releaseFactory.create());
    public Provider<FingerprintHeaderProvider> e;
    public Provider<ServerTimeSource> f;
    public Provider<CookieExpiredTimeImpl> g;
    public Provider<CookieProvider> h;

    public static final class b implements StoriesComponent.Builder {
        public StoriesArguments a;
        public Resources b;
        public StoriesDependencies c;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.StoriesComponent.Builder
        public StoriesComponent build() {
            Preconditions.checkBuilderRequirement(this.a, StoriesArguments.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, StoriesDependencies.class);
            return new DaggerStoriesComponent(this.c, this.a, this.b, null);
        }

        @Override // com.avito.android.di.component.StoriesComponent.Builder
        public StoriesComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.di.component.StoriesComponent.Builder
        public StoriesComponent.Builder storiesArguments(StoriesArguments storiesArguments) {
            this.a = (StoriesArguments) Preconditions.checkNotNull(storiesArguments);
            return this;
        }

        @Override // com.avito.android.di.component.StoriesComponent.Builder
        public StoriesComponent.Builder storiesDependencies(StoriesDependencies storiesDependencies) {
            this.c = (StoriesDependencies) Preconditions.checkNotNull(storiesDependencies);
            return this;
        }
    }

    public static class c implements Provider<FingerprintHeaderProvider> {
        public final StoriesDependencies a;

        public c(StoriesDependencies storiesDependencies) {
            this.a = storiesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FingerprintHeaderProvider get() {
            return (FingerprintHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.fingerprintHeaderProvider());
        }
    }

    public static class d implements Provider<ServerTimeSource> {
        public final StoriesDependencies a;

        public d(StoriesDependencies storiesDependencies) {
            this.a = storiesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ServerTimeSource get() {
            return (ServerTimeSource) Preconditions.checkNotNullFromComponent(this.a.serverTimeSource());
        }
    }

    public DaggerStoriesComponent(StoriesDependencies storiesDependencies, StoriesArguments storiesArguments, Resources resources, a aVar) {
        this.a = storiesDependencies;
        this.b = storiesArguments;
        this.c = resources;
        this.e = new c(storiesDependencies);
        d dVar = new d(storiesDependencies);
        this.f = dVar;
        CookieExpiredTimeImpl_Factory create = CookieExpiredTimeImpl_Factory.create(dVar);
        this.g = create;
        this.h = DoubleCheck.provider(StoriesModule_ProvideCookieProvider$serp_core_releaseFactory.create(this.e, create));
    }

    public static StoriesComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.StoriesComponent
    public void inject(StoriesActivity storiesActivity) {
        StoriesActivity_MembersInjector.injectPresenter(storiesActivity, new StoriesPresenterImpl(new StoriesInteractorImpl((StoriesApi) Preconditions.checkNotNullFromComponent(this.a.storiesApi()), (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences()), (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource())), this.d.get(), this.h.get(), (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory()), this.b, this.c));
        StoriesActivity_MembersInjector.injectDeepLinkIntentFactory(storiesActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        StoriesActivity_MembersInjector.injectImplicitIntentFactory(storiesActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
    }
}

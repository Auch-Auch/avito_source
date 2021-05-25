package com.avito.android.deep_linking.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.AppShortcutsDeepLinkActivity;
import com.avito.android.deep_linking.AppShortcutsDeepLinkActivity_MembersInjector;
import com.avito.android.deep_linking.AppShortcutsDeepLinkPresenter;
import com.avito.android.deep_linking.AppShortcutsDeepLinkPresenterImpl;
import com.avito.android.deep_linking.AppShortcutsDeepLinkPresenterImpl_Factory;
import com.avito.android.deep_linking.AppShortcutsDeepLinkRouter;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.di.AppShortcutsDeepLinkComponent;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerAppShortcutsDeepLinkComponent implements AppShortcutsDeepLinkComponent {
    public final AppShortcutsDeepLinkDependencies a;
    public Provider<Analytics> b;
    public Provider<DeepLinkFactory> c;
    public Provider<AppShortcutsDeepLinkRouter> d;
    public Provider<AppShortcutsDeepLinkPresenterImpl> e;
    public Provider<AppShortcutsDeepLinkPresenter> f;

    public static final class b implements AppShortcutsDeepLinkComponent.Builder {
        public AppShortcutsDeepLinkDependencies a;
        public AppShortcutsDeepLinkRouter b;

        public b(a aVar) {
        }

        @Override // com.avito.android.deep_linking.di.AppShortcutsDeepLinkComponent.Builder
        public AppShortcutsDeepLinkComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AppShortcutsDeepLinkDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, AppShortcutsDeepLinkRouter.class);
            return new DaggerAppShortcutsDeepLinkComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.deep_linking.di.AppShortcutsDeepLinkComponent.Builder
        public AppShortcutsDeepLinkComponent.Builder dependencies(AppShortcutsDeepLinkDependencies appShortcutsDeepLinkDependencies) {
            this.a = (AppShortcutsDeepLinkDependencies) Preconditions.checkNotNull(appShortcutsDeepLinkDependencies);
            return this;
        }

        @Override // com.avito.android.deep_linking.di.AppShortcutsDeepLinkComponent.Builder
        public AppShortcutsDeepLinkComponent.Builder withRouter(AppShortcutsDeepLinkRouter appShortcutsDeepLinkRouter) {
            this.b = (AppShortcutsDeepLinkRouter) Preconditions.checkNotNull(appShortcutsDeepLinkRouter);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final AppShortcutsDeepLinkDependencies a;

        public c(AppShortcutsDeepLinkDependencies appShortcutsDeepLinkDependencies) {
            this.a = appShortcutsDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<DeepLinkFactory> {
        public final AppShortcutsDeepLinkDependencies a;

        public d(AppShortcutsDeepLinkDependencies appShortcutsDeepLinkDependencies) {
            this.a = appShortcutsDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkFactory());
        }
    }

    public DaggerAppShortcutsDeepLinkComponent(AppShortcutsDeepLinkDependencies appShortcutsDeepLinkDependencies, AppShortcutsDeepLinkRouter appShortcutsDeepLinkRouter, a aVar) {
        this.a = appShortcutsDeepLinkDependencies;
        this.b = new c(appShortcutsDeepLinkDependencies);
        this.c = new d(appShortcutsDeepLinkDependencies);
        Factory create = InstanceFactory.create(appShortcutsDeepLinkRouter);
        this.d = create;
        AppShortcutsDeepLinkPresenterImpl_Factory create2 = AppShortcutsDeepLinkPresenterImpl_Factory.create(this.b, this.c, create);
        this.e = create2;
        this.f = DoubleCheck.provider(create2);
    }

    public static AppShortcutsDeepLinkComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.deep_linking.di.AppShortcutsDeepLinkComponent
    public void inject(AppShortcutsDeepLinkActivity appShortcutsDeepLinkActivity) {
        AppShortcutsDeepLinkActivity_MembersInjector.injectDeepLinkIntentFactory(appShortcutsDeepLinkActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        AppShortcutsDeepLinkActivity_MembersInjector.injectPresenter(appShortcutsDeepLinkActivity, this.f.get());
    }
}

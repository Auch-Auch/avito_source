package com.avito.android.search.subscriptions.di;

import android.app.Application;
import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.db.SavedSearchDao;
import com.avito.android.db.SearchSubscriptionDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SearchSubscriptionPluginModule_ProvideAuthorizationPluginFactory implements Factory<AuthorizationPlugin> {
    public final Provider<SavedSearchDao> a;
    public final Provider<SearchSubscriptionDao> b;
    public final Provider<Application> c;

    public SearchSubscriptionPluginModule_ProvideAuthorizationPluginFactory(Provider<SavedSearchDao> provider, Provider<SearchSubscriptionDao> provider2, Provider<Application> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SearchSubscriptionPluginModule_ProvideAuthorizationPluginFactory create(Provider<SavedSearchDao> provider, Provider<SearchSubscriptionDao> provider2, Provider<Application> provider3) {
        return new SearchSubscriptionPluginModule_ProvideAuthorizationPluginFactory(provider, provider2, provider3);
    }

    public static AuthorizationPlugin provideAuthorizationPlugin(SavedSearchDao savedSearchDao, SearchSubscriptionDao searchSubscriptionDao, Application application) {
        return (AuthorizationPlugin) Preconditions.checkNotNullFromProvides(SearchSubscriptionPluginModule.provideAuthorizationPlugin(savedSearchDao, searchSubscriptionDao, application));
    }

    @Override // javax.inject.Provider
    public AuthorizationPlugin get() {
        return provideAuthorizationPlugin(this.a.get(), this.b.get(), this.c.get());
    }
}

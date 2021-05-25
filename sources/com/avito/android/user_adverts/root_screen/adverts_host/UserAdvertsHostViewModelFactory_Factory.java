package com.avito.android.user_adverts.root_screen.adverts_host;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoInteractor;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserAdvertsHostViewModelFactory_Factory implements Factory<UserAdvertsHostViewModelFactory> {
    public final Provider<SoaInfoInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<AttributedTextFormatter> c;
    public final Provider<Analytics> d;
    public final Provider<AccountStateProvider> e;

    public UserAdvertsHostViewModelFactory_Factory(Provider<SoaInfoInteractor> provider, Provider<SchedulersFactory> provider2, Provider<AttributedTextFormatter> provider3, Provider<Analytics> provider4, Provider<AccountStateProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static UserAdvertsHostViewModelFactory_Factory create(Provider<SoaInfoInteractor> provider, Provider<SchedulersFactory> provider2, Provider<AttributedTextFormatter> provider3, Provider<Analytics> provider4, Provider<AccountStateProvider> provider5) {
        return new UserAdvertsHostViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static UserAdvertsHostViewModelFactory newInstance(SoaInfoInteractor soaInfoInteractor, SchedulersFactory schedulersFactory, AttributedTextFormatter attributedTextFormatter, Analytics analytics, AccountStateProvider accountStateProvider) {
        return new UserAdvertsHostViewModelFactory(soaInfoInteractor, schedulersFactory, attributedTextFormatter, analytics, accountStateProvider);
    }

    @Override // javax.inject.Provider
    public UserAdvertsHostViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}

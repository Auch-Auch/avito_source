package com.avito.android.publish.details.di;

import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.publish.slots.SlotsFactory;
import com.avito.android.publish.slots.profile_info.PublishContactsStringProvider;
import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideSlotsFactoryFactory implements Factory<SlotsFactory> {
    public final PublishDetailsModule a;
    public final Provider<ProfileSourceInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<ProfileApi> d;
    public final Provider<PublishApi> e;
    public final Provider<PublishLimitsApi> f;
    public final Provider<TypedErrorThrowableConverter> g;
    public final Provider<AccountStorageInteractor> h;
    public final Provider<AttributedTextFormatter> i;
    public final Provider<CategoryParametersConverter> j;
    public final Provider<ContactsDataSource> k;
    public final Provider<PublishContactsStringProvider> l;
    public final Provider<PublishAnalyticsDataProvider> m;
    public final Provider<Analytics> n;
    public final Provider<Formatter<String>> o;
    public final Provider<SessionChangeTracker> p;
    public final Provider<Features> q;
    public final Provider<PublishDetailsTracker> r;
    public final Provider<PublishEventTracker> s;
    public final Provider<PublishLimitsEventTracker> t;

    public PublishDetailsModule_ProvideSlotsFactoryFactory(PublishDetailsModule publishDetailsModule, Provider<ProfileSourceInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<ProfileApi> provider3, Provider<PublishApi> provider4, Provider<PublishLimitsApi> provider5, Provider<TypedErrorThrowableConverter> provider6, Provider<AccountStorageInteractor> provider7, Provider<AttributedTextFormatter> provider8, Provider<CategoryParametersConverter> provider9, Provider<ContactsDataSource> provider10, Provider<PublishContactsStringProvider> provider11, Provider<PublishAnalyticsDataProvider> provider12, Provider<Analytics> provider13, Provider<Formatter<String>> provider14, Provider<SessionChangeTracker> provider15, Provider<Features> provider16, Provider<PublishDetailsTracker> provider17, Provider<PublishEventTracker> provider18, Provider<PublishLimitsEventTracker> provider19) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
        this.l = provider11;
        this.m = provider12;
        this.n = provider13;
        this.o = provider14;
        this.p = provider15;
        this.q = provider16;
        this.r = provider17;
        this.s = provider18;
        this.t = provider19;
    }

    public static PublishDetailsModule_ProvideSlotsFactoryFactory create(PublishDetailsModule publishDetailsModule, Provider<ProfileSourceInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<ProfileApi> provider3, Provider<PublishApi> provider4, Provider<PublishLimitsApi> provider5, Provider<TypedErrorThrowableConverter> provider6, Provider<AccountStorageInteractor> provider7, Provider<AttributedTextFormatter> provider8, Provider<CategoryParametersConverter> provider9, Provider<ContactsDataSource> provider10, Provider<PublishContactsStringProvider> provider11, Provider<PublishAnalyticsDataProvider> provider12, Provider<Analytics> provider13, Provider<Formatter<String>> provider14, Provider<SessionChangeTracker> provider15, Provider<Features> provider16, Provider<PublishDetailsTracker> provider17, Provider<PublishEventTracker> provider18, Provider<PublishLimitsEventTracker> provider19) {
        return new PublishDetailsModule_ProvideSlotsFactoryFactory(publishDetailsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19);
    }

    public static SlotsFactory provideSlotsFactory(PublishDetailsModule publishDetailsModule, ProfileSourceInteractor profileSourceInteractor, SchedulersFactory3 schedulersFactory3, ProfileApi profileApi, PublishApi publishApi, PublishLimitsApi publishLimitsApi, TypedErrorThrowableConverter typedErrorThrowableConverter, AccountStorageInteractor accountStorageInteractor, AttributedTextFormatter attributedTextFormatter, CategoryParametersConverter categoryParametersConverter, ContactsDataSource contactsDataSource, PublishContactsStringProvider publishContactsStringProvider, PublishAnalyticsDataProvider publishAnalyticsDataProvider, Analytics analytics, Formatter<String> formatter, SessionChangeTracker sessionChangeTracker, Features features, PublishDetailsTracker publishDetailsTracker, PublishEventTracker publishEventTracker, PublishLimitsEventTracker publishLimitsEventTracker) {
        return (SlotsFactory) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideSlotsFactory(profileSourceInteractor, schedulersFactory3, profileApi, publishApi, publishLimitsApi, typedErrorThrowableConverter, accountStorageInteractor, attributedTextFormatter, categoryParametersConverter, contactsDataSource, publishContactsStringProvider, publishAnalyticsDataProvider, analytics, formatter, sessionChangeTracker, features, publishDetailsTracker, publishEventTracker, publishLimitsEventTracker));
    }

    @Override // javax.inject.Provider
    public SlotsFactory get() {
        return provideSlotsFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get());
    }
}

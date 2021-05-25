package com.avito.android.analytics.clickstream;

import com.avito.android.AnalyticsToggles;
import com.avito.android.analytics.inhouse_transport.InMemoryEventStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import proto.events.apps.EventOuterClass;
public final class ClickStreamCommonModule_ProvideInMemoryClickStreamEventStorageFactory implements Factory<InMemoryEventStorage<EventOuterClass.Event>> {
    public final Provider<AnalyticsToggles> a;

    public ClickStreamCommonModule_ProvideInMemoryClickStreamEventStorageFactory(Provider<AnalyticsToggles> provider) {
        this.a = provider;
    }

    public static ClickStreamCommonModule_ProvideInMemoryClickStreamEventStorageFactory create(Provider<AnalyticsToggles> provider) {
        return new ClickStreamCommonModule_ProvideInMemoryClickStreamEventStorageFactory(provider);
    }

    public static InMemoryEventStorage<EventOuterClass.Event> provideInMemoryClickStreamEventStorage(AnalyticsToggles analyticsToggles) {
        return (InMemoryEventStorage) Preconditions.checkNotNullFromProvides(ClickStreamCommonModule.provideInMemoryClickStreamEventStorage(analyticsToggles));
    }

    @Override // javax.inject.Provider
    public InMemoryEventStorage<EventOuterClass.Event> get() {
        return provideInMemoryClickStreamEventStorage(this.a.get());
    }
}

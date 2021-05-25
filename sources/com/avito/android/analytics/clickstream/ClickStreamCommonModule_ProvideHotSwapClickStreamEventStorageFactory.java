package com.avito.android.analytics.clickstream;

import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.analytics.inhouse_transport.InMemoryEventStorage;
import com.avito.android.analytics.inhouse_transport.OnDiskEventStorage;
import com.avito.android.analytics.inhouse_transport.OverflowTrimmer;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import proto.events.apps.EventOuterClass;
public final class ClickStreamCommonModule_ProvideHotSwapClickStreamEventStorageFactory implements Factory<InHouseEventStorage<EventOuterClass.Event>> {
    public final Provider<InMemoryEventStorage<EventOuterClass.Event>> a;
    public final Provider<OnDiskEventStorage<EventOuterClass.Event>> b;
    public final Provider<OverflowTrimmer<EventOuterClass.Event>> c;

    public ClickStreamCommonModule_ProvideHotSwapClickStreamEventStorageFactory(Provider<InMemoryEventStorage<EventOuterClass.Event>> provider, Provider<OnDiskEventStorage<EventOuterClass.Event>> provider2, Provider<OverflowTrimmer<EventOuterClass.Event>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ClickStreamCommonModule_ProvideHotSwapClickStreamEventStorageFactory create(Provider<InMemoryEventStorage<EventOuterClass.Event>> provider, Provider<OnDiskEventStorage<EventOuterClass.Event>> provider2, Provider<OverflowTrimmer<EventOuterClass.Event>> provider3) {
        return new ClickStreamCommonModule_ProvideHotSwapClickStreamEventStorageFactory(provider, provider2, provider3);
    }

    public static InHouseEventStorage<EventOuterClass.Event> provideHotSwapClickStreamEventStorage(Provider<InMemoryEventStorage<EventOuterClass.Event>> provider, Lazy<OnDiskEventStorage<EventOuterClass.Event>> lazy, OverflowTrimmer<EventOuterClass.Event> overflowTrimmer) {
        return (InHouseEventStorage) Preconditions.checkNotNullFromProvides(ClickStreamCommonModule.provideHotSwapClickStreamEventStorage(provider, lazy, overflowTrimmer));
    }

    @Override // javax.inject.Provider
    public InHouseEventStorage<EventOuterClass.Event> get() {
        return provideHotSwapClickStreamEventStorage(this.a, DoubleCheck.lazy(this.b), this.c.get());
    }
}

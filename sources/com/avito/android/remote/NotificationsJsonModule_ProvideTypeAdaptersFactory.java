package com.avito.android.remote;

import com.avito.android.Features;
import com.avito.android.util.TypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class NotificationsJsonModule_ProvideTypeAdaptersFactory implements Factory<Set<TypeAdapterEntry>> {
    public final Provider<Features> a;

    public NotificationsJsonModule_ProvideTypeAdaptersFactory(Provider<Features> provider) {
        this.a = provider;
    }

    public static NotificationsJsonModule_ProvideTypeAdaptersFactory create(Provider<Features> provider) {
        return new NotificationsJsonModule_ProvideTypeAdaptersFactory(provider);
    }

    public static Set<TypeAdapterEntry> provideTypeAdapters(Features features) {
        return (Set) Preconditions.checkNotNullFromProvides(NotificationsJsonModule.provideTypeAdapters(features));
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterEntry> get() {
        return provideTypeAdapters(this.a.get());
    }
}

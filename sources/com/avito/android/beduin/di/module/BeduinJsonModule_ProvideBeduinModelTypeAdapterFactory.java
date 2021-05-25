package com.avito.android.beduin.di.module;

import com.avito.android.beduin.parse.BeduinModelTypeAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class BeduinJsonModule_ProvideBeduinModelTypeAdapterFactory implements Factory<BeduinModelTypeAdapter> {

    public static final class a {
        public static final BeduinJsonModule_ProvideBeduinModelTypeAdapterFactory a = new BeduinJsonModule_ProvideBeduinModelTypeAdapterFactory();
    }

    public static BeduinJsonModule_ProvideBeduinModelTypeAdapterFactory create() {
        return a.a;
    }

    public static BeduinModelTypeAdapter provideBeduinModelTypeAdapter() {
        return (BeduinModelTypeAdapter) Preconditions.checkNotNullFromProvides(BeduinJsonModule.INSTANCE.provideBeduinModelTypeAdapter());
    }

    @Override // javax.inject.Provider
    public BeduinModelTypeAdapter get() {
        return provideBeduinModelTypeAdapter();
    }
}

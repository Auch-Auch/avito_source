package com.avito.android.beduin.di.module;

import com.avito.android.beduin.parse.BeduinActionParamsTypeAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class BeduinJsonModule_ProvideBeduinActionParamsTypeAdapterFactory implements Factory<BeduinActionParamsTypeAdapter> {

    public static final class a {
        public static final BeduinJsonModule_ProvideBeduinActionParamsTypeAdapterFactory a = new BeduinJsonModule_ProvideBeduinActionParamsTypeAdapterFactory();
    }

    public static BeduinJsonModule_ProvideBeduinActionParamsTypeAdapterFactory create() {
        return a.a;
    }

    public static BeduinActionParamsTypeAdapter provideBeduinActionParamsTypeAdapter() {
        return (BeduinActionParamsTypeAdapter) Preconditions.checkNotNullFromProvides(BeduinJsonModule.INSTANCE.provideBeduinActionParamsTypeAdapter());
    }

    @Override // javax.inject.Provider
    public BeduinActionParamsTypeAdapter get() {
        return provideBeduinActionParamsTypeAdapter();
    }
}

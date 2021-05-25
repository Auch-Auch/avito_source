package com.avito.android.di.module;

import android.content.Context;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DataDirectoryProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SendDataSizeModule_ProvideDataDirectoryProviderFactoryFactory implements Factory<DataDirectoryProvider> {
    public final Provider<Context> a;
    public final Provider<BuildInfo> b;

    public SendDataSizeModule_ProvideDataDirectoryProviderFactoryFactory(Provider<Context> provider, Provider<BuildInfo> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SendDataSizeModule_ProvideDataDirectoryProviderFactoryFactory create(Provider<Context> provider, Provider<BuildInfo> provider2) {
        return new SendDataSizeModule_ProvideDataDirectoryProviderFactoryFactory(provider, provider2);
    }

    public static DataDirectoryProvider provideDataDirectoryProviderFactory(Context context, BuildInfo buildInfo) {
        return (DataDirectoryProvider) Preconditions.checkNotNullFromProvides(SendDataSizeModule.provideDataDirectoryProviderFactory(context, buildInfo));
    }

    @Override // javax.inject.Provider
    public DataDirectoryProvider get() {
        return provideDataDirectoryProviderFactory(this.a.get(), this.b.get());
    }
}

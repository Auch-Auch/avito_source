package ru.avito.messenger.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.avito.messenger.internal.Config;
public final class ConfigModule_ProvideConfigFactory implements Factory<Config> {
    public final ConfigModule a;

    public ConfigModule_ProvideConfigFactory(ConfigModule configModule) {
        this.a = configModule;
    }

    public static ConfigModule_ProvideConfigFactory create(ConfigModule configModule) {
        return new ConfigModule_ProvideConfigFactory(configModule);
    }

    public static Config provideConfig(ConfigModule configModule) {
        return (Config) Preconditions.checkNotNullFromProvides(configModule.provideConfig());
    }

    @Override // javax.inject.Provider
    public Config get() {
        return provideConfig(this.a);
    }
}

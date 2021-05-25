package com.avito.android.advert.di;

import com.avito.android.advert_core.analytics.broker.SravniAnalyticsEventLogger;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.network.di.SravniNetworkConfiguration;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/di/SravniConfigurationModule;", "", "Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;", "sravniConfiguration", "()Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;", "Lcom/avito/android/advert_core/analytics/broker/SravniAnalyticsEventLogger;", "sravniEventLogger", "()Lcom/avito/android/advert_core/analytics/broker/SravniAnalyticsEventLogger;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SravniConfigurationModule {
    @NotNull
    public static final SravniConfigurationModule INSTANCE = new SravniConfigurationModule();

    @Provides
    @Singleton
    @NotNull
    public final SravniNetworkConfiguration sravniConfiguration() {
        return new SravniNetworkConfiguration(0, 0, 0, "https://mobile.sravni.ru", 7, null);
    }

    @Provides
    @Singleton
    @NotNull
    public final SravniAnalyticsEventLogger sravniEventLogger() {
        return new SravniAnalyticsEventLogger();
    }
}

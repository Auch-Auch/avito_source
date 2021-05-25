package com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.di;

import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractorImpl;
import com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger;
import com.avito.android.di.PerFragment;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/di/CreditPartnerModule;", "", "<init>", "()V", "Declarations", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class CreditPartnerModule {
    @NotNull
    public static final CreditPartnerModule INSTANCE = new CreditPartnerModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/di/CreditPartnerModule$Declarations;", "", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractorImpl;", "logger", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", "bindCreditBrokerFlowEventLogger", "(Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractorImpl;)Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        CreditBrokerFlowEventLogger bindCreditBrokerFlowEventLogger(@NotNull CreditBrokerAnalyticsInteractorImpl creditBrokerAnalyticsInteractorImpl);
    }
}

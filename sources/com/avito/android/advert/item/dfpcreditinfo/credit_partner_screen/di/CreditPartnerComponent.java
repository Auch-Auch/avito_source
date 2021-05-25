package com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.di;

import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerFragment;
import com.avito.android.advert_core.analytics.broker.BrokerAnalyticsState;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AdvertId;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/di/CreditPartnerComponent;", "", "Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartnerFragment;", "fragment", "", "inject", "(Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartnerFragment;)V", "Builder", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CoreComponentDependencies.class}, modules = {CreditPartnerModule.class})
@PerFragment
public interface CreditPartnerComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/di/CreditPartnerComponent$Builder;", "", "Lcom/avito/android/di/CoreComponentDependencies;", "dependencies", "(Lcom/avito/android/di/CoreComponentDependencies;)Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/di/CreditPartnerComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "withAdvertId", "(Ljava/lang/String;)Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/di/CreditPartnerComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withBrokerState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/di/CreditPartnerComponent$Builder;", "Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/di/CreditPartnerComponent;", "build", "()Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/di/CreditPartnerComponent;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        CreditPartnerComponent build();

        @NotNull
        Builder dependencies(@NotNull CoreComponentDependencies coreComponentDependencies);

        @BindsInstance
        @NotNull
        Builder withAdvertId(@AdvertId @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withBrokerState(@BrokerAnalyticsState @NotNull Kundle kundle);
    }

    void inject(@NotNull CreditPartnerFragment creditPartnerFragment);
}

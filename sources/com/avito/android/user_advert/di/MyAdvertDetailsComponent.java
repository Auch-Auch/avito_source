package com.avito.android.user_advert.di;

import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel;
import com.avito.android.analytics.di.BivrostStatisticsModule;
import com.avito.android.di.PerActivity;
import com.avito.android.di.PerScreen;
import com.avito.android.di.module.AdvertId;
import com.avito.android.user_advert.advert.DetailsId;
import com.avito.android.user_advert.advert.MyAdvertDetailsActivity;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingBlockViewModel;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishBlockViewModel;
import com.avito.android.user_advert.advert.feature_teasers.di.MyAdvertDetailsFeaturesTeasersModule;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerScreen
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0002\u001b\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/user_advert/di/MyAdvertDetailsComponent;", "", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsActivity;", "activity", "", "inject", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsActivity;)V", "Lcom/avito/android/user_advert/advert/autopublish_block/AutoPublishBlockViewModel;", "getAutoPublishBlockViewModel", "()Lcom/avito/android/user_advert/advert/autopublish_block/AutoPublishBlockViewModel;", "autoPublishBlockViewModel", "Lcom/avito/android/user_advert/advert/autobooking_block/AutoBookingBlockViewModel;", "getAutoBookingBlockViewModel", "()Lcom/avito/android/user_advert/advert/autobooking_block/AutoBookingBlockViewModel;", "autoBookingBlockViewModel", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "getDeliveryBlockViewModel", "()Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "deliveryBlockViewModel", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModel;", "getStrBlockViewModel", "()Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModel;", "strBlockViewModel", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", "getSafeDealServicesViewModel", "()Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", "safeDealServicesViewModel", "AdvertDetailsModule", "Builder", "user-advert_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {MyAdvertDetailsDependencies.class}, modules = {MyAdvertDetailsModule.class, AdvertDetailsModule.class, MyAdvertDetailsFeaturesTeasersModule.class, BivrostStatisticsModule.class})
@PerActivity
public interface MyAdvertDetailsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/user_advert/di/MyAdvertDetailsComponent$AdvertDetailsModule;", "", "Lcom/avito/android/user_advert/advert/DetailsId;", "detailsId", "", "provideAdvertId", "(Lcom/avito/android/user_advert/advert/DetailsId;)Ljava/lang/String;", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public static final class AdvertDetailsModule {
        @NotNull
        public static final AdvertDetailsModule INSTANCE = new AdvertDetailsModule();

        @AdvertId
        @Provides
        @NotNull
        public final String provideAdvertId(@NotNull DetailsId detailsId) {
            Intrinsics.checkNotNullParameter(detailsId, "detailsId");
            return ((com.avito.android.user_advert.advert.AdvertId) detailsId).getAdvertId();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/user_advert/di/MyAdvertDetailsComponent$Builder;", "Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "Lcom/avito/android/user_advert/di/MyAdvertDetailsComponent;", "build", "()Lcom/avito/android/user_advert/di/MyAdvertDetailsComponent;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder extends DetailsComponentBuilder<MyAdvertDetailsComponent> {
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        @NotNull
        /* renamed from: build */
        MyAdvertDetailsComponent mo95build();
    }

    @NotNull
    AutoBookingBlockViewModel getAutoBookingBlockViewModel();

    @NotNull
    AutoPublishBlockViewModel getAutoPublishBlockViewModel();

    @NotNull
    AdvertDeliveryBlockViewModel getDeliveryBlockViewModel();

    @NotNull
    MyAdvertSafeDealServicesViewModel getSafeDealServicesViewModel();

    @NotNull
    AdvertStrBlockViewModel getStrBlockViewModel();

    void inject(@NotNull MyAdvertDetailsActivity myAdvertDetailsActivity);
}

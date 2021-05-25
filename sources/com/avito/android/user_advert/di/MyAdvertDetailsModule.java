package com.avito.android.user_advert.di;

import com.avito.android.advert_core.analytics.AdvertAnalyticsModule;
import com.avito.android.advert_core.di.module.AdvertDeliveryBlockModule;
import com.avito.android.advert_core.di.module.AdvertStrBlockModule;
import com.avito.android.advert_core.safedeal.di.MyAdvertSafeDealServicesModule;
import com.avito.android.advert_core.social.ShareModule;
import com.avito.android.app_rater.di.AppRaterModule;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.user_advert.advert.autobooking_block.di.AutoBookingBlockModule;
import com.avito.android.user_advert.advert.autopublish_block.di.AutoPublishBlockModule;
import com.avito.android.user_advert.limits_info.LimitsInfoModule;
import com.avito.android.user_adverts_common.charity.CharityModule;
import com.avito.android.user_adverts_common.safety.di.SafetyInfoModule;
import com.avito.android.util.di.ClipboardModule;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_advert/di/MyAdvertDetailsModule;", "", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {BaseAdvertDetailsModule.class, ClipboardModule.class, ShareModule.class, DateTimeFormatterModule.class, AdvertDeliveryBlockModule.class, AdvertAnalyticsModule.class, AdvertStrBlockModule.class, DialogRouterModule.class, MyAdvertDetailsTrackerModule.class, DetailsPresentationModule.class, AppRaterModule.class, MyAdvertSafeDealServicesModule.class, AutoPublishBlockModule.class, AutoBookingBlockModule.class, SafetyInfoModule.class, CharityModule.class, LimitsInfoModule.class})
public final class MyAdvertDetailsModule {
    @NotNull
    public static final MyAdvertDetailsModule INSTANCE = new MyAdvertDetailsModule();
}

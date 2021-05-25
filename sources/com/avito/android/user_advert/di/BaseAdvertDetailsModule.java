package com.avito.android.user_advert.di;

import android.content.res.Resources;
import com.avito.android.advert_core.car_market_price.badge.di.AdvertDetailsImvBadgeModule;
import com.avito.android.advert_core.car_market_price.price_chart.di.CarMarketPriceChartModule;
import com.avito.android.advert_core.car_market_price.price_description.di.CarMarketPriceDescriptionModule;
import com.avito.android.di.PerActivity;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.shared_providers.SupportEmailResourceProviderImpl;
import com.avito.android.user_advert.R;
import com.avito.android.user_advert.advert.MyAdvertDetailsActionMenuConverter;
import com.avito.android.user_advert.advert.MyAdvertDetailsActionMenuConverterImpl;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/user_advert/di/BaseAdvertDetailsModule;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsActionMenuConverter;", "myAdvertDetailsActionMenuConverter", "(Landroid/content/res/Resources;)Lcom/avito/android/user_advert/advert/MyAdvertDetailsActionMenuConverter;", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "provideSupportEmailResourceProvider", "(Landroid/content/res/Resources;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/profile/ProfileInfoStorage;)Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "provideHtmlRenderOptions", "(Landroid/content/res/Resources;)Lcom/avito/android/html_formatter/HtmlRenderOptions;", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AttributedTextFormatterModule.class, CarMarketPriceChartModule.class, CarMarketPriceDescriptionModule.class, AdvertDetailsImvBadgeModule.class})
public final class BaseAdvertDetailsModule {
    @NotNull
    public static final BaseAdvertDetailsModule INSTANCE = new BaseAdvertDetailsModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final MyAdvertDetailsActionMenuConverter myAdvertDetailsActionMenuConverter(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.menu_share);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.menu_share)");
        return new MyAdvertDetailsActionMenuConverterImpl(string);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SupportEmailResourceProvider provideSupportEmailResourceProvider(@NotNull Resources resources, @NotNull DeviceMetrics deviceMetrics, @NotNull ProfileInfoStorage profileInfoStorage) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(profileInfoStorage, "profileInfoStorage");
        return new SupportEmailResourceProviderImpl(resources, profileInfoStorage, deviceMetrics.getBuildInfo());
    }

    @Provides
    @PerActivity
    @NotNull
    public final HtmlRenderOptions provideHtmlRenderOptions(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new HtmlRenderOptions((int) resources.getDimension(R.dimen.list_bullet_left_margin), (int) resources.getDimension(R.dimen.list_bullet_right_margin), (int) resources.getDimension(R.dimen.list_bullet_symbol_width), "—", false, 16, null);
    }
}

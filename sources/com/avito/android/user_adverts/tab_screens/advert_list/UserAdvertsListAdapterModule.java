package com.avito.android.user_adverts.tab_screens.advert_list;

import android.content.Context;
import android.content.res.Resources;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.analytics.Analytics;
import com.avito.android.component.user_advert.UserAdvertItemClickListener;
import com.avito.android.component.user_advert.UserAdvertItemListBlueprint;
import com.avito.android.component.user_advert.UserAdvertItemPresenter;
import com.avito.android.component.user_advert.UserAdvertItemPresenterImpl;
import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenter;
import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.lib.design.R;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistryImpl;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenterImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.ShortcutBannerBlueprint;
import com.avito.android.serp.adapter.ShortcutBannerItemListener;
import com.avito.android.serp.adapter.ShortcutBannerItemPresenter;
import com.avito.android.serp.adapter.ShortcutBannerItemPresenterImpl;
import com.avito.android.serp.adapter.ShortcutBannerWidthProvider;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.user_adverts.tab_screens.advert_list.disclaimer.DisclaimerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerPresenterImpl;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerPresenterImpl;
import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerItemPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerItemPresenterImpl;
import com.avito.android.user_adverts.tab_screens.advert_list.shortcut_title.ShortcutTitleBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.user_advert.UserAdvertItemResourceProvider;
import com.avito.android.user_adverts.tab_screens.advert_list.user_advert.UserAdvertItemResourceProviderImpl;
import com.avito.android.user_adverts.tab_screens.advert_list.user_advert.UserAdvertsInfoBannerWidthProvider;
import com.avito.android.util.Contexts;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010X\u001a\u00020U\u0012\u0006\u0010\\\u001a\u00020Y¢\u0006\u0004\b]\u0010^J\u001d\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000f\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b \u0010!J\u0017\u0010'\u001a\u00020$2\u0006\u0010#\u001a\u00020\u0005H\u0001¢\u0006\u0004\b%\u0010&J\u0017\u0010,\u001a\u00020)2\u0006\u0010(\u001a\u00020\fH\u0001¢\u0006\u0004\b*\u0010+J\u000f\u00100\u001a\u00020-H\u0001¢\u0006\u0004\b.\u0010/J\u0017\u00105\u001a\u0002022\u0006\u00101\u001a\u00020-H\u0001¢\u0006\u0004\b3\u00104J\u0017\u00109\u001a\u0002062\u0006\u00101\u001a\u00020-H\u0001¢\u0006\u0004\b7\u00108J\u000f\u0010=\u001a\u00020:H\u0001¢\u0006\u0004\b;\u0010<J\u0017\u0010A\u001a\u00020>2\u0006\u00101\u001a\u00020:H\u0001¢\u0006\u0004\b?\u0010@J\u000f\u0010E\u001a\u00020BH\u0001¢\u0006\u0004\bC\u0010DJ\u0017\u0010I\u001a\u00020F2\u0006\u00101\u001a\u00020BH\u0001¢\u0006\u0004\bG\u0010HJ\u000f\u0010M\u001a\u00020JH\u0001¢\u0006\u0004\bK\u0010LJ\u001f\u0010T\u001a\u00020Q2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020JH\u0001¢\u0006\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006_"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertsListAdapterModule;", "", "Ldagger/Lazy;", "Lcom/avito/android/component/user_advert/UserAdvertItemClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/component/user_advert/UserAdvertItemPresenter;", "provideAdvertItemPresenter$user_adverts_release", "(Ldagger/Lazy;)Lcom/avito/android/component/user_advert/UserAdvertItemPresenter;", "provideAdvertItemPresenter", "Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", "Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;", "shortcutBannerWidthProvider", "Lcom/avito/android/serp/adapter/ShortcutBannerItemPresenter;", "provideShortcutBannerItemPresenter$user_adverts_release", "(Ldagger/Lazy;Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;)Lcom/avito/android/serp/adapter/ShortcutBannerItemPresenter;", "provideShortcutBannerItemPresenter", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerPresenter;", "provideLinkedInfoBannerItemPresenter$user_adverts_release", "(Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerPresenter;", "provideLinkedInfoBannerItemPresenter", "provideShortcutBannerWidthProvider$user_adverts_release", "()Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;", "provideShortcutBannerWidthProvider", "Lcom/avito/android/user_adverts/tab_screens/advert_list/user_advert/UserAdvertItemResourceProvider;", "provideUserAdvertItemResourceProvider$user_adverts_release", "()Lcom/avito/android/user_adverts/tab_screens/advert_list/user_advert/UserAdvertItemResourceProvider;", "provideUserAdvertItemResourceProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", GeoContract.PROVIDER, "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup$user_adverts_release", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup", "advertItemPresenter", "Lcom/avito/android/component/user_advert/UserAdvertItemListBlueprint;", "provideAdvertItemListBlueprint$user_adverts_release", "(Lcom/avito/android/component/user_advert/UserAdvertItemPresenter;)Lcom/avito/android/component/user_advert/UserAdvertItemListBlueprint;", "provideAdvertItemListBlueprint", "shortcutBannerItemPresenter", "Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;", "provideShortcutBannerItemBlueprint$user_adverts_release", "(Lcom/avito/android/serp/adapter/ShortcutBannerItemPresenter;)Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;", "provideShortcutBannerItemBlueprint", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenter;", "provideSingleTextPresenter$user_adverts_release", "()Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenter;", "provideSingleTextPresenter", "presenter", "Lcom/avito/android/user_adverts/tab_screens/advert_list/disclaimer/DisclaimerBlueprint;", "provideDisclaimerBlueprint$user_adverts_release", "(Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenter;)Lcom/avito/android/user_adverts/tab_screens/advert_list/disclaimer/DisclaimerBlueprint;", "provideDisclaimerBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/shortcut_title/ShortcutTitleBlueprint;", "provideShortcutTitleBlueprint$user_adverts_release", "(Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenter;)Lcom/avito/android/user_adverts/tab_screens/advert_list/shortcut_title/ShortcutTitleBlueprint;", "provideShortcutTitleBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerPresenter;", "provideDiscountBannerPresenter$user_adverts_release", "()Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerPresenter;", "provideDiscountBannerPresenter", "Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerBlueprint;", "provideDiscountBlueprint$user_adverts_release", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerPresenter;)Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerBlueprint;", "provideDiscountBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerItemPresenter;", "providePerformanceVasBannerPresenter$user_adverts_release", "()Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerItemPresenter;", "providePerformanceVasBannerPresenter", "Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerBlueprint;", "providePerformanceVasBannerBlueprint$user_adverts_release", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerItemPresenter;)Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerBlueprint;", "providePerformanceVasBannerBlueprint", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry$user_adverts_release", "()Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "callableResponsiveItemPresenterRegistry", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter$user_adverts_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;)Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/Context;Landroid/content/res/Resources;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UserAdvertsListAdapterModule {
    public final Context a;
    public final Resources b;

    public UserAdvertsListAdapterModule(@NotNull Context context, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = context;
        this.b = resources;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ResponsiveAdapterPresenter provideAdapterPresenter$user_adverts_release(@NotNull AdapterPresenter adapterPresenter, @NotNull CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(callableResponsiveItemPresenterRegistry, "callableResponsiveItemPresenterRegistry");
        return new ResponsiveAdapterPresenterImpl(adapterPresenter, callableResponsiveItemPresenterRegistry);
    }

    @Provides
    @PerFragment
    @NotNull
    public final UserAdvertItemListBlueprint provideAdvertItemListBlueprint$user_adverts_release(@NotNull UserAdvertItemPresenter userAdvertItemPresenter) {
        Intrinsics.checkNotNullParameter(userAdvertItemPresenter, "advertItemPresenter");
        return new UserAdvertItemListBlueprint(userAdvertItemPresenter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final UserAdvertItemPresenter provideAdvertItemPresenter$user_adverts_release(@NotNull Lazy<UserAdvertItemClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new UserAdvertItemPresenterImpl(lazy);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DisclaimerBlueprint provideDisclaimerBlueprint$user_adverts_release(@NotNull SingleTextPresenter singleTextPresenter) {
        Intrinsics.checkNotNullParameter(singleTextPresenter, "presenter");
        return new DisclaimerBlueprint(singleTextPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DiscountBannerPresenter provideDiscountBannerPresenter$user_adverts_release() {
        return new DiscountBannerPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final DiscountBannerBlueprint provideDiscountBlueprint$user_adverts_release(@NotNull DiscountBannerPresenter discountBannerPresenter) {
        Intrinsics.checkNotNullParameter(discountBannerPresenter, "presenter");
        return new DiscountBannerBlueprint(discountBannerPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final LinkedInfoBannerPresenter provideLinkedInfoBannerItemPresenter$user_adverts_release(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new LinkedInfoBannerPresenterImpl(analytics);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PerformanceVasBannerBlueprint providePerformanceVasBannerBlueprint$user_adverts_release(@NotNull PerformanceVasBannerItemPresenter performanceVasBannerItemPresenter) {
        Intrinsics.checkNotNullParameter(performanceVasBannerItemPresenter, "presenter");
        return new PerformanceVasBannerBlueprint(performanceVasBannerItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PerformanceVasBannerItemPresenter providePerformanceVasBannerPresenter$user_adverts_release() {
        return new PerformanceVasBannerItemPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final CallableResponsiveItemPresenterRegistry provideResponsiveItemPresenterRegistry$user_adverts_release() {
        return new CallableResponsiveItemPresenterRegistryImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final ShortcutBannerBlueprint provideShortcutBannerItemBlueprint$user_adverts_release(@NotNull ShortcutBannerItemPresenter shortcutBannerItemPresenter) {
        Intrinsics.checkNotNullParameter(shortcutBannerItemPresenter, "shortcutBannerItemPresenter");
        return new ShortcutBannerBlueprint(shortcutBannerItemPresenter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final ShortcutBannerItemPresenter provideShortcutBannerItemPresenter$user_adverts_release(@NotNull Lazy<ShortcutBannerItemListener> lazy, @NotNull ShortcutBannerWidthProvider shortcutBannerWidthProvider) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(shortcutBannerWidthProvider, "shortcutBannerWidthProvider");
        return new ShortcutBannerItemPresenterImpl(lazy, shortcutBannerWidthProvider, Contexts.getColorByAttr(this.a, R.attr.violet));
    }

    @Provides
    @PerFragment
    @NotNull
    public final ShortcutBannerWidthProvider provideShortcutBannerWidthProvider$user_adverts_release() {
        return new UserAdvertsInfoBannerWidthProvider(this.b);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ShortcutTitleBlueprint provideShortcutTitleBlueprint$user_adverts_release(@NotNull SingleTextPresenter singleTextPresenter) {
        Intrinsics.checkNotNullParameter(singleTextPresenter, "presenter");
        return new ShortcutTitleBlueprint(singleTextPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SingleTextPresenter provideSingleTextPresenter$user_adverts_release() {
        return new SingleTextPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final GridLayoutManager.SpanSizeLookup provideSpanLookup$user_adverts_release(@NotNull SerpSpanProvider serpSpanProvider) {
        Intrinsics.checkNotNullParameter(serpSpanProvider, GeoContract.PROVIDER);
        return new SpanLookup(serpSpanProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final UserAdvertItemResourceProvider provideUserAdvertItemResourceProvider$user_adverts_release() {
        return new UserAdvertItemResourceProviderImpl();
    }
}

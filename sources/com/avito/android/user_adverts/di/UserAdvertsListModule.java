package com.avito.android.user_adverts.di;

import com.avito.android.component.user_advert.UserAdvertItemClickListener;
import com.avito.android.component.user_advert.UserAdvertItemListBlueprint;
import com.avito.android.di.PerFragment;
import com.avito.android.serp.adapter.ShortcutBannerBlueprint;
import com.avito.android.serp.adapter.ShortcutBannerItemListener;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenterImpl;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.avito.android.user_adverts.tab_screens.advert_list.disclaimer.DisclaimerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItemBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.shortcut_title.ShortcutTitleBlueprint;
import com.avito.konveyor.ItemBinder;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017JO\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/avito/android/user_adverts/di/UserAdvertsListModule;", "", "Lcom/avito/android/component/user_advert/UserAdvertItemListBlueprint;", "advertItemListBlueprint", "Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;", "shortcutBannerBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerBlueprint;", "linkedInfoBannerBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/disclaimer/DisclaimerBlueprint;", "disclaimerBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerBlueprint;", "discountBannerBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/shortcut_title/ShortcutTitleBlueprint;", "shortcutTitleBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerBlueprint;", "performanceVasBannerBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemBlueprint;", "loadingItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$user_adverts_release", "(Lcom/avito/android/component/user_advert/UserAdvertItemListBlueprint;Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerBlueprint;Lcom/avito/android/user_adverts/tab_screens/advert_list/disclaimer/DisclaimerBlueprint;Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerBlueprint;Lcom/avito/android/user_adverts/tab_screens/advert_list/shortcut_title/ShortcutTitleBlueprint;Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerBlueprint;Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "<init>", "()V", "Declarations", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class UserAdvertsListModule {
    @NotNull
    public static final UserAdvertsListModule INSTANCE = new UserAdvertsListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u000e0\u0011j\u0002`\u00122\u0010\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000fH'¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\f\u0012\u0004\u0012\u00020\u000e0\u0015j\u0002`\u00162\u0010\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000fH'¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/user_adverts/di/UserAdvertsListModule$Declarations;", "", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter;", "presenter", "Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", "provideShortcutBannerItemListener", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter;)Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", "Lcom/avito/android/component/user_advert/UserAdvertItemClickListener;", "provideClickListener", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter;)Lcom/avito/android/component/user_advert/UserAdvertItemClickListener;", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenterImpl;", "providePresenter", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenterImpl;)Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemAction;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionRelay;", "relay", "Lio/reactivex/Observable;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionObservable;", "bindObservable", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lio/reactivex/Observable;", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionConsumer;", "bindConsumer", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lio/reactivex/functions/Consumer;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @PerFragment
        Consumer<UserAdvertItemAction> bindConsumer(@NotNull PublishRelay<UserAdvertItemAction> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<UserAdvertItemAction> bindObservable(@NotNull PublishRelay<UserAdvertItemAction> publishRelay);

        @PerFragment
        @Binds
        @NotNull
        UserAdvertItemClickListener provideClickListener(@NotNull UserAdvertsListPresenter userAdvertsListPresenter);

        @PerFragment
        @Binds
        @NotNull
        UserAdvertsListPresenter providePresenter(@NotNull UserAdvertsListPresenterImpl userAdvertsListPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShortcutBannerItemListener provideShortcutBannerItemListener(@NotNull UserAdvertsListPresenter userAdvertsListPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$user_adverts_release(@NotNull UserAdvertItemListBlueprint userAdvertItemListBlueprint, @NotNull ShortcutBannerBlueprint shortcutBannerBlueprint, @NotNull LinkedInfoBannerBlueprint linkedInfoBannerBlueprint, @NotNull DisclaimerBlueprint disclaimerBlueprint, @NotNull DiscountBannerBlueprint discountBannerBlueprint, @NotNull ShortcutTitleBlueprint shortcutTitleBlueprint, @NotNull PerformanceVasBannerBlueprint performanceVasBannerBlueprint, @NotNull LoadingItemBlueprint loadingItemBlueprint) {
        Intrinsics.checkNotNullParameter(userAdvertItemListBlueprint, "advertItemListBlueprint");
        Intrinsics.checkNotNullParameter(shortcutBannerBlueprint, "shortcutBannerBlueprint");
        Intrinsics.checkNotNullParameter(linkedInfoBannerBlueprint, "linkedInfoBannerBlueprint");
        Intrinsics.checkNotNullParameter(disclaimerBlueprint, "disclaimerBlueprint");
        Intrinsics.checkNotNullParameter(discountBannerBlueprint, "discountBannerBlueprint");
        Intrinsics.checkNotNullParameter(shortcutTitleBlueprint, "shortcutTitleBlueprint");
        Intrinsics.checkNotNullParameter(performanceVasBannerBlueprint, "performanceVasBannerBlueprint");
        Intrinsics.checkNotNullParameter(loadingItemBlueprint, "loadingItemBlueprint");
        return new ItemBinder.Builder().registerItem(disclaimerBlueprint).registerItem(userAdvertItemListBlueprint).registerItem(shortcutBannerBlueprint).registerItem(linkedInfoBannerBlueprint).registerItem(discountBannerBlueprint).registerItem(shortcutTitleBlueprint).registerItem(performanceVasBannerBlueprint).registerItem(loadingItemBlueprint).build();
    }
}

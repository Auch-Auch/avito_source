package com.avito.android.notification_center.landing.recommends.di;

import a2.b.a.a.a;
import com.avito.android.di.PerFragment;
import com.avito.android.di.ViewedAdvertsModule;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsResourceProviderImpl;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsConverter;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsConverterImpl;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsInteractor;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsInteractorImpl;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsPresenter;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsPresenterImpl;
import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItem;
import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemBlueprint;
import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemPresenter;
import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemPresenterImpl;
import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView;
import com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItem;
import com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemBlueprint;
import com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemPresenter;
import com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemPresenterImpl;
import com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemView;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItem;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemBlueprint;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemPresenter;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemPresenterImpl;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemView;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItem;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemBlueprint;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemPresenter;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemPresenterImpl;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemView;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.FavoriteStatusResolverImpl;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.shared_providers.SupportEmailResourceProviderImpl;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/di/NotificationCenterLandingRecommendsFragmentModule;", "", "Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemBlueprint;", "itemAdvertBlueprint", "Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItemBlueprint;", "itemHeaderBlueprint", "Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemBlueprint;", "itemReviewBlueprint", "Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItemBlueprint;", "itemTitleBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemBlueprint;Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItemBlueprint;Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemBlueprint;Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "<init>", "()V", "Declarations", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ViewedAdvertsModule.class, Declarations.class})
public final class NotificationCenterLandingRecommendsFragmentModule {
    @NotNull
    public static final NotificationCenterLandingRecommendsFragmentModule INSTANCE = new NotificationCenterLandingRecommendsFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010\b\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\t2\u0006\u0010\b\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020 H'¢\u0006\u0004\b\"\u0010#J#\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0\t2\u0006\u0010\b\u001a\u00020$H'¢\u0006\u0004\b'\u0010(J\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)H'¢\u0006\u0004\b,\u0010-J\u0017\u00101\u001a\u0002002\u0006\u0010/\u001a\u00020.H'¢\u0006\u0004\b1\u00102J\u0017\u00106\u001a\u0002052\u0006\u00104\u001a\u000203H'¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u0002092\u0006\u0010\u0003\u001a\u000208H'¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020=2\u0006\u00104\u001a\u00020<H'¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020A2\u0006\u0010\u0003\u001a\u00020@H'¢\u0006\u0004\bB\u0010CJ\u0017\u0010G\u001a\u00020F2\u0006\u0010E\u001a\u00020DH'¢\u0006\u0004\bG\u0010H¨\u0006I"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/di/NotificationCenterLandingRecommendsFragmentModule$Declarations;", "", "Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemPresenterImpl;", "presenter", "Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemPresenter;", "bindNotificationCenterLandingRecommendsAdvertItemPresenter", "(Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemPresenterImpl;)Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemPresenter;", "Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemView;", "Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItem;", "bindNotificationCenterLandingRecommendsAdvertItemBlueprint", "(Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItemPresenterImpl;", "Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItemPresenter;", "bindNotificationCenterLandingRecommendsHeaderItemPresenter", "(Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItemPresenterImpl;)Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItemPresenter;", "Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItemBlueprint;", "Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItemView;", "Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItem;", "bindNotificationCenterLandingRecommendsHeaderItemBlueprint", "(Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemPresenterImpl;", "Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemPresenter;", "bindNotificationCenterLandingRecommendsReviewItemPresenter", "(Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemPresenterImpl;)Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemPresenter;", "Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemBlueprint;", "Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemView;", "Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItem;", "bindNotificationCenterLandingRecommendsReviewItemBlueprint", "(Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItemPresenterImpl;", "Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItemPresenter;", "bindNotificationCenterLandingRecommendsTitleItemPresenter", "(Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItemPresenterImpl;)Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItemPresenter;", "Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItemBlueprint;", "Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItemView;", "Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItem;", "bindNotificationCenterLandingRecommendsTitleItemBlueprint", "(Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/FavoriteStatusResolverImpl;", "resolver", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "bindFavoriteStatusResolver", "(Lcom/avito/android/serp/adapter/FavoriteStatusResolverImpl;)Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsConverterImpl;", "converter", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsConverter;", "bindNotificationCenterLandingRecommendsConverter", "(Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsConverterImpl;)Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsConverter;", "Lcom/avito/android/shared_providers/SupportEmailResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "bindSupportEmailResourceProvider", "(Lcom/avito/android/shared_providers/SupportEmailResourceProviderImpl;)Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "bindFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;)Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "Lcom/avito/android/favorite/FavoriteAdvertsResourceProviderImpl;", "Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "bindFavoriteAdvertsResourceProvider", "(Lcom/avito/android/favorite/FavoriteAdvertsResourceProviderImpl;)Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsPresenterImpl;", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsPresenter;", "bindNotificationCenterLandingRecommendsPresenter", "(Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsPresenterImpl;)Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsPresenter;", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsInteractorImpl;", "onteractor", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsInteractor;", "bindNotificationCenterLandingRecommendsInteractor", "(Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsInteractorImpl;)Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsInteractor;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        FavoriteAdvertsPresenter bindFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenterImpl favoriteAdvertsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteAdvertsResourceProvider bindFavoriteAdvertsResourceProvider(@NotNull FavoriteAdvertsResourceProviderImpl favoriteAdvertsResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteStatusResolver bindFavoriteStatusResolver(@NotNull FavoriteStatusResolverImpl favoriteStatusResolverImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<NotificationCenterLandingRecommendsAdvertItemView, NotificationCenterLandingRecommendsAdvertItem> bindNotificationCenterLandingRecommendsAdvertItemBlueprint(@NotNull NotificationCenterLandingRecommendsAdvertItemBlueprint notificationCenterLandingRecommendsAdvertItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        NotificationCenterLandingRecommendsAdvertItemPresenter bindNotificationCenterLandingRecommendsAdvertItemPresenter(@NotNull NotificationCenterLandingRecommendsAdvertItemPresenterImpl notificationCenterLandingRecommendsAdvertItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        NotificationCenterLandingRecommendsConverter bindNotificationCenterLandingRecommendsConverter(@NotNull NotificationCenterLandingRecommendsConverterImpl notificationCenterLandingRecommendsConverterImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<NotificationCenterLandingRecommendsHeaderItemView, NotificationCenterLandingRecommendsHeaderItem> bindNotificationCenterLandingRecommendsHeaderItemBlueprint(@NotNull NotificationCenterLandingRecommendsHeaderItemBlueprint notificationCenterLandingRecommendsHeaderItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        NotificationCenterLandingRecommendsHeaderItemPresenter bindNotificationCenterLandingRecommendsHeaderItemPresenter(@NotNull NotificationCenterLandingRecommendsHeaderItemPresenterImpl notificationCenterLandingRecommendsHeaderItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        NotificationCenterLandingRecommendsInteractor bindNotificationCenterLandingRecommendsInteractor(@NotNull NotificationCenterLandingRecommendsInteractorImpl notificationCenterLandingRecommendsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        NotificationCenterLandingRecommendsPresenter bindNotificationCenterLandingRecommendsPresenter(@NotNull NotificationCenterLandingRecommendsPresenterImpl notificationCenterLandingRecommendsPresenterImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<NotificationCenterLandingRecommendsReviewItemView, NotificationCenterLandingRecommendsReviewItem> bindNotificationCenterLandingRecommendsReviewItemBlueprint(@NotNull NotificationCenterLandingRecommendsReviewItemBlueprint notificationCenterLandingRecommendsReviewItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        NotificationCenterLandingRecommendsReviewItemPresenter bindNotificationCenterLandingRecommendsReviewItemPresenter(@NotNull NotificationCenterLandingRecommendsReviewItemPresenterImpl notificationCenterLandingRecommendsReviewItemPresenterImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<NotificationCenterLandingRecommendsTitleItemView, NotificationCenterLandingRecommendsTitleItem> bindNotificationCenterLandingRecommendsTitleItemBlueprint(@NotNull NotificationCenterLandingRecommendsTitleItemBlueprint notificationCenterLandingRecommendsTitleItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        NotificationCenterLandingRecommendsTitleItemPresenter bindNotificationCenterLandingRecommendsTitleItemPresenter(@NotNull NotificationCenterLandingRecommendsTitleItemPresenterImpl notificationCenterLandingRecommendsTitleItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SupportEmailResourceProvider bindSupportEmailResourceProvider(@NotNull SupportEmailResourceProviderImpl supportEmailResourceProviderImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder(@NotNull NotificationCenterLandingRecommendsAdvertItemBlueprint notificationCenterLandingRecommendsAdvertItemBlueprint, @NotNull NotificationCenterLandingRecommendsHeaderItemBlueprint notificationCenterLandingRecommendsHeaderItemBlueprint, @NotNull NotificationCenterLandingRecommendsReviewItemBlueprint notificationCenterLandingRecommendsReviewItemBlueprint, @NotNull NotificationCenterLandingRecommendsTitleItemBlueprint notificationCenterLandingRecommendsTitleItemBlueprint) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsAdvertItemBlueprint, "itemAdvertBlueprint");
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsHeaderItemBlueprint, "itemHeaderBlueprint");
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsReviewItemBlueprint, "itemReviewBlueprint");
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsTitleItemBlueprint, "itemTitleBlueprint");
        return new ItemBinder.Builder().registerItem(notificationCenterLandingRecommendsAdvertItemBlueprint).registerItem(notificationCenterLandingRecommendsHeaderItemBlueprint).registerItem(notificationCenterLandingRecommendsReviewItemBlueprint).registerItem(notificationCenterLandingRecommendsTitleItemBlueprint).build();
    }
}

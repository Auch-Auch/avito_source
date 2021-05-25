package com.avito.android.favorite_sellers.di;

import android.app.Application;
import androidx.core.app.NotificationManagerCompat;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.common.CounterInteractor;
import com.avito.android.di.FavoriteSellers;
import com.avito.android.di.PerFragment;
import com.avito.android.favorite_sellers.FavoriteSellerAdvertsStatusProcessor;
import com.avito.android.favorite_sellers.FavoriteSellerAdvertsStatusProcessorImpl;
import com.avito.android.favorite_sellers.FavoriteSellersConverter;
import com.avito.android.favorite_sellers.FavoriteSellersConverterImpl;
import com.avito.android.favorite_sellers.FavoriteSellersInteractor;
import com.avito.android.favorite_sellers.FavoriteSellersInteractorImpl;
import com.avito.android.favorite_sellers.FavoriteSellersPresenter;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.FavoriteSellersResourceProvider;
import com.avito.android.favorite_sellers.FavoriteSellersResourceProviderImpl;
import com.avito.android.favorite_sellers.ReadScreenMode;
import com.avito.android.favorite_sellers.ScreenMode;
import com.avito.android.favorite_sellers.ScreenModeAnalytics;
import com.avito.android.favorite_sellers.ScreenModeButtons;
import com.avito.android.favorite_sellers.ScreenModeInteractor;
import com.avito.android.favorite_sellers.TabOpenAnalytics;
import com.avito.android.favorite_sellers.TabOpenAnalyticsImpl;
import com.avito.android.favorite_sellers.TabOpenAnalyticsStub;
import com.avito.android.favorite_sellers.WriteScreenMode;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemView;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractorImpl;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersSyncInteractor;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersSyncInteractorImpl;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractorImpl;
import com.avito.android.favorite_sellers.interactor.SubscribersReadInteractor;
import com.avito.android.favorite_sellers.interactor.SubscriptionsReadInteractor;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.notification_manager_provider.NotificationManagerModule;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistryImpl;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenterImpl;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.google.android.exoplayer2.util.MimeTypes;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004LMNOB\t\b\u0002¢\u0006\u0004\bJ\u0010KJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019JC\u0010'\u001a\u00020$2\b\b\u0001\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001d2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001dH\u0001¢\u0006\u0004\b%\u0010&J=\u00103\u001a\u00020\u001e2\n\b\u0001\u0010)\u001a\u0004\u0018\u00010(2\b\b\u0001\u0010*\u001a\u00020(2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0004\b1\u00102J9\u0010<\u001a\u00020 2\u0006\u0010,\u001a\u00020+2\b\b\u0001\u00105\u001a\u0002042\u0006\u00100\u001a\u00020/2\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u000208H\u0001¢\u0006\u0004\b:\u0010;J\u0017\u0010A\u001a\u00020\"2\u0006\u0010>\u001a\u00020=H\u0001¢\u0006\u0004\b?\u0010@J\u001f\u0010I\u001a\u00020F2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020DH\u0001¢\u0006\u0004\bG\u0010H¨\u0006P"}, d2 = {"Lcom/avito/android/favorite_sellers/di/FavoriteSellersModule;", "", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", "advertListItemPresenter", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry$favorite_sellers_release", "(Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;)Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "callableResponsiveItemPresenterRegistry", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter$favorite_sellers_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;)Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder$favorite_sellers_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Landroidx/core/app/NotificationManagerCompat;", "provideNotificationManager$favorite_sellers_release", "(Landroid/app/Application;)Landroidx/core/app/NotificationManagerCompat;", "provideNotificationManager", "", "editable", "Ldagger/Lazy;", "Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersReadInteractor;", "readInteractor", "Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersWriteInteractor;", "writeInteractor", "Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersSyncInteractor;", "syncInteractor", "Lcom/avito/android/favorite_sellers/ScreenMode;", "provideScreenMode$favorite_sellers_release", "(ZLdagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)Lcom/avito/android/favorite_sellers/ScreenMode;", "provideScreenMode", "", "userKey", "dataType", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/remote/FavoriteSellersApi;", "api", "provideFavoriteSellersReadInteractor$favorite_sellers_release", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/remote/FavoriteSellersApi;)Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersReadInteractor;", "provideFavoriteSellersReadInteractor", "Lcom/avito/android/common/CounterInteractor;", "favoriteSellersCounterInteractor", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", "Lcom/avito/android/Features;", "features", "provideFavoriteSellersWriteInteractor$favorite_sellers_release", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/common/CounterInteractor;Lcom/avito/android/remote/FavoriteSellersApi;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/Features;)Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersWriteInteractor;", "provideFavoriteSellersWriteInteractor", "Lcom/avito/android/FavoriteSellersRepository;", "favoriteSellersRepository", "provideFavoriteSellersSyncInteractor$favorite_sellers_release", "(Lcom/avito/android/FavoriteSellersRepository;)Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersSyncInteractor;", "provideFavoriteSellersSyncInteractor", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/favorite_sellers/ScreenModeAnalytics;", "screenModeAnalytics", "Lcom/avito/android/favorite_sellers/TabOpenAnalytics;", "provideTabOpenAnalyrics$favorite_sellers_release", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/favorite_sellers/ScreenModeAnalytics;)Lcom/avito/android/favorite_sellers/TabOpenAnalytics;", "provideTabOpenAnalyrics", "<init>", "()V", "DataType", "Declarations", "Editable", "UserKey", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class, NotificationManagerModule.class})
public final class FavoriteSellersModule {
    @NotNull
    public static final FavoriteSellersModule INSTANCE = new FavoriteSellersModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/favorite_sellers/di/FavoriteSellersModule$DataType;", "", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface DataType {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H'¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H'¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\"\u001a\u00020!H'¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020)2\u0006\u0010\"\u001a\u00020!H'¢\u0006\u0004\b*\u0010+J\u0017\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020,H'¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u0002012\u0006\u0010-\u001a\u00020\fH'¢\u0006\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/avito/android/favorite_sellers/di/FavoriteSellersModule$Declarations;", "", "Lcom/avito/android/favorite_sellers/FavoriteSellersInteractorImpl;", "interactor", "Lcom/avito/android/favorite_sellers/FavoriteSellersInteractor;", "bindFavoriteSellersInteractor", "(Lcom/avito/android/favorite_sellers/FavoriteSellersInteractorImpl;)Lcom/avito/android/favorite_sellers/FavoriteSellersInteractor;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationInteractor;", "bindRecommendationInteractor", "(Lcom/avito/android/favorite_sellers/FavoriteSellersInteractor;)Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationInteractor;", "Lcom/avito/android/favorite_sellers/FavoriteSellersPresenterImpl;", "presenter", "Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter;", "bindFavoriteSellersPresenter", "(Lcom/avito/android/favorite_sellers/FavoriteSellersPresenterImpl;)Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter;", "Lcom/avito/android/favorite_sellers/FavoriteSellersConverterImpl;", "Lcom/avito/android/favorite_sellers/FavoriteSellersConverter;", "bindFavoriteSellersConverter", "(Lcom/avito/android/favorite_sellers/FavoriteSellersConverterImpl;)Lcom/avito/android/favorite_sellers/FavoriteSellersConverter;", "Lcom/avito/android/favorite_sellers/FavoriteSellersResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/favorite_sellers/FavoriteSellersResourceProvider;", "bindFavoriteSellersResourceProvider", "(Lcom/avito/android/favorite_sellers/FavoriteSellersResourceProviderImpl;)Lcom/avito/android/favorite_sellers/FavoriteSellersResourceProvider;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", "relay", "Lio/reactivex/rxjava3/core/Observable;", "bindObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/favorite_sellers/ScreenMode;", "screenMode", "Lcom/avito/android/favorite_sellers/ScreenModeButtons;", "bindScreenModeButtons", "(Lcom/avito/android/favorite_sellers/ScreenMode;)Lcom/avito/android/favorite_sellers/ScreenModeButtons;", "Lcom/avito/android/favorite_sellers/ScreenModeInteractor;", "bindScreenModeInteractor", "(Lcom/avito/android/favorite_sellers/ScreenMode;)Lcom/avito/android/favorite_sellers/ScreenModeInteractor;", "Lcom/avito/android/favorite_sellers/ScreenModeAnalytics;", "bindScreenModeAnalytics", "(Lcom/avito/android/favorite_sellers/ScreenMode;)Lcom/avito/android/favorite_sellers/ScreenModeAnalytics;", "Lcom/avito/android/favorite_sellers/FavoriteSellerAdvertsStatusProcessorImpl;", "impl", "Lcom/avito/android/favorite_sellers/FavoriteSellerAdvertsStatusProcessor;", "bindFavoriteSellerAdvertsStatusProcessor", "(Lcom/avito/android/favorite_sellers/FavoriteSellerAdvertsStatusProcessorImpl;)Lcom/avito/android/favorite_sellers/FavoriteSellerAdvertsStatusProcessor;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "bindAdvertItemListener", "(Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter;)Lcom/avito/android/serp/adapter/AdvertItemListener;", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        AdvertItemListener bindAdvertItemListener(@NotNull FavoriteSellersPresenter favoriteSellersPresenter);

        @Binds
        @NotNull
        @PerFragment
        Consumer<FavoriteSellersItemAction> bindConsumer(@NotNull PublishRelay<FavoriteSellersItemAction> publishRelay);

        @PerFragment
        @Binds
        @NotNull
        FavoriteSellerAdvertsStatusProcessor bindFavoriteSellerAdvertsStatusProcessor(@NotNull FavoriteSellerAdvertsStatusProcessorImpl favoriteSellerAdvertsStatusProcessorImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteSellersConverter bindFavoriteSellersConverter(@NotNull FavoriteSellersConverterImpl favoriteSellersConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteSellersInteractor bindFavoriteSellersInteractor(@NotNull FavoriteSellersInteractorImpl favoriteSellersInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteSellersPresenter bindFavoriteSellersPresenter(@NotNull FavoriteSellersPresenterImpl favoriteSellersPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteSellersResourceProvider bindFavoriteSellersResourceProvider(@NotNull FavoriteSellersResourceProviderImpl favoriteSellersResourceProviderImpl);

        @Binds
        @NotNull
        @PerFragment
        Observable<FavoriteSellersItemAction> bindObservable(@NotNull PublishRelay<FavoriteSellersItemAction> publishRelay);

        @PerFragment
        @Binds
        @NotNull
        RecommendationInteractor bindRecommendationInteractor(@NotNull FavoriteSellersInteractor favoriteSellersInteractor);

        @PerFragment
        @Binds
        @NotNull
        ScreenModeAnalytics bindScreenModeAnalytics(@NotNull ScreenMode screenMode);

        @PerFragment
        @Binds
        @NotNull
        ScreenModeButtons bindScreenModeButtons(@NotNull ScreenMode screenMode);

        @PerFragment
        @Binds
        @NotNull
        ScreenModeInteractor bindScreenModeInteractor(@NotNull ScreenMode screenMode);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/favorite_sellers/di/FavoriteSellersModule$Editable;", "", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Editable {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/favorite_sellers/di/FavoriteSellersModule$UserKey;", "", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface UserKey {
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ResponsiveAdapterPresenter provideAdapterPresenter$favorite_sellers_release(@NotNull AdapterPresenter adapterPresenter, @NotNull CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(callableResponsiveItemPresenterRegistry, "callableResponsiveItemPresenterRegistry");
        return new ResponsiveAdapterPresenterImpl(adapterPresenter, callableResponsiveItemPresenterRegistry);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$favorite_sellers_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final FavoriteSellersReadInteractor provideFavoriteSellersReadInteractor$favorite_sellers_release(@UserKey @Nullable String str, @DataType @NotNull String str2, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AccountStateProvider accountStateProvider, @NotNull FavoriteSellersApi favoriteSellersApi) {
        Intrinsics.checkNotNullParameter(str2, "dataType");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(favoriteSellersApi, "api");
        int hashCode = str2.hashCode();
        if (hashCode != 841859339) {
            if (hashCode == 1987365622 && str2.equals("subscriptions")) {
                if (str == null) {
                    str = "";
                }
                return new SubscriptionsReadInteractor(str, schedulersFactory3, favoriteSellersApi);
            }
        } else if (str2.equals(SubscribersReadInteractor.TYPE)) {
            if (str == null) {
                str = "";
            }
            return new SubscribersReadInteractor(str, schedulersFactory3, favoriteSellersApi);
        }
        return new FavoriteSellersReadInteractorImpl(schedulersFactory3, accountStateProvider, favoriteSellersApi);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final FavoriteSellersSyncInteractor provideFavoriteSellersSyncInteractor$favorite_sellers_release(@NotNull FavoriteSellersRepository favoriteSellersRepository) {
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "favoriteSellersRepository");
        return new FavoriteSellersSyncInteractorImpl(favoriteSellersRepository);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final FavoriteSellersWriteInteractor provideFavoriteSellersWriteInteractor$favorite_sellers_release(@NotNull SchedulersFactory3 schedulersFactory3, @FavoriteSellers @NotNull CounterInteractor counterInteractor, @NotNull FavoriteSellersApi favoriteSellersApi, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(counterInteractor, "favoriteSellersCounterInteractor");
        Intrinsics.checkNotNullParameter(favoriteSellersApi, "api");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        return new FavoriteSellersWriteInteractorImpl("favorite_sellers", schedulersFactory3, counterInteractor, notificationManagerProvider, favoriteSellersApi, features);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final NotificationManagerCompat provideNotificationManager$favorite_sellers_release(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        NotificationManagerCompat from = NotificationManagerCompat.from(application);
        Intrinsics.checkNotNullExpressionValue(from, "NotificationManagerCompat.from(application)");
        return from;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CallableResponsiveItemPresenterRegistry provideResponsiveItemPresenterRegistry$favorite_sellers_release(@NotNull AdvertListItemPresenter advertListItemPresenter) {
        Intrinsics.checkNotNullParameter(advertListItemPresenter, "advertListItemPresenter");
        CallableResponsiveItemPresenterRegistryImpl callableResponsiveItemPresenterRegistryImpl = new CallableResponsiveItemPresenterRegistryImpl();
        callableResponsiveItemPresenterRegistryImpl.register(AdvertListItemView.class, advertListItemPresenter);
        return callableResponsiveItemPresenterRegistryImpl;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ScreenMode provideScreenMode$favorite_sellers_release(@Editable boolean z, @NotNull Lazy<FavoriteSellersReadInteractor> lazy, @NotNull Lazy<FavoriteSellersWriteInteractor> lazy2, @NotNull Lazy<FavoriteSellersSyncInteractor> lazy3) {
        Intrinsics.checkNotNullParameter(lazy, "readInteractor");
        Intrinsics.checkNotNullParameter(lazy2, "writeInteractor");
        Intrinsics.checkNotNullParameter(lazy3, "syncInteractor");
        if (!z) {
            FavoriteSellersReadInteractor favoriteSellersReadInteractor = lazy.get();
            Intrinsics.checkNotNullExpressionValue(favoriteSellersReadInteractor, "readInteractor.get()");
            return new ReadScreenMode(favoriteSellersReadInteractor);
        }
        FavoriteSellersReadInteractor favoriteSellersReadInteractor2 = lazy.get();
        Intrinsics.checkNotNullExpressionValue(favoriteSellersReadInteractor2, "readInteractor.get()");
        FavoriteSellersWriteInteractor favoriteSellersWriteInteractor = lazy2.get();
        Intrinsics.checkNotNullExpressionValue(favoriteSellersWriteInteractor, "writeInteractor.get()");
        FavoriteSellersSyncInteractor favoriteSellersSyncInteractor = lazy3.get();
        Intrinsics.checkNotNullExpressionValue(favoriteSellersSyncInteractor, "syncInteractor.get()");
        return new WriteScreenMode(favoriteSellersReadInteractor2, favoriteSellersWriteInteractor, favoriteSellersSyncInteractor);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TabOpenAnalytics provideTabOpenAnalyrics$favorite_sellers_release(@NotNull Analytics analytics, @NotNull ScreenModeAnalytics screenModeAnalytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(screenModeAnalytics, "screenModeAnalytics");
        if (screenModeAnalytics.getShouldTrackOpenTabEvent()) {
            return new TabOpenAnalyticsImpl(analytics);
        }
        return new TabOpenAnalyticsStub();
    }
}

package com.avito.android.public_profile.di;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentManager;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.design.widget.tab.TabPagerAdapter;
import com.avito.android.di.PerFragment;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerModule;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.public_profile.ui.PublicProfileInteractor;
import com.avito.android.public_profile.ui.PublicProfileInteractorImpl;
import com.avito.android.public_profile.ui.PublicProfilePresenter;
import com.avito.android.public_profile.ui.PublicProfilePresenterImpl;
import com.avito.android.public_profile.ui.PublicProfileResourceProvider;
import com.avito.android.public_profile.ui.PublicProfileResourceProviderImpl;
import com.avito.android.public_profile.ui.SubscribeInteractor;
import com.avito.android.public_profile.ui.SubscriptionStateListener;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenterImpl;
import com.avito.android.public_profile.ui.SubscriptionsResourceProvider;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.google.android.exoplayer2.util.MimeTypes;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.functions.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0006@ABCDEB\t\b\u0002¢\u0006\u0004\b>\u0010?J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ@\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0019\u0010\u0012\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010¢\u0006\u0002\b\u00110\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b#\u0010$Jk\u0010<\u001a\u00020;2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\n\b\u0001\u00106\u001a\u0004\u0018\u0001052\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u000209H\u0007¢\u0006\u0004\b<\u0010=¨\u0006F"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileFragmentModule;", "", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/ui/adapter/tab/BaseTabItem;", "provideTabsDataProvider", "()Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "Landroid/app/Activity;", "activity", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "provideTabsLayout$public_profile_release", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Landroid/app/Activity;)Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "provideTabsLayout", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/avito/android/design/widget/tab/TabBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "provideTabPagerAdapterProvider", "(Landroidx/fragment/app/FragmentManager;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Ljava/util/Set;)Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Formatter;", "", "providesErrorFormatter$public_profile_release", "(Landroid/content/res/Resources;)Lcom/avito/android/util/Formatter;", "providesErrorFormatter", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Landroidx/core/app/NotificationManagerCompat;", "provideNotificationManager", "(Landroid/app/Application;)Landroidx/core/app/NotificationManagerCompat;", "Lcom/avito/android/public_profile/ui/SubscriptionStateListener;", "provideSubscriptionStateListener", "()Lcom/avito/android/public_profile/ui/SubscriptionStateListener;", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", "Lcom/avito/android/FavoriteSellersRepository;", "favoriteSellersRepository", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "resourceProvider", "Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "interactor", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/Kundle;", "state", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "provideSubscriptionsPresenter", "(Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/FavoriteSellersRepository;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;Lcom/avito/android/public_profile/ui/SubscribeInteractor;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/Kundle;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/Features;)Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "<init>", "()V", "ContextId", "Dependencies", "PresenterState", "SubscriptionsState", "Tracker", "UserKey", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, ErrorHelperModule.class, NotificationManagerModule.class})
public final class PublicProfileFragmentModule {
    @NotNull
    public static final PublicProfileFragmentModule INSTANCE = new PublicProfileFragmentModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileFragmentModule$ContextId;", "", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ContextId {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H'¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileFragmentModule$Dependencies;", "", "Lcom/avito/android/public_profile/ui/PublicProfileResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/public_profile/ui/PublicProfileResourceProvider;", "bindPublicProfileResourceProvider", "(Lcom/avito/android/public_profile/ui/PublicProfileResourceProviderImpl;)Lcom/avito/android/public_profile/ui/PublicProfileResourceProvider;", "Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "bindSubscriptionsResourceProvider", "(Lcom/avito/android/public_profile/ui/PublicProfileResourceProviderImpl;)Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "Lcom/avito/android/public_profile/ui/PublicProfileInteractorImpl;", "interactor", "Lcom/avito/android/public_profile/ui/PublicProfileInteractor;", "bindPublicProfileInteractor", "(Lcom/avito/android/public_profile/ui/PublicProfileInteractorImpl;)Lcom/avito/android/public_profile/ui/PublicProfileInteractor;", "Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "bindSubscribeInteractor", "(Lcom/avito/android/public_profile/ui/PublicProfileInteractorImpl;)Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "Lcom/avito/android/public_profile/ui/PublicProfilePresenterImpl;", "presenter", "Lcom/avito/android/public_profile/ui/PublicProfilePresenter;", "bindPublicProfilePresenter", "(Lcom/avito/android/public_profile/ui/PublicProfilePresenterImpl;)Lcom/avito/android/public_profile/ui/PublicProfilePresenter;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "", "refreshEvent", "Lio/reactivex/rxjava3/functions/Consumer;", "bindRefreshEvent", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        PublicProfileInteractor bindPublicProfileInteractor(@NotNull PublicProfileInteractorImpl publicProfileInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        PublicProfilePresenter bindPublicProfilePresenter(@NotNull PublicProfilePresenterImpl publicProfilePresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        PublicProfileResourceProvider bindPublicProfileResourceProvider(@NotNull PublicProfileResourceProviderImpl publicProfileResourceProviderImpl);

        @Binds
        @NotNull
        @PerFragment
        Consumer<Unit> bindRefreshEvent(@NotNull PublishRelay<Unit> publishRelay);

        @PerFragment
        @Binds
        @NotNull
        SubscribeInteractor bindSubscribeInteractor(@NotNull PublicProfileInteractorImpl publicProfileInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SubscriptionsResourceProvider bindSubscriptionsResourceProvider(@NotNull PublicProfileResourceProviderImpl publicProfileResourceProviderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileFragmentModule$PresenterState;", "", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface PresenterState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileFragmentModule$SubscriptionsState;", "", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface SubscriptionsState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileFragmentModule$Tracker;", "", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Tracker {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileFragmentModule$UserKey;", "", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface UserKey {
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final NotificationManagerCompat provideNotificationManager(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        NotificationManagerCompat from = NotificationManagerCompat.from(application);
        Intrinsics.checkNotNullExpressionValue(from, "NotificationManagerCompat.from(application)");
        return from;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SubscriptionStateListener provideSubscriptionStateListener() {
        return new SubscriptionStateListener() { // from class: com.avito.android.public_profile.di.PublicProfileFragmentModule$provideSubscriptionStateListener$1
            @Override // com.avito.android.public_profile.ui.SubscriptionStateListener
            public void onSubscribeInfoChanged(@Nullable SubscribeInfo subscribeInfo) {
            }
        };
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SubscriptionsPresenter provideSubscriptionsPresenter(@NotNull NotificationManagerProvider notificationManagerProvider, @NotNull FavoriteSellersRepository favoriteSellersRepository, @NotNull AccountStateProvider accountStateProvider, @NotNull SubscriptionsResourceProvider subscriptionsResourceProvider, @NotNull SubscribeInteractor subscribeInteractor, @NotNull ErrorHelper errorHelper, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3, @SubscriptionsState @Nullable Kundle kundle, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "favoriteSellersRepository");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(subscriptionsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(subscribeInteractor, "interactor");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SubscriptionsPresenterImpl(notificationManagerProvider, favoriteSellersRepository, accountStateProvider, subscriptionsResourceProvider, subscribeInteractor, errorHelper, null, schedulersFactory3, analytics, kundle, SubscriptionSource.PUBLIC_PROFILE, compositeSnackbarPresenter, features);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TabPagerAdapter provideTabPagerAdapterProvider(@NotNull FragmentManager fragmentManager, @NotNull TabsDataProvider<BaseTabItem> tabsDataProvider, @NotNull Set<TabBlueprint<? extends BaseTabItem>> set) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(set, "blueprints");
        return new TabPagerAdapter(fragmentManager, tabsDataProvider, set, TabPagerAdapter.Behaviour.RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TabsDataProvider<BaseTabItem> provideTabsDataProvider() {
        return new TabsDataProvider<>();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TabLayoutAdapter<BaseTabItem> provideTabsLayout$public_profile_release(@NotNull TabsDataProvider<BaseTabItem> tabsDataProvider, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new TabLayoutAdapter<>(tabsDataProvider, activity, 0, 4, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final Formatter<Throwable> providesErrorFormatter$public_profile_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }
}

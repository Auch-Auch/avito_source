package com.avito.android.messenger.channels.mvi.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.ab_tests.groups.AdCascadesInChannelsTestGroup;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.fps.FpsMetricsSupplier;
import com.avito.android.analytics.screens.fps.FpsMetricsTracker;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.cart_fab.CartFabModule_ProvideCartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabPreferences;
import com.avito.android.cart_fab.CartFabPreferencesImpl;
import com.avito.android.cart_fab.CartFabPreferencesImpl_Factory;
import com.avito.android.cart_fab.CartFabQuantityVisibilityHandler_Factory;
import com.avito.android.cart_fab.CartFabRepository;
import com.avito.android.cart_fab.CartFabRepositoryImpl;
import com.avito.android.cart_fab.CartFabRepositoryImpl_Factory;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabViewModelFactory_Factory;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.date_time_formatter.RelativeDateFormatter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.item_visibility_tracker.filters.BannerViewFilter;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.SavedLocationInteractorImpl;
import com.avito.android.location.SavedLocationInteractorImpl_Factory;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.location.back_navigation.BackNavigationLocationInteractor;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.analytics.graphite_counter.ChatListAppendCounter;
import com.avito.android.messenger.analytics.graphite_counter.ChatListAppendCounter_Factory;
import com.avito.android.messenger.analytics.graphite_counter.ChatListLoadingResult;
import com.avito.android.messenger.analytics.graphite_counter.ChatListRefreshResult;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.channels.action_banner.ChannelsBannerShowTimeStorage;
import com.avito.android.messenger.channels.analytics.ChannelsTracker;
import com.avito.android.messenger.channels.analytics.ChannelsTrackerImpl;
import com.avito.android.messenger.channels.analytics.ChannelsTrackerImpl_Factory;
import com.avito.android.messenger.channels.mvi.data.ChannelContextSerializer;
import com.avito.android.messenger.channels.mvi.data.ChannelEntityConverter;
import com.avito.android.messenger.channels.mvi.data.ChannelEntityConverterImpl;
import com.avito.android.messenger.channels.mvi.data.ChannelEntityConverterImpl_Factory;
import com.avito.android.messenger.channels.mvi.data.ChannelPropertySerializer;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoImpl;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoImpl_Factory;
import com.avito.android.messenger.channels.mvi.data.UserEntityConverter;
import com.avito.android.messenger.channels.mvi.data.UserEntityConverterImpl;
import com.avito.android.messenger.channels.mvi.data.UserEntityConverterImpl_Factory;
import com.avito.android.messenger.channels.mvi.di.ChannelsComponent;
import com.avito.android.messenger.channels.mvi.di.ChannelsListComponent;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractorImpl;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractorImpl_Factory;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorImpl;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorImpl_Factory;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProvider;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProviderImpl;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProviderImpl_Factory;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl_Factory;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl_Factory;
import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractor;
import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractorImpl;
import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractorImpl_Factory;
import com.avito.android.messenger.channels.mvi.presenter.ChannelListAdBannerItemFactoryImpl;
import com.avito.android.messenger.channels.mvi.presenter.ChannelListAdBannerItemFactoryImpl_Factory;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl_Factory;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl_Factory;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenterImpl;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenterImpl_Factory;
import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenterImpl;
import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenterImpl_Factory;
import com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProviderImpl;
import com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProviderImpl_Factory;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.channels.mvi.view.ChannelsFragment;
import com.avito.android.messenger.channels.mvi.view.ChannelsFragment_MembersInjector;
import com.avito.android.messenger.channels.mvi.view.ChannelsListFragment;
import com.avito.android.messenger.channels.mvi.view.ChannelsListFragment_MembersInjector;
import com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandler;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandlerImpl;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandlerImpl_Factory;
import com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverter;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverterImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverterImpl_Factory;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoImpl_Factory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideChannelDao$messenger_releaseFactory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideChannelMetaInfoDao$messenger_releaseFactory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideChannelTagDao$messenger_releaseFactory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideDraftDao$messenger_releaseFactory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideMessageMetaInfoDao$messenger_releaseFactory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideUserDao$messenger_releaseFactory;
import com.avito.android.messenger.di.RelativeDateFormatterModule;
import com.avito.android.messenger.di.RelativeDateFormatterModule_ProvideRelativeDateFormatterFactory;
import com.avito.android.messenger.folders.FolderOnboardingStatusStorage;
import com.avito.android.messenger.service.OpenErrorTrackerSchedulerImpl;
import com.avito.android.messenger.service.OpenErrorTrackerSchedulerImpl_Factory;
import com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.cart.CartApi;
import com.avito.android.serp.BannerInfoFactory;
import com.avito.android.serp.BannerInfoFactoryImpl_Factory;
import com.avito.android.serp.CommercialBannerTimeProviderImpl;
import com.avito.android.serp.CommercialBannerTimeProviderImpl_Factory;
import com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl;
import com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl_Factory;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.CommercialBannersInteractorImpl;
import com.avito.android.serp.CommercialBannersInteractorImpl_Factory;
import com.avito.android.serp.ad.DfpBannerLoader;
import com.avito.android.serp.ad.DfpBannerLoaderImpl;
import com.avito.android.serp.ad.DfpBannerLoaderImpl_Factory;
import com.avito.android.serp.ad.MyTargetBannerLoader;
import com.avito.android.serp.ad.MyTargetBannerLoaderImpl;
import com.avito.android.serp.ad.MyTargetBannerLoaderImpl_Factory;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.serp.ad.YandexBannerLoader;
import com.avito.android.serp.ad.YandexBannerLoaderImpl;
import com.avito.android.serp.ad.YandexBannerLoaderImpl_Factory;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.google.common.base.Optional;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import io.reactivex.Observable;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import javax.inject.Provider;
import kotlin.Pair;
import ru.avito.android.persistence.messenger.ChannelDao;
import ru.avito.android.persistence.messenger.ChannelMetaInfoDao;
import ru.avito.android.persistence.messenger.ChannelTagDao;
import ru.avito.android.persistence.messenger.DraftDao;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessageMetaInfoDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.android.persistence.messenger.UserDao;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerChannelsComponent implements ChannelsComponent {
    public static final Provider V0 = InstanceFactory.create(Optional.absent());
    public Provider<Analytics> A;
    public Provider<SavedLocationStorage> A0;
    public Provider<FoldersPresenterImpl> B;
    public Provider<LocationApi> B0;
    public Provider<FoldersInteractorImpl> C;
    public Provider<TopLocationInteractor> C0;
    public Provider<Map<Class<?>, Provider<ViewModel>>> D;
    public Provider<BackNavigationLocationInteractor> D0;
    public Provider<ViewModelStoreOwner> E;
    public Provider<DfpBannerLoaderImpl> E0;
    public Provider<CartApi> F;
    public Provider<DfpBannerLoader> F0;
    public Provider<SchedulersFactory3> G;
    public Provider<YandexBannerLoaderImpl> G0;
    public Provider<CartFabRepositoryImpl> H;
    public Provider<YandexBannerLoader> H0;
    public Provider<CartFabRepository> I;
    public Provider<MyTargetBannerLoaderImpl> I0;
    public Provider<Preferences> J;
    public Provider<MyTargetBannerLoader> J0;
    public Provider<CartFabPreferencesImpl> K;
    public Provider<BannerPageSource> K0;
    public Provider<CartFabPreferences> L;
    public Provider<TreeStateIdGenerator> L0;
    public Provider<Optional<SearchContextWrapper>> M;
    public Provider<TreeClickStreamParent> M0;
    public Provider<CartFabViewModelFactory> N;
    public Provider<CommercialBannersAnalyticsInteractorImpl> N0;
    public Provider<CartFabViewModel> O;
    public Provider<BannerInfoFactory> O0;
    public Provider<CartQuantityChangesHandler> P;
    public Provider<CommercialBannersInteractorImpl> P0;
    public Provider<TimeSource> Q;
    public Provider<CommercialBannersInteractor> Q0;
    public Provider<Locale> R;
    public Provider<PreferenceFactory> R0;
    public Provider<Resources> S;
    public Provider<Preferences> S0;
    public Provider<ChannelSyncAgent> T;
    public Provider<MessageMetaInfoDao> T0;
    public Provider<MessengerDatabase> U;
    public Provider<ChannelMetaInfoDao> U0;
    public Provider<ChannelDao> V;
    public Provider<DraftDao> W;
    public Provider<UserDao> X;
    public Provider<MessageDao> Y;
    public Provider<ChannelTagDao> Z;
    public final ChannelsDependencies a;
    public Provider<MessageBodySerializer> a0;
    public final Fragment b;
    public Provider<MessageEntityConverterImpl> b0;
    public final BannerPageSource c;
    public Provider<MessageEntityConverter> c0;
    public final ScreenAnalyticsDependencies d;
    public Provider<ChannelPropertySerializer> d0;
    public final Screen e;
    public Provider<UserEntityConverterImpl> e0;
    public Provider<ScreenTrackerFactory> f;
    public Provider<UserEntityConverter> f0;
    public Provider<TimerFactory> g;
    public Provider<ChannelContextSerializer> g0;
    public Provider<ScreenDiInjectTracker> h;
    public Provider<ChannelEntityConverterImpl> h0;
    public Provider<ScreenInitTracker> i = DoubleCheck.provider(ChannelsModule_ProvidesScreenInitTrackerFactory.create(this.f, this.g));
    public Provider<ChannelEntityConverter> i0;
    public Provider<ScreenFlowTrackerProvider> j;
    public Provider<ChannelRepoImpl> j0;
    public Provider<Features> k;
    public Provider<ChannelRepo> k0;
    public Provider<ChannelsTrackerImpl> l;
    public Provider<UserLastActivitySyncAgent> l0;
    public Provider<ChannelsTracker> m;
    public Provider<AnalyticsTimer<ChatListLoadingResult>> m0;
    public Provider<AccountStateProvider> n;
    public Provider<AnalyticsTimer<ChatListRefreshResult>> n0;
    public Provider<SchedulersFactory> o;
    public Provider<Context> o0;
    public Provider<ChannelsErrorInteractorImpl> p;
    public Provider<OpenErrorTrackerSchedulerImpl> p0;
    public Provider<MessengerClient<AvitoMessengerApi>> q;
    public Provider<MessengerEntityConverter> q0;
    public Provider<ViewModelFactory> r;
    public Provider<AttributedTextFormatter> r0;
    public Provider<Fragment> s;
    public Provider<LocalMessagePreviewProviderImpl> s0;
    public Provider<ChannelsErrorInteractor> t;
    public Provider<ChannelsListDataConverterImpl> t0;
    public Provider<BlockUserInteractor> u;
    public Provider<ChannelsBannerShowTimeStorage> u0;
    public Provider<ChannelsHeaderPresenterImpl> v;
    public Provider<NotificationManagerProvider> v0;
    public Provider<FoldersInteractor> w;
    public Provider<Formatter<Throwable>> w0;
    public Provider<SharedPreferences> x;
    public Provider<SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup>> x0;
    public Provider<FolderOnboardingStatusStorage> y;
    public Provider<MyTargetImageBgProvider> y0;
    public Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> z;
    public Provider<BuildInfo> z0;

    public static class a0 implements Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> {
        public final ChannelsDependencies a;

        public a0(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> get() {
            return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.messengerFolderTabsTestGroup());
        }
    }

    public static final class b implements ChannelsComponent.Builder {
        public Fragment a;
        public Screen b;
        public ScreenAnalyticsDependencies c;
        public Resources d;
        public BannerPageSource e;
        public ChannelsDependencies f;
        public LocationDependencies g;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsComponent.Builder
        public ChannelsComponent.Builder adBannerPageSource(BannerPageSource bannerPageSource) {
            this.e = (BannerPageSource) Preconditions.checkNotNull(bannerPageSource);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsComponent.Builder
        public ChannelsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Fragment.class);
            Preconditions.checkBuilderRequirement(this.b, Screen.class);
            Preconditions.checkBuilderRequirement(this.c, ScreenAnalyticsDependencies.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, BannerPageSource.class);
            Preconditions.checkBuilderRequirement(this.f, ChannelsDependencies.class);
            Preconditions.checkBuilderRequirement(this.g, LocationDependencies.class);
            return new DaggerChannelsComponent(this.f, this.g, this.c, this.a, this.b, this.d, this.e, null);
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsComponent.Builder
        public ChannelsComponent.Builder channelsMviDependencies(ChannelsDependencies channelsDependencies) {
            this.f = (ChannelsDependencies) Preconditions.checkNotNull(channelsDependencies);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsComponent.Builder
        public ChannelsComponent.Builder fragment(Fragment fragment) {
            this.a = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsComponent.Builder
        public ChannelsComponent.Builder locationDependencies(LocationDependencies locationDependencies) {
            this.g = (LocationDependencies) Preconditions.checkNotNull(locationDependencies);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsComponent.Builder
        @Deprecated
        public ChannelsComponent.Builder relativeDateFormatterModule(RelativeDateFormatterModule relativeDateFormatterModule) {
            Preconditions.checkNotNull(relativeDateFormatterModule);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsComponent.Builder
        public ChannelsComponent.Builder resources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsComponent.Builder
        public ChannelsComponent.Builder screen(Screen screen) {
            this.b = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsComponent.Builder
        public ChannelsComponent.Builder screenAnalyticsDependencies(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.c = (ScreenAnalyticsDependencies) Preconditions.checkNotNull(screenAnalyticsDependencies);
            return this;
        }
    }

    public static class b0 implements Provider<MyTargetImageBgProvider> {
        public final ChannelsDependencies a;

        public b0(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MyTargetImageBgProvider get() {
            return (MyTargetImageBgProvider) Preconditions.checkNotNullFromComponent(this.a.myTargetImageBgProvider());
        }
    }

    public final class c implements ChannelsListComponent.Builder {
        public Pair<? extends SortedSet<String>, ? extends SortedSet<String>> a;
        public Pair<? extends SortedSet<String>, ? extends SortedSet<String>> b;
        public Pair<? extends SortedSet<String>, ? extends SortedSet<String>> c;
        public ChannelsListState d;
        public ChannelsBannerInteractor.State e;
        public ChannelsLastMessageProvider.State f;
        public Bundle g;

        public c(a aVar) {
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsListComponent.Builder
        public ChannelsListComponent.Builder bindMainTags(Pair pair) {
            this.a = (Pair) Preconditions.checkNotNull(pair);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsListComponent.Builder
        public ChannelsListComponent.Builder bindMergedTags(Pair pair) {
            this.c = (Pair) Preconditions.checkNotNull(pair);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsListComponent.Builder
        public ChannelsListComponent.Builder bindPinnedTags(Pair pair) {
            this.b = pair;
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsListComponent.Builder
        public ChannelsListComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Pair.class);
            Preconditions.checkBuilderRequirement(this.c, Pair.class);
            Preconditions.checkBuilderRequirement(this.d, ChannelsListState.class);
            Preconditions.checkBuilderRequirement(this.e, ChannelsBannerInteractor.State.class);
            Preconditions.checkBuilderRequirement(this.f, ChannelsLastMessageProvider.State.class);
            return new d(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsListComponent.Builder
        public ChannelsListComponent.Builder defaultChannelBannerInteractorState(ChannelsBannerInteractor.State state) {
            this.e = (ChannelsBannerInteractor.State) Preconditions.checkNotNull(state);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsListComponent.Builder
        public ChannelsListComponent.Builder defaultChannelsLastMessageProvidedState(ChannelsLastMessageProvider.State state) {
            this.f = (ChannelsLastMessageProvider.State) Preconditions.checkNotNull(state);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsListComponent.Builder
        public ChannelsListComponent.Builder defaultPresenterState(ChannelsListState channelsListState) {
            this.d = (ChannelsListState) Preconditions.checkNotNull(channelsListState);
            return this;
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsListComponent.Builder
        public ChannelsListComponent.Builder itemVisibilityTrackerState(Bundle bundle) {
            this.g = bundle;
            return this;
        }
    }

    public static class c0 implements Provider<NotificationManagerProvider> {
        public final ChannelsDependencies a;

        public c0(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationManagerProvider get() {
            return (NotificationManagerProvider) Preconditions.checkNotNullFromComponent(this.a.notificationManagerProvider());
        }
    }

    public final class d implements ChannelsListComponent {
        public Provider<DatabaseErrorHandlerImpl> A;
        public Provider<DatabaseErrorHandler> B;
        public Provider<MessageRepoImpl> C;
        public Provider<MessageRepo> D;
        public Provider<ChannelsLastMessageProviderImpl> E;
        public Provider<Map<Class<?>, Provider<ViewModel>>> F;
        public final Pair<? extends SortedSet<String>, ? extends SortedSet<String>> a;
        public final Pair<? extends SortedSet<String>, ? extends SortedSet<String>> b;
        public final Pair<? extends SortedSet<String>, ? extends SortedSet<String>> c;
        public final Bundle d;
        public Provider<RelativeDateFormatter> e;
        public Provider<ViewModelFactory> f;
        public Provider<ChannelsErrorInteractor> g;
        public Provider<ChannelsHeaderPresenterImpl> h;
        public Provider<FoldersInteractor> i;
        public Provider<FoldersPresenterImpl> j;
        public Provider<ChatListAppendCounter> k;
        public Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> l;
        public Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> m;
        public Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> n;
        public Provider<ChannelsListInteractorImpl> o;
        public Provider<ChannelsListState> p;
        public Provider<ChannelsListInteractor> q;
        public Provider<ChannelsBannerInteractor.State> r;
        public Provider<ChannelsBannerInteractorImpl> s;
        public Provider<ChatListAdBannerInteractor> t;
        public Provider<ChannelListAdBannerItemFactoryImpl> u;
        public Provider<ChannelsListPresenterImpl> v;
        public Provider<SavedLocationInteractorImpl> w;
        public Provider<SavedLocationInteractor> x;
        public Provider<ChatListAdBannerInteractorImpl> y;
        public Provider<ChannelsLastMessageProvider.State> z;

        public d(Pair pair, Pair pair2, Pair pair3, ChannelsListState channelsListState, ChannelsBannerInteractor.State state, ChannelsLastMessageProvider.State state2, Bundle bundle, a aVar) {
            this.a = pair;
            this.b = pair2;
            this.c = pair3;
            this.d = bundle;
            this.e = SingleCheck.provider(RelativeDateFormatterModule_ProvideRelativeDateFormatterFactory.create(DaggerChannelsComponent.this.Q, DaggerChannelsComponent.this.R, DaggerChannelsComponent.this.S));
            DelegateFactory delegateFactory = new DelegateFactory();
            this.f = delegateFactory;
            ChannelsModule_ProvideChannelsErrorInteractorFactory create = ChannelsModule_ProvideChannelsErrorInteractorFactory.create(delegateFactory, DaggerChannelsComponent.this.s);
            this.g = create;
            this.h = ChannelsHeaderPresenterImpl_Factory.create(DaggerChannelsComponent.this.o, DaggerChannelsComponent.this.q, create, DaggerChannelsComponent.this.u);
            ChannelsModule_ProvideFoldersInteractorFactory create2 = ChannelsModule_ProvideFoldersInteractorFactory.create(this.f, DaggerChannelsComponent.this.s);
            this.i = create2;
            this.j = FoldersPresenterImpl_Factory.create(DaggerChannelsComponent.this.o, create2, DaggerChannelsComponent.this.y, DaggerChannelsComponent.this.z, DaggerChannelsComponent.this.A);
            this.k = ChatListAppendCounter_Factory.create(DaggerChannelsComponent.this.A, DaggerChannelsComponent.this.k);
            this.l = InstanceFactory.create(pair);
            this.m = InstanceFactory.createNullable(pair2);
            Factory create3 = InstanceFactory.create(pair3);
            this.n = create3;
            this.o = ChannelsListInteractorImpl_Factory.create(DaggerChannelsComponent.this.o, DaggerChannelsComponent.this.k, DaggerChannelsComponent.this.n, DaggerChannelsComponent.this.q, DaggerChannelsComponent.this.T, DaggerChannelsComponent.this.k0, DaggerChannelsComponent.this.l0, DaggerChannelsComponent.this.m0, DaggerChannelsComponent.this.n0, this.k, DaggerChannelsComponent.this.m, DaggerChannelsComponent.this.A, DaggerChannelsComponent.this.p0, this.g, this.l, this.m, create3, DaggerChannelsComponent.this.z);
            this.p = InstanceFactory.create(channelsListState);
            this.q = ChannelsListModule_ProvideChannelsListInteractorFactory.create(this.f, DaggerChannelsComponent.this.s, this.l, this.m, this.n);
            Factory create4 = InstanceFactory.create(state);
            this.r = create4;
            this.s = ChannelsBannerInteractorImpl_Factory.create(create4, DaggerChannelsComponent.this.o, DaggerChannelsComponent.this.Q, DaggerChannelsComponent.this.u0, DaggerChannelsComponent.this.v0, DaggerChannelsComponent.this.A, ChannelsModule_ProvideChannelsBannerDismissPeriodFactory.create());
            this.t = ChannelsListModule_ProvideChatListAdBannerInteractorFactory.create(this.f, DaggerChannelsComponent.this.s, this.l, this.m, this.n);
            ChannelListAdBannerItemFactoryImpl_Factory create5 = ChannelListAdBannerItemFactoryImpl_Factory.create(DaggerChannelsComponent.this.x0, DaggerChannelsComponent.this.G, DaggerChannelsComponent.this.y0, DaggerChannelsComponent.this.k);
            this.u = create5;
            this.v = ChannelsListPresenterImpl_Factory.create(this.p, DaggerChannelsComponent.this.o, DaggerChannelsComponent.this.t0, this.q, this.s, DaggerChannelsComponent.this.w0, DaggerChannelsComponent.this.A, DaggerChannelsComponent.this.m, this.t, create5, DaggerChannelsComponent.this.k, DaggerChannelsComponent.this.z);
            SavedLocationInteractorImpl_Factory create6 = SavedLocationInteractorImpl_Factory.create(DaggerChannelsComponent.this.A0, DaggerChannelsComponent.this.B0, DaggerChannelsComponent.this.C0, DaggerChannelsComponent.this.k, DaggerChannelsComponent.this.D0);
            this.w = create6;
            Provider<SavedLocationInteractor> provider = SingleCheck.provider(create6);
            this.x = provider;
            this.y = ChatListAdBannerInteractorImpl_Factory.create(DaggerChannelsComponent.this.o, DaggerChannelsComponent.this.q, DaggerChannelsComponent.this.z0, provider, DaggerChannelsComponent.this.Q0, DaggerChannelsComponent.this.N0, DaggerChannelsComponent.this.S0, DaggerChannelsComponent.this.Q, DaggerChannelsComponent.this.x0, DaggerChannelsComponent.this.k);
            this.z = InstanceFactory.create(state2);
            DatabaseErrorHandlerImpl_Factory create7 = DatabaseErrorHandlerImpl_Factory.create(DaggerChannelsComponent.this.o0, DaggerChannelsComponent.this.U, DaggerChannelsComponent.this.o, DaggerChannelsComponent.this.A);
            this.A = create7;
            Provider<DatabaseErrorHandler> provider2 = SingleCheck.provider(create7);
            this.B = provider2;
            MessageRepoImpl_Factory create8 = MessageRepoImpl_Factory.create(DaggerChannelsComponent.this.Y, DaggerChannelsComponent.this.T0, DaggerChannelsComponent.this.U0, DaggerChannelsComponent.this.c0, provider2);
            this.C = create8;
            Provider<MessageRepo> provider3 = SingleCheck.provider(create8);
            this.D = provider3;
            this.E = ChannelsLastMessageProviderImpl_Factory.create(this.z, DaggerChannelsComponent.this.o, provider3);
            MapProviderFactory build = MapProviderFactory.builder(8).put((MapProviderFactory.Builder) ChannelsErrorInteractorImpl.class, (Provider) DaggerChannelsComponent.this.p).put((MapProviderFactory.Builder) ChannelsHeaderPresenterImpl.class, (Provider) this.h).put((MapProviderFactory.Builder) FoldersPresenterImpl.class, (Provider) this.j).put((MapProviderFactory.Builder) FoldersInteractorImpl.class, (Provider) DaggerChannelsComponent.this.C).put((MapProviderFactory.Builder) ChannelsListInteractorImpl.class, (Provider) this.o).put((MapProviderFactory.Builder) ChannelsListPresenterImpl.class, (Provider) this.v).put((MapProviderFactory.Builder) ChatListAdBannerInteractorImpl.class, (Provider) this.y).put((MapProviderFactory.Builder) ChannelsLastMessageProviderImpl.class, (Provider) this.E).build();
            this.F = build;
            DelegateFactory.setDelegate(this.f, SingleCheck.provider(ViewModelFactory_Factory.create(build)));
        }

        @Override // com.avito.android.messenger.channels.mvi.di.ChannelsListComponent
        public void inject(ChannelsListFragment channelsListFragment) {
            ChannelsListFragment_MembersInjector.injectDateFormatter(channelsListFragment, this.e.get());
            ChannelsListFragment_MembersInjector.injectAnalytics(channelsListFragment, (Analytics) Preconditions.checkNotNullFromComponent(DaggerChannelsComponent.this.a.analytics()));
            ChannelsListFragment_MembersInjector.injectFeatures(channelsListFragment, (Features) Preconditions.checkNotNullFromComponent(DaggerChannelsComponent.this.a.features()));
            ChannelsListFragment_MembersInjector.injectPerfTracker(channelsListFragment, DaggerChannelsComponent.this.m.get());
            ChannelsListFragment_MembersInjector.injectChannelsListPresenter(channelsListFragment, ChannelsListModule_ProvideChannelsListPresenterFactory.provideChannelsListPresenter(this.f.get(), DaggerChannelsComponent.this.b, this.a, this.b, this.c));
            ChannelsListFragment_MembersInjector.injectActivityIntentFactory(channelsListFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(DaggerChannelsComponent.this.a.activityIntentFactory()));
            DaggerChannelsComponent daggerChannelsComponent = DaggerChannelsComponent.this;
            ChannelsListFragment_MembersInjector.injectItemVisibilityTracker(channelsListFragment, ChannelsListModule_ProvideItemVisibilityTracker$messenger_releaseFactory.provideItemVisibilityTracker$messenger_release(new BannerViewFilter(new CommercialBannersAnalyticsInteractorImpl(daggerChannelsComponent.c, (Analytics) Preconditions.checkNotNullFromComponent(daggerChannelsComponent.a.analytics()), daggerChannelsComponent.M0, (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(daggerChannelsComponent.a.treeStateIdGenerator()), new CommercialBannerTimeProviderImpl())), this.d));
            DaggerChannelsComponent daggerChannelsComponent2 = DaggerChannelsComponent.this;
            ChannelsListFragment_MembersInjector.injectSupplier(channelsListFragment, new FpsStateSupplier(new FpsMetricsSupplier.Impl((Observable) Preconditions.checkNotNullFromComponent(daggerChannelsComponent2.d.frameStream()), (FpsMetricsTracker) Preconditions.checkNotNullFromComponent(daggerChannelsComponent2.d.fpsMetricsTracker()), daggerChannelsComponent2.e, daggerChannelsComponent2.d.fpsTrackingThreshold(), (Features) Preconditions.checkNotNullFromComponent(daggerChannelsComponent2.a.features())), (BuildInfo) Preconditions.checkNotNullFromComponent(DaggerChannelsComponent.this.a.buildInfo())));
        }
    }

    public static class d0 implements Provider<PreferenceFactory> {
        public final ChannelsDependencies a;

        public d0(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PreferenceFactory get() {
            return (PreferenceFactory) Preconditions.checkNotNullFromComponent(this.a.preferenceFactory());
        }
    }

    public static class e implements Provider<ScreenTrackerFactory> {
        public final ScreenAnalyticsDependencies a;

        public e(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class e0 implements Provider<Preferences> {
        public final ChannelsDependencies a;

        public e0(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class f implements Provider<TimerFactory> {
        public final ScreenAnalyticsDependencies a;

        public f(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class f0 implements Provider<SchedulersFactory3> {
        public final ChannelsDependencies a;

        public f0(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class g implements Provider<BackNavigationLocationInteractor> {
        public final LocationDependencies a;

        public g(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BackNavigationLocationInteractor get() {
            return (BackNavigationLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.backNavigationLocationInteractor());
        }
    }

    public static class g0 implements Provider<SchedulersFactory> {
        public final ChannelsDependencies a;

        public g0(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<LocationApi> {
        public final LocationDependencies a;

        public h(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class h0 implements Provider<SharedPreferences> {
        public final ChannelsDependencies a;

        public h0(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SharedPreferences get() {
            return (SharedPreferences) Preconditions.checkNotNullFromComponent(this.a.sharedPreferences());
        }
    }

    public static class i implements Provider<SavedLocationStorage> {
        public final LocationDependencies a;

        public i(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SavedLocationStorage get() {
            return (SavedLocationStorage) Preconditions.checkNotNullFromComponent(this.a.savedLocationStorage());
        }
    }

    public static class i0 implements Provider<TimeSource> {
        public final ChannelsDependencies a;

        public i0(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class j implements Provider<TopLocationInteractor> {
        public final LocationDependencies a;

        public j(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TopLocationInteractor get() {
            return (TopLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.topLocationInteractor());
        }
    }

    public static class j0 implements Provider<TreeStateIdGenerator> {
        public final ChannelsDependencies a;

        public j0(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TreeStateIdGenerator get() {
            return (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(this.a.treeStateIdGenerator());
        }
    }

    public static class k implements Provider<AccountStateProvider> {
        public final ChannelsDependencies a;

        public k(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class k0 implements Provider<UserLastActivitySyncAgent> {
        public final ChannelsDependencies a;

        public k0(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserLastActivitySyncAgent get() {
            return (UserLastActivitySyncAgent) Preconditions.checkNotNullFromComponent(this.a.userLastActivitySyncAgent());
        }
    }

    public static class l implements Provider<SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup>> {
        public final ChannelsDependencies a;

        public l(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.adCascadesInChannelsTestGroup());
        }
    }

    public static class m implements Provider<Analytics> {
        public final ChannelsDependencies a;

        public m(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class n implements Provider<BlockUserInteractor> {
        public final ChannelsDependencies a;

        public n(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BlockUserInteractor get() {
            return (BlockUserInteractor) Preconditions.checkNotNullFromComponent(this.a.blockUserInteractor());
        }
    }

    public static class o implements Provider<BuildInfo> {
        public final ChannelsDependencies a;

        public o(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class p implements Provider<CartApi> {
        public final ChannelsDependencies a;

        public p(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CartApi get() {
            return (CartApi) Preconditions.checkNotNullFromComponent(this.a.cartApi());
        }
    }

    public static class q implements Provider<ChannelContextSerializer> {
        public final ChannelsDependencies a;

        public q(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ChannelContextSerializer get() {
            return (ChannelContextSerializer) Preconditions.checkNotNullFromComponent(this.a.channelContextSerializer());
        }
    }

    public static class r implements Provider<ChannelPropertySerializer> {
        public final ChannelsDependencies a;

        public r(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ChannelPropertySerializer get() {
            return (ChannelPropertySerializer) Preconditions.checkNotNullFromComponent(this.a.channelPropertySerializer());
        }
    }

    public static class s implements Provider<ChannelSyncAgent> {
        public final ChannelsDependencies a;

        public s(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ChannelSyncAgent get() {
            return (ChannelSyncAgent) Preconditions.checkNotNullFromComponent(this.a.channelsSyncAgent());
        }
    }

    public static class t implements Provider<Context> {
        public final ChannelsDependencies a;

        public t(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class u implements Provider<Features> {
        public final ChannelsDependencies a;

        public u(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class v implements Provider<Locale> {
        public final ChannelsDependencies a;

        public v(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class w implements Provider<MessageBodySerializer> {
        public final ChannelsDependencies a;

        public w(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessageBodySerializer get() {
            return (MessageBodySerializer) Preconditions.checkNotNullFromComponent(this.a.messageBodySerializer());
        }
    }

    public static class x implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final ChannelsDependencies a;

        public x(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public static class y implements Provider<MessengerDatabase> {
        public final ChannelsDependencies a;

        public y(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerDatabase get() {
            return (MessengerDatabase) Preconditions.checkNotNullFromComponent(this.a.messengerDatabase());
        }
    }

    public static class z implements Provider<MessengerEntityConverter> {
        public final ChannelsDependencies a;

        public z(ChannelsDependencies channelsDependencies) {
            this.a = channelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerEntityConverter get() {
            return (MessengerEntityConverter) Preconditions.checkNotNullFromComponent(this.a.messengerEntityConverter());
        }
    }

    public DaggerChannelsComponent(ChannelsDependencies channelsDependencies, LocationDependencies locationDependencies, ScreenAnalyticsDependencies screenAnalyticsDependencies, Fragment fragment, Screen screen, Resources resources, BannerPageSource bannerPageSource, a aVar) {
        this.a = channelsDependencies;
        this.b = fragment;
        this.c = bannerPageSource;
        this.d = screenAnalyticsDependencies;
        this.e = screen;
        e eVar = new e(screenAnalyticsDependencies);
        this.f = eVar;
        f fVar = new f(screenAnalyticsDependencies);
        this.g = fVar;
        this.h = DoubleCheck.provider(ChannelsModule_ProvidesScreenDiInjectTracker$messenger_releaseFactory.create(eVar, fVar));
        Provider<ScreenFlowTrackerProvider> provider = DoubleCheck.provider(ChannelsModule_ProvidesScreenFlowTrackerProviderFactory.create(this.f, this.g));
        this.j = provider;
        u uVar = new u(channelsDependencies);
        this.k = uVar;
        ChannelsTrackerImpl_Factory create = ChannelsTrackerImpl_Factory.create(this.h, this.i, provider, uVar);
        this.l = create;
        this.m = DoubleCheck.provider(create);
        k kVar = new k(channelsDependencies);
        this.n = kVar;
        g0 g0Var = new g0(channelsDependencies);
        this.o = g0Var;
        this.p = ChannelsErrorInteractorImpl_Factory.create(kVar, g0Var);
        this.q = new x(channelsDependencies);
        this.r = new DelegateFactory();
        Factory create2 = InstanceFactory.create(fragment);
        this.s = create2;
        ChannelsModule_ProvideChannelsErrorInteractorFactory create3 = ChannelsModule_ProvideChannelsErrorInteractorFactory.create(this.r, create2);
        this.t = create3;
        n nVar = new n(channelsDependencies);
        this.u = nVar;
        this.v = ChannelsHeaderPresenterImpl_Factory.create(this.o, this.q, create3, nVar);
        this.w = ChannelsModule_ProvideFoldersInteractorFactory.create(this.r, this.s);
        h0 h0Var = new h0(channelsDependencies);
        this.x = h0Var;
        ChannelsModule_ProvideFoldersOnboardingStatusStorageFactory create4 = ChannelsModule_ProvideFoldersOnboardingStatusStorageFactory.create(h0Var);
        this.y = create4;
        a0 a0Var = new a0(channelsDependencies);
        this.z = a0Var;
        m mVar = new m(channelsDependencies);
        this.A = mVar;
        this.B = FoldersPresenterImpl_Factory.create(this.o, this.w, create4, a0Var, mVar);
        this.C = FoldersInteractorImpl_Factory.create(this.o, this.z, this.q);
        MapProviderFactory build = MapProviderFactory.builder(4).put((MapProviderFactory.Builder) ChannelsErrorInteractorImpl.class, (Provider) this.p).put((MapProviderFactory.Builder) ChannelsHeaderPresenterImpl.class, (Provider) this.v).put((MapProviderFactory.Builder) FoldersPresenterImpl.class, (Provider) this.B).put((MapProviderFactory.Builder) FoldersInteractorImpl.class, (Provider) this.C).build();
        this.D = build;
        DelegateFactory.setDelegate(this.r, SingleCheck.provider(ViewModelFactory_Factory.create(build)));
        this.E = DoubleCheck.provider(this.s);
        p pVar = new p(channelsDependencies);
        this.F = pVar;
        f0 f0Var = new f0(channelsDependencies);
        this.G = f0Var;
        CartFabRepositoryImpl_Factory create5 = CartFabRepositoryImpl_Factory.create(pVar, f0Var);
        this.H = create5;
        this.I = SingleCheck.provider(create5);
        e0 e0Var = new e0(channelsDependencies);
        this.J = e0Var;
        CartFabPreferencesImpl_Factory create6 = CartFabPreferencesImpl_Factory.create(e0Var);
        this.K = create6;
        Provider<CartFabPreferences> provider2 = SingleCheck.provider(create6);
        this.L = provider2;
        Provider<Optional<SearchContextWrapper>> provider3 = V0;
        this.M = provider3;
        CartFabViewModelFactory_Factory create7 = CartFabViewModelFactory_Factory.create(this.k, this.I, provider2, this.n, this.G, this.A, provider3);
        this.N = create7;
        this.O = SingleCheck.provider(CartFabModule_ProvideCartFabViewModelFactory.create(this.E, create7));
        this.P = SingleCheck.provider(CartFabQuantityVisibilityHandler_Factory.create());
        this.Q = new i0(channelsDependencies);
        this.R = new v(channelsDependencies);
        this.S = InstanceFactory.create(resources);
        this.T = new s(channelsDependencies);
        y yVar = new y(channelsDependencies);
        this.U = yVar;
        this.V = MessengerRepoModule_ProvideChannelDao$messenger_releaseFactory.create(yVar);
        this.W = MessengerRepoModule_ProvideDraftDao$messenger_releaseFactory.create(this.U);
        this.X = MessengerRepoModule_ProvideUserDao$messenger_releaseFactory.create(this.U);
        this.Y = MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory.create(this.U);
        this.Z = MessengerRepoModule_ProvideChannelTagDao$messenger_releaseFactory.create(this.U);
        w wVar = new w(channelsDependencies);
        this.a0 = wVar;
        MessageEntityConverterImpl_Factory create8 = MessageEntityConverterImpl_Factory.create(wVar);
        this.b0 = create8;
        this.c0 = SingleCheck.provider(create8);
        r rVar = new r(channelsDependencies);
        this.d0 = rVar;
        UserEntityConverterImpl_Factory create9 = UserEntityConverterImpl_Factory.create(rVar);
        this.e0 = create9;
        Provider<UserEntityConverter> provider4 = SingleCheck.provider(create9);
        this.f0 = provider4;
        q qVar = new q(channelsDependencies);
        this.g0 = qVar;
        ChannelEntityConverterImpl_Factory create10 = ChannelEntityConverterImpl_Factory.create(this.c0, provider4, qVar, this.d0);
        this.h0 = create10;
        Provider<ChannelEntityConverter> provider5 = SingleCheck.provider(create10);
        this.i0 = provider5;
        ChannelRepoImpl_Factory create11 = ChannelRepoImpl_Factory.create(this.V, this.W, this.X, this.Y, this.Z, provider5);
        this.j0 = create11;
        this.k0 = SingleCheck.provider(create11);
        this.l0 = new k0(channelsDependencies);
        this.m0 = ChannelsModule_ProvideChatListLoadingTimerFactory.create(this.A, this.k);
        this.n0 = ChannelsModule_ProvideChatListRefreshTimerFactory.create(this.A, this.k);
        t tVar = new t(channelsDependencies);
        this.o0 = tVar;
        this.p0 = OpenErrorTrackerSchedulerImpl_Factory.create(tVar);
        this.q0 = new z(channelsDependencies);
        Provider<AttributedTextFormatter> provider6 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.r0 = provider6;
        LocalMessagePreviewProviderImpl_Factory create12 = LocalMessagePreviewProviderImpl_Factory.create(this.o0, provider6);
        this.s0 = create12;
        this.t0 = ChannelsListDataConverterImpl_Factory.create(this.s, this.q0, this.S, create12, this.Q, this.k);
        this.u0 = ChannelsModule_ProvideChannelsBannerShowTimeStorageFactory.create(this.x);
        this.v0 = new c0(channelsDependencies);
        this.w0 = ChannelsModule_ProvideErrorFormatterFactory.create(this.S);
        this.x0 = new l(channelsDependencies);
        this.y0 = new b0(channelsDependencies);
        o oVar = new o(channelsDependencies);
        this.z0 = oVar;
        this.A0 = new i(locationDependencies);
        this.B0 = new h(locationDependencies);
        this.C0 = new j(locationDependencies);
        this.D0 = new g(locationDependencies);
        DfpBannerLoaderImpl_Factory create13 = DfpBannerLoaderImpl_Factory.create(this.o0, this.A, oVar, this.k);
        this.E0 = create13;
        this.F0 = DoubleCheck.provider(create13);
        YandexBannerLoaderImpl_Factory create14 = YandexBannerLoaderImpl_Factory.create(this.o0, this.G, this.A);
        this.G0 = create14;
        this.H0 = DoubleCheck.provider(create14);
        MyTargetBannerLoaderImpl_Factory create15 = MyTargetBannerLoaderImpl_Factory.create(this.o0, this.A, this.y0);
        this.I0 = create15;
        this.J0 = DoubleCheck.provider(create15);
        this.K0 = InstanceFactory.create(bannerPageSource);
        j0 j0Var = new j0(channelsDependencies);
        this.L0 = j0Var;
        Provider<TreeClickStreamParent> provider7 = DoubleCheck.provider(ChannelsModule_ProvideTreeParent$messenger_releaseFactory.create(j0Var));
        this.M0 = provider7;
        this.N0 = CommercialBannersAnalyticsInteractorImpl_Factory.create(this.K0, this.A, provider7, this.L0, CommercialBannerTimeProviderImpl_Factory.create());
        this.O0 = DoubleCheck.provider(BannerInfoFactoryImpl_Factory.create());
        CommercialBannersInteractorImpl_Factory create16 = CommercialBannersInteractorImpl_Factory.create(this.F0, this.H0, this.J0, this.N0, CommercialBannerTimeProviderImpl_Factory.create(), this.G, this.O0);
        this.P0 = create16;
        this.Q0 = DoubleCheck.provider(create16);
        d0 d0Var = new d0(channelsDependencies);
        this.R0 = d0Var;
        this.S0 = ChannelsModule_ProvideMessengerAdsPreferencesFactory.create(this.o0, d0Var);
        this.T0 = MessengerRepoModule_ProvideMessageMetaInfoDao$messenger_releaseFactory.create(this.U);
        this.U0 = MessengerRepoModule_ProvideChannelMetaInfoDao$messenger_releaseFactory.create(this.U);
    }

    public static ChannelsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.channels.mvi.di.ChannelsComponent
    public void inject(ChannelsFragment channelsFragment) {
        ChannelsFragment_MembersInjector.injectAnalytics(channelsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        ChannelsFragment_MembersInjector.injectFeatures(channelsFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        ChannelsFragment_MembersInjector.injectPerfTracker(channelsFragment, this.m.get());
        ChannelsFragment_MembersInjector.injectChannelsHeaderPresenter(channelsFragment, ChannelsModule_ProvideChannelsHeaderPresenterFactory.provideChannelsHeaderPresenter(this.r.get(), this.b));
        ChannelsFragment_MembersInjector.injectFoldersPresenter(channelsFragment, ChannelsModule_ProvideFoldersPresenterFactory.provideFoldersPresenter(this.r.get(), this.b));
        ChannelsFragment_MembersInjector.injectImplicitIntentFactory(channelsFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        ChannelsFragment_MembersInjector.injectActivityIntentFactory(channelsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ChannelsFragment_MembersInjector.injectDatabase(channelsFragment, (MessengerDatabase) Preconditions.checkNotNullFromComponent(this.a.messengerDatabase()));
        ChannelsFragment_MembersInjector.injectMessengerFolderTabsTestGroup(channelsFragment, (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.messengerFolderTabsTestGroup()));
        ChannelsFragment_MembersInjector.injectDeepLinkIntentFactory(channelsFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        ChannelsFragment_MembersInjector.injectSearchIconTest(channelsFragment, (SimpleTestGroup) Preconditions.checkNotNullFromComponent(this.a.messengerSearchIconTestGroup()));
        ChannelsFragment_MembersInjector.injectCartFabViewModel(channelsFragment, this.O.get());
        ChannelsFragment_MembersInjector.injectCartQuantityHandler(channelsFragment, this.P.get());
    }

    @Override // com.avito.android.messenger.channels.mvi.di.ChannelsComponent
    public ChannelsListComponent.Builder listComponentBuilder() {
        return new c(null);
    }
}

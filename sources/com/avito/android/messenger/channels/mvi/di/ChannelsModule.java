package com.avito.android.messenger.channels.mvi.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.ChannelsScreen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.cart_fab.CartFabModule;
import com.avito.android.di.CommercialBannersInteractorModule;
import com.avito.android.di.PerFragment;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.messenger.analytics.graphite_counter.ChatListLoadingResult;
import com.avito.android.messenger.analytics.graphite_counter.ChatListLoadingTimer;
import com.avito.android.messenger.analytics.graphite_counter.ChatListRefreshResult;
import com.avito.android.messenger.analytics.graphite_counter.ChatListRefreshTimer;
import com.avito.android.messenger.channels.action_banner.ChannelsBannerShowTimeStorage;
import com.avito.android.messenger.channels.action_banner.ChannelsBannerShowTimeStorageImpl;
import com.avito.android.messenger.channels.analytics.ChannelsTracker;
import com.avito.android.messenger.channels.analytics.ChannelsTrackerImpl;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorImpl;
import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractor;
import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractorImpl;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverter;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl;
import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter;
import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenterImpl;
import com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProvider;
import com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProviderImpl;
import com.avito.android.messenger.di.MessengerRepoModule;
import com.avito.android.messenger.folders.FolderOnboardingStatusStorage;
import com.avito.android.messenger.folders.FolderOnboardingStatusStorageImpl;
import com.avito.android.messenger.service.OpenErrorTrackerScheduler;
import com.avito.android.messenger.service.OpenErrorTrackerSchedulerImpl;
import com.avito.android.messenger.util.EntityConverter;
import com.avito.android.messenger.util.EntityConverterImpl;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.UrlParams;
import com.avito.android.util.preferences.Names;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeUnit;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002JKB\t\b\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J*\u0010\f\u001a\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b\u000b0\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000f\u001a\r\u0012\t\u0012\u00070\u000e¢\u0006\u0002\b\u000b0\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\rJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b'\u0010(J\u001f\u0010.\u001a\u00020-2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b.\u0010/J\u001f\u00101\u001a\u0002002\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b1\u00102J\u001f\u00104\u001a\u0002032\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b4\u00105J\u001f\u00107\u001a\u0002062\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u0002092\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b:\u0010;J\u001f\u0010@\u001a\u00020?2\u0006\u0010=\u001a\u00020<2\u0006\u0010\u001e\u001a\u00020>H\u0007¢\u0006\u0004\b@\u0010AJ\u0017\u0010G\u001a\u00020D2\u0006\u0010C\u001a\u00020BH\u0001¢\u0006\u0004\bE\u0010F¨\u0006L"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/ChannelsModule;", "", "", "provideChannelsBannerDismissPeriod", "()J", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/timer/AnalyticsTimer;", "Lcom/avito/android/messenger/analytics/graphite_counter/ChatListLoadingResult;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideChatListLoadingTimer", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Lcom/avito/android/analytics/timer/AnalyticsTimer;", "Lcom/avito/android/messenger/analytics/graphite_counter/ChatListRefreshResult;", "provideChatListRefreshTimer", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Formatter;", "", "provideErrorFormatter", "(Landroid/content/res/Resources;)Lcom/avito/android/util/Formatter;", "Landroid/content/SharedPreferences;", "preferences", "Lcom/avito/android/messenger/channels/action_banner/ChannelsBannerShowTimeStorage;", "provideChannelsBannerShowTimeStorage", "(Landroid/content/SharedPreferences;)Lcom/avito/android/messenger/channels/action_banner/ChannelsBannerShowTimeStorage;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$messenger_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractor;", "provideChannelsErrorInteractor", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractor;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter;", "provideChannelsHeaderPresenter", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter;", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter;", "provideFoldersPresenter", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter;", "Lcom/avito/android/messenger/channels/mvi/interactor/FoldersInteractor;", "provideFoldersInteractor", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/channels/mvi/interactor/FoldersInteractor;", "Lcom/avito/android/messenger/folders/FolderOnboardingStatusStorage;", "provideFoldersOnboardingStatusStorage", "(Landroid/content/SharedPreferences;)Lcom/avito/android/messenger/folders/FolderOnboardingStatusStorage;", "Landroid/content/Context;", "context", "Lcom/avito/android/util/preferences/PreferenceFactory;", "Lcom/avito/android/util/preferences/Preferences;", "provideMessengerAdsPreferences", "(Landroid/content/Context;Lcom/avito/android/util/preferences/PreferenceFactory;)Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "stateGenerator", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideTreeParent$messenger_release", "(Lcom/avito/android/analytics/provider/TreeStateIdGenerator;)Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideTreeParent", "<init>", "()V", "Declarations", "Tracker", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {MessengerRepoModule.class, Declarations.class, AttributedTextFormatterModule.class, SavedLocationInteractorModule.class, CommercialBannersInteractorModule.class, CartFabModule.class})
public final class ChannelsModule {
    @NotNull
    public static final ChannelsModule INSTANCE = new ChannelsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u001dH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020 H'¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020#H'¢\u0006\u0004\b$\u0010%J\u0017\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H'¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/ChannelsModule$Declarations;", "", "Lcom/avito/android/messenger/channels/analytics/ChannelsTrackerImpl;", "tracker", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "bindTracker", "(Lcom/avito/android/messenger/channels/analytics/ChannelsTrackerImpl;)Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListDataConverterImpl;", "implementation", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListDataConverter;", "channelsListDataConverter", "(Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListDataConverterImpl;)Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListDataConverter;", "Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProviderImpl;", "impl", "Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProvider;", "messagePreviewProvider", "(Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProviderImpl;)Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProvider;", "Lcom/avito/android/messenger/util/EntityConverterImpl;", "Lcom/avito/android/messenger/util/EntityConverter;", "entityConverter", "(Lcom/avito/android/messenger/util/EntityConverterImpl;)Lcom/avito/android/messenger/util/EntityConverter;", "Lcom/avito/android/messenger/service/OpenErrorTrackerSchedulerImpl;", "Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;", "bindOpenErrorTrackerScheduler", "(Lcom/avito/android/messenger/service/OpenErrorTrackerSchedulerImpl;)Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractorImpl;", "Landroidx/lifecycle/ViewModel;", "bindChannelsErrorInteractorViewModel", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenterImpl;", "bindChannelsHeaderPresenterViewModel", "(Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenterImpl;", "bindFoldersPresenterViewModel", "(Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/channels/mvi/interactor/FoldersInteractorImpl;", "bindFoldersInteractorViewModel", "(Lcom/avito/android/messenger/channels/mvi/interactor/FoldersInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", UrlParams.OWNER, "Landroidx/lifecycle/ViewModelStoreOwner;", "bindViewModelStoreOwner", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModelStoreOwner;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @ClassKey(ChannelsErrorInteractorImpl.class)
        @IntoMap
        ViewModel bindChannelsErrorInteractorViewModel(@NotNull ChannelsErrorInteractorImpl channelsErrorInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(ChannelsHeaderPresenterImpl.class)
        @IntoMap
        ViewModel bindChannelsHeaderPresenterViewModel(@NotNull ChannelsHeaderPresenterImpl channelsHeaderPresenterImpl);

        @Binds
        @NotNull
        @ClassKey(FoldersInteractorImpl.class)
        @IntoMap
        ViewModel bindFoldersInteractorViewModel(@NotNull FoldersInteractorImpl foldersInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(FoldersPresenterImpl.class)
        @IntoMap
        ViewModel bindFoldersPresenterViewModel(@NotNull FoldersPresenterImpl foldersPresenterImpl);

        @Binds
        @NotNull
        OpenErrorTrackerScheduler bindOpenErrorTrackerScheduler(@NotNull OpenErrorTrackerSchedulerImpl openErrorTrackerSchedulerImpl);

        @PerFragment
        @Binds
        @NotNull
        ChannelsTracker bindTracker(@NotNull ChannelsTrackerImpl channelsTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelStoreOwner bindViewModelStoreOwner(@NotNull Fragment fragment);

        @Binds
        @NotNull
        ChannelsListDataConverter channelsListDataConverter(@NotNull ChannelsListDataConverterImpl channelsListDataConverterImpl);

        @Binds
        @NotNull
        EntityConverter entityConverter(@NotNull EntityConverterImpl entityConverterImpl);

        @Binds
        @NotNull
        LocalMessagePreviewProvider messagePreviewProvider(@NotNull LocalMessagePreviewProviderImpl localMessagePreviewProviderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/ChannelsModule$Tracker;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Tracker {
    }

    @Provides
    public final long provideChannelsBannerDismissPeriod() {
        return TimeUnit.DAYS.toMillis(45);
    }

    @Provides
    @NotNull
    public final ChannelsBannerShowTimeStorage provideChannelsBannerShowTimeStorage(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        return new ChannelsBannerShowTimeStorageImpl(sharedPreferences, "channels_banner_next_show_time");
    }

    @Provides
    @NotNull
    public final ChannelsErrorInteractor provideChannelsErrorInteractor(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(ChannelsErrorInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (ChannelsErrorInteractor) viewModel;
    }

    @Provides
    @NotNull
    public final ChannelsHeaderPresenter provideChannelsHeaderPresenter(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(ChannelsHeaderPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (ChannelsHeaderPresenter) viewModel;
    }

    @Provides
    @NotNull
    public final AnalyticsTimer<ChatListLoadingResult> provideChatListLoadingTimer(@NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ChatListLoadingTimer(TimeSource.DEFAULT, analytics, features);
    }

    @Provides
    @NotNull
    public final AnalyticsTimer<ChatListRefreshResult> provideChatListRefreshTimer(@NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ChatListRefreshTimer(TimeSource.DEFAULT, analytics, features);
    }

    @Provides
    @NotNull
    public final Formatter<Throwable> provideErrorFormatter(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @NotNull
    public final FoldersInteractor provideFoldersInteractor(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(FoldersInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (FoldersInteractor) viewModel;
    }

    @Provides
    @NotNull
    public final FolderOnboardingStatusStorage provideFoldersOnboardingStatusStorage(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        return new FolderOnboardingStatusStorageImpl(sharedPreferences);
    }

    @Provides
    @NotNull
    public final FoldersPresenter provideFoldersPresenter(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(FoldersPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (FoldersPresenter) viewModel;
    }

    @Provides
    @MessengerAdsPreferences
    @NotNull
    public final Preferences provideMessengerAdsPreferences(@NotNull Context context, @NotNull PreferenceFactory preferenceFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        return preferenceFactory.getCustomPreferences(context, Names.MESSENGER_ADS);
    }

    @Provides
    @PerFragment
    @NotNull
    public final TreeClickStreamParent provideTreeParent$messenger_release(@NotNull TreeStateIdGenerator treeStateIdGenerator) {
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "stateGenerator");
        return new TreeClickStreamParent(treeStateIdGenerator.nextStateId(), ScreenIdField.CHANNELS.name(), null, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenDiInjectTracker providesScreenDiInjectTracker$messenger_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, ChannelsScreen.INSTANCE, timerFactory, null, 4, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(ChannelsScreen.INSTANCE, timerFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenInitTracker providesScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, ChannelsScreen.INSTANCE, timerFactory, null, 4, null);
    }
}

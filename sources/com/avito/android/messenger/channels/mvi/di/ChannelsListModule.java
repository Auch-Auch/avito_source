package com.avito.android.messenger.channels.mvi.di;

import a2.b.a.a.a;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.item_visibility_tracker.ItemVisibilityTrackerImpl;
import com.avito.android.item_visibility_tracker.filters.BannerViewFilter;
import com.avito.android.messenger.analytics.graphite_counter.ChatListAppendCounter;
import com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractorImpl;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProvider;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProviderImpl;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl;
import com.avito.android.messenger.channels.mvi.presenter.ChannelListAdBannerItemFactory;
import com.avito.android.messenger.channels.mvi.presenter.ChannelListAdBannerItemFactoryImpl;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenterImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import java.util.SortedSet;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0002`\t2(\b\u0001\u0010\u000b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\t2\"\u0010\f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0002`\tH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0001\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0002`\t2(\b\u0001\u0010\u000b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\t2\"\u0010\f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0002`\tH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0001\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0002`\t2(\b\u0001\u0010\u000b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\t2\"\u0010\f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0002`\tH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0001\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0002`\t2(\b\u0001\u0010\u000b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\t2\"\u0010\f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0002`\tH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010 \u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0001¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/ChannelsListModule;", "", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Landroidx/fragment/app/Fragment;", "fragment", "Lkotlin/Pair;", "Ljava/util/SortedSet;", "", "Lcom/avito/android/messenger/folders/ChatListTags;", "mainTags", "pinnedTags", "mergedTags", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenter;", "provideChannelsListPresenter", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;)Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenter;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor;", "provideChannelsListInteractor", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor;", "provideChatListAdBannerInteractor", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;)Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider;", "provideChannelsLastMessageProvider", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider;", "Lcom/avito/android/item_visibility_tracker/filters/BannerViewFilter;", "bannerViewFilter", "Landroid/os/Bundle;", "state", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker$messenger_release", "(Lcom/avito/android/item_visibility_tracker/filters/BannerViewFilter;Landroid/os/Bundle;)Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class ChannelsListModule {
    @NotNull
    public static final ChannelsListModule INSTANCE = new ChannelsListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/ChannelsListModule$Declarations;", "", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;", "impl", "Landroidx/lifecycle/ViewModel;", "bindChannelsInteractorViewModel", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenterImpl;", "bindChannelsPresenterViewModel", "(Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl;", "bindChatListAdBannerInteractorViewModel", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProviderImpl;", "channelsLastMessageProviderViewModel", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProviderImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/analytics/graphite_counter/ChatListAppendCounter;", "implementation", "Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "appendCounter", "(Lcom/avito/android/messenger/analytics/graphite_counter/ChatListAppendCounter;)Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractorImpl;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor;", "channelsBannerInteractor", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractorImpl;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelListAdBannerItemFactoryImpl;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelListAdBannerItemFactory;", "channelListAdBannerItemFactory", "(Lcom/avito/android/messenger/channels/mvi/presenter/ChannelListAdBannerItemFactoryImpl;)Lcom/avito/android/messenger/channels/mvi/presenter/ChannelListAdBannerItemFactory;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        MessengerGraphiteCounter appendCounter(@NotNull ChatListAppendCounter chatListAppendCounter);

        @Binds
        @NotNull
        @ClassKey(ChannelsListInteractorImpl.class)
        @IntoMap
        ViewModel bindChannelsInteractorViewModel(@NotNull ChannelsListInteractorImpl channelsListInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(ChannelsListPresenterImpl.class)
        @IntoMap
        ViewModel bindChannelsPresenterViewModel(@NotNull ChannelsListPresenterImpl channelsListPresenterImpl);

        @Binds
        @NotNull
        @ClassKey(ChatListAdBannerInteractorImpl.class)
        @IntoMap
        ViewModel bindChatListAdBannerInteractorViewModel(@NotNull ChatListAdBannerInteractorImpl chatListAdBannerInteractorImpl);

        @Binds
        @NotNull
        ChannelListAdBannerItemFactory channelListAdBannerItemFactory(@NotNull ChannelListAdBannerItemFactoryImpl channelListAdBannerItemFactoryImpl);

        @Binds
        @NotNull
        ChannelsBannerInteractor channelsBannerInteractor(@NotNull ChannelsBannerInteractorImpl channelsBannerInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(ChannelsLastMessageProviderImpl.class)
        @IntoMap
        ViewModel channelsLastMessageProviderViewModel(@NotNull ChannelsLastMessageProviderImpl channelsLastMessageProviderImpl);
    }

    @Provides
    @NotNull
    public final ChannelsLastMessageProvider provideChannelsLastMessageProvider(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair, @Nullable @org.jetbrains.annotations.Nullable Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair2, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair3) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(pair, "mainTags");
        Intrinsics.checkNotNullParameter(pair3, "mergedTags");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(a.C2(ChannelsLastMessageProviderImpl.class, new StringBuilder(), ':', "mainTags=" + pair + ", pinnedTags=" + pair2 + ", mergedTags=" + pair3), ChannelsLastMessageProviderImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (ChannelsLastMessageProvider) viewModel;
    }

    @Provides
    @NotNull
    public final ChannelsListInteractor provideChannelsListInteractor(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair, @Nullable @org.jetbrains.annotations.Nullable Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair2, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair3) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(pair, "mainTags");
        Intrinsics.checkNotNullParameter(pair3, "mergedTags");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(a.C2(ChannelsListInteractorImpl.class, new StringBuilder(), ':', "mainTags=" + pair + ", pinnedTags=" + pair2 + ", mergedTags=" + pair3), ChannelsListInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (ChannelsListInteractor) viewModel;
    }

    @Provides
    @NotNull
    public final ChannelsListPresenter provideChannelsListPresenter(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair, @Nullable @org.jetbrains.annotations.Nullable Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair2, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair3) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(pair, "mainTags");
        Intrinsics.checkNotNullParameter(pair3, "mergedTags");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(a.C2(ChannelsListPresenterImpl.class, new StringBuilder(), ':', "mainTags=" + pair + ", pinnedTags=" + pair2 + ", mergedTags=" + pair3), ChannelsListPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (ChannelsListPresenter) viewModel;
    }

    @Provides
    @NotNull
    public final ChatListAdBannerInteractor provideChatListAdBannerInteractor(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair, @Nullable @org.jetbrains.annotations.Nullable Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair2, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair3) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(pair, "mainTags");
        Intrinsics.checkNotNullParameter(pair3, "mergedTags");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(a.C2(ChatListAdBannerInteractorImpl.class, new StringBuilder(), ':', "mainTags=" + pair + ", pinnedTags=" + pair2 + ", mergedTags=" + pair3), ChatListAdBannerInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (ChatListAdBannerInteractor) viewModel;
    }

    @Provides
    @NotNull
    public final ItemVisibilityTracker provideItemVisibilityTracker$messenger_release(@NotNull BannerViewFilter bannerViewFilter, @ChannelsListVisibilityTrackerState @org.jetbrains.annotations.Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(bannerViewFilter, "bannerViewFilter");
        return new ItemVisibilityTrackerImpl.Builder(false, bundle).addFilter(bannerViewFilter).build();
    }
}

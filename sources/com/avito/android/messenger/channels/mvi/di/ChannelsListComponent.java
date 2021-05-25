package com.avito.android.messenger.channels.mvi.di;

import android.os.Bundle;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProvider;
import com.avito.android.messenger.channels.mvi.view.ChannelsListFragment;
import com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState;
import dagger.BindsInstance;
import dagger.Subcomponent;
import java.util.SortedSet;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Subcomponent(modules = {ChannelsListModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/ChannelsListComponent;", "", "Lcom/avito/android/messenger/channels/mvi/view/ChannelsListFragment;", "fragment", "", "inject", "(Lcom/avito/android/messenger/channels/mvi/view/ChannelsListFragment;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsListComponent {

    @Subcomponent.Builder
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J3\u0010\u0007\u001a\u00020\u00002\"\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u0002`\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\t\u001a\u00020\u00002(\b\u0001\u0010\u0006\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005H'¢\u0006\u0004\b\t\u0010\bJ3\u0010\n\u001a\u00020\u00002\"\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u0002`\u0005H'¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0012H'¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00002\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/ChannelsListComponent$Builder;", "", "Lkotlin/Pair;", "Ljava/util/SortedSet;", "", "Lcom/avito/android/messenger/folders/ChatListTags;", "instance", "bindMainTags", "(Lkotlin/Pair;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsListComponent$Builder;", "bindPinnedTags", "bindMergedTags", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "state", "defaultPresenterState", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsListComponent$Builder;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor$State;", "defaultChannelBannerInteractorState", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor$State;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsListComponent$Builder;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider$State;", "defaultChannelsLastMessageProvidedState", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider$State;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsListComponent$Builder;", "Landroid/os/Bundle;", "itemVisibilityTrackerState", "(Landroid/os/Bundle;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsListComponent$Builder;", "Lcom/avito/android/messenger/channels/mvi/di/ChannelsListComponent;", "build", "()Lcom/avito/android/messenger/channels/mvi/di/ChannelsListComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bindMainTags(@NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair);

        @BindsInstance
        @NotNull
        Builder bindMergedTags(@NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair);

        @BindsInstance
        @NotNull
        Builder bindPinnedTags(@Nullable @org.jetbrains.annotations.Nullable Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair);

        @NotNull
        ChannelsListComponent build();

        @BindsInstance
        @NotNull
        Builder defaultChannelBannerInteractorState(@NotNull ChannelsBannerInteractor.State state);

        @BindsInstance
        @NotNull
        Builder defaultChannelsLastMessageProvidedState(@NotNull ChannelsLastMessageProvider.State state);

        @BindsInstance
        @NotNull
        Builder defaultPresenterState(@NotNull ChannelsListState channelsListState);

        @BindsInstance
        @NotNull
        Builder itemVisibilityTrackerState(@ChannelsListVisibilityTrackerState @org.jetbrains.annotations.Nullable Bundle bundle);
    }

    void inject(@NotNull ChannelsListFragment channelsListFragment);
}

package com.avito.android.messenger.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.OpenedFrom;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextView;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di.ItemsListModule;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter;
import com.avito.android.permissions.PermissionHelper;
import dagger.BindsInstance;
import dagger.Subcomponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/di/ChannelFragmentComponent;", "", "Lcom/avito/android/messenger/conversation/ChannelFragment;", "channelFragment", "", "inject", "(Lcom/avito/android/messenger/conversation/ChannelFragment;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Subcomponent(modules = {ChannelFragmentModule.class, MessageAdapterModule.class, ItemsListModule.class})
@PerFragment
public interface ChannelFragmentComponent {

    @Subcomponent.Builder
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0015H'¢\u0006\u0004\b\u0013\u0010\u0016J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0017H'¢\u0006\u0004\b\u0013\u0010\u0018J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0019H'¢\u0006\u0004\b\u0013\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "", "Lcom/avito/android/messenger/di/RelativeDateFormatterModule;", "relativeDateFormatterModule", "(Lcom/avito/android/messenger/di/RelativeDateFormatterModule;)Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "Lcom/avito/android/messenger/conversation/ChannelFragment;", "fragment", "(Lcom/avito/android/messenger/conversation/ChannelFragment;)Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "Lcom/avito/android/messenger/conversation/ChannelFragment$Params;", "params", "(Lcom/avito/android/messenger/conversation/ChannelFragment$Params;)Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "Lcom/avito/android/messenger/conversation/OpenedFrom;", "value", "openedFrom", "(Lcom/avito/android/messenger/conversation/OpenedFrom;)Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "state", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;)Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;)Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "Lcom/avito/android/permissions/PermissionHelper;", "helper", "permissionHelper", "(Lcom/avito/android/permissions/PermissionHelper;)Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "Lcom/avito/android/messenger/di/ChannelFragmentComponent;", "build", "()Lcom/avito/android/messenger/di/ChannelFragmentComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Builder {
        @NotNull
        ChannelFragmentComponent build();

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull ChannelFragment channelFragment);

        @BindsInstance
        @NotNull
        Builder openedFrom(@NotNull OpenedFrom openedFrom);

        @BindsInstance
        @NotNull
        Builder params(@NotNull ChannelFragment.Params params);

        @BindsInstance
        @NotNull
        Builder permissionHelper(@NotNull PermissionHelper permissionHelper);

        @NotNull
        Builder relativeDateFormatterModule(@NotNull RelativeDateFormatterModule relativeDateFormatterModule);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder state(@NotNull ChannelContextInteractor.State state);

        @BindsInstance
        @NotNull
        Builder state(@NotNull ChannelContextView.State state);

        @BindsInstance
        @NotNull
        Builder state(@NotNull MessageListInteractor.State state);

        @BindsInstance
        @NotNull
        Builder state(@NotNull SendMessagePresenter.State state);
    }

    void inject(@NotNull ChannelFragment channelFragment);
}

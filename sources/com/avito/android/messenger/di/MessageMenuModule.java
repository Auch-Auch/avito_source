package com.avito.android.messenger.di;

import a2.b.a.a.a;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.message_menu.MenuElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuCallbacks;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuCallbacksImpl;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.CopyToClipboardElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.LinkHintElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.OpenInBrowserElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.RetrySendingMessageElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.DeleteLocalMessageElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageInteractor;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageInteractorImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJE\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/di/MessageMenuModule;", "", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider;", "copyToClipboard", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider;", "openInBrowser", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/LinkHintElementProvider;", "linkHint", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider;", "deleteLocalMessage", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider;", "retrySendingMessage", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider;", "deleteRemoteMessage", "", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElementProvider;", "provideMessageMenuElementProvidersList", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/LinkHintElementProvider;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider;)Ljava/util/List;", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "factory", "Lcom/avito/android/messenger/conversation/ChannelFragment;", "fragment", "Lcom/avito/android/messenger/conversation/ChannelFragment$Params;", "params", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;", "provideMessageMenuCallbacks", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class MessageMenuModule {
    @NotNull
    public static final MessageMenuModule INSTANCE = new MessageMenuModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/di/MessageMenuModule$Declarations;", "", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacksImpl;", "impl", "Landroidx/lifecycle/ViewModel;", "bindMessageMenuCallbacksViewModel", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacksImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider$Callback;", "bindCopyActionCallback", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;)Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider$Callback;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider$Callback;", "bindOpenInBrowserActionCallback", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;)Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/OpenInBrowserElementProvider$Callback;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider$Callback;", "bindDeleteLocalMessageActionCallback", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;)Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/DeleteLocalMessageElementProvider$Callback;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider$Callback;", "bindRetrySendingMessageActionCallback", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;)Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/RetrySendingMessageElementProvider$Callback;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider$Callback;", "bindDeleteRemoteMessageActionCallback", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;)Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageElementProvider$Callback;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageInteractor;", "bindDeleteRemoteMessageInteractor", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageInteractorImpl;)Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageInteractor;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        CopyToClipboardElementProvider.Callback bindCopyActionCallback(@NotNull MessageMenuCallbacks messageMenuCallbacks);

        @PerFragment
        @Binds
        @NotNull
        DeleteLocalMessageElementProvider.Callback bindDeleteLocalMessageActionCallback(@NotNull MessageMenuCallbacks messageMenuCallbacks);

        @PerFragment
        @Binds
        @NotNull
        DeleteRemoteMessageElementProvider.Callback bindDeleteRemoteMessageActionCallback(@NotNull MessageMenuCallbacks messageMenuCallbacks);

        @PerFragment
        @Binds
        @NotNull
        DeleteRemoteMessageInteractor bindDeleteRemoteMessageInteractor(@NotNull DeleteRemoteMessageInteractorImpl deleteRemoteMessageInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(MessageMenuCallbacksImpl.class)
        @IntoMap
        ViewModel bindMessageMenuCallbacksViewModel(@NotNull MessageMenuCallbacksImpl messageMenuCallbacksImpl);

        @PerFragment
        @Binds
        @NotNull
        OpenInBrowserElementProvider.Callback bindOpenInBrowserActionCallback(@NotNull MessageMenuCallbacks messageMenuCallbacks);

        @PerFragment
        @Binds
        @NotNull
        RetrySendingMessageElementProvider.Callback bindRetrySendingMessageActionCallback(@NotNull MessageMenuCallbacks messageMenuCallbacks);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final MessageMenuCallbacks provideMessageMenuCallbacks(@NotNull ViewModelFactory viewModelFactory, @NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "factory");
        Intrinsics.checkNotNullParameter(channelFragment, "fragment");
        Intrinsics.checkNotNullParameter(params, "params");
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(MessageMenuCallbacksImpl.class, new StringBuilder(), ':', params.getChannelId()), MessageMenuCallbacksImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (MessageMenuCallbacks) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final List<MenuElementProvider> provideMessageMenuElementProvidersList(@NotNull CopyToClipboardElementProvider copyToClipboardElementProvider, @NotNull OpenInBrowserElementProvider openInBrowserElementProvider, @NotNull LinkHintElementProvider linkHintElementProvider, @NotNull DeleteLocalMessageElementProvider deleteLocalMessageElementProvider, @NotNull RetrySendingMessageElementProvider retrySendingMessageElementProvider, @NotNull DeleteRemoteMessageElementProvider deleteRemoteMessageElementProvider) {
        Intrinsics.checkNotNullParameter(copyToClipboardElementProvider, "copyToClipboard");
        Intrinsics.checkNotNullParameter(openInBrowserElementProvider, "openInBrowser");
        Intrinsics.checkNotNullParameter(linkHintElementProvider, "linkHint");
        Intrinsics.checkNotNullParameter(deleteLocalMessageElementProvider, "deleteLocalMessage");
        Intrinsics.checkNotNullParameter(retrySendingMessageElementProvider, "retrySendingMessage");
        Intrinsics.checkNotNullParameter(deleteRemoteMessageElementProvider, "deleteRemoteMessage");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new MenuElementProvider[]{linkHintElementProvider, openInBrowserElementProvider, copyToClipboardElementProvider, retrySendingMessageElementProvider, deleteLocalMessageElementProvider, deleteRemoteMessageElementProvider});
    }
}

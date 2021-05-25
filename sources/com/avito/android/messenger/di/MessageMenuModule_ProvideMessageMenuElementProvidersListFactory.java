package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.mvi.message_menu.MenuElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.CopyToClipboardElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.LinkHintElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.OpenInBrowserElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.RetrySendingMessageElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.DeleteLocalMessageElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageElementProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class MessageMenuModule_ProvideMessageMenuElementProvidersListFactory implements Factory<List<MenuElementProvider>> {
    public final Provider<CopyToClipboardElementProvider> a;
    public final Provider<OpenInBrowserElementProvider> b;
    public final Provider<LinkHintElementProvider> c;
    public final Provider<DeleteLocalMessageElementProvider> d;
    public final Provider<RetrySendingMessageElementProvider> e;
    public final Provider<DeleteRemoteMessageElementProvider> f;

    public MessageMenuModule_ProvideMessageMenuElementProvidersListFactory(Provider<CopyToClipboardElementProvider> provider, Provider<OpenInBrowserElementProvider> provider2, Provider<LinkHintElementProvider> provider3, Provider<DeleteLocalMessageElementProvider> provider4, Provider<RetrySendingMessageElementProvider> provider5, Provider<DeleteRemoteMessageElementProvider> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MessageMenuModule_ProvideMessageMenuElementProvidersListFactory create(Provider<CopyToClipboardElementProvider> provider, Provider<OpenInBrowserElementProvider> provider2, Provider<LinkHintElementProvider> provider3, Provider<DeleteLocalMessageElementProvider> provider4, Provider<RetrySendingMessageElementProvider> provider5, Provider<DeleteRemoteMessageElementProvider> provider6) {
        return new MessageMenuModule_ProvideMessageMenuElementProvidersListFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static List<MenuElementProvider> provideMessageMenuElementProvidersList(CopyToClipboardElementProvider copyToClipboardElementProvider, OpenInBrowserElementProvider openInBrowserElementProvider, LinkHintElementProvider linkHintElementProvider, DeleteLocalMessageElementProvider deleteLocalMessageElementProvider, RetrySendingMessageElementProvider retrySendingMessageElementProvider, DeleteRemoteMessageElementProvider deleteRemoteMessageElementProvider) {
        return (List) Preconditions.checkNotNullFromProvides(MessageMenuModule.provideMessageMenuElementProvidersList(copyToClipboardElementProvider, openInBrowserElementProvider, linkHintElementProvider, deleteLocalMessageElementProvider, retrySendingMessageElementProvider, deleteRemoteMessageElementProvider));
    }

    @Override // javax.inject.Provider
    public List<MenuElementProvider> get() {
        return provideMessageMenuElementProvidersList(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}

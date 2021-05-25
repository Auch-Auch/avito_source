package com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote;

import android.content.res.Resources;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageElementProvider;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeleteRemoteMessageElementProvider_Factory implements Factory<DeleteRemoteMessageElementProvider> {
    public final Provider<Resources> a;
    public final Provider<DeleteRemoteMessageElementProvider.Callback> b;
    public final Provider<TimeSource> c;
    public final Provider<DeleteRemoteMessageInteractor> d;

    public DeleteRemoteMessageElementProvider_Factory(Provider<Resources> provider, Provider<DeleteRemoteMessageElementProvider.Callback> provider2, Provider<TimeSource> provider3, Provider<DeleteRemoteMessageInteractor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DeleteRemoteMessageElementProvider_Factory create(Provider<Resources> provider, Provider<DeleteRemoteMessageElementProvider.Callback> provider2, Provider<TimeSource> provider3, Provider<DeleteRemoteMessageInteractor> provider4) {
        return new DeleteRemoteMessageElementProvider_Factory(provider, provider2, provider3, provider4);
    }

    public static DeleteRemoteMessageElementProvider newInstance(Resources resources, DeleteRemoteMessageElementProvider.Callback callback, TimeSource timeSource, DeleteRemoteMessageInteractor deleteRemoteMessageInteractor) {
        return new DeleteRemoteMessageElementProvider(resources, callback, timeSource, deleteRemoteMessageInteractor);
    }

    @Override // javax.inject.Provider
    public DeleteRemoteMessageElementProvider get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}

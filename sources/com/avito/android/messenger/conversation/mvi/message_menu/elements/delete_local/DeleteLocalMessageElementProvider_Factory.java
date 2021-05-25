package com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.DeleteLocalMessageElementProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeleteLocalMessageElementProvider_Factory implements Factory<DeleteLocalMessageElementProvider> {
    public final Provider<MessageEraser> a;
    public final Provider<Analytics> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<DeleteLocalMessageElementProvider.Callback> d;

    public DeleteLocalMessageElementProvider_Factory(Provider<MessageEraser> provider, Provider<Analytics> provider2, Provider<SchedulersFactory> provider3, Provider<DeleteLocalMessageElementProvider.Callback> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DeleteLocalMessageElementProvider_Factory create(Provider<MessageEraser> provider, Provider<Analytics> provider2, Provider<SchedulersFactory> provider3, Provider<DeleteLocalMessageElementProvider.Callback> provider4) {
        return new DeleteLocalMessageElementProvider_Factory(provider, provider2, provider3, provider4);
    }

    public static DeleteLocalMessageElementProvider newInstance(MessageEraser messageEraser, Analytics analytics, SchedulersFactory schedulersFactory, DeleteLocalMessageElementProvider.Callback callback) {
        return new DeleteLocalMessageElementProvider(messageEraser, analytics, schedulersFactory, callback);
    }

    @Override // javax.inject.Provider
    public DeleteLocalMessageElementProvider get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}

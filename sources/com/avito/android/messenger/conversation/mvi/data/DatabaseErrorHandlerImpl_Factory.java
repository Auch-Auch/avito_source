package com.avito.android.messenger.conversation.mvi.data;

import android.content.Context;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.MessengerDatabase;
public final class DatabaseErrorHandlerImpl_Factory implements Factory<DatabaseErrorHandlerImpl> {
    public final Provider<Context> a;
    public final Provider<MessengerDatabase> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Analytics> d;

    public DatabaseErrorHandlerImpl_Factory(Provider<Context> provider, Provider<MessengerDatabase> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DatabaseErrorHandlerImpl_Factory create(Provider<Context> provider, Provider<MessengerDatabase> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4) {
        return new DatabaseErrorHandlerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static DatabaseErrorHandlerImpl newInstance(Context context, MessengerDatabase messengerDatabase, SchedulersFactory schedulersFactory, Analytics analytics) {
        return new DatabaseErrorHandlerImpl(context, messengerDatabase, schedulersFactory, analytics);
    }

    @Override // javax.inject.Provider
    public DatabaseErrorHandlerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}

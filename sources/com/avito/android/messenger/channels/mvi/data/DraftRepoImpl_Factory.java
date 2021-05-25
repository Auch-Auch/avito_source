package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandler;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.DraftDao;
public final class DraftRepoImpl_Factory implements Factory<DraftRepoImpl> {
    public final Provider<DraftDao> a;
    public final Provider<DatabaseErrorHandler> b;

    public DraftRepoImpl_Factory(Provider<DraftDao> provider, Provider<DatabaseErrorHandler> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DraftRepoImpl_Factory create(Provider<DraftDao> provider, Provider<DatabaseErrorHandler> provider2) {
        return new DraftRepoImpl_Factory(provider, provider2);
    }

    public static DraftRepoImpl newInstance(DraftDao draftDao, DatabaseErrorHandler databaseErrorHandler) {
        return new DraftRepoImpl(draftDao, databaseErrorHandler);
    }

    @Override // javax.inject.Provider
    public DraftRepoImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}

package com.avito.android.social;

import dagger.internal.Factory;
public final class LiveJournalSocialManagerImpl_Factory implements Factory<LiveJournalSocialManagerImpl> {

    public static final class a {
        public static final LiveJournalSocialManagerImpl_Factory a = new LiveJournalSocialManagerImpl_Factory();
    }

    public static LiveJournalSocialManagerImpl_Factory create() {
        return a.a;
    }

    public static LiveJournalSocialManagerImpl newInstance() {
        return new LiveJournalSocialManagerImpl();
    }

    @Override // javax.inject.Provider
    public LiveJournalSocialManagerImpl get() {
        return newInstance();
    }
}

package com.avito.android.messenger.channels.mvi.data;

import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.ChannelDao;
import ru.avito.android.persistence.messenger.ChannelTagDao;
import ru.avito.android.persistence.messenger.DraftDao;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.UserDao;
public final class ChannelRepoImpl_Factory implements Factory<ChannelRepoImpl> {
    public final Provider<ChannelDao> a;
    public final Provider<DraftDao> b;
    public final Provider<UserDao> c;
    public final Provider<MessageDao> d;
    public final Provider<ChannelTagDao> e;
    public final Provider<ChannelEntityConverter> f;

    public ChannelRepoImpl_Factory(Provider<ChannelDao> provider, Provider<DraftDao> provider2, Provider<UserDao> provider3, Provider<MessageDao> provider4, Provider<ChannelTagDao> provider5, Provider<ChannelEntityConverter> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ChannelRepoImpl_Factory create(Provider<ChannelDao> provider, Provider<DraftDao> provider2, Provider<UserDao> provider3, Provider<MessageDao> provider4, Provider<ChannelTagDao> provider5, Provider<ChannelEntityConverter> provider6) {
        return new ChannelRepoImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ChannelRepoImpl newInstance(ChannelDao channelDao, DraftDao draftDao, UserDao userDao, MessageDao messageDao, ChannelTagDao channelTagDao, ChannelEntityConverter channelEntityConverter) {
        return new ChannelRepoImpl(channelDao, draftDao, userDao, messageDao, channelTagDao, channelEntityConverter);
    }

    @Override // javax.inject.Provider
    public ChannelRepoImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}

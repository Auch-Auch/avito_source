package com.avito.android.messenger.conversation.mvi.data;

import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.ChannelMetaInfoDao;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessageMetaInfoDao;
public final class MessageRepoImpl_Factory implements Factory<MessageRepoImpl> {
    public final Provider<MessageDao> a;
    public final Provider<MessageMetaInfoDao> b;
    public final Provider<ChannelMetaInfoDao> c;
    public final Provider<MessageEntityConverter> d;
    public final Provider<DatabaseErrorHandler> e;

    public MessageRepoImpl_Factory(Provider<MessageDao> provider, Provider<MessageMetaInfoDao> provider2, Provider<ChannelMetaInfoDao> provider3, Provider<MessageEntityConverter> provider4, Provider<DatabaseErrorHandler> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MessageRepoImpl_Factory create(Provider<MessageDao> provider, Provider<MessageMetaInfoDao> provider2, Provider<ChannelMetaInfoDao> provider3, Provider<MessageEntityConverter> provider4, Provider<DatabaseErrorHandler> provider5) {
        return new MessageRepoImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static MessageRepoImpl newInstance(MessageDao messageDao, MessageMetaInfoDao messageMetaInfoDao, ChannelMetaInfoDao channelMetaInfoDao, MessageEntityConverter messageEntityConverter, DatabaseErrorHandler databaseErrorHandler) {
        return new MessageRepoImpl(messageDao, messageMetaInfoDao, channelMetaInfoDao, messageEntityConverter, databaseErrorHandler);
    }

    @Override // javax.inject.Provider
    public MessageRepoImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}

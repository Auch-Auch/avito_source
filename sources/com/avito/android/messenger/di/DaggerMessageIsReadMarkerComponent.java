package com.avito.android.messenger.di;

import android.content.Context;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandler;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandlerImpl;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandlerImpl_Factory;
import com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverter;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverterImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverterImpl_Factory;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoImpl_Factory;
import com.avito.android.messenger.conversation.mvi.sync.MessageIsReadMarker;
import com.avito.android.messenger.conversation.mvi.sync.MessageIsReadMarkerService;
import com.avito.android.messenger.conversation.mvi.sync.MessageIsReadMarkerService_MembersInjector;
import com.avito.android.messenger.conversation.mvi.sync.MessageIsReadMarkerWorker;
import com.avito.android.messenger.conversation.mvi.sync.MessageIsReadMarkerWorker_MembersInjector;
import com.avito.android.messenger.di.MessageIsReadMarkerComponent;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.ChannelMetaInfoDao;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessageMetaInfoDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.messenger.MessengerHistory;
public final class DaggerMessageIsReadMarkerComponent implements MessageIsReadMarkerComponent {
    public final MessageIsReadMarkerDependencies a;
    public Provider<MessengerDatabase> b;
    public Provider<MessageDao> c;
    public Provider<MessageMetaInfoDao> d = MessengerRepoModule_ProvideMessageMetaInfoDao$messenger_releaseFactory.create(this.b);
    public Provider<ChannelMetaInfoDao> e = MessengerRepoModule_ProvideChannelMetaInfoDao$messenger_releaseFactory.create(this.b);
    public Provider<MessageBodySerializer> f;
    public Provider<MessageEntityConverterImpl> g;
    public Provider<MessageEntityConverter> h;
    public Provider<Context> i;
    public Provider<SchedulersFactory> j;
    public Provider<Analytics> k;
    public Provider<DatabaseErrorHandlerImpl> l;
    public Provider<DatabaseErrorHandler> m;
    public Provider<MessageRepoImpl> n;
    public Provider<MessageRepo> o;

    public static final class b implements MessageIsReadMarkerComponent.Builder {
        public MessageIsReadMarkerDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.di.MessageIsReadMarkerComponent.Builder
        public MessageIsReadMarkerComponent build() {
            Preconditions.checkBuilderRequirement(this.a, MessageIsReadMarkerDependencies.class);
            return new DaggerMessageIsReadMarkerComponent(this.a, null);
        }

        @Override // com.avito.android.messenger.di.MessageIsReadMarkerComponent.Builder
        public MessageIsReadMarkerComponent.Builder messageIsReadMarkerDependencies(MessageIsReadMarkerDependencies messageIsReadMarkerDependencies) {
            this.a = (MessageIsReadMarkerDependencies) Preconditions.checkNotNull(messageIsReadMarkerDependencies);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final MessageIsReadMarkerDependencies a;

        public c(MessageIsReadMarkerDependencies messageIsReadMarkerDependencies) {
            this.a = messageIsReadMarkerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Context> {
        public final MessageIsReadMarkerDependencies a;

        public d(MessageIsReadMarkerDependencies messageIsReadMarkerDependencies) {
            this.a = messageIsReadMarkerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class e implements Provider<MessageBodySerializer> {
        public final MessageIsReadMarkerDependencies a;

        public e(MessageIsReadMarkerDependencies messageIsReadMarkerDependencies) {
            this.a = messageIsReadMarkerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessageBodySerializer get() {
            return (MessageBodySerializer) Preconditions.checkNotNullFromComponent(this.a.messageBodySerializer());
        }
    }

    public static class f implements Provider<MessengerDatabase> {
        public final MessageIsReadMarkerDependencies a;

        public f(MessageIsReadMarkerDependencies messageIsReadMarkerDependencies) {
            this.a = messageIsReadMarkerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerDatabase get() {
            return (MessengerDatabase) Preconditions.checkNotNullFromComponent(this.a.messengerDatabase());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final MessageIsReadMarkerDependencies a;

        public g(MessageIsReadMarkerDependencies messageIsReadMarkerDependencies) {
            this.a = messageIsReadMarkerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerMessageIsReadMarkerComponent(MessageIsReadMarkerDependencies messageIsReadMarkerDependencies, a aVar) {
        this.a = messageIsReadMarkerDependencies;
        f fVar = new f(messageIsReadMarkerDependencies);
        this.b = fVar;
        this.c = MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory.create(fVar);
        e eVar = new e(messageIsReadMarkerDependencies);
        this.f = eVar;
        MessageEntityConverterImpl_Factory create = MessageEntityConverterImpl_Factory.create(eVar);
        this.g = create;
        this.h = SingleCheck.provider(create);
        d dVar = new d(messageIsReadMarkerDependencies);
        this.i = dVar;
        g gVar = new g(messageIsReadMarkerDependencies);
        this.j = gVar;
        c cVar = new c(messageIsReadMarkerDependencies);
        this.k = cVar;
        DatabaseErrorHandlerImpl_Factory create2 = DatabaseErrorHandlerImpl_Factory.create(dVar, this.b, gVar, cVar);
        this.l = create2;
        Provider<DatabaseErrorHandler> provider = SingleCheck.provider(create2);
        this.m = provider;
        MessageRepoImpl_Factory create3 = MessageRepoImpl_Factory.create(this.c, this.d, this.e, this.h, provider);
        this.n = create3;
        this.o = SingleCheck.provider(create3);
    }

    public static MessageIsReadMarkerComponent.Builder builder() {
        return new b(null);
    }

    public final MessageIsReadMarker a() {
        return new MessageIsReadMarker(this.o.get(), (MessengerHistory) Preconditions.checkNotNullFromComponent(this.a.messengerClient()), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
    }

    @Override // com.avito.android.messenger.di.MessageIsReadMarkerComponent
    public void inject(MessageIsReadMarkerService messageIsReadMarkerService) {
        MessageIsReadMarkerService_MembersInjector.injectMarker(messageIsReadMarkerService, a());
    }

    @Override // com.avito.android.messenger.di.MessageIsReadMarkerComponent
    public void inject(MessageIsReadMarkerWorker messageIsReadMarkerWorker) {
        MessageIsReadMarkerWorker_MembersInjector.injectMarker(messageIsReadMarkerWorker, a());
    }
}

package com.avito.android.messenger.di;

import android.content.Context;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.MessengerEntityConverter;
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
import com.avito.android.messenger.conversation.mvi.sync.IncompleteMessageBodyLoader;
import com.avito.android.messenger.conversation.mvi.sync.IncompleteMessageLoadingService;
import com.avito.android.messenger.conversation.mvi.sync.IncompleteMessageLoadingService_MembersInjector;
import com.avito.android.messenger.conversation.mvi.sync.IncompleteMessageLoadingWorker;
import com.avito.android.messenger.conversation.mvi.sync.IncompleteMessageLoadingWorker_MembersInjector;
import com.avito.android.messenger.di.IncompleteMessageLoaderComponent;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.ChannelMetaInfoDao;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessageMetaInfoDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.messenger.MessengerClient;
public final class DaggerIncompleteMessageLoaderComponent implements IncompleteMessageLoaderComponent {
    public final IncompleteMessageLoaderDependencies a;
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

    public static final class b implements IncompleteMessageLoaderComponent.Builder {
        public IncompleteMessageLoaderDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.di.IncompleteMessageLoaderComponent.Builder
        public IncompleteMessageLoaderComponent build() {
            Preconditions.checkBuilderRequirement(this.a, IncompleteMessageLoaderDependencies.class);
            return new DaggerIncompleteMessageLoaderComponent(this.a, null);
        }

        @Override // com.avito.android.messenger.di.IncompleteMessageLoaderComponent.Builder
        public IncompleteMessageLoaderComponent.Builder incompleteMessageLoaderDependencies(IncompleteMessageLoaderDependencies incompleteMessageLoaderDependencies) {
            this.a = (IncompleteMessageLoaderDependencies) Preconditions.checkNotNull(incompleteMessageLoaderDependencies);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final IncompleteMessageLoaderDependencies a;

        public c(IncompleteMessageLoaderDependencies incompleteMessageLoaderDependencies) {
            this.a = incompleteMessageLoaderDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Context> {
        public final IncompleteMessageLoaderDependencies a;

        public d(IncompleteMessageLoaderDependencies incompleteMessageLoaderDependencies) {
            this.a = incompleteMessageLoaderDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class e implements Provider<MessageBodySerializer> {
        public final IncompleteMessageLoaderDependencies a;

        public e(IncompleteMessageLoaderDependencies incompleteMessageLoaderDependencies) {
            this.a = incompleteMessageLoaderDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessageBodySerializer get() {
            return (MessageBodySerializer) Preconditions.checkNotNullFromComponent(this.a.messageBodySerializer());
        }
    }

    public static class f implements Provider<MessengerDatabase> {
        public final IncompleteMessageLoaderDependencies a;

        public f(IncompleteMessageLoaderDependencies incompleteMessageLoaderDependencies) {
            this.a = incompleteMessageLoaderDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerDatabase get() {
            return (MessengerDatabase) Preconditions.checkNotNullFromComponent(this.a.messengerDatabase());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final IncompleteMessageLoaderDependencies a;

        public g(IncompleteMessageLoaderDependencies incompleteMessageLoaderDependencies) {
            this.a = incompleteMessageLoaderDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerIncompleteMessageLoaderComponent(IncompleteMessageLoaderDependencies incompleteMessageLoaderDependencies, a aVar) {
        this.a = incompleteMessageLoaderDependencies;
        f fVar = new f(incompleteMessageLoaderDependencies);
        this.b = fVar;
        this.c = MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory.create(fVar);
        e eVar = new e(incompleteMessageLoaderDependencies);
        this.f = eVar;
        MessageEntityConverterImpl_Factory create = MessageEntityConverterImpl_Factory.create(eVar);
        this.g = create;
        this.h = SingleCheck.provider(create);
        d dVar = new d(incompleteMessageLoaderDependencies);
        this.i = dVar;
        g gVar = new g(incompleteMessageLoaderDependencies);
        this.j = gVar;
        c cVar = new c(incompleteMessageLoaderDependencies);
        this.k = cVar;
        DatabaseErrorHandlerImpl_Factory create2 = DatabaseErrorHandlerImpl_Factory.create(dVar, this.b, gVar, cVar);
        this.l = create2;
        Provider<DatabaseErrorHandler> provider = SingleCheck.provider(create2);
        this.m = provider;
        MessageRepoImpl_Factory create3 = MessageRepoImpl_Factory.create(this.c, this.d, this.e, this.h, provider);
        this.n = create3;
        this.o = SingleCheck.provider(create3);
    }

    public static IncompleteMessageLoaderComponent.Builder builder() {
        return new b(null);
    }

    public final IncompleteMessageBodyLoader a() {
        return new IncompleteMessageBodyLoader(this.o.get(), IncompleteMessageLoaderModule_ProvideMessageBodyResolver$messenger_releaseFactory.provideMessageBodyResolver$messenger_release((MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient()), (MessengerEntityConverter) Preconditions.checkNotNullFromComponent(this.a.messengerEntityConverter()), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory())), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
    }

    @Override // com.avito.android.messenger.di.IncompleteMessageLoaderComponent
    public void inject(IncompleteMessageLoadingService incompleteMessageLoadingService) {
        IncompleteMessageLoadingService_MembersInjector.injectLoader(incompleteMessageLoadingService, a());
    }

    @Override // com.avito.android.messenger.di.IncompleteMessageLoaderComponent
    public void inject(IncompleteMessageLoadingWorker incompleteMessageLoadingWorker) {
        IncompleteMessageLoadingWorker_MembersInjector.injectLoader(incompleteMessageLoadingWorker, a());
    }
}

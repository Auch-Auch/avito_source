package com.avito.android.messenger.di;

import android.content.Context;
import com.avito.android.account.AccountStateProvider;
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
import com.avito.android.messenger.di.OpenErrorTrackerComponent;
import com.avito.android.messenger.service.OpenErrorTrackerImpl;
import com.avito.android.messenger.service.OpenErrorTrackerService;
import com.avito.android.messenger.service.OpenErrorTrackerService_MembersInjector;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.ChannelMetaInfoDao;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessageMetaInfoDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
public final class DaggerOpenErrorTrackerComponent implements OpenErrorTrackerComponent {
    public final OpenErrorTrackerDependencies a;
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

    public static final class b implements OpenErrorTrackerComponent.Builder {
        public OpenErrorTrackerDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.di.OpenErrorTrackerComponent.Builder
        public OpenErrorTrackerComponent build() {
            Preconditions.checkBuilderRequirement(this.a, OpenErrorTrackerDependencies.class);
            return new DaggerOpenErrorTrackerComponent(this.a, null);
        }

        @Override // com.avito.android.messenger.di.OpenErrorTrackerComponent.Builder
        public OpenErrorTrackerComponent.Builder dependencies(OpenErrorTrackerDependencies openErrorTrackerDependencies) {
            this.a = (OpenErrorTrackerDependencies) Preconditions.checkNotNull(openErrorTrackerDependencies);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final OpenErrorTrackerDependencies a;

        public c(OpenErrorTrackerDependencies openErrorTrackerDependencies) {
            this.a = openErrorTrackerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Context> {
        public final OpenErrorTrackerDependencies a;

        public d(OpenErrorTrackerDependencies openErrorTrackerDependencies) {
            this.a = openErrorTrackerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class e implements Provider<MessageBodySerializer> {
        public final OpenErrorTrackerDependencies a;

        public e(OpenErrorTrackerDependencies openErrorTrackerDependencies) {
            this.a = openErrorTrackerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessageBodySerializer get() {
            return (MessageBodySerializer) Preconditions.checkNotNullFromComponent(this.a.messageBodySerializer());
        }
    }

    public static class f implements Provider<MessengerDatabase> {
        public final OpenErrorTrackerDependencies a;

        public f(OpenErrorTrackerDependencies openErrorTrackerDependencies) {
            this.a = openErrorTrackerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerDatabase get() {
            return (MessengerDatabase) Preconditions.checkNotNullFromComponent(this.a.messengerDatabase());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final OpenErrorTrackerDependencies a;

        public g(OpenErrorTrackerDependencies openErrorTrackerDependencies) {
            this.a = openErrorTrackerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerOpenErrorTrackerComponent(OpenErrorTrackerDependencies openErrorTrackerDependencies, a aVar) {
        this.a = openErrorTrackerDependencies;
        f fVar = new f(openErrorTrackerDependencies);
        this.b = fVar;
        this.c = MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory.create(fVar);
        e eVar = new e(openErrorTrackerDependencies);
        this.f = eVar;
        MessageEntityConverterImpl_Factory create = MessageEntityConverterImpl_Factory.create(eVar);
        this.g = create;
        this.h = SingleCheck.provider(create);
        d dVar = new d(openErrorTrackerDependencies);
        this.i = dVar;
        g gVar = new g(openErrorTrackerDependencies);
        this.j = gVar;
        c cVar = new c(openErrorTrackerDependencies);
        this.k = cVar;
        DatabaseErrorHandlerImpl_Factory create2 = DatabaseErrorHandlerImpl_Factory.create(dVar, this.b, gVar, cVar);
        this.l = create2;
        Provider<DatabaseErrorHandler> provider = SingleCheck.provider(create2);
        this.m = provider;
        MessageRepoImpl_Factory create3 = MessageRepoImpl_Factory.create(this.c, this.d, this.e, this.h, provider);
        this.n = create3;
        this.o = SingleCheck.provider(create3);
    }

    public static OpenErrorTrackerComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.di.OpenErrorTrackerComponent
    public void inject(OpenErrorTrackerService openErrorTrackerService) {
        OpenErrorTrackerService_MembersInjector.injectOpenErrorTracker(openErrorTrackerService, new OpenErrorTrackerImpl((AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider()), this.o.get(), (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics())));
    }
}

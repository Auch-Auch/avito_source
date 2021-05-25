package com.avito.android.messenger.di;

import android.app.Application;
import android.content.Context;
import com.avito.android.Features;
import com.avito.android.PendingMessageHandlerModule_ProvideImageUploadStarterFactory;
import com.avito.android.PendingMessageHandlerModule_ProvideLocalMessageSenderFactory;
import com.avito.android.PendingMessageHandlerModule_ProvideMessageSendingTrackerFactoryFactory;
import com.avito.android.PendingMessageHandlerModule_ProvidePendingMessageHandlerFactory;
import com.avito.android.PendingMessageHandlerModule_ProvidePhotoInteractorFactory;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.app.task.LocalMessageSender;
import com.avito.android.app.task.MessageSendingTrackerFactory;
import com.avito.android.app.task.PendingMessageHandler;
import com.avito.android.app.work.SendPendingMessagesWorker;
import com.avito.android.app.work.SendPendingMessagesWorker_MembersInjector;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
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
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractor;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadCanceller;
import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage;
import com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver;
import com.avito.android.messenger.di.SendPendingMessagesWorkerComponent;
import com.avito.android.messenger.service.ImageUploadStarter;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.ChannelMetaInfoDao;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessageMetaInfoDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerSendPendingMessagesWorkerComponent implements SendPendingMessagesWorkerComponent {
    public Provider<Features> A;
    public Provider<MessengerFileUploadCanceller> B;
    public Provider<LocalMessageSender> C;
    public Provider<TimeSource> D;
    public Provider<MessageSendingTrackerFactory> E;
    public Provider<MessengerErrorTracker> F;
    public Provider<NetworkTypeProvider> G;
    public Provider<PendingMessageHandler> H;
    public final SendPendingMessagesWorkerComponentDependencies a;
    public Provider<AccountStateProvider> b;
    public Provider<MessengerClient<AvitoMessengerApi>> c;
    public Provider<MessengerDatabase> d;
    public Provider<MessageDao> e;
    public Provider<MessageMetaInfoDao> f = MessengerRepoModule_ProvideMessageMetaInfoDao$messenger_releaseFactory.create(this.d);
    public Provider<ChannelMetaInfoDao> g = MessengerRepoModule_ProvideChannelMetaInfoDao$messenger_releaseFactory.create(this.d);
    public Provider<MessageBodySerializer> h;
    public Provider<MessageEntityConverterImpl> i;
    public Provider<MessageEntityConverter> j;
    public Provider<Context> k;
    public Provider<SchedulersFactory> l;
    public Provider<Analytics> m;
    public Provider<DatabaseErrorHandlerImpl> n;
    public Provider<DatabaseErrorHandler> o;
    public Provider<MessageRepoImpl> p;
    public Provider<MessageRepo> q;
    public Provider<FileUploadInteractor> r;
    public Provider<MessageBodyResolver> s;
    public Provider<MessengerEntityConverter> t;
    public Provider<Application> u;
    public Provider<ServiceIntentFactory> v;
    public Provider<ImageUploadStarter> w;
    public Provider<BuildInfo> x;
    public Provider<PhotoInteractor> y;
    public Provider<MessengerPhotoStorage> z;

    public static final class b implements SendPendingMessagesWorkerComponent.Builder {
        public SendPendingMessagesWorkerComponentDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponent.Builder
        public SendPendingMessagesWorkerComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SendPendingMessagesWorkerComponentDependencies.class);
            return new DaggerSendPendingMessagesWorkerComponent(this.a, null);
        }

        @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponent.Builder
        public SendPendingMessagesWorkerComponent.Builder dependencies(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = (SendPendingMessagesWorkerComponentDependencies) Preconditions.checkNotNull(sendPendingMessagesWorkerComponentDependencies);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public c(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public d(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<Application> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public e(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class f implements Provider<BuildInfo> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public f(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class g implements Provider<Context> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public g(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class h implements Provider<Features> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public h(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class i implements Provider<FileUploadInteractor> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public i(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FileUploadInteractor get() {
            return (FileUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.fileUploadInteractor());
        }
    }

    public static class j implements Provider<MessageBodyResolver> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public j(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessageBodyResolver get() {
            return (MessageBodyResolver) Preconditions.checkNotNullFromComponent(this.a.messageBodyResolver());
        }
    }

    public static class k implements Provider<MessageBodySerializer> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public k(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessageBodySerializer get() {
            return (MessageBodySerializer) Preconditions.checkNotNullFromComponent(this.a.messageBodySerializer());
        }
    }

    public static class l implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public l(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public static class m implements Provider<MessengerDatabase> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public m(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerDatabase get() {
            return (MessengerDatabase) Preconditions.checkNotNullFromComponent(this.a.messengerDatabase());
        }
    }

    public static class n implements Provider<MessengerEntityConverter> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public n(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerEntityConverter get() {
            return (MessengerEntityConverter) Preconditions.checkNotNullFromComponent(this.a.messengerEntityConverter());
        }
    }

    public static class o implements Provider<MessengerErrorTracker> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public o(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerErrorTracker get() {
            return (MessengerErrorTracker) Preconditions.checkNotNullFromComponent(this.a.messengerErrorTracker());
        }
    }

    public static class p implements Provider<MessengerFileUploadCanceller> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public p(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerFileUploadCanceller get() {
            return (MessengerFileUploadCanceller) Preconditions.checkNotNullFromComponent(this.a.messengerFileUploadCanceller());
        }
    }

    public static class q implements Provider<MessengerPhotoStorage> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public q(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerPhotoStorage get() {
            return (MessengerPhotoStorage) Preconditions.checkNotNullFromComponent(this.a.messengerPhotoStorage());
        }
    }

    public static class r implements Provider<NetworkTypeProvider> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public r(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NetworkTypeProvider get() {
            return (NetworkTypeProvider) Preconditions.checkNotNullFromComponent(this.a.networkTypeProvider());
        }
    }

    public static class s implements Provider<SchedulersFactory> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public s(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class t implements Provider<ServiceIntentFactory> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public t(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ServiceIntentFactory get() {
            return (ServiceIntentFactory) Preconditions.checkNotNullFromComponent(this.a.serviceIntentFactory());
        }
    }

    public static class u implements Provider<TimeSource> {
        public final SendPendingMessagesWorkerComponentDependencies a;

        public u(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies) {
            this.a = sendPendingMessagesWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerSendPendingMessagesWorkerComponent(SendPendingMessagesWorkerComponentDependencies sendPendingMessagesWorkerComponentDependencies, a aVar) {
        this.a = sendPendingMessagesWorkerComponentDependencies;
        this.b = new c(sendPendingMessagesWorkerComponentDependencies);
        this.c = new l(sendPendingMessagesWorkerComponentDependencies);
        m mVar = new m(sendPendingMessagesWorkerComponentDependencies);
        this.d = mVar;
        this.e = MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory.create(mVar);
        k kVar = new k(sendPendingMessagesWorkerComponentDependencies);
        this.h = kVar;
        MessageEntityConverterImpl_Factory create = MessageEntityConverterImpl_Factory.create(kVar);
        this.i = create;
        this.j = SingleCheck.provider(create);
        g gVar = new g(sendPendingMessagesWorkerComponentDependencies);
        this.k = gVar;
        s sVar = new s(sendPendingMessagesWorkerComponentDependencies);
        this.l = sVar;
        d dVar = new d(sendPendingMessagesWorkerComponentDependencies);
        this.m = dVar;
        DatabaseErrorHandlerImpl_Factory create2 = DatabaseErrorHandlerImpl_Factory.create(gVar, this.d, sVar, dVar);
        this.n = create2;
        Provider<DatabaseErrorHandler> provider = SingleCheck.provider(create2);
        this.o = provider;
        MessageRepoImpl_Factory create3 = MessageRepoImpl_Factory.create(this.e, this.f, this.g, this.j, provider);
        this.p = create3;
        this.q = SingleCheck.provider(create3);
        this.r = new i(sendPendingMessagesWorkerComponentDependencies);
        this.s = new j(sendPendingMessagesWorkerComponentDependencies);
        this.t = new n(sendPendingMessagesWorkerComponentDependencies);
        e eVar = new e(sendPendingMessagesWorkerComponentDependencies);
        this.u = eVar;
        t tVar = new t(sendPendingMessagesWorkerComponentDependencies);
        this.v = tVar;
        this.w = PendingMessageHandlerModule_ProvideImageUploadStarterFactory.create(eVar, tVar);
        f fVar = new f(sendPendingMessagesWorkerComponentDependencies);
        this.x = fVar;
        Provider<PhotoInteractor> provider2 = SingleCheck.provider(PendingMessageHandlerModule_ProvidePhotoInteractorFactory.create(fVar, this.u));
        this.y = provider2;
        q qVar = new q(sendPendingMessagesWorkerComponentDependencies);
        this.z = qVar;
        h hVar = new h(sendPendingMessagesWorkerComponentDependencies);
        this.A = hVar;
        p pVar = new p(sendPendingMessagesWorkerComponentDependencies);
        this.B = pVar;
        this.C = PendingMessageHandlerModule_ProvideLocalMessageSenderFactory.create(this.c, this.r, this.s, this.t, this.w, provider2, qVar, this.l, hVar, pVar);
        u uVar = new u(sendPendingMessagesWorkerComponentDependencies);
        this.D = uVar;
        PendingMessageHandlerModule_ProvideMessageSendingTrackerFactoryFactory create4 = PendingMessageHandlerModule_ProvideMessageSendingTrackerFactoryFactory.create(this.m, uVar, this.x);
        this.E = create4;
        o oVar = new o(sendPendingMessagesWorkerComponentDependencies);
        this.F = oVar;
        r rVar = new r(sendPendingMessagesWorkerComponentDependencies);
        this.G = rVar;
        this.H = SingleCheck.provider(PendingMessageHandlerModule_ProvidePendingMessageHandlerFactory.create(this.b, this.c, this.q, this.C, this.D, create4, oVar, this.l, this.A, this.m, rVar));
    }

    public static SendPendingMessagesWorkerComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponent
    public void inject(SendPendingMessagesWorker sendPendingMessagesWorker) {
        SendPendingMessagesWorker_MembersInjector.injectAccountStateProvider(sendPendingMessagesWorker, (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider()));
        SendPendingMessagesWorker_MembersInjector.injectSchedulers(sendPendingMessagesWorker, (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
        SendPendingMessagesWorker_MembersInjector.injectMessageDao(sendPendingMessagesWorker, MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory.provideMessageDao$messenger_release((MessengerDatabase) Preconditions.checkNotNullFromComponent(this.a.messengerDatabase())));
        SendPendingMessagesWorker_MembersInjector.injectPendingMessageHandler(sendPendingMessagesWorker, DoubleCheck.lazy(this.H));
    }
}

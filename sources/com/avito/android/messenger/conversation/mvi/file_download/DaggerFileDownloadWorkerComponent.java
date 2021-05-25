package com.avito.android.messenger.conversation.mvi.file_download;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponent;
import com.avito.android.messenger.service.MessengerInfoProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.SessionProvider;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerFileDownloadWorkerComponent implements FileDownloadWorkerComponent {
    public Provider<AccountStateProvider> a;
    public Provider<Features> b;
    public Provider<MessageRepo> c;
    public Provider<MessengerClient<AvitoMessengerApi>> d;
    public Provider<OkHttpClient> e;
    public Provider<SessionProvider> f;
    public Provider<MessengerInfoProvider> g;
    public Provider<FileDownloadRequestCallProviderImpl> h;
    public Provider<FileDownloadRequestCallProvider> i;
    public Provider<FileStorageHelper> j;
    public Provider<Analytics> k;
    public Provider<SchedulersFactory3> l;
    public Provider<FileDownloadWorkerDelegateImpl> m;
    public Provider<FileDownloadWorkerDelegate> n;

    public static final class b implements FileDownloadWorkerComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponent.Factory
        public FileDownloadWorkerComponent create(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies) {
            Preconditions.checkNotNull(fileDownloadWorkerComponentDependencies);
            return new DaggerFileDownloadWorkerComponent(fileDownloadWorkerComponentDependencies, null);
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final FileDownloadWorkerComponentDependencies a;

        public c(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies) {
            this.a = fileDownloadWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final FileDownloadWorkerComponentDependencies a;

        public d(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies) {
            this.a = fileDownloadWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<Features> {
        public final FileDownloadWorkerComponentDependencies a;

        public e(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies) {
            this.a = fileDownloadWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<FileStorageHelper> {
        public final FileDownloadWorkerComponentDependencies a;

        public f(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies) {
            this.a = fileDownloadWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FileStorageHelper get() {
            return (FileStorageHelper) Preconditions.checkNotNullFromComponent(this.a.fileStorageHelper());
        }
    }

    public static class g implements Provider<MessageRepo> {
        public final FileDownloadWorkerComponentDependencies a;

        public g(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies) {
            this.a = fileDownloadWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessageRepo get() {
            return (MessageRepo) Preconditions.checkNotNullFromComponent(this.a.messageRepo());
        }
    }

    public static class h implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final FileDownloadWorkerComponentDependencies a;

        public h(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies) {
            this.a = fileDownloadWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public static class i implements Provider<MessengerInfoProvider> {
        public final FileDownloadWorkerComponentDependencies a;

        public i(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies) {
            this.a = fileDownloadWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerInfoProvider get() {
            return (MessengerInfoProvider) Preconditions.checkNotNullFromComponent(this.a.messengerInfoProvider());
        }
    }

    public static class j implements Provider<OkHttpClient> {
        public final FileDownloadWorkerComponentDependencies a;

        public j(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies) {
            this.a = fileDownloadWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public OkHttpClient get() {
            return (OkHttpClient) Preconditions.checkNotNullFromComponent(this.a.okHttpClient());
        }
    }

    public static class k implements Provider<SchedulersFactory3> {
        public final FileDownloadWorkerComponentDependencies a;

        public k(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies) {
            this.a = fileDownloadWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class l implements Provider<SessionProvider> {
        public final FileDownloadWorkerComponentDependencies a;

        public l(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies) {
            this.a = fileDownloadWorkerComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SessionProvider get() {
            return (SessionProvider) Preconditions.checkNotNullFromComponent(this.a.sessionProvider());
        }
    }

    public DaggerFileDownloadWorkerComponent(FileDownloadWorkerComponentDependencies fileDownloadWorkerComponentDependencies, a aVar) {
        this.a = new c(fileDownloadWorkerComponentDependencies);
        this.b = new e(fileDownloadWorkerComponentDependencies);
        this.c = new g(fileDownloadWorkerComponentDependencies);
        this.d = new h(fileDownloadWorkerComponentDependencies);
        j jVar = new j(fileDownloadWorkerComponentDependencies);
        this.e = jVar;
        l lVar = new l(fileDownloadWorkerComponentDependencies);
        this.f = lVar;
        i iVar = new i(fileDownloadWorkerComponentDependencies);
        this.g = iVar;
        FileDownloadRequestCallProviderImpl_Factory create = FileDownloadRequestCallProviderImpl_Factory.create(jVar, lVar, iVar);
        this.h = create;
        Provider<FileDownloadRequestCallProvider> provider = SingleCheck.provider(create);
        this.i = provider;
        f fVar = new f(fileDownloadWorkerComponentDependencies);
        this.j = fVar;
        d dVar = new d(fileDownloadWorkerComponentDependencies);
        this.k = dVar;
        k kVar = new k(fileDownloadWorkerComponentDependencies);
        this.l = kVar;
        FileDownloadWorkerDelegateImpl_Factory create2 = FileDownloadWorkerDelegateImpl_Factory.create(this.a, this.b, this.c, this.d, provider, fVar, dVar, kVar);
        this.m = create2;
        this.n = SingleCheck.provider(create2);
    }

    public static FileDownloadWorkerComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponent
    public void inject(FileDownloadWorker fileDownloadWorker) {
        FileDownloadWorker_MembersInjector.injectDelegate(fileDownloadWorker, this.n.get());
    }
}

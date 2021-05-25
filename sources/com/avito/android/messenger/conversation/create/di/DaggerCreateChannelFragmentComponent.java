package com.avito.android.messenger.conversation.create.di;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.channels.mvi.data.ChannelContextSerializer;
import com.avito.android.messenger.channels.mvi.data.ChannelEntityConverter;
import com.avito.android.messenger.channels.mvi.data.ChannelEntityConverterImpl;
import com.avito.android.messenger.channels.mvi.data.ChannelEntityConverterImpl_Factory;
import com.avito.android.messenger.channels.mvi.data.ChannelPropertySerializer;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoImpl;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoImpl_Factory;
import com.avito.android.messenger.channels.mvi.data.DraftRepoImpl;
import com.avito.android.messenger.channels.mvi.data.DraftRepoImpl_Factory;
import com.avito.android.messenger.channels.mvi.data.UserEntityConverter;
import com.avito.android.messenger.channels.mvi.data.UserEntityConverterImpl;
import com.avito.android.messenger.channels.mvi.data.UserEntityConverterImpl_Factory;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory_Factory;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.create.CreateChannelFragment;
import com.avito.android.messenger.conversation.create.CreateChannelFragment_MembersInjector;
import com.avito.android.messenger.conversation.create.CreateChannelInteractorImpl;
import com.avito.android.messenger.conversation.create.CreateChannelInteractorImpl_Factory;
import com.avito.android.messenger.conversation.create.CreateChannelPresenter;
import com.avito.android.messenger.conversation.create.CreateChannelPresenterImpl;
import com.avito.android.messenger.conversation.create.CreateChannelPresenterImpl_Factory;
import com.avito.android.messenger.conversation.create.di.CreateChannelFragmentComponent;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandler;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandlerImpl;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandlerImpl_Factory;
import com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverter;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverterImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverterImpl_Factory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideChannelDao$messenger_releaseFactory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideChannelTagDao$messenger_releaseFactory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideDraftDao$messenger_releaseFactory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory;
import com.avito.android.messenger.di.MessengerRepoModule_ProvideUserDao$messenger_releaseFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.ChannelDao;
import ru.avito.android.persistence.messenger.ChannelTagDao;
import ru.avito.android.persistence.messenger.DraftDao;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.android.persistence.messenger.UserDao;
public final class DaggerCreateChannelFragmentComponent implements CreateChannelFragmentComponent {
    public Provider<DraftRepoImpl> A;
    public Provider<CreateChannelInteractorImpl> B;
    public Provider<CreateChannelPresenter.State> C;
    public Provider<CreateChannelPresenterImpl> D;
    public Provider<Map<Class<?>, Provider<ViewModel>>> E;
    public Provider<ViewModelFactory> F;
    public final Fragment a;
    public final CreateChannelFragmentDependencies b;
    public Provider<AccountStateProvider> c;
    public Provider<SchedulersFactory> d;
    public Provider<MessengerDatabase> e;
    public Provider<ChannelDao> f;
    public Provider<DraftDao> g = MessengerRepoModule_ProvideDraftDao$messenger_releaseFactory.create(this.e);
    public Provider<UserDao> h = MessengerRepoModule_ProvideUserDao$messenger_releaseFactory.create(this.e);
    public Provider<MessageDao> i = MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory.create(this.e);
    public Provider<ChannelTagDao> j = MessengerRepoModule_ProvideChannelTagDao$messenger_releaseFactory.create(this.e);
    public Provider<MessageBodySerializer> k;
    public Provider<MessageEntityConverterImpl> l;
    public Provider<MessageEntityConverter> m;
    public Provider<ChannelPropertySerializer> n;
    public Provider<UserEntityConverterImpl> o;
    public Provider<UserEntityConverter> p;
    public Provider<ChannelContextSerializer> q;
    public Provider<ChannelEntityConverterImpl> r;
    public Provider<ChannelEntityConverter> s;
    public Provider<ChannelRepoImpl> t;
    public Provider<ChannelRepo> u;
    public Provider<ChannelSyncAgent> v;
    public Provider<Context> w;
    public Provider<Analytics> x;
    public Provider<DatabaseErrorHandlerImpl> y;
    public Provider<DatabaseErrorHandler> z;

    public static final class b implements CreateChannelFragmentComponent.Builder {
        public CreateChannelFragmentDependencies a;
        public Fragment b;
        public CreateChannelPresenter.State c;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.conversation.create.di.CreateChannelFragmentComponent.Builder
        public CreateChannelFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CreateChannelFragmentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Fragment.class);
            Preconditions.checkBuilderRequirement(this.c, CreateChannelPresenter.State.class);
            return new DaggerCreateChannelFragmentComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.messenger.conversation.create.di.CreateChannelFragmentComponent.Builder
        public CreateChannelFragmentComponent.Builder createChannelFragmentDependencies(CreateChannelFragmentDependencies createChannelFragmentDependencies) {
            this.a = (CreateChannelFragmentDependencies) Preconditions.checkNotNull(createChannelFragmentDependencies);
            return this;
        }

        @Override // com.avito.android.messenger.conversation.create.di.CreateChannelFragmentComponent.Builder
        public CreateChannelFragmentComponent.Builder fragment(Fragment fragment) {
            this.b = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.messenger.conversation.create.di.CreateChannelFragmentComponent.Builder
        public CreateChannelFragmentComponent.Builder presenterState(CreateChannelPresenter.State state) {
            this.c = (CreateChannelPresenter.State) Preconditions.checkNotNull(state);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final CreateChannelFragmentDependencies a;

        public c(CreateChannelFragmentDependencies createChannelFragmentDependencies) {
            this.a = createChannelFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final CreateChannelFragmentDependencies a;

        public d(CreateChannelFragmentDependencies createChannelFragmentDependencies) {
            this.a = createChannelFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<ChannelContextSerializer> {
        public final CreateChannelFragmentDependencies a;

        public e(CreateChannelFragmentDependencies createChannelFragmentDependencies) {
            this.a = createChannelFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ChannelContextSerializer get() {
            return (ChannelContextSerializer) Preconditions.checkNotNullFromComponent(this.a.channelContextSerializer());
        }
    }

    public static class f implements Provider<ChannelPropertySerializer> {
        public final CreateChannelFragmentDependencies a;

        public f(CreateChannelFragmentDependencies createChannelFragmentDependencies) {
            this.a = createChannelFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ChannelPropertySerializer get() {
            return (ChannelPropertySerializer) Preconditions.checkNotNullFromComponent(this.a.channelPropertySerializer());
        }
    }

    public static class g implements Provider<ChannelSyncAgent> {
        public final CreateChannelFragmentDependencies a;

        public g(CreateChannelFragmentDependencies createChannelFragmentDependencies) {
            this.a = createChannelFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ChannelSyncAgent get() {
            return (ChannelSyncAgent) Preconditions.checkNotNullFromComponent(this.a.channelSyncAgent());
        }
    }

    public static class h implements Provider<Context> {
        public final CreateChannelFragmentDependencies a;

        public h(CreateChannelFragmentDependencies createChannelFragmentDependencies) {
            this.a = createChannelFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class i implements Provider<MessageBodySerializer> {
        public final CreateChannelFragmentDependencies a;

        public i(CreateChannelFragmentDependencies createChannelFragmentDependencies) {
            this.a = createChannelFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessageBodySerializer get() {
            return (MessageBodySerializer) Preconditions.checkNotNullFromComponent(this.a.messageBodySerializer());
        }
    }

    public static class j implements Provider<MessengerDatabase> {
        public final CreateChannelFragmentDependencies a;

        public j(CreateChannelFragmentDependencies createChannelFragmentDependencies) {
            this.a = createChannelFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerDatabase get() {
            return (MessengerDatabase) Preconditions.checkNotNullFromComponent(this.a.messengerDatabase());
        }
    }

    public static class k implements Provider<SchedulersFactory> {
        public final CreateChannelFragmentDependencies a;

        public k(CreateChannelFragmentDependencies createChannelFragmentDependencies) {
            this.a = createChannelFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerCreateChannelFragmentComponent(CreateChannelFragmentDependencies createChannelFragmentDependencies, Fragment fragment, CreateChannelPresenter.State state, a aVar) {
        this.a = fragment;
        this.b = createChannelFragmentDependencies;
        this.c = new c(createChannelFragmentDependencies);
        this.d = new k(createChannelFragmentDependencies);
        j jVar = new j(createChannelFragmentDependencies);
        this.e = jVar;
        this.f = MessengerRepoModule_ProvideChannelDao$messenger_releaseFactory.create(jVar);
        i iVar = new i(createChannelFragmentDependencies);
        this.k = iVar;
        MessageEntityConverterImpl_Factory create = MessageEntityConverterImpl_Factory.create(iVar);
        this.l = create;
        this.m = SingleCheck.provider(create);
        f fVar = new f(createChannelFragmentDependencies);
        this.n = fVar;
        UserEntityConverterImpl_Factory create2 = UserEntityConverterImpl_Factory.create(fVar);
        this.o = create2;
        Provider<UserEntityConverter> provider = SingleCheck.provider(create2);
        this.p = provider;
        e eVar = new e(createChannelFragmentDependencies);
        this.q = eVar;
        ChannelEntityConverterImpl_Factory create3 = ChannelEntityConverterImpl_Factory.create(this.m, provider, eVar, this.n);
        this.r = create3;
        Provider<ChannelEntityConverter> provider2 = SingleCheck.provider(create3);
        this.s = provider2;
        ChannelRepoImpl_Factory create4 = ChannelRepoImpl_Factory.create(this.f, this.g, this.h, this.i, this.j, provider2);
        this.t = create4;
        this.u = SingleCheck.provider(create4);
        this.v = new g(createChannelFragmentDependencies);
        h hVar = new h(createChannelFragmentDependencies);
        this.w = hVar;
        d dVar = new d(createChannelFragmentDependencies);
        this.x = dVar;
        DatabaseErrorHandlerImpl_Factory create5 = DatabaseErrorHandlerImpl_Factory.create(hVar, this.e, this.d, dVar);
        this.y = create5;
        Provider<DatabaseErrorHandler> provider3 = SingleCheck.provider(create5);
        this.z = provider3;
        DraftRepoImpl_Factory create6 = DraftRepoImpl_Factory.create(this.g, provider3);
        this.A = create6;
        this.B = CreateChannelInteractorImpl_Factory.create(this.c, this.d, this.u, this.v, create6);
        Factory create7 = InstanceFactory.create(state);
        this.C = create7;
        this.D = CreateChannelPresenterImpl_Factory.create(this.B, create7, this.d);
        MapProviderFactory build = MapProviderFactory.builder(1).put((MapProviderFactory.Builder) CreateChannelPresenterImpl.class, (Provider) this.D).build();
        this.E = build;
        this.F = SingleCheck.provider(ViewModelFactory_Factory.create(build));
    }

    public static CreateChannelFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.conversation.create.di.CreateChannelFragmentComponent
    public void inject(CreateChannelFragment createChannelFragment) {
        CreateChannelFragment_MembersInjector.injectPresenter(createChannelFragment, CreateChannelFragmentModule_ProvideCreateChannelPresenter$messenger_releaseFactory.provideCreateChannelPresenter$messenger_release(this.F.get(), this.a));
        CreateChannelFragment_MembersInjector.injectActivityIntentFactory(createChannelFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.b.activityIntentFactory()));
        CreateChannelFragment_MembersInjector.injectAnalytics(createChannelFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.b.analytics()));
    }
}

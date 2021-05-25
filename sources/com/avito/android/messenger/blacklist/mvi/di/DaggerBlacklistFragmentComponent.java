package com.avito.android.messenger.blacklist.mvi.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.date_time_formatter.BlacklistDateFormatter;
import com.avito.android.messenger.blacklist.mvi.BlacklistFragment;
import com.avito.android.messenger.blacklist.mvi.BlacklistFragment_MembersInjector;
import com.avito.android.messenger.blacklist.mvi.BlacklistInteractor;
import com.avito.android.messenger.blacklist.mvi.BlacklistInteractorImpl;
import com.avito.android.messenger.blacklist.mvi.BlacklistInteractorImpl_Factory;
import com.avito.android.messenger.blacklist.mvi.BlacklistPresenter;
import com.avito.android.messenger.blacklist.mvi.BlacklistPresenterImpl;
import com.avito.android.messenger.blacklist.mvi.BlacklistPresenterImpl_Factory;
import com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserBlueprint;
import com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserPresenter;
import com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.UnblockClickListener;
import com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponent;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory_Factory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import java.util.Map;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerBlacklistFragmentComponent implements BlacklistFragmentComponent {
    public final BlacklistFragmentComponentDependencies a;
    public Provider<Fragment> b;
    public Provider<SchedulersFactory> c;
    public Provider<Features> d;
    public Provider<AccountStateProvider> e;
    public Provider<MessengerClient<AvitoMessengerApi>> f;
    public Provider<BlacklistInteractorImpl> g;
    public Provider<ViewModel> h;
    public Provider<ViewModelFactory> i;
    public Provider<BlacklistInteractor> j;
    public Provider<TimeSource> k;
    public Provider<Resources> l;
    public Provider<Locale> m;
    public Provider<BlacklistDateFormatter> n;
    public Provider<Formatter<Throwable>> o;
    public Provider<BlacklistPresenterImpl> p;
    public Provider<ViewModel> q;
    public Provider<Map<Class<?>, Provider<ViewModel>>> r;
    public Provider<BlacklistPresenter> s;
    public Provider<UnblockClickListener> t;
    public Provider<BlockedUserPresenter> u;
    public Provider<BlockedUserBlueprint> v;
    public Provider<ItemBinder> w;
    public Provider<AdapterPresenter> x;

    public static final class b implements BlacklistFragmentComponent.Builder {
        public Fragment a;
        public Resources b;
        public BlacklistFragmentComponentDependencies c;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponent.Builder
        public BlacklistFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Fragment.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, BlacklistFragmentComponentDependencies.class);
            return new DaggerBlacklistFragmentComponent(this.c, this.a, this.b, null);
        }

        @Override // com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponent.Builder
        public BlacklistFragmentComponent.Builder dependencies(BlacklistFragmentComponentDependencies blacklistFragmentComponentDependencies) {
            this.c = (BlacklistFragmentComponentDependencies) Preconditions.checkNotNull(blacklistFragmentComponentDependencies);
            return this;
        }

        @Override // com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponent.Builder
        public BlacklistFragmentComponent.Builder fragment(Fragment fragment) {
            this.a = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponent.Builder
        public BlacklistFragmentComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final BlacklistFragmentComponentDependencies a;

        public c(BlacklistFragmentComponentDependencies blacklistFragmentComponentDependencies) {
            this.a = blacklistFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Features> {
        public final BlacklistFragmentComponentDependencies a;

        public d(BlacklistFragmentComponentDependencies blacklistFragmentComponentDependencies) {
            this.a = blacklistFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<Locale> {
        public final BlacklistFragmentComponentDependencies a;

        public e(BlacklistFragmentComponentDependencies blacklistFragmentComponentDependencies) {
            this.a = blacklistFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class f implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final BlacklistFragmentComponentDependencies a;

        public f(BlacklistFragmentComponentDependencies blacklistFragmentComponentDependencies) {
            this.a = blacklistFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final BlacklistFragmentComponentDependencies a;

        public g(BlacklistFragmentComponentDependencies blacklistFragmentComponentDependencies) {
            this.a = blacklistFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<TimeSource> {
        public final BlacklistFragmentComponentDependencies a;

        public h(BlacklistFragmentComponentDependencies blacklistFragmentComponentDependencies) {
            this.a = blacklistFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerBlacklistFragmentComponent(BlacklistFragmentComponentDependencies blacklistFragmentComponentDependencies, Fragment fragment, Resources resources, a aVar) {
        this.a = blacklistFragmentComponentDependencies;
        this.b = InstanceFactory.create(fragment);
        g gVar = new g(blacklistFragmentComponentDependencies);
        this.c = gVar;
        d dVar = new d(blacklistFragmentComponentDependencies);
        this.d = dVar;
        c cVar = new c(blacklistFragmentComponentDependencies);
        this.e = cVar;
        f fVar = new f(blacklistFragmentComponentDependencies);
        this.f = fVar;
        BlacklistInteractorImpl_Factory create = BlacklistInteractorImpl_Factory.create(gVar, dVar, cVar, fVar);
        this.g = create;
        this.h = DoubleCheck.provider(create);
        DelegateFactory delegateFactory = new DelegateFactory();
        this.i = delegateFactory;
        this.j = DoubleCheck.provider(BlacklistFragmentModule_ProvideBlacklistInteractor$messenger_releaseFactory.create(this.b, delegateFactory));
        this.k = new h(blacklistFragmentComponentDependencies);
        Factory create2 = InstanceFactory.create(resources);
        this.l = create2;
        e eVar = new e(blacklistFragmentComponentDependencies);
        this.m = eVar;
        this.n = DoubleCheck.provider(BlacklistFragmentModule_ProvideBlacklistDateFormatterFactory.create(this.k, create2, eVar));
        Provider<Formatter<Throwable>> provider = DoubleCheck.provider(BlacklistFragmentModule_ProvideErrorFormatterFactory.create(this.l));
        this.o = provider;
        BlacklistPresenterImpl_Factory create3 = BlacklistPresenterImpl_Factory.create(this.c, this.d, this.j, this.n, provider);
        this.p = create3;
        this.q = DoubleCheck.provider(create3);
        MapProviderFactory build = MapProviderFactory.builder(2).put((MapProviderFactory.Builder) BlacklistInteractorImpl.class, (Provider) this.h).put((MapProviderFactory.Builder) BlacklistPresenterImpl.class, (Provider) this.q).build();
        this.r = build;
        DelegateFactory.setDelegate(this.i, SingleCheck.provider(ViewModelFactory_Factory.create(build)));
        Provider<BlacklistPresenter> provider2 = DoubleCheck.provider(BlacklistFragmentModule_ProvideBlacklistPresenter$messenger_releaseFactory.create(this.b, this.i));
        this.s = provider2;
        Provider<UnblockClickListener> provider3 = DoubleCheck.provider(BlacklistFragmentModule_ProvideUnblockClickListener$messenger_releaseFactory.create(provider2));
        this.t = provider3;
        Provider<BlockedUserPresenter> provider4 = DoubleCheck.provider(BlacklistFragmentModule_ProvideBlockedUserPresenter$messenger_releaseFactory.create(provider3));
        this.u = provider4;
        Provider<BlockedUserBlueprint> provider5 = DoubleCheck.provider(BlacklistFragmentModule_ProvideBlockedUserBlueprint$messenger_releaseFactory.create(provider4));
        this.v = provider5;
        Provider<ItemBinder> provider6 = DoubleCheck.provider(BlacklistFragmentModule_ProvideListItemBinder$messenger_releaseFactory.create(provider5));
        this.w = provider6;
        this.x = DoubleCheck.provider(BlacklistFragmentModule_ProvideAdapterPresenter$messenger_releaseFactory.create(provider6));
    }

    public static BlacklistFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponent
    public void inject(BlacklistFragment blacklistFragment) {
        BlacklistFragment_MembersInjector.injectSchedulers(blacklistFragment, (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
        BlacklistFragment_MembersInjector.injectAnalytics(blacklistFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        BlacklistFragment_MembersInjector.injectAdapterPresenter(blacklistFragment, this.x.get());
        BlacklistFragment_MembersInjector.injectItemBinder(blacklistFragment, this.w.get());
        BlacklistFragment_MembersInjector.injectBlacklistPresenter(blacklistFragment, this.s.get());
    }
}

package com.avito.android.messenger.blacklist_reasons.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsFragment;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsFragment_MembersInjector;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsPresenterImpl;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsPresenterImpl_Factory;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.blacklist_reasons.di.BlacklistReasonsComponent;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;
public final class DaggerBlacklistReasonsComponent implements BlacklistReasonsComponent {
    public final BlacklistReasonsComponentDependencies a;
    public final Fragment b;
    public Provider<BlockUserInteractor> c;
    public Provider<BlacklistReasonsProvider> d;
    public Provider<Fragment> e;
    public Provider<Formatter<Throwable>> f;
    public Provider<SchedulersFactory> g;
    public Provider<BlacklistReasonsPresenterImpl> h;
    public Provider<Map<Class<?>, Provider<ViewModel>>> i;
    public Provider<ViewModelFactory> j;

    public static final class b implements BlacklistReasonsComponent.Builder {
        public Fragment a;
        public BlacklistReasonsComponentDependencies b;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.blacklist_reasons.di.BlacklistReasonsComponent.Builder
        public BlacklistReasonsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Fragment.class);
            Preconditions.checkBuilderRequirement(this.b, BlacklistReasonsComponentDependencies.class);
            return new DaggerBlacklistReasonsComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.messenger.blacklist_reasons.di.BlacklistReasonsComponent.Builder
        public BlacklistReasonsComponent.Builder dependencies(BlacklistReasonsComponentDependencies blacklistReasonsComponentDependencies) {
            this.b = (BlacklistReasonsComponentDependencies) Preconditions.checkNotNull(blacklistReasonsComponentDependencies);
            return this;
        }

        @Override // com.avito.android.messenger.blacklist_reasons.di.BlacklistReasonsComponent.Builder
        public BlacklistReasonsComponent.Builder fragment(Fragment fragment) {
            this.a = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<BlacklistReasonsProvider> {
        public final BlacklistReasonsComponentDependencies a;

        public c(BlacklistReasonsComponentDependencies blacklistReasonsComponentDependencies) {
            this.a = blacklistReasonsComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BlacklistReasonsProvider get() {
            return (BlacklistReasonsProvider) Preconditions.checkNotNullFromComponent(this.a.blacklistReasonsProvider());
        }
    }

    public static class d implements Provider<BlockUserInteractor> {
        public final BlacklistReasonsComponentDependencies a;

        public d(BlacklistReasonsComponentDependencies blacklistReasonsComponentDependencies) {
            this.a = blacklistReasonsComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BlockUserInteractor get() {
            return (BlockUserInteractor) Preconditions.checkNotNullFromComponent(this.a.blockUserInteractor());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final BlacklistReasonsComponentDependencies a;

        public e(BlacklistReasonsComponentDependencies blacklistReasonsComponentDependencies) {
            this.a = blacklistReasonsComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerBlacklistReasonsComponent(BlacklistReasonsComponentDependencies blacklistReasonsComponentDependencies, Fragment fragment, a aVar) {
        this.a = blacklistReasonsComponentDependencies;
        this.b = fragment;
        this.c = new d(blacklistReasonsComponentDependencies);
        this.d = new c(blacklistReasonsComponentDependencies);
        Factory create = InstanceFactory.create(fragment);
        this.e = create;
        BlacklistReasonsModule_ProvideErrorFormatterFactory create2 = BlacklistReasonsModule_ProvideErrorFormatterFactory.create(create);
        this.f = create2;
        e eVar = new e(blacklistReasonsComponentDependencies);
        this.g = eVar;
        this.h = BlacklistReasonsPresenterImpl_Factory.create(this.c, this.d, create2, eVar);
        MapProviderFactory build = MapProviderFactory.builder(1).put((MapProviderFactory.Builder) BlacklistReasonsPresenterImpl.class, (Provider) this.h).build();
        this.i = build;
        this.j = SingleCheck.provider(ViewModelFactory_Factory.create(build));
    }

    public static BlacklistReasonsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.blacklist_reasons.di.BlacklistReasonsComponent
    public void inject(BlacklistReasonsFragment blacklistReasonsFragment) {
        BlacklistReasonsFragment_MembersInjector.injectSchedulers(blacklistReasonsFragment, (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
        BlacklistReasonsFragment_MembersInjector.injectPresenter(blacklistReasonsFragment, BlacklistReasonsModule_ProvideBlacklistReasonsPresenterFactory.provideBlacklistReasonsPresenter(this.j.get(), this.b));
    }
}

package com.avito.android.verification.di;

import android.content.res.Resources;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.VerificationApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.verification.VerificationResourceProviderImpl;
import com.avito.android.verification.VerificationResourceProviderImpl_Factory;
import com.avito.android.verification.di.VerificationsListComponent;
import com.avito.android.verification.verifications_list.VerificationOptionsListConverter;
import com.avito.android.verification.verifications_list.VerificationOptionsListConverterImpl_Factory;
import com.avito.android.verification.verifications_list.VerificationsListFragment;
import com.avito.android.verification.verifications_list.VerificationsListFragment_MembersInjector;
import com.avito.android.verification.verifications_list.VerificationsListInteractor;
import com.avito.android.verification.verifications_list.VerificationsListInteractorImpl;
import com.avito.android.verification.verifications_list.VerificationsListInteractorImpl_Factory;
import com.avito.android.verification.verifications_list.VerificationsListViewModel;
import com.avito.android.verification.verifications_list.VerificationsListViewModelFactory;
import com.avito.android.verification.verifications_list.VerificationsListViewModelFactory_Factory;
import com.avito.android.verification.verifications_list.list.VerificationsListBlueprint;
import com.avito.android.verification.verifications_list.list.VerificationsListBlueprint_Factory;
import com.avito.android.verification.verifications_list.list.VerificationsListItemPresenter;
import com.avito.android.verification.verifications_list.list.VerificationsListItemPresenterImpl_Factory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerVerificationsListComponent implements VerificationsListComponent {
    public final VerificationsListDependencies a;
    public Provider<VerificationsListItemPresenter> b;
    public Provider<VerificationsListBlueprint> c;
    public Provider<ItemBinder> d;
    public Provider<AdapterPresenter> e;
    public Provider<SimpleRecyclerAdapter> f;
    public Provider<ViewModelStoreOwner> g;
    public Provider<SchedulersFactory3> h;
    public Provider<VerificationApi> i;
    public Provider<TypedErrorThrowableConverter> j;
    public Provider<VerificationsListInteractorImpl> k;
    public Provider<VerificationsListInteractor> l;
    public Provider<Resources> m;
    public Provider<VerificationResourceProviderImpl> n;
    public Provider<VerificationOptionsListConverter> o;
    public Provider<VerificationsListViewModelFactory> p;
    public Provider<VerificationsListViewModel> q;
    public Provider<Set<ItemPresenter<?, ?>>> r;

    public static final class b implements VerificationsListComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.verification.di.VerificationsListComponent.Factory
        public VerificationsListComponent create(ViewModelStoreOwner viewModelStoreOwner, Resources resources, VerificationsListDependencies verificationsListDependencies) {
            Preconditions.checkNotNull(viewModelStoreOwner);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(verificationsListDependencies);
            return new DaggerVerificationsListComponent(new VerificationsListModule(), verificationsListDependencies, viewModelStoreOwner, resources, null);
        }
    }

    public static class c implements Provider<VerificationApi> {
        public final VerificationsListDependencies a;

        public c(VerificationsListDependencies verificationsListDependencies) {
            this.a = verificationsListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public VerificationApi get() {
            return (VerificationApi) Preconditions.checkNotNullFromComponent(this.a.getVerificationListApi());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final VerificationsListDependencies a;

        public d(VerificationsListDependencies verificationsListDependencies) {
            this.a = verificationsListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<TypedErrorThrowableConverter> {
        public final VerificationsListDependencies a;

        public e(VerificationsListDependencies verificationsListDependencies) {
            this.a = verificationsListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerVerificationsListComponent(VerificationsListModule verificationsListModule, VerificationsListDependencies verificationsListDependencies, ViewModelStoreOwner viewModelStoreOwner, Resources resources, a aVar) {
        this.a = verificationsListDependencies;
        Provider<VerificationsListItemPresenter> provider = DoubleCheck.provider(VerificationsListItemPresenterImpl_Factory.create());
        this.b = provider;
        VerificationsListBlueprint_Factory create = VerificationsListBlueprint_Factory.create(provider);
        this.c = create;
        Provider<ItemBinder> provider2 = DoubleCheck.provider(VerificationsListModule_ProvideItemBinder$verification_releaseFactory.create(verificationsListModule, create));
        this.d = provider2;
        Provider<AdapterPresenter> provider3 = DoubleCheck.provider(VerificationsListModule_ProvideAdapterFactory.create(verificationsListModule, provider2));
        this.e = provider3;
        this.f = DoubleCheck.provider(VerificationsListModule_ProvideRecyclerAdapter$verification_releaseFactory.create(verificationsListModule, provider3, this.d));
        this.g = InstanceFactory.create(viewModelStoreOwner);
        d dVar = new d(verificationsListDependencies);
        this.h = dVar;
        c cVar = new c(verificationsListDependencies);
        this.i = cVar;
        e eVar = new e(verificationsListDependencies);
        this.j = eVar;
        VerificationsListInteractorImpl_Factory create2 = VerificationsListInteractorImpl_Factory.create(dVar, cVar, eVar);
        this.k = create2;
        this.l = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(resources);
        this.m = create3;
        this.n = VerificationResourceProviderImpl_Factory.create(create3);
        Provider<VerificationOptionsListConverter> provider4 = DoubleCheck.provider(VerificationOptionsListConverterImpl_Factory.create());
        this.o = provider4;
        VerificationsListViewModelFactory_Factory create4 = VerificationsListViewModelFactory_Factory.create(this.l, this.h, this.n, provider4);
        this.p = create4;
        this.q = DoubleCheck.provider(VerificationsListModule_ProvideUserStatsFactory.create(verificationsListModule, this.g, create4));
        this.r = DoubleCheck.provider(VerificationsListModule_ProvideItemPresentersSetFactory.create(verificationsListModule, this.b));
    }

    public static VerificationsListComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.verification.di.VerificationsListComponent
    public void inject(VerificationsListFragment verificationsListFragment) {
        VerificationsListFragment_MembersInjector.injectAnalytics(verificationsListFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        VerificationsListFragment_MembersInjector.injectAdapter(verificationsListFragment, this.f.get());
        VerificationsListFragment_MembersInjector.injectAdapterPresenter(verificationsListFragment, this.e.get());
        VerificationsListFragment_MembersInjector.injectViewModel(verificationsListFragment, this.q.get());
        VerificationsListFragment_MembersInjector.injectItemPresentersSet(verificationsListFragment, this.r.get());
    }
}

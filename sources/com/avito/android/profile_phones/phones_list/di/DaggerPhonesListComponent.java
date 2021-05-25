package com.avito.android.profile_phones.phones_list.di;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.profile_phones.phones_list.PhonesConverter;
import com.avito.android.profile_phones.phones_list.PhonesConverterImpl;
import com.avito.android.profile_phones.phones_list.PhonesConverterImpl_Factory;
import com.avito.android.profile_phones.phones_list.PhonesListFragment;
import com.avito.android.profile_phones.phones_list.PhonesListFragment_MembersInjector;
import com.avito.android.profile_phones.phones_list.PhonesListInteractor;
import com.avito.android.profile_phones.phones_list.PhonesListInteractorImpl;
import com.avito.android.profile_phones.phones_list.PhonesListInteractorImpl_Factory;
import com.avito.android.profile_phones.phones_list.PhonesListResourceProvider;
import com.avito.android.profile_phones.phones_list.PhonesListViewModelFactory;
import com.avito.android.profile_phones.phones_list.PhonesListViewModelFactory_Factory;
import com.avito.android.profile_phones.phones_list.di.PhonesListComponent;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItemBlueprint;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItemPresenter;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItemPresenterImpl;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItemPresenterImpl_Factory;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class DaggerPhonesListComponent implements PhonesListComponent {
    public final PhonesListDependencies a;
    public Provider<Observable<PhoneListItem>> b;
    public Provider<PhonesListResourceProvider> c;
    public Provider<PhonesConverterImpl> d;
    public Provider<PhonesConverter> e;
    public Provider<ProfileApi> f;
    public Provider<SchedulersFactory3> g;
    public Provider<PhonesListInteractorImpl> h;
    public Provider<PhonesListInteractor> i;
    public Provider<Analytics> j;
    public Provider<PhonesListViewModelFactory> k;
    public Provider<ViewModelProvider.Factory> l;
    public Provider<Consumer<PhoneListItem>> m;
    public Provider<PhoneListItemPresenterImpl> n;
    public Provider<PhoneListItemPresenter> o;
    public Provider<PhoneListItemBlueprint> p;
    public Provider<ItemBinder> q;
    public Provider<AdapterPresenter> r;
    public Provider<RecyclerView.Adapter<?>> s;

    public static final class b implements PhonesListComponent.Builder {
        public PhonesListDependencies a;
        public PhonesListModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.profile_phones.phones_list.di.PhonesListComponent.Builder
        public PhonesListComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PhonesListDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, PhonesListModule.class);
            return new DaggerPhonesListComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.profile_phones.phones_list.di.PhonesListComponent.Builder
        public PhonesListComponent.Builder phonesListDependencies(PhonesListDependencies phonesListDependencies) {
            this.a = (PhonesListDependencies) Preconditions.checkNotNull(phonesListDependencies);
            return this;
        }

        @Override // com.avito.android.profile_phones.phones_list.di.PhonesListComponent.Builder
        public PhonesListComponent.Builder phonesListModule(PhonesListModule phonesListModule) {
            this.b = (PhonesListModule) Preconditions.checkNotNull(phonesListModule);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final PhonesListDependencies a;

        public c(PhonesListDependencies phonesListDependencies) {
            this.a = phonesListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<ProfileApi> {
        public final PhonesListDependencies a;

        public d(PhonesListDependencies phonesListDependencies) {
            this.a = phonesListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final PhonesListDependencies a;

        public e(PhonesListDependencies phonesListDependencies) {
            this.a = phonesListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerPhonesListComponent(PhonesListModule phonesListModule, PhonesListDependencies phonesListDependencies, a aVar) {
        this.a = phonesListDependencies;
        this.b = DoubleCheck.provider(PhonesListModule_ProvidePhoneListItemClickObservable$profile_phones_releaseFactory.create(phonesListModule));
        Provider<PhonesListResourceProvider> provider = DoubleCheck.provider(PhonesListModule_ProvideUserProfileResourceProvider$profile_phones_releaseFactory.create(phonesListModule));
        this.c = provider;
        PhonesConverterImpl_Factory create = PhonesConverterImpl_Factory.create(provider);
        this.d = create;
        Provider<PhonesConverter> provider2 = DoubleCheck.provider(create);
        this.e = provider2;
        d dVar = new d(phonesListDependencies);
        this.f = dVar;
        e eVar = new e(phonesListDependencies);
        this.g = eVar;
        PhonesListInteractorImpl_Factory create2 = PhonesListInteractorImpl_Factory.create(provider2, dVar, eVar);
        this.h = create2;
        Provider<PhonesListInteractor> provider3 = DoubleCheck.provider(create2);
        this.i = provider3;
        c cVar = new c(phonesListDependencies);
        this.j = cVar;
        PhonesListViewModelFactory_Factory create3 = PhonesListViewModelFactory_Factory.create(provider3, cVar);
        this.k = create3;
        this.l = DoubleCheck.provider(create3);
        Provider<Consumer<PhoneListItem>> provider4 = DoubleCheck.provider(PhonesListModule_ProvidePhoneListItemClickConsumer$profile_phones_releaseFactory.create(phonesListModule));
        this.m = provider4;
        PhoneListItemPresenterImpl_Factory create4 = PhoneListItemPresenterImpl_Factory.create(provider4);
        this.n = create4;
        Provider<PhoneListItemPresenter> provider5 = DoubleCheck.provider(create4);
        this.o = provider5;
        Provider<PhoneListItemBlueprint> provider6 = DoubleCheck.provider(PhonesListModule_ProvidePhonesCardBlueprint$profile_phones_releaseFactory.create(phonesListModule, provider5));
        this.p = provider6;
        Provider<ItemBinder> provider7 = DoubleCheck.provider(PhonesListModule_ProvideItemBinder$profile_phones_releaseFactory.create(phonesListModule, provider6));
        this.q = provider7;
        Provider<AdapterPresenter> provider8 = DoubleCheck.provider(PhonesListModule_ProvideAdapterPresenter$profile_phones_releaseFactory.create(phonesListModule, provider7));
        this.r = provider8;
        this.s = DoubleCheck.provider(PhonesListModule_ProvideAdapter$profile_phones_releaseFactory.create(phonesListModule, provider8, this.q));
    }

    public static PhonesListComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.profile_phones.phones_list.di.PhonesListComponent
    public void inject(PhonesListFragment phonesListFragment) {
        PhonesListFragment_MembersInjector.injectPhoneListItemClickObservable(phonesListFragment, this.b.get());
        PhonesListFragment_MembersInjector.injectPhonesListViewModelFactory(phonesListFragment, this.l.get());
        PhonesListFragment_MembersInjector.injectAdapter(phonesListFragment, this.s.get());
        PhonesListFragment_MembersInjector.injectAdapterPresenter(phonesListFragment, this.r.get());
        PhonesListFragment_MembersInjector.injectActivityIntentFactory(phonesListFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.intentFactory()));
        PhonesListFragment_MembersInjector.injectDeepLinkIntentFactory(phonesListFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        PhonesListFragment_MembersInjector.injectAnalytics(phonesListFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}

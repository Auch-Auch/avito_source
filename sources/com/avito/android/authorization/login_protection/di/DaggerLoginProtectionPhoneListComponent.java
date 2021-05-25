package com.avito.android.authorization.login_protection.di;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl;
import com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl_Factory;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListFragment;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListFragment_MembersInjector;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter;
import com.avito.android.authorization.login_protection.action.PhoneListAction;
import com.avito.android.authorization.login_protection.adapter.another.AnotherPhoneItemBlueprint;
import com.avito.android.authorization.login_protection.adapter.another.AnotherPhoneItemBlueprint_Factory;
import com.avito.android.authorization.login_protection.adapter.another.AnotherPhoneItemPresenter;
import com.avito.android.authorization.login_protection.adapter.another.AnotherPhoneItemPresenterImpl;
import com.avito.android.authorization.login_protection.adapter.another.AnotherPhoneItemPresenterImpl_Factory;
import com.avito.android.authorization.login_protection.adapter.not_found.PhoneNotFoundItemBlueprint;
import com.avito.android.authorization.login_protection.adapter.not_found.PhoneNotFoundItemBlueprint_Factory;
import com.avito.android.authorization.login_protection.adapter.not_found.PhoneNotFoundItemPresenter;
import com.avito.android.authorization.login_protection.adapter.not_found.PhoneNotFoundItemPresenterImpl_Factory;
import com.avito.android.authorization.login_protection.adapter.phone.PhoneItemBlueprint;
import com.avito.android.authorization.login_protection.adapter.phone.PhoneItemBlueprint_Factory;
import com.avito.android.authorization.login_protection.adapter.phone.PhoneItemPresenter;
import com.avito.android.authorization.login_protection.adapter.phone.PhoneItemPresenterImpl;
import com.avito.android.authorization.login_protection.adapter.phone.PhoneItemPresenterImpl_Factory;
import com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListComponent;
import com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatter;
import com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatterImpl;
import com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatterImpl_Factory;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl_Factory;
import com.avito.android.code_confirmation.tfa.TfaInteractor;
import com.avito.android.code_confirmation.tfa.TfaInteractorImpl;
import com.avito.android.code_confirmation.tfa.TfaInteractorImpl_Factory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerLoginProtectionPhoneListComponent implements LoginProtectionPhoneListComponent {
    public Provider<Set<ItemBlueprint<?, ?>>> A;
    public Provider<ItemBinder> B;
    public Provider<AdapterPresenter> C;
    public Provider<Boolean> D;
    public Provider<LoginProtectionPhoneFormatterImpl> E;
    public Provider<LoginProtectionPhoneFormatter> F;
    public Provider<Analytics> G;
    public Provider<ErrorFormatterImpl> H;
    public Provider<ErrorFormatter> I;
    public Provider<LoginProtectionListPresenterImpl> J;
    public Provider<LoginProtectionPhoneListPresenter> K;
    public Provider<RecyclerView.Adapter<?>> L;
    public final LoginProtectionPhoneListDependencies a;
    public Provider<ProfileApi> b;
    public Provider<SchedulersFactory3> c;
    public Provider<Resources> d;
    public Provider<CodeConfirmationResourceProviderImpl> e;
    public Provider<CodeConfirmationResourceProvider> f;
    public Provider<TypedErrorThrowableConverter> g;
    public Provider<AccountInteractor> h;
    public Provider<TfaInteractorImpl> i;
    public Provider<TfaInteractor> j;
    public Provider<List<String>> k;
    public Provider<String> l;
    public Provider<String> m;
    public Provider<Set<ItemBlueprint<?, ?>>> n = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PublishRelay<PhoneListAction>> o;
    public Provider<PhoneItemPresenterImpl> p;
    public Provider<PhoneItemPresenter> q;
    public Provider<PhoneItemBlueprint> r;
    public Provider<ItemBlueprint<?, ?>> s;
    public Provider<AnotherPhoneItemPresenterImpl> t;
    public Provider<AnotherPhoneItemPresenter> u;
    public Provider<AnotherPhoneItemBlueprint> v;
    public Provider<ItemBlueprint<?, ?>> w;
    public Provider<PhoneNotFoundItemPresenter> x;
    public Provider<PhoneNotFoundItemBlueprint> y;
    public Provider<ItemBlueprint<?, ?>> z;

    public static final class b implements LoginProtectionPhoneListComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListComponent.Factory
        public LoginProtectionPhoneListComponent create(List<String> list, String str, String str2, Resources resources, boolean z, LoginProtectionPhoneListDependencies loginProtectionPhoneListDependencies) {
            Preconditions.checkNotNull(list);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(Boolean.valueOf(z));
            Preconditions.checkNotNull(loginProtectionPhoneListDependencies);
            return new DaggerLoginProtectionPhoneListComponent(loginProtectionPhoneListDependencies, list, str, str2, resources, Boolean.valueOf(z), null);
        }
    }

    public static class c implements Provider<AccountInteractor> {
        public final LoginProtectionPhoneListDependencies a;

        public c(LoginProtectionPhoneListDependencies loginProtectionPhoneListDependencies) {
            this.a = loginProtectionPhoneListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountInteractor get() {
            return (AccountInteractor) Preconditions.checkNotNullFromComponent(this.a.accountInteractor());
        }
    }

    public static class d implements Provider<Analytics> {
        public final LoginProtectionPhoneListDependencies a;

        public d(LoginProtectionPhoneListDependencies loginProtectionPhoneListDependencies) {
            this.a = loginProtectionPhoneListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<ProfileApi> {
        public final LoginProtectionPhoneListDependencies a;

        public e(LoginProtectionPhoneListDependencies loginProtectionPhoneListDependencies) {
            this.a = loginProtectionPhoneListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class f implements Provider<SchedulersFactory3> {
        public final LoginProtectionPhoneListDependencies a;

        public f(LoginProtectionPhoneListDependencies loginProtectionPhoneListDependencies) {
            this.a = loginProtectionPhoneListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class g implements Provider<TypedErrorThrowableConverter> {
        public final LoginProtectionPhoneListDependencies a;

        public g(LoginProtectionPhoneListDependencies loginProtectionPhoneListDependencies) {
            this.a = loginProtectionPhoneListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerLoginProtectionPhoneListComponent(LoginProtectionPhoneListDependencies loginProtectionPhoneListDependencies, List list, String str, String str2, Resources resources, Boolean bool, a aVar) {
        this.a = loginProtectionPhoneListDependencies;
        this.b = new e(loginProtectionPhoneListDependencies);
        this.c = new f(loginProtectionPhoneListDependencies);
        Factory create = InstanceFactory.create(resources);
        this.d = create;
        CodeConfirmationResourceProviderImpl_Factory create2 = CodeConfirmationResourceProviderImpl_Factory.create(create);
        this.e = create2;
        Provider<CodeConfirmationResourceProvider> provider = DoubleCheck.provider(create2);
        this.f = provider;
        g gVar = new g(loginProtectionPhoneListDependencies);
        this.g = gVar;
        c cVar = new c(loginProtectionPhoneListDependencies);
        this.h = cVar;
        TfaInteractorImpl_Factory create3 = TfaInteractorImpl_Factory.create(this.b, this.c, provider, gVar, cVar);
        this.i = create3;
        this.j = DoubleCheck.provider(create3);
        this.k = InstanceFactory.create(list);
        this.l = InstanceFactory.create(str);
        this.m = InstanceFactory.createNullable(str2);
        Provider<PublishRelay<PhoneListAction>> provider2 = DoubleCheck.provider(LoginProtectionPhoneListModule_ProvidePhoneActionRelayFactory.create());
        this.o = provider2;
        PhoneItemPresenterImpl_Factory create4 = PhoneItemPresenterImpl_Factory.create(provider2);
        this.p = create4;
        Provider<PhoneItemPresenter> provider3 = DoubleCheck.provider(create4);
        this.q = provider3;
        PhoneItemBlueprint_Factory create5 = PhoneItemBlueprint_Factory.create(provider3);
        this.r = create5;
        this.s = DoubleCheck.provider(create5);
        AnotherPhoneItemPresenterImpl_Factory create6 = AnotherPhoneItemPresenterImpl_Factory.create(this.o);
        this.t = create6;
        Provider<AnotherPhoneItemPresenter> provider4 = DoubleCheck.provider(create6);
        this.u = provider4;
        AnotherPhoneItemBlueprint_Factory create7 = AnotherPhoneItemBlueprint_Factory.create(provider4);
        this.v = create7;
        this.w = DoubleCheck.provider(create7);
        Provider<PhoneNotFoundItemPresenter> provider5 = DoubleCheck.provider(PhoneNotFoundItemPresenterImpl_Factory.create());
        this.x = provider5;
        PhoneNotFoundItemBlueprint_Factory create8 = PhoneNotFoundItemBlueprint_Factory.create(provider5);
        this.y = create8;
        this.z = DoubleCheck.provider(create8);
        SetFactory build = SetFactory.builder(3, 1).addCollectionProvider(this.n).addProvider(this.s).addProvider(this.w).addProvider(this.z).build();
        this.A = build;
        Provider<ItemBinder> provider6 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.B = provider6;
        this.C = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider6));
        Factory create9 = InstanceFactory.create(bool);
        this.D = create9;
        LoginProtectionPhoneFormatterImpl_Factory create10 = LoginProtectionPhoneFormatterImpl_Factory.create(create9);
        this.E = create10;
        this.F = DoubleCheck.provider(create10);
        this.G = new d(loginProtectionPhoneListDependencies);
        ErrorFormatterImpl_Factory create11 = ErrorFormatterImpl_Factory.create(this.d);
        this.H = create11;
        Provider<ErrorFormatter> provider7 = SingleCheck.provider(create11);
        this.I = provider7;
        LoginProtectionListPresenterImpl_Factory create12 = LoginProtectionListPresenterImpl_Factory.create(this.j, this.c, this.k, this.l, this.m, this.C, this.o, this.F, this.G, provider7, this.D);
        this.J = create12;
        this.K = DoubleCheck.provider(create12);
        this.L = DoubleCheck.provider(LoginProtectionPhoneListModule_ProvideAdapterFactory.create(this.C, this.B));
    }

    public static LoginProtectionPhoneListComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListComponent
    public void inject(LoginProtectionPhoneListFragment loginProtectionPhoneListFragment) {
        LoginProtectionPhoneListFragment_MembersInjector.injectPresenter(loginProtectionPhoneListFragment, this.K.get());
        LoginProtectionPhoneListFragment_MembersInjector.injectAdapterPresenter(loginProtectionPhoneListFragment, this.L.get());
        LoginProtectionPhoneListFragment_MembersInjector.injectActivityIntentFactory(loginProtectionPhoneListFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        LoginProtectionPhoneListFragment_MembersInjector.injectAnalytics(loginProtectionPhoneListFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}

package com.avito.android.verification.di;

import android.content.res.Resources;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.remote.VerificationApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.verification.VerificationResourceProviderImpl;
import com.avito.android.verification.VerificationResourceProviderImpl_Factory;
import com.avito.android.verification.di.VerificationActionComponent;
import com.avito.android.verification.verification_status.VerificationStatusInteractor;
import com.avito.android.verification.verification_status.VerificationStatusInteractorImpl;
import com.avito.android.verification.verification_status.VerificationStatusInteractorImpl_Factory;
import com.avito.android.verification.verification_status.actions.VerificationActionActivity;
import com.avito.android.verification.verification_status.actions.VerificationActionActivity_MembersInjector;
import com.avito.android.verification.verification_status.actions.VerificationActionViewModel;
import com.avito.android.verification.verification_status.actions.VerificationActionViewModelFactory;
import com.avito.android.verification.verification_status.actions.VerificationActionViewModelFactory_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerVerificationActionComponent implements VerificationActionComponent {
    public Provider<ViewModelStoreOwner> a;
    public Provider<SchedulersFactory3> b;
    public Provider<VerificationApi> c;
    public Provider<TypedErrorThrowableConverter> d;
    public Provider<VerificationStatusInteractorImpl> e;
    public Provider<VerificationStatusInteractor> f;
    public Provider<Resources> g;
    public Provider<VerificationResourceProviderImpl> h;
    public Provider<String> i;
    public Provider<VerificationActionViewModelFactory> j;
    public Provider<VerificationActionViewModel> k;

    public static final class b implements VerificationActionComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.verification.di.VerificationActionComponent.Factory
        public VerificationActionComponent create(ViewModelStoreOwner viewModelStoreOwner, VerificationActionDependencies verificationActionDependencies, Resources resources, String str) {
            Preconditions.checkNotNull(viewModelStoreOwner);
            Preconditions.checkNotNull(verificationActionDependencies);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(str);
            return new DaggerVerificationActionComponent(new VerificationActionModule(), verificationActionDependencies, viewModelStoreOwner, resources, str, null);
        }
    }

    public static class c implements Provider<VerificationApi> {
        public final VerificationActionDependencies a;

        public c(VerificationActionDependencies verificationActionDependencies) {
            this.a = verificationActionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public VerificationApi get() {
            return (VerificationApi) Preconditions.checkNotNullFromComponent(this.a.getVerificationListApi());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final VerificationActionDependencies a;

        public d(VerificationActionDependencies verificationActionDependencies) {
            this.a = verificationActionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<TypedErrorThrowableConverter> {
        public final VerificationActionDependencies a;

        public e(VerificationActionDependencies verificationActionDependencies) {
            this.a = verificationActionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerVerificationActionComponent(VerificationActionModule verificationActionModule, VerificationActionDependencies verificationActionDependencies, ViewModelStoreOwner viewModelStoreOwner, Resources resources, String str, a aVar) {
        this.a = InstanceFactory.create(viewModelStoreOwner);
        d dVar = new d(verificationActionDependencies);
        this.b = dVar;
        c cVar = new c(verificationActionDependencies);
        this.c = cVar;
        e eVar = new e(verificationActionDependencies);
        this.d = eVar;
        VerificationStatusInteractorImpl_Factory create = VerificationStatusInteractorImpl_Factory.create(dVar, cVar, eVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.g = create2;
        this.h = VerificationResourceProviderImpl_Factory.create(create2);
        Factory create3 = InstanceFactory.create(str);
        this.i = create3;
        VerificationActionViewModelFactory_Factory create4 = VerificationActionViewModelFactory_Factory.create(this.f, this.b, this.h, create3);
        this.j = create4;
        this.k = DoubleCheck.provider(VerificationActionModule_ProvideUserStatsFactory.create(verificationActionModule, this.a, create4));
    }

    public static VerificationActionComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.verification.di.VerificationActionComponent
    public void inject(VerificationActionActivity verificationActionActivity) {
        VerificationActionActivity_MembersInjector.injectViewModel(verificationActionActivity, this.k.get());
    }
}

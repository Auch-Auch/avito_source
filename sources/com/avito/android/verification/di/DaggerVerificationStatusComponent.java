package com.avito.android.verification.di;

import android.content.res.Resources;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.VerificationApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterImpl_Factory;
import com.avito.android.verification.VerificationResourceProviderImpl;
import com.avito.android.verification.VerificationResourceProviderImpl_Factory;
import com.avito.android.verification.di.VerificationStatusComponent;
import com.avito.android.verification.verification_status.VerificationStatusConverter;
import com.avito.android.verification.verification_status.VerificationStatusConverterImpl;
import com.avito.android.verification.verification_status.VerificationStatusConverterImpl_Factory;
import com.avito.android.verification.verification_status.VerificationStatusFragment;
import com.avito.android.verification.verification_status.VerificationStatusFragment_MembersInjector;
import com.avito.android.verification.verification_status.VerificationStatusInteractor;
import com.avito.android.verification.verification_status.VerificationStatusInteractorImpl;
import com.avito.android.verification.verification_status.VerificationStatusInteractorImpl_Factory;
import com.avito.android.verification.verification_status.VerificationStatusViewModel;
import com.avito.android.verification.verification_status.VerificationStatusViewModelFactory;
import com.avito.android.verification.verification_status.VerificationStatusViewModelFactory_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerVerificationStatusComponent implements VerificationStatusComponent {
    public final VerificationStatusDependencies a;
    public Provider<ViewModelStoreOwner> b;
    public Provider<SchedulersFactory3> c;
    public Provider<VerificationApi> d;
    public Provider<TypedErrorThrowableConverter> e;
    public Provider<VerificationStatusInteractorImpl> f;
    public Provider<VerificationStatusInteractor> g;
    public Provider<Resources> h;
    public Provider<VerificationResourceProviderImpl> i;
    public Provider<Features> j;
    public Provider<VerificationStatusConverterImpl> k;
    public Provider<VerificationStatusConverter> l;
    public Provider<VerificationStatusViewModelFactory> m;
    public Provider<VerificationStatusViewModel> n;
    public Provider<AttributedTextFormatter> o = DoubleCheck.provider(AttributedTextFormatterImpl_Factory.create());

    public static final class b implements VerificationStatusComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.verification.di.VerificationStatusComponent.Factory
        public VerificationStatusComponent create(ViewModelStoreOwner viewModelStoreOwner, Resources resources, VerificationStatusDependencies verificationStatusDependencies) {
            Preconditions.checkNotNull(viewModelStoreOwner);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(verificationStatusDependencies);
            return new DaggerVerificationStatusComponent(new VerificationStatusModule(), verificationStatusDependencies, viewModelStoreOwner, resources, null);
        }
    }

    public static class c implements Provider<Features> {
        public final VerificationStatusDependencies a;

        public c(VerificationStatusDependencies verificationStatusDependencies) {
            this.a = verificationStatusDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class d implements Provider<VerificationApi> {
        public final VerificationStatusDependencies a;

        public d(VerificationStatusDependencies verificationStatusDependencies) {
            this.a = verificationStatusDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public VerificationApi get() {
            return (VerificationApi) Preconditions.checkNotNullFromComponent(this.a.getVerificationListApi());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final VerificationStatusDependencies a;

        public e(VerificationStatusDependencies verificationStatusDependencies) {
            this.a = verificationStatusDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class f implements Provider<TypedErrorThrowableConverter> {
        public final VerificationStatusDependencies a;

        public f(VerificationStatusDependencies verificationStatusDependencies) {
            this.a = verificationStatusDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerVerificationStatusComponent(VerificationStatusModule verificationStatusModule, VerificationStatusDependencies verificationStatusDependencies, ViewModelStoreOwner viewModelStoreOwner, Resources resources, a aVar) {
        this.a = verificationStatusDependencies;
        this.b = InstanceFactory.create(viewModelStoreOwner);
        e eVar = new e(verificationStatusDependencies);
        this.c = eVar;
        d dVar = new d(verificationStatusDependencies);
        this.d = dVar;
        f fVar = new f(verificationStatusDependencies);
        this.e = fVar;
        VerificationStatusInteractorImpl_Factory create = VerificationStatusInteractorImpl_Factory.create(eVar, dVar, fVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.h = create2;
        this.i = VerificationResourceProviderImpl_Factory.create(create2);
        c cVar = new c(verificationStatusDependencies);
        this.j = cVar;
        VerificationStatusConverterImpl_Factory create3 = VerificationStatusConverterImpl_Factory.create(cVar);
        this.k = create3;
        Provider<VerificationStatusConverter> provider = DoubleCheck.provider(create3);
        this.l = provider;
        VerificationStatusViewModelFactory_Factory create4 = VerificationStatusViewModelFactory_Factory.create(this.g, this.c, this.i, provider);
        this.m = create4;
        this.n = DoubleCheck.provider(VerificationStatusModule_ProvideUserStatsFactory.create(verificationStatusModule, this.b, create4));
    }

    public static VerificationStatusComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.verification.di.VerificationStatusComponent
    public void inject(VerificationStatusFragment verificationStatusFragment) {
        VerificationStatusFragment_MembersInjector.injectViewModel(verificationStatusFragment, this.n.get());
        VerificationStatusFragment_MembersInjector.injectTextFormatter(verificationStatusFragment, this.o.get());
        VerificationStatusFragment_MembersInjector.injectAnalytics(verificationStatusFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        VerificationStatusFragment_MembersInjector.injectDeepLinkIntentFactory(verificationStatusFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        VerificationStatusFragment_MembersInjector.injectImplicitIntentFactory(verificationStatusFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
    }
}

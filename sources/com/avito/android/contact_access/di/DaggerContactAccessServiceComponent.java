package com.avito.android.contact_access.di;

import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.contact_access.ContactAccessServiceArguments;
import com.avito.android.contact_access.ContactAccessServiceFragment;
import com.avito.android.contact_access.ContactAccessServiceFragment_MembersInjector;
import com.avito.android.contact_access.ContactAccessServiceInteractor;
import com.avito.android.contact_access.ContactAccessServiceInteractorImpl;
import com.avito.android.contact_access.ContactAccessServiceInteractorImpl_Factory;
import com.avito.android.contact_access.ContactAccessServicePresenter;
import com.avito.android.contact_access.ContactAccessServicePresenterImpl;
import com.avito.android.contact_access.ContactAccessServicePresenterImpl_Factory;
import com.avito.android.contact_access.IncompleteSocialInteractorImpl;
import com.avito.android.contact_access.IncompleteSocialInteractorImpl_Factory;
import com.avito.android.contact_access.di.ContactAccessServiceComponent;
import com.avito.android.contact_access.remote.ContactAccessApi;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.ProfileApi;
import com.avito.android.social.incomplete.IncompleteSocialInteractor;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerContactAccessServiceComponent implements ContactAccessServiceComponent {
    public final ContactAccessDependencies a;
    public Provider<ProfileApi> b;
    public Provider<IncompleteSocialInteractorImpl> c;
    public Provider<IncompleteSocialInteractor> d;
    public Provider<ContactAccessApi> e;
    public Provider<ContactAccessServiceArguments> f;
    public Provider<ContactAccessServiceInteractorImpl> g;
    public Provider<ContactAccessServiceInteractor> h;
    public Provider<Resources> i;
    public Provider<ErrorFormatterImpl> j;
    public Provider<Formatter<Throwable>> k;
    public Provider<SchedulersFactory> l;
    public Provider<Bundle> m;
    public Provider<ContactAccessServicePresenterImpl> n;
    public Provider<ContactAccessServicePresenter> o;

    public static final class b implements ContactAccessServiceComponent.Builder {
        public ContactAccessDependencies a;
        public ContactAccessServiceArguments b;
        public Bundle c;
        public Resources d;

        public b(a aVar) {
        }

        @Override // com.avito.android.contact_access.di.ContactAccessServiceComponent.Builder
        public ContactAccessServiceComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ContactAccessDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ContactAccessServiceArguments.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            return new DaggerContactAccessServiceComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.contact_access.di.ContactAccessServiceComponent.Builder
        public ContactAccessServiceComponent.Builder dependentOn(ContactAccessDependencies contactAccessDependencies) {
            this.a = (ContactAccessDependencies) Preconditions.checkNotNull(contactAccessDependencies);
            return this;
        }

        @Override // com.avito.android.contact_access.di.ContactAccessServiceComponent.Builder
        public ContactAccessServiceComponent.Builder withArgs(ContactAccessServiceArguments contactAccessServiceArguments) {
            this.b = (ContactAccessServiceArguments) Preconditions.checkNotNull(contactAccessServiceArguments);
            return this;
        }

        @Override // com.avito.android.contact_access.di.ContactAccessServiceComponent.Builder
        public ContactAccessServiceComponent.Builder withResources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.contact_access.di.ContactAccessServiceComponent.Builder
        public ContactAccessServiceComponent.Builder withState(Bundle bundle) {
            this.c = bundle;
            return this;
        }
    }

    public static class c implements Provider<ContactAccessApi> {
        public final ContactAccessDependencies a;

        public c(ContactAccessDependencies contactAccessDependencies) {
            this.a = contactAccessDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ContactAccessApi get() {
            return (ContactAccessApi) Preconditions.checkNotNullFromComponent(this.a.contactAccessApi());
        }
    }

    public static class d implements Provider<ProfileApi> {
        public final ContactAccessDependencies a;

        public d(ContactAccessDependencies contactAccessDependencies) {
            this.a = contactAccessDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final ContactAccessDependencies a;

        public e(ContactAccessDependencies contactAccessDependencies) {
            this.a = contactAccessDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerContactAccessServiceComponent(ContactAccessDependencies contactAccessDependencies, ContactAccessServiceArguments contactAccessServiceArguments, Bundle bundle, Resources resources, a aVar) {
        this.a = contactAccessDependencies;
        d dVar = new d(contactAccessDependencies);
        this.b = dVar;
        IncompleteSocialInteractorImpl_Factory create = IncompleteSocialInteractorImpl_Factory.create(dVar);
        this.c = create;
        this.d = DoubleCheck.provider(create);
        this.e = new c(contactAccessDependencies);
        Factory create2 = InstanceFactory.create(contactAccessServiceArguments);
        this.f = create2;
        ContactAccessServiceInteractorImpl_Factory create3 = ContactAccessServiceInteractorImpl_Factory.create(this.d, this.e, create2);
        this.g = create3;
        this.h = DoubleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(resources);
        this.i = create4;
        ErrorFormatterImpl_Factory create5 = ErrorFormatterImpl_Factory.create(create4);
        this.j = create5;
        this.k = DoubleCheck.provider(create5);
        this.l = new e(contactAccessDependencies);
        Factory createNullable = InstanceFactory.createNullable(bundle);
        this.m = createNullable;
        ContactAccessServicePresenterImpl_Factory create6 = ContactAccessServicePresenterImpl_Factory.create(this.h, this.k, this.l, createNullable);
        this.n = create6;
        this.o = DoubleCheck.provider(create6);
    }

    public static ContactAccessServiceComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.contact_access.di.ContactAccessServiceComponent
    public void inject(ContactAccessServiceFragment contactAccessServiceFragment) {
        ContactAccessServiceFragment_MembersInjector.injectActivityIntentFactory(contactAccessServiceFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ContactAccessServiceFragment_MembersInjector.injectDeepLinkIntentFactory(contactAccessServiceFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        ContactAccessServiceFragment_MembersInjector.injectPresenter(contactAccessServiceFragment, this.o.get());
        ContactAccessServiceFragment_MembersInjector.injectAnalytics(contactAccessServiceFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}

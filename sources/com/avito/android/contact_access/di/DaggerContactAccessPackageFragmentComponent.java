package com.avito.android.contact_access.di;

import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.contact_access.ContactAccessPackageFragment;
import com.avito.android.contact_access.ContactAccessPackageFragment_MembersInjector;
import com.avito.android.contact_access.ContactAccessPackageInteractor;
import com.avito.android.contact_access.ContactAccessPackageInteractorImpl;
import com.avito.android.contact_access.ContactAccessPackageInteractorImpl_Factory;
import com.avito.android.contact_access.ContactAccessPackagePresenter;
import com.avito.android.contact_access.ContactAccessPackagePresenterImpl;
import com.avito.android.contact_access.ContactAccessPackagePresenterImpl_Factory;
import com.avito.android.contact_access.di.ContactAccessPackageFragmentComponent;
import com.avito.android.contact_access.remote.ContactAccessApi;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerContactAccessPackageFragmentComponent implements ContactAccessPackageFragmentComponent {
    public Provider<ContactAccessApi> a;
    public Provider<String> b;
    public Provider<ContactAccessPackageInteractorImpl> c;
    public Provider<ContactAccessPackageInteractor> d;
    public Provider<Resources> e;
    public Provider<ErrorFormatterImpl> f;
    public Provider<Formatter<Throwable>> g;
    public Provider<SchedulersFactory> h;
    public Provider<Bundle> i;
    public Provider<ContactAccessPackagePresenterImpl> j;
    public Provider<ContactAccessPackagePresenter> k;

    public static final class b implements ContactAccessPackageFragmentComponent.Builder {
        public ContactAccessDependencies a;
        public String b;
        public Bundle c;
        public Resources d;

        public b(a aVar) {
        }

        @Override // com.avito.android.contact_access.di.ContactAccessPackageFragmentComponent.Builder
        public ContactAccessPackageFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ContactAccessDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            return new DaggerContactAccessPackageFragmentComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.contact_access.di.ContactAccessPackageFragmentComponent.Builder
        public ContactAccessPackageFragmentComponent.Builder dependentOn(ContactAccessDependencies contactAccessDependencies) {
            this.a = (ContactAccessDependencies) Preconditions.checkNotNull(contactAccessDependencies);
            return this;
        }

        @Override // com.avito.android.contact_access.di.ContactAccessPackageFragmentComponent.Builder
        public ContactAccessPackageFragmentComponent.Builder withAdvertId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.contact_access.di.ContactAccessPackageFragmentComponent.Builder
        public ContactAccessPackageFragmentComponent.Builder withResources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.contact_access.di.ContactAccessPackageFragmentComponent.Builder
        public ContactAccessPackageFragmentComponent.Builder withState(Bundle bundle) {
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

    public static class d implements Provider<SchedulersFactory> {
        public final ContactAccessDependencies a;

        public d(ContactAccessDependencies contactAccessDependencies) {
            this.a = contactAccessDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerContactAccessPackageFragmentComponent(ContactAccessDependencies contactAccessDependencies, String str, Bundle bundle, Resources resources, a aVar) {
        this.a = new c(contactAccessDependencies);
        Factory create = InstanceFactory.create(str);
        this.b = create;
        ContactAccessPackageInteractorImpl_Factory create2 = ContactAccessPackageInteractorImpl_Factory.create(this.a, create);
        this.c = create2;
        this.d = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(resources);
        this.e = create3;
        ErrorFormatterImpl_Factory create4 = ErrorFormatterImpl_Factory.create(create3);
        this.f = create4;
        this.g = DoubleCheck.provider(create4);
        this.h = new d(contactAccessDependencies);
        Factory createNullable = InstanceFactory.createNullable(bundle);
        this.i = createNullable;
        ContactAccessPackagePresenterImpl_Factory create5 = ContactAccessPackagePresenterImpl_Factory.create(this.d, this.g, this.h, createNullable);
        this.j = create5;
        this.k = DoubleCheck.provider(create5);
    }

    public static ContactAccessPackageFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.contact_access.di.ContactAccessPackageFragmentComponent
    public void inject(ContactAccessPackageFragment contactAccessPackageFragment) {
        ContactAccessPackageFragment_MembersInjector.injectPresenter(contactAccessPackageFragment, this.k.get());
    }
}

package com.avito.android.photo_wizard.di;

import android.content.Context;
import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraOpenInteractorImpl;
import com.avito.android.photo_picker.legacy.CameraOpenInteractorImpl_Factory;
import com.avito.android.photo_picker.legacy.CameraSource;
import com.avito.android.photo_picker.legacy.CameraSourceImpl_Factory;
import com.avito.android.photo_wizard.PhotoWizardFragment;
import com.avito.android.photo_wizard.PhotoWizardFragment_MembersInjector;
import com.avito.android.photo_wizard.PhotoWizardImageResizer;
import com.avito.android.photo_wizard.PhotoWizardImageResizerImpl_Factory;
import com.avito.android.photo_wizard.PhotoWizardResourceProvider;
import com.avito.android.photo_wizard.PhotoWizardResourceProviderImpl;
import com.avito.android.photo_wizard.PhotoWizardResourceProviderImpl_Factory;
import com.avito.android.photo_wizard.PhotoWizardViewModelFactory;
import com.avito.android.photo_wizard.UploadPicturesInteractor;
import com.avito.android.photo_wizard.UploadPicturesInteractorImpl;
import com.avito.android.photo_wizard.UploadPicturesInteractorImpl_Factory;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenter;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenterImpl;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenterImpl_Factory;
import com.avito.android.photo_wizard.converter.DocumentTypesConverter;
import com.avito.android.photo_wizard.converter.DocumentTypesConverterImpl_Factory;
import com.avito.android.photo_wizard.converter.WizardStepsConverter;
import com.avito.android.photo_wizard.converter.WizardStepsConverterImpl;
import com.avito.android.photo_wizard.converter.WizardStepsConverterImpl_Factory;
import com.avito.android.photo_wizard.di.PhotoWizardComponent;
import com.avito.android.photo_wizard.remote.PhotoWizardApi;
import com.avito.android.remote.model.VerificationStep;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class DaggerPhotoWizardComponent implements PhotoWizardComponent {
    public final String a;
    public final List<VerificationStep> b;
    public final WizardImageUploadDependencies c;
    public Provider<DocumentTypesConverter> d;
    public Provider<WizardStepsConverterImpl> e;
    public Provider<WizardStepsConverter> f;
    public Provider<PhotoWizardApi> g;
    public Provider<Context> h;
    public Provider<PrivatePhotosStorage> i;
    public Provider<String> j;
    public Provider<UploadPicturesInteractorImpl> k;
    public Provider<UploadPicturesInteractor> l;
    public Provider<Resources> m;
    public Provider<PhotoWizardResourceProviderImpl> n;
    public Provider<PhotoWizardResourceProvider> o;
    public Provider<CameraSource> p;
    public Provider<Analytics> q;
    public Provider<CameraOpenInteractorImpl> r;
    public Provider<CameraOpenInteractor> s;
    public Provider<SchedulersFactory3> t;
    public Provider<PermissionHelper> u;
    public Provider<PhotoWizardImageResizer> v;
    public Provider<SharedPhotosStorage> w;
    public Provider<WizardPhotoPickerPresenterImpl> x;
    public Provider<WizardPhotoPickerPresenter> y;

    public static final class b implements PhotoWizardComponent.Builder {
        public WizardImageUploadDependencies a;
        public String b;
        public List<VerificationStep> c;
        public PermissionHelper d;
        public Resources e;

        public b(a aVar) {
        }

        @Override // com.avito.android.photo_wizard.di.PhotoWizardComponent.Builder
        public PhotoWizardComponent build() {
            Preconditions.checkBuilderRequirement(this.a, WizardImageUploadDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, List.class);
            Preconditions.checkBuilderRequirement(this.d, PermissionHelper.class);
            Preconditions.checkBuilderRequirement(this.e, Resources.class);
            return new DaggerPhotoWizardComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.photo_wizard.di.PhotoWizardComponent.Builder
        public PhotoWizardComponent.Builder dependencies(WizardImageUploadDependencies wizardImageUploadDependencies) {
            this.a = (WizardImageUploadDependencies) Preconditions.checkNotNull(wizardImageUploadDependencies);
            return this;
        }

        @Override // com.avito.android.photo_wizard.di.PhotoWizardComponent.Builder
        public PhotoWizardComponent.Builder withAdvertId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.photo_wizard.di.PhotoWizardComponent.Builder
        public PhotoWizardComponent.Builder withPermissionHelper(PermissionHelper permissionHelper) {
            this.d = (PermissionHelper) Preconditions.checkNotNull(permissionHelper);
            return this;
        }

        @Override // com.avito.android.photo_wizard.di.PhotoWizardComponent.Builder
        public PhotoWizardComponent.Builder withResources(Resources resources) {
            this.e = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.photo_wizard.di.PhotoWizardComponent.Builder
        public PhotoWizardComponent.Builder withVerificationSteps(List list) {
            this.c = (List) Preconditions.checkNotNull(list);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final WizardImageUploadDependencies a;

        public c(WizardImageUploadDependencies wizardImageUploadDependencies) {
            this.a = wizardImageUploadDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Context> {
        public final WizardImageUploadDependencies a;

        public d(WizardImageUploadDependencies wizardImageUploadDependencies) {
            this.a = wizardImageUploadDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class e implements Provider<PhotoWizardApi> {
        public final WizardImageUploadDependencies a;

        public e(WizardImageUploadDependencies wizardImageUploadDependencies) {
            this.a = wizardImageUploadDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PhotoWizardApi get() {
            return (PhotoWizardApi) Preconditions.checkNotNullFromComponent(this.a.photoWizardApi());
        }
    }

    public static class f implements Provider<PrivatePhotosStorage> {
        public final WizardImageUploadDependencies a;

        public f(WizardImageUploadDependencies wizardImageUploadDependencies) {
            this.a = wizardImageUploadDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PrivatePhotosStorage get() {
            return (PrivatePhotosStorage) Preconditions.checkNotNullFromComponent(this.a.privatePhotosStorage());
        }
    }

    public static class g implements Provider<SchedulersFactory3> {
        public final WizardImageUploadDependencies a;

        public g(WizardImageUploadDependencies wizardImageUploadDependencies) {
            this.a = wizardImageUploadDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class h implements Provider<SharedPhotosStorage> {
        public final WizardImageUploadDependencies a;

        public h(WizardImageUploadDependencies wizardImageUploadDependencies) {
            this.a = wizardImageUploadDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SharedPhotosStorage get() {
            return (SharedPhotosStorage) Preconditions.checkNotNullFromComponent(this.a.sharedPhotosStorage());
        }
    }

    public DaggerPhotoWizardComponent(WizardImageUploadDependencies wizardImageUploadDependencies, String str, List list, PermissionHelper permissionHelper, Resources resources, a aVar) {
        this.a = str;
        this.b = list;
        this.c = wizardImageUploadDependencies;
        Provider<DocumentTypesConverter> provider = DoubleCheck.provider(DocumentTypesConverterImpl_Factory.create());
        this.d = provider;
        WizardStepsConverterImpl_Factory create = WizardStepsConverterImpl_Factory.create(provider);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        this.g = new e(wizardImageUploadDependencies);
        this.h = new d(wizardImageUploadDependencies);
        this.i = new f(wizardImageUploadDependencies);
        Factory create2 = InstanceFactory.create(str);
        this.j = create2;
        UploadPicturesInteractorImpl_Factory create3 = UploadPicturesInteractorImpl_Factory.create(this.g, this.h, this.i, create2);
        this.k = create3;
        this.l = DoubleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(resources);
        this.m = create4;
        PhotoWizardResourceProviderImpl_Factory create5 = PhotoWizardResourceProviderImpl_Factory.create(create4);
        this.n = create5;
        this.o = DoubleCheck.provider(create5);
        Provider<CameraSource> provider2 = DoubleCheck.provider(CameraSourceImpl_Factory.create());
        this.p = provider2;
        c cVar = new c(wizardImageUploadDependencies);
        this.q = cVar;
        CameraOpenInteractorImpl_Factory create6 = CameraOpenInteractorImpl_Factory.create(provider2, cVar);
        this.r = create6;
        this.s = DoubleCheck.provider(create6);
        this.t = new g(wizardImageUploadDependencies);
        this.u = InstanceFactory.create(permissionHelper);
        Provider<PhotoWizardImageResizer> provider3 = DoubleCheck.provider(PhotoWizardImageResizerImpl_Factory.create());
        this.v = provider3;
        h hVar = new h(wizardImageUploadDependencies);
        this.w = hVar;
        WizardPhotoPickerPresenterImpl_Factory create7 = WizardPhotoPickerPresenterImpl_Factory.create(this.s, this.t, this.u, this.o, provider3, hVar);
        this.x = create7;
        this.y = DoubleCheck.provider(create7);
    }

    public static PhotoWizardComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.photo_wizard.di.PhotoWizardComponent
    public void inject(PhotoWizardFragment photoWizardFragment) {
        PhotoWizardFragment_MembersInjector.injectViewModelFactory(photoWizardFragment, new PhotoWizardViewModelFactory(this.a, this.b, this.f.get(), this.l.get(), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.c.schedulersFactory3()), this.o.get(), (Analytics) Preconditions.checkNotNullFromComponent(this.c.analytics())));
        PhotoWizardFragment_MembersInjector.injectPresenter(photoWizardFragment, this.y.get());
        PhotoWizardFragment_MembersInjector.injectIntentFactory(photoWizardFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.c.implicitIntentFactory()));
        PhotoWizardFragment_MembersInjector.injectFeatures(photoWizardFragment, (Features) Preconditions.checkNotNullFromComponent(this.c.features()));
    }
}

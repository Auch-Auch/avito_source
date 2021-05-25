package com.avito.android.photo_picker.edit.di;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl_Factory;
import com.avito.android.photo_picker.edit.EditPhotoFragment;
import com.avito.android.photo_picker.edit.EditPhotoFragment_MembersInjector;
import com.avito.android.photo_picker.edit.EditPhotoViewModel;
import com.avito.android.photo_picker.edit.EditPhotoViewModelFactory;
import com.avito.android.photo_picker.edit.EditPhotoViewModelFactory_Factory;
import com.avito.android.photo_picker.edit.ExifProvider;
import com.avito.android.photo_picker.edit.di.EditPhotoComponent;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerEditPhotoComponent implements EditPhotoComponent {
    public Provider<Fragment> a;
    public Provider<SharedPhotosStorage> b;
    public Provider<SchedulersFactory3> c;
    public Provider<PhotoPickerEventTracker> d;
    public Provider<Context> e;
    public Provider<PrivatePhotosStorage> f;
    public Provider<Gson> g;
    public Provider<ExifExtraDataSerializerImpl> h;
    public Provider<ExifExtraDataSerializer> i;
    public Provider<ExifProvider> j;
    public Provider<EditPhotoViewModelFactory> k;
    public Provider<ViewModelProvider.Factory> l;
    public Provider<EditPhotoViewModel> m;

    public static final class b implements EditPhotoComponent.Builder {
        public EditPhotoDependencies a;
        public Fragment b;

        public b(a aVar) {
        }

        @Override // com.avito.android.photo_picker.edit.di.EditPhotoComponent.Builder
        public EditPhotoComponent build() {
            Preconditions.checkBuilderRequirement(this.a, EditPhotoDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Fragment.class);
            return new DaggerEditPhotoComponent(new EditPhotoModule(), this.a, this.b, null);
        }

        @Override // com.avito.android.photo_picker.edit.di.EditPhotoComponent.Builder
        public EditPhotoComponent.Builder dependencies(EditPhotoDependencies editPhotoDependencies) {
            this.a = (EditPhotoDependencies) Preconditions.checkNotNull(editPhotoDependencies);
            return this;
        }

        @Override // com.avito.android.photo_picker.edit.di.EditPhotoComponent.Builder
        public EditPhotoComponent.Builder withFragment(Fragment fragment) {
            this.b = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<Context> {
        public final EditPhotoDependencies a;

        public c(EditPhotoDependencies editPhotoDependencies) {
            this.a = editPhotoDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class d implements Provider<Gson> {
        public final EditPhotoDependencies a;

        public d(EditPhotoDependencies editPhotoDependencies) {
            this.a = editPhotoDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Gson get() {
            return (Gson) Preconditions.checkNotNullFromComponent(this.a.gson());
        }
    }

    public static class e implements Provider<PhotoPickerEventTracker> {
        public final EditPhotoDependencies a;

        public e(EditPhotoDependencies editPhotoDependencies) {
            this.a = editPhotoDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PhotoPickerEventTracker get() {
            return (PhotoPickerEventTracker) Preconditions.checkNotNullFromComponent(this.a.photoPickerEventTracker());
        }
    }

    public static class f implements Provider<PrivatePhotosStorage> {
        public final EditPhotoDependencies a;

        public f(EditPhotoDependencies editPhotoDependencies) {
            this.a = editPhotoDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PrivatePhotosStorage get() {
            return (PrivatePhotosStorage) Preconditions.checkNotNullFromComponent(this.a.privatePhotoStorage());
        }
    }

    public static class g implements Provider<SchedulersFactory3> {
        public final EditPhotoDependencies a;

        public g(EditPhotoDependencies editPhotoDependencies) {
            this.a = editPhotoDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class h implements Provider<SharedPhotosStorage> {
        public final EditPhotoDependencies a;

        public h(EditPhotoDependencies editPhotoDependencies) {
            this.a = editPhotoDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SharedPhotosStorage get() {
            return (SharedPhotosStorage) Preconditions.checkNotNullFromComponent(this.a.sharedPhotoStorage());
        }
    }

    public DaggerEditPhotoComponent(EditPhotoModule editPhotoModule, EditPhotoDependencies editPhotoDependencies, Fragment fragment, a aVar) {
        this.a = InstanceFactory.create(fragment);
        this.b = new h(editPhotoDependencies);
        this.c = new g(editPhotoDependencies);
        this.d = new e(editPhotoDependencies);
        this.e = new c(editPhotoDependencies);
        this.f = new f(editPhotoDependencies);
        d dVar = new d(editPhotoDependencies);
        this.g = dVar;
        ExifExtraDataSerializerImpl_Factory create = ExifExtraDataSerializerImpl_Factory.create(dVar);
        this.h = create;
        Provider<ExifExtraDataSerializer> provider = DoubleCheck.provider(create);
        this.i = provider;
        Provider<ExifProvider> provider2 = DoubleCheck.provider(EditPhotoModule_ProvideExifProviderFactory.create(editPhotoModule, this.e, this.f, provider));
        this.j = provider2;
        EditPhotoViewModelFactory_Factory create2 = EditPhotoViewModelFactory_Factory.create(this.b, this.c, this.d, provider2);
        this.k = create2;
        Provider<ViewModelProvider.Factory> provider3 = DoubleCheck.provider(create2);
        this.l = provider3;
        this.m = DoubleCheck.provider(EditPhotoModule_ProvideViewModelFactory.create(editPhotoModule, this.a, provider3));
    }

    public static EditPhotoComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.photo_picker.edit.di.EditPhotoComponent
    public void inject(EditPhotoFragment editPhotoFragment) {
        EditPhotoFragment_MembersInjector.injectViewModel(editPhotoFragment, this.m.get());
    }
}

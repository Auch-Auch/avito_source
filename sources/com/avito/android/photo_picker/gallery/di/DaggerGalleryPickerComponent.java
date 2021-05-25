package com.avito.android.photo_picker.gallery.di;

import android.content.ContentResolver;
import androidx.fragment.app.Fragment;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.permissions.FragmentPermissionHelper;
import com.avito.android.permissions.FragmentPermissionHelper_Factory;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.gallery.GalleryPickerFragment;
import com.avito.android.photo_picker.gallery.GalleryPickerFragment_MembersInjector;
import com.avito.android.photo_picker.gallery.GalleryPickerViewModelFactory;
import com.avito.android.photo_picker.gallery.data.GalleryPickerRepository;
import com.avito.android.photo_picker.gallery.data.GalleryPickerRepositoryImpl;
import com.avito.android.photo_picker.gallery.data.GalleryPickerRepositoryImpl_Factory;
import com.avito.android.photo_picker.gallery.di.GalleryPickerComponent;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryItemBluePrint;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryItemBluePrint_Factory;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryItemPresenter;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryItemPresenterImpl_Factory;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerGalleryPickerComponent implements GalleryPickerComponent {
    public final GalleryPickerDependencies a;
    public Provider<Fragment> b;
    public Provider<FragmentPermissionHelper> c;
    public Provider<PermissionHelper> d;
    public Provider<ContentResolver> e;
    public Provider<GalleryPickerRepositoryImpl> f;
    public Provider<GalleryPickerRepository> g;
    public Provider<GalleryItemPresenter> h;
    public Provider<GalleryItemBluePrint> i;
    public Provider<ItemBinder> j;
    public Provider<AdapterPresenter> k;
    public Provider<SimpleRecyclerAdapter> l;

    public static final class b implements GalleryPickerComponent.Builder {
        public GalleryPickerDependencies a;
        public Fragment b;
        public ContentResolver c;

        public b(a aVar) {
        }

        @Override // com.avito.android.photo_picker.gallery.di.GalleryPickerComponent.Builder
        public GalleryPickerComponent build() {
            Preconditions.checkBuilderRequirement(this.a, GalleryPickerDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Fragment.class);
            Preconditions.checkBuilderRequirement(this.c, ContentResolver.class);
            return new DaggerGalleryPickerComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.photo_picker.gallery.di.GalleryPickerComponent.Builder
        public GalleryPickerComponent.Builder contentResolver(ContentResolver contentResolver) {
            this.c = (ContentResolver) Preconditions.checkNotNull(contentResolver);
            return this;
        }

        @Override // com.avito.android.photo_picker.gallery.di.GalleryPickerComponent.Builder
        public GalleryPickerComponent.Builder dependencies(GalleryPickerDependencies galleryPickerDependencies) {
            this.a = (GalleryPickerDependencies) Preconditions.checkNotNull(galleryPickerDependencies);
            return this;
        }

        @Override // com.avito.android.photo_picker.gallery.di.GalleryPickerComponent.Builder
        public GalleryPickerComponent.Builder withFragment(Fragment fragment) {
            this.b = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public DaggerGalleryPickerComponent(GalleryPickerDependencies galleryPickerDependencies, Fragment fragment, ContentResolver contentResolver, a aVar) {
        this.a = galleryPickerDependencies;
        Factory create = InstanceFactory.create(fragment);
        this.b = create;
        FragmentPermissionHelper_Factory create2 = FragmentPermissionHelper_Factory.create(create);
        this.c = create2;
        this.d = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(contentResolver);
        this.e = create3;
        GalleryPickerRepositoryImpl_Factory create4 = GalleryPickerRepositoryImpl_Factory.create(create3);
        this.f = create4;
        this.g = DoubleCheck.provider(create4);
        Provider<GalleryItemPresenter> provider = DoubleCheck.provider(GalleryItemPresenterImpl_Factory.create());
        this.h = provider;
        GalleryItemBluePrint_Factory create5 = GalleryItemBluePrint_Factory.create(provider);
        this.i = create5;
        Provider<ItemBinder> provider2 = DoubleCheck.provider(GalleryPickerModule_ProvideItemBinderFactory.create(create5));
        this.j = provider2;
        Provider<AdapterPresenter> provider3 = DoubleCheck.provider(GalleryPickerModule_ProvidePhotoGridPresenterFactory.create(provider2));
        this.k = provider3;
        this.l = DoubleCheck.provider(GalleryPickerModule_ProvideAdapterFactory.create(provider3, this.j));
    }

    public static GalleryPickerComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.photo_picker.gallery.di.GalleryPickerComponent
    public void inject(GalleryPickerFragment galleryPickerFragment) {
        GalleryPickerFragment_MembersInjector.injectViewModelFactory(galleryPickerFragment, new GalleryPickerViewModelFactory(this.d.get(), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()), this.g.get(), this.h.get()));
        GalleryPickerFragment_MembersInjector.injectPhotoGridPresenter(galleryPickerFragment, this.k.get());
        GalleryPickerFragment_MembersInjector.injectAdapter(galleryPickerFragment, this.l.get());
        GalleryPickerFragment_MembersInjector.injectAnalytics(galleryPickerFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        GalleryPickerFragment_MembersInjector.injectFeatures(galleryPickerFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}

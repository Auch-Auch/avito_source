package com.avito.android.di.component;

import android.content.ContentResolver;
import com.avito.android.db.DbHelper;
import com.avito.android.di.component.PhotoContentProviderComponent;
import com.avito.android.di.module.PhotoContentProviderModule_ProvidePhotoContentProviderDelegate$photo_picker_releaseFactory;
import com.avito.android.photo_picker.legacy.di.PhotoContentProviderDependencies;
import com.avito.android.photo_picker.legacy.provider.PhotoContentProvider;
import com.avito.android.photo_picker.legacy.provider.PhotoContentProvider_MembersInjector;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ContentProviderDelegate;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerPhotoContentProviderComponent implements PhotoContentProviderComponent {
    public Provider<BuildInfo> a;
    public Provider<DbHelper> b;
    public Provider<ContentResolver> c;
    public Provider<ContentProviderDelegate> d;

    public static final class b implements PhotoContentProviderComponent.Builder {
        public PhotoContentProviderDependencies a;
        public ContentResolver b;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.PhotoContentProviderComponent.Builder
        public PhotoContentProviderComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PhotoContentProviderDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ContentResolver.class);
            return new DaggerPhotoContentProviderComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.di.component.PhotoContentProviderComponent.Builder
        public PhotoContentProviderComponent.Builder contentResolver(ContentResolver contentResolver) {
            this.b = (ContentResolver) Preconditions.checkNotNull(contentResolver);
            return this;
        }

        @Override // com.avito.android.di.component.PhotoContentProviderComponent.Builder
        public PhotoContentProviderComponent.Builder photoContentProviderDependencies(PhotoContentProviderDependencies photoContentProviderDependencies) {
            this.a = (PhotoContentProviderDependencies) Preconditions.checkNotNull(photoContentProviderDependencies);
            return this;
        }
    }

    public static class c implements Provider<BuildInfo> {
        public final PhotoContentProviderDependencies a;

        public c(PhotoContentProviderDependencies photoContentProviderDependencies) {
            this.a = photoContentProviderDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class d implements Provider<DbHelper> {
        public final PhotoContentProviderDependencies a;

        public d(PhotoContentProviderDependencies photoContentProviderDependencies) {
            this.a = photoContentProviderDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DbHelper get() {
            return (DbHelper) Preconditions.checkNotNullFromComponent(this.a.dbHelper());
        }
    }

    public DaggerPhotoContentProviderComponent(PhotoContentProviderDependencies photoContentProviderDependencies, ContentResolver contentResolver, a aVar) {
        this.a = new c(photoContentProviderDependencies);
        this.b = new d(photoContentProviderDependencies);
        Factory create = InstanceFactory.create(contentResolver);
        this.c = create;
        this.d = DoubleCheck.provider(PhotoContentProviderModule_ProvidePhotoContentProviderDelegate$photo_picker_releaseFactory.create(this.a, this.b, create));
    }

    public static PhotoContentProviderComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.PhotoContentProviderComponent
    public void inject(PhotoContentProvider photoContentProvider) {
        PhotoContentProvider_MembersInjector.injectDelegate(photoContentProvider, this.d.get());
    }
}

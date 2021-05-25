package com.avito.android.di.component;

import android.app.Application;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.component.ImageUploadServiceComponent;
import com.avito.android.di.module.ImageUploadServiceModule;
import com.avito.android.di.module.ImageUploadServiceModule_ProvideBitmapFileProviderFactory;
import com.avito.android.di.module.ImageUploadServiceModule_ProvideImageUploadServiceDelegateFactory;
import com.avito.android.di.module.ImageUploadServiceModule_ProvidePhotoInteractorFactory;
import com.avito.android.di.module.ImageUploadServiceModule_ProvideServiceCountdownHandlerFactory;
import com.avito.android.di.module.ImageUploadServiceModule_ProvideUploadInteractorsFactory;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl_Factory;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.api.UploadConverterProvider;
import com.avito.android.photo_picker.legacy.api.UploadConverterProviderImpl;
import com.avito.android.photo_picker.legacy.api.UploadConverterProviderImpl_Factory;
import com.avito.android.photo_picker.legacy.api.UploadInteractor;
import com.avito.android.photo_picker.legacy.api.UploadInteractorProvider;
import com.avito.android.photo_picker.legacy.api.UploadInteractorProviderImpl;
import com.avito.android.photo_picker.legacy.api.UploadInteractorProviderImpl_Factory;
import com.avito.android.photo_picker.legacy.remote.PickerApi;
import com.avito.android.photo_picker.legacy.service.ImageUploadService;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegate;
import com.avito.android.photo_picker.legacy.service.ImageUploadService_MembersInjector;
import com.avito.android.service.ServiceCountdownHandler;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerImageUploadServiceComponent implements ImageUploadServiceComponent {
    public Provider<Application> a;
    public Provider<BuildInfo> b;
    public Provider<PhotoInteractor> c;
    public Provider<PickerApi> d;
    public Provider<Messenger<AvitoMessengerApi>> e;
    public Provider<Map<String, UploadInteractor>> f;
    public Provider<UploadInteractorProviderImpl> g;
    public Provider<UploadInteractorProvider> h;
    public Provider<Analytics> i;
    public Provider<PrivatePhotosStorage> j;
    public Provider<BitmapFileProvider> k;
    public Provider<Gson> l;
    public Provider<ExifExtraDataSerializerImpl> m;
    public Provider<ExifExtraDataSerializer> n;
    public Provider<Features> o;
    public Provider<UploadConverterProviderImpl> p;
    public Provider<UploadConverterProvider> q;
    public Provider<SchedulersFactory> r;
    public Provider<ImageUploadServiceDelegate> s;
    public Provider<ServiceCountdownHandler> t = DoubleCheck.provider(ImageUploadServiceModule_ProvideServiceCountdownHandlerFactory.create());

    public static final class b implements ImageUploadServiceComponent.Builder {
        public ImageUploadServiceDependencies a;
        public Gson b;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.ImageUploadServiceComponent.Builder
        public ImageUploadServiceComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ImageUploadServiceDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Gson.class);
            return new DaggerImageUploadServiceComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.di.component.ImageUploadServiceComponent.Builder
        public ImageUploadServiceComponent.Builder dependencies(ImageUploadServiceDependencies imageUploadServiceDependencies) {
            this.a = (ImageUploadServiceDependencies) Preconditions.checkNotNull(imageUploadServiceDependencies);
            return this;
        }

        @Override // com.avito.android.di.component.ImageUploadServiceComponent.Builder
        @Deprecated
        public ImageUploadServiceComponent.Builder module(ImageUploadServiceModule imageUploadServiceModule) {
            Preconditions.checkNotNull(imageUploadServiceModule);
            return this;
        }

        @Override // com.avito.android.di.component.ImageUploadServiceComponent.Builder
        public ImageUploadServiceComponent.Builder withGson(Gson gson) {
            this.b = (Gson) Preconditions.checkNotNull(gson);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final ImageUploadServiceDependencies a;

        public c(ImageUploadServiceDependencies imageUploadServiceDependencies) {
            this.a = imageUploadServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Application> {
        public final ImageUploadServiceDependencies a;

        public d(ImageUploadServiceDependencies imageUploadServiceDependencies) {
            this.a = imageUploadServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class e implements Provider<BuildInfo> {
        public final ImageUploadServiceDependencies a;

        public e(ImageUploadServiceDependencies imageUploadServiceDependencies) {
            this.a = imageUploadServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class f implements Provider<Features> {
        public final ImageUploadServiceDependencies a;

        public f(ImageUploadServiceDependencies imageUploadServiceDependencies) {
            this.a = imageUploadServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<Messenger<AvitoMessengerApi>> {
        public final ImageUploadServiceDependencies a;

        public g(ImageUploadServiceDependencies imageUploadServiceDependencies) {
            this.a = imageUploadServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Messenger<AvitoMessengerApi> get() {
            return (Messenger) Preconditions.checkNotNullFromComponent(this.a.messenger());
        }
    }

    public static class h implements Provider<PickerApi> {
        public final ImageUploadServiceDependencies a;

        public h(ImageUploadServiceDependencies imageUploadServiceDependencies) {
            this.a = imageUploadServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PickerApi get() {
            return (PickerApi) Preconditions.checkNotNullFromComponent(this.a.pickerApi());
        }
    }

    public static class i implements Provider<PrivatePhotosStorage> {
        public final ImageUploadServiceDependencies a;

        public i(ImageUploadServiceDependencies imageUploadServiceDependencies) {
            this.a = imageUploadServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PrivatePhotosStorage get() {
            return (PrivatePhotosStorage) Preconditions.checkNotNullFromComponent(this.a.privatePhotosStorage());
        }
    }

    public static class j implements Provider<SchedulersFactory> {
        public final ImageUploadServiceDependencies a;

        public j(ImageUploadServiceDependencies imageUploadServiceDependencies) {
            this.a = imageUploadServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerImageUploadServiceComponent(ImageUploadServiceDependencies imageUploadServiceDependencies, Gson gson, a aVar) {
        d dVar = new d(imageUploadServiceDependencies);
        this.a = dVar;
        e eVar = new e(imageUploadServiceDependencies);
        this.b = eVar;
        this.c = DoubleCheck.provider(ImageUploadServiceModule_ProvidePhotoInteractorFactory.create(dVar, eVar));
        h hVar = new h(imageUploadServiceDependencies);
        this.d = hVar;
        g gVar = new g(imageUploadServiceDependencies);
        this.e = gVar;
        Provider<Map<String, UploadInteractor>> provider = DoubleCheck.provider(ImageUploadServiceModule_ProvideUploadInteractorsFactory.create(hVar, gVar));
        this.f = provider;
        UploadInteractorProviderImpl_Factory create = UploadInteractorProviderImpl_Factory.create(provider);
        this.g = create;
        this.h = DoubleCheck.provider(create);
        c cVar = new c(imageUploadServiceDependencies);
        this.i = cVar;
        i iVar = new i(imageUploadServiceDependencies);
        this.j = iVar;
        this.k = DoubleCheck.provider(ImageUploadServiceModule_ProvideBitmapFileProviderFactory.create(this.a, cVar, iVar));
        Factory create2 = InstanceFactory.create(gson);
        this.l = create2;
        ExifExtraDataSerializerImpl_Factory create3 = ExifExtraDataSerializerImpl_Factory.create(create2);
        this.m = create3;
        Provider<ExifExtraDataSerializer> provider2 = DoubleCheck.provider(create3);
        this.n = provider2;
        f fVar = new f(imageUploadServiceDependencies);
        this.o = fVar;
        UploadConverterProviderImpl_Factory create4 = UploadConverterProviderImpl_Factory.create(this.k, provider2, fVar);
        this.p = create4;
        Provider<UploadConverterProvider> provider3 = DoubleCheck.provider(create4);
        this.q = provider3;
        j jVar = new j(imageUploadServiceDependencies);
        this.r = jVar;
        this.s = DoubleCheck.provider(ImageUploadServiceModule_ProvideImageUploadServiceDelegateFactory.create(this.c, this.h, provider3, jVar));
    }

    public static ImageUploadServiceComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.ImageUploadServiceComponent
    public void inject(ImageUploadService imageUploadService) {
        ImageUploadService_MembersInjector.injectDelegate(imageUploadService, this.s.get());
        ImageUploadService_MembersInjector.injectCountdownHandler(imageUploadService, this.t.get());
    }
}

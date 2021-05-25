package com.avito.android.advert.notes.di;

import com.avito.android.advert.notes.EditAdvertNoteActivity;
import com.avito.android.advert.notes.EditAdvertNoteActivity_MembersInjector;
import com.avito.android.advert.notes.EditAdvertNoteInteractor;
import com.avito.android.advert.notes.EditAdvertNoteInteractorImpl;
import com.avito.android.advert.notes.EditAdvertNoteInteractorImpl_Factory;
import com.avito.android.advert.notes.EditAdvertNotePresenter;
import com.avito.android.advert.notes.EditAdvertNotePresenterImpl;
import com.avito.android.advert.notes.EditAdvertNotePresenterImpl_Factory;
import com.avito.android.advert.notes.di.AdvertDetailsNoteComponent;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerAdvertDetailsNoteComponent implements AdvertDetailsNoteComponent {
    public Provider<String> a;
    public Provider<String> b;
    public Provider<AdvertDetailsApi> c;
    public Provider<SchedulersFactory3> d;
    public Provider<TypedErrorThrowableConverter> e;
    public Provider<EditAdvertNoteInteractorImpl> f;
    public Provider<EditAdvertNoteInteractor> g;
    public Provider<FavoriteAdvertsInteractor> h;
    public Provider<Boolean> i;
    public Provider<Boolean> j;
    public Provider<EditAdvertNotePresenterImpl> k;
    public Provider<EditAdvertNotePresenter> l;

    public static final class b implements AdvertDetailsNoteComponent.Builder {
        public String a;
        public String b;
        public Boolean c;
        public Boolean d;
        public AdvertDetailsNoteDependencies e;

        public b(a aVar) {
        }

        @Override // com.avito.android.advert.notes.di.AdvertDetailsNoteComponent.Builder
        public AdvertDetailsNoteComponent.Builder advertDetailsNoteDependencies(AdvertDetailsNoteDependencies advertDetailsNoteDependencies) {
            this.e = (AdvertDetailsNoteDependencies) Preconditions.checkNotNull(advertDetailsNoteDependencies);
            return this;
        }

        @Override // com.avito.android.advert.notes.di.AdvertDetailsNoteComponent.Builder
        public AdvertDetailsNoteComponent build() {
            Preconditions.checkBuilderRequirement(this.a, String.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Boolean.class);
            Preconditions.checkBuilderRequirement(this.d, Boolean.class);
            Preconditions.checkBuilderRequirement(this.e, AdvertDetailsNoteDependencies.class);
            return new DaggerAdvertDetailsNoteComponent(this.e, this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.advert.notes.di.AdvertDetailsNoteComponent.Builder
        public AdvertDetailsNoteComponent.Builder withAdvertId(String str) {
            this.a = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.advert.notes.di.AdvertDetailsNoteComponent.Builder
        public AdvertDetailsNoteComponent.Builder withIsFavorite(boolean z) {
            this.d = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.advert.notes.di.AdvertDetailsNoteComponent.Builder
        public AdvertDetailsNoteComponent.Builder withIsRestored(boolean z) {
            this.c = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.advert.notes.di.AdvertDetailsNoteComponent.Builder
        public AdvertDetailsNoteComponent.Builder withNote(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public static class c implements Provider<AdvertDetailsApi> {
        public final AdvertDetailsNoteDependencies a;

        public c(AdvertDetailsNoteDependencies advertDetailsNoteDependencies) {
            this.a = advertDetailsNoteDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AdvertDetailsApi get() {
            return (AdvertDetailsApi) Preconditions.checkNotNullFromComponent(this.a.advertDetailsApi());
        }
    }

    public static class d implements Provider<FavoriteAdvertsInteractor> {
        public final AdvertDetailsNoteDependencies a;

        public d(AdvertDetailsNoteDependencies advertDetailsNoteDependencies) {
            this.a = advertDetailsNoteDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsInteractor get() {
            return (FavoriteAdvertsInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsInteractor());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final AdvertDetailsNoteDependencies a;

        public e(AdvertDetailsNoteDependencies advertDetailsNoteDependencies) {
            this.a = advertDetailsNoteDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class f implements Provider<TypedErrorThrowableConverter> {
        public final AdvertDetailsNoteDependencies a;

        public f(AdvertDetailsNoteDependencies advertDetailsNoteDependencies) {
            this.a = advertDetailsNoteDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerAdvertDetailsNoteComponent(AdvertDetailsNoteDependencies advertDetailsNoteDependencies, String str, String str2, Boolean bool, Boolean bool2, a aVar) {
        this.a = InstanceFactory.create(str);
        this.b = InstanceFactory.create(str2);
        c cVar = new c(advertDetailsNoteDependencies);
        this.c = cVar;
        e eVar = new e(advertDetailsNoteDependencies);
        this.d = eVar;
        f fVar = new f(advertDetailsNoteDependencies);
        this.e = fVar;
        EditAdvertNoteInteractorImpl_Factory create = EditAdvertNoteInteractorImpl_Factory.create(cVar, eVar, fVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        this.h = new d(advertDetailsNoteDependencies);
        this.i = InstanceFactory.create(bool);
        Factory create2 = InstanceFactory.create(bool2);
        this.j = create2;
        EditAdvertNotePresenterImpl_Factory create3 = EditAdvertNotePresenterImpl_Factory.create(this.a, this.b, this.g, this.d, this.h, this.i, create2);
        this.k = create3;
        this.l = DoubleCheck.provider(create3);
    }

    public static AdvertDetailsNoteComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.advert.notes.di.AdvertDetailsNoteComponent
    public void inject(EditAdvertNoteActivity editAdvertNoteActivity) {
        EditAdvertNoteActivity_MembersInjector.injectPresenter(editAdvertNoteActivity, this.l.get());
    }
}

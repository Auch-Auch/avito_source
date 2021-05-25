package com.avito.android.profile.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.account.SessionChangeTrackerImpl;
import com.avito.android.account.SessionChangeTrackerImpl_Factory;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo_picker.BitmapTransformer;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl_Factory;
import com.avito.android.photo_picker.legacy.api.UploadConverterProvider;
import com.avito.android.profile.di.EditProfileComponent;
import com.avito.android.profile.edit.CameraDelegate;
import com.avito.android.profile.edit.EditProfileActivity;
import com.avito.android.profile.edit.EditProfileActivity_MembersInjector;
import com.avito.android.profile.edit.EditProfileInteractor;
import com.avito.android.profile.edit.EditProfilePresenter;
import com.avito.android.profile.edit.EditProfileResourceProvider;
import com.avito.android.profile.edit.LocationInteractor;
import com.avito.android.profile.edit.LocationInteractorResourceProvider;
import com.avito.android.profile.edit.SaveProfileInteractor;
import com.avito.android.profile.edit.adapter.AvatarItemBlueprint;
import com.avito.android.profile.edit.adapter.ErrorLabelItemBlueprint;
import com.avito.android.profile.edit.adapter.InputItemBlueprint;
import com.avito.android.profile.edit.adapter.LocationItemBlueprint;
import com.avito.android.profile.edit.adapter.LocationItemPresenter;
import com.avito.android.profile.edit.adapter.PhoneInputItemBlueprint;
import com.avito.android.profile.edit.adapter.SubLocationItemBlueprint;
import com.avito.android.profile.edit.adapter.TextItemBlueprint;
import com.avito.android.profile.edit.avatar.AvatarInteractor;
import com.avito.android.profile.edit.refactoring.adapter.AvatarItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.ErrorLabelItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.InputItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.PhoneInputItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.SubLocationItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.TextItemPresenter;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.gson.Gson;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerEditProfileComponent implements EditProfileComponent {
    public Provider<AdapterPresenter> A;
    public Provider<AvatarItemPresenter> B;
    public Provider<AvatarItemBlueprint> C;
    public Provider<InputItemPresenter> D;
    public Provider<InputItemBlueprint> E;
    public Provider<LocationItemPresenter> F;
    public Provider<LocationItemBlueprint> G;
    public Provider<SubLocationItemPresenter> H;
    public Provider<SubLocationItemBlueprint> I;
    public Provider<PhoneInputItemPresenter> J;
    public Provider<PhoneInputItemBlueprint> K;
    public Provider<ErrorLabelItemPresenter> L;
    public Provider<ErrorLabelItemBlueprint> M;
    public Provider<TextItemPresenter> N;
    public Provider<TextItemBlueprint> O;
    public Provider<ItemBinder> P;
    public Provider<SimpleRecyclerAdapter> Q;
    public Provider<ListUpdateCallback> R;
    public Provider<AdapterPresenter> S;
    public Provider<ContentsComparator> T;
    public Provider<DiffCalculator> U;
    public Provider<ErrorFormatter> V;
    public Provider<Kundle> W;
    public Provider<EditProfilePresenter> X;
    public Provider<ActivityIntentFactory> Y;
    public Provider<RandomKeyProvider> Z;
    public final EditProfileDependencies a;
    public Provider<CameraDelegate> a0;
    public Provider<LocationApi> b;
    public Provider<ProfileApi> c;
    public Provider<SchedulersFactory> d;
    public Provider<Context> e;
    public Provider<LocationInteractorResourceProvider> f;
    public Provider<Kundle> g;
    public Provider<LocationInteractor> h;
    public Provider<Features> i;
    public Provider<Analytics> j;
    public Provider<SessionChangeTrackerImpl> k;
    public Provider<SessionChangeTracker> l;
    public Provider<AccountStorageInteractor> m;
    public Provider<SaveProfileInteractor> n;
    public Provider<Application> o;
    public Provider<PrivatePhotosStorage> p;
    public Provider<BitmapFileProvider> q;
    public Provider<Gson> r;
    public Provider<ExifExtraDataSerializerImpl> s;
    public Provider<ExifExtraDataSerializer> t;
    public Provider<UploadConverterProvider> u;
    public Provider<BitmapTransformer> v;
    public Provider<AvatarInteractor> w;
    public Provider<EditProfileResourceProvider> x = DoubleCheck.provider(EditProfileModule_ProvideEditProfileResourceProvider$profile_releaseFactory.create(this.e));
    public Provider<Kundle> y;
    public Provider<EditProfileInteractor> z;

    public static final class b implements EditProfileComponent.Builder {
        public EditProfileDependencies a;
        public Activity b;
        public Kundle c;
        public Kundle d;
        public Kundle e;
        public Gson f;

        public b(a aVar) {
        }

        @Override // com.avito.android.profile.di.EditProfileComponent.Builder
        public EditProfileComponent.Builder activity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.profile.di.EditProfileComponent.Builder
        public EditProfileComponent build() {
            Preconditions.checkBuilderRequirement(this.a, EditProfileDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.f, Gson.class);
            return new DaggerEditProfileComponent(this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.profile.di.EditProfileComponent.Builder
        public EditProfileComponent.Builder dependencies(EditProfileDependencies editProfileDependencies) {
            this.a = (EditProfileDependencies) Preconditions.checkNotNull(editProfileDependencies);
            return this;
        }

        @Override // com.avito.android.profile.di.EditProfileComponent.Builder
        public EditProfileComponent.Builder editProfileInteractorState(Kundle kundle) {
            this.e = kundle;
            return this;
        }

        @Override // com.avito.android.profile.di.EditProfileComponent.Builder
        public EditProfileComponent.Builder interactorState(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.profile.di.EditProfileComponent.Builder
        public EditProfileComponent.Builder presenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.profile.di.EditProfileComponent.Builder
        public EditProfileComponent.Builder withGson(Gson gson) {
            this.f = (Gson) Preconditions.checkNotNull(gson);
            return this;
        }
    }

    public static class c implements Provider<AccountStorageInteractor> {
        public final EditProfileDependencies a;

        public c(EditProfileDependencies editProfileDependencies) {
            this.a = editProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStorageInteractor get() {
            return (AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor());
        }
    }

    public static class d implements Provider<ActivityIntentFactory> {
        public final EditProfileDependencies a;

        public d(EditProfileDependencies editProfileDependencies) {
            this.a = editProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ActivityIntentFactory get() {
            return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
        }
    }

    public static class e implements Provider<Analytics> {
        public final EditProfileDependencies a;

        public e(EditProfileDependencies editProfileDependencies) {
            this.a = editProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class f implements Provider<Application> {
        public final EditProfileDependencies a;

        public f(EditProfileDependencies editProfileDependencies) {
            this.a = editProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class g implements Provider<Context> {
        public final EditProfileDependencies a;

        public g(EditProfileDependencies editProfileDependencies) {
            this.a = editProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class h implements Provider<Features> {
        public final EditProfileDependencies a;

        public h(EditProfileDependencies editProfileDependencies) {
            this.a = editProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class i implements Provider<LocationApi> {
        public final EditProfileDependencies a;

        public i(EditProfileDependencies editProfileDependencies) {
            this.a = editProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class j implements Provider<PrivatePhotosStorage> {
        public final EditProfileDependencies a;

        public j(EditProfileDependencies editProfileDependencies) {
            this.a = editProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PrivatePhotosStorage get() {
            return (PrivatePhotosStorage) Preconditions.checkNotNullFromComponent(this.a.privatePhotosStorage());
        }
    }

    public static class k implements Provider<ProfileApi> {
        public final EditProfileDependencies a;

        public k(EditProfileDependencies editProfileDependencies) {
            this.a = editProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class l implements Provider<RandomKeyProvider> {
        public final EditProfileDependencies a;

        public l(EditProfileDependencies editProfileDependencies) {
            this.a = editProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class m implements Provider<SchedulersFactory> {
        public final EditProfileDependencies a;

        public m(EditProfileDependencies editProfileDependencies) {
            this.a = editProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerEditProfileComponent(EditProfileDependencies editProfileDependencies, Activity activity, Kundle kundle, Kundle kundle2, Kundle kundle3, Gson gson, a aVar) {
        this.a = editProfileDependencies;
        this.b = new i(editProfileDependencies);
        this.c = new k(editProfileDependencies);
        this.d = new m(editProfileDependencies);
        g gVar = new g(editProfileDependencies);
        this.e = gVar;
        this.f = DoubleCheck.provider(EditProfileModule_ProvideLocationInteractorResourceProviderFactory.create(gVar));
        Factory createNullable = InstanceFactory.createNullable(kundle2);
        this.g = createNullable;
        this.h = DoubleCheck.provider(EditProfileModule_ProvideLocationInteractorFactory.create(this.b, this.c, this.d, this.f, createNullable));
        h hVar = new h(editProfileDependencies);
        this.i = hVar;
        e eVar = new e(editProfileDependencies);
        this.j = eVar;
        SessionChangeTrackerImpl_Factory create = SessionChangeTrackerImpl_Factory.create(hVar, eVar);
        this.k = create;
        Provider<SessionChangeTracker> provider = SingleCheck.provider(create);
        this.l = provider;
        c cVar = new c(editProfileDependencies);
        this.m = cVar;
        this.n = DoubleCheck.provider(EditProfileModule_ProvideSaveProfileInteractorFactory.create(this.c, this.h, provider, cVar, this.d));
        f fVar = new f(editProfileDependencies);
        this.o = fVar;
        j jVar = new j(editProfileDependencies);
        this.p = jVar;
        this.q = DoubleCheck.provider(EditProfileModule_ProvideBitmapFileProviderFactory.create(fVar, this.j, jVar));
        Factory create2 = InstanceFactory.create(gson);
        this.r = create2;
        ExifExtraDataSerializerImpl_Factory create3 = ExifExtraDataSerializerImpl_Factory.create(create2);
        this.s = create3;
        Provider<ExifExtraDataSerializer> provider2 = DoubleCheck.provider(EditProfileModule_ProvideExifExtraDataSerializerFactory.create(create3));
        this.t = provider2;
        this.u = DoubleCheck.provider(EditProfileModule_ProvideUploadConverterFactory.create(this.q, provider2, this.i));
        Provider<BitmapTransformer> provider3 = DoubleCheck.provider(EditProfileModule_ProvideBitmapTransformerFactory.create(this.o, this.p));
        this.v = provider3;
        this.w = DoubleCheck.provider(EditProfileModule_ProvideAvatarInteractorFactory.create(this.c, this.u, provider3, this.d));
        Factory createNullable2 = InstanceFactory.createNullable(kundle3);
        this.y = createNullable2;
        this.z = DoubleCheck.provider(EditProfileModule_ProvideInteractorFactory.create(this.h, this.d, this.n, this.w, this.x, createNullable2));
        this.A = new DelegateFactory();
        Provider<AvatarItemPresenter> provider4 = DoubleCheck.provider(EditProfileModule_ProvideAvatarItemPresenter$profile_releaseFactory.create());
        this.B = provider4;
        this.C = DoubleCheck.provider(EditProfileModule_ProvideAvatarItemBlueprint$profile_releaseFactory.create(provider4));
        Provider<InputItemPresenter> provider5 = DoubleCheck.provider(EditProfileModule_ProvideInputItemPresenter$profile_releaseFactory.create());
        this.D = provider5;
        this.E = DoubleCheck.provider(EditProfileModule_ProvideInputItemBlueprint$profile_releaseFactory.create(provider5));
        Provider<LocationItemPresenter> provider6 = DoubleCheck.provider(EditProfileModule_ProvideLocationItemPresenter$profile_releaseFactory.create());
        this.F = provider6;
        this.G = DoubleCheck.provider(EditProfileModule_ProvideLocationItemBlueprint$profile_releaseFactory.create(provider6));
        Provider<SubLocationItemPresenter> provider7 = DoubleCheck.provider(EditProfileModule_ProvideSubLocationItemPresenter$profile_releaseFactory.create());
        this.H = provider7;
        this.I = DoubleCheck.provider(EditProfileModule_ProvideSubLocationItemBlueprint$profile_releaseFactory.create(provider7));
        Provider<PhoneInputItemPresenter> provider8 = DoubleCheck.provider(EditProfileModule_ProvidePhoneInputItemPresenter$profile_releaseFactory.create());
        this.J = provider8;
        this.K = DoubleCheck.provider(EditProfileModule_ProvidePhoneInputItemBlueprint$profile_releaseFactory.create(provider8));
        Provider<ErrorLabelItemPresenter> provider9 = DoubleCheck.provider(EditProfileModule_ProvideErrorBlockItemPresenter$profile_releaseFactory.create());
        this.L = provider9;
        this.M = DoubleCheck.provider(EditProfileModule_ProvideErrorBlockItemBlueprint$profile_releaseFactory.create(provider9));
        Provider<TextItemPresenter> provider10 = DoubleCheck.provider(EditProfileModule_ProvideTextlockItemPresenter$profile_releaseFactory.create());
        this.N = provider10;
        Provider<TextItemBlueprint> provider11 = DoubleCheck.provider(EditProfileModule_ProvideTextItemBlueprint$profile_releaseFactory.create(provider10));
        this.O = provider11;
        Provider<ItemBinder> provider12 = DoubleCheck.provider(EditProfileModule_ProvideItemBinder$profile_releaseFactory.create(this.C, this.E, this.G, this.I, this.K, this.M, provider11));
        this.P = provider12;
        Provider<SimpleRecyclerAdapter> provider13 = DoubleCheck.provider(EditProfileModule_ProvideRecyclerAdapterFactory.create(this.A, provider12));
        this.Q = provider13;
        this.R = DoubleCheck.provider(EditProfileModule_ProvideListUpdateListenerFactory.create(provider13));
        this.S = DoubleCheck.provider(EditProfileModule_ProvideAdapterPresenterFactory.create(this.P));
        Provider<ContentsComparator> provider14 = DoubleCheck.provider(EditProfileModule_ProvideContentsComparatorFactory.create());
        this.T = provider14;
        Provider<DiffCalculator> provider15 = DoubleCheck.provider(EditProfileModule_ProvideDiffCalculatorFactory.create(provider14));
        this.U = provider15;
        DelegateFactory.setDelegate(this.A, DoubleCheck.provider(EditProfileModule_ProvideDataAwareAdapterFactory.create(this.R, this.S, provider15)));
        this.V = DoubleCheck.provider(EditProfileModule_ProvideErrorFormatter$profile_releaseFactory.create(this.e));
        Factory createNullable3 = InstanceFactory.createNullable(kundle);
        this.W = createNullable3;
        this.X = DoubleCheck.provider(EditProfileModule_ProvidePresenterFactory.create(this.z, this.j, this.A, this.d, this.V, createNullable3));
        d dVar = new d(editProfileDependencies);
        this.Y = dVar;
        l lVar = new l(editProfileDependencies);
        this.Z = lVar;
        this.a0 = DoubleCheck.provider(EditProfileModule_ProvideCameraDelegateFactory.create(dVar, lVar));
    }

    public static EditProfileComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.profile.di.EditProfileComponent
    public void inject(EditProfileActivity editProfileActivity) {
        EditProfileActivity_MembersInjector.injectEditProfilePresenter(editProfileActivity, this.X.get());
        EditProfileActivity_MembersInjector.injectEditProfileInteractor(editProfileActivity, this.z.get());
        EditProfileActivity_MembersInjector.injectActivityIntentFactory(editProfileActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        EditProfileActivity_MembersInjector.injectLocationInteractor(editProfileActivity, this.h.get());
        EditProfileActivity_MembersInjector.injectIntentFactory(editProfileActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        EditProfileActivity_MembersInjector.injectCameraDelegate(editProfileActivity, this.a0.get());
        EditProfileActivity_MembersInjector.injectRecyclerAdapter(editProfileActivity, this.Q.get());
        EditProfileActivity_MembersInjector.injectFeatures(editProfileActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        EditProfileActivity_MembersInjector.injectAnalytics(editProfileActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        EditProfileActivity_MembersInjector.injectImplicitIntentFactory(editProfileActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
    }
}

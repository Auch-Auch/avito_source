package com.avito.android.profile.edit;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class EditProfileActivity_MembersInjector implements MembersInjector<EditProfileActivity> {
    public final Provider<EditProfilePresenter> a;
    public final Provider<EditProfileInteractor> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<LocationInteractor> d;
    public final Provider<ActivityIntentFactory> e;
    public final Provider<CameraDelegate> f;
    public final Provider<SimpleRecyclerAdapter> g;
    public final Provider<Features> h;
    public final Provider<Analytics> i;
    public final Provider<ImplicitIntentFactory> j;

    public EditProfileActivity_MembersInjector(Provider<EditProfilePresenter> provider, Provider<EditProfileInteractor> provider2, Provider<ActivityIntentFactory> provider3, Provider<LocationInteractor> provider4, Provider<ActivityIntentFactory> provider5, Provider<CameraDelegate> provider6, Provider<SimpleRecyclerAdapter> provider7, Provider<Features> provider8, Provider<Analytics> provider9, Provider<ImplicitIntentFactory> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static MembersInjector<EditProfileActivity> create(Provider<EditProfilePresenter> provider, Provider<EditProfileInteractor> provider2, Provider<ActivityIntentFactory> provider3, Provider<LocationInteractor> provider4, Provider<ActivityIntentFactory> provider5, Provider<CameraDelegate> provider6, Provider<SimpleRecyclerAdapter> provider7, Provider<Features> provider8, Provider<Analytics> provider9, Provider<ImplicitIntentFactory> provider10) {
        return new EditProfileActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @InjectedFieldSignature("com.avito.android.profile.edit.EditProfileActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(EditProfileActivity editProfileActivity, ActivityIntentFactory activityIntentFactory) {
        editProfileActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.edit.EditProfileActivity.analytics")
    public static void injectAnalytics(EditProfileActivity editProfileActivity, Analytics analytics) {
        editProfileActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.profile.edit.EditProfileActivity.cameraDelegate")
    public static void injectCameraDelegate(EditProfileActivity editProfileActivity, CameraDelegate cameraDelegate) {
        editProfileActivity.cameraDelegate = cameraDelegate;
    }

    @InjectedFieldSignature("com.avito.android.profile.edit.EditProfileActivity.editProfileInteractor")
    public static void injectEditProfileInteractor(EditProfileActivity editProfileActivity, EditProfileInteractor editProfileInteractor) {
        editProfileActivity.editProfileInteractor = editProfileInteractor;
    }

    @InjectedFieldSignature("com.avito.android.profile.edit.EditProfileActivity.editProfilePresenter")
    public static void injectEditProfilePresenter(EditProfileActivity editProfileActivity, EditProfilePresenter editProfilePresenter) {
        editProfileActivity.editProfilePresenter = editProfilePresenter;
    }

    @InjectedFieldSignature("com.avito.android.profile.edit.EditProfileActivity.features")
    public static void injectFeatures(EditProfileActivity editProfileActivity, Features features) {
        editProfileActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.profile.edit.EditProfileActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(EditProfileActivity editProfileActivity, ImplicitIntentFactory implicitIntentFactory) {
        editProfileActivity.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.edit.EditProfileActivity.intentFactory")
    public static void injectIntentFactory(EditProfileActivity editProfileActivity, ActivityIntentFactory activityIntentFactory) {
        editProfileActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.edit.EditProfileActivity.locationInteractor")
    public static void injectLocationInteractor(EditProfileActivity editProfileActivity, LocationInteractor locationInteractor) {
        editProfileActivity.locationInteractor = locationInteractor;
    }

    @InjectedFieldSignature("com.avito.android.profile.edit.EditProfileActivity.recyclerAdapter")
    public static void injectRecyclerAdapter(EditProfileActivity editProfileActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        editProfileActivity.recyclerAdapter = simpleRecyclerAdapter;
    }

    public void injectMembers(EditProfileActivity editProfileActivity) {
        injectEditProfilePresenter(editProfileActivity, this.a.get());
        injectEditProfileInteractor(editProfileActivity, this.b.get());
        injectActivityIntentFactory(editProfileActivity, this.c.get());
        injectLocationInteractor(editProfileActivity, this.d.get());
        injectIntentFactory(editProfileActivity, this.e.get());
        injectCameraDelegate(editProfileActivity, this.f.get());
        injectRecyclerAdapter(editProfileActivity, this.g.get());
        injectFeatures(editProfileActivity, this.h.get());
        injectAnalytics(editProfileActivity, this.i.get());
        injectImplicitIntentFactory(editProfileActivity, this.j.get());
    }
}

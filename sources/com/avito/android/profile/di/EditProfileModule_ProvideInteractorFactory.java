package com.avito.android.profile.di;

import com.avito.android.profile.edit.EditProfileInteractor;
import com.avito.android.profile.edit.EditProfileResourceProvider;
import com.avito.android.profile.edit.LocationInteractor;
import com.avito.android.profile.edit.SaveProfileInteractor;
import com.avito.android.profile.edit.avatar.AvatarInteractor;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideInteractorFactory implements Factory<EditProfileInteractor> {
    public final Provider<LocationInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<SaveProfileInteractor> c;
    public final Provider<AvatarInteractor> d;
    public final Provider<EditProfileResourceProvider> e;
    public final Provider<Kundle> f;

    public EditProfileModule_ProvideInteractorFactory(Provider<LocationInteractor> provider, Provider<SchedulersFactory> provider2, Provider<SaveProfileInteractor> provider3, Provider<AvatarInteractor> provider4, Provider<EditProfileResourceProvider> provider5, Provider<Kundle> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static EditProfileModule_ProvideInteractorFactory create(Provider<LocationInteractor> provider, Provider<SchedulersFactory> provider2, Provider<SaveProfileInteractor> provider3, Provider<AvatarInteractor> provider4, Provider<EditProfileResourceProvider> provider5, Provider<Kundle> provider6) {
        return new EditProfileModule_ProvideInteractorFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static EditProfileInteractor provideInteractor(LocationInteractor locationInteractor, SchedulersFactory schedulersFactory, SaveProfileInteractor saveProfileInteractor, AvatarInteractor avatarInteractor, EditProfileResourceProvider editProfileResourceProvider, Kundle kundle) {
        return (EditProfileInteractor) Preconditions.checkNotNullFromProvides(EditProfileModule.provideInteractor(locationInteractor, schedulersFactory, saveProfileInteractor, avatarInteractor, editProfileResourceProvider, kundle));
    }

    @Override // javax.inject.Provider
    public EditProfileInteractor get() {
        return provideInteractor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}

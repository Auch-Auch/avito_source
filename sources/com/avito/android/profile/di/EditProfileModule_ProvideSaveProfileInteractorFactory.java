package com.avito.android.profile.di;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.profile.edit.LocationInteractor;
import com.avito.android.profile.edit.SaveProfileInteractor;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideSaveProfileInteractorFactory implements Factory<SaveProfileInteractor> {
    public final Provider<ProfileApi> a;
    public final Provider<LocationInteractor> b;
    public final Provider<SessionChangeTracker> c;
    public final Provider<AccountStorageInteractor> d;
    public final Provider<SchedulersFactory> e;

    public EditProfileModule_ProvideSaveProfileInteractorFactory(Provider<ProfileApi> provider, Provider<LocationInteractor> provider2, Provider<SessionChangeTracker> provider3, Provider<AccountStorageInteractor> provider4, Provider<SchedulersFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static EditProfileModule_ProvideSaveProfileInteractorFactory create(Provider<ProfileApi> provider, Provider<LocationInteractor> provider2, Provider<SessionChangeTracker> provider3, Provider<AccountStorageInteractor> provider4, Provider<SchedulersFactory> provider5) {
        return new EditProfileModule_ProvideSaveProfileInteractorFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static SaveProfileInteractor provideSaveProfileInteractor(ProfileApi profileApi, LocationInteractor locationInteractor, SessionChangeTracker sessionChangeTracker, AccountStorageInteractor accountStorageInteractor, SchedulersFactory schedulersFactory) {
        return (SaveProfileInteractor) Preconditions.checkNotNullFromProvides(EditProfileModule.provideSaveProfileInteractor(profileApi, locationInteractor, sessionChangeTracker, accountStorageInteractor, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public SaveProfileInteractor get() {
        return provideSaveProfileInteractor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}

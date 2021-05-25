package com.avito.android.profile.di;

import com.avito.android.photo_picker.BitmapTransformer;
import com.avito.android.photo_picker.legacy.api.UploadConverterProvider;
import com.avito.android.profile.edit.avatar.AvatarInteractor;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideAvatarInteractorFactory implements Factory<AvatarInteractor> {
    public final Provider<ProfileApi> a;
    public final Provider<UploadConverterProvider> b;
    public final Provider<BitmapTransformer> c;
    public final Provider<SchedulersFactory> d;

    public EditProfileModule_ProvideAvatarInteractorFactory(Provider<ProfileApi> provider, Provider<UploadConverterProvider> provider2, Provider<BitmapTransformer> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static EditProfileModule_ProvideAvatarInteractorFactory create(Provider<ProfileApi> provider, Provider<UploadConverterProvider> provider2, Provider<BitmapTransformer> provider3, Provider<SchedulersFactory> provider4) {
        return new EditProfileModule_ProvideAvatarInteractorFactory(provider, provider2, provider3, provider4);
    }

    public static AvatarInteractor provideAvatarInteractor(ProfileApi profileApi, UploadConverterProvider uploadConverterProvider, BitmapTransformer bitmapTransformer, SchedulersFactory schedulersFactory) {
        return (AvatarInteractor) Preconditions.checkNotNullFromProvides(EditProfileModule.provideAvatarInteractor(profileApi, uploadConverterProvider, bitmapTransformer, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public AvatarInteractor get() {
        return provideAvatarInteractor(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}

package com.avito.android.profile.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.profile.edit.CameraDelegate;
import com.avito.android.util.RandomKeyProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideCameraDelegateFactory implements Factory<CameraDelegate> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<RandomKeyProvider> b;

    public EditProfileModule_ProvideCameraDelegateFactory(Provider<ActivityIntentFactory> provider, Provider<RandomKeyProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static EditProfileModule_ProvideCameraDelegateFactory create(Provider<ActivityIntentFactory> provider, Provider<RandomKeyProvider> provider2) {
        return new EditProfileModule_ProvideCameraDelegateFactory(provider, provider2);
    }

    public static CameraDelegate provideCameraDelegate(ActivityIntentFactory activityIntentFactory, RandomKeyProvider randomKeyProvider) {
        return (CameraDelegate) Preconditions.checkNotNullFromProvides(EditProfileModule.provideCameraDelegate(activityIntentFactory, randomKeyProvider));
    }

    @Override // javax.inject.Provider
    public CameraDelegate get() {
        return provideCameraDelegate(this.a.get(), this.b.get());
    }
}

package com.avito.android.messenger.di;

import android.app.Application;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvidePhotoInteractorFactory implements Factory<PhotoInteractor> {
    public final ChannelFragmentModule a;
    public final Provider<BuildInfo> b;
    public final Provider<Application> c;

    public ChannelFragmentModule_ProvidePhotoInteractorFactory(ChannelFragmentModule channelFragmentModule, Provider<BuildInfo> provider, Provider<Application> provider2) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ChannelFragmentModule_ProvidePhotoInteractorFactory create(ChannelFragmentModule channelFragmentModule, Provider<BuildInfo> provider, Provider<Application> provider2) {
        return new ChannelFragmentModule_ProvidePhotoInteractorFactory(channelFragmentModule, provider, provider2);
    }

    public static PhotoInteractor providePhotoInteractor(ChannelFragmentModule channelFragmentModule, BuildInfo buildInfo, Application application) {
        return (PhotoInteractor) Preconditions.checkNotNullFromProvides(channelFragmentModule.providePhotoInteractor(buildInfo, application));
    }

    @Override // javax.inject.Provider
    public PhotoInteractor get() {
        return providePhotoInteractor(this.a, this.b.get(), this.c.get());
    }
}

package com.avito.android.publish.details.di;

import com.avito.android.component.profile_snippet.AvatarRenderer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishDetailsModule_ProvideAvatarRendererFactory implements Factory<AvatarRenderer> {
    public final PublishDetailsModule a;

    public PublishDetailsModule_ProvideAvatarRendererFactory(PublishDetailsModule publishDetailsModule) {
        this.a = publishDetailsModule;
    }

    public static PublishDetailsModule_ProvideAvatarRendererFactory create(PublishDetailsModule publishDetailsModule) {
        return new PublishDetailsModule_ProvideAvatarRendererFactory(publishDetailsModule);
    }

    public static AvatarRenderer provideAvatarRenderer(PublishDetailsModule publishDetailsModule) {
        return (AvatarRenderer) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideAvatarRenderer());
    }

    @Override // javax.inject.Provider
    public AvatarRenderer get() {
        return provideAvatarRenderer(this.a);
    }
}

package com.avito.android.publish.drafts.di;

import com.avito.android.photo_picker.legacy.DraftIdProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishDraftsModule_ProvideDraftIdProviderFactory implements Factory<DraftIdProvider> {

    public static final class a {
        public static final PublishDraftsModule_ProvideDraftIdProviderFactory a = new PublishDraftsModule_ProvideDraftIdProviderFactory();
    }

    public static PublishDraftsModule_ProvideDraftIdProviderFactory create() {
        return a.a;
    }

    public static DraftIdProvider provideDraftIdProvider() {
        return (DraftIdProvider) Preconditions.checkNotNullFromProvides(PublishDraftsModule.provideDraftIdProvider());
    }

    @Override // javax.inject.Provider
    public DraftIdProvider get() {
        return provideDraftIdProvider();
    }
}

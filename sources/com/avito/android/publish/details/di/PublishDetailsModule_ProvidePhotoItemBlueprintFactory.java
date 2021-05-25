package com.avito.android.publish.details.di;

import com.avito.android.photo_view.blueprints.MultiStatePhotoItemBlueprint;
import com.avito.android.photo_view.blueprints.MultiStatePhotoItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvidePhotoItemBlueprintFactory implements Factory<MultiStatePhotoItemBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<MultiStatePhotoItemPresenter> b;

    public PublishDetailsModule_ProvidePhotoItemBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<MultiStatePhotoItemPresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvidePhotoItemBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<MultiStatePhotoItemPresenter> provider) {
        return new PublishDetailsModule_ProvidePhotoItemBlueprintFactory(publishDetailsModule, provider);
    }

    public static MultiStatePhotoItemBlueprint providePhotoItemBlueprint(PublishDetailsModule publishDetailsModule, MultiStatePhotoItemPresenter multiStatePhotoItemPresenter) {
        return (MultiStatePhotoItemBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.providePhotoItemBlueprint(multiStatePhotoItemPresenter));
    }

    @Override // javax.inject.Provider
    public MultiStatePhotoItemBlueprint get() {
        return providePhotoItemBlueprint(this.a, this.b.get());
    }
}

package com.avito.android.publish.details.di;

import com.avito.android.publish.details.adapter.edit_category.EditCategoryItemBlueprint;
import com.avito.android.publish.details.adapter.edit_category.EditCategoryItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideEditCategoryItemBlueprintFactory implements Factory<EditCategoryItemBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<EditCategoryItemPresenter> b;

    public PublishDetailsModule_ProvideEditCategoryItemBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<EditCategoryItemPresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideEditCategoryItemBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<EditCategoryItemPresenter> provider) {
        return new PublishDetailsModule_ProvideEditCategoryItemBlueprintFactory(publishDetailsModule, provider);
    }

    public static EditCategoryItemBlueprint provideEditCategoryItemBlueprint(PublishDetailsModule publishDetailsModule, EditCategoryItemPresenter editCategoryItemPresenter) {
        return (EditCategoryItemBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideEditCategoryItemBlueprint(editCategoryItemPresenter));
    }

    @Override // javax.inject.Provider
    public EditCategoryItemBlueprint get() {
        return provideEditCategoryItemBlueprint(this.a, this.b.get());
    }
}

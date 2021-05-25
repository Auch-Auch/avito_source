package com.avito.android.validation;

import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemBlueprint;
import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemPresenter;
import com.avito.android.ui.widget.tagged_input.analytics.TagSelectionTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideMultiStateInputWithTagsItemBlueprintFactory implements Factory<MultiStateInputWithTagsItemBlueprint> {
    public final ParametersListModule a;
    public final Provider<MultiStateInputWithTagsItemPresenter> b;
    public final Provider<TagSelectionTracker> c;

    public ParametersListModule_ProvideMultiStateInputWithTagsItemBlueprintFactory(ParametersListModule parametersListModule, Provider<MultiStateInputWithTagsItemPresenter> provider, Provider<TagSelectionTracker> provider2) {
        this.a = parametersListModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ParametersListModule_ProvideMultiStateInputWithTagsItemBlueprintFactory create(ParametersListModule parametersListModule, Provider<MultiStateInputWithTagsItemPresenter> provider, Provider<TagSelectionTracker> provider2) {
        return new ParametersListModule_ProvideMultiStateInputWithTagsItemBlueprintFactory(parametersListModule, provider, provider2);
    }

    public static MultiStateInputWithTagsItemBlueprint provideMultiStateInputWithTagsItemBlueprint(ParametersListModule parametersListModule, MultiStateInputWithTagsItemPresenter multiStateInputWithTagsItemPresenter, TagSelectionTracker tagSelectionTracker) {
        return (MultiStateInputWithTagsItemBlueprint) Preconditions.checkNotNullFromProvides(parametersListModule.provideMultiStateInputWithTagsItemBlueprint(multiStateInputWithTagsItemPresenter, tagSelectionTracker));
    }

    @Override // javax.inject.Provider
    public MultiStateInputWithTagsItemBlueprint get() {
        return provideMultiStateInputWithTagsItemBlueprint(this.a, this.b.get(), this.c.get());
    }
}

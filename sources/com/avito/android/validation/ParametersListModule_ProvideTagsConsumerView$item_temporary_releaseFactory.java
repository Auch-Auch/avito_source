package com.avito.android.validation;

import com.avito.android.ui.widget.tagged_input.TagsConsumerView;
import com.avito.android.ui.widget.tagged_input.analytics.TagSelectionTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideTagsConsumerView$item_temporary_releaseFactory implements Factory<TagsConsumerView> {
    public final ParametersListModule a;
    public final Provider<TagSelectionTracker> b;

    public ParametersListModule_ProvideTagsConsumerView$item_temporary_releaseFactory(ParametersListModule parametersListModule, Provider<TagSelectionTracker> provider) {
        this.a = parametersListModule;
        this.b = provider;
    }

    public static ParametersListModule_ProvideTagsConsumerView$item_temporary_releaseFactory create(ParametersListModule parametersListModule, Provider<TagSelectionTracker> provider) {
        return new ParametersListModule_ProvideTagsConsumerView$item_temporary_releaseFactory(parametersListModule, provider);
    }

    public static TagsConsumerView provideTagsConsumerView$item_temporary_release(ParametersListModule parametersListModule, TagSelectionTracker tagSelectionTracker) {
        return (TagsConsumerView) Preconditions.checkNotNullFromProvides(parametersListModule.provideTagsConsumerView$item_temporary_release(tagSelectionTracker));
    }

    @Override // javax.inject.Provider
    public TagsConsumerView get() {
        return provideTagsConsumerView$item_temporary_release(this.a, this.b.get());
    }
}

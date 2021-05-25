package com.avito.android.publish.drafts.di;

import com.avito.android.photo_picker.legacy.DraftIdProvider;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDraftActivityModule_ProvideSubcategoryTitleHolderForDraftFactory implements Factory<PublishDraftDataHolder> {
    public final PublishDraftActivityModule a;
    public final Provider<DraftIdProvider> b;

    public PublishDraftActivityModule_ProvideSubcategoryTitleHolderForDraftFactory(PublishDraftActivityModule publishDraftActivityModule, Provider<DraftIdProvider> provider) {
        this.a = publishDraftActivityModule;
        this.b = provider;
    }

    public static PublishDraftActivityModule_ProvideSubcategoryTitleHolderForDraftFactory create(PublishDraftActivityModule publishDraftActivityModule, Provider<DraftIdProvider> provider) {
        return new PublishDraftActivityModule_ProvideSubcategoryTitleHolderForDraftFactory(publishDraftActivityModule, provider);
    }

    public static PublishDraftDataHolder provideSubcategoryTitleHolderForDraft(PublishDraftActivityModule publishDraftActivityModule, DraftIdProvider draftIdProvider) {
        return (PublishDraftDataHolder) Preconditions.checkNotNullFromProvides(publishDraftActivityModule.provideSubcategoryTitleHolderForDraft(draftIdProvider));
    }

    @Override // javax.inject.Provider
    public PublishDraftDataHolder get() {
        return provideSubcategoryTitleHolderForDraft(this.a, this.b.get());
    }
}

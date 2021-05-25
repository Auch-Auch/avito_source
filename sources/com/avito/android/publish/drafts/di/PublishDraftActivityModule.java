package com.avito.android.publish.drafts.di;

import com.avito.android.di.PerActivity;
import com.avito.android.photo_picker.legacy.DraftIdProvider;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import com.avito.android.publish.drafts.PublishDraftDataHolderImpl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/publish/drafts/di/PublishDraftActivityModule;", "", "Lcom/avito/android/photo_picker/legacy/DraftIdProvider;", "draftIdProvider", "Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "provideSubcategoryTitleHolderForDraft", "(Lcom/avito/android/photo_picker/legacy/DraftIdProvider;)Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "<init>", "()V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PublishDraftActivityModule {
    @Provides
    @PerActivity
    @NotNull
    public final PublishDraftDataHolder provideSubcategoryTitleHolderForDraft(@NotNull DraftIdProvider draftIdProvider) {
        Intrinsics.checkNotNullParameter(draftIdProvider, "draftIdProvider");
        return new PublishDraftDataHolderImpl(draftIdProvider);
    }
}

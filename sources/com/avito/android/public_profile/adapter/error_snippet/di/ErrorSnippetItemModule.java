package com.avito.android.public_profile.adapter.error_snippet.di;

import com.avito.android.di.PerFragment;
import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItem;
import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItemBlueprint;
import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItemPresenter;
import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItemPresenterImpl;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/public_profile/adapter/error_snippet/di/ErrorSnippetItemModule;", "", "Lcom/avito/android/public_profile/adapter/error_snippet/ErrorSnippetItemPresenter;", "presenter", "Lcom/avito/android/public_profile/adapter/error_snippet/ErrorSnippetItemBlueprint;", "provideBlueprint$public_profile_release", "(Lcom/avito/android/public_profile/adapter/error_snippet/ErrorSnippetItemPresenter;)Lcom/avito/android/public_profile/adapter/error_snippet/ErrorSnippetItemBlueprint;", "provideBlueprint", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/public_profile/adapter/error_snippet/ErrorSnippetItem;", "clicksRelay", "providePresenter$public_profile_release", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/public_profile/adapter/error_snippet/ErrorSnippetItemPresenter;", "providePresenter", "provideItemClicksStream$public_profile_release", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "provideItemClicksStream", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ErrorSnippetItemModule {
    @Provides
    @PerFragment
    @NotNull
    public final ErrorSnippetItemBlueprint provideBlueprint$public_profile_release(@NotNull ErrorSnippetItemPresenter errorSnippetItemPresenter) {
        Intrinsics.checkNotNullParameter(errorSnippetItemPresenter, "presenter");
        return new ErrorSnippetItemBlueprint(errorSnippetItemPresenter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final PublishRelay<ErrorSnippetItem> provideItemClicksStream$public_profile_release() {
        PublishRelay<ErrorSnippetItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<ErrorSnippetItem>()");
        return create;
    }

    @Provides
    @NotNull
    @PerFragment
    public final ErrorSnippetItemPresenter providePresenter$public_profile_release(@NotNull PublishRelay<ErrorSnippetItem> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "clicksRelay");
        return new ErrorSnippetItemPresenterImpl(publishRelay);
    }
}

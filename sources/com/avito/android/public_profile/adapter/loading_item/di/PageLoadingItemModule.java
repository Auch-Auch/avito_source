package com.avito.android.public_profile.adapter.loading_item.di;

import com.avito.android.di.PerFragment;
import com.avito.android.public_profile.adapter.loading_item.PageLoadingItemBlueprint;
import com.avito.android.public_profile.adapter.loading_item.PageLoadingItemPresenter;
import com.avito.android.public_profile.adapter.loading_item.PageLoadingItemPresenterImpl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/public_profile/adapter/loading_item/di/PageLoadingItemModule;", "", "Lcom/avito/android/public_profile/adapter/loading_item/PageLoadingItemPresenter;", "presenter", "Lcom/avito/android/public_profile/adapter/loading_item/PageLoadingItemBlueprint;", "provideBlueprint$public_profile_release", "(Lcom/avito/android/public_profile/adapter/loading_item/PageLoadingItemPresenter;)Lcom/avito/android/public_profile/adapter/loading_item/PageLoadingItemBlueprint;", "provideBlueprint", "providePresenter$public_profile_release", "()Lcom/avito/android/public_profile/adapter/loading_item/PageLoadingItemPresenter;", "providePresenter", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PageLoadingItemModule {
    @Provides
    @PerFragment
    @NotNull
    public final PageLoadingItemBlueprint provideBlueprint$public_profile_release(@NotNull PageLoadingItemPresenter pageLoadingItemPresenter) {
        Intrinsics.checkNotNullParameter(pageLoadingItemPresenter, "presenter");
        return new PageLoadingItemBlueprint(pageLoadingItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PageLoadingItemPresenter providePresenter$public_profile_release() {
        return new PageLoadingItemPresenterImpl();
    }
}

package com.avito.android.public_profile.adapter.placeholder.di;

import com.avito.android.di.PerFragment;
import com.avito.android.public_profile.adapter.placeholder.PlaceholderItemBlueprint;
import com.avito.android.public_profile.adapter.placeholder.PlaceholderItemPresenter;
import com.avito.android.public_profile.adapter.placeholder.PlaceholderItemPresenterImpl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/public_profile/adapter/placeholder/di/PlaceholderItemModule;", "", "Lcom/avito/android/public_profile/adapter/placeholder/PlaceholderItemPresenter;", "advertItemPresenter", "Lcom/avito/android/public_profile/adapter/placeholder/PlaceholderItemBlueprint;", "provideBlueprint$public_profile_release", "(Lcom/avito/android/public_profile/adapter/placeholder/PlaceholderItemPresenter;)Lcom/avito/android/public_profile/adapter/placeholder/PlaceholderItemBlueprint;", "provideBlueprint", "providePresenter$public_profile_release", "()Lcom/avito/android/public_profile/adapter/placeholder/PlaceholderItemPresenter;", "providePresenter", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PlaceholderItemModule {
    @Provides
    @PerFragment
    @NotNull
    public final PlaceholderItemBlueprint provideBlueprint$public_profile_release(@NotNull PlaceholderItemPresenter placeholderItemPresenter) {
        Intrinsics.checkNotNullParameter(placeholderItemPresenter, "advertItemPresenter");
        return new PlaceholderItemBlueprint(placeholderItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PlaceholderItemPresenter providePresenter$public_profile_release() {
        return new PlaceholderItemPresenterImpl();
    }
}

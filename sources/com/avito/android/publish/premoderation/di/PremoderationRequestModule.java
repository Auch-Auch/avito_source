package com.avito.android.publish.premoderation.di;

import com.avito.android.Features;
import com.avito.android.di.PerFragment;
import com.avito.android.progress_overlay.LoadingProgressOverlayModule;
import com.avito.android.publish.premoderation.AdvertProactiveModerationInteractor;
import com.avito.android.publish.premoderation.PremoderationRequestViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/premoderation/di/PremoderationRequestModule;", "", "Lcom/avito/android/publish/premoderation/AdvertProactiveModerationInteractor;", "interactor", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/publish/premoderation/PremoderationRequestViewModelFactory;", "providePremoderationRequestViewModelFactory", "(Lcom/avito/android/publish/premoderation/AdvertProactiveModerationInteractor;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/publish/premoderation/PremoderationRequestViewModelFactory;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdvertProactiveModerationModule.class, LoadingProgressOverlayModule.class})
public final class PremoderationRequestModule {
    @Provides
    @PerFragment
    @NotNull
    public final PremoderationRequestViewModelFactory providePremoderationRequestViewModelFactory(@NotNull AdvertProactiveModerationInteractor advertProactiveModerationInteractor, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(advertProactiveModerationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new PremoderationRequestViewModelFactory(advertProactiveModerationInteractor, features, schedulersFactory);
    }
}

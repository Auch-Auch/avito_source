package com.avito.android.advert_core.di.module;

import com.avito.android.advert_core.teaser.TeaserObserver;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert_core/di/module/GalleryTeaserModule;", "", "Lcom/avito/android/advert_core/teaser/TeaserObserver;", "provideTeaserObserver", "()Lcom/avito/android/advert_core/teaser/TeaserObserver;", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class GalleryTeaserModule {
    @Provides
    @Reusable
    @NotNull
    public final TeaserObserver provideTeaserObserver() {
        return new TeaserObserver();
    }
}

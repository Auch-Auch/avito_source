package com.avito.android.serp.adapter.skeleton.di;

import com.avito.android.di.PerFragment;
import com.avito.android.serp.adapter.skeleton.AdvertItemGridSkeletonBlueprint;
import com.avito.android.serp.adapter.skeleton.SkeletonGenerator;
import com.avito.android.serp.adapter.skeleton.SkeletonPresenter;
import com.avito.android.serp.adapter.skeleton.SkeletonPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/serp/adapter/skeleton/di/SerpSkeletonModule;", "", "Lcom/avito/android/serp/adapter/skeleton/SkeletonPresenterImpl;", "presenter", "Lcom/avito/android/serp/adapter/skeleton/SkeletonPresenter;", "bindSkeletonPresenter", "(Lcom/avito/android/serp/adapter/skeleton/SkeletonPresenterImpl;)Lcom/avito/android/serp/adapter/skeleton/SkeletonPresenter;", "Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator$Impl;", "generator", "Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator;", "bindSkeletonGenerator", "(Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator$Impl;)Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator;", "Lcom/avito/android/serp/adapter/skeleton/AdvertItemGridSkeletonBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindSkeletonBlueprint", "(Lcom/avito/android/serp/adapter/skeleton/AdvertItemGridSkeletonBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface SerpSkeletonModule {
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindSkeletonBlueprint(@NotNull AdvertItemGridSkeletonBlueprint advertItemGridSkeletonBlueprint);

    @PerFragment
    @Binds
    @NotNull
    SkeletonGenerator bindSkeletonGenerator(@NotNull SkeletonGenerator.Impl impl);

    @PerFragment
    @Binds
    @NotNull
    SkeletonPresenter bindSkeletonPresenter(@NotNull SkeletonPresenterImpl skeletonPresenterImpl);
}

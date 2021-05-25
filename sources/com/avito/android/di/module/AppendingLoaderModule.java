package com.avito.android.di.module;

import com.avito.android.di.PerFragment;
import com.avito.android.home.appending_item.loader.AppendingLargeLoaderItemBlueprint;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemBlueprint;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemPresenter;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/di/module/AppendingLoaderModule;", "", "Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemPresenter;", "presenter", "Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemBlueprint;", "provideAppendingLoaderItemBlueprint", "(Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemPresenter;)Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemBlueprint;", "Lcom/avito/android/home/appending_item/loader/AppendingLargeLoaderItemBlueprint;", "provideAppendingLargeLoaderItemBlueprint", "(Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemPresenter;)Lcom/avito/android/home/appending_item/loader/AppendingLargeLoaderItemBlueprint;", "provideAppendingLoaderItemPresenter", "()Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemPresenter;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AppendingLoaderModule {
    @Provides
    @PerFragment
    @NotNull
    public final AppendingLargeLoaderItemBlueprint provideAppendingLargeLoaderItemBlueprint(@NotNull AppendingLoaderItemPresenter appendingLoaderItemPresenter) {
        Intrinsics.checkNotNullParameter(appendingLoaderItemPresenter, "presenter");
        return new AppendingLargeLoaderItemBlueprint(appendingLoaderItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AppendingLoaderItemBlueprint provideAppendingLoaderItemBlueprint(@NotNull AppendingLoaderItemPresenter appendingLoaderItemPresenter) {
        Intrinsics.checkNotNullParameter(appendingLoaderItemPresenter, "presenter");
        return new AppendingLoaderItemBlueprint(appendingLoaderItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AppendingLoaderItemPresenter provideAppendingLoaderItemPresenter() {
        return new AppendingLoaderItemPresenter();
    }
}

package com.avito.android.di.module;

import com.avito.android.home.appending_item.loader.AppendingLargeLoaderItemBlueprint;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AppendingLoaderModule_ProvideAppendingLargeLoaderItemBlueprintFactory implements Factory<AppendingLargeLoaderItemBlueprint> {
    public final AppendingLoaderModule a;
    public final Provider<AppendingLoaderItemPresenter> b;

    public AppendingLoaderModule_ProvideAppendingLargeLoaderItemBlueprintFactory(AppendingLoaderModule appendingLoaderModule, Provider<AppendingLoaderItemPresenter> provider) {
        this.a = appendingLoaderModule;
        this.b = provider;
    }

    public static AppendingLoaderModule_ProvideAppendingLargeLoaderItemBlueprintFactory create(AppendingLoaderModule appendingLoaderModule, Provider<AppendingLoaderItemPresenter> provider) {
        return new AppendingLoaderModule_ProvideAppendingLargeLoaderItemBlueprintFactory(appendingLoaderModule, provider);
    }

    public static AppendingLargeLoaderItemBlueprint provideAppendingLargeLoaderItemBlueprint(AppendingLoaderModule appendingLoaderModule, AppendingLoaderItemPresenter appendingLoaderItemPresenter) {
        return (AppendingLargeLoaderItemBlueprint) Preconditions.checkNotNullFromProvides(appendingLoaderModule.provideAppendingLargeLoaderItemBlueprint(appendingLoaderItemPresenter));
    }

    @Override // javax.inject.Provider
    public AppendingLargeLoaderItemBlueprint get() {
        return provideAppendingLargeLoaderItemBlueprint(this.a, this.b.get());
    }
}

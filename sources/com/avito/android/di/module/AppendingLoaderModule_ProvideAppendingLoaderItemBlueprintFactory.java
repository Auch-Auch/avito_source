package com.avito.android.di.module;

import com.avito.android.home.appending_item.loader.AppendingLoaderItemBlueprint;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AppendingLoaderModule_ProvideAppendingLoaderItemBlueprintFactory implements Factory<AppendingLoaderItemBlueprint> {
    public final AppendingLoaderModule a;
    public final Provider<AppendingLoaderItemPresenter> b;

    public AppendingLoaderModule_ProvideAppendingLoaderItemBlueprintFactory(AppendingLoaderModule appendingLoaderModule, Provider<AppendingLoaderItemPresenter> provider) {
        this.a = appendingLoaderModule;
        this.b = provider;
    }

    public static AppendingLoaderModule_ProvideAppendingLoaderItemBlueprintFactory create(AppendingLoaderModule appendingLoaderModule, Provider<AppendingLoaderItemPresenter> provider) {
        return new AppendingLoaderModule_ProvideAppendingLoaderItemBlueprintFactory(appendingLoaderModule, provider);
    }

    public static AppendingLoaderItemBlueprint provideAppendingLoaderItemBlueprint(AppendingLoaderModule appendingLoaderModule, AppendingLoaderItemPresenter appendingLoaderItemPresenter) {
        return (AppendingLoaderItemBlueprint) Preconditions.checkNotNullFromProvides(appendingLoaderModule.provideAppendingLoaderItemBlueprint(appendingLoaderItemPresenter));
    }

    @Override // javax.inject.Provider
    public AppendingLoaderItemBlueprint get() {
        return provideAppendingLoaderItemBlueprint(this.a, this.b.get());
    }
}

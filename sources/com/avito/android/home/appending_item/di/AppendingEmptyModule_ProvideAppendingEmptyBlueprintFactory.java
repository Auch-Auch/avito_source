package com.avito.android.home.appending_item.di;

import com.avito.android.home.appending_item.empty.AppendingEmptyItemBlueprint;
import com.avito.android.home.appending_item.empty.AppendingEmptyItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AppendingEmptyModule_ProvideAppendingEmptyBlueprintFactory implements Factory<AppendingEmptyItemBlueprint> {
    public final AppendingEmptyModule a;
    public final Provider<AppendingEmptyItemPresenter> b;

    public AppendingEmptyModule_ProvideAppendingEmptyBlueprintFactory(AppendingEmptyModule appendingEmptyModule, Provider<AppendingEmptyItemPresenter> provider) {
        this.a = appendingEmptyModule;
        this.b = provider;
    }

    public static AppendingEmptyModule_ProvideAppendingEmptyBlueprintFactory create(AppendingEmptyModule appendingEmptyModule, Provider<AppendingEmptyItemPresenter> provider) {
        return new AppendingEmptyModule_ProvideAppendingEmptyBlueprintFactory(appendingEmptyModule, provider);
    }

    public static AppendingEmptyItemBlueprint provideAppendingEmptyBlueprint(AppendingEmptyModule appendingEmptyModule, AppendingEmptyItemPresenter appendingEmptyItemPresenter) {
        return (AppendingEmptyItemBlueprint) Preconditions.checkNotNullFromProvides(appendingEmptyModule.provideAppendingEmptyBlueprint(appendingEmptyItemPresenter));
    }

    @Override // javax.inject.Provider
    public AppendingEmptyItemBlueprint get() {
        return provideAppendingEmptyBlueprint(this.a, this.b.get());
    }
}

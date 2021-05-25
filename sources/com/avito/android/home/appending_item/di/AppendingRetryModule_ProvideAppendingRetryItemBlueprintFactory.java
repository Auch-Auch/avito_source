package com.avito.android.home.appending_item.di;

import com.avito.android.home.appending_item.retry.AppendingRetryItemBlueprint;
import com.avito.android.home.appending_item.retry.AppendingRetryItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AppendingRetryModule_ProvideAppendingRetryItemBlueprintFactory implements Factory<AppendingRetryItemBlueprint> {
    public final AppendingRetryModule a;
    public final Provider<AppendingRetryItemPresenter> b;

    public AppendingRetryModule_ProvideAppendingRetryItemBlueprintFactory(AppendingRetryModule appendingRetryModule, Provider<AppendingRetryItemPresenter> provider) {
        this.a = appendingRetryModule;
        this.b = provider;
    }

    public static AppendingRetryModule_ProvideAppendingRetryItemBlueprintFactory create(AppendingRetryModule appendingRetryModule, Provider<AppendingRetryItemPresenter> provider) {
        return new AppendingRetryModule_ProvideAppendingRetryItemBlueprintFactory(appendingRetryModule, provider);
    }

    public static AppendingRetryItemBlueprint provideAppendingRetryItemBlueprint(AppendingRetryModule appendingRetryModule, AppendingRetryItemPresenter appendingRetryItemPresenter) {
        return (AppendingRetryItemBlueprint) Preconditions.checkNotNullFromProvides(appendingRetryModule.provideAppendingRetryItemBlueprint(appendingRetryItemPresenter));
    }

    @Override // javax.inject.Provider
    public AppendingRetryItemBlueprint get() {
        return provideAppendingRetryItemBlueprint(this.a, this.b.get());
    }
}

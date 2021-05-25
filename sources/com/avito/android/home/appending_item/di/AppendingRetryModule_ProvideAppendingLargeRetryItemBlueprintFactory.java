package com.avito.android.home.appending_item.di;

import com.avito.android.home.appending_item.retry.AppendingLargeRetryItemBlueprint;
import com.avito.android.home.appending_item.retry.AppendingRetryItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AppendingRetryModule_ProvideAppendingLargeRetryItemBlueprintFactory implements Factory<AppendingLargeRetryItemBlueprint> {
    public final AppendingRetryModule a;
    public final Provider<AppendingRetryItemPresenter> b;

    public AppendingRetryModule_ProvideAppendingLargeRetryItemBlueprintFactory(AppendingRetryModule appendingRetryModule, Provider<AppendingRetryItemPresenter> provider) {
        this.a = appendingRetryModule;
        this.b = provider;
    }

    public static AppendingRetryModule_ProvideAppendingLargeRetryItemBlueprintFactory create(AppendingRetryModule appendingRetryModule, Provider<AppendingRetryItemPresenter> provider) {
        return new AppendingRetryModule_ProvideAppendingLargeRetryItemBlueprintFactory(appendingRetryModule, provider);
    }

    public static AppendingLargeRetryItemBlueprint provideAppendingLargeRetryItemBlueprint(AppendingRetryModule appendingRetryModule, AppendingRetryItemPresenter appendingRetryItemPresenter) {
        return (AppendingLargeRetryItemBlueprint) Preconditions.checkNotNullFromProvides(appendingRetryModule.provideAppendingLargeRetryItemBlueprint(appendingRetryItemPresenter));
    }

    @Override // javax.inject.Provider
    public AppendingLargeRetryItemBlueprint get() {
        return provideAppendingLargeRetryItemBlueprint(this.a, this.b.get());
    }
}

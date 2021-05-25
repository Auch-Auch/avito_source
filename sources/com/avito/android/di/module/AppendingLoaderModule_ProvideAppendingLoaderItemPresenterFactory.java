package com.avito.android.di.module;

import com.avito.android.home.appending_item.loader.AppendingLoaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AppendingLoaderModule_ProvideAppendingLoaderItemPresenterFactory implements Factory<AppendingLoaderItemPresenter> {
    public final AppendingLoaderModule a;

    public AppendingLoaderModule_ProvideAppendingLoaderItemPresenterFactory(AppendingLoaderModule appendingLoaderModule) {
        this.a = appendingLoaderModule;
    }

    public static AppendingLoaderModule_ProvideAppendingLoaderItemPresenterFactory create(AppendingLoaderModule appendingLoaderModule) {
        return new AppendingLoaderModule_ProvideAppendingLoaderItemPresenterFactory(appendingLoaderModule);
    }

    public static AppendingLoaderItemPresenter provideAppendingLoaderItemPresenter(AppendingLoaderModule appendingLoaderModule) {
        return (AppendingLoaderItemPresenter) Preconditions.checkNotNullFromProvides(appendingLoaderModule.provideAppendingLoaderItemPresenter());
    }

    @Override // javax.inject.Provider
    public AppendingLoaderItemPresenter get() {
        return provideAppendingLoaderItemPresenter(this.a);
    }
}

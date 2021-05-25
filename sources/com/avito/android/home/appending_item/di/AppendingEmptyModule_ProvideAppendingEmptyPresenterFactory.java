package com.avito.android.home.appending_item.di;

import com.avito.android.home.appending_item.empty.AppendingEmptyItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AppendingEmptyModule_ProvideAppendingEmptyPresenterFactory implements Factory<AppendingEmptyItemPresenter> {
    public final AppendingEmptyModule a;

    public AppendingEmptyModule_ProvideAppendingEmptyPresenterFactory(AppendingEmptyModule appendingEmptyModule) {
        this.a = appendingEmptyModule;
    }

    public static AppendingEmptyModule_ProvideAppendingEmptyPresenterFactory create(AppendingEmptyModule appendingEmptyModule) {
        return new AppendingEmptyModule_ProvideAppendingEmptyPresenterFactory(appendingEmptyModule);
    }

    public static AppendingEmptyItemPresenter provideAppendingEmptyPresenter(AppendingEmptyModule appendingEmptyModule) {
        return (AppendingEmptyItemPresenter) Preconditions.checkNotNullFromProvides(appendingEmptyModule.provideAppendingEmptyPresenter());
    }

    @Override // javax.inject.Provider
    public AppendingEmptyItemPresenter get() {
        return provideAppendingEmptyPresenter(this.a);
    }
}

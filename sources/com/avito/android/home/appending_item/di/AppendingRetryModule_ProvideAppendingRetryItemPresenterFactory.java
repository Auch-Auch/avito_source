package com.avito.android.home.appending_item.di;

import com.avito.android.home.appending_item.retry.AppendingRetryItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AppendingRetryModule_ProvideAppendingRetryItemPresenterFactory implements Factory<AppendingRetryItemPresenter> {
    public final AppendingRetryModule a;

    public AppendingRetryModule_ProvideAppendingRetryItemPresenterFactory(AppendingRetryModule appendingRetryModule) {
        this.a = appendingRetryModule;
    }

    public static AppendingRetryModule_ProvideAppendingRetryItemPresenterFactory create(AppendingRetryModule appendingRetryModule) {
        return new AppendingRetryModule_ProvideAppendingRetryItemPresenterFactory(appendingRetryModule);
    }

    public static AppendingRetryItemPresenter provideAppendingRetryItemPresenter(AppendingRetryModule appendingRetryModule) {
        return (AppendingRetryItemPresenter) Preconditions.checkNotNullFromProvides(appendingRetryModule.provideAppendingRetryItemPresenter());
    }

    @Override // javax.inject.Provider
    public AppendingRetryItemPresenter get() {
        return provideAppendingRetryItemPresenter(this.a);
    }
}

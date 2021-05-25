package com.avito.android.express_cv.new_cv.di;

import com.avito.android.blueprints.publish.SelectItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NewCvModule_SelectItemPresenterFactory implements Factory<SelectItemPresenter> {
    public final NewCvModule a;
    public final Provider<SelectItemPresenter.ClickListener> b;

    public NewCvModule_SelectItemPresenterFactory(NewCvModule newCvModule, Provider<SelectItemPresenter.ClickListener> provider) {
        this.a = newCvModule;
        this.b = provider;
    }

    public static NewCvModule_SelectItemPresenterFactory create(NewCvModule newCvModule, Provider<SelectItemPresenter.ClickListener> provider) {
        return new NewCvModule_SelectItemPresenterFactory(newCvModule, provider);
    }

    public static SelectItemPresenter selectItemPresenter(NewCvModule newCvModule, Lazy<SelectItemPresenter.ClickListener> lazy) {
        return (SelectItemPresenter) Preconditions.checkNotNullFromProvides(newCvModule.selectItemPresenter(lazy));
    }

    @Override // javax.inject.Provider
    public SelectItemPresenter get() {
        return selectItemPresenter(this.a, DoubleCheck.lazy(this.b));
    }
}

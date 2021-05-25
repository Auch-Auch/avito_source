package com.avito.android.express_cv.di;

import com.avito.android.express_cv.ExpressCvViewModelImpl;
import com.avito.android.express_cv.existed_cv.item.CvItemClickListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideCvItemClickListenerFactory implements Factory<CvItemClickListener> {
    public final ExpressCvModule a;
    public final Provider<ExpressCvViewModelImpl> b;

    public ExpressCvModule_ProvideCvItemClickListenerFactory(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvideCvItemClickListenerFactory create(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        return new ExpressCvModule_ProvideCvItemClickListenerFactory(expressCvModule, provider);
    }

    public static CvItemClickListener provideCvItemClickListener(ExpressCvModule expressCvModule, ExpressCvViewModelImpl expressCvViewModelImpl) {
        return (CvItemClickListener) Preconditions.checkNotNullFromProvides(expressCvModule.provideCvItemClickListener(expressCvViewModelImpl));
    }

    @Override // javax.inject.Provider
    public CvItemClickListener get() {
        return provideCvItemClickListener(this.a, this.b.get());
    }
}

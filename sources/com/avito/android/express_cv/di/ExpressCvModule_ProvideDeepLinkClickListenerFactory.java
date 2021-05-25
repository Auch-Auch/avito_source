package com.avito.android.express_cv.di;

import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.express_cv.ExpressCvViewModelImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideDeepLinkClickListenerFactory implements Factory<OnDeepLinkClickListener> {
    public final ExpressCvModule a;
    public final Provider<ExpressCvViewModelImpl> b;

    public ExpressCvModule_ProvideDeepLinkClickListenerFactory(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvideDeepLinkClickListenerFactory create(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        return new ExpressCvModule_ProvideDeepLinkClickListenerFactory(expressCvModule, provider);
    }

    public static OnDeepLinkClickListener provideDeepLinkClickListener(ExpressCvModule expressCvModule, ExpressCvViewModelImpl expressCvViewModelImpl) {
        return (OnDeepLinkClickListener) Preconditions.checkNotNullFromProvides(expressCvModule.provideDeepLinkClickListener(expressCvViewModelImpl));
    }

    @Override // javax.inject.Provider
    public OnDeepLinkClickListener get() {
        return provideDeepLinkClickListener(this.a, this.b.get());
    }
}

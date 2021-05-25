package com.avito.android.express_cv.di;

import com.avito.android.epress_cv.remote.ExpressCvApi;
import com.avito.android.express_cv.ExpressCvRepository;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ExpressCvModule_ProvideRepositoryFactory implements Factory<ExpressCvRepository> {
    public final ExpressCvModule a;
    public final Provider<ExpressCvApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<AvitoMessengerApi> d;

    public ExpressCvModule_ProvideRepositoryFactory(ExpressCvModule expressCvModule, Provider<ExpressCvApi> provider, Provider<SchedulersFactory> provider2, Provider<AvitoMessengerApi> provider3) {
        this.a = expressCvModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ExpressCvModule_ProvideRepositoryFactory create(ExpressCvModule expressCvModule, Provider<ExpressCvApi> provider, Provider<SchedulersFactory> provider2, Provider<AvitoMessengerApi> provider3) {
        return new ExpressCvModule_ProvideRepositoryFactory(expressCvModule, provider, provider2, provider3);
    }

    public static ExpressCvRepository provideRepository(ExpressCvModule expressCvModule, ExpressCvApi expressCvApi, SchedulersFactory schedulersFactory, AvitoMessengerApi avitoMessengerApi) {
        return (ExpressCvRepository) Preconditions.checkNotNullFromProvides(expressCvModule.provideRepository(expressCvApi, schedulersFactory, avitoMessengerApi));
    }

    @Override // javax.inject.Provider
    public ExpressCvRepository get() {
        return provideRepository(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}

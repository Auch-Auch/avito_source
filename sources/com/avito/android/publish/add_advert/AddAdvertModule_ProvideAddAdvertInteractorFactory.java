package com.avito.android.publish.add_advert;

import com.avito.android.remote.PublishApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
public final class AddAdvertModule_ProvideAddAdvertInteractorFactory implements Factory<AddAdvertInteractor> {
    public final Provider<PublishApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<TypedErrorThrowableConverter> c;

    public AddAdvertModule_ProvideAddAdvertInteractorFactory(Provider<PublishApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AddAdvertModule_ProvideAddAdvertInteractorFactory create(Provider<PublishApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new AddAdvertModule_ProvideAddAdvertInteractorFactory(provider, provider2, provider3);
    }

    public static AddAdvertInteractor provideAddAdvertInteractor(PublishApi publishApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return (AddAdvertInteractor) Preconditions.checkNotNullFromProvides(AddAdvertModule.provideAddAdvertInteractor(publishApi, schedulersFactory3, typedErrorThrowableConverter));
    }

    @Override // javax.inject.Provider
    public AddAdvertInteractor get() {
        return provideAddAdvertInteractor(this.a.get(), this.b.get(), this.c.get());
    }
}

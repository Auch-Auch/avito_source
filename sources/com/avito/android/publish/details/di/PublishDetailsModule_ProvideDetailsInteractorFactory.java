package com.avito.android.publish.details.di;

import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.details.PublishDetailsInteractor;
import com.avito.android.publish.pretend.PretendInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideDetailsInteractorFactory implements Factory<PublishDetailsInteractor> {
    public final PublishDetailsModule a;
    public final Provider<PretendInteractor> b;
    public final Provider<PublishParametersInteractor> c;

    public PublishDetailsModule_ProvideDetailsInteractorFactory(PublishDetailsModule publishDetailsModule, Provider<PretendInteractor> provider, Provider<PublishParametersInteractor> provider2) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PublishDetailsModule_ProvideDetailsInteractorFactory create(PublishDetailsModule publishDetailsModule, Provider<PretendInteractor> provider, Provider<PublishParametersInteractor> provider2) {
        return new PublishDetailsModule_ProvideDetailsInteractorFactory(publishDetailsModule, provider, provider2);
    }

    public static PublishDetailsInteractor provideDetailsInteractor(PublishDetailsModule publishDetailsModule, PretendInteractor pretendInteractor, PublishParametersInteractor publishParametersInteractor) {
        return (PublishDetailsInteractor) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideDetailsInteractor(pretendInteractor, publishParametersInteractor));
    }

    @Override // javax.inject.Provider
    public PublishDetailsInteractor get() {
        return provideDetailsInteractor(this.a, this.b.get(), this.c.get());
    }
}

package com.avito.android.user_advert.di;

import com.avito.android.user_advert.advert.DetailsId;
import com.avito.android.user_advert.di.MyDraftDetailsComponent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MyDraftDetailsComponent_DraftDetailsModule_ProvideAdvertIdFactory implements Factory<String> {
    public final Provider<DetailsId> a;

    public MyDraftDetailsComponent_DraftDetailsModule_ProvideAdvertIdFactory(Provider<DetailsId> provider) {
        this.a = provider;
    }

    public static MyDraftDetailsComponent_DraftDetailsModule_ProvideAdvertIdFactory create(Provider<DetailsId> provider) {
        return new MyDraftDetailsComponent_DraftDetailsModule_ProvideAdvertIdFactory(provider);
    }

    public static String provideAdvertId(DetailsId detailsId) {
        return (String) Preconditions.checkNotNullFromProvides(MyDraftDetailsComponent.DraftDetailsModule.INSTANCE.provideAdvertId(detailsId));
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideAdvertId(this.a.get());
    }
}

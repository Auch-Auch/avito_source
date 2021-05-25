package com.avito.android.profile_phones.phone_action.view_model;

import com.avito.android.profile_phones.phone_action.PhoneParcelableEntity;
import com.avito.android.profile_phones.phone_action.interactor.PhoneActionInteractor;
import com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider;
import com.avito.android.profile_phones.phones_list.list_item.PhoneActionCode;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class PhoneActionViewModelFactory_Factory implements Factory<PhoneActionViewModelFactory> {
    public final Provider<String> a;
    public final Provider<Integer> b;
    public final Provider<List<PhoneParcelableEntity>> c;
    public final Provider<PhoneActionCode> d;
    public final Provider<PhoneActionResourceProvider> e;
    public final Provider<PhoneActionInteractor> f;

    public PhoneActionViewModelFactory_Factory(Provider<String> provider, Provider<Integer> provider2, Provider<List<PhoneParcelableEntity>> provider3, Provider<PhoneActionCode> provider4, Provider<PhoneActionResourceProvider> provider5, Provider<PhoneActionInteractor> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static PhoneActionViewModelFactory_Factory create(Provider<String> provider, Provider<Integer> provider2, Provider<List<PhoneParcelableEntity>> provider3, Provider<PhoneActionCode> provider4, Provider<PhoneActionResourceProvider> provider5, Provider<PhoneActionInteractor> provider6) {
        return new PhoneActionViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PhoneActionViewModelFactory newInstance(String str, int i, List<PhoneParcelableEntity> list, PhoneActionCode phoneActionCode, PhoneActionResourceProvider phoneActionResourceProvider, PhoneActionInteractor phoneActionInteractor) {
        return new PhoneActionViewModelFactory(str, i, list, phoneActionCode, phoneActionResourceProvider, phoneActionInteractor);
    }

    @Override // javax.inject.Provider
    public PhoneActionViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get().intValue(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}

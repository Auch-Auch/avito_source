package com.avito.android.authorization.login_protection.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LoginProtectionPhoneListModule_ProvideAdapterFactory implements Factory<RecyclerView.Adapter<?>> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;

    public LoginProtectionPhoneListModule_ProvideAdapterFactory(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LoginProtectionPhoneListModule_ProvideAdapterFactory create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new LoginProtectionPhoneListModule_ProvideAdapterFactory(provider, provider2);
    }

    public static RecyclerView.Adapter<?> provideAdapter(AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (RecyclerView.Adapter) Preconditions.checkNotNullFromProvides(LoginProtectionPhoneListModule.provideAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public RecyclerView.Adapter<?> get() {
        return provideAdapter(this.a.get(), this.b.get());
    }
}

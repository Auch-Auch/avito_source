package com.avito.android.profile.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;

    public EditProfileModule_ProvideRecyclerAdapterFactory(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static EditProfileModule_ProvideRecyclerAdapterFactory create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new EditProfileModule_ProvideRecyclerAdapterFactory(provider, provider2);
    }

    public static SimpleRecyclerAdapter provideRecyclerAdapter(AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(EditProfileModule.provideRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideRecyclerAdapter(this.a.get(), this.b.get());
    }
}

package com.avito.android.publish.start_publish.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StartPublishSheetModule_ProvideAdapterFactory implements Factory<RecyclerView.Adapter<?>> {
    public final StartPublishSheetModule a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public StartPublishSheetModule_ProvideAdapterFactory(StartPublishSheetModule startPublishSheetModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = startPublishSheetModule;
        this.b = provider;
        this.c = provider2;
    }

    public static StartPublishSheetModule_ProvideAdapterFactory create(StartPublishSheetModule startPublishSheetModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new StartPublishSheetModule_ProvideAdapterFactory(startPublishSheetModule, provider, provider2);
    }

    public static RecyclerView.Adapter<?> provideAdapter(StartPublishSheetModule startPublishSheetModule, AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (RecyclerView.Adapter) Preconditions.checkNotNullFromProvides(startPublishSheetModule.provideAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public RecyclerView.Adapter<?> get() {
        return provideAdapter(this.a, this.b.get(), this.c.get());
    }
}

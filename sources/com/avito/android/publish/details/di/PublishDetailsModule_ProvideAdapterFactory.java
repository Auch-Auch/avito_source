package com.avito.android.publish.details.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideAdapterFactory implements Factory<RecyclerView.Adapter<?>> {
    public final PublishDetailsModule a;
    public final Provider<SimpleRecyclerAdapter> b;

    public PublishDetailsModule_ProvideAdapterFactory(PublishDetailsModule publishDetailsModule, Provider<SimpleRecyclerAdapter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideAdapterFactory create(PublishDetailsModule publishDetailsModule, Provider<SimpleRecyclerAdapter> provider) {
        return new PublishDetailsModule_ProvideAdapterFactory(publishDetailsModule, provider);
    }

    public static RecyclerView.Adapter<?> provideAdapter(PublishDetailsModule publishDetailsModule, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        return (RecyclerView.Adapter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideAdapter(simpleRecyclerAdapter));
    }

    @Override // javax.inject.Provider
    public RecyclerView.Adapter<?> get() {
        return provideAdapter(this.a, this.b.get());
    }
}

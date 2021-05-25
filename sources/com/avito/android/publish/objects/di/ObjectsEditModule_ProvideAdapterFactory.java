package com.avito.android.publish.objects.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ObjectsEditModule_ProvideAdapterFactory implements Factory<RecyclerView.Adapter<?>> {
    public final Provider<SimpleRecyclerAdapter> a;

    public ObjectsEditModule_ProvideAdapterFactory(Provider<SimpleRecyclerAdapter> provider) {
        this.a = provider;
    }

    public static ObjectsEditModule_ProvideAdapterFactory create(Provider<SimpleRecyclerAdapter> provider) {
        return new ObjectsEditModule_ProvideAdapterFactory(provider);
    }

    public static RecyclerView.Adapter<?> provideAdapter(SimpleRecyclerAdapter simpleRecyclerAdapter) {
        return (RecyclerView.Adapter) Preconditions.checkNotNullFromProvides(ObjectsEditModule.INSTANCE.provideAdapter(simpleRecyclerAdapter));
    }

    @Override // javax.inject.Provider
    public RecyclerView.Adapter<?> get() {
        return provideAdapter(this.a.get());
    }
}

package com.avito.android.profile.di;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideListUpdateListenerFactory implements Factory<ListUpdateCallback> {
    public final Provider<SimpleRecyclerAdapter> a;

    public EditProfileModule_ProvideListUpdateListenerFactory(Provider<SimpleRecyclerAdapter> provider) {
        this.a = provider;
    }

    public static EditProfileModule_ProvideListUpdateListenerFactory create(Provider<SimpleRecyclerAdapter> provider) {
        return new EditProfileModule_ProvideListUpdateListenerFactory(provider);
    }

    public static ListUpdateCallback provideListUpdateListener(SimpleRecyclerAdapter simpleRecyclerAdapter) {
        return (ListUpdateCallback) Preconditions.checkNotNullFromProvides(EditProfileModule.provideListUpdateListener(simpleRecyclerAdapter));
    }

    @Override // javax.inject.Provider
    public ListUpdateCallback get() {
        return provideListUpdateListener(this.a.get());
    }
}

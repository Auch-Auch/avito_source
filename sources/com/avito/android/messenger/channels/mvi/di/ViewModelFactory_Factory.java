package com.avito.android.messenger.channels.mvi.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
public final class ViewModelFactory_Factory implements Factory<ViewModelFactory> {
    public final Provider<Map<Class<?>, Provider<ViewModel>>> a;

    public ViewModelFactory_Factory(Provider<Map<Class<?>, Provider<ViewModel>>> provider) {
        this.a = provider;
    }

    public static ViewModelFactory_Factory create(Provider<Map<Class<?>, Provider<ViewModel>>> provider) {
        return new ViewModelFactory_Factory(provider);
    }

    public static ViewModelFactory newInstance(Map<Class<?>, Provider<ViewModel>> map) {
        return new ViewModelFactory(map);
    }

    @Override // javax.inject.Provider
    public ViewModelFactory get() {
        return newInstance(this.a.get());
    }
}

package com.avito.android.html_editor;

import com.avito.android.util.preferences.Preferences;
import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PrefEditorHistoryProvider_Factory implements Factory<PrefEditorHistoryProvider> {
    public final Provider<Preferences> a;
    public final Provider<Gson> b;

    public PrefEditorHistoryProvider_Factory(Provider<Preferences> provider, Provider<Gson> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PrefEditorHistoryProvider_Factory create(Provider<Preferences> provider, Provider<Gson> provider2) {
        return new PrefEditorHistoryProvider_Factory(provider, provider2);
    }

    public static PrefEditorHistoryProvider newInstance(Preferences preferences, Gson gson) {
        return new PrefEditorHistoryProvider(preferences, gson);
    }

    @Override // javax.inject.Provider
    public PrefEditorHistoryProvider get() {
        return newInstance(this.a.get(), this.b.get());
    }
}

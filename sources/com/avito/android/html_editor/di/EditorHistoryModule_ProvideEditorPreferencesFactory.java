package com.avito.android.html_editor.di;

import android.app.Application;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditorHistoryModule_ProvideEditorPreferencesFactory implements Factory<Preferences> {
    public final EditorHistoryModule a;
    public final Provider<Application> b;
    public final Provider<PreferenceFactory> c;

    public EditorHistoryModule_ProvideEditorPreferencesFactory(EditorHistoryModule editorHistoryModule, Provider<Application> provider, Provider<PreferenceFactory> provider2) {
        this.a = editorHistoryModule;
        this.b = provider;
        this.c = provider2;
    }

    public static EditorHistoryModule_ProvideEditorPreferencesFactory create(EditorHistoryModule editorHistoryModule, Provider<Application> provider, Provider<PreferenceFactory> provider2) {
        return new EditorHistoryModule_ProvideEditorPreferencesFactory(editorHistoryModule, provider, provider2);
    }

    public static Preferences provideEditorPreferences(EditorHistoryModule editorHistoryModule, Application application, PreferenceFactory preferenceFactory) {
        return (Preferences) Preconditions.checkNotNullFromProvides(editorHistoryModule.provideEditorPreferences(application, preferenceFactory));
    }

    @Override // javax.inject.Provider
    public Preferences get() {
        return provideEditorPreferences(this.a, this.b.get(), this.c.get());
    }
}

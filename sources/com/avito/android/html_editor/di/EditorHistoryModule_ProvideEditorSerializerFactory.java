package com.avito.android.html_editor.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class EditorHistoryModule_ProvideEditorSerializerFactory implements Factory<Gson> {
    public final EditorHistoryModule a;

    public EditorHistoryModule_ProvideEditorSerializerFactory(EditorHistoryModule editorHistoryModule) {
        this.a = editorHistoryModule;
    }

    public static EditorHistoryModule_ProvideEditorSerializerFactory create(EditorHistoryModule editorHistoryModule) {
        return new EditorHistoryModule_ProvideEditorSerializerFactory(editorHistoryModule);
    }

    public static Gson provideEditorSerializer(EditorHistoryModule editorHistoryModule) {
        return (Gson) Preconditions.checkNotNullFromProvides(editorHistoryModule.provideEditorSerializer());
    }

    @Override // javax.inject.Provider
    public Gson get() {
        return provideEditorSerializer(this.a);
    }
}

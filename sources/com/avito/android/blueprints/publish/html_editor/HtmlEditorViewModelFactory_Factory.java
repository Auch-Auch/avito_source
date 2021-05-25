package com.avito.android.blueprints.publish.html_editor;

import androidx.savedstate.SavedStateRegistryOwner;
import com.avito.android.html_editor.EditorHistoryProvider;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderOptions;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HtmlEditorViewModelFactory_Factory implements Factory<HtmlEditorViewModelFactory> {
    public final Provider<EditorHistoryProvider> a;
    public final Provider<HtmlNodeFactory> b;
    public final Provider<HtmlRenderOptions> c;
    public final Provider<SavedStateRegistryOwner> d;

    public HtmlEditorViewModelFactory_Factory(Provider<EditorHistoryProvider> provider, Provider<HtmlNodeFactory> provider2, Provider<HtmlRenderOptions> provider3, Provider<SavedStateRegistryOwner> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static HtmlEditorViewModelFactory_Factory create(Provider<EditorHistoryProvider> provider, Provider<HtmlNodeFactory> provider2, Provider<HtmlRenderOptions> provider3, Provider<SavedStateRegistryOwner> provider4) {
        return new HtmlEditorViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static HtmlEditorViewModelFactory newInstance(EditorHistoryProvider editorHistoryProvider, HtmlNodeFactory htmlNodeFactory, HtmlRenderOptions htmlRenderOptions, SavedStateRegistryOwner savedStateRegistryOwner) {
        return new HtmlEditorViewModelFactory(editorHistoryProvider, htmlNodeFactory, htmlRenderOptions, savedStateRegistryOwner);
    }

    @Override // javax.inject.Provider
    public HtmlEditorViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}

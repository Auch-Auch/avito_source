package com.avito.android.publish.objects.di;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import dagger.internal.Factory;
import org.jetbrains.annotations.Nullable;
public final class ObjectsEditModule_ProvideHtmlEditorViewModelFactory implements Factory<HtmlEditorViewModel> {

    public static final class a {
        public static final ObjectsEditModule_ProvideHtmlEditorViewModelFactory a = new ObjectsEditModule_ProvideHtmlEditorViewModelFactory();
    }

    public static ObjectsEditModule_ProvideHtmlEditorViewModelFactory create() {
        return a.a;
    }

    @Nullable
    public static HtmlEditorViewModel provideHtmlEditorViewModel() {
        return ObjectsEditModule.INSTANCE.provideHtmlEditorViewModel();
    }

    @Override // javax.inject.Provider
    @Nullable
    public HtmlEditorViewModel get() {
        return provideHtmlEditorViewModel();
    }
}

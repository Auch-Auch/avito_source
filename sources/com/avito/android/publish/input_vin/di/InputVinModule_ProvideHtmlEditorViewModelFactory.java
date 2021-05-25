package com.avito.android.publish.input_vin.di;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import dagger.internal.Factory;
import org.jetbrains.annotations.Nullable;
public final class InputVinModule_ProvideHtmlEditorViewModelFactory implements Factory<HtmlEditorViewModel> {

    public static final class a {
        public static final InputVinModule_ProvideHtmlEditorViewModelFactory a = new InputVinModule_ProvideHtmlEditorViewModelFactory();
    }

    public static InputVinModule_ProvideHtmlEditorViewModelFactory create() {
        return a.a;
    }

    @Nullable
    public static HtmlEditorViewModel provideHtmlEditorViewModel() {
        return InputVinModule.INSTANCE.provideHtmlEditorViewModel();
    }

    @Override // javax.inject.Provider
    @Nullable
    public HtmlEditorViewModel get() {
        return provideHtmlEditorViewModel();
    }
}

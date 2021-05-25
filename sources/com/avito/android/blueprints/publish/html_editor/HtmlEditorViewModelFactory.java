package com.avito.android.blueprints.publish.html_editor;

import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.avito.android.html_editor.EditorHistoryProvider;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.util.UrlParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ9\u0010\n\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModelFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModel;", "T", "", "key", "Ljava/lang/Class;", "modelClass", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "create", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/html_editor/EditorHistoryProvider;", "d", "Lcom/avito/android/html_editor/EditorHistoryProvider;", "historyProvider", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "f", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "htmlRenderOptions", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "e", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "Landroidx/savedstate/SavedStateRegistryOwner;", UrlParams.OWNER, "<init>", "(Lcom/avito/android/html_editor/EditorHistoryProvider;Lcom/avito/android/html_formatter/HtmlNodeFactory;Lcom/avito/android/html_formatter/HtmlRenderOptions;Landroidx/savedstate/SavedStateRegistryOwner;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class HtmlEditorViewModelFactory extends AbstractSavedStateViewModelFactory {
    public final EditorHistoryProvider d;
    public final HtmlNodeFactory e;
    public final HtmlRenderOptions f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public HtmlEditorViewModelFactory(@NotNull EditorHistoryProvider editorHistoryProvider, @NotNull HtmlNodeFactory htmlNodeFactory, @NotNull HtmlRenderOptions htmlRenderOptions, @NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
        super(savedStateRegistryOwner, null);
        Intrinsics.checkNotNullParameter(editorHistoryProvider, "historyProvider");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "htmlRenderOptions");
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, UrlParams.OWNER);
        this.d = editorHistoryProvider;
        this.e = htmlNodeFactory;
        this.f = htmlRenderOptions;
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    public <T extends ViewModel> T create(@NotNull String str, @NotNull Class<T> cls, @NotNull SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(savedStateHandle, "stateHandle");
        if (cls.isAssignableFrom(HtmlEditorViewModelImpl.class)) {
            return new HtmlEditorViewModelImpl(savedStateHandle, this.d, this.e, this.f);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

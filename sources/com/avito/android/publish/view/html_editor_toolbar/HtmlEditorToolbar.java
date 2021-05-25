package com.avito.android.publish.view.html_editor_toolbar;

import com.avito.android.html_editor.EditorNavigationEvent;
import com.avito.android.html_formatter.FormatChange;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/avito/android/publish/view/html_editor_toolbar/HtmlEditorToolbar;", "", "", "flags", "", "setEditorToolbarStateFlags", "(I)V", "", "undoEnabled", "redoEnabled", "setNavigationButtonsStates", "(ZZ)V", "show", "()V", "hide", "isVisible", "()Z", "Lio/reactivex/Observable;", "Lcom/avito/android/html_editor/EditorNavigationEvent;", "getEditorToolbarNavigationEventObservable", "()Lio/reactivex/Observable;", "editorToolbarNavigationEventObservable", "Lcom/avito/android/html_formatter/FormatChange;", "getEditorToolbarStateFlagsObservable", "editorToolbarStateFlagsObservable", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface HtmlEditorToolbar {
    @NotNull
    Observable<EditorNavigationEvent> getEditorToolbarNavigationEventObservable();

    @NotNull
    Observable<FormatChange> getEditorToolbarStateFlagsObservable();

    void hide();

    boolean isVisible();

    void setEditorToolbarStateFlags(int i);

    void setNavigationButtonsStates(boolean z, boolean z2);

    void show();
}

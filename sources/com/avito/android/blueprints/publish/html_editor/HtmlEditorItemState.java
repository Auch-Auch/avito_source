package com.avito.android.blueprints.publish.html_editor;

import com.avito.android.html_editor.EditorState;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemState;", "", "", "itemId", "Lio/reactivex/disposables/CompositeDisposable;", "getItemSubscriptionsDisposable", "(Ljava/lang/String;)Lio/reactivex/disposables/CompositeDisposable;", "Lcom/avito/android/html_editor/EditorState;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/html_editor/EditorState;", "getEditorState", "()Lcom/avito/android/html_editor/EditorState;", "editorState", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "disposables", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class HtmlEditorItemState {
    public final Map<String, CompositeDisposable> a = new LinkedHashMap();
    @NotNull
    public final EditorState b = new EditorState();

    @NotNull
    public final EditorState getEditorState() {
        return this.b;
    }

    @NotNull
    public final CompositeDisposable getItemSubscriptionsDisposable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Map<String, CompositeDisposable> map = this.a;
        CompositeDisposable compositeDisposable = map.get(str);
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
            map.put(str, compositeDisposable);
        }
        return compositeDisposable;
    }
}

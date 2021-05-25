package com.avito.android.html_editor;

import com.avito.android.html_formatter.EditorOperation;
import com.avito.android.html_formatter.FormatOperation;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/avito/android/html_editor/EditorState;", "", "", "clear", "()V", "", "Lcom/avito/android/html_formatter/FormatOperation;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getPendingFormatOperations", "()Ljava/util/List;", "setPendingFormatOperations", "(Ljava/util/List;)V", "pendingFormatOperations", "Lcom/avito/android/html_formatter/EditorOperation;", "c", "Lcom/avito/android/html_formatter/EditorOperation;", "getLastOperation", "()Lcom/avito/android/html_formatter/EditorOperation;", "setLastOperation", "(Lcom/avito/android/html_formatter/EditorOperation;)V", "lastOperation", "", AuthSource.BOOKING_ORDER, "Z", "getShouldMakeSnapshotOnNextOperation", "()Z", "setShouldMakeSnapshotOnNextOperation", "(Z)V", "shouldMakeSnapshotOnNextOperation", "<init>", "html-editor_release"}, k = 1, mv = {1, 4, 2})
public final class EditorState {
    @NotNull
    public List<FormatOperation> a = new ArrayList();
    public boolean b = true;
    @Nullable
    public EditorOperation c;

    public final void clear() {
        this.a.clear();
        this.b = true;
    }

    @Nullable
    public final EditorOperation getLastOperation() {
        return this.c;
    }

    @NotNull
    public final List<FormatOperation> getPendingFormatOperations() {
        return this.a;
    }

    public final boolean getShouldMakeSnapshotOnNextOperation() {
        return this.b;
    }

    public final void setLastOperation(@Nullable EditorOperation editorOperation) {
        this.c = editorOperation;
    }

    public final void setPendingFormatOperations(@NotNull List<FormatOperation> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.a = list;
    }

    public final void setShouldMakeSnapshotOnNextOperation(boolean z) {
        this.b = z;
    }
}

package com.avito.android.html_formatter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/html_formatter/ReplaceOperation;", "Lcom/avito/android/html_formatter/EditorOperation;", "Lcom/avito/android/html_formatter/DeleteOperation;", "component1", "()Lcom/avito/android/html_formatter/DeleteOperation;", "", "Lcom/avito/android/html_formatter/InsertOperation;", "component2", "()Ljava/util/List;", "deleteOperation", "insertOperations", "copy", "(Lcom/avito/android/html_formatter/DeleteOperation;Ljava/util/List;)Lcom/avito/android/html_formatter/ReplaceOperation;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", "isActuallyInsert", "()Z", "c", "Ljava/util/List;", "getInsertOperations", AuthSource.BOOKING_ORDER, "Lcom/avito/android/html_formatter/DeleteOperation;", "getDeleteOperation", "<init>", "(Lcom/avito/android/html_formatter/DeleteOperation;Ljava/util/List;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class ReplaceOperation extends EditorOperation {
    public final boolean a;
    @NotNull
    public final DeleteOperation b;
    @NotNull
    public final List<InsertOperation> c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReplaceOperation(@NotNull DeleteOperation deleteOperation, @NotNull List<InsertOperation> list) {
        super(null);
        Intrinsics.checkNotNullParameter(deleteOperation, "deleteOperation");
        Intrinsics.checkNotNullParameter(list, "insertOperations");
        this.b = deleteOperation;
        this.c = list;
        int to = deleteOperation.getTo() - deleteOperation.getFrom();
        Iterator<T> it = list.iterator();
        boolean z = false;
        int i = 0;
        while (it.hasNext()) {
            i += it.next().getContent().length();
        }
        this.a = to < i ? true : z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.html_formatter.ReplaceOperation */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReplaceOperation copy$default(ReplaceOperation replaceOperation, DeleteOperation deleteOperation, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            deleteOperation = replaceOperation.b;
        }
        if ((i & 2) != 0) {
            list = replaceOperation.c;
        }
        return replaceOperation.copy(deleteOperation, list);
    }

    @NotNull
    public final DeleteOperation component1() {
        return this.b;
    }

    @NotNull
    public final List<InsertOperation> component2() {
        return this.c;
    }

    @NotNull
    public final ReplaceOperation copy(@NotNull DeleteOperation deleteOperation, @NotNull List<InsertOperation> list) {
        Intrinsics.checkNotNullParameter(deleteOperation, "deleteOperation");
        Intrinsics.checkNotNullParameter(list, "insertOperations");
        return new ReplaceOperation(deleteOperation, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReplaceOperation)) {
            return false;
        }
        ReplaceOperation replaceOperation = (ReplaceOperation) obj;
        return Intrinsics.areEqual(this.b, replaceOperation.b) && Intrinsics.areEqual(this.c, replaceOperation.c);
    }

    @NotNull
    public final DeleteOperation getDeleteOperation() {
        return this.b;
    }

    @NotNull
    public final List<InsertOperation> getInsertOperations() {
        return this.c;
    }

    public int hashCode() {
        DeleteOperation deleteOperation = this.b;
        int i = 0;
        int hashCode = (deleteOperation != null ? deleteOperation.hashCode() : 0) * 31;
        List<InsertOperation> list = this.c;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isActuallyInsert() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ReplaceOperation(deleteOperation=");
        L.append(this.b);
        L.append(", insertOperations=");
        return a.w(L, this.c, ")");
    }
}

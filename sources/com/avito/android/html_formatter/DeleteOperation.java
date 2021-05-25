package com.avito.android.html_formatter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/html_formatter/DeleteOperation;", "Lcom/avito/android/html_formatter/EditorOperation;", "", "component1", "()I", "component2", "from", "to", "copy", "(II)Lcom/avito/android/html_formatter/DeleteOperation;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getFrom", "setFrom", "(I)V", AuthSource.BOOKING_ORDER, "getTo", "setTo", "<init>", "(II)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class DeleteOperation extends EditorOperation {
    public int a;
    public int b;

    public DeleteOperation(int i, int i2) {
        super(null);
        this.a = i;
        this.b = i2;
    }

    public static /* synthetic */ DeleteOperation copy$default(DeleteOperation deleteOperation, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = deleteOperation.a;
        }
        if ((i3 & 2) != 0) {
            i2 = deleteOperation.b;
        }
        return deleteOperation.copy(i, i2);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final DeleteOperation copy(int i, int i2) {
        return new DeleteOperation(i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteOperation)) {
            return false;
        }
        DeleteOperation deleteOperation = (DeleteOperation) obj;
        return this.a == deleteOperation.a && this.b == deleteOperation.b;
    }

    public final int getFrom() {
        return this.a;
    }

    public final int getTo() {
        return this.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final void setFrom(int i) {
        this.a = i;
    }

    public final void setTo(int i) {
        this.b = i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DeleteOperation(from=");
        L.append(this.a);
        L.append(", to=");
        return a.j(L, this.b, ")");
    }
}

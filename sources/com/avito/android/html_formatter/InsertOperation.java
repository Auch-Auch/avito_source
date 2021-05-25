package com.avito.android.html_formatter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/avito/android/html_formatter/InsertOperation;", "Lcom/avito/android/html_formatter/EditorOperation;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "from", "content", "copy", "(ILjava/lang/String;)Lcom/avito/android/html_formatter/InsertOperation;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getContent", "setContent", "(Ljava/lang/String;)V", AuthSource.SEND_ABUSE, "I", "getFrom", "setFrom", "(I)V", "<init>", "(ILjava/lang/String;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class InsertOperation extends EditorOperation {
    public int a;
    @NotNull
    public String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InsertOperation(int i, @NotNull String str) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "content");
        this.a = i;
        this.b = str;
    }

    public static /* synthetic */ InsertOperation copy$default(InsertOperation insertOperation, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = insertOperation.a;
        }
        if ((i2 & 2) != 0) {
            str = insertOperation.b;
        }
        return insertOperation.copy(i, str);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final InsertOperation copy(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        return new InsertOperation(i, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsertOperation)) {
            return false;
        }
        InsertOperation insertOperation = (InsertOperation) obj;
        return this.a == insertOperation.a && Intrinsics.areEqual(this.b, insertOperation.b);
    }

    @NotNull
    public final String getContent() {
        return this.b;
    }

    public final int getFrom() {
        return this.a;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void setFrom(int i) {
        this.a = i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("InsertOperation(from=");
        L.append(this.a);
        L.append(", content=");
        return a.t(L, this.b, ")");
    }
}

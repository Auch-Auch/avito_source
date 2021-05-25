package com.avito.android.html_formatter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u0019\u0010!\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/avito/android/html_formatter/FormatOperation;", "Lcom/avito/android/html_formatter/EditorOperation;", "", "component1", "()I", "component2", "Lcom/avito/android/html_formatter/FormatChange;", "component3", "()Lcom/avito/android/html_formatter/FormatChange;", "from", "to", "formatChange", "copy", "(IILcom/avito/android/html_formatter/FormatChange;)Lcom/avito/android/html_formatter/FormatOperation;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "I", "getTo", AuthSource.BOOKING_ORDER, "getFrom", "d", "Lcom/avito/android/html_formatter/FormatChange;", "getFormatChange", AuthSource.SEND_ABUSE, "Z", "isPending", "()Z", "<init>", "(IILcom/avito/android/html_formatter/FormatChange;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class FormatOperation extends EditorOperation {
    public final boolean a;
    public final int b;
    public final int c;
    @NotNull
    public final FormatChange d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FormatOperation(int i, int i2, @NotNull FormatChange formatChange) {
        super(null);
        Intrinsics.checkNotNullParameter(formatChange, "formatChange");
        this.b = i;
        this.c = i2;
        this.d = formatChange;
        this.a = (formatChange instanceof InlineFormatChange) && i == i2;
    }

    public static /* synthetic */ FormatOperation copy$default(FormatOperation formatOperation, int i, int i2, FormatChange formatChange, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = formatOperation.b;
        }
        if ((i3 & 2) != 0) {
            i2 = formatOperation.c;
        }
        if ((i3 & 4) != 0) {
            formatChange = formatOperation.d;
        }
        return formatOperation.copy(i, i2, formatChange);
    }

    public final int component1() {
        return this.b;
    }

    public final int component2() {
        return this.c;
    }

    @NotNull
    public final FormatChange component3() {
        return this.d;
    }

    @NotNull
    public final FormatOperation copy(int i, int i2, @NotNull FormatChange formatChange) {
        Intrinsics.checkNotNullParameter(formatChange, "formatChange");
        return new FormatOperation(i, i2, formatChange);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormatOperation)) {
            return false;
        }
        FormatOperation formatOperation = (FormatOperation) obj;
        return this.b == formatOperation.b && this.c == formatOperation.c && Intrinsics.areEqual(this.d, formatOperation.d);
    }

    @NotNull
    public final FormatChange getFormatChange() {
        return this.d;
    }

    public final int getFrom() {
        return this.b;
    }

    public final int getTo() {
        return this.c;
    }

    public int hashCode() {
        int i = ((this.b * 31) + this.c) * 31;
        FormatChange formatChange = this.d;
        return i + (formatChange != null ? formatChange.hashCode() : 0);
    }

    public final boolean isPending() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("FormatOperation(from=");
        L.append(this.b);
        L.append(", to=");
        L.append(this.c);
        L.append(", formatChange=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }
}

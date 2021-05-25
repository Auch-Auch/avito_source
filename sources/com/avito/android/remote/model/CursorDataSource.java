package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.database.Cursor;
import com.avito.android.util.CursorsKt;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001)B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0004\u001a\u00020\u0003HÂ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÂ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u000fJ0\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010#R\u0016\u0010\t\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010$R\u0016\u0010&\u001a\u00020\u00108V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001e¨\u0006*"}, d2 = {"Lcom/avito/android/remote/model/CursorDataSource;", "T", "Lcom/avito/android/remote/model/CloseableDataSource;", "Landroid/database/Cursor;", "component1", "()Landroid/database/Cursor;", "Lcom/avito/android/remote/model/CursorDataSource$CursorDataRetriever;", "component2", "()Lcom/avito/android/remote/model/CursorDataSource$CursorDataRetriever;", "cursor", "", "setCursor", "(Landroid/database/Cursor;)V", "", "isEmpty", "()Z", "", VKApiConst.POSITION, "getItem", "(I)Ljava/lang/Object;", "close", "()V", "isClosed", "retriever", "copy", "(Landroid/database/Cursor;Lcom/avito/android/remote/model/CursorDataSource$CursorDataRetriever;)Lcom/avito/android/remote/model/CursorDataSource;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/CursorDataSource$CursorDataRetriever;", "Landroid/database/Cursor;", "getCount", "count", "<init>", "(Landroid/database/Cursor;Lcom/avito/android/remote/model/CursorDataSource$CursorDataRetriever;)V", "CursorDataRetriever", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public final class CursorDataSource<T> implements CloseableDataSource<T> {
    private Cursor cursor;
    private final CursorDataRetriever<T> retriever;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/CursorDataSource$CursorDataRetriever;", "T", "", "Landroid/database/Cursor;", "cursor", "retrieve", "(Landroid/database/Cursor;)Ljava/lang/Object;", "konveyor_release"}, k = 1, mv = {1, 4, 2})
    public interface CursorDataRetriever<T> {
        T retrieve(@NotNull Cursor cursor);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.remote.model.CursorDataSource$CursorDataRetriever<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public CursorDataSource(@NotNull Cursor cursor2, @NotNull CursorDataRetriever<? extends T> cursorDataRetriever) {
        Intrinsics.checkNotNullParameter(cursor2, "cursor");
        Intrinsics.checkNotNullParameter(cursorDataRetriever, "retriever");
        this.cursor = cursor2;
        this.retriever = cursorDataRetriever;
    }

    private final Cursor component1() {
        return this.cursor;
    }

    private final CursorDataRetriever<T> component2() {
        return this.retriever;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.CursorDataSource */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CursorDataSource copy$default(CursorDataSource cursorDataSource, Cursor cursor2, CursorDataRetriever cursorDataRetriever, int i, Object obj) {
        if ((i & 1) != 0) {
            cursor2 = cursorDataSource.cursor;
        }
        if ((i & 2) != 0) {
            cursorDataRetriever = cursorDataSource.retriever;
        }
        return cursorDataSource.copy(cursor2, cursorDataRetriever);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cursor.close();
    }

    @NotNull
    public final CursorDataSource<T> copy(@NotNull Cursor cursor2, @NotNull CursorDataRetriever<? extends T> cursorDataRetriever) {
        Intrinsics.checkNotNullParameter(cursor2, "cursor");
        Intrinsics.checkNotNullParameter(cursorDataRetriever, "retriever");
        return new CursorDataSource<>(cursor2, cursorDataRetriever);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CursorDataSource)) {
            return false;
        }
        CursorDataSource cursorDataSource = (CursorDataSource) obj;
        return Intrinsics.areEqual(this.cursor, cursorDataSource.cursor) && Intrinsics.areEqual(this.retriever, cursorDataSource.retriever);
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        return this.cursor.getCount();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public T getItem(int i) {
        if (this.cursor.moveToPosition(i)) {
            return this.retriever.retrieve(this.cursor);
        }
        StringBuilder L = a.L("Failed to move cursor ");
        L.append(this.cursor.toString());
        L.append(" to position ");
        L.append(i);
        throw new IllegalStateException(L.toString());
    }

    @Override // java.lang.Object
    public int hashCode() {
        Cursor cursor2 = this.cursor;
        int i = 0;
        int hashCode = (cursor2 != null ? cursor2.hashCode() : 0) * 31;
        CursorDataRetriever<T> cursorDataRetriever = this.retriever;
        if (cursorDataRetriever != null) {
            i = cursorDataRetriever.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isClosed() {
        return this.cursor.isClosed();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return CursorsKt.isEmpty(this.cursor);
    }

    public final void setCursor(@NotNull Cursor cursor2) {
        Intrinsics.checkNotNullParameter(cursor2, "cursor");
        Cursor cursor3 = this.cursor;
        if (cursor3 != cursor2) {
            cursor3.close();
        }
        this.cursor = cursor2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CursorDataSource(cursor=");
        L.append(this.cursor);
        L.append(", retriever=");
        L.append(this.retriever);
        L.append(")");
        return L.toString();
    }
}

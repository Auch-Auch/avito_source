package com.avito.android.messenger.conversation.mvi.file_attachment;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "displayName", MessageBody.File.MIME_TYPE, "sizeInBytes", "copy", "(Ljava/lang/String;Ljava/lang/String;J)Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "J", "getSizeInBytes", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDisplayName", AuthSource.BOOKING_ORDER, "getMimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileInfo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final long c;

    public FileInfo(@NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        Intrinsics.checkNotNullParameter(str2, MessageBody.File.MIME_TYPE);
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    public static /* synthetic */ FileInfo copy$default(FileInfo fileInfo, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = fileInfo.b;
        }
        if ((i & 4) != 0) {
            j = fileInfo.c;
        }
        return fileInfo.copy(str, str2, j);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final long component3() {
        return this.c;
    }

    @NotNull
    public final FileInfo copy(@NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        Intrinsics.checkNotNullParameter(str2, MessageBody.File.MIME_TYPE);
        return new FileInfo(str, str2, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileInfo)) {
            return false;
        }
        FileInfo fileInfo = (FileInfo) obj;
        return Intrinsics.areEqual(this.a, fileInfo.a) && Intrinsics.areEqual(this.b, fileInfo.b) && this.c == fileInfo.c;
    }

    @NotNull
    public final String getDisplayName() {
        return this.a;
    }

    @NotNull
    public final String getMimeType() {
        return this.b;
    }

    public final long getSizeInBytes() {
        return this.c;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + c.a(this.c);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("FileInfo(displayName=");
        L.append(this.a);
        L.append(", mimeType=");
        L.append(this.b);
        L.append(", sizeInBytes=");
        return a.l(L, this.c, ")");
    }
}

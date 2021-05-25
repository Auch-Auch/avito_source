package com.avito.android.messenger.conversation.mvi.file_attachment;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0003\u0004\u0005\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "FileMaxSizeExceeded", "NoSuchFileFoundException", "ReadFileInfoException", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentException$ReadFileInfoException;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentException$NoSuchFileFoundException;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentException$FileMaxSizeExceeded;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class FileAttachmentException extends Exception {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentException$FileMaxSizeExceeded;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentException;", "", "component1", "()J", "component2", "fileSizeInBytes", "maxAllowedSizeInBytes", "copy", "(JJ)Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentException$FileMaxSizeExceeded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "J", "getMaxAllowedSizeInBytes", AuthSource.SEND_ABUSE, "getFileSizeInBytes", "<init>", "(JJ)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class FileMaxSizeExceeded extends FileAttachmentException {
        public final long a;
        public final long b;

        public FileMaxSizeExceeded(long j, long j2) {
            super((Throwable) null, 1);
            this.a = j;
            this.b = j2;
        }

        public static /* synthetic */ FileMaxSizeExceeded copy$default(FileMaxSizeExceeded fileMaxSizeExceeded, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = fileMaxSizeExceeded.a;
            }
            if ((i & 2) != 0) {
                j2 = fileMaxSizeExceeded.b;
            }
            return fileMaxSizeExceeded.copy(j, j2);
        }

        public final long component1() {
            return this.a;
        }

        public final long component2() {
            return this.b;
        }

        @NotNull
        public final FileMaxSizeExceeded copy(long j, long j2) {
            return new FileMaxSizeExceeded(j, j2);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FileMaxSizeExceeded)) {
                return false;
            }
            FileMaxSizeExceeded fileMaxSizeExceeded = (FileMaxSizeExceeded) obj;
            return this.a == fileMaxSizeExceeded.a && this.b == fileMaxSizeExceeded.b;
        }

        public final long getFileSizeInBytes() {
            return this.a;
        }

        public final long getMaxAllowedSizeInBytes() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (c.a(this.a) * 31) + c.a(this.b);
        }

        @Override // java.lang.Throwable, java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("FileMaxSizeExceeded(fileSizeInBytes=");
            L.append(this.a);
            L.append(", maxAllowedSizeInBytes=");
            return a.l(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentException$NoSuchFileFoundException;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentException;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class NoSuchFileFoundException extends FileAttachmentException {
        @NotNull
        public static final NoSuchFileFoundException INSTANCE = new NoSuchFileFoundException();

        private NoSuchFileFoundException() {
            super((Throwable) null, 1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentException$ReadFileInfoException;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentException;", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ReadFileInfoException extends FileAttachmentException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReadFileInfoException(@NotNull Throwable th) {
            super(th, (j) null);
            Intrinsics.checkNotNullParameter(th, "cause");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileAttachmentException(Throwable th, int i) {
        super((Throwable) null);
        int i2 = i & 1;
    }

    public FileAttachmentException(Throwable th, j jVar) {
        super(th);
    }
}

package com.avito.composite_exception;

import com.avito.android.remote.auth.AuthSource;
import java.io.PrintStream;
import java.io.PrintWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0004\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/composite_exception/CompositeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "printStackTrace", "()V", "Ljava/io/PrintStream;", "s", "(Ljava/io/PrintStream;)V", "Ljava/io/PrintWriter;", "(Ljava/io/PrintWriter;)V", "", "", AuthSource.SEND_ABUSE, "[Ljava/lang/Throwable;", "throwables", "", "message", "<init>", "(Ljava/lang/String;[Ljava/lang/Throwable;)V", "composite-exception"}, k = 1, mv = {1, 4, 2})
public final class CompositeException extends RuntimeException {
    public final Throwable[] a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompositeException(@NotNull String str, @NotNull Throwable[] thArr) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(thArr, "throwables");
        this.a = thArr;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        Throwable[] thArr = this.a;
        if (thArr.length == 0) {
            super.printStackTrace();
            return;
        }
        for (Throwable th : thArr) {
            th.printStackTrace();
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(@NotNull PrintStream printStream) {
        Intrinsics.checkNotNullParameter(printStream, "s");
        Throwable[] thArr = this.a;
        if (thArr.length == 0) {
            super.printStackTrace(printStream);
            return;
        }
        for (Throwable th : thArr) {
            th.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(@NotNull PrintWriter printWriter) {
        Intrinsics.checkNotNullParameter(printWriter, "s");
        Throwable[] thArr = this.a;
        if (thArr.length == 0) {
            super.printStackTrace(printWriter);
            return;
        }
        for (Throwable th : thArr) {
            th.printStackTrace(printWriter);
        }
    }
}

package com.avito.android.calls;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B'\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/avito/android/calls/AvitoCallException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/avito/android/calls/AvitoCallError;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/AvitoCallError;", "getCode", "()Lcom/avito/android/calls/AvitoCallError;", "code", "", "message", "", "cause", "<init>", "(Lcom/avito/android/calls/AvitoCallError;Ljava/lang/String;Ljava/lang/Throwable;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoCallException extends Exception {
    @NotNull
    public final AvitoCallError a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvitoCallException(AvitoCallError avitoCallError, String str, Throwable th, int i, j jVar) {
        this(avitoCallError, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : th);
    }

    @NotNull
    public final AvitoCallError getCode() {
        return this.a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AvitoCallException(@NotNull AvitoCallError avitoCallError, @Nullable String str, @Nullable Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(avitoCallError, "code");
        this.a = avitoCallError;
    }
}

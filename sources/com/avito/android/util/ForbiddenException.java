package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorContainer;
import com.avito.android.remote.model.Error;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/util/ForbiddenException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/avito/android/remote/error/ErrorContainer;", "Lcom/avito/android/remote/model/Error;", "getError", "()Lcom/avito/android/remote/model/Error;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Error;", "error", "<init>", "(Lcom/avito/android/remote/model/Error;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ForbiddenException extends Exception implements ErrorContainer {
    public final Error a;

    public ForbiddenException(@NotNull Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = error;
    }

    @Override // com.avito.android.remote.error.ErrorContainer
    @NotNull
    public Error getError() {
        return this.a;
    }
}

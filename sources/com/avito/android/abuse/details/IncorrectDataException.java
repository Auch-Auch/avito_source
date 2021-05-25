package com.avito.android.abuse.details;

import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u000b\u0010\fR%\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/abuse/details/IncorrectDataException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getErrors", "()Ljava/util/Map;", "errors", "<init>", "(Ljava/util/Map;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class IncorrectDataException extends Exception {
    @NotNull
    public final Map<Long, String> a;

    public IncorrectDataException(@NotNull Map<Long, String> map) {
        Intrinsics.checkNotNullParameter(map, "errors");
        this.a = map;
    }

    @NotNull
    public final Map<Long, String> getErrors() {
        return this.a;
    }
}

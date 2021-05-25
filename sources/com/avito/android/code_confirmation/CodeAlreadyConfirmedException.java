package com.avito.android.code_confirmation;

import com.avito.android.code_confirmation.model.ConfirmedCodeInfo;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/code_confirmation/CodeAlreadyConfirmedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", "getInfo", "()Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", "info", "<init>", "(Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class CodeAlreadyConfirmedException extends Exception {
    @NotNull
    public final ConfirmedCodeInfo a;

    public CodeAlreadyConfirmedException(@NotNull ConfirmedCodeInfo confirmedCodeInfo) {
        Intrinsics.checkNotNullParameter(confirmedCodeInfo, "info");
        this.a = confirmedCodeInfo;
    }

    @NotNull
    public final ConfirmedCodeInfo getInfo() {
        return this.a;
    }
}

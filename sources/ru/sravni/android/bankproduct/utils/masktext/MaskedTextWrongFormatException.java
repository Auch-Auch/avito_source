package ru.sravni.android.bankproduct.utils.masktext;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lru/sravni/android/bankproduct/utils/masktext/MaskedTextWrongFormatException;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMask", "()Ljava/lang/String;", "mask", AuthSource.BOOKING_ORDER, "getText", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MaskedTextWrongFormatException extends Throwable {
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    public MaskedTextWrongFormatException(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "mask");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        this.a = str;
        this.b = str2;
    }

    @NotNull
    public final String getMask() {
        return this.a;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }
}

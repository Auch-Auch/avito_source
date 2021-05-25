package ru.sravni.android.bankproduct.utils.error;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.bumptech.glide.load.engine.GlideException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
import ru.sravni.android.bankproduct.utils.keyboard.KeyboardError;
import ru.sravni.android.bankproduct.utils.keyboard.UnknownKeyboardTypeError;
import ru.sravni.android.bankproduct.utils.masktext.MaskedTextWrongFormatException;
import ru.sravni.android.bankproduct.utils.svg.NullGlideExceptionError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/utils/error/UtilErrorDescriptionMapper;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableErrorDescriptionMapper;", "", "throwable", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "mapToError", "(Ljava/lang/Throwable;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDomain", "()Ljava/lang/String;", "domain", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class UtilErrorDescriptionMapper implements IThrowableErrorDescriptionMapper {
    @NotNull
    public final String a = "UT";

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper
    @NotNull
    public String getDomain() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper
    @Nullable
    public ErrorDescription mapToError(@NotNull Throwable th) {
        ErrorDescription errorDescription;
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        if (th instanceof MaskedTextWrongFormatException) {
            MaskedTextWrongFormatException maskedTextWrongFormatException = (MaskedTextWrongFormatException) th;
            return UtilErrorDescriptionMapperKt.access$maskTextErrorDescription(maskedTextWrongFormatException.getMask(), maskedTextWrongFormatException.getText());
        } else if (th instanceof KeyboardError) {
            return new ErrorDescription(33, "UNKS", "Unknown keyboard signal", null, 8, null);
        } else {
            if (th instanceof GlideException) {
                return new ErrorDescription(40, "GlErr", "Glide load svg fail", null, 8, null);
            }
            if (th instanceof NullGlideExceptionError) {
                StringBuilder L = a.L("Glide load svg fail with null exception for url ");
                L.append(((NullGlideExceptionError) th).getUrl());
                errorDescription = new ErrorDescription(41, "GlNullErr", L.toString(), null, 8, null);
            } else if (!(th instanceof UnknownKeyboardTypeError)) {
                return null;
            } else {
                StringBuilder L2 = a.L("Unknown keyboard type ");
                L2.append(((UnknownKeyboardTypeError) th).getKeyboardType());
                errorDescription = new ErrorDescription(50, "UnKeType", L2.toString(), null, 8, null);
            }
            return errorDescription;
        }
    }
}

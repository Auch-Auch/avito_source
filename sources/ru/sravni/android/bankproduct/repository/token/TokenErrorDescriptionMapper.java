package ru.sravni.android.bankproduct.repository.token;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/repository/token/TokenErrorDescriptionMapper;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableErrorDescriptionMapper;", "", "throwable", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "mapToError", "(Ljava/lang/Throwable;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDomain", "()Ljava/lang/String;", "domain", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenErrorDescriptionMapper implements IThrowableErrorDescriptionMapper {
    @NotNull
    public final String a = "TOKREF";

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper
    @NotNull
    public String getDomain() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper
    @Nullable
    public ErrorDescription mapToError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        if (th instanceof SravniError) {
            th = ((SravniError) th).getError();
        }
        boolean z = th instanceof HttpException;
        if (z && ((HttpException) th).code() == HttpResponseStatus.TOKEN_EXPIRE.getCode()) {
            return TokenErrorDescriptionMapperKt.d;
        }
        if (z) {
            HttpResponseStatus.Companion companion = HttpResponseStatus.Companion;
            HttpException httpException = (HttpException) th;
            if (companion.getUnauthorizedCodes().contains(Integer.valueOf(httpException.code()))) {
                return TokenErrorDescriptionMapperKt.access$getUnauthDescription(companion.fromCode(httpException.code()));
            }
        }
        if (z) {
            HttpResponseStatus.Companion companion2 = HttpResponseStatus.Companion;
            HttpException httpException2 = (HttpException) th;
            if (companion2.getUnavailableCodes().contains(Integer.valueOf(httpException2.code()))) {
                return TokenErrorDescriptionMapperKt.access$getUnavailableDescription(companion2.fromCode(httpException2.code()));
            }
        }
        if (z) {
            return TokenErrorDescriptionMapperKt.access$getUnknownHttpResponseDescription(((HttpException) th).code());
        }
        if (th instanceof NullTokenAndErrorInContainerException) {
            return TokenErrorDescriptionMapperKt.c;
        }
        if (th instanceof NullTokenWhenTryRefreshTokenException) {
            return TokenErrorDescriptionMapperKt.b;
        }
        if (th instanceof NullTokenWhenTryAuthedRequestException) {
            return TokenErrorDescriptionMapperKt.a;
        }
        return TokenErrorDescriptionMapperKt.e;
    }
}

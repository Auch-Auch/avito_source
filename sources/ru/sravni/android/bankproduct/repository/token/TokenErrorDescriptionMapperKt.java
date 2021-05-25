package ru.sravni.android.bankproduct.repository.token;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\f\"\u0016\u0010\u0003\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0005\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0002\"\u0016\u0010\u0007\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0002\"\u0016\u0010\t\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0002\"\u0016\u0010\u000b\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0002¨\u0006\f"}, d2 = {"Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "e", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "unsupportedAuthErrorDescription", "c", "nullTokenAndErrorInContainerDescription", AuthSource.BOOKING_ORDER, "nullTokenWhileRefreshTokenDescription", "d", "expiredTokenDescription", AuthSource.SEND_ABUSE, "nullTokenWhenTryAuthedQuerryDescription", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class TokenErrorDescriptionMapperKt {
    public static final ErrorDescription a = new ErrorDescription(11, "TokenEmpty", "Refresh request with null access token", null, 8, null);
    public static final ErrorDescription b = new ErrorDescription(12, "TokenEmpty", "Empty token while refresh token.", null, 8, null);
    public static final ErrorDescription c = new ErrorDescription(20, "UnexpSit", "Impossible situation. Null in token and in error in refreshChannel data container.", null, 8, null);
    public static final ErrorDescription d = new ErrorDescription(HttpResponseStatus.TOKEN_EXPIRE.getCode(), "AuthErr", "Token expired", null, 8, null);
    public static final ErrorDescription e = new ErrorDescription(520, "AuthErr", "Undefined auth error", null, 8, null);

    public static final ErrorDescription access$getUnauthDescription(HttpResponseStatus httpResponseStatus) {
        return new ErrorDescription(httpResponseStatus.getCode(), "AuthErr", "User unauthorized", null, 8, null);
    }

    public static final ErrorDescription access$getUnavailableDescription(HttpResponseStatus httpResponseStatus) {
        return new ErrorDescription(httpResponseStatus.getCode(), "AuthErr", "Service unavailable", null, 8, null);
    }

    public static final ErrorDescription access$getUnknownHttpResponseDescription(int i) {
        return new ErrorDescription(i, "AuthErr", a.M2("UnknownHttpResponse with code ", i), null, 8, null);
    }
}

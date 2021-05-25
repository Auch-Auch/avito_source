package ru.sravni.android.bankproduct.network;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/network/NetworkErrorDescriptionMapper;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableErrorDescriptionMapper;", "", "throwable", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "mapToError", "(Ljava/lang/Throwable;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDomain", "()Ljava/lang/String;", "domain", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class NetworkErrorDescriptionMapper implements IThrowableErrorDescriptionMapper {
    @NotNull
    public final String a = "NE";

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper
    @NotNull
    public String getDomain() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper
    @Nullable
    public ErrorDescription mapToError(@NotNull Throwable th) {
        Response raw;
        Request request;
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        HttpUrl httpUrl = null;
        if (th instanceof SocketTimeoutException) {
            return new ErrorDescription(2, "Timeout", "Timeout error", null, 8, null);
        }
        if (!(th instanceof HttpException)) {
            return null;
        }
        StringBuilder L = a.L("HttpException for ");
        HttpException httpException = (HttpException) th;
        retrofit2.Response<?> response = httpException.response();
        if (!(response == null || (raw = response.raw()) == null || (request = raw.request()) == null)) {
            httpUrl = request.url();
        }
        L.append(String.valueOf(httpUrl));
        return new ErrorDescription(3, L.toString(), String.valueOf(httpException.response()), null, 8, null);
    }
}

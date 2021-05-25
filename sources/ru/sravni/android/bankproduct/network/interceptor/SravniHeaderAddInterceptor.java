package ru.sravni.android.bankproduct.network.interceptor;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.AppBuildInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/network/interceptor/SravniHeaderAddInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lru/sravni/android/bankproduct/domain/AppBuildInfo;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/AppBuildInfo;", "getPhoneInfo", "()Lru/sravni/android/bankproduct/domain/AppBuildInfo;", "phoneInfo", "<init>", "(Lru/sravni/android/bankproduct/domain/AppBuildInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SravniHeaderAddInterceptor implements Interceptor {
    @NotNull
    public final AppBuildInfo a;

    public SravniHeaderAddInterceptor(@NotNull AppBuildInfo appBuildInfo) {
        Intrinsics.checkParameterIsNotNull(appBuildInfo, "phoneInfo");
        this.a = appBuildInfo;
    }

    @NotNull
    public final AppBuildInfo getPhoneInfo() {
        return this.a;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Request.Builder addHeader = chain.request().newBuilder().addHeader("Sravni-User-Agent", this.a.getAuthClientAgent()).addHeader("Sravni-Device", this.a.getDeviceModel()).addHeader("Sravni-OSVersion", this.a.getOsVersion());
        return chain.proceed(addHeader.addHeader("Sravni-AppVersion", this.a.getAppVersion() + "(" + this.a.getCodeVersion() + ")").build());
    }
}

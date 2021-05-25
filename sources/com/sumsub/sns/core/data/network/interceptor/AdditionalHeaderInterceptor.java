package com.sumsub.sns.core.data.network.interceptor;

import android.os.Build;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.data.source.settings.SettingsRepository;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/sumsub/sns/core/data/network/interceptor/AdditionalHeaderInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getDeviceId", "()Ljava/lang/String;", "deviceId", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "repository", "<init>", "(Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdditionalHeaderInterceptor implements Interceptor {
    public final Lazy a = c.lazy(new a(this));
    public final SettingsRepository b;

    public static final class a extends Lambda implements Function0<String> {
        public final /* synthetic */ AdditionalHeaderInterceptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdditionalHeaderInterceptor additionalHeaderInterceptor) {
            super(0);
            this.a = additionalHeaderInterceptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            return this.a.b.getDeviceId();
        }
    }

    public AdditionalHeaderInterceptor(@NotNull SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(settingsRepository, "repository");
        this.b = settingsRepository;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public synchronized Response intercept(@NotNull Interceptor.Chain chain) {
        Response proceed;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder addHeader = chain.request().newBuilder().addHeader(SNSConstants.Header.APPLICANT_ID, this.b.getApplicantId());
        SNSMobileSDK sNSMobileSDK = SNSMobileSDK.INSTANCE;
        Request.Builder addHeader2 = addHeader.addHeader(SNSConstants.Header.MOBILE_APPLICATION, sNSMobileSDK.getPackageName());
        proceed = chain.proceed(addHeader2.addHeader(SNSConstants.Header.MOBILE_APPLICATION_VERSION, sNSMobileSDK.getVersionName() + "/" + sNSMobileSDK.getVersionCode()).addHeader(SNSConstants.Header.MOBILE_DEVICE, ExtensionsKt.getDeviceName()).addHeader(SNSConstants.Header.MOBILE_DEVICE_ID, (String) this.a.getValue()).addHeader(SNSConstants.Header.MOBILE_SDK_VERSION, "1.17.1").addHeader(SNSConstants.Header.MOBILE_SDK_LOCALE, sNSMobileSDK.getLocale().toString()).addHeader(SNSConstants.Header.MOBILE_OS, SNSConstants.PLATFORM).addHeader(SNSConstants.Header.MOBILE_OS_VERSION, Build.VERSION.RELEASE).addHeader(SNSConstants.Header.CLIENT_ID, SNSConstants.CLIENT_ID).addHeader(SNSConstants.Header.DEBUG, String.valueOf(sNSMobileSDK.isDebug())).addHeader(SNSConstants.Header.MOBILE_FINGERPRINT, (String) this.a.getValue()).build());
        Intrinsics.checkNotNullExpressionValue(proceed, "chain.proceed(request)");
        return proceed;
    }
}

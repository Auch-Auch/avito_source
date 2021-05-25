package com.sumsub.sns.core.data.adapter.network;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.common.StringRepository;
import com.sumsub.sns.core.data.model.SNSException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0004B1\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00028\u00010\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b%\u0010&J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u0016\u0012\f\u0012\n \r*\u0004\u0018\u00018\u00008\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00028\u00010\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/sumsub/sns/core/data/adapter/network/ApiResponseCall;", "", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "Lretrofit2/Call;", "Lretrofit2/Callback;", "callback", "", "enqueue", "(Lretrofit2/Callback;)V", "", "isExecuted", "()Z", "kotlin.jvm.PlatformType", "clone", "()Lcom/sumsub/sns/core/data/adapter/network/ApiResponseCall;", "isCanceled", "cancel", "()V", "Lretrofit2/Response;", "execute", "()Lretrofit2/Response;", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "Lcom/sumsub/sns/core/common/StringRepository;", "c", "Lcom/sumsub/sns/core/common/StringRepository;", "errors", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", AuthSource.BOOKING_ORDER, "Lretrofit2/Converter;", "errorConverter", AuthSource.SEND_ABUSE, "Lretrofit2/Call;", "delegate", "<init>", "(Lretrofit2/Call;Lretrofit2/Converter;Lcom/sumsub/sns/core/common/StringRepository;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ApiResponseCall<S, E> implements Call<S> {
    public final Call<S> a;
    public final Converter<ResponseBody, E> b;
    public final StringRepository c;

    public ApiResponseCall(@NotNull Call<S> call, @NotNull Converter<ResponseBody, E> converter, @NotNull StringRepository stringRepository) {
        Intrinsics.checkNotNullParameter(call, "delegate");
        Intrinsics.checkNotNullParameter(converter, "errorConverter");
        Intrinsics.checkNotNullParameter(stringRepository, "errors");
        this.a = call;
        this.b = converter;
        this.c = stringRepository;
    }

    @Override // retrofit2.Call
    public void cancel() {
        this.a.cancel();
    }

    @Override // retrofit2.Call
    public void enqueue(@NotNull Callback<S> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.a.enqueue(new Callback<S>(this, callback) { // from class: com.sumsub.sns.core.data.adapter.network.ApiResponseCall$enqueue$1
            public final /* synthetic */ ApiResponseCall a;
            public final /* synthetic */ Callback b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // retrofit2.Callback
            public void onFailure(@NotNull Call<S> call, @NotNull Throwable th) {
                Throwable th2;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(th, "throwable");
                if (th instanceof IOException) {
                    th2 = new SNSException.Network(th);
                } else {
                    th2 = new SNSException.Unknown(th);
                }
                this.b.onFailure(this.a, th2);
            }

            /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x007c  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x0098  */
            @Override // retrofit2.Callback
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(@org.jetbrains.annotations.NotNull retrofit2.Call<S> r7, @org.jetbrains.annotations.NotNull retrofit2.Response<S> r8) {
                /*
                    r6 = this;
                    java.lang.String r0 = "call"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    java.lang.String r7 = "response"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
                    java.lang.Object r7 = r8.body()
                    okhttp3.ResponseBody r0 = r8.errorBody()
                    boolean r8 = r8.isSuccessful()
                    if (r8 == 0) goto L_0x0025
                    retrofit2.Callback r8 = r6.b
                    com.sumsub.sns.core.data.adapter.network.ApiResponseCall r0 = r6.a
                    retrofit2.Response r7 = retrofit2.Response.success(r7)
                    r8.onResponse(r0, r7)
                    goto L_0x00a6
                L_0x0025:
                    r7 = 0
                    if (r0 != 0) goto L_0x002a
                L_0x0028:
                    r8 = r7
                    goto L_0x003f
                L_0x002a:
                    long r1 = r0.contentLength()
                    r3 = 0
                    int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                    if (r8 != 0) goto L_0x0035
                    goto L_0x0028
                L_0x0035:
                    com.sumsub.sns.core.data.adapter.network.ApiResponseCall r8 = r6.a     // Catch:{ Exception -> 0x0028 }
                    retrofit2.Converter r8 = com.sumsub.sns.core.data.adapter.network.ApiResponseCall.access$getErrorConverter$p(r8)     // Catch:{ Exception -> 0x0028 }
                    java.lang.Object r8 = r8.convert(r0)     // Catch:{ Exception -> 0x0028 }
                L_0x003f:
                    boolean r0 = r8 instanceof com.sumsub.sns.core.data.model.remote.response.ApiErrorResponse
                    if (r0 == 0) goto L_0x0098
                    com.sumsub.sns.core.data.model.remote.response.ApiErrorResponse r8 = (com.sumsub.sns.core.data.model.remote.response.ApiErrorResponse) r8
                    java.lang.String r0 = r8.getErrorName()
                    if (r0 == 0) goto L_0x0061
                    com.sumsub.sns.core.data.adapter.network.ApiResponseCall r1 = r6.a
                    com.sumsub.sns.core.common.StringRepository r1 = com.sumsub.sns.core.data.adapter.network.ApiResponseCall.access$getErrors$p(r1)
                    java.lang.CharSequence r0 = r1.getText(r0)
                    if (r0 == 0) goto L_0x005c
                    java.lang.String r0 = r0.toString()
                    goto L_0x005d
                L_0x005c:
                    r0 = r7
                L_0x005d:
                    if (r0 == 0) goto L_0x0061
                    r7 = r0
                    goto L_0x0079
                L_0x0061:
                    com.sumsub.sns.core.data.adapter.network.ApiResponseCall r0 = r6.a
                    com.sumsub.sns.core.common.StringRepository r0 = com.sumsub.sns.core.data.adapter.network.ApiResponseCall.access$getErrors$p(r0)
                    java.lang.Integer r1 = r8.getErrorCode()
                    java.lang.String r1 = java.lang.String.valueOf(r1)
                    java.lang.CharSequence r0 = r0.getText(r1)
                    if (r0 == 0) goto L_0x0079
                    java.lang.String r7 = r0.toString()
                L_0x0079:
                    if (r7 == 0) goto L_0x007c
                    goto L_0x0080
                L_0x007c:
                    java.lang.String r7 = r8.getDescription()
                L_0x0080:
                    r1 = r7
                    com.sumsub.sns.core.data.model.SNSException$Api r7 = new com.sumsub.sns.core.data.model.SNSException$Api
                    java.lang.Integer r2 = r8.getCode()
                    java.lang.String r3 = r8.getCorrelationId()
                    java.lang.Integer r4 = r8.getErrorCode()
                    java.lang.String r5 = r8.getErrorName()
                    r0 = r7
                    r0.<init>(r1, r2, r3, r4, r5)
                    goto L_0x009f
                L_0x0098:
                    com.sumsub.sns.core.data.model.SNSException$Unknown r8 = new com.sumsub.sns.core.data.model.SNSException$Unknown
                    r0 = 1
                    r8.<init>(r7, r0, r7)
                    r7 = r8
                L_0x009f:
                    retrofit2.Callback r8 = r6.b
                    com.sumsub.sns.core.data.adapter.network.ApiResponseCall r0 = r6.a
                    r8.onFailure(r0, r7)
                L_0x00a6:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.adapter.network.ApiResponseCall$enqueue$1.onResponse(retrofit2.Call, retrofit2.Response):void");
            }
        });
    }

    @Override // retrofit2.Call
    @NotNull
    public Response<S> execute() {
        throw new UnsupportedOperationException("ApiResponseCall doesn't support execute");
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        return this.a.isCanceled();
    }

    @Override // retrofit2.Call
    public boolean isExecuted() {
        return this.a.isExecuted();
    }

    @Override // retrofit2.Call
    @NotNull
    public Request request() {
        Request request = this.a.request();
        Intrinsics.checkNotNullExpressionValue(request, "delegate.request()");
        return request;
    }

    @Override // retrofit2.Call, java.lang.Object
    @NotNull
    public ApiResponseCall<S, E> clone() {
        Call<S> clone = this.a.clone();
        Intrinsics.checkNotNullExpressionValue(clone, "delegate.clone()");
        return new ApiResponseCall<>(clone, this.b, this.c);
    }
}

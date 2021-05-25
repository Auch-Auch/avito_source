package com.sumsub.sns.core.data.adapter.network;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.common.StringRepository;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004B+\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00010\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/sumsub/sns/core/data/adapter/network/ApiResponseAdapter;", "", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "Lretrofit2/CallAdapter;", "Lretrofit2/Call;", "Ljava/lang/reflect/Type;", "responseType", "()Ljava/lang/reflect/Type;", "call", "adapt", "(Lretrofit2/Call;)Lretrofit2/Call;", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", AuthSource.BOOKING_ORDER, "Lretrofit2/Converter;", "errorBodyConverter", "Lcom/sumsub/sns/core/common/StringRepository;", "c", "Lcom/sumsub/sns/core/common/StringRepository;", "errors", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Type;", "successType", "<init>", "(Ljava/lang/reflect/Type;Lretrofit2/Converter;Lcom/sumsub/sns/core/common/StringRepository;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ApiResponseAdapter<S, E> implements CallAdapter<S, Call<S>> {
    public final Type a;
    public final Converter<ResponseBody, E> b;
    public final StringRepository c;

    public ApiResponseAdapter(@NotNull Type type, @NotNull Converter<ResponseBody, E> converter, @NotNull StringRepository stringRepository) {
        Intrinsics.checkNotNullParameter(type, "successType");
        Intrinsics.checkNotNullParameter(converter, "errorBodyConverter");
        Intrinsics.checkNotNullParameter(stringRepository, "errors");
        this.a = type;
        this.b = converter;
        this.c = stringRepository;
    }

    @Override // retrofit2.CallAdapter
    @NotNull
    public Type responseType() {
        return this.a;
    }

    @Override // retrofit2.CallAdapter
    @NotNull
    public Call<S> adapt(@NotNull Call<S> call) {
        Intrinsics.checkNotNullParameter(call, "call");
        return new ApiResponseCall(call, this.b, this.c);
    }
}

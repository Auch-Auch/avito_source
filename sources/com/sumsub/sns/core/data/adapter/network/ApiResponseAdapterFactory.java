package com.sumsub.sns.core.data.adapter.network;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.reflect.TypeToken;
import com.sumsub.sns.core.common.StringRepository;
import com.sumsub.sns.core.data.model.remote.response.ApiErrorResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J8\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/data/adapter/network/ApiResponseAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "Ljava/lang/reflect/Type;", "returnType", "", "", "annotations", "Lretrofit2/Retrofit;", "retrofit", "Lretrofit2/CallAdapter;", "get", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "Lcom/sumsub/sns/core/common/StringRepository;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/common/StringRepository;", "errors", "<init>", "(Lcom/sumsub/sns/core/common/StringRepository;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ApiResponseAdapterFactory extends CallAdapter.Factory {
    public final StringRepository a;

    public ApiResponseAdapterFactory(@NotNull StringRepository stringRepository) {
        Intrinsics.checkNotNullParameter(stringRepository, "errors");
        this.a = stringRepository;
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(@NotNull Type type, @NotNull Annotation[] annotationArr, @NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "returnType");
        Intrinsics.checkNotNullParameter(annotationArr, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (!Intrinsics.areEqual(Call.class, CallAdapter.Factory.getRawType(type))) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
            Converter nextResponseBodyConverter = retrofit.nextResponseBodyConverter(null, new TypeToken<ApiErrorResponse>() { // from class: com.sumsub.sns.core.data.adapter.network.ApiResponseAdapterFactory$get$errorBodyType$1
            }.getType(), annotationArr);
            Intrinsics.checkNotNullExpressionValue(parameterUpperBound, "responseType");
            Intrinsics.checkNotNullExpressionValue(nextResponseBodyConverter, "errorBodyConverter");
            return new ApiResponseAdapter(parameterUpperBound, nextResponseBodyConverter, this.a);
        }
        throw new IllegalStateException("return type must be parameterized as Call<NetworkResponse<<Foo>> or Call<NetworkResponse<out Foo>>".toString());
    }
}

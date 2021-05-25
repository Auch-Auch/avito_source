package com.avito.android.remote.parse.adapter.stream_gson;

import com.avito.android.remote.auth.AuthSource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Converter;
import retrofit2.Retrofit;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJG\u0010\u000f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/GsonMigrationConverter;", "Lretrofit2/Converter$Factory;", "Ljava/lang/reflect/Type;", "type", "", "", "annotations", "Lretrofit2/Retrofit;", "retrofit", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "responseBodyConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "parameterAnnotations", "Lokhttp3/RequestBody;", "requestBodyConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", AuthSource.SEND_ABUSE, "Lretrofit2/Converter$Factory;", "gsonConverterFactory", "<init>", "(Lretrofit2/Converter$Factory;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class GsonMigrationConverter extends Converter.Factory {
    public final Converter.Factory a;

    public GsonMigrationConverter(@NotNull Converter.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "gsonConverterFactory");
        this.a = factory;
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public Converter<?, RequestBody> requestBodyConverter(@NotNull Type type, @NotNull Annotation[] annotationArr, @NotNull Annotation[] annotationArr2, @NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotationArr, "parameterAnnotations");
        Intrinsics.checkNotNullParameter(annotationArr2, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        int length = annotationArr2.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (Intrinsics.areEqual(JvmClassMappingKt.getAnnotationClass(annotationArr2[i]), Reflection.getOrCreateKotlinClass(StreamParsing.class))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return this.a.requestBodyConverter(type, annotationArr, annotationArr2, retrofit);
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public Converter<ResponseBody, ?> responseBodyConverter(@NotNull Type type, @NotNull Annotation[] annotationArr, @NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotationArr, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        int length = annotationArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (Intrinsics.areEqual(JvmClassMappingKt.getAnnotationClass(annotationArr[i]), Reflection.getOrCreateKotlinClass(StreamParsing.class))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return this.a.responseBodyConverter(type, annotationArr, retrofit);
        }
        return null;
    }
}

package com.avito.android.remote;

import androidx.annotation.VisibleForTesting;
import com.avito.android.Features;
import com.avito.android.remote.annotations.PretendError;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Throwables;
import com.google.gson.Gson;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.CallAdapter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002!\u0010B1\b\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010 J8\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/avito/android/remote/AvitoCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "Ljava/lang/reflect/Type;", "returnType", "", "", "annotations", "Lretrofit2/Retrofit;", "retrofit", "Lretrofit2/CallAdapter;", "get", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "e", "Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "resourceProvider", AuthSource.SEND_ABUSE, "Lretrofit2/CallAdapter$Factory;", "delegate", "Lcom/avito/android/util/BuildInfo;", "c", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/google/gson/Gson;", AuthSource.BOOKING_ORDER, "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "<init>", "(Lretrofit2/CallAdapter$Factory;Lcom/google/gson/Gson;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/Features;Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;)V", "Companion", "api_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoCallAdapterFactory extends CallAdapter.Factory {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final CallAdapter.Factory a;
    public final Gson b;
    public final BuildInfo c;
    public final Features d;
    public final CallAdapterFactoryResourceProvider e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/AvitoCallAdapterFactory$Companion;", "", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "resourceProvider", "Lcom/avito/android/remote/AvitoCallAdapterFactory;", "create", "(Lcom/google/gson/Gson;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/Features;Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;)Lcom/avito/android/remote/AvitoCallAdapterFactory;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final AvitoCallAdapterFactory create(@NotNull Gson gson, @NotNull BuildInfo buildInfo, @NotNull Features features, @NotNull CallAdapterFactoryResourceProvider callAdapterFactoryResourceProvider) {
            Intrinsics.checkNotNullParameter(gson, "gson");
            Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(callAdapterFactoryResourceProvider, "resourceProvider");
            RxJava3CallAdapterFactory create = RxJava3CallAdapterFactory.create();
            Intrinsics.checkNotNullExpressionValue(create, "delegate");
            return new AvitoCallAdapterFactory(create, gson, buildInfo, features, callAdapterFactoryResourceProvider);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<R> implements CallAdapter<R, Object> {
        public final CallAdapter<R, Object> a;
        public final Gson b;
        public final List<Annotation> c;
        @NotNull
        public BuildInfo d;
        @NotNull
        public Features e;
        public final CallAdapterFactoryResourceProvider f;

        /* renamed from: com.avito.android.remote.AvitoCallAdapterFactory$a$a  reason: collision with other inner class name */
        public interface AbstractC0154a {
            @NotNull
            Observable<Object> apply(@NotNull Observable<Object> observable);
        }

        public final class b implements AbstractC0154a {

            /* renamed from: com.avito.android.remote.AvitoCallAdapterFactory$a$b$a  reason: collision with other inner class name */
            public static final class C0155a<T, R> implements Function<Throwable, ObservableSource<? extends Object>> {
                public final /* synthetic */ b a;

                public C0155a(b bVar) {
                    this.a = bVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX WARNING: Removed duplicated region for block: B:26:0x009a  */
                /* JADX WARNING: Removed duplicated region for block: B:36:0x00bf  */
                @Override // io.reactivex.rxjava3.functions.Function
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public io.reactivex.rxjava3.core.ObservableSource<? extends java.lang.Object> apply(java.lang.Throwable r8) {
                    /*
                        r7 = this;
                        java.lang.Throwable r8 = (java.lang.Throwable) r8
                        com.avito.android.remote.AvitoCallAdapterFactory$a$b r0 = r7.a
                        java.lang.String r1 = "throwable"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
                        java.util.Objects.requireNonNull(r0)
                        java.lang.String r2 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
                        boolean r1 = r8 instanceof java.io.IOException
                        if (r1 == 0) goto L_0x001d
                        com.avito.android.util.NetworkException r0 = new com.avito.android.util.NetworkException
                        r0.<init>(r8)
                    L_0x001a:
                        r8 = r0
                        goto L_0x00dd
                    L_0x001d:
                        com.avito.android.remote.AvitoCallAdapterFactory$a r1 = com.avito.android.remote.AvitoCallAdapterFactory.a.this
                        java.util.Objects.requireNonNull(r1)
                        boolean r1 = r8 instanceof retrofit2.HttpException
                        java.lang.String r3 = "AvitoCallAdapterFactory"
                        if (r1 == 0) goto L_0x00d8
                        r1 = r8
                        java.lang.Exception r1 = (java.lang.Exception) r1
                        com.avito.android.remote.AvitoCallAdapterFactory$a r4 = com.avito.android.remote.AvitoCallAdapterFactory.a.this
                        retrofit2.Response r4 = com.avito.android.remote.AvitoCallAdapterFactory.a.a(r4, r1)
                        if (r4 == 0) goto L_0x00dd
                        okhttp3.ResponseBody r4 = r4.errorBody()
                        com.avito.android.remote.AvitoCallAdapterFactory$a r5 = com.avito.android.remote.AvitoCallAdapterFactory.a.this
                        java.util.Objects.requireNonNull(r5)
                        boolean r5 = r1 instanceof retrofit2.HttpException
                        if (r5 == 0) goto L_0x00cc
                        retrofit2.HttpException r1 = (retrofit2.HttpException) r1
                        int r1 = r1.code()
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        java.lang.String r5 = r4.string()     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        com.avito.android.remote.AvitoCallAdapterFactory$a r6 = com.avito.android.remote.AvitoCallAdapterFactory.a.this     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        boolean r6 = com.avito.android.remote.AvitoCallAdapterFactory.a.b(r6)     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        if (r6 == 0) goto L_0x0066
                        com.avito.android.remote.AvitoCallAdapterFactory$a r0 = com.avito.android.remote.AvitoCallAdapterFactory.a.this     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        com.google.gson.Gson r0 = r0.b     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        java.lang.Class<com.avito.android.remote.model.PretendResultErrorContainer> r6 = com.avito.android.remote.model.PretendResultErrorContainer.class
                        java.lang.Object r0 = r0.fromJson(r5, r6)     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        com.avito.android.remote.model.PretendResultErrorContainer r0 = (com.avito.android.remote.model.PretendResultErrorContainer) r0     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        com.avito.android.remote.model.PretendResultError r0 = r0.getError()     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        goto L_0x0093
                    L_0x0066:
                        com.avito.android.remote.AvitoCallAdapterFactory$a r0 = com.avito.android.remote.AvitoCallAdapterFactory.a.this     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        com.google.gson.Gson r0 = r0.b     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        java.lang.Class<com.avito.android.remote.model.ErrorContainer> r6 = com.avito.android.remote.model.ErrorContainer.class
                        java.lang.Object r0 = r0.fromJson(r5, r6)     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        com.avito.android.remote.model.ErrorContainer r0 = (com.avito.android.remote.model.ErrorContainer) r0     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        com.avito.android.remote.model.Error r0 = r0.getError()     // Catch:{ IOException -> 0x0085, Exception -> 0x0079 }
                        goto L_0x0093
                    L_0x0077:
                        r8 = move-exception
                        goto L_0x00c5
                    L_0x0079:
                        r0 = move-exception
                        java.lang.String r5 = "Unknown error"
                        com.avito.android.util.Logs.error(r3, r5, r0)     // Catch:{ all -> 0x0077 }
                        com.avito.android.remote.model.Error r0 = new com.avito.android.remote.model.Error     // Catch:{ all -> 0x0077 }
                        r0.<init>(r1, r2)     // Catch:{ all -> 0x0077 }
                        goto L_0x0090
                    L_0x0085:
                        r0 = move-exception
                        java.lang.String r5 = "parseError"
                        com.avito.android.util.Logs.error(r3, r5, r0)     // Catch:{ all -> 0x0077 }
                        com.avito.android.remote.model.Error r0 = new com.avito.android.remote.model.Error     // Catch:{ all -> 0x0077 }
                        r0.<init>(r1, r2)     // Catch:{ all -> 0x0077 }
                    L_0x0090:
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
                    L_0x0093:
                        r4.close()
                        r2 = 401(0x191, float:5.62E-43)
                        if (r1 == r2) goto L_0x00bf
                        r2 = 413(0x19d, float:5.79E-43)
                        if (r1 == r2) goto L_0x00b8
                        r8 = 403(0x193, float:5.65E-43)
                        if (r1 == r8) goto L_0x00b2
                        r8 = 404(0x194, float:5.66E-43)
                        if (r1 == r8) goto L_0x00ac
                        com.avito.android.util.AvitoResponseException r8 = new com.avito.android.util.AvitoResponseException
                        r8.<init>(r0)
                        goto L_0x00dd
                    L_0x00ac:
                        com.avito.android.util.NotFoundException r8 = new com.avito.android.util.NotFoundException
                        r8.<init>(r0)
                        goto L_0x00dd
                    L_0x00b2:
                        com.avito.android.util.ForbiddenException r8 = new com.avito.android.util.ForbiddenException
                        r8.<init>(r0)
                        goto L_0x00dd
                    L_0x00b8:
                        com.avito.android.util.EntityTooLargeException r0 = new com.avito.android.util.EntityTooLargeException
                        r0.<init>(r8)
                        goto L_0x001a
                    L_0x00bf:
                        com.avito.android.util.UnauthorizedException r8 = new com.avito.android.util.UnauthorizedException
                        r8.<init>()
                        goto L_0x00dd
                    L_0x00c5:
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
                        r4.close()
                        throw r8
                    L_0x00cc:
                        java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                        java.lang.String r0 = "Exception must be HttpException, but was "
                        java.lang.String r0 = a2.b.a.a.a.a3(r0, r1)
                        r8.<init>(r0)
                        throw r8
                    L_0x00d8:
                        java.lang.String r0 = "unknownError"
                        com.avito.android.util.Logs.error(r3, r0, r8)
                    L_0x00dd:
                        io.reactivex.rxjava3.core.Observable r8 = io.reactivex.rxjava3.core.Observable.error(r8)
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.AvitoCallAdapterFactory.a.b.C0155a.apply(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public b() {
            }

            @Override // com.avito.android.remote.AvitoCallAdapterFactory.a.AbstractC0154a
            @NotNull
            public Observable<Object> apply(@NotNull Observable<Object> observable) {
                Intrinsics.checkNotNullParameter(observable, "call");
                Observable<Object> onErrorResumeNext = observable.onErrorResumeNext(new C0155a(this));
                Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "call.onErrorResumeNext {…      )\n                }");
                return onErrorResumeNext;
            }
        }

        public final class c implements AbstractC0154a {

            /* renamed from: com.avito.android.remote.AvitoCallAdapterFactory$a$c$a  reason: collision with other inner class name */
            public static final class C0156a<T, R> implements Function<Throwable, ObservableSource<? extends Object>> {
                public final /* synthetic */ c a;

                public C0156a(c cVar) {
                    this.a = cVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.rxjava3.functions.Function
                public ObservableSource<? extends Object> apply(Throwable th) {
                    ErrorResult errorResult;
                    Throwable th2 = th;
                    c cVar = this.a;
                    Intrinsics.checkNotNullExpressionValue(th2, "throwable");
                    Objects.requireNonNull(cVar);
                    if (Throwables.isCertificatePinningError(th2)) {
                        errorResult = new ErrorResult.NetworkIOError(a.this.f.getUnsafeNetworkError());
                    } else if (Throwables.isNetworkProblem(th2)) {
                        errorResult = new ErrorResult.NetworkIOError(a.this.f.getNetworkUnavailableError());
                    } else if (th2 instanceof InvalidSchemaException) {
                        errorResult = cVar.a("Invalid parsing result", null, th2);
                    } else {
                        Objects.requireNonNull(a.this);
                        if (!(th2 instanceof HttpException)) {
                            errorResult = cVar.a("Unknown error", null, th2);
                        } else {
                            Objects.requireNonNull(th2, "null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */");
                            Response<?> a3 = a.a(a.this, (Exception) th2);
                            if (a3 != null) {
                                try {
                                    ResponseBody errorBody = a3.errorBody();
                                    if (errorBody != null) {
                                        Intrinsics.checkNotNullExpressionValue(errorBody, "response.errorBody() ?: …body is null\", throwable)");
                                        ErrorResult errorResult2 = (ErrorResult) a.this.b.fromJson(errorBody.string(), (Class<Object>) ErrorResult.class);
                                        if (errorResult2 != null) {
                                            if (errorResult2.getMessage().length() == 0) {
                                                errorResult = cVar.a("ErrorResult message must not be empty, got response: " + errorBody.string(), a3, th2);
                                            } else {
                                                errorResult = errorResult2;
                                            }
                                        } else {
                                            errorResult = cVar.a("Parsing json body error", null, th2);
                                        }
                                    } else {
                                        errorResult = cVar.a("Response body is null", null, th2);
                                    }
                                } catch (Exception e) {
                                    errorResult = cVar.a("Response body unexpected error", null, e);
                                }
                            } else {
                                errorResult = cVar.a("Response is null", null, th2);
                            }
                        }
                    }
                    return Observable.just(new TypedResult.OfError(errorResult));
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public c() {
            }

            public final ErrorResult a(String str, Response<?> response, Throwable th) {
                String str2;
                okhttp3.Response raw;
                Request request;
                HttpUrl url;
                if (response == null || (raw = response.raw()) == null || (request = raw.request()) == null || (url = request.url()) == null || (str2 = url.toString()) == null) {
                    str2 = "";
                }
                String str3 = str + "; request=" + str2 + "; " + th;
                if (!a.this.d.isDebug() || !a.this.e.getCrashOnIllegalBackendErrorsFormat().invoke().booleanValue()) {
                    return new ErrorResult.UnknownError(a.this.f.getUnknownError(), str3, th);
                }
                throw new UnknownError(str3);
            }

            @Override // com.avito.android.remote.AvitoCallAdapterFactory.a.AbstractC0154a
            @NotNull
            public Observable<Object> apply(@NotNull Observable<Object> observable) {
                Intrinsics.checkNotNullParameter(observable, "call");
                Observable<Object> onErrorResumeNext = observable.onErrorResumeNext(new C0156a(this));
                Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "call.onErrorResumeNext {…      )\n                }");
                return onErrorResumeNext;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends java.lang.annotation.Annotation> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull CallAdapter<R, Object> callAdapter, @NotNull Gson gson, @NotNull List<? extends Annotation> list, @NotNull BuildInfo buildInfo, @NotNull Features features, @NotNull CallAdapterFactoryResourceProvider callAdapterFactoryResourceProvider) {
            Intrinsics.checkNotNullParameter(callAdapter, "delegate");
            Intrinsics.checkNotNullParameter(gson, "gson");
            Intrinsics.checkNotNullParameter(list, "annotations");
            Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(callAdapterFactoryResourceProvider, "resourceProvider");
            this.a = callAdapter;
            this.b = gson;
            this.c = list;
            this.d = buildInfo;
            this.e = features;
            this.f = callAdapterFactoryResourceProvider;
        }

        public static final Response a(a aVar, Exception exc) {
            Objects.requireNonNull(aVar);
            if (exc instanceof HttpException) {
                return ((HttpException) exc).response();
            }
            throw new IllegalArgumentException(a2.b.a.a.a.a3("Exception must be HttpException, but was ", exc));
        }

        public static final boolean b(a aVar) {
            for (Annotation annotation : aVar.c) {
                if (Intrinsics.areEqual(JvmClassMappingKt.getAnnotationClass(annotation), Reflection.getOrCreateKotlinClass(PretendError.class))) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
        @Override // retrofit2.CallAdapter
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object adapt(@org.jetbrains.annotations.NotNull retrofit2.Call<R> r3) {
            /*
                r2 = this;
                java.lang.String r0 = "call"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                retrofit2.CallAdapter<R, java.lang.Object> r0 = r2.a
                java.lang.Object r3 = r0.adapt(r3)
                retrofit2.CallAdapter<R, java.lang.Object> r0 = r2.a
                java.lang.reflect.Type r0 = r0.responseType()
                java.lang.String r1 = "delegate.responseType()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                boolean r1 = r0 instanceof java.lang.reflect.ParameterizedType     // Catch:{ Exception -> 0x003a }
                if (r1 == 0) goto L_0x003a
                java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0     // Catch:{ Exception -> 0x003a }
                java.lang.reflect.Type r0 = r0.getRawType()     // Catch:{ Exception -> 0x003a }
                if (r0 == 0) goto L_0x0032
                java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ Exception -> 0x003a }
                java.lang.Class<com.avito.android.remote.model.TypedResult> r1 = com.avito.android.remote.model.TypedResult.class
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)     // Catch:{ Exception -> 0x003a }
                if (r0 == 0) goto L_0x003a
                com.avito.android.remote.AvitoCallAdapterFactory$a$c r0 = new com.avito.android.remote.AvitoCallAdapterFactory$a$c     // Catch:{ Exception -> 0x003a }
                r0.<init>()     // Catch:{ Exception -> 0x003a }
                goto L_0x003f
            L_0x0032:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x003a }
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.Class<*>"
                r0.<init>(r1)     // Catch:{ Exception -> 0x003a }
                throw r0     // Catch:{ Exception -> 0x003a }
            L_0x003a:
                com.avito.android.remote.AvitoCallAdapterFactory$a$b r0 = new com.avito.android.remote.AvitoCallAdapterFactory$a$b
                r0.<init>()
            L_0x003f:
                boolean r1 = r3 instanceof io.reactivex.rxjava3.core.Observable
                if (r1 == 0) goto L_0x004a
                io.reactivex.rxjava3.core.Observable r3 = (io.reactivex.rxjava3.core.Observable) r3
                io.reactivex.rxjava3.core.Observable r3 = r0.apply(r3)
                return r3
            L_0x004a:
                boolean r1 = r3 instanceof io.reactivex.rxjava3.core.Single
                if (r1 == 0) goto L_0x0067
                io.reactivex.rxjava3.core.Single r3 = (io.reactivex.rxjava3.core.Single) r3
                io.reactivex.rxjava3.core.Observable r3 = r3.toObservable()
                java.lang.String r1 = "null cannot be cast to non-null type io.reactivex.rxjava3.core.Observable<kotlin.Any>"
                java.util.Objects.requireNonNull(r3, r1)
                io.reactivex.rxjava3.core.Observable r3 = r0.apply(r3)
                io.reactivex.rxjava3.core.Single r3 = r3.firstOrError()
                java.lang.String r0 = "errorStrategy.apply(adap…able<Any>).firstOrError()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                return r3
            L_0x0067:
                java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
                java.lang.String r0 = "Only Observable and Single supported"
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.AvitoCallAdapterFactory.a.adapt(retrofit2.Call):java.lang.Object");
        }

        @Override // retrofit2.CallAdapter
        @NotNull
        public Type responseType() {
            Type responseType = this.a.responseType();
            Intrinsics.checkNotNullExpressionValue(responseType, "delegate.responseType()");
            return responseType;
        }
    }

    @VisibleForTesting
    public AvitoCallAdapterFactory(@NotNull CallAdapter.Factory factory, @NotNull Gson gson, @NotNull BuildInfo buildInfo, @NotNull Features features, @NotNull CallAdapterFactoryResourceProvider callAdapterFactoryResourceProvider) {
        Intrinsics.checkNotNullParameter(factory, "delegate");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(callAdapterFactoryResourceProvider, "resourceProvider");
        this.a = factory;
        this.b = gson;
        this.c = buildInfo;
        this.d = features;
        this.e = callAdapterFactoryResourceProvider;
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(@NotNull Type type, @NotNull Annotation[] annotationArr, @NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "returnType");
        Intrinsics.checkNotNullParameter(annotationArr, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        CallAdapter<?, ?> callAdapter = this.a.get(type, annotationArr, retrofit);
        if (callAdapter == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(callAdapter, "delegate[returnType, ann… retrofit] ?: return null");
        return new a(callAdapter, this.b, CollectionsKt__CollectionsKt.listOf((Object[]) ((Annotation[]) Arrays.copyOf(annotationArr, annotationArr.length))), this.c, this.d, this.e);
    }
}

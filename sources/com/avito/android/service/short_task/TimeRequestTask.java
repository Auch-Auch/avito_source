package com.avito.android.service.short_task;

import android.os.Bundle;
import com.avito.android.BaseApp;
import com.avito.android.Features;
import com.avito.android.di.CheckRequestDependencies;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.DaggerCheckRequestComponent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.short_task.ShortTask;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u00100\u001a\u00020+8\u0016@\u0016XD¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/avito/android/service/short_task/TimeRequestTask;", "Lcom/avito/android/service/short_task/ShortTask;", "Landroid/os/Bundle;", "bundle", "", "initialize", "(Landroid/os/Bundle;)V", "Lio/reactivex/Single;", "Lcom/avito/android/service/short_task/ShortTask$Status;", Tracker.Events.CREATIVE_START, "()Lio/reactivex/Single;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/service/short_task/ShortTask$NetworkState;", "c", "Lcom/avito/android/service/short_task/ShortTask$NetworkState;", "getRequiredNetworkState", "()Lcom/avito/android/service/short_task/ShortTask$NetworkState;", "requiredNetworkState", "Lokhttp3/OkHttpClient;", "httpClient", "Lokhttp3/OkHttpClient;", "getHttpClient", "()Lokhttp3/OkHttpClient;", "setHttpClient", "(Lokhttp3/OkHttpClient;)V", "", "Lokhttp3/Interceptor;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "requestInterceptors", "Lcom/avito/android/service/short_task/TimeDiffAnalyticsInterceptor;", "timeDiffAnalyticsInterceptor", "Lcom/avito/android/service/short_task/TimeDiffAnalyticsInterceptor;", "getTimeDiffAnalyticsInterceptor", "()Lcom/avito/android/service/short_task/TimeDiffAnalyticsInterceptor;", "setTimeDiffAnalyticsInterceptor", "(Lcom/avito/android/service/short_task/TimeDiffAnalyticsInterceptor;)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Lcom/avito/android/service/short_task/CheckCertPinningInterceptor;", "pinningInterceptor", "Lcom/avito/android/service/short_task/CheckCertPinningInterceptor;", "getPinningInterceptor", "()Lcom/avito/android/service/short_task/CheckCertPinningInterceptor;", "setPinningInterceptor", "(Lcom/avito/android/service/short_task/CheckCertPinningInterceptor;)V", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
public class TimeRequestTask implements ShortTask {
    public List<? extends Interceptor> a;
    @NotNull
    public final String b = TimeRequestTaskKt.CHECK_REQUEST_TASK;
    @NotNull
    public final ShortTask.NetworkState c = ShortTask.NetworkState.CONNECTED;
    @Inject
    public Features features;
    @Inject
    public OkHttpClient httpClient;
    @Inject
    public CheckCertPinningInterceptor pinningInterceptor;
    @Inject
    public TimeDiffAnalyticsInterceptor timeDiffAnalyticsInterceptor;

    public static final class a<V> implements Callable<Response> {
        public final /* synthetic */ OkHttpClient a;
        public final /* synthetic */ Request b;

        public a(OkHttpClient okHttpClient, Request request) {
            this.a = okHttpClient;
            this.b = request;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Response call() {
            return this.a.newCall(this.b).execute();
        }
    }

    public static final class b<T, R> implements Function<Response, ShortTask.Status> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ShortTask.Status apply(Response response) {
            Intrinsics.checkNotNullParameter(response, "it");
            return ShortTask.Status.SUCCESS;
        }
    }

    public static final class c<T, R> implements Function<Throwable, ShortTask.Status> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ShortTask.Status apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return ShortTask.Status.FAILED;
        }
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final OkHttpClient getHttpClient() {
        OkHttpClient okHttpClient = this.httpClient;
        if (okHttpClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("httpClient");
        }
        return okHttpClient;
    }

    @NotNull
    public final CheckCertPinningInterceptor getPinningInterceptor() {
        CheckCertPinningInterceptor checkCertPinningInterceptor = this.pinningInterceptor;
        if (checkCertPinningInterceptor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinningInterceptor");
        }
        return checkCertPinningInterceptor;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public ShortTask.NetworkState getRequiredNetworkState() {
        return this.c;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public String getTag() {
        return this.b;
    }

    @NotNull
    public final TimeDiffAnalyticsInterceptor getTimeDiffAnalyticsInterceptor() {
        TimeDiffAnalyticsInterceptor timeDiffAnalyticsInterceptor2 = this.timeDiffAnalyticsInterceptor;
        if (timeDiffAnalyticsInterceptor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeDiffAnalyticsInterceptor");
        }
        return timeDiffAnalyticsInterceptor2;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0033: APUT  
      (r4v5 okhttp3.Interceptor[])
      (0 ??[int, short, byte, char])
      (r0v6 com.avito.android.service.short_task.CheckCertPinningInterceptor)
     */
    @Override // com.avito.android.service.short_task.ShortTask
    public void initialize(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        DaggerCheckRequestComponent.builder().dependencies((CheckRequestDependencies) ComponentDependenciesKt.getDependencies(CheckRequestDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(BaseApp.Companion.getInstance()))).build().inject(this);
        Interceptor[] interceptorArr = new Interceptor[2];
        CheckCertPinningInterceptor checkCertPinningInterceptor = this.pinningInterceptor;
        if (checkCertPinningInterceptor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinningInterceptor");
        }
        interceptorArr[0] = checkCertPinningInterceptor;
        TimeDiffAnalyticsInterceptor timeDiffAnalyticsInterceptor2 = this.timeDiffAnalyticsInterceptor;
        if (timeDiffAnalyticsInterceptor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeDiffAnalyticsInterceptor");
        }
        interceptorArr[1] = timeDiffAnalyticsInterceptor2;
        this.a = CollectionsKt__CollectionsKt.listOf((Object[]) interceptorArr);
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setHttpClient(@NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "<set-?>");
        this.httpClient = okHttpClient;
    }

    public final void setPinningInterceptor(@NotNull CheckCertPinningInterceptor checkCertPinningInterceptor) {
        Intrinsics.checkNotNullParameter(checkCertPinningInterceptor, "<set-?>");
        this.pinningInterceptor = checkCertPinningInterceptor;
    }

    public final void setTimeDiffAnalyticsInterceptor(@NotNull TimeDiffAnalyticsInterceptor timeDiffAnalyticsInterceptor2) {
        Intrinsics.checkNotNullParameter(timeDiffAnalyticsInterceptor2, "<set-?>");
        this.timeDiffAnalyticsInterceptor = timeDiffAnalyticsInterceptor2;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public Single<ShortTask.Status> start() {
        OkHttpClient okHttpClient = this.httpClient;
        if (okHttpClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("httpClient");
        }
        OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
        List<? extends Interceptor> list = this.a;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestInterceptors");
        }
        for (Interceptor interceptor : list) {
            if (interceptor instanceof OkHttpPreparer) {
                ((OkHttpPreparer) interceptor).prepare(newBuilder);
            }
            newBuilder.addInterceptor(interceptor);
        }
        OkHttpClient build = newBuilder.build();
        StringBuilder sb = new StringBuilder();
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        Single<ShortTask.Status> firstOrError = Observable.fromCallable(new a(build, new Request.Builder().url(a2.b.a.a.a.t(sb, features2.getApiUrl().invoke(), "/2/time")).build())).map(b.a).onErrorReturn(c.a).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "fromCallable {\n         …          .firstOrError()");
        return firstOrError;
    }
}

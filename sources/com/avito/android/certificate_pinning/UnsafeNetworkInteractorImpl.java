package com.avito.android.certificate_pinning;

import com.avito.android.Features;
import com.avito.android.certificate_pinning.di.UnsafeNetworkModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.interceptor.CertificatePinningInterceptor;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.google.common.net.HttpHeaders;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import ru.ok.android.sdk.OkListener;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B<\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0013\b\u0001\u0010\u001b\u001a\r\u0012\t\u0012\u00070\u0017¢\u0006\u0002\b\u00180\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R!\u0010\u001b\u001a\r\u0012\t\u0012\u00070\u0017¢\u0006\u0002\b\u00180\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\f¨\u0006\""}, d2 = {"Lcom/avito/android/certificate_pinning/UnsafeNetworkInteractorImpl;", "Lcom/avito/android/certificate_pinning/UnsafeNetworkInteractor;", "Lio/reactivex/Single;", "Lcom/avito/android/certificate_pinning/NetworkState;", "checkNetworkState", "()Lio/reactivex/Single;", "", "isInsecure", "Lokhttp3/Request;", AuthSource.SEND_ABUSE, "(Z)Lokhttp3/Request;", "Lokhttp3/OkHttpClient;", "Lokhttp3/OkHttpClient;", "client", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "", "Lokhttp3/Interceptor;", "Lkotlin/jvm/JvmSuppressWildcards;", "d", "Ljava/util/Set;", "interceptors", AuthSource.BOOKING_ORDER, "clientWithoutPinning", "Ljavax/inject/Provider;", "httpClientProvider", "<init>", "(Lcom/avito/android/Features;Ljava/util/Set;Lcom/avito/android/util/SchedulersFactory;Ljavax/inject/Provider;)V", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
public final class UnsafeNetworkInteractorImpl implements UnsafeNetworkInteractor {
    public final OkHttpClient a;
    public final OkHttpClient b;
    public final Features c;
    public final Set<Interceptor> d;
    public final SchedulersFactory e;

    public static final class a<V> implements Callable<Response> {
        public final /* synthetic */ UnsafeNetworkInteractorImpl a;
        public final /* synthetic */ Request b;

        public a(UnsafeNetworkInteractorImpl unsafeNetworkInteractorImpl, Request request) {
            this.a = unsafeNetworkInteractorImpl;
            this.b = request;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Response call() {
            return this.a.b.newCall(this.b).execute();
        }
    }

    public static final class b<T, R> implements Function<Response, NetworkState> {
        public final /* synthetic */ Request a;

        public b(Request request) {
            this.a = request;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public NetworkState apply(Response response) {
            Response response2 = response;
            Intrinsics.checkNotNullParameter(response2, "it");
            String header$default = Response.header$default(response2, HttpHeaders.LOCATION, null, 2, null);
            boolean z = false;
            if (header$default != null) {
                if (header$default.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                String encodedPath = this.a.url().encodedPath();
                URI create = URI.create(header$default);
                Intrinsics.checkNotNullExpressionValue(create, "URI.create(redirectUrl)");
                if (!Intrinsics.areEqual(encodedPath, create.getPath())) {
                    return new NetworkState(1, header$default);
                }
            }
            return new NetworkState(0, null, 2, null);
        }
    }

    public static final class c<T, R> implements Function<Throwable, NetworkState> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public NetworkState apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, OkListener.KEY_EXCEPTION);
            if (th2 instanceof IOException) {
                return new NetworkState(3, null, 2, null);
            }
            return new NetworkState(4, null, 2, null);
        }
    }

    public static final class d<T, R> implements Function<NetworkState, SingleSource<? extends NetworkState>> {
        public final /* synthetic */ UnsafeNetworkInteractorImpl a;

        public d(UnsafeNetworkInteractorImpl unsafeNetworkInteractorImpl) {
            this.a = unsafeNetworkInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends NetworkState> apply(NetworkState networkState) {
            NetworkState networkState2 = networkState;
            Intrinsics.checkNotNullParameter(networkState2, "state");
            long state = networkState2.getState();
            if (state == 1 || state == 3) {
                return Singles.toSingle(networkState2);
            }
            Single<R> onErrorReturn = Single.fromCallable(new a2.a.a.d0.a(this)).map(new a2.a.a.d0.b(networkState2)).onErrorReturn(a2.a.a.d0.c.a);
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "Single.fromCallable { cl…                        }");
            return onErrorReturn;
        }
    }

    @Inject
    public UnsafeNetworkInteractorImpl(@NotNull Features features, @UnsafeNetworkModule.Silent @NotNull Set<Interceptor> set, @NotNull SchedulersFactory schedulersFactory, @NotNull Provider<OkHttpClient> provider) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(set, "interceptors");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(provider, "httpClientProvider");
        this.c = features;
        this.d = set;
        this.e = schedulersFactory;
        OkHttpClient.Builder newBuilder = provider.get().newBuilder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            newBuilder.addInterceptor(it.next());
        }
        this.a = newBuilder.build();
        OkHttpClient.Builder newBuilder2 = provider.get().newBuilder();
        newBuilder2.interceptors().clear();
        Set<Interceptor> set2 = this.d;
        ArrayList arrayList = new ArrayList();
        for (T t : set2) {
            if (!(t instanceof CertificatePinningInterceptor)) {
                arrayList.add(t);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            newBuilder2.addInterceptor((Interceptor) it2.next());
        }
        newBuilder2.followRedirects(false);
        this.b = newBuilder2.build();
    }

    public final Request a(boolean z) {
        return new Request.Builder().url(z ? "http://connectivitycheck.gstatic.com/generate_204" : a2.b.a.a.a.t(new StringBuilder(), m.replaceFirst$default(this.c.getApiUrl().invoke(), "http://", "https://", false, 4, (Object) null), "/2/time")).build();
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkInteractor
    @NotNull
    public Single<NetworkState> checkNetworkState() {
        Request a3 = a(true);
        return a2.b.a.a.a.V1(this.e, Single.fromCallable(new a(this, a3)).map(new b(a3)).onErrorReturn(c.a).flatMap(new d(this)), "Single.fromCallable { cl…scribeOn(schedulers.io())");
    }
}

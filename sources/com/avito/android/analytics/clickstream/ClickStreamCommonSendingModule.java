package com.avito.android.analytics.clickstream;

import com.avito.android.analytics.inhouse_transport.InHouseCommonSendingModule;
import com.avito.android.util.BuildInfo;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.protobuf.ProtoConverterFactory;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamCommonSendingModule;", "", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", "httpClient", "Lcom/avito/android/analytics/clickstream/ClickStreamApi;", "provideClickStreamApi", "(Lcom/avito/android/util/BuildInfo;Ldagger/Lazy;)Lcom/avito/android/analytics/clickstream/ClickStreamApi;", "<init>", "()V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {InHouseCommonSendingModule.class})
public final class ClickStreamCommonSendingModule {
    @NotNull
    public static final ClickStreamCommonSendingModule INSTANCE = new ClickStreamCommonSendingModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ClickStreamApi provideClickStreamApi(@NotNull BuildInfo buildInfo, @InHouseCommonSendingModule.InHouseHttpClient @NotNull Lazy<OkHttpClient> lazy) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(lazy, "httpClient");
        Retrofit.Builder callFactory = new Retrofit.Builder().baseUrl(buildInfo.isDebug() ? "https://prod-www.k.avito.ru/clickstream/events/" : "https://www.avito.ru/clickstream/events/").addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(ProtoConverterFactory.create()).callFactory(new Call.Factory(lazy) { // from class: com.avito.android.analytics.clickstream.ClickStreamCommonSendingModule$provideClickStreamApi$builder$1
            public final /* synthetic */ Lazy a;

            {
                this.a = r1;
            }

            @Override // okhttp3.Call.Factory
            @NotNull
            public Call newCall(@NotNull Request request) {
                Intrinsics.checkNotNullParameter(request, "request");
                return ((OkHttpClient) this.a.get()).newCall(request);
            }
        });
        if (buildInfo.isDebug()) {
            callFactory.validateEagerly(true);
        }
        Retrofit build = callFactory.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder\n            .build()");
        return (ClickStreamApi) build.create(ClickStreamApi.class);
    }
}

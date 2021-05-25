package com.avito.android.remote;

import com.avito.android.remote.config.AppConfig;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.ab_tests.AbTestsConfigResponse;
import com.avito.android.remote.parse.adapter.stream_gson.StreamParsing;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/ConfigApi;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/config/AppConfig;", "getConfig", "()Lio/reactivex/rxjava3/core/Observable;", "", "rotatable", "", "resolutionWidth", "resolutionHeight", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/ab_tests/AbTestsConfigResponse;", "fetchABTestsConfig", "(ZII)Lio/reactivex/rxjava3/core/Observable;", "config_release"}, k = 1, mv = {1, 4, 2})
public interface ConfigApi {
    @StreamParsing
    @GET("4/features")
    @NotNull
    @NetworkRequestEventId(eventId = 3650)
    Observable<TypedResult<AbTestsConfigResponse>> fetchABTestsConfig(@Query("rotatable") boolean z, @Query("resolutionWidth") int i, @Query("resolutionHeight") int i2);

    @GET("2/config/android")
    @NotNull
    @NetworkRequestEventId(eventId = 3620)
    @Headers({ConfigApiKt.UPDATE_DATE})
    Observable<AppConfig> getConfig();
}

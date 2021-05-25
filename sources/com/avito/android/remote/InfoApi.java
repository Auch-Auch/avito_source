package com.avito.android.remote;

import com.avito.android.remote.model.Info;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/InfoApi;", "", "", MessageMetaInfo.COLUMN_PATH, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/Info;", "getInfo", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "info_release"}, k = 1, mv = {1, 4, 2})
public interface InfoApi {
    @GET("2/info/{path}")
    @NotNull
    Observable<Info> getInfo(@Path("path") @NotNull String str);
}

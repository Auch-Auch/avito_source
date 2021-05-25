package com.avito.android.express_cv;

import com.avito.android.epress_cv.remote.model.CreateExpressCvResult;
import com.avito.android.epress_cv.remote.model.CvResult;
import com.avito.android.epress_cv.remote.model.ExpressCvInfo;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ7\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\bJ#\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\bJ\u001b\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u0004H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/express_cv/ExpressCvRepository;", "", "", "context", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/epress_cv/remote/model/ExpressCvInfo;", "getExpressCvInfo", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "params", "Lcom/avito/android/remote/model/PretendResult;", "validateParams", "(Ljava/util/Map;)Lio/reactivex/Observable;", "Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult$Ok;", "publishExpressCv", "(Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/Observable;", "id", "Lcom/avito/android/epress_cv/remote/model/CvResult;", "activateCv", "itemId", "getMessengerChannel", "disableExpressCv", "()Lio/reactivex/Observable;", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public interface ExpressCvRepository {
    @NotNull
    Observable<LoadingState<CvResult>> activateCv(@NotNull String str);

    @NotNull
    Observable<LoadingState<CvResult>> disableExpressCv();

    @NotNull
    Observable<LoadingState<ExpressCvInfo>> getExpressCvInfo(@NotNull String str);

    @NotNull
    Observable<LoadingState<String>> getMessengerChannel(@NotNull String str);

    @NotNull
    Observable<LoadingState<CreateExpressCvResult.Ok>> publishExpressCv(@NotNull Map<String, String> map, @NotNull String str);

    @NotNull
    Observable<PretendResult> validateParams(@NotNull Map<String, String> map);
}

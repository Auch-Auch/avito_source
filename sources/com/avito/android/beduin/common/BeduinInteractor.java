package com.avito.android.beduin.common;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.beduin.BeduinApi;
import com.avito.android.beduin.action.BeduinExecuteRequestAction;
import com.avito.android.beduin.model.BeduinActionsResponse;
import com.avito.android.beduin.model.BeduinComponentsResponse;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/beduin/common/BeduinInteractor;", "", "", "url", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/beduin/model/BeduinComponentsResponse;", "fetchData", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/beduin/action/BeduinExecuteRequestAction$HttpMethod;", "method", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/beduin/model/BeduinActionsResponse;", "executeRequest", "(Ljava/lang/String;Lcom/avito/android/beduin/action/BeduinExecuteRequestAction$HttpMethod;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Single;", "T", AuthSource.SEND_ABUSE, "(Lio/reactivex/rxjava3/core/Single;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/beduin/BeduinApi;", "Lcom/avito/android/beduin/BeduinApi;", "beduinApi", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/beduin/BeduinApi;Lcom/avito/android/util/SchedulersFactory3;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinInteractor {
    public final BeduinApi a;
    public final SchedulersFactory3 b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            BeduinExecuteRequestAction.HttpMethod.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            BeduinExecuteRequestAction.HttpMethod httpMethod = BeduinExecuteRequestAction.HttpMethod.POST;
            iArr[0] = 1;
            BeduinExecuteRequestAction.HttpMethod httpMethod2 = BeduinExecuteRequestAction.HttpMethod.GET;
            iArr[1] = 2;
            BeduinExecuteRequestAction.HttpMethod httpMethod3 = BeduinExecuteRequestAction.HttpMethod.DELETE;
            iArr[2] = 3;
            BeduinExecuteRequestAction.HttpMethod httpMethod4 = BeduinExecuteRequestAction.HttpMethod.PUT;
            iArr[3] = 4;
        }
    }

    @Inject
    public BeduinInteractor(@NotNull BeduinApi beduinApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(beduinApi, "beduinApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = beduinApi;
        this.b = schedulersFactory3;
    }

    public final <T> Single<T> a(Single<T> single) {
        Single<T> observeOn = single.subscribeOn(this.b.io()).observeOn(this.b.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "subscribeOn(schedulers.i…(schedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<TypedResult<BeduinActionsResponse>> executeRequest(@NotNull String str, @NotNull BeduinExecuteRequestAction.HttpMethod httpMethod, @Nullable Map<String, String> map) {
        Single<TypedResult<BeduinActionsResponse>> single;
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(httpMethod, "method");
        int ordinal = httpMethod.ordinal();
        if (ordinal == 0) {
            single = this.a.executePostRequest(str, map);
        } else if (ordinal == 1) {
            single = this.a.executeGetRequest(str);
        } else if (ordinal == 2) {
            single = this.a.executeDeleteRequest(str);
        } else if (ordinal == 3) {
            single = this.a.executePutRequest(str, map);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return a(single);
    }

    @NotNull
    public final Single<TypedResult<BeduinComponentsResponse>> fetchData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return a(this.a.getBeduinScreenContent(str));
    }
}

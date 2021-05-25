package com.avito.android.user_advert.limits_info;

import a2.b.a.a.a;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/user_advert/limits_info/LimitsInfoInteractorImpl;", "Lcom/avito/android/user_advert/limits_info/LimitsInfoInteractor;", "", "itemId", "Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/remote/model/LimitsInfo;", "loadLimitsInfo", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/PublishLimitsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/PublishLimitsApi;", "api", "<init>", "(Lcom/avito/android/remote/PublishLimitsApi;Lcom/avito/android/util/SchedulersFactory3;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class LimitsInfoInteractorImpl implements LimitsInfoInteractor {
    public final PublishLimitsApi a;
    public final SchedulersFactory3 b;

    @Inject
    public LimitsInfoInteractorImpl(@NotNull PublishLimitsApi publishLimitsApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(publishLimitsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = publishLimitsApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.user_advert.limits_info.LimitsInfoInteractor
    @NotNull
    public Maybe<LimitsInfo> loadLimitsInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Single flatMap = a.e2(this.b, this.a.getLimitsForItem(str), "api.getLimitsForItem(ite…scribeOn(schedulers.io())").flatMap(LimitsInfoInteractorImpl$loadLimitsInfo$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Maybe<LimitsInfo> onErrorComplete = flatMap.toMaybe().onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "api.getLimitsForItem(ite…       .onErrorComplete()");
        return onErrorComplete;
    }
}

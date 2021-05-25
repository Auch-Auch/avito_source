package com.avito.android.rating.publish.deal_stage;

import com.avito.android.rating.publish.deal_stage.adapter.DealStageItem;
import com.avito.android.rating.publish.deal_stage.adapter.stage.StageItem;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.publish.DealStage;
import com.avito.android.remote.model.publish.DealStagesResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/rating/publish/deal_stage/DealStageInteractorImpl;", "Lcom/avito/android/rating/publish/deal_stage/DealStageInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/rating/publish/deal_stage/adapter/DealStageItem;", "loadItems", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/rating/remote/RatingApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/remote/RatingApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/rating/remote/RatingApi;Lcom/avito/android/util/SchedulersFactory3;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class DealStageInteractorImpl implements DealStageInteractor {
    public final RatingApi a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<DealStagesResult, List<? extends DealStageItem>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends DealStageItem> apply(DealStagesResult dealStagesResult) {
            List<DealStage> stages = dealStagesResult.getStages();
            if (stages == null) {
                stages = CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(stages, 10));
            for (T t : stages) {
                arrayList.add(new StageItem(t.getId(), t, false));
            }
            return arrayList;
        }
    }

    @Inject
    public DealStageInteractorImpl(@NotNull RatingApi ratingApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(ratingApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = ratingApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.rating.publish.deal_stage.DealStageInteractor
    @NotNull
    public Observable<List<DealStageItem>> loadItems() {
        Observable<TypedResult<DealStagesResult>> subscribeOn = this.a.getDealStages().subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getDealStages()\n    …scribeOn(schedulers.io())");
        Observable<List<DealStageItem>> map = TypedObservablesKt.toTyped(subscribeOn).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getDealStages()\n    …          }\n            }");
        return map;
    }
}

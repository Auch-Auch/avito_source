package com.avito.android.user_stats.tab;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import com.avito.conveyor_item.Item;
import com.avito.user_stats.model.StatsData;
import com.avito.user_stats.model.UserStatsTabData;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabInteractorImpl;", "Lcom/avito/android/user_stats/tab/UserStatsTabInteractor;", "", FirebaseAnalytics.Param.INDEX, "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/conveyor_item/Item;", "createItemsForColumnIndex", "(I)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/user_stats/tab/UserStatsTemplateItemConverter;", "c", "Lcom/avito/android/user_stats/tab/UserStatsTemplateItemConverter;", "templateItemConverter", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/user_stats/model/UserStatsTabData;", AuthSource.BOOKING_ORDER, "Lcom/avito/user_stats/model/UserStatsTabData;", "tabModel", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/user_stats/model/UserStatsTabData;Lcom/avito/android/user_stats/tab/UserStatsTemplateItemConverter;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTabInteractorImpl implements UserStatsTabInteractor {
    public final SchedulersFactory3 a;
    public final UserStatsTabData b;
    public final UserStatsTemplateItemConverter c;

    public static final class a<V> implements Callable<List<? extends Item>> {
        public final /* synthetic */ UserStatsTabInteractorImpl a;
        public final /* synthetic */ int b;

        public a(UserStatsTabInteractorImpl userStatsTabInteractorImpl, int i) {
            this.a = userStatsTabInteractorImpl;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends Item> call() {
            return UserStatsTabInteractorImpl.access$getItems(this.a, this.b);
        }
    }

    @Inject
    public UserStatsTabInteractorImpl(@NotNull SchedulersFactory3 schedulersFactory3, @Nullable UserStatsTabData userStatsTabData, @NotNull UserStatsTemplateItemConverter userStatsTemplateItemConverter) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(userStatsTemplateItemConverter, "templateItemConverter");
        this.a = schedulersFactory3;
        this.b = userStatsTabData;
        this.c = userStatsTemplateItemConverter;
    }

    public static final List access$getItems(UserStatsTabInteractorImpl userStatsTabInteractorImpl, int i) {
        List<StatsData> data;
        UserStatsTabData userStatsTabData = userStatsTabInteractorImpl.b;
        if (userStatsTabData == null || (data = userStatsTabData.getData()) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return userStatsTabInteractorImpl.c.convert(data.get(i).getTemplate(), data, i);
    }

    @Override // com.avito.android.user_stats.tab.UserStatsTabInteractor
    @NotNull
    public Single<List<Item>> createItemsForColumnIndex(int i) {
        Single<List<Item>> subscribeOn = Single.fromCallable(new a(this, i)).subscribeOn(this.a.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Single\n            .from…schedulers.computation())");
        return subscribeOn;
    }
}

package com.avito.android.publish.details.tags;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.publish.BubbleSuggest;
import com.avito.android.remote.model.suggests.TitleSuggestsResponse;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedSingleKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/publish/details/tags/PublishTagsInteractorImpl;", "Lcom/avito/android/publish/details/tags/PublishTagsInteractor;", "", "query", "", "categoryId", "Lio/reactivex/Single;", "", "Lcom/avito/android/remote/model/publish/BubbleSuggest;", "loadSuggests", "(Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "c", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/remote/PublishApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/PublishApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishTagsInteractorImpl implements PublishTagsInteractor {
    public final PublishApi a;
    public final SchedulersFactory b;
    public final PublishAnalyticsDataProvider c;

    public static final class a<T, R> implements Function<TitleSuggestsResponse, List<? extends BubbleSuggest>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends BubbleSuggest> apply(TitleSuggestsResponse titleSuggestsResponse) {
            TitleSuggestsResponse titleSuggestsResponse2 = titleSuggestsResponse;
            Intrinsics.checkNotNullParameter(titleSuggestsResponse2, "it");
            return titleSuggestsResponse2.getList();
        }
    }

    public static final class b<T, R> implements Function<Throwable, List<? extends BubbleSuggest>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends BubbleSuggest> apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    @Inject
    public PublishTagsInteractorImpl(@NotNull PublishApi publishApi, @NotNull SchedulersFactory schedulersFactory, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(publishApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        this.a = publishApi;
        this.b = schedulersFactory;
        this.c = publishAnalyticsDataProvider;
    }

    @Override // com.avito.android.publish.details.tags.PublishTagsInteractor
    @NotNull
    public Single<List<BubbleSuggest>> loadSuggests(@NotNull String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "query");
        if (str.length() == 0) {
            Single<List<BubbleSuggest>> just = Single.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(emptyList())");
            return just;
        }
        Single subscribeOn = InteropKt.toV2(this.a.getTitleSuggest(str, this.c.getSessionId(), num)).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getTitleSuggest(\n   …scribeOn(schedulers.io())");
        Single<List<BubbleSuggest>> onErrorReturn = TypedSingleKt.toTyped(subscribeOn).map(a.a).onErrorReturn(b.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getTitleSuggest(\n   …emptyList()\n            }");
        return onErrorReturn;
    }
}

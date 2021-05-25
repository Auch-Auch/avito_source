package com.avito.android.publish_limits_info.history;

import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AdvertsHistory;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractorImpl;", "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractor;", "Lcom/avito/android/publish_limits_info/ItemId;", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/AdvertsHistory;", "getAdvertsHistory", "(Lcom/avito/android/publish_limits_info/ItemId;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/remote/PublishLimitsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/PublishLimitsApi;", "limitsApi", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/remote/PublishLimitsApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class PublishLimitsHistoryInteractorImpl implements PublishLimitsHistoryInteractor {
    public final PublishLimitsApi a;
    public final SchedulersFactory3 b;
    public final TypedErrorThrowableConverter c;

    public static final class a<T, R> implements Function<TypedResult<AdvertsHistory>, LoadingState<? super AdvertsHistory>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super AdvertsHistory> apply(TypedResult<AdvertsHistory> typedResult) {
            TypedResult<AdvertsHistory> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super AdvertsHistory>> {
        public final /* synthetic */ PublishLimitsHistoryInteractorImpl a;

        public b(PublishLimitsHistoryInteractorImpl publishLimitsHistoryInteractorImpl) {
            this.a = publishLimitsHistoryInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super AdvertsHistory> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public PublishLimitsHistoryInteractorImpl(@NotNull PublishLimitsApi publishLimitsApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(publishLimitsApi, "limitsApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = publishLimitsApi;
        this.b = schedulersFactory3;
        this.c = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.publish_limits_info.history.PublishLimitsHistoryInteractor
    @NotNull
    public Observable<LoadingState<AdvertsHistory>> getAdvertsHistory(@NotNull ItemId itemId) {
        Single<TypedResult<AdvertsHistory>> single;
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        if (itemId instanceof ItemId.Advert) {
            single = this.a.getLimitsHistoryForItem(((ItemId.Advert) itemId).getAdvertId());
        } else if (itemId instanceof ItemId.Draft) {
            single = this.a.getLimitsHistoryForDraft(((ItemId.Draft) itemId).getDraftId());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return a2.b.a.a.a.a2(this.b, single.map(a.a).toObservable().startWith(Observable.just(LoadingState.Loading.INSTANCE)).onErrorReturn(new b(this)), "when (itemId) {\n        …scribeOn(schedulers.io())");
    }
}

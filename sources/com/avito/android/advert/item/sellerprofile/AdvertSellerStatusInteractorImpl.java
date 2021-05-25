package com.avito.android.advert.item.sellerprofile;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.messenger.UserOnlineStatus;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Maybies;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert/item/sellerprofile/AdvertSellerStatusInteractorImpl;", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerStatusInteractor;", "", "sellerHashId", "", "initialStatus", "Lio/reactivex/rxjava3/core/Observable;", "observeSellerOnlineStatus", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/advert_details/remote/AdvertDetailsApi;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSellerStatusInteractorImpl implements AdvertSellerStatusInteractor {
    public final AdvertDetailsApi a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<Long, ObservableSource<? extends TypedResult<UserOnlineStatus>>> {
        public final /* synthetic */ AdvertSellerStatusInteractorImpl a;
        public final /* synthetic */ String b;

        public a(AdvertSellerStatusInteractorImpl advertSellerStatusInteractorImpl, String str) {
            this.a = advertSellerStatusInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends TypedResult<UserOnlineStatus>> apply(Long l) {
            return this.a.a.getUserOnlineStatus(this.b).subscribeOn(this.a.b.io()).onErrorResumeNext(a2.a.a.f.x.a0.a.a);
        }
    }

    public static final class b<T, R> implements Function<TypedResult<UserOnlineStatus>, MaybeSource<? extends Long>> {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MaybeSource<? extends Long> apply(TypedResult<UserOnlineStatus> typedResult) {
            TypedResult<UserOnlineStatus> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return Maybies.toMaybe(Long.valueOf(((UserOnlineStatus) ((TypedResult.OfResult) typedResult2).getResult()).getTimeDiff()));
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                StringBuilder L = a2.b.a.a.a.L("Online status request failed for id=");
                L.append(this.a);
                L.append(", error = ");
                L.append(((TypedResult.OfError) typedResult2).getError().getMessage());
                Logs.debug$default("AdvertSellerStatusInteractor", L.toString(), null, 4, null);
                return Maybe.empty();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T, R> implements Function<Long, Boolean> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Boolean apply(Long l) {
            Long l2 = l;
            Intrinsics.checkNotNullExpressionValue(l2, "timeDiff");
            long longValue = l2.longValue();
            return Boolean.valueOf(1 <= longValue && 150 >= longValue);
        }
    }

    @Inject
    public AdvertSellerStatusInteractorImpl(@NotNull AdvertDetailsApi advertDetailsApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(advertDetailsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = advertDetailsApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerStatusInteractor
    @NotNull
    public Observable<Boolean> observeSellerOnlineStatus(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "sellerHashId");
        Observable<R> skip = Observable.interval(30, 60, TimeUnit.SECONDS, this.b.computation()).switchMap(new a(this, str)).observeOn(this.b.computation()).flatMapMaybe(new b(str)).map(c.a).startWith(Observable.just(Boolean.valueOf(z))).distinctUntilChanged().skip(1);
        Intrinsics.checkNotNullExpressionValue(skip, "Observable.interval(\n   …ed()\n            .skip(1)");
        return skip;
    }
}

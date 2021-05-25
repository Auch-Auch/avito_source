package com.avito.android.abuse.category;

import com.avito.android.abuse.details.remote.AbuseApi;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.abuse.AbuseCategoriesResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/abuse/category/AbuseCategoryInteractorImpl;", "Lcom/avito/android/abuse/category/AbuseCategoryInteractor;", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/abuse/AbuseCategoriesResult;", "getAbuseCategories", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/abuse/details/remote/AbuseApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/abuse/details/remote/AbuseApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/abuse/details/remote/AbuseApi;Lcom/avito/android/util/SchedulersFactory3;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseCategoryInteractorImpl implements AbuseCategoryInteractor {
    public final AbuseApi a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<TypedResult<AbuseCategoriesResult>, ObservableSource<? extends AbuseCategoriesResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends AbuseCategoriesResult> apply(TypedResult<AbuseCategoriesResult> typedResult) {
            TypedResult<AbuseCategoriesResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            return TypedObservablesKt.toTypedObservable3(typedResult2);
        }
    }

    @Inject
    public AbuseCategoryInteractorImpl(@NotNull AbuseApi abuseApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(abuseApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = abuseApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryInteractor
    @NotNull
    public Observable<AbuseCategoriesResult> getAbuseCategories(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return a2.b.a.a.a.a2(this.b, this.a.getAbuseCategories(str).flatMap(a.a), "api.getAbuseCategories(a…scribeOn(schedulers.io())");
    }
}

package com.avito.android.fees.refactor;

import com.avito.android.fees.remote.FeesApi;
import com.avito.android.remote.FeesLoadingState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.OwnedPackage;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/fees/refactor/PackageApplyInteractorImpl;", "Lcom/avito/android/fees/refactor/PackageApplyInteractor;", "Lcom/avito/android/remote/model/OwnedPackage;", "ownedPackage", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/FeesLoadingState;", "applyPackage", "(Lcom/avito/android/remote/model/OwnedPackage;)Lio/reactivex/Observable;", "Lcom/avito/android/fees/remote/FeesApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/fees/remote/FeesApi;", "feesApi", "Lcom/avito/android/util/ErrorFormatter;", "d", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "itemId", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Ljava/lang/String;Lcom/avito/android/fees/remote/FeesApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class PackageApplyInteractorImpl implements PackageApplyInteractor {
    public final String a;
    public final FeesApi b;
    public final SchedulersFactory c;
    public final ErrorFormatter d;

    public static final class a<T, R> implements Function<SuccessResult, FeesLoadingState> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public FeesLoadingState apply(SuccessResult successResult) {
            Intrinsics.checkNotNullParameter(successResult, "it");
            return new FeesLoadingState.Success();
        }
    }

    public static final class b<T, R> implements Function<Throwable, FeesLoadingState> {
        public final /* synthetic */ PackageApplyInteractorImpl a;

        public b(PackageApplyInteractorImpl packageApplyInteractorImpl) {
            this.a = packageApplyInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.ErrorFormatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public FeesLoadingState apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new FeesLoadingState.Error(this.a.d.format(th2));
        }
    }

    public PackageApplyInteractorImpl(@NotNull String str, @NotNull FeesApi feesApi, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(feesApi, "feesApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        this.a = str;
        this.b = feesApi;
        this.c = schedulersFactory;
        this.d = errorFormatter;
    }

    @Override // com.avito.android.fees.refactor.PackageApplyInteractor
    @NotNull
    public Observable<FeesLoadingState> applyPackage(@NotNull OwnedPackage ownedPackage) {
        Intrinsics.checkNotNullParameter(ownedPackage, "ownedPackage");
        return a2.b.a.a.a.T1(this.c, InteropKt.toV2(this.b.applyItemFeesPackage(this.a, ownedPackage.getId())).subscribeOn(this.c.io()).map(a.a).startWith((Observable) new FeesLoadingState.Loading()).onErrorReturn(new b(this)), "feesApi.applyItemFeesPac…lersFactory.mainThread())");
    }
}

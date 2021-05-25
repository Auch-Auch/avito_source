package com.avito.android.fees;

import com.avito.android.fees.remote.FeesApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/fees/PackageFeeInteractorImpl;", "Lcom/avito/android/fees/PackageFeeInteractor;", "", "packageId", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "applyPackage", "(J)Lio/reactivex/Observable;", "Lcom/avito/android/fees/remote/FeesApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/fees/remote/FeesApi;", "api", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "itemId", "<init>", "(Lcom/avito/android/fees/remote/FeesApi;Ljava/lang/String;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class PackageFeeInteractorImpl implements PackageFeeInteractor {
    public final FeesApi a;
    public final String b;

    public PackageFeeInteractorImpl(@NotNull FeesApi feesApi, @NotNull String str) {
        Intrinsics.checkNotNullParameter(feesApi, "api");
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.a = feesApi;
        this.b = str;
    }

    @Override // com.avito.android.fees.PackageFeeInteractor
    @NotNull
    public Observable<SuccessResult> applyPackage(long j) {
        return InteropKt.toV2(this.a.applyItemFeesPackage(this.b, j));
    }
}

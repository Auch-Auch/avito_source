package com.avito.android.publish.cpa_tariff.data;

import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CpaContactInfoResponse;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/data/CpaTariffRepositoryImpl;", "Lcom/avito/android/publish/cpa_tariff/data/CpaTariffRepository;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/CpaContactInfoResponse;", "getContactInfo", "()Lio/reactivex/rxjava3/core/Observable;", "", "phone", "name", "", "requestCpaTariff", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/PublishApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/PublishApi;", "publishApi", "", AuthSource.SEND_ABUSE, "I", "categoryId", "<init>", "(ILcom/avito/android/remote/PublishApi;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CpaTariffRepositoryImpl implements CpaTariffRepository {
    public final int a;
    public final PublishApi b;

    @Inject
    public CpaTariffRepositoryImpl(int i, @NotNull PublishApi publishApi) {
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        this.a = i;
        this.b = publishApi;
    }

    @Override // com.avito.android.publish.cpa_tariff.data.CpaTariffRepository
    @NotNull
    public Observable<TypedResult<CpaContactInfoResponse>> getContactInfo() {
        return this.b.getContactInfo();
    }

    @Override // com.avito.android.publish.cpa_tariff.data.CpaTariffRepository
    @NotNull
    public Observable<TypedResult<Object>> requestCpaTariff(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str2, "name");
        return this.b.createCpaTariffRequest(str, str2, this.a);
    }
}

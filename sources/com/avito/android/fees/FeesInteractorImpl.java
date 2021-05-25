package com.avito.android.fees;

import android.os.Bundle;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertFeesResponse;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/fees/FeesInteractorImpl;", "Lcom/avito/android/fees/FeesInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/AdvertFeesResponse;", "getFees", "()Lio/reactivex/Observable;", "getItemFeesResponse", "()Lcom/avito/android/remote/model/AdvertFeesResponse;", "Landroid/os/Bundle;", "state", "", "onSaveState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/fees/remote/FeesApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/fees/remote/FeesApi;", "avitoApi", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/AdvertFeesResponse;", "itemFeesResponse", "", "c", "Ljava/lang/String;", "itemId", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "d", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "<init>", "(Lcom/avito/android/fees/remote/FeesApi;Ljava/lang/String;Landroid/os/Bundle;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class FeesInteractorImpl implements FeesInteractor {
    public volatile AdvertFeesResponse a;
    public final FeesApi b;
    public final String c;
    public final PublishAnalyticsDataProvider d;

    public static final class a<T> implements Consumer<AdvertFeesResponse> {
        public final /* synthetic */ FeesInteractorImpl a;

        public a(FeesInteractorImpl feesInteractorImpl) {
            this.a = feesInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AdvertFeesResponse advertFeesResponse) {
            this.a.a = advertFeesResponse;
        }
    }

    public FeesInteractorImpl(@NotNull FeesApi feesApi, @NotNull String str, @Nullable Bundle bundle, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(feesApi, "avitoApi");
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        this.b = feesApi;
        this.c = str;
        this.d = publishAnalyticsDataProvider;
        this.a = bundle != null ? (AdvertFeesResponse) bundle.getParcelable("key_interactor_response") : null;
    }

    @Override // com.avito.android.fees.FeesInteractor
    @NotNull
    public Observable<AdvertFeesResponse> getFees() {
        if (this.a != null) {
            Observable<AdvertFeesResponse> just = Observable.just(this.a);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(itemFeesResponse)");
            return just;
        }
        Observable<AdvertFeesResponse> doOnNext = InteropKt.toV2(this.b.getItemFees(this.c, this.d.getSessionId())).doOnNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "avitoApi.getItemFees(ite…sponse = it\n            }");
        return doOnNext;
    }

    @Override // com.avito.android.fees.FeesInteractor
    @Nullable
    public AdvertFeesResponse getItemFeesResponse() {
        return this.a;
    }

    @Override // com.avito.android.fees.FeesInteractor
    public void onSaveState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "state");
        if (this.a != null) {
            bundle.putParcelable("key_interactor_response", this.a);
        }
    }
}

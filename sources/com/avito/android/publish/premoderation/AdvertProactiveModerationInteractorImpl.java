package com.avito.android.publish.premoderation;

import a2.b.a.a.a;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.adverts.AdvertProactiveModerationResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish/premoderation/AdvertProactiveModerationInteractorImpl;", "Lcom/avito/android/publish/premoderation/AdvertProactiveModerationInteractor;", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult;", "checkAdvertProactiveModeration", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Lcom/avito/android/remote/model/Navigation;)Lio/reactivex/Observable;", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "d", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/PublishApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/PublishApi;", "api", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "c", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "<init>", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertProactiveModerationInteractorImpl implements AdvertProactiveModerationInteractor {
    public final PublishApi a;
    public final SchedulersFactory b;
    public final CategoryParametersConverter c;
    public final PublishAnalyticsDataProvider d;

    public AdvertProactiveModerationInteractorImpl(@NotNull PublishApi publishApi, @NotNull SchedulersFactory schedulersFactory, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(publishApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        this.a = publishApi;
        this.b = schedulersFactory;
        this.c = categoryParametersConverter;
        this.d = publishAnalyticsDataProvider;
    }

    @Override // com.avito.android.publish.premoderation.AdvertProactiveModerationInteractor
    @NotNull
    public Observable<AdvertProactiveModerationResult> checkAdvertProactiveModeration(@NotNull CategoryParameters categoryParameters, @NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        return a.S1(this.b, TypedObservablesKt.toTyped(InteropKt.toV2(this.a.checkAdvertProactiveModerationV4(this.c.convertToFieldMap(navigation), this.c.convertToFieldMap(categoryParameters.getParametersExceptOwnedBySlots()), this.d.getSessionId()))), "api.checkAdvertProactive…scribeOn(schedulers.io())");
    }
}

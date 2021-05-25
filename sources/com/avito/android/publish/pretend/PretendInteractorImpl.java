package com.avito.android.publish.pretend;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.validate_advert.remote.ValidateAdvertApi;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/publish/pretend/PretendInteractorImpl;", "Lcom/avito/android/publish/pretend/PretendInteractor;", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/PretendResult;", "validateData", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "c", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "Lcom/avito/android/validate_advert/remote/ValidateAdvertApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/validate_advert/remote/ValidateAdvertApi;", "validateAdvertApi", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "d", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/validate_advert/remote/ValidateAdvertApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/Features;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PretendInteractorImpl implements PretendInteractor {
    public final ValidateAdvertApi a;
    public final SchedulersFactory b;
    public final CategoryParametersConverter c;
    public final PublishAnalyticsDataProvider d;
    public final Features e;

    @Inject
    public PretendInteractorImpl(@NotNull ValidateAdvertApi validateAdvertApi, @NotNull SchedulersFactory schedulersFactory, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(validateAdvertApi, "validateAdvertApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = validateAdvertApi;
        this.b = schedulersFactory;
        this.c = categoryParametersConverter;
        this.d = publishAnalyticsDataProvider;
        this.e = features;
    }

    @Override // com.avito.android.publish.pretend.PretendInteractor
    @NotNull
    public Observable<PretendResult> validateData(@NotNull Navigation navigation, @NotNull CategoryParameters categoryParameters) {
        io.reactivex.rxjava3.core.Observable observable;
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
        if (this.e.getHtmlDescriptionOnPublish().invoke().booleanValue()) {
            observable = ValidateAdvertApi.DefaultImpls.validateNewAdvertParamsWithNavigation$default(this.a, this.c.convertToFieldMap(navigation), null, null, this.c.convertToFieldMap(categoryParameters.getParametersExceptOwnedBySlots()), this.d.getSessionId(), 6, null);
        } else {
            observable = ValidateAdvertApi.DefaultImpls.validateNewAdvertParamsWithNavigationV10$default(this.a, this.c.convertToFieldMap(navigation), null, null, this.c.convertToFieldMap(categoryParameters.getParametersExceptOwnedBySlots()), this.d.getSessionId(), 6, null);
        }
        return a.S1(this.b, InteropKt.toV2(observable), "if (features.htmlDescrip…scribeOn(schedulers.io())");
    }
}

package com.avito.android.publish.category_suggest;

import com.avito.android.Features;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CategoriesSuggestResponse;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsInteractorImpl;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsInteractor;", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/CategoriesSuggestResponse;", "loadSuggestions", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Lcom/avito/android/remote/model/Navigation;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "c", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "Lcom/avito/android/remote/PublishApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/PublishApi;", "api", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/Features;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesSuggestionsInteractorImpl implements CategoriesSuggestionsInteractor {
    public final PublishApi a;
    public final PublishAnalyticsDataProvider b;
    public final CategoryParametersConverter c;

    public CategoriesSuggestionsInteractorImpl(@NotNull PublishApi publishApi, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(publishApi, "api");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = publishApi;
        this.b = publishAnalyticsDataProvider;
        this.c = categoryParametersConverter;
    }

    @Override // com.avito.android.publish.category_suggest.CategoriesSuggestionsInteractor
    @NotNull
    public Observable<CategoriesSuggestResponse> loadSuggestions(@NotNull CategoryParameters categoryParameters, @NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        return InteropKt.toV2(this.a.getCategoriesSuggest(this.c.convertToFieldMap(navigation), this.c.convertToFieldMap(categoryParameters.getParametersExceptOwnedBySlots()), this.b.getSessionId()));
    }
}

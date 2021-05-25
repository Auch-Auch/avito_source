package com.avito.android.publish.edit_advert_request.data;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.adverts.EditAdvertResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJO\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/data/EditAdvertRepositoryImpl;", "Lcom/avito/android/publish/edit_advert_request/data/EditAdvertRepository;", "", "itemId", "categoryId", "Lcom/avito/android/remote/model/Navigation;", "navigation", "version", "postAction", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "params", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/adverts/EditAdvertResult;", "editAdvert", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "c", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "Lcom/avito/android/publish/edit_advert_request/data/EditAdvertDataSource;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/edit_advert_request/data/EditAdvertDataSource;", "cloudDataSource", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "<init>", "(Lcom/avito/android/publish/edit_advert_request/data/EditAdvertDataSource;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class EditAdvertRepositoryImpl implements EditAdvertRepository {
    public final EditAdvertDataSource a;
    public final CategoryParametersConverter b;
    public final PublishAnalyticsDataProvider c;

    @Inject
    public EditAdvertRepositoryImpl(@NotNull EditAdvertDataSource editAdvertDataSource, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(editAdvertDataSource, "cloudDataSource");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        this.a = editAdvertDataSource;
        this.b = categoryParametersConverter;
        this.c = publishAnalyticsDataProvider;
    }

    @Override // com.avito.android.publish.edit_advert_request.data.EditAdvertRepository
    @NotNull
    public Observable<TypedResult<EditAdvertResult>> editAdvert(@NotNull String str, @NotNull String str2, @NotNull Navigation navigation, @Nullable String str3, @Nullable String str4, @NotNull CategoryParameters categoryParameters) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "categoryId");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(categoryParameters, "params");
        return this.a.editAdvertWithNavigation(str, str2, this.b.convertToFieldMap(navigation), str3, str4, this.b.convertToFieldMap(categoryParameters.getParametersExceptOwnedBySlots()), this.c.getSessionId());
    }
}

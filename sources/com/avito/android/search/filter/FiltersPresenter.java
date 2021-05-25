package com.avito.android.search.filter;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import com.avito.android.select.Arguments;
import com.avito.android.util.Kundle;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0002()J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H&¢\u0006\u0004\b\"\u0010\bJ\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H&¢\u0006\u0004\b&\u0010\bJ\u000f\u0010'\u001a\u00020\u0004H&¢\u0006\u0004\b'\u0010\b¨\u0006*"}, d2 = {"Lcom/avito/android/search/filter/FiltersPresenter;", "", "Lcom/avito/android/search/filter/FiltersView;", "view", "", "attachView", "(Lcom/avito/android/search/filter/FiltersView;)V", "detachView", "()V", "", "id", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selection", "sectionTitle", "onSelected", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Lcom/avito/android/remote/model/Location;", "location", "onLocationChanged", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/avito/android/remote/model/SearchRadius;", "radius", "onSearchRadiusChanged", "(Lcom/avito/android/remote/model/SearchRadius;)V", "Ljava/util/Date;", "checkInDate", "checkOutDate", "onDatesSelected", "(Ljava/util/Date;Ljava/util/Date;)V", "Lcom/avito/android/search/filter/FiltersPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/search/filter/FiltersPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", "retry", "ResourceProvider", "Router", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface FiltersPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/search/filter/FiltersPresenter$ResourceProvider;", "", "", "getNoAdverts", "()Ljava/lang/String;", "getShowAdverts", "", "canSwitchDisplayType", "()Z", "filter_release"}, k = 1, mv = {1, 4, 2})
    public interface ResourceProvider {
        boolean canSwitchDisplayType();

        @NotNull
        String getNoAdverts();

        @NotNull
        String getShowAdverts();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0014\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0015\u0010\fJ#\u0010\u0019\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b\u001f\u0010 J'\u0010$\u001a\u00020\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010!H&¢\u0006\u0004\b$\u0010%JG\u0010.\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010*\u001a\u00020)2\b\u0010\u0018\u001a\u0004\u0018\u00010)2\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160,0+H&¢\u0006\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/avito/android/search/filter/FiltersPresenter$Router;", "", "", "closeScreen", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "closeScreenWithDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/select/Arguments;", "arguments", "showSelectScreen", "(Lcom/avito/android/select/Arguments;)V", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "item", "showMultiselectDialog", "(Lcom/avito/android/category_parameters/ParameterElement$Multiselect;)V", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "showSelectDialog", "(Lcom/avito/android/category_parameters/ParameterElement$Select;)V", "showGroupSelectDialog", "showSelectBottomSheet", "", "selectedLocationId", "categoryId", "showRegionSelectScreen", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/remote/model/SearchParams;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/SearchRadius;", "searchRadius", "showSearchRadiusPickerScreen", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/SearchRadius;)V", "Ljava/util/Date;", "startDate", "endDate", "showSelectDatesCalendar", "(Ljava/util/Date;Ljava/util/Date;)V", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "metroWithLines", "requestId", "", "locationId", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedValues", "showSelectMetroScreen", "(Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;Ljava/lang/String;ILjava/lang/Integer;Ljava/util/List;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void showSelectDatesCalendar$default(Router router, Date date, Date date2, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        date = null;
                    }
                    if ((i & 2) != 0) {
                        date2 = null;
                    }
                    router.showSelectDatesCalendar(date, date2);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSelectDatesCalendar");
            }
        }

        void closeScreen();

        void closeScreenWithDeepLink(@NotNull DeepLink deepLink);

        void showGroupSelectDialog(@NotNull ParameterElement.Multiselect multiselect);

        void showMultiselectDialog(@NotNull ParameterElement.Multiselect multiselect);

        void showRegionSelectScreen(@Nullable String str, @Nullable String str2);

        void showSearchRadiusPickerScreen(@NotNull SearchParams searchParams, @Nullable SearchRadius searchRadius);

        void showSelectBottomSheet(@NotNull Arguments arguments);

        void showSelectDatesCalendar(@Nullable Date date, @Nullable Date date2);

        void showSelectDialog(@NotNull ParameterElement.Select select);

        void showSelectMetroScreen(@Nullable MetroResponseBody metroResponseBody, @NotNull String str, int i, @Nullable Integer num, @NotNull List<? extends ParcelableEntity<String>> list);

        void showSelectScreen(@NotNull Arguments arguments);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull FiltersView filtersView);

    void detachRouter();

    void detachView();

    void onBackPressed();

    void onDatesSelected(@NotNull Date date, @NotNull Date date2);

    void onLocationChanged(@Nullable Location location);

    @NotNull
    Kundle onSaveState();

    void onSearchRadiusChanged(@Nullable SearchRadius searchRadius);

    void onSelected(@NotNull String str, @NotNull List<? extends ParcelableEntity<String>> list, @Nullable String str2);

    void retry();
}

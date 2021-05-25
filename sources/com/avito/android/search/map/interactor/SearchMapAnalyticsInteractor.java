package com.avito.android.search.map.interactor;

import com.avito.android.analytics.event.ClickPinEvent;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J3\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0004J#\u0010\u0017\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0019\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0019\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u001f\u0010 J_\u0010)\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b+\u0010,J!\u0010/\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\u0006\u0010.\u001a\u00020-H&¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0012H&¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012H&¢\u0006\u0004\b5\u00106J'\u00108\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00122\u0006\u00107\u001a\u00020-H&¢\u0006\u0004\b8\u00109J)\u0010<\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010\u00122\u0006\u0010;\u001a\u00020-H&¢\u0006\u0004\b<\u00109J)\u0010?\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00122\u0006\u0010>\u001a\u00020=2\b\u0010:\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH&¢\u0006\u0004\bB\u0010CJ\u0011\u0010E\u001a\u0004\u0018\u00010DH&¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0002H&¢\u0006\u0004\bG\u0010\u0004J\u0011\u0010H\u001a\u0004\u0018\u00010AH&¢\u0006\u0004\bH\u0010CJ\u0017\u0010K\u001a\u00020\u00022\u0006\u0010J\u001a\u00020IH&¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u0002H&¢\u0006\u0004\bM\u0010\u0004J#\u0010P\u001a\u00020\u00022\u0012\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120N0NH&¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u0002H&¢\u0006\u0004\bR\u0010\u0004J\u000f\u0010S\u001a\u00020\u0002H&¢\u0006\u0004\bS\u0010\u0004¨\u0006T"}, d2 = {"Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", "", "", "sendEntranceToMap", "()V", "sendShowScreenEvent", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "total", "Lcom/google/android/gms/maps/model/LatLngBounds;", "bounds", "", "mapZoom", "sendSearchByMap", "(Lcom/avito/android/remote/model/SearchParams;JLcom/google/android/gms/maps/model/LatLngBounds;Ljava/lang/Float;)V", "Lcom/avito/android/remote/model/SerpDisplayType;", "serpDisplayType", "", "xHash", "sendSerpLoad", "(Lcom/avito/android/remote/model/SearchParams;JLcom/google/android/gms/maps/model/LatLngBounds;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;)V", "sendExitFromMap", "sendMapZoom", "(Lcom/google/android/gms/maps/model/LatLngBounds;Ljava/lang/Float;)V", "sendMapScroll", "sendClickFindMe", "(Lcom/google/android/gms/maps/model/LatLngBounds;)V", "serpPanelState", "shortcutTitle", "categoryId", "sendClickShortcut", "(Ljava/lang/String;Lcom/google/android/gms/maps/model/LatLngBounds;Ljava/lang/String;Ljava/lang/String;)V", "", "Lcom/avito/android/analytics/event/ClickPinEvent$PinType;", "pinType", "Lcom/avito/android/analytics/event/ClickPinEvent$PinState;", "pinState", "Lcom/avito/android/analytics/event/ClickPinEvent$PinHighlight;", "pinHighlight", "pinPrice", "sendClickPin", "(Ljava/lang/String;Lcom/google/android/gms/maps/model/LatLngBounds;ILjava/lang/String;Ljava/lang/Float;Lcom/avito/android/analytics/event/ClickPinEvent$PinType;Lcom/avito/android/analytics/event/ClickPinEvent$PinState;Lcom/avito/android/analytics/event/ClickPinEvent$PinHighlight;Ljava/lang/String;)V", "sendClearGeoFilters", "(Lcom/avito/android/remote/model/SearchParams;)V", "", "fromActionBar", "sendClickBack", "(Ljava/lang/String;Z)V", BookingInfoActivity.EXTRA_ITEM_ID, "sendAdvertXlConfirmedCall", "(Ljava/lang/String;)V", "source", "sendShowPhoneDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "success", "sendShowPhoneDialer", "(Ljava/lang/String;Ljava/lang/String;Z)V", "context", "fromXl", "sendCallToSeller", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "sendWriteToSeller", "(Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;Ljava/lang/String;)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Lcom/avito/android/search/map/interactor/ParentType;", "getParentType", "()Lcom/avito/android/search/map/interactor/ParentType;", "searchParamChange", "getSavedParent", "Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;", "event", "sendClickSearchSuggest", "(Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;)V", "sendSearchSubmit", "", "items", "sendMarkerItemsLoaded", "(Ljava/util/List;)V", "sendResetActionClick", "sendNotRestoreState", "map_release"}, k = 1, mv = {1, 4, 2})
public interface SearchMapAnalyticsInteractor {
    @NotNull
    TreeClickStreamParent getParent();

    @Nullable
    ParentType getParentType();

    @Nullable
    TreeClickStreamParent getSavedParent();

    void searchParamChange();

    void sendAdvertXlConfirmedCall(@NotNull String str);

    void sendCallToSeller(@NotNull String str, @Nullable String str2, boolean z);

    void sendClearGeoFilters(@NotNull SearchParams searchParams);

    void sendClickBack(@Nullable String str, boolean z);

    void sendClickFindMe(@Nullable LatLngBounds latLngBounds);

    void sendClickPin(@NotNull String str, @Nullable LatLngBounds latLngBounds, int i, @Nullable String str2, @Nullable Float f, @NotNull ClickPinEvent.PinType pinType, @NotNull ClickPinEvent.PinState pinState, @NotNull ClickPinEvent.PinHighlight pinHighlight, @Nullable String str3);

    void sendClickSearchSuggest(@NotNull SuggestAnalyticsEvent suggestAnalyticsEvent);

    void sendClickShortcut(@NotNull String str, @Nullable LatLngBounds latLngBounds, @NotNull String str2, @Nullable String str3);

    void sendEntranceToMap();

    void sendExitFromMap();

    void sendMapScroll(@Nullable LatLngBounds latLngBounds, @Nullable Float f);

    void sendMapZoom(@Nullable LatLngBounds latLngBounds, @Nullable Float f);

    void sendMarkerItemsLoaded(@NotNull List<? extends List<String>> list);

    void sendNotRestoreState();

    void sendResetActionClick();

    void sendSearchByMap(@NotNull SearchParams searchParams, long j, @Nullable LatLngBounds latLngBounds, @Nullable Float f);

    void sendSearchSubmit();

    void sendSerpLoad(@NotNull SearchParams searchParams, long j, @Nullable LatLngBounds latLngBounds, @Nullable SerpDisplayType serpDisplayType, @Nullable String str);

    void sendShowPhoneDialer(@NotNull String str, @NotNull String str2, boolean z);

    void sendShowPhoneDialog(@NotNull String str, @NotNull String str2);

    void sendShowScreenEvent();

    void sendWriteToSeller(@NotNull String str, @NotNull ContactSource contactSource, @Nullable String str2);
}

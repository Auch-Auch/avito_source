package com.avito.android.home;

import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.search.SearchViewInteractor;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.stories.StartupBannerInteractor;
import com.avito.android.stories.StoriesInteractor;
import com.avito.android.util.LoadingState;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J[\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0010H&¢\u0006\u0004\b!\u0010\u001fJ\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u0010H&¢\u0006\u0004\b\"\u0010\u001fJ\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00102\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H&¢\u0006\u0004\b&\u0010\u001fJ\u0017\u0010'\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b'\u0010(J'\u0010*\u001a\u00020 2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u0010H&¢\u0006\u0004\b-\u0010\u001f¨\u0006."}, d2 = {"Lcom/avito/android/home/HomeInteractor;", "Lcom/avito/android/search/SearchViewInteractor;", "Lcom/avito/android/stories/StoriesInteractor;", "Lcom/avito/android/stories/StartupBannerInteractor;", "Lcom/avito/android/remote/model/Location;", "location", "", "offset", "page", "columnCount", "", "tabId", "", "hideSeenBadge", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/home/HomePageResult;", "loadAdverts", "(Lcom/avito/android/remote/model/Location;IIILjava/lang/String;ZLcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "items", "locationId", "loadAds", "(Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/home/HomeInteractorState;", "onSaveState", "()Lcom/avito/android/home/HomeInteractorState;", "isLocationChanged", "()Lio/reactivex/rxjava3/core/Observable;", "", "onLocationChanged", "onLogin", "Lcom/avito/android/remote/model/Shortcuts;", "loadMainShortcuts", "(Lcom/avito/android/remote/model/Location;)Lio/reactivex/rxjava3/core/Observable;", "loadLocation", "updateStoredLocationId", "(Lcom/avito/android/remote/model/Location;)V", MessengerShareContentUtility.ELEMENTS, "resolveItems", "(Ljava/util/List;Z)V", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "loadWarning", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface HomeInteractor extends SearchViewInteractor, StoriesInteractor, StartupBannerInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable loadAdverts$default(HomeInteractor homeInteractor, Location location, int i, int i2, int i3, String str, boolean z, SerpDisplayType serpDisplayType, int i4, Object obj) {
            if (obj == null) {
                return homeInteractor.loadAdverts(location, i, i2, i3, str, (i4 & 32) != 0 ? false : z, (i4 & 64) != 0 ? null : serpDisplayType);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAdverts");
        }

        public static /* synthetic */ void resolveItems$default(HomeInteractor homeInteractor, List list, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                homeInteractor.resolveItems(list, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolveItems");
        }
    }

    @NotNull
    Observable<Boolean> isLocationChanged();

    @NotNull
    Observable<ViewTypeSerpItem> loadAds(@NotNull List<? extends ViewTypeSerpItem> list, @Nullable String str, @Nullable SerpDisplayType serpDisplayType);

    @NotNull
    Observable<LoadingState<HomePageResult>> loadAdverts(@NotNull Location location, int i, int i2, int i3, @Nullable String str, boolean z, @Nullable SerpDisplayType serpDisplayType);

    @NotNull
    Observable<Location> loadLocation();

    @NotNull
    Observable<Shortcuts> loadMainShortcuts(@NotNull Location location);

    @NotNull
    Observable<SnippetItem> loadWarning();

    @NotNull
    Observable<Unit> onLocationChanged();

    @NotNull
    Observable<Unit> onLogin();

    @NotNull
    HomeInteractorState onSaveState();

    void resolveItems(@NotNull List<? extends ViewTypeSerpItem> list, boolean z);

    void updateStoredLocationId(@NotNull Location location);
}

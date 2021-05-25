package com.avito.android.remote.model;

import a2.b.a.a.a;
import androidx.annotation.Keep;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001Bc\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b4\u00105J\u001b\u0010\u0005\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017Jn\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010\u000bJ\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010(\u001a\u0004\b)\u0010\u0017R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b+\u0010\u0014R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b-\u0010\bR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b/\u0010\u000bR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b1\u0010\u0011R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b2\u0010\u000bR$\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b3\u0010\b¨\u00066"}, d2 = {"Lcom/avito/android/remote/model/HomeElementResult;", "", "", "Lcom/avito/android/remote/model/SerpElement;", MessengerShareContentUtility.ELEMENTS, "cloneWithNewElements", "(Ljava/util/List;)Lcom/avito/android/remote/model/HomeElementResult;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "component3", "Lcom/avito/android/remote/model/HomeTabItem;", "component4", "Lcom/avito/android/remote/model/Location;", "component5", "()Lcom/avito/android/remote/model/Location;", "Lcom/avito/android/remote/model/Options;", "component6", "()Lcom/avito/android/remote/model/Options;", "Lcom/avito/android/remote/model/AdvertItemActions;", "component7", "()Lcom/avito/android/remote/model/AdvertItemActions;", "searchHint", "xHash", "tabs", "location", "options", "moreActions", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Location;Lcom/avito/android/remote/model/Options;Lcom/avito/android/remote/model/AdvertItemActions;)Lcom/avito/android/remote/model/HomeElementResult;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/AdvertItemActions;", "getMoreActions", "Lcom/avito/android/remote/model/Options;", "getOptions", "Ljava/util/List;", "getElements", "Ljava/lang/String;", "getXHash", "Lcom/avito/android/remote/model/Location;", "getLocation", "getSearchHint", "getTabs", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Location;Lcom/avito/android/remote/model/Options;Lcom/avito/android/remote/model/AdvertItemActions;)V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class HomeElementResult {
    @SerializedName("items")
    @NotNull
    private final List<SerpElement> elements;
    @SerializedName("location")
    @Nullable
    private final Location location;
    @SerializedName("moreActions")
    @Nullable
    private final AdvertItemActions moreActions;
    @SerializedName("options")
    @Nullable
    private final Options options;
    @SerializedName("searchHint")
    @Nullable
    private final String searchHint;
    @SerializedName("feeds")
    @Nullable
    private final List<HomeTabItem> tabs;
    @SerializedName("xHash")
    @Nullable
    private final String xHash;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeElementResult(@NotNull List<? extends SerpElement> list, @Nullable String str, @Nullable String str2, @Nullable List<HomeTabItem> list2, @Nullable Location location2, @Nullable Options options2, @Nullable AdvertItemActions advertItemActions) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        this.elements = list;
        this.searchHint = str;
        this.xHash = str2;
        this.tabs = list2;
        this.location = location2;
        this.options = options2;
        this.moreActions = advertItemActions;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.remote.model.HomeElementResult */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeElementResult copy$default(HomeElementResult homeElementResult, List list, String str, String str2, List list2, Location location2, Options options2, AdvertItemActions advertItemActions, int i, Object obj) {
        if ((i & 1) != 0) {
            list = homeElementResult.elements;
        }
        if ((i & 2) != 0) {
            str = homeElementResult.searchHint;
        }
        if ((i & 4) != 0) {
            str2 = homeElementResult.xHash;
        }
        if ((i & 8) != 0) {
            list2 = homeElementResult.tabs;
        }
        if ((i & 16) != 0) {
            location2 = homeElementResult.location;
        }
        if ((i & 32) != 0) {
            options2 = homeElementResult.options;
        }
        if ((i & 64) != 0) {
            advertItemActions = homeElementResult.moreActions;
        }
        return homeElementResult.copy(list, str, str2, list2, location2, options2, advertItemActions);
    }

    @NotNull
    public final HomeElementResult cloneWithNewElements(@NotNull List<? extends SerpElement> list) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        return copy$default(this, list, null, null, null, null, null, null, 126, null);
    }

    @NotNull
    public final List<SerpElement> component1() {
        return this.elements;
    }

    @Nullable
    public final String component2() {
        return this.searchHint;
    }

    @Nullable
    public final String component3() {
        return this.xHash;
    }

    @Nullable
    public final List<HomeTabItem> component4() {
        return this.tabs;
    }

    @Nullable
    public final Location component5() {
        return this.location;
    }

    @Nullable
    public final Options component6() {
        return this.options;
    }

    @Nullable
    public final AdvertItemActions component7() {
        return this.moreActions;
    }

    @NotNull
    public final HomeElementResult copy(@NotNull List<? extends SerpElement> list, @Nullable String str, @Nullable String str2, @Nullable List<HomeTabItem> list2, @Nullable Location location2, @Nullable Options options2, @Nullable AdvertItemActions advertItemActions) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        return new HomeElementResult(list, str, str2, list2, location2, options2, advertItemActions);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeElementResult)) {
            return false;
        }
        HomeElementResult homeElementResult = (HomeElementResult) obj;
        return Intrinsics.areEqual(this.elements, homeElementResult.elements) && Intrinsics.areEqual(this.searchHint, homeElementResult.searchHint) && Intrinsics.areEqual(this.xHash, homeElementResult.xHash) && Intrinsics.areEqual(this.tabs, homeElementResult.tabs) && Intrinsics.areEqual(this.location, homeElementResult.location) && Intrinsics.areEqual(this.options, homeElementResult.options) && Intrinsics.areEqual(this.moreActions, homeElementResult.moreActions);
    }

    @NotNull
    public final List<SerpElement> getElements() {
        return this.elements;
    }

    @Nullable
    public final Location getLocation() {
        return this.location;
    }

    @Nullable
    public final AdvertItemActions getMoreActions() {
        return this.moreActions;
    }

    @Nullable
    public final Options getOptions() {
        return this.options;
    }

    @Nullable
    public final String getSearchHint() {
        return this.searchHint;
    }

    @Nullable
    public final List<HomeTabItem> getTabs() {
        return this.tabs;
    }

    @Nullable
    public final String getXHash() {
        return this.xHash;
    }

    public int hashCode() {
        List<SerpElement> list = this.elements;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.searchHint;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.xHash;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<HomeTabItem> list2 = this.tabs;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Location location2 = this.location;
        int hashCode5 = (hashCode4 + (location2 != null ? location2.hashCode() : 0)) * 31;
        Options options2 = this.options;
        int hashCode6 = (hashCode5 + (options2 != null ? options2.hashCode() : 0)) * 31;
        AdvertItemActions advertItemActions = this.moreActions;
        if (advertItemActions != null) {
            i = advertItemActions.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("HomeElementResult(elements=");
        L.append(this.elements);
        L.append(", searchHint=");
        L.append(this.searchHint);
        L.append(", xHash=");
        L.append(this.xHash);
        L.append(", tabs=");
        L.append(this.tabs);
        L.append(", location=");
        L.append(this.location);
        L.append(", options=");
        L.append(this.options);
        L.append(", moreActions=");
        L.append(this.moreActions);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeElementResult(List list, String str, String str2, List list2, Location location2, Options options2, AdvertItemActions advertItemActions, int i, j jVar) {
        this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : location2, (i & 32) != 0 ? null : options2, (i & 64) == 0 ? advertItemActions : null);
    }
}

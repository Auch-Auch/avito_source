package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.UrlParams;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u001a\b\b\u0018\u0000 Q2\u00020\u0001:\u0001QB¡\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010)\u001a\u00020\u0015\u0012\b\b\u0002\u0010*\u001a\u00020\u0015\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0019\u0012\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001e\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010&¢\u0006\u0004\bO\u0010PJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001bJ\u001e\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b!\u0010\u001bJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\"\u0010\u001bJ\u0012\u0010$\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0012\u0010'\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0004\b'\u0010(J¬\u0001\u00104\u001a\u00020\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010)\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u00152\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001e2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00102\u001a\u0004\u0018\u00010#2\n\b\u0002\u00103\u001a\u0004\u0018\u00010&HÆ\u0001¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b6\u0010\u001bJ\u0010\u00107\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b7\u0010\u0012J\u001a\u0010:\u001a\u00020&2\b\u00109\u001a\u0004\u0018\u000108HÖ\u0003¢\u0006\u0004\b:\u0010;R\u0018\u0010,\u001a\u0004\u0018\u00010\u00028\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b,\u0010<R\u001e\u00103\u001a\u0004\u0018\u00010&8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u0010=\u001a\u0004\b3\u0010(R\u001e\u00101\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b1\u0010>\u001a\u0004\b?\u0010\u001bR\u001e\u0010.\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b.\u0010>\u001a\u0004\b@\u0010\u001bR\u001c\u0010)\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010A\u001a\u0004\bB\u0010\u0017R\u001e\u00102\u001a\u0004\u0018\u00010#8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b2\u0010C\u001a\u0004\bD\u0010%R\u0013\u0010F\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\bE\u0010\u0004R\u001e\u0010-\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010>\u001a\u0004\bG\u0010\u001bR\u001e\u00100\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b0\u0010>\u001a\u0004\bH\u0010\u001bR\u001e\u0010+\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010>\u001a\u0004\bI\u0010\u001bR\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010J\u001a\u0004\bK\u0010\u0014R*\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u0010L\u001a\u0004\bM\u0010 R\u001c\u0010*\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010A\u001a\u0004\bN\u0010\u0017¨\u0006R"}, d2 = {"Lcom/avito/android/remote/model/SerpElementResult;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/SerpDisplayType;", "component5", "()Lcom/avito/android/remote/model/SerpDisplayType;", "", "Lcom/avito/android/remote/model/SerpElement;", MessengerShareContentUtility.ELEMENTS, "cloneWithNewElements", "(Ljava/util/List;)Lcom/avito/android/remote/model/SerpElementResult;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/List;", "", "component2", "()J", "component3", "", "component4", "()Ljava/lang/String;", "component6", "component7", "", "component8", "()Ljava/util/Map;", "component9", "component10", "Lcom/avito/android/remote/model/SearchDescription;", "component11", "()Lcom/avito/android/remote/model/SearchDescription;", "", "component12", "()Ljava/lang/Boolean;", "count", UrlParams.LAST_STAMP, "subscriptionId", "displayType", "searchHint", "xHash", "firebaseParams", "emptySearchText", UrlParams.NEXT_PAGE_ID, "searchDescription", "isSubscribed", "copy", "(Ljava/util/List;JJLjava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchDescription;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/SerpElementResult;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/SerpDisplayType;", "Ljava/lang/Boolean;", "Ljava/lang/String;", "getNextPageId", "getXHash", "J", "getCount", "Lcom/avito/android/remote/model/SearchDescription;", "getSearchDescription", "getSerpDisplayType", "serpDisplayType", "getSearchHint", "getEmptySearchText", "getSubscriptionId", "Ljava/util/List;", "getElements", "Ljava/util/Map;", "getFirebaseParams", "getLastStamp", "<init>", "(Ljava/util/List;JJLjava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchDescription;Ljava/lang/Boolean;)V", "Companion", "search_release"}, k = 1, mv = {1, 4, 2})
public final class SerpElementResult implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SerpElementResult> CREATOR = Parcels.creator(SerpElementResult$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("count")
    private final long count;
    @SerializedName("displayType")
    private final SerpDisplayType displayType;
    @SerializedName("items")
    @NotNull
    private final List<SerpElement> elements;
    @SerializedName("emptySearch")
    @Nullable
    private final String emptySearchText;
    @SerializedName("firebaseParams")
    @Nullable
    private final Map<String, String> firebaseParams;
    @SerializedName("isSubscribed")
    @Nullable
    private final Boolean isSubscribed;
    @SerializedName(UrlParams.LAST_STAMP)
    private final long lastStamp;
    @SerializedName(UrlParams.NEXT_PAGE_ID)
    @Nullable
    private final String nextPageId;
    @SerializedName("saveToHistoryDescription")
    @Nullable
    private final SearchDescription searchDescription;
    @SerializedName("searchHint")
    @Nullable
    private final String searchHint;
    @SerializedName("subscriptionId")
    @Nullable
    private final String subscriptionId;
    @SerializedName("xHash")
    @Nullable
    private final String xHash;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SerpElementResult$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SerpElementResult;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "search_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public SerpElementResult(@NotNull List<? extends SerpElement> list, long j, long j2, @Nullable String str, @Nullable SerpDisplayType serpDisplayType, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable String str4, @Nullable String str5, @Nullable SearchDescription searchDescription2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        this.elements = list;
        this.count = j;
        this.lastStamp = j2;
        this.subscriptionId = str;
        this.displayType = serpDisplayType;
        this.searchHint = str2;
        this.xHash = str3;
        this.firebaseParams = map;
        this.emptySearchText = str4;
        this.nextPageId = str5;
        this.searchDescription = searchDescription2;
        this.isSubscribed = bool;
    }

    private final SerpDisplayType component5() {
        return this.displayType;
    }

    public static /* synthetic */ SerpElementResult copy$default(SerpElementResult serpElementResult, List list, long j, long j2, String str, SerpDisplayType serpDisplayType, String str2, String str3, Map map, String str4, String str5, SearchDescription searchDescription2, Boolean bool, int i, Object obj) {
        return serpElementResult.copy((i & 1) != 0 ? serpElementResult.elements : list, (i & 2) != 0 ? serpElementResult.count : j, (i & 4) != 0 ? serpElementResult.lastStamp : j2, (i & 8) != 0 ? serpElementResult.subscriptionId : str, (i & 16) != 0 ? serpElementResult.displayType : serpDisplayType, (i & 32) != 0 ? serpElementResult.searchHint : str2, (i & 64) != 0 ? serpElementResult.xHash : str3, (i & 128) != 0 ? serpElementResult.firebaseParams : map, (i & 256) != 0 ? serpElementResult.emptySearchText : str4, (i & 512) != 0 ? serpElementResult.nextPageId : str5, (i & 1024) != 0 ? serpElementResult.searchDescription : searchDescription2, (i & 2048) != 0 ? serpElementResult.isSubscribed : bool);
    }

    @NotNull
    public final SerpElementResult cloneWithNewElements(@NotNull List<? extends SerpElement> list) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        return new SerpElementResult(list, this.count, this.lastStamp, this.subscriptionId, this.displayType, this.searchHint, this.xHash, this.firebaseParams, this.emptySearchText, this.nextPageId, this.searchDescription, this.isSubscribed);
    }

    @NotNull
    public final List<SerpElement> component1() {
        return this.elements;
    }

    @Nullable
    public final String component10() {
        return this.nextPageId;
    }

    @Nullable
    public final SearchDescription component11() {
        return this.searchDescription;
    }

    @Nullable
    public final Boolean component12() {
        return this.isSubscribed;
    }

    public final long component2() {
        return this.count;
    }

    public final long component3() {
        return this.lastStamp;
    }

    @Nullable
    public final String component4() {
        return this.subscriptionId;
    }

    @Nullable
    public final String component6() {
        return this.searchHint;
    }

    @Nullable
    public final String component7() {
        return this.xHash;
    }

    @Nullable
    public final Map<String, String> component8() {
        return this.firebaseParams;
    }

    @Nullable
    public final String component9() {
        return this.emptySearchText;
    }

    @NotNull
    public final SerpElementResult copy(@NotNull List<? extends SerpElement> list, long j, long j2, @Nullable String str, @Nullable SerpDisplayType serpDisplayType, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable String str4, @Nullable String str5, @Nullable SearchDescription searchDescription2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        return new SerpElementResult(list, j, j2, str, serpDisplayType, str2, str3, map, str4, str5, searchDescription2, bool);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SerpElementResult)) {
            return false;
        }
        SerpElementResult serpElementResult = (SerpElementResult) obj;
        return Intrinsics.areEqual(this.elements, serpElementResult.elements) && this.count == serpElementResult.count && this.lastStamp == serpElementResult.lastStamp && Intrinsics.areEqual(this.subscriptionId, serpElementResult.subscriptionId) && Intrinsics.areEqual(this.displayType, serpElementResult.displayType) && Intrinsics.areEqual(this.searchHint, serpElementResult.searchHint) && Intrinsics.areEqual(this.xHash, serpElementResult.xHash) && Intrinsics.areEqual(this.firebaseParams, serpElementResult.firebaseParams) && Intrinsics.areEqual(this.emptySearchText, serpElementResult.emptySearchText) && Intrinsics.areEqual(this.nextPageId, serpElementResult.nextPageId) && Intrinsics.areEqual(this.searchDescription, serpElementResult.searchDescription) && Intrinsics.areEqual(this.isSubscribed, serpElementResult.isSubscribed);
    }

    public final long getCount() {
        return this.count;
    }

    @NotNull
    public final List<SerpElement> getElements() {
        return this.elements;
    }

    @Nullable
    public final String getEmptySearchText() {
        return this.emptySearchText;
    }

    @Nullable
    public final Map<String, String> getFirebaseParams() {
        return this.firebaseParams;
    }

    public final long getLastStamp() {
        return this.lastStamp;
    }

    @Nullable
    public final String getNextPageId() {
        return this.nextPageId;
    }

    @Nullable
    public final SearchDescription getSearchDescription() {
        return this.searchDescription;
    }

    @Nullable
    public final String getSearchHint() {
        return this.searchHint;
    }

    @NotNull
    public final SerpDisplayType getSerpDisplayType() {
        return SerpDisplayTypeKt.orDefault(this.displayType);
    }

    @Nullable
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @Nullable
    public final String getXHash() {
        return this.xHash;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<SerpElement> list = this.elements;
        int i = 0;
        int hashCode = (((((list != null ? list.hashCode() : 0) * 31) + c.a(this.count)) * 31) + c.a(this.lastStamp)) * 31;
        String str = this.subscriptionId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        SerpDisplayType serpDisplayType = this.displayType;
        int hashCode3 = (hashCode2 + (serpDisplayType != null ? serpDisplayType.hashCode() : 0)) * 31;
        String str2 = this.searchHint;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.xHash;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Map<String, String> map = this.firebaseParams;
        int hashCode6 = (hashCode5 + (map != null ? map.hashCode() : 0)) * 31;
        String str4 = this.emptySearchText;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.nextPageId;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        SearchDescription searchDescription2 = this.searchDescription;
        int hashCode9 = (hashCode8 + (searchDescription2 != null ? searchDescription2.hashCode() : 0)) * 31;
        Boolean bool = this.isSubscribed;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode9 + i;
    }

    @Nullable
    public final Boolean isSubscribed() {
        return this.isSubscribed;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SerpElementResult(elements=");
        L.append(this.elements);
        L.append(", count=");
        L.append(this.count);
        L.append(", lastStamp=");
        L.append(this.lastStamp);
        L.append(", subscriptionId=");
        L.append(this.subscriptionId);
        L.append(", displayType=");
        L.append(this.displayType);
        L.append(", searchHint=");
        L.append(this.searchHint);
        L.append(", xHash=");
        L.append(this.xHash);
        L.append(", firebaseParams=");
        L.append(this.firebaseParams);
        L.append(", emptySearchText=");
        L.append(this.emptySearchText);
        L.append(", nextPageId=");
        L.append(this.nextPageId);
        L.append(", searchDescription=");
        L.append(this.searchDescription);
        L.append(", isSubscribed=");
        return a.o(L, this.isSubscribed, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            ParcelsKt.writeOptimizedParcelableList$default(parcel, this.elements, 0, 2, null);
            parcel.writeLong(this.count);
            parcel.writeLong(this.lastStamp);
            parcel.writeString(this.subscriptionId);
            ParcelsKt.writeOptEnum(parcel, this.displayType);
            parcel.writeString(this.searchHint);
            parcel.writeString(this.xHash);
            ParcelsKt.writeValueMap(parcel, this.firebaseParams);
            parcel.writeString(this.emptySearchText);
            parcel.writeString(this.nextPageId);
            parcel.writeParcelable(this.searchDescription, i);
            ParcelsKt.writeOptBoolean(parcel, this.isSubscribed);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpElementResult(List list, long j, long j2, String str, SerpDisplayType serpDisplayType, String str2, String str3, Map map, String str4, String str5, SearchDescription searchDescription2, Boolean bool, int i, j jVar) {
        this(list, (i & 2) != 0 ? 0 : j, (i & 4) == 0 ? j2 : 0, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : serpDisplayType, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : map, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : searchDescription2, (i & 2048) == 0 ? bool : null);
    }
}

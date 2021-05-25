package com.avito.android.deep_linking.links;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0012\u0006\u0010@\u001a\u00020;\u0012\b\u00104\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00101\u001a\u00020\u001d\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010#\u0012\b\u00107\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010.\u001a\u00020\u001d\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u001d¢\u0006\u0004\bA\u0010BJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0005R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0005R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0005R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010(\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010+\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010\u001bR\u0019\u0010.\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010!R\u0019\u00101\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u001f\u001a\u0004\b0\u0010!R\u001b\u00104\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b3\u0010\u0005R\u001b\u00107\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u000e\u001a\u0004\b6\u0010\u0005R\u001b\u0010:\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u000e\u001a\u0004\b9\u0010\u0005R\u0019\u0010@\u001a\u00020;8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/avito/android/deep_linking/links/ItemsSearchLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/deep_linking/links/LocationOwnerLink;", "", "getLocationId", "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/String;", "getPath", MessageMetaInfo.COLUMN_PATH, "i", "getMapSerpState", "mapSerpState", "n", "getSellerId", "sellerId", "Lcom/avito/android/remote/model/search/map/Area;", "h", "Lcom/avito/android/remote/model/search/map/Area;", "getMapArea", "()Lcom/avito/android/remote/model/search/map/Area;", "mapArea", "", "o", "Z", "getShowSimpleMap", "()Z", UrlParams.SIMPLE_MAP, "", "j", "Ljava/lang/Float;", "getMapZoomLevel", "()Ljava/lang/Float;", "mapZoomLevel", g.a, "getSearchArea", "searchArea", "l", "getShowJobNearbyBanner", "showJobNearbyBanner", "f", "getShowMap", "showMap", "e", "getContext", "context", "k", "getFromPage", "fromPage", AuthSource.OPEN_CHANNEL_LIST, "getExpanded", PanelStateKt.PANEL_EXPANDED, "Lcom/avito/android/remote/model/SearchParams;", "d", "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "()Lcom/avito/android/remote/model/SearchParams;", "searchParams", "<init>", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;ZLcom/avito/android/remote/model/search/map/Area;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ItemsSearchLink extends DeepLink implements LocationOwnerLink {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ItemsSearchLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/items/search";
    @NotNull
    public final String c;
    @NotNull
    public final SearchParams d;
    @Nullable
    public final String e;
    public final boolean f;
    @Nullable
    public final Area g;
    @Nullable
    public final Area h;
    @Nullable
    public final String i;
    @Nullable
    public final Float j;
    @Nullable
    public final String k;
    public final boolean l;
    @Nullable
    public final String m;
    @Nullable
    public final String n;
    public final boolean o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/ItemsSearchLink$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/ItemsSearchLink;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ItemsSearchLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ItemsSearchLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            SearchParams searchParams = (SearchParams) a2.b.a.a.a.z1(SearchParams.class, parcel2);
            String readString = parcel2.readString();
            boolean readBool = ParcelsKt.readBool(parcel2);
            Area area = (Area) parcel2.readParcelable(Area.class.getClassLoader());
            Area area2 = (Area) parcel2.readParcelable(Area.class.getClassLoader());
            String readString2 = parcel2.readString();
            Object readValue = parcel2.readValue(Float.class.getClassLoader());
            if (!(readValue instanceof Float)) {
                readValue = null;
            }
            return new ItemsSearchLink(searchParams, readString, readBool, area, area2, readString2, (Float) readValue, parcel2.readString(), ParcelsKt.readBool(parcel2), parcel2.readString(), parcel2.readString(), ParcelsKt.readBool(parcel2));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemsSearchLink(SearchParams searchParams, String str, boolean z, Area area, Area area2, String str2, Float f2, String str3, boolean z2, String str4, String str5, boolean z3, int i2, j jVar) {
        this(searchParams, str, z, area, area2, str2, f2, str3, (i2 & 256) != 0 ? false : z2, (i2 & 512) != 0 ? null : str4, (i2 & 1024) != 0 ? null : str5, (i2 & 2048) != 0 ? false : z3);
    }

    @Nullable
    public final String getContext() {
        return this.e;
    }

    @Nullable
    public final String getExpanded() {
        return this.m;
    }

    @Nullable
    public final String getFromPage() {
        return this.k;
    }

    @Override // com.avito.android.deep_linking.links.LocationOwnerLink
    @Nullable
    public String getLocationId() {
        return this.d.getLocationId();
    }

    @Nullable
    public final Area getMapArea() {
        return this.h;
    }

    @Nullable
    public final String getMapSerpState() {
        return this.i;
    }

    @Nullable
    public final Float getMapZoomLevel() {
        return this.j;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Nullable
    public final Area getSearchArea() {
        return this.g;
    }

    @NotNull
    public final SearchParams getSearchParams() {
        return this.d;
    }

    @Nullable
    public final String getSellerId() {
        return this.n;
    }

    public final boolean getShowJobNearbyBanner() {
        return this.l;
    }

    public final boolean getShowMap() {
        return this.f;
    }

    public final boolean getShowSimpleMap() {
        return this.o;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.d, i2);
        parcel.writeString(this.e);
        ParcelsKt.writeBool(parcel, this.f);
        parcel.writeParcelable(this.g, i2);
        parcel.writeParcelable(this.h, i2);
        parcel.writeString(this.i);
        ParcelsKt.writeNullableValue(parcel, this.j);
        parcel.writeString(this.k);
        ParcelsKt.writeBool(parcel, this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        ParcelsKt.writeBool(parcel, this.o);
    }

    public ItemsSearchLink(@NotNull SearchParams searchParams, @Nullable String str, boolean z, @Nullable Area area, @Nullable Area area2, @Nullable String str2, @Nullable Float f2, @Nullable String str3, boolean z2, @Nullable String str4, @Nullable String str5, boolean z3) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        this.d = searchParams;
        this.e = str;
        this.f = z;
        this.g = area;
        this.h = area2;
        this.i = str2;
        this.j = f2;
        this.k = str3;
        this.l = z2;
        this.m = str4;
        this.n = str5;
        this.o = z3;
        this.c = PATH;
    }
}

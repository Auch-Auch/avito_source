package com.avito.android.search.map.interactor;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PageParams;
import com.avito.android.remote.model.SearchDescription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u0000 82\u00020\u0001:\u00018BC\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b6\u00107J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\nJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016JR\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\rJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b \u0010\nJ\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0010R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0016R\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\rR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010-\u001a\u0004\b0\u0010\rR\u0019\u0010\u0019\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\nR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u0010\r¨\u00069"}, d2 = {"Lcom/avito/android/search/map/interactor/SerpKey;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/PageParams;", "component2", "()Lcom/avito/android/remote/model/PageParams;", "component3", "component4", "component5", "Lcom/avito/android/remote/model/SearchDescription;", "component6", "()Lcom/avito/android/remote/model/SearchDescription;", "id", "pageParams", "columnsCount", "subscriptionId", "searchHint", "searchDescription", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/PageParams;ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchDescription;)Lcom/avito/android/search/map/interactor/SerpKey;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/PageParams;", "getPageParams", "f", "Lcom/avito/android/remote/model/SearchDescription;", "getSearchDescription", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "d", "getSubscriptionId", "c", "I", "getColumnsCount", "e", "getSearchHint", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/PageParams;ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchDescription;)V", "CREATOR", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SerpKey implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @NotNull
    public final String a;
    @NotNull
    public final PageParams b;
    public final int c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final SearchDescription f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/search/map/interactor/SerpKey$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/search/map/interactor/SerpKey;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/search/map/interactor/SerpKey;", "", "size", "", "newArray", "(I)[Lcom/avito/android/search/map/interactor/SerpKey;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<SerpKey> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public SerpKey createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SerpKey(a.u2(parcel, "parcel.readString()!!"), (PageParams) a.z1(PageParams.class, parcel), parcel.readInt(), parcel.readString(), parcel.readString(), (SearchDescription) parcel.readParcelable(SearchDescription.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public SerpKey[] newArray(int i) {
            return new SerpKey[i];
        }
    }

    public SerpKey(@NotNull String str, @NotNull PageParams pageParams, int i, @Nullable String str2, @Nullable String str3, @Nullable SearchDescription searchDescription) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        this.a = str;
        this.b = pageParams;
        this.c = i;
        this.d = str2;
        this.e = str3;
        this.f = searchDescription;
    }

    public static /* synthetic */ SerpKey copy$default(SerpKey serpKey, String str, PageParams pageParams, int i, String str2, String str3, SearchDescription searchDescription, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = serpKey.a;
        }
        if ((i2 & 2) != 0) {
            pageParams = serpKey.b;
        }
        if ((i2 & 4) != 0) {
            i = serpKey.c;
        }
        if ((i2 & 8) != 0) {
            str2 = serpKey.d;
        }
        if ((i2 & 16) != 0) {
            str3 = serpKey.e;
        }
        if ((i2 & 32) != 0) {
            searchDescription = serpKey.f;
        }
        return serpKey.copy(str, pageParams, i, str2, str3, searchDescription);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final PageParams component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final SearchDescription component6() {
        return this.f;
    }

    @NotNull
    public final SerpKey copy(@NotNull String str, @NotNull PageParams pageParams, int i, @Nullable String str2, @Nullable String str3, @Nullable SearchDescription searchDescription) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        return new SerpKey(str, pageParams, i, str2, str3, searchDescription);
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
        if (!(obj instanceof SerpKey)) {
            return false;
        }
        SerpKey serpKey = (SerpKey) obj;
        return Intrinsics.areEqual(this.a, serpKey.a) && Intrinsics.areEqual(this.b, serpKey.b) && this.c == serpKey.c && Intrinsics.areEqual(this.d, serpKey.d) && Intrinsics.areEqual(this.e, serpKey.e) && Intrinsics.areEqual(this.f, serpKey.f);
    }

    public final int getColumnsCount() {
        return this.c;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final PageParams getPageParams() {
        return this.b;
    }

    @Nullable
    public final SearchDescription getSearchDescription() {
        return this.f;
    }

    @Nullable
    public final String getSearchHint() {
        return this.e;
    }

    @Nullable
    public final String getSubscriptionId() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        PageParams pageParams = this.b;
        int hashCode2 = (((hashCode + (pageParams != null ? pageParams.hashCode() : 0)) * 31) + this.c) * 31;
        String str2 = this.d;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        SearchDescription searchDescription = this.f;
        if (searchDescription != null) {
            i = searchDescription.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SerpKey(id=");
        L.append(this.a);
        L.append(", pageParams=");
        L.append(this.b);
        L.append(", columnsCount=");
        L.append(this.c);
        L.append(", subscriptionId=");
        L.append(this.d);
        L.append(", searchHint=");
        L.append(this.e);
        L.append(", searchDescription=");
        L.append(this.f);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpKey(String str, PageParams pageParams, int i, String str2, String str3, SearchDescription searchDescription, int i2, j jVar) {
        this(str, pageParams, i, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : searchDescription);
    }
}

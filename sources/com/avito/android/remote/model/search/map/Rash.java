package com.avito.android.remote.model.search.map;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.remote.model.search.map.Marker;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b'\u0010(J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u00020\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011R\u001e\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/search/map/Rash;", "Lcom/avito/android/remote/model/search/map/Marker;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "isFavorite", "Z", "()Z", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/search/map/Form;", "form", "Lcom/avito/android/remote/model/search/map/Form;", "getForm", "()Lcom/avito/android/remote/model/search/map/Form;", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "itemsCount", "I", "getItemsCount", "()I", "favoritesIds", "getFavoritesIds", "Lcom/avito/android/remote/model/search/map/Highlight;", ServiceTypeKt.SERVICE_HIGHLIGHT, "Lcom/avito/android/remote/model/search/map/Highlight;", "getHighlight", "()Lcom/avito/android/remote/model/search/map/Highlight;", "<init>", "(Ljava/lang/String;ILcom/avito/android/remote/model/Coordinates;ZLjava/lang/String;Lcom/avito/android/remote/model/search/map/Highlight;Lcom/avito/android/remote/model/search/map/Form;)V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class Rash implements Marker {
    public static final Parcelable.Creator<Rash> CREATOR = new Creator();
    @SerializedName(ParameterId.COORDS)
    @NotNull
    private final Coordinates coordinates;
    @SerializedName("favoritesIds")
    @Nullable
    private final String favoritesIds;
    @SerializedName("form")
    @Nullable
    private final Form form;
    @SerializedName(ServiceTypeKt.SERVICE_HIGHLIGHT)
    @Nullable
    private final Highlight highlight;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("isFavorite")
    private final boolean isFavorite;
    @SerializedName("itemsCount")
    private final int itemsCount;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Rash> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Rash createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Rash(parcel.readString(), parcel.readInt(), (Coordinates) parcel.readParcelable(Rash.class.getClassLoader()), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? (Highlight) Enum.valueOf(Highlight.class, parcel.readString()) : null, parcel.readInt() != 0 ? (Form) Enum.valueOf(Form.class, parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Rash[] newArray(int i) {
            return new Rash[i];
        }
    }

    public Rash(@NotNull String str, int i, @NotNull Coordinates coordinates2, boolean z, @Nullable String str2, @Nullable Highlight highlight2, @Nullable Form form2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        this.id = str;
        this.itemsCount = i;
        this.coordinates = coordinates2;
        this.isFavorite = z;
        this.favoritesIds = str2;
        this.highlight = highlight2;
        this.form = form2;
    }

    @Override // com.avito.android.remote.model.search.map.Marker, android.os.Parcelable
    public int describeContents() {
        return Marker.DefaultImpls.describeContents(this);
    }

    @NotNull
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Nullable
    public final String getFavoritesIds() {
        return this.favoritesIds;
    }

    @Nullable
    public final Form getForm() {
        return this.form;
    }

    @Nullable
    public final Highlight getHighlight() {
        return this.highlight;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getItemsCount() {
        return this.itemsCount;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.itemsCount);
        parcel.writeParcelable(this.coordinates, i);
        parcel.writeInt(this.isFavorite ? 1 : 0);
        parcel.writeString(this.favoritesIds);
        Highlight highlight2 = this.highlight;
        if (highlight2 != null) {
            parcel.writeInt(1);
            parcel.writeString(highlight2.name());
        } else {
            parcel.writeInt(0);
        }
        Form form2 = this.form;
        if (form2 != null) {
            parcel.writeInt(1);
            parcel.writeString(form2.name());
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Rash(String str, int i, Coordinates coordinates2, boolean z, String str2, Highlight highlight2, Form form2, int i2, j jVar) {
        this(str, i, coordinates2, (i2 & 8) != 0 ? false : z, str2, (i2 & 32) != 0 ? null : highlight2, (i2 & 64) != 0 ? null : form2);
    }
}

package com.avito.android.remote.model.search.map;

import a2.b.a.a.a;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b)\u0010*J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u00020\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u001e\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 R\u001c\u0010%\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/search/map/Pin;", "Lcom/avito/android/remote/model/search/map/Marker;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/search/map/Form;", "form", "Lcom/avito/android/remote/model/search/map/Form;", "getForm", "()Lcom/avito/android/remote/model/search/map/Form;", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "", "isFavorite", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/search/map/Highlight;", ServiceTypeKt.SERVICE_HIGHLIGHT, "Lcom/avito/android/remote/model/search/map/Highlight;", "getHighlight", "()Lcom/avito/android/remote/model/search/map/Highlight;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "favoritesIds", "getFavoritesIds", "price", "getPrice", "itemsCount", "I", "getItemsCount", "()I", "<init>", "(Ljava/lang/String;ILcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/search/map/Highlight;Lcom/avito/android/remote/model/search/map/Form;)V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class Pin implements Marker {
    public static final Parcelable.Creator<Pin> CREATOR = new Creator();
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
    @Nullable
    private final Boolean isFavorite;
    @SerializedName("itemsCount")
    private final int itemsCount;
    @SerializedName("price")
    @Nullable
    private final String price;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Pin> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Pin createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            Coordinates coordinates = (Coordinates) parcel.readParcelable(Pin.class.getClassLoader());
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new Pin(readString, readInt, coordinates, readString2, bool, parcel.readString(), parcel.readInt() != 0 ? (Highlight) Enum.valueOf(Highlight.class, parcel.readString()) : null, parcel.readInt() != 0 ? (Form) Enum.valueOf(Form.class, parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Pin[] newArray(int i) {
            return new Pin[i];
        }
    }

    public Pin(@NotNull String str, int i, @NotNull Coordinates coordinates2, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable Highlight highlight2, @Nullable Form form2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        this.id = str;
        this.itemsCount = i;
        this.coordinates = coordinates2;
        this.price = str2;
        this.isFavorite = bool;
        this.favoritesIds = str3;
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

    @Nullable
    public final String getPrice() {
        return this.price;
    }

    @Nullable
    public final Boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.itemsCount);
        parcel.writeParcelable(this.coordinates, i);
        parcel.writeString(this.price);
        Boolean bool = this.isFavorite;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
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
    public /* synthetic */ Pin(String str, int i, Coordinates coordinates2, String str2, Boolean bool, String str3, Highlight highlight2, Form form2, int i2, j jVar) {
        this(str, i, coordinates2, str2, bool, str3, (i2 & 64) != 0 ? null : highlight2, (i2 & 128) != 0 ? null : form2);
    }
}

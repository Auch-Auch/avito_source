package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b$\u0010%J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\tJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\fR\u001c\u0010\u001c\u001a\u00020\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001e\u0010\"\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\f¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/CategoryModel;", "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "isCrossVertical", "Ljava/lang/Boolean;", "isVerticalChange", "()Z", "title", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "()Lcom/avito/android/remote/model/Navigation;", "rootNavigation", "getRootNavigation", "description", "getDescription", "<init>", "(Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public class CategoryModel implements Parcelable {
    public static final Parcelable.Creator<CategoryModel> CREATOR = new Creator();
    @SerializedName(alternate = {MessengerShareContentUtility.SUBTITLE}, value = "description")
    @Nullable
    private final String description;
    @SerializedName("isCrossVertical")
    private final Boolean isCrossVertical;
    @SerializedName("navigation")
    @NotNull
    private final Navigation navigation;
    @SerializedName("rootNavigation")
    @Nullable
    private final Navigation rootNavigation;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CategoryModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Parcelable.Creator<Navigation> creator = Navigation.CREATOR;
            Navigation createFromParcel = creator.createFromParcel(parcel);
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Boolean bool = null;
            Navigation createFromParcel2 = parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new CategoryModel(createFromParcel, readString, readString2, createFromParcel2, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryModel[] newArray(int i) {
            return new CategoryModel[i];
        }
    }

    public CategoryModel(@NotNull Navigation navigation2, @NotNull String str, @Nullable String str2, @Nullable Navigation navigation3, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(navigation2, "navigation");
        Intrinsics.checkNotNullParameter(str, "title");
        this.navigation = navigation2;
        this.title = str;
        this.description = str2;
        this.rootNavigation = navigation3;
        this.isCrossVertical = bool;
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
        return (obj instanceof CategoryModel) && !(Intrinsics.areEqual(this.navigation, ((CategoryModel) obj).navigation) ^ true);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final Navigation getNavigation() {
        return this.navigation;
    }

    @Nullable
    public final Navigation getRootNavigation() {
        return this.rootNavigation;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.navigation.hashCode();
    }

    public final boolean isVerticalChange() {
        Boolean bool = this.isCrossVertical;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder Q = a.Q("CategoryModel(", "navigation=");
        Q.append(this.navigation);
        Q.append(", ");
        Q.append("title='");
        a.m1(Q, this.title, "', ", "isCrossVertical=");
        Q.append(this.isCrossVertical);
        Q.append(", ");
        Q.append("rootNavigation=");
        Q.append(this.rootNavigation);
        Q.append(")");
        return Q.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.navigation.writeToParcel(parcel, 0);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        Navigation navigation2 = this.rootNavigation;
        if (navigation2 != null) {
            parcel.writeInt(1);
            navigation2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.isCrossVertical;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryModel(Navigation navigation2, String str, String str2, Navigation navigation3, Boolean bool, int i, j jVar) {
        this(navigation2, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : navigation3, (i & 16) != 0 ? Boolean.FALSE : bool);
    }
}

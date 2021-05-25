package com.avito.android.remote.model.service_subscription;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/service_subscription/PackageAttribute;", "Landroid/os/Parcelable;", "<init>", "()V", "Monster", "Regular", "Lcom/avito/android/remote/model/service_subscription/PackageAttribute$Regular;", "Lcom/avito/android/remote/model/service_subscription/PackageAttribute$Monster;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class PackageAttribute implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB5\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/service_subscription/PackageAttribute$Monster;", "Lcom/avito/android/remote/model/service_subscription/PackageAttribute;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "locations", "Ljava/util/List;", "getLocations", "()Ljava/util/List;", "Lcom/avito/android/remote/model/service_subscription/PackageAttribute$Monster$Subcategory;", "subcategories", "getSubcategories", "count", "getCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "Subcategory", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Monster extends PackageAttribute {
        public static final Parcelable.Creator<Monster> CREATOR = new Creator();
        @SerializedName("count")
        @Nullable
        private final String count;
        @SerializedName("locations")
        @NotNull
        private final List<String> locations;
        @SerializedName("subcategories")
        @NotNull
        private final List<Subcategory> subcategories;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Monster> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Monster createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Subcategory.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new Monster(readString, readString2, createStringArrayList, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Monster[] newArray(int i) {
                return new Monster[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/service_subscription/PackageAttribute$Monster$Subcategory;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "microcategories", "Ljava/util/List;", "getMicrocategories", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Subcategory implements Parcelable {
            public static final Parcelable.Creator<Subcategory> CREATOR = new Creator();
            @SerializedName("microcategories")
            @Nullable
            private final List<String> microcategories;
            @SerializedName("title")
            @NotNull
            private final String title;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Subcategory> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Subcategory createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Subcategory(parcel.readString(), parcel.createStringArrayList());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Subcategory[] newArray(int i) {
                    return new Subcategory[i];
                }
            }

            public Subcategory(@NotNull String str, @Nullable List<String> list) {
                Intrinsics.checkNotNullParameter(str, "title");
                this.title = str;
                this.microcategories = list;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Nullable
            public final List<String> getMicrocategories() {
                return this.microcategories;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.title);
                parcel.writeStringList(this.microcategories);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Monster(@NotNull String str, @Nullable String str2, @NotNull List<String> list, @NotNull List<Subcategory> list2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "locations");
            Intrinsics.checkNotNullParameter(list2, "subcategories");
            this.title = str;
            this.count = str2;
            this.locations = list;
            this.subcategories = list2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getCount() {
            return this.count;
        }

        @NotNull
        public final List<String> getLocations() {
            return this.locations;
        }

        @NotNull
        public final List<Subcategory> getSubcategories() {
            return this.subcategories;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.count);
            parcel.writeStringList(this.locations);
            Iterator n0 = a.n0(this.subcategories, parcel);
            while (n0.hasNext()) {
                ((Subcategory) n0.next()).writeToParcel(parcel, 0);
            }
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/service_subscription/PackageAttribute$Regular;", "Lcom/avito/android/remote/model/service_subscription/PackageAttribute;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "expiration", "getExpiration", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "count", "getCount", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Regular extends PackageAttribute {
        public static final Parcelable.Creator<Regular> CREATOR = new Creator();
        @SerializedName("count")
        @Nullable
        private final String count;
        @SerializedName("description")
        @Nullable
        private final String description;
        @SerializedName("expiration")
        @Nullable
        private final String expiration;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Regular> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Regular createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Regular(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Regular[] newArray(int i) {
                return new Regular[i];
            }
        }

        public Regular(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            super(null);
            this.title = str;
            this.subtitle = str2;
            this.description = str3;
            this.count = str4;
            this.expiration = str5;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getCount() {
            return this.count;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getExpiration() {
            return this.expiration;
        }

        @Nullable
        public final String getSubtitle() {
            return this.subtitle;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            parcel.writeString(this.description);
            parcel.writeString(this.count);
            parcel.writeString(this.expiration);
        }
    }

    private PackageAttribute() {
    }

    public /* synthetic */ PackageAttribute(j jVar) {
        this();
    }
}

package com.avito.android.remote.models;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001:\u0002*+B9\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJJ\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\tR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010\u0004R$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b&\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b'\u0010\u0004¨\u0006,"}, d2 = {"Lcom/avito/android/remote/models/SparePartsResponse;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;", "component3", "()Ljava/util/List;", "Lcom/avito/android/remote/models/SparePartsResponse$Specification;", "component4", TariffPackageInfoConverterKt.HEADER_STRING_ID, "subheader", "groups", "specifications", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/avito/android/remote/models/SparePartsResponse;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getSpecifications", "Ljava/lang/String;", "getHeader", "getGroups", "getSubheader", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "SparePartsGroup", "Specification", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsResponse implements Parcelable {
    public static final Parcelable.Creator<SparePartsResponse> CREATOR = new Creator();
    @SerializedName("groupings")
    @Nullable
    private final List<SparePartsGroup> groups;
    @SerializedName(TariffPackageInfoConverterKt.HEADER_STRING_ID)
    @NotNull
    private final String header;
    @SerializedName("specifications")
    @Nullable
    private final List<Specification> specifications;
    @SerializedName("subheader")
    @Nullable
    private final String subheader;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SparePartsResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SparePartsResponse createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            ArrayList arrayList2 = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(SparePartsGroup.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList2.add(Specification.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
            }
            return new SparePartsResponse(readString, readString2, arrayList, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SparePartsResponse[] newArray(int i) {
            return new SparePartsResponse[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJT\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00072\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\u0004R$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\tR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b'\u0010\tR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b(\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b)\u0010\u0004¨\u0006,"}, d2 = {"Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/util/List;", "Lcom/avito/android/remote/models/SparePartsResponse$Specification;", "component5", "groupTitle", "text", "buttonText", "groups", "specifications", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getButtonText", "Ljava/util/List;", "getGroups", "getSpecifications", "getGroupTitle", "getText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
    public static final class SparePartsGroup implements Parcelable {
        public static final Parcelable.Creator<SparePartsGroup> CREATOR = new Creator();
        @SerializedName("buttonText")
        @Nullable
        private final String buttonText;
        @SerializedName("groupTitle")
        @NotNull
        private final String groupTitle;
        @SerializedName("groupings")
        @Nullable
        private final List<SparePartsGroup> groups;
        @SerializedName("specifications")
        @Nullable
        private final List<Specification> specifications;
        @SerializedName("text")
        @NotNull
        private final String text;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<SparePartsGroup> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SparePartsGroup createFromParcel(@NotNull Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                ArrayList arrayList2 = null;
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add(SparePartsGroup.CREATOR.createFromParcel(parcel));
                        readInt--;
                    }
                } else {
                    arrayList = null;
                }
                if (parcel.readInt() != 0) {
                    int readInt2 = parcel.readInt();
                    arrayList2 = new ArrayList(readInt2);
                    while (readInt2 != 0) {
                        arrayList2.add(Specification.CREATOR.createFromParcel(parcel));
                        readInt2--;
                    }
                }
                return new SparePartsGroup(readString, readString2, readString3, arrayList, arrayList2);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SparePartsGroup[] newArray(int i) {
                return new SparePartsGroup[i];
            }
        }

        public SparePartsGroup(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<SparePartsGroup> list, @Nullable List<Specification> list2) {
            Intrinsics.checkNotNullParameter(str, "groupTitle");
            Intrinsics.checkNotNullParameter(str2, "text");
            this.groupTitle = str;
            this.text = str2;
            this.buttonText = str3;
            this.groups = list;
            this.specifications = list2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.remote.models.SparePartsResponse$SparePartsGroup */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SparePartsGroup copy$default(SparePartsGroup sparePartsGroup, String str, String str2, String str3, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sparePartsGroup.groupTitle;
            }
            if ((i & 2) != 0) {
                str2 = sparePartsGroup.text;
            }
            if ((i & 4) != 0) {
                str3 = sparePartsGroup.buttonText;
            }
            if ((i & 8) != 0) {
                list = sparePartsGroup.groups;
            }
            if ((i & 16) != 0) {
                list2 = sparePartsGroup.specifications;
            }
            return sparePartsGroup.copy(str, str2, str3, list, list2);
        }

        @NotNull
        public final String component1() {
            return this.groupTitle;
        }

        @NotNull
        public final String component2() {
            return this.text;
        }

        @Nullable
        public final String component3() {
            return this.buttonText;
        }

        @Nullable
        public final List<SparePartsGroup> component4() {
            return this.groups;
        }

        @Nullable
        public final List<Specification> component5() {
            return this.specifications;
        }

        @NotNull
        public final SparePartsGroup copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<SparePartsGroup> list, @Nullable List<Specification> list2) {
            Intrinsics.checkNotNullParameter(str, "groupTitle");
            Intrinsics.checkNotNullParameter(str2, "text");
            return new SparePartsGroup(str, str2, str3, list, list2);
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
            if (!(obj instanceof SparePartsGroup)) {
                return false;
            }
            SparePartsGroup sparePartsGroup = (SparePartsGroup) obj;
            return Intrinsics.areEqual(this.groupTitle, sparePartsGroup.groupTitle) && Intrinsics.areEqual(this.text, sparePartsGroup.text) && Intrinsics.areEqual(this.buttonText, sparePartsGroup.buttonText) && Intrinsics.areEqual(this.groups, sparePartsGroup.groups) && Intrinsics.areEqual(this.specifications, sparePartsGroup.specifications);
        }

        @Nullable
        public final String getButtonText() {
            return this.buttonText;
        }

        @NotNull
        public final String getGroupTitle() {
            return this.groupTitle;
        }

        @Nullable
        public final List<SparePartsGroup> getGroups() {
            return this.groups;
        }

        @Nullable
        public final List<Specification> getSpecifications() {
            return this.specifications;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.groupTitle;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.text;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.buttonText;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            List<SparePartsGroup> list = this.groups;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            List<Specification> list2 = this.specifications;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return hashCode4 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("SparePartsGroup(groupTitle=");
            L.append(this.groupTitle);
            L.append(", text=");
            L.append(this.text);
            L.append(", buttonText=");
            L.append(this.buttonText);
            L.append(", groups=");
            L.append(this.groups);
            L.append(", specifications=");
            return a.w(L, this.specifications, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.groupTitle);
            parcel.writeString(this.text);
            parcel.writeString(this.buttonText);
            List<SparePartsGroup> list = this.groups;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    ((SparePartsGroup) l0.next()).writeToParcel(parcel, 0);
                }
            } else {
                parcel.writeInt(0);
            }
            List<Specification> list2 = this.specifications;
            if (list2 != null) {
                Iterator l02 = a.l0(parcel, 1, list2);
                while (l02.hasNext()) {
                    ((Specification) l02.next()).writeToParcel(parcel, 0);
                }
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/models/SparePartsResponse$Specification;", "Landroid/os/Parcelable;", "", "", "component1", "()Ljava/util/List;", "params", "copy", "(Ljava/util/List;)Lcom/avito/android/remote/models/SparePartsResponse$Specification;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getParams", "<init>", "(Ljava/util/List;)V", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Specification implements Parcelable {
        public static final Parcelable.Creator<Specification> CREATOR = new Creator();
        @SerializedName("params")
        @NotNull
        private final List<String> params;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Specification> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Specification createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Specification(parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Specification[] newArray(int i) {
                return new Specification[i];
            }
        }

        public Specification(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "params");
            this.params = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.models.SparePartsResponse$Specification */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Specification copy$default(Specification specification, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = specification.params;
            }
            return specification.copy(list);
        }

        @NotNull
        public final List<String> component1() {
            return this.params;
        }

        @NotNull
        public final Specification copy(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "params");
            return new Specification(list);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Specification) && Intrinsics.areEqual(this.params, ((Specification) obj).params);
            }
            return true;
        }

        @NotNull
        public final List<String> getParams() {
            return this.params;
        }

        @Override // java.lang.Object
        public int hashCode() {
            List<String> list = this.params;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.w(a.L("Specification(params="), this.params, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeStringList(this.params);
        }
    }

    public SparePartsResponse(@NotNull String str, @Nullable String str2, @Nullable List<SparePartsGroup> list, @Nullable List<Specification> list2) {
        Intrinsics.checkNotNullParameter(str, TariffPackageInfoConverterKt.HEADER_STRING_ID);
        this.header = str;
        this.subheader = str2;
        this.groups = list;
        this.specifications = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.models.SparePartsResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SparePartsResponse copy$default(SparePartsResponse sparePartsResponse, String str, String str2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sparePartsResponse.header;
        }
        if ((i & 2) != 0) {
            str2 = sparePartsResponse.subheader;
        }
        if ((i & 4) != 0) {
            list = sparePartsResponse.groups;
        }
        if ((i & 8) != 0) {
            list2 = sparePartsResponse.specifications;
        }
        return sparePartsResponse.copy(str, str2, list, list2);
    }

    @NotNull
    public final String component1() {
        return this.header;
    }

    @Nullable
    public final String component2() {
        return this.subheader;
    }

    @Nullable
    public final List<SparePartsGroup> component3() {
        return this.groups;
    }

    @Nullable
    public final List<Specification> component4() {
        return this.specifications;
    }

    @NotNull
    public final SparePartsResponse copy(@NotNull String str, @Nullable String str2, @Nullable List<SparePartsGroup> list, @Nullable List<Specification> list2) {
        Intrinsics.checkNotNullParameter(str, TariffPackageInfoConverterKt.HEADER_STRING_ID);
        return new SparePartsResponse(str, str2, list, list2);
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
        if (!(obj instanceof SparePartsResponse)) {
            return false;
        }
        SparePartsResponse sparePartsResponse = (SparePartsResponse) obj;
        return Intrinsics.areEqual(this.header, sparePartsResponse.header) && Intrinsics.areEqual(this.subheader, sparePartsResponse.subheader) && Intrinsics.areEqual(this.groups, sparePartsResponse.groups) && Intrinsics.areEqual(this.specifications, sparePartsResponse.specifications);
    }

    @Nullable
    public final List<SparePartsGroup> getGroups() {
        return this.groups;
    }

    @NotNull
    public final String getHeader() {
        return this.header;
    }

    @Nullable
    public final List<Specification> getSpecifications() {
        return this.specifications;
    }

    @Nullable
    public final String getSubheader() {
        return this.subheader;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.header;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subheader;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<SparePartsGroup> list = this.groups;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<Specification> list2 = this.specifications;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SparePartsResponse(header=");
        L.append(this.header);
        L.append(", subheader=");
        L.append(this.subheader);
        L.append(", groups=");
        L.append(this.groups);
        L.append(", specifications=");
        return a.w(L, this.specifications, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.header);
        parcel.writeString(this.subheader);
        List<SparePartsGroup> list = this.groups;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((SparePartsGroup) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        List<Specification> list2 = this.specifications;
        if (list2 != null) {
            Iterator l02 = a.l0(parcel, 1, list2);
            while (l02.hasNext()) {
                ((Specification) l02.next()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }
}

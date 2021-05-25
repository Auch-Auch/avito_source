package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/core/data/model/ApplicantDataField;", "", "<init>", "()V", "CustomField", "Field", "Lcom/sumsub/sns/core/data/model/ApplicantDataField$Field;", "Lcom/sumsub/sns/core/data/model/ApplicantDataField$CustomField;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class ApplicantDataField {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ.\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0012J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000b\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u001c\u0010\n\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b \u0010\u0005R\u001c\u0010\f\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\f\u0010\t¨\u0006$"}, d2 = {"Lcom/sumsub/sns/core/data/model/ApplicantDataField$CustomField;", "Lcom/sumsub/sns/core/data/model/ApplicantDataField;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "name", "displayName", "isRequired", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lcom/sumsub/sns/core/data/model/ApplicantDataField$CustomField;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDisplayName", "getName", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class CustomField extends ApplicantDataField implements Parcelable {
        public static final Parcelable.Creator<CustomField> CREATOR = new Creator();
        @SerializedName("displayName")
        @NotNull
        private final String displayName;
        @SerializedName("required")
        private final boolean isRequired;
        @SerializedName("name")
        @NotNull
        private final String name;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<CustomField> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CustomField createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new CustomField(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CustomField[] newArray(int i) {
                return new CustomField[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CustomField(@NotNull String str, @NotNull String str2, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "displayName");
            this.name = str;
            this.displayName = str2;
            this.isRequired = z;
        }

        public static /* synthetic */ CustomField copy$default(CustomField customField, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = customField.name;
            }
            if ((i & 2) != 0) {
                str2 = customField.displayName;
            }
            if ((i & 4) != 0) {
                z = customField.isRequired;
            }
            return customField.copy(str, str2, z);
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @NotNull
        public final String component2() {
            return this.displayName;
        }

        public final boolean component3() {
            return this.isRequired;
        }

        @NotNull
        public final CustomField copy(@NotNull String str, @NotNull String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "displayName");
            return new CustomField(str, str2, z);
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
            if (!(obj instanceof CustomField)) {
                return false;
            }
            CustomField customField = (CustomField) obj;
            return Intrinsics.areEqual(this.name, customField.name) && Intrinsics.areEqual(this.displayName, customField.displayName) && this.isRequired == customField.isRequired;
        }

        @NotNull
        public final String getDisplayName() {
            return this.displayName;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.name;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.displayName;
            if (str2 != null) {
                i = str2.hashCode();
            }
            int i2 = (hashCode + i) * 31;
            boolean z = this.isRequired;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i2 + i3;
        }

        public final boolean isRequired() {
            return this.isRequired;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("CustomField(name=");
            L.append(this.name);
            L.append(", displayName=");
            L.append(this.displayName);
            L.append(", isRequired=");
            return a.B(L, this.isRequired, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.name);
            parcel.writeString(this.displayName);
            parcel.writeInt(this.isRequired ? 1 : 0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0012J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u0013\u0010 \u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b \u0010\bR\u001c\u0010\n\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\n\u0010\bR\u0013\u0010\"\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010\bR\u0013\u0010#\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\b¨\u0006&"}, d2 = {"Lcom/sumsub/sns/core/data/model/ApplicantDataField$Field;", "Lcom/sumsub/sns/core/data/model/ApplicantDataField;", "Landroid/os/Parcelable;", "Lcom/sumsub/sns/core/data/model/FieldName;", "component1", "()Lcom/sumsub/sns/core/data/model/FieldName;", "", "component2", "()Z", "name", "isRequired", "copy", "(Lcom/sumsub/sns/core/data/model/FieldName;Z)Lcom/sumsub/sns/core/data/model/ApplicantDataField$Field;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sumsub/sns/core/data/model/FieldName;", "getName", "isCoreRelated", "Z", "isAddressRelated", "isInfoRelated", "<init>", "(Lcom/sumsub/sns/core/data/model/FieldName;Z)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Field extends ApplicantDataField implements Parcelable {
        public static final Parcelable.Creator<Field> CREATOR = new Creator();
        @SerializedName("required")
        private final boolean isRequired;
        @SerializedName("name")
        @NotNull
        private final FieldName name;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Field> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Field createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Field((FieldName) Enum.valueOf(FieldName.class, parcel.readString()), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Field[] newArray(int i) {
                return new Field[i];
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                FieldName.values();
                int[] iArr = new int[25];
                $EnumSwitchMapping$0 = iArr;
                FieldName fieldName = FieldName.country;
                iArr[12] = 1;
                FieldName fieldName2 = FieldName.street;
                iArr[13] = 2;
                FieldName fieldName3 = FieldName.subStreet;
                iArr[14] = 3;
                FieldName fieldName4 = FieldName.buildingNumber;
                iArr[15] = 4;
                FieldName fieldName5 = FieldName.flatNumber;
                iArr[16] = 5;
                FieldName fieldName6 = FieldName.town;
                iArr[17] = 6;
                FieldName fieldName7 = FieldName.state;
                iArr[18] = 7;
                FieldName fieldName8 = FieldName.postCode;
                iArr[19] = 8;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Field(@NotNull FieldName fieldName, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(fieldName, "name");
            this.name = fieldName;
            this.isRequired = z;
        }

        public static /* synthetic */ Field copy$default(Field field, FieldName fieldName, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                fieldName = field.name;
            }
            if ((i & 2) != 0) {
                z = field.isRequired;
            }
            return field.copy(fieldName, z);
        }

        @NotNull
        public final FieldName component1() {
            return this.name;
        }

        public final boolean component2() {
            return this.isRequired;
        }

        @NotNull
        public final Field copy(@NotNull FieldName fieldName, boolean z) {
            Intrinsics.checkNotNullParameter(fieldName, "name");
            return new Field(fieldName, z);
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
            if (!(obj instanceof Field)) {
                return false;
            }
            Field field = (Field) obj;
            return Intrinsics.areEqual(this.name, field.name) && this.isRequired == field.isRequired;
        }

        @NotNull
        public final FieldName getName() {
            return this.name;
        }

        @Override // java.lang.Object
        public int hashCode() {
            FieldName fieldName = this.name;
            int hashCode = (fieldName != null ? fieldName.hashCode() : 0) * 31;
            boolean z = this.isRequired;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return hashCode + i;
        }

        public final boolean isAddressRelated() {
            switch (this.name.ordinal()) {
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    return true;
                default:
                    return false;
            }
        }

        public final boolean isCoreRelated() {
            return this.name == FieldName.email;
        }

        public final boolean isInfoRelated() {
            return !isCoreRelated() && !isAddressRelated();
        }

        public final boolean isRequired() {
            return this.isRequired;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Field(name=");
            L.append(this.name);
            L.append(", isRequired=");
            return a.B(L, this.isRequired, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.name.name());
            parcel.writeInt(this.isRequired ? 1 : 0);
        }
    }

    public ApplicantDataField() {
    }

    public ApplicantDataField(j jVar) {
    }
}

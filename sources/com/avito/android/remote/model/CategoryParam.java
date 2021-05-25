package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002)*B?\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 ¢\u0006\u0004\b'\u0010(J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0013R\u001c\u0010\u001b\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u001c\u0010\u001f\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u001f\u0010\u0017R$\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b&\u0010\u0017¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/CategoryParam;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Entity;", "", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "describeContents", "isMultiple", "Z", "()Z", "id", "Ljava/lang/String;", "getId", "title", "getTitle", "getName", "name", "isImmutable", "", "Lcom/avito/android/remote/model/CategoryParam$ParamValue;", ResidentialComplexModuleKt.VALUES, "Ljava/util/List;", "getValues", "()Ljava/util/List;", "isRequired", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZLjava/util/List;)V", "Companion", "ParamValue", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryParam implements Parcelable, Entity<String> {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CategoryParam> CREATOR = Parcels.creator(CategoryParam$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("immutable")
    private final boolean isImmutable;
    @SerializedName("multiple")
    private final boolean isMultiple;
    @SerializedName("required")
    private final boolean isRequired;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName(ResidentialComplexModuleKt.VALUES)
    @Nullable
    private final List<ParamValue> values;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/CategoryParam$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/CategoryParam;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001$B'\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c¢\u0006\u0004\b\"\u0010#J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\fR\u0016\u0010\u0019\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u001c\u0010\u001a\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\fR$\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/CategoryParam$ParamValue;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Entity;", "", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "toString", "()Ljava/lang/String;", "describeContents", "()I", "", "o", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "id", "Ljava/lang/String;", "getId", "getName", "name", "title", "getTitle", "", "Lcom/avito/android/remote/model/CategoryParam;", "innerParams", "Ljava/util/List;", "getInnerParams", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ParamValue implements Parcelable, Entity<String> {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<ParamValue> CREATOR = Parcels.creator(CategoryParam$ParamValue$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("params")
        @Nullable
        private final List<CategoryParam> innerParams;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/CategoryParam$ParamValue$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/CategoryParam$ParamValue;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public ParamValue(@NotNull String str, @NotNull String str2, @Nullable List<CategoryParam> list) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
            this.innerParams = list;
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
            if (!(obj instanceof ParamValue)) {
                return false;
            }
            return Intrinsics.areEqual(getId(), ((ParamValue) obj).getId());
        }

        @Nullable
        public final List<CategoryParam> getInnerParams() {
            return this.innerParams;
        }

        @Override // com.avito.android.remote.model.Entity
        @NotNull
        public String getName() {
            return this.title;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return getId().hashCode();
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ParamValue[");
            L.append(getId());
            L.append(',');
            L.append(getName());
            L.append(']');
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(getId());
            parcel.writeString(getName());
            ParcelsKt.writeOptimizedParcelableList$default(parcel, this.innerParams, 0, 2, null);
        }

        @Override // com.avito.android.remote.model.Entity
        @NotNull
        public String getId() {
            return this.id;
        }
    }

    public CategoryParam(@NotNull String str, @NotNull String str2, boolean z, boolean z2, boolean z3, @Nullable List<ParamValue> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.isRequired = z;
        this.isImmutable = z2;
        this.isMultiple = z3;
        this.values = list;
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
        if (!(obj instanceof CategoryParam)) {
            return false;
        }
        return Intrinsics.areEqual(getId(), ((CategoryParam) obj).getId());
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getName() {
        return this.title;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final List<ParamValue> getValues() {
        return this.values;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getId().hashCode();
    }

    public final boolean isImmutable() {
        return this.isImmutable;
    }

    public final boolean isMultiple() {
        return this.isMultiple;
    }

    public final boolean isRequired() {
        return this.isRequired;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CategoryParams[");
        L.append(getId());
        L.append(',');
        L.append(getName());
        L.append(']');
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getId());
        parcel.writeString(getName());
        ParcelsKt.writeBool(parcel, this.isRequired);
        ParcelsKt.writeBool(parcel, this.isImmutable);
        ParcelsKt.writeBool(parcel, this.isMultiple);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.values, 0, 2, null);
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getId() {
        return this.id;
    }
}

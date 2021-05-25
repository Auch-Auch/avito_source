package com.avito.android.remote.model;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001aB/\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/SearchProperties;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/SearchProperties$BooleanRule;", "byPrice", "Lcom/avito/android/remote/model/SearchProperties$BooleanRule;", "getByPrice", "()Lcom/avito/android/remote/model/SearchProperties$BooleanRule;", "byDirection", "getByDirection", "byDistrict", "getByDistrict", "byGeo", "getByGeo", "byMetro", "getByMetro", "<init>", "(Lcom/avito/android/remote/model/SearchProperties$BooleanRule;Lcom/avito/android/remote/model/SearchProperties$BooleanRule;Lcom/avito/android/remote/model/SearchProperties$BooleanRule;Lcom/avito/android/remote/model/SearchProperties$BooleanRule;Lcom/avito/android/remote/model/SearchProperties$BooleanRule;)V", "Companion", "BooleanRule", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SearchProperties implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SearchProperties> CREATOR = Parcels.creator(SearchProperties$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("searchByDirection")
    @NotNull
    private final BooleanRule byDirection;
    @SerializedName("searchByDistrict")
    @NotNull
    private final BooleanRule byDistrict;
    @SerializedName("searchByGeo")
    @NotNull
    private final BooleanRule byGeo;
    @SerializedName("searchByMetro")
    @NotNull
    private final BooleanRule byMetro;
    @SerializedName("searchByPrice")
    @NotNull
    private final BooleanRule byPrice;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/SearchProperties$BooleanRule;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/SearchProperties$BooleanRule$Value;", ResidentialComplexModuleKt.VALUES, "Ljava/util/List;", "getValues", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Companion", "Value", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class BooleanRule implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<BooleanRule> CREATOR = Parcels.creator(SearchProperties$BooleanRule$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final List<Value> values;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SearchProperties$BooleanRule$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SearchProperties$BooleanRule;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001aB#\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/SearchProperties$BooleanRule$Value;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Rule;", "", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "paramId", "Ljava/lang/String;", "getParamId", "()Ljava/lang/String;", "valueId", "getValueId", "value", "Z", "getValue", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Value implements Parcelable, Rule<Boolean> {
            @JvmField
            @NotNull
            public static final Parcelable.Creator<Value> CREATOR = Parcels.creator(SearchProperties$BooleanRule$Value$Companion$CREATOR$1.INSTANCE);
            @NotNull
            public static final Companion Companion = new Companion(null);
            @SerializedName("paramId")
            @Nullable
            private final String paramId;
            @SerializedName("value")
            private final boolean value;
            @SerializedName("valueId")
            @Nullable
            private final String valueId;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SearchProperties$BooleanRule$Value$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SearchProperties$BooleanRule$Value;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            public Value(@Nullable String str, @Nullable String str2, boolean z) {
                this.paramId = str;
                this.valueId = str2;
                this.value = z;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // com.avito.android.remote.model.Rule
            @Nullable
            public String getParamId() {
                return this.paramId;
            }

            @Override // com.avito.android.remote.model.Rule
            @Nullable
            public String getValueId() {
                return this.valueId;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "dest");
                parcel.writeString(getParamId());
                parcel.writeString(getValueId());
                ParcelsKt.writeBool(parcel, getValue().booleanValue());
            }

            @Override // com.avito.android.remote.model.Rule
            @NotNull
            public Boolean getValue() {
                return Boolean.valueOf(this.value);
            }
        }

        public BooleanRule(@NotNull List<Value> list) {
            Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
            this.values = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<Value> getValues() {
            return this.values;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            ParcelsKt.writeOptimizedParcelableList(parcel, this.values, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SearchProperties$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SearchProperties;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public SearchProperties(@NotNull BooleanRule booleanRule, @NotNull BooleanRule booleanRule2, @NotNull BooleanRule booleanRule3, @NotNull BooleanRule booleanRule4, @NotNull BooleanRule booleanRule5) {
        Intrinsics.checkNotNullParameter(booleanRule, "byDirection");
        Intrinsics.checkNotNullParameter(booleanRule2, "byPrice");
        Intrinsics.checkNotNullParameter(booleanRule3, "byMetro");
        Intrinsics.checkNotNullParameter(booleanRule4, "byDistrict");
        Intrinsics.checkNotNullParameter(booleanRule5, "byGeo");
        this.byDirection = booleanRule;
        this.byPrice = booleanRule2;
        this.byMetro = booleanRule3;
        this.byDistrict = booleanRule4;
        this.byGeo = booleanRule5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final BooleanRule getByDirection() {
        return this.byDirection;
    }

    @NotNull
    public final BooleanRule getByDistrict() {
        return this.byDistrict;
    }

    @NotNull
    public final BooleanRule getByGeo() {
        return this.byGeo;
    }

    @NotNull
    public final BooleanRule getByMetro() {
        return this.byMetro;
    }

    @NotNull
    public final BooleanRule getByPrice() {
        return this.byPrice;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.byDirection, i);
        parcel.writeParcelable(this.byPrice, i);
        parcel.writeParcelable(this.byMetro, i);
        parcel.writeParcelable(this.byDistrict, i);
        parcel.writeParcelable(this.byGeo, i);
    }
}

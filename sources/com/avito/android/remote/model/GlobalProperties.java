package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/GlobalProperties;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/model/GlobalProperties$PriceRule;", "priceRules", "Ljava/util/List;", "getPriceRules", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Companion", "PriceRule", "models_release"}, k = 1, mv = {1, 4, 2})
public final class GlobalProperties implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<GlobalProperties> CREATOR = Parcels.creator(GlobalProperties$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("price")
    @NotNull
    private final List<PriceRule> priceRules;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/GlobalProperties$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/GlobalProperties;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u001a\u001bB#\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/GlobalProperties$PriceRule;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Rule;", "Lcom/avito/android/remote/model/GlobalProperties$PriceRule$Value;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "value", "Lcom/avito/android/remote/model/GlobalProperties$PriceRule$Value;", "getValue", "()Lcom/avito/android/remote/model/GlobalProperties$PriceRule$Value;", "", "paramId", "Ljava/lang/String;", "getParamId", "()Ljava/lang/String;", "valueId", "getValueId", "<init>", "(Lcom/avito/android/remote/model/GlobalProperties$PriceRule$Value;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "Value", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class PriceRule implements Parcelable, Rule<Value> {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<PriceRule> CREATOR = Parcels.creator(GlobalProperties$PriceRule$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("paramId")
        @Nullable
        private final String paramId;
        @SerializedName("value")
        @NotNull
        private final Value value;
        @SerializedName("valueId")
        @Nullable
        private final String valueId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/GlobalProperties$PriceRule$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/GlobalProperties$PriceRule;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B#\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/GlobalProperties$PriceRule$Value;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "postfix", "Ljava/lang/String;", "getPostfix", "()Ljava/lang/String;", "fullTitle", "getFullTitle", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Value implements Parcelable {
            @JvmField
            @NotNull
            public static final Parcelable.Creator<Value> CREATOR = Parcels.creator(GlobalProperties$PriceRule$Value$Companion$CREATOR$1.INSTANCE);
            @NotNull
            public static final Companion Companion = new Companion(null);
            @Nullable
            private final String fullTitle;
            @Nullable
            private final String postfix;
            @NotNull
            private final String title;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/GlobalProperties$PriceRule$Value$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/GlobalProperties$PriceRule$Value;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            public Value(@NotNull String str, @Nullable String str2, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(str, "title");
                this.title = str;
                this.fullTitle = str2;
                this.postfix = str3;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Nullable
            public final String getFullTitle() {
                return this.fullTitle;
            }

            @Nullable
            public final String getPostfix() {
                return this.postfix;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "dest");
                parcel.writeString(this.title);
                parcel.writeString(this.fullTitle);
                parcel.writeString(this.postfix);
            }
        }

        public PriceRule(@NotNull Value value2, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(value2, "value");
            this.value = value2;
            this.paramId = str;
            this.valueId = str2;
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
            parcel.writeParcelable(getValue(), i);
            parcel.writeString(getParamId());
            parcel.writeString(getValueId());
        }

        @Override // com.avito.android.remote.model.Rule
        @NotNull
        public Value getValue() {
            return this.value;
        }
    }

    public GlobalProperties(@NotNull List<PriceRule> list) {
        Intrinsics.checkNotNullParameter(list, "priceRules");
        this.priceRules = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<PriceRule> getPriceRules() {
        return this.priceRules;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeOptimizedParcelableList(parcel, this.priceRules, i);
    }
}

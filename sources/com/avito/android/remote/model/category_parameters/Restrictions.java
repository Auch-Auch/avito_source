package com.avito.android.remote.model.category_parameters;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Restrictions;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/category_parameters/Restrictions$Limit;", "limit", "Lcom/avito/android/remote/model/category_parameters/Restrictions$Limit;", "getLimit", "()Lcom/avito/android/remote/model/category_parameters/Restrictions$Limit;", "<init>", "(Lcom/avito/android/remote/model/category_parameters/Restrictions$Limit;)V", "Companion", "Limit", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Restrictions implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Restrictions> CREATOR = Parcels.creator(Restrictions$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("limit")
    @Nullable
    private final Limit limit;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Restrictions$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/Restrictions;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Restrictions$Limit;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "max", "Ljava/lang/Long;", "getMax", "()Ljava/lang/Long;", "min", "getMin", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Limit implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Limit> CREATOR = Parcels.creator(Restrictions$Limit$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("max")
        @Nullable
        private final Long max;
        @SerializedName("min")
        @Nullable
        private final Long min;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Restrictions$Limit$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/Restrictions$Limit;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public Limit() {
            this(null, null, 3, null);
        }

        public Limit(@Nullable Long l, @Nullable Long l2) {
            this.min = l;
            this.max = l2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Long getMax() {
            return this.max;
        }

        @Nullable
        public final Long getMin() {
            return this.min;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            ParcelsKt.writeNullableValue(parcel, this.min);
            ParcelsKt.writeNullableValue(parcel, this.max);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Limit(Long l, Long l2, int i, j jVar) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2);
        }
    }

    public Restrictions() {
        this(null, 1, null);
    }

    public Restrictions(@Nullable Limit limit2) {
        this.limit = limit2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Limit getLimit() {
        return this.limit;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.limit, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Restrictions(Limit limit2, int i, j jVar) {
        this((i & 1) != 0 ? null : limit2);
    }
}

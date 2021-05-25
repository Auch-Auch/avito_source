package com.avito.android.remote.model.category_parameters;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\"#$%&'()BA\b\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u001f\u0001\u0006*+,-./¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "message", "getMessage", "", "Lcom/avito/android/remote/model/category_parameters/Condition;", "conditions", "Ljava/util/List;", "getConditions", "()Ljava/util/List;", "setConditions", "(Ljava/util/List;)V", "severity", "getSeverity", "conditionFlow", "getConditionFlow", "setConditionFlow", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "ConditionFlow", "DistinctFrom", "EqualTo", "Length", "Limit", "RangeConstraint", "Regex", "Severity", "Lcom/avito/android/remote/model/category_parameters/Constraint$Limit;", "Lcom/avito/android/remote/model/category_parameters/Constraint$Length;", "Lcom/avito/android/remote/model/category_parameters/Constraint$Regex;", "Lcom/avito/android/remote/model/category_parameters/Constraint$EqualTo;", "Lcom/avito/android/remote/model/category_parameters/Constraint$DistinctFrom;", "Lcom/avito/android/remote/model/category_parameters/Constraint$RangeConstraint;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class Constraint implements Parcelable {
    @Nullable
    private String conditionFlow;
    @Nullable
    private List<? extends Condition> conditions;
    @SerializedName("message")
    @Nullable
    private final String message;
    @SerializedName("severity")
    @Nullable
    private final String severity;
    @SerializedName("tag")
    @Nullable
    private final String tag;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$ConditionFlow;", "", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ConditionFlow {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018BK\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$DistinctFrom;", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "Lcom/avito/android/remote/model/category_parameters/DependentConstraint;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "dependentId", "Ljava/lang/String;", "getDependentId", "()Ljava/lang/String;", "message", "severity", "tag", "", "Lcom/avito/android/remote/model/category_parameters/Condition;", "conditions", "conditionFlow", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class DistinctFrom extends Constraint implements DependentConstraint {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<DistinctFrom> CREATOR = Parcels.creator(Constraint$DistinctFrom$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("id")
        @NotNull
        private final String dependentId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$DistinctFrom$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/Constraint$DistinctFrom;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DistinctFrom(String str, String str2, String str3, String str4, List list, String str5, int i, j jVar) {
            this(str, str2, str3, str4, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : str5);
        }

        @Override // com.avito.android.remote.model.category_parameters.DependentConstraint
        @NotNull
        public String getDependentId() {
            return this.dependentId;
        }

        @Override // com.avito.android.remote.model.category_parameters.Constraint, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            Constraint.super.writeToParcel(parcel, i);
            parcel.writeString(getDependentId());
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DistinctFrom(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable List<? extends Condition> list, @Nullable String str5) {
            super(str2, str3, str4, list, str5, null);
            Intrinsics.checkNotNullParameter(str, "dependentId");
            this.dependentId = str;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018BK\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$EqualTo;", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "Lcom/avito/android/remote/model/category_parameters/DependentConstraint;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "dependentId", "Ljava/lang/String;", "getDependentId", "()Ljava/lang/String;", "message", "severity", "tag", "", "Lcom/avito/android/remote/model/category_parameters/Condition;", "conditions", "conditionFlow", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class EqualTo extends Constraint implements DependentConstraint {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<EqualTo> CREATOR = Parcels.creator(Constraint$EqualTo$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("id")
        @NotNull
        private final String dependentId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$EqualTo$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/Constraint$EqualTo;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ EqualTo(String str, String str2, String str3, String str4, List list, String str5, int i, j jVar) {
            this(str, str2, str3, str4, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : str5);
        }

        @Override // com.avito.android.remote.model.category_parameters.DependentConstraint
        @NotNull
        public String getDependentId() {
            return this.dependentId;
        }

        @Override // com.avito.android.remote.model.category_parameters.Constraint, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            Constraint.super.writeToParcel(parcel, i);
            parcel.writeString(getDependentId());
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EqualTo(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable List<? extends Condition> list, @Nullable String str5) {
            super(str2, str3, str4, list, str5, null);
            Intrinsics.checkNotNullParameter(str, "dependentId");
            this.dependentId = str;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBW\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$Length;", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "min", "Ljava/lang/Long;", "getMin", "()Ljava/lang/Long;", "max", "getMax", "", "message", "severity", "tag", "", "Lcom/avito/android/remote/model/category_parameters/Condition;", "conditions", "conditionFlow", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Length extends Constraint {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Length> CREATOR = Parcels.creator(Constraint$Length$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("max")
        @Nullable
        private final Long max;
        @SerializedName("min")
        @Nullable
        private final Long min;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$Length$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/Constraint$Length;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Length(Long l, Long l2, String str, String str2, String str3, List list, String str4, int i, j jVar) {
            this(l, l2, str, str2, str3, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : str4);
        }

        @Nullable
        public final Long getMax() {
            return this.max;
        }

        @Nullable
        public final Long getMin() {
            return this.min;
        }

        @Override // com.avito.android.remote.model.category_parameters.Constraint, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            Constraint.super.writeToParcel(parcel, i);
            ParcelsKt.writeNullableValue(parcel, this.min);
            ParcelsKt.writeNullableValue(parcel, this.max);
        }

        public Length(@Nullable Long l, @Nullable Long l2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<? extends Condition> list, @Nullable String str4) {
            super(str, str2, str3, list, str4, null);
            this.min = l;
            this.max = l2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBW\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$Limit;", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "min", "Ljava/lang/Long;", "getMin", "()Ljava/lang/Long;", "max", "getMax", "", "severity", "message", "tag", "", "Lcom/avito/android/remote/model/category_parameters/Condition;", "conditions", "conditionFlow", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Limit extends Constraint {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Limit> CREATOR = Parcels.creator(Constraint$Limit$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("max")
        @Nullable
        private final Long max;
        @SerializedName("min")
        @Nullable
        private final Long min;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$Limit$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/Constraint$Limit;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Limit(Long l, Long l2, String str, String str2, String str3, List list, String str4, int i, j jVar) {
            this(l, l2, str, str2, str3, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : str4);
        }

        @Nullable
        public final Long getMax() {
            return this.max;
        }

        @Nullable
        public final Long getMin() {
            return this.min;
        }

        @Override // com.avito.android.remote.model.category_parameters.Constraint, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            Constraint.super.writeToParcel(parcel, i);
            ParcelsKt.writeNullableValue(parcel, this.min);
            ParcelsKt.writeNullableValue(parcel, this.max);
        }

        public Limit(@Nullable Long l, @Nullable Long l2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<? extends Condition> list, @Nullable String str4) {
            super(str2, str, str3, list, str4, null);
            this.min = l;
            this.max = l2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013BG\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$RangeConstraint;", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "message", "severity", "tag", "", "Lcom/avito/android/remote/model/category_parameters/Condition;", "conditions", "conditionFlow", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class RangeConstraint extends Constraint {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<RangeConstraint> CREATOR = Parcels.creator(Constraint$RangeConstraint$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$RangeConstraint$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/Constraint$RangeConstraint;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RangeConstraint(String str, String str2, String str3, List list, String str4, int i, j jVar) {
            this(str, (i & 2) != 0 ? "error" : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : str4);
        }

        @Override // com.avito.android.remote.model.category_parameters.Constraint, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            Constraint.super.writeToParcel(parcel, i);
        }

        public RangeConstraint(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<? extends Condition> list, @Nullable String str4) {
            super(str, str2, str3, list, str4, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBU\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$Regex;", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "regex", "Ljava/lang/String;", "getRegex", "()Ljava/lang/String;", "", "passOnMatch", "Ljava/lang/Boolean;", "getPassOnMatch", "()Ljava/lang/Boolean;", "message", "severity", "tag", "", "Lcom/avito/android/remote/model/category_parameters/Condition;", "conditions", "conditionFlow", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Regex extends Constraint {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Regex> CREATOR = Parcels.creator(Constraint$Regex$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("passOnMatch")
        @Nullable
        private final Boolean passOnMatch;
        @SerializedName("regexp")
        @NotNull
        private final String regex;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$Regex$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/Constraint$Regex;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Regex(String str, Boolean bool, String str2, String str3, String str4, List list, String str5, int i, j jVar) {
            this(str, bool, str2, str3, str4, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : str5);
        }

        @Nullable
        public final Boolean getPassOnMatch() {
            return this.passOnMatch;
        }

        @NotNull
        public final String getRegex() {
            return this.regex;
        }

        @Override // com.avito.android.remote.model.category_parameters.Constraint, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            Constraint.super.writeToParcel(parcel, i);
            parcel.writeString(this.regex);
            ParcelsKt.writeNullableValue(parcel, this.passOnMatch);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Regex(@NotNull String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable List<? extends Condition> list, @Nullable String str5) {
            super(str2, str3, str4, list, str5, null);
            Intrinsics.checkNotNullParameter(str, "regex");
            this.regex = str;
            this.passOnMatch = bool;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Constraint$Severity;", "", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Severity {
    }

    private Constraint(String str, String str2, String str3, List<? extends Condition> list, String str4) {
        this.message = str;
        this.severity = str2;
        this.tag = str3;
        this.conditions = list;
        this.conditionFlow = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getConditionFlow() {
        return this.conditionFlow;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.avito.android.remote.model.category_parameters.Condition>, java.util.List<com.avito.android.remote.model.category_parameters.Condition> */
    @Nullable
    public final List<Condition> getConditions() {
        return this.conditions;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getSeverity() {
        return this.severity;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    public final void setConditionFlow(@Nullable String str) {
        this.conditionFlow = str;
    }

    public final void setConditions(@Nullable List<? extends Condition> list) {
        this.conditions = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.message);
        parcel.writeString(this.severity);
        parcel.writeString(this.tag);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.conditions, 0, 2, null);
        parcel.writeString(this.conditionFlow);
    }

    public /* synthetic */ Constraint(String str, String str2, String str3, List list, String str4, j jVar) {
        this(str, str2, str3, list, str4);
    }
}

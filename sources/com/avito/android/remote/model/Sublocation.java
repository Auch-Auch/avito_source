package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.UrlParams;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/Sublocation;", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "Type", "models_release"}, k = 1, mv = {1, 4, 2})
public interface Sublocation extends ParcelableEntity<String> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\nR\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u0001\u0003\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/Sublocation$Type;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "idParam", "Ljava/lang/String;", "getIdParam", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Direction", "District", "Metro", "Lcom/avito/android/remote/model/Sublocation$Type$Metro;", "Lcom/avito/android/remote/model/Sublocation$Type$District;", "Lcom/avito/android/remote/model/Sublocation$Type$Direction;", "models_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Type implements Parcelable {
        @NotNull
        private final String idParam;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/model/Sublocation$Type$Direction;", "Lcom/avito/android/remote/model/Sublocation$Type;", "<init>", "()V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Direction extends Type {
            @JvmField
            @NotNull
            public static final Parcelable.Creator<Direction> CREATOR = Parcels.creator(Sublocation$Type$Direction$Companion$CREATOR$1.INSTANCE);
            @NotNull
            public static final Companion Companion = new Companion(null);

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/Sublocation$Type$Direction$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/Sublocation$Type$Direction;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            public Direction() {
                super(UrlParams.DIRECTION_ID, null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/model/Sublocation$Type$District;", "Lcom/avito/android/remote/model/Sublocation$Type;", "<init>", "()V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class District extends Type {
            @JvmField
            @NotNull
            public static final Parcelable.Creator<District> CREATOR = Parcels.creator(Sublocation$Type$District$Companion$CREATOR$1.INSTANCE);
            @NotNull
            public static final Companion Companion = new Companion(null);

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/Sublocation$Type$District$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/Sublocation$Type$District;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            public District() {
                super(UrlParams.DISTRICT_ID, null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/model/Sublocation$Type$Metro;", "Lcom/avito/android/remote/model/Sublocation$Type;", "<init>", "()V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Metro extends Type {
            @JvmField
            @NotNull
            public static final Parcelable.Creator<Metro> CREATOR = Parcels.creator(Sublocation$Type$Metro$Companion$CREATOR$1.INSTANCE);
            @NotNull
            public static final Companion Companion = new Companion(null);

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/Sublocation$Type$Metro$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/Sublocation$Type$Metro;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            public Metro() {
                super(UrlParams.METRO_ID, null);
            }
        }

        private Type(String str) {
            this.idParam = str;
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
            if (!Intrinsics.areEqual(obj != null ? obj.getClass() : null, getClass())) {
                return false;
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.remote.model.Sublocation.Type");
            return !(Intrinsics.areEqual(this.idParam, ((Type) obj).idParam) ^ true);
        }

        @NotNull
        public final String getIdParam() {
            return this.idParam;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.idParam.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@Nullable Parcel parcel, int i) {
        }

        public /* synthetic */ Type(String str, j jVar) {
            this(str);
        }
    }
}

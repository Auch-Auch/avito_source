package com.avito.android.krop.util;

import a2.b.a.a.a;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B!\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b(\u0010)B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b(\u0010*J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0010R\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\rR\u0019\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010$\u001a\u0004\b'\u0010\r¨\u0006,"}, d2 = {"Lcom/avito/android/krop/util/Transformation;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()F", "Landroid/graphics/PointF;", "component2", "()Landroid/graphics/PointF;", "component3", "scale", "focusOffset", "rotationAngle", "copy", "(FLandroid/graphics/PointF;F)Lcom/avito/android/krop/util/Transformation;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Landroid/graphics/PointF;", "getFocusOffset", "c", "F", "getRotationAngle", AuthSource.SEND_ABUSE, "getScale", "<init>", "(FLandroid/graphics/PointF;F)V", "(Landroid/os/Parcel;)V", "CREATOR", "krop_release"}, k = 1, mv = {1, 4, 0})
public final class Transformation implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    public final float a;
    @NotNull
    public final PointF b;
    public final float c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/krop/util/Transformation$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/krop/util/Transformation;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/krop/util/Transformation;", "", "size", "", "newArray", "(I)[Lcom/avito/android/krop/util/Transformation;", "<init>", "()V", "krop_release"}, k = 1, mv = {1, 4, 0})
    public static final class CREATOR implements Parcelable.Creator<Transformation> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public Transformation createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new Transformation(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public Transformation[] newArray(int i) {
            return new Transformation[i];
        }
    }

    public Transformation(float f, @NotNull PointF pointF, float f2) {
        Intrinsics.checkParameterIsNotNull(pointF, "focusOffset");
        this.a = f;
        this.b = pointF;
        this.c = f2;
    }

    public static /* synthetic */ Transformation copy$default(Transformation transformation, float f, PointF pointF, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = transformation.a;
        }
        if ((i & 2) != 0) {
            pointF = transformation.b;
        }
        if ((i & 4) != 0) {
            f2 = transformation.c;
        }
        return transformation.copy(f, pointF, f2);
    }

    public final float component1() {
        return this.a;
    }

    @NotNull
    public final PointF component2() {
        return this.b;
    }

    public final float component3() {
        return this.c;
    }

    @NotNull
    public final Transformation copy(float f, @NotNull PointF pointF, float f2) {
        Intrinsics.checkParameterIsNotNull(pointF, "focusOffset");
        return new Transformation(f, pointF, f2);
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
        if (!(obj instanceof Transformation)) {
            return false;
        }
        Transformation transformation = (Transformation) obj;
        return Float.compare(this.a, transformation.a) == 0 && Intrinsics.areEqual(this.b, transformation.b) && Float.compare(this.c, transformation.c) == 0;
    }

    @NotNull
    public final PointF getFocusOffset() {
        return this.b;
    }

    public final float getRotationAngle() {
        return this.c;
    }

    public final float getScale() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.a) * 31;
        PointF pointF = this.b;
        return Float.floatToIntBits(this.c) + ((floatToIntBits + (pointF != null ? pointF.hashCode() : 0)) * 31);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Transformation(scale=");
        L.append(this.a);
        L.append(", focusOffset=");
        L.append(this.b);
        L.append(", rotationAngle=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeFloat(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeFloat(this.c);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Transformation(float f, PointF pointF, float f2, int i, j jVar) {
        this(f, pointF, (i & 4) != 0 ? 0.0f : f2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Transformation(@org.jetbrains.annotations.NotNull android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            float r0 = r4.readFloat()
            java.lang.Class<android.graphics.PointF> r1 = android.graphics.PointF.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r4.readParcelable(r1)
            java.lang.String r2 = "parcel.readParcelable(Po…::class.java.classLoader)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            float r4 = r4.readFloat()
            r3.<init>(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.krop.util.Transformation.<init>(android.os.Parcel):void");
    }
}

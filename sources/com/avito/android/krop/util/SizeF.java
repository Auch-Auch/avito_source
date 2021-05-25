package com.avito.android.krop.util;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u0000 !2\u00020\u0001:\u0001!B\u001b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010 J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u0013\u0010\u001d\u001a\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\n¨\u0006\""}, d2 = {"Lcom/avito/android/krop/util/SizeF;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "getWidthInt", "widthInt", "", AuthSource.SEND_ABUSE, "F", "getWidth", "()F", "setWidth", "(F)V", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, AuthSource.BOOKING_ORDER, "getHeight", "setHeight", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "getHeightInt", "heightInt", "<init>", "(FF)V", "(Landroid/os/Parcel;)V", "CREATOR", "krop_release"}, k = 1, mv = {1, 4, 0})
public final class SizeF implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    public float a;
    public float b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/krop/util/SizeF$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/krop/util/SizeF;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/krop/util/SizeF;", "", "size", "", "newArray", "(I)[Lcom/avito/android/krop/util/SizeF;", "<init>", "()V", "krop_release"}, k = 1, mv = {1, 4, 0})
    public static final class CREATOR implements Parcelable.Creator<SizeF> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public SizeF createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new SizeF(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public SizeF[] newArray(int i) {
            return new SizeF[i];
        }
    }

    public SizeF() {
        this(0.0f, 0.0f, 3, null);
    }

    public SizeF(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final float getHeight() {
        return this.b;
    }

    public final int getHeightInt() {
        return (int) this.b;
    }

    public final float getWidth() {
        return this.a;
    }

    public final int getWidthInt() {
        return (int) this.a;
    }

    public final void setHeight(float f) {
        this.b = f;
    }

    public final void setWidth(float f) {
        this.a = f;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SizeF(width=");
        L.append(getWidthInt());
        L.append(", height=");
        L.append(getHeightInt());
        L.append(')');
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.b);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SizeF(float f, float f2, int i, j jVar) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SizeF(@NotNull Parcel parcel) {
        this(parcel.readFloat(), parcel.readFloat());
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
    }
}

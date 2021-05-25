package com.avito.android.avito_map;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapTarget;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/avito_map/AvitoMapPoint;", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/AvitoMapPoint;", "getPoint", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "", AuthSource.BOOKING_ORDER, "F", "getZoomLevel", "()F", "zoomLevel", "<init>", "(Lcom/avito/android/avito_map/AvitoMapPoint;F)V", "(Landroid/os/Parcel;)V", "CREATOR", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoMapTarget implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @NotNull
    public final AvitoMapPoint a;
    public final float b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapTarget$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/avito_map/AvitoMapTarget;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/avito_map/AvitoMapTarget;", "", "size", "", "newArray", "(I)[Lcom/avito/android/avito_map/AvitoMapTarget;", "<init>", "()V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<AvitoMapTarget> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AvitoMapTarget createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AvitoMapTarget(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AvitoMapTarget[] newArray(int i) {
            return new AvitoMapTarget[i];
        }
    }

    public AvitoMapTarget(@NotNull AvitoMapPoint avitoMapPoint, float f) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "point");
        this.a = avitoMapPoint;
        this.b = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final AvitoMapPoint getPoint() {
        return this.a;
    }

    public final float getZoomLevel() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeFloat(this.b);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AvitoMapTarget(@org.jetbrains.annotations.NotNull android.os.Parcel r2) {
        /*
            r1 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.Class<com.avito.android.avito_map.AvitoMapPoint> r0 = com.avito.android.avito_map.AvitoMapPoint.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r2.readParcelable(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.avito.android.avito_map.AvitoMapPoint r0 = (com.avito.android.avito_map.AvitoMapPoint) r0
            float r2 = r2.readFloat()
            r1.<init>(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.avito_map.AvitoMapTarget.<init>(android.os.Parcel):void");
    }
}

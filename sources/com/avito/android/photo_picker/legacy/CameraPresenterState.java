package com.avito.android.photo_picker.legacy;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0019\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\rR\u0019\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0010¨\u0006'"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraPresenterState;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/photo_picker/legacy/CameraType;", "component1", "()Lcom/avito/android/photo_picker/legacy/CameraType;", "Lcom/avito/android/photo_picker/legacy/FlashMode;", "component2", "()Lcom/avito/android/photo_picker/legacy/FlashMode;", "cameraType", "flashMode", "copy", "(Lcom/avito/android/photo_picker/legacy/CameraType;Lcom/avito/android/photo_picker/legacy/FlashMode;)Lcom/avito/android/photo_picker/legacy/CameraPresenterState;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/CameraType;", "getCameraType", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/FlashMode;", "getFlashMode", "<init>", "(Lcom/avito/android/photo_picker/legacy/CameraType;Lcom/avito/android/photo_picker/legacy/FlashMode;)V", "Companion", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraPresenterState implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CameraPresenterState> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    public final CameraType a;
    @NotNull
    public final FlashMode b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraPresenterState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/photo_picker/legacy/CameraPresenterState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, CameraPresenterState> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CameraPresenterState invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new CameraPresenterState((CameraType) parcel2.readParcelable(CameraType.class.getClassLoader()), (FlashMode) a2.b.a.a.a.z1(FlashMode.class, parcel2));
        }
    }

    public CameraPresenterState(@Nullable CameraType cameraType, @NotNull FlashMode flashMode) {
        Intrinsics.checkNotNullParameter(flashMode, "flashMode");
        this.a = cameraType;
        this.b = flashMode;
    }

    public static /* synthetic */ CameraPresenterState copy$default(CameraPresenterState cameraPresenterState, CameraType cameraType, FlashMode flashMode, int i, Object obj) {
        if ((i & 1) != 0) {
            cameraType = cameraPresenterState.a;
        }
        if ((i & 2) != 0) {
            flashMode = cameraPresenterState.b;
        }
        return cameraPresenterState.copy(cameraType, flashMode);
    }

    @Nullable
    public final CameraType component1() {
        return this.a;
    }

    @NotNull
    public final FlashMode component2() {
        return this.b;
    }

    @NotNull
    public final CameraPresenterState copy(@Nullable CameraType cameraType, @NotNull FlashMode flashMode) {
        Intrinsics.checkNotNullParameter(flashMode, "flashMode");
        return new CameraPresenterState(cameraType, flashMode);
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
        if (!(obj instanceof CameraPresenterState)) {
            return false;
        }
        CameraPresenterState cameraPresenterState = (CameraPresenterState) obj;
        return Intrinsics.areEqual(this.a, cameraPresenterState.a) && Intrinsics.areEqual(this.b, cameraPresenterState.b);
    }

    @Nullable
    public final CameraType getCameraType() {
        return this.a;
    }

    @NotNull
    public final FlashMode getFlashMode() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        CameraType cameraType = this.a;
        int i = 0;
        int hashCode = (cameraType != null ? cameraType.hashCode() : 0) * 31;
        FlashMode flashMode = this.b;
        if (flashMode != null) {
            i = flashMode.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("CameraPresenterState(cameraType=");
        L.append(this.a);
        L.append(", flashMode=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
        }
    }
}

package com.avito.android.photo_picker.legacy;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000f2\u00020\u0001:\u0003\u0010\u000f\u0011J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\n\u0001\u0002\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraType;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", AuthSource.SEND_ABUSE, "I", "getIndex", FirebaseAnalytics.Param.INDEX, "Companion", "BackCamera", "FrontCamera", "Lcom/avito/android/photo_picker/legacy/CameraType$BackCamera;", "Lcom/avito/android/photo_picker/legacy/CameraType$FrontCamera;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public abstract class CameraType implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CameraType> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraType$BackCamera;", "Lcom/avito/android/photo_picker/legacy/CameraType;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class BackCamera extends CameraType {
        @NotNull
        public static final BackCamera INSTANCE = new BackCamera();

        public BackCamera() {
            super(0, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraType$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/photo_picker/legacy/CameraType;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraType$FrontCamera;", "Lcom/avito/android/photo_picker/legacy/CameraType;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class FrontCamera extends CameraType {
        @NotNull
        public static final FrontCamera INSTANCE = new FrontCamera();

        public FrontCamera() {
            super(1, null);
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, CameraType> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CameraType invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            CameraType cameraTypeByIndex = CameraTypeKt.getCameraTypeByIndex(parcel2.readInt());
            return cameraTypeByIndex != null ? cameraTypeByIndex : BackCamera.INSTANCE;
        }
    }

    public CameraType(int i, j jVar) {
        this.a = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getIndex() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeInt(this.a);
        }
    }
}

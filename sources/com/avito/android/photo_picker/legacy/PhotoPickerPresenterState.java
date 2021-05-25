package com.avito.android.photo_picker.legacy;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.photo_picker.SelectedPhoto;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB1\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR!\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/photo_picker/SelectedPhoto;", "c", "Ljava/util/List;", "getSelectedPhotos", "()Ljava/util/List;", "selectedPhotos", "Lcom/avito/android/photo_picker/legacy/PickerPhoto;", AuthSource.BOOKING_ORDER, "getLoadingPhotos", "loadingPhotos", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSelectedImageId", "()Ljava/lang/String;", "selectedImageId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "Companion", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerPresenterState implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PhotoPickerPresenterState> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @Nullable
    public final List<PickerPhoto> b;
    @Nullable
    public final List<SelectedPhoto> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, PhotoPickerPresenterState> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PhotoPickerPresenterState invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new PhotoPickerPresenterState(a2.b.a.a.a.u2(parcel2, "readString()!!"), ParcelsKt.createParcelableList(parcel2, PickerPhoto.class), ParcelsKt.createParcelableList(parcel2, SelectedPhoto.class));
        }
    }

    public PhotoPickerPresenterState(@NotNull String str, @Nullable List<PickerPhoto> list, @Nullable List<SelectedPhoto> list2) {
        Intrinsics.checkNotNullParameter(str, "selectedImageId");
        this.a = str;
        this.b = list;
        this.c = list2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<PickerPhoto> getLoadingPhotos() {
        return this.b;
    }

    @NotNull
    public final String getSelectedImageId() {
        return this.a;
    }

    @Nullable
    public final List<SelectedPhoto> getSelectedPhotos() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeString(this.a);
            ParcelsKt.writeOptimizedParcelableList$default(parcel, this.b, 0, 2, null);
            ParcelsKt.writeOptimizedParcelableList$default(parcel, this.c, 0, 2, null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoPickerPresenterState(String str, List list, List list2, int i, j jVar) {
        this(str, list, (i & 4) != 0 ? null : list2);
    }
}

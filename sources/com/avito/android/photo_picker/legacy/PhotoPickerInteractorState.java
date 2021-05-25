package com.avito.android.photo_picker.legacy;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntProgression;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractorState;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/photo_picker/legacy/PickerPhoto;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getPhotosCache", "()Ljava/util/List;", "photosCache", "<init>", "(Ljava/util/List;)V", "Companion", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerInteractorState implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PhotoPickerInteractorState> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final List<PickerPhoto> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractorState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractorState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, PhotoPickerInteractorState> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PhotoPickerInteractorState invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            IntProgression downTo = e.downTo(parcel2.readInt(), 1);
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(downTo, 10));
            Iterator it = downTo.iterator();
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                Parcelable readParcelable = parcel2.readParcelable(PickerPhoto.class.getClassLoader());
                Intrinsics.checkNotNull(readParcelable);
                arrayList.add((PickerPhoto) readParcelable);
            }
            return new PhotoPickerInteractorState(arrayList);
        }
    }

    public PhotoPickerInteractorState(@NotNull List<PickerPhoto> list) {
        Intrinsics.checkNotNullParameter(list, "photosCache");
        this.a = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<PickerPhoto> getPhotosCache() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.a.size());
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), i);
        }
    }
}

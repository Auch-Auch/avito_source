package com.avito.android.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 :*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003:\u0001:B\u0011\b\u0016\u0012\u0006\u00105\u001a\u00020\u0004¢\u0006\u0004\b6\u0010\fB\u0019\b\u0016\u0012\u000e\u00104\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000101¢\u0006\u0004\b6\u00107B\u0013\b\u0014\u0012\b\u00108\u001a\u0004\u0018\u00010$¢\u0006\u0004\b6\u00109J\u0018\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\fJ\u001d\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0007J\u001d\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u0015J\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b \u0010\u0015J\u000f\u0010\"\u001a\u00020!H\u0014¢\u0006\u0004\b\"\u0010#J\u001f\u0010'\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u0016J\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010\u0016J\u0015\u0010/\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b/\u00100R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u0006;"}, d2 = {"Lcom/avito/android/util/ParcelableSparseArray;", ExifInterface.LONGITUDE_EAST, "Landroid/os/Parcelable;", "", "", "key", "get", "(I)Ljava/lang/Object;", "valueIfKeyNotFound", "(ILjava/lang/Object;)Ljava/lang/Object;", "", PhoneActionStrings.REMOVE, "(I)V", ProductAction.ACTION_REMOVE, FirebaseAnalytics.Param.INDEX, "removeAt", "size", "removeAtRange", "(II)V", "value", "put", "(ILjava/lang/Object;)V", "()I", "keyAt", "(I)I", "valueAt", "setValueAt", "indexOfKey", "indexOfValue", "(Ljava/lang/Object;)I", "clear", "()V", "append", "", "clone", "()Ljava/lang/Object;", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "fill", "(Ljava/lang/Object;)V", "Landroid/util/SparseArray;", AuthSource.SEND_ABUSE, "Landroid/util/SparseArray;", "array", "initialCapacity", "<init>", "(Landroid/util/SparseArray;)V", "in", "(Landroid/os/Parcel;)V", "Companion", "android_release"}, k = 1, mv = {1, 4, 2})
public final class ParcelableSparseArray<E> implements Parcelable, Cloneable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ParcelableSparseArray<?>> CREATOR = new Parcelable.Creator<ParcelableSparseArray<?>>() { // from class: com.avito.android.util.ParcelableSparseArray$Companion$CREATOR$1
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ParcelableSparseArray<?> createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ParcelableSparseArray<>(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public ParcelableSparseArray<?>[] newArray(int i) {
            return new ParcelableSparseArray[i];
        }
    };
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final SparseArray<E> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/util/ParcelableSparseArray$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/util/ParcelableSparseArray;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public ParcelableSparseArray(int i) {
        this.a = new SparseArray<>(i);
    }

    public final void append(int i, E e) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        sparseArray.append(i, e);
    }

    public final void clear() {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        sparseArray.clear();
    }

    @Override // java.lang.Object
    @NotNull
    public Object clone() throws CloneNotSupportedException {
        SparseArray<E> sparseArray = this.a;
        if (sparseArray == null) {
            return new ParcelableSparseArray((SparseArray) null);
        }
        return new ParcelableSparseArray(sparseArray.clone());
    }

    public final void delete(int i) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        sparseArray.delete(i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof ParcelableSparseArray)) {
            return false;
        }
        SparseArray<E> sparseArray = this.a;
        SparseArray<E> sparseArray2 = ((ParcelableSparseArray) obj).a;
        Objects.requireNonNull(sparseArray2, "null cannot be cast to non-null type android.util.SparseArray<E>");
        return SparseArraysKt.equals(sparseArray, sparseArray2);
    }

    public final void fill(E e) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        int size = sparseArray.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                sparseArray.put(sparseArray.keyAt(i), e);
                if (i != size) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final E get(int i) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        return sparseArray.get(i);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return SparseArraysKt.hashCode(this.a);
    }

    public final int indexOfKey(int i) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        return sparseArray.indexOfKey(i);
    }

    public final int indexOfValue(E e) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        return sparseArray.indexOfValue(e);
    }

    public final int keyAt(int i) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        return sparseArray.keyAt(i);
    }

    public final void put(int i, E e) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        sparseArray.put(i, e);
    }

    public final void remove(int i) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        sparseArray.remove(i);
    }

    public final void removeAt(int i) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        sparseArray.removeAt(i);
    }

    public final void removeAtRange(int i, int i2) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        sparseArray.removeAtRange(i, i2);
    }

    public final void setValueAt(int i, E e) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        sparseArray.setValueAt(i, e);
    }

    public final int size() {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        return sparseArray.size();
    }

    public final E valueAt(int i) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        return sparseArray.valueAt(i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelUtils.writeSparseArray(parcel, this.a);
    }

    public ParcelableSparseArray(@Nullable SparseArray<E> sparseArray) {
        this.a = sparseArray;
    }

    public final E get(int i, E e) {
        SparseArray<E> sparseArray = this.a;
        Intrinsics.checkNotNull(sparseArray);
        return sparseArray.get(i, e);
    }

    public ParcelableSparseArray(@Nullable Parcel parcel) {
        Intrinsics.checkNotNull(parcel);
        this.a = ParcelUtils.readSparseArray(parcel, ParcelableSparseArray.class);
    }
}

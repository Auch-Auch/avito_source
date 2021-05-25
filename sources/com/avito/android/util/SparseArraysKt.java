package com.avito.android.util;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a3\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001¢\u0006\u0004\b\b\u0010\t\u001a)\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010\u001a)\u0010\u0013\u001a\u00020\u000e\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u001a(\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0015\u001a\u00020\u0007H\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a(\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a(\u0010\u001b\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\b¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {ExifInterface.LONGITUDE_EAST, "Landroid/util/SparseArray;", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "equals", "(Landroid/util/SparseArray;Landroid/util/SparseArray;)Z", "", "hashCode", "(Landroid/util/SparseArray;)I", "T", "array", "Ljava/io/ObjectOutput;", VKApiConst.OUT, "", "write", "(Landroid/util/SparseArray;Ljava/io/ObjectOutput;)V", "Ljava/io/ObjectInput;", "source", "read", "(Landroid/util/SparseArray;Ljava/io/ObjectInput;)V", "key", "containsKey", "(Landroid/util/SparseArray;I)Z", "value", "containsValue", "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "fill", "(Landroid/util/SparseArray;Ljava/lang/Object;)V", "android_release"}, k = 2, mv = {1, 4, 2})
public final class SparseArraysKt {
    public static final <E> boolean containsKey(@NotNull SparseArray<E> sparseArray, int i) {
        Intrinsics.checkNotNullParameter(sparseArray, "$this$containsKey");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <E> boolean containsValue(@NotNull SparseArray<E> sparseArray, E e) {
        Intrinsics.checkNotNullParameter(sparseArray, "$this$containsValue");
        return sparseArray.indexOfValue(e) >= 0;
    }

    public static final <E> boolean equals(@Nullable SparseArray<E> sparseArray, @Nullable SparseArray<E> sparseArray2) {
        if (sparseArray == null && sparseArray2 == null) {
            return true;
        }
        if ((sparseArray == null) ^ (sparseArray2 == null)) {
            return false;
        }
        Intrinsics.checkNotNull(sparseArray);
        int size = sparseArray.size();
        Intrinsics.checkNotNull(sparseArray2);
        if (size != sparseArray2.size()) {
            return false;
        }
        int size2 = sparseArray.size() - 1;
        if (size2 >= 0) {
            int i = 0;
            while (true) {
                int keyAt = sparseArray.keyAt(i);
                E e = sparseArray.get(keyAt);
                E e2 = sparseArray2.get(keyAt);
                if (e == null || e2 == null) {
                    if (e != e2) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual((Object) e, (Object) e2)) {
                    return false;
                }
                if (i == size2) {
                    break;
                }
                i++;
            }
        }
        return true;
    }

    public static final <E> void fill(@NotNull SparseArray<E> sparseArray, E e) {
        Intrinsics.checkNotNullParameter(sparseArray, "$this$fill");
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

    public static final <E> int hashCode(@Nullable SparseArray<E> sparseArray) {
        int size;
        if (sparseArray == null || sparseArray.size() - 1 < 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            E e = sparseArray.get(sparseArray.keyAt(i));
            i2 = (i2 * 31) + (e != null ? e.hashCode() : 0);
            if (i == size) {
                return i2;
            }
            i++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: android.util.SparseArray<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void read(@NotNull SparseArray<T> sparseArray, @NotNull ObjectInput objectInput) throws IOException, ClassNotFoundException {
        Intrinsics.checkNotNullParameter(sparseArray, "array");
        Intrinsics.checkNotNullParameter(objectInput, "source");
        int readInt = objectInput.readInt() - 1;
        if (readInt >= 0) {
            int i = 0;
            while (true) {
                sparseArray.put(objectInput.readInt(), objectInput.readObject());
                if (i != readInt) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final <T> void write(@NotNull SparseArray<T> sparseArray, @NotNull ObjectOutput objectOutput) throws IOException {
        Intrinsics.checkNotNullParameter(sparseArray, "array");
        Intrinsics.checkNotNullParameter(objectOutput, VKApiConst.OUT);
        int size = sparseArray.size();
        objectOutput.writeInt(size);
        int i = size - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int keyAt = sparseArray.keyAt(i2);
                T valueAt = sparseArray.valueAt(i2);
                objectOutput.writeInt(keyAt);
                objectOutput.writeObject(valueAt);
                if (i2 != i) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}

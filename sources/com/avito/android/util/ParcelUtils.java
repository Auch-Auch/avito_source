package com.avito.android.util;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b(\u0010)J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0013\u001a\u00020\u0006\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014JM\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u000f2\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0019\"\b\b\u0000\u0010\t*\u00020\u001a2\u0006\u0010\n\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020#8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b&\u0010%R\u0016\u0010'\u001a\u00020#8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b'\u0010%¨\u0006*"}, d2 = {"Lcom/avito/android/util/ParcelUtils;", "", "Landroid/os/Parcel;", "dest", "Landroid/util/SparseArray;", "value", "", "writeSparseArray", "(Landroid/os/Parcel;Landroid/util/SparseArray;)V", "T", "input", "Ljava/lang/Class;", "clazz", "readSparseArray", "(Landroid/os/Parcel;Ljava/lang/Class;)Landroid/util/SparseArray;", ExifInterface.LONGITUDE_EAST, VKApiConst.OUT, "", "map", "writeValueMap", "(Landroid/os/Parcel;Ljava/util/Map;)V", "keyClass", "valueClass", "createValueMap", "(Landroid/os/Parcel;Ljava/lang/Class;Ljava/lang/Class;)Ljava/util/Map;", "", "Landroid/os/Parcelable;", "list", "writeOptimizedParcelableList", "(Landroid/os/Parcel;Ljava/util/List;)V", "createParcelableList", "(Landroid/os/Parcel;Ljava/lang/Class;)Ljava/util/List;", "parcel", "recycle", "(Landroid/os/Parcel;)V", "", "PARCELABLE_NULL", "I", "PARCELABLE_TRUE", "PARCELABLE_FALSE", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class ParcelUtils {
    @NotNull
    public static final ParcelUtils INSTANCE = new ParcelUtils();
    public static final int PARCELABLE_FALSE = 0;
    public static final int PARCELABLE_NULL = -1;
    public static final int PARCELABLE_TRUE = 1;

    @JvmStatic
    @Nullable
    public static final <T extends Parcelable> List<T> createParcelableList(@NotNull Parcel parcel, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(parcel, "input");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return ParcelsKt.createParcelableList(parcel, cls);
    }

    @JvmStatic
    @Nullable
    public static final <T, E> Map<T, E> createValueMap(@NotNull Parcel parcel, @NotNull Class<T> cls, @NotNull Class<E> cls2) {
        Intrinsics.checkNotNullParameter(parcel, "input");
        Intrinsics.checkNotNullParameter(cls, "keyClass");
        Intrinsics.checkNotNullParameter(cls2, "valueClass");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap(readInt);
        while (readInt > 0) {
            arrayMap.put(parcel.readValue(cls.getClassLoader()), parcel.readValue(cls2.getClassLoader()));
            readInt--;
        }
        return arrayMap;
    }

    @JvmStatic
    @Nullable
    public static final <T> SparseArray<T> readSparseArray(@NotNull Parcel parcel, @NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(parcel, "input");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return parcel.readSparseArray(cls.getClassLoader());
    }

    @JvmStatic
    public static final void writeOptimizedParcelableList(@NotNull Parcel parcel, @Nullable List<? extends Parcelable> list) {
        Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
        ParcelsKt.writeOptimizedParcelableList(parcel, list, 0);
    }

    @JvmStatic
    public static final void writeSparseArray(@NotNull Parcel parcel, @Nullable SparseArray<?> sparseArray) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeSparseArray(sparseArray);
    }

    @JvmStatic
    public static final <T, E> void writeValueMap(@NotNull Parcel parcel, @Nullable Map<T, ? extends E> map) {
        Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        Iterator o0 = a.o0(map, parcel);
        while (o0.hasNext()) {
            Map.Entry entry = (Map.Entry) o0.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            parcel.writeValue(key);
            parcel.writeValue(value);
        }
    }

    public final void recycle(@Nullable Parcel parcel) {
        if (parcel != null) {
            parcel.recycle();
        }
    }
}

package com.avito.android.util;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0010\u0010\u0014J+\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016\"\u0004\b\u0000\u0010\u00152\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00198\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/util/AvitoCollectionUtils;", "", "T", "", "list", "notNull", "(Ljava/util/List;)Ljava/util/List;", "source", "excluded", ProductAction.ACTION_REMOVE, "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "", "array", "", "value", "", "contains", "([II)Z", "", VKApiConst.VERSION, "([Ljava/lang/Object;Ljava/lang/Object;)Z", ExifInterface.LONGITUDE_EAST, "Ljava/util/ArrayList;", "asArrayList", "(Ljava/util/List;)Ljava/util/ArrayList;", "", "PARCELABLE_TRUE", "B", "PARCELABLE_FALSE", "<init>", "()V", VKApiConst.LANG}, k = 1, mv = {1, 4, 2})
public final class AvitoCollectionUtils {
    @NotNull
    public static final AvitoCollectionUtils INSTANCE = new AvitoCollectionUtils();
    public static final byte PARCELABLE_FALSE = 0;
    public static final byte PARCELABLE_TRUE = 1;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @NotNull
    @Deprecated(message = "Use orEmpty()")
    public static final <T> List<T> notNull(@Nullable List<? extends T> list) {
        return list != 0 ? list : CollectionsKt__CollectionsKt.emptyList();
    }

    @Nullable
    public final <E> ArrayList<E> asArrayList(@Nullable List<? extends E> list) {
        if (list == null) {
            return null;
        }
        if (list instanceof ArrayList) {
            return (ArrayList) list;
        }
        return new ArrayList<>(list);
    }

    public final boolean contains(@Nullable int[] iArr, int i) {
        if (!(iArr == null || iArr.length == 0)) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    @NotNull
    public final <T> List<T> remove(@NotNull List<? extends T> list, @NotNull List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list, "source");
        Intrinsics.checkNotNullParameter(list2, "excluded");
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            if (!list2.contains(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final <T> boolean contains(@Nullable T[] tArr, @Nullable T t) {
        if (tArr == null) {
            return false;
        }
        for (T t2 : tArr) {
            if (t2 == t) {
                return true;
            }
            if (t != null && Intrinsics.areEqual((Object) t, (Object) t2)) {
                return true;
            }
        }
        return false;
    }
}

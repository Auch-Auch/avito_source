package com.avito.android.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\u001a+\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\u000b\u001a\u00020\n*\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0010\u001a\u0019\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014\"\u0017\u0010\u0017\u001a\u00020\r*\u00020\u00018F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"", "Lcom/avito/android/util/Dimension;", "desiredSize", "", "maxDownScaling", "findBestMatchByRatio", "(Ljava/util/List;Lcom/avito/android/util/Dimension;I)Lcom/avito/android/util/Dimension;", "findMinimalGreaterThan", "(Ljava/util/List;Lcom/avito/android/util/Dimension;)Lcom/avito/android/util/Dimension;", "other", "", "greaterOrEqual", "(Lcom/avito/android/util/Dimension;Lcom/avito/android/util/Dimension;)Z", "", "targetAspectRatio", "increaseByAspectRatio", "(Lcom/avito/android/util/Dimension;F)Lcom/avito/android/util/Dimension;", "cutByAspectRatio", "rotationAngle", "rotate", "(Lcom/avito/android/util/Dimension;I)Lcom/avito/android/util/Dimension;", "getAspectRatio", "(Lcom/avito/android/util/Dimension;)F", "aspectRatio", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class DimensionsKt {
    @NotNull
    public static final Dimension cutByAspectRatio(@NotNull Dimension dimension, float f) {
        Intrinsics.checkNotNullParameter(dimension, "$this$cutByAspectRatio");
        float aspectRatio = getAspectRatio(dimension) / f;
        return new Dimension((int) (((float) dimension.getWidth()) * Math.min(1.0f, aspectRatio)), (int) (((float) dimension.getHeight()) * Math.min(1.0f, 1.0f / aspectRatio)));
    }

    @Nullable
    public static final Dimension findBestMatchByRatio(@NotNull List<Dimension> list, @NotNull Dimension dimension, int i) {
        Intrinsics.checkNotNullParameter(list, "$this$findBestMatchByRatio");
        Intrinsics.checkNotNullParameter(dimension, "desiredSize");
        float aspectRatio = getAspectRatio(dimension);
        Object obj = null;
        if (aspectRatio == 0.0f || aspectRatio == Float.POSITIVE_INFINITY) {
            return null;
        }
        Dimension dimension2 = new Dimension(dimension.getWidth() / i, dimension.getHeight() / i);
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (greaterOrEqual(t, dimension2)) {
                arrayList.add(t);
            }
        }
        Iterator it = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator<T>() { // from class: com.avito.android.util.DimensionsKt$findBestMatchByRatio$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return a.compareValues(Integer.valueOf(t3.getHeight()), Integer.valueOf(t2.getHeight()));
            }
        }).iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                float abs = Math.abs(getAspectRatio((Dimension) obj) - getAspectRatio(dimension));
                do {
                    Object next = it.next();
                    float abs2 = Math.abs(getAspectRatio((Dimension) next) - getAspectRatio(dimension));
                    if (Float.compare(abs, abs2) > 0) {
                        obj = next;
                        abs = abs2;
                    }
                } while (it.hasNext());
            }
        }
        return (Dimension) obj;
    }

    public static /* synthetic */ Dimension findBestMatchByRatio$default(List list, Dimension dimension, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return findBestMatchByRatio(list, dimension, i);
    }

    @Nullable
    public static final Dimension findMinimalGreaterThan(@NotNull List<Dimension> list, @NotNull Dimension dimension) {
        Intrinsics.checkNotNullParameter(list, "$this$findMinimalGreaterThan");
        Intrinsics.checkNotNullParameter(dimension, "desiredSize");
        Object obj = null;
        if (list.isEmpty()) {
            return null;
        }
        List sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator<T>() { // from class: com.avito.android.util.DimensionsKt$findMinimalGreaterThan$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return a.compareValues(Integer.valueOf(t.getHeight()), Integer.valueOf(t2.getHeight()));
            }
        });
        Iterator it = sortedWith.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (greaterOrEqual((Dimension) next, dimension)) {
                obj = next;
                break;
            }
        }
        Dimension dimension2 = (Dimension) obj;
        return dimension2 != null ? dimension2 : (Dimension) CollectionsKt___CollectionsKt.last((List<? extends Object>) sortedWith);
    }

    public static final float getAspectRatio(@NotNull Dimension dimension) {
        Intrinsics.checkNotNullParameter(dimension, "$this$aspectRatio");
        if (dimension.getWidth() != 0) {
            return ((float) dimension.getHeight()) / ((float) dimension.getWidth());
        }
        return Float.POSITIVE_INFINITY;
    }

    public static final boolean greaterOrEqual(@NotNull Dimension dimension, @NotNull Dimension dimension2) {
        Intrinsics.checkNotNullParameter(dimension, "$this$greaterOrEqual");
        Intrinsics.checkNotNullParameter(dimension2, "other");
        return dimension.getHeight() >= dimension2.getHeight() && dimension.getWidth() >= dimension2.getWidth();
    }

    @NotNull
    public static final Dimension increaseByAspectRatio(@NotNull Dimension dimension, float f) {
        Intrinsics.checkNotNullParameter(dimension, "$this$increaseByAspectRatio");
        float aspectRatio = getAspectRatio(dimension) / f;
        return new Dimension((int) (((float) dimension.getWidth()) * Math.max(1.0f, aspectRatio)), (int) (((float) dimension.getHeight()) * Math.max(1.0f, 1.0f / aspectRatio)));
    }

    @NotNull
    public static final Dimension rotate(@NotNull Dimension dimension, int i) {
        Intrinsics.checkNotNullParameter(dimension, "$this$rotate");
        return (i == 90 || i == 270) ? new Dimension(dimension.getHeight(), dimension.getWidth()) : dimension;
    }
}

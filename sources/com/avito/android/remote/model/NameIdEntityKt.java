package com.avito.android.remote.model;

import com.avito.android.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a2\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0000H\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "Lcom/avito/android/remote/model/NameIdEntity;", "", "", "getNamesFrom", "(Ljava/util/List;)[Ljava/lang/CharSequence;", "", "ids", "filter", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class NameIdEntityKt {
    @NotNull
    public static final List<NameIdEntity> filter(@Nullable List<NameIdEntity> list, @Nullable List<String> list2) {
        List<String> list3;
        if (Collections.isNullOrEmpty(list) || Collections.isNullOrEmpty(list2)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            T t2 = t;
            if (list2 != null) {
                list3 = list2;
            } else {
                list3 = CollectionsKt__CollectionsKt.emptyList();
            }
            if (list3.contains(t2.getId())) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final CharSequence[] getNamesFrom(@NotNull List<NameIdEntity> list) {
        Intrinsics.checkNotNullParameter(list, "$this$getNamesFrom");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            if (name == null) {
                name = "";
            }
            arrayList.add(name);
        }
        Object[] array = arrayList.toArray(new CharSequence[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (CharSequence[]) array;
    }
}

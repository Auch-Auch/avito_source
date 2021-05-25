package com.avito.konveyor.util;

import a2.a.b.a.a;
import a2.a.b.a.c;
import a2.a.b.a.d;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.IterableDataSource;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\r\u0010\f\u001a\u001d\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000e\u0010\f\u001a\u001d\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000f\u0010\f\u001a\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a=\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001a7\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0017\"\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a1\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0019\u0010\u001c\u001a#\u0010 \u001a\u0004\u0018\u00010\u0003*\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u00012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!\"\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"T", "Lcom/avito/konveyor/data_source/DataSource;", "item", "", "indexOf", "(Lcom/avito/konveyor/data_source/DataSource;Ljava/lang/Object;)I", "orEmpty", "(Lcom/avito/konveyor/data_source/DataSource;)Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/data_source/IterableDataSource;", "toIterableDataSource", "(Lcom/avito/konveyor/data_source/DataSource;)Lcom/avito/konveyor/data_source/IterableDataSource;", InternalConstsKt.FIRST_IMAGE, "(Lcom/avito/konveyor/data_source/DataSource;)Ljava/lang/Object;", "second", "third", "last", "emptyDataSource", "()Lcom/avito/konveyor/data_source/DataSource;", "R", "Lkotlin/Function1;", "mapper", "map", "(Lcom/avito/konveyor/data_source/DataSource;Lkotlin/jvm/functions/Function1;)Lcom/avito/konveyor/data_source/DataSource;", "", "items", "concatWith", "(Lcom/avito/konveyor/data_source/DataSource;[Ljava/lang/Object;)Lcom/avito/konveyor/data_source/DataSource;", "other", "(Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/konveyor/data_source/DataSource;)Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/conveyor_item/Item;", "", "itemId", "itemPosition", "(Lcom/avito/konveyor/data_source/DataSource;Ljava/lang/String;)Ljava/lang/Integer;", "Lcom/avito/konveyor/data_source/ListDataSource;", "", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/ListDataSource;", "EMPTY_DATA_SOURCE", "konveyor_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "DataSources")
public final class DataSources {
    public static final ListDataSource<Object> a;

    static {
        List emptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(emptyList, "Collections.emptyList()");
        a = new ListDataSource<>(emptyList);
    }

    @NotNull
    public static final <T> DataSource<T> concatWith(@NotNull DataSource<T> dataSource, @NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$concatWith");
        Intrinsics.checkNotNullParameter(tArr, "items");
        return (tArr.length == 0) ^ true ? concatWith(dataSource, new ListDataSource(ArraysKt___ArraysKt.toList(tArr))) : dataSource;
    }

    @NotNull
    public static final <T> DataSource<T> emptyDataSource() {
        ListDataSource<Object> listDataSource = a;
        Objects.requireNonNull(listDataSource, "null cannot be cast to non-null type com.avito.konveyor.data_source.DataSource<T>");
        return listDataSource;
    }

    public static final <T> T first(@NotNull DataSource<T> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$first");
        return dataSource.getItem(0);
    }

    public static final <T> int indexOf(@NotNull DataSource<? extends T> dataSource, T t) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$indexOf");
        int count = dataSource.getCount();
        for (int i = 0; i < count; i++) {
            if (Intrinsics.areEqual(dataSource.getItem(i), t)) {
                return i;
            }
        }
        return -1;
    }

    @Nullable
    public static final Integer itemPosition(@NotNull DataSource<? extends Item> dataSource, @NotNull String str) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$itemPosition");
        Intrinsics.checkNotNullParameter(str, "itemId");
        int count = dataSource.getCount();
        for (int i = 0; i < count; i++) {
            if (Intrinsics.areEqual(str, ((Item) dataSource.getItem(i)).getStringId())) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    public static final <T> T last(@NotNull DataSource<T> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$last");
        return dataSource.getItem(dataSource.getCount() - 1);
    }

    @NotNull
    public static final <T, R> DataSource<R> map(@NotNull DataSource<T> dataSource, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        return new d(dataSource, function1);
    }

    @NotNull
    public static final <T> DataSource<T> orEmpty(@Nullable DataSource<T> dataSource) {
        return dataSource != null ? dataSource : emptyDataSource();
    }

    public static final <T> T second(@NotNull DataSource<T> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$second");
        return dataSource.getItem(1);
    }

    public static final <T> T third(@NotNull DataSource<T> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$third");
        return dataSource.getItem(2);
    }

    @NotNull
    public static final <T> IterableDataSource<T> toIterableDataSource(@NotNull DataSource<T> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$toIterableDataSource");
        if (dataSource instanceof IterableDataSource) {
            return (IterableDataSource) dataSource;
        }
        return new c(dataSource);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.util.List */
    /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> DataSource<T> concatWith(@NotNull DataSource<T> dataSource, @NotNull DataSource<T> dataSource2) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$concatWith");
        Intrinsics.checkNotNullParameter(dataSource2, "other");
        if (!(dataSource instanceof a)) {
            return new a(dataSource, dataSource2);
        }
        a aVar = (a) dataSource;
        Objects.requireNonNull(aVar);
        Intrinsics.checkNotNullParameter(dataSource2, "other");
        if (dataSource2 instanceof a) {
            Object[] array = CollectionsKt___CollectionsKt.plus((Collection) ArraysKt___ArraysJvmKt.asList(aVar.a), (Iterable) ArraysKt___ArraysJvmKt.asList(((a) dataSource2).a)).toArray(new DataSource[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            DataSource[] dataSourceArr = (DataSource[]) array;
            return new a((DataSource[]) Arrays.copyOf(dataSourceArr, dataSourceArr.length));
        }
        Object[] array2 = CollectionsKt___CollectionsKt.plus((Collection<? extends DataSource<T>>) ArraysKt___ArraysJvmKt.asList(aVar.a), dataSource2).toArray(new DataSource[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        DataSource[] dataSourceArr2 = (DataSource[]) array2;
        return new a((DataSource[]) Arrays.copyOf(dataSourceArr2, dataSourceArr2.length));
    }
}

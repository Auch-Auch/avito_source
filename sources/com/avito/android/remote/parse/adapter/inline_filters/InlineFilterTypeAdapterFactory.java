package com.avito.android.remote.parse.adapter.inline_filters;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001f\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\n¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/inline_filters/InlineFilterTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "T", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/reflect/TypeToken;", "type", "Lcom/google/gson/TypeAdapter;", "create", "(Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;", "", "", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "widgetTypeToValueType", "<init>", "(Ljava/util/Map;)V", "Companion", "search_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFilterTypeAdapterFactory implements TypeAdapterFactory {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final Map<String, Class<?>> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/parse/adapter/inline_filters/InlineFilterTypeAdapterFactory$Companion;", "", "Lcom/avito/android/remote/parse/adapter/inline_filters/InlineFilterTypeAdapterFactory;", "create", "()Lcom/avito/android/remote/parse/adapter/inline_filters/InlineFilterTypeAdapterFactory;", "<init>", "()V", "search_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final InlineFilterTypeAdapterFactory create() {
            return new InlineFilterTypeAdapterFactory(r.mapOf(TuplesKt.to("shortcut", InlineFilterValue.InlineFilterShortcutValue.class), TuplesKt.to("select", InlineFilterValue.InlineFilterSelectValue.class), TuplesKt.to("checkbox", InlineFilterValue.InlineFilterSelectValue.class), TuplesKt.to("multiselect", InlineFilterValue.InlineFilterMultiSelectValue.class), TuplesKt.to("numericRange", InlineFilterValue.InlineFilterNumericRangeValue.class), TuplesKt.to("formattedDate", InlineFilterValue.InlineFilterDateRangeValue.class), TuplesKt.to("segmented", InlineFilterValue.InlineFilterSelectValue.class)));
        }

        public Companion(j jVar) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, ? extends java.lang.Class<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public InlineFilterTypeAdapterFactory(@NotNull Map<String, ? extends Class<?>> map) {
        Intrinsics.checkNotNullParameter(map, "widgetTypeToValueType");
        this.a = map;
    }

    @Override // com.google.gson.TypeAdapterFactory
    @Nullable
    public <T> TypeAdapter<T> create(@NotNull Gson gson, @NotNull TypeToken<T> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "type");
        if (!Intrinsics.areEqual(typeToken.getRawType(), Filter.class)) {
            return null;
        }
        Map<String, Class<?>> map = this.a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(map.size()));
        for (T t : map.entrySet()) {
            linkedHashMap.put(t.getKey(), gson.getDelegateAdapter(this, TypeToken.get((Class) t.getValue())));
        }
        TypeAdapter<T> nullSafe = new TypeAdapter<Filter>(linkedHashMap, gson.getDelegateAdapter(this, TypeToken.get(Filter.class))) { // from class: com.avito.android.remote.parse.adapter.inline_filters.InlineFilterTypeAdapterFactory$create$1
            public final /* synthetic */ Map a;
            public final /* synthetic */ TypeAdapter b;

            {
                this.a = r1;
                this.b = r2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r11v5, resolved type: com.avito.android.remote.model.search.InlineFilterValue */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00db  */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x00e5  */
            @Override // com.google.gson.TypeAdapter
            @org.jetbrains.annotations.NotNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.avito.android.remote.model.search.Filter read(@org.jetbrains.annotations.Nullable com.google.gson.stream.JsonReader r25) {
                /*
                // Method dump skipped, instructions count: 300
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.inline_filters.InlineFilterTypeAdapterFactory$create$1.read(com.google.gson.stream.JsonReader):com.avito.android.remote.model.search.Filter");
            }

            @NotNull
            public Void write(@Nullable JsonWriter jsonWriter, @Nullable Filter filter) {
                throw new UnsupportedOperationException();
            }
        }.nullSafe();
        Objects.requireNonNull(nullSafe, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T>");
        return nullSafe;
    }
}

package com.avito.android.search.map.viewed_pins;

import android.content.SharedPreferences;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR:\u0010\u0015\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00030\u0003 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00120\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/search/map/viewed_pins/ViewedPinsStorageImpl;", "Lcom/avito/android/search/map/viewed_pins/ViewedPinsStorage;", "", "", "pins", "", "save", "(Ljava/util/List;)V", "ids", "", "isViewed", "(Ljava/util/List;)Z", "Landroid/content/SharedPreferences;", "c", "Landroid/content/SharedPreferences;", "preferences", "", "kotlin.jvm.PlatformType", "", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "viewedPins", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getViewedPinsCount", "()I", "viewedPinsCount", "<init>", "(Landroid/content/SharedPreferences;Lcom/avito/android/Features;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedPinsStorageImpl implements ViewedPinsStorage {
    public final Set<String> a;
    public final Lazy b = c.lazy(new a(this));
    public final SharedPreferences c;
    public final Features d;

    public static final class a extends Lambda implements Function0<Integer> {
        public final /* synthetic */ ViewedPinsStorageImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ViewedPinsStorageImpl viewedPinsStorageImpl) {
            super(0);
            this.a = viewedPinsStorageImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Integer invoke() {
            return Integer.valueOf(this.a.d.getReduceViewedPinsStorageSize().invoke().booleanValue() ? 50 : 1000);
        }
    }

    @Inject
    public ViewedPinsStorageImpl(@NotNull SharedPreferences sharedPreferences, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        Intrinsics.checkNotNullParameter(features, "features");
        this.c = sharedPreferences;
        this.d = features;
        Set<String> newSetFromMap = Collections.newSetFromMap(new LinkedHashMap<String, Boolean>(this) { // from class: com.avito.android.search.map.viewed_pins.ViewedPinsStorageImpl$viewedPins$1
            public final /* synthetic */ ViewedPinsStorageImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            public /* bridge */ boolean containsValue(Boolean bool) {
                return super.containsValue((Object) bool);
            }

            @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
            public final /* bridge */ Set<Map.Entry<String, Boolean>> entrySet() {
                return getEntries();
            }

            public /* bridge */ Boolean get(String str) {
                return (Boolean) super.get((Object) str);
            }

            public /* bridge */ Set getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set getKeys() {
                return super.keySet();
            }

            public /* bridge */ Boolean getOrDefault(String str, Boolean bool) {
                return (Boolean) super.getOrDefault((Object) str, (String) bool);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection getValues() {
                return super.values();
            }

            @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            public /* bridge */ Boolean remove(String str) {
                return (Boolean) super.remove((Object) str);
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(@Nullable Map.Entry<String, Boolean> entry) {
                return size() > ViewedPinsStorageImpl.access$getViewedPinsCount$p(this.a);
            }

            @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
            public final /* bridge */ Collection<Boolean> values() {
                return getValues();
            }

            public /* bridge */ boolean containsKey(String str) {
                return super.containsKey((Object) str);
            }

            @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj instanceof Boolean) {
                    return containsValue((Boolean) obj);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
            public final /* bridge */ Object get(Object obj) {
                if (obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap, java.util.Map, java.util.HashMap
            public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
                return obj instanceof String ? getOrDefault((String) obj, (Boolean) obj2) : obj2;
            }

            @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
            public final /* bridge */ Object remove(Object obj) {
                if (obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.Map, java.util.HashMap
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                boolean z = true;
                if (!(obj != null ? obj instanceof String : true)) {
                    return false;
                }
                if (obj2 != null) {
                    z = obj2 instanceof Boolean;
                }
                if (z) {
                    return remove((String) obj, (Boolean) obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str, Boolean bool) {
                return super.remove((Object) str, (Object) bool);
            }
        });
        this.a = newSetFromMap;
        Set<String> stringSet = sharedPreferences.getStringSet(ViewedPinsStorageKt.VIEWED_PINS, newSetFromMap);
        if (stringSet != null) {
            newSetFromMap.addAll(stringSet);
        }
    }

    public static final int access$getViewedPinsCount$p(ViewedPinsStorageImpl viewedPinsStorageImpl) {
        return ((Number) viewedPinsStorageImpl.b.getValue()).intValue();
    }

    @Override // com.avito.android.search.map.viewed_pins.ViewedPinsStorage
    public boolean isViewed(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (this.a.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.avito.android.search.map.viewed_pins.ViewedPinsStorage
    public void save(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "pins");
        if (!this.a.containsAll(list)) {
            for (T t : list) {
                if (this.a.contains(t)) {
                    this.a.remove(t);
                }
                this.a.add(t);
            }
            this.c.edit().putStringSet(ViewedPinsStorageKt.VIEWED_PINS, this.a).apply();
        }
    }
}

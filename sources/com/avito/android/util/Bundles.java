package com.avito.android.util;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u001a3\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\u000e\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001e\u0010\u0010\u001a\u0004\u0018\u00010\f*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0013\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0012H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0012*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0018\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0017H\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0017*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u001d\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u001cH\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001c*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010\"\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010!H\b¢\u0006\u0004\b\"\u0010#\u001a\u001e\u0010$\u001a\u0004\u0018\u00010!*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b$\u0010%\u001a&\u0010'\u001a\u00020!*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020!H\b¢\u0006\u0004\b'\u0010(\u001a\u0014\u0010)\u001a\u00020!*\u00020\u0002H\b¢\u0006\u0004\b)\u0010*\u001a\u0016\u0010+\u001a\u00020\u0002*\u0004\u0018\u00010\u0002H\b¢\u0006\u0004\b+\u0010,\u001a#\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010-*\u0004\u0018\u00010\u0002¢\u0006\u0004\b.\u0010/\u001a\u0011\u00100\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0004\b0\u00101\u001a;\u00103\u001a\u00020\u0002*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001c\u00102\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0005\u0018\u00010-¢\u0006\u0004\b3\u00104\u001a9\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0018\u00010-\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b5\u00106\u001a5\u00107\u001a\u00020\u0002*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010-¢\u0006\u0004\b7\u00104\u001a+\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010-*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b8\u00106\u001a!\u0010;\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<\u001a\u001b\u0010=\u001a\u0004\u0018\u000109*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b=\u0010>\u001a\u0019\u0010@\u001a\u00020!*\u00020\u00022\u0006\u0010?\u001a\u00020\u0002¢\u0006\u0004\b@\u0010A¨\u0006B"}, d2 = {"Landroid/os/Parcelable;", "T", "Landroid/os/Bundle;", "", "key", "", "list", "", "putParcelableList", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/util/List;)V", "getParcelableList", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/List;", "", "value", "putNullableInt", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Integer;)V", "getNullableInt", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "", "putNullableByte", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Byte;)V", "getNullableByte", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Byte;", "", "putNullableFloat", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Float;)V", "getNullableFloat", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Float;", "", "putNullableLong", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Long;)V", "getNullableLong", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Long;", "", "putNullableBoolean", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Boolean;)V", "getNullableBoolean", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Boolean;", "default", "getBoolean", "(Landroid/os/Bundle;Ljava/lang/String;Z)Z", "isNotEmpty", "(Landroid/os/Bundle;)Z", "orEmpty", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "", "toMap", "(Landroid/os/Bundle;)Ljava/util/Map;", "removeNonNativeObjects", "(Landroid/os/Bundle;)V", "map", "putMapOfParcelablesList", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/util/Map;)Landroid/os/Bundle;", "getMapOfParcelablesList", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/Map;", "putMapOfStrings", "getMapOfStrings", "Lcom/avito/android/util/Kundle;", "kundle", "putKundle", "(Landroid/os/Bundle;Ljava/lang/String;Lcom/avito/android/util/Kundle;)Landroid/os/Bundle;", "getKundle", "(Landroid/os/Bundle;Ljava/lang/String;)Lcom/avito/android/util/Kundle;", "other", "isEqual", "(Landroid/os/Bundle;Landroid/os/Bundle;)Z", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Bundles")
public final class Bundles {
    public static final boolean getBoolean(@Nullable Bundle bundle, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle != null ? bundle.getBoolean(str, z) : z;
    }

    @Nullable
    public static final Kundle getKundle(@NotNull Bundle bundle, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bundle, "$this$getKundle");
        Intrinsics.checkNotNullParameter(str, "key");
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 != null) {
            return new Kundle(bundle2);
        }
        return null;
    }

    @Nullable
    public static final <T extends Parcelable> Map<String, List<T>> getMapOfParcelablesList(@NotNull Bundle bundle, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bundle, "$this$getMapOfParcelablesList");
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!(!bundle2.isEmpty())) {
            return linkedHashMap;
        }
        for (String str2 : bundle2.keySet()) {
            List list = (List) bundle2.get(str2);
            if (list != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "key");
                linkedHashMap.put(str2, list);
            }
        }
        return linkedHashMap;
    }

    @Nullable
    public static final Map<String, String> getMapOfStrings(@NotNull Bundle bundle, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bundle, "$this$getMapOfStrings");
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 != null) {
            return toMap(bundle2);
        }
        return null;
    }

    @Nullable
    public static final Boolean getNullableBoolean(@NotNull Bundle bundle, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bundle, "$this$getNullableBoolean");
        Intrinsics.checkNotNullParameter(str, "key");
        if (bundle.containsKey(str)) {
            return Boolean.valueOf(bundle.getBoolean(str));
        }
        return null;
    }

    @Nullable
    public static final Byte getNullableByte(@NotNull Bundle bundle, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bundle, "$this$getNullableByte");
        Intrinsics.checkNotNullParameter(str, "key");
        if (bundle.containsKey(str)) {
            return Byte.valueOf(bundle.getByte(str));
        }
        return null;
    }

    @Nullable
    public static final Float getNullableFloat(@NotNull Bundle bundle, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bundle, "$this$getNullableFloat");
        Intrinsics.checkNotNullParameter(str, "key");
        if (bundle.containsKey(str)) {
            return Float.valueOf(bundle.getFloat(str));
        }
        return null;
    }

    @Nullable
    public static final Integer getNullableInt(@NotNull Bundle bundle, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bundle, "$this$getNullableInt");
        Intrinsics.checkNotNullParameter(str, "key");
        if (bundle.containsKey(str)) {
            return Integer.valueOf(bundle.getInt(str));
        }
        return null;
    }

    @Nullable
    public static final Long getNullableLong(@NotNull Bundle bundle, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bundle, "$this$getNullableLong");
        Intrinsics.checkNotNullParameter(str, "key");
        if (bundle.containsKey(str)) {
            return Long.valueOf(bundle.getLong(str));
        }
        return null;
    }

    @Nullable
    public static final <T extends Parcelable> List<T> getParcelableList(@NotNull Bundle bundle, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bundle, "$this$getParcelableList");
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getParcelableArrayList(str);
    }

    public static final boolean isEqual(@NotNull Bundle bundle, @NotNull Bundle bundle2) {
        Intrinsics.checkNotNullParameter(bundle, "$this$isEqual");
        Intrinsics.checkNotNullParameter(bundle2, "other");
        if (bundle == bundle2) {
            return true;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        Set<String> keySet = bundle.keySet();
        Set<String> keySet2 = bundle2.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet2, "other.keySet()");
        if (!keySet.containsAll(keySet2)) {
            return false;
        }
        Set<String> keySet3 = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet3, "keySet()");
        for (T t : keySet3) {
            Object obj = bundle.get(t);
            Object obj2 = bundle2.get(t);
            Class<?> cls = null;
            Class<?> cls2 = obj != null ? obj.getClass() : null;
            if (obj2 != null) {
                cls = obj2.getClass();
            }
            if (!Intrinsics.areEqual(cls2, cls)) {
                return false;
            }
            if (obj instanceof Bundle) {
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.os.Bundle");
                if (!isEqual((Bundle) obj, (Bundle) obj2)) {
                    return false;
                }
            } else if (!Intrinsics.areEqual(obj, obj2)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isNotEmpty(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "$this$isNotEmpty");
        return !bundle.isEmpty();
    }

    @NotNull
    public static final Bundle orEmpty(@Nullable Bundle bundle) {
        return bundle != null ? bundle : new Bundle(0);
    }

    @NotNull
    public static final Bundle putKundle(@NotNull Bundle bundle, @NotNull String str, @NotNull Kundle kundle) {
        Intrinsics.checkNotNullParameter(bundle, "$this$putKundle");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kundle, "kundle");
        bundle.putBundle(str, kundle.toBundle());
        return bundle;
    }

    @NotNull
    public static final Bundle putMapOfParcelablesList(@NotNull Bundle bundle, @Nullable String str, @Nullable Map<String, ? extends List<? extends Parcelable>> map) {
        Intrinsics.checkNotNullParameter(bundle, "$this$putMapOfParcelablesList");
        if (map == null) {
            return bundle;
        }
        Bundle bundle2 = new Bundle(map.size());
        for (Map.Entry<String, ? extends List<? extends Parcelable>> entry : map.entrySet()) {
            putParcelableList(bundle2, entry.getKey(), (List) entry.getValue());
        }
        bundle.putBundle(str, bundle2);
        return bundle;
    }

    public static /* synthetic */ Bundle putMapOfParcelablesList$default(Bundle bundle, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return putMapOfParcelablesList(bundle, str, map);
    }

    @NotNull
    public static final Bundle putMapOfStrings(@NotNull Bundle bundle, @Nullable String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(bundle, "$this$putMapOfStrings");
        if (map == null) {
            return bundle;
        }
        Bundle bundle2 = new Bundle(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle2.putString(entry.getKey(), entry.getValue());
        }
        bundle.putBundle(str, bundle2);
        return bundle;
    }

    public static /* synthetic */ Bundle putMapOfStrings$default(Bundle bundle, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return putMapOfStrings(bundle, str, map);
    }

    public static final void putNullableBoolean(@NotNull Bundle bundle, @NotNull String str, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(bundle, "$this$putNullableBoolean");
        Intrinsics.checkNotNullParameter(str, "key");
        if (bool != null) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    public static final void putNullableByte(@NotNull Bundle bundle, @NotNull String str, @Nullable Byte b) {
        Intrinsics.checkNotNullParameter(bundle, "$this$putNullableByte");
        Intrinsics.checkNotNullParameter(str, "key");
        if (b != null) {
            bundle.putByte(str, b.byteValue());
        }
    }

    public static final void putNullableFloat(@NotNull Bundle bundle, @NotNull String str, @Nullable Float f) {
        Intrinsics.checkNotNullParameter(bundle, "$this$putNullableFloat");
        Intrinsics.checkNotNullParameter(str, "key");
        if (f != null) {
            bundle.putFloat(str, f.floatValue());
        }
    }

    public static final void putNullableInt(@NotNull Bundle bundle, @NotNull String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(bundle, "$this$putNullableInt");
        Intrinsics.checkNotNullParameter(str, "key");
        if (num != null) {
            bundle.putInt(str, num.intValue());
        }
    }

    public static final void putNullableLong(@NotNull Bundle bundle, @NotNull String str, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(bundle, "$this$putNullableLong");
        Intrinsics.checkNotNullParameter(str, "key");
        if (l != null) {
            bundle.putLong(str, l.longValue());
        }
    }

    public static final <T extends Parcelable> void putParcelableList(@NotNull Bundle bundle, @NotNull String str, @Nullable List<? extends T> list) {
        Intrinsics.checkNotNullParameter(bundle, "$this$putParcelableList");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putParcelableArrayList(str, Collections.asArrayList(list));
    }

    public static final void removeNonNativeObjects(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "$this$removeNonNativeObjects");
        Set<String> keySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "keySet()");
        for (String str : CollectionsKt___CollectionsKt.toList(keySet)) {
            Object obj = bundle.get(str);
            if (obj != null) {
                Intrinsics.checkNotNullExpressionValue(obj, "get(it) ?: return@forEach");
                if (obj instanceof Bundle) {
                    removeNonNativeObjects((Bundle) obj);
                } else {
                    String name = obj.getClass().getName();
                    if (!(m.startsWith$default(name, "java.", false, 2, null) | m.startsWith$default(name, "android.", false, 2, null))) {
                        bundle.remove(str);
                    }
                }
            }
        }
    }

    @Nullable
    public static final Map<String, String> toMap(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int size = bundle.size();
        HashMap hashMap = new HashMap(size);
        if (size > 0) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                hashMap.put(str, obj != null ? obj.toString() : null);
            }
        }
        return hashMap;
    }
}

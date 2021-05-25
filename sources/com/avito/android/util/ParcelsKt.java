package com.avito.android.util;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a5\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a(\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\f\u0010\r\u001a1\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\f\u0010\u0010\u001a1\u0010\u0011\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012\u001a.\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0018\u00010\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0013\u0010\r\u001a3\u0010\u0018\u001a\u00020\t\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u0015*\u00020\u00022\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0016\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u001a\"\n\b\u0001\u0010\u0015\u0018\u0001*\u00020\u001a*\u00020\u0002H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0019\u0010\u001f\u001a\u00020\t*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 \u001a\u0011\u0010!\u001a\u00020\u001d*\u00020\u0002¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010#\u001a\u00020\t*\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b#\u0010$\u001a\u0013\u0010%\u001a\u0004\u0018\u00010\u001d*\u00020\u0002¢\u0006\u0004\b%\u0010&\u001a\u001b\u0010'\u001a\u00020\t*\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b'\u0010(\u001a\"\u0010)\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u001a*\u00020\u0002H\b¢\u0006\u0004\b)\u0010*\u001a\u0019\u0010-\u001a\u00020\t*\u00020\u00022\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.\u001a\u0011\u0010/\u001a\u00020+*\u00020\u0002¢\u0006\u0004\b/\u00100\u001a)\u00102\u001a\u00020\t\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u000001*\u00020\u00022\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0004\b2\u00103\u001a+\u00104\u001a\u00020\t\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u000001*\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b4\u00103\u001a1\u00108\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u00105*\b\u0012\u0004\u0012\u00028\u000001*\u00020\u00022\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000006¢\u0006\u0004\b8\u00109\u001a/\u0010:\u001a\u00028\u0000\"\u000e\b\u0000\u00105*\b\u0012\u0004\u0012\u00028\u000001*\u00020\u00022\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000006¢\u0006\u0004\b:\u00109\"2\u0010A\u001a\u001e\u0012\u0004\u0012\u00020<\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020=\u0012\b\u0012\u0006\u0012\u0002\b\u00030>0;0;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006B"}, d2 = {"Landroid/os/Parcelable;", "T", "Landroid/os/Parcel;", "readParcelable", "(Landroid/os/Parcel;)Landroid/os/Parcelable;", "", "list", "", "parcelableFlags", "", "writeOptimizedParcelableList", "(Landroid/os/Parcel;Ljava/util/List;I)V", "createParcelableList", "(Landroid/os/Parcel;)Ljava/util/List;", "Ljava/lang/Class;", "clazz", "(Landroid/os/Parcel;Ljava/lang/Class;)Ljava/util/List;", "writeParcelableListOfLists", "(Landroid/os/Parcel;Ljava/util/List;)V", "createParcelableListOfLists", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "writeValueMap", "(Landroid/os/Parcel;Ljava/util/Map;)V", "", "createValueMap", "(Landroid/os/Parcel;)Ljava/util/Map;", "", "value", "writeBool", "(Landroid/os/Parcel;Z)V", "readBool", "(Landroid/os/Parcel;)Z", "writeOptBoolean", "(Landroid/os/Parcel;Ljava/lang/Boolean;)V", "readOptBoolean", "(Landroid/os/Parcel;)Ljava/lang/Boolean;", "writeNullableValue", "(Landroid/os/Parcel;Ljava/lang/Object;)V", "readNullableValue", "(Landroid/os/Parcel;)Ljava/lang/Object;", "Lkotlin/ranges/LongRange;", "range", "writeLongRange", "(Landroid/os/Parcel;Lkotlin/ranges/LongRange;)V", "createLongRange", "(Landroid/os/Parcel;)Lkotlin/ranges/LongRange;", "", "writeEnum", "(Landroid/os/Parcel;Ljava/lang/Enum;)V", "writeOptEnum", ExifInterface.LONGITUDE_EAST, "", ResidentialComplexModuleKt.VALUES, "readOptEnum", "(Landroid/os/Parcel;[Ljava/lang/Enum;)Ljava/lang/Enum;", "readEnum", "Landroidx/collection/SimpleArrayMap;", "Ljava/lang/ClassLoader;", "", "Landroid/os/Parcelable$Creator;", AuthSource.SEND_ABUSE, "Landroidx/collection/SimpleArrayMap;", "creators", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ParcelsKt {
    public static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Parcelable.Creator<?>>> a = new SimpleArrayMap<>();

    @NotNull
    public static final LongRange createLongRange(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$this$createLongRange");
        return new LongRange(parcel.readLong(), parcel.readLong());
    }

    public static final /* synthetic */ <T extends Parcelable> List<T> createParcelableList(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$this$createParcelableList");
        Intrinsics.reifiedOperationMarker(4, "T");
        return createParcelableList(parcel, Parcelable.class);
    }

    public static final /* synthetic */ <T extends Parcelable> List<List<T>> createParcelableListOfLists(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$this$createParcelableListOfLists");
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readInt; i++) {
            Intrinsics.reifiedOperationMarker(4, "T");
            List createParcelableList = createParcelableList(parcel, Parcelable.class);
            if (createParcelableList == null) {
                createParcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            arrayList.add(createParcelableList);
        }
        return arrayList;
    }

    public static final /* synthetic */ <K, V> Map<K, V> createValueMap(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$this$createValueMap");
        Intrinsics.reifiedOperationMarker(4, "K");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        return ParcelUtils.createValueMap(parcel, Object.class, Object.class);
    }

    public static final boolean readBool(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$this$readBool");
        return parcel.readInt() == 1;
    }

    @NotNull
    public static final <E extends Enum<E>> E readEnum(@NotNull Parcel parcel, @NotNull E[] eArr) {
        Intrinsics.checkNotNullParameter(parcel, "$this$readEnum");
        Intrinsics.checkNotNullParameter(eArr, ResidentialComplexModuleKt.VALUES);
        return eArr[parcel.readInt()];
    }

    public static final /* synthetic */ <T> T readNullableValue(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$this$readNullableValue");
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) parcel.readValue(Object.class.getClassLoader());
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }

    @Nullable
    public static final Boolean readOptBoolean(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$this$readOptBoolean");
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return Boolean.FALSE;
        }
        if (readInt != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    @Nullable
    public static final <E extends Enum<E>> E readOptEnum(@NotNull Parcel parcel, @NotNull E[] eArr) {
        Intrinsics.checkNotNullParameter(parcel, "$this$readOptEnum");
        Intrinsics.checkNotNullParameter(eArr, ResidentialComplexModuleKt.VALUES);
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        return eArr[readInt];
    }

    public static final /* synthetic */ <T extends Parcelable> T readParcelable(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$this$readParcelable");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) parcel.readParcelable(Parcelable.class.getClassLoader());
    }

    public static final void writeBool(@NotNull Parcel parcel, boolean z) {
        Intrinsics.checkNotNullParameter(parcel, "$this$writeBool");
        parcel.writeInt(z ? 1 : 0);
    }

    public static final <T extends Enum<T>> void writeEnum(@NotNull Parcel parcel, @NotNull T t) {
        Intrinsics.checkNotNullParameter(parcel, "$this$writeEnum");
        Intrinsics.checkNotNullParameter(t, "value");
        parcel.writeInt(t.ordinal());
    }

    public static final void writeLongRange(@NotNull Parcel parcel, @NotNull LongRange longRange) {
        Intrinsics.checkNotNullParameter(parcel, "$this$writeLongRange");
        Intrinsics.checkNotNullParameter(longRange, "range");
        parcel.writeLong(longRange.getFirst());
        parcel.writeLong(longRange.getLast());
    }

    public static final void writeNullableValue(@NotNull Parcel parcel, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(parcel, "$this$writeNullableValue");
        parcel.writeValue(obj);
    }

    public static final void writeOptBoolean(@NotNull Parcel parcel, @Nullable Boolean bool) {
        int i;
        Intrinsics.checkNotNullParameter(parcel, "$this$writeOptBoolean");
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            i = 1;
        } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            i = 0;
        } else if (bool == null) {
            i = -1;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        parcel.writeInt(i);
    }

    public static final <T extends Enum<T>> void writeOptEnum(@NotNull Parcel parcel, @Nullable T t) {
        Intrinsics.checkNotNullParameter(parcel, "$this$writeOptEnum");
        if (t == null) {
            parcel.writeInt(-1);
        } else {
            writeEnum(parcel, t);
        }
    }

    public static final <T extends Parcelable> void writeOptimizedParcelableList(@NotNull Parcel parcel, @Nullable List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(parcel, "$this$writeOptimizedParcelableList");
        if (list == null) {
            parcel.writeInt(-1);
            return;
        }
        ArrayMap arrayMap = new ArrayMap();
        for (T t : list) {
            if (!arrayMap.containsKey(t.getClass())) {
                arrayMap.put(t.getClass(), Integer.valueOf(arrayMap.size()));
            }
        }
        parcel.writeInt(arrayMap.size());
        for (Map.Entry entry : arrayMap.entrySet()) {
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "it.key");
            parcel.writeString(((Class) key).getName());
            Object value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "it.value");
            parcel.writeInt(((Number) value).intValue());
        }
        parcel.writeInt(list.size());
        for (T t2 : list) {
            Object obj = arrayMap.get(t2.getClass());
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
            parcel.writeInt(((Integer) obj).intValue());
            t2.writeToParcel(parcel, i);
        }
    }

    public static /* synthetic */ void writeOptimizedParcelableList$default(Parcel parcel, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        writeOptimizedParcelableList(parcel, list, i);
    }

    public static final <T extends Parcelable> void writeParcelableListOfLists(@NotNull Parcel parcel, @Nullable List<? extends List<? extends T>> list) {
        Intrinsics.checkNotNullParameter(parcel, "$this$writeParcelableListOfLists");
        if (list == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(list.size());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            writeOptimizedParcelableList$default(parcel, it.next(), 0, 2, null);
        }
    }

    public static final <K, V> void writeValueMap(@NotNull Parcel parcel, @Nullable Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(parcel, "$this$writeValueMap");
        ParcelUtils.writeValueMap(parcel, map);
    }

    @Nullable
    public static final <T extends Parcelable> List<T> createParcelableList(@NotNull Parcel parcel, @NotNull Class<T> cls) {
        Parcelable.Creator<?> creator;
        Intrinsics.checkNotNullParameter(parcel, "$this$createParcelableList");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        Parcelable.Creator[] creatorArr = new Parcelable.Creator[readInt];
        for (int i = 0; i < readInt; i++) {
            ClassLoader classLoader = cls.getClassLoader();
            String readString = parcel.readString();
            if (readString != null) {
                Intrinsics.checkNotNullExpressionValue(readString, "readString() ?: return null");
                SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Parcelable.Creator<?>>> simpleArrayMap = a;
                synchronized (simpleArrayMap) {
                    SimpleArrayMap<String, Parcelable.Creator<?>> simpleArrayMap2 = simpleArrayMap.get(classLoader);
                    if (simpleArrayMap2 == null) {
                        simpleArrayMap2 = new SimpleArrayMap<>();
                        simpleArrayMap.put(classLoader, simpleArrayMap2);
                    }
                    creator = simpleArrayMap2.get(readString);
                    if (creator == null) {
                        if (classLoader == null) {
                            try {
                                classLoader = parcel.getClass().getClassLoader();
                            } catch (IllegalAccessException unused) {
                                throw new BadParcelableException("IllegalAccessException when unmarshalling: " + readString);
                            } catch (ClassNotFoundException unused2) {
                                throw new BadParcelableException("ClassNotFoundException when unmarshalling: " + readString);
                            } catch (NoSuchFieldException unused3) {
                                throw new BadParcelableException("Parcelable protocol requires a Parcelable.Creator object called CREATOR on class " + readString);
                            }
                        }
                        Class<?> cls2 = Class.forName(readString, false, classLoader);
                        Intrinsics.checkNotNullExpressionValue(cls2, "Class.forName(\n         …sLoader\n                )");
                        if (Parcelable.class.isAssignableFrom(cls2)) {
                            Field field = cls2.getField("CREATOR");
                            Intrinsics.checkNotNullExpressionValue(field, "parcelableClass.getField(\"CREATOR\")");
                            if ((field.getModifiers() & 8) != 0) {
                                Class<?> type = field.getType();
                                Intrinsics.checkNotNullExpressionValue(type, "field.type");
                                if (Parcelable.Creator.class.isAssignableFrom(type)) {
                                    Object obj = field.get(null);
                                    if (obj != null) {
                                        creator = (Parcelable.Creator) obj;
                                        simpleArrayMap2.put(readString, creator);
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type android.os.Parcelable.Creator<*>");
                                    }
                                } else {
                                    throw new BadParcelableException("Parcelable protocol requires a Parcelable.Creator object called CREATOR on class " + readString);
                                }
                            } else {
                                throw new BadParcelableException("Parcelable protocol requires the CREATOR object to be static on class " + readString);
                            }
                        } else {
                            throw new BadParcelableException("Parcelable protocol requires that the class implements Parcelable");
                        }
                    }
                }
            } else {
                creator = null;
            }
            creatorArr[parcel.readInt()] = creator;
        }
        int readInt2 = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt2);
        for (int i2 = 0; i2 < readInt2; i2++) {
            Parcelable.Creator creator2 = creatorArr[parcel.readInt()];
            Objects.requireNonNull(creator2, "null cannot be cast to non-null type android.os.Parcelable.Creator<*>");
            Object createFromParcel = creator2.createFromParcel(parcel);
            Objects.requireNonNull(createFromParcel, "null cannot be cast to non-null type T");
            arrayList.add((Parcelable) createFromParcel);
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }
}

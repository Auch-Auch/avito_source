package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.lib.design.input.FormatterType;
import com.vk.sdk.api.model.VKApiPhotoSize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.pqc.math.linearalgebra.Matrix;
import t6.y.m;
public final class ClassMapperLite {
    @NotNull
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();
    @NotNull
    public static final String a = CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{'k', Character.valueOf(VKApiPhotoSize.O), 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
    @NotNull
    public static final Map<String, String> b;

    static {
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 2;
                StringBuilder sb = new StringBuilder();
                String str = a;
                sb.append(str);
                sb.append('/');
                sb.append((String) listOf.get(i2));
                int i4 = i2 + 1;
                linkedHashMap.put(sb.toString(), listOf.get(i4));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append('/');
                linkedHashMap.put(a.t(sb2, (String) listOf.get(i2), "Array"), Intrinsics.stringPlus("[", listOf.get(i4)));
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 = i3;
            }
        }
        linkedHashMap.put(Intrinsics.stringPlus(a, "/Unit"), ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            a(linkedHashMap, str2, Intrinsics.stringPlus("java/lang/", str2));
        }
        for (String str3 : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            a(linkedHashMap, Intrinsics.stringPlus("collections/", str3), Intrinsics.stringPlus("java/util/", str3));
            a(linkedHashMap, Intrinsics.stringPlus("collections/Mutable", str3), Intrinsics.stringPlus("java/util/", str3));
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i5 = i + 1;
            String stringPlus = Intrinsics.stringPlus("Function", Integer.valueOf(i));
            StringBuilder sb3 = new StringBuilder();
            String str4 = a;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i);
            a(linkedHashMap, stringPlus, sb3.toString());
            a(linkedHashMap, Intrinsics.stringPlus("reflect/KFunction", Integer.valueOf(i)), Intrinsics.stringPlus(str4, "/reflect/KFunction"));
            if (i5 > 22) {
                break;
            }
            i = i5;
        }
        for (String str5 : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            a(linkedHashMap, Intrinsics.stringPlus(str5, ".Companion"), a.v(new StringBuilder(), a, "/jvm/internal/", str5, "CompanionObject"));
        }
        b = linkedHashMap;
    }

    public static final void a(Map<String, String> map, String str, String str2) {
        map.put(a + '/' + str, Matrix.MATRIX_TYPE_RANDOM_LT + str2 + ';');
    }

    @JvmStatic
    @NotNull
    public static final String mapClass(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "classId");
        String str2 = b.get(str);
        return str2 == null ? a.s(a.I(Matrix.MATRIX_TYPE_RANDOM_LT), m.replace$default(str, (char) FormatterType.defaultDecimalSeparator, (char) Typography.dollar, false, 4, (Object) null), ';') : str2;
    }
}

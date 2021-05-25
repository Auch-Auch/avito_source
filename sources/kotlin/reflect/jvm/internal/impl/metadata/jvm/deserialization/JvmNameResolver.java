package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.util.preferences.db_preferences.Types;
import com.vk.sdk.api.model.VKApiPhotoSize;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.n.y;
import t6.r.a.j;
import t6.v.e;
import t6.y.m;
public final class JvmNameResolver implements NameResolver {
    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final String e;
    @NotNull
    public static final List<String> f;
    @NotNull
    public final JvmProtoBuf.StringTableTypes a;
    @NotNull
    public final String[] b;
    @NotNull
    public final Set<Integer> c;
    @NotNull
    public final List<JvmProtoBuf.StringTableTypes.Record> d;

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final List<String> getPREDEFINED_STRINGS() {
            return JvmNameResolver.f;
        }

        public Companion(j jVar) {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2, 3};

        static {
            JvmProtoBuf.StringTableTypes.Record.Operation.values();
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{'k', Character.valueOf(VKApiPhotoSize.O), 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        e = joinToString$default;
        f = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Intrinsics.stringPlus(joinToString$default, "/Any"), Intrinsics.stringPlus(joinToString$default, "/Nothing"), Intrinsics.stringPlus(joinToString$default, "/Unit"), Intrinsics.stringPlus(joinToString$default, "/Throwable"), Intrinsics.stringPlus(joinToString$default, "/Number"), Intrinsics.stringPlus(joinToString$default, "/Byte"), Intrinsics.stringPlus(joinToString$default, "/Double"), Intrinsics.stringPlus(joinToString$default, "/Float"), Intrinsics.stringPlus(joinToString$default, "/Int"), Intrinsics.stringPlus(joinToString$default, "/Long"), Intrinsics.stringPlus(joinToString$default, "/Short"), Intrinsics.stringPlus(joinToString$default, "/Boolean"), Intrinsics.stringPlus(joinToString$default, "/Char"), Intrinsics.stringPlus(joinToString$default, "/CharSequence"), Intrinsics.stringPlus(joinToString$default, "/String"), Intrinsics.stringPlus(joinToString$default, "/Comparable"), Intrinsics.stringPlus(joinToString$default, "/Enum"), Intrinsics.stringPlus(joinToString$default, "/Array"), Intrinsics.stringPlus(joinToString$default, "/ByteArray"), Intrinsics.stringPlus(joinToString$default, "/DoubleArray"), Intrinsics.stringPlus(joinToString$default, "/FloatArray"), Intrinsics.stringPlus(joinToString$default, "/IntArray"), Intrinsics.stringPlus(joinToString$default, "/LongArray"), Intrinsics.stringPlus(joinToString$default, "/ShortArray"), Intrinsics.stringPlus(joinToString$default, "/BooleanArray"), Intrinsics.stringPlus(joinToString$default, "/CharArray"), Intrinsics.stringPlus(joinToString$default, "/Cloneable"), Intrinsics.stringPlus(joinToString$default, "/Annotation"), Intrinsics.stringPlus(joinToString$default, "/collections/Iterable"), Intrinsics.stringPlus(joinToString$default, "/collections/MutableIterable"), Intrinsics.stringPlus(joinToString$default, "/collections/Collection"), Intrinsics.stringPlus(joinToString$default, "/collections/MutableCollection"), Intrinsics.stringPlus(joinToString$default, "/collections/List"), Intrinsics.stringPlus(joinToString$default, "/collections/MutableList"), Intrinsics.stringPlus(joinToString$default, "/collections/Set"), Intrinsics.stringPlus(joinToString$default, "/collections/MutableSet"), Intrinsics.stringPlus(joinToString$default, "/collections/Map"), Intrinsics.stringPlus(joinToString$default, "/collections/MutableMap"), Intrinsics.stringPlus(joinToString$default, "/collections/Map.Entry"), Intrinsics.stringPlus(joinToString$default, "/collections/MutableMap.MutableEntry"), Intrinsics.stringPlus(joinToString$default, "/collections/Iterator"), Intrinsics.stringPlus(joinToString$default, "/collections/MutableIterator"), Intrinsics.stringPlus(joinToString$default, "/collections/ListIterator"), Intrinsics.stringPlus(joinToString$default, "/collections/MutableListIterator")});
        Iterable<IndexedValue> withIndex = CollectionsKt___CollectionsKt.withIndex(companion.getPREDEFINED_STRINGS());
        LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(withIndex, 10)), 16));
        for (IndexedValue indexedValue : withIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
    }

    public JvmNameResolver(@NotNull JvmProtoBuf.StringTableTypes stringTableTypes, @NotNull String[] strArr) {
        Set<Integer> set;
        Intrinsics.checkNotNullParameter(stringTableTypes, "types");
        Intrinsics.checkNotNullParameter(strArr, "strings");
        this.a = stringTableTypes;
        this.b = strArr;
        List<Integer> localNameList = stringTableTypes.getLocalNameList();
        if (localNameList.isEmpty()) {
            set = y.emptySet();
        } else {
            Intrinsics.checkNotNullExpressionValue(localNameList, "");
            set = CollectionsKt___CollectionsKt.toSet(localNameList);
        }
        this.c = set;
        ArrayList arrayList = new ArrayList();
        List<JvmProtoBuf.StringTableTypes.Record> recordList = getTypes().getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (JvmProtoBuf.StringTableTypes.Record record : recordList) {
            int range = record.getRange();
            for (int i = 0; i < range; i++) {
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        Unit unit = Unit.INSTANCE;
        this.d = arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getString(int i) {
        String str;
        JvmProtoBuf.StringTableTypes.Record record = this.d.get(i);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                Companion companion = Companion;
                int size = companion.getPREDEFINED_STRINGS().size() - 1;
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex <= size) {
                    str = companion.getPREDEFINED_STRINGS().get(record.getPredefinedIndex());
                }
            }
            str = this.b[i];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNullExpressionValue(substringIndexList, "substringIndexList");
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            Intrinsics.checkNotNullExpressionValue(num, "begin");
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                Intrinsics.checkNotNullExpressionValue(num2, "end");
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    Intrinsics.checkNotNullExpressionValue(str, Types.STRING);
                    str = str.substring(num.intValue(), num2.intValue());
                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNullExpressionValue(replaceCharList, "replaceCharList");
            Intrinsics.checkNotNullExpressionValue(str2, Types.STRING);
            str2 = m.replace$default(str2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, (Object) null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int ordinal = operation.ordinal();
        if (ordinal == 1) {
            Intrinsics.checkNotNullExpressionValue(str3, Types.STRING);
            str3 = m.replace$default(str3, (char) Typography.dollar, (char) FormatterType.defaultDecimalSeparator, false, 4, (Object) null);
        } else if (ordinal == 2) {
            if (str3.length() >= 2) {
                Intrinsics.checkNotNullExpressionValue(str3, Types.STRING);
                str3 = str3.substring(1, str3.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            Intrinsics.checkNotNullExpressionValue(str3, Types.STRING);
            str3 = m.replace$default(str3, (char) Typography.dollar, (char) FormatterType.defaultDecimalSeparator, false, 4, (Object) null);
        }
        Intrinsics.checkNotNullExpressionValue(str3, Types.STRING);
        return str3;
    }

    @NotNull
    public final JvmProtoBuf.StringTableTypes getTypes() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return this.c.contains(Integer.valueOf(i));
    }
}

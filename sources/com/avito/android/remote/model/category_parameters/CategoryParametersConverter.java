package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Entity;
import com.avito.android.remote.model.ImageUploadResult;
import com.avito.android.remote.model.Metro;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.BaseParametersConverter;
import com.avito.android.remote.model.category_parameters.DateTimeParameter;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.remote.model.category_parameters.RangeParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotWithState;
import com.avito.android.util.Collections;
import com.avito.android.util.Formatter;
import com.avito.android.util.RawPhoneNumberFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.q;
import t6.n.s;
import t6.n.x;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040)¢\u0006\u0004\b,\u0010-J3\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J=\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011JE\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f2*\u0010\u0014\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u00130\u0012\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0004\b\u0010\u0010\u0015J-\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0004\b\u0010\u0010\u0017J'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018¢\u0006\u0004\b\u0010\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0004*\u00020\u001c8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\"\u001a\u00020\u0004*\u00020\u00048B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001bR\u001a\u0010%\u001a\u00020\u0004*\u00020\u00048B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010!R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "Lcom/avito/android/remote/model/category_parameters/BaseParametersConverter;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", "", "map", "appendToFieldMap", "(Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;Ljava/util/Map;)Ljava/util/Map;", "key", "", "value", "appendField", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/Object;)Ljava/util/Map;", "Lcom/avito/android/remote/model/Navigation;", "navigation", "", "convertToFieldMap", "(Lcom/avito/android/remote/model/Navigation;)Ljava/util/Map;", "", "Lkotlin/Pair;", "fields", "([Lkotlin/Pair;)Ljava/util/Map;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "(Ljava/util/Map;)Ljava/util/Map;", "", "(Ljava/lang/Iterable;)Ljava/util/Map;", "paramKeyBase", "Ljava/lang/String;", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "getParamKey", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Ljava/lang/String;", "paramKey", "getToParamKey", "(Ljava/lang/String;)Ljava/lang/String;", "toParamKey", "slotKeyBase", "getToSlotKey", "toSlotKey", "", "hardcodedParamIds", "Ljava/util/Set;", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "Lcom/avito/android/util/Formatter;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/util/Formatter;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryParametersConverter implements BaseParametersConverter {
    private final Set<String> hardcodedParamIds;
    private final String paramKeyBase;
    private final Formatter<String> phoneNumberFormatter;
    private final String slotKeyBase;

    public CategoryParametersConverter() {
        this(null, null, null, 7, null);
    }

    public CategoryParametersConverter(@NotNull String str, @NotNull String str2, @NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(str, "paramKeyBase");
        Intrinsics.checkNotNullParameter(str2, "slotKeyBase");
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        this.paramKeyBase = str;
        this.slotKeyBase = str2;
        this.phoneNumberFormatter = formatter;
        this.hardcodedParamIds = x.setOf(ParameterId.COORDS);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, String> appendField(Map<String, String> map, String str, Object obj) {
        if (obj != 0) {
            if (obj instanceof String) {
                map.put(str, obj);
            } else if (obj instanceof Number) {
                appendField(map, str, obj.toString());
            } else if (obj instanceof Boolean) {
                appendField(map, str, toFormValue(((Boolean) obj).booleanValue()));
            } else if (obj instanceof Entity) {
                appendField(map, str, ((Entity) obj).getId());
            } else if (obj instanceof Map) {
                for (Map.Entry entry : Collections.filterValuesNotNull((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    appendField(map, str + '[' + key + ']', value);
                }
            } else if (obj instanceof Iterable) {
                int i = 0;
                for (Object obj2 : CollectionsKt___CollectionsKt.filterNotNull((Iterable) obj)) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    appendField(map, str + '[' + i + ']', obj2);
                    i = i2;
                }
            } else {
                for (Pair<String, Object> pair : getFields(obj)) {
                    Object component2 = pair.component2();
                    appendField(map, str + '[' + pair.component1() + ']', component2);
                }
            }
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v15. Raw type applied. Possible types: com.avito.android.util.Formatter<java.lang.String>, com.avito.android.util.Formatter */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.avito.android.remote.model.category_parameters.CategoryParametersConverter] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    private final Map<String, String> appendToFieldMap(ParameterSlot parameterSlot, Map<String, String> map) {
        List<ImageUploadResult> onlyUploaded;
        List<ParameterSlot> parameters;
        if (parameterSlot instanceof SelectParameter) {
            SelectParameter.Value chosenOrCurrentSelectedValue = ((SelectParameter) parameterSlot).getChosenOrCurrentSelectedValue();
            appendField(map, getParamKey((CategoryParameter) parameterSlot), chosenOrCurrentSelectedValue);
            if (!(chosenOrCurrentSelectedValue == null || (parameters = chosenOrCurrentSelectedValue.getParameters()) == null)) {
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    appendToFieldMap(it.next(), map);
                }
            }
        } else {
            int i = 0;
            ArrayList arrayList = null;
            if (parameterSlot instanceof AddressParameter) {
                AddressParameter.Value value = (AddressParameter.Value) ((AddressParameter) parameterSlot).getValue();
                if (value != null) {
                    appendField(map, m.startsWith$default(parameterSlot.getId(), "params", false, 2, null) ? parameterSlot.getId() : getParamKey((CategoryParameter) parameterSlot), value);
                    appendField(map, ParameterId.COORDS, value);
                }
            } else if (parameterSlot instanceof ObjectsParameter) {
                List list = (List) ((ObjectsParameter) parameterSlot).getValue();
                if (list != null) {
                    for (Object obj : list) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        String str = getParamKey((CategoryParameter) parameterSlot) + '[' + i + ']';
                        Map<String, String> convertToFieldMap = convertToFieldMap((List) obj);
                        LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(convertToFieldMap.size()));
                        for (T t : convertToFieldMap.entrySet()) {
                            linkedHashMap.put(StringsKt__StringsKt.removePrefix((String) t.getKey(), (CharSequence) this.paramKeyBase), t.getValue());
                        }
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            StringBuilder L = a.L(str);
                            L.append((String) entry.getKey());
                            map.put(L.toString(), entry.getValue());
                        }
                        i = i2;
                    }
                }
            } else if (parameterSlot instanceof PhotoParameter) {
                String paramKey = getParamKey((CategoryParameter) parameterSlot);
                PhotoParameter.ImageUploadListWrapper imageUploadListWrapper = (PhotoParameter.ImageUploadListWrapper) ((PhotoParameter) parameterSlot).getValue();
                if (!(imageUploadListWrapper == null || (onlyUploaded = imageUploadListWrapper.getOnlyUploaded()) == null)) {
                    arrayList = new ArrayList(e.collectionSizeOrDefault(onlyUploaded, 10));
                    Iterator<T> it2 = onlyUploaded.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next().getUploadId());
                    }
                }
                appendField(map, paramKey, arrayList);
            } else if (parameterSlot instanceof GroupParameter) {
                Iterator<T> it3 = ((GroupParameter) parameterSlot).getParameters().iterator();
                while (it3.hasNext()) {
                    appendToFieldMap(it3.next(), map);
                }
            } else if (parameterSlot instanceof DateTimeIntervalParameter) {
                for (DateTimeParameter dateTimeParameter : ((DateTimeIntervalParameter) parameterSlot).getParameters()) {
                    appendToFieldMap(dateTimeParameter, map);
                }
            } else if (parameterSlot instanceof DateTimeParameter) {
                DateTimeParameter.Value value2 = (DateTimeParameter.Value) ((DateTimeParameter) parameterSlot).getValue();
                if (value2 != null) {
                    appendField(map, getParamKey((CategoryParameter) parameterSlot), DateTimeParameterKt.toFormValue(value2));
                }
            } else if (parameterSlot instanceof PhoneParameter) {
                String paramKey2 = getParamKey((CategoryParameter) parameterSlot);
                String format = this.phoneNumberFormatter.format(((PhoneParameter) parameterSlot).getValue());
                if (!Intrinsics.areEqual(format, "")) {
                    arrayList = format;
                }
                appendField(map, paramKey2, arrayList);
            } else if (parameterSlot instanceof MultiselectParameter) {
                appendField(map, getParamKey((CategoryParameter) parameterSlot), ((MultiselectParameter) parameterSlot).getValue());
            } else if (parameterSlot instanceof RangeParameter) {
                RangeParameter.RangeValue rangeValue = (RangeParameter.RangeValue) ((RangeParameter) parameterSlot).getValue();
                if (rangeValue != null) {
                    Double from = rangeValue.getFrom();
                    if (from != null) {
                        appendField(map, a.t(new StringBuilder(), getParamKey((CategoryParameter) parameterSlot), "[from]"), Double.valueOf(from.doubleValue()));
                    }
                    Double to = rangeValue.getTo();
                    if (to != null) {
                        appendField(map, a.t(new StringBuilder(), getParamKey((CategoryParameter) parameterSlot), "[to]"), Double.valueOf(to.doubleValue()));
                    }
                }
            } else if (parameterSlot instanceof MetroParameter) {
                List<Metro> list2 = (List) ((MetroParameter) parameterSlot).getValue();
                if (list2 != null) {
                    String paramKey3 = getParamKey((CategoryParameter) parameterSlot);
                    ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list2, 10));
                    for (Metro metro : list2) {
                        arrayList2.add(metro.getId());
                    }
                    appendField(map, paramKey3, arrayList2);
                }
            } else if (parameterSlot instanceof EditableParameter) {
                appendField(map, getParamKey((CategoryParameter) parameterSlot), ((EditableParameter) parameterSlot).getValue());
            } else if (parameterSlot instanceof SlotWithState) {
                Map<String, String> convertToFieldMap2 = convertToFieldMap(((SlotWithState) parameterSlot).getState().getFields());
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(q.mapCapacity(convertToFieldMap2.size()));
                for (T t2 : convertToFieldMap2.entrySet()) {
                    linkedHashMap2.put(StringsKt__StringsKt.removePrefix((String) t2.getKey(), (CharSequence) this.paramKeyBase), t2.getValue());
                }
                for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                    map.put(getToSlotKey(parameterSlot.getId()) + ((String) entry2.getKey()), entry2.getValue());
                }
            }
        }
        return map;
    }

    private final String getParamKey(CategoryParameter categoryParameter) {
        return getToParamKey(categoryParameter.getId());
    }

    private final String getToParamKey(String str) {
        if (this.hardcodedParamIds.contains(str)) {
            return str;
        }
        return this.paramKeyBase + '[' + str + ']';
    }

    private final String getToSlotKey(String str) {
        return this.slotKeyBase + '[' + str + ']';
    }

    @NotNull
    public final Map<String, String> convertToFieldMap(@NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        return convertToFieldMap(TuplesKt.to("navigation", navigation));
    }

    @Override // com.avito.android.remote.model.category_parameters.BaseParametersConverter
    @NotNull
    public Sequence<Pair<String, Object>> getFields(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "$this$fields");
        return BaseParametersConverter.DefaultImpls.getFields(this, obj);
    }

    @Override // com.avito.android.remote.model.category_parameters.BaseParametersConverter
    @NotNull
    public String toFormValue(boolean z) {
        return BaseParametersConverter.DefaultImpls.toFormValue(this, z);
    }

    @NotNull
    public final Map<String, String> convertToFieldMap(@NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "fields");
        Sequence<Pair> asSequence = ArraysKt___ArraysKt.asSequence(pairArr);
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        for (Pair pair : asSequence) {
            linkedHashMap = appendField(linkedHashMap, (String) pair.component1(), pair.component2());
        }
        return linkedHashMap;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryParametersConverter(String str, String str2, Formatter formatter, int i, j jVar) {
        this((i & 1) != 0 ? "params" : str, (i & 2) != 0 ? "slots" : str2, (i & 4) != 0 ? new RawPhoneNumberFormatter() : formatter);
    }

    @NotNull
    public final Map<String, String> convertToFieldMap(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Sequence<Map.Entry> asSequence = s.asSequence(map);
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry entry : asSequence) {
            linkedHashMap = appendField(linkedHashMap, getToParamKey((String) entry.getKey()), entry.getValue());
        }
        return linkedHashMap;
    }

    @NotNull
    public final Map<String, String> convertToFieldMap(@NotNull Iterable<? extends ParameterSlot> iterable) {
        Intrinsics.checkNotNullParameter(iterable, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        for (ParameterSlot parameterSlot : iterable) {
            linkedHashMap = appendToFieldMap(parameterSlot, linkedHashMap);
        }
        return linkedHashMap;
    }
}

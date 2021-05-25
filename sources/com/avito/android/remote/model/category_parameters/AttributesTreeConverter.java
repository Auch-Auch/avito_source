package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.Entity;
import com.avito.android.remote.model.ImageUploadResult;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.AttributeNode;
import com.avito.android.remote.model.category_parameters.BaseParametersConverter;
import com.avito.android.remote.model.category_parameters.DateTimeParameter;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotWithState;
import com.avito.android.util.Collections;
import com.avito.android.util.Formatter;
import com.avito.android.util.RawPhoneNumberFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u001c\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010/\u001a\u00020\u0006\u0012\b\b\u0002\u0010*\u001a\u00020\u0006\u0012\b\b\u0002\u00100\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060,¢\u0006\u0004\b1\u00102J5\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000e\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\nJ;\u0010\u0013\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\r*\u00020\u00152\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001b\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004¢\u0006\u0004\b\u001f\u0010\u001eJ+\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0010\u0010 \u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004¢\u0006\u0004\b!\u0010\u001eJ+\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0010\u0010\"\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004¢\u0006\u0004\b#\u0010\u001eJ%\u0010&\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150$¢\u0006\u0004\b&\u0010'J%\u0010(\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150$¢\u0006\u0004\b(\u0010'J%\u0010)\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150$¢\u0006\u0004\b)\u0010'R\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010+R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010+¨\u00063"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;", "Lcom/avito/android/remote/model/category_parameters/BaseParametersConverter;", "", "Lcom/avito/android/remote/model/category_parameters/AttributeNode;", "Lcom/avito/android/remote/model/category_parameters/AttributesTree;", "attributesTree", "", "key", "", "convertToFieldMap", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/Map;", "", "tree", "", "appendToFieldMap", "(Ljava/util/Map;Lcom/avito/android/remote/model/category_parameters/AttributeNode;Ljava/lang/String;)V", "convertToAttributeMap", "", "innerIndex", "appendToAttributeMap", "(Ljava/util/Map;Lcom/avito/android/remote/model/category_parameters/AttributeNode;Ljava/lang/String;Ljava/lang/Integer;)V", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", "appendToAttributesTree", "(Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;Ljava/util/List;)V", "", "value", "appendField", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Object;)V", "convertToSlotFieldMap", "(Ljava/util/List;)Ljava/util/Map;", "convertToParameterFieldMap", "slotsTree", "convertToSlotAttributesMap", "parametersTree", "convertToParameterAttributesMap", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "convertToSlotAttributesTree", "(Ljava/lang/Iterable;)Ljava/util/List;", "convertToParameterAttributesTree", "convertToAttributesTree", "slotKeyBase", "Ljava/lang/String;", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "Lcom/avito/android/util/Formatter;", "paramKeyBase", "attributesKeyBase", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/util/Formatter;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class AttributesTreeConverter implements BaseParametersConverter {
    private final String attributesKeyBase;
    private final String paramKeyBase;
    private final Formatter<String> phoneNumberFormatter;
    private final String slotKeyBase;

    public AttributesTreeConverter() {
        this(null, null, null, null, 15, null);
    }

    public AttributesTreeConverter(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(str, "paramKeyBase");
        Intrinsics.checkNotNullParameter(str2, "slotKeyBase");
        Intrinsics.checkNotNullParameter(str3, "attributesKeyBase");
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        this.paramKeyBase = str;
        this.slotKeyBase = str2;
        this.attributesKeyBase = str3;
        this.phoneNumberFormatter = formatter;
    }

    private final void appendField(List<AttributeNode> list, String str, Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                list.add(new AttributeNode.StringNode(str, (String) obj));
            } else if (obj instanceof Number) {
                appendField(list, str, obj.toString());
            } else if (obj instanceof Boolean) {
                appendField(list, str, toFormValue(((Boolean) obj).booleanValue()));
            } else if (obj instanceof Entity) {
                appendField(list, str, ((Entity) obj).getId());
            } else if (obj instanceof Map) {
                AttributeNode.ListNode listNode = new AttributeNode.ListNode(str, null, 2, null);
                for (Map.Entry entry : Collections.filterValuesNotNull((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    appendField(listNode.getValue(), String.valueOf(key), entry.getValue());
                }
                list.add(listNode);
            } else if (obj instanceof Iterable) {
                AttributeNode.ListNode listNode2 = new AttributeNode.ListNode(str, null, 2, null);
                List filterNotNull = CollectionsKt___CollectionsKt.filterNotNull((Iterable) obj);
                int i = 0;
                for (Object obj2 : filterNotNull) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    appendField(listNode2.getValue(), String.valueOf(i), obj2);
                    i = i2;
                }
                list.add(listNode2);
            } else {
                AttributeNode.ListNode listNode3 = new AttributeNode.ListNode(str, null, 2, null);
                for (Pair<String, Object> pair : getFields(obj)) {
                    appendField(listNode3.getValue(), pair.component1(), pair.component2());
                }
                list.add(listNode3);
            }
        }
    }

    private final void appendToAttributeMap(Map<String, String> map, AttributeNode attributeNode, String str, Integer num) {
        String str2;
        if (attributeNode instanceof AttributeNode.ListNode) {
            AttributeNode.ListNode listNode = (AttributeNode.ListNode) attributeNode;
            if ((!listNode.getValue().isEmpty()) && num == null) {
                map.put(a.c3(str, "[id]"), attributeNode.getId());
            }
            List<AttributeNode> value = listNode.getValue();
            int i = 0;
            for (T t : value) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                if (num != null) {
                    str2 = str + '[' + num.intValue() + ']';
                    if (str2 != null) {
                        appendToAttributeMap(map, t2, str2, Integer.valueOf(i));
                        i = i2;
                    }
                }
                str2 = a.c3(str, "[value]");
                appendToAttributeMap(map, t2, str2, Integer.valueOf(i));
                i = i2;
            }
        } else if (attributeNode instanceof AttributeNode.StringNode) {
            if (num == null) {
                map.put(a.c3(str, "[id]"), attributeNode.getId());
                map.put(str + "[value]", ((AttributeNode.StringNode) attributeNode).getValue());
                return;
            }
            map.put(str + '[' + attributeNode.getId() + ']', ((AttributeNode.StringNode) attributeNode).getValue());
        }
    }

    public static /* synthetic */ void appendToAttributeMap$default(AttributesTreeConverter attributesTreeConverter, Map map, AttributeNode attributeNode, String str, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        attributesTreeConverter.appendToAttributeMap(map, attributeNode, str, num);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.avito.android.util.Formatter<java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    private final void appendToAttributesTree(ParameterSlot parameterSlot, List<AttributeNode> list) {
        List<ImageUploadResult> onlyUploaded;
        List<ParameterSlot> parameters;
        if (parameterSlot instanceof SelectParameter) {
            SelectParameter.Value chosenOrCurrentSelectedValue = ((SelectParameter) parameterSlot).getChosenOrCurrentSelectedValue();
            appendField(list, parameterSlot.getId(), chosenOrCurrentSelectedValue);
            if (!(chosenOrCurrentSelectedValue == null || (parameters = chosenOrCurrentSelectedValue.getParameters()) == null)) {
                for (ParameterSlot parameterSlot2 : parameters) {
                    appendToAttributesTree(parameterSlot2, list);
                }
            }
        } else if (parameterSlot instanceof AddressParameter) {
            Object obj = (AddressParameter.Value) ((AddressParameter) parameterSlot).getValue();
            if (obj != null) {
                appendField(list, parameterSlot.getId(), obj);
            }
        } else {
            ArrayList arrayList = null;
            if (parameterSlot instanceof ObjectsParameter) {
                AttributeNode.ListNode listNode = new AttributeNode.ListNode(parameterSlot.getId(), null, 2, null);
                List list2 = (List) ((ObjectsParameter) parameterSlot).getValue();
                if (list2 != null) {
                    int i = 0;
                    for (Object obj2 : list2) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        AttributeNode.ListNode listNode2 = new AttributeNode.ListNode(String.valueOf(i), null, 2, null);
                        for (ParameterSlot parameterSlot3 : (List) obj2) {
                            appendToAttributesTree(parameterSlot3, listNode2.getValue());
                        }
                        listNode.getValue().add(listNode2);
                        i = i2;
                    }
                }
                list.add(listNode);
            } else if (parameterSlot instanceof PhotoParameter) {
                String id = parameterSlot.getId();
                PhotoParameter.ImageUploadListWrapper imageUploadListWrapper = (PhotoParameter.ImageUploadListWrapper) ((PhotoParameter) parameterSlot).getValue();
                if (!(imageUploadListWrapper == null || (onlyUploaded = imageUploadListWrapper.getOnlyUploaded()) == null)) {
                    arrayList = new ArrayList(e.collectionSizeOrDefault(onlyUploaded, 10));
                    Iterator<T> it = onlyUploaded.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getUploadId());
                    }
                }
                appendField(list, id, arrayList);
            } else if (parameterSlot instanceof GroupParameter) {
                for (ParameterSlot parameterSlot4 : ((GroupParameter) parameterSlot).getParameters()) {
                    appendToAttributesTree(parameterSlot4, list);
                }
            } else if (parameterSlot instanceof DateTimeIntervalParameter) {
                for (ParameterSlot parameterSlot5 : ((DateTimeIntervalParameter) parameterSlot).getParameters()) {
                    appendToAttributesTree(parameterSlot5, list);
                }
            } else if (parameterSlot instanceof DateTimeParameter) {
                DateTimeParameter.Value value = (DateTimeParameter.Value) ((DateTimeParameter) parameterSlot).getValue();
                if (value != null) {
                    appendField(list, parameterSlot.getId(), DateTimeParameterKt.toFormValue(value));
                }
            } else if (parameterSlot instanceof PhoneParameter) {
                appendField(list, parameterSlot.getId(), this.phoneNumberFormatter.format(((PhoneParameter) parameterSlot).getValue()));
            } else if (parameterSlot instanceof MultiselectParameter) {
                appendField(list, parameterSlot.getId(), ((MultiselectParameter) parameterSlot).getValue());
            } else if (parameterSlot instanceof EditableParameter) {
                appendField(list, parameterSlot.getId(), ((EditableParameter) parameterSlot).getValue());
            } else if (parameterSlot instanceof SlotWithState) {
                AttributeNode.ListNode listNode3 = new AttributeNode.ListNode(parameterSlot.getId(), null, 2, null);
                for (ParameterSlot parameterSlot6 : ((SlotWithState) parameterSlot).getState().getFields()) {
                    appendToAttributesTree(parameterSlot6, listNode3.getValue());
                }
                list.add(listNode3);
            }
        }
    }

    private final void appendToFieldMap(Map<String, String> map, AttributeNode attributeNode, String str) {
        if (attributeNode instanceof AttributeNode.ListNode) {
            Iterator<T> it = ((AttributeNode.ListNode) attributeNode).getValue().iterator();
            while (it.hasNext()) {
                appendToFieldMap(map, it.next(), str + '[' + attributeNode.getId() + ']');
            }
        } else if (attributeNode instanceof AttributeNode.StringNode) {
            map.put(str + '[' + attributeNode.getId() + ']', ((AttributeNode.StringNode) attributeNode).getValue());
        }
    }

    public static /* synthetic */ void appendToFieldMap$default(AttributesTreeConverter attributesTreeConverter, Map map, AttributeNode attributeNode, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        attributesTreeConverter.appendToFieldMap(map, attributeNode, str);
    }

    private final Map<String, String> convertToAttributeMap(List<? extends AttributeNode> list, String str) {
        HashMap hashMap = new HashMap();
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            appendToAttributeMap$default(this, hashMap, t2, str + '[' + i + ']', null, 4, null);
            i = i2;
        }
        return hashMap;
    }

    private final Map<String, String> convertToFieldMap(List<? extends AttributeNode> list, String str) {
        HashMap hashMap = new HashMap();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            appendToFieldMap(hashMap, it.next(), str);
        }
        return hashMap;
    }

    @NotNull
    public final List<AttributeNode> convertToAttributesTree(@NotNull Iterable<? extends ParameterSlot> iterable) {
        Intrinsics.checkNotNullParameter(iterable, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        ArrayList arrayList = new ArrayList();
        ArrayList<ParameterSlot> arrayList2 = new ArrayList();
        for (Object obj : iterable) {
            String id = ((ParameterSlot) obj).getId();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= id.length()) {
                    z = true;
                    break;
                } else if (!Character.isDigit(id.charAt(i))) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                arrayList2.add(obj);
            }
        }
        for (ParameterSlot parameterSlot : arrayList2) {
            appendToAttributesTree(parameterSlot, arrayList);
        }
        return arrayList;
    }

    @NotNull
    public final Map<String, String> convertToParameterAttributesMap(@NotNull List<? extends AttributeNode> list) {
        Intrinsics.checkNotNullParameter(list, "parametersTree");
        return convertToAttributeMap(list, this.attributesKeyBase);
    }

    @NotNull
    public final List<AttributeNode> convertToParameterAttributesTree(@NotNull Iterable<? extends ParameterSlot> iterable) {
        Intrinsics.checkNotNullParameter(iterable, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (!(((ParameterSlot) obj) instanceof SlotWithState)) {
                arrayList.add(obj);
            }
        }
        return convertToAttributesTree(arrayList);
    }

    @NotNull
    public final Map<String, String> convertToParameterFieldMap(@NotNull List<? extends AttributeNode> list) {
        Intrinsics.checkNotNullParameter(list, "attributesTree");
        return convertToFieldMap(list, this.paramKeyBase);
    }

    @NotNull
    public final Map<String, String> convertToSlotAttributesMap(@NotNull List<? extends AttributeNode> list) {
        Intrinsics.checkNotNullParameter(list, "slotsTree");
        return convertToAttributeMap(list, this.slotKeyBase);
    }

    @NotNull
    public final List<AttributeNode> convertToSlotAttributesTree(@NotNull Iterable<? extends ParameterSlot> iterable) {
        Intrinsics.checkNotNullParameter(iterable, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (((ParameterSlot) obj) instanceof SlotWithState) {
                arrayList.add(obj);
            }
        }
        return convertToAttributesTree(arrayList);
    }

    @NotNull
    public final Map<String, String> convertToSlotFieldMap(@NotNull List<? extends AttributeNode> list) {
        Intrinsics.checkNotNullParameter(list, "attributesTree");
        return convertToFieldMap(list, this.slotKeyBase);
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AttributesTreeConverter(String str, String str2, String str3, Formatter formatter, int i, j jVar) {
        this((i & 1) != 0 ? "params" : str, (i & 2) != 0 ? "slots" : str2, (i & 4) != 0 ? Navigation.ATTRIBUTES : str3, (i & 8) != 0 ? new RawPhoneNumberFormatter() : formatter);
    }
}

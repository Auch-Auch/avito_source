package com.avito.android.delivery.summary.konveyor;

import a2.b.a.a.a;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.delivery.summary.konveyor.button.ButtonItem;
import com.avito.android.delivery.summary.konveyor.divider.DividerItem;
import com.avito.android.delivery.summary.konveyor.header.HeaderItem;
import com.avito.android.delivery.summary.konveyor.link.LinkItem;
import com.avito.android.delivery.summary.konveyor.shipment.ShipmentItem;
import com.avito.android.delivery.summary.konveyor.text.TextItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.EmailParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasError;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010*\u001a\u00020(\u0012\u0006\u0010'\u001a\u00020%¢\u0006\u0004\b8\u00109J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\fJ9\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0012J\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010)R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b.\u0010,R$\u00107\u001a\u0004\u0018\u0001008\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverterImpl;", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;", ErrorBundle.SUMMARY_ENTRY, "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "deepLinkClickListener", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)Ljava/util/List;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "contactsGroup", "(Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;)Ljava/util/List;", "", "", "valuesMap", "oldItems", "applyValues", "(Ljava/util/Map;Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "formSections", "Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "createParametersTree", "(Ljava/util/List;)Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "errorsMap", "applyErrors", "paramId", "newValue", "", "onParameterValueChanged", "(Ljava/lang/String;Ljava/lang/String;)V", "", "withParameters", "c", "(Z)Ljava/util/Map;", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;Z)Ljava/lang/String;", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryKonveyorResourceProvider;", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryKonveyorResourceProvider;", "resourceProvider", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "getFieldsMap", "()Ljava/util/Map;", "fieldsMap", "getParametersMap", "parametersMap", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParametersTree", "()Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "setParametersTree", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "parametersTree", "<init>", "(Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryKonveyorResourceProvider;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsSummaryItemsConverterImpl implements DeliveryRdsSummaryItemsConverter {
    @Nullable
    public ParametersTree a;
    public final CategoryParametersElementConverter b;
    public final DeliveryRdsSummaryKonveyorResourceProvider c;

    @Inject
    public DeliveryRdsSummaryItemsConverterImpl(@NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull DeliveryRdsSummaryKonveyorResourceProvider deliveryRdsSummaryKonveyorResourceProvider) {
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryKonveyorResourceProvider, "resourceProvider");
        this.b = categoryParametersElementConverter;
        this.c = deliveryRdsSummaryKonveyorResourceProvider;
    }

    public static Item a(DeliveryRdsSummaryItemsConverterImpl deliveryRdsSummaryItemsConverterImpl, String str, boolean z, boolean z2, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return new HeaderItem(DeliveryRdsSummaryItemsConverterKt.HEADER_USER_INFO_ID, str, z2, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter
    @NotNull
    public List<Item> applyErrors(@NotNull Map<String, String> map, @NotNull List<? extends Item> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(map, "errorsMap");
        Intrinsics.checkNotNullParameter(list, "oldItems");
        ParametersTree<ParameterSlot> parametersTree = getParametersTree();
        if (parametersTree == null) {
            return list;
        }
        for (ParameterSlot parameterSlot : parametersTree) {
            String str = map.get(parameterSlot.getId());
            if (str != null && (parameterSlot instanceof HasError)) {
                ((HasError) parameterSlot).setError(str);
            }
        }
        List convert$default = CategoryParametersElementConverter.convert$default(this.b, parametersTree, null, null, 6, null);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (Item item : list) {
            Iterator it = convert$default.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((Item) obj).getStringId(), item.getStringId())) {
                    break;
                }
            }
            Item item2 = (Item) obj;
            if (item2 != null) {
                item = item2;
            }
            arrayList.add(item);
        }
        return arrayList;
    }

    @Override // com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter
    @NotNull
    public List<Item> applyValues(@NotNull Map<String, String> map, @NotNull List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(map, "valuesMap");
        Intrinsics.checkNotNullParameter(list, "oldItems");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            String str = map.get(t.getStringId());
            if (str != null) {
                TextItem textItem = !(t instanceof TextItem) ? null : t;
                if (textItem != null) {
                    t = new TextItem(textItem.getStringId(), AttributedText.copy$default(textItem.getTitle(), str, null, 2, null), textItem.getDescription());
                }
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    public final String b(String str, boolean z) {
        return z ? a.d3("parameters[", str, ']') : str;
    }

    public final Map<String, String> c(boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterable<ParameterSlot> parametersTree = getParametersTree();
        if (parametersTree == null) {
            parametersTree = CollectionsKt__CollectionsKt.emptyList();
        }
        for (ParameterSlot parameterSlot : parametersTree) {
            if (parameterSlot instanceof CharParameter) {
                String b2 = b(parameterSlot.getId(), z);
                String str = (String) ((CharParameter) parameterSlot).getValue();
                if (str != null) {
                    linkedHashMap.put(b2, str);
                }
            } else if (parameterSlot instanceof PhoneParameter) {
                String b3 = b(parameterSlot.getId(), z);
                String str2 = (String) ((PhoneParameter) parameterSlot).getValue();
                if (str2 != null) {
                    linkedHashMap.put(b3, str2);
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter
    @NotNull
    public List<Item> convert(@NotNull DeliverySummaryRds deliverySummaryRds, @NotNull OnDeepLinkClickListener onDeepLinkClickListener) {
        Boolean bool;
        List<AttributedText> contacts;
        Intrinsics.checkNotNullParameter(deliverySummaryRds, ErrorBundle.SUMMARY_ENTRY);
        Intrinsics.checkNotNullParameter(onDeepLinkClickListener, "deepLinkClickListener");
        ArrayList arrayList = new ArrayList();
        DeliverySummaryRds.DeliveryGroup deliveryGroup = deliverySummaryRds.getDeliveryGroup();
        arrayList.add(new HeaderItem(DeliveryRdsSummaryItemsConverterKt.HEADER_ADDRESS_ID, deliveryGroup.getTitle(), false, deliveryGroup.getEditable(), 4, null));
        arrayList.add(new TextItem(String.valueOf(arrayList.size()), deliveryGroup.getInfo(), null, 4, null));
        DeliverySummaryRds.ShipmentsGroup shipmentsGroup = deliverySummaryRds.getShipmentsGroup();
        if (shipmentsGroup != null) {
            arrayList.add(new HeaderItem(String.valueOf(arrayList.size()), shipmentsGroup.getTitle(), true, false, 8, null));
            List<DeliverySummaryRds.ShipmentsGroup.Shipment> shipments = shipmentsGroup.getShipments();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(shipments, 10));
            int i = 0;
            for (T t : shipments) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                arrayList2.add(new ShipmentItem(a.M2("shipment#", i), t2.getTitle(), t2.getSubtitle(), t2.getItems()));
                i = i2;
            }
            arrayList.addAll(arrayList2);
        }
        DeliverySummaryRds.ContactsGroup contactsGroup = deliverySummaryRds.getContactsGroup();
        List<DeliverySummaryRds.ContactsGroup.PrefilledContact> prefilledContactsGroup = contactsGroup.getPrefilledContactsGroup();
        if (prefilledContactsGroup != null) {
            arrayList.add(a(this, contactsGroup.getTitle(), contactsGroup.getEditable(), false, 4));
            ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(prefilledContactsGroup, 10));
            for (T t3 : prefilledContactsGroup) {
                arrayList3.add(new TextItem(t3.getId(), t3.getText(), null, 4, null));
            }
            bool = Boolean.valueOf(arrayList.addAll(arrayList3));
        } else {
            List<ParameterSlot> formSections = contactsGroup.getFormSections();
            if (formSections != null) {
                arrayList.add(a(this, contactsGroup.getTitle(), false, false, 4));
                bool = Boolean.valueOf(arrayList.addAll(CategoryParametersElementConverter.convert$default(this.b, createParametersTree(formSections), null, null, 6, null)));
            } else {
                bool = null;
            }
        }
        if (bool == null && (contacts = contactsGroup.getContacts()) != null) {
            arrayList.add(a(this, contactsGroup.getTitle(), false, false, 4));
            ArrayList arrayList4 = new ArrayList(e.collectionSizeOrDefault(contacts, 10));
            Iterator<T> it = contacts.iterator();
            while (it.hasNext()) {
                arrayList4.add(new TextItem(String.valueOf(arrayList.size()), it.next(), null, 4, null));
            }
            arrayList.addAll(arrayList4);
        }
        DeliverySummaryRds.CalculationsGroup calculationsGroup = deliverySummaryRds.getCalculationsGroup();
        arrayList.add(new HeaderItem(String.valueOf(arrayList.size()), calculationsGroup.getTitle(), true, false, 8, null));
        arrayList.addAll(DeliveryRdsSummaryItemsConverterKt.toPriceItems(calculationsGroup.getDetails()));
        arrayList.add(new DividerItem(String.valueOf(arrayList.size())));
        AttributedText disclaimer = deliverySummaryRds.getDisclaimer();
        if (disclaimer != null) {
            disclaimer.setOnDeepLinkClickListener(onDeepLinkClickListener);
            arrayList.add(new LinkItem(String.valueOf(arrayList.size()), disclaimer));
        }
        DeliverySummaryRds.Header header = deliverySummaryRds.getHeader();
        Integer availableQuantity = header != null ? header.getAvailableQuantity() : null;
        arrayList.add(new ButtonItem(DeliveryRdsSummaryItemsConverterKt.SUBMIT_BUTTON_ID, this.c.getButtonTitle(), false, availableQuantity == null || availableQuantity.intValue() > 0, 4, null));
        return arrayList;
    }

    @Override // com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter
    @NotNull
    public SimpleParametersTree createParametersTree(@NotNull List<? extends ParameterSlot> list) {
        Intrinsics.checkNotNullParameter(list, "formSections");
        SimpleParametersTree simpleParametersTree = new SimpleParametersTree(list, null, 2, null);
        setParametersTree(simpleParametersTree);
        return simpleParametersTree;
    }

    @Override // com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter
    @NotNull
    public Map<String, String> getFieldsMap() {
        return c(false);
    }

    @Override // com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter
    @NotNull
    public Map<String, String> getParametersMap() {
        return c(true);
    }

    @Override // com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter
    @Nullable
    public ParametersTree getParametersTree() {
        return this.a;
    }

    @Override // com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter
    public void onParameterValueChanged(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "paramId");
        Intrinsics.checkNotNullParameter(str2, "newValue");
        ParametersTree parametersTree = getParametersTree();
        ParameterSlot findParameter = parametersTree != null ? parametersTree.findParameter(str) : null;
        if (findParameter == null) {
            return;
        }
        if (findParameter instanceof EmailParameter) {
            EditableParameter editableParameter = (EditableParameter) findParameter;
            if (!Intrinsics.areEqual(editableParameter.getValue(), str2)) {
                editableParameter.setValue(str2);
                editableParameter.setError(null);
            }
        } else if (findParameter instanceof CharParameter) {
            EditableParameter editableParameter2 = (EditableParameter) findParameter;
            if (!Intrinsics.areEqual(editableParameter2.getValue(), str2)) {
                editableParameter2.setValue(str2);
                editableParameter2.setError(null);
            }
        } else if (findParameter instanceof PhoneParameter) {
            EditableParameter editableParameter3 = (EditableParameter) findParameter;
            if (!Intrinsics.areEqual(editableParameter3.getValue(), str2)) {
                editableParameter3.setValue(str2);
                editableParameter3.setError(null);
            }
        }
    }

    @Override // com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter
    public void setParametersTree(@Nullable ParametersTree parametersTree) {
        this.a = parametersTree;
    }

    @Override // com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter
    @NotNull
    public List<Item> convert(@NotNull DeliverySummaryRds.ContactsGroup contactsGroup) {
        Intrinsics.checkNotNullParameter(contactsGroup, "contactsGroup");
        ArrayList arrayList = new ArrayList();
        List<ParameterSlot> formSections = contactsGroup.getFormSections();
        if (formSections != null) {
            SimpleParametersTree simpleParametersTree = new SimpleParametersTree(formSections, null, 2, null);
            setParametersTree(simpleParametersTree);
            arrayList.addAll(CategoryParametersElementConverter.convert$default(this.b, simpleParametersTree, null, null, 6, null));
        }
        arrayList.add(new ButtonItem(DeliveryRdsSummaryItemsConverterKt.SUBMIT_BUTTON_ID, this.c.getButtonTitle(), false, true, 4, null));
        return arrayList;
    }
}

package com.avito.android.safedeal.delivery_courier.summary.konveyor;

import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeliveryCourierLocationSelectLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.avito.android.remote.model.category_parameters.EmailParameter;
import com.avito.android.remote.model.category_parameters.FormatterType;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.SelectDeepLinkParameter;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasError;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.BaseCourierServiceItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.CourierServiceRadioButtonItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.CourierServicesRadioGroupItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service.SingleCourierServiceItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.divider.DividerItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.image.ImageItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.link.LinkItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.text.TextItem;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.conveyor_item.Item;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.n.e;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010,\u001a\u00020)¢\u0006\u0004\bB\u0010CJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ3\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010#\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0!H\u0002¢\u0006\u0004\b#\u0010$J!\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0006*\n\u0012\u0004\u0012\u00020%\u0018\u00010\u0006H\u0002¢\u0006\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R$\u00107\u001a\u0004\u0018\u0001018\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00108V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverterImpl;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverter;", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary;", ErrorBundle.SUMMARY_ENTRY, "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "deepLinkClickListener", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary;Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)Ljava/util/List;", "oldItems", "", "paramId", "newValue", "applyParameterValue", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "", "errorsMap", "applyErrors", "(Ljava/util/Map;Ljava/util/List;)Ljava/util/List;", "", "onParameterValueChanged", "(Ljava/lang/String;Ljava/lang/String;)V", "items", "", "getFirstErrorPosition", "(Ljava/util/List;)Ljava/lang/Integer;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;", "selectedCourierService", "updateCost", "(Ljava/util/List;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;)Ljava/util/List;", "value", "id", "", "map", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Cost;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/text/TextItem;", AuthSource.SEND_ABUSE, "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryKonveyorResourceProvider;", "e", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryKonveyorResourceProvider;", "resourceProvider", "Lcom/avito/android/util/text/AttributedTextFormatter;", "d", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParametersTree", "()Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "setParametersTree", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "parametersTree", "getParametersMap", "()Ljava/util/Map;", "parametersMap", "", "Ljava/util/Set;", "costItemsIDs", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "c", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "<init>", "(Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryKonveyorResourceProvider;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierSummaryItemsConverterImpl implements DeliveryCourierSummaryItemsConverter {
    public Set<String> a = y.emptySet();
    @Nullable
    public ParametersTree b;
    public final CategoryParametersElementConverter c;
    public final AttributedTextFormatter d;
    public final DeliveryCourierSummaryKonveyorResourceProvider e;

    @Inject
    public DeliveryCourierSummaryItemsConverterImpl(@NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull DeliveryCourierSummaryKonveyorResourceProvider deliveryCourierSummaryKonveyorResourceProvider) {
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryKonveyorResourceProvider, "resourceProvider");
        this.c = categoryParametersElementConverter;
        this.d = attributedTextFormatter;
        this.e = deliveryCourierSummaryKonveyorResourceProvider;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0053 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.text.SpannableString] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.avito.android.safedeal.delivery_courier.summary.konveyor.text.TextItem> a(java.util.List<com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary.Cost> r10) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x0067
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = t6.n.e.collectionSizeOrDefault(r10, r1)
            r0.<init>(r1)
            java.util.Iterator r10 = r10.iterator()
            r1 = 0
            r2 = 0
        L_0x0013:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x006b
            java.lang.Object r3 = r10.next()
            int r4 = r2 + 1
            if (r2 >= 0) goto L_0x0024
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x0024:
            com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary$Cost r3 = (com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary.Cost) r3
            java.lang.Boolean r5 = r3.getHighlightValue()
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L_0x004f
            android.text.SpannableString r5 = new android.text.SpannableString
            java.lang.String r6 = r3.getValue()
            r5.<init>(r6)
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r7 = 1
            r6.<init>(r7)
            java.lang.String r7 = r3.getValue()
            int r7 = r7.length()
            r8 = 33
            r5.setSpan(r6, r1, r7, r8)
            goto L_0x0053
        L_0x004f:
            java.lang.String r5 = r3.getValue()
        L_0x0053:
            com.avito.android.safedeal.delivery_courier.summary.konveyor.text.TextItem r6 = new com.avito.android.safedeal.delivery_courier.summary.konveyor.text.TextItem
            java.lang.String r7 = "costItem#"
            java.lang.String r2 = a2.b.a.a.a.M2(r7, r2)
            java.lang.String r3 = r3.getTitle()
            r6.<init>(r2, r3, r5)
            r0.add(r6)
            r2 = r4
            goto L_0x0013
        L_0x0067:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x006b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverterImpl.a(java.util.List):java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter
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
        List convert$default = CategoryParametersElementConverter.convert$default(this.c, parametersTree, null, null, 6, null);
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

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter
    @NotNull
    public List<Item> applyParameterValue(@NotNull List<? extends Item> list, @NotNull String str, @NotNull String str2) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "oldItems");
        Intrinsics.checkNotNullParameter(str, "paramId");
        Intrinsics.checkNotNullParameter(str2, "newValue");
        onParameterValueChanged(str, str2);
        ParametersTree parametersTree = getParametersTree();
        if (parametersTree == null) {
            return list;
        }
        List convert$default = CategoryParametersElementConverter.convert$default(this.c, parametersTree, null, null, 6, null);
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

    public final void b(String str, String str2, Map<String, String> map) {
        if (str != null) {
            map.put("params[" + str2 + ']', str);
        }
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter
    @NotNull
    public List<Item> convert(@NotNull DeliveryCourierSummary deliveryCourierSummary, @NotNull OnDeepLinkClickListener onDeepLinkClickListener) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        CharSequence formatIgnoreColors;
        T t;
        Intrinsics.checkNotNullParameter(deliveryCourierSummary, ErrorBundle.SUMMARY_ENTRY);
        Intrinsics.checkNotNullParameter(onDeepLinkClickListener, "deepLinkClickListener");
        ArrayList arrayList = new ArrayList();
        AttributedText motivation = deliveryCourierSummary.getAddress().getMotivation();
        Boolean bool = Boolean.FALSE;
        String value = deliveryCourierSummary.getAddress().getValue();
        String placeholder = deliveryCourierSummary.getAddress().getPlaceholder();
        String uri = new DeliveryCourierLocationSelectLink().getUri().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "DeliveryCourierLocationSelectLink().uri.toString()");
        arrayList.add(new SelectDeepLinkParameter(IntegrityManager.INTEGRITY_TYPE_ADDRESS, "", true, false, motivation, bool, value, placeholder, uri));
        arrayList.add(new CharParameter("addressDetails", "", false, false, deliveryCourierSummary.getComment().getMotivation(), bool, null, deliveryCourierSummary.getComment().getValue(), new DisplayingOptions(null, null, Boolean.TRUE, null, null, null, null, null, false, null, null, null, 3843, null), deliveryCourierSummary.getComment().getConstraints(), null, deliveryCourierSummary.getComment().getPlaceholder(), null, null, null, 28672, null));
        arrayList.add(new CharParameter("name", "", true, false, deliveryCourierSummary.getName().getMotivation(), bool, null, deliveryCourierSummary.getName().getValue(), null, deliveryCourierSummary.getName().getConstraints(), null, deliveryCourierSummary.getName().getPlaceholder(), null, null, null, 28672, null));
        arrayList.add(new PhoneParameter("phoneNumber", "", true, false, deliveryCourierSummary.getPhone().getMotivation(), bool, null, deliveryCourierSummary.getPhone().getValue(), new DisplayingOptions(null, null, null, "+7 ", null, 10, FormatterType.PHONE, null, false, null, null, null, 3843, null), deliveryCourierSummary.getPhone().getConstraints(), deliveryCourierSummary.getPhone().getPlaceholder()));
        arrayList.add(new EmailParameter("email", "", true, false, deliveryCourierSummary.getEmail().getMotivation(), bool, null, deliveryCourierSummary.getEmail().getValue(), deliveryCourierSummary.getEmail().getConstraints(), deliveryCourierSummary.getEmail().getPlaceholder()));
        List<DeliveryCourierSummary.Cost> list = null;
        SimpleParametersTree simpleParametersTree = new SimpleParametersTree(arrayList, null, 2, null);
        setParametersTree(simpleParametersTree);
        List convert$default = CategoryParametersElementConverter.convert$default(this.c, simpleParametersTree, null, null, 6, null);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new ImageItem(String.valueOf(arrayList2.size()), deliveryCourierSummary.getAdvertImage().getTitle(), deliveryCourierSummary.getAdvertImage().getImage()));
        DeliveryCourierSummary.CourierServices courierServices = deliveryCourierSummary.getCourierServices();
        if (courierServices == null) {
            obj = null;
        } else if (courierServices.getServices().size() == 1) {
            String groupTitle = courierServices.getGroupTitle();
            if (groupTitle != null) {
                arrayList2.add(new HeaderItem("courierServices", groupTitle, true));
            }
            DeliveryCourierSummary.CourierService courierService = (DeliveryCourierSummary.CourierService) CollectionsKt___CollectionsKt.first((List<? extends Object>) courierServices.getServices());
            obj = new SingleCourierServiceItem(courierService.getProviderKey(), courierService.getTitle(), courierService.getSubtitle(), courierService.getCost());
        } else {
            List<DeliveryCourierSummary.CourierService> services = courierServices.getServices();
            ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(services, 10));
            for (T t2 : services) {
                arrayList3.add(new CourierServiceRadioButtonItem(t2.getProviderKey(), t2.getTitle(), t2.getSubtitle(), t2.getCost(), t2.isChecked()));
            }
            obj = new CourierServicesRadioGroupItem("courierServices", courierServices.getGroupTitle(), courierServices.getGroupSubtitle(), courierServices.getGroupHint(), arrayList3);
        }
        if (obj != null) {
            arrayList2.add(obj);
        }
        arrayList2.add(new HeaderItem("addressTitle", this.e.getAddress(), true));
        Iterator it = convert$default.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.areEqual(((Item) obj2).getStringId(), IntegrityManager.INTEGRITY_TYPE_ADDRESS)) {
                break;
            }
        }
        Item item = (Item) obj2;
        if (item != null) {
            arrayList2.add(item);
        }
        Iterator it2 = convert$default.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it2.next();
            if (Intrinsics.areEqual(((Item) obj3).getStringId(), "addressDetails")) {
                break;
            }
        }
        Item item2 = (Item) obj3;
        if (item2 != null) {
            arrayList2.add(item2);
        }
        arrayList2.add(new ExtraItem("howWork", deliveryCourierSummary.getHowWork().getText(), deliveryCourierSummary.getHowWork().getText(), deliveryCourierSummary.getHowWork().getDescription()));
        arrayList2.add(new HeaderItem("contactHeader", this.e.getContact(), true));
        Iterator it3 = convert$default.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj4 = null;
                break;
            }
            obj4 = it3.next();
            if (Intrinsics.areEqual(((Item) obj4).getStringId(), "name")) {
                break;
            }
        }
        Item item3 = (Item) obj4;
        if (item3 != null) {
            arrayList2.add(item3);
        }
        Iterator it4 = convert$default.iterator();
        while (true) {
            if (!it4.hasNext()) {
                obj5 = null;
                break;
            }
            obj5 = it4.next();
            if (Intrinsics.areEqual(((Item) obj5).getStringId(), "phoneNumber")) {
                break;
            }
        }
        Item item4 = (Item) obj5;
        if (item4 != null) {
            arrayList2.add(item4);
        }
        Iterator it5 = convert$default.iterator();
        while (true) {
            if (!it5.hasNext()) {
                obj6 = null;
                break;
            }
            obj6 = it5.next();
            if (Intrinsics.areEqual(((Item) obj6).getStringId(), "email")) {
                break;
            }
        }
        Item item5 = (Item) obj6;
        if (item5 != null) {
            arrayList2.add(item5);
        }
        arrayList2.add(new HeaderItem("costHeader", this.e.getCost(), true));
        if (obj == null) {
            list = deliveryCourierSummary.getCost();
        } else if (obj instanceof SingleCourierServiceItem) {
            list = ((SingleCourierServiceItem) obj).getCost();
        } else if (obj instanceof CourierServicesRadioGroupItem) {
            Iterator<T> it6 = ((CourierServicesRadioGroupItem) obj).getRadioButtons().iterator();
            while (true) {
                if (!it6.hasNext()) {
                    t = null;
                    break;
                }
                t = it6.next();
                if (t.isChecked()) {
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                list = t3.getCost();
            }
        } else {
            throw new IllegalStateException("unsupported CourierServicesItem");
        }
        List<TextItem> a3 = a(list);
        arrayList2.addAll(a3);
        ArrayList arrayList4 = new ArrayList(e.collectionSizeOrDefault(a3, 10));
        Iterator<T> it7 = a3.iterator();
        while (it7.hasNext()) {
            arrayList4.add(it7.next().getStringId());
        }
        this.a = CollectionsKt___CollectionsKt.toSet(arrayList4);
        arrayList2.add(new DividerItem(String.valueOf(arrayList2.size())));
        AttributedText disclaimer = deliveryCourierSummary.getDisclaimer();
        if (!(disclaimer == null || (formatIgnoreColors = this.d.formatIgnoreColors(disclaimer)) == null)) {
            disclaimer.setOnDeepLinkClickListener(onDeepLinkClickListener);
            arrayList2.add(new LinkItem(String.valueOf(arrayList2.size()), formatIgnoreColors));
        }
        arrayList2.add(new ParameterElement.Button(String.valueOf(arrayList2.size()), this.e.getButtonTitle(), null, null, null, 28, null));
        return arrayList2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0041 A[EDGE_INSN: B:37:0x0041->B:20:0x0041 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x003d A[SYNTHETIC] */
    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Integer getFirstErrorPosition(@org.jetbrains.annotations.NotNull java.util.List<? extends com.avito.conveyor_item.Item> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "items"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.avito.android.remote.model.category_parameters.ParametersTree r0 = r7.getParametersTree()
            r1 = 0
            if (r0 == 0) goto L_0x0073
            java.util.Iterator r0 = r0.iterator()
        L_0x0010:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r0.next()
            r4 = r2
            com.avito.android.remote.model.category_parameters.base.ParameterSlot r4 = (com.avito.android.remote.model.category_parameters.base.ParameterSlot) r4
            boolean r5 = r4 instanceof com.avito.android.remote.model.category_parameters.base.HasError
            r6 = 1
            if (r5 == 0) goto L_0x003c
            com.avito.android.remote.model.category_parameters.base.HasError r4 = (com.avito.android.remote.model.category_parameters.base.HasError) r4
            java.lang.String r4 = r4.getError()
            if (r4 == 0) goto L_0x0038
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            if (r4 == 0) goto L_0x0038
            r4 = 1
            goto L_0x0039
        L_0x0038:
            r4 = 0
        L_0x0039:
            if (r4 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r6 = 0
        L_0x003d:
            if (r6 == 0) goto L_0x0010
            goto L_0x0041
        L_0x0040:
            r2 = r1
        L_0x0041:
            com.avito.android.remote.model.category_parameters.base.ParameterSlot r2 = (com.avito.android.remote.model.category_parameters.base.ParameterSlot) r2
            if (r2 == 0) goto L_0x0073
            java.lang.String r0 = r2.getId()
            if (r0 == 0) goto L_0x0073
            java.util.Iterator r8 = r8.iterator()
        L_0x004f:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x0073
            java.lang.Object r2 = r8.next()
            int r4 = r3 + 1
            if (r3 >= 0) goto L_0x0060
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x0060:
            com.avito.conveyor_item.Item r2 = (com.avito.conveyor_item.Item) r2
            java.lang.String r2 = r2.getStringId()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
            if (r2 == 0) goto L_0x0071
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            return r8
        L_0x0071:
            r3 = r4
            goto L_0x004f
        L_0x0073:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverterImpl.getFirstErrorPosition(java.util.List):java.lang.Integer");
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter
    @NotNull
    public Map<String, String> getParametersMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ParametersTree<ParameterSlot> parametersTree = getParametersTree();
        if (parametersTree != null) {
            for (ParameterSlot parameterSlot : parametersTree) {
                if (parameterSlot instanceof CharParameter) {
                    b((String) ((CharParameter) parameterSlot).getValue(), parameterSlot.getId(), linkedHashMap);
                } else if (parameterSlot instanceof PhoneParameter) {
                    b((String) ((PhoneParameter) parameterSlot).getValue(), parameterSlot.getId(), linkedHashMap);
                } else if (parameterSlot instanceof EmailParameter) {
                    b((String) ((EmailParameter) parameterSlot).getValue(), parameterSlot.getId(), linkedHashMap);
                } else if (parameterSlot instanceof SelectDeepLinkParameter) {
                    b((String) ((SelectDeepLinkParameter) parameterSlot).getValue(), parameterSlot.getId(), linkedHashMap);
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter
    @Nullable
    public ParametersTree getParametersTree() {
        return this.b;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter
    public void onParameterValueChanged(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "paramId");
        Intrinsics.checkNotNullParameter(str2, "newValue");
        ParametersTree parametersTree = getParametersTree();
        ParameterSlot findParameter = parametersTree != null ? parametersTree.findParameter(str) : null;
        if (findParameter == null) {
            return;
        }
        if (findParameter instanceof CharParameter) {
            EditableParameter editableParameter = (EditableParameter) findParameter;
            if (!Intrinsics.areEqual(editableParameter.getValue(), str2)) {
                editableParameter.setValue(str2);
                editableParameter.setError(null);
            }
        } else if (findParameter instanceof PhoneParameter) {
            EditableParameter editableParameter2 = (EditableParameter) findParameter;
            if (!Intrinsics.areEqual(editableParameter2.getValue(), str2)) {
                editableParameter2.setValue(str2);
                editableParameter2.setError(null);
            }
        } else if (findParameter instanceof EmailParameter) {
            EditableParameter editableParameter3 = (EditableParameter) findParameter;
            if (!Intrinsics.areEqual(editableParameter3.getValue(), str2)) {
                editableParameter3.setValue(str2);
                editableParameter3.setError(null);
            }
        } else if (findParameter instanceof SelectDeepLinkParameter) {
            EditableParameter editableParameter4 = (EditableParameter) findParameter;
            if (!Intrinsics.areEqual(editableParameter4.getValue(), str2)) {
                editableParameter4.setValue(str2);
                editableParameter4.setError(null);
            }
        }
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter
    public void setParametersTree(@Nullable ParametersTree parametersTree) {
        this.b = parametersTree;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter
    @NotNull
    public List<Item> updateCost(@NotNull List<? extends Item> list, @NotNull BaseCourierServiceItem baseCourierServiceItem) {
        Intrinsics.checkNotNullParameter(list, "oldItems");
        Intrinsics.checkNotNullParameter(baseCourierServiceItem, "selectedCourierService");
        List<TextItem> a3 = a(baseCourierServiceItem.getCost());
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(a3, 10));
        Iterator<T> it = a3.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getStringId());
        }
        Set mutableSet = CollectionsKt___CollectionsKt.toMutableSet(arrayList);
        Set mutableSet2 = CollectionsKt___CollectionsKt.toMutableSet(this.a);
        this.a = CollectionsKt___CollectionsKt.toSet(mutableSet);
        ArrayList arrayList2 = new ArrayList();
        Iterator<TextItem> it2 = a3.iterator();
        for (T t : list) {
            if (mutableSet2.contains(t.getStringId())) {
                mutableSet2.remove(t.getStringId());
                if (it2.hasNext()) {
                    TextItem next = it2.next();
                    arrayList2.add(next);
                    mutableSet.remove(next.getStringId());
                }
            } else if (!mutableSet2.isEmpty() || !(!mutableSet.isEmpty())) {
                arrayList2.add(t);
            } else {
                while (it2.hasNext()) {
                    TextItem next2 = it2.next();
                    arrayList2.add(next2);
                    mutableSet.remove(next2.getStringId());
                }
            }
        }
        return arrayList2;
    }
}

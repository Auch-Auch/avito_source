package com.avito.android.safedeal.delivery_courier.order_update.konveyor;

import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.SelectDeepLinkParameter;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasError;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderParams;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.text.TextItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItem;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b(\u0010)J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverterImpl;", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams;", "params", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams;)Ljava/util/List;", "oldItems", "", "", "errorsMap", "applyErrors", "(Ljava/util/List;Ljava/util/Map;)Ljava/util/List;", "paramId", "newValue", "applyParameterValue", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "selectedTimeInterval", "getSubmitParametersMap", "(Lcom/avito/android/remote/model/delivery_courier/TimeInterval;)Ljava/util/Map;", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "", "changeAction", AuthSource.SEND_ABUSE, "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "", "Ljava/util/List;", "getParametersTrees", "()Ljava/util/List;", "parametersTrees", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "getParametersMap", "()Ljava/util/Map;", "parametersMap", "<init>", "(Lcom/avito/android/category_parameters/CategoryParametersElementConverter;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierItemsConverterImpl implements DeliveryCourierItemsConverter {
    @NotNull
    public final List<ParametersTree> a = new ArrayList();
    public final CategoryParametersElementConverter b;

    public static final class a extends Lambda implements Function1<ParametersTree, Unit> {
        public final /* synthetic */ Map a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Map map) {
            super(1);
            this.a = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ParametersTree parametersTree) {
            ParametersTree<ParameterSlot> parametersTree2 = parametersTree;
            Intrinsics.checkNotNullParameter(parametersTree2, "it");
            for (ParameterSlot parameterSlot : parametersTree2) {
                if (parameterSlot instanceof HasError) {
                    ((HasError) parameterSlot).setError((String) this.a.get(parameterSlot.getId()));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<ParametersTree, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(1);
            this.a = str;
            this.b = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ParametersTree parametersTree) {
            ParametersTree parametersTree2 = parametersTree;
            Intrinsics.checkNotNullParameter(parametersTree2, "it");
            ParameterSlot findParameter = parametersTree2.findParameter(this.a);
            if (findParameter instanceof SelectDeepLinkParameter) {
                EditableParameter editableParameter = (EditableParameter) findParameter;
                String str = this.b;
                if (!Intrinsics.areEqual(editableParameter.getValue(), str)) {
                    editableParameter.setValue(str);
                    editableParameter.setError(null);
                }
            } else if (findParameter instanceof PhoneParameter) {
                EditableParameter editableParameter2 = (EditableParameter) findParameter;
                String str2 = this.b;
                if (!Intrinsics.areEqual(editableParameter2.getValue(), str2)) {
                    editableParameter2.setValue(str2);
                    editableParameter2.setError(null);
                }
            } else if (findParameter instanceof CharParameter) {
                EditableParameter editableParameter3 = (EditableParameter) findParameter;
                String str3 = this.b;
                if (!Intrinsics.areEqual(editableParameter3.getValue(), str3)) {
                    editableParameter3.setValue(str3);
                    editableParameter3.setError(null);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function2<String, String, Unit> {
        public final /* synthetic */ Map a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Map map) {
            super(2);
            this.a = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, String str2) {
            String str3 = str;
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str3, "id");
            Intrinsics.checkNotNullParameter(str4, "value");
            Map map = this.a;
            map.put("params[" + str3 + ']', str4);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<EditableParameter<String>, Unit> {
        public final /* synthetic */ Map a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Map map) {
            super(1);
            this.a = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(EditableParameter<String> editableParameter) {
            EditableParameter<String> editableParameter2 = editableParameter;
            Intrinsics.checkNotNullParameter(editableParameter2, "parameter");
            String value = editableParameter2.getValue();
            if (value != null) {
                this.a.put(editableParameter2.getId(), value);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public DeliveryCourierItemsConverterImpl(@NotNull CategoryParametersElementConverter categoryParametersElementConverter) {
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        this.b = categoryParametersElementConverter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.avito.conveyor_item.Item] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.avito.conveyor_item.Item> a(java.util.List<? extends com.avito.conveyor_item.Item> r10, kotlin.jvm.functions.Function1<? super com.avito.android.remote.model.category_parameters.ParametersTree, kotlin.Unit> r11) {
        /*
            r9 = this;
            java.util.List r0 = r9.getParametersTrees()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x000d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r0.next()
            r4 = r2
            com.avito.android.remote.model.category_parameters.ParametersTree r4 = (com.avito.android.remote.model.category_parameters.ParametersTree) r4
            java.lang.Object r2 = r11.invoke(r4)
            kotlin.Unit r2 = (kotlin.Unit) r2
            com.avito.android.category_parameters.CategoryParametersElementConverter r3 = r9.b
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            java.util.List r2 = com.avito.android.category_parameters.CategoryParametersElementConverter.convert$default(r3, r4, r5, r6, r7, r8)
            t6.n.h.addAll(r1, r2)
            goto L_0x000d
        L_0x002e:
            java.util.ArrayList r11 = new java.util.ArrayList
            r0 = 10
            int r0 = t6.n.e.collectionSizeOrDefault(r10, r0)
            r11.<init>(r0)
            java.util.Iterator r10 = r10.iterator()
        L_0x003d:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0073
            java.lang.Object r0 = r10.next()
            com.avito.conveyor_item.Item r0 = (com.avito.conveyor_item.Item) r0
            java.util.Iterator r2 = r1.iterator()
        L_0x004d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0069
            java.lang.Object r3 = r2.next()
            r4 = r3
            com.avito.conveyor_item.Item r4 = (com.avito.conveyor_item.Item) r4
            java.lang.String r4 = r4.getStringId()
            java.lang.String r5 = r0.getStringId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L_0x004d
            goto L_0x006a
        L_0x0069:
            r3 = 0
        L_0x006a:
            com.avito.conveyor_item.Item r3 = (com.avito.conveyor_item.Item) r3
            if (r3 == 0) goto L_0x006f
            r0 = r3
        L_0x006f:
            r11.add(r0)
            goto L_0x003d
        L_0x0073:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverterImpl.a(java.util.List, kotlin.jvm.functions.Function1):java.util.List");
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverter
    @NotNull
    public List<Item> applyErrors(@NotNull List<? extends Item> list, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(list, "oldItems");
        Intrinsics.checkNotNullParameter(map, "errorsMap");
        return a(list, new a(map));
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverter
    @NotNull
    public List<Item> applyParameterValue(@NotNull List<? extends Item> list, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(list, "oldItems");
        Intrinsics.checkNotNullParameter(str, "paramId");
        Intrinsics.checkNotNullParameter(str2, "newValue");
        return a(list, new b(str, str2));
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverter
    @NotNull
    public List<Item> convert(@NotNull DeliveryCourierOrderParams deliveryCourierOrderParams) {
        Intrinsics.checkNotNullParameter(deliveryCourierOrderParams, "params");
        ArrayList arrayList = new ArrayList();
        String subtitle = deliveryCourierOrderParams.getSubtitle();
        if (subtitle != null) {
            boolean z = false;
            if (subtitle.length() > 0) {
                z = true;
            }
            if (z) {
                arrayList.add(new TextItem(String.valueOf(arrayList.size()), subtitle));
            }
        }
        DeliveryCourierOrderParams.ArrivalTime arrivalTime = deliveryCourierOrderParams.getArrivalTime();
        if (arrivalTime != null) {
            arrayList.add(new HeaderItem(String.valueOf(arrayList.size()), arrivalTime.getDay(), true));
            arrayList.add(new TextItem(String.valueOf(arrayList.size()), arrivalTime.getTime()));
        }
        List<DeliveryCourierOrderParams.FormGroup> groups = deliveryCourierOrderParams.getGroups();
        if (groups != null) {
            Iterator<T> it = groups.iterator();
            while (it.hasNext()) {
                List<ParameterSlot> formSections = it.next().getFormSections();
                if (formSections != null) {
                    SimpleParametersTree simpleParametersTree = new SimpleParametersTree(formSections, null, 2, null);
                    getParametersTrees().add(simpleParametersTree);
                    arrayList.addAll(CategoryParametersElementConverter.convert$default(this.b, simpleParametersTree, null, null, 6, null));
                }
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverter
    @NotNull
    public Map<String, String> getParametersMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        d dVar = new d(linkedHashMap);
        for (ParameterSlot parameterSlot : e.flatten(getParametersTrees())) {
            if (parameterSlot instanceof CharParameter) {
                dVar.invoke(parameterSlot);
            } else if (parameterSlot instanceof SelectDeepLinkParameter) {
                dVar.invoke(parameterSlot);
            } else if (parameterSlot instanceof PhoneParameter) {
                dVar.invoke(parameterSlot);
            }
        }
        return linkedHashMap;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverter
    @NotNull
    public List<ParametersTree> getParametersTrees() {
        return this.a;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverter
    @NotNull
    public Map<String, String> getSubmitParametersMap(@Nullable TimeInterval timeInterval) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c cVar = new c(linkedHashMap);
        for (ParameterSlot parameterSlot : e.flatten(getParametersTrees())) {
            String str = "";
            if (parameterSlot instanceof CharParameter) {
                String id = parameterSlot.getId();
                String str2 = (String) ((CharParameter) parameterSlot).getValue();
                if (str2 != null) {
                    str = str2;
                }
                cVar.invoke(id, str);
            } else if (parameterSlot instanceof PhoneParameter) {
                String id2 = parameterSlot.getId();
                String str3 = (String) ((PhoneParameter) parameterSlot).getValue();
                if (str3 != null) {
                    str = str3;
                }
                cVar.invoke(id2, str);
            } else if (parameterSlot instanceof SelectDeepLinkParameter) {
                if (timeInterval == null || !Intrinsics.areEqual((String) ((SelectDeepLinkParameter) parameterSlot).getValue(), timeInterval.getTitle())) {
                    String id3 = parameterSlot.getId();
                    String str4 = (String) ((SelectDeepLinkParameter) parameterSlot).getValue();
                    if (str4 != null) {
                        str = str4;
                    }
                    cVar.invoke(id3, str);
                } else {
                    cVar.invoke(parameterSlot.getId() + "][startDate", timeInterval.getStartDate());
                    cVar.invoke(parameterSlot.getId() + "][endDate", timeInterval.getEndDate());
                }
            }
        }
        return linkedHashMap;
    }
}

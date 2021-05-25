package com.avito.android.str_calendar.seller.edit;

import a2.b.a.a.a;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.GroupParameter;
import com.avito.android.remote.model.category_parameters.IntParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PriceParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasError;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b1\u00102J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017RF\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\r2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\r8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u001eR:\u0010(\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0!0 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'R4\u0010+\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0!0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010*R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108V@\u0016X\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\u0013¨\u00063"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverterImpl;", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;", "", "Lcom/avito/android/remote/model/category_parameters/GroupParameter;", "formFields", "", "convert", "(Ljava/util/List;)V", "", "paramId", "newValue", "onParameterValueChanged", "(Ljava/lang/String;Ljava/lang/String;)V", "", "convertToMap", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "parametersTree", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "e", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "value", "d", "Ljava/util/Map;", "getErrorsMap", "setErrorsMap", "(Ljava/util/Map;)V", "errorsMap", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lcom/avito/conveyor_item/Item;", "", "", "Lio/reactivex/Observable;", "getItemsObservable", "()Lio/reactivex/Observable;", "itemsObservable", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/jakewharton/rxrelay2/Relay;", "itemsRelay", "c", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParametersTree", "()Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "setParametersTree", "<init>", "(Lcom/avito/android/category_parameters/CategoryParametersElementConverter;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarParametersConverterImpl implements SellerCalendarParametersConverter {
    public final Relay<Pair<List<Item>, Set<Integer>>> a;
    @NotNull
    public final Observable<Pair<List<Item>, Set<Integer>>> b;
    @Nullable
    public ParametersTree c;
    @NotNull
    public Map<String, String> d = r.emptyMap();
    public final CategoryParametersElementConverter e;

    @Inject
    public SellerCalendarParametersConverterImpl(@NotNull CategoryParametersElementConverter categoryParametersElementConverter) {
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        this.e = categoryParametersElementConverter;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        this.b = create;
    }

    public final void a(ParametersTree parametersTree) {
        if (parametersTree != null) {
            Iterator it = parametersTree.iterator();
            while (it.hasNext()) {
                ParameterSlot parameterSlot = (ParameterSlot) it.next();
                String str = getErrorsMap().get(parameterSlot.getId());
                if (str != null && (parameterSlot instanceof HasError)) {
                    ((HasError) parameterSlot).setError(str);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
        if ((((com.avito.android.category_parameters.ParameterElement.GroupMarker.Start) r4).getTitle().length() == 0) == false) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.avito.android.remote.model.category_parameters.ParametersTree r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x0082
            com.avito.android.category_parameters.CategoryParametersElementConverter r0 = r7.e
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r1 = r8
            java.util.List r8 = com.avito.android.category_parameters.CategoryParametersElementConverter.convert$default(r0, r1, r2, r3, r4, r5)
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            java.util.Iterator r1 = r8.iterator()
            r2 = 0
            r3 = 0
        L_0x0018:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x003f
            java.lang.Object r4 = r1.next()
            int r5 = r3 + 1
            if (r3 >= 0) goto L_0x0029
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x0029:
            com.avito.conveyor_item.Item r4 = (com.avito.conveyor_item.Item) r4
            boolean r4 = r4 instanceof com.avito.android.category_parameters.ParameterElement.GroupMarker.Start
            if (r4 == 0) goto L_0x003d
            int r4 = r0.size()
            int r4 = r4 * 2
            int r3 = r3 - r4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.add(r3)
        L_0x003d:
            r3 = r5
            goto L_0x0018
        L_0x003f:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0048:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0078
            java.lang.Object r3 = r8.next()
            r4 = r3
            com.avito.conveyor_item.Item r4 = (com.avito.conveyor_item.Item) r4
            boolean r5 = r4 instanceof com.avito.android.category_parameters.ParameterElement.GroupMarker.Start
            r6 = 1
            if (r5 == 0) goto L_0x006c
            r5 = r4
            com.avito.android.category_parameters.ParameterElement$GroupMarker$Start r5 = (com.avito.android.category_parameters.ParameterElement.GroupMarker.Start) r5
            java.lang.String r5 = r5.getTitle()
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0069
            r5 = 1
            goto L_0x006a
        L_0x0069:
            r5 = 0
        L_0x006a:
            if (r5 != 0) goto L_0x0072
        L_0x006c:
            boolean r4 = r4 instanceof com.avito.android.category_parameters.ParameterElement.GroupMarker.End
            if (r4 == 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r6 = 0
        L_0x0072:
            if (r6 != 0) goto L_0x0048
            r1.add(r3)
            goto L_0x0048
        L_0x0078:
            com.jakewharton.rxrelay2.Relay<kotlin.Pair<java.util.List<com.avito.conveyor_item.Item>, java.util.Set<java.lang.Integer>>> r8 = r7.a
            kotlin.Pair r2 = new kotlin.Pair
            r2.<init>(r1, r0)
            r8.accept(r2)
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverterImpl.b(com.avito.android.remote.model.category_parameters.ParametersTree):void");
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverter
    public void convert(@NotNull List<GroupParameter> list) {
        Intrinsics.checkNotNullParameter(list, "formFields");
        SimpleParametersTree simpleParametersTree = new SimpleParametersTree(list, null, 2, null);
        a(simpleParametersTree);
        setParametersTree(simpleParametersTree);
        b(getParametersTree());
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverter
    @NotNull
    public Map<String, String> convertToMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ParametersTree<ParameterSlot> parametersTree = getParametersTree();
        if (parametersTree != null) {
            for (ParameterSlot parameterSlot : parametersTree) {
                if (parameterSlot instanceof EditableParameter) {
                    if (parameterSlot instanceof PriceParameter) {
                        StringBuilder L = a.L("parameters[");
                        L.append(parameterSlot.getId());
                        L.append("]");
                        String sb = L.toString();
                        String valueOf = String.valueOf(((PriceParameter) parameterSlot).getValue());
                        StringBuilder sb2 = new StringBuilder();
                        int length = valueOf.length();
                        for (int i = 0; i < length; i++) {
                            char charAt = valueOf.charAt(i);
                            if (Character.isDigit(charAt)) {
                                sb2.append(charAt);
                            }
                        }
                        String sb3 = sb2.toString();
                        Intrinsics.checkNotNullExpressionValue(sb3, "filterTo(StringBuilder(), predicate).toString()");
                        linkedHashMap.put(sb, sb3);
                    } else {
                        StringBuilder L2 = a.L("parameters[");
                        L2.append(parameterSlot.getId());
                        L2.append("]");
                        linkedHashMap.put(L2.toString(), String.valueOf(((EditableParameter) parameterSlot).getValue()));
                    }
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverter
    @NotNull
    public Map<String, String> getErrorsMap() {
        return this.d;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverter
    @NotNull
    public Observable<Pair<List<Item>, Set<Integer>>> getItemsObservable() {
        return this.b;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverter
    @Nullable
    public ParametersTree getParametersTree() {
        Object obj;
        ParametersTree parametersTree = this.c;
        if (parametersTree == null) {
            return null;
        }
        Iterator it = parametersTree.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ParameterSlot) obj).getId(), "availability")) {
                break;
            }
        }
        if (!(obj instanceof SelectParameter)) {
            obj = null;
        }
        SelectParameter selectParameter = (SelectParameter) obj;
        if (!Intrinsics.areEqual(selectParameter != null ? (String) selectParameter.getValue() : null, "unavailable")) {
            return parametersTree;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : parametersTree) {
            if (Intrinsics.areEqual(((ParameterSlot) obj2).getId(), "availability")) {
                arrayList.add(obj2);
            }
        }
        return new SimpleParametersTree(arrayList, null, 2, null);
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverter
    public void onParameterValueChanged(@NotNull String str, @NotNull String str2) {
        long j;
        Intrinsics.checkNotNullParameter(str, "paramId");
        Intrinsics.checkNotNullParameter(str2, "newValue");
        ParametersTree parametersTree = getParametersTree();
        ParameterSlot findParameter = parametersTree != null ? parametersTree.findParameter(str) : null;
        if (findParameter == null) {
            return;
        }
        if (findParameter instanceof PriceParameter) {
            EditableParameter editableParameter = (EditableParameter) findParameter;
            if (!Intrinsics.areEqual(editableParameter.getValue(), str2)) {
                editableParameter.setValue(str2);
                editableParameter.setError(null);
            }
        } else if (findParameter instanceof IntParameter) {
            EditableParameter editableParameter2 = (EditableParameter) findParameter;
            if (str2.length() == 0) {
                j = 0L;
            } else {
                StringBuilder sb = new StringBuilder();
                int length = str2.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str2.charAt(i);
                    if (Character.isDigit(charAt)) {
                        sb.append(charAt);
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
                j = l.toLongOrNull(sb2);
            }
            if (!Intrinsics.areEqual(editableParameter2.getValue(), j)) {
                editableParameter2.setValue(j);
                editableParameter2.setError(null);
            }
        } else if (findParameter instanceof SelectParameter) {
            EditableParameter editableParameter3 = (EditableParameter) findParameter;
            if (true ^ Intrinsics.areEqual(editableParameter3.getValue(), str2)) {
                editableParameter3.setValue(str2);
                editableParameter3.setError(null);
            }
            if (Intrinsics.areEqual(findParameter.getId(), "availability")) {
                b(getParametersTree());
            }
        }
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverter
    public void setErrorsMap(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "value");
        this.d = map;
        a(getParametersTree());
        b(getParametersTree());
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverter
    public void setParametersTree(@Nullable ParametersTree parametersTree) {
        this.c = parametersTree;
    }
}

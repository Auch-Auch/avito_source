package com.avito.android.search.filter;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.DateSearchParam;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.Metro;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SplitSearchParamKt;
import com.avito.android.remote.model.StringSearchParam;
import com.avito.android.remote.model.category_parameters.BooleanParameter;
import com.avito.android.remote.model.category_parameters.DateRangeParameter;
import com.avito.android.remote.model.category_parameters.LocationParameter;
import com.avito.android.remote.model.category_parameters.MetroParameter;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PriceParameter;
import com.avito.android.remote.model.category_parameters.QuartersParameter;
import com.avito.android.remote.model.category_parameters.SearchRadiusParameter;
import com.avito.android.remote.model.category_parameters.SelectCategoryParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.util.UrlParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\f*\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/search/filter/ParametersTreeSearchParamsConverterImpl;", "Lcom/avito/android/search/filter/ParametersTreeSearchParamsConverter;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/SearchParams;", "convert", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lcom/avito/android/remote/model/SearchParams;", "", "", "Lcom/avito/android/remote/model/SearchParam;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "parameter", "", AuthSource.SEND_ABUSE, "(Ljava/util/Map;Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;)V", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersTreeSearchParamsConverterImpl implements ParametersTreeSearchParamsConverter {
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.Map<java.lang.String, com.avito.android.remote.model.SearchParam<?>> r5, com.avito.android.remote.model.category_parameters.base.EditableParameter<?> r6) {
        /*
            r4 = this;
            java.lang.String r0 = r6.getId()
            r1 = 91
            r2 = 0
            r3 = 2
            java.lang.String r0 = kotlin.text.StringsKt__StringsKt.substringAfter$default(r0, r1, r2, r3, r2)
            r1 = 93
            java.lang.String r0 = kotlin.text.StringsKt__StringsKt.substringBefore$default(r0, r1, r2, r3, r2)
            boolean r1 = r6 instanceof com.avito.android.remote.model.category_parameters.MultiselectParameter
            if (r1 == 0) goto L_0x002e
            com.avito.android.remote.model.category_parameters.MultiselectParameter r6 = (com.avito.android.remote.model.category_parameters.MultiselectParameter) r6
            java.lang.Object r6 = r6.getValue()
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x005d
            boolean r1 = r6.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x005d
            com.avito.android.remote.model.MultiSelectSearchParam r1 = new com.avito.android.remote.model.MultiSelectSearchParam
            r1.<init>(r6)
            goto L_0x005c
        L_0x002e:
            boolean r1 = r6 instanceof com.avito.android.remote.model.category_parameters.BooleanParameter
            if (r1 == 0) goto L_0x004d
            com.avito.android.remote.model.category_parameters.BooleanParameter r6 = (com.avito.android.remote.model.category_parameters.BooleanParameter) r6
            java.lang.Object r6 = r6.getValue()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            if (r6 == 0) goto L_0x005d
            boolean r6 = r6.booleanValue()
            com.avito.android.remote.model.StringSearchParam r2 = new com.avito.android.remote.model.StringSearchParam
            if (r6 == 0) goto L_0x0047
            java.lang.String r6 = "1"
            goto L_0x0049
        L_0x0047:
            java.lang.String r6 = "0"
        L_0x0049:
            r2.<init>(r6)
            goto L_0x005d
        L_0x004d:
            java.lang.Object r6 = r6.getValue()
            if (r6 == 0) goto L_0x005d
            com.avito.android.remote.model.StringSearchParam r1 = new com.avito.android.remote.model.StringSearchParam
            java.lang.String r6 = r6.toString()
            r1.<init>(r6)
        L_0x005c:
            r2 = r1
        L_0x005d:
            if (r2 == 0) goto L_0x0065
            java.lang.Object r5 = r5.put(r0, r2)
            com.avito.android.remote.model.SearchParam r5 = (com.avito.android.remote.model.SearchParam) r5
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.filter.ParametersTreeSearchParamsConverterImpl.a(java.util.Map, com.avito.android.remote.model.category_parameters.base.EditableParameter):void");
    }

    @Override // com.avito.android.search.filter.ParametersTreeSearchParamsConverter
    @NotNull
    public SearchParams convert(@NotNull ParametersTree parametersTree) {
        String id;
        Integer to;
        Integer from;
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        SearchParams searchParams = new SearchParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = parametersTree.iterator();
        while (it.hasNext()) {
            ParameterSlot parameterSlot = (ParameterSlot) it.next();
            if (parameterSlot instanceof EditableParameter) {
                EditableParameter<?> editableParameter = (EditableParameter) parameterSlot;
                if (editableParameter.hasValue()) {
                    String str = null;
                    ArrayList arrayList = null;
                    String str2 = null;
                    r7 = null;
                    Integer num = null;
                    Integer num2 = null;
                    Integer num3 = null;
                    Long l = null;
                    Long l2 = null;
                    String str3 = null;
                    if (parameterSlot instanceof SelectCategoryParameter) {
                        Category category = (Category) ((SelectCategoryParameter) parameterSlot).getValue();
                        if (category != null) {
                            str = category.getId();
                        }
                        searchParams.setCategoryId(str);
                    } else if (parameterSlot instanceof LocationParameter) {
                        Location location = (Location) ((LocationParameter) parameterSlot).getValue();
                        if (location != null) {
                            str3 = location.getId();
                        }
                        searchParams.setLocationId(str3);
                    } else if (parameterSlot instanceof PriceParameter) {
                        String id2 = parameterSlot.getId();
                        int hashCode = id2.hashCode();
                        if (hashCode != -1176958117) {
                            if (hashCode == -1176957879 && id2.equals(UrlParams.PRICE_MIN)) {
                                String str4 = (String) ((PriceParameter) parameterSlot).getValue();
                                if (str4 != null) {
                                    l2 = l.toLongOrNull(str4);
                                }
                                searchParams.setPriceMin(l2);
                            }
                        } else if (id2.equals(UrlParams.PRICE_MAX)) {
                            String str5 = (String) ((PriceParameter) parameterSlot).getValue();
                            if (str5 != null) {
                                l = l.toLongOrNull(str5);
                            }
                            searchParams.setPriceMax(l);
                        }
                    } else if (parameterSlot instanceof SelectParameter) {
                        String id3 = parameterSlot.getId();
                        switch (id3.hashCode()) {
                            case -1313322582:
                                if (id3.equals(ParameterId.CATEGORIES)) {
                                    break;
                                } else {
                                    a(linkedHashMap, (EditableParameter) parameterSlot);
                                    break;
                                }
                            case -938578798:
                                if (id3.equals("radius")) {
                                    String str6 = (String) ((SelectParameter) parameterSlot).getValue();
                                    if (str6 != null) {
                                        num3 = Integer.valueOf(Integer.parseInt(str6));
                                    }
                                    searchParams.setRadius(num3);
                                    break;
                                } else {
                                    a(linkedHashMap, (EditableParameter) parameterSlot);
                                    break;
                                }
                            case 3536286:
                                if (id3.equals("sort")) {
                                    searchParams.setSort((String) ((SelectParameter) parameterSlot).getValue());
                                    break;
                                } else {
                                    a(linkedHashMap, (EditableParameter) parameterSlot);
                                    break;
                                }
                            case 73719898:
                                if (id3.equals("searchRadius")) {
                                    String str7 = (String) ((SelectParameter) parameterSlot).getValue();
                                    if (str7 != null) {
                                        num2 = Integer.valueOf(Integer.parseInt(str7));
                                    }
                                    searchParams.setRadius(num2);
                                    break;
                                } else {
                                    a(linkedHashMap, (EditableParameter) parameterSlot);
                                    break;
                                }
                            case 1671764162:
                                if (id3.equals("display")) {
                                    searchParams.setDisplayType(SerpDisplayType.Companion.fromString((String) ((SelectParameter) parameterSlot).getValue()));
                                    break;
                                } else {
                                    a(linkedHashMap, (EditableParameter) parameterSlot);
                                    break;
                                }
                            case 1902960142:
                                if (id3.equals(ParameterId.SUBCATEGORIES)) {
                                    break;
                                } else {
                                    a(linkedHashMap, (EditableParameter) parameterSlot);
                                    break;
                                }
                            default:
                                a(linkedHashMap, (EditableParameter) parameterSlot);
                                break;
                        }
                    } else if (parameterSlot instanceof MultiselectParameter) {
                        String id4 = parameterSlot.getId();
                        int hashCode2 = id4.hashCode();
                        if (hashCode2 != -1631834886) {
                            if (hashCode2 != -1480945335) {
                                if (hashCode2 == 106164915 && id4.equals(UrlParams.OWNER)) {
                                    searchParams.setOwner((List) ((MultiselectParameter) parameterSlot).getValue());
                                }
                            } else if (id4.equals(UrlParams.DISTRICT_ID)) {
                                searchParams.setDistrictId((List) ((MultiselectParameter) parameterSlot).getValue());
                            }
                        } else if (id4.equals(UrlParams.DIRECTION_ID)) {
                            searchParams.setDirectionId((List) ((MultiselectParameter) parameterSlot).getValue());
                        }
                        a(linkedHashMap, (EditableParameter) parameterSlot);
                    } else if (parameterSlot instanceof BooleanParameter) {
                        String id5 = parameterSlot.getId();
                        int hashCode3 = id5.hashCode();
                        if (hashCode3 != -317069398) {
                            if (hashCode3 != 636854694) {
                                if (hashCode3 == 1691623983 && id5.equals(UrlParams.LOCAL_PRIORITY)) {
                                    searchParams.setLocalPriority((Boolean) ((BooleanParameter) parameterSlot).getValue());
                                }
                            } else if (id5.equals(UrlParams.WITH_DELIVERY_ONLY)) {
                                searchParams.setWithDeliveryOnly((Boolean) ((BooleanParameter) parameterSlot).getValue());
                            }
                        } else if (id5.equals(UrlParams.WITH_IMAGES_ONLY)) {
                            searchParams.setWithImagesOnly((Boolean) ((BooleanParameter) parameterSlot).getValue());
                        }
                        a(linkedHashMap, (EditableParameter) parameterSlot);
                    } else if (parameterSlot instanceof SearchRadiusParameter) {
                        SearchRadius searchRadius = (SearchRadius) ((SearchRadiusParameter) parameterSlot).getValue();
                        if (!(searchRadius == null || (id = searchRadius.getId()) == null)) {
                            num = Integer.valueOf(Integer.parseInt(id));
                        }
                        searchParams.setRadius(num);
                    } else if (parameterSlot instanceof DateRangeParameter) {
                        DateRangeParameter dateRangeParameter = (DateRangeParameter) parameterSlot;
                        DateRangeParameter.FormattedDateParameter checkIn = dateRangeParameter.getCheckIn();
                        String id6 = checkIn != null ? checkIn.getId() : null;
                        DateRangeParameter.FormattedDateParameter checkIn2 = dateRangeParameter.getCheckIn();
                        String str8 = checkIn2 != null ? (String) checkIn2.getValue() : null;
                        DateRangeParameter.FormattedDateParameter checkOut = dateRangeParameter.getCheckOut();
                        String id7 = checkOut != null ? checkOut.getId() : null;
                        DateRangeParameter.FormattedDateParameter checkOut2 = dateRangeParameter.getCheckOut();
                        if (checkOut2 != null) {
                            str2 = (String) checkOut2.getValue();
                        }
                        if (!(id6 == null || str8 == null || id7 == null || str2 == null)) {
                            linkedHashMap.put(id6, new DateSearchParam(str8));
                            linkedHashMap.put(id7, new DateSearchParam(str2));
                        }
                    } else if (parameterSlot instanceof QuartersParameter) {
                        String substringBefore$default = StringsKt__StringsKt.substringBefore$default(StringsKt__StringsKt.substringAfter$default(parameterSlot.getId(), '[', (String) null, 2, (Object) null), ']', (String) null, 2, (Object) null);
                        QuartersParameter quartersParameter = (QuartersParameter) parameterSlot;
                        QuartersParameter.Value value = (QuartersParameter.Value) quartersParameter.getValue();
                        if (!(value == null || (from = value.getFrom()) == null)) {
                            linkedHashMap.put(a.c3(substringBefore$default, SplitSearchParamKt.SPLIT_FROM), new StringSearchParam(String.valueOf(from.intValue())));
                        }
                        QuartersParameter.Value value2 = (QuartersParameter.Value) quartersParameter.getValue();
                        if (!(value2 == null || (to = value2.getTo()) == null)) {
                            linkedHashMap.put(a.c3(substringBefore$default, SplitSearchParamKt.SPLIT_TO), new StringSearchParam(String.valueOf(to.intValue())));
                        }
                    } else if (parameterSlot instanceof MetroParameter) {
                        List<Metro> list = (List) ((MetroParameter) parameterSlot).getValue();
                        if (list != null) {
                            arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                            for (Metro metro : list) {
                                arrayList.add(metro.getId());
                            }
                        }
                        searchParams.setMetroIds(arrayList);
                    } else {
                        a(linkedHashMap, editableParameter);
                    }
                }
            }
        }
        if (!linkedHashMap.isEmpty()) {
            searchParams.setParams(linkedHashMap);
        }
        return searchParams;
    }
}

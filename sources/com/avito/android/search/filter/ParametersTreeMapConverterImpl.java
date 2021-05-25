package com.avito.android.search.filter;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.Sublocation;
import com.avito.android.remote.model.category_parameters.BooleanParameter;
import com.avito.android.remote.model.category_parameters.DateRangeParameter;
import com.avito.android.remote.model.category_parameters.DirectionParameter;
import com.avito.android.remote.model.category_parameters.DistrictParameter;
import com.avito.android.remote.model.category_parameters.IntParameter;
import com.avito.android.remote.model.category_parameters.LocationParameter;
import com.avito.android.remote.model.category_parameters.MetroParameter;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.NumericParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PriceParameter;
import com.avito.android.remote.model.category_parameters.SearchRadiusParameter;
import com.avito.android.remote.model.category_parameters.SelectCategoryParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007JG\u0010\u000e\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u00052\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0012\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\n*\b\u0012\u0004\u0012\u00020\u00140\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/search/filter/ParametersTreeMapConverterImpl;", "Lcom/avito/android/search/filter/ParametersTreeMapConverter;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "tree", "", "", "convert", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Ljava/util/Map;", "", "key", "", ResidentialComplexModuleKt.VALUES, "oldValues", "", AuthSource.SEND_ABUSE, "(Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "value", "oldValue", AuthSource.BOOKING_ORDER, "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/remote/model/Sublocation;", "c", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersTreeMapConverterImpl implements ParametersTreeMapConverter {
    public final void a(Map<String, String> map, String str, List<String> list, List<String> list2) {
        int i = 0;
        if (list != null) {
            int i2 = 0;
            for (T t : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                map.put(str + '[' + i2 + ']', t);
                i2 = i3;
            }
        }
        if (list2 != null) {
            for (T t2 : list2) {
                int i4 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                map.put("changedValues[" + str + '[' + i + "]]", t2);
                i = i4;
            }
        }
    }

    public final void b(Map<String, String> map, String str, String str2, String str3) {
        if (str2 != null) {
            map.put(str, str2);
        }
        int hashCode = str.hashCode();
        if (hashCode == -1313322582 ? str.equals(ParameterId.CATEGORIES) : !(hashCode != 1902960142 || !str.equals(ParameterId.SUBCATEGORIES))) {
            if (str3 == null) {
                str3 = "0";
            }
            str = "categoryId";
        }
        if (str3 != null) {
            map.put("changedValues[" + str + ']', str3);
        }
    }

    public final List<String> c(List<? extends Sublocation> list) {
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next().getId());
        }
        return arrayList;
    }

    @Override // com.avito.android.search.filter.ParametersTreeMapConverter
    @NotNull
    public Map<String, String> convert(@NotNull ParametersTree parametersTree) {
        List<DateRangeParameter.FormattedDateParameter> list;
        Intrinsics.checkNotNullParameter(parametersTree, "tree");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = parametersTree.iterator();
        while (it.hasNext()) {
            ParameterSlot parameterSlot = (ParameterSlot) it.next();
            if (parameterSlot instanceof EditableParameter) {
                String id = parameterSlot.getId();
                String str = null;
                String str2 = null;
                String str3 = null;
                List<String> list2 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                List<String> list3 = null;
                List<String> list4 = null;
                String str7 = null;
                if (((EditableParameter) parameterSlot).hasValue()) {
                    String str8 = "";
                    if (parameterSlot instanceof SelectParameter) {
                        SelectParameter selectParameter = (SelectParameter) parameterSlot;
                        String str9 = (String) selectParameter.getValue();
                        if (str9 != null) {
                            str8 = str9;
                        }
                        b(linkedHashMap, id, str8, (String) selectParameter.getOldValue());
                    } else if (parameterSlot instanceof PriceParameter) {
                        PriceParameter priceParameter = (PriceParameter) parameterSlot;
                        String str10 = (String) priceParameter.getValue();
                        if (str10 != null) {
                            str8 = str10;
                        }
                        b(linkedHashMap, id, str8, (String) priceParameter.getOldValue());
                    } else if (parameterSlot instanceof LocationParameter) {
                        LocationParameter locationParameter = (LocationParameter) parameterSlot;
                        Location location = (Location) locationParameter.getValue();
                        String id2 = location != null ? location.getId() : null;
                        if (id2 != null) {
                            str8 = id2;
                        }
                        Location location2 = (Location) locationParameter.getOldValue();
                        if (location2 != null) {
                            str = location2.getId();
                        }
                        b(linkedHashMap, id, str8, str);
                    } else if (parameterSlot instanceof SearchRadiusParameter) {
                        SearchRadiusParameter searchRadiusParameter = (SearchRadiusParameter) parameterSlot;
                        SearchRadius searchRadius = (SearchRadius) searchRadiusParameter.getValue();
                        String id3 = searchRadius != null ? searchRadius.getId() : null;
                        if (id3 != null) {
                            str8 = id3;
                        }
                        SearchRadius searchRadius2 = (SearchRadius) searchRadiusParameter.getOldValue();
                        if (searchRadius2 != null) {
                            str7 = searchRadius2.getId();
                        }
                        b(linkedHashMap, id, str8, str7);
                    } else if (parameterSlot instanceof DirectionParameter) {
                        DirectionParameter directionParameter = (DirectionParameter) parameterSlot;
                        List<? extends Sublocation> list5 = (List) directionParameter.getValue();
                        List<String> c = list5 != null ? c(list5) : null;
                        List<? extends Sublocation> list6 = (List) directionParameter.getOldValue();
                        if (list6 != null) {
                            list4 = c(list6);
                        }
                        a(linkedHashMap, id, c, list4);
                    } else if (parameterSlot instanceof DistrictParameter) {
                        DistrictParameter districtParameter = (DistrictParameter) parameterSlot;
                        List<? extends Sublocation> list7 = (List) districtParameter.getValue();
                        List<String> c2 = list7 != null ? c(list7) : null;
                        List<? extends Sublocation> list8 = (List) districtParameter.getOldValue();
                        if (list8 != null) {
                            list3 = c(list8);
                        }
                        a(linkedHashMap, id, c2, list3);
                    } else if (parameterSlot instanceof NumericParameter) {
                        NumericParameter numericParameter = (NumericParameter) parameterSlot;
                        Double d = (Double) numericParameter.getValue();
                        String valueOf = d != null ? String.valueOf(d.doubleValue()) : null;
                        if (valueOf != null) {
                            str8 = valueOf;
                        }
                        Double d2 = (Double) numericParameter.getOldValue();
                        if (d2 != null) {
                            str6 = String.valueOf(d2.doubleValue());
                        }
                        b(linkedHashMap, id, str8, str6);
                    } else if (parameterSlot instanceof SelectCategoryParameter) {
                        SelectCategoryParameter selectCategoryParameter = (SelectCategoryParameter) parameterSlot;
                        Category category = (Category) selectCategoryParameter.getValue();
                        String id4 = category != null ? category.getId() : null;
                        if (id4 != null) {
                            str8 = id4;
                        }
                        Category category2 = (Category) selectCategoryParameter.getOldValue();
                        if (category2 != null) {
                            str5 = category2.getId();
                        }
                        b(linkedHashMap, id, str8, str5);
                    } else if (parameterSlot instanceof IntParameter) {
                        IntParameter intParameter = (IntParameter) parameterSlot;
                        Long l = (Long) intParameter.getValue();
                        String valueOf2 = l != null ? String.valueOf(l.longValue()) : null;
                        if (valueOf2 != null) {
                            str8 = valueOf2;
                        }
                        Long l2 = (Long) intParameter.getOldValue();
                        if (l2 != null) {
                            str4 = String.valueOf(l2.longValue());
                        }
                        b(linkedHashMap, id, str8, str4);
                    } else if (parameterSlot instanceof MultiselectParameter) {
                        MultiselectParameter multiselectParameter = (MultiselectParameter) parameterSlot;
                        a(linkedHashMap, id, (List) multiselectParameter.getValue(), (List) multiselectParameter.getOldValue());
                    } else if (parameterSlot instanceof MetroParameter) {
                        MetroParameter metroParameter = (MetroParameter) parameterSlot;
                        List<? extends Sublocation> list9 = (List) metroParameter.getValue();
                        List<String> c3 = list9 != null ? c(list9) : null;
                        List<? extends Sublocation> list10 = (List) metroParameter.getOldValue();
                        if (list10 != null) {
                            list2 = c(list10);
                        }
                        a(linkedHashMap, id, c3, list2);
                    } else if (parameterSlot instanceof BooleanParameter) {
                        BooleanParameter booleanParameter = (BooleanParameter) parameterSlot;
                        Boolean bool = (Boolean) booleanParameter.getValue();
                        String str11 = bool != null ? bool.booleanValue() : false ? "1" : "0";
                        Boolean bool2 = (Boolean) booleanParameter.getOldValue();
                        if (bool2 != null) {
                            str3 = bool2.booleanValue() ? "1" : "0";
                        }
                        b(linkedHashMap, id, str11, str3);
                    } else if ((parameterSlot instanceof DateRangeParameter) && (list = (List) ((DateRangeParameter) parameterSlot).getValue()) != null) {
                        for (DateRangeParameter.FormattedDateParameter formattedDateParameter : list) {
                            String id5 = formattedDateParameter.getId();
                            String str12 = (String) formattedDateParameter.getValue();
                            if (str12 == null) {
                                str12 = str8;
                            }
                            b(linkedHashMap, id5, str12, (String) formattedDateParameter.getOldValue());
                        }
                    }
                } else if (parameterSlot instanceof SearchRadiusParameter) {
                    SearchRadiusParameter searchRadiusParameter2 = (SearchRadiusParameter) parameterSlot;
                    SearchRadius searchRadius3 = (SearchRadius) searchRadiusParameter2.getValue();
                    String id6 = searchRadius3 != null ? searchRadius3.getId() : null;
                    SearchRadius searchRadius4 = (SearchRadius) searchRadiusParameter2.getOldValue();
                    if (searchRadius4 != null) {
                        str2 = searchRadius4.getId();
                    }
                    b(linkedHashMap, id, id6, str2);
                }
            }
        }
        return linkedHashMap;
    }
}

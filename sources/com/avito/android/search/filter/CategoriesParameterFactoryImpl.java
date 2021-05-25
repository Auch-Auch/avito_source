package com.avito.android.search.filter;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJC\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/search/filter/CategoriesParameterFactoryImpl;", "Lcom/avito/android/search/filter/CategoriesParameterFactory;", "", "Lcom/avito/android/remote/model/Category;", "categories", "selectedCategory", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "create", "(Ljava/util/List;Lcom/avito/android/remote/model/Category;)Ljava/util/List;", "", "id", "title", "value", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", ResidentialComplexModuleKt.VALUES, "", "updatesForm", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;", "Lcom/avito/android/search/filter/FiltersResourceProvider;", "Lcom/avito/android/search/filter/FiltersResourceProvider;", "titleProvider", "<init>", "(Lcom/avito/android/search/filter/FiltersResourceProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesParameterFactoryImpl implements CategoriesParameterFactory {
    public final FiltersResourceProvider a;

    @Inject
    public CategoriesParameterFactoryImpl(@NotNull FiltersResourceProvider filtersResourceProvider) {
        Intrinsics.checkNotNullParameter(filtersResourceProvider, "titleProvider");
        this.a = filtersResourceProvider;
    }

    public final SelectParameter.Flat a(String str, String str2, String str3, List<SelectParameter.Value> list, boolean z) {
        return new SelectParameter.Flat(str, str2, false, false, null, Boolean.valueOf(z), str3, null, list, new SelectParameter.Displaying("dialog", null, false, null, null, null, 62, null), null, null, 3200, null);
    }

    @Override // com.avito.android.search.filter.CategoriesParameterFactory
    @NotNull
    public List<CategoryParameter> create(@NotNull List<Category> list, @Nullable Category category) {
        String str;
        String str2;
        T t;
        boolean z;
        T t2;
        Intrinsics.checkNotNullParameter(list, "categories");
        String id = category != null ? category.getId() : null;
        if (id != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (Intrinsics.areEqual(t2.getId(), id)) {
                    break;
                }
            }
            T t3 = t2;
            str = t3 != null ? t3.isRoot() ? t3.getId() : t3.getParentId() : null;
        } else {
            str = null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t4 : list) {
            if (t4.isRoot()) {
                arrayList.add(t4);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Category category2 = (Category) it2.next();
            String id2 = category2.getId();
            if (id != null) {
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it3.next();
                    T t5 = t;
                    if (!Intrinsics.areEqual(t5.getId(), id) || !Intrinsics.areEqual(t5.getParentId(), id2)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                T t7 = t;
                str2 = t7 != null ? t7.getId() : null;
            } else {
                str2 = null;
            }
            ArrayList arrayList3 = new ArrayList();
            for (T t8 : list) {
                if (Intrinsics.areEqual(t8.getParentId(), id2)) {
                    arrayList3.add(t8);
                }
            }
            ArrayList arrayList4 = new ArrayList(e.collectionSizeOrDefault(arrayList3, 10));
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                Category category3 = (Category) it4.next();
                arrayList4.add(new SelectParameter.Value(category3.getId(), category3.getName(), null, null));
            }
            arrayList2.add(new SelectParameter.Value(category2.getId(), category2.getName(), CollectionsKt___CollectionsKt.filterNotNull(d.listOf(arrayList4.isEmpty() ? null : a(ParameterId.SUBCATEGORIES, this.a.getSubcategoriesTitle(), str2, arrayList4, true))), null));
        }
        return d.listOf(a(ParameterId.CATEGORIES, this.a.getCategoriesTitle(), str, arrayList2, true));
    }
}

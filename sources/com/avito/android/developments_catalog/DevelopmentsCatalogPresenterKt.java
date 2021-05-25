package com.avito.android.developments_catalog;

import com.avito.android.developments_catalog.remote.model.DevelopmentsAdviceView;
import com.avito.android.developments_catalog.remote.model.DevelopmentsCatalogResponse;
import com.avito.android.developments_catalog.remote.model.MetroParam;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.remote.model.FormCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"developments-catalog_release"}, k = 2, mv = {1, 4, 2})
public final class DevelopmentsCatalogPresenterKt {
    public static final List access$mapMetroIds(DevelopmentsCatalogResponse developmentsCatalogResponse) {
        List<MetroParam> metro = developmentsCatalogResponse.getMetro();
        if (metro == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(metro, 10));
        Iterator<T> it = metro.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().getId()));
        }
        return arrayList;
    }

    public static final ConsultationFormData access$toConsultationFormData(DevelopmentsAdviceView developmentsAdviceView) {
        return new ConsultationFormData(developmentsAdviceView.getTitle(), developmentsAdviceView.getDescription(), null, null, null, null, developmentsAdviceView.getButtonTitle(), null, FormCategory.NewBuildings, 188, null);
    }
}

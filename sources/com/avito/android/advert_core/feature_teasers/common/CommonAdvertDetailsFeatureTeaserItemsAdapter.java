package com.avito.android.advert_core.feature_teasers.common;

import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItem;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogInfo;
import com.avito.android.remote.model.feature_teaser.ApartmentFeature;
import com.avito.android.remote.model.feature_teaser.CheckedByAvito;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0015\u0010\u0016JR\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/CommonAdvertDetailsFeatureTeaserItemsAdapter;", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItemsAdapter;", "", "Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature;", "apartmentFeatures", "", "span", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "teaserIndex", "", "idGenerator", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "createItems", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;)Ljava/util/List;", "Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito;", "checkedByAvito", "itemId", "createItem", "(Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito;IJ)Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class CommonAdvertDetailsFeatureTeaserItemsAdapter implements AdvertDetailsFeatureTeaserItemsAdapter {
    @Override // com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItemsAdapter
    @Nullable
    public AdvertDetailsFeatureTeaserItem createItem(@Nullable CheckedByAvito checkedByAvito, int i, long j) {
        if (checkedByAvito == null) {
            return null;
        }
        List<String> checks = checkedByAvito.getActionInfo().getChecks();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(checks, 10));
        Iterator<T> it = checks.iterator();
        while (it.hasNext()) {
            arrayList.add(AdvertDetailsFeatureTeaserOptionKt.okOption(it.next()));
        }
        String title = checkedByAvito.getActionInfo().getTitle();
        AdvertDetailsFeatureTeaserItem.Icon icon = AdvertDetailsFeatureTeaserItem.Icon.Protected;
        return new AdvertDetailsFeatureTeaserItem(j, i, "CheckedByAvito", null, null, new AdvertDetailsFeatureTeaserOption(checkedByAvito.getTitle(), icon), new AdvertDetailsFeatureTeaserDialogInfo.CheckedByAvito(new AdvertDetailsFeatureTeaserOption(title, icon), checkedByAvito.getActionInfo().getSubtitle(), arrayList, checkedByAvito.getActionInfo().getApplyBtnText()), checkedByAvito.getSubtitle(), arrayList, checkedByAvito.getActionText(), null, null, 3096, null);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItemsAdapter
    @Nullable
    public List<AdvertDetailsFeatureTeaserItem> createItems(@Nullable List<ApartmentFeature> list, int i, @NotNull Function1<? super Integer, Long> function1) {
        AdvertDetailsFeatureTeaserDialogInfo.FeaturesList featuresList;
        Intrinsics.checkNotNullParameter(function1, "idGenerator");
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            ApartmentFeature.ActionInfo actionInfo = t2.getActionInfo();
            if (actionInfo != null) {
                String title = actionInfo.getTitle();
                List<ApartmentFeature.FeatureBloc> blocs = actionInfo.getBlocs();
                LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(e.collectionSizeOrDefault(blocs, 10)), 16));
                for (T t3 : blocs) {
                    Pair pair = TuplesKt.to(t3.getTitle(), t3.getItems());
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                featuresList = new AdvertDetailsFeatureTeaserDialogInfo.FeaturesList(title, linkedHashMap);
            } else {
                featuresList = null;
            }
            long longValue = function1.invoke(Integer.valueOf(i2)).longValue();
            String slug = t2.getSlug();
            AdvertDetailsFeatureTeaserOption option = AdvertDetailsFeatureTeaserOptionKt.option(t2.getTitle());
            String str = t2.getSlug() + '_' + i2;
            String actionText = t2.getActionText();
            List<String> previewOptions = t2.getPreviewOptions();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(previewOptions, 10));
            Iterator<T> it = previewOptions.iterator();
            while (it.hasNext()) {
                arrayList2.add(AdvertDetailsFeatureTeaserOptionKt.option(it.next()));
            }
            arrayList.add(new AdvertDetailsFeatureTeaserItem(longValue, i, str, null, null, option, featuresList, null, arrayList2, actionText, slug, null, 2200, null));
            i2 = i3;
        }
        return arrayList;
    }
}

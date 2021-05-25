package com.avito.android.advert_core.feature_teasers.common.dialog;

import com.avito.android.IdProvider;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import com.avito.android.advert_core.feature_teasers.common.di.AdvertDetailsFeatureTeaser;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogInfo;
import com.avito.android.advert_core.gap.AdvertDetailsGapItem;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogItemsAdapter;", "", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo$FeaturesList;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeaturesList;", "dialogInfo", "", "Lcom/avito/conveyor_item/Item;", "createFeatureListItems", "(Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo$FeaturesList;)Ljava/util/List;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo$CheckedByAvito;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/CheckedByAvito;", "createCheckedByAvitoItems", "(Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo$CheckedByAvito;)Ljava/util/List;", "", "", "gap", "", AuthSource.SEND_ABUSE, "(Ljava/util/List;I)V", "Lcom/avito/android/IdProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/IdProvider;", "idProvider", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;Lcom/avito/android/IdProvider;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFeatureTeaserDialogItemsAdapter {
    public final FeatureTeaserResourceProvider a;
    public final IdProvider b;

    @Inject
    public AdvertDetailsFeatureTeaserDialogItemsAdapter(@NotNull FeatureTeaserResourceProvider featureTeaserResourceProvider, @AdvertDetailsFeatureTeaser @NotNull IdProvider idProvider) {
        Intrinsics.checkNotNullParameter(featureTeaserResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        this.a = featureTeaserResourceProvider;
        this.b = idProvider;
    }

    public final void a(List<Item> list, int i) {
        list.add(new AdvertDetailsGapItem(this.b.generateId(), null, i, 0, null, null, 50, null));
    }

    @NotNull
    public final List<Item> createCheckedByAvitoItems(@NotNull AdvertDetailsFeatureTeaserDialogInfo.CheckedByAvito checkedByAvito) {
        Intrinsics.checkNotNullParameter(checkedByAvito, "dialogInfo");
        ArrayList arrayList = new ArrayList();
        a(arrayList, 10);
        arrayList.add(new AdvertDetailsFeatureTeaserDialogTextItem(this.b.generateId(), checkedByAvito.getTitle().getName(), null, R.style.TextAppearance_Avito_Heading_Large, null, checkedByAvito.getTitle().getIcon(), null, null, com.avito.android.advert_core.R.dimen.advert_details_feature_teaser_icon_padding, 212, null));
        a(arrayList, 10);
        arrayList.add(new AdvertDetailsFeatureTeaserDialogTextItem(this.b.generateId(), checkedByAvito.getSubtitle(), null, R.style.TextAppearance_Avito_Body, null, null, null, null, 0, 500, null));
        a(arrayList, 10);
        int i = 0;
        for (T t : checkedByAvito.getOptions()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (i > 0) {
                a(arrayList, 8);
            }
            arrayList.add(new AdvertDetailsFeatureTeaserDialogTextItem(this.b.generateId(), t2.getName(), null, R.style.TextAppearance_Avito_Body, null, null, t2.getIcon(), Integer.valueOf(com.avito.android.advert_core.R.dimen.advert_details_checked_by_avito_option_left_padding), com.avito.android.advert_core.R.dimen.advert_details_feature_teaser_option_icon_padding, 52, null));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public final List<Item> createFeatureListItems(@NotNull AdvertDetailsFeatureTeaserDialogInfo.FeaturesList featuresList) {
        Intrinsics.checkNotNullParameter(featuresList, "dialogInfo");
        ArrayList arrayList = new ArrayList();
        a(arrayList, this.a.isTablet() ? 12 : 20);
        arrayList.add(new AdvertDetailsFeatureTeaserDialogTextItem(this.b.generateId(), featuresList.getTitle(), null, R.style.TextAppearance_Avito_Heading_Large, null, null, null, null, 0, 500, null));
        boolean z = true;
        for (Map.Entry<String, List<String>> entry : featuresList.getBlocks().entrySet()) {
            if (!this.a.isTablet() || !z) {
                a(arrayList, 24);
            } else {
                z = false;
                a(arrayList, 8);
            }
            arrayList.add(new AdvertDetailsFeatureTeaserDialogTextItem(this.b.generateId(), entry.getKey(), null, R.style.TextAppearance_Avito_Heading_Small, null, null, null, null, 0, 500, null));
            for (String str : entry.getValue()) {
                a(arrayList, 10);
                arrayList.add(new AdvertDetailsFeatureTeaserDialogTextItem(this.b.generateId(), str, null, R.style.TextAppearance_Avito_Body, null, null, null, null, 0, 500, null));
            }
        }
        if (!featuresList.getBlocks().isEmpty()) {
            a(arrayList, 24);
        }
        return arrayList;
    }
}

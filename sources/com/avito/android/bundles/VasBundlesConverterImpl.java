package com.avito.android.bundles;

import com.avito.android.bundles.ui.recycler.item.benefit.BundleBenefitItem;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItem;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItem;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.BundleBenefit;
import com.avito.android.remote.model.BundleDiscount;
import com.avito.android.remote.model.UniversalImage;
import com.avito.android.remote.model.VasBundle;
import com.avito.android.remote.model.VasBundlesResult;
import com.avito.konveyor.blueprint.Item;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/bundles/VasBundlesConverterImpl;", "Lcom/avito/android/bundles/VasBundlesConverter;", "Lcom/avito/android/remote/model/VasBundlesResult;", "bundlesResult", "", "Lcom/avito/konveyor/blueprint/Item;", "convert", "(Lcom/avito/android/remote/model/VasBundlesResult;)Ljava/util/List;", "<init>", "()V", "Companion", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasBundlesConverterImpl implements VasBundlesConverter {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/bundles/VasBundlesConverterImpl$Companion;", "", "", "ID_EMPTY_ACTION", "Ljava/lang/String;", "ID_TITLE", "<init>", "()V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.bundles.VasBundlesConverter
    @NotNull
    public List<Item> convert(@NotNull VasBundlesResult vasBundlesResult) {
        Intrinsics.checkNotNullParameter(vasBundlesResult, "bundlesResult");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PaidServiceHeaderItem("vas_bundle_id_title", vasBundlesResult.getTitle(), vasBundlesResult.getDescription()));
        List<VasBundle> list = vasBundlesResult.getList();
        int i = 10;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            String id = t.getId();
            UniversalImage image = t.getImage();
            BundleDiscount discount = t.getDiscount();
            String title = t.getTitle();
            List<BundleBenefit> benefits = t.getBenefits();
            ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(benefits, i));
            for (T t2 : benefits) {
                arrayList3.add(new BundleBenefitItem(t2.getText(), t2.getIcon(), t2.getText(), t2.getBadge(), t2.getDeepLink()));
            }
            arrayList2.add(new VasBundleItem(id, image, discount, title, arrayList3, t.getPrice(), t.getOldPrice(), t.getPriceHint(), t.getAction().getTitle(), t.getAction().getDeepLink()));
            i = 10;
        }
        arrayList.addAll(arrayList2);
        Action emptyAction = vasBundlesResult.getEmptyAction();
        BundleSkipButtonItem bundleSkipButtonItem = emptyAction != null ? new BundleSkipButtonItem("vas_bundle_empty_action", emptyAction) : null;
        if (bundleSkipButtonItem != null) {
            arrayList.add(bundleSkipButtonItem);
        }
        return arrayList;
    }
}

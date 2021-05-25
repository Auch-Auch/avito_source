package com.avito.android.vas_performance;

import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitleItem;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.vas.applied.AppliedService;
import com.avito.android.remote.model.vas.applied.AppliedVasResult;
import com.avito.android.remote.model.vas.applied.VasBundleBanner;
import com.avito.android.vas_performance.ui.items.applied_services.AppliedServiceItem;
import com.avito.android.vas_performance.ui.items.banner.VasBundleBannerItem;
import com.avito.android.vas_performance.ui.items.button.ButtonItem;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/vas_performance/AppliedServiceConverterImpl;", "Lcom/avito/android/vas_performance/AppliedServicesConverter;", "Lcom/avito/android/remote/model/vas/applied/AppliedVasResult;", "appliedServiceResult", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/vas/applied/AppliedVasResult;)Ljava/util/List;", "<init>", "()V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class AppliedServiceConverterImpl implements AppliedServicesConverter {
    @Override // com.avito.android.vas_performance.AppliedServicesConverter
    @NotNull
    public List<Item> convert(@NotNull AppliedVasResult appliedVasResult) {
        Intrinsics.checkNotNullParameter(appliedVasResult, "appliedServiceResult");
        List<Item> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TitleItem("applied_services_item", appliedVasResult.getTitle()));
        VasBundleBanner banner = appliedVasResult.getBanner();
        if (banner != null) {
            mutableListOf.add(new VasBundleBannerItem("applied_services_banner", banner.getText(), banner.getImage(), banner.getBackgroundColor()));
        }
        List<AppliedService> services = appliedVasResult.getServices();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(services, 10));
        for (T t : services) {
            arrayList.add(new AppliedServiceItem(t.getId(), t.getTitle(), t.getDescription(), t.getIcon()));
        }
        h.addAll(mutableListOf, arrayList);
        Action action = appliedVasResult.getAction();
        if (action != null) {
            mutableListOf.add(new ButtonItem("applied_services_button", action.getTitle(), action.getDeepLink()));
        }
        return mutableListOf;
    }
}

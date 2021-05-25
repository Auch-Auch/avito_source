package com.avito.android.advert.item.marketplace_specs;

import android.content.Context;
import android.view.View;
import com.avito.android.advert.item.AdvertDetailsViewKt;
import com.avito.android.advert_core.specifications.SpecificationData;
import com.avito.android.advert_core.specifications.SpecificationView;
import com.avito.android.advert_core.specifications.SpecificationsConverter;
import com.avito.android.advert_core.specifications.SpecificationsConverterImpl;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.serp.adapter.SimpleNarrowLayoutTypeProviderImpl;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsDialog;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "Lcom/avito/android/advert_core/specifications/SpecificationsConverter;", "s", "Lcom/avito/android/advert_core/specifications/SpecificationsConverter;", "converter", "Lcom/avito/android/remote/model/ModelSpecifications;", "t", "Lcom/avito/android/remote/model/ModelSpecifications;", "specs", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/remote/model/ModelSpecifications;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceSpecsDialog extends BottomSheetDialog {
    public final SpecificationsConverter s = new SpecificationsConverterImpl(new SimpleNarrowLayoutTypeProviderImpl());
    public final ModelSpecifications t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceSpecsDialog(@NotNull Context context, @NotNull ModelSpecifications modelSpecifications) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(modelSpecifications, "specs");
        this.t = modelSpecifications;
        setContentView(R.layout.marketplace_specs_bottomsheet_layout, new Function1<View, Unit>(this) { // from class: com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsDialog.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                MarketplaceSpecsDialog.access$setupContentView((MarketplaceSpecsDialog) this.receiver, view2);
                return Unit.INSTANCE;
            }
        });
        AdvertDetailsViewKt.setMarketplaceCustomHeader$default(this, null, 1, null);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        setFitContentPeekHeight(true);
    }

    public static final void access$setupContentView(MarketplaceSpecsDialog marketplaceSpecsDialog, View view) {
        Objects.requireNonNull(marketplaceSpecsDialog);
        View findViewById = view.findViewById(com.avito.android.advert_core.R.id.specifications);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.advert_core.specifications.SpecificationView");
        Pair<Integer, List<SpecificationData>> convertSpecifications = marketplaceSpecsDialog.s.convertSpecifications(marketplaceSpecsDialog.t, -1);
        ((SpecificationView) findViewById).setData(convertSpecifications.component1().intValue(), convertSpecifications.component2());
    }
}

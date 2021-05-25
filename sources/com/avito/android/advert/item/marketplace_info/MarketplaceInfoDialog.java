package com.avito.android.advert.item.marketplace_info;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert.item.AdvertDetailsViewKt;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.marketplace.InfoBannerPopup;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoDialog;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "Lcom/avito/android/remote/marketplace/InfoBannerPopup;", "s", "Lcom/avito/android/remote/marketplace/InfoBannerPopup;", "popup", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/remote/marketplace/InfoBannerPopup;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceInfoDialog extends BottomSheetDialog {
    public final InfoBannerPopup s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceInfoDialog(@NotNull Context context, @NotNull InfoBannerPopup infoBannerPopup) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(infoBannerPopup, "popup");
        this.s = infoBannerPopup;
        setContentView(R.layout.marketplace_info_bottomsheet_layout, new Function1<View, Unit>(this) { // from class: com.avito.android.advert.item.marketplace_info.MarketplaceInfoDialog.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                MarketplaceInfoDialog.access$setupContentView((MarketplaceInfoDialog) this.receiver, view2);
                return Unit.INSTANCE;
            }
        });
        AdvertDetailsViewKt.setMarketplaceCustomHeader$default(this, null, 1, null);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        setFitContentPeekHeight(true);
    }

    public static final void access$setupContentView(MarketplaceInfoDialog marketplaceInfoDialog, View view) {
        Objects.requireNonNull(marketplaceInfoDialog);
        View findViewById = view.findViewById(R.id.marketplace_info_bottomsheet_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(advert…e_info_bottomsheet_title)");
        View findViewById2 = view.findViewById(R.id.marketplace_info_bottomsheet_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(advert…ce_info_bottomsheet_text)");
        ((TextView) findViewById).setText(marketplaceInfoDialog.s.getTitle());
        ((TextView) findViewById2).setText(marketplaceInfoDialog.s.getDescription());
    }
}

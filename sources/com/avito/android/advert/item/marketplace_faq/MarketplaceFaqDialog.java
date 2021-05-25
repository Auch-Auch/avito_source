package com.avito.android.advert.item.marketplace_faq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.advert.item.AdvertDetailsViewKt;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.model.AdvertParameters;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqDialog;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", "s", "Ljava/util/List;", "items", "Landroid/content/Context;", "context", "", "title", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceFaqDialog extends BottomSheetDialog {
    public final List<AdvertParameters.Parameter> s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceFaqDialog(@NotNull Context context, @Nullable String str, @NotNull List<AdvertParameters.Parameter> list) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "items");
        this.s = list;
        setContentView(R.layout.marketplace_faq_bottomsheet_layout, new Function1<View, Unit>(this) { // from class: com.avito.android.advert.item.marketplace_faq.MarketplaceFaqDialog.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                MarketplaceFaqDialog.access$setupContentView((MarketplaceFaqDialog) this.receiver, view2);
                return Unit.INSTANCE;
            }
        });
        AdvertDetailsViewKt.setMarketplaceCustomHeader(this, str);
        setSkipCollapsed(true);
        setCanceledOnTouchOutside(true);
        setFitContentPeekHeight(true);
    }

    public static final void access$setupContentView(MarketplaceFaqDialog marketplaceFaqDialog, View view) {
        Objects.requireNonNull(marketplaceFaqDialog);
        View findViewById = view.findViewById(R.id.marketplace_faq_bottomsheet_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…aq_bottomsheet_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        LayoutInflater from = LayoutInflater.from(marketplaceFaqDialog.getContext());
        for (T t : marketplaceFaqDialog.s) {
            View inflate = from.inflate(R.layout.marketplace_faq_item, (ViewGroup) linearLayout, false);
            View findViewById2 = inflate.findViewById(R.id.marketplace_faq_item_title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById<Te…rketplace_faq_item_title)");
            ((TextView) findViewById2).setText(t.getTitle());
            View findViewById3 = inflate.findViewById(R.id.marketplace_faq_item_description);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById<Te…ace_faq_item_description)");
            ((TextView) findViewById3).setText(t.getDescription());
            linearLayout.addView(inflate);
        }
    }
}

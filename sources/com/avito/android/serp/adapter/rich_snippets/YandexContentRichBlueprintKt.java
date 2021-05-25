package com.avito.android.serp.adapter.rich_snippets;

import android.content.res.Resources;
import android.view.View;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroid/view/View;", "applyYandexBannerRichStyle", "(Landroid/view/View;)Landroid/view/View;", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class YandexContentRichBlueprintKt {
    @NotNull
    public static final View applyYandexBannerRichStyle(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$applyYandexBannerRichStyle");
        Views.changePadding$default(view, view.getResources().getDimensionPixelSize(R.dimen.rich_snippet_banner_padding_left), view.getResources().getDimensionPixelSize(R.dimen.rich_snippet_commercial_padding_top), view.getResources().getDimensionPixelSize(R.dimen.rich_snippet_banner_padding_right), 0, 8, null);
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 2) {
            Resources resources2 = view.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "resources");
            view.getLayoutParams().width = (int) (((float) (((resources2.getDisplayMetrics().widthPixels - view.getPaddingLeft()) - view.getPaddingRight()) - (view.getResources().getDimensionPixelSize(R.dimen.serp_horizontal_padding) * 2))) * 0.42857143f);
        }
        return view;
    }
}

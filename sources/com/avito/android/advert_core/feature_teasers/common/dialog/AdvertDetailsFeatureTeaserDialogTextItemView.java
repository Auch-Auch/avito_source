package com.avito.android.advert_core.feature_teasers.common.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItem;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItemKt;
import com.avito.android.advert_core.utils.AdvertDetailsUtilsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItem;", "item", "", "bindItem", "(Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItem;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "t", "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFeatureTeaserDialogTextItemView extends BaseViewHolder implements ItemView {
    public final TextView s;
    public final AttributedTextFormatter t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsFeatureTeaserDialogTextItemView(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.t = attributedTextFormatter;
        TextView textView = (TextView) view;
        this.s = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void bindItem(@NotNull AdvertDetailsFeatureTeaserDialogTextItem advertDetailsFeatureTeaserDialogTextItem) {
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserDialogTextItem, "item");
        TextView textView = this.s;
        TextViewCompat.setTextAppearance(textView, advertDetailsFeatureTeaserDialogTextItem.getTextStyle());
        CharSequence text = advertDetailsFeatureTeaserDialogTextItem.getText();
        if (text == null) {
            AttributedTextFormatter attributedTextFormatter = this.t;
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            text = attributedTextFormatter.format(context, advertDetailsFeatureTeaserDialogTextItem.getAttributedText());
        }
        AdvertDetailsFeatureTeaserItem.Icon leftIcon = advertDetailsFeatureTeaserDialogTextItem.getLeftIcon();
        Context context2 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Drawable drawable = AdvertDetailsFeatureTeaserItemKt.drawable(leftIcon, context2);
        Integer valueOf = Integer.valueOf(advertDetailsFeatureTeaserDialogTextItem.getDrawablePadding());
        Context context3 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        textView.setText(AdvertDetailsFeatureTeaserItemKt.textWithLeftIcon(text, drawable, AdvertDetailsUtilsKt.dimen(valueOf, context3)));
        AdvertDetailsFeatureTeaserItem.Icon rightIcon = advertDetailsFeatureTeaserDialogTextItem.getRightIcon();
        Context context4 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        TextViews.setCompoundDrawables$default(textView, (Drawable) null, (Drawable) null, AdvertDetailsFeatureTeaserItemKt.drawable(rightIcon, context4), (Drawable) null, 11, (Object) null);
        Integer valueOf2 = Integer.valueOf(advertDetailsFeatureTeaserDialogTextItem.getDrawablePadding());
        Context context5 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        textView.setCompoundDrawablePadding(AdvertDetailsUtilsKt.dimen(valueOf2, context5));
        Integer leftPaddingRes = advertDetailsFeatureTeaserDialogTextItem.getLeftPaddingRes();
        if (leftPaddingRes != null) {
            Integer valueOf3 = Integer.valueOf(leftPaddingRes.intValue());
            Context context6 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "context");
            textView.setPadding(AdvertDetailsUtilsKt.dimen(valueOf3, context6), textView.getPaddingTop(), textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ItemView.DefaultImpls.onUnbind(this);
    }
}

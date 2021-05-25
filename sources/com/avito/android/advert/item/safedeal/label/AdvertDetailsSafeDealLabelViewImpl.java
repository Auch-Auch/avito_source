package com.avito.android.advert.item.safedeal.label;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelView;
import com.avito.android.advert_details.R;
import com.avito.android.remote.model.SafeDeal;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelView;", "Lcom/avito/android/remote/model/SafeDeal$Actions;", "actions", "", "aboutLabelTitle", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelView$Router;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showLabel", "(Lcom/avito/android/remote/model/SafeDeal$Actions;Ljava/lang/CharSequence;Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelView$Router;)V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "discountLabel", "s", "aboutLabel", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealLabelViewImpl extends BaseViewHolder implements AdvertDetailsSafeDealLabelView {
    public final TextView s;
    public final TextView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsSafeDealLabelViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.about_label);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.discount_label);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelView
    public void showLabel(@NotNull SafeDeal.Actions actions, @Nullable CharSequence charSequence, @NotNull AdvertDetailsSafeDealLabelView.Router router) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(router, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (charSequence != null) {
            SpannableString spannableString = new SpannableString(charSequence);
            Matcher matcher = Pattern.compile("(?<!\n)\n{2}(?!\n)").matcher(spannableString);
            while (matcher.find()) {
                spannableString.setSpan(new RelativeSizeSpan(0.35f), matcher.start() + 1, matcher.end(), 33);
            }
            this.s.setText(spannableString, TextView.BufferType.SPANNABLE);
            this.s.setMovementMethod(LinkMovementMethod.getInstance());
        }
        SafeDeal.DiscountLabel discountLabel = actions.getDiscountLabel();
        if (discountLabel != null) {
            this.s.setGravity(GravityCompat.START);
            TextView textView = this.t;
            textView.setVisibility(0);
            textView.setText(discountLabel.getText());
            Views.changeMargin$default(textView, 0, ((this.s.getLineHeight() - this.t.getHeight()) * 3) / 5, 0, 0, 13, null);
        }
    }
}

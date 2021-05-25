package com.avito.android.fees.utils;

import android.content.res.Resources;
import com.avito.android.deep_linking.links.InfoPageLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.fees.R;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.DeepLinkAttribute;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/fees/utils/FeesAttributedTextUtils;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "onDeepLinkClickListener", "Lcom/avito/android/remote/model/text/AttributedText;", "generateFeeAgreementAttributedText", "(Landroid/content/res/Resources;Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class FeesAttributedTextUtils {
    @NotNull
    public static final FeesAttributedTextUtils INSTANCE = new FeesAttributedTextUtils();

    @JvmStatic
    @NotNull
    public static final AttributedText generateFeeAgreementAttributedText(@NotNull Resources resources, @NotNull OnDeepLinkClickListener onDeepLinkClickListener) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(onDeepLinkClickListener, "onDeepLinkClickListener");
        String string = resources.getString(R.string.listing_fees_agreement_link1_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…es_agreement_link1_title)");
        String string2 = resources.getString(R.string.fees_paid_placement_conditions);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…aid_placement_conditions)");
        String string3 = resources.getString(R.string.listing_fees_agreement_link2_title);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…es_agreement_link2_title)");
        String string4 = resources.getString(com.avito.android.ui_components.R.string.read_offer);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(ui_R.string.read_offer)");
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new DeepLinkAttribute[]{new DeepLinkAttribute("link1", string, new InfoPageLink("app_fee_conditions", string2), null, null, 24, null), new DeepLinkAttribute("link2", string3, new InfoPageLink("oferta", string4), null, null, 24, null)});
        String string5 = resources.getString(R.string.listing_fees_agreement_text);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st…ting_fees_agreement_text)");
        AttributedText attributedText = new AttributedText(string5, listOf);
        attributedText.setOnDeepLinkClickListener(onDeepLinkClickListener);
        return attributedText;
    }
}

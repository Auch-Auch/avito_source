package com.avito.android.advert.item.safedeal.label;

import android.content.Context;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.AttributedTextFormatter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelPresenterImpl;", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelPresenter;", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelView;", "view", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelView;Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelItem;I)V", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "safedealPresenter", "<init>", "(Landroid/content/Context;Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealLabelPresenterImpl implements AdvertDetailsSafeDealLabelPresenter {
    public final Context a;
    public final AdvertSafeDealPresenter b;
    public final AttributedTextFormatter c;

    @Inject
    public AdvertDetailsSafeDealLabelPresenterImpl(@NotNull Context context, @NotNull AdvertSafeDealPresenter advertSafeDealPresenter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(advertSafeDealPresenter, "safedealPresenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.a = context;
        this.b = advertSafeDealPresenter;
        this.c = attributedTextFormatter;
    }

    public void bindView(@NotNull AdvertDetailsSafeDealLabelView advertDetailsSafeDealLabelView, @NotNull AdvertDetailsSafeDealLabelItem advertDetailsSafeDealLabelItem, int i) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(advertDetailsSafeDealLabelView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsSafeDealLabelItem, "item");
        this.b.setCategoryId(advertDetailsSafeDealLabelItem.getCategoryId());
        AttributedText aboutLabel = advertDetailsSafeDealLabelItem.getActions().getAboutLabel();
        if (aboutLabel != null) {
            AttributedText attributedText = new AttributedText(new Regex("(?<!\n)\n(?!\n)").replace(aboutLabel.getText(), "\n\n"), aboutLabel.getAttributes());
            attributedText.setOnDeepLinkClickListener(new OnDeepLinkClickListener(this, advertDetailsSafeDealLabelView) { // from class: com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelPresenterImpl$bindView$$inlined$with$lambda$1
                public final /* synthetic */ AdvertDetailsSafeDealLabelPresenterImpl a;
                public final /* synthetic */ AdvertDetailsSafeDealLabelView b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                    Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                    this.a.b.followLabelDeepLink(deepLink);
                }
            });
            charSequence = this.c.format(this.a, attributedText);
        } else {
            charSequence = null;
        }
        advertDetailsSafeDealLabelView.showLabel(advertDetailsSafeDealLabelItem.getActions(), charSequence, this.b);
    }
}

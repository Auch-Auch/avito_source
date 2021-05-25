package com.avito.android.bundles.ui.recycler.item.bundle;

import com.avito.android.bundles.ui.recycler.item.benefit.BundleBenefitItem;
import com.avito.android.remote.model.BundleDiscount;
import com.avito.android.remote.model.UniversalImage;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0019\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u001b\u0010\u0017J%\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH&¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/UniversalImage;", "image", "", "setPicture", "(Lcom/avito/android/remote/model/UniversalImage;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/BundleDiscount;", FirebaseAnalytics.Param.DISCOUNT, "setDiscount", "(Lcom/avito/android/remote/model/BundleDiscount;)V", "", "Lcom/avito/android/bundles/ui/recycler/item/benefit/BundleBenefitItem;", "benefits", "setBenefits", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "price", "setPrice", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "oldPrice", "setOldPrice", "priceHint", "setPriceHint", "text", "Lkotlin/Function0;", "onClickListener", "configureChooseButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public interface VasBundleItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull VasBundleItemView vasBundleItemView) {
            ItemView.DefaultImpls.onUnbind(vasBundleItemView);
        }
    }

    void configureChooseButton(@NotNull String str, @NotNull Function0<Unit> function0);

    void setBenefits(@NotNull List<BundleBenefitItem> list);

    void setDiscount(@Nullable BundleDiscount bundleDiscount);

    void setOldPrice(@Nullable AttributedText attributedText);

    void setPicture(@Nullable UniversalImage universalImage);

    void setPrice(@NotNull AttributedText attributedText);

    void setPriceHint(@Nullable AttributedText attributedText);

    void setTitle(@NotNull String str);
}

package com.avito.android.bundles.ui.recycler.item.benefit;

import android.view.View;
import com.avito.android.remote.model.BenefitColoredIcon;
import com.avito.android.remote.model.BundleBadge;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/BenefitColoredIcon;", "benefitColoredIcon", "", "setIcon", "(Lcom/avito/android/remote/model/BenefitColoredIcon;)V", "", "text", "Lcom/avito/android/remote/model/BundleBadge;", "badge", "setText", "(Ljava/lang/String;Lcom/avito/android/remote/model/BundleBadge;)V", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "removeOnClickListener", "()V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public interface BenefitItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull BenefitItemView benefitItemView) {
            ItemView.DefaultImpls.onUnbind(benefitItemView);
        }
    }

    void removeOnClickListener();

    void setIcon(@Nullable BenefitColoredIcon benefitColoredIcon);

    void setOnClickListener(@NotNull View.OnClickListener onClickListener);

    void setText(@NotNull String str, @Nullable BundleBadge bundleBadge);
}

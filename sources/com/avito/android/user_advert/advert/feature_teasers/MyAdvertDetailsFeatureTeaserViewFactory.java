package com.avito.android.user_advert.advert.feature_teasers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert_core.feature_teasers.common.CommonFeatureTeaserView;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView;
import com.avito.android.advert_core.feature_teasers.common.dialog.FeatureTeaserDialogFactory;
import com.avito.android.deprecated_design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserViewFactory;", "", "Landroid/view/ViewGroup;", "parent", "", "isFirstItem", "isLastItem", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;", "createFeatureTeaserView", "(Landroid/view/ViewGroup;ZZ)Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;", "", "resId", "Landroid/view/View;", AuthSource.SEND_ABUSE, "(Landroid/view/ViewGroup;I)Landroid/view/View;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;", "dialogFactory", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsFeatureTeaserViewFactory {
    public final FeatureTeaserResourceProvider a;
    public final FeatureTeaserDialogFactory b;

    @Inject
    public MyAdvertDetailsFeatureTeaserViewFactory(@NotNull FeatureTeaserResourceProvider featureTeaserResourceProvider, @NotNull FeatureTeaserDialogFactory featureTeaserDialogFactory) {
        Intrinsics.checkNotNullParameter(featureTeaserResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(featureTeaserDialogFactory, "dialogFactory");
        this.a = featureTeaserResourceProvider;
        this.b = featureTeaserDialogFactory;
    }

    public final View a(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        viewGroup.addView(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater\n         …    .also { addView(it) }");
        return inflate;
    }

    @NotNull
    public final FeatureTeaserView createFeatureTeaserView(@NotNull ViewGroup viewGroup, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (z) {
            Views.changeMargin$default(a(viewGroup, R.layout.divider_1_0), 0, 0, 0, ViewSizeKt.getDp(22), 7, null);
        }
        View a3 = a(viewGroup, com.avito.android.advert_core.R.layout.advert_details_feature_teaser);
        if (!z2) {
            Views.changeMargin$default(a(viewGroup, R.layout.divider_1_0), 0, ViewSizeKt.getDp(22), 0, ViewSizeKt.getDp(22), 5, null);
        } else {
            Views.changeMargin$default(a3, 0, 0, 0, ViewSizeKt.getDp(22), 7, null);
        }
        return new CommonFeatureTeaserView(a3, this.a, this.b);
    }
}

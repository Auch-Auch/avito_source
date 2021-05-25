package com.avito.android.tariff.info.item.package_info;

import android.view.View;
import android.widget.TextView;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.android.tariff.R;
import com.avito.android.tariff.view.TariffCountBar;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0007J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001f¨\u0006-"}, d2 = {"Lcom/avito/android/tariff/info/item/package_info/PackageInfoItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/tariff/info/item/package_info/PackageInfoItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "subcategories", "setSubcategories", "location", "setLocation", "setBarTitle", MessengerShareContentUtility.SUBTITLE, "bindBarSubtitle", "", "progress", "setBarProgress", "(F)V", "Lcom/avito/android/paid_services/routing/ProgressState;", "progressState", "setBarState", "(Lcom/avito/android/paid_services/routing/ProgressState;)V", "description", "bindBarDescription", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "tariffCountStatus", "setBarDescriptionStatus", "(Lcom/avito/android/paid_services/routing/TariffCountStatus;)V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "locationsView", "s", "titleView", "Lcom/avito/android/tariff/view/TariffCountBar;", VKApiConst.VERSION, "Lcom/avito/android/tariff/view/TariffCountBar;", "countBar", "t", "subcategoriesView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class PackageInfoItemViewImpl extends BaseViewHolder implements PackageInfoItemView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TariffCountBar v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PackageInfoItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.subcategories);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.subcategories)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.location);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.location)");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.count_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.count_bar)");
        this.v = (TariffCountBar) findViewById4;
    }

    @Override // com.avito.android.tariff.info.item.package_info.PackageInfoItemView
    public void bindBarDescription(@Nullable String str) {
        this.v.bindDescription(str);
    }

    @Override // com.avito.android.tariff.info.item.package_info.PackageInfoItemView
    public void bindBarSubtitle(@Nullable String str) {
        this.v.bindSubtitle(str);
    }

    @Override // com.avito.android.tariff.info.item.package_info.PackageInfoItemView
    public void setBarDescriptionStatus(@NotNull TariffCountStatus tariffCountStatus) {
        Intrinsics.checkNotNullParameter(tariffCountStatus, "tariffCountStatus");
        this.v.setDescriptionStatus(tariffCountStatus);
    }

    @Override // com.avito.android.tariff.info.item.package_info.PackageInfoItemView
    public void setBarProgress(float f) {
        this.v.setProgress(f);
    }

    @Override // com.avito.android.tariff.info.item.package_info.PackageInfoItemView
    public void setBarState(@NotNull ProgressState progressState) {
        Intrinsics.checkNotNullParameter(progressState, "progressState");
        this.v.setProgressState(progressState);
    }

    @Override // com.avito.android.tariff.info.item.package_info.PackageInfoItemView
    public void setBarTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.v.setTitle(str);
    }

    @Override // com.avito.android.tariff.info.item.package_info.PackageInfoItemView
    public void setLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "location");
        this.u.setText(str);
    }

    @Override // com.avito.android.tariff.info.item.package_info.PackageInfoItemView
    public void setSubcategories(@Nullable String str) {
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.tariff.info.item.package_info.PackageInfoItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }
}

package com.avito.android.tariff.tariff_package_info.recycler.header;

import android.view.View;
import android.widget.TextView;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.android.tariff.R;
import com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderItemView;
import com.avito.android.tariff.view.TariffCountBar;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010 \u001a\n \u0019*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderItemViewImpl;", "Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "progress", "", "setBarProgress", "(F)V", "", "barTitle", "setBarTitle", "(Ljava/lang/String;)V", "title", "setTitle", "Lcom/avito/android/paid_services/routing/ProgressState;", "status", "setProgressState", "(Lcom/avito/android/paid_services/routing/ProgressState;)V", "barDescription", "setBarDescription", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "tariffCountStatus", "setBarDescriptionStatus", "(Lcom/avito/android/paid_services/routing/TariffCountStatus;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "titleView", "Lcom/avito/android/tariff/view/TariffCountBar;", "t", "Lcom/avito/android/tariff/view/TariffCountBar;", "countBar", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackageHeaderItemViewImpl extends BaseViewHolder implements TariffPackageHeaderItemView {
    public final TextView s;
    public final TariffCountBar t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TariffPackageHeaderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (TariffCountBar) view.findViewById(R.id.count_bar);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        TariffPackageHeaderItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderItemView
    public void setBarDescription(@Nullable String str) {
        this.t.bindDescription(str);
    }

    @Override // com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderItemView
    public void setBarDescriptionStatus(@NotNull TariffCountStatus tariffCountStatus) {
        Intrinsics.checkNotNullParameter(tariffCountStatus, "tariffCountStatus");
        this.t.setDescriptionStatus(tariffCountStatus);
    }

    @Override // com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderItemView
    public void setBarProgress(float f) {
        this.t.setProgress(f);
    }

    @Override // com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderItemView
    public void setBarTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "barTitle");
        this.t.setTitle(str);
    }

    @Override // com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderItemView
    public void setProgressState(@NotNull ProgressState progressState) {
        Intrinsics.checkNotNullParameter(progressState, "status");
        this.t.setProgressState(progressState);
    }

    @Override // com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderItemView
    public void setTitle(@Nullable String str) {
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "titleView");
        TextViews.bindText$default(textView, str, false, 2, null);
    }
}

package com.avito.android.tariff.fees_methods.items.bar;

import android.view.View;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.android.tariff.R;
import com.avito.android.tariff.fees_methods.items.bar.BarItemView;
import com.avito.android.tariff.view.TariffCountBar;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/bar/BarItemViewImpl;", "Lcom/avito/android/tariff/fees_methods/items/bar/BarItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "bindSubtitle", "description", "bindDescription", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "tariffCountStatus", "setDescriptionStatus", "(Lcom/avito/android/paid_services/routing/TariffCountStatus;)V", "Lcom/avito/android/paid_services/routing/ProgressState;", "progressState", "setProgressState", "(Lcom/avito/android/paid_services/routing/ProgressState;)V", "", "progress", "setProgress", "(F)V", "Lcom/avito/android/tariff/view/TariffCountBar;", "s", "Lcom/avito/android/tariff/view/TariffCountBar;", "countBar", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class BarItemViewImpl extends BaseViewHolder implements BarItemView {
    public TariffCountBar s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BarItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.bar_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.bar_view)");
        this.s = (TariffCountBar) findViewById;
    }

    @Override // com.avito.android.tariff.fees_methods.items.bar.BarItemView
    public void bindDescription(@Nullable String str) {
        this.s.bindDescription(str);
    }

    @Override // com.avito.android.tariff.fees_methods.items.bar.BarItemView
    public void bindSubtitle(@Nullable String str) {
        this.s.bindSubtitle(str);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        BarItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.tariff.fees_methods.items.bar.BarItemView
    public void setDescriptionStatus(@NotNull TariffCountStatus tariffCountStatus) {
        Intrinsics.checkNotNullParameter(tariffCountStatus, "tariffCountStatus");
        this.s.setDescriptionStatus(tariffCountStatus);
    }

    @Override // com.avito.android.tariff.fees_methods.items.bar.BarItemView
    public void setProgress(float f) {
        this.s.setProgress(f);
    }

    @Override // com.avito.android.tariff.fees_methods.items.bar.BarItemView
    public void setProgressState(@NotNull ProgressState progressState) {
        Intrinsics.checkNotNullParameter(progressState, "progressState");
        this.s.setProgressState(progressState);
    }

    @Override // com.avito.android.tariff.fees_methods.items.bar.BarItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }
}

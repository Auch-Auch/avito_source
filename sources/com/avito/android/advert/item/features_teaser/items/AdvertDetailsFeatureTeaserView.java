package com.avito.android.advert.item.features_teaser.items;

import android.view.View;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItem;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserOption;
import com.avito.android.advert_core.feature_teasers.common.CommonFeatureTeaserView;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogInfo;
import com.avito.android.advert_core.feature_teasers.common.dialog.FeatureTeaserDialogFactory;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b(\u0010)J\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\u0013\u0010\fJ\u001e\u0010\u0014\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u0014\u0010\bJ\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\u0015\u0010\fJ$\u0010\u0018\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006*"}, d2 = {"Lcom/avito/android/advert/item/features_teaser/items/AdvertDetailsFeatureTeaserView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "test", "setButtonText", "(Ljava/lang/String;)V", "", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;", "options", "setFeatures", "(Ljava/util/List;)V", "text", "setLinkText", "setLinkTextClickListener", "setSubtitle", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;", "icon", "setTitle", "(Ljava/lang/String;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;)V", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;", "dialogInfo", "showDialog", "(Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;)V", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;", "t", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;", "dialogFactory", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "s", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "resourceProvider", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public class AdvertDetailsFeatureTeaserView extends BaseViewHolder implements ItemView, FeatureTeaserView {
    public final FeatureTeaserResourceProvider s;
    public final FeatureTeaserDialogFactory t;
    public final /* synthetic */ CommonFeatureTeaserView u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsFeatureTeaserView(@NotNull View view, @NotNull FeatureTeaserResourceProvider featureTeaserResourceProvider, @NotNull FeatureTeaserDialogFactory featureTeaserDialogFactory) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(featureTeaserResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(featureTeaserDialogFactory, "dialogFactory");
        this.u = new CommonFeatureTeaserView(view, featureTeaserResourceProvider, featureTeaserDialogFactory);
        this.s = featureTeaserResourceProvider;
        this.t = featureTeaserDialogFactory;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setButtonClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.setButtonClickListener(function0);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setButtonText(@Nullable String str) {
        this.u.setButtonText(str);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setFeatures(@NotNull List<AdvertDetailsFeatureTeaserOption> list) {
        Intrinsics.checkNotNullParameter(list, "options");
        this.u.setFeatures(list);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setLinkText(@Nullable String str) {
        this.u.setLinkText(str);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setLinkTextClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.setLinkTextClickListener(function0);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setSubtitle(@Nullable String str) {
        this.u.setSubtitle(str);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setTitle(@Nullable String str, @Nullable AdvertDetailsFeatureTeaserItem.Icon icon) {
        this.u.setTitle(str, icon);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void showDialog(@NotNull AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo) {
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserDialogInfo, "dialogInfo");
        this.u.showDialog(advertDetailsFeatureTeaserDialogInfo);
    }
}

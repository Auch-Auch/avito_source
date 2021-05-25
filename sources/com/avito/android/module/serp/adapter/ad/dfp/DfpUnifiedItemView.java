package com.avito.android.module.serp.adapter.ad.dfp;

import com.avito.android.component.ads.dfp.AdDfpUnified;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/component/ads/dfp/AdDfpUnified;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface DfpUnifiedItemView extends ItemView, AdDfpUnified {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull DfpUnifiedItemView dfpUnifiedItemView) {
            ItemView.DefaultImpls.onUnbind(dfpUnifiedItemView);
        }
    }

    void setUnbindListener(@Nullable Function0<Unit> function0);
}

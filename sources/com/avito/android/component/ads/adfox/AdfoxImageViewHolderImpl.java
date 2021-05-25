package com.avito.android.component.ads.adfox;

import android.view.View;
import com.avito.android.component.ads.adfox.AdfoxImageViewHolder;
import com.avito.android.serp.BaseSerpViewHolder;
import com.yandex.mobile.ads.nativeads.NativeImageAd;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012JD\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/avito/android/component/ads/adfox/AdfoxImageViewHolderImpl;", "Lcom/avito/android/component/ads/adfox/AdfoxImageViewHolder;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lcom/avito/android/component/ads/adfox/AdfoxImage;", "Lcom/yandex/mobile/ads/nativeads/NativeImageAd;", "nativeAd", "", "isClosed", "showGrayBadge", "Lkotlin/Function0;", "", "closeListener", "openListener", "bindAd", "(Lcom/yandex/mobile/ads/nativeads/NativeImageAd;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdfoxImageViewHolderImpl extends BaseSerpViewHolder implements AdfoxImageViewHolder, AdfoxImage {
    public final /* synthetic */ AdfoxImageImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdfoxImageViewHolderImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new AdfoxImageImpl(view);
    }

    @Override // com.avito.android.component.ads.adfox.AdfoxImage
    public void bindAd(@NotNull NativeImageAd nativeImageAd, boolean z, boolean z2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(nativeImageAd, "nativeAd");
        Intrinsics.checkNotNullParameter(function0, "closeListener");
        Intrinsics.checkNotNullParameter(function02, "openListener");
        this.s.bindAd(nativeImageAd, z, z2, function0, function02);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AdfoxImageViewHolder.DefaultImpls.onUnbind(this);
    }
}

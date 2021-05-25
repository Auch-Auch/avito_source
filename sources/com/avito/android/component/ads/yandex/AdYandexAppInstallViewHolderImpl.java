package com.avito.android.component.ads.yandex;

import android.view.View;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.component.ads.yandex.AdYandexAppInstallViewHolder;
import com.avito.android.serp.BaseSerpViewHolder;
import com.yandex.mobile.ads.nativeads.NativeAppInstallAd;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J<\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/avito/android/component/ads/yandex/AdYandexAppInstallViewHolderImpl;", "Lcom/avito/android/component/ads/yandex/AdYandexAppInstallViewHolder;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lcom/avito/android/component/ads/yandex/AdYandexAppInstall;", "Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAd;", "nativeAd", "", "isClose", "Lkotlin/Function0;", "", "closeListener", "openListener", "bindAd", "(Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAd;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "bindBody", "(Lcom/avito/android/app/DescriptionPosition;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdYandexAppInstallViewHolderImpl extends BaseSerpViewHolder implements AdYandexAppInstallViewHolder, AdYandexAppInstall {
    public final /* synthetic */ AdYandexAppInstallImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdYandexAppInstallViewHolderImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new AdYandexAppInstallImpl(view);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexAppInstall
    public void bindAd(@NotNull NativeAppInstallAd nativeAppInstallAd, boolean z, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(nativeAppInstallAd, "nativeAd");
        Intrinsics.checkNotNullParameter(function0, "closeListener");
        Intrinsics.checkNotNullParameter(function02, "openListener");
        this.s.bindAd(nativeAppInstallAd, z, function0, function02);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexAppInstall
    public void bindBody(@NotNull DescriptionPosition descriptionPosition) {
        Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
        this.s.bindBody(descriptionPosition);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AdYandexAppInstallViewHolder.DefaultImpls.onUnbind(this);
    }
}

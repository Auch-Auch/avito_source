package com.avito.android.component.ads.yandex;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import com.avito.android.component.ads.yandex.AdYandexContentViewHolder;
import com.avito.android.serp.BaseSerpViewHolder;
import com.yandex.mobile.ads.nativeads.NativeContentAd;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJD\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/component/ads/yandex/AdYandexContentViewHolderImpl;", "Lcom/avito/android/component/ads/yandex/AdYandexContentViewHolder;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lcom/avito/android/component/ads/yandex/AdYandexContent;", "Lcom/yandex/mobile/ads/nativeads/NativeContentAd;", "nativeAd", "", "isClose", "isRedesign", "Lkotlin/Function0;", "", "closeListener", "openListener", "bindAd", "(Lcom/yandex/mobile/ads/nativeads/NativeContentAd;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "hasImage", "()Z", "Landroid/widget/Button;", "view", "setFeedbackView", "(Landroid/widget/Button;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "clipToOutline", "setImageClipToOutline", "(Z)V", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdYandexContentViewHolderImpl extends BaseSerpViewHolder implements AdYandexContentViewHolder, AdYandexContent {
    public final /* synthetic */ AdYandexContentImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdYandexContentViewHolderImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new AdYandexContentImpl(view);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexContent
    public void bindAd(@NotNull NativeContentAd nativeContentAd, boolean z, boolean z2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(nativeContentAd, "nativeAd");
        Intrinsics.checkNotNullParameter(function0, "closeListener");
        Intrinsics.checkNotNullParameter(function02, "openListener");
        this.s.bindAd(nativeContentAd, z, z2, function0, function02);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexContent
    public boolean hasImage() {
        return this.s.hasImage();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AdYandexContentViewHolder.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexContent
    public void setFeedbackView(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "view");
        this.s.setFeedbackView(button);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexContent
    public void setImage(@Nullable Drawable drawable) {
        this.s.setImage(drawable);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexContent
    public void setImageClipToOutline(boolean z) {
        this.s.setImageClipToOutline(z);
    }
}

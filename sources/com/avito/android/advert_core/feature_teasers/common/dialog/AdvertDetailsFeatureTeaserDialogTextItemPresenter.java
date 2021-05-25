package com.avito.android.advert_core.feature_teasers.common.dialog;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\t\b\u0007¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItemView;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItem;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItemView;Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItem;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lkotlin/Function1;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "getDeepLinkRouter", "()Lkotlin/jvm/functions/Function1;", "setDeepLinkRouter", "(Lkotlin/jvm/functions/Function1;)V", "deepLinkRouter", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFeatureTeaserDialogTextItemPresenter implements ItemPresenter<AdvertDetailsFeatureTeaserDialogTextItemView, AdvertDetailsFeatureTeaserDialogTextItem>, OnDeepLinkClickListener {
    @Nullable
    public Function1<? super DeepLink, Unit> a;

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.avito.android.deep_linking.links.DeepLink, kotlin.Unit>, kotlin.jvm.functions.Function1<com.avito.android.deep_linking.links.DeepLink, kotlin.Unit> */
    @Nullable
    public final Function1<DeepLink, Unit> getDeepLinkRouter() {
        return this.a;
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Function1<? super DeepLink, Unit> function1 = this.a;
        if (function1 != null) {
            function1.invoke(deepLink);
        }
    }

    public final void setDeepLinkRouter(@Nullable Function1<? super DeepLink, Unit> function1) {
        this.a = function1;
    }

    public void bindView(@NotNull AdvertDetailsFeatureTeaserDialogTextItemView advertDetailsFeatureTeaserDialogTextItemView, @NotNull AdvertDetailsFeatureTeaserDialogTextItem advertDetailsFeatureTeaserDialogTextItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserDialogTextItemView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserDialogTextItem, "item");
        AttributedText attributedText = advertDetailsFeatureTeaserDialogTextItem.getAttributedText();
        if (attributedText != null) {
            attributedText.setOnDeepLinkClickListener(this);
        }
        advertDetailsFeatureTeaserDialogTextItemView.bindItem(advertDetailsFeatureTeaserDialogTextItem);
    }
}

package com.avito.android.messenger.channels.adapter.action_banner;

import android.view.View;
import androidx.annotation.DrawableRes;
import com.avito.android.component.banner_card.BannerCard;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.channels.adapter.action_banner.ActionBannerItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0012\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u0016\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/channels/adapter/action_banner/ActionBannerItemViewImpl;", "Lcom/avito/android/messenger/channels/adapter/action_banner/ActionBannerItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/component/banner_card/BannerCard;", "", "clearActionListeners", "()V", "", "Lcom/avito/android/component/banner_card/BannerCard$Action;", "actions", "setActions", "(Ljava/util/List;)V", "", "visible", "setCloseButtonVisible", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCloseClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setImage", "(Lcom/avito/android/image_loader/Picture;)V", "", "drawableRes", "(I)V", "", "message", "setMessage", "(Ljava/lang/CharSequence;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ActionBannerItemViewImpl extends BaseViewHolder implements ActionBannerItemView, BannerCard {
    public final /* synthetic */ BannerCard s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionBannerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = BannerCard.Companion.create(view);
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void clearActionListeners() {
        this.s.clearActionListeners();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ActionBannerItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setActions(@NotNull List<BannerCard.Action> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.s.setActions(list);
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setCloseButtonVisible(boolean z) {
        this.s.setCloseButtonVisible(z);
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setCloseClickListener(@Nullable Function0<Unit> function0) {
        this.s.setCloseClickListener(function0);
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setImage(@DrawableRes int i) {
        this.s.setImage(i);
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setImage(@Nullable Picture picture) {
        this.s.setImage(picture);
    }

    @Override // com.avito.android.component.banner_card.BannerCard
    public void setMessage(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        this.s.setMessage(charSequence);
    }
}

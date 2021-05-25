package com.avito.android.profile.cards;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.SocialCardItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u001d\u0010\u0011\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0015R\u0016\u0010$\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0015¨\u0006)"}, d2 = {"Lcom/avito/android/profile/cards/SocialCardItemViewHolder;", "Lcom/avito/android/profile/cards/SocialCardItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "hideSocials", "()V", "", "title", "showVkontakte", "(Ljava/lang/String;)V", "showOdnoklassniki", "showApple", "showGosuslugi", "showFacebook", "showGooglePlus", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/component/info_block/InfoBlock;", "w", "Lcom/avito/android/component/info_block/InfoBlock;", "gpView", "t", "okView", "Lru/avito/component/button/Button;", "y", "Lru/avito/component/button/Button;", "actionButtonView", "s", "vkView", "x", "esiaView", "u", "appleView", VKApiConst.VERSION, "fbView", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SocialCardItemViewHolder extends BaseViewHolder implements SocialCardItemView {
    public final InfoBlock s;
    public final InfoBlock t;
    public final InfoBlock u;
    public final InfoBlock v;
    public final InfoBlock w;
    public final InfoBlock x;
    public final Button y;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialCardItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        InfoBlock findInfoBlock = findInfoBlock(view, R.id.social_vk);
        findInfoBlock.setIcon(com.avito.android.ui_components.R.drawable.ic_profile_vk);
        Unit unit = Unit.INSTANCE;
        this.s = findInfoBlock;
        InfoBlock findInfoBlock2 = findInfoBlock(view, R.id.social_ok);
        findInfoBlock2.setIcon(com.avito.android.ui_components.R.drawable.ic_profile_ok);
        this.t = findInfoBlock2;
        InfoBlock findInfoBlock3 = findInfoBlock(view, R.id.social_apple);
        findInfoBlock3.setIcon(com.avito.android.ui_components.R.drawable.ic_profile_apple);
        this.u = findInfoBlock3;
        InfoBlock findInfoBlock4 = findInfoBlock(view, R.id.social_fb);
        findInfoBlock4.setIcon(com.avito.android.ui_components.R.drawable.ic_profile_fb);
        this.v = findInfoBlock4;
        InfoBlock findInfoBlock5 = findInfoBlock(view, R.id.social_gp);
        findInfoBlock5.setIcon(com.avito.android.ui_components.R.drawable.ic_profile_gp);
        this.w = findInfoBlock5;
        InfoBlock findInfoBlock6 = findInfoBlock(view, R.id.social_esia);
        findInfoBlock6.setIcon(com.avito.android.ui_components.R.drawable.ic_profile_esia);
        this.x = findInfoBlock6;
        Button findButton = findButton(view, R.id.edit_social_networks);
        findButton.setText(R.string.edit_social_networks);
        this.y = findButton;
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public Button findButton(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findButton");
        return SocialCardItemView.DefaultImpls.findButton(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ClickableElement findClickableElement(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
        return SocialCardItemView.DefaultImpls.findClickableElement(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public InfoBlock findInfoBlock(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
        return SocialCardItemView.DefaultImpls.findInfoBlock(this, view, i);
    }

    @Override // com.avito.android.profile.cards.SocialCardItemView
    public void hideSocials() {
        this.s.hide();
        this.t.hide();
        this.v.hide();
        this.w.hide();
        this.u.hide();
        this.x.hide();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SocialCardItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.profile.cards.SocialCardItemView
    public void setActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.y.setClickListener(new a(function0));
    }

    @Override // com.avito.android.profile.cards.CardItemView
    public void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
        SocialCardItemView.DefaultImpls.setIcon(this, infoBlock, drawable);
    }

    @Override // com.avito.android.profile.cards.SocialCardItemView
    public void showApple(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.u.bindText(str);
    }

    @Override // com.avito.android.profile.cards.SocialCardItemView
    public void showFacebook(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.v.bindText(str);
    }

    @Override // com.avito.android.profile.cards.SocialCardItemView
    public void showGooglePlus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.w.bindText(str);
    }

    @Override // com.avito.android.profile.cards.SocialCardItemView
    public void showGosuslugi(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.x.bindText(str);
    }

    @Override // com.avito.android.profile.cards.SocialCardItemView
    public void showOdnoklassniki(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.bindText(str);
    }

    @Override // com.avito.android.profile.cards.SocialCardItemView
    public void showVkontakte(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.bindText(str);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public View withCardPaddings(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
        return SocialCardItemView.DefaultImpls.withCardPaddings(this, view);
    }
}

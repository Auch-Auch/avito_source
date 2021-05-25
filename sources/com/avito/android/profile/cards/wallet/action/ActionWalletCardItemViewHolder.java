package com.avito.android.profile.cards.wallet.action;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.Features;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.wallet.action.ActionWalletCardItemView;
import com.avito.android.util.Contexts;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardItemViewHolder;", "Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "balance", "", "setBalance", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "Lcom/avito/android/component/info_block/InfoBlock;", "t", "Lcom/avito/android/component/info_block/InfoBlock;", "balanceView", "Lru/avito/component/button/Button;", "u", "Lru/avito/component/button/Button;", "actionButtonView", "Landroid/view/View;", "rootView", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lcom/avito/android/Features;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ActionWalletCardItemViewHolder extends BaseViewHolder implements ActionWalletCardItemView {
    public final Context s;
    public final InfoBlock t;
    public final Button u;

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
    public ActionWalletCardItemViewHolder(@NotNull View view, @NotNull Features features) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(features, "features");
        Context context = view.getContext();
        this.s = context;
        InfoBlock findInfoBlock = findInfoBlock(view, R.id.balance);
        Drawable drawable = context.getDrawable(com.avito.android.ui_components.R.drawable.ic_pay_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setIcon(findInfoBlock, Contexts.getTintedDrawable(drawable, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28)));
        Unit unit = Unit.INSTANCE;
        this.t = findInfoBlock;
        Button findButton = findButton(view, R.id.wallet_top_up_button);
        findButton.setText(R.string.payment_wallet_page);
        this.u = findButton;
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public Button findButton(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findButton");
        return ActionWalletCardItemView.DefaultImpls.findButton(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ClickableElement findClickableElement(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
        return ActionWalletCardItemView.DefaultImpls.findClickableElement(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public InfoBlock findInfoBlock(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
        return ActionWalletCardItemView.DefaultImpls.findInfoBlock(this, view, i);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ActionWalletCardItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.profile.cards.wallet.action.ActionWalletCardItemView
    public void setActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.setClickListener(new a(function0));
    }

    @Override // com.avito.android.profile.cards.wallet.SimpleWalletCardItemView
    public void setBalance(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "balance");
        this.t.bindText(str);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    public void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
        ActionWalletCardItemView.DefaultImpls.setIcon(this, infoBlock, drawable);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public View withCardPaddings(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
        return ActionWalletCardItemView.DefaultImpls.withCardPaddings(this, view);
    }
}

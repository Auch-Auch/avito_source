package com.avito.android.profile.cards.tfa;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.tfa.TfaSettingsItemView;
import com.avito.android.util.Contexts;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/profile/cards/tfa/TfaSettingsItemViewHolder;", "Lcom/avito/android/profile/cards/tfa/TfaSettingsItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", MessengerShareContentUtility.SUBTITLE, "", "needHighlight", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "bind", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/component/clickable_element/ClickableElement;", "s", "Lcom/avito/android/component/clickable_element/ClickableElement;", "containerView", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "descriptionTextView", "Landroid/view/View;", "u", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class TfaSettingsItemViewHolder extends BaseViewHolder implements TfaSettingsItemView {
    public final ClickableElement s;
    public final TextView t;
    @NotNull
    public final View u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TfaSettingsItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = view;
        this.s = findClickableElement(view, R.id.container);
        View findViewById = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.description)");
        this.t = (TextView) findViewById;
    }

    @Override // com.avito.android.profile.cards.tfa.TfaSettingsItemView
    public void bind(@NotNull String str, @NotNull String str2, boolean z, @NotNull Function0<Unit> function0) {
        int i;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ClickableElement clickableElement = this.s;
        clickableElement.setText(str);
        clickableElement.setDescription(str2);
        Context context = this.u.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (z) {
            i = com.avito.android.lib.design.R.attr.red;
        } else {
            i = com.avito.android.lib.design.R.attr.gray48;
        }
        this.t.setTextColor(Contexts.getColorByAttr(context, i));
        clickableElement.setOnClickListener(function0);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public Button findButton(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findButton");
        return TfaSettingsItemView.DefaultImpls.findButton(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ClickableElement findClickableElement(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
        return TfaSettingsItemView.DefaultImpls.findClickableElement(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public InfoBlock findInfoBlock(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
        return TfaSettingsItemView.DefaultImpls.findInfoBlock(this, view, i);
    }

    @NotNull
    public final View getView() {
        return this.u;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        TfaSettingsItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    public void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
        TfaSettingsItemView.DefaultImpls.setIcon(this, infoBlock, drawable);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public View withCardPaddings(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
        return TfaSettingsItemView.DefaultImpls.withCardPaddings(this, view);
    }
}

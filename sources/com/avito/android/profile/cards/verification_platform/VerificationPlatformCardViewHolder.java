package com.avito.android.profile.cards.verification_platform;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.component.info_block.InfoBlockImpl;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.verification_platform.VerificationPlatformCardView;
import com.avito.android.util.Contexts;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010(\u001a\n \u0019*\u0004\u0018\u00010%0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/avito/android/profile/cards/verification_platform/VerificationPlatformCardViewHolder;", "Lcom/avito/android/profile/cards/verification_platform/VerificationPlatformCardView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAction", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "removeAllStatuses", "()V", "message", "", "iconRes", "iconTintRes", "addStatusInfo", "(Ljava/lang/String;II)V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "titleView", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "w", "Landroid/view/LayoutInflater;", "inflater", "Lru/avito/component/button/Button;", "u", "Lru/avito/component/button/Button;", "actionView", "Landroid/view/ViewGroup;", "s", "Landroid/view/ViewGroup;", "statusesContainer", "Landroid/content/Context;", VKApiConst.VERSION, "Landroid/content/Context;", "context", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationPlatformCardViewHolder extends BaseViewHolder implements VerificationPlatformCardView {
    public final ViewGroup s;
    public final TextView t;
    public final Button u;
    public final Context v;
    public final LayoutInflater w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerificationPlatformCardViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.verification_statuses_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…ation_statuses_container)");
        this.s = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.verification_card_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.….verification_card_title)");
        this.t = (TextView) findViewById2;
        this.u = findButton(view, R.id.verification_action_button);
        Context context = view.getContext();
        this.v = context;
        this.w = LayoutInflater.from(context);
    }

    @Override // com.avito.android.profile.cards.verification_platform.VerificationPlatformCardView
    public void addStatusInfo(@NotNull String str, @AttrRes int i, @AttrRes int i2) {
        Intrinsics.checkNotNullParameter(str, "message");
        View inflate = this.w.inflate(com.avito.android.ui_components.R.layout.info_block, this.s, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(\n      …          false\n        )");
        View withCardPaddings = withCardPaddings(inflate);
        this.s.addView(withCardPaddings);
        InfoBlockImpl infoBlockImpl = new InfoBlockImpl(withCardPaddings);
        infoBlockImpl.setText(str);
        Context context = this.v;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setIcon(infoBlockImpl, Contexts.getDrawableByAttr(context, i));
        Context context2 = this.v;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        infoBlockImpl.setIconTintColor(Contexts.getColorStateListByAttr(context2, i2));
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public Button findButton(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findButton");
        return VerificationPlatformCardView.DefaultImpls.findButton(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ClickableElement findClickableElement(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
        return VerificationPlatformCardView.DefaultImpls.findClickableElement(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public InfoBlock findInfoBlock(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
        return VerificationPlatformCardView.DefaultImpls.findInfoBlock(this, view, i);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        VerificationPlatformCardView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.profile.cards.verification_platform.VerificationPlatformCardView
    public void removeAllStatuses() {
        this.s.removeAllViews();
    }

    @Override // com.avito.android.profile.cards.verification_platform.VerificationPlatformCardView
    public void setAction(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.setText(str);
        this.u.setClickListener(function0);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    public void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
        VerificationPlatformCardView.DefaultImpls.setIcon(this, infoBlock, drawable);
    }

    @Override // com.avito.android.profile.cards.verification_platform.VerificationPlatformCardView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setText(str);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public View withCardPaddings(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
        return VerificationPlatformCardView.DefaultImpls.withCardPaddings(this, view);
    }
}

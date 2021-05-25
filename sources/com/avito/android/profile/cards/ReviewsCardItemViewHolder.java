package com.avito.android.profile.cards;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.ReviewsCardItemView;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0007J\u001d\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/avito/android/profile/cards/ReviewsCardItemViewHolder;", "Lcom/avito/android/profile/cards/ReviewsCardItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "bindCardTitle", "(Ljava/lang/String;)V", "reviews", "bindReviewsText", "setActionButtonTitle", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "Lru/avito/component/button/Button;", VKApiConst.VERSION, "Lru/avito/component/button/Button;", "actionButtonView", "Lcom/avito/android/component/info_block/InfoBlock;", "u", "Lcom/avito/android/component/info_block/InfoBlock;", "reviewsView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewsCardItemViewHolder extends BaseViewHolder implements ReviewsCardItemView {
    public final Context s;
    public final TextView t;
    public final InfoBlock u;
    public final Button v;

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
    public ReviewsCardItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Context context = view.getContext();
        this.s = context;
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title)");
        this.t = (TextView) findViewById;
        InfoBlock findInfoBlock = findInfoBlock(view, R.id.reviews);
        Drawable drawable = context.getDrawable(com.avito.android.ui_components.R.drawable.ic_review_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setIcon(findInfoBlock, Contexts.getTintedDrawable(drawable, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28)));
        Unit unit = Unit.INSTANCE;
        this.u = findInfoBlock;
        this.v = findButton(view, R.id.action_button);
    }

    @Override // com.avito.android.profile.cards.ReviewsCardItemView
    public void bindCardTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.profile.cards.ReviewsCardItemView
    public void bindReviewsText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reviews");
        this.u.bindText(str);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public Button findButton(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findButton");
        return ReviewsCardItemView.DefaultImpls.findButton(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ClickableElement findClickableElement(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
        return ReviewsCardItemView.DefaultImpls.findClickableElement(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public InfoBlock findInfoBlock(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
        return ReviewsCardItemView.DefaultImpls.findInfoBlock(this, view, i);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ReviewsCardItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.profile.cards.ReviewsCardItemView
    public void setActionButtonTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.v.setText(str);
    }

    @Override // com.avito.android.profile.cards.ReviewsCardItemView
    public void setActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v.setClickListener(new a(function0));
    }

    @Override // com.avito.android.profile.cards.CardItemView
    public void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
        ReviewsCardItemView.DefaultImpls.setIcon(this, infoBlock, drawable);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public View withCardPaddings(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
        return ReviewsCardItemView.DefaultImpls.withCardPaddings(this, view);
    }
}

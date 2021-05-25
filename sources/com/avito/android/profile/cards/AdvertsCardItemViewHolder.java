package com.avito.android.profile.cards;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.AdvertsCardItemView;
import com.avito.android.util.Contexts;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/avito/android/profile/cards/AdvertsCardItemViewHolder;", "Lcom/avito/android/profile/cards/AdvertsCardItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "active", "", "bindActiveAdvertsText", "(Ljava/lang/String;)V", "inactive", "bindInactiveAdvertsText", "rejected", "bindRejectedAdvertsText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/component/info_block/InfoBlock;", VKApiConst.VERSION, "Lcom/avito/android/component/info_block/InfoBlock;", "rejectedView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "t", "activeView", "u", "inactiveView", "Lru/avito/component/button/Button;", "w", "Lru/avito/component/button/Button;", "actionButtonView", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertsCardItemViewHolder extends BaseViewHolder implements AdvertsCardItemView {
    public final Context s;
    public final InfoBlock t;
    public final InfoBlock u;
    public final InfoBlock v;
    public final Button w;

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
    public AdvertsCardItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Context context = view.getContext();
        this.s = context;
        InfoBlock findInfoBlock = findInfoBlock(view, R.id.active);
        Drawable drawable = context.getDrawable(com.avito.android.deprecated_design.R.drawable.ic_item_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setIcon(findInfoBlock, Contexts.getTintedDrawable(drawable, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28)));
        Unit unit = Unit.INSTANCE;
        this.t = findInfoBlock;
        InfoBlock findInfoBlock2 = findInfoBlock(view, R.id.inactive);
        int i = com.avito.android.ui_components.R.drawable.ic_error_24;
        Drawable drawable2 = context.getDrawable(i);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int i2 = com.avito.android.lib.design.R.attr.red;
        setIcon(findInfoBlock2, Contexts.getTintedDrawable(drawable2, Contexts.getColorByAttr(context, i2)));
        this.u = findInfoBlock2;
        InfoBlock findInfoBlock3 = findInfoBlock(view, R.id.rejected);
        Drawable drawable3 = context.getDrawable(i);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setIcon(findInfoBlock3, Contexts.getTintedDrawable(drawable3, Contexts.getColorByAttr(context, i2)));
        this.v = findInfoBlock3;
        Button findButton = findButton(view, R.id.show_adverts);
        findButton.setText(R.string.show_adverts);
        this.w = findButton;
    }

    @Override // com.avito.android.profile.cards.AdvertsCardItemView
    public void bindActiveAdvertsText(@Nullable String str) {
        this.t.bindText(str);
    }

    @Override // com.avito.android.profile.cards.AdvertsCardItemView
    public void bindInactiveAdvertsText(@Nullable String str) {
        this.u.bindText(str);
    }

    @Override // com.avito.android.profile.cards.AdvertsCardItemView
    public void bindRejectedAdvertsText(@Nullable String str) {
        this.v.bindText(str);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public Button findButton(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findButton");
        return AdvertsCardItemView.DefaultImpls.findButton(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ClickableElement findClickableElement(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
        return AdvertsCardItemView.DefaultImpls.findClickableElement(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public InfoBlock findInfoBlock(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
        return AdvertsCardItemView.DefaultImpls.findInfoBlock(this, view, i);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AdvertsCardItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.profile.cards.AdvertsCardItemView
    public void setActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w.setClickListener(new a(function0));
    }

    @Override // com.avito.android.profile.cards.CardItemView
    public void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
        AdvertsCardItemView.DefaultImpls.setIcon(this, infoBlock, drawable);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public View withCardPaddings(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
        return AdvertsCardItemView.DefaultImpls.withCardPaddings(this, view);
    }
}

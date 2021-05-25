package com.avito.android.profile.cards;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.SubscriptionCardItemView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u00103\u001a\u00020&\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b4\u00105J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\f\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u001d\u0010\u0016\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010.\u001a\n +*\u0004\u0018\u00010*0*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/avito/android/profile/cards/SubscriptionCardItemViewHolder;", "Lcom/avito/android/profile/cards/SubscriptionCardItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "setSubscriptionActive", "()V", "setSubscriptionInactive", "", "title", "setSubscriptionTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubscriptionSubtitle", "Lcom/avito/android/remote/model/text/AttributedText;", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "showSubscriptionAction", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "hideSubscriptionAction", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "titleView", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "iconView", VKApiConst.VERSION, "subtitleView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "y", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/view/View;", "w", "Landroid/view/View;", "actionButtonView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "Lru/avito/component/button/Button;", "x", "Lru/avito/component/button/Button;", "actionTextView", "rootView", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriptionCardItemViewHolder extends BaseViewHolder implements SubscriptionCardItemView {
    public final Context s;
    public final ImageView t;
    public final TextView u;
    public final TextView v;
    public final View w;
    public final Button x;
    public final AttributedTextFormatter y;

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
    public SubscriptionCardItemViewHolder(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.y = attributedTextFormatter;
        this.s = view.getContext();
        View findViewById = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.t = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.action_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.w = findViewById4;
        this.x = findButton(view, R.id.action_text);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public Button findButton(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findButton");
        return SubscriptionCardItemView.DefaultImpls.findButton(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ClickableElement findClickableElement(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
        return SubscriptionCardItemView.DefaultImpls.findClickableElement(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public InfoBlock findInfoBlock(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
        return SubscriptionCardItemView.DefaultImpls.findInfoBlock(this, view, i);
    }

    @Override // com.avito.android.profile.cards.SubscriptionCardItemView
    public void hideSubscriptionAction() {
        Views.hide(this.w);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SubscriptionCardItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.profile.cards.SubscriptionCardItemView
    public void setActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x.setClickListener(new a(function0));
    }

    @Override // com.avito.android.profile.cards.CardItemView
    public void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
        SubscriptionCardItemView.DefaultImpls.setIcon(this, infoBlock, drawable);
    }

    @Override // com.avito.android.profile.cards.SubscriptionCardItemView
    public void setSubscriptionActive() {
        this.t.setImageResource(com.avito.android.ui_components.R.drawable.ic_subscribe_24);
        ImageView imageView = this.t;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setColorFilter(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28));
    }

    @Override // com.avito.android.profile.cards.SubscriptionCardItemView
    public void setSubscriptionInactive() {
        this.t.setImageResource(com.avito.android.ui_components.R.drawable.ic_error_24);
        ImageView imageView = this.t;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setColorFilter(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.red));
    }

    @Override // com.avito.android.profile.cards.SubscriptionCardItemView
    public void setSubscriptionSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.v, str, false, 2, null);
    }

    @Override // com.avito.android.profile.cards.SubscriptionCardItemView
    public void setSubscriptionTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.profile.cards.SubscriptionCardItemView
    public void showSubscriptionAction(@NotNull String str, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Views.show(this.w);
        this.x.setText(str);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public View withCardPaddings(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
        return SubscriptionCardItemView.DefaultImpls.withCardPaddings(this, view);
    }

    @Override // com.avito.android.profile.cards.SubscriptionCardItemView
    public void setSubscriptionSubtitle(@Nullable AttributedText attributedText) {
        TextView textView = this.v;
        AttributedTextFormatter attributedTextFormatter = this.y;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
    }
}

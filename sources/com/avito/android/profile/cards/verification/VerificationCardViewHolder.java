package com.avito.android.profile.cards.verification;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.alert_banner.AlertBannerContent;
import com.avito.android.lib.design.button.Button;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.verification.VerificationCardView;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010:\u001a\u000207¢\u0006\u0004\bC\u0010DJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJI\u0010#\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u001dR\u001e\u0010*\u001a\n '*\u0004\u0018\u00010&0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00102\u001a\n '*\u0004\u0018\u00010/0/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010-¨\u0006E"}, d2 = {"Lcom/avito/android/profile/cards/verification/VerificationCardViewHolder;", "Lcom/avito/android/profile/cards/verification/VerificationCardView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "visible", "", "setBannerVisibility", "(Z)V", "", "title", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", ErrorBundle.DETAIL_ENTRY, "setBannerTexts", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/avito/android/remote/model/text/AttributedText;)V", "", "iconRes", "iconTint", "setBannerIcon", "(II)V", "backgroundTint", "setBannerBackgroundTint", "(I)V", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "removeVerificationWays", "()V", "buttonText", "buttonStyleAttr", "buttonEnabled", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addVerificationWay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLkotlin/jvm/functions/Function0;)V", "onUnbind", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "t", "Landroid/view/LayoutInflater;", "inflater", "Landroid/widget/TextView;", "w", "Landroid/widget/TextView;", "descriptionView", "Landroid/content/Context;", "s", "Landroid/content/Context;", "context", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "u", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "banner", "Lcom/avito/android/util/text/AttributedTextFormatter;", "y", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/view/ViewGroup;", "x", "Landroid/view/ViewGroup;", "verificationWaysContainerView", VKApiConst.VERSION, "titleView", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationCardViewHolder extends BaseViewHolder implements VerificationCardView {
    public final Context s;
    public final LayoutInflater t;
    public final AlertBanner u;
    public final TextView v;
    public final TextView w;
    public final ViewGroup x;
    public final AttributedTextFormatter y;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(String str, int i, boolean z, Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerificationCardViewHolder(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.y = attributedTextFormatter;
        Context context = view.getContext();
        this.s = context;
        this.t = LayoutInflater.from(context);
        View findViewById = view.findViewById(R.id.verification_banner);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.alert_banner.AlertBanner");
        this.u = (AlertBanner) findViewById;
        View findViewById2 = view.findViewById(R.id.verification_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.verification_description);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.verification_ways_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.ViewGroup");
        this.x = (ViewGroup) findViewById4;
    }

    @Override // com.avito.android.profile.cards.verification.VerificationCardView
    public void addVerificationWay(@Nullable String str, @Nullable String str2, @NotNull String str3, int i, boolean z, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str3, "buttonText");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        View inflate = this.t.inflate(R.layout.user_profile_verification_item, this.x, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(\n      …      false\n            )");
        View withCardPaddings = withCardPaddings(inflate);
        View findViewById = withCardPaddings.findViewById(R.id.verification_item_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextViews.bindText$default((TextView) findViewById, str, false, 2, null);
        View findViewById2 = withCardPaddings.findViewById(R.id.verification_item_description);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextViews.bindText$default((TextView) findViewById2, str2, false, 2, null);
        View findViewById3 = withCardPaddings.findViewById(R.id.verification_item_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById3;
        button.setText(str3);
        button.setAppearanceFromAttr(i);
        button.setEnabled(z);
        button.setOnClickListener(new a(str3, i, z, function0));
        this.x.addView(withCardPaddings);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ru.avito.component.button.Button findButton(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findButton");
        return VerificationCardView.DefaultImpls.findButton(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ClickableElement findClickableElement(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
        return VerificationCardView.DefaultImpls.findClickableElement(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public InfoBlock findInfoBlock(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
        return VerificationCardView.DefaultImpls.findInfoBlock(this, view, i);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        removeVerificationWays();
    }

    @Override // com.avito.android.profile.cards.verification.VerificationCardView
    public void removeVerificationWays() {
        this.x.removeAllViews();
    }

    @Override // com.avito.android.profile.cards.verification.VerificationCardView
    public void setBannerBackgroundTint(int i) {
        AlertBanner alertBanner = this.u;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        alertBanner.setBackgroundTintList(Contexts.getColorStateListByAttr(context, i));
    }

    @Override // com.avito.android.profile.cards.verification.VerificationCardView
    public void setBannerIcon(int i, int i2) {
        this.u.getContent().setImageDrawable(ContextCompat.getDrawable(this.s, i));
        AlertBannerContent content = this.u.getContent();
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        content.setImageTint(Contexts.getColorStateListByAttr(context, i2));
    }

    @Override // com.avito.android.profile.cards.verification.VerificationCardView
    public void setBannerTexts(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable AttributedText attributedText) {
        CharSequence charSequence3;
        this.u.getContent().setTitle(charSequence);
        this.u.getContent().setBody(charSequence2);
        AlertBannerContent content = this.u.getContent();
        if (attributedText != null) {
            AttributedTextFormatter attributedTextFormatter = this.y;
            Context context = this.s;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            charSequence3 = attributedTextFormatter.format(context, attributedText);
        } else {
            charSequence3 = null;
        }
        AlertBannerContent.setLink$default(content, charSequence3, null, 2, null);
    }

    @Override // com.avito.android.profile.cards.verification.VerificationCardView
    public void setBannerVisibility(boolean z) {
        Views.setVisible(this.u, z);
    }

    @Override // com.avito.android.profile.cards.verification.VerificationCardView
    public void setDescription(@Nullable String str) {
        TextViews.bindText$default(this.w, str, false, 2, null);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    public void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
        VerificationCardView.DefaultImpls.setIcon(this, infoBlock, drawable);
    }

    @Override // com.avito.android.profile.cards.verification.VerificationCardView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.v.setText(str);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public View withCardPaddings(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
        return VerificationCardView.DefaultImpls.withCardPaddings(this, view);
    }
}

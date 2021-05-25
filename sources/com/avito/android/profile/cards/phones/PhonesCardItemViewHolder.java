package com.avito.android.profile.cards.phones;

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
import com.avito.android.component.info_block.InfoBlockImpl;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.phones.PhonesCardItemView;
import com.avito.android.util.Contexts;
import com.avito.konveyor.adapter.BaseViewHolder;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010$\u001a\n !*\u0004\u0018\u00010 0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010(\u001a\n !*\u0004\u0018\u00010%0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001a¨\u0006/"}, d2 = {"Lcom/avito/android/profile/cards/phones/PhonesCardItemViewHolder;", "Lcom/avito/android/profile/cards/phones/PhonesCardItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "removePhones", "()V", "", "phone", "", "verified", "locked", "addPhone", "(Ljava/lang/String;ZZ)V", "text", "addMorePhonesView", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "Lru/avito/component/button/Button;", VKApiConst.VERSION, "Lru/avito/component/button/Button;", "actionButtonView", "Landroid/graphics/drawable/Drawable;", "x", "Landroid/graphics/drawable/Drawable;", "problemPhoneIcon", "Landroid/view/ViewGroup;", "u", "Landroid/view/ViewGroup;", "phonesContainerView", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "t", "Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "s", "Landroid/content/Context;", "context", "w", "verifiedPhoneIcon", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesCardItemViewHolder extends BaseViewHolder implements PhonesCardItemView {
    public final Context s;
    public final LayoutInflater t;
    public final ViewGroup u;
    public final Button v;
    public final Drawable w;
    public final Drawable x;

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
    public PhonesCardItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Context context = view.getContext();
        this.s = context;
        this.t = LayoutInflater.from(context);
        View findViewById = view.findViewById(R.id.phones_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.u = (ViewGroup) findViewById;
        Button findButton = findButton(view, R.id.phones_action_button);
        findButton.setText(R.string.phone_action_manage);
        Unit unit = Unit.INSTANCE;
        this.v = findButton;
        Drawable drawable = ContextCompat.getDrawable(context, com.avito.android.ui_components.R.drawable.ic_call_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.w = Contexts.getTintedDrawable(drawable, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28));
        Drawable drawable2 = ContextCompat.getDrawable(context, com.avito.android.ui_components.R.drawable.ic_error_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.x = Contexts.getTintedDrawable(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.red));
    }

    @Override // com.avito.android.profile.cards.phones.PhonesCardItemView
    public void addMorePhonesView(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        View inflate = this.t.inflate(R.layout.more_phones_item, this.u, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(\n      …      false\n            )");
        View withCardPaddings = withCardPaddings(inflate);
        View findViewById = withCardPaddings.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(str);
        this.u.addView(withCardPaddings);
    }

    @Override // com.avito.android.profile.cards.phones.PhonesCardItemView
    public void addPhone(@NotNull String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "phone");
        View inflate = this.t.inflate(com.avito.android.ui_components.R.layout.info_block, this.u, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(\n      …      false\n            )");
        View withCardPaddings = withCardPaddings(inflate);
        InfoBlockImpl infoBlockImpl = new InfoBlockImpl(withCardPaddings);
        infoBlockImpl.setText(str);
        setIcon(infoBlockImpl, z ? this.w : this.x);
        this.u.addView(withCardPaddings);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public Button findButton(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findButton");
        return PhonesCardItemView.DefaultImpls.findButton(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ClickableElement findClickableElement(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
        return PhonesCardItemView.DefaultImpls.findClickableElement(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public InfoBlock findInfoBlock(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
        return PhonesCardItemView.DefaultImpls.findInfoBlock(this, view, i);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PhonesCardItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.profile.cards.phones.PhonesCardItemView
    public void removePhones() {
        this.u.removeAllViews();
    }

    @Override // com.avito.android.profile.cards.phones.PhonesCardItemView
    public void setActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v.setClickListener(new a(function0));
    }

    @Override // com.avito.android.profile.cards.CardItemView
    public void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
        PhonesCardItemView.DefaultImpls.setIcon(this, infoBlock, drawable);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public View withCardPaddings(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
        return PhonesCardItemView.DefaultImpls.withCardPaddings(this, view);
    }
}

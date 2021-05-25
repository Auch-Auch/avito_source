package com.avito.android.profile.cards.phones;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.clickable_info_block.ClickableInfoBlock;
import com.avito.android.component.clickable_info_block.ProgressClickableInfoBlock;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.phones.PhonesCardItemViewOld;
import com.avito.android.util.Contexts;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001f\u001a\n \u0018*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010&¨\u0006."}, d2 = {"Lcom/avito/android/profile/cards/phones/PhonesCardItemViewHolderOld;", "Lcom/avito/android/profile/cards/phones/PhonesCardItemViewOld;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "removePhones", "()V", "", "phone", "", "verified", "locked", "Lio/reactivex/Observable;", "Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock;", "addPhone", "(Ljava/lang/String;ZZ)Lio/reactivex/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/ViewGroup;", "u", "Landroid/view/ViewGroup;", "phonesContainerView", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "t", "Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "s", "Landroid/content/Context;", "context", "Lru/avito/component/button/Button;", VKApiConst.VERSION, "Lru/avito/component/button/Button;", "actionButtonView", "Landroid/graphics/drawable/Drawable;", "w", "Landroid/graphics/drawable/Drawable;", "verifiedPhoneIcon", "x", "problemPhoneIcon", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesCardItemViewHolderOld extends BaseViewHolder implements PhonesCardItemViewOld {
    public final Context s;
    public final LayoutInflater t;
    public final ViewGroup u;
    public final Button v;
    public final Drawable w;
    public final Drawable x;

    public static final class a<T, R> implements Function<Unit, ClickableInfoBlock> {
        public final /* synthetic */ ProgressClickableInfoBlock a;

        public a(ProgressClickableInfoBlock progressClickableInfoBlock) {
            this.a = progressClickableInfoBlock;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ClickableInfoBlock apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function0 function0) {
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
    public PhonesCardItemViewHolderOld(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Context context = view.getContext();
        this.s = context;
        this.t = LayoutInflater.from(context);
        View findViewById = view.findViewById(R.id.phones_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.u = (ViewGroup) findViewById;
        Button findButton = findButton(view, R.id.phones_action_button);
        findButton.setText(R.string.phone_action_attach);
        Unit unit = Unit.INSTANCE;
        this.v = findButton;
        Drawable drawable = context.getDrawable(com.avito.android.ui_components.R.drawable.ic_call_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.w = Contexts.getTintedDrawable(drawable, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28));
        Drawable drawable2 = context.getDrawable(com.avito.android.ui_components.R.drawable.ic_error_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.x = Contexts.getTintedDrawable(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.red));
    }

    @Override // com.avito.android.profile.cards.phones.PhonesCardItemViewOld
    @NotNull
    public Observable<ClickableInfoBlock> addPhone(@NotNull String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "phone");
        View inflate = this.t.inflate(com.avito.android.ui_components.R.layout.progress_clickable_info_block, this.u, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(ui_R.la…onesContainerView, false)");
        View withCardPaddings = withCardPaddings(inflate);
        ProgressClickableInfoBlock progressClickableInfoBlock = new ProgressClickableInfoBlock(withCardPaddings, null, 2, null);
        progressClickableInfoBlock.setText(str);
        setIcon(progressClickableInfoBlock, z ? this.w : this.x);
        progressClickableInfoBlock.setEnabled(!z2);
        this.u.addView(withCardPaddings);
        Observable<ClickableInfoBlock> map = InteropKt.toV2(progressClickableInfoBlock.clicks()).map(new a(progressClickableInfoBlock));
        Intrinsics.checkNotNullExpressionValue(map, "infoBlock.clicks().toV2().map { infoBlock }");
        return map;
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public Button findButton(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findButton");
        return PhonesCardItemViewOld.DefaultImpls.findButton(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public ClickableElement findClickableElement(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
        return PhonesCardItemViewOld.DefaultImpls.findClickableElement(this, view, i);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public InfoBlock findInfoBlock(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
        return PhonesCardItemViewOld.DefaultImpls.findInfoBlock(this, view, i);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PhonesCardItemViewOld.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.profile.cards.phones.PhonesCardItemViewOld
    public void removePhones() {
        this.u.removeAllViews();
    }

    @Override // com.avito.android.profile.cards.phones.PhonesCardItemViewOld
    public void setActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v.setClickListener(new b(function0));
    }

    @Override // com.avito.android.profile.cards.CardItemView
    public void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
        PhonesCardItemViewOld.DefaultImpls.setIcon(this, infoBlock, drawable);
    }

    @Override // com.avito.android.profile.cards.CardItemView
    @NotNull
    public View withCardPaddings(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
        return PhonesCardItemViewOld.DefaultImpls.withCardPaddings(this, view);
    }
}

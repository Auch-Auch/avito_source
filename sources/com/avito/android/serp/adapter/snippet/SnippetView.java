package com.avito.android.serp.adapter.snippet;

import android.view.View;
import androidx.annotation.DrawableRes;
import com.avito.android.component.banner_card.BannerCard;
import com.avito.android.component.banner_card.BannerCardImpl;
import com.avito.android.image_loader.Picture;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tJ#\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/serp/adapter/snippet/SnippetView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/component/banner_card/BannerCard;", "Lkotlin/Function1;", "", "", "callback", "setOnVisibleCallback", "(Lkotlin/jvm/functions/Function1;)V", "Impl", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SnippetView extends ItemView, BannerCard {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SnippetView snippetView) {
            ItemView.DefaultImpls.onUnbind(snippetView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\f\u0010\u0006J\u001e\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0017\u001a\u00020\u00042\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001b\u0010\u001fJ\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b\"\u0010#R$\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/avito/android/serp/adapter/snippet/SnippetView$Impl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/serp/adapter/snippet/SnippetView;", "Lcom/avito/android/component/banner_card/BannerCard;", "", "onUnbind", "()V", "Lkotlin/Function1;", "", "callback", "setOnVisibleCallback", "(Lkotlin/jvm/functions/Function1;)V", "clearActionListeners", "", "Lcom/avito/android/component/banner_card/BannerCard$Action;", "actions", "setActions", "(Ljava/util/List;)V", "visible", "setCloseButtonVisible", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCloseClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setImage", "(Lcom/avito/android/image_loader/Picture;)V", "", "drawableRes", "(I)V", "", "message", "setMessage", "(Ljava/lang/CharSequence;)V", "s", "Lkotlin/jvm/functions/Function1;", "visibleCallback", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements SnippetView, BannerCard {
        public Function1<? super Boolean, Unit> s;
        public final /* synthetic */ BannerCardImpl t;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.t = new BannerCardImpl(view);
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) { // from class: com.avito.android.serp.adapter.snippet.SnippetView.Impl.1
                public final /* synthetic */ Impl a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view2) {
                    Intrinsics.checkNotNullParameter(view2, VKApiConst.VERSION);
                    Function1 function1 = this.a.s;
                    if (function1 != null) {
                        Unit unit = (Unit) function1.invoke(Boolean.TRUE);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view2) {
                    Intrinsics.checkNotNullParameter(view2, VKApiConst.VERSION);
                    Function1 function1 = this.a.s;
                    if (function1 != null) {
                        Unit unit = (Unit) function1.invoke(Boolean.FALSE);
                    }
                }
            });
        }

        @Override // com.avito.android.component.banner_card.BannerCard
        public void clearActionListeners() {
            this.t.clearActionListeners();
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            this.s = null;
            clearActionListeners();
            setCloseClickListener(null);
        }

        @Override // com.avito.android.component.banner_card.BannerCard
        public void setActions(@NotNull List<BannerCard.Action> list) {
            Intrinsics.checkNotNullParameter(list, "actions");
            this.t.setActions(list);
        }

        @Override // com.avito.android.component.banner_card.BannerCard
        public void setCloseButtonVisible(boolean z) {
            this.t.setCloseButtonVisible(z);
        }

        @Override // com.avito.android.component.banner_card.BannerCard
        public void setCloseClickListener(@Nullable Function0<Unit> function0) {
            this.t.setCloseClickListener(function0);
        }

        @Override // com.avito.android.component.banner_card.BannerCard
        public void setImage(@DrawableRes int i) {
            this.t.setImage(i);
        }

        @Override // com.avito.android.component.banner_card.BannerCard
        public void setImage(@Nullable Picture picture) {
            this.t.setImage(picture);
        }

        @Override // com.avito.android.component.banner_card.BannerCard
        public void setMessage(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "message");
            this.t.setMessage(charSequence);
        }

        @Override // com.avito.android.serp.adapter.snippet.SnippetView
        public void setOnVisibleCallback(@NotNull Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "callback");
            this.s = function1;
        }
    }

    void setOnVisibleCallback(@NotNull Function1<? super Boolean, Unit> function1);
}

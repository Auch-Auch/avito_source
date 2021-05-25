package com.avito.android.serp.adapter;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.avito.android.image_loader.Picture;
import com.avito.android.serp.BaseSerpViewHolder;
import com.avito.android.serp.adapter.ShortcutBannerItemView;
import com.avito.android.serp_core.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010(\u001a\u00020\u001c¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00052\b\b\u0001\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0007J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001a¨\u0006+"}, d2 = {"Lcom/avito/android/serp/adapter/ShortcutBannerItemViewImpl;", "Lcom/avito/android/serp/adapter/ShortcutBannerItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "", "widthPx", "", "setShortcutWidth", "(I)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setLeftImage", "(Lcom/avito/android/image_loader/Picture;)V", "setRightImage", "color", "setBackground", "setImage", "Lcom/facebook/drawee/view/SimpleDraweeView;", "u", "Lcom/facebook/drawee/view/SimpleDraweeView;", "rightImage", "Landroid/view/View;", "s", "Landroid/view/View;", "container", VKApiConst.VERSION, "imageView", "Landroid/widget/TextView;", "w", "Landroid/widget/TextView;", "title", "t", "leftImage", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutBannerItemViewImpl extends BaseSerpViewHolder implements ShortcutBannerItemView {
    public final View s;
    public final SimpleDraweeView t;
    public final SimpleDraweeView u;
    public final SimpleDraweeView v;
    public final TextView w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortcutBannerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = findViewById;
        View findViewById2 = view.findViewById(R.id.left_image);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.t = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.right_image);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.u = (SimpleDraweeView) findViewById3;
        View findViewById4 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.v = (SimpleDraweeView) findViewById4;
        View findViewById5 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById5;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ShortcutBannerItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemView
    public void setBackground(@ColorInt int i) {
        SimpleDraweeViewsKt.getRequestBuilder(this.v).drawable(new ColorDrawable(i)).load();
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemView
    public void setImage(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a2.b.a.a.a.L0(this.v, picture);
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemView
    public void setLeftImage(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a2.b.a.a.a.L0(this.t, picture);
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemView
    public void setRightImage(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a2.b.a.a.a.L0(this.u, picture);
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemView
    public void setShortcutWidth(int i) {
        this.s.getLayoutParams().width = i;
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemView
    public void setTitle(@Nullable String str) {
        TextViews.bindText$default(this.w, str, false, 2, null);
    }
}

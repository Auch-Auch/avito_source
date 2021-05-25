package ru.avito.component.serp.cyclic_gallery.image_carousel;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.avito.android.design.widget.RatioLinearLayout;
import com.avito.android.design.widget.circular_progress.CircularProgressDrawable;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.PhoneLoadingState;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b4\u00105J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\n2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001d\u00100\u001a\u00020,8B@\u0002X\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b\u001b\u0010/R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActionItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActionItemView;", "", "title", "", "icon", "background", "Lru/avito/component/serp/PhoneLoadingState;", "loadingState", "", "setData", "(Ljava/lang/String;IILru/avito/component/serp/PhoneLoadingState;)V", "", "widthRatio", "setWidthRatio", "(F)V", "Lio/reactivex/rxjava3/core/Observable;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "y", "Landroid/view/View;", "view", "Landroid/widget/ImageButton;", "u", "Landroid/widget/ImageButton;", "iconView", "w", "Ljava/lang/Float;", "Lcom/avito/android/design/widget/RatioLinearLayout;", "s", "Lcom/avito/android/design/widget/RatioLinearLayout;", "ratioContainer", "Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", VKApiConst.VERSION, "Lkotlin/Lazy;", "()Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", "loadingDrawable", "x", "Lkotlin/jvm/functions/Function0;", "unbindListener", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselActionItemViewImpl extends BaseViewHolder implements CarouselActionItemView {
    public final RatioLinearLayout s;
    public final TextView t;
    public final ImageButton u;
    public final Lazy v = c.lazy(new a(this));
    public Float w;
    public Function0<Unit> x;
    public final View y;

    public static final class a extends Lambda implements Function0<CircularProgressDrawable> {
        public final /* synthetic */ CarouselActionItemViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CarouselActionItemViewImpl carouselActionItemViewImpl) {
            super(0);
            this.a = carouselActionItemViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public CircularProgressDrawable invoke() {
            Context context = this.a.y.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            CircularProgressDrawable build = new CircularProgressDrawable.Builder(context, false, 2, null).build();
            build.setSize(Views.dpToPx(this.a.y, 20));
            return build;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselActionItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.y = view;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.design.widget.RatioLinearLayout");
        this.s = (RatioLinearLayout) view;
        View findViewById = view.findViewById(R.id.action_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.action_title)");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.icon)");
        this.u = (ImageButton) findViewById2;
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActionItemView
    @NotNull
    public Observable<Unit> clicks() {
        return RxView.clicks(this.y);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.x;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActionItemView
    public void setData(@NotNull String str, int i, int i2, @NotNull PhoneLoadingState phoneLoadingState) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(phoneLoadingState, "loadingState");
        this.y.setEnabled(phoneLoadingState == PhoneLoadingState.IDLE);
        this.t.setText(str);
        Views.setBackgroundCompat(this.u, this.y.getContext().getDrawable(i2));
        if (phoneLoadingState == PhoneLoadingState.LOADING) {
            this.u.setImageDrawable(t());
            t().start();
            return;
        }
        this.u.setImageResource(i);
        t().stop();
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActionItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.x = function0;
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActionItemView
    public void setWidthRatio(float f) {
        if (!Intrinsics.areEqual(this.w, f)) {
            this.s.setRatio(f);
            this.s.requestLayout();
            this.w = Float.valueOf(f);
        }
    }

    public final CircularProgressDrawable t() {
        return (CircularProgressDrawable) this.v.getValue();
    }
}

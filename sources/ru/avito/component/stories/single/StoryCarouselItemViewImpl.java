package ru.avito.component.stories.single;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;
import com.avito.android.design.widget.RatioFrameLayout;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.Color;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b6\u00107J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00052\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010#R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lru/avito/component/stories/single/StoryCarouselItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/stories/single/StoryCarouselItemView;", "", "widthRatio", "", "setWidthRatio", "(F)V", "Lcom/avito/android/remote/model/Color;", "backgroundColor", "Lcom/avito/android/image_loader/Picture;", "image", "setImage", "(Lcom/avito/android/remote/model/Color;Lcom/avito/android/image_loader/Picture;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "", "isViewed", "setViewed", "(Z)V", "Lio/reactivex/rxjava3/core/Observable;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "w", "Ljava/lang/Float;", "Landroid/view/View;", "y", "Landroid/view/View;", "view", VKApiConst.VERSION, "viewedDot", "x", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "titleView", "Lcom/avito/android/design/widget/RatioFrameLayout;", "s", "Lcom/avito/android/design/widget/RatioFrameLayout;", "ratioContainer", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class StoryCarouselItemViewImpl extends BaseViewHolder implements StoryCarouselItemView {
    public final RatioFrameLayout s;
    public final SimpleDraweeView t;
    public final TextView u;
    public final View v;
    public Float w;
    public Function0<Unit> x;
    public final View y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryCarouselItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.y = view;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        context.getResources();
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.design.widget.RatioFrameLayout");
        this.s = (RatioFrameLayout) view;
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.t = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.text);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.viewed_dot);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.v = findViewById3;
    }

    @Override // ru.avito.component.stories.single.StoryCarouselItemView
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

    @Override // ru.avito.component.stories.single.StoryCarouselItemView
    public void setImage(@NotNull Color color, @Nullable Picture picture) {
        Intrinsics.checkNotNullParameter(color, "backgroundColor");
        ColorDrawable colorDrawable = new ColorDrawable(color.getValue());
        ((GenericDraweeHierarchy) this.t.getHierarchy()).setPlaceholderImage(colorDrawable);
        ((GenericDraweeHierarchy) this.t.getHierarchy()).setFailureImage(colorDrawable);
        SimpleDraweeViewsKt.loadPicture$default(this.t, picture, null, null, 6, null);
    }

    @Override // ru.avito.component.stories.single.StoryCarouselItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.u.setText(str);
    }

    @Override // ru.avito.component.stories.single.StoryCarouselItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.x = function0;
    }

    @Override // ru.avito.component.stories.single.StoryCarouselItemView
    public void setViewed(boolean z) {
        Views.setVisible(this.v, !z);
    }

    @Override // ru.avito.component.stories.single.StoryCarouselItemView
    public void setWidthRatio(float f) {
        if (!Intrinsics.areEqual(this.w, f)) {
            this.s.setRatio(f);
            this.s.requestLayout();
            this.w = Float.valueOf(f);
        }
    }
}

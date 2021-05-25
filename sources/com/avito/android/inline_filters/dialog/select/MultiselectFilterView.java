package com.avito.android.inline_filters.dialog.select;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.lib.design.button.Button;
import com.avito.android.serp_core.R;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010,\u001a\u00020\u0014¢\u0006\u0004\b-\u0010.J)\u0010\u0007\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/MultiselectFilterView;", "Lcom/avito/android/inline_filters/dialog/select/SelectFilterView;", "Lkotlin/Function1;", "", "", "", "applyAction", "setApplyAction", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "items", "setItemsView", "(Ljava/util/List;)V", "text", "setApplyBtnText", "(Ljava/lang/String;)V", "", "visible", "setApplyBtnVisible", "(Z)V", "Landroid/view/View;", "t", "Landroid/view/View;", "applyBtnContainer", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", "applyBtn", "Landroidx/recyclerview/widget/RecyclerView;", "u", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "", VKApiConst.VERSION, "F", "bottomBtnContainerHeight", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", VKApiConst.Q, "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "bottomBtnSpaceDecorator", "Landroid/animation/Animator;", "r", "Landroid/animation/Animator;", "btnAppearsAnimator", "rootView", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class MultiselectFilterView extends SelectFilterView {
    public RecyclerView.ItemDecoration q;
    public Animator r;
    public final Button s;
    public final View t;
    public final RecyclerView u;
    public final float v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function1 a;

        public a(Function1 function1) {
            this.a = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke(CollectionsKt__CollectionsKt.emptyList());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiselectFilterView(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ValueAnimator.ofFloat(0f, 0f)");
        this.r = ofFloat;
        View findViewById = view.findViewById(R.id.apply_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.s = (Button) findViewById;
        View findViewById2 = view.findViewById(R.id.apply_button_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.t = findViewById2;
        View findViewById3 = view.findViewById(R.id.filter_options_recycler_view);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.u = (RecyclerView) findViewById3;
        this.v = a2.b.a.a.a.u1(view, "rootView.context").getDimension(R.dimen.inline_filters_apply_btn_container_height);
        Views.setVisible(findViewById2, true);
    }

    @Override // com.avito.android.inline_filters.dialog.select.SelectFilterView, com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setApplyAction(@NotNull Function1<? super List<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "applyAction");
        this.s.setOnClickListener(new a(function1));
    }

    @Override // com.avito.android.inline_filters.dialog.select.SelectFilterView, com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setApplyBtnText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setText(str);
    }

    @Override // com.avito.android.inline_filters.dialog.select.SelectFilterView, com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setApplyBtnVisible(boolean z) {
        float f;
        this.r.cancel();
        RecyclerView.ItemDecoration itemDecoration = this.q;
        if (itemDecoration != null) {
            this.u.removeItemDecoration(itemDecoration);
        }
        LinearLayoutManager linearLayoutManager = null;
        if (z) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
            shapeDrawable.setIntrinsicHeight((int) this.v);
            Context context = this.u.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "recycler.context");
            shapeDrawable.setTint(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.transparentWhite));
            VerticalListItemDecoration build = new VerticalListItemDecoration.Builder(null, 1, null).drawForLastItem(true).setDividerForItemAt(CollectionsKt__CollectionsKt.getLastIndex(getVisibleItems()), shapeDrawable).build();
            this.q = build;
            RecyclerView recyclerView = this.u;
            Intrinsics.checkNotNull(build);
            recyclerView.addItemDecoration(build);
        }
        RecyclerView.LayoutManager layoutManager = this.u.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = layoutManager;
        }
        LinearLayoutManager linearLayoutManager2 = linearLayoutManager;
        boolean z2 = (linearLayoutManager2 != null && linearLayoutManager2.findLastVisibleItemPosition() == CollectionsKt__CollectionsKt.getLastIndex(getVisibleItems())) && z;
        if (z) {
            f = 0.0f;
        } else {
            f = this.v;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.t.getTranslationY(), f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(z2) { // from class: com.avito.android.inline_filters.dialog.select.MultiselectFilterView$animateTranslation$$inlined$apply$lambda$1
            public Float a;
            public final /* synthetic */ boolean c;

            {
                this.c = r2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NotNull ValueAnimator valueAnimator) {
                Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
                Object animatedValue = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float floatValue = ((Float) animatedValue).floatValue();
                MultiselectFilterView.this.t.setTranslationY(floatValue);
                Float f2 = this.a;
                if (f2 != null) {
                    float floatValue2 = f2.floatValue();
                    if (this.c) {
                        MultiselectFilterView.this.u.scrollBy(0, (int) (floatValue2 - floatValue));
                    }
                }
                this.a = Float.valueOf(floatValue);
            }
        });
        ofFloat.setDuration(150L);
        ofFloat.start();
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ValueAnimator.ofFloat(fr…        start()\n        }");
        this.r = ofFloat;
    }

    @Override // com.avito.android.inline_filters.dialog.select.SelectFilterView, com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setItemsView(@NotNull List<InlineFiltersDialogItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        super.setItemsView(list);
        setApplyBtnVisible(Views.isVisible(this.t));
    }
}

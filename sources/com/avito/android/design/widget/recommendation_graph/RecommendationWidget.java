package com.avito.android.design.widget.recommendation_graph;

import a2.a.a.l0.a.b.d;
import a2.g.r.g;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.design.widget.circular_progress.SimpleAnimatorListener;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010=\u001a\u00020\u000f¢\u0006\u0004\b>\u0010?J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010#R\u0016\u00102\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010&R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00105\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010&R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006@"}, d2 = {"Lcom/avito/android/design/widget/recommendation_graph/RecommendationWidget;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/design/widget/recommendation_graph/GraphData;", "graphData", "", "animate", "", "showData", "(Lcom/avito/android/design/widget/recommendation_graph/GraphData;Z)V", "", VKApiConst.POSITION, "showCurrentValuePointer", "(F)V", "hideCurrentValuePointer", "()V", "", "coord", "Landroid/animation/Animator;", "c", "(I)Landroid/animation/Animator;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "view", AuthSource.SEND_ABUSE, "(Landroid/view/View;)Landroid/animation/Animator;", "", "i", "Ljava/util/List;", "columnAnimations", "Landroid/widget/FrameLayout;", "labelsContainer", "j", "Landroid/animation/Animator;", "medianAnimation", "l", "Landroid/view/View;", "currentValuePointer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "maxLabelView", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "columnsContainer", "f", "F", "graphHeight", "k", "medianPointer", "d", "medianLabelView", "h", "graphLightAlpha", "minLabelView", g.a, "I", "graphColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RecommendationWidget extends FrameLayout {
    public final FrameLayout a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final float f;
    public final int g;
    public final float h;
    public List<Animator> i;
    public Animator j;
    public final View k;
    public final View l;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.setAlpha(((Float) a2.b.a.a.a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Float")).floatValue());
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public b(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view = this.a;
            Intrinsics.checkNotNullExpressionValue(view, "newLightedView");
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            view.setAlpha(((Float) animatedValue).floatValue());
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public c(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view = this.a;
            Intrinsics.checkNotNullExpressionValue(view, "oldLightedView");
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            view.setAlpha(((Float) animatedValue).floatValue());
        }
    }

    @JvmOverloads
    public RecommendationWidget(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public RecommendationWidget(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecommendationWidget(Context context, AttributeSet attributeSet, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static final void access$hideBorderLabels(RecommendationWidget recommendationWidget) {
        Views.hide(recommendationWidget.b);
        Views.hide(recommendationWidget.c);
    }

    public final Animator a(View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(view));
        ofFloat.addListener(new SimpleAnimatorListener(view) { // from class: com.avito.android.design.widget.recommendation_graph.RecommendationWidget$createAlphaInAnimator$2
            public final /* synthetic */ View c;

            {
                this.c = r1;
            }

            @Override // com.avito.android.design.widget.circular_progress.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                super.onAnimationStart(animator);
                Views.show(this.c);
            }
        });
        Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
        ofFloat.setDuration(300L);
        return ofFloat;
    }

    public final Animator b(int i2) {
        View childAt = this.e.getChildAt(i2 / (this.e.getWidth() / this.e.getChildCount()));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, this.h);
        ofFloat.addUpdateListener(new b(childAt));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
        ofFloat.setDuration(300L);
        return ofFloat;
    }

    public final Animator c(int i2) {
        View childAt = this.e.getChildAt(i2 / (this.e.getWidth() / this.e.getChildCount()));
        Intrinsics.checkNotNullExpressionValue(childAt, "oldLightedView");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(childAt.getAlpha(), 1.0f);
        ofFloat.addUpdateListener(new c(childAt));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
        ofFloat.setDuration(300L);
        return ofFloat;
    }

    public final void hideCurrentValuePointer() {
        if (this.l.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            c((this.l.getWidth() / 2) + ((FrameLayout.LayoutParams) layoutParams).leftMargin).start();
            View view = this.l;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.addUpdateListener(new a2.a.a.l0.a.b.a(view));
            ofFloat.addListener(new SimpleAnimatorListener(view) { // from class: com.avito.android.design.widget.recommendation_graph.RecommendationWidget$createAlphaOutAnimator$2
                public final /* synthetic */ View c;

                {
                    this.c = r1;
                }

                @Override // com.avito.android.design.widget.circular_progress.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@NotNull Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animation");
                    super.onAnimationEnd(animator);
                    this.c.setVisibility(8);
                }
            });
            Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
            ofFloat.setDuration(300L);
            ofFloat.start();
        }
    }

    public final void showCurrentValuePointer(float f2) {
        int measuredWidth = (this.e.getMeasuredWidth() - this.e.getPaddingLeft()) - this.e.getPaddingRight();
        int i2 = (int) (((float) measuredWidth) * f2);
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 <= measuredWidth) {
            measuredWidth = i2;
        }
        if (this.l.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ((FrameLayout.LayoutParams) layoutParams).leftMargin = measuredWidth;
            int width = (this.l.getWidth() / 2) + measuredWidth;
            if (width <= this.e.getWidth() && width >= 0) {
                b(width).start();
            }
            a(this.l).start();
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int width2 = (this.l.getWidth() / 2) + ((FrameLayout.LayoutParams) layoutParams2).leftMargin;
        int width3 = (this.l.getWidth() / 2) + measuredWidth;
        int width4 = this.e.getWidth();
        Animator c2 = c(width2);
        if (width3 > width4 || width3 < 0) {
            c2.start();
        } else {
            Animator b2 = b(width3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(c2, b2);
            animatorSet.start();
        }
        View view = this.l;
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        ValueAnimator ofInt = ValueAnimator.ofInt(layoutParams4.leftMargin, measuredWidth);
        ofInt.addUpdateListener(new a2.a.a.l0.a.b.c(layoutParams4, view));
        Intrinsics.checkNotNullExpressionValue(ofInt, "animator");
        ofInt.setDuration(300L);
        ofInt.start();
    }

    public final void showData(@NotNull GraphData graphData, boolean z) {
        int i2;
        Intrinsics.checkNotNullParameter(graphData, "graphData");
        List<Float> columns = graphData.getColumns();
        this.i.clear();
        this.j = null;
        this.e.removeAllViews();
        Iterator<Float> it = columns.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            float floatValue = it.next().floatValue();
            View view = new View(getContext());
            int i3 = (int) (floatValue * this.f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, z ? 0 : i3, 1.0f);
            layoutParams.gravity = 80;
            view.setLayoutParams(layoutParams);
            view.setBackgroundColor(this.g);
            this.e.addView(view);
            if (z) {
                List<Animator> list = this.i;
                ValueAnimator ofInt = ValueAnimator.ofInt(0, i3);
                ofInt.addUpdateListener(new a2.a.a.l0.a.b.b(view));
                Intrinsics.checkNotNullExpressionValue(ofInt, "animator");
                ofInt.setDuration(200L);
                ofInt.addListener(new SimpleAnimatorListener(view) { // from class: com.avito.android.design.widget.recommendation_graph.RecommendationWidget$createGrowthAnimator$2
                    public final /* synthetic */ View c;

                    {
                        this.c = r1;
                    }

                    @Override // com.avito.android.design.widget.circular_progress.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(@NotNull Animator animator) {
                        Intrinsics.checkNotNullParameter(animator, "animation");
                        super.onAnimationStart(animator);
                        this.c.setVisibility(0);
                    }
                });
                list.add(ofInt);
            }
        }
        if (z) {
            Animator a3 = a(this.k);
            a3.setStartDelay((((((long) (this.i.size() - 1)) * 30) + 200) * ((long) 3)) / ((long) 4));
            this.j = a3;
        }
        this.b.setText(graphData.getBorders().getFirst());
        this.c.setText(graphData.getBorders().getSecond());
        String mediumLabel = graphData.getMediumLabel();
        float mediumPosition = graphData.getMediumPosition();
        this.d.setText(mediumLabel);
        this.d.setVisibility(4);
        this.d.post(new d(this, mediumPosition, z));
        if (z) {
            int size = this.i.size();
            for (i2 = 0; i2 < size; i2++) {
                Animator animator = this.i.get(i2);
                animator.setStartDelay(((long) i2) * 30);
                animator.start();
            }
            Animator animator2 = this.j;
            if (animator2 != null) {
                animator2.start();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendationWidget(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.i = new ArrayList();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        float applyDimension = TypedValue.applyDimension(1, 64.0f, resources.getDisplayMetrics());
        int colorByAttr = Contexts.getColorByAttr(context, R.attr.black);
        float f2 = 0.6f;
        if (attributeSet != null) {
            Resources.Theme theme = context.getTheme();
            TypedArray obtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, com.avito.android.ui_components.R.styleable.RecommendationWidget, i2, 0) : null;
            this.f = obtainStyledAttributes != null ? obtainStyledAttributes.getDimension(com.avito.android.ui_components.R.styleable.RecommendationWidget_rg_graph_height, applyDimension) : applyDimension;
            this.g = obtainStyledAttributes != null ? obtainStyledAttributes.getColor(com.avito.android.ui_components.R.styleable.RecommendationWidget_rg_graph_color, colorByAttr) : colorByAttr;
            this.h = obtainStyledAttributes != null ? obtainStyledAttributes.getFloat(com.avito.android.ui_components.R.styleable.RecommendationWidget_rg_column_selection_alpha, 0.6f) : f2;
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.f = applyDimension;
            this.g = colorByAttr;
            this.h = 0.6f;
        }
        LayoutInflater.from(context).inflate(com.avito.android.ui_components.R.layout.recommendation_graph, this);
        View findViewById = findViewById(com.avito.android.ui_components.R.id.columns_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.e = linearLayout;
        linearLayout.getLayoutParams().height = (int) this.f;
        View findViewById2 = findViewById(com.avito.android.ui_components.R.id.labels_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) findViewById2;
        this.a = frameLayout;
        View findViewById3 = frameLayout.findViewById(com.avito.android.ui_components.R.id.min_value_label);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById3;
        View findViewById4 = frameLayout.findViewById(com.avito.android.ui_components.R.id.max_value_label);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById4;
        View findViewById5 = frameLayout.findViewById(com.avito.android.ui_components.R.id.median_value_label);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById5;
        View findViewById6 = findViewById(com.avito.android.ui_components.R.id.median_value_pointer);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.k = findViewById6;
        View findViewById7 = findViewById(com.avito.android.ui_components.R.id.current_value_pointer);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.l = findViewById7;
        findViewById6.getLayoutParams().height = (int) this.f;
        ViewGroup.LayoutParams layoutParams = findViewById7.getLayoutParams();
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        layoutParams.height = ((int) this.f) + ((int) TypedValue.applyDimension(1, 4.0f, resources2.getDisplayMetrics()));
    }
}

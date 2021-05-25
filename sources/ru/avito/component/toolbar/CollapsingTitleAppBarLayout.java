package ru.avito.component.toolbar;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContent;
import com.avito.android.lib.design.tooltip.TooltipContentKt;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.ui_components.R;
import com.google.android.material.appbar.AppBarLayout;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bR\u0010SB\u001b\b\u0016\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bR\u0010TJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR(\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R.\u0010%\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$8\u0004@DX\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0004@\u0004X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R(\u00106\u001a\u0004\u0018\u00010\u001d2\b\u00103\u001a\u0004\u0018\u00010\u001d8F@FX\u000e¢\u0006\f\u001a\u0004\b4\u0010 \"\u0004\b5\u0010\"R\u0016\u00108\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u0010\u0017R\u0016\u0010:\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010\u0017R\"\u0010;\u001a\u00020\u00198\u0004@\u0004X.¢\u0006\u0012\n\u0004\b;\u0010\u001b\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010C\u001a\u0004\u0018\u00010\u001d2\b\u0010@\u001a\u0004\u0018\u00010\u001d8F@FX\u000e¢\u0006\f\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bE\u0010FR$\u0010O\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006U"}, d2 = {"Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", "", "drawableResId", "", "setHomeIcon", "(I)V", "Lru/avito/component/toolbar/OnboardingData;", "onboardingData", "showActionOnboarding", "(Lru/avito/component/toolbar/OnboardingData;)V", "refreshShortTitleWidth", "()V", "Landroid/util/AttributeSet;", "attrs", g.a, "(Landroid/util/AttributeSet;)V", "", "x", "Z", PanelStateKt.PANEL_COLLAPSED, "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "subTitleView", "Landroid/widget/FrameLayout;", VKApiConst.VERSION, "Landroid/widget/FrameLayout;", "homeButtonView", "", "titleString", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "Landroid/view/View;", "actionView", "z", "Landroid/view/View;", "getActionView", "()Landroid/view/View;", "setActionView", "(Landroid/view/View;)V", "Landroid/widget/RelativeLayout;", "appbarContainer", "Landroid/widget/RelativeLayout;", "getAppbarContainer", "()Landroid/widget/RelativeLayout;", "setAppbarContainer", "(Landroid/widget/RelativeLayout;)V", "subTitleString", "getSubTitle", "setSubTitle", "subTitle", "u", "shortTitleView", "s", "titleView", "actionViewContainer", "getActionViewContainer", "()Landroid/widget/FrameLayout;", "setActionViewContainer", "(Landroid/widget/FrameLayout;)V", "shortTitleString", "getShortTitle", "setShortTitle", "shortTitle", "Landroid/widget/ImageView;", "w", "Landroid/widget/ImageView;", "homeButtonIconView", "Lru/avito/component/toolbar/AppbarClickListener;", "y", "Lru/avito/component/toolbar/AppbarClickListener;", "getClickListener", "()Lru/avito/component/toolbar/AppbarClickListener;", "setClickListener", "(Lru/avito/component/toolbar/AppbarClickListener;)V", "clickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class CollapsingTitleAppBarLayout extends AppBarLayout {
    public FrameLayout actionViewContainer;
    public RelativeLayout appbarContainer;
    public TextView s;
    public TextView t;
    public TextView u;
    public FrameLayout v;
    public ImageView w;
    public boolean x;
    @Nullable
    public AppbarClickListener y;
    @Nullable
    public View z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CollapsingTitleAppBarLayout a;

        public a(CollapsingTitleAppBarLayout collapsingTitleAppBarLayout) {
            this.a = collapsingTitleAppBarLayout;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppbarClickListener clickListener = this.a.getClickListener();
            if (clickListener != null) {
                clickListener.onActionClicked();
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CollapsingTitleAppBarLayout a;

        public b(CollapsingTitleAppBarLayout collapsingTitleAppBarLayout) {
            this.a = collapsingTitleAppBarLayout;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppbarClickListener clickListener = this.a.getClickListener();
            if (clickListener != null) {
                clickListener.onHomeClicked();
            }
        }
    }

    public static final class c implements AppBarLayout.OnOffsetChangedListener {
        public final /* synthetic */ CollapsingTitleAppBarLayout a;

        public c(CollapsingTitleAppBarLayout collapsingTitleAppBarLayout) {
            this.a = collapsingTitleAppBarLayout;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            int i2 = -this.a.getResources().getDimensionPixelSize(R.dimen.publish_appbar_title_move_to_full_disappear);
            if (i >= 0) {
                CollapsingTitleAppBarLayout.access$hideShortTitle(this.a);
                i = 0;
            } else if (i < i2) {
                CollapsingTitleAppBarLayout.access$showShortTitle(this.a);
                i = i2;
            } else {
                CollapsingTitleAppBarLayout.access$hideShortTitle(this.a);
            }
            CollapsingTitleAppBarLayout.access$getTitleView$p(this.a).setAlpha(1.0f - (((float) i) / ((float) i2)));
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ CollapsingTitleAppBarLayout a;

        public d(CollapsingTitleAppBarLayout collapsingTitleAppBarLayout) {
            this.a = collapsingTitleAppBarLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CollapsingTitleAppBarLayout.access$getShortTitleView$p(this.a).setWidth(this.a.getWidth() - (Math.max(CollapsingTitleAppBarLayout.access$getHomeButtonView$p(this.a).getWidth(), this.a.getActionViewContainer().getWidth()) * 2));
        }
    }

    public static final class e extends Lambda implements Function1<TooltipContent, Unit> {
        public final /* synthetic */ OnboardingData a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(OnboardingData onboardingData) {
            super(1);
            this.a = onboardingData;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(TooltipContent tooltipContent) {
            TooltipContent tooltipContent2 = tooltipContent;
            Intrinsics.checkNotNullParameter(tooltipContent2, "$receiver");
            tooltipContent2.setTitle(this.a.getTitle());
            tooltipContent2.setBody(this.a.getText());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollapsingTitleAppBarLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        g(null);
    }

    public static final /* synthetic */ FrameLayout access$getHomeButtonView$p(CollapsingTitleAppBarLayout collapsingTitleAppBarLayout) {
        FrameLayout frameLayout = collapsingTitleAppBarLayout.v;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeButtonView");
        }
        return frameLayout;
    }

    public static final /* synthetic */ TextView access$getShortTitleView$p(CollapsingTitleAppBarLayout collapsingTitleAppBarLayout) {
        TextView textView = collapsingTitleAppBarLayout.u;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shortTitleView");
        }
        return textView;
    }

    public static final /* synthetic */ TextView access$getTitleView$p(CollapsingTitleAppBarLayout collapsingTitleAppBarLayout) {
        TextView textView = collapsingTitleAppBarLayout.s;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        return textView;
    }

    public static final void access$hideShortTitle(CollapsingTitleAppBarLayout collapsingTitleAppBarLayout) {
        if (collapsingTitleAppBarLayout.x) {
            collapsingTitleAppBarLayout.x = false;
            TextView textView = collapsingTitleAppBarLayout.u;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shortTitleView");
            }
            textView.animate().alpha(0.0f).setDuration(250).start();
        }
    }

    public static final void access$showShortTitle(CollapsingTitleAppBarLayout collapsingTitleAppBarLayout) {
        if (!collapsingTitleAppBarLayout.x) {
            collapsingTitleAppBarLayout.x = true;
            TextView textView = collapsingTitleAppBarLayout.u;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shortTitleView");
            }
            textView.animate().alpha(1.0f).setDuration(250).start();
        }
    }

    public final void g(AttributeSet attributeSet) {
        Object systemService = getContext().getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(R.layout.collapsing_title_appbar_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.appbar_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.appbar_container)");
        this.appbarContainer = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.action_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.actionViewContainer = (FrameLayout) findViewById2;
        View findViewById3 = findViewById(R.id.appbar_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.appbar_title)");
        this.s = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.sub_title)");
        this.t = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.title_short);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.title_short)");
        TextView textView = (TextView) findViewById5;
        this.u = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shortTitleView");
        }
        textView.setAlpha(0.0f);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CollapsingTitleAppBarLayout, 0, 0);
        setTitle(obtainStyledAttributes.getString(R.styleable.CollapsingTitleAppBarLayout_title));
        setSubTitle(obtainStyledAttributes.getString(R.styleable.CollapsingTitleAppBarLayout_subtitle));
        setShortTitle(obtainStyledAttributes.getString(R.styleable.CollapsingTitleAppBarLayout_short_title));
        View findViewById6 = findViewById(R.id.home);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.home)");
        FrameLayout frameLayout = (FrameLayout) findViewById6;
        this.v = frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeButtonView");
        }
        frameLayout.setOnClickListener(new b(this));
        FrameLayout frameLayout2 = this.v;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeButtonView");
        }
        View findViewById7 = frameLayout2.findViewById(R.id.home_button_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "homeButtonView.findViewById(R.id.home_button_icon)");
        this.w = (ImageView) findViewById7;
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CollapsingTitleAppBarLayout_home_icon);
        if (drawable != null) {
            ImageView imageView = this.w;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeButtonIconView");
            }
            imageView.setImageDrawable(drawable);
        }
        int i = R.styleable.CollapsingTitleAppBarLayout_titleSidePadding;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dimension = (int) obtainStyledAttributes.getDimension(i, (float) context.getResources().getDimensionPixelSize(R.dimen.container_horizontal_padding));
        int i2 = R.styleable.CollapsingTitleAppBarLayout_titlesBottomPadding;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        obtainStyledAttributes.recycle();
        View findViewById8 = findViewById(R.id.titles_container);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        findViewById8.setPadding(dimension, findViewById8.getPaddingTop(), dimension, (int) obtainStyledAttributes.getDimension(i2, (float) context2.getResources().getDimensionPixelSize(R.dimen.collapsing_title_appbar_padding_bottom)));
        addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new c(this));
    }

    @Nullable
    public final View getActionView() {
        return this.z;
    }

    @NotNull
    public final FrameLayout getActionViewContainer() {
        FrameLayout frameLayout = this.actionViewContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionViewContainer");
        }
        return frameLayout;
    }

    @NotNull
    public final RelativeLayout getAppbarContainer() {
        RelativeLayout relativeLayout = this.appbarContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appbarContainer");
        }
        return relativeLayout;
    }

    @Nullable
    public final AppbarClickListener getClickListener() {
        return this.y;
    }

    @Nullable
    public final String getShortTitle() {
        TextView textView = this.u;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shortTitleView");
        }
        return textView.getText().toString();
    }

    @Nullable
    public final String getSubTitle() {
        TextView textView = this.t;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        }
        return textView.getText().toString();
    }

    @Nullable
    public final String getTitle() {
        TextView textView = this.s;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        return textView.getText().toString();
    }

    public final void refreshShortTitleWidth() {
        FrameLayout frameLayout = this.actionViewContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionViewContainer");
        }
        frameLayout.post(new d(this));
    }

    public final void setActionView(@Nullable View view) {
        if (view != null) {
            FrameLayout frameLayout = this.actionViewContainer;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionViewContainer");
            }
            frameLayout.addView(view);
            FrameLayout frameLayout2 = this.actionViewContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionViewContainer");
            }
            frameLayout2.setVisibility(0);
        } else {
            FrameLayout frameLayout3 = this.actionViewContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionViewContainer");
            }
            frameLayout3.removeAllViews();
            FrameLayout frameLayout4 = this.actionViewContainer;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionViewContainer");
            }
            frameLayout4.setVisibility(4);
        }
        refreshShortTitleWidth();
        this.z = view;
        if (view != null) {
            view.setOnClickListener(new a(this));
        }
    }

    public final void setActionViewContainer(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.actionViewContainer = frameLayout;
    }

    public final void setAppbarContainer(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.appbarContainer = relativeLayout;
    }

    public final void setClickListener(@Nullable AppbarClickListener appbarClickListener) {
        this.y = appbarClickListener;
    }

    public final void setHomeIcon(@DrawableRes int i) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        ImageView imageView = this.w;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeButtonIconView");
        }
        imageView.setImageDrawable(drawable);
    }

    public final void setShortTitle(@Nullable String str) {
        TextView textView = this.u;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shortTitleView");
        }
        textView.setText(str);
    }

    public final void setSubTitle(@Nullable String str) {
        if (!(str == null || str.length() == 0)) {
            TextView textView = this.t;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
            }
            textView.setText(str);
            TextView textView2 = this.t;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
            }
            textView2.setVisibility(0);
            return;
        }
        TextView textView3 = this.t;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        }
        textView3.setText("");
        TextView textView4 = this.t;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        }
        textView4.setVisibility(8);
    }

    public final void setTitle(@Nullable String str) {
        TextView textView = this.s;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        textView.setText(str);
    }

    public final void showActionOnboarding(@NotNull OnboardingData onboardingData) {
        Intrinsics.checkNotNullParameter(onboardingData, "onboardingData");
        RelativeLayout relativeLayout = this.appbarContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appbarContainer");
        }
        Context context = relativeLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "appbarContainer.context");
        Tooltip content = TooltipContentKt.content(Tooltip.setSize$default(new Tooltip(context, 0, 0, 6, null).setTooltipPosition(new TooltipPositions.Bottom(new TailPositions.End(new AnchorPositions.End()))), -1, 0, 2, null), new e(onboardingData));
        RelativeLayout relativeLayout2 = this.appbarContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appbarContainer");
        }
        content.show(relativeLayout2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollapsingTitleAppBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        g(attributeSet);
    }
}

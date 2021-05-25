package com.avito.android.category;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.design.widget.recycler.BackgroundDecoration;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Contexts;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.RecyclerViewsKt;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006I"}, d2 = {"Lcom/avito/android/category/CategoryViewImpl;", "Lcom/avito/android/category/CategoryView;", "", "showProgress", "()V", "showRetry", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "dataChanged", "", VKApiConst.POSITION, "itemChanged", "(I)V", "count", "itemRangeRemoved", "(II)V", "itemRangeInserted", "Lkotlin/ranges/IntRange;", "range", "showBackgroundForRange", "(Lkotlin/ranges/IntRange;)V", "colorAttr", "getColor", "(I)I", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/design/widget/recycler/BackgroundDecoration;", g.a, "Lcom/avito/android/design/widget/recycler/BackgroundDecoration;", "backgroundDecoration", "Landroid/view/ViewGroup;", "h", "Landroid/view/ViewGroup;", "rootView", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "shadowView", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "Landroid/content/res/Resources;", "f", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/BuildInfo;", "j", "Lcom/avito/android/util/BuildInfo;", "build", "Landroidx/appcompat/widget/Toolbar;", "d", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "e", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/util/DeviceMetrics;", "i", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/category/CategoryPresenter;", "presenter", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/category/CategoryPresenter;Lcom/avito/android/analytics/Analytics;)V", "category_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryViewImpl implements CategoryView {
    public final View a;
    public final RecyclerView b;
    public final Context c;
    public final Toolbar d;
    public final ProgressOverlay e;
    public final Resources f;
    public BackgroundDecoration g;
    public final ViewGroup h;
    public final DeviceMetrics i;
    public final BuildInfo j;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CategoryPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CategoryPresenter categoryPresenter) {
            super(0);
            this.a = categoryPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onRetryClick();
            return Unit.INSTANCE;
        }
    }

    public CategoryViewImpl(@NotNull ViewGroup viewGroup, @NotNull DeviceMetrics deviceMetrics, @NotNull BuildInfo buildInfo, @NotNull CategoryPresenter categoryPresenter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        Intrinsics.checkNotNullParameter(categoryPresenter, "presenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.h = viewGroup;
        this.i = deviceMetrics;
        this.j = buildInfo;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.c = context;
        View findViewById = viewGroup.findViewById(R.id.progress_overlay_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        int i2 = R.id.recycler_view;
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById, i2, analytics, false, 0, 24, null);
        this.e = progressOverlay;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.f = resources;
        View findViewById2 = viewGroup.findViewById(R.id.shadow);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById2;
        View findViewById3 = viewGroup.findViewById(i2);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.b = recyclerView;
        View findViewById4 = viewGroup.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById4;
        this.d = toolbar;
        progressOverlay.setOnRefreshListener(new a(categoryPresenter));
        progressOverlay.setToolbarPadding();
        String string = resources.getString(R.string.categories);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.categories)");
        Toolbars.setSpannedTitle(toolbar, string);
        Toolbars.setCloseIcon(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.clearOnScrollListeners();
        CategoryItemAnimator categoryItemAnimator = new CategoryItemAnimator(buildInfo);
        categoryItemAnimator.setAddDuration(100);
        categoryItemAnimator.setRemoveDuration(100);
        Unit unit = Unit.INSTANCE;
        recyclerView.setItemAnimator(categoryItemAnimator);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryPresenter);
        categoryAdapter.setHasStableIds(true);
        recyclerView.setAdapter(categoryAdapter);
        int dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(R.dimen.category_list_width_max);
        if (dimensionPixelSize > 0) {
            int displayWidth = (deviceMetrics.getDisplayWidth() - dimensionPixelSize) / 2;
            Views.changePadding$default(recyclerView, displayWidth, 0, displayWidth, 0, 10, null);
        }
    }

    @Override // com.avito.android.category.CategoryView
    public void dataChanged() {
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.category.CategoryView
    public int getColor(int i2) {
        return Contexts.getColorByAttr(this.c, i2);
    }

    @Override // com.avito.android.category.CategoryView
    public void itemChanged(int i2) {
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2);
        }
    }

    @Override // com.avito.android.category.CategoryView
    public void itemRangeInserted(int i2, int i3) {
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeInserted(i2, i3);
        }
    }

    @Override // com.avito.android.category.CategoryView
    public void itemRangeRemoved(int i2, int i3) {
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeRemoved(i2, i3);
        }
    }

    @Override // com.avito.android.category.CategoryView
    public void showBackgroundForRange(@NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, "range");
        BackgroundDecoration backgroundDecoration = this.g;
        if (backgroundDecoration == null) {
            Drawable drawable = this.h.getContext().getDrawable(R.drawable.category_list_decoration_background);
            Intrinsics.checkNotNull(drawable);
            Intrinsics.checkNotNullExpressionValue(drawable, "rootView.context.getDraw…_decoration_background)!!");
            BackgroundDecoration backgroundDecoration2 = new BackgroundDecoration(drawable, intRange);
            this.g = backgroundDecoration2;
            this.b.addItemDecoration(backgroundDecoration2);
        } else {
            backgroundDecoration.setRange(intRange);
        }
        RecyclerViewsKt.invalidateItemDecorationsSafely(this.b);
    }

    @Override // com.avito.android.category.CategoryView
    public void showContent() {
        this.e.showContent();
    }

    @Override // com.avito.android.category.CategoryView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.h, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.category.CategoryView
    public void showProgress() {
        this.e.showLoading();
    }

    @Override // com.avito.android.category.CategoryView
    public void showRetry() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.e, null, 1, null);
    }
}

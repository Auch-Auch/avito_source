package com.avito.android.advert_core.specifications;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.advert_core.R;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018¨\u0006!"}, d2 = {"Lcom/avito/android/advert_core/specifications/SpecificationsViewImpl;", "Lcom/avito/android/advert_core/specifications/SpecificationsView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "columns", "", "Lcom/avito/android/advert_core/specifications/SpecificationData;", "items", "setData", "(ILjava/util/List;)V", "Lcom/avito/android/advert_core/specifications/SpecificationView;", "d", "Lcom/avito/android/advert_core/specifications/SpecificationView;", "specificationView", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/View;", "c", "Landroid/view/View;", "shadow", AuthSource.SEND_ABUSE, "scrollContainer", "view", "Lkotlin/Function0;", "backPressedAction", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class SpecificationsViewImpl implements SpecificationsView {
    public final View a;
    public final Toolbar b;
    public final View c;
    public final SpecificationView d;

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

    public static final class b implements ViewTreeObserver.OnScrollChangedListener {
        public final /* synthetic */ SpecificationsViewImpl a;

        public b(SpecificationsViewImpl specificationsViewImpl) {
            this.a = specificationsViewImpl;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            this.a.c.setVisibility(this.a.a.getScrollY() <= 0 ? 8 : 0);
        }
    }

    public SpecificationsViewImpl(@NotNull View view, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function0, "backPressedAction");
        View findViewById = view.findViewById(R.id.scroll_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById2;
        this.b = toolbar;
        View findViewById3 = view.findViewById(R.id.toolbar_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.toolbar_shadow)");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R.id.specifications);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.advert_core.specifications.SpecificationView");
        this.d = (SpecificationView) findViewById4;
        toolbar.setNavigationOnClickListener(new a(function0));
        findViewById.getViewTreeObserver().addOnScrollChangedListener(new b(this));
    }

    @Override // com.avito.android.advert_core.specifications.SpecificationsView
    public void setData(int i, @NotNull List<? extends SpecificationData> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.d.setData(i, list);
    }

    @Override // com.avito.android.advert_core.specifications.SpecificationsView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.b.setTitle(str);
    }
}

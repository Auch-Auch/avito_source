package ru.avito.component.collapsing_appbar;

import a7.a.a.b.c;
import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.google.android.material.appbar.AppBarLayout;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.view.ViewLayoutChangeEvent;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lru/avito/component/collapsing_appbar/CollapsingAppBar;", "", "Lcom/google/android/material/appbar/AppBarLayout;", AuthSource.BOOKING_ORDER, "Lcom/google/android/material/appbar/AppBarLayout;", "appBar", "Lnet/opacapp/multilinecollapsingtoolbar/CollapsingToolbarLayout;", AuthSource.SEND_ABUSE, "Lnet/opacapp/multilinecollapsingtoolbar/CollapsingToolbarLayout;", "ctl", "Landroid/view/View;", "c", "Landroid/view/View;", "shadow", "root", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CollapsingAppBar {
    public final CollapsingToolbarLayout a;
    public final AppBarLayout b;
    public final View c;

    public static final class a implements AppBarLayout.OnOffsetChangedListener {
        public final /* synthetic */ CollapsingAppBar a;

        public a(CollapsingAppBar collapsingAppBar) {
            this.a = collapsingAppBar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            View view = this.a.c;
            int abs = Math.abs(i);
            Intrinsics.checkNotNullExpressionValue(appBarLayout, "appBarLayout");
            Views.setVisible(view, abs >= appBarLayout.getTotalScrollRange());
        }
    }

    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ CollapsingAppBar a;
        public final /* synthetic */ View b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CollapsingAppBar collapsingAppBar, View view) {
            super(1);
            this.a = collapsingAppBar;
            this.b = view;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            this.a.a.setExpandedTitleMargin(this.b.getResources().getDimensionPixelSize(R.dimen.standard_padding) + num.intValue(), 0, 0, 0);
            return Unit.INSTANCE;
        }
    }

    public CollapsingAppBar(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "root");
        View findViewById = view.findViewById(R.id.toolbar_layout);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout");
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById;
        this.a = collapsingToolbarLayout;
        View findViewById2 = view.findViewById(R.id.app_bar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById2;
        this.b = appBarLayout;
        View findViewById3 = view.findViewById(R.id.shadow);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById3;
        Toolbars.applyTypefaceForCollapsedTitle(collapsingToolbarLayout);
        Toolbars.applyTypefaceForExpandedTitle(collapsingToolbarLayout);
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(this));
        b bVar = new b(this, view);
        if (view.getResources().getBoolean(R.bool.is_tablet)) {
            RxView.layoutChangeEvents(view).filter(new a7.a.a.b.a(this)).map(new a7.a.a.b.b(this)).subscribe(new c(view, bVar));
        }
    }

    public static final int access$newWidth(CollapsingAppBar collapsingAppBar, ViewLayoutChangeEvent viewLayoutChangeEvent) {
        Objects.requireNonNull(collapsingAppBar);
        return viewLayoutChangeEvent.getRight() - viewLayoutChangeEvent.getLeft();
    }

    public static final int access$oldWidth(CollapsingAppBar collapsingAppBar, ViewLayoutChangeEvent viewLayoutChangeEvent) {
        Objects.requireNonNull(collapsingAppBar);
        return viewLayoutChangeEvent.getOldRight() - viewLayoutChangeEvent.getOldLeft();
    }
}

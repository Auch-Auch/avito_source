package com.avito.android.autoteka_details;

import a2.g.r.g;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.analytics.Analytics;
import com.avito.android.autoteka_details.AutotekaDetailsNavigation;
import com.avito.android.deprecated_design.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000eR\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0012R\u0016\u0010$\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0016R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0012R\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0012R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00104\u001a\n \u0019*\u0004\u0018\u000101018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u0006;"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsViewImpl;", "Lcom/avito/android/autoteka_details/AutotekaDetailsView;", "", "startLoad", "()V", "Lcom/avito/android/autoteka_details/AutotekaDetails;", "data", "showData", "(Lcom/avito/android/autoteka_details/AutotekaDetails;)V", "showError", "Lcom/jakewharton/rxrelay2/PublishRelay;", "l", "Lcom/jakewharton/rxrelay2/PublishRelay;", "getRefreshClick", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "refreshClick", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "subTitle", "Lru/avito/component/button/ButtonImpl;", "h", "Lru/avito/component/button/ButtonImpl;", "reportExampleButton", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation;", "k", "getNavigationClick", "navigationClick", "d", "title", g.a, "getReportButton", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "i", "disclaimer", "f", "description", "Landroid/view/ViewGroup;", "j", "Landroid/view/ViewGroup;", "benefitsContainer", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/View;", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;)V", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaDetailsViewImpl implements AutotekaDetailsView {
    public final Context a;
    public final Toolbar b;
    public final ProgressOverlay c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final ButtonImpl g;
    public final ButtonImpl h;
    public final TextView i;
    public final ViewGroup j;
    @NotNull
    public final PublishRelay<AutotekaDetailsNavigation> k;
    @NotNull
    public final PublishRelay<Unit> l;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((AutotekaDetailsViewImpl) this.b).getNavigationClick().accept(new AutotekaDetailsNavigation.GetReport(((AutotekaDetails) this.c).getReportUrl()));
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((AutotekaDetailsViewImpl) this.b).getNavigationClick().accept(new AutotekaDetailsNavigation.ExampleReport(((AutotekaDetails) this.c).getExampleUrl()));
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AutotekaDetailsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AutotekaDetailsViewImpl autotekaDetailsViewImpl) {
            super(0);
            this.a = autotekaDetailsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay<Unit> refreshClick = this.a.getRefreshClick();
            Unit unit = Unit.INSTANCE;
            refreshClick.accept(unit);
            return unit;
        }
    }

    public AutotekaDetailsViewImpl(@NotNull View view, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = view.getContext();
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.b = toolbar;
        View findViewById = view.findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.content_holder)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById, R.id.scrollView, analytics, false, 0, 24, null);
        this.c = progressOverlay;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.sub_title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.btn_get_report);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.g = new ButtonImpl(findViewById5);
        View findViewById6 = view.findViewById(R.id.btn_report_example);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.h = new ButtonImpl(findViewById6);
        View findViewById7 = view.findViewById(R.id.disclaimer);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.i = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.benefits_container);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.ViewGroup");
        this.j = (ViewGroup) findViewById8;
        PublishRelay<AutotekaDetailsNavigation> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.k = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.l = create2;
        toolbar.setTitle(R.string.autoteka_report);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24_blue);
        toolbar.setNavigationOnClickListener(new a2.a.a.o.a(this));
        progressOverlay.setOnRefreshListener(new b(this));
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsView
    public void showData(@NotNull AutotekaDetails autotekaDetails) {
        Intrinsics.checkNotNullParameter(autotekaDetails, "data");
        this.c.showContent();
        this.d.setText(autotekaDetails.getTitle());
        this.e.setText(autotekaDetails.getSubTitle());
        this.f.setText(autotekaDetails.getDescription());
        TextView textView = this.i;
        textView.setText(autotekaDetails.getDisclaimer());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        ButtonImpl buttonImpl = this.g;
        buttonImpl.setText(R.string.autoteka_get_report);
        buttonImpl.setClickListener(new a(0, this, autotekaDetails));
        ButtonImpl buttonImpl2 = this.h;
        buttonImpl2.setText(R.string.autoteka_example_report);
        buttonImpl2.setClickListener(new a(1, this, autotekaDetails));
        ViewGroup viewGroup = this.j;
        viewGroup.removeAllViews();
        LayoutInflater from = LayoutInflater.from(this.a);
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String[] stringArray = context.getResources().getStringArray(R.array.autoteka_benefits);
        Intrinsics.checkNotNullExpressionValue(stringArray, "context.resources.getStr….array.autoteka_benefits)");
        for (String str : stringArray) {
            View inflate = from.inflate(R.layout.autoteka_benefits_view, viewGroup, false);
            View findViewById = inflate.findViewById(R.id.text);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setText(str);
            viewGroup.addView(inflate);
        }
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsView
    public void showError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.c, null, 1, null);
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsView
    public void startLoad() {
        this.c.showLoading();
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsView
    @NotNull
    public PublishRelay<AutotekaDetailsNavigation> getNavigationClick() {
        return this.k;
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsView
    @NotNull
    public PublishRelay<Unit> getRefreshClick() {
        return this.l;
    }
}

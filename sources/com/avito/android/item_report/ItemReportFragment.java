package com.avito.android.item_report;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.item_report.ItemReportPresenter;
import com.avito.android.item_report.di.DaggerItemReportComponent;
import com.avito.android.item_report.di.ItemReportDependencies;
import com.avito.android.item_report.remote.ItemReportApi;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.OnRefreshListener;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.model.AdvertReport;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.ViewUtils;
import com.avito.android.util.Views;
import com.avito.android.util.text.LegacyAttributedTextFormatter;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b[\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\nJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u0011J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\nJ\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\nJ\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\nR\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010E\u001a\u00020D8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010,R\u0018\u0010R\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010,R\u0016\u0010V\u001a\u00020S8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010,R\u0018\u0010Z\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010,¨\u0006\\"}, d2 = {"Lcom/avito/android/item_report/ItemReportFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/item_report/ItemReportPresenter$Subscriber;", "Lcom/avito/android/progress_overlay/OnRefreshListener;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "onDetach", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "outState", "onSaveInstanceState", "", "message", "onFatalError", "(Ljava/lang/String;)V", "onNetworkError", "Lcom/avito/android/remote/model/AdvertReport;", "report", "onFinish", "(Lcom/avito/android/remote/model/AdvertReport;)V", "showProgress", "onRefresh", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "status", "Lcom/avito/android/item_report/remote/ItemReportApi;", "api", "Lcom/avito/android/item_report/remote/ItemReportApi;", "getApi", "()Lcom/avito/android/item_report/remote/ItemReportApi;", "setApi", "(Lcom/avito/android/item_report/remote/ItemReportApi;)V", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "setSchedulersFactory", "(Lcom/avito/android/util/SchedulersFactory;)V", "Landroid/widget/LinearLayout;", "k", "Landroid/widget/LinearLayout;", "resultsContainer", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "e", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/item_report/ErrorListener;", "d", "Lcom/avito/android/item_report/ErrorListener;", "errorListener", "j", "legalInfo", "f", TariffPackageInfoConverterKt.HEADER_STRING_ID, "Lcom/avito/android/item_report/ItemReportPresenter;", "c", "Lcom/avito/android/item_report/ItemReportPresenter;", "presenter", g.a, "number", "i", Sort.DATE, "<init>", "item-report_release"}, k = 1, mv = {1, 4, 2})
public final class ItemReportFragment extends BaseFragment implements ItemReportPresenter.Subscriber, OnRefreshListener {
    @Inject
    public Analytics analytics;
    @Inject
    public ItemReportApi api;
    public ItemReportPresenter c;
    public ErrorListener d;
    public ProgressOverlay e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public LinearLayout k;
    @Inject
    public SchedulersFactory schedulersFactory;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ItemReportFragment a;

        public a(ItemReportFragment itemReportFragment) {
            this.a = itemReportFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = this.a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final ItemReportApi getApi() {
        ItemReportApi itemReportApi = this.api;
        if (itemReportApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("api");
        }
        return itemReportApi;
    }

    @NotNull
    public final SchedulersFactory getSchedulersFactory() {
        SchedulersFactory schedulersFactory2 = this.schedulersFactory;
        if (schedulersFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulersFactory");
        }
        return schedulersFactory2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.d = (ErrorListener) context;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("item_id");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "requireArguments().getString(KEY_ITEM_ID)!!");
        ItemReportApi itemReportApi = this.api;
        if (itemReportApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("api");
        }
        ItemReportInteractorImpl itemReportInteractorImpl = new ItemReportInteractorImpl(itemReportApi);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Resources resources = requireContext.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "requireContext().resources");
        ErrorFormatterImpl errorFormatterImpl = new ErrorFormatterImpl(resources);
        SchedulersFactory schedulersFactory2 = this.schedulersFactory;
        if (schedulersFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulersFactory");
        }
        this.c = new ItemReportPresenterImpl(string, itemReportInteractorImpl, schedulersFactory2, errorFormatterImpl);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.item_report, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        View findViewById = inflate.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) findViewById;
        int i2 = R.id.content;
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup2, i2, analytics2, false, 0, 24, null);
        this.e = progressOverlay;
        if (progressOverlay != null) {
            progressOverlay.setOnRefreshListener(this);
        }
        this.f = (TextView) inflate.findViewById(R.id.header);
        this.g = (TextView) inflate.findViewById(R.id.number);
        this.h = (TextView) inflate.findViewById(R.id.status);
        this.i = (TextView) inflate.findViewById(R.id.date);
        this.j = (TextView) inflate.findViewById(R.id.legal_info);
        this.k = (LinearLayout) inflate.findViewById(R.id.results);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ItemReportPresenter itemReportPresenter = this.c;
        if (itemReportPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemReportPresenter.unsubscribe();
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.d = null;
    }

    @Override // com.avito.android.item_report.ItemReportPresenter.Subscriber
    public void onFatalError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        ErrorListener errorListener = this.d;
        if (errorListener != null) {
            errorListener.onError(str);
        }
    }

    @Override // com.avito.android.item_report.ItemReportPresenter.Subscriber
    public void onFinish(@NotNull AdvertReport advertReport) {
        Drawable drawable;
        Context context;
        Drawable drawable2;
        Drawable drawable3;
        Context context2;
        Drawable drawable4;
        CharSequence format;
        Intrinsics.checkNotNullParameter(advertReport, "report");
        ProgressOverlay progressOverlay = this.e;
        if (progressOverlay != null) {
            progressOverlay.showContent();
        }
        AttributedText legalInfo = advertReport.getLegalInfo();
        if (!(legalInfo == null || (format = new LegacyAttributedTextFormatter().format(legalInfo)) == null)) {
            TextView textView = this.j;
            if (textView != null) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setText(format);
            }
            TextView textView3 = this.j;
            if (textView3 != null) {
                Views.show(textView3);
            }
        }
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        viewUtils.bindText(this.f, advertReport.getHeader());
        viewUtils.bindText(this.g, advertReport.getNumber());
        viewUtils.bindText(this.h, advertReport.getStatus());
        viewUtils.bindText(this.i, advertReport.getDate());
        LinearLayout linearLayout = this.k;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        View view = getView();
        LayoutInflater from = LayoutInflater.from(view != null ? view.getContext() : null);
        List<AdvertReport.Result> results = advertReport.getResults();
        if (results != null) {
            for (T t : results) {
                View inflate = from.inflate(R.layout.item_report_result, (ViewGroup) this.k, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView4 = (TextView) inflate;
                LinearLayout linearLayout2 = this.k;
                if (linearLayout2 != null) {
                    linearLayout2.addView(textView4);
                }
                textView4.setText(t.getTitle());
                if (t instanceof AdvertReport.OkResult) {
                    LinearLayout linearLayout3 = this.k;
                    if (linearLayout3 == null || (context = linearLayout3.getContext()) == null || (drawable2 = context.getDrawable(R.drawable.ic_good_24)) == null) {
                        drawable = null;
                    } else {
                        FragmentActivity requireActivity = requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                        drawable = DrawablesKt.wrapForTinting(drawable2, Contexts.getColorByAttr(requireActivity, com.avito.android.lib.design.R.attr.green));
                    }
                    textView4.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                } else if (t instanceof AdvertReport.WarnResult) {
                    LinearLayout linearLayout4 = this.k;
                    if (linearLayout4 == null || (context2 = linearLayout4.getContext()) == null || (drawable4 = context2.getDrawable(R.drawable.ic_error_24)) == null) {
                        drawable3 = null;
                    } else {
                        FragmentActivity requireActivity2 = requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                        drawable3 = DrawablesKt.wrapForTinting(drawable4, Contexts.getColorByAttr(requireActivity2, com.avito.android.lib.design.R.attr.orange));
                    }
                    textView4.setCompoundDrawablesWithIntrinsicBounds(drawable3, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        }
    }

    @Override // com.avito.android.item_report.ItemReportPresenter.Subscriber
    public void onNetworkError() {
        ProgressOverlay progressOverlay = this.e;
        if (progressOverlay != null) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(progressOverlay, null, 1, null);
        }
    }

    @Override // com.avito.android.progress_overlay.OnRefreshListener
    public void onRefresh() {
        ItemReportPresenter itemReportPresenter = this.c;
        if (itemReportPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemReportPresenter.load();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ItemReportPresenter itemReportPresenter = this.c;
        if (itemReportPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemReportPresenter.onSaveState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        toolbar.setTitle(R.string.item_report);
        toolbar.setNavigationIcon(R.drawable.ic_close_24_blue);
        toolbar.setNavigationOnClickListener(new a(this));
        ItemReportPresenter itemReportPresenter = this.c;
        if (itemReportPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemReportPresenter.onRestoreState(bundle);
        ItemReportPresenter itemReportPresenter2 = this.c;
        if (itemReportPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemReportPresenter2.subscribe(this);
        ItemReportPresenter itemReportPresenter3 = this.c;
        if (itemReportPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemReportPresenter3.load();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setApi(@NotNull ItemReportApi itemReportApi) {
        Intrinsics.checkNotNullParameter(itemReportApi, "<set-?>");
        this.api = itemReportApi;
    }

    public final void setSchedulersFactory(@NotNull SchedulersFactory schedulersFactory2) {
        Intrinsics.checkNotNullParameter(schedulersFactory2, "<set-?>");
        this.schedulersFactory = schedulersFactory2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        DaggerItemReportComponent.builder().dependentOn((ItemReportDependencies) ComponentDependenciesKt.getDependencies(ItemReportDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
        return true;
    }

    @Override // com.avito.android.item_report.ItemReportPresenter.Subscriber
    public void showProgress() {
        ProgressOverlay progressOverlay = this.e;
        if (progressOverlay != null) {
            progressOverlay.showLoading();
        }
    }
}

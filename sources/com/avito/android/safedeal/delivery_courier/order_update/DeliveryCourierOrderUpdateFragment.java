package com.avito.android.safedeal.delivery_courier.order_update;

import a2.a.a.i2.a.a.d;
import a2.a.a.i2.a.a.e;
import a2.g.r.g;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.location_picker.di.LocationPickerModuleKt;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.delivery_courier.DeliveryCourierActivityInteractionConstants;
import com.avito.android.safedeal.delivery_courier.di.component.DaggerDeliveryCourierOrderUpdateComponent;
import com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateComponent;
import com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateDependencies;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.KeyboardSubscription;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002z{B\u0007¢\u0006\u0004\by\u0010\u001cJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b/\u0010\u001fR\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u0010;\u001a\u0002088\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010]\u001a\u00020\\8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010d\u001a\u00020c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010k\u001a\u00020j8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X.¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bv\u0010w¨\u0006|"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onActivityCreated", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroyView", "()V", "Lcom/avito/android/lib/design/button/Button;", "f", "Lcom/avito/android/lib/design/button/Button;", "cancelButton", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModel;", "viewModel", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModel;", "getViewModel", "()Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModel;", "setViewModel", "(Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModel;)V", "e", "submitButton", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", g.a, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/util/KeyboardSubscription;", "h", "Lcom/avito/android/util/KeyboardSubscription;", "keyboardVisibilitySubscription", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "performanceTracker", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "getPerformanceTracker", "()Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "setPerformanceTracker", "(Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "getDeepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "setDeepLinkFactory", "(Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", "tracker", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", "getTracker", "()Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", "setTracker", "(Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;)V", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;", "resourceProvider", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;", "getResourceProvider", "()Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;", "setResourceProvider", "(Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;)V", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateFragment$Source;", "c", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateFragment$Source;", "source", "Landroidx/appcompat/widget/Toolbar;", "d", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "<init>", "Factory", "Source", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierOrderUpdateFragment extends BaseFragment {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public Source c;
    public Toolbar d;
    @Inject
    public DeepLinkFactory deepLinkFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    public Button e;
    public Button f;
    public ProgressOverlay g;
    public KeyboardSubscription h;
    @Inject
    public BaseScreenPerformanceTracker performanceTracker;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public DeliveryCourierOrderUpdateResourceProvider resourceProvider;
    @Inject
    public DeliveryCourierOrderUpdateAnalyticsTracker tracker;
    @Inject
    public DeliveryCourierOrderUpdateViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateFragment$Factory;", "", "", "orderID", "source", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateFragment;", "createInstance", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateFragment;", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final DeliveryCourierOrderUpdateFragment createInstance(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "orderID");
            Intrinsics.checkNotNullParameter(str2, "source");
            Bundle bundle = new Bundle(2);
            bundle.putString("EXTRA_ORDER_ID", str);
            bundle.putString("EXTRA_SOURCE", str2);
            DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment = new DeliveryCourierOrderUpdateFragment();
            deliveryCourierOrderUpdateFragment.setArguments(bundle);
            return deliveryCourierOrderUpdateFragment;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateFragment$Source;", "", "<init>", "(Ljava/lang/String;I)V", "SELLER", "BUYER", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public enum Source {
        SELLER,
        BUYER
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                FragmentActivity activity = ((DeliveryCourierOrderUpdateFragment) this.b).getActivity();
                if (activity != null) {
                    DeliveryCourierOrderUpdateFragment.access$finishWithResult((DeliveryCourierOrderUpdateFragment) this.b, activity, -1);
                }
            } else if (i == 1) {
                ((DeliveryCourierOrderUpdateFragment) this.b).getViewModel().submitData();
            } else if (i == 2) {
                FragmentActivity activity2 = ((DeliveryCourierOrderUpdateFragment) this.b).getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ DeliveryCourierOrderUpdateFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment) {
            super(1);
            this.a = deliveryCourierOrderUpdateFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment = this.a;
                DeliveryCourierOrderUpdateFragment.access$hideWithZeroAlpha(deliveryCourierOrderUpdateFragment, DeliveryCourierOrderUpdateFragment.access$getSubmitButton$p(deliveryCourierOrderUpdateFragment));
                DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment2 = this.a;
                DeliveryCourierOrderUpdateFragment.access$hideWithZeroAlpha(deliveryCourierOrderUpdateFragment2, DeliveryCourierOrderUpdateFragment.access$getCancelButton$p(deliveryCourierOrderUpdateFragment2));
            } else {
                DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment3 = this.a;
                DeliveryCourierOrderUpdateFragment.a(deliveryCourierOrderUpdateFragment3, DeliveryCourierOrderUpdateFragment.access$getSubmitButton$p(deliveryCourierOrderUpdateFragment3), 0, 1);
                DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment4 = this.a;
                DeliveryCourierOrderUpdateFragment.a(deliveryCourierOrderUpdateFragment4, DeliveryCourierOrderUpdateFragment.access$getCancelButton$p(deliveryCourierOrderUpdateFragment4), 0, 1);
            }
            return Unit.INSTANCE;
        }
    }

    public static void a(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, View view, long j, int i) {
        if ((i & 1) != 0) {
            j = 400;
        }
        Objects.requireNonNull(deliveryCourierOrderUpdateFragment);
        Views.show(view);
        view.animate().alpha(1.0f).setDuration(j);
    }

    public static final void access$finishWithResult(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, Activity activity, int i) {
        Objects.requireNonNull(deliveryCourierOrderUpdateFragment);
        activity.setResult(i);
        activity.finish();
    }

    public static final /* synthetic */ Button access$getCancelButton$p(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment) {
        Button button = deliveryCourierOrderUpdateFragment.f;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
        }
        return button;
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment) {
        ProgressOverlay progressOverlay = deliveryCourierOrderUpdateFragment.g;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ Button access$getSubmitButton$p(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment) {
        Button button = deliveryCourierOrderUpdateFragment.e;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitButton");
        }
        return button;
    }

    public static final /* synthetic */ Toolbar access$getToolbar$p(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment) {
        Toolbar toolbar = deliveryCourierOrderUpdateFragment.d;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        return toolbar;
    }

    public static final void access$hideWithZeroAlpha(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, View view) {
        Objects.requireNonNull(deliveryCourierOrderUpdateFragment);
        Views.hide(view);
        view.setAlpha(0.0f);
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final DataAwareAdapterPresenter getAdapterPresenter() {
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return dataAwareAdapterPresenter;
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
    public final DeepLinkFactory getDeepLinkFactory() {
        DeepLinkFactory deepLinkFactory2 = this.deepLinkFactory;
        if (deepLinkFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkFactory");
        }
        return deepLinkFactory2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final BaseScreenPerformanceTracker getPerformanceTracker() {
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.performanceTracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
        }
        return baseScreenPerformanceTracker;
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final DeliveryCourierOrderUpdateResourceProvider getResourceProvider() {
        DeliveryCourierOrderUpdateResourceProvider deliveryCourierOrderUpdateResourceProvider = this.resourceProvider;
        if (deliveryCourierOrderUpdateResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        return deliveryCourierOrderUpdateResourceProvider;
    }

    @NotNull
    public final DeliveryCourierOrderUpdateAnalyticsTracker getTracker() {
        DeliveryCourierOrderUpdateAnalyticsTracker deliveryCourierOrderUpdateAnalyticsTracker = this.tracker;
        if (deliveryCourierOrderUpdateAnalyticsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return deliveryCourierOrderUpdateAnalyticsTracker;
    }

    @NotNull
    public final DeliveryCourierOrderUpdateViewModel getViewModel() {
        DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel = this.viewModel;
        if (deliveryCourierOrderUpdateViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return deliveryCourierOrderUpdateViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel = this.viewModel;
        if (deliveryCourierOrderUpdateViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        deliveryCourierOrderUpdateViewModel.setAdapterPresenter(dataAwareAdapterPresenter);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        AddressParameter.Value value;
        TimeInterval timeInterval;
        super.onActivityResult(i, i2, intent);
        if (i != 10) {
            if (i == 11) {
                if (i2 == 10) {
                    View requireView = requireView();
                    Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
                    DeliveryCourierOrderUpdateResourceProvider deliveryCourierOrderUpdateResourceProvider = this.resourceProvider;
                    if (deliveryCourierOrderUpdateResourceProvider == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
                    }
                    Views.showSnackBar$default(requireView, deliveryCourierOrderUpdateResourceProvider.getTimeIntervalSelectError(), 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
                    DeliveryCourierOrderUpdateAnalyticsTracker deliveryCourierOrderUpdateAnalyticsTracker = this.tracker;
                    if (deliveryCourierOrderUpdateAnalyticsTracker == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tracker");
                    }
                    deliveryCourierOrderUpdateAnalyticsTracker.trackSelectTimeIntervalError();
                } else if (intent != null && (timeInterval = (TimeInterval) intent.getParcelableExtra(DeliveryCourierActivityInteractionConstants.EXTRA_TIME_INTERVAL_RESULT)) != null) {
                    DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel = this.viewModel;
                    if (deliveryCourierOrderUpdateViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    deliveryCourierOrderUpdateViewModel.onTimeIntervalSelected(timeInterval);
                }
            }
        } else if (intent != null && (value = (AddressParameter.Value) intent.getParcelableExtra(LocationPickerModuleKt.EXTRA_ADDRESS_RESULT)) != null) {
            DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel2 = this.viewModel;
            if (deliveryCourierOrderUpdateViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            deliveryCourierOrderUpdateViewModel2.onLocationSelected(value);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.performanceTracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
        }
        baseScreenPerformanceTracker.startInit();
        return layoutInflater.inflate(R.layout.delivery_courier_order_update_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        KeyboardSubscription keyboardSubscription = this.h;
        if (keyboardSubscription != null) {
            keyboardSubscription.dispose();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel = this.viewModel;
        if (deliveryCourierOrderUpdateViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierOrderUpdateViewModel.getSelectDeepLinkChanges().observe(getViewLifecycleOwner(), new a2.a.a.i2.a.a.a(this));
        DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel2 = this.viewModel;
        if (deliveryCourierOrderUpdateViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierOrderUpdateViewModel2.getSnackbarChanges().observe(getViewLifecycleOwner(), new a2.a.a.i2.a.a.b(this));
        DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel3 = this.viewModel;
        if (deliveryCourierOrderUpdateViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierOrderUpdateViewModel3.getToolbarTitleChanges().observe(getViewLifecycleOwner(), new e2(0, this));
        DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel4 = this.viewModel;
        if (deliveryCourierOrderUpdateViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierOrderUpdateViewModel4.getSubmitButtonEnabledChanges().observe(getViewLifecycleOwner(), new l(0, this));
        DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel5 = this.viewModel;
        if (deliveryCourierOrderUpdateViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierOrderUpdateViewModel5.getSubmitButtonTextChanges().observe(getViewLifecycleOwner(), new e2(1, this));
        DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel6 = this.viewModel;
        if (deliveryCourierOrderUpdateViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierOrderUpdateViewModel6.getCancelButtonTextChanges().observe(getViewLifecycleOwner(), new e2(2, this));
        DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel7 = this.viewModel;
        if (deliveryCourierOrderUpdateViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierOrderUpdateViewModel7.getProgressChanges().observe(getViewLifecycleOwner(), new d(this));
        DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel8 = this.viewModel;
        if (deliveryCourierOrderUpdateViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierOrderUpdateViewModel8.getSubmitButtonSpinnerChanges().observe(getViewLifecycleOwner(), new l(1, this));
        DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel9 = this.viewModel;
        if (deliveryCourierOrderUpdateViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierOrderUpdateViewModel9.getCloseScreenChanges().observe(getViewLifecycleOwner(), new e(this));
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        Source source = this.c;
        if (source == null) {
            Intrinsics.throwUninitializedPropertyAccessException("source");
        }
        Source source2 = Source.SELLER;
        if (source == source2) {
            View findViewById2 = toolbar.findViewById(R.id.toolbar_title);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) findViewById2;
            DeliveryCourierOrderUpdateResourceProvider deliveryCourierOrderUpdateResourceProvider = this.resourceProvider;
            if (deliveryCourierOrderUpdateResourceProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
            }
            textView.setText(deliveryCourierOrderUpdateResourceProvider.getSellerTitle());
        }
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24_black);
        toolbar.setNavigationOnClickListener(new a(0, this));
        this.d = toolbar;
        View findViewById3 = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.g = new ProgressOverlay(viewGroup, 0, analytics2, false, 0, 26, null);
        View findViewById4 = view.findViewById(R.id.recycler_view);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.addItemDecoration(new PaddingListDecoration(recyclerView.getResources().getDimensionPixelOffset(R.dimen.order_update_fragment_recycler_view_top_padding), recyclerView.getResources().getDimensionPixelSize(R.dimen.order_update_fragment_recycler_view_bottom_padding), 0, 0, 12, null));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this, viewGroup) { // from class: com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment$onViewCreated$$inlined$apply$lambda$2
            public final /* synthetic */ ViewGroup a;

            {
                this.a = r2;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i2, int i3) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                if (Build.VERSION.SDK_INT < 23) {
                    return;
                }
                if (recyclerView2.canScrollVertically(-1)) {
                    ViewGroup viewGroup2 = this.a;
                    viewGroup2.setForeground(viewGroup2.getContext().getDrawable(com.avito.android.deprecated_design.R.drawable.shadow_toolbar));
                    return;
                }
                this.a.setForeground(null);
            }
        });
        View findViewById5 = view.findViewById(R.id.submit_button);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById5;
        Source source3 = this.c;
        if (source3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("source");
        }
        if (source3 == source2) {
            i = R.string.courier_update_fragment_seller_submit_button_text;
        } else {
            i = R.string.courier_update_fragment_buyer_submit_button_text;
        }
        button.setText(i);
        button.setOnClickListener(new a(1, this));
        this.e = button;
        View findViewById6 = view.findViewById(R.id.cancel_button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button2 = (Button) findViewById6;
        button2.setOnClickListener(new a(2, this));
        this.f = button2;
        FragmentActivity activity = getActivity();
        KeyboardSubscription keyboardSubscription = null;
        if (activity != null) {
            keyboardSubscription = Keyboards.addSoftKeyboardVisibilityListener$default((Activity) activity, false, (Function1) new b(this), 1, (Object) null);
        }
        this.h = keyboardSubscription;
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.performanceTracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
        }
        baseScreenPerformanceTracker.trackInit();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkFactory(@NotNull DeepLinkFactory deepLinkFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkFactory2, "<set-?>");
        this.deepLinkFactory = deepLinkFactory2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPerformanceTracker(@NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "<set-?>");
        this.performanceTracker = baseScreenPerformanceTracker;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setResourceProvider(@NotNull DeliveryCourierOrderUpdateResourceProvider deliveryCourierOrderUpdateResourceProvider) {
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateResourceProvider, "<set-?>");
        this.resourceProvider = deliveryCourierOrderUpdateResourceProvider;
    }

    public final void setTracker(@NotNull DeliveryCourierOrderUpdateAnalyticsTracker deliveryCourierOrderUpdateAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateAnalyticsTracker, "<set-?>");
        this.tracker = deliveryCourierOrderUpdateAnalyticsTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: throw Illeg…tion(\"Arguments not set\")");
            String string = arguments.getString("EXTRA_ORDER_ID");
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "arguments.getString(EXTR…eption(\"orderID not set\")");
                String string2 = arguments.getString("EXTRA_SOURCE");
                if (string2 != null) {
                    Intrinsics.checkNotNullExpressionValue(string2, "arguments.getString(EXTR…ception(\"source not set\")");
                    this.c = Intrinsics.areEqual(string2, "seller") ? Source.SELLER : Source.BUYER;
                    Timer B1 = a2.b.a.a.a.B1();
                    DeliveryCourierOrderUpdateComponent.Builder deliveryCourierOrderUpdateDependencies = DaggerDeliveryCourierOrderUpdateComponent.builder().deliveryCourierOrderUpdateDependencies((DeliveryCourierOrderUpdateDependencies) ComponentDependenciesKt.getDependencies(DeliveryCourierOrderUpdateDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
                    FragmentActivity activity = getActivity();
                    Objects.requireNonNull(activity, "null cannot be cast to non-null type android.app.Activity");
                    DeliveryCourierOrderUpdateComponent.Builder source = deliveryCourierOrderUpdateDependencies.activity(activity).orderID(string).source(string2);
                    Resources resources = getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "resources");
                    source.resources(resources).viewModelFragment(this).build().inject(this);
                    BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.performanceTracker;
                    if (baseScreenPerformanceTracker == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
                    }
                    baseScreenPerformanceTracker.trackDiInject(B1.elapsed());
                    return true;
                }
                throw new IllegalStateException("source not set");
            }
            throw new IllegalStateException("orderID not set");
        }
        throw new IllegalStateException("Arguments not set");
    }

    public final void setViewModel(@NotNull DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateViewModel, "<set-?>");
        this.viewModel = deliveryCourierOrderUpdateViewModel;
    }
}

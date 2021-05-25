package com.avito.android.safedeal.delivery_type;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.delivery_courier.ScreenStyle;
import com.avito.android.safedeal.delivery_type.di.DaggerDeliveryTypeComponent;
import com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.facebook.internal.AnalyticsEvents;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001mB\u0007¢\u0006\u0004\bl\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u0019\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u0014J\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J)\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\"\u0010?\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010F\u001a\u00020E8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010M\u001a\u00020L8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\"\u0010X\u001a\u00020W8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010_\u001a\u00020^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010f\u001a\u00020e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k¨\u0006n"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeFragmentDelegate;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onActivityCreated", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "closeScreen", "Landroid/content/Intent;", "intent", "launchActivity", "(Landroid/content/Intent;)V", "showAuthScreen", "", "stringId", "launchToast", "(I)V", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/safedeal/delivery_courier/ScreenStyle;", "e", "Lcom/avito/android/safedeal/delivery_courier/ScreenStyle;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeView;", "c", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeView;", "deliveryTypeView", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/android/recycler/base/SafeRecyclerAdapter;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getDestroyableViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setDestroyableViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeRouter;", "d", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeRouter;", "deliveryTypeRouter", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypePresenter;", "presenter", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypePresenter;", "getPresenter", "()Lcom/avito/android/safedeal/delivery_type/DeliveryTypePresenter;", "setPresenter", "(Lcom/avito/android/safedeal/delivery_type/DeliveryTypePresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "<init>", "Companion", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryTypeFragment extends BaseFragment implements DeliveryTypeFragmentDelegate {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    public DeliveryTypeView c;
    public DeliveryTypeRouter d;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DestroyableViewHolderBuilder destroyableViewHolderBuilder;
    public ScreenStyle e;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public DeliveryTypePresenter presenter;
    @Inject
    public SafeRecyclerAdapter recyclerAdapter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeFragment$Companion;", "", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;", "deliveryTypeData", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeFragment;", "newInstance", "(Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;)Lcom/avito/android/safedeal/delivery_type/DeliveryTypeFragment;", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ DeliveryTypeData a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(DeliveryTypeData deliveryTypeData) {
                super(1);
                this.a = deliveryTypeData;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("deliveryTypesData", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final DeliveryTypeFragment newInstance(@NotNull DeliveryTypeData deliveryTypeData) {
            Intrinsics.checkNotNullParameter(deliveryTypeData, "deliveryTypeData");
            return (DeliveryTypeFragment) FragmentsKt.arguments$default(new DeliveryTypeFragment(), 0, new a(deliveryTypeData), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DeliveryTypeFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DeliveryTypeFragment deliveryTypeFragment) {
            super(0);
            this.a = deliveryTypeFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            DeliveryTypeRouter deliveryTypeRouter = this.a.d;
            if (deliveryTypeRouter != null) {
                deliveryTypeRouter.closeScreen();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeFragmentDelegate
    public void closeScreen() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
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
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final AttributedTextFormatter getAttributedTextFormatter() {
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        return attributedTextFormatter2;
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
    public final DestroyableViewHolderBuilder getDestroyableViewHolderBuilder() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        return destroyableViewHolderBuilder2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final DeliveryTypePresenter getPresenter() {
        DeliveryTypePresenter deliveryTypePresenter = this.presenter;
        if (deliveryTypePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return deliveryTypePresenter;
    }

    @NotNull
    public final SafeRecyclerAdapter getRecyclerAdapter() {
        SafeRecyclerAdapter safeRecyclerAdapter = this.recyclerAdapter;
        if (safeRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return safeRecyclerAdapter;
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeFragmentDelegate
    public void launchActivity(@Nullable Intent intent) {
        startActivityForResult(intent, 164);
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeFragmentDelegate
    public void launchToast(int i) {
        Context context = getContext();
        if (context != null) {
            ToastsKt.showToast(context, i, 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ScreenStyle screenStyle = this.e;
        if (screenStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        }
        if (screenStyle == ScreenStyle.BOTTOM_SHEET) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
            AdapterPresenter adapterPresenter2 = this.adapterPresenter;
            if (adapterPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
            }
            SafeRecyclerAdapter safeRecyclerAdapter = this.recyclerAdapter;
            if (safeRecyclerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
            }
            DeliveryTypePresenter deliveryTypePresenter = this.presenter;
            if (deliveryTypePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
            if (attributedTextFormatter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
            }
            DeliveryTypeBottomSheetViewImpl deliveryTypeBottomSheetViewImpl = new DeliveryTypeBottomSheetViewImpl(bottomSheetDialog, adapterPresenter2, safeRecyclerAdapter, deliveryTypePresenter, attributedTextFormatter2);
            deliveryTypeBottomSheetViewImpl.setOnDismissListener(new a(this));
            this.c = deliveryTypeBottomSheetViewImpl;
            return;
        }
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        AdapterPresenter adapterPresenter3 = this.adapterPresenter;
        if (adapterPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        SafeRecyclerAdapter safeRecyclerAdapter2 = this.recyclerAdapter;
        if (safeRecyclerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        DeliveryTypePresenter deliveryTypePresenter2 = this.presenter;
        if (deliveryTypePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        AttributedTextFormatter attributedTextFormatter3 = this.attributedTextFormatter;
        if (attributedTextFormatter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        this.c = new DeliveryTypeViewImpl(requireView, adapterPresenter3, safeRecyclerAdapter2, deliveryTypePresenter2, attributedTextFormatter3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        FragmentActivity activity;
        super.onActivityResult(i, i2, intent);
        if (i != 164) {
            if (i == 165 && i2 != -1 && (activity = getActivity()) != null) {
                activity.finish();
            }
        } else if (i2 == -1) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.setResult(-1, intent);
            }
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
            }
        }
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            DeliveryTypePresenter deliveryTypePresenter = this.presenter;
            if (deliveryTypePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            deliveryTypePresenter.restoreState(bundle.getBundle("deliveryTypePresenter"));
        }
        if (this.d == null) {
            DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            this.d = new DeliveryTypeRouterImpl(deepLinkIntentFactory2, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ScreenStyle screenStyle = this.e;
        if (screenStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        }
        if (screenStyle == ScreenStyle.BOTTOM_SHEET) {
            i = R.layout.fragment_delivery_type_with_bottom_sheet;
        } else {
            i = R.layout.fragment_delivery_type;
        }
        return layoutInflater.inflate(i, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        destroyableViewHolderBuilder2.destroy();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        DeliveryTypePresenter deliveryTypePresenter = this.presenter;
        if (deliveryTypePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("deliveryTypePresenter", deliveryTypePresenter.saveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        DeliveryTypeView deliveryTypeView = this.c;
        if (deliveryTypeView != null) {
            DeliveryTypePresenter deliveryTypePresenter = this.presenter;
            if (deliveryTypePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            deliveryTypePresenter.attachView(deliveryTypeView);
        }
        DeliveryTypePresenter deliveryTypePresenter2 = this.presenter;
        if (deliveryTypePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        deliveryTypePresenter2.attachRouter(this.d);
        DeliveryTypePresenter deliveryTypePresenter3 = this.presenter;
        if (deliveryTypePresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        deliveryTypePresenter3.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        DeliveryTypePresenter deliveryTypePresenter = this.presenter;
        if (deliveryTypePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        deliveryTypePresenter.onStop();
        DeliveryTypePresenter deliveryTypePresenter2 = this.presenter;
        if (deliveryTypePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        deliveryTypePresenter2.detachRouter();
        DeliveryTypePresenter deliveryTypePresenter3 = this.presenter;
        if (deliveryTypePresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        deliveryTypePresenter3.detachView();
        super.onStop();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDestroyableViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder2) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder2, "<set-?>");
        this.destroyableViewHolderBuilder = destroyableViewHolderBuilder2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setPresenter(@NotNull DeliveryTypePresenter deliveryTypePresenter) {
        Intrinsics.checkNotNullParameter(deliveryTypePresenter, "<set-?>");
        this.presenter = deliveryTypePresenter;
    }

    public final void setRecyclerAdapter(@NotNull SafeRecyclerAdapter safeRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = safeRecyclerAdapter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: return false");
        Parcelable parcelable = arguments.getParcelable("deliveryTypesData");
        if (parcelable != null) {
            DeliveryTypeData deliveryTypeData = (DeliveryTypeData) parcelable;
            this.e = deliveryTypeData.getStyle();
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            DaggerDeliveryTypeComponent.factory().create((DeliveryTypeDependencies) ComponentDependenciesKt.getDependencies(DeliveryTypeDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)), deliveryTypeData, resources).inject(this);
            return true;
        }
        throw new IllegalStateException("deliveryTypesData argument must be not null".toString());
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeFragmentDelegate
    public void showAuthScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, "d", null, 5, null), 165);
    }
}

package com.avito.android.tariff.edit_info;

import a2.a.a.e3.d.c;
import a2.a.a.e3.d.d;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PaymentSessionLink;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.bottom_sheet.RightCrossHeaderKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.R;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.edit_info.di.DaggerEditInfoComponent;
import com.avito.android.tariff.edit_info.di.EditInfoComponent;
import com.avito.android.tariff.edit_info.di.TabsAdapterPresenter;
import com.avito.android.tariff.edit_info.di.TabsRecyclerAdapter;
import com.avito.android.tariff.edit_info.item.tabs.TabsItemPresenter;
import com.avito.android.tariff.edit_info.viewmodel.BottomSheetParams;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel;
import com.avito.android.util.Contexts;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedRecyclerView;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedValue;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.z;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\b¢\u0006\u0005\b\u0001\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R+\u0010)\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8B@BX\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010*\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0018\n\u0004\b*\u0010\u001c\u0012\u0004\b-\u0010.\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R5\u00106\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u000304¢\u0006\u0002\b5038\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR+\u0010J\u001a\u00020C2\u0006\u0010\"\u001a\u00020C8B@BX\u0002¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010L\u001a\u00020K8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR(\u0010S\u001a\u00020R8\u0006@\u0006X.¢\u0006\u0018\n\u0004\bS\u0010T\u0012\u0004\bY\u0010.\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010[\u001a\u00020Z8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010b\u001a\u00020a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR+\u0010n\u001a\u00020h2\u0006\u0010\"\u001a\u00020h8B@BX\u0002¢\u0006\u0012\n\u0004\bi\u0010$\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR+\u0010r\u001a\u00020C2\u0006\u0010\"\u001a\u00020C8B@BX\u0002¢\u0006\u0012\n\u0004\bo\u0010E\u001a\u0004\bp\u0010G\"\u0004\bq\u0010IR\u0018\u0010v\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\"\u0010x\u001a\u00020w8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R'\u0010\u001a\u00020~8\u0006@\u0006X.¢\u0006\u0017\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/tariff/edit_info/EditInfoFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Landroidx/appcompat/widget/Toolbar;", "<set-?>", "c", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar", "tabsRecyclerAdapter", "getTabsRecyclerAdapter", "setTabsRecyclerAdapter", "getTabsRecyclerAdapter$annotations", "()V", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "f", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "bottomSheetDialog", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedRecyclerView;", "getTabsRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setTabsRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "tabsRecyclerView", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "tabsAdapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getTabsAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setTabsAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "getTabsAdapterPresenter$annotations", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;", "tabsItemPresenter", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;", "getTabsItemPresenter", "()Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;", "setTabsItemPresenter", "(Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "getProgressOverlay", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "setProgressOverlay", "(Lcom/avito/android/progress_overlay/ProgressOverlay;)V", "progressOverlay", AuthSource.SEND_ABUSE, "getRecyclerView", "setRecyclerView", "recyclerView", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "e", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "router", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModel;", "viewModel", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModel;", "getViewModel", "()Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModel;", "setViewModel", "(Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModel;)V", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "()Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setItemDecoration", "(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V", "<init>", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class EditInfoFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] g = {a2.b.a.a.a.u0(EditInfoFragment.class, "recyclerView", "getRecyclerView()Landroidx/recyclerview/widget/RecyclerView;", 0), a2.b.a.a.a.u0(EditInfoFragment.class, "tabsRecyclerView", "getTabsRecyclerView()Landroidx/recyclerview/widget/RecyclerView;", 0), a2.b.a.a.a.u0(EditInfoFragment.class, "toolbar", "getToolbar()Landroidx/appcompat/widget/Toolbar;", 0), a2.b.a.a.a.u0(EditInfoFragment.class, "progressOverlay", "getProgressOverlay()Lcom/avito/android/progress_overlay/ProgressOverlay;", 0)};
    public final AutoClearedRecyclerView a = new AutoClearedRecyclerView();
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    public final AutoClearedRecyclerView b = new AutoClearedRecyclerView();
    public final AutoClearedValue c = new AutoClearedValue();
    public final AutoClearedValue d = new AutoClearedValue();
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    public PaidServicesRouter e;
    public BottomSheetDialog f;
    @Inject
    public RecyclerView.ItemDecoration itemDecoration;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public AdapterPresenter tabsAdapterPresenter;
    @Inject
    public TabsItemPresenter tabsItemPresenter;
    @Inject
    public SimpleRecyclerAdapter tabsRecyclerAdapter;
    @Inject
    public EditInfoViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/tariff/edit_info/EditInfoFragment$Companion;", "", "", "checkoutContext", "Lcom/avito/android/tariff/edit_info/EditInfoFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/tariff/edit_info/EditInfoFragment;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final EditInfoFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "checkoutContext");
            EditInfoFragment editInfoFragment = new EditInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("checkout_context", str);
            editInfoFragment.setArguments(bundle);
            return editInfoFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ EditInfoFragment a;

        public a(EditInfoFragment editInfoFragment) {
            this.a = editInfoFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.requireActivity().onBackPressed();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EditInfoFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(EditInfoFragment editInfoFragment) {
            super(0);
            this.a = editInfoFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final ProgressOverlay access$getProgressOverlay$p(EditInfoFragment editInfoFragment) {
        return (ProgressOverlay) editInfoFragment.d.getValue((Fragment) editInfoFragment, g[3]);
    }

    public static final Toolbar access$getToolbar$p(EditInfoFragment editInfoFragment) {
        return (Toolbar) editInfoFragment.c.getValue((Fragment) editInfoFragment, g[2]);
    }

    public static final void access$resolveDeeplink(EditInfoFragment editInfoFragment, DeepLink deepLink) {
        Objects.requireNonNull(editInfoFragment);
        if (deepLink instanceof PaymentSessionLink) {
            DeepLinkIntentFactory deepLinkIntentFactory2 = editInfoFragment.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
            if (intent != null) {
                editInfoFragment.startActivityForResult(intent, 13);
                return;
            }
            return;
        }
        PaidServicesRouter paidServicesRouter = editInfoFragment.e;
        if (paidServicesRouter != null) {
            paidServicesRouter.navigate(deepLink);
        }
    }

    public static final void access$setProgressOverlay$p(EditInfoFragment editInfoFragment, ProgressOverlay progressOverlay) {
        editInfoFragment.d.setValue((Fragment) editInfoFragment, g[3], (KProperty<?>) progressOverlay);
    }

    public static final void access$setToolbar$p(EditInfoFragment editInfoFragment, Toolbar toolbar) {
        editInfoFragment.c.setValue((Fragment) editInfoFragment, g[2], (KProperty<?>) toolbar);
    }

    public static final void access$showBottomSheet(EditInfoFragment editInfoFragment, BottomSheetParams bottomSheetParams) {
        Objects.requireNonNull(editInfoFragment);
        Context requireContext = editInfoFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
        View inflate = View.inflate(bottomSheetDialog.getContext(), R.layout.bottom_sheet_layout_info, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "contentView");
        bottomSheetDialog.setContentView(inflate, true);
        RightCrossHeaderKt.setRightCrossHeader(bottomSheetDialog, bottomSheetParams.getTitle(), true, true);
        TextView textView = (TextView) inflate.findViewById(R.id.description);
        Button button = (Button) inflate.findViewById(R.id.primary_button);
        Button button2 = (Button) inflate.findViewById(R.id.secondary_button);
        Intrinsics.checkNotNullExpressionValue(textView, "description");
        List<AttributedText> description = bottomSheetParams.getDescription();
        StringBuilder sb = new StringBuilder();
        if (description != null) {
            for (T t : description) {
                AttributedTextFormatter attributedTextFormatter2 = editInfoFragment.attributedTextFormatter;
                if (attributedTextFormatter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
                }
                Context requireContext2 = editInfoFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                sb.append(attributedTextFormatter2.format(requireContext2, t));
                sb.append("\n");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        textView.setText(sb2);
        button.setAppearanceFromAttr(bottomSheetParams.getPrimaryButtonStyle());
        Intrinsics.checkNotNullExpressionValue(button, "primaryButton");
        ButtonsKt.bindText$default(button, bottomSheetParams.getPrimaryButtonText(), false, 2, null);
        Integer primaryButtonDrawable = bottomSheetParams.getPrimaryButtonDrawable();
        if (primaryButtonDrawable != null) {
            int intValue = primaryButtonDrawable.intValue();
            Context context = bottomSheetDialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Button.setImageDrawable$default(button, Contexts.getDrawableByAttr(context, intValue), null, false, 6, null);
        }
        Intrinsics.checkNotNullExpressionValue(button2, "secondaryButton");
        ButtonsKt.bindText$default(button2, bottomSheetParams.getSecondaryButtonText(), false, 2, null);
        button.setOnClickListener(new v3(0, editInfoFragment, bottomSheetParams));
        button2.setOnClickListener(new v3(1, editInfoFragment, bottomSheetParams));
        bottomSheetDialog.show();
        editInfoFragment.f = bottomSheetDialog;
    }

    @TabsAdapterPresenter
    public static /* synthetic */ void getTabsAdapterPresenter$annotations() {
    }

    @TabsRecyclerAdapter
    public static /* synthetic */ void getTabsRecyclerAdapter$annotations() {
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
    public final RecyclerView.ItemDecoration getItemDecoration() {
        RecyclerView.ItemDecoration itemDecoration2 = this.itemDecoration;
        if (itemDecoration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemDecoration");
        }
        return itemDecoration2;
    }

    @NotNull
    public final Set<ItemPresenter<?, ?>> getItemPresenterSet() {
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        return set;
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
    public final AdapterPresenter getTabsAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.tabsAdapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsAdapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final TabsItemPresenter getTabsItemPresenter() {
        TabsItemPresenter tabsItemPresenter2 = this.tabsItemPresenter;
        if (tabsItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsItemPresenter");
        }
        return tabsItemPresenter2;
    }

    @NotNull
    public final SimpleRecyclerAdapter getTabsRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.tabsRecyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsRecyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final EditInfoViewModel getViewModel() {
        EditInfoViewModel editInfoViewModel = this.viewModel;
        if (editInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return editInfoViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 13 && i2 == -1) {
            EditInfoViewModel editInfoViewModel = this.viewModel;
            if (editInfoViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            editInfoViewModel.loadData();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        ComponentProvider componentProvider = (ComponentProvider) (!(context instanceof ComponentProvider) ? null : context);
        if (componentProvider != null) {
            TariffStepDependencies tariffStepDependencies = (TariffStepDependencies) componentProvider.getComponent();
            Bundle arguments = getArguments();
            if (arguments == null || (string = arguments.getString("checkout_context")) == null) {
                throw new IllegalStateException("checkout context must be set");
            }
            Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…out context must be set\")");
            if (!(context instanceof PaidServicesRouter)) {
                context = null;
            }
            PaidServicesRouter paidServicesRouter = (PaidServicesRouter) context;
            if (paidServicesRouter != null) {
                this.e = paidServicesRouter;
                EditInfoComponent.Factory factory = DaggerEditInfoComponent.factory();
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                factory.create(this, string, resources, tariffStepDependencies).inject(this);
                EditInfoViewModel editInfoViewModel = this.viewModel;
                if (editInfoViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
                if (set == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
                }
                TabsItemPresenter tabsItemPresenter2 = this.tabsItemPresenter;
                if (tabsItemPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabsItemPresenter");
                }
                editInfoViewModel.observeItemClicks(z.plus(set, tabsItemPresenter2));
                return;
            }
            throw new IllegalStateException("Parent activity must implement PaidServicesRouter");
        }
        throw new IllegalStateException("Parent activity must implement ComponentProvider");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.edit_info_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        int i = R.id.recycler_view;
        View findViewById = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_view)");
        AutoClearedRecyclerView autoClearedRecyclerView = this.a;
        KProperty<?>[] kPropertyArr = g;
        autoClearedRecyclerView.setValue((Fragment) this, kPropertyArr[0], (KProperty<?>) ((RecyclerView) findViewById));
        RecyclerView recyclerView = (RecyclerView) this.a.getValue((Fragment) this, kPropertyArr[0]);
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
        RecyclerView recyclerView2 = (RecyclerView) this.a.getValue((Fragment) this, kPropertyArr[0]);
        RecyclerView.ItemDecoration itemDecoration2 = this.itemDecoration;
        if (itemDecoration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemDecoration");
        }
        recyclerView2.addItemDecoration(itemDecoration2);
        View findViewById2 = view.findViewById(R.id.tabs_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tabs_recycler_view)");
        this.b.setValue((Fragment) this, kPropertyArr[1], (KProperty<?>) ((RecyclerView) findViewById2));
        RecyclerView recyclerView3 = (RecyclerView) this.b.getValue((Fragment) this, kPropertyArr[1]);
        SimpleRecyclerAdapter simpleRecyclerAdapter2 = this.tabsRecyclerAdapter;
        if (simpleRecyclerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsRecyclerAdapter");
        }
        recyclerView3.setAdapter(simpleRecyclerAdapter2);
        View findViewById3 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.toolbar)");
        this.c.setValue((Fragment) this, kPropertyArr[2], (KProperty<?>) ((Toolbar) findViewById3));
        ((Toolbar) this.c.getValue((Fragment) this, kPropertyArr[2])).setNavigationOnClickListener(new a(this));
        View findViewById4 = view.findViewById(R.id.progress_placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.progress_placeholder)");
        this.d.setValue((Fragment) this, kPropertyArr[3], (KProperty<?>) new ProgressOverlay((ViewGroup) findViewById4, i, null, false, 0, 28, null));
        ((ProgressOverlay) this.d.getValue((Fragment) this, kPropertyArr[3])).setOnRefreshListener(new b(this));
        EditInfoViewModel editInfoViewModel = this.viewModel;
        if (editInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editInfoViewModel.getProgressChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.d.a(this));
        EditInfoViewModel editInfoViewModel2 = this.viewModel;
        if (editInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editInfoViewModel2.getListChanges().observe(getViewLifecycleOwner(), new h2(0, this));
        EditInfoViewModel editInfoViewModel3 = this.viewModel;
        if (editInfoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editInfoViewModel3.getHeaderChanges().observe(getViewLifecycleOwner(), new h2(1, this));
        EditInfoViewModel editInfoViewModel4 = this.viewModel;
        if (editInfoViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editInfoViewModel4.getBottomSheetActionChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.d.b(this));
        EditInfoViewModel editInfoViewModel5 = this.viewModel;
        if (editInfoViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editInfoViewModel5.getCloseBottomSheetChanges().observe(getViewLifecycleOwner(), new c(this));
        EditInfoViewModel editInfoViewModel6 = this.viewModel;
        if (editInfoViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editInfoViewModel6.getTitleChanges().observe(getViewLifecycleOwner(), new x0(0, this));
        EditInfoViewModel editInfoViewModel7 = this.viewModel;
        if (editInfoViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DeepLink> routingEvents = editInfoViewModel7.getRoutingEvents();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        routingEvents.observe(viewLifecycleOwner, new d(this));
        EditInfoViewModel editInfoViewModel8 = this.viewModel;
        if (editInfoViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editInfoViewModel8.getErrorChanges().observe(getViewLifecycleOwner(), new x0(1, this));
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setItemDecoration(@NotNull RecyclerView.ItemDecoration itemDecoration2) {
        Intrinsics.checkNotNullParameter(itemDecoration2, "<set-?>");
        this.itemDecoration = itemDecoration2;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setTabsAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.tabsAdapterPresenter = adapterPresenter2;
    }

    public final void setTabsItemPresenter(@NotNull TabsItemPresenter tabsItemPresenter2) {
        Intrinsics.checkNotNullParameter(tabsItemPresenter2, "<set-?>");
        this.tabsItemPresenter = tabsItemPresenter2;
    }

    public final void setTabsRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.tabsRecyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setViewModel(@NotNull EditInfoViewModel editInfoViewModel) {
        Intrinsics.checkNotNullParameter(editInfoViewModel, "<set-?>");
        this.viewModel = editInfoViewModel;
    }
}

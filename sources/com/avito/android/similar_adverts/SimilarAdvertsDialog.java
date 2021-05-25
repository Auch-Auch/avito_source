package com.avito.android.similar_adverts;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.bottom_sheet.RightCrossHeaderKt;
import com.avito.android.rec.ScreenSource;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.similar_adverts.di.DaggerSimilarAdvertsComponent;
import com.avito.android.similar_adverts.di.SimilarAdvertsComponent;
import com.avito.android.similar_adverts.di.SimilarAdvertsDependencies;
import com.avito.android.util.Contexts;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\bQ\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lcom/avito/android/similar_adverts/SimilarAdvertsDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDestroyView", "()V", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "setSpanSizeLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoriteAdvertsPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "setFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenter;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/similar_adverts/SimilarAdvertsView;", AuthSource.SEND_ABUSE, "Lcom/avito/android/similar_adverts/SimilarAdvertsView;", "similarAdvertsView", "Lcom/avito/android/section/action/SectionActionPresenter;", "sectionActionPresenter", "Lcom/avito/android/section/action/SectionActionPresenter;", "getSectionActionPresenter", "()Lcom/avito/android/section/action/SectionActionPresenter;", "setSectionActionPresenter", "(Lcom/avito/android/section/action/SectionActionPresenter;)V", "Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;", "resourceProvider", "Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;", "getResourceProvider", "()Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;", "setResourceProvider", "(Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;)V", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "serpSpanProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "getSerpSpanProvider", "()Lcom/avito/android/serp/adapter/SerpSpanProvider;", "setSerpSpanProvider", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)V", "Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;", "viewModel", "Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;", "getViewModel$similar_adverts_release", "()Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;", "setViewModel$similar_adverts_release", "(Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "Companion", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SimilarAdvertsDialog extends DialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public SimilarAdvertsView a;
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public FavoriteAdvertsPresenter favoriteAdvertsPresenter;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public SimilarAdvertsResourceProvider resourceProvider;
    @Inject
    public SectionActionPresenter sectionActionPresenter;
    @Inject
    public SerpSpanProvider serpSpanProvider;
    @Inject
    public GridLayoutManager.SpanSizeLookup spanSizeLookup;
    @Inject
    public SimilarAdvertsViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/similar_adverts/SimilarAdvertsDialog$Companion;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "isShop", "Lcom/avito/android/similar_adverts/SimilarAdvertsDialog;", "createInstance", "(Ljava/lang/String;Z)Lcom/avito/android/similar_adverts/SimilarAdvertsDialog;", "<init>", "()V", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final SimilarAdvertsDialog createInstance(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            SimilarAdvertsDialog similarAdvertsDialog = new SimilarAdvertsDialog();
            Bundle bundle = new Bundle(2);
            bundle.putString("ARG_ADVERT_ID", str);
            bundle.putBoolean("ARG_SHOP", z);
            similarAdvertsDialog.setArguments(bundle);
            return similarAdvertsDialog;
        }

        public Companion(j jVar) {
        }
    }

    public static final void access$onViewInflate(SimilarAdvertsDialog similarAdvertsDialog, View view) {
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = similarAdvertsDialog.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        FragmentActivity requireActivity = similarAdvertsDialog.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        SimpleRecyclerAdapter simpleRecyclerAdapter = similarAdvertsDialog.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        SimilarAdvertsResourceProvider similarAdvertsResourceProvider = similarAdvertsDialog.resourceProvider;
        if (similarAdvertsResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        DeepLinkIntentFactory deepLinkIntentFactory2 = similarAdvertsDialog.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = similarAdvertsDialog.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        SerpSpanProvider serpSpanProvider2 = similarAdvertsDialog.serpSpanProvider;
        if (serpSpanProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serpSpanProvider");
        }
        DataAwareAdapterPresenter dataAwareAdapterPresenter = similarAdvertsDialog.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        SimilarAdvertsViewImpl similarAdvertsViewImpl = new SimilarAdvertsViewImpl(view, requireActivity, deepLinkIntentFactory2, dataAwareAdapterPresenter, favoriteAdvertsPresenter2, serpSpanProvider2, spanSizeLookup2, similarAdvertsResourceProvider, simpleRecyclerAdapter);
        similarAdvertsDialog.a = similarAdvertsViewImpl;
        SimilarAdvertsViewModel similarAdvertsViewModel = similarAdvertsDialog.viewModel;
        if (similarAdvertsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        similarAdvertsViewImpl.bindTo(similarAdvertsViewModel);
        FavoriteAdvertsPresenter favoriteAdvertsPresenter3 = similarAdvertsDialog.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        SimilarAdvertsView similarAdvertsView = similarAdvertsDialog.a;
        Intrinsics.checkNotNull(similarAdvertsView);
        favoriteAdvertsPresenter3.attachView(similarAdvertsView);
        SectionActionPresenter sectionActionPresenter2 = similarAdvertsDialog.sectionActionPresenter;
        if (sectionActionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionActionPresenter");
        }
        SimilarAdvertsViewModel similarAdvertsViewModel2 = similarAdvertsDialog.viewModel;
        if (similarAdvertsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        sectionActionPresenter2.attachRouter(similarAdvertsViewModel2);
        SimilarAdvertsViewModel similarAdvertsViewModel3 = similarAdvertsDialog.viewModel;
        if (similarAdvertsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        similarAdvertsViewModel3.updateSimilarAdvertItems();
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
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final FavoriteAdvertsPresenter getFavoriteAdvertsPresenter() {
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        return favoriteAdvertsPresenter2;
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
    public final SimilarAdvertsResourceProvider getResourceProvider() {
        SimilarAdvertsResourceProvider similarAdvertsResourceProvider = this.resourceProvider;
        if (similarAdvertsResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        return similarAdvertsResourceProvider;
    }

    @NotNull
    public final SectionActionPresenter getSectionActionPresenter() {
        SectionActionPresenter sectionActionPresenter2 = this.sectionActionPresenter;
        if (sectionActionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionActionPresenter");
        }
        return sectionActionPresenter2;
    }

    @NotNull
    public final SerpSpanProvider getSerpSpanProvider() {
        SerpSpanProvider serpSpanProvider2 = this.serpSpanProvider;
        if (serpSpanProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serpSpanProvider");
        }
        return serpSpanProvider2;
    }

    @NotNull
    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        return spanSizeLookup2;
    }

    @NotNull
    public final SimilarAdvertsViewModel getViewModel$similar_adverts_release() {
        SimilarAdvertsViewModel similarAdvertsViewModel = this.viewModel;
        if (similarAdvertsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return similarAdvertsViewModel;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("ARG_ADVERT_ID")) == null) {
            throw new IllegalStateException("Argument ARG_ADVERT_ID must be set");
        }
        Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(ARG…G_ADVERT_ID must be set\")");
        Bundle arguments2 = getArguments();
        boolean z = arguments2 != null ? arguments2.getBoolean("ARG_SHOP") : false;
        SimilarAdvertsComponent.Factory factory = DaggerSimilarAdvertsComponent.factory();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(requireActivity, resources, this, string, null, ScreenSource.FAVORITES.INSTANCE, z, (SimilarAdvertsDependencies) ComponentDependenciesKt.getDependencies(SimilarAdvertsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
        bottomSheetDialog.setContentView(R.layout.similar_adverts, true, new Function1<View, Unit>(this) { // from class: com.avito.android.similar_adverts.SimilarAdvertsDialog.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                SimilarAdvertsDialog.access$onViewInflate((SimilarAdvertsDialog) this.receiver, view2);
                return Unit.INSTANCE;
            }
        });
        RightCrossHeaderKt.setRightCrossHeader$default(bottomSheetDialog, null, false, true, 1, null);
        Context context = bottomSheetDialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bottomSheetDialog.setPeekHeight(Contexts.getDisplayHeight(context));
        bottomSheetDialog.setForceExpandedState(true);
        bottomSheetDialog.setSkipCollapsed(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter2.detachViews();
        SectionActionPresenter sectionActionPresenter2 = this.sectionActionPresenter;
        if (sectionActionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionActionPresenter");
        }
        sectionActionPresenter2.detachRouter();
        SimilarAdvertsView similarAdvertsView = this.a;
        if (similarAdvertsView != null) {
            SimilarAdvertsViewModel similarAdvertsViewModel = this.viewModel;
            if (similarAdvertsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            similarAdvertsView.onDestroyView(similarAdvertsViewModel);
        }
        this.a = null;
        super.onDestroyView();
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter2, "<set-?>");
        this.favoriteAdvertsPresenter = favoriteAdvertsPresenter2;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setResourceProvider(@NotNull SimilarAdvertsResourceProvider similarAdvertsResourceProvider) {
        Intrinsics.checkNotNullParameter(similarAdvertsResourceProvider, "<set-?>");
        this.resourceProvider = similarAdvertsResourceProvider;
    }

    public final void setSectionActionPresenter(@NotNull SectionActionPresenter sectionActionPresenter2) {
        Intrinsics.checkNotNullParameter(sectionActionPresenter2, "<set-?>");
        this.sectionActionPresenter = sectionActionPresenter2;
    }

    public final void setSerpSpanProvider(@NotNull SerpSpanProvider serpSpanProvider2) {
        Intrinsics.checkNotNullParameter(serpSpanProvider2, "<set-?>");
        this.serpSpanProvider = serpSpanProvider2;
    }

    public final void setSpanSizeLookup(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup2) {
        Intrinsics.checkNotNullParameter(spanSizeLookup2, "<set-?>");
        this.spanSizeLookup = spanSizeLookup2;
    }

    public final void setViewModel$similar_adverts_release(@NotNull SimilarAdvertsViewModel similarAdvertsViewModel) {
        Intrinsics.checkNotNullParameter(similarAdvertsViewModel, "<set-?>");
        this.viewModel = similarAdvertsViewModel;
    }
}

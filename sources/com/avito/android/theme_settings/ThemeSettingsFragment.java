package com.avito.android.theme_settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.settings.R;
import com.avito.android.theme_settings.di.DaggerThemeSettingsComponent;
import com.avito.android.theme_settings.di.ThemeSettingsDependencies;
import com.avito.android.theme_settings.item.ThemeModeItemPresenter;
import com.avito.android.theme_settings.ui.ThemeSettingsPaddingDecoration;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModel;
import com.avito.android.util.Toolbars;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 P2\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\bN\u0010OJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R-\u0010:\u001a\r\u0012\t\u0012\u000708¢\u0006\u0002\b9078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006Q"}, d2 = {"Lcom/avito/android/theme_settings/ThemeSettingsFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "getGridPositionProvider", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "setGridPositionProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsViewModel;", "viewModel", "Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsViewModel;", "getViewModel", "()Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsViewModel;", "setViewModel", "(Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsViewModel;)V", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "", "Lcom/avito/android/theme_settings/item/ThemeModeItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenters", "Ljava/util/Set;", "getItemPresenters", "()Ljava/util/Set;", "setItemPresenters", "(Ljava/util/Set;)V", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "serpSpanProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "getSerpSpanProvider", "()Lcom/avito/android/serp/adapter/SerpSpanProvider;", "setSerpSpanProvider", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)V", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "setSpanSizeLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "<init>", "()V", "Companion", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class ThemeSettingsFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public RecyclerView a;
    @Inject
    public AdapterPresenter adapterPresenter;
    public Toolbar b;
    @Inject
    public SpannedGridPositionProvider gridPositionProvider;
    @Inject
    public Set<ThemeModeItemPresenter> itemPresenters;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public SerpSpanProvider serpSpanProvider;
    @Inject
    public GridLayoutManager.SpanSizeLookup spanSizeLookup;
    @Inject
    public ThemeSettingsViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/theme_settings/ThemeSettingsFragment$Companion;", "", "Lcom/avito/android/theme_settings/ThemeSettingsFragment;", "newInstance", "()Lcom/avito/android/theme_settings/ThemeSettingsFragment;", "<init>", "()V", "settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ThemeSettingsFragment newInstance() {
            ThemeSettingsFragment themeSettingsFragment = new ThemeSettingsFragment();
            themeSettingsFragment.setArguments(new Bundle());
            return themeSettingsFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ThemeSettingsFragment a;

        public a(ThemeSettingsFragment themeSettingsFragment) {
            this.a = themeSettingsFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.requireActivity().onBackPressed();
        }
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
    public final SpannedGridPositionProvider getGridPositionProvider() {
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        return spannedGridPositionProvider;
    }

    @NotNull
    public final Set<ThemeModeItemPresenter> getItemPresenters() {
        Set<ThemeModeItemPresenter> set = this.itemPresenters;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenters");
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
    public final ThemeSettingsViewModel getViewModel() {
        ThemeSettingsViewModel themeSettingsViewModel = this.viewModel;
        if (themeSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return themeSettingsViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        DaggerThemeSettingsComponent.factory().create(this, context, (ThemeSettingsDependencies) ComponentDependenciesKt.getDependencies(ThemeSettingsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        ThemeSettingsViewModel themeSettingsViewModel = this.viewModel;
        if (themeSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Set<ThemeModeItemPresenter> set = this.itemPresenters;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenters");
        }
        themeSettingsViewModel.observeItemClicks(set);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.theme_settings_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2, 1, false);
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup2);
        View findViewById = view.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView3 = this.a;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        recyclerView3.addItemDecoration(new ThemeSettingsPaddingDecoration(requireContext));
        View findViewById2 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById2;
        this.b = toolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar.setTitle(R.string.ui_theme);
        Toolbar toolbar2 = this.b;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        Toolbars.setBackIcon$default(toolbar2, 0, 1, null);
        Toolbar toolbar3 = this.b;
        if (toolbar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar3.setNavigationOnClickListener(new a(this));
        ThemeSettingsViewModel themeSettingsViewModel = this.viewModel;
        if (themeSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        themeSettingsViewModel.getItemChanges().observe(getViewLifecycleOwner(), new a2.a.a.f3.a(this));
        ThemeSettingsViewModel themeSettingsViewModel2 = this.viewModel;
        if (themeSettingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        themeSettingsViewModel2.refreshItems();
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setGridPositionProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "<set-?>");
        this.gridPositionProvider = spannedGridPositionProvider;
    }

    public final void setItemPresenters(@NotNull Set<ThemeModeItemPresenter> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenters = set;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setSerpSpanProvider(@NotNull SerpSpanProvider serpSpanProvider2) {
        Intrinsics.checkNotNullParameter(serpSpanProvider2, "<set-?>");
        this.serpSpanProvider = serpSpanProvider2;
    }

    public final void setSpanSizeLookup(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup2) {
        Intrinsics.checkNotNullParameter(spanSizeLookup2, "<set-?>");
        this.spanSizeLookup = spanSizeLookup2;
    }

    public final void setViewModel(@NotNull ThemeSettingsViewModel themeSettingsViewModel) {
        Intrinsics.checkNotNullParameter(themeSettingsViewModel, "<set-?>");
        this.viewModel = themeSettingsViewModel;
    }
}

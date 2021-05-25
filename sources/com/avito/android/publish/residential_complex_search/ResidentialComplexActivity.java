package com.avito.android.publish.residential_complex_search;

import a2.a.a.e2.b0.a;
import a2.a.a.e2.b0.b;
import a2.a.a.e2.b0.c;
import a2.a.a.e2.b0.d;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.publish.R;
import com.avito.android.publish.residential_complex_search.adapter.button.ResidentialComplexButtonPresenter;
import com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestPresenter;
import com.avito.android.publish.residential_complex_search.di.DaggerResidentialComplexComponent;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponentDependencies;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModule;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.util.EditTextsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/ResidentialComplexActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Landroidx/appcompat/widget/Toolbar;", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel;", "viewModel", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel;", "getViewModel", "()Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel;", "setViewModel", "(Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel;)V", "Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonPresenter;", "buttonPresenter", "Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonPresenter;", "getButtonPresenter", "()Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonPresenter;", "setButtonPresenter", "(Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonPresenter;)V", "Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestPresenter;", "suggestPresenter", "Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestPresenter;", "getSuggestPresenter", "()Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestPresenter;", "setSuggestPresenter", "(Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroid/widget/ImageButton;", "f", "Landroid/widget/ImageButton;", "clear", "Landroid/widget/EditText;", "d", "Landroid/widget/EditText;", "searchEditText", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexActivity extends AppCompatActivity {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public ResidentialComplexButtonPresenter buttonPresenter;
    public Toolbar c;
    public EditText d;
    public RecyclerView e;
    public ImageButton f;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public ResidentialComplexSuggestPresenter suggestPresenter;
    @Inject
    public ResidentialComplexViewModel viewModel;

    public static final /* synthetic */ ImageButton access$getClear$p(ResidentialComplexActivity residentialComplexActivity) {
        ImageButton imageButton = residentialComplexActivity.f;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clear");
        }
        return imageButton;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(ResidentialComplexActivity residentialComplexActivity) {
        RecyclerView recyclerView = residentialComplexActivity.e;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ EditText access$getSearchEditText$p(ResidentialComplexActivity residentialComplexActivity) {
        EditText editText = residentialComplexActivity.d;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        return editText;
    }

    public static final void access$setResultAndFinish(ResidentialComplexActivity residentialComplexActivity, int i, String str) {
        Objects.requireNonNull(residentialComplexActivity);
        Intent putExtra = new Intent().putExtra(ResidentialComplexActivityKt.EXTRA_SUGGEST_VALUE, new SelectParameter.Value(String.valueOf(i), str, null, null, 4, null));
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(\n     …l\n            )\n        )");
        residentialComplexActivity.setResult(-1, putExtra);
        residentialComplexActivity.finish();
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
    public final ResidentialComplexButtonPresenter getButtonPresenter() {
        ResidentialComplexButtonPresenter residentialComplexButtonPresenter = this.buttonPresenter;
        if (residentialComplexButtonPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonPresenter");
        }
        return residentialComplexButtonPresenter;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final ResidentialComplexSuggestPresenter getSuggestPresenter() {
        ResidentialComplexSuggestPresenter residentialComplexSuggestPresenter = this.suggestPresenter;
        if (residentialComplexSuggestPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suggestPresenter");
        }
        return residentialComplexSuggestPresenter;
    }

    @NotNull
    public final ResidentialComplexViewModel getViewModel() {
        ResidentialComplexViewModel residentialComplexViewModel = this.viewModel;
        if (residentialComplexViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return residentialComplexViewModel;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Double d2;
        Double d3;
        super.onCreate(bundle);
        setContentView(R.layout.residential_complex_activity);
        if (!getIntent().hasExtra("lat") || !getIntent().hasExtra("lng")) {
            d2 = null;
            d3 = null;
        } else {
            d2 = Double.valueOf(getIntent().getDoubleExtra("lat", 0.0d));
            d3 = Double.valueOf(getIntent().getDoubleExtra("lng", 0.0d));
        }
        DaggerResidentialComplexComponent.builder().dependencies((ResidentialComplexComponentDependencies) ComponentDependenciesKt.getDependencies(ResidentialComplexComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).module(new ResidentialComplexModule(this)).withLat(d2).withLng(d3).withValues(getIntent().hasExtra(ResidentialComplexModuleKt.VALUES) ? getIntent().getParcelableArrayListExtra(ResidentialComplexModuleKt.VALUES) : null).build().inject(this);
        View findViewById = findViewById(R.id.searchEditText);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.searchEditText)");
        EditText editText = (EditText) findViewById;
        this.d = editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        editText.setHint(getString(R.string.residential_complex_choose_placeholder));
        EditText editText2 = this.d;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        EditTextsKt.watchText(editText2, new c(this));
        EditText editText3 = this.d;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        editText3.requestFocus();
        View findViewById2 = findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById2;
        this.c = toolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        setSupportActionBar(toolbar);
        Toolbar toolbar2 = this.c;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar2.setNavigationOnClickListener(new h3(0, this));
        View findViewById3 = findViewById(R.id.clear);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.clear)");
        ImageButton imageButton = (ImageButton) findViewById3;
        this.f = imageButton;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clear");
        }
        Views.hide(imageButton);
        ImageButton imageButton2 = this.f;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clear");
        }
        imageButton2.setOnClickListener(new h3(1, this));
        View findViewById4 = findViewById(R.id.recyclerView);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.recyclerView)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.e = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        recyclerView.setAdapter(new SimpleRecyclerAdapter(adapterPresenter2, itemBinder2));
        RecyclerView recyclerView2 = this.e;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.setItemAnimator(null);
        RecyclerView recyclerView3 = this.e;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView3.setNestedScrollingEnabled(false);
        RecyclerView recyclerView4 = this.e;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView4.setLayoutManager(new LinearLayoutManager(this, 1, false));
        ResidentialComplexSuggestPresenter residentialComplexSuggestPresenter = this.suggestPresenter;
        if (residentialComplexSuggestPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suggestPresenter");
        }
        residentialComplexSuggestPresenter.getClicks().observe(this, new a(this));
        ResidentialComplexButtonPresenter residentialComplexButtonPresenter = this.buttonPresenter;
        if (residentialComplexButtonPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonPresenter");
        }
        residentialComplexButtonPresenter.getClicks().observe(this, new b(this));
        ResidentialComplexViewModel residentialComplexViewModel = this.viewModel;
        if (residentialComplexViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        residentialComplexViewModel.getState().observe(this, new d(this));
        ResidentialComplexViewModel residentialComplexViewModel2 = this.viewModel;
        if (residentialComplexViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        residentialComplexViewModel2.initialSuggest();
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setButtonPresenter(@NotNull ResidentialComplexButtonPresenter residentialComplexButtonPresenter) {
        Intrinsics.checkNotNullParameter(residentialComplexButtonPresenter, "<set-?>");
        this.buttonPresenter = residentialComplexButtonPresenter;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setSuggestPresenter(@NotNull ResidentialComplexSuggestPresenter residentialComplexSuggestPresenter) {
        Intrinsics.checkNotNullParameter(residentialComplexSuggestPresenter, "<set-?>");
        this.suggestPresenter = residentialComplexSuggestPresenter;
    }

    public final void setViewModel(@NotNull ResidentialComplexViewModel residentialComplexViewModel) {
        Intrinsics.checkNotNullParameter(residentialComplexViewModel, "<set-?>");
        this.viewModel = residentialComplexViewModel;
    }
}

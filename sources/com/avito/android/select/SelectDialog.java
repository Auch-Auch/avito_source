package com.avito.android.select;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ab_tests.AutoGenerationsFilterWithPhotos;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.di.DaggerSelectDialogComponent;
import com.avito.android.select.di.SelectDialogComponent;
import com.avito.android.select.di.SelectDialogDependencies;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bR\u0010\u0016J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u0007J-\u0010\u001f\u001a\u00020\u00052\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0016J\u0011\u0010#\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b#\u0010$R.\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006@\u0006X.¢\u0006\u0018\n\u0004\b'\u0010(\u0012\u0004\b-\u0010\u0016\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010/R\"\u0010B\u001a\u00020A8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lcom/avito/android/select/SelectDialog;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/select/SelectDialogRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "rootView", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onDestroyView", "outState", "onSaveInstanceState", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "selectedVariants", "sectionTitle", "onSelected", "(Ljava/util/List;Ljava/lang/String;)V", "onCancel", "Lcom/avito/android/select/SelectListener;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/select/SelectListener;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "filterWithPhotosGroup", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "getFilterWithPhotosGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "setFilterWithPhotosGroup", "(Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "getFilterWithPhotosGroup$annotations", "e", "Z", "shouldExposeImageFilterGroup", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/select/SelectDialogInteractor;", "interactor", "Lcom/avito/android/select/SelectDialogInteractor;", "getInteractor", "()Lcom/avito/android/select/SelectDialogInteractor;", "setInteractor", "(Lcom/avito/android/select/SelectDialogInteractor;)V", "d", "isRedesign", "Lcom/avito/android/select/SelectDialogPresenter;", "presenter", "Lcom/avito/android/select/SelectDialogPresenter;", "getPresenter", "()Lcom/avito/android/select/SelectDialogPresenter;", "setPresenter", "(Lcom/avito/android/select/SelectDialogPresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "c", "Ljava/lang/String;", "requestId", "<init>", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectDialog extends BaseFragment implements SelectDialogRouter {
    @Inject
    public AdapterPresenter adapterPresenter;
    public String c;
    public boolean d;
    public boolean e;
    @Inject
    public SingleManuallyExposedAbTestGroup<SimpleTestGroup> filterWithPhotosGroup;
    @Inject
    public SelectDialogInteractor interactor;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SelectDialogPresenter presenter;

    @AutoGenerationsFilterWithPhotos
    public static /* synthetic */ void getFilterWithPhotosGroup$annotations() {
    }

    public final SelectListener a() {
        Fragment targetFragment = getTargetFragment();
        if (!(targetFragment instanceof SelectListener)) {
            targetFragment = null;
        }
        SelectListener selectListener = (SelectListener) targetFragment;
        if (selectListener == null) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof SelectListener)) {
                activity = null;
            }
            selectListener = (SelectListener) activity;
        }
        if (selectListener != null) {
            return selectListener;
        }
        return null;
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
    public final SingleManuallyExposedAbTestGroup<SimpleTestGroup> getFilterWithPhotosGroup() {
        SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup = this.filterWithPhotosGroup;
        if (singleManuallyExposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterWithPhotosGroup");
        }
        return singleManuallyExposedAbTestGroup;
    }

    @NotNull
    public final SelectDialogInteractor getInteractor() {
        SelectDialogInteractor selectDialogInteractor = this.interactor;
        if (selectDialogInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return selectDialogInteractor;
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
    public final SelectDialogPresenter getPresenter() {
        SelectDialogPresenter selectDialogPresenter = this.presenter;
        if (selectDialogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return selectDialogPresenter;
    }

    @Override // com.avito.android.select.SelectDialogRouter
    public void onCancel() {
        SelectListener a = a();
        if (a != null) {
            String str = this.c;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestId");
            }
            a.onCancel(str);
        }
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Parcelable parcelable = requireArguments().getParcelable("arguments");
        Intrinsics.checkNotNull(parcelable);
        Intrinsics.checkNotNullExpressionValue(parcelable, "requireArguments().getPa…guments>(KEY_ARGUMENTS)!!");
        Arguments arguments = (Arguments) parcelable;
        this.c = arguments.getRequestId();
        this.d = arguments.isRedesign();
        this.e = arguments.getShouldExposeImageFilterGroup();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.select_dialog, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectDialogPresenter selectDialogPresenter = this.presenter;
        if (selectDialogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectDialogPresenter.detachRouter();
        SelectDialogPresenter selectDialogPresenter2 = this.presenter;
        if (selectDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectDialogPresenter2.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.e) {
            SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup = this.filterWithPhotosGroup;
            if (singleManuallyExposedAbTestGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterWithPhotosGroup");
            }
            singleManuallyExposedAbTestGroup.exposeIfNeeded();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SelectDialogPresenter selectDialogPresenter = this.presenter;
        if (selectDialogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("presenter_state", selectDialogPresenter.onSaveState());
    }

    @Override // com.avito.android.select.SelectDialogRouter
    public void onSelected(@NotNull List<? extends ParcelableEntity<String>> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "selectedVariants");
        SelectListener a = a();
        if (a != null) {
            getTargetFragment();
            String str2 = this.c;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestId");
            }
            a.onSelected(str2, list, str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        super.onViewCreated(view, bundle);
        ViewGroup viewGroup = (ViewGroup) view;
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        SelectDialogViewImpl selectDialogViewImpl = new SelectDialogViewImpl(viewGroup, adapterPresenter2, itemBinder2, this.d);
        SelectDialogPresenter selectDialogPresenter = this.presenter;
        if (selectDialogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectDialogPresenter.attachView(selectDialogViewImpl);
        SelectDialogPresenter selectDialogPresenter2 = this.presenter;
        if (selectDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectDialogPresenter2.attachRouter(this);
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setFilterWithPhotosGroup(@NotNull SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "<set-?>");
        this.filterWithPhotosGroup = singleManuallyExposedAbTestGroup;
    }

    public final void setInteractor(@NotNull SelectDialogInteractor selectDialogInteractor) {
        Intrinsics.checkNotNullParameter(selectDialogInteractor, "<set-?>");
        this.interactor = selectDialogInteractor;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull SelectDialogPresenter selectDialogPresenter) {
        Intrinsics.checkNotNullParameter(selectDialogPresenter, "<set-?>");
        this.presenter = selectDialogPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle bundle2 = bundle != null ? bundle.getBundle("presenter_state") : null;
        Parcelable parcelable = requireArguments().getParcelable("arguments");
        Intrinsics.checkNotNull(parcelable);
        Intrinsics.checkNotNullExpressionValue(parcelable, "requireArguments().getPa…guments>(KEY_ARGUMENTS)!!");
        SelectDialogComponent.Builder withArguments = DaggerSelectDialogComponent.builder().dependentOn((SelectDialogDependencies) ComponentDependenciesKt.getDependencies(SelectDialogDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withPresenterState(bundle2).withArguments((Arguments) parcelable);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withArguments.withResources(resources).build().inject(this);
        return true;
    }
}

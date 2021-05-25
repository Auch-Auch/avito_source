package com.avito.android.advert.specifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.advert.specifications.di.DaggerSpecificationsComponent;
import com.avito.android.advert.specifications.di.SpecificationsDependencies;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.specifications.SpecificationsViewImpl;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.ui.fragments.BaseFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\u0010J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/advert/specifications/SpecificationsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Lcom/avito/android/advert/specifications/SpecificationsPresenter;", "presenter", "Lcom/avito/android/advert/specifications/SpecificationsPresenter;", "getPresenter$advert_details_release", "()Lcom/avito/android/advert/specifications/SpecificationsPresenter;", "setPresenter$advert_details_release", "(Lcom/avito/android/advert/specifications/SpecificationsPresenter;)V", "<init>", "Factory", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SpecificationsFragment extends BaseFragment {
    @Inject
    public SpecificationsPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/specifications/SpecificationsFragment$Factory;", "", "Lcom/avito/android/remote/model/ModelSpecifications;", "specifications", "Lcom/avito/android/advert/specifications/SpecificationsFragment;", "create", "(Lcom/avito/android/remote/model/ModelSpecifications;)Lcom/avito/android/advert/specifications/SpecificationsFragment;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final SpecificationsFragment create(@NotNull ModelSpecifications modelSpecifications) {
            Intrinsics.checkNotNullParameter(modelSpecifications, "specifications");
            SpecificationsFragment specificationsFragment = new SpecificationsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("specifications", modelSpecifications);
            Unit unit = Unit.INSTANCE;
            specificationsFragment.setArguments(bundle);
            return specificationsFragment;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                FragmentActivity activity = ((SpecificationsFragment) this.b).getActivity();
                if (activity != null) {
                    activity.finish();
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                FragmentActivity activity2 = ((SpecificationsFragment) this.b).getActivity();
                if (activity2 != null) {
                    activity2.onBackPressed();
                }
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @NotNull
    public final SpecificationsPresenter getPresenter$advert_details_release() {
        SpecificationsPresenter specificationsPresenter = this.presenter;
        if (specificationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return specificationsPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_specifications, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SpecificationsPresenter specificationsPresenter = this.presenter;
        if (specificationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        specificationsPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SpecificationsViewImpl specificationsViewImpl = new SpecificationsViewImpl(view, new a(1, this));
        SpecificationsPresenter specificationsPresenter = this.presenter;
        if (specificationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        specificationsPresenter.attachView(specificationsViewImpl, new a(0, this));
    }

    public final void setPresenter$advert_details_release(@NotNull SpecificationsPresenter specificationsPresenter) {
        Intrinsics.checkNotNullParameter(specificationsPresenter, "<set-?>");
        this.presenter = specificationsPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        if (getContext() != null) {
            Bundle arguments = getArguments();
            DaggerSpecificationsComponent.builder().specifications(arguments != null ? (ModelSpecifications) arguments.getParcelable("specifications") : null).specificationsDependencies((SpecificationsDependencies) ComponentDependenciesKt.getDependencies(SpecificationsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
            return true;
        }
        throw new IllegalArgumentException("context is null".toString());
    }
}

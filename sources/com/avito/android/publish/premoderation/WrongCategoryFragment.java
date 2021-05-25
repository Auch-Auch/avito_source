package com.avito.android.publish.premoderation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.publish.R;
import com.avito.android.publish.di.PublishDependencies;
import com.avito.android.publish.premoderation.di.DaggerWrongCategoryComponent;
import com.avito.android.publish.premoderation.di.WrongCategoryModule;
import com.avito.android.remote.model.adverts.AdvertProactiveModerationResult;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0006R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/publish/premoderation/WrongCategoryFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "outState", "onSaveInstanceState", "Lcom/avito/android/publish/premoderation/WrongCategoryPresenter;", "presenter", "Lcom/avito/android/publish/premoderation/WrongCategoryPresenter;", "getPresenter", "()Lcom/avito/android/publish/premoderation/WrongCategoryPresenter;", "setPresenter", "(Lcom/avito/android/publish/premoderation/WrongCategoryPresenter;)V", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class WrongCategoryFragment extends Fragment {
    @Inject
    public WrongCategoryPresenter presenter;

    @NotNull
    public final WrongCategoryPresenter getPresenter() {
        WrongCategoryPresenter wrongCategoryPresenter = this.presenter;
        if (wrongCategoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return wrongCategoryPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        AdvertProactiveModerationResult.WrongCategorySuggest wrongCategorySuggest;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (wrongCategorySuggest = (AdvertProactiveModerationResult.WrongCategorySuggest) arguments.getParcelable("key_wrong_category_data")) == null) {
            throw new RuntimeException("key_wrong_category_data was not passed to " + this);
        }
        Kundle kundle = bundle != null ? Bundles.getKundle(bundle, "key_wrong_category_data") : null;
        String string = getString(R.string.wrong_category_subtitle);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.wrong_category_subtitle)");
        DaggerWrongCategoryComponent.builder().publishDependencies((PublishDependencies) ComponentDependenciesKt.getDependencies(PublishDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).wrongCategoryModule(new WrongCategoryModule(wrongCategorySuggest, string, kundle)).build().inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.wrong_category_screen, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        WrongCategoryPresenter wrongCategoryPresenter = this.presenter;
        if (wrongCategoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wrongCategoryPresenter.detachRouter();
        WrongCategoryPresenter wrongCategoryPresenter2 = this.presenter;
        if (wrongCategoryPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wrongCategoryPresenter2.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        WrongCategoryPresenter wrongCategoryPresenter = this.presenter;
        if (wrongCategoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "key_wrong_category_data", wrongCategoryPresenter.saveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof WrongCategoryRouter)) {
            activity = null;
        }
        WrongCategoryRouter wrongCategoryRouter = (WrongCategoryRouter) activity;
        if (wrongCategoryRouter != null) {
            WrongCategoryPresenter wrongCategoryPresenter = this.presenter;
            if (wrongCategoryPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            wrongCategoryPresenter.attachView(new WrongCategoryViewImpl(view));
            WrongCategoryPresenter wrongCategoryPresenter2 = this.presenter;
            if (wrongCategoryPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            wrongCategoryPresenter2.attachRouter(wrongCategoryRouter);
            return;
        }
        throw new RuntimeException("activity must implement WrongCategoryRouter");
    }

    public final void setPresenter(@NotNull WrongCategoryPresenter wrongCategoryPresenter) {
        Intrinsics.checkNotNullParameter(wrongCategoryPresenter, "<set-?>");
        this.presenter = wrongCategoryPresenter;
    }
}

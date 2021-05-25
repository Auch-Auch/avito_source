package com.avito.android.notification_center.landing.recommends.review;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.notification_center.R;
import com.avito.android.notification_center.landing.recommends.review.di.DaggerNcRecommendsReviewComponent;
import com.avito.android.notification_center.landing.recommends.review.di.NcRecommendsReviewDependencies;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010\u0010J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onStop", "onDestroyView", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewPresenter;", "presenter", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewPresenter;", "getPresenter", "()Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewPresenter;", "setPresenter", "(Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewPresenter;)V", "<init>", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NcRecommendsReviewFragment extends BaseFragment {
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public NcRecommendsReviewPresenter presenter;

    @NotNull
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final NcRecommendsReviewPresenter getPresenter() {
        NcRecommendsReviewPresenter ncRecommendsReviewPresenter = this.presenter;
        if (ncRecommendsReviewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return ncRecommendsReviewPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.nc_recommends_review, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…review, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        NcRecommendsReviewPresenter ncRecommendsReviewPresenter = this.presenter;
        if (ncRecommendsReviewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ncRecommendsReviewPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        NcRecommendsReviewPresenter ncRecommendsReviewPresenter = this.presenter;
        if (ncRecommendsReviewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("key_state", ncRecommendsReviewPresenter.getState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NcRecommendsReviewPresenter ncRecommendsReviewPresenter = this.presenter;
        if (ncRecommendsReviewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewRouter");
        ncRecommendsReviewPresenter.attachRouter((NcRecommendsReviewRouter) context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        NcRecommendsReviewPresenter ncRecommendsReviewPresenter = this.presenter;
        if (ncRecommendsReviewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ncRecommendsReviewPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        NcRecommendsReviewPresenter ncRecommendsReviewPresenter = this.presenter;
        if (ncRecommendsReviewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        ncRecommendsReviewPresenter.attachView(new NcRecommendsReviewViewImpl(view, dialogRouter2));
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setPresenter(@NotNull NcRecommendsReviewPresenter ncRecommendsReviewPresenter) {
        Intrinsics.checkNotNullParameter(ncRecommendsReviewPresenter, "<set-?>");
        this.presenter = ncRecommendsReviewPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String string = requireArguments().getString("key_id");
        if (string != null) {
            String string2 = requireArguments().getString("key_hint");
            if (string2 != null) {
                DaggerNcRecommendsReviewComponent.builder().dependencies((NcRecommendsReviewDependencies) ComponentDependenciesKt.getDependencies(NcRecommendsReviewDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withId(string).withHint(string2).withPresenterState(bundle != null ? (Kundle) bundle.getParcelable("key_state") : null).build().inject(this);
                return true;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}

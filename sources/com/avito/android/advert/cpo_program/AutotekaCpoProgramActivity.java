package com.avito.android.advert.cpo_program;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenter;
import com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies;
import com.avito.android.advert.cpo_program.di.DaggerAutotekaCpoProgramComponent;
import com.avito.android.advert_details.R;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.model.CpoDescription;
import com.avito.android.ui.activity.BaseActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007¢\u0006\u0004\b\u001a\u0010\fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "onDestroy", "()V", "", "getContentLayoutId", "()I", "setUpCustomToolbar", "()Z", "close", "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter;", "presenter", "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter;", "getPresenter", "()Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter;", "setPresenter", "(Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter;)V", "<init>", "Factory", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaCpoProgramActivity extends BaseActivity implements AutotekaCpoProgramPresenter.Router {
    @Inject
    public AutotekaCpoProgramPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramActivity$Factory;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/CpoDescription;", "data", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Lcom/avito/android/remote/model/CpoDescription;)Landroid/content/Intent;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull CpoDescription cpoDescription) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cpoDescription, "data");
            Intent putExtra = new Intent(context, AutotekaCpoProgramActivity.class).putExtra("cpo_program_data", cpoDescription);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…A_CPO_PROGRAM_DATA, data)");
            return putExtra;
        }
    }

    @Override // com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenter.Router
    public void close() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.activity_autoteka_cpo_program;
    }

    @NotNull
    public final AutotekaCpoProgramPresenter getPresenter() {
        AutotekaCpoProgramPresenter autotekaCpoProgramPresenter = this.presenter;
        if (autotekaCpoProgramPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return autotekaCpoProgramPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AutotekaCpoProgramPresenter autotekaCpoProgramPresenter = this.presenter;
        if (autotekaCpoProgramPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autotekaCpoProgramPresenter.attachView(new AutotekaCpoProgramViewImpl(getContainerView()));
        AutotekaCpoProgramPresenter autotekaCpoProgramPresenter2 = this.presenter;
        if (autotekaCpoProgramPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autotekaCpoProgramPresenter2.attachRouter(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AutotekaCpoProgramPresenter autotekaCpoProgramPresenter = this.presenter;
        if (autotekaCpoProgramPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autotekaCpoProgramPresenter.detachRouter();
        AutotekaCpoProgramPresenter autotekaCpoProgramPresenter2 = this.presenter;
        if (autotekaCpoProgramPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autotekaCpoProgramPresenter2.detachView();
        super.onDestroy();
    }

    public final void setPresenter(@NotNull AutotekaCpoProgramPresenter autotekaCpoProgramPresenter) {
        Intrinsics.checkNotNullParameter(autotekaCpoProgramPresenter, "<set-?>");
        this.presenter = autotekaCpoProgramPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Parcelable parcelableExtra = getIntent().getParcelableExtra("cpo_program_data");
        if (parcelableExtra != null) {
            DaggerAutotekaCpoProgramComponent.builder().cpoProgramDependencies((AutotekaCpoProgramDependencies) ComponentDependenciesKt.getDependencies(AutotekaCpoProgramDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withDescription((CpoDescription) parcelableExtra).build().inject(this);
            return true;
        }
        throw new IllegalArgumentException(("cpo_program_data was not passed to " + this).toString());
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}

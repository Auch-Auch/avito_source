package com.avito.android.job.cv_packages;

import a2.a.a.j1.a.b;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.job.cv_packages.di.CvPackagesDependencies;
import com.avito.android.job.cv_packages.di.DaggerCvPackagesComponent;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxrelay3.PublishRelay;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/avito/android/job/cv_packages/JobCvPackagesActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/job/cv_packages/JobCvPackagesViewModel;", "viewModel", "Lcom/avito/android/job/cv_packages/JobCvPackagesViewModel;", "getViewModel", "()Lcom/avito/android/job/cv_packages/JobCvPackagesViewModel;", "setViewModel", "(Lcom/avito/android/job/cv_packages/JobCvPackagesViewModel;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "<init>", "()V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
public final class JobCvPackagesActivity extends BaseActivity {
    @Inject
    public SimpleRecyclerAdapter adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public JobCvPackagesViewModel viewModel;

    @NotNull
    public final SimpleRecyclerAdapter getAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
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
    public final JobCvPackagesViewModel getViewModel() {
        JobCvPackagesViewModel jobCvPackagesViewModel = this.viewModel;
        if (jobCvPackagesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return jobCvPackagesViewModel;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            setResult(i2);
            finish();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cv_packages_activity);
        String stringExtra = getIntent().getStringExtra("extra_resume_id");
        Intrinsics.checkNotNull(stringExtra);
        DaggerCvPackagesComponent.factory().build((CvPackagesDependencies) ComponentDependenciesKt.getDependencies(CvPackagesDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)), this, stringExtra).inject(this);
        View findViewById = findViewById(R.id.packages_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.packages_root)");
        JobCvPackagesViewModel jobCvPackagesViewModel = this.viewModel;
        if (jobCvPackagesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        PublishRelay<Action> actions = jobCvPackagesViewModel.getActions();
        Intrinsics.checkNotNullExpressionValue(actions, "viewModel.actions");
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        JobCvPackagesRenderer jobCvPackagesRenderer = new JobCvPackagesRenderer(findViewById, actions, simpleRecyclerAdapter, adapterPresenter2);
        JobCvPackagesViewModel jobCvPackagesViewModel2 = this.viewModel;
        if (jobCvPackagesViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        jobCvPackagesViewModel2.getState().observe(this, new b(new Function1<State, Unit>(jobCvPackagesRenderer) { // from class: com.avito.android.job.cv_packages.JobCvPackagesActivity.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(State state) {
                State state2 = state;
                Intrinsics.checkNotNullParameter(state2, "p1");
                ((JobCvPackagesRenderer) this.receiver).render(state2);
                return Unit.INSTANCE;
            }
        }));
    }

    public final void setAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setViewModel(@NotNull JobCvPackagesViewModel jobCvPackagesViewModel) {
        Intrinsics.checkNotNullParameter(jobCvPackagesViewModel, "<set-?>");
        this.viewModel = jobCvPackagesViewModel;
    }
}

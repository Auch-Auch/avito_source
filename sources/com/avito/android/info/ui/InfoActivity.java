package com.avito.android.info.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.info.R;
import com.avito.android.info.di.DaggerInfoActivityComponent;
import com.avito.android.info.di.InfoActivityDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.ToastsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\tR\"\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010(\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001c¨\u0006*"}, d2 = {"Lcom/avito/android/info/ui/InfoActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/info/ui/InfoRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "closeScreen", "outState", "onSaveInstanceState", "onDestroy", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$info_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$info_release", "(Lcom/avito/android/analytics/Analytics;)V", "", "l", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "Lcom/avito/android/info/ui/InfoPresenter;", "infoPresenter", "Lcom/avito/android/info/ui/InfoPresenter;", "getInfoPresenter", "()Lcom/avito/android/info/ui/InfoPresenter;", "setInfoPresenter", "(Lcom/avito/android/info/ui/InfoPresenter;)V", "k", "getPath", "setPath", MessageMetaInfo.COLUMN_PATH, "<init>", "info_release"}, k = 1, mv = {1, 4, 2})
public final class InfoActivity extends BaseActivity implements InfoRouter {
    @Inject
    public Analytics analytics;
    @Inject
    public InfoPresenter infoPresenter;
    @NotNull
    public String k = "";
    @NotNull
    public String l = "";

    @Override // com.avito.android.info.ui.InfoRouter
    public void closeScreen() {
        finish();
    }

    @NotNull
    public final Analytics getAnalytics$info_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final InfoPresenter getInfoPresenter() {
        InfoPresenter infoPresenter2 = this.infoPresenter;
        if (infoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoPresenter");
        }
        return infoPresenter2;
    }

    @NotNull
    public final String getPath() {
        return this.k;
    }

    @Override // android.app.Activity
    @NotNull
    public final String getTitle() {
        return this.l;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Bundle extras = intent.getExtras();
        boolean z = true;
        if (extras != null) {
            String string = extras.getString(MessageMetaInfo.COLUMN_PATH);
            Intrinsics.checkNotNull(string);
            this.k = string;
            String string2 = extras.getString("title");
            Intrinsics.checkNotNull(string2);
            this.l = string2;
            if (this.k.length() != 0) {
                z = false;
            }
        }
        DaggerInfoActivityComponent.builder().dependentOn((InfoActivityDependencies) ComponentDependenciesKt.getDependencies(InfoActivityDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withTitle(this.l).withPath(this.k).withState(bundle).build().inject(this);
        setContentView(R.layout.info);
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        InfoPresenter infoPresenter2 = this.infoPresenter;
        if (infoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoPresenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        InfoViewImpl infoViewImpl = new InfoViewImpl(findViewById, infoPresenter2, analytics2);
        InfoPresenter infoPresenter3 = this.infoPresenter;
        if (infoPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoPresenter");
        }
        infoPresenter3.attachView(infoViewImpl);
        if (z) {
            ToastsKt.showToast$default(this, com.avito.android.remote.R.string.unknown_server_error, 0, 2, (Object) null);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        InfoPresenter infoPresenter2 = this.infoPresenter;
        if (infoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoPresenter");
        }
        infoPresenter2.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        InfoPresenter infoPresenter2 = this.infoPresenter;
        if (infoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoPresenter");
        }
        infoPresenter2.saveState(bundle);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        InfoPresenter infoPresenter2 = this.infoPresenter;
        if (infoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoPresenter");
        }
        infoPresenter2.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        InfoPresenter infoPresenter2 = this.infoPresenter;
        if (infoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoPresenter");
        }
        infoPresenter2.detachRouter();
        super.onStop();
    }

    public final void setAnalytics$info_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setInfoPresenter(@NotNull InfoPresenter infoPresenter2) {
        Intrinsics.checkNotNullParameter(infoPresenter2, "<set-?>");
        this.infoPresenter = infoPresenter2;
    }

    public final void setPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.k = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.l = str;
    }
}

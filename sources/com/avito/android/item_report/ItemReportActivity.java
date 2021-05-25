package com.avito.android.item_report;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.item_report.di.DaggerItemReportComponent;
import com.avito.android.item_report.di.ItemReportDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.ToastsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/item_report/ItemReportActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/item_report/ErrorListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "message", "onError", "(Ljava/lang/String;)V", "<init>", "()V", "item-report_release"}, k = 1, mv = {1, 4, 2})
public final class ItemReportActivity extends BaseActivity implements ErrorListener {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerItemReportComponent.builder().dependentOn((ItemReportDependencies) ComponentDependenciesKt.getDependencies(ItemReportDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        setContentView(R.layout.fragment_container);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        int i = R.id.fragment_container;
        if (supportFragmentManager.findFragmentById(i) == null) {
            String stringExtra = getIntent().getStringExtra("item_id");
            Intrinsics.checkNotNullExpressionValue(stringExtra, "itemId");
            getSupportFragmentManager().beginTransaction().add(i, ItemReportFragmentKt.createItemReportFragment(stringExtra)).commit();
        }
    }

    @Override // com.avito.android.item_report.ErrorListener
    public void onError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        ToastsKt.showToast$default(this, str, 0, 2, (Object) null);
        finish();
    }
}

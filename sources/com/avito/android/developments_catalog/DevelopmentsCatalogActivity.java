package com.avito.android.developments_catalog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.developments_catalog.DevelopmentsCatalogFragment;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "setUpCustomToolbar", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "<init>", "()V", "Factory", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogActivity extends BaseActivity {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ;\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogActivity$Factory;", "", "Landroid/content/Context;", "context", "", "developmentsId", "developmentsTitle", "searchContext", "fromPage", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        public static /* synthetic */ Intent createIntent$default(Factory factory, Context context, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = "";
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            return factory.createIntent(context, str, str2, str3, str4);
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "developmentsId");
            Intrinsics.checkNotNullParameter(str2, "developmentsTitle");
            Intrinsics.checkNotNullParameter(str4, "fromPage");
            Intent putExtra = new Intent(context, DevelopmentsCatalogActivity.class).putExtra("developments_id", str).putExtra("developments_title", str2).putExtra("search_context", str3).putExtra(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, str4);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…XTRA_FROM_PAGE, fromPage)");
            return putExtra;
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.developments_catalog_screen;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("developments_id");
        if (stringExtra != null) {
            String stringExtra2 = getIntent().getStringExtra("developments_title");
            String stringExtra3 = getIntent().getStringExtra("search_context");
            String stringExtra4 = getIntent().getStringExtra(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY);
            if (bundle == null) {
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                int i = R.id.fragment_container;
                DevelopmentsCatalogFragment.Companion companion = DevelopmentsCatalogFragment.Companion;
                Intrinsics.checkNotNullExpressionValue(stringExtra4, "fromPage");
                beginTransaction.add(i, companion.newInstance(new DevelopmentsCatalogArguments(stringExtra, stringExtra2, stringExtra3, stringExtra4))).commit();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("developments_id was not passed to " + this).toString());
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}

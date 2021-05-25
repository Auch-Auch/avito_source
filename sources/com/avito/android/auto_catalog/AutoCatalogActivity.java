package com.avito.android.auto_catalog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "setUpCustomToolbar", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "<init>", "()V", "Factory", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AutoCatalogActivity extends BaseActivity {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogActivity$Factory;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/auto_catalog/AutoCatalogData;", "data", "", "from", "searchContext", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Lcom/avito/android/auto_catalog/AutoCatalogData;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        public static /* synthetic */ Intent createIntent$default(Factory factory, Context context, AutoCatalogData autoCatalogData, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str = null;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            return factory.createIntent(context, autoCatalogData, str, str2);
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull AutoCatalogData autoCatalogData, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(autoCatalogData, "data");
            Intent putExtra = new Intent(context, AutoCatalogActivity.class).putExtra("auto_catalog_data", autoCatalogData).putExtra("search_context", str2).putExtra("from_screen", str);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…tra(KEY_EXTRA_FROM, from)");
            return putExtra;
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.auto_catalog_screen;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Parcelable parcelableExtra = getIntent().getParcelableExtra("auto_catalog_data");
        if (parcelableExtra != null) {
            AutoCatalogData autoCatalogData = (AutoCatalogData) parcelableExtra;
            String stringExtra = getIntent().getStringExtra("search_context");
            String stringExtra2 = getIntent().getStringExtra("from_screen");
            if (bundle == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, AutoCatalogFragment.Companion.newInstance(new AutoCatalogArguments(autoCatalogData, stringExtra, stringExtra2))).commit();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("auto_catalog_data was not passed to " + this).toString());
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}

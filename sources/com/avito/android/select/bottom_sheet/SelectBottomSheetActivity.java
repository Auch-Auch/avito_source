package com.avito.android.select.bottom_sheet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectActivityKt;
import com.avito.android.select.SelectListener;
import com.avito.android.select.SelectResult;
import com.avito.android.ui.activity.BaseActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\n2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/select/bottom_sheet/SelectBottomSheetActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/select/SelectListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "requestId", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedItems", "sectionTitle", "onSelected", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "onCancel", "(Ljava/lang/String;)V", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectBottomSheetActivity extends BaseActivity implements SelectListener {
    @Override // com.avito.android.select.SelectListener
    public void onCancel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        setResult(0);
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            Parcelable parcelableExtra = getIntent().getParcelableExtra("select_arguments");
            if (parcelableExtra != null) {
                SelectBottomSheetFragmentKt.createSelectSheetDialogFragment(null, (Arguments) parcelableExtra).show(getSupportFragmentManager(), "select_bottom_sheet_tag");
                return;
            }
            throw new IllegalArgumentException("select_arguments required".toString());
        }
    }

    @Override // com.avito.android.select.SelectListener
    public void onSelected(@NotNull String str, @NotNull List<? extends ParcelableEntity<String>> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(list, "selectedItems");
        Intent putExtra = new Intent().putExtra(SelectActivityKt.EXTRA_SELECT_RESULT, new SelectResult(str, list, str2));
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(EXTRA_…ctedItems, sectionTitle))");
        setResult(-1, putExtra);
        finish();
    }
}

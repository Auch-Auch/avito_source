package com.avito.android.advert.specifications;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.avito.android.advert.specifications.SpecificationsFragment;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/specifications/SpecificationsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "Factory", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SpecificationsActivity extends BaseActivity {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/specifications/SpecificationsActivity$Factory;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/ModelSpecifications;", "specifications", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Lcom/avito/android/remote/model/ModelSpecifications;)Landroid/content/Intent;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final Intent create(@NotNull Context context, @NotNull ModelSpecifications modelSpecifications) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(modelSpecifications, "specifications");
            Intent putExtra = new Intent(context, SpecificationsActivity.class).putExtra("specifications", modelSpecifications);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…ICATIONS, specifications)");
            return putExtra;
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            Parcelable parcelableExtra = getIntent().getParcelableExtra("specifications");
            if (parcelableExtra != null) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new SpecificationsFragment.Factory().create((ModelSpecifications) parcelableExtra)).commit();
                return;
            }
            throw new IllegalArgumentException(("specifications should be provided to " + this).toString());
        }
    }
}

package com.avito.android.item_map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avito.android.ui.activity.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/item_map/ItemMapActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "Companion", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class ItemMapActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/item_map/ItemMapActivity$Companion;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/item_map/ItemMapArguments;", "args", "Landroid/content/Intent;", "newInstance", "(Landroid/content/Context;Lcom/avito/android/item_map/ItemMapArguments;)Landroid/content/Intent;", "<init>", "()V", "item-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent newInstance(@NotNull Context context, @NotNull ItemMapArguments itemMapArguments) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(itemMapArguments, "args");
            Intent putExtra = new Intent(context, ItemMapActivity.class).putExtra(ItemMapActivityKt.EXTRA_ITEM_MAP_ARGS, itemMapArguments);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, ItemMapA…XTRA_ITEM_MAP_ARGS, args)");
            return putExtra;
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.item_map_activity);
        if (bundle == null) {
            ItemMapArguments itemMapArguments = (ItemMapArguments) getIntent().getParcelableExtra(ItemMapActivityKt.EXTRA_ITEM_MAP_ARGS);
            if (itemMapArguments != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ItemMapFragment.Companion.newInstance(itemMapArguments), "item_map_tag").commit();
                return;
            }
            throw new IllegalStateException("No args provided");
        }
    }
}

package com.avito.android.grouping_adverts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "<init>", "()V", "Factory", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class GroupingAdvertsActivity extends BaseActivity {
    @NotNull
    public static final Factory Factory = new Factory(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsActivity$Factory;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;", "advertArguments", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;)Landroid/content/Intent;", "<init>", "()V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        public Factory() {
        }

        @NotNull
        public final Intent create(@NotNull Context context, @Nullable GroupingAdvertsArguments groupingAdvertsArguments) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent putExtra = new Intent(context, GroupingAdvertsActivity.class).putExtra("grouping_advert_arguments", groupingAdvertsArguments);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…RT_ARGS, advertArguments)");
            return putExtra;
        }

        public Factory(j jVar) {
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.overlay_fragment_container;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        GroupingAdvertsArguments groupingAdvertsArguments = intent != null ? (GroupingAdvertsArguments) intent.getParcelableExtra("grouping_advert_arguments") : null;
        Intrinsics.checkNotNull(groupingAdvertsArguments);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, GroupingAdvertsFragment.Companion.newInstance(groupingAdvertsArguments)).commit();
        }
    }
}

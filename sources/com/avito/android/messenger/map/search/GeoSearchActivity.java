package com.avito.android.messenger.map.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.avito.android.messenger.map.search.di.GeoSearchFragmentModule;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Keyboards;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "<init>", "()V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class GeoSearchActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J9\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchActivity$Companion;", "", "Landroid/content/Context;", "context", "", "channelId", "initialQuery", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "centerPoint", "itemLocation", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;)Landroid/content/Intent;", "KEY_CENTER_POINT", "Ljava/lang/String;", "KEY_CHANNEL_ID", "KEY_INITIAL_QUERY", "KEY_ITEM_LOCATION", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable GeoPoint geoPoint, @Nullable GeoPoint geoPoint2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str2, "initialQuery");
            Intent intent = new Intent(context, GeoSearchActivity.class);
            intent.putExtra("channel_id", str);
            intent.putExtra("initial_query", str2);
            if (geoPoint != null) {
                intent.putExtra(GeoSearchFragmentModule.CENTER_POINT, geoPoint);
            }
            if (geoPoint2 != null) {
                intent.putExtra(GeoSearchFragmentModule.ITEM_LOCATION, geoPoint2);
            }
            return intent;
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.fragment_container);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Bundle extras = intent.getExtras();
        GeoPoint geoPoint = null;
        String string = extras != null ? extras.getString("channel_id") : null;
        if (string != null) {
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            Bundle extras2 = intent2.getExtras();
            if (extras2 == null || (str = extras2.getString("initial_query")) == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "intent.extras?.getString(KEY_INITIAL_QUERY) ?: \"\"");
            Intent intent3 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent3, "intent");
            Bundle extras3 = intent3.getExtras();
            GeoPoint geoPoint2 = extras3 != null ? (GeoPoint) extras3.getParcelable(GeoSearchFragmentModule.CENTER_POINT) : null;
            Intent intent4 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent4, "intent");
            Bundle extras4 = intent4.getExtras();
            if (extras4 != null) {
                geoPoint = (GeoPoint) extras4.getParcelable(GeoSearchFragmentModule.ITEM_LOCATION);
            }
            if (bundle == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, GeoSearchFragment.Companion.invoke(string, str, geoPoint2, geoPoint), GeoSearchFragment.TAG).commit();
                return;
            }
            return;
        }
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        Keyboards.hideKeyboard(this);
        onBackPressed();
        return true;
    }
}

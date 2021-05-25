package com.avito.android.messenger.map.sharing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import com.avito.android.messenger.map.OnLocationEnabledListener;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "<init>", "()V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SharingMapActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapActivity$Companion;", "", "Landroid/content/Context;", "context", "", "channelId", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "initialPosition", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;)Landroid/content/Intent;", "KEY_CHANNEL_ID", "Ljava/lang/String;", "KEY_INITIAL_POSITION", "TAG", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull String str, @Nullable MessageBody.Location location) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intent intent = new Intent(context, SharingMapActivity.class);
            intent.putExtra("channel_id", str);
            intent.putExtra("initial_position", location);
            return intent;
        }

        public Companion(j jVar) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 69 && i2 == -1) {
            Logs.verbose$default("SharingMapActivity", "onActivityResult(requestCode == ENABLE_LOCATION_REQUEST_CODE, resultCode == RESULT_OK) => onLocationEnabled()", null, 4, null);
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(SharingMapFragment.TAG);
            if (!(findFragmentByTag instanceof OnLocationEnabledListener)) {
                findFragmentByTag = null;
            }
            OnLocationEnabledListener onLocationEnabledListener = (OnLocationEnabledListener) findFragmentByTag;
            if (onLocationEnabledListener != null) {
                onLocationEnabledListener.onLocationEnabled();
            } else {
                Logs.warning$default("SharingMapActivity", "SharingMapFragment not found!", null, 4, null);
            }
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_container);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Bundle extras = intent.getExtras();
        MessageBody.Location location = null;
        String string = extras != null ? extras.getString("channel_id") : null;
        if (string != null) {
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            Bundle extras2 = intent2.getExtras();
            if (extras2 != null) {
                location = (MessageBody.Location) extras2.getParcelable("initial_position");
            }
            if (bundle == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, SharingMapFragment.Companion.invoke(string, location), SharingMapFragment.TAG).commit();
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
        onBackPressed();
        return true;
    }
}

package com.avito.android.messenger.map.viewing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import com.avito.android.messenger.map.OnLocationEnabledListener;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Logs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/map/viewing/PlatformMapActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "<init>", "()V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformMapActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J?\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/map/viewing/PlatformMapActivity$Companion;", "", "Landroid/content/Context;", "context", "", "title", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "initialGeoMarkers", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "markersRequest", "", "lockBottomSheet", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/String;[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;Z)Landroid/content/Intent;", "INITIAL_GEO_MARKERS_KEY", "Ljava/lang/String;", "LOCK_BOTTOM_SHEET_KEY", "MARKERS_REQUEST_KEY", "TITLE_KEY", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ Intent createIntent$default(Companion companion, Context context, String str, GeoMarker[] geoMarkerArr, MarkersRequest markersRequest, boolean z, int i, Object obj) {
            return companion.createIntent(context, str, geoMarkerArr, markersRequest, (i & 16) != 0 ? false : z);
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull String str, @NotNull GeoMarker[] geoMarkerArr, @Nullable MarkersRequest markersRequest, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(geoMarkerArr, "initialGeoMarkers");
            Intent intent = new Intent(context, PlatformMapActivity.class);
            intent.putExtra("title", str);
            intent.putExtra("initial_pins", geoMarkerArr);
            if (markersRequest != null) {
                intent.putExtra("markers_request", markersRequest);
            }
            intent.putExtra("lock_bottom_sheet", z);
            return intent;
        }

        public Companion(j jVar) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 69 && i2 == -1) {
            Logs.verbose$default("PlatformMapActivity", "onActivityResult(requestCode == ENABLE_LOCATION_REQUEST_CODE, resultCode == RESULT_OK) => onLocationEnabled()", null, 4, null);
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(PlatformMapFragment.TAG);
            if (!(findFragmentByTag instanceof OnLocationEnabledListener)) {
                findFragmentByTag = null;
            }
            OnLocationEnabledListener onLocationEnabledListener = (OnLocationEnabledListener) findFragmentByTag;
            if (onLocationEnabledListener != null) {
                onLocationEnabledListener.onLocationEnabled();
            } else {
                Logs.warning$default("PlatformMapActivity", "PlatformMapFragment not found!", null, 4, null);
            }
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
        if (extras == null || (str = extras.getString("title")) == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "intent.extras?.getString(TITLE_KEY) ?: \"\"");
        Intent intent2 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        MarkersRequest markersRequest = null;
        Parcelable[] parcelableArray = extras2 != null ? extras2.getParcelableArray("initial_pins") : null;
        if (!(parcelableArray instanceof Parcelable[])) {
            parcelableArray = null;
        }
        if (parcelableArray == null) {
            parcelableArray = new Parcelable[0];
        }
        Intent intent3 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent3, "intent");
        Bundle extras3 = intent3.getExtras();
        MarkersRequest markersRequest2 = extras3 != null ? (MarkersRequest) extras3.getParcelable("markers_request") : null;
        if (markersRequest2 instanceof MarkersRequest) {
            markersRequest = markersRequest2;
        }
        Intent intent4 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent4, "intent");
        Bundle extras4 = intent4.getExtras();
        boolean z = extras4 != null ? extras4.getBoolean("lock_bottom_sheet", false) : false;
        int length = parcelableArray.length;
        GeoMarker[] geoMarkerArr = new GeoMarker[length];
        for (int i = 0; i < length; i++) {
            Parcelable parcelable = parcelableArray[i];
            Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.geo.GeoMarker");
            geoMarkerArr[i] = (GeoMarker) parcelable;
        }
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, PlatformMapFragment.Companion.invoke(str, geoMarkerArr, markersRequest, z), PlatformMapFragment.TAG).commit();
        }
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

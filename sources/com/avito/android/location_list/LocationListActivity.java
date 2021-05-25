package com.avito.android.location_list;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ'\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/location_list/LocationListActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/location_list/LocationListListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "Lcom/avito/android/remote/model/Location;", "location", "onLocationSet", "(Lcom/avito/android/remote/model/Location;)V", "onRegionLocationSelected", "Landroidx/fragment/app/Fragment;", "fragment", "", "tag", "", "addToBackStack", AuthSource.SEND_ABUSE, "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Z)V", "k", "Ljava/lang/String;", "categoryId", "<init>", "()V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public class LocationListActivity extends BaseActivity implements LocationListListener {
    public String k = "";

    public final void a(Fragment fragment, String str, boolean z) {
        FragmentTransaction replace = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment, str);
        Intrinsics.checkNotNullExpressionValue(replace, "supportFragmentManager\n …container, fragment, tag)");
        if (z) {
            replace.addToBackStack(str);
        }
        replace.commitAllowingStateLoss();
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (((LocationListFragment) getSupportFragmentManager().findFragmentByTag("LocationListFragment")) == null) {
            Intent intent = getIntent();
            Location location = (Location) intent.getParcelableExtra("location");
            boolean booleanExtra = intent.getBooleanExtra("has_search_area", false);
            boolean booleanExtra2 = intent.getBooleanExtra("show_whole_locations", false);
            String stringExtra = intent.getStringExtra("extra_category_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.k = stringExtra;
            a(LocationListFragmentKt.newLocationListFragmentInstance(location, null, true, booleanExtra, booleanExtra2, this.k, intent.getBooleanExtra("track_location_events", false)), "LocationListFragment", false);
        }
    }

    @Override // com.avito.android.location_list.LocationListListener
    public void onLocationSet(@Nullable Location location) {
        Intent intent = new Intent();
        intent.putExtra("location", location);
        setResult(-1, intent);
    }

    @Override // com.avito.android.location_list.LocationListListener
    public void onRegionLocationSelected(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intent intent = getIntent();
        a(LocationListFragmentKt.newLocationListFragmentInstance((Location) intent.getParcelableExtra("location"), location, false, false, intent.getBooleanExtra("show_whole_locations", false), this.k, intent.getBooleanExtra("track_location_events", false)), "LocationListFragment", true);
    }
}

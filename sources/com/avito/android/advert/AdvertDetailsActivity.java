package com.avito.android.advert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.advert.di.AdvertActivityDependencies;
import com.avito.android.advert.di.DaggerAdvertActivityComponent;
import com.avito.android.advert.item.AdvertDetailsArguments;
import com.avito.android.advert.item.AdvertDetailsFastOpenParams;
import com.avito.android.advert.item.AdvertDetailsFragment;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingActivityKt;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.model.Image;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Intents;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0012\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "setUpCustomToolbar", "()Z", "", "getContentLayoutId", "()I", "onBackPressed", "()V", "handleUp", "<init>", "Factory", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsActivity extends BaseActivity {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ{\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsActivity$Factory;", "", "Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "serverContext", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "", "galleryPosition", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "", "clickTime", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "", "isMarketplace", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/Integer;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;JLcom/avito/android/rec/ScreenSource;Z)Landroid/content/Intent;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final Intent create(@NotNull Context context, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable Integer num, @Nullable TreeClickStreamParent treeClickStreamParent, long j, @NotNull ScreenSource screenSource, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Intrinsics.checkNotNullParameter(screenSource, "screenSource");
            Intent putExtra = new Intent(context, AdvertDetailsActivity.class).putExtra("advert_id", str).putExtra("advert_context", str2).putExtra("fast_open_params", new AdvertDetailsFastOpenParams(str3, str4, str5, image)).putExtra("serp_gallery_position", num).putExtra("advert_click_time", j).putExtra("advert_screen_source", screenSource).putExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, z);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…RKETPLACE, isMarketplace)");
            if (treeClickStreamParent != null) {
                Intents.putTreeAnalyticsParent(putExtra, treeClickStreamParent);
            }
            return putExtra;
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
    }

    public final boolean handleUp() {
        if (!isTaskRoot() || getUpIntent() == null) {
            return false;
        }
        startActivity(getUpIntent());
        return true;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(AdvertDetailsFragment.TAG);
        if (!(findFragmentByTag instanceof AdvertDetailsFragment)) {
            findFragmentByTag = null;
        }
        AdvertDetailsFragment advertDetailsFragment = (AdvertDetailsFragment) findFragmentByTag;
        if (advertDetailsFragment != null) {
            advertDetailsFragment.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        if (bundle == null) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(AdvertDetailsFragment.TAG);
            ScreenSource screenSource = null;
            if (!(findFragmentByTag instanceof AdvertDetailsFragment)) {
                findFragmentByTag = null;
            }
            if (((AdvertDetailsFragment) findFragmentByTag) == null) {
                Intent intent = getIntent();
                if (intent == null || (stringExtra = intent.getStringExtra("advert_id")) == null) {
                    throw new IllegalStateException("");
                }
                Intent intent2 = getIntent();
                String stringExtra2 = intent2 != null ? intent2.getStringExtra("advert_context") : null;
                Intent intent3 = getIntent();
                AdvertDetailsFastOpenParams advertDetailsFastOpenParams = intent3 != null ? (AdvertDetailsFastOpenParams) intent3.getParcelableExtra("fast_open_params") : null;
                Intent intent4 = getIntent();
                long j = 0;
                if (intent4 != null) {
                    j = intent4.getLongExtra("advert_click_time", 0);
                }
                Intent intent5 = getIntent();
                TreeClickStreamParent treeAnalyticsParent = intent5 != null ? Intents.getTreeAnalyticsParent(intent5) : null;
                Intent intent6 = getIntent();
                int intExtra = intent6 != null ? intent6.getIntExtra("serp_gallery_position", 0) : 0;
                Intent intent7 = getIntent();
                if (intent7 != null) {
                    screenSource = (ScreenSource) intent7.getParcelableExtra("advert_screen_source");
                }
                Objects.requireNonNull(screenSource, "null cannot be cast to non-null type com.avito.android.rec.ScreenSource");
                Intent intent8 = getIntent();
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, AdvertDetailsFragment.Companion.newInstance(new AdvertDetailsArguments(stringExtra, stringExtra2, advertDetailsFastOpenParams, treeAnalyticsParent, j, intExtra, screenSource, intent8 != null ? intent8.getBooleanExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, false) : false)), AdvertDetailsFragment.TAG).commitAllowingStateLoss();
            }
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        DaggerAdvertActivityComponent.builder().dependencies((AdvertActivityDependencies) ComponentDependenciesKt.getDependencies(AdvertActivityDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        return true;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}

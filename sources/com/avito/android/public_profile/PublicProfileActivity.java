package com.avito.android.public_profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.public_profile.di.DaggerPublicProfileActivityComponent;
import com.avito.android.public_profile.di.PublicProfileActivityDependencies;
import com.avito.android.public_profile_stuff.R;
import com.avito.android.ui.activity.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/avito/android/public_profile/PublicProfileActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "", "getContentLayoutId", "()I", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "()V", "<init>", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfileActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.public_profile_container;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        PublicProfileFragment publicProfileFragment = (PublicProfileFragment) getSupportFragmentManager().findFragmentById(com.avito.android.ui_components.R.id.fragment_container);
        if (publicProfileFragment != null) {
            publicProfileFragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PublicProfileFragment publicProfileFragment = (PublicProfileFragment) getSupportFragmentManager().findFragmentById(com.avito.android.ui_components.R.id.fragment_container);
        if (publicProfileFragment == null || !publicProfileFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        PublicProfileArguments publicProfileArguments;
        super.onCreate(bundle);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras == null || (publicProfileArguments = (PublicProfileArguments) extras.getParcelable("extra_args")) == null) {
            throw new IllegalArgumentException("Arguments must be specified");
        }
        Intrinsics.checkNotNullExpressionValue(publicProfileArguments, "intent.extras?.getParcel…ments must be specified\")");
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(com.avito.android.ui_components.R.id.fragment_container, PublicProfileFragmentKt.createPublicProfileFragment(publicProfileArguments)).commitAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        finish();
        startActivity(intent);
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        DaggerPublicProfileActivityComponent.builder().publicProfileActivityDependencies((PublicProfileActivityDependencies) ComponentDependenciesKt.getDependencies(PublicProfileActivityDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        return true;
    }
}

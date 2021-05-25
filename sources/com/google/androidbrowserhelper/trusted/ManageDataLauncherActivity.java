package com.google.androidbrowserhelper.trusted;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.androidbrowserhelper.R;
import java.util.List;
public class ManageDataLauncherActivity extends AppCompatActivity {
    public static final String ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA = "android.support.customtabs.action.ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA";
    @Nullable
    public String c;
    @Nullable
    public CustomTabsServiceConnection d;

    public class b extends CustomTabsServiceConnection {
        public b(a aVar) {
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            if (!ManageDataLauncherActivity.this.isFinishing()) {
                ManageDataLauncherActivity.a(ManageDataLauncherActivity.this, customTabsClient.newSession(null));
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public class c extends CustomTabsServiceConnection {
        public CustomTabsSession b;
        public CustomTabsCallback c = new a();

        public class a extends CustomTabsCallback {
            public a() {
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
                if (!ManageDataLauncherActivity.this.isFinishing()) {
                    if (!z) {
                        ManageDataLauncherActivity.this.onError(new RuntimeException(a2.b.a.a.a.W2("Failed to validate origin ", uri)));
                        ManageDataLauncherActivity.this.finish();
                        return;
                    }
                    c cVar = c.this;
                    ManageDataLauncherActivity.a(ManageDataLauncherActivity.this, cVar.b);
                }
            }
        }

        public c(a aVar) {
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            if (!ManageDataLauncherActivity.this.isFinishing()) {
                Uri defaultUrlForManagingSpace = ManageDataLauncherActivity.this.getDefaultUrlForManagingSpace();
                if (defaultUrlForManagingSpace == null) {
                    ManageDataLauncherActivity.this.onError(new RuntimeException("Can't launch settings without an url"));
                    ManageDataLauncherActivity.this.finish();
                    return;
                }
                this.b = customTabsClient.newSession(this.c);
                if (!customTabsClient.warmup(0)) {
                    ManageDataLauncherActivity.this.handleTwaNeverLaunched();
                } else {
                    this.b.validateRelationship(2, defaultUrlForManagingSpace, null);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static void a(ManageDataLauncherActivity manageDataLauncherActivity, CustomTabsSession customTabsSession) {
        boolean z;
        String str = manageDataLauncherActivity.c;
        Uri defaultUrlForManagingSpace = manageDataLauncherActivity.getDefaultUrlForManagingSpace();
        Intent intent = new CustomTabsIntent.Builder().setSession(customTabsSession).build().intent;
        intent.setAction("android.support.customtabs.action.ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA");
        intent.setPackage(str);
        intent.setData(defaultUrlForManagingSpace);
        try {
            manageDataLauncherActivity.startActivity(intent);
            z = true;
        } catch (ActivityNotFoundException unused) {
            z = false;
        }
        if (z) {
            manageDataLauncherActivity.finish();
        } else {
            manageDataLauncherActivity.handleNoSupportForManageSpace();
        }
    }

    @Nullable
    public View createLoadingView() {
        ProgressBar progressBar = new ProgressBar(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        progressBar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(progressBar);
        return frameLayout;
    }

    @Nullable
    public Uri getDefaultUrlForManagingSpace() {
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
            Bundle bundle = activityInfo.metaData;
            if (bundle == null || !bundle.containsKey("android.support.customtabs.trusted.MANAGE_SPACE_URL")) {
                return null;
            }
            Uri parse = Uri.parse(activityInfo.metaData.getString("android.support.customtabs.trusted.MANAGE_SPACE_URL"));
            String str = "Using clean-up URL from Manifest (" + parse + ").";
            return parse;
        } catch (PackageManager.NameNotFoundException e) {
            onError(new RuntimeException(e));
            return null;
        }
    }

    public void handleNoSupportForManageSpace() {
        String str;
        try {
            str = getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(this.c, 0)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            str = this.c;
        }
        Toast.makeText(this, getString(R.string.manage_space_not_supported_toast, new Object[]{str}), 1).show();
        finish();
    }

    public void handleTwaNeverLaunched() {
        Toast.makeText(this, getString(R.string.manage_space_no_data_toast), 1).show();
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IntentFilter intentFilter;
        super.onCreate(bundle);
        String readLastLaunchedProviderPackageName = new TwaSharedPreferencesManager(this).readLastLaunchedProviderPackageName();
        this.c = readLastLaunchedProviderPackageName;
        if (readLastLaunchedProviderPackageName == null) {
            handleTwaNeverLaunched();
            return;
        }
        boolean z = true;
        if (!ChromeLegacyUtils.supportsTrustedWebActivities(getPackageManager(), readLastLaunchedProviderPackageName)) {
            List<ResolveInfo> queryIntentServices = getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION).setPackage(readLastLaunchedProviderPackageName), 64);
            if (queryIntentServices.isEmpty() || (intentFilter = queryIntentServices.get(0).filter) == null || !intentFilter.hasCategory(CustomTabsService.TRUSTED_WEB_ACTIVITY_CATEGORY)) {
                z = false;
            }
        }
        if (!z) {
            handleNoSupportForManageSpace();
            return;
        }
        View createLoadingView = createLoadingView();
        if (createLoadingView != null) {
            setContentView(createLoadingView);
        }
        if (ChromeLegacyUtils.supportsManageSpaceWithoutWarmupAndValidation(getPackageManager(), this.c)) {
            this.d = new b(null);
        } else {
            this.d = new c(null);
        }
        CustomTabsClient.bindCustomTabsService(this, this.c, this.d);
    }

    public void onError(RuntimeException runtimeException) {
        throw runtimeException;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        CustomTabsServiceConnection customTabsServiceConnection = this.d;
        if (customTabsServiceConnection != null) {
            unbindService(customTabsServiceConnection);
        }
        finish();
    }
}

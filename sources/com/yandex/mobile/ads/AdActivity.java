package com.yandex.mobile.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.RelativeLayout;
import com.yandex.mobile.ads.impl.k;
import com.yandex.mobile.ads.impl.m;
import com.yandex.mobile.ads.impl.p;
public final class AdActivity extends Activity {
    public static final String a = AdActivity.class.getCanonicalName();
    @Nullable
    private RelativeLayout b;
    @Nullable
    private k c;

    @Nullable
    private static ResultReceiver a(@NonNull Intent intent) {
        try {
            return (ResultReceiver) intent.getParcelableExtra("extra_receiver");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        k kVar = this.c;
        if (kVar == null || kVar.c()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        k kVar;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.b = relativeLayout;
        Intent intent = getIntent();
        if (intent != null) {
            Window window = getWindow();
            ResultReceiver a3 = a(intent);
            kVar = m.a().a(this, relativeLayout, a3, new p(this, a3), intent, window);
        } else {
            kVar = null;
        }
        this.c = kVar;
        if (kVar != null) {
            kVar.a();
            this.c.c_();
            setContentView(this.b);
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        k kVar = this.c;
        if (kVar != null) {
            kVar.d();
            this.c.g();
        }
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onPause() {
        k kVar = this.c;
        if (kVar != null) {
            kVar.f();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        k kVar = this.c;
        if (kVar != null) {
            kVar.e();
        }
    }
}

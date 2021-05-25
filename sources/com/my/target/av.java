package com.my.target;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ap;
import com.my.target.common.MyTargetActivity;
import java.lang.ref.WeakReference;
public abstract class av implements ap, MyTargetActivity.ActivityEngine {
    @NonNull
    public final ap.a a;
    public boolean b;
    public boolean c;
    @Nullable
    public WeakReference<MyTargetActivity> d;
    public boolean e;
    @Nullable
    public ap.b f;

    public av(@NonNull ap.a aVar) {
        this.a = aVar;
    }

    @Nullable
    public static av a(@NonNull ca caVar, @NonNull cq cqVar, boolean z, @NonNull ap.a aVar) {
        if (caVar instanceof ce) {
            return ay.a((ce) caVar, cqVar, z, aVar);
        }
        if (caVar instanceof cc) {
            return new aw((cc) caVar, cqVar, aVar);
        }
        if (caVar instanceof cd) {
            return new ax((cd) caVar, aVar);
        }
        return null;
    }

    @Override // com.my.target.ap
    public void a(@Nullable ap.b bVar) {
        this.f = bVar;
    }

    @Override // com.my.target.ap
    @Nullable
    public String ad() {
        return "myTarget";
    }

    @Override // com.my.target.ap
    public float ae() {
        return 0.0f;
    }

    public abstract boolean al();

    @Nullable
    public ap.b am() {
        return this.f;
    }

    @Override // com.my.target.ap
    public void destroy() {
        dismiss();
    }

    @Override // com.my.target.ap
    public void dismiss() {
        this.e = false;
        WeakReference<MyTargetActivity> weakReference = this.d;
        MyTargetActivity myTargetActivity = weakReference == null ? null : weakReference.get();
        if (myTargetActivity != null) {
            myTargetActivity.finish();
        }
    }

    @Override // com.my.target.ap
    public void o(@NonNull Context context) {
        if (this.e) {
            ae.a("Unable to open Interstitial Ad twice, please dismiss currently showing ad first");
            return;
        }
        this.e = true;
        MyTargetActivity.activityEngine = this;
        Intent intent = new Intent(context, MyTargetActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public final boolean onActivityBackPressed() {
        return al();
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityCreate(@NonNull MyTargetActivity myTargetActivity, @NonNull Intent intent, @NonNull FrameLayout frameLayout) {
        this.d = new WeakReference<>(myTargetActivity);
        myTargetActivity.setTheme(16973830);
        myTargetActivity.getWindow().setFlags(1024, 1024);
        this.a.onDisplay();
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityDestroy() {
        this.e = false;
        this.d = null;
        this.a.onDismiss();
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public boolean onActivityOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityPause() {
        this.b = false;
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityResume() {
        this.b = true;
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityStart() {
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityStop() {
    }
}

package com.my.target;

import a2.l.a.i;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.MyTargetActivity;
import com.my.target.nativeads.NativeAppwallAd;
import com.my.target.nativeads.factories.NativeAppwallViewsFactory;
import com.my.target.nativeads.views.AppwallAdView;
import java.lang.ref.WeakReference;
public class bg implements MyTargetActivity.ActivityEngine {
    @NonNull
    public final NativeAppwallAd a;
    @Nullable
    public WeakReference<MyTargetActivity> b;
    public boolean c;

    public bg(@NonNull NativeAppwallAd nativeAppwallAd) {
        this.a = nativeAppwallAd;
    }

    @NonNull
    public static bg a(@NonNull NativeAppwallAd nativeAppwallAd) {
        return new bg(nativeAppwallAd);
    }

    public final void b(@NonNull ActionBar actionBar, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(actionBar.getTitle());
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, actionBar.getTitle().length(), 18);
        actionBar.setTitle(spannableStringBuilder);
    }

    public final void c(@NonNull ViewGroup viewGroup) {
        AppwallAdView appwallView = NativeAppwallViewsFactory.getAppwallView(this.a, viewGroup.getContext());
        this.a.registerAppwallAdView(appwallView);
        appwallView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(appwallView);
    }

    public void destroy() {
        dismiss();
    }

    public void dismiss() {
        this.c = false;
        WeakReference<MyTargetActivity> weakReference = this.b;
        MyTargetActivity myTargetActivity = weakReference == null ? null : weakReference.get();
        if (myTargetActivity != null) {
            myTargetActivity.finish();
        }
    }

    public void o(Context context) {
        if (this.c) {
            ae.a("Unable to open Appwall Ad twice, please dismiss currently showing ad first");
            return;
        }
        this.c = true;
        MyTargetActivity.activityEngine = this;
        Intent intent = new Intent(context, MyTargetActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public boolean onActivityBackPressed() {
        return true;
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityCreate(@NonNull MyTargetActivity myTargetActivity, @NonNull Intent intent, @NonNull FrameLayout frameLayout) {
        this.b = new WeakReference<>(myTargetActivity);
        Window window = myTargetActivity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        myTargetActivity.setTheme(16974392);
        ActionBar actionBar = myTargetActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(this.a.getTitle());
            actionBar.setIcon(17170445);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setBackgroundDrawable(new ColorDrawable(this.a.getTitleBackgroundColor()));
            b(actionBar, this.a.getTitleTextColor());
            actionBar.setElevation((float) io.af(myTargetActivity).L(4));
        }
        window.setStatusBarColor(this.a.getTitleSupplementaryColor());
        if (myTargetActivity.getActionBar() == null) {
            LinearLayout linearLayout = new LinearLayout(myTargetActivity);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(linearLayout);
            fp fpVar = new fp(linearLayout.getContext());
            fpVar.setTitle(this.a.getTitle());
            fpVar.setStripeColor(this.a.getTitleSupplementaryColor());
            fpVar.setMainColor(this.a.getTitleBackgroundColor());
            fpVar.setTitleColor(this.a.getTitleTextColor());
            fpVar.setLayoutParams(new ViewGroup.LayoutParams(-1, io.af(linearLayout.getContext()).L(52)));
            linearLayout.addView(fpVar);
            fpVar.setOnCloseClickListener(new i(this));
            c(linearLayout);
        } else {
            c(frameLayout);
        }
        NativeAppwallAd.AppwallAdListener listener = this.a.getListener();
        if (listener != null) {
            listener.onDisplay(this.a);
        }
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityDestroy() {
        this.c = false;
        this.b = null;
        NativeAppwallAd.AppwallAdListener listener = this.a.getListener();
        if (listener != null) {
            listener.onDismiss(this.a);
        }
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public boolean onActivityOptionsItemSelected(MenuItem menuItem) {
        WeakReference<MyTargetActivity> weakReference;
        MyTargetActivity myTargetActivity;
        if (menuItem.getItemId() != 16908332 || (weakReference = this.b) == null || (myTargetActivity = weakReference.get()) == null) {
            return false;
        }
        myTargetActivity.finish();
        return true;
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityPause() {
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityResume() {
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityStart() {
    }

    @Override // com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityStop() {
    }
}

package com.google.android.play.core.missingsplits;

import android.app.Application;
public class MissingSplitsDetectingApplication extends Application {
    public boolean a = false;

    @Override // android.app.Application
    public final void onCreate() {
        if (!this.a) {
            this.a = true;
            if (!MissingSplitsManagerFactory.create(this).disableAppIfMissingRequiredSplits()) {
                super.onCreate();
                onCreateCustom();
                return;
            }
            return;
        }
        throw new IllegalStateException("The onCreate method must be invoked at most once.");
    }

    public void onCreateCustom() {
    }
}

package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
public class FragmentWrapper {
    public Fragment a;
    public android.app.Fragment b;

    public FragmentWrapper(Fragment fragment) {
        Validate.notNull(fragment, "fragment");
        this.a = fragment;
    }

    public final Activity getActivity() {
        Fragment fragment = this.a;
        if (fragment != null) {
            return fragment.getActivity();
        }
        return this.b.getActivity();
    }

    public android.app.Fragment getNativeFragment() {
        return this.b;
    }

    public Fragment getSupportFragment() {
        return this.a;
    }

    public void startActivityForResult(Intent intent, int i) {
        Fragment fragment = this.a;
        if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        } else {
            this.b.startActivityForResult(intent, i);
        }
    }

    public FragmentWrapper(android.app.Fragment fragment) {
        Validate.notNull(fragment, "fragment");
        this.b = fragment;
    }
}

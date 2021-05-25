package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog;
public class FacebookDialogFragment extends DialogFragment {
    public static final String TAG = "FacebookDialogFragment";
    public Dialog a;

    public class a implements WebDialog.OnCompleteListener {
        public a() {
        }

        @Override // com.facebook.internal.WebDialog.OnCompleteListener
        public void onComplete(Bundle bundle, FacebookException facebookException) {
            FacebookDialogFragment facebookDialogFragment = FacebookDialogFragment.this;
            String str = FacebookDialogFragment.TAG;
            facebookDialogFragment.a(bundle, facebookException);
        }
    }

    public class b implements WebDialog.OnCompleteListener {
        public b() {
        }

        @Override // com.facebook.internal.WebDialog.OnCompleteListener
        public void onComplete(Bundle bundle, FacebookException facebookException) {
            FacebookDialogFragment facebookDialogFragment = FacebookDialogFragment.this;
            String str = FacebookDialogFragment.TAG;
            FragmentActivity activity = facebookDialogFragment.getActivity();
            Intent intent = new Intent();
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtras(bundle);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    public final void a(Bundle bundle, FacebookException facebookException) {
        FragmentActivity activity = getActivity();
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(activity.getIntent(), bundle, facebookException));
        activity.finish();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.a instanceof WebDialog) && isResumed()) {
            ((WebDialog) this.a).resize();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        WebDialog webDialog;
        super.onCreate(bundle);
        if (this.a == null) {
            FragmentActivity activity = getActivity();
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(activity.getIntent());
            if (!methodArgumentsFromIntent.getBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, false)) {
                String string = methodArgumentsFromIntent.getString("action");
                Bundle bundle2 = methodArgumentsFromIntent.getBundle("params");
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd(TAG, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                }
                webDialog = new WebDialog.Builder(activity, string, bundle2).setOnCompleteListener(new a()).build();
            } else {
                String string2 = methodArgumentsFromIntent.getString("url");
                if (Utility.isNullOrEmpty(string2)) {
                    Utility.logd(TAG, "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                webDialog = FacebookWebFallbackDialog.newInstance(activity, string2, String.format("fb%s://bridge/", FacebookSdk.getApplicationId()));
                webDialog.setOnCompleteListener(new b());
            }
            this.a = webDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a == null) {
            a(null, null);
            setShowsDialog(false);
        }
        return this.a;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = this.a;
        if (dialog instanceof WebDialog) {
            ((WebDialog) dialog).resize();
        }
    }

    public void setDialog(Dialog dialog) {
        this.a = dialog;
    }
}

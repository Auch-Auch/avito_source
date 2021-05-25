package com.facebook.share.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.common.R;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Deprecated
public class DeviceShareDialogFragment extends DialogFragment {
    public static final String TAG = "DeviceShareDialogFragment";
    public static ScheduledThreadPoolExecutor g;
    public ProgressBar a;
    public TextView b;
    public Dialog c;
    public volatile c d;
    public volatile ScheduledFuture e;
    public ShareContent f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DeviceShareDialogFragment.this.c.dismiss();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DeviceShareDialogFragment.this.c.dismiss();
        }
    }

    public static class c implements Parcelable {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public String a;
        public long b;

        public static class a implements Parcelable.Creator<c> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public c[] newArray(int i) {
                return new c[i];
            }
        }

        public c() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeLong(this.b);
        }

        public c(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readLong();
        }
    }

    public final void a(int i, Intent intent) {
        if (this.d != null) {
            DeviceRequestsHelper.cleanUpAdvertisementService(this.d.a);
        }
        FacebookRequestError facebookRequestError = (FacebookRequestError) intent.getParcelableExtra("error");
        if (facebookRequestError != null) {
            Toast.makeText(getContext(), facebookRequestError.getErrorMessage(), 0).show();
        }
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            activity.setResult(i, intent);
            activity.finish();
        }
    }

    public final void b(FacebookRequestError facebookRequestError) {
        if (isAdded()) {
            getFragmentManager().beginTransaction().remove(this).commit();
        }
        Intent intent = new Intent();
        intent.putExtra("error", facebookRequestError);
        a(-1, intent);
    }

    public final void c(c cVar) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        this.d = cVar;
        this.b.setText(cVar.a);
        this.b.setVisibility(0);
        this.a.setVisibility(8);
        synchronized (DeviceShareDialogFragment.class) {
            if (g == null) {
                g = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = g;
        }
        this.e = scheduledThreadPoolExecutor.schedule(new b(), cVar.b, TimeUnit.SECONDS);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        this.c = new Dialog(getActivity(), R.style.com_facebook_auth_dialog);
        Bundle bundle2 = null;
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.com_facebook_device_auth_dialog_fragment, (ViewGroup) null);
        this.a = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.b = (TextView) inflate.findViewById(R.id.confirmation_code);
        ((Button) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new a());
        ((TextView) inflate.findViewById(R.id.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
        this.c.setContentView(inflate);
        ShareContent shareContent = this.f;
        if (shareContent != null) {
            if (shareContent instanceof ShareLinkContent) {
                bundle2 = WebDialogParameters.create((ShareLinkContent) shareContent);
            } else if (shareContent instanceof ShareOpenGraphContent) {
                bundle2 = WebDialogParameters.create((ShareOpenGraphContent) shareContent);
            }
        }
        if (bundle2 == null || bundle2.size() == 0) {
            b(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        bundle2.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        bundle2.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo());
        new GraphRequest(null, "device/share", bundle2, HttpMethod.POST, new a2.g.v.l.a(this)).executeAsync();
        return this.c;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c cVar;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (!(bundle == null || (cVar = (c) bundle.getParcelable("request_state")) == null)) {
            c(cVar);
        }
        return onCreateView;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.e != null) {
            this.e.cancel(true);
        }
        a(-1, new Intent());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.d != null) {
            bundle.putParcelable("request_state", this.d);
        }
    }

    public void setShareContent(ShareContent shareContent) {
        this.f = shareContent;
    }
}

package com.facebook.login;

import a2.g.s.e;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
public class DeviceAuthDialog extends DialogFragment {
    public static final /* synthetic */ int m = 0;
    public View a;
    public TextView b;
    public TextView c;
    public e d;
    public AtomicBoolean e = new AtomicBoolean();
    public volatile GraphRequestAsyncTask f;
    public volatile ScheduledFuture g;
    public volatile d h;
    public Dialog i;
    public boolean j = false;
    public boolean k = false;
    public LoginClient.Request l = null;

    public class a implements GraphRequest.Callback {
        public a() {
        }

        @Override // com.facebook.GraphRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            if (!DeviceAuthDialog.this.j) {
                if (graphResponse.getError() != null) {
                    DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                    return;
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                d dVar = new d();
                try {
                    String string = jSONObject.getString("user_code");
                    dVar.b = string;
                    dVar.a = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", string);
                    dVar.c = jSONObject.getString("code");
                    dVar.d = jSONObject.getLong("interval");
                    DeviceAuthDialog.this.e(dVar);
                } catch (JSONException e) {
                    DeviceAuthDialog.this.onError(new FacebookException(e));
                }
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DeviceAuthDialog.this.onCancel();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
            int i = DeviceAuthDialog.m;
            deviceAuthDialog.c();
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();
        public String a;
        public String b;
        public String c;
        public long d;
        public long e;

        public static class a implements Parcelable.Creator<d> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeLong(this.d);
            parcel.writeLong(this.e);
        }

        public d(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.d = parcel.readLong();
            this.e = parcel.readLong();
        }
    }

    public static void a(DeviceAuthDialog deviceAuthDialog, String str, Long l2, Long l3) {
        Date date;
        Objects.requireNonNull(deviceAuthDialog);
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        Date date2 = null;
        if (l2.longValue() != 0) {
            date = new Date((l2.longValue() * 1000) + new Date().getTime());
        } else {
            date = null;
        }
        if (l3.longValue() != 0) {
            date2 = new Date(l3.longValue() * 1000);
        }
        new GraphRequest(new AccessToken(str, FacebookSdk.getApplicationId(), "0", null, null, null, null, date, null, date2), "me", bundle, HttpMethod.GET, new a2.g.s.d(deviceAuthDialog, str, date, date2)).executeAsync();
    }

    public static void b(DeviceAuthDialog deviceAuthDialog, String str, Utility.PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        e eVar = deviceAuthDialog.d;
        String applicationId = FacebookSdk.getApplicationId();
        List<String> grantedPermissions = permissionsLists.getGrantedPermissions();
        List<String> declinedPermissions = permissionsLists.getDeclinedPermissions();
        List<String> expiredPermissions = permissionsLists.getExpiredPermissions();
        AccessTokenSource accessTokenSource = AccessTokenSource.DEVICE_AUTH;
        Objects.requireNonNull(eVar);
        eVar.loginClient.d(LoginClient.Result.d(eVar.loginClient.g, new AccessToken(str2, applicationId, str, grantedPermissions, declinedPermissions, expiredPermissions, accessTokenSource, date, null, date2)));
        deviceAuthDialog.i.dismiss();
    }

    public final void c() {
        this.h.e = new Date().getTime();
        Bundle bundle = new Bundle();
        bundle.putString("code", this.h.c);
        this.f = new GraphRequest(null, "device/login_status", bundle, HttpMethod.POST, new a2.g.s.a(this)).executeAsync();
    }

    public final void d() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (e.class) {
            if (e.b == null) {
                e.b = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = e.b;
        }
        this.g = scheduledThreadPoolExecutor.schedule(new c(), this.h.d, TimeUnit.SECONDS);
    }

    public final void e(d dVar) {
        this.h = dVar;
        this.b.setText(dVar.b);
        this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getResources(), DeviceRequestsHelper.generateQRCode(dVar.a)), (Drawable) null, (Drawable) null);
        boolean z = false;
        this.b.setVisibility(0);
        this.a.setVisibility(8);
        if (!this.k && DeviceRequestsHelper.startAdvertisementService(dVar.b)) {
            new InternalAppEventsLogger(getContext()).logEventImplicitly(AnalyticsEvents.EVENT_SMART_LOGIN_SERVICE);
        }
        if (dVar.e != 0 && (new Date().getTime() - dVar.e) - (dVar.d * 1000) < 0) {
            z = true;
        }
        if (z) {
            d();
        } else {
            c();
        }
    }

    @LayoutRes
    public int getLayoutResId(boolean z) {
        return z ? R.layout.com_facebook_smart_device_dialog_fragment : R.layout.com_facebook_device_auth_dialog_fragment;
    }

    public View initializeContentView(boolean z) {
        View inflate = getActivity().getLayoutInflater().inflate(getLayoutResId(z), (ViewGroup) null);
        this.a = inflate.findViewById(R.id.progress_bar);
        this.b = (TextView) inflate.findViewById(R.id.confirmation_code);
        ((Button) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new b());
        TextView textView = (TextView) inflate.findViewById(R.id.com_facebook_device_auth_instructions);
        this.c = textView;
        textView.setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
        return inflate;
    }

    public void onCancel() {
        if (this.e.compareAndSet(false, true)) {
            if (this.h != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.h.b);
            }
            e eVar = this.d;
            if (eVar != null) {
                eVar.loginClient.d(LoginClient.Result.a(eVar.loginClient.g, "User canceled log in."));
            }
            this.i.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        this.i = new Dialog(getActivity(), R.style.com_facebook_auth_dialog);
        this.i.setContentView(initializeContentView(DeviceRequestsHelper.isAvailable() && !this.k));
        return this.i;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d dVar;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.d = (e) ((LoginFragment) ((FacebookActivity) getActivity()).getCurrentFragment()).b.f();
        if (!(bundle == null || (dVar = (d) bundle.getParcelable("request_state")) == null)) {
            e(dVar);
        }
        return onCreateView;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.j = true;
        this.e.set(true);
        super.onDestroyView();
        if (this.f != null) {
            this.f.cancel(true);
        }
        if (this.g != null) {
            this.g.cancel(true);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.j) {
            onCancel();
        }
    }

    public void onError(FacebookException facebookException) {
        if (this.e.compareAndSet(false, true)) {
            if (this.h != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.h.b);
            }
            e eVar = this.d;
            eVar.loginClient.d(LoginClient.Result.b(eVar.loginClient.g, null, facebookException.getMessage()));
            this.i.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.h != null) {
            bundle.putParcelable("request_state", this.h);
        }
    }

    public void startLogin(LoginClient.Request request) {
        this.l = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.b));
        String str = request.g;
        if (str != null) {
            bundle.putString("redirect_uri", str);
        }
        String str2 = request.i;
        if (str2 != null) {
            bundle.putString(DeviceRequestsHelper.DEVICE_TARGET_USER_ID, str2);
        }
        bundle.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        bundle.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo());
        new GraphRequest(null, "device/login", bundle, HttpMethod.POST, new a()).executeAsync();
    }
}

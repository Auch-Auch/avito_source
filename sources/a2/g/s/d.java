package a2.g.s;

import android.app.AlertDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.common.R;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.login.DeviceAuthDialog;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
public class d implements GraphRequest.Callback {
    public final /* synthetic */ String a;
    public final /* synthetic */ Date b;
    public final /* synthetic */ Date c;
    public final /* synthetic */ DeviceAuthDialog d;

    public d(DeviceAuthDialog deviceAuthDialog, String str, Date date, Date date2) {
        this.d = deviceAuthDialog;
        this.a = str;
        this.b = date;
        this.c = date2;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (!this.d.e.get()) {
            if (graphResponse.getError() != null) {
                this.d.onError(graphResponse.getError().getException());
                return;
            }
            try {
                JSONObject jSONObject = graphResponse.getJSONObject();
                String string = jSONObject.getString("id");
                Utility.PermissionsLists handlePermissionResponse = Utility.handlePermissionResponse(jSONObject);
                String string2 = jSONObject.getString("name");
                DeviceRequestsHelper.cleanUpAdvertisementService(this.d.h.b);
                if (FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.RequireConfirm)) {
                    DeviceAuthDialog deviceAuthDialog = this.d;
                    if (!deviceAuthDialog.k) {
                        deviceAuthDialog.k = true;
                        String str = this.a;
                        Date date = this.b;
                        Date date2 = this.c;
                        String string3 = deviceAuthDialog.getResources().getString(R.string.com_facebook_smart_login_confirmation_title);
                        String string4 = deviceAuthDialog.getResources().getString(R.string.com_facebook_smart_login_confirmation_continue_as);
                        String string5 = deviceAuthDialog.getResources().getString(R.string.com_facebook_smart_login_confirmation_cancel);
                        String format = String.format(string4, string2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(deviceAuthDialog.getContext());
                        builder.setMessage(string3).setCancelable(true).setNegativeButton(format, new c(deviceAuthDialog, string, handlePermissionResponse, str, date, date2)).setPositiveButton(string5, new b(deviceAuthDialog));
                        builder.create().show();
                        return;
                    }
                }
                DeviceAuthDialog.b(this.d, string, handlePermissionResponse, this.a, this.b, this.c);
            } catch (JSONException e) {
                this.d.onError(new FacebookException(e));
            }
        }
    }
}

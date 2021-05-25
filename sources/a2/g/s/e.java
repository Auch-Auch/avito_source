package a2.g.s;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.LoginClient;
import java.util.concurrent.ScheduledThreadPoolExecutor;
public class e extends n {
    public static final Parcelable.Creator<e> CREATOR = new a();
    public static ScheduledThreadPoolExecutor b;

    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new e[i];
        }
    }

    public e(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // a2.g.s.n
    public String b() {
        return "device_auth";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // a2.g.s.n
    public int f(LoginClient.Request request) {
        FragmentActivity e = this.loginClient.e();
        if (e == null || e.isFinishing()) {
            return 1;
        }
        DeviceAuthDialog deviceAuthDialog = new DeviceAuthDialog();
        deviceAuthDialog.show(e.getSupportFragmentManager(), "login_with_facebook");
        deviceAuthDialog.startLogin(request);
        return 1;
    }

    @Override // a2.g.s.n, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public e(Parcel parcel) {
        super(parcel);
    }
}

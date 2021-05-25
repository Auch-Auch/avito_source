package a2.g.s;

import android.content.DialogInterface;
import com.facebook.login.DeviceAuthDialog;
public class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ DeviceAuthDialog a;

    public b(DeviceAuthDialog deviceAuthDialog) {
        this.a = deviceAuthDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.i.setContentView(this.a.initializeContentView(false));
        DeviceAuthDialog deviceAuthDialog = this.a;
        deviceAuthDialog.startLogin(deviceAuthDialog.l);
    }
}

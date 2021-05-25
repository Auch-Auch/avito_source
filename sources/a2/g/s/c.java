package a2.g.s;

import android.content.DialogInterface;
import com.facebook.internal.Utility;
import com.facebook.login.DeviceAuthDialog;
import java.util.Date;
public class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ Utility.PermissionsLists b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Date d;
    public final /* synthetic */ Date e;
    public final /* synthetic */ DeviceAuthDialog f;

    public c(DeviceAuthDialog deviceAuthDialog, String str, Utility.PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        this.f = deviceAuthDialog;
        this.a = str;
        this.b = permissionsLists;
        this.c = str2;
        this.d = date;
        this.e = date2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DeviceAuthDialog.b(this.f, this.a, this.b, this.c, this.d, this.e);
    }
}

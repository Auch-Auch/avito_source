package a2.a.a.e2.e0;

import android.content.DialogInterface;
import com.avito.android.publish.start_publish.StartPublishFragment;
public final class c implements DialogInterface.OnCancelListener {
    public final /* synthetic */ StartPublishFragment a;

    public c(StartPublishFragment startPublishFragment) {
        this.a = startPublishFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.l = null;
        this.a.onBackPressed();
    }
}

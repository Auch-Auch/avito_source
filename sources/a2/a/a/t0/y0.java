package a2.a.a.t0;

import android.content.DialogInterface;
import com.avito.android.lastclick.LastClick;
public final class y0 implements DialogInterface.OnClickListener {
    public static final y0 a = new y0();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        LastClick.Updater.update();
    }
}

package l6.c.a;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.widget.Toast;
import androidx.browser.R;
public class c implements Runnable {
    public final /* synthetic */ e a;

    public c(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((ClipboardManager) this.a.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("url", this.a.b.toString()));
        Toast.makeText(this.a.a, this.a.a.getString(R.string.copy_toast_msg), 0).show();
    }
}

package a2.l.a;

import android.content.Context;
import android.media.AudioManager;
import android.view.View;
import com.my.target.ae;
import com.my.target.al;
import com.my.target.am;
import com.my.target.an;
import com.my.target.ci;
import com.my.target.fk;
import java.lang.ref.WeakReference;
public class e implements View.OnClickListener {
    public final /* synthetic */ an a;

    public e(an anVar) {
        this.a = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an anVar = this.a;
        am amVar = anVar.k;
        ci content = anVar.d.getContent();
        if (content != null) {
            al a3 = al.a(content);
            a3.a(anVar.c);
            a3.k(view.getContext());
            return;
        }
        WeakReference<Context> weakReference = amVar.m;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context == null) {
            context = view.getContext();
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            audioManager.requestAudioFocus(amVar.c, 3, 2);
        }
        if (!amVar.w) {
            if (amVar.n == 1) {
                amVar.n = 4;
            }
            amVar.p = true;
            try {
                fk.a(amVar, context).show();
            } catch (Throwable th) {
                th.printStackTrace();
                ae.b("Unable to start video dialog! Check myTarget MediaAdView, maybe it was created with non-Activity context");
                amVar.o();
            }
        }
    }
}

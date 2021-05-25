package a2.g.k.a0;

import com.facebook.appevents.suggestedevents.ViewOnClickListener;
public final class e implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public e(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewOnClickListener.a(this.a, this.b, new float[0]);
    }
}

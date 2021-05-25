package a2.g.k;

import com.facebook.appevents.UserDataStore;
public final class u implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public u(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!UserDataStore.b.get()) {
            UserDataStore.a();
        }
        UserDataStore.a.edit().putString(this.a, this.b).apply();
    }
}

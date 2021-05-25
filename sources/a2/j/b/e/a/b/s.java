package a2.j.b.e.a.b;

import com.google.android.play.core.assetpacks.AssetPackState;
public final /* synthetic */ class s implements Runnable {
    public final v a;
    public final AssetPackState b;

    public s(v vVar, AssetPackState assetPackState) {
        this.a = vVar;
        this.b = assetPackState;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a((v) this.b);
    }
}

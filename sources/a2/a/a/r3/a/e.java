package a2.a.a.r3.a;

import com.avito.android.verification.verification_status.VerificationStatusViewImpl;
public final class e implements Runnable {
    public final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VerificationStatusViewImpl.access$getDeepLinkListener$p(this.a.b.a).invoke(this.a.a.getDeeplink());
    }
}

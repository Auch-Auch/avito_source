package a2.j.b.e.a.b;

import com.google.android.play.core.assetpacks.dd;
import com.google.android.play.core.internal.aa;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
public final class e2 {
    public static final aa b = new aa("VerifySliceTaskHandler");
    public final a0 a;

    public e2(a0 a0Var) {
        this.a = a0Var;
    }

    public final void a(d2 d2Var) {
        File b2 = this.a.b(d2Var.b, d2Var.c, d2Var.d, d2Var.e);
        if (b2.exists()) {
            try {
                File s = this.a.s(d2Var.b, d2Var.c, d2Var.d, d2Var.e);
                if (s.exists()) {
                    try {
                        if (dd.e(c2.a(b2, s)).equals(d2Var.f)) {
                            b.c("Verification of slice %s of pack %s successful.", d2Var.e, d2Var.b);
                            File i = this.a.i(d2Var.b, d2Var.c, d2Var.d, d2Var.e);
                            if (!i.exists()) {
                                i.mkdirs();
                            }
                            if (!b2.renameTo(i)) {
                                throw new q0(String.format("Failed to move slice %s after verification.", d2Var.e), d2Var.a);
                            }
                            return;
                        }
                        throw new q0(String.format("Verification failed for slice %s.", d2Var.e), d2Var.a);
                    } catch (NoSuchAlgorithmException e) {
                        throw new q0("SHA256 algorithm not supported.", e, d2Var.a);
                    } catch (IOException e2) {
                        throw new q0(String.format("Could not digest file during verification for slice %s.", d2Var.e), e2, d2Var.a);
                    }
                } else {
                    throw new q0(String.format("Cannot find metadata files for slice %s.", d2Var.e), d2Var.a);
                }
            } catch (IOException e3) {
                throw new q0(String.format("Could not reconstruct slice archive during verification for slice %s.", d2Var.e), e3, d2Var.a);
            }
        } else {
            throw new q0(String.format("Cannot find unverified files for slice %s.", d2Var.e), d2Var.a);
        }
    }
}

package org.spongycastle.x509;

import java.security.cert.CertPath;
import org.spongycastle.i18n.ErrorBundle;
import org.spongycastle.i18n.LocalizedException;
public class CertPathReviewerException extends LocalizedException {
    public int b = -1;
    public CertPath c = null;

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th) {
        super(errorBundle, th);
    }

    public CertPath getCertPath() {
        return this.c;
    }

    public int getIndex() {
        return this.b;
    }

    public CertPathReviewerException(ErrorBundle errorBundle) {
        super(errorBundle);
    }

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th, CertPath certPath, int i) {
        super(errorBundle, th);
        if (certPath == null || i == -1) {
            throw new IllegalArgumentException();
        } else if (i < -1 || i >= certPath.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.c = certPath;
            this.b = i;
        }
    }

    public CertPathReviewerException(ErrorBundle errorBundle, CertPath certPath, int i) {
        super(errorBundle);
        if (certPath == null || i == -1) {
            throw new IllegalArgumentException();
        } else if (i < -1 || i >= certPath.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.c = certPath;
            this.b = i;
        }
    }
}

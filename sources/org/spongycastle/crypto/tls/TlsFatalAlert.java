package org.spongycastle.crypto.tls;
public class TlsFatalAlert extends TlsException {
    public short alertDescription;

    public TlsFatalAlert(short s) {
        this(s, null);
    }

    public short getAlertDescription() {
        return this.alertDescription;
    }

    public TlsFatalAlert(short s, Throwable th) {
        super(AlertDescription.getText(s), th);
        this.alertDescription = s;
    }
}

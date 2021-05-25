package org.spongycastle.i18n;

import java.util.Locale;
public class LocalizedException extends Exception {
    public Throwable a;
    public ErrorBundle message;

    public LocalizedException(ErrorBundle errorBundle) {
        super(errorBundle.getText(Locale.getDefault()));
        this.message = errorBundle;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }

    public ErrorBundle getErrorMessage() {
        return this.message;
    }

    public LocalizedException(ErrorBundle errorBundle, Throwable th) {
        super(errorBundle.getText(Locale.getDefault()));
        this.message = errorBundle;
        this.a = th;
    }
}

package com.evernote.android.job;

import androidx.annotation.RestrictTo;
public class JobProxyIllegalStateException extends IllegalStateException {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public JobProxyIllegalStateException(String str) {
        super(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public JobProxyIllegalStateException(Throwable th) {
        super(th);
    }
}

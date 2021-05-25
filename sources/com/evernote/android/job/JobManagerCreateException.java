package com.evernote.android.job;

import androidx.annotation.RestrictTo;
public class JobManagerCreateException extends IllegalStateException {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public JobManagerCreateException(String str) {
        super(str);
    }
}

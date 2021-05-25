package com.avito.android.util;

import androidx.annotation.NonNull;
import com.avito.android.remote.error.ErrorContainer;
import com.avito.android.remote.model.Error;
public class NotFoundException extends Exception implements ErrorContainer {
    private static final long serialVersionUID = 1;
    @NonNull
    public final Error a;

    public NotFoundException(@NonNull Error error) {
        this.a = error;
    }

    @Override // com.avito.android.remote.error.ErrorContainer
    @NonNull
    public Error getError() {
        return this.a;
    }
}

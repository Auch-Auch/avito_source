package com.google.android.datatransport.runtime;

import a2.j.b.a.c.c;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.auto.value.AutoValue;
@AutoValue
public abstract class TransportContext {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract TransportContext build();

        public abstract Builder setBackendName(String str);

        public abstract Builder setExtras(@Nullable byte[] bArr);

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public abstract Builder setPriority(Priority priority);
    }

    public static Builder builder() {
        c.b bVar = new c.b();
        bVar.setPriority(Priority.DEFAULT);
        return bVar;
    }

    public abstract String getBackendName();

    @Nullable
    public abstract byte[] getExtras();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract Priority getPriority();

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0023: APUT  (r0v1 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r1v3 java.lang.String) */
    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = getBackendName();
        objArr[1] = getPriority();
        objArr[2] = getExtras() == null ? "" : Base64.encodeToString(getExtras(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public TransportContext withPriority(Priority priority) {
        return builder().setBackendName(getBackendName()).setPriority(priority).setExtras(getExtras()).build();
    }
}

package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.al;
public class ack {
    @NonNull
    private final abi<acl, acj> a;
    @NonNull
    private final abi<al.a, acj> b;

    public ack() {
        this(new ach(), new acm(), new ace());
    }

    @NonNull
    public acj a(acl acl) {
        return this.a.a(acl);
    }

    public ack(@NonNull acj acj, @NonNull acj acj2, @NonNull acj acj3) {
        abi<acl, acj> abi = new abi<>(acj);
        this.a = abi;
        abi.a(acl.NONE, acj);
        abi.a(acl.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, acj2);
        abi.a(acl.AES_VALUE_ENCRYPTION, acj3);
        abi<al.a, acj> abi2 = new abi<>(acj);
        this.b = abi2;
        abi2.a(al.a.EVENT_TYPE_IDENTITY, acj3);
    }

    @NonNull
    public acj a(@NonNull aa aaVar) {
        return a(al.a.a(aaVar.g()));
    }

    @NonNull
    private acj a(@NonNull al.a aVar) {
        return this.b.a(aVar);
    }
}

package com.facebook.imagepipeline.image;
public enum EncodedImageOrigin {
    NOT_SET("not_set"),
    NETWORK("network"),
    DISK("disk"),
    ENCODED_MEM_CACHE("encoded_mem_cache");
    
    public final String a;

    /* access modifiers changed from: public */
    EncodedImageOrigin(String str) {
        this.a = str;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.a;
    }
}

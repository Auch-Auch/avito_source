package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
@GwtCompatible
public enum RemovalCause {
    EXPLICIT {
        @Override // com.google.common.cache.RemovalCause
        public boolean a() {
            return false;
        }
    },
    REPLACED {
        @Override // com.google.common.cache.RemovalCause
        public boolean a() {
            return false;
        }
    },
    COLLECTED {
        @Override // com.google.common.cache.RemovalCause
        public boolean a() {
            return true;
        }
    },
    EXPIRED {
        @Override // com.google.common.cache.RemovalCause
        public boolean a() {
            return true;
        }
    },
    SIZE {
        @Override // com.google.common.cache.RemovalCause
        public boolean a() {
            return true;
        }
    };

    /* access modifiers changed from: public */
    RemovalCause(a aVar) {
    }

    public abstract boolean a();
}

package a2.v.a;
public enum a {
    START {
        @Override // a2.v.a.a
        public int a(int i) {
            return i * -1;
        }

        @Override // a2.v.a.a
        public boolean c(int i) {
            return i < 0;
        }
    },
    END {
        @Override // a2.v.a.a
        public int a(int i) {
            return i;
        }

        @Override // a2.v.a.a
        public boolean c(int i) {
            return i > 0;
        }
    };

    /* access modifiers changed from: public */
    a(C0108a aVar) {
    }

    public static a b(int i) {
        return i > 0 ? END : START;
    }

    public abstract int a(int i);

    public abstract boolean c(int i);
}

package a2.j.d.c;
public enum s3 {
    NEXT_LOWER {
        @Override // a2.j.d.c.s3
        public int a(int i) {
            return i - 1;
        }
    },
    NEXT_HIGHER {
        @Override // a2.j.d.c.s3
        public int a(int i) {
            return i;
        }
    },
    INVERTED_INSERTION_INDEX {
        @Override // a2.j.d.c.s3
        public int a(int i) {
            return ~i;
        }
    };

    /* access modifiers changed from: public */
    s3(r3 r3Var) {
    }

    public abstract int a(int i);
}

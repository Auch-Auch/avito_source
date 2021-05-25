package a2.j.k.i.a;

import com.google.zxing.common.BitMatrix;
public enum c {
    DATA_MASK_000 {
        @Override // a2.j.k.i.a.c
        public boolean a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    },
    DATA_MASK_001 {
        @Override // a2.j.k.i.a.c
        public boolean a(int i, int i2) {
            return (i & 1) == 0;
        }
    },
    DATA_MASK_010 {
        @Override // a2.j.k.i.a.c
        public boolean a(int i, int i2) {
            return i2 % 3 == 0;
        }
    },
    DATA_MASK_011 {
        @Override // a2.j.k.i.a.c
        public boolean a(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    },
    DATA_MASK_100 {
        @Override // a2.j.k.i.a.c
        public boolean a(int i, int i2) {
            return (((i2 / 3) + (i / 2)) & 1) == 0;
        }
    },
    DATA_MASK_101 {
        @Override // a2.j.k.i.a.c
        public boolean a(int i, int i2) {
            return (i * i2) % 6 == 0;
        }
    },
    DATA_MASK_110 {
        @Override // a2.j.k.i.a.c
        public boolean a(int i, int i2) {
            return (i * i2) % 6 < 3;
        }
    },
    DATA_MASK_111 {
        @Override // a2.j.k.i.a.c
        public boolean a(int i, int i2) {
            return ((((i * i2) % 3) + (i + i2)) & 1) == 0;
        }
    };

    /* access modifiers changed from: public */
    c(a aVar) {
    }

    public abstract boolean a(int i2, int i3);

    public final void b(BitMatrix bitMatrix, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    bitMatrix.flip(i4, i3);
                }
            }
        }
    }
}

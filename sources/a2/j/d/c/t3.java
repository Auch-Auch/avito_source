package a2.j.d.c;

import java.util.Comparator;
import java.util.List;
public enum t3 {
    ANY_PRESENT {
        @Override // a2.j.d.c.t3
        public <E> int a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
            return i;
        }
    },
    LAST_PRESENT {
        @Override // a2.j.d.c.t3
        public <E> int a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
            int size = list.size() - 1;
            while (i < size) {
                int i2 = ((i + size) + 1) >>> 1;
                if (comparator.compare((Object) list.get(i2), e) > 0) {
                    size = i2 - 1;
                } else {
                    i = i2;
                }
            }
            return i;
        }
    },
    FIRST_PRESENT {
        @Override // a2.j.d.c.t3
        public <E> int a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
            int i2 = 0;
            while (i2 < i) {
                int i3 = (i2 + i) >>> 1;
                if (comparator.compare((Object) list.get(i3), e) < 0) {
                    i2 = i3 + 1;
                } else {
                    i = i3;
                }
            }
            return i2;
        }
    },
    FIRST_AFTER {
        @Override // a2.j.d.c.t3
        public <E> int a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
            return t3.LAST_PRESENT.a(comparator, e, list, i) + 1;
        }
    },
    LAST_BEFORE {
        @Override // a2.j.d.c.t3
        public <E> int a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
            return t3.FIRST_PRESENT.a(comparator, e, list, i) - 1;
        }
    };

    /* access modifiers changed from: public */
    t3(r3 r3Var) {
    }

    public abstract <E> int a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i);
}

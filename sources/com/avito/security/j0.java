package com.avito.security;

import a2.b.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
public class j0 extends i0 {
    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e1<? super T, ? extends CharSequence> e1Var) {
        j1.b(iterable, "$this$joinTo");
        j1.b(a, "buffer");
        j1.b(charSequence, "separator");
        j1.b(charSequence2, "prefix");
        j1.b(charSequence3, "postfix");
        j1.b(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            g2.a(a, obj, e1Var);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final <T> T a(Iterable<? extends T> iterable) {
        j1.b(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) b((List<? extends Object>) ((List) iterable));
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return (T) it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e1<? super T, ? extends CharSequence> e1Var) {
        j1.b(iterable, "$this$joinToString");
        j1.b(charSequence, "separator");
        j1.b(charSequence2, "prefix");
        j1.b(charSequence3, "postfix");
        j1.b(charSequence4, "truncated");
        String sb = ((StringBuilder) a(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, e1Var)).toString();
        j1.a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e1 e1Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i2 & 32) != 0) {
            e1Var = null;
        }
        return a(iterable, charSequence, charSequence6, charSequence5, i3, charSequence4, e1Var);
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c) {
        j1.b(iterable, "$this$toCollection");
        j1.b(c, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.Collection */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> a(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        j1.b(iterable, "$this$sortedWith");
        j1.b(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return c(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            w.a(array, comparator);
            return w.a(array);
        }
        List<T> d = d(iterable);
        f0.a(d, comparator);
        return d;
    }

    public static final <T> List<T> a(Collection<? extends T> collection) {
        j1.b(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static <T> T b(Iterable<? extends T> iterable) {
        j1.b(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) c((List<? extends Object>) ((List) iterable));
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T t = (T) it.next();
            if (!it.hasNext()) {
                return t;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T b(List<? extends T> list) {
        j1.b(list, "$this$first");
        if (!list.isEmpty()) {
            return (T) list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> List<T> b(Iterable<? extends T> iterable, int i) {
        j1.b(iterable, "$this$take");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return b0.a();
        } else {
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    return c(iterable);
                }
                if (i == 1) {
                    return a0.a(a((Iterable<? extends Object>) iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i);
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return b0.a((List) arrayList);
        }
    }

    public static final <T> T c(List<? extends T> list) {
        j1.b(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return (T) list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static final <T> List<T> c(Iterable<? extends T> iterable) {
        j1.b(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return b0.a(d(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return b0.a();
        }
        if (size != 1) {
            return a(collection);
        }
        return a0.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> d(Iterable<? extends T> iterable) {
        j1.b(iterable, "$this$toMutableList");
        return iterable instanceof Collection ? a((Collection) iterable) : (List) a(iterable, new ArrayList());
    }
}

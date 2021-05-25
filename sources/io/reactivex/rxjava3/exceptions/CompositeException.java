package io.reactivex.rxjava3.exceptions;

import io.reactivex.rxjava3.annotations.NonNull;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    public final List<Throwable> a;
    public final String b;
    public Throwable c;

    public static final class a extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        public a(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static abstract class b {
        public abstract void a(Object obj);
    }

    public static final class c extends b {
        public final PrintStream a;

        public c(PrintStream printStream) {
            this.a = printStream;
        }

        @Override // io.reactivex.rxjava3.exceptions.CompositeException.b
        public void a(Object obj) {
            this.a.println(obj);
        }
    }

    public static final class d extends b {
        public final PrintWriter a;

        public d(PrintWriter printWriter) {
            this.a = printWriter;
        }

        @Override // io.reactivex.rxjava3.exceptions.CompositeException.b
        public void a(Object obj) {
            this.a.println(obj);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CompositeException(@NonNull Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public final void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        StackTraceElement[] stackTrace = th.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    public final void b(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        StackTraceElement[] stackTrace = getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i = 1;
        for (Throwable th : this.a) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            a(sb, th, "\t");
            i++;
        }
        bVar.a(sb.toString());
    }

    @Override // java.lang.Throwable
    @NonNull
    public synchronized Throwable getCause() {
        int i;
        if (this.c == null) {
            String property = System.getProperty("line.separator");
            if (this.a.size() > 1) {
                IdentityHashMap identityHashMap = new IdentityHashMap();
                StringBuilder sb = new StringBuilder();
                sb.append("Multiple exceptions (");
                sb.append(this.a.size());
                sb.append(")");
                sb.append(property);
                for (Throwable th : this.a) {
                    int i2 = 0;
                    while (true) {
                        if (th == null) {
                            break;
                        }
                        for (int i3 = 0; i3 < i2; i3++) {
                            sb.append("  ");
                        }
                        sb.append("|-- ");
                        sb.append(th.getClass().getCanonicalName());
                        sb.append(": ");
                        String message = th.getMessage();
                        if (message == null || !message.contains(property)) {
                            sb.append(message);
                            sb.append(property);
                        } else {
                            sb.append(property);
                            String[] split = message.split(property);
                            for (String str : split) {
                                for (int i4 = 0; i4 < i2 + 2; i4++) {
                                    sb.append("  ");
                                }
                                sb.append(str);
                                sb.append(property);
                            }
                        }
                        int i5 = 0;
                        while (true) {
                            i = i2 + 2;
                            if (i5 >= i) {
                                break;
                            }
                            sb.append("  ");
                            i5++;
                        }
                        StackTraceElement[] stackTrace = th.getStackTrace();
                        if (stackTrace.length > 0) {
                            sb.append("at ");
                            sb.append(stackTrace[0]);
                            sb.append(property);
                        }
                        if (!identityHashMap.containsKey(th)) {
                            identityHashMap.put(th, Boolean.TRUE);
                            th = th.getCause();
                            i2++;
                        } else {
                            Throwable cause = th.getCause();
                            if (cause != null) {
                                for (int i6 = 0; i6 < i; i6++) {
                                    sb.append("  ");
                                }
                                sb.append("|-- ");
                                sb.append("(cause not expanded again) ");
                                sb.append(cause.getClass().getCanonicalName());
                                sb.append(": ");
                                sb.append(cause.getMessage());
                                sb.append(property);
                            }
                        }
                    }
                }
                this.c = new a(sb.toString().trim());
            } else {
                this.c = this.a.get(0);
            }
        }
        return this.c;
    }

    @NonNull
    public List<Throwable> getExceptions() {
        return this.a;
    }

    @Override // java.lang.Throwable
    @NonNull
    public String getMessage() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public int size() {
        return this.a.size();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        b(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        b(new d(printWriter));
    }

    public CompositeException(@NonNull Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            List<Throwable> unmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
            this.a = unmodifiableList;
            this.b = unmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }
}

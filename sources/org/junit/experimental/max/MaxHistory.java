package org.junit.experimental.max;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
public class MaxHistory implements Serializable {
    private static final long serialVersionUID = 1;
    public final Map<String, Long> a = new HashMap();
    public final Map<String, Long> b = new HashMap();
    public final File c;

    public final class b extends RunListener {
        public long a = System.currentTimeMillis();
        public Map<Description, Long> b = new HashMap();

        public b(a aVar) {
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFailure(Failure failure) throws Exception {
            MaxHistory.this.b.put(failure.getDescription().toString(), Long.valueOf(this.a));
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFinished(Description description) throws Exception {
            MaxHistory.this.a.put(description.toString(), Long.valueOf(System.nanoTime() - this.b.get(description).longValue()));
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
        @Override // org.junit.runner.notification.RunListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void testRunFinished(org.junit.runner.Result r5) throws java.lang.Exception {
            /*
                r4 = this;
                org.junit.experimental.max.MaxHistory r5 = org.junit.experimental.max.MaxHistory.this
                java.util.Objects.requireNonNull(r5)
                r0 = 0
                java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x001c }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x001c }
                java.io.File r3 = r5.c     // Catch:{ all -> 0x001c }
                r2.<init>(r3)     // Catch:{ all -> 0x001c }
                r1.<init>(r2)     // Catch:{ all -> 0x001c }
                r1.writeObject(r5)     // Catch:{ all -> 0x0019 }
                r1.close()
                return
            L_0x0019:
                r5 = move-exception
                r0 = r1
                goto L_0x001d
            L_0x001c:
                r5 = move-exception
            L_0x001d:
                if (r0 == 0) goto L_0x0022
                r0.close()
            L_0x0022:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.junit.experimental.max.MaxHistory.b.testRunFinished(org.junit.runner.Result):void");
        }

        @Override // org.junit.runner.notification.RunListener
        public void testStarted(Description description) throws Exception {
            this.b.put(description, Long.valueOf(System.nanoTime()));
        }
    }

    public class c implements Comparator<Description> {
        public c(a aVar) {
        }

        public final Long a(Description description) {
            Long l = MaxHistory.this.b.get(description.toString());
            if (l == null) {
                return 0L;
            }
            return l;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Description description, Description description2) {
            Description description3 = description;
            Description description4 = description2;
            if (!MaxHistory.this.a.containsKey(description3.toString())) {
                return -1;
            }
            if (!MaxHistory.this.a.containsKey(description4.toString())) {
                return 1;
            }
            int compareTo = a(description4).compareTo(a(description3));
            return compareTo != 0 ? compareTo : MaxHistory.this.a.get(description3.toString()).compareTo(MaxHistory.this.a.get(description4.toString()));
        }
    }

    public MaxHistory(File file) {
        this.c = file;
    }

    /* JADX INFO: finally extract failed */
    public static MaxHistory a(File file) throws CouldNotReadCoreException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    MaxHistory maxHistory = (MaxHistory) objectInputStream.readObject();
                    objectInputStream.close();
                    return maxHistory;
                } catch (Throwable th) {
                    objectInputStream.close();
                    throw th;
                }
            } finally {
                fileInputStream.close();
            }
        } catch (Exception e) {
            throw new CouldNotReadCoreException(e);
        }
    }

    public static MaxHistory forFolder(File file) {
        if (file.exists()) {
            try {
                return a(file);
            } catch (CouldNotReadCoreException e) {
                e.printStackTrace();
                file.delete();
            }
        }
        return new MaxHistory(file);
    }

    public RunListener listener() {
        return new b(null);
    }

    public Comparator<Description> testComparator() {
        return new c(null);
    }
}

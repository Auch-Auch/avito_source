package org.junit.runner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
public class Result implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = ObjectStreamClass.lookup(c.class).getFields();
    private static final long serialVersionUID = 1;
    public final AtomicInteger a;
    public final AtomicInteger b;
    public final AtomicInteger c;
    public final CopyOnWriteArrayList<Failure> d;
    public final AtomicLong e;
    public final AtomicLong f;
    public c g;

    @RunListener.ThreadSafe
    public class b extends RunListener {
        public b(a aVar) {
        }

        @Override // org.junit.runner.notification.RunListener
        public void testAssumptionFailure(Failure failure) {
            Result.this.c.getAndIncrement();
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFailure(Failure failure) throws Exception {
            Result.this.d.add(failure);
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFinished(Description description) throws Exception {
            Result.this.a.getAndIncrement();
        }

        @Override // org.junit.runner.notification.RunListener
        public void testIgnored(Description description) throws Exception {
            Result.this.b.getAndIncrement();
        }

        @Override // org.junit.runner.notification.RunListener
        public void testRunFinished(Result result) throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            Result result2 = Result.this;
            result2.e.addAndGet(currentTimeMillis - result2.f.get());
        }

        @Override // org.junit.runner.notification.RunListener
        public void testRunStarted(Description description) throws Exception {
            Result.this.f.set(System.currentTimeMillis());
        }
    }

    public static class c implements Serializable {
        private static final long serialVersionUID = 1;
        public final AtomicInteger a;
        public final AtomicInteger b;
        public final AtomicInteger c;
        public final List<Failure> d;
        public final long e;
        public final long f;

        public c(ObjectInputStream.GetField getField) throws IOException {
            this.a = (AtomicInteger) getField.get("fCount", (Object) null);
            this.b = (AtomicInteger) getField.get("fIgnoreCount", (Object) null);
            this.c = (AtomicInteger) getField.get("assumptionFailureCount", (Object) null);
            this.d = (List) getField.get("fFailures", (Object) null);
            this.e = getField.get("fRunTime", 0L);
            this.f = getField.get("fStartTime", 0L);
        }
    }

    public Result() {
        this.a = new AtomicInteger();
        this.b = new AtomicInteger();
        this.c = new AtomicInteger();
        this.d = new CopyOnWriteArrayList<>();
        this.e = new AtomicLong();
        this.f = new AtomicLong();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.g = new c(objectInputStream.readFields());
    }

    private Object readResolve() {
        return new Result(this.g);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        AtomicInteger atomicInteger = this.a;
        AtomicInteger atomicInteger2 = this.b;
        AtomicInteger atomicInteger3 = this.c;
        List synchronizedList = Collections.synchronizedList(new ArrayList(this.d));
        long longValue = this.e.longValue();
        long longValue2 = this.f.longValue();
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("fCount", atomicInteger);
        putFields.put("fIgnoreCount", atomicInteger2);
        putFields.put("fFailures", synchronizedList);
        putFields.put("fRunTime", longValue);
        putFields.put("fStartTime", longValue2);
        putFields.put("assumptionFailureCount", atomicInteger3);
        objectOutputStream.writeFields();
    }

    public RunListener createListener() {
        return new b(null);
    }

    public int getAssumptionFailureCount() {
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        throw new UnsupportedOperationException("Result was serialized from a version of JUnit that doesn't support this method");
    }

    public int getFailureCount() {
        return this.d.size();
    }

    public List<Failure> getFailures() {
        return this.d;
    }

    public int getIgnoreCount() {
        return this.b.get();
    }

    public int getRunCount() {
        return this.a.get();
    }

    public long getRunTime() {
        return this.e.get();
    }

    public boolean wasSuccessful() {
        return getFailureCount() == 0;
    }

    public Result(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = new CopyOnWriteArrayList<>(cVar.d);
        this.e = new AtomicLong(cVar.e);
        this.f = new AtomicLong(cVar.f);
    }
}

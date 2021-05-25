package io.reactivex.rxjava3.observers;

import a2.b.a.a.a;
import com.avito.android.BuildConfig;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.VolatileSizeArrayList;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> {
    public boolean checkSubscriptionOnce;
    public long completions;
    public final CountDownLatch done = new CountDownLatch(1);
    public final List<Throwable> errors = new VolatileSizeArrayList();
    public Thread lastThread;
    public CharSequence tag;
    public boolean timeout;
    public final List<T> values = new VolatileSizeArrayList();

    @NonNull
    public static String valueAndClass(@Nullable Object obj) {
        if (obj == null) {
            return BuildConfig.ADJUST_DEFAULT_TRACKER;
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ")";
    }

    @NonNull
    public final U assertComplete() {
        long j = this.completions;
        if (j == 0) {
            throw fail("Not completed");
        } else if (j <= 1) {
            return this;
        } else {
            throw fail("Multiple completions: " + j);
        }
    }

    @NonNull
    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    @NonNull
    public final U assertError(@NonNull Throwable th) {
        return assertError(Functions.equalsWith(th));
    }

    @SafeVarargs
    @NonNull
    public final U assertFailure(@NonNull Class<? extends Throwable> cls, @NonNull T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    @NonNull
    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return this;
        }
        StringBuilder L = a.L("Error(s) present: ");
        L.append(this.errors);
        throw fail(L.toString());
    }

    @NonNull
    public final U assertNoValues() {
        return assertValueCount(0);
    }

    @NonNull
    public final U assertNotComplete() {
        long j = this.completions;
        int i = (j > 1 ? 1 : (j == 1 ? 0 : -1));
        if (i == 0) {
            throw fail("Completed!");
        } else if (i <= 0) {
            return this;
        } else {
            throw fail("Multiple completions: " + j);
        }
    }

    @SafeVarargs
    @NonNull
    public final U assertResult(@NonNull T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    @NonNull
    public abstract U assertSubscribed();

    @NonNull
    public final U assertValue(@NonNull T t) {
        if (this.values.size() == 1) {
            T t2 = this.values.get(0);
            if (Objects.equals(t, t2)) {
                return this;
            }
            StringBuilder L = a.L("expected: ");
            L.append(valueAndClass(t));
            L.append(" but was: ");
            L.append(valueAndClass(t2));
            throw fail(L.toString());
        }
        StringBuilder L2 = a.L("expected: ");
        L2.append(valueAndClass(t));
        L2.append(" but was: ");
        L2.append(this.values);
        throw fail(L2.toString());
    }

    @NonNull
    public final U assertValueAt(int i, @NonNull T t) {
        int size = this.values.size();
        if (size == 0) {
            throw fail("No values");
        } else if (i < size) {
            T t2 = this.values.get(i);
            if (Objects.equals(t, t2)) {
                return this;
            }
            StringBuilder L = a.L("expected: ");
            L.append(valueAndClass(t));
            L.append(" but was: ");
            L.append(valueAndClass(t2));
            throw fail(L.toString());
        } else {
            throw fail("Invalid index: " + i);
        }
    }

    @NonNull
    public final U assertValueCount(int i) {
        int size = this.values.size();
        if (size == i) {
            return this;
        }
        throw fail("Value counts differ; expected: " + i + " but was: " + size);
    }

    @NonNull
    public final U assertValueSequence(@NonNull Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> it = this.values.iterator();
        Iterator<? extends T> it2 = iterable.iterator();
        int i = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (!hasNext2 || !hasNext) {
                break;
            }
            Object next = it2.next();
            T next2 = it.next();
            if (Objects.equals(next, next2)) {
                i++;
            } else {
                StringBuilder M = a.M("Values at position ", i, " differ; expected: ");
                M.append(valueAndClass(next));
                M.append(" but was: ");
                M.append(valueAndClass(next2));
                throw fail(M.toString());
            }
        }
        if (hasNext2) {
            throw fail("More values received than expected (" + i + ")");
        } else if (!hasNext) {
            return this;
        } else {
            throw fail("Fewer values received than expected (" + i + ")");
        }
    }

    @SafeVarargs
    @NonNull
    public final U assertValues(@NonNull T... tArr) {
        int size = this.values.size();
        if (size == tArr.length) {
            for (int i = 0; i < size; i++) {
                T t = this.values.get(i);
                T t2 = tArr[i];
                if (!Objects.equals(t2, t)) {
                    StringBuilder M = a.M("Values at position ", i, " differ; expected: ");
                    M.append(valueAndClass(t2));
                    M.append(" but was: ");
                    M.append(valueAndClass(t));
                    throw fail(M.toString());
                }
            }
            return this;
        }
        StringBuilder L = a.L("Value count differs; expected: ");
        L.append(tArr.length);
        L.append(" ");
        L.append(Arrays.toString(tArr));
        L.append(" but was: ");
        L.append(size);
        L.append(" ");
        L.append(this.values);
        throw fail(L.toString());
    }

    @SafeVarargs
    @NonNull
    public final U assertValuesOnly(@NonNull T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    @NonNull
    public final U await() throws InterruptedException {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    @NonNull
    public final U awaitCount(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - currentTimeMillis < 5000) {
                if (this.done.getCount() == 0 || this.values.size() >= i) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                this.timeout = true;
                break;
            }
        }
        return this;
    }

    @NonNull
    public final U awaitDone(long j, @NonNull TimeUnit timeUnit) {
        try {
            if (!this.done.await(j, timeUnit)) {
                this.timeout = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public abstract void dispose();

    @NonNull
    public final AssertionError fail(@NonNull String str) {
        StringBuilder sb = new StringBuilder(str.length() + 64);
        a.m1(sb, str, " (", "latch = ");
        sb.append(this.done.getCount());
        sb.append(", ");
        sb.append("values = ");
        sb.append(this.values.size());
        sb.append(", ");
        sb.append("errors = ");
        sb.append(this.errors.size());
        sb.append(", ");
        sb.append("completions = ");
        sb.append(this.completions);
        if (this.timeout) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.tag;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.errors));
            }
        }
        return assertionError;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public abstract boolean isDisposed();

    @NonNull
    public final List<T> values() {
        return this.values;
    }

    @NonNull
    public final U withTag(@Nullable CharSequence charSequence) {
        this.tag = charSequence;
        return this;
    }

    @NonNull
    public final U assertError(@NonNull Class<? extends Throwable> cls) {
        return assertError(Functions.isInstanceOf(cls));
    }

    @NonNull
    public final U assertError(@NonNull Predicate<Throwable> predicate) {
        int size = this.errors.size();
        if (size != 0) {
            boolean z = false;
            Iterator<Throwable> it = this.errors.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                try {
                    if (predicate.test(it.next())) {
                        z = true;
                        break;
                    }
                } catch (Throwable th) {
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
            if (!z) {
                throw fail("Error not present");
            } else if (size == 1) {
                return this;
            } else {
                throw fail("Error present but other errors as well");
            }
        } else {
            throw fail("No errors");
        }
    }

    public final boolean await(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        boolean z = this.done.getCount() == 0 || this.done.await(j, timeUnit);
        this.timeout = !z;
        return z;
    }

    @NonNull
    public final U assertValue(@NonNull Predicate<T> predicate) {
        assertValueAt(0, (Predicate) predicate);
        if (this.values.size() <= 1) {
            return this;
        }
        throw fail("Value present but other values as well");
    }

    @NonNull
    public final U assertValueAt(int i, @NonNull Predicate<T> predicate) {
        if (this.values.size() == 0) {
            throw fail("No values");
        } else if (i < this.values.size()) {
            try {
                if (predicate.test(this.values.get(i))) {
                    return this;
                }
                throw fail("Value not present");
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        } else {
            throw fail("Invalid index: " + i);
        }
    }
}

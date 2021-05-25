package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
public final class LinesSequence implements Sequence<String> {
    public final BufferedReader a;

    public LinesSequence(@NotNull BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "reader");
        this.a = bufferedReader;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<String> iterator() {
        return new Object(this) { // from class: kotlin.io.LinesSequence$iterator$1
            public String a;
            public boolean b;
            public final /* synthetic */ LinesSequence c;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.c = r1;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.a == null && !this.b) {
                    String readLine = this.c.a.readLine();
                    this.a = readLine;
                    if (readLine == null) {
                        this.b = true;
                    }
                }
                if (this.a != null) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            @Override // java.util.Iterator
            @NotNull
            public String next() {
                if (hasNext()) {
                    String str = this.a;
                    this.a = null;
                    Intrinsics.checkNotNull(str);
                    return str;
                }
                throw new NoSuchElementException();
            }
        };
    }
}

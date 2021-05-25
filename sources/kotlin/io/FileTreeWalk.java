package kotlin.io;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0015\"\u001aB\u0001\b\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020!\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u00128\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b%\u0010&B\u001b\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020!¢\u0006\u0004\b%\u0010'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\f\u0010\nJ'\u0010\u000f\u001a\u00020\u00002\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bRH\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function1;", "", "function", "onEnter", "(Lkotlin/jvm/functions/Function1;)Lkotlin/io/FileTreeWalk;", "", "onLeave", "Lkotlin/Function2;", "Ljava/io/IOException;", "onFail", "(Lkotlin/jvm/functions/Function2;)Lkotlin/io/FileTreeWalk;", "", "depth", "maxDepth", "(I)Lkotlin/io/FileTreeWalk;", AuthSource.SEND_ABUSE, "Ljava/io/File;", Tracker.Events.CREATIVE_START, "f", "I", "c", "Lkotlin/jvm/functions/Function1;", "d", "Lkotlin/ParameterName;", "name", "e", "Lkotlin/jvm/functions/Function2;", "Lkotlin/io/FileWalkDirection;", AuthSource.BOOKING_ORDER, "Lkotlin/io/FileWalkDirection;", "direction", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class FileTreeWalk implements Sequence<File> {
    public final File a;
    public final FileWalkDirection b;
    public final Function1<File, Boolean> c;
    public final Function1<File, Unit> d;
    public final Function2<File, IOException, Unit> e;
    public final int f;

    public static abstract class a extends c {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull File file) {
            super(file);
            Intrinsics.checkNotNullParameter(file, "rootDir");
        }
    }

    public final class b extends AbstractIterator<File> {
        public final ArrayDeque<c> c;

        public final class a extends a {
            public boolean b;
            public File[] c;
            public int d;
            public boolean e;
            public final /* synthetic */ b f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(@NotNull b bVar, File file) {
                super(file);
                Intrinsics.checkNotNullParameter(file, "rootDir");
                this.f = bVar;
            }

            @Override // kotlin.io.FileTreeWalk.c
            @Nullable
            public File a() {
                if (!this.e && this.c == null) {
                    Function1 function1 = FileTreeWalk.this.c;
                    if (function1 != null && !((Boolean) function1.invoke(this.a)).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = this.a.listFiles();
                    this.c = listFiles;
                    if (listFiles == null) {
                        Function2 function2 = FileTreeWalk.this.e;
                        if (function2 != null) {
                            Unit unit = (Unit) function2.invoke(this.a, new AccessDeniedException(this.a, null, "Cannot list files in a directory", 2, null));
                        }
                        this.e = true;
                    }
                }
                File[] fileArr = this.c;
                if (fileArr != null) {
                    int i = this.d;
                    Intrinsics.checkNotNull(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.c;
                        Intrinsics.checkNotNull(fileArr2);
                        int i2 = this.d;
                        this.d = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.b) {
                    this.b = true;
                    return this.a;
                }
                Function1 function12 = FileTreeWalk.this.d;
                if (function12 != null) {
                    Unit unit2 = (Unit) function12.invoke(this.a);
                }
                return null;
            }
        }

        /* renamed from: kotlin.io.FileTreeWalk$b$b  reason: collision with other inner class name */
        public final class C0505b extends c {
            public boolean b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0505b(@NotNull b bVar, File file) {
                super(file);
                Intrinsics.checkNotNullParameter(file, "rootFile");
            }

            @Override // kotlin.io.FileTreeWalk.c
            @Nullable
            public File a() {
                if (this.b) {
                    return null;
                }
                this.b = true;
                return this.a;
            }
        }

        public final class c extends a {
            public boolean b;
            public File[] c;
            public int d;
            public final /* synthetic */ b e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(@NotNull b bVar, File file) {
                super(file);
                Intrinsics.checkNotNullParameter(file, "rootDir");
                this.e = bVar;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:27:0x0079, code lost:
                if (r0.length == 0) goto L_0x007b;
             */
            @Override // kotlin.io.FileTreeWalk.c
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.io.File a() {
                /*
                    r10 = this;
                    boolean r0 = r10.b
                    r1 = 0
                    if (r0 != 0) goto L_0x0024
                    kotlin.io.FileTreeWalk$b r0 = r10.e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.access$getOnEnter$p(r0)
                    if (r0 == 0) goto L_0x001e
                    java.io.File r2 = r10.a
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L_0x001e
                    return r1
                L_0x001e:
                    r0 = 1
                    r10.b = r0
                    java.io.File r0 = r10.a
                    return r0
                L_0x0024:
                    java.io.File[] r0 = r10.c
                    if (r0 == 0) goto L_0x0044
                    int r2 = r10.d
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L_0x0031
                    goto L_0x0044
                L_0x0031:
                    kotlin.io.FileTreeWalk$b r0 = r10.e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.access$getOnLeave$p(r0)
                    if (r0 == 0) goto L_0x0043
                    java.io.File r2 = r10.a
                    java.lang.Object r0 = r0.invoke(r2)
                    kotlin.Unit r0 = (kotlin.Unit) r0
                L_0x0043:
                    return r1
                L_0x0044:
                    java.io.File[] r0 = r10.c
                    if (r0 != 0) goto L_0x008e
                    java.io.File r0 = r10.a
                    java.io.File[] r0 = r0.listFiles()
                    r10.c = r0
                    if (r0 != 0) goto L_0x0071
                    kotlin.io.FileTreeWalk$b r0 = r10.e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function2 r0 = kotlin.io.FileTreeWalk.access$getOnFail$p(r0)
                    if (r0 == 0) goto L_0x0071
                    java.io.File r2 = r10.a
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.a
                    r5 = 0
                    r7 = 2
                    r8 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    java.lang.Object r0 = r0.invoke(r2, r9)
                    kotlin.Unit r0 = (kotlin.Unit) r0
                L_0x0071:
                    java.io.File[] r0 = r10.c
                    if (r0 == 0) goto L_0x007b
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L_0x008e
                L_0x007b:
                    kotlin.io.FileTreeWalk$b r0 = r10.e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.access$getOnLeave$p(r0)
                    if (r0 == 0) goto L_0x008d
                    java.io.File r2 = r10.a
                    java.lang.Object r0 = r0.invoke(r2)
                    kotlin.Unit r0 = (kotlin.Unit) r0
                L_0x008d:
                    return r1
                L_0x008e:
                    java.io.File[] r0 = r10.c
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r1 = r10.d
                    int r2 = r1 + 1
                    r10.d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.b.c.a():java.io.File");
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.c = arrayDeque;
            if (FileTreeWalk.this.a.isDirectory()) {
                arrayDeque.push(a(FileTreeWalk.this.a));
            } else if (FileTreeWalk.this.a.isFile()) {
                arrayDeque.push(new C0505b(this, FileTreeWalk.this.a));
            } else {
                done();
            }
        }

        public final a a(File file) {
            int ordinal = FileTreeWalk.this.b.ordinal();
            if (ordinal == 0) {
                return new c(this, file);
            }
            if (ordinal == 1) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // kotlin.collections.AbstractIterator
        public void computeNext() {
            File file;
            while (true) {
                c peek = this.c.peek();
                if (peek == null) {
                    file = null;
                    break;
                }
                file = peek.a();
                if (file != null) {
                    if (Intrinsics.areEqual(file, peek.a) || !file.isDirectory() || this.c.size() >= FileTreeWalk.this.f) {
                        break;
                    }
                    this.c.push(a(file));
                } else {
                    this.c.pop();
                }
            }
            if (file != null) {
                setNext(file);
            } else {
                done();
            }
        }
    }

    public static abstract class c {
        @NotNull
        public final File a;

        public c(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "root");
            this.a = file;
        }

        @Nullable
        public abstract File a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.io.File, java.lang.Boolean> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.io.File, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1<? super File, Boolean> function1, Function1<? super File, Unit> function12, Function2<? super File, ? super IOException, Unit> function2, int i) {
        this.a = file;
        this.b = fileWalkDirection;
        this.c = function1;
        this.d = function12;
        this.e = function2;
        this.f = i;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<File> iterator() {
        return new b();
    }

    @NotNull
    public final FileTreeWalk maxDepth(int i) {
        if (i > 0) {
            return new FileTreeWalk(this.a, this.b, this.c, this.d, this.e, i);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i + FormatterType.defaultDecimalSeparator);
    }

    @NotNull
    public final FileTreeWalk onEnter(@NotNull Function1<? super File, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        return new FileTreeWalk(this.a, this.b, function1, this.d, this.e, this.f);
    }

    @NotNull
    public final FileTreeWalk onFail(@NotNull Function2<? super File, ? super IOException, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "function");
        return new FileTreeWalk(this.a, this.b, this.c, this.d, function2, this.f);
    }

    @NotNull
    public final FileTreeWalk onLeave(@NotNull Function1<? super File, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        return new FileTreeWalk(this.a, this.b, this.c, function1, this.e, this.f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FileTreeWalk(@NotNull File file, @NotNull FileWalkDirection fileWalkDirection) {
        this(file, fileWalkDirection, null, null, null, Integer.MAX_VALUE);
        Intrinsics.checkNotNullParameter(file, Tracker.Events.CREATIVE_START);
        Intrinsics.checkNotNullParameter(fileWalkDirection, "direction");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, int i, j jVar) {
        this(file, (i & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }
}

package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\b\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\"<\u0010\u000f\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000bj\u0002`\f0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014*(\b\u0002\u0010\u0016\"\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000b2\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000b¨\u0006\u0017"}, d2 = {"", ExifInterface.LONGITUDE_EAST, OkListener.KEY_EXCEPTION, "tryCopyException", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Ljava/lang/Class;", "", "defaultValue", AuthSource.SEND_ABUSE, "(Ljava/lang/Class;I)I", "Ljava/util/WeakHashMap;", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "c", "Ljava/util/WeakHashMap;", "exceptionCtors", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", AuthSource.BOOKING_ORDER, "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "cacheLock", "I", "throwableFields", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class ExceptionsConstuctorKt {
    public static final int a = a(Throwable.class, -1);
    public static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    public static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> c = new WeakHashMap<>();

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1 {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(1);
            this.a = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            int i = this.a;
            if (i == 0) {
                Throwable th = (Throwable) obj;
                return null;
            } else if (i == 1) {
                Throwable th2 = (Throwable) obj;
                return null;
            } else {
                throw null;
            }
        }
    }

    public static final int a(Class<?> cls, int i) {
        Integer num;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            int i2 = 0;
            while (true) {
                Field[] declaredFields = cls.getDeclaredFields();
                int length = declaredFields.length;
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    if (!Modifier.isStatic(declaredFields[i4].getModifiers())) {
                        i3++;
                    }
                }
                i2 += i3;
                cls = cls.getSuperclass();
                if (cls == null) {
                    break;
                }
            }
            num = Result.m242constructorimpl(Integer.valueOf(i2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m242constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m247isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:403)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @org.jetbrains.annotations.Nullable
    public static final <E extends java.lang.Throwable> E tryCopyException(@org.jetbrains.annotations.NotNull E r9) {
        /*
        // Method dump skipped, instructions count: 354
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ExceptionsConstuctorKt.tryCopyException(java.lang.Throwable):java.lang.Throwable");
    }
}

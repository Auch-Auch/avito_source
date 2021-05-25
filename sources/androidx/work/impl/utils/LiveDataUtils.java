package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LiveDataUtils {

    public class a implements Observer<In> {
        public Out a = null;
        public final /* synthetic */ TaskExecutor b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Function d;
        public final /* synthetic */ MediatorLiveData e;

        /* renamed from: androidx.work.impl.utils.LiveDataUtils$a$a  reason: collision with other inner class name */
        public class RunnableC0125a implements Runnable {
            public final /* synthetic */ Object a;

            public RunnableC0125a(Object obj) {
                this.a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.c) {
                    Out out = (Out) a.this.d.apply(this.a);
                    a aVar = a.this;
                    Out out2 = aVar.a;
                    if (out2 == null && out != null) {
                        aVar.a = out;
                        aVar.e.postValue(out);
                    } else if (out2 != null && !out2.equals(out)) {
                        a aVar2 = a.this;
                        aVar2.a = out;
                        aVar2.e.postValue(out);
                    }
                }
            }
        }

        public a(TaskExecutor taskExecutor, Object obj, Function function, MediatorLiveData mediatorLiveData) {
            this.b = taskExecutor;
            this.c = obj;
            this.d = function;
            this.e = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable In in) {
            this.b.executeOnBackgroundThread(new RunnableC0125a(in));
        }
    }

    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(@NonNull LiveData<In> liveData, @NonNull Function<In, Out> function, @NonNull TaskExecutor taskExecutor) {
        Object obj = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new a(taskExecutor, obj, function, mediatorLiveData));
        return mediatorLiveData;
    }
}

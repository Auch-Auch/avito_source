package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MultiInstanceInvalidationService extends Service {
    public int a = 0;
    public final HashMap<Integer, String> b = new HashMap<>();
    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> c = new a();
    public final IMultiInstanceInvalidationService.Stub d = new b();

    public class a extends RemoteCallbackList<IMultiInstanceInvalidationCallback> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.IInterface, java.lang.Object] */
        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
            MultiInstanceInvalidationService.this.b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    public class b extends IMultiInstanceInvalidationService.Stub {
        public b() {
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.c) {
                String str = MultiInstanceInvalidationService.this.b.get(Integer.valueOf(i));
                if (str != null) {
                    int beginBroadcast = MultiInstanceInvalidationService.this.c.beginBroadcast();
                    for (int i2 = 0; i2 < beginBroadcast; i2++) {
                        try {
                            int intValue = ((Integer) MultiInstanceInvalidationService.this.c.getBroadcastCookie(i2)).intValue();
                            String str2 = MultiInstanceInvalidationService.this.b.get(Integer.valueOf(intValue));
                            if (i != intValue && str.equals(str2)) {
                                try {
                                    MultiInstanceInvalidationService.this.c.getBroadcastItem(i2).onInvalidation(strArr);
                                } catch (RemoteException unused) {
                                }
                            }
                        } catch (Throwable th) {
                            MultiInstanceInvalidationService.this.c.finishBroadcast();
                            throw th;
                        }
                    }
                    MultiInstanceInvalidationService.this.c.finishBroadcast();
                }
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.a + 1;
                multiInstanceInvalidationService.a = i;
                if (multiInstanceInvalidationService.c.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.b.put(Integer.valueOf(i), str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.a--;
                return 0;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) {
            synchronized (MultiInstanceInvalidationService.this.c) {
                MultiInstanceInvalidationService.this.c.unregister(iMultiInstanceInvalidationCallback);
                MultiInstanceInvalidationService.this.b.remove(Integer.valueOf(i));
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.d;
    }
}

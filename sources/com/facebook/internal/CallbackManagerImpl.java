package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map;
public final class CallbackManagerImpl implements CallbackManager {
    public static Map<Integer, Callback> b = new HashMap();
    public Map<Integer, Callback> a = new HashMap();

    public interface Callback {
        boolean onActivityResult(int i, Intent intent);
    }

    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8),
        GamingFriendFinder(9),
        GamingGroupIntegration(10),
        Referral(11);
        
        public final int a;

        /* access modifiers changed from: public */
        RequestCodeOffset(int i) {
            this.a = i;
        }

        public int toRequestCode() {
            return FacebookSdk.getCallbackRequestCodeOffset() + this.a;
        }
    }

    public static synchronized void registerStaticCallback(int i, Callback callback) {
        synchronized (CallbackManagerImpl.class) {
            Validate.notNull(callback, "callback");
            if (!b.containsKey(Integer.valueOf(i))) {
                b.put(Integer.valueOf(i), callback);
            }
        }
    }

    @Override // com.facebook.CallbackManager
    public boolean onActivityResult(int i, int i2, Intent intent) {
        Callback callback;
        Callback callback2 = this.a.get(Integer.valueOf(i));
        if (callback2 != null) {
            return callback2.onActivityResult(i2, intent);
        }
        Integer valueOf = Integer.valueOf(i);
        synchronized (CallbackManagerImpl.class) {
            callback = b.get(valueOf);
        }
        if (callback != null) {
            return callback.onActivityResult(i2, intent);
        }
        return false;
    }

    public void registerCallback(int i, Callback callback) {
        Validate.notNull(callback, "callback");
        this.a.put(Integer.valueOf(i), callback);
    }

    public void unregisterCallback(int i) {
        this.a.remove(Integer.valueOf(i));
    }
}

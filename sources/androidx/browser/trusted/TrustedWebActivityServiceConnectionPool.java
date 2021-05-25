package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.trusted.TrustedWebActivityServiceConnection;
import androidx.browser.trusted.TrustedWebActivityServiceConnectionPool;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import l6.c.c.d;
public final class TrustedWebActivityServiceConnectionPool {
    public final Context a;
    public final Map<Uri, d> b = new HashMap();

    public static class a extends AsyncTask<Void, Void, Exception> {
        public final Context a;
        public final Intent b;
        public final d c;

        public a(Context context, Intent intent, d dVar) {
            this.a = context.getApplicationContext();
            this.b = intent;
            this.c = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        @Nullable
        public Exception doInBackground(Void[] voidArr) {
            try {
                if (this.a.bindService(this.b, this.c, 1)) {
                    return null;
                }
                this.a.unbindService(this.c);
                return new IllegalStateException("Could not bind to the service");
            } catch (SecurityException e) {
                return e;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(Exception exc) {
            Exception exc2 = exc;
            if (exc2 != null) {
                d dVar = this.c;
                for (CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection> completer : dVar.e) {
                    completer.setException(exc2);
                }
                dVar.e.clear();
                dVar.a.run();
                dVar.c = 3;
                dVar.f = exc2;
            }
        }
    }

    public TrustedWebActivityServiceConnectionPool(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    @NonNull
    public static TrustedWebActivityServiceConnectionPool create(@NonNull Context context) {
        return new TrustedWebActivityServiceConnectionPool(context);
    }

    @Nullable
    public final Intent a(Context context, Uri uri, Set<Token> set, boolean z) {
        if (set == null || set.size() == 0) {
            return null;
        }
        Intent intent = new Intent();
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        String str = null;
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            String str2 = resolveInfo.activityInfo.packageName;
            Iterator<Token> it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().matches(str2, context.getPackageManager())) {
                        str = str2;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (str == null) {
            if (z) {
                String str3 = "No TWA candidates for " + uri + " have been registered.";
            }
            return null;
        }
        Intent intent2 = new Intent();
        intent2.setPackage(str);
        intent2.setAction(TrustedWebActivityService.ACTION_TRUSTED_WEB_ACTIVITY_SERVICE);
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent2, 131072);
        if (resolveService == null) {
            return null;
        }
        if (z) {
            StringBuilder L = a2.b.a.a.a.L("Found ");
            L.append(resolveService.serviceInfo.name);
            L.append(" to handle request for ");
            L.append(uri);
            L.toString();
        }
        Intent intent3 = new Intent();
        intent3.setComponent(new ComponentName(str, resolveService.serviceInfo.name));
        return intent3;
    }

    @NonNull
    @MainThread
    public ListenableFuture<TrustedWebActivityServiceConnection> connect(@NonNull Uri uri, @NonNull Set<Token> set, @NonNull Executor executor) {
        d dVar = this.b.get(uri);
        if (dVar != null) {
            return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: l6.c.c.a
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    d dVar2 = d.this;
                    int i = dVar2.c;
                    if (i == 0) {
                        dVar2.e.add(completer);
                    } else if (i == 1) {
                        TrustedWebActivityServiceConnection trustedWebActivityServiceConnection = dVar2.d;
                        if (trustedWebActivityServiceConnection != null) {
                            completer.set(trustedWebActivityServiceConnection);
                        } else {
                            throw new IllegalStateException("ConnectionHolder state is incorrect.");
                        }
                    } else if (i == 2) {
                        throw new IllegalStateException("Service has been disconnected.");
                    } else if (i != 3) {
                        throw new IllegalStateException("Connection state is invalid");
                    } else {
                        throw dVar2.f;
                    }
                    StringBuilder L = a2.b.a.a.a.L("ConnectionHolder, state = ");
                    L.append(dVar2.c);
                    return L.toString();
                }
            });
        }
        Intent a3 = a(this.a, uri, set, true);
        if (a3 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No service exists for scope");
            ResolvableFuture create = ResolvableFuture.create();
            create.setException(illegalArgumentException);
            return create;
        }
        d dVar2 = new d(new Runnable(uri) { // from class: l6.c.c.c
            public final /* synthetic */ Uri b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TrustedWebActivityServiceConnectionPool trustedWebActivityServiceConnectionPool = TrustedWebActivityServiceConnectionPool.this;
                trustedWebActivityServiceConnectionPool.b.remove(this.b);
            }
        });
        this.b.put(uri, dVar2);
        new a(this.a, a3, dVar2).executeOnExecutor(executor, new Void[0]);
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: l6.c.c.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                d dVar2 = d.this;
                int i = dVar2.c;
                if (i == 0) {
                    dVar2.e.add(completer);
                } else if (i == 1) {
                    TrustedWebActivityServiceConnection trustedWebActivityServiceConnection = dVar2.d;
                    if (trustedWebActivityServiceConnection != null) {
                        completer.set(trustedWebActivityServiceConnection);
                    } else {
                        throw new IllegalStateException("ConnectionHolder state is incorrect.");
                    }
                } else if (i == 2) {
                    throw new IllegalStateException("Service has been disconnected.");
                } else if (i != 3) {
                    throw new IllegalStateException("Connection state is invalid");
                } else {
                    throw dVar2.f;
                }
                StringBuilder L = a2.b.a.a.a.L("ConnectionHolder, state = ");
                L.append(dVar2.c);
                return L.toString();
            }
        });
    }

    @MainThread
    public boolean serviceExistsForScope(@NonNull Uri uri, @NonNull Set<Token> set) {
        if (this.b.get(uri) == null && a(this.a, uri, set, false) == null) {
            return false;
        }
        return true;
    }
}

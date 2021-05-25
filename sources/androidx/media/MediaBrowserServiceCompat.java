package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompatApi26;
import androidx.media.MediaSessionManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import l6.q.l;
import l6.q.m;
import l6.q.n;
import l6.q.o;
import l6.q.p;
import l6.q.q;
import l6.q.r;
import l6.q.s;
import l6.q.t;
public abstract class MediaBrowserServiceCompat extends Service {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_MEDIA_ITEM = "media_item";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SEARCH_RESULTS = "search_results";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_ERROR = -1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_OK = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    public static final boolean f = Log.isLoggable("MBServiceCompat", 3);
    public c a;
    public final ArrayMap<IBinder, b> b = new ArrayMap<>();
    public b c;
    public final k d = new k();
    public MediaSessionCompat.Token e;

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        public final String a;
        public final Bundle b;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            if (str != null) {
                this.a = str;
                this.b = bundle;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
        }

        public Bundle getExtras() {
            return this.b;
        }

        public String getRootId() {
            return this.a;
        }
    }

    public static class Result<T> {
        public final Object a;
        public boolean b;
        public boolean c;
        public boolean d;
        public int e;

        public Result(Object obj) {
            this.a = obj;
        }

        public boolean a() {
            return this.b || this.c || this.d;
        }

        public void b(Bundle bundle) {
            StringBuilder L = a2.b.a.a.a.L("It is not supported to send an error for ");
            L.append(this.a);
            throw new UnsupportedOperationException(L.toString());
        }

        public void c(Bundle bundle) {
            StringBuilder L = a2.b.a.a.a.L("It is not supported to send an interim update for ");
            L.append(this.a);
            throw new UnsupportedOperationException(L.toString());
        }

        public void d(T t) {
        }

        public void detach() {
            if (this.b) {
                StringBuilder L = a2.b.a.a.a.L("detach() called when detach() had already been called for: ");
                L.append(this.a);
                throw new IllegalStateException(L.toString());
            } else if (this.c) {
                StringBuilder L2 = a2.b.a.a.a.L("detach() called when sendResult() had already been called for: ");
                L2.append(this.a);
                throw new IllegalStateException(L2.toString());
            } else if (!this.d) {
                this.b = true;
            } else {
                StringBuilder L3 = a2.b.a.a.a.L("detach() called when sendError() had already been called for: ");
                L3.append(this.a);
                throw new IllegalStateException(L3.toString());
            }
        }

        public void sendError(Bundle bundle) {
            if (this.c || this.d) {
                StringBuilder L = a2.b.a.a.a.L("sendError() called when either sendResult() or sendError() had already been called for: ");
                L.append(this.a);
                throw new IllegalStateException(L.toString());
            }
            this.d = true;
            b(bundle);
        }

        public void sendProgressUpdate(Bundle bundle) {
            if (this.c || this.d) {
                StringBuilder L = a2.b.a.a.a.L("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
                L.append(this.a);
                throw new IllegalStateException(L.toString());
            }
            if (bundle != null && bundle.containsKey(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS)) {
                float f = bundle.getFloat(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
                if (f < -1.0E-5f || f > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
            c(bundle);
        }

        public void sendResult(T t) {
            if (this.c || this.d) {
                StringBuilder L = a2.b.a.a.a.L("sendResult() called when either sendResult() or sendError() had already been called for: ");
                L.append(this.a);
                throw new IllegalStateException(L.toString());
            }
            this.c = true;
            d(t);
        }
    }

    public class a extends Result<List<MediaBrowserCompat.MediaItem>> {
        public final /* synthetic */ b f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Bundle h;
        public final /* synthetic */ Bundle i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object obj, b bVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f = bVar;
            this.g = str;
            this.h = bundle;
            this.i = bundle2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.media.MediaBrowserServiceCompat.Result
        public void d(List<MediaBrowserCompat.MediaItem> list) {
            List<MediaBrowserCompat.MediaItem> list2 = list;
            b bVar = MediaBrowserServiceCompat.this.b.get(((j) this.f.d).a());
            b bVar2 = this.f;
            if (bVar == bVar2) {
                if ((this.e & 1) != 0) {
                    MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                    Bundle bundle = this.h;
                    Objects.requireNonNull(mediaBrowserServiceCompat);
                    if (list2 == null) {
                        list2 = null;
                    } else {
                        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                        int i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                        if (!(i2 == -1 && i3 == -1)) {
                            int i4 = i3 * i2;
                            int i5 = i4 + i3;
                            if (i2 < 0 || i3 < 1 || i4 >= list2.size()) {
                                list2 = Collections.emptyList();
                            } else {
                                if (i5 > list2.size()) {
                                    i5 = list2.size();
                                }
                                list2 = list2.subList(i4, i5);
                            }
                        }
                    }
                }
                try {
                    ((j) this.f.d).c(this.g, list2, this.h, this.i);
                } catch (RemoteException unused) {
                    String str = this.f.a;
                }
            } else if (MediaBrowserServiceCompat.f) {
                String str2 = bVar2.a;
            }
        }
    }

    public class b implements IBinder.DeathRecipient {
        public final String a;
        public final MediaSessionManager.RemoteUserInfo b;
        public final Bundle c;
        public final i d;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> e = new HashMap<>();
        public BrowserRoot f;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                MediaBrowserServiceCompat.this.b.remove(((j) bVar.d).a());
            }
        }

        public b(String str, int i, int i2, Bundle bundle, i iVar) {
            this.a = str;
            this.b = new MediaSessionManager.RemoteUserInfo(str, i, i2);
            this.c = bundle;
            this.d = iVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.d.post(new a());
        }
    }

    public interface c {
        void a();

        MediaSessionManager.RemoteUserInfo b();

        Bundle c();
    }

    @RequiresApi(21)
    public class d implements c, MediaBrowserServiceCompatApi21$ServiceCompatProxy {
        public final List<Bundle> a = new ArrayList();
        public Object b;
        public Messenger c;

        public class a extends Result<List<MediaBrowserCompat.MediaItem>> {
            public final /* synthetic */ s f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(d dVar, Object obj, s sVar) {
                super(obj);
                this.f = sVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void d(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                List<MediaBrowserCompat.MediaItem> list2 = list;
                if (list2 != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list2) {
                        Parcel obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f.a(arrayList);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                this.f.a.detach();
            }
        }

        public d() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.c
        public void a() {
            r rVar = new r(MediaBrowserServiceCompat.this, this);
            this.b = rVar;
            rVar.onCreate();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.c
        public MediaSessionManager.RemoteUserInfo b() {
            b bVar = MediaBrowserServiceCompat.this.c;
            if (bVar != null) {
                return bVar.b;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.c
        public Bundle c() {
            if (this.c == null) {
                return null;
            }
            b bVar = MediaBrowserServiceCompat.this.c;
            if (bVar == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (bVar.c == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.c.c);
            }
        }

        public void d(b bVar, String str, Bundle bundle) {
            List<Pair<IBinder, Bundle>> list = bVar.e.get(str);
            if (list != null) {
                for (Pair<IBinder, Bundle> pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                        MediaBrowserServiceCompat.this.a(str, bVar, pair.second, bundle);
                    }
                }
            }
        }

        public void e(String str, Bundle bundle) {
            ((MediaBrowserService) this.b).notifyChildrenChanged(str);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21$ServiceCompatProxy
        public q onGetRoot(String str, int i, Bundle bundle) {
            Bundle bundle2;
            IBinder iBinder;
            if (bundle == null || bundle.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                this.c = new Messenger(MediaBrowserServiceCompat.this.d);
                bundle2 = new Bundle();
                bundle2.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
                BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.e;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    if (extraBinder == null) {
                        iBinder = null;
                    } else {
                        iBinder = extraBinder.asBinder();
                    }
                    BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_SESSION_BINDER, iBinder);
                } else {
                    this.a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.c = new b(str, -1, i, bundle, null);
            BrowserRoot onGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            MediaBrowserServiceCompat.this.c = null;
            if (onGetRoot == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = onGetRoot.getExtras();
            } else if (onGetRoot.getExtras() != null) {
                bundle2.putAll(onGetRoot.getExtras());
            }
            return new q(onGetRoot.getRootId(), bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21$ServiceCompatProxy
        public void onLoadChildren(String str, s<List<Parcel>> sVar) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new a(this, str, sVar));
        }
    }

    @RequiresApi(23)
    public class e extends d implements MediaBrowserServiceCompatApi23$ServiceCompatProxy {

        public class a extends Result<MediaBrowserCompat.MediaItem> {
            public final /* synthetic */ s f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(e eVar, Object obj, s sVar) {
                super(obj);
                this.f = sVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void d(MediaBrowserCompat.MediaItem mediaItem) {
                MediaBrowserCompat.MediaItem mediaItem2 = mediaItem;
                if (mediaItem2 == null) {
                    this.f.a(null);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                mediaItem2.writeToParcel(obtain, 0);
                this.f.a(obtain);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                this.f.a.detach();
            }
        }

        public e() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.d, androidx.media.MediaBrowserServiceCompat.c
        public void a() {
            t tVar = new t(MediaBrowserServiceCompat.this, this);
            this.b = tVar;
            tVar.onCreate();
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy
        public void onLoadItem(String str, s<Parcel> sVar) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new a(this, str, sVar));
        }
    }

    @RequiresApi(26)
    public class f extends e implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {

        public class a extends Result<List<MediaBrowserCompat.MediaItem>> {
            public final /* synthetic */ MediaBrowserServiceCompatApi26.b f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(f fVar, Object obj, MediaBrowserServiceCompatApi26.b bVar) {
                super(obj);
                this.f = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void d(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList<Parcel> arrayList;
                List<MediaBrowserCompat.MediaItem> list2 = list;
                ArrayList arrayList2 = null;
                if (list2 != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list2) {
                        Parcel obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                MediaBrowserServiceCompatApi26.b bVar = this.f;
                int i = this.e;
                Objects.requireNonNull(bVar);
                try {
                    MediaBrowserServiceCompatApi26.a.setInt(bVar.a, i);
                } catch (IllegalAccessException unused) {
                }
                MediaBrowserService.Result result = bVar.a;
                if (arrayList != null) {
                    arrayList2 = new ArrayList();
                    for (Parcel parcel : arrayList) {
                        parcel.setDataPosition(0);
                        arrayList2.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                        parcel.recycle();
                    }
                }
                result.sendResult(arrayList2);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                this.f.a.detach();
            }
        }

        public f() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.e, androidx.media.MediaBrowserServiceCompat.d, androidx.media.MediaBrowserServiceCompat.c
        public void a() {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            Field field = MediaBrowserServiceCompatApi26.a;
            MediaBrowserServiceCompatApi26.a aVar = new MediaBrowserServiceCompatApi26.a(mediaBrowserServiceCompat, this);
            this.b = aVar;
            aVar.onCreate();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.d, androidx.media.MediaBrowserServiceCompat.c
        public Bundle c() {
            b bVar = MediaBrowserServiceCompat.this.c;
            if (bVar == null) {
                Object obj = this.b;
                Field field = MediaBrowserServiceCompatApi26.a;
                return ((MediaBrowserService) obj).getBrowserRootHints();
            } else if (bVar.c == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.c.c);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.d
        public void e(String str, Bundle bundle) {
            if (bundle != null) {
                Object obj = this.b;
                Field field = MediaBrowserServiceCompatApi26.a;
                ((MediaBrowserService) obj).notifyChildrenChanged(str, bundle);
                return;
            }
            ((MediaBrowserService) this.b).notifyChildrenChanged(str);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void onLoadChildren(String str, MediaBrowserServiceCompatApi26.b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new a(this, str, bVar), bundle);
        }
    }

    @RequiresApi(28)
    public class g extends f {
        public g() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.d, androidx.media.MediaBrowserServiceCompat.c
        public MediaSessionManager.RemoteUserInfo b() {
            b bVar = MediaBrowserServiceCompat.this.c;
            if (bVar != null) {
                return bVar.b;
            }
            return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.b).getCurrentBrowserInfo());
        }
    }

    public class h {
        public h() {
        }
    }

    public interface i {
    }

    public static class j implements i {
        public final Messenger a;

        public j(Messenger messenger) {
            this.a = messenger;
        }

        public IBinder a() {
            return this.a.getBinder();
        }

        public void b(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
            bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
            d(1, bundle2);
        }

        public void c(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            bundle3.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            d(3, bundle3);
        }

        public final void d(int i, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.a.send(obtain);
        }
    }

    public final class k extends Handler {
        public final h a;

        public k() {
            this.a = new h();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    h hVar = this.a;
                    String string = data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME);
                    int i = data.getInt(MediaBrowserProtocol.DATA_CALLING_PID);
                    int i2 = data.getInt(MediaBrowserProtocol.DATA_CALLING_UID);
                    j jVar = new j(message.replyTo);
                    MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                    Objects.requireNonNull(mediaBrowserServiceCompat);
                    boolean z = false;
                    if (string != null) {
                        String[] packagesForUid = mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i2);
                        int length = packagesForUid.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                if (packagesForUid[i3].equals(string)) {
                                    z = true;
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                    if (z) {
                        MediaBrowserServiceCompat.this.d.a(new l6.q.h(hVar, jVar, string, i, i2, bundle));
                        return;
                    }
                    throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + string);
                case 2:
                    h hVar2 = this.a;
                    MediaBrowserServiceCompat.this.d.a(new l6.q.i(hVar2, new j(message.replyTo)));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    h hVar3 = this.a;
                    MediaBrowserServiceCompat.this.d.a(new l6.q.j(hVar3, new j(message.replyTo), data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), bundle2));
                    return;
                case 4:
                    h hVar4 = this.a;
                    MediaBrowserServiceCompat.this.d.a(new l6.q.k(hVar4, new j(message.replyTo), data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN)));
                    return;
                case 5:
                    h hVar5 = this.a;
                    String string2 = data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID);
                    ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER);
                    j jVar2 = new j(message.replyTo);
                    Objects.requireNonNull(hVar5);
                    if (!TextUtils.isEmpty(string2) && resultReceiver != null) {
                        MediaBrowserServiceCompat.this.d.a(new l(hVar5, jVar2, string2, resultReceiver));
                        return;
                    }
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    h hVar6 = this.a;
                    MediaBrowserServiceCompat.this.d.a(new m(hVar6, new j(message.replyTo), data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), bundle3));
                    return;
                case 7:
                    h hVar7 = this.a;
                    MediaBrowserServiceCompat.this.d.a(new n(hVar7, new j(message.replyTo)));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    h hVar8 = this.a;
                    String string3 = data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY);
                    ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER);
                    j jVar3 = new j(message.replyTo);
                    Objects.requireNonNull(hVar8);
                    if (!TextUtils.isEmpty(string3) && resultReceiver2 != null) {
                        MediaBrowserServiceCompat.this.d.a(new o(hVar8, jVar3, string3, bundle4, resultReceiver2));
                        return;
                    }
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    h hVar9 = this.a;
                    String string4 = data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION);
                    ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER);
                    j jVar4 = new j(message.replyTo);
                    Objects.requireNonNull(hVar9);
                    if (!TextUtils.isEmpty(string4) && resultReceiver3 != null) {
                        MediaBrowserServiceCompat.this.d.a(new p(hVar9, jVar4, string4, bundle5, resultReceiver3));
                        return;
                    }
                    return;
                default:
                    String str = "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1;
                    return;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }
    }

    public void a(String str, b bVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, bVar, str, bundle, bundle2);
        this.c = bVar;
        if (bundle == null) {
            onLoadChildren(str, aVar);
        } else {
            onLoadChildren(str, aVar, bundle);
        }
        this.c = null;
        if (!aVar.a()) {
            throw new IllegalStateException(a2.b.a.a.a.u(a2.b.a.a.a.L("onLoadChildren must call detach() or sendResult() before returning for package="), bVar.a, " id=", str));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Bundle getBrowserRootHints() {
        return this.a.c();
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.a.b();
    }

    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        return this.e;
    }

    public void notifyChildrenChanged(@NonNull String str) {
        if (str != null) {
            d dVar = (d) this.a;
            dVar.e(str, null);
            MediaBrowserServiceCompat.this.d.post(new l6.q.f(dVar, str, null));
            return;
        }
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return ((MediaBrowserService) ((d) this.a).b).onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.a = new g();
        } else if (i2 >= 26) {
            this.a = new f();
        } else if (i2 >= 23) {
            this.a = new e();
        } else {
            this.a = new d();
        }
        this.a.a();
    }

    public void onCustomAction(@NonNull String str, Bundle bundle, @NonNull Result<Bundle> result) {
        result.sendError(null);
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i2, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result);

    public void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result, @NonNull Bundle bundle) {
        result.e = 1;
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, @NonNull Result<MediaBrowserCompat.MediaItem> result) {
        result.e = 2;
        result.sendResult(null);
    }

    public void onSearch(@NonNull String str, Bundle bundle, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.e = 4;
        result.sendResult(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSubscribe(String str, Bundle bundle) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnsubscribe(String str) {
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.e == null) {
            this.e = token;
            d dVar = (d) this.a;
            MediaBrowserServiceCompat.this.d.a(new l6.q.e(dVar, token));
        } else {
            throw new IllegalStateException("The session token has already been set.");
        }
    }

    public void notifyChildrenChanged(@NonNull String str, @NonNull Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            d dVar = (d) this.a;
            dVar.e(str, bundle);
            MediaBrowserServiceCompat.this.d.post(new l6.q.f(dVar, str, bundle));
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull String str, @NonNull Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        } else if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            d dVar = (d) this.a;
            MediaBrowserServiceCompat.this.d.post(new l6.q.g(dVar, remoteUserInfo, str, bundle));
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }
}

package androidx.appcompat.app;

import a2.j.b.d.j.s;
import a2.j.b.d.j.t;
import a2.j.d.c.h4;
import a2.j.d.c.j4;
import a2.j.d.c.k4;
import a2.j.d.c.l3;
import a2.j.d.c.q3;
import a2.j.d.c.s3;
import a2.j.d.c.t3;
import a2.j.d.c.t4;
import a2.j.d.c.u4;
import a2.j.d.c.x4;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.util.Property;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewUtils;
import androidx.appcompat.widget.WithHint;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.BuildConfig;
import com.avito.android.util.preferences.db_preferences.Types;
import com.evernote.android.job.patched.internal.util.support.XmlUtils$ReadMapCallback;
import com.evernote.android.job.patched.internal.util.support.XmlUtils$WriteMapCallback;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.appevents.ml.MTensor;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Logger;
import com.facebook.share.internal.ShareConstants;
import com.facebook.soloader.SoLoader;
import com.facebook.soloader.SoSource;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.text.ttml.TtmlStyle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.kml.KmlBoolean;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlGroundOverlay;
import com.google.maps.android.data.kml.KmlLineString;
import com.google.maps.android.data.kml.KmlMultiGeometry;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlPoint;
import com.google.maps.android.data.kml.KmlPolygon;
import com.google.maps.android.data.kml.KmlStyle;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.vk.sdk.api.model.VKApiModel;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
import hu.akarnokd.rxjava2.joins.Plan;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.rxjava3.functions.Supplier;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.security.spec.ECParameterSpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;
import kotlin.UShort;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import l6.b.a.p;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.parser.HtmlTreeBuilder;
import org.jsoup.parser.Parser;
import org.junit.internal.Classes;
import org.junit.runner.Description;
import org.junit.runner.FilterFactory;
import org.junit.runner.FilterFactoryParams;
import org.junit.runner.Request;
import org.junit.runner.manipulation.Filter;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Xof;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHAKEDigest;
import org.spongycastle.crypto.engines.ChaChaEngine;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.crypto.xmss.HashTreeAddress;
import org.spongycastle.pqc.crypto.xmss.LTreeAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSNode;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.util.Arrays;
import org.spongycastle.x509.X509AttributeCertificate;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import r6.a.a.f.n;
import u6.a.j0.k0;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    public static final SimpleArrayMap<String, Integer> a0 = new SimpleArrayMap<>();
    public static final int[] b0 = {16842836};
    public static final boolean c0 = (!"robolectric".equals(Build.FINGERPRINT));
    public static final boolean d0 = true;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public PanelFeatureState[] G;
    public PanelFeatureState H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N = -100;
    public int O;
    public boolean P;
    public boolean Q;
    public g R;
    public g S;
    public boolean T;
    public int U;
    public final Runnable V = new a();
    public boolean W;
    public Rect X;
    public Rect Y;
    public AppCompatViewInflater Z;
    public final Object d;
    public final Context e;
    public Window f;
    public e g;
    public final AppCompatCallback h;
    public ActionBar i;
    public MenuInflater j;
    public CharSequence k;
    public DecorContentParent l;
    public c m;
    public k n;
    public ActionMode o;
    public ActionBarContextView p;
    public PopupWindow q;
    public Runnable r;
    public ViewPropertyAnimatorCompat s = null;
    public boolean t = true;
    public boolean u;
    public ViewGroup v;
    public TextView w;
    public View x;
    public boolean y;
    public boolean z;

    public static final class PanelFeatureState {
        public int a;
        public int b;
        public int c;
        public int d;
        public ViewGroup e;
        public View f;
        public View g;
        public MenuBuilder h;
        public ListMenuPresenter i;
        public Context j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n = false;
        public boolean o;
        public Bundle p;
        public boolean qwertyMode;

        public PanelFeatureState(int i2) {
            this.a = i2;
        }

        public void a(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.h;
            if (menuBuilder != menuBuilder2) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(this.i);
                }
                this.h = menuBuilder;
                if (menuBuilder != null && (listMenuPresenter = this.i) != null) {
                    menuBuilder.addMenuPresenter(listMenuPresenter);
                }
            }
        }

        public void clearMenuPresenters() {
            MenuBuilder menuBuilder = this.h;
            if (menuBuilder != null) {
                menuBuilder.removeMenuPresenter(this.i);
            }
            this.i = null;
        }

        public boolean hasPanelItems() {
            if (this.f == null) {
                return false;
            }
            if (this.g == null && this.i.getAdapter().getCount() <= 0) {
                return false;
            }
            return true;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.U & 1) != 0) {
                appCompatDelegateImpl.i(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.U & 4096) != 0) {
                appCompatDelegateImpl2.i(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.T = false;
            appCompatDelegateImpl3.U = 0;
        }
    }

    public class b implements ActionBarDrawerToggle.Delegate {
        public b() {
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return AppCompatDelegateImpl.this.n();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.r();
            ActionBar actionBar = appCompatDelegateImpl.i;
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.r();
            ActionBar actionBar = appCompatDelegateImpl.i;
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i) {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.r();
            ActionBar actionBar = appCompatDelegateImpl.i;
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
            }
        }
    }

    public final class c implements MenuPresenter.Callback {
        public c() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.e(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback q = AppCompatDelegateImpl.this.q();
            if (q == null) {
                return true;
            }
            q.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    public class d implements ActionMode.Callback {
        public ActionMode.Callback a;

        public class a extends ViewPropertyAnimatorListenerAdapter {
            public a() {
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.p.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.p.getParent() instanceof View) {
                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.p.getParent());
                }
                AppCompatDelegateImpl.this.p.removeAllViews();
                AppCompatDelegateImpl.this.s.setListener(null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.s = null;
                ViewCompat.requestApplyInsets(appCompatDelegateImpl2.v);
            }
        }

        public d(ActionMode.Callback callback) {
            this.a = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.a.onCreateActionMode(actionMode, menu);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.a.onDestroyActionMode(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.q != null) {
                appCompatDelegateImpl.f.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.r);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.p != null) {
                appCompatDelegateImpl2.j();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.s = ViewCompat.animate(appCompatDelegateImpl3.p).alpha(0.0f);
                AppCompatDelegateImpl.this.s.setListener(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.h;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.o);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.o = null;
            ViewCompat.requestApplyInsets(appCompatDelegateImpl5.v);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.v);
            return this.a.onPrepareActionMode(actionMode, menu);
        }
    }

    public class f extends g {
        public final PowerManager c;

        public f(@NonNull Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public int c() {
            return this.c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public void d() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract class g {
        public BroadcastReceiver a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                g.this.d();
            }
        }

        public g() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        @Nullable
        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b2 = b();
            if (b2 != null && b2.countActions() != 0) {
                if (this.a == null) {
                    this.a = new a();
                }
                AppCompatDelegateImpl.this.e.registerReceiver(this.a, b2);
            }
        }
    }

    public class h extends g {
        public final p c;

        public h(@NonNull p pVar) {
            super();
            this.c = pVar;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00e7  */
        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int c() {
            /*
            // Method dump skipped, instructions count: 254
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.h.c():int");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public void d() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    @RequiresApi(17)
    public static class i {
        public static Field a;
        public static boolean b;
        public static Class<?> c;
        public static boolean d;
        public static Field e;
        public static boolean f;
        public static Field g;
        public static boolean h;
        public static Method i;
        public static Method j;
        public static boolean k;
        public static ScheduledExecutorService l;
        public static a2.g.s.k m;

        @CanIgnoreReturnValue
        public static long A(long j2, String str) {
            if (j2 >= 0) {
                return j2;
            }
            throw new IllegalArgumentException(str + " cannot be negative but was: " + j2);
        }

        public static X9ECParameters A0(String str) {
            try {
                if (str.charAt(0) >= '0' && str.charAt(0) <= '2') {
                    return ECUtil.getNamedCurveByOid(new ASN1ObjectIdentifier(str));
                }
                if (str.indexOf(32) > 0) {
                    return ECUtil.getNamedCurveByName(str.substring(str.indexOf(32) + 1));
                }
                return ECUtil.getNamedCurveByName(str);
            } catch (IllegalArgumentException unused) {
                return ECUtil.getNamedCurveByName(str);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.collect.Multimap<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        public static <K, V> void A1(Multimap<K, V> multimap, ObjectInputStream objectInputStream, int i2) throws IOException, ClassNotFoundException {
            for (int i3 = 0; i3 < i2; i3++) {
                Collection collection = multimap.mo118get(objectInputStream.readObject());
                int readInt = objectInputStream.readInt();
                for (int i4 = 0; i4 < readInt; i4++) {
                    collection.add(objectInputStream.readObject());
                }
            }
        }

        public static int B(@NullableDecl String str, int i2) {
            if (i2 > 0) {
                return i2;
            }
            throw new IllegalArgumentException(str + " (" + i2 + ") must be > 0");
        }

        public static X500Name B0(Object obj) {
            if (obj instanceof X509Certificate) {
                return E0((X509Certificate) obj);
            }
            return X500Name.getInstance(((X500Principal) ((X509AttributeCertificate) obj).getIssuer().getPrincipals()[0]).getEncoded());
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.Multiset<E> */
        /* JADX WARN: Multi-variable type inference failed */
        public static <E> void B1(Multiset<E> multiset, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            int readInt = objectInputStream.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                multiset.add(objectInputStream.readObject(), objectInputStream.readInt());
            }
        }

        public static long C(@NullableDecl String str, long j2) {
            if (j2 > 0) {
                return j2;
            }
            throw new IllegalArgumentException(str + " (" + j2 + ") must be > 0");
        }

        public static long C0(@Nullable String str) {
            long j2 = 0;
            if (str == null) {
                return 0;
            }
            for (int i2 = 0; i2 < str.length(); i2++) {
                long charAt = j2 ^ ((long) str.charAt(i2));
                j2 = charAt + (charAt << 1) + (charAt << 4) + (charAt << 5) + (charAt << 7) + (charAt << 8) + (charAt << 40);
            }
            return j2;
        }

        public static void C1(byte[] bArr, int i2, long j2, byte[] bArr2, int i3) {
            ChaChaEngine chaChaEngine = new ChaChaEngine(12);
            chaChaEngine.init(true, new ParametersWithIV(new KeyParameter(bArr2, i3, 32), new byte[8]));
            chaChaEngine.processBytes(bArr, i2, (int) j2, bArr, i2);
        }

        public static BigInteger D(@NullableDecl String str, BigInteger bigInteger) {
            if (bigInteger.signum() > 0) {
                return bigInteger;
            }
            throw new IllegalArgumentException(str + " (" + bigInteger + ") must be > 0");
        }

        public static <T> l3<T> D0(Class<T> cls, String str) {
            try {
                return new l3<>(cls.getDeclaredField(str), null);
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        public static final void D1(StringBuilder sb, int i2, String str, Object obj) {
            if (obj instanceof List) {
                for (Object obj2 : (List) obj) {
                    D1(sb, i2, str, obj2);
                }
                return;
            }
            sb.append('\n');
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(k0(ByteString.copyFromUtf8((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof ByteString) {
                sb.append(": \"");
                sb.append(k0((ByteString) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof GeneratedMessageLite) {
                sb.append(" {");
                O1((GeneratedMessageLite) obj, sb, i2 + 2);
                sb.append("\n");
                for (int i4 = 0; i4 < i2; i4++) {
                    sb.append(' ');
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }

        public static void E(int i2, String str) {
            if (i2 <= 0) {
                throw new IllegalArgumentException(str + " must be positive but was: " + i2);
            }
        }

        public static X500Name E0(X509Certificate x509Certificate) {
            return X500Name.getInstance(x509Certificate.getIssuerX500Principal().getEncoded());
        }

        public static void E1(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3) {
            ChaChaEngine chaChaEngine = new ChaChaEngine(20);
            chaChaEngine.init(true, new ParametersWithIV(new KeyParameter(bArr), bArr2));
            chaChaEngine.processBytes(bArr3, i2, i3, bArr3, i2);
        }

        public static void F(boolean z) {
            if (!z) {
                throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
            }
        }

        public static String F0(long j2, Locale locale) {
            if (Build.VERSION.SDK_INT >= 24) {
                return t.c("MMMd", locale).format(new Date(j2));
            }
            AtomicReference<s> atomicReference = t.a;
            DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
            dateInstance.setTimeZone(t.g());
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) dateInstance;
            String pattern = simpleDateFormat.toPattern();
            int b2 = t.b(pattern, "yY", 1, 0);
            if (b2 < pattern.length()) {
                String str = "EMd";
                int b3 = t.b(pattern, str, 1, b2);
                if (b3 < pattern.length()) {
                    str = "EMd,";
                }
                pattern = pattern.replace(pattern.substring(t.b(pattern, str, -1, b2) + 1, b3), " ").trim();
            }
            simpleDateFormat.applyPattern(pattern);
            return simpleDateFormat.format(new Date(j2));
        }

        public static long F1(Context context, Uri uri, String str, long j2) {
            AutoCloseable autoCloseable = null;
            try {
                autoCloseable = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
                if (autoCloseable.moveToFirst() && !autoCloseable.isNull(0)) {
                    return autoCloseable.getLong(0);
                }
                I(autoCloseable);
                return j2;
            } catch (Exception e2) {
                String str2 = "Failed query: " + e2;
                return j2;
            } finally {
                I(autoCloseable);
            }
        }

        public static Vector[] G(Vector[] vectorArr) {
            if (vectorArr == null) {
                return null;
            }
            Vector[] vectorArr2 = new Vector[vectorArr.length];
            for (int i2 = 0; i2 != vectorArr.length; i2++) {
                vectorArr2[i2] = new Vector();
                Enumeration elements = vectorArr[i2].elements();
                while (elements.hasMoreElements()) {
                    vectorArr2[i2].addElement(elements.nextElement());
                }
            }
            return vectorArr2;
        }

        public static ASN1OctetString G0(byte[] bArr) {
            if (bArr == null) {
                return new DEROctetString(new byte[0]);
            }
            return new DEROctetString(Arrays.clone(bArr));
        }

        @Nullable
        public static String G1(Context context, Uri uri, String str, @Nullable String str2) {
            Cursor cursor;
            Throwable th;
            Exception e2;
            try {
                cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
                try {
                    if (!cursor.moveToFirst() || cursor.isNull(0)) {
                        I(cursor);
                        return null;
                    }
                    String string = cursor.getString(0);
                    I(cursor);
                    return string;
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        String str3 = "Failed query: " + e2;
                        I(cursor);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        I(cursor);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e2 = e4;
                cursor = null;
                String str3 = "Failed query: " + e2;
                I(cursor);
                return null;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                I(cursor);
                throw th;
            }
        }

        public static BodyPartID[] H(BodyPartID[] bodyPartIDArr) {
            BodyPartID[] bodyPartIDArr2 = new BodyPartID[bodyPartIDArr.length];
            System.arraycopy(bodyPartIDArr, 0, bodyPartIDArr2, 0, bodyPartIDArr.length);
            return bodyPartIDArr2;
        }

        public static Object H0(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }

        public static XMSSNode H1(x6.e.f.a.d.c cVar, XMSSNode xMSSNode, XMSSNode xMSSNode2, XMSSAddress xMSSAddress) {
            Objects.requireNonNull(xMSSNode, "left == null");
            Objects.requireNonNull(xMSSNode2, "right == null");
            if (xMSSNode.getHeight() == xMSSNode2.getHeight()) {
                Objects.requireNonNull(xMSSAddress, "address == null");
                byte[] cloneArray = XMSSUtil.cloneArray(cVar.d);
                if (xMSSAddress instanceof LTreeAddress) {
                    LTreeAddress lTreeAddress = (LTreeAddress) xMSSAddress;
                    xMSSAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress.getLayerAddress())).withTreeAddress(lTreeAddress.getTreeAddress())).withLTreeAddress(lTreeAddress.e).withTreeHeight(lTreeAddress.f).withTreeIndex(lTreeAddress.g).withKeyAndMask(0)).build();
                } else if (xMSSAddress instanceof HashTreeAddress) {
                    HashTreeAddress hashTreeAddress = (HashTreeAddress) xMSSAddress;
                    xMSSAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.getLayerAddress())).withTreeAddress(hashTreeAddress.getTreeAddress())).withTreeHeight(hashTreeAddress.e).withTreeIndex(hashTreeAddress.f).withKeyAndMask(0)).build();
                }
                byte[] b2 = cVar.b.b(cloneArray, xMSSAddress.toByteArray());
                if (xMSSAddress instanceof LTreeAddress) {
                    LTreeAddress lTreeAddress2 = (LTreeAddress) xMSSAddress;
                    xMSSAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress2.getLayerAddress())).withTreeAddress(lTreeAddress2.getTreeAddress())).withLTreeAddress(lTreeAddress2.e).withTreeHeight(lTreeAddress2.f).withTreeIndex(lTreeAddress2.g).withKeyAndMask(1)).build();
                } else if (xMSSAddress instanceof HashTreeAddress) {
                    HashTreeAddress hashTreeAddress2 = (HashTreeAddress) xMSSAddress;
                    xMSSAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress2.getLayerAddress())).withTreeAddress(hashTreeAddress2.getTreeAddress())).withTreeHeight(hashTreeAddress2.e).withTreeIndex(hashTreeAddress2.f).withKeyAndMask(1)).build();
                }
                byte[] b3 = cVar.b.b(cloneArray, xMSSAddress.toByteArray());
                if (xMSSAddress instanceof LTreeAddress) {
                    LTreeAddress lTreeAddress3 = (LTreeAddress) xMSSAddress;
                    xMSSAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress3.getLayerAddress())).withTreeAddress(lTreeAddress3.getTreeAddress())).withLTreeAddress(lTreeAddress3.e).withTreeHeight(lTreeAddress3.f).withTreeIndex(lTreeAddress3.g).withKeyAndMask(2)).build();
                } else if (xMSSAddress instanceof HashTreeAddress) {
                    HashTreeAddress hashTreeAddress3 = (HashTreeAddress) xMSSAddress;
                    xMSSAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress3.getLayerAddress())).withTreeAddress(hashTreeAddress3.getTreeAddress())).withTreeHeight(hashTreeAddress3.e).withTreeIndex(hashTreeAddress3.f).withKeyAndMask(2)).build();
                }
                byte[] b4 = cVar.b.b(cloneArray, xMSSAddress.toByteArray());
                int i2 = cVar.a.c;
                int i3 = i2 * 2;
                byte[] bArr = new byte[i3];
                for (int i4 = 0; i4 < i2; i4++) {
                    bArr[i4] = (byte) (xMSSNode.getValue()[i4] ^ b3[i4]);
                }
                for (int i5 = 0; i5 < i2; i5++) {
                    bArr[i5 + i2] = (byte) (xMSSNode2.getValue()[i5] ^ b4[i5]);
                }
                x6.e.f.a.d.b bVar = cVar.b;
                Objects.requireNonNull(bVar);
                int length = b2.length;
                int i6 = bVar.b;
                if (length != i6) {
                    throw new IllegalArgumentException("wrong key length");
                } else if (i3 == i6 * 2) {
                    return new XMSSNode(xMSSNode.getHeight(), bVar.c(1, b2, bArr));
                } else {
                    throw new IllegalArgumentException("wrong in length");
                }
            } else {
                throw new IllegalStateException("height of both nodes must be equal");
            }
        }

        public static void I(@Nullable AutoCloseable autoCloseable) {
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused) {
                }
            }
        }

        public static long I0(double d2) {
            Preconditions.checkArgument(Y0(d2), "not a normal value");
            int exponent = Math.getExponent(d2);
            long doubleToRawLongBits = Double.doubleToRawLongBits(d2) & 4503599627370495L;
            return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
        }

        public static JSONObject I1(InputStream inputStream) throws IOException {
            if (inputStream.read() != 0) {
                return null;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 3; i4++) {
                int read = inputStream.read();
                if (read == -1) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    AtomicLong atomicLong = FileLruCache.g;
                    Logger.log(loggingBehavior, "FileLruCache", "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i3 = (i3 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i3];
            while (i2 < i3) {
                int read2 = inputStream.read(bArr, i2, i3 - i2);
                if (read2 < 1) {
                    LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                    AtomicLong atomicLong2 = FileLruCache.g;
                    StringBuilder L = a2.b.a.a.a.L("readHeader: stream.read stopped at ");
                    L.append(Integer.valueOf(i2));
                    L.append(" when expected ");
                    L.append(i3);
                    Logger.log(loggingBehavior2, "FileLruCache", L.toString());
                    return null;
                }
                i2 += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr)).nextValue();
                if (nextValue instanceof JSONObject) {
                    return (JSONObject) nextValue;
                }
                LoggingBehavior loggingBehavior3 = LoggingBehavior.CACHE;
                AtomicLong atomicLong3 = FileLruCache.g;
                Logger.log(loggingBehavior3, "FileLruCache", "readHeader: expected JSONObject, got " + nextValue.getClass().getCanonicalName());
                return null;
            } catch (JSONException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public static int J(int i2, double d2) {
            int max = Math.max(i2, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max <= ((int) (d2 * ((double) highestOneBit)))) {
                return highestOneBit;
            }
            int i3 = highestOneBit << 1;
            if (i3 > 0) {
                return i3;
            }
            return 1073741824;
        }

        public static String J0(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            if (aSN1ObjectIdentifier.equals(NISTObjectIdentifiers.id_sha256)) {
                return "SHA256";
            }
            if (aSN1ObjectIdentifier.equals(NISTObjectIdentifiers.id_sha512)) {
                return "SHA512";
            }
            if (aSN1ObjectIdentifier.equals(NISTObjectIdentifiers.id_shake128)) {
                return "SHAKE128";
            }
            if (aSN1ObjectIdentifier.equals(NISTObjectIdentifiers.id_shake256)) {
                return "SHAKE256";
            }
            throw new IllegalArgumentException("unrecognized digest OID: " + aSN1ObjectIdentifier);
        }

        public static final HashMap<String, ?> J1(InputStream inputStream) throws XmlPullParserException, IOException {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, null);
            String[] strArr = new String[1];
            int eventType = newPullParser.getEventType();
            while (eventType != 2) {
                if (eventType == 3) {
                    throw new XmlPullParserException(a2.b.a.a.a.G(newPullParser, a2.b.a.a.a.L("Unexpected end tag at: ")));
                } else if (eventType != 4) {
                    eventType = newPullParser.next();
                    if (eventType == 1) {
                        throw new XmlPullParserException("Unexpected end of document");
                    }
                } else {
                    StringBuilder L = a2.b.a.a.a.L("Unexpected text: ");
                    L.append(newPullParser.getText());
                    throw new XmlPullParserException(L.toString());
                }
            }
            return (HashMap) M1(newPullParser, strArr, null);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
            r0.addSuppressed(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
            throw r1;
         */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final java.lang.String K(java.lang.String r4) throws java.lang.Exception {
            /*
                java.io.File r0 = new java.io.File
                r0.<init>(r4)
                java.io.BufferedInputStream r4 = new java.io.BufferedInputStream
                java.io.FileInputStream r1 = new java.io.FileInputStream
                r1.<init>(r0)
                r0 = 1024(0x400, float:1.435E-42)
                r4.<init>(r1, r0)
                java.lang.String r1 = "MD5"
                java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ all -> 0x003a }
                byte[] r0 = new byte[r0]     // Catch:{ all -> 0x003a }
            L_0x0019:
                int r2 = r4.read(r0)     // Catch:{ all -> 0x003a }
                if (r2 <= 0) goto L_0x0023
                r3 = 0
                r1.update(r0, r3, r2)     // Catch:{ all -> 0x003a }
            L_0x0023:
                r3 = -1
                if (r2 != r3) goto L_0x0019
                java.math.BigInteger r0 = new java.math.BigInteger     // Catch:{ all -> 0x003a }
                r2 = 1
                byte[] r1 = r1.digest()     // Catch:{ all -> 0x003a }
                r0.<init>(r2, r1)     // Catch:{ all -> 0x003a }
                r1 = 16
                java.lang.String r0 = r0.toString(r1)     // Catch:{ all -> 0x003a }
                r4.close()
                return r0
            L_0x003a:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x003c }
            L_0x003c:
                r1 = move-exception
                r4.close()     // Catch:{ all -> 0x0041 }
                goto L_0x0045
            L_0x0041:
                r4 = move-exception
                r0.addSuppressed(r4)
            L_0x0045:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.i.K(java.lang.String):java.lang.String");
        }

        public static String K0(long j2, Locale locale) {
            if (Build.VERSION.SDK_INT >= 24) {
                return t.c("yMMMd", locale).format(new Date(j2));
            }
            AtomicReference<s> atomicReference = t.a;
            DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
            dateInstance.setTimeZone(t.g());
            return dateInstance.format(new Date(j2));
        }

        public static final HashMap<String, ?> K1(InputStream inputStream) throws XmlPullParserException, IOException {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, null);
            String[] strArr = new String[1];
            int eventType = newPullParser.getEventType();
            while (eventType != 2) {
                if (eventType == 3) {
                    throw new XmlPullParserException(a2.b.a.a.a.G(newPullParser, a2.b.a.a.a.L("Unexpected end tag at: ")));
                } else if (eventType != 4) {
                    eventType = newPullParser.next();
                    if (eventType == 1) {
                        throw new XmlPullParserException("Unexpected end of document");
                    }
                } else {
                    StringBuilder L = a2.b.a.a.a.L("Unexpected text: ");
                    L.append(newPullParser.getText());
                    throw new XmlPullParserException(L.toString());
                }
            }
            return (HashMap) N1(newPullParser, strArr, null);
        }

        public static int L(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
            if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
            }
            return Math.min(orientationHelper.getTotalSpace(), orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view));
        }

        public static void L0(@Nullable InputStream inputStream, @NonNull File file) throws IOException {
            Throwable th;
            byte[] bArr = new byte[8192];
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            gZIPOutputStream2.write(bArr, 0, read);
                        } else {
                            gZIPOutputStream2.finish();
                            CommonUtils.closeQuietly(gZIPOutputStream2);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPOutputStream = gZIPOutputStream2;
                        CommonUtils.closeQuietly(gZIPOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                CommonUtils.closeQuietly(gZIPOutputStream);
                throw th;
            }
        }

        public static int L1(InputStream inputStream, int i2, boolean z) throws IOException {
            int i3;
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int read = inputStream.read();
                if (read != -1) {
                    if (z) {
                        i3 = (read & 255) << (i5 * 8);
                    } else {
                        i4 <<= 8;
                        i3 = read & 255;
                    }
                    i4 |= i3;
                } else {
                    throw new IOException("no more bytes");
                }
            }
            return i4;
        }

        public static int M(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
            int i2;
            if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
                return 0;
            }
            int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
            int max = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
            if (z2) {
                i2 = Math.max(0, (state.getItemCount() - max) - 1);
            } else {
                i2 = Math.max(0, min);
            }
            if (!z) {
                return i2;
            }
            return Math.round((((float) i2) * (((float) Math.abs(orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)))) + ((float) (orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(view))));
        }

        public static boolean M0(Comparator<?> comparator, Iterable<?> iterable) {
            Object obj;
            Preconditions.checkNotNull(comparator);
            Preconditions.checkNotNull(iterable);
            if (iterable instanceof SortedSet) {
                obj = ((SortedSet) iterable).comparator();
                if (obj == null) {
                    obj = Ordering.natural();
                }
            } else if (!(iterable instanceof q3)) {
                return false;
            } else {
                obj = ((q3) iterable).comparator();
            }
            return comparator.equals(obj);
        }

        public static final Object M1(XmlPullParser xmlPullParser, String[] strArr, XmlUtils$ReadMapCallback xmlUtils$ReadMapCallback) throws XmlPullParserException, IOException {
            int next;
            Object obj = null;
            String attributeValue = xmlPullParser.getAttributeValue(null, "name");
            String name = xmlPullParser.getName();
            if (!name.equals(BuildConfig.ADJUST_DEFAULT_TRACKER)) {
                if (name.equals(Types.STRING)) {
                    String str = "";
                    while (true) {
                        int next2 = xmlPullParser.next();
                        if (next2 == 1) {
                            throw new XmlPullParserException("Unexpected end of document in <string>");
                        } else if (next2 == 3) {
                            if (xmlPullParser.getName().equals(Types.STRING)) {
                                strArr[0] = attributeValue;
                                return str;
                            }
                            throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Unexpected end tag in <string>: ")));
                        } else if (next2 == 4) {
                            StringBuilder L = a2.b.a.a.a.L(str);
                            L.append(xmlPullParser.getText());
                            str = L.toString();
                        } else if (next2 == 2) {
                            throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Unexpected start tag in <string>: ")));
                        }
                    }
                } else {
                    try {
                        if (name.equals(Types.INT)) {
                            obj = Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
                        } else if (name.equals("long")) {
                            obj = Long.valueOf(xmlPullParser.getAttributeValue(null, "value"));
                        } else if (name.equals(Types.FLOAT)) {
                            obj = Float.valueOf(xmlPullParser.getAttributeValue(null, "value"));
                        } else if (name.equals("double")) {
                            obj = Double.valueOf(xmlPullParser.getAttributeValue(null, "value"));
                        } else if (name.equals(Types.BOOLEAN)) {
                            obj = Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value"));
                        }
                        if (obj == null) {
                            if (name.equals("int-array")) {
                                try {
                                    int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
                                    xmlPullParser.next();
                                    int[] iArr = new int[parseInt];
                                    int eventType = xmlPullParser.getEventType();
                                    int i2 = 0;
                                    do {
                                        if (eventType == 2) {
                                            if (xmlPullParser.getName().equals("item")) {
                                                try {
                                                    iArr[i2] = Integer.parseInt(xmlPullParser.getAttributeValue(null, "value"));
                                                } catch (NullPointerException unused) {
                                                    throw new XmlPullParserException("Need value attribute in item");
                                                } catch (NumberFormatException unused2) {
                                                    throw new XmlPullParserException("Not a number in value attribute in item");
                                                }
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Expected item tag at: ")));
                                            }
                                        } else if (eventType == 3) {
                                            if (xmlPullParser.getName().equals("int-array")) {
                                                strArr[0] = attributeValue;
                                                return iArr;
                                            } else if (xmlPullParser.getName().equals("item")) {
                                                i2++;
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "int-array", " end tag at: ")));
                                            }
                                        }
                                        eventType = xmlPullParser.next();
                                    } while (eventType != 1);
                                    throw new XmlPullParserException("Document ended before int-array end tag");
                                } catch (NullPointerException unused3) {
                                    throw new XmlPullParserException("Need num attribute in byte-array");
                                } catch (NumberFormatException unused4) {
                                    throw new XmlPullParserException("Not a number in num attribute in byte-array");
                                }
                            } else if (name.equals("long-array")) {
                                try {
                                    int parseInt2 = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
                                    xmlPullParser.next();
                                    long[] jArr = new long[parseInt2];
                                    int eventType2 = xmlPullParser.getEventType();
                                    int i3 = 0;
                                    do {
                                        if (eventType2 == 2) {
                                            if (xmlPullParser.getName().equals("item")) {
                                                try {
                                                    jArr[i3] = Long.parseLong(xmlPullParser.getAttributeValue(null, "value"));
                                                } catch (NullPointerException unused5) {
                                                    throw new XmlPullParserException("Need value attribute in item");
                                                } catch (NumberFormatException unused6) {
                                                    throw new XmlPullParserException("Not a number in value attribute in item");
                                                }
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Expected item tag at: ")));
                                            }
                                        } else if (eventType2 == 3) {
                                            if (xmlPullParser.getName().equals("long-array")) {
                                                strArr[0] = attributeValue;
                                                return jArr;
                                            } else if (xmlPullParser.getName().equals("item")) {
                                                i3++;
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "long-array", " end tag at: ")));
                                            }
                                        }
                                        eventType2 = xmlPullParser.next();
                                    } while (eventType2 != 1);
                                    throw new XmlPullParserException("Document ended before long-array end tag");
                                } catch (NullPointerException unused7) {
                                    throw new XmlPullParserException("Need num attribute in long-array");
                                } catch (NumberFormatException unused8) {
                                    throw new XmlPullParserException("Not a number in num attribute in long-array");
                                }
                            } else if (name.equals("double-array")) {
                                try {
                                    int parseInt3 = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
                                    xmlPullParser.next();
                                    double[] dArr = new double[parseInt3];
                                    int eventType3 = xmlPullParser.getEventType();
                                    int i4 = 0;
                                    do {
                                        if (eventType3 == 2) {
                                            if (xmlPullParser.getName().equals("item")) {
                                                try {
                                                    dArr[i4] = Double.parseDouble(xmlPullParser.getAttributeValue(null, "value"));
                                                } catch (NullPointerException unused9) {
                                                    throw new XmlPullParserException("Need value attribute in item");
                                                } catch (NumberFormatException unused10) {
                                                    throw new XmlPullParserException("Not a number in value attribute in item");
                                                }
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Expected item tag at: ")));
                                            }
                                        } else if (eventType3 == 3) {
                                            if (xmlPullParser.getName().equals("double-array")) {
                                                strArr[0] = attributeValue;
                                                return dArr;
                                            } else if (xmlPullParser.getName().equals("item")) {
                                                i4++;
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "double-array", " end tag at: ")));
                                            }
                                        }
                                        eventType3 = xmlPullParser.next();
                                    } while (eventType3 != 1);
                                    throw new XmlPullParserException("Document ended before double-array end tag");
                                } catch (NullPointerException unused11) {
                                    throw new XmlPullParserException("Need num attribute in double-array");
                                } catch (NumberFormatException unused12) {
                                    throw new XmlPullParserException("Not a number in num attribute in double-array");
                                }
                            } else if (name.equals("string-array")) {
                                try {
                                    int parseInt4 = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
                                    xmlPullParser.next();
                                    String[] strArr2 = new String[parseInt4];
                                    int eventType4 = xmlPullParser.getEventType();
                                    int i5 = 0;
                                    do {
                                        if (eventType4 == 2) {
                                            if (xmlPullParser.getName().equals("item")) {
                                                try {
                                                    strArr2[i5] = xmlPullParser.getAttributeValue(null, "value");
                                                } catch (NullPointerException unused13) {
                                                    throw new XmlPullParserException("Need value attribute in item");
                                                } catch (NumberFormatException unused14) {
                                                    throw new XmlPullParserException("Not a number in value attribute in item");
                                                }
                                            } else if (xmlPullParser.getName().equals(BuildConfig.ADJUST_DEFAULT_TRACKER)) {
                                                strArr2[i5] = null;
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Expected item tag at: ")));
                                            }
                                        } else if (eventType4 == 3) {
                                            if (xmlPullParser.getName().equals("string-array")) {
                                                strArr[0] = attributeValue;
                                                return strArr2;
                                            } else if (xmlPullParser.getName().equals("item") || xmlPullParser.getName().equals(BuildConfig.ADJUST_DEFAULT_TRACKER)) {
                                                i5++;
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "string-array", " end tag at: ")));
                                            }
                                        }
                                        eventType4 = xmlPullParser.next();
                                    } while (eventType4 != 1);
                                    throw new XmlPullParserException("Document ended before string-array end tag");
                                } catch (NullPointerException unused15) {
                                    throw new XmlPullParserException("Need num attribute in string-array");
                                } catch (NumberFormatException unused16) {
                                    throw new XmlPullParserException("Not a number in num attribute in string-array");
                                }
                            } else if (name.equals("map")) {
                                xmlPullParser.next();
                                HashMap hashMap = new HashMap();
                                int eventType5 = xmlPullParser.getEventType();
                                do {
                                    if (eventType5 == 2) {
                                        hashMap.put(strArr[0], M1(xmlPullParser, strArr, null));
                                    } else if (eventType5 == 3) {
                                        if (xmlPullParser.getName().equals("map")) {
                                            strArr[0] = attributeValue;
                                            return hashMap;
                                        }
                                        throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "map", " end tag at: ")));
                                    }
                                    eventType5 = xmlPullParser.next();
                                } while (eventType5 != 1);
                                throw new XmlPullParserException("Document ended before map end tag");
                            } else if (name.equals("list")) {
                                xmlPullParser.next();
                                ArrayList arrayList = new ArrayList();
                                int eventType6 = xmlPullParser.getEventType();
                                do {
                                    if (eventType6 == 2) {
                                        arrayList.add(M1(xmlPullParser, strArr, null));
                                    } else if (eventType6 == 3) {
                                        if (xmlPullParser.getName().equals("list")) {
                                            strArr[0] = attributeValue;
                                            return arrayList;
                                        }
                                        throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "list", " end tag at: ")));
                                    }
                                    eventType6 = xmlPullParser.next();
                                } while (eventType6 != 1);
                                throw new XmlPullParserException("Document ended before list end tag");
                            } else if (name.equals("set")) {
                                xmlPullParser.next();
                                HashSet hashSet = new HashSet();
                                int eventType7 = xmlPullParser.getEventType();
                                do {
                                    if (eventType7 == 2) {
                                        hashSet.add(M1(xmlPullParser, strArr, null));
                                    } else if (eventType7 == 3) {
                                        if (xmlPullParser.getName().equals("set")) {
                                            strArr[0] = attributeValue;
                                            return hashSet;
                                        }
                                        throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "set", " end tag at: ")));
                                    }
                                    eventType7 = xmlPullParser.next();
                                } while (eventType7 != 1);
                                throw new XmlPullParserException("Document ended before set end tag");
                            } else if (xmlUtils$ReadMapCallback != null) {
                                Object readThisUnknownObjectXml = xmlUtils$ReadMapCallback.readThisUnknownObjectXml(xmlPullParser, name);
                                strArr[0] = attributeValue;
                                return readThisUnknownObjectXml;
                            } else {
                                throw new XmlPullParserException(a2.b.a.a.a.c3("Unknown tag: ", name));
                            }
                        }
                    } catch (NullPointerException unused17) {
                        throw new XmlPullParserException(a2.b.a.a.a.e3("Need value attribute in <", name, ">"));
                    } catch (NumberFormatException unused18) {
                        throw new XmlPullParserException(a2.b.a.a.a.e3("Not a number in value attribute in <", name, ">"));
                    }
                }
            }
            do {
                next = xmlPullParser.next();
                if (next == 1) {
                    throw new XmlPullParserException(a2.b.a.a.a.e3("Unexpected end of document in <", name, ">"));
                } else if (next == 3) {
                    if (xmlPullParser.getName().equals(name)) {
                        strArr[0] = attributeValue;
                        return obj;
                    }
                    throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Unexpected end tag in <", name, ">: ")));
                } else if (next == 4) {
                    throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Unexpected text in <", name, ">: ")));
                }
            } while (next != 2);
            throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Unexpected start tag in <", name, ">: ")));
        }

        public static int N(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
            if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return state.getItemCount();
            }
            return (int) ((((float) (orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) * ((float) state.getItemCount()));
        }

        public static double N0(double d2) {
            double sin = Math.sin(d2 * 0.5d);
            return sin * sin;
        }

        public static final Object N1(XmlPullParser xmlPullParser, String[] strArr, com.evernote.android.job.util.support.XmlUtils$ReadMapCallback xmlUtils$ReadMapCallback) throws XmlPullParserException, IOException {
            int next;
            Object obj = null;
            String attributeValue = xmlPullParser.getAttributeValue(null, "name");
            String name = xmlPullParser.getName();
            if (!name.equals(BuildConfig.ADJUST_DEFAULT_TRACKER)) {
                if (name.equals(Types.STRING)) {
                    String str = "";
                    while (true) {
                        int next2 = xmlPullParser.next();
                        if (next2 == 1) {
                            throw new XmlPullParserException("Unexpected end of document in <string>");
                        } else if (next2 == 3) {
                            if (xmlPullParser.getName().equals(Types.STRING)) {
                                strArr[0] = attributeValue;
                                return str;
                            }
                            throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Unexpected end tag in <string>: ")));
                        } else if (next2 == 4) {
                            StringBuilder L = a2.b.a.a.a.L(str);
                            L.append(xmlPullParser.getText());
                            str = L.toString();
                        } else if (next2 == 2) {
                            throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Unexpected start tag in <string>: ")));
                        }
                    }
                } else {
                    try {
                        if (name.equals(Types.INT)) {
                            obj = Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
                        } else if (name.equals("long")) {
                            obj = Long.valueOf(xmlPullParser.getAttributeValue(null, "value"));
                        } else if (name.equals(Types.FLOAT)) {
                            obj = Float.valueOf(xmlPullParser.getAttributeValue(null, "value"));
                        } else if (name.equals("double")) {
                            obj = Double.valueOf(xmlPullParser.getAttributeValue(null, "value"));
                        } else if (name.equals(Types.BOOLEAN)) {
                            obj = Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value"));
                        }
                        if (obj == null) {
                            if (name.equals("int-array")) {
                                try {
                                    int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
                                    xmlPullParser.next();
                                    int[] iArr = new int[parseInt];
                                    int eventType = xmlPullParser.getEventType();
                                    int i2 = 0;
                                    do {
                                        if (eventType == 2) {
                                            if (xmlPullParser.getName().equals("item")) {
                                                try {
                                                    iArr[i2] = Integer.parseInt(xmlPullParser.getAttributeValue(null, "value"));
                                                } catch (NullPointerException unused) {
                                                    throw new XmlPullParserException("Need value attribute in item");
                                                } catch (NumberFormatException unused2) {
                                                    throw new XmlPullParserException("Not a number in value attribute in item");
                                                }
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Expected item tag at: ")));
                                            }
                                        } else if (eventType == 3) {
                                            if (xmlPullParser.getName().equals("int-array")) {
                                                strArr[0] = attributeValue;
                                                return iArr;
                                            } else if (xmlPullParser.getName().equals("item")) {
                                                i2++;
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "int-array", " end tag at: ")));
                                            }
                                        }
                                        eventType = xmlPullParser.next();
                                    } while (eventType != 1);
                                    throw new XmlPullParserException("Document ended before int-array end tag");
                                } catch (NullPointerException unused3) {
                                    throw new XmlPullParserException("Need num attribute in byte-array");
                                } catch (NumberFormatException unused4) {
                                    throw new XmlPullParserException("Not a number in num attribute in byte-array");
                                }
                            } else if (name.equals("long-array")) {
                                try {
                                    int parseInt2 = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
                                    xmlPullParser.next();
                                    long[] jArr = new long[parseInt2];
                                    int eventType2 = xmlPullParser.getEventType();
                                    int i3 = 0;
                                    do {
                                        if (eventType2 == 2) {
                                            if (xmlPullParser.getName().equals("item")) {
                                                try {
                                                    jArr[i3] = Long.parseLong(xmlPullParser.getAttributeValue(null, "value"));
                                                } catch (NullPointerException unused5) {
                                                    throw new XmlPullParserException("Need value attribute in item");
                                                } catch (NumberFormatException unused6) {
                                                    throw new XmlPullParserException("Not a number in value attribute in item");
                                                }
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Expected item tag at: ")));
                                            }
                                        } else if (eventType2 == 3) {
                                            if (xmlPullParser.getName().equals("long-array")) {
                                                strArr[0] = attributeValue;
                                                return jArr;
                                            } else if (xmlPullParser.getName().equals("item")) {
                                                i3++;
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "long-array", " end tag at: ")));
                                            }
                                        }
                                        eventType2 = xmlPullParser.next();
                                    } while (eventType2 != 1);
                                    throw new XmlPullParserException("Document ended before long-array end tag");
                                } catch (NullPointerException unused7) {
                                    throw new XmlPullParserException("Need num attribute in long-array");
                                } catch (NumberFormatException unused8) {
                                    throw new XmlPullParserException("Not a number in num attribute in long-array");
                                }
                            } else if (name.equals("double-array")) {
                                try {
                                    int parseInt3 = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
                                    xmlPullParser.next();
                                    double[] dArr = new double[parseInt3];
                                    int eventType3 = xmlPullParser.getEventType();
                                    int i4 = 0;
                                    do {
                                        if (eventType3 == 2) {
                                            if (xmlPullParser.getName().equals("item")) {
                                                try {
                                                    dArr[i4] = Double.parseDouble(xmlPullParser.getAttributeValue(null, "value"));
                                                } catch (NullPointerException unused9) {
                                                    throw new XmlPullParserException("Need value attribute in item");
                                                } catch (NumberFormatException unused10) {
                                                    throw new XmlPullParserException("Not a number in value attribute in item");
                                                }
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Expected item tag at: ")));
                                            }
                                        } else if (eventType3 == 3) {
                                            if (xmlPullParser.getName().equals("double-array")) {
                                                strArr[0] = attributeValue;
                                                return dArr;
                                            } else if (xmlPullParser.getName().equals("item")) {
                                                i4++;
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "double-array", " end tag at: ")));
                                            }
                                        }
                                        eventType3 = xmlPullParser.next();
                                    } while (eventType3 != 1);
                                    throw new XmlPullParserException("Document ended before double-array end tag");
                                } catch (NullPointerException unused11) {
                                    throw new XmlPullParserException("Need num attribute in double-array");
                                } catch (NumberFormatException unused12) {
                                    throw new XmlPullParserException("Not a number in num attribute in double-array");
                                }
                            } else if (name.equals("string-array")) {
                                try {
                                    int parseInt4 = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
                                    xmlPullParser.next();
                                    String[] strArr2 = new String[parseInt4];
                                    int eventType4 = xmlPullParser.getEventType();
                                    int i5 = 0;
                                    do {
                                        if (eventType4 == 2) {
                                            if (xmlPullParser.getName().equals("item")) {
                                                try {
                                                    strArr2[i5] = xmlPullParser.getAttributeValue(null, "value");
                                                } catch (NullPointerException unused13) {
                                                    throw new XmlPullParserException("Need value attribute in item");
                                                } catch (NumberFormatException unused14) {
                                                    throw new XmlPullParserException("Not a number in value attribute in item");
                                                }
                                            } else if (xmlPullParser.getName().equals(BuildConfig.ADJUST_DEFAULT_TRACKER)) {
                                                strArr2[i5] = null;
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.L("Expected item tag at: ")));
                                            }
                                        } else if (eventType4 == 3) {
                                            if (xmlPullParser.getName().equals("string-array")) {
                                                strArr[0] = attributeValue;
                                                return strArr2;
                                            } else if (xmlPullParser.getName().equals("item") || xmlPullParser.getName().equals(BuildConfig.ADJUST_DEFAULT_TRACKER)) {
                                                i5++;
                                            } else {
                                                throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "string-array", " end tag at: ")));
                                            }
                                        }
                                        eventType4 = xmlPullParser.next();
                                    } while (eventType4 != 1);
                                    throw new XmlPullParserException("Document ended before string-array end tag");
                                } catch (NullPointerException unused15) {
                                    throw new XmlPullParserException("Need num attribute in string-array");
                                } catch (NumberFormatException unused16) {
                                    throw new XmlPullParserException("Not a number in num attribute in string-array");
                                }
                            } else if (name.equals("map")) {
                                xmlPullParser.next();
                                HashMap hashMap = new HashMap();
                                int eventType5 = xmlPullParser.getEventType();
                                do {
                                    if (eventType5 == 2) {
                                        hashMap.put(strArr[0], N1(xmlPullParser, strArr, null));
                                    } else if (eventType5 == 3) {
                                        if (xmlPullParser.getName().equals("map")) {
                                            strArr[0] = attributeValue;
                                            return hashMap;
                                        }
                                        throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "map", " end tag at: ")));
                                    }
                                    eventType5 = xmlPullParser.next();
                                } while (eventType5 != 1);
                                throw new XmlPullParserException("Document ended before map end tag");
                            } else if (name.equals("list")) {
                                xmlPullParser.next();
                                ArrayList arrayList = new ArrayList();
                                int eventType6 = xmlPullParser.getEventType();
                                do {
                                    if (eventType6 == 2) {
                                        arrayList.add(N1(xmlPullParser, strArr, null));
                                    } else if (eventType6 == 3) {
                                        if (xmlPullParser.getName().equals("list")) {
                                            strArr[0] = attributeValue;
                                            return arrayList;
                                        }
                                        throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "list", " end tag at: ")));
                                    }
                                    eventType6 = xmlPullParser.next();
                                } while (eventType6 != 1);
                                throw new XmlPullParserException("Document ended before list end tag");
                            } else if (name.equals("set")) {
                                xmlPullParser.next();
                                HashSet hashSet = new HashSet();
                                int eventType7 = xmlPullParser.getEventType();
                                do {
                                    if (eventType7 == 2) {
                                        hashSet.add(N1(xmlPullParser, strArr, null));
                                    } else if (eventType7 == 3) {
                                        if (xmlPullParser.getName().equals("set")) {
                                            strArr[0] = attributeValue;
                                            return hashSet;
                                        }
                                        throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Expected ", "set", " end tag at: ")));
                                    }
                                    eventType7 = xmlPullParser.next();
                                } while (eventType7 != 1);
                                throw new XmlPullParserException("Document ended before set end tag");
                            } else if (xmlUtils$ReadMapCallback != null) {
                                Object readThisUnknownObjectXml = xmlUtils$ReadMapCallback.readThisUnknownObjectXml(xmlPullParser, name);
                                strArr[0] = attributeValue;
                                return readThisUnknownObjectXml;
                            } else {
                                throw new XmlPullParserException(a2.b.a.a.a.c3("Unknown tag: ", name));
                            }
                        }
                    } catch (NullPointerException unused17) {
                        throw new XmlPullParserException(a2.b.a.a.a.e3("Need value attribute in <", name, ">"));
                    } catch (NumberFormatException unused18) {
                        throw new XmlPullParserException(a2.b.a.a.a.e3("Not a number in value attribute in <", name, ">"));
                    }
                }
            }
            do {
                next = xmlPullParser.next();
                if (next == 1) {
                    throw new XmlPullParserException(a2.b.a.a.a.e3("Unexpected end of document in <", name, ">"));
                } else if (next == 3) {
                    if (xmlPullParser.getName().equals(name)) {
                        strArr[0] = attributeValue;
                        return obj;
                    }
                    throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Unexpected end tag in <", name, ">: ")));
                } else if (next == 4) {
                    throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Unexpected text in <", name, ">: ")));
                }
            } while (next != 2);
            throw new XmlPullParserException(a2.b.a.a.a.G(xmlPullParser, a2.b.a.a.a.R("Unexpected start tag in <", name, ">: ")));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
            if (r3 == 0) goto L_0x0033;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final <T> u6.a.j0.r0<T> O(kotlinx.coroutines.flow.Flow<? extends T> r6, int r7) {
            /*
                kotlinx.coroutines.channels.Channel$Factory r0 = kotlinx.coroutines.channels.Channel.Factory
                int r0 = r0.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core()
                int r0 = t6.v.e.coerceAtLeast(r7, r0)
                int r0 = r0 - r7
                boolean r1 = r6 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
                if (r1 == 0) goto L_0x003c
                r1 = r6
                kotlinx.coroutines.flow.internal.ChannelFlow r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r1
                kotlinx.coroutines.flow.Flow r2 = r1.dropChannelOperators()
                if (r2 == 0) goto L_0x003c
                u6.a.j0.r0 r6 = new u6.a.j0.r0
                int r3 = r1.capacity
                r4 = -3
                if (r3 == r4) goto L_0x0026
                r4 = -2
                if (r3 == r4) goto L_0x0026
                if (r3 == 0) goto L_0x0026
                r0 = r3
                goto L_0x0034
            L_0x0026:
                kotlinx.coroutines.channels.BufferOverflow r4 = r1.onBufferOverflow
                kotlinx.coroutines.channels.BufferOverflow r5 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
                if (r4 != r5) goto L_0x002f
                if (r3 != 0) goto L_0x0034
                goto L_0x0033
            L_0x002f:
                if (r7 != 0) goto L_0x0033
                r0 = 1
                goto L_0x0034
            L_0x0033:
                r0 = 0
            L_0x0034:
                kotlinx.coroutines.channels.BufferOverflow r7 = r1.onBufferOverflow
                kotlin.coroutines.CoroutineContext r1 = r1.context
                r6.<init>(r2, r0, r7, r1)
                return r6
            L_0x003c:
                u6.a.j0.r0 r7 = new u6.a.j0.r0
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
                kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
                r7.<init>(r6, r0, r1, r2)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.i.O(kotlinx.coroutines.flow.Flow, int):u6.a.j0.r0");
        }

        public static double O0(double d2, double d3, double d4) {
            double N0 = N0(d2 - d3);
            double N02 = N0(d4);
            return (Math.cos(d3) * Math.cos(d2) * N02) + N0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0160, code lost:
            if (((java.lang.Integer) r9).intValue() == 0) goto L_0x01b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0171, code lost:
            if (((java.lang.Float) r9).floatValue() == 0.0f) goto L_0x01b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0183, code lost:
            if (((java.lang.Double) r9).doubleValue() == 0.0d) goto L_0x01b5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void O1(com.google.protobuf.MessageLite r13, java.lang.StringBuilder r14, int r15) {
            /*
            // Method dump skipped, instructions count: 554
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.i.O1(com.google.protobuf.MessageLite, java.lang.StringBuilder, int):void");
        }

        public static MTensor P(MTensor mTensor, MTensor mTensor2) {
            int i2 = 0;
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            int shape3 = mTensor.getShape(2);
            int shape4 = mTensor2.getShape(0);
            int i3 = (shape2 - shape4) + 1;
            int shape5 = mTensor2.getShape(2);
            MTensor mTensor3 = new MTensor(new int[]{shape, i3, shape5});
            float[] data = mTensor.getData();
            float[] data2 = mTensor3.getData();
            float[] data3 = mTensor2.getData();
            int i4 = 0;
            while (i4 < shape) {
                int i5 = 0;
                while (i5 < shape5) {
                    int i6 = 0;
                    while (i6 < i3) {
                        float f2 = 0.0f;
                        int i7 = 0;
                        while (i7 < shape4) {
                            while (i2 < shape3) {
                                f2 = (data[((i7 + i6) * shape3) + (shape2 * shape3 * i4) + i2] * data3[(((i7 * shape3) + i2) * shape5) + i5]) + f2;
                                i2++;
                            }
                            i7++;
                            i2 = 0;
                        }
                        data2[a2.b.a.a.a.c2(i6, shape5, i3 * shape5 * i4, i5)] = f2;
                        i6++;
                        i2 = 0;
                    }
                    i5++;
                    i2 = 0;
                }
                i4++;
                i2 = 0;
            }
            return mTensor3;
        }

        public static int P0(int i2, int i3) {
            if (i2 > -12 || i3 > -65) {
                return -1;
            }
            return i2 ^ (i3 << 8);
        }

        public static void P1(MTensor mTensor) {
            float[] data = mTensor.getData();
            for (int i2 = 0; i2 < data.length; i2++) {
                if (data[i2] < 0.0f) {
                    data[i2] = 0.0f;
                }
            }
        }

        public static MessengerEventType Q(String str) {
            if (str == null) {
                return MessengerEventType.EVENT_UNKNOWN;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1349867671:
                    if (str.equals("onError")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1287936188:
                    if (str.equals("onRemoveMessage")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1216048212:
                    if (str.equals("onEditConversation")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1180158496:
                    if (str.equals("isRead")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -977882306:
                    if (str.equals("onEditMessage")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -777558414:
                    if (str.equals("onGetSubscriptionList")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -553719842:
                    if (str.equals("onCreateConversation")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -97433381:
                    if (str.equals("onRetransmitEvents")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 77061108:
                    if (str.equals("onEditUser")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 87372646:
                    if (str.equals("onRemoveConversation")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 484055595:
                    if (str.equals("onSubscribe")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 558130133:
                    if (str.equals("onSetStatus")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 938983194:
                    if (str.equals("onGetConversation")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 1062384498:
                    if (str.equals("onUnsubscribe")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case 1144879600:
                    if (str.equals("onGetPublicConversations")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 1170556928:
                    if (str.equals("onSendMessage")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 1261196642:
                    if (str.equals("onGetUser")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case 1539611702:
                    if (str.equals("onTyping")) {
                        c2 = 17;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return MessengerEventType.ON_ERROR;
                case 1:
                    return MessengerEventType.ON_REMOVE_MESSAGE;
                case 2:
                    return MessengerEventType.ON_EDIT_CONVERSATION;
                case 3:
                    return MessengerEventType.IS_READ;
                case 4:
                    return MessengerEventType.ON_EDIT_MESSAGE;
                case 5:
                    return MessengerEventType.ON_GET_SUBSCRIPTION_LIST;
                case 6:
                    return MessengerEventType.ON_CREATE_CONVERSATION;
                case 7:
                    return MessengerEventType.ON_RETRANSMIT_EVENTS;
                case '\b':
                    return MessengerEventType.ON_EDIT_USER;
                case '\t':
                    return MessengerEventType.ON_REMOVE_CONVERSATION;
                case '\n':
                    return MessengerEventType.ON_SUBSCRIBE;
                case 11:
                    return MessengerEventType.ON_SET_STATUS;
                case '\f':
                    return MessengerEventType.ON_GET_CONVERSATION;
                case '\r':
                    return MessengerEventType.ON_UNSUBSCRIBE;
                case 14:
                    return MessengerEventType.ON_GET_PUBLIC_CONVERSATIONS;
                case 15:
                    return MessengerEventType.ON_SEND_MESSAGE;
                case 16:
                    return MessengerEventType.ON_GET_USER;
                case 17:
                    return MessengerEventType.ON_TYPING;
                default:
                    return MessengerEventType.EVENT_UNKNOWN;
            }
        }

        public static int Q0(int i2, int i3, int i4) {
            if (i2 > -12 || i3 > -65 || i4 > -65) {
                return -1;
            }
            return (i2 ^ (i3 << 8)) ^ (i4 << 16);
        }

        public static <T> ArrayList<T> Q1(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }

        public static MessengerAction R(String str) {
            if (str == null) {
                return MessengerAction.ACTION_UNKNOWN;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -2144550173:
                    if (str.equals("removeMessage")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1994977583:
                    if (str.equals("getSubscriptionList")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1928302855:
                    if (str.equals("getConversation")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1562822753:
                    if (str.equals("createConversation")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1456985443:
                    if (str.equals("editMessage")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1296654643:
                    if (str.equals("joinConversation")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1180158496:
                    if (str.equals("isRead")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -921730265:
                    if (str.equals("removeConversation")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -285736655:
                    if (str.equals("getPublicConversations")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -75082687:
                    if (str.equals("getUser")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 92397485:
                    if (str.equals("editConversation")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 96459489:
                    if (str.equals("addParticipants")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 352153754:
                    if (str.equals("getConversations")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 514841930:
                    if (str.equals("subscribe")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case 583281361:
                    if (str.equals("unsubscribe")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 588916468:
                    if (str.equals("setStatus")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 653368900:
                    if (str.equals("removeParticipants")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case 691453791:
                    if (str.equals("sendMessage")) {
                        c2 = 17;
                        break;
                    }
                    break;
                case 698879632:
                    if (str.equals("typingMessage")) {
                        c2 = 18;
                        break;
                    }
                    break;
                case 1211012316:
                    if (str.equals("retransmitEvents")) {
                        c2 = 19;
                        break;
                    }
                    break;
                case 1602074869:
                    if (str.equals("editUser")) {
                        c2 = 20;
                        break;
                    }
                    break;
                case 1652460272:
                    if (str.equals("manageNotification")) {
                        c2 = 21;
                        break;
                    }
                    break;
                case 1667496650:
                    if (str.equals("editParticipants")) {
                        c2 = 22;
                        break;
                    }
                    break;
                case 1967404114:
                    if (str.equals("getUsers")) {
                        c2 = 23;
                        break;
                    }
                    break;
                case 2117018842:
                    if (str.equals("leaveConversation")) {
                        c2 = 24;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return MessengerAction.REMOVE_MESSAGE;
                case 1:
                    return MessengerAction.GET_SUBSCRIPTION_LIST;
                case 2:
                    return MessengerAction.GET_CONVERSATION;
                case 3:
                    return MessengerAction.CREATE_CONVERSATION;
                case 4:
                    return MessengerAction.EDIT_MESSAGE;
                case 5:
                    return MessengerAction.JOIN_CONVERSATION;
                case 6:
                    return MessengerAction.IS_READ;
                case 7:
                    return MessengerAction.REMOVE_CONVERSATION;
                case '\b':
                    return MessengerAction.GET_PUBLIC_CONVERSATIONS;
                case '\t':
                    return MessengerAction.GET_USER;
                case '\n':
                    return MessengerAction.EDIT_CONVERSATION;
                case 11:
                    return MessengerAction.ADD_PARTICIPANTS;
                case '\f':
                    return MessengerAction.GET_CONVERSATIONS;
                case '\r':
                    return MessengerAction.SUBSCRIBE;
                case 14:
                    return MessengerAction.UNSUBSCRIBE;
                case 15:
                    return MessengerAction.SET_STATUS;
                case 16:
                    return MessengerAction.REMOVE_PARTICIPANTS;
                case 17:
                    return MessengerAction.SEND_MESSAGE;
                case 18:
                    return MessengerAction.TYPING_MESSAGE;
                case 19:
                    return MessengerAction.RETRANSMIT_EVENTS;
                case 20:
                    return MessengerAction.EDIT_USER;
                case 21:
                    return MessengerAction.MANAGE_NOTIFICATIONS;
                case 22:
                    return MessengerAction.EDIT_PARTICIPANTS;
                case 23:
                    return MessengerAction.GET_USERS;
                case 24:
                    return MessengerAction.LEAVE_CONVERSATION;
                default:
                    return MessengerAction.ACTION_UNKNOWN;
            }
        }

        public static int R0(byte[] bArr, int i2, int i3) {
            byte b2 = bArr[i2 - 1];
            int i4 = i3 - i2;
            if (i4 != 0) {
                if (i4 == 1) {
                    return P0(b2, bArr[i2]);
                }
                if (i4 == 2) {
                    return Q0(b2, bArr[i2], bArr[i2 + 1]);
                }
                throw new AssertionError();
            } else if (b2 > -12) {
                return -1;
            } else {
                return b2;
            }
        }

        @Nullable
        public static TtmlStyle R1(@Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, Map<String, TtmlStyle> map) {
            int i2 = 0;
            if (ttmlStyle == null) {
                if (strArr == null) {
                    return null;
                }
                if (strArr.length == 1) {
                    return map.get(strArr[0]);
                }
                if (strArr.length > 1) {
                    TtmlStyle ttmlStyle2 = new TtmlStyle();
                    int length = strArr.length;
                    while (i2 < length) {
                        ttmlStyle2.a(map.get(strArr[i2]));
                        i2++;
                    }
                    return ttmlStyle2;
                }
            } else if (strArr != null && strArr.length == 1) {
                ttmlStyle.a(map.get(strArr[0]));
                return ttmlStyle;
            } else if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i2 < length2) {
                    ttmlStyle.a(map.get(strArr[i2]));
                    i2++;
                }
            }
            return ttmlStyle;
        }

        public static LatLng S(String str) {
            String[] split = str.split(",");
            return new LatLng(Double.valueOf(Double.parseDouble(split[1])).doubleValue(), Double.valueOf(Double.parseDouble(split[0])).doubleValue());
        }

        public static void S0(String str) {
            throw new IllegalArgumentException(a2.b.a.a.a.c3("Unknown library: ", str));
        }

        public static float S1(int i2, float f2, int i3, int i4) {
            float f3;
            if (f2 == -3.4028235E38f) {
                return -3.4028235E38f;
            }
            if (i2 == 0) {
                f3 = (float) i4;
            } else if (i2 == 1) {
                f3 = (float) i3;
            } else if (i2 != 2) {
                return -3.4028235E38f;
            } else {
                return f2;
            }
            return f2 * f3;
        }

        public static ArrayList<LatLng> T(String str) {
            ArrayList<LatLng> arrayList = new ArrayList<>();
            for (String str2 : str.trim().split("(\\s+)")) {
                arrayList.add(S(str2));
            }
            return arrayList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final /* synthetic */ <T> java.lang.Object T0(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.Nullable java.lang.Throwable r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                boolean r0 = r7 instanceof u6.a.j0.o
                if (r0 == 0) goto L_0x0013
                r0 = r7
                u6.a.j0.o r0 = (u6.a.j0.o) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.b = r1
                goto L_0x0018
            L_0x0013:
                u6.a.j0.o r0 = new u6.a.j0.o
                r0.<init>(r7)
            L_0x0018:
                java.lang.Object r7 = r0.a
                java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                int r2 = r0.b
                r3 = 1
                if (r2 == 0) goto L_0x003e
                if (r2 != r3) goto L_0x0036
                java.lang.Object r4 = r0.e
                r6 = r4
                java.lang.Throwable r6 = (java.lang.Throwable) r6
                java.lang.Object r4 = r0.d
                kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
                java.lang.Object r4 = r0.c
                kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0053 }
                goto L_0x0050
            L_0x0036:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L_0x003e:
                kotlin.ResultKt.throwOnFailure(r7)
                r0.c = r4
                r0.d = r5
                r0.e = r6
                r0.b = r3
                java.lang.Object r4 = r5.invoke(r4, r6, r0)
                if (r4 != r1) goto L_0x0050
                return r1
            L_0x0050:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            L_0x0053:
                r4 = move-exception
                if (r6 == 0) goto L_0x005b
                if (r6 == r4) goto L_0x005b
                t6.b.addSuppressed(r4, r6)
            L_0x005b:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.i.T0(kotlinx.coroutines.flow.FlowCollector, kotlin.jvm.functions.Function3, java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public static HashMap<String, String> T1(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            HashMap<String, String> hashMap = new HashMap<>();
            int eventType = xmlPullParser.getEventType();
            String str = null;
            while (true) {
                if (eventType == 3 && xmlPullParser.getName().equals("ExtendedData")) {
                    return hashMap;
                }
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("Data")) {
                        str = xmlPullParser.getAttributeValue(null, "name");
                    } else if (xmlPullParser.getName().equals("value") && str != null) {
                        hashMap.put(str, xmlPullParser.nextText());
                        str = null;
                    }
                }
                eventType = xmlPullParser.next();
            }
        }

        public static Filter U(Request request, String str) throws FilterFactory.FilterNotCreatedException {
            Description description = request.getRunner().getDescription();
            String[] split = str.contains("=") ? str.split("=", 2) : new String[]{str, ""};
            try {
                try {
                    return ((FilterFactory) Classes.getClass(split[0]).asSubclass(FilterFactory.class).getConstructor(new Class[0]).newInstance(new Object[0])).createFilter(new FilterFactoryParams(description, split[1]));
                } catch (Exception e2) {
                    throw new FilterFactory.FilterNotCreatedException(e2);
                }
            } catch (Exception e3) {
                throw new FilterFactory.FilterNotCreatedException(e3);
            }
        }

        public static boolean U0(@NonNull Rect rect, @NonNull Rect rect2, int i2) {
            if (i2 == 17) {
                int i3 = rect.right;
                int i4 = rect2.right;
                if ((i3 > i4 || rect.left >= i4) && rect.left > rect2.left) {
                    return true;
                }
                return false;
            } else if (i2 == 33) {
                int i5 = rect.bottom;
                int i6 = rect2.bottom;
                if ((i5 > i6 || rect.top >= i6) && rect.top > rect2.top) {
                    return true;
                }
                return false;
            } else if (i2 == 66) {
                int i7 = rect.left;
                int i8 = rect2.left;
                if ((i7 < i8 || rect.right <= i8) && rect.right < rect2.right) {
                    return true;
                }
                return false;
            } else if (i2 == 130) {
                int i9 = rect.top;
                int i10 = rect2.top;
                return (i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }

        public static void U1(SoSource[] soSourceArr) {
            ReentrantReadWriteLock reentrantReadWriteLock = SoLoader.c;
            reentrantReadWriteLock.writeLock().lock();
            try {
                SoLoader.d = soSourceArr;
                SoLoader.e++;
                reentrantReadWriteLock.writeLock().unlock();
            } catch (Throwable th) {
                SoLoader.c.writeLock().unlock();
                throw th;
            }
        }

        public static Geometry V(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
            int eventType = xmlPullParser.getEventType();
            while (true) {
                LatLng latLng = null;
                if (eventType == 3 && xmlPullParser.getName().equals(str)) {
                    return null;
                }
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("Point")) {
                        int eventType2 = xmlPullParser.getEventType();
                        while (true) {
                            if (eventType2 == 3 && xmlPullParser.getName().equals("Point")) {
                                return new KmlPoint(latLng);
                            }
                            if (eventType2 == 2 && xmlPullParser.getName().equals("coordinates")) {
                                latLng = S(xmlPullParser.nextText());
                            }
                            eventType2 = xmlPullParser.next();
                        }
                    } else if (xmlPullParser.getName().equals("LineString")) {
                        ArrayList<LatLng> arrayList = new ArrayList<>();
                        int eventType3 = xmlPullParser.getEventType();
                        while (true) {
                            if (eventType3 == 3 && xmlPullParser.getName().equals("LineString")) {
                                return new KmlLineString(arrayList);
                            }
                            if (eventType3 == 2 && xmlPullParser.getName().equals("coordinates")) {
                                arrayList = T(xmlPullParser.nextText());
                            }
                            eventType3 = xmlPullParser.next();
                        }
                    } else if (xmlPullParser.getName().equals(KmlPolygon.GEOMETRY_TYPE)) {
                        Boolean bool = Boolean.FALSE;
                        ArrayList<LatLng> arrayList2 = new ArrayList<>();
                        ArrayList arrayList3 = new ArrayList();
                        int eventType4 = xmlPullParser.getEventType();
                        while (true) {
                            if (eventType4 == 3 && xmlPullParser.getName().equals(KmlPolygon.GEOMETRY_TYPE)) {
                                return new KmlPolygon(arrayList2, arrayList3);
                            }
                            if (eventType4 == 2) {
                                if (xmlPullParser.getName().matches("outerBoundaryIs|innerBoundaryIs")) {
                                    bool = Boolean.valueOf(xmlPullParser.getName().equals("outerBoundaryIs"));
                                } else if (xmlPullParser.getName().equals("coordinates")) {
                                    if (bool.booleanValue()) {
                                        arrayList2 = T(xmlPullParser.nextText());
                                    } else {
                                        arrayList3.add(T(xmlPullParser.nextText()));
                                    }
                                }
                            }
                            eventType4 = xmlPullParser.next();
                        }
                    } else if (xmlPullParser.getName().equals("MultiGeometry")) {
                        ArrayList arrayList4 = new ArrayList();
                        int next = xmlPullParser.next();
                        while (true) {
                            if (next == 3 && xmlPullParser.getName().equals("MultiGeometry")) {
                                return new KmlMultiGeometry(arrayList4);
                            }
                            if (next == 2 && xmlPullParser.getName().matches("Point|LineString|Polygon|MultiGeometry")) {
                                arrayList4.add(V(xmlPullParser, xmlPullParser.getName()));
                            }
                            next = xmlPullParser.next();
                        }
                    }
                }
                eventType = xmlPullParser.next();
            }
        }

        @RequiresApi(26)
        public static boolean V0(NotificationManager notificationManager, String str) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            return notificationChannel == null || notificationChannel.getImportance() != 0;
        }

        public static int V1(int i2) {
            return (int) (((long) Integer.rotateLeft((int) (((long) i2) * -862048943), 15)) * 461845907);
        }

        public static KmlGroundOverlay W(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            int eventType = xmlPullParser.getEventType();
            String str = null;
            float f2 = 0.0f;
            int i2 = 1;
            float f3 = 0.0f;
            while (true) {
                if (eventType == 3 && xmlPullParser.getName().equals("GroundOverlay")) {
                    return new KmlGroundOverlay(str, new LatLngBounds(new LatLng(((Double) hashMap2.get("south")).doubleValue(), ((Double) hashMap2.get("west")).doubleValue()), new LatLng(((Double) hashMap2.get("north")).doubleValue(), ((Double) hashMap2.get("east")).doubleValue())), f2, i2, hashMap, f3);
                }
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("Icon")) {
                        int eventType2 = xmlPullParser.getEventType();
                        while (true) {
                            if (eventType2 != 3 || !xmlPullParser.getName().equals("Icon")) {
                                if (eventType2 == 2 && xmlPullParser.getName().equals(ShareConstants.WEB_DIALOG_PARAM_HREF)) {
                                    str = xmlPullParser.nextText();
                                    break;
                                }
                                eventType2 = xmlPullParser.next();
                            } else {
                                str = null;
                                break;
                            }
                        }
                    } else if (xmlPullParser.getName().equals("drawOrder")) {
                        f2 = Float.parseFloat(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY)) {
                        i2 = Integer.parseInt(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("ExtendedData")) {
                        hashMap.putAll(T1(xmlPullParser));
                    } else if (xmlPullParser.getName().equals("rotation")) {
                        f3 = -Float.parseFloat(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().matches("name|description|drawOrder|visibility|open|address|phoneNumber") || xmlPullParser.getName().equals("color")) {
                        hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().matches("north|south|east|west")) {
                        hashMap2.put(xmlPullParser.getName(), Double.valueOf(Double.parseDouble(xmlPullParser.nextText())));
                    }
                }
                eventType = xmlPullParser.next();
            }
        }

        public static boolean W0(CharSequence charSequence) {
            return charSequence == null || charSequence.length() == 0;
        }

        public static int W1(@NullableDecl Object obj) {
            return V1(obj == null ? 0 : obj.hashCode());
        }

        public static KmlPlacemark X(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
            HashMap hashMap = new HashMap();
            int eventType = xmlPullParser.getEventType();
            Geometry geometry = null;
            String str = null;
            KmlStyle kmlStyle = null;
            while (true) {
                if (eventType == 3 && xmlPullParser.getName().equals("Placemark")) {
                    return new KmlPlacemark(geometry, str, kmlStyle, hashMap);
                }
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("styleUrl")) {
                        str = xmlPullParser.nextText();
                    } else if (xmlPullParser.getName().matches("Point|LineString|Polygon|MultiGeometry")) {
                        geometry = V(xmlPullParser, xmlPullParser.getName());
                    } else if (xmlPullParser.getName().matches("name|description|drawOrder|visibility|open|address|phoneNumber")) {
                        hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("ExtendedData")) {
                        hashMap.putAll(T1(xmlPullParser));
                    } else if (xmlPullParser.getName().equals("Style")) {
                        kmlStyle = Y(xmlPullParser);
                    }
                }
                eventType = xmlPullParser.next();
            }
        }

        public static boolean X0(Context context, Uri uri) {
            String G1 = G1(context, uri, "mime_type", null);
            return !"vnd.android.document/directory".equals(G1) && !TextUtils.isEmpty(G1);
        }

        public static int X1(Context context, String str) {
            Resources.Theme theme = context.getTheme();
            if (theme == null) {
                return -1;
            }
            TypedValue typedValue = new TypedValue();
            int identifier = context.getResources().getIdentifier(str, "attr", context.getPackageName());
            if (identifier == 0) {
                return -1;
            }
            theme.resolveAttribute(identifier, typedValue, true);
            return typedValue.data;
        }

        public static KmlStyle Y(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
            KmlStyle kmlStyle = new KmlStyle();
            String attributeValue = xmlPullParser.getAttributeValue(null, "id");
            if (attributeValue != null) {
                kmlStyle.g = a2.b.a.a.a.c3("#", attributeValue);
            }
            int eventType = xmlPullParser.getEventType();
            while (true) {
                if (eventType == 3 && xmlPullParser.getName().equals("Style")) {
                    return kmlStyle;
                }
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("IconStyle")) {
                        int eventType2 = xmlPullParser.getEventType();
                        while (true) {
                            if (eventType2 == 3 && xmlPullParser.getName().equals("IconStyle")) {
                                break;
                            }
                            if (eventType2 == 2) {
                                if (xmlPullParser.getName().equals("heading")) {
                                    kmlStyle.setMarkerRotation(Float.parseFloat(xmlPullParser.nextText()));
                                    kmlStyle.b.add("heading");
                                } else if (xmlPullParser.getName().equals("Icon")) {
                                    int eventType3 = xmlPullParser.getEventType();
                                    while (true) {
                                        if (eventType3 == 3 && xmlPullParser.getName().equals("Icon")) {
                                            break;
                                        }
                                        if (eventType3 == 2 && xmlPullParser.getName().equals(ShareConstants.WEB_DIALOG_PARAM_HREF)) {
                                            kmlStyle.e = xmlPullParser.nextText();
                                            kmlStyle.b.add("iconUrl");
                                        }
                                        eventType3 = xmlPullParser.next();
                                    }
                                } else if (xmlPullParser.getName().equals("hotSpot")) {
                                    Float valueOf = Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, "x")));
                                    Float valueOf2 = Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, "y")));
                                    kmlStyle.setMarkerHotSpot(valueOf.floatValue(), valueOf2.floatValue(), xmlPullParser.getAttributeValue(null, "xunits"), xmlPullParser.getAttributeValue(null, "yunits"));
                                    kmlStyle.b.add("hotSpot");
                                } else if (xmlPullParser.getName().equals("scale")) {
                                    kmlStyle.f = Double.parseDouble(xmlPullParser.nextText());
                                    kmlStyle.b.add("iconScale");
                                } else if (xmlPullParser.getName().equals("color")) {
                                    String nextText = xmlPullParser.nextText();
                                    StringBuilder L = a2.b.a.a.a.L("#");
                                    L.append(KmlStyle.a(nextText));
                                    float[] fArr = new float[3];
                                    Color.colorToHSV(Color.parseColor(L.toString()), fArr);
                                    float f2 = fArr[0];
                                    kmlStyle.k = f2;
                                    kmlStyle.mMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(f2));
                                    kmlStyle.b.add("markerColor");
                                } else if (xmlPullParser.getName().equals("colorMode")) {
                                    kmlStyle.h = xmlPullParser.nextText().equals("random");
                                    kmlStyle.b.add("iconColorMode");
                                }
                            }
                            eventType2 = xmlPullParser.next();
                        }
                    } else if (xmlPullParser.getName().equals("LineStyle")) {
                        int eventType4 = xmlPullParser.getEventType();
                        while (true) {
                            if (eventType4 == 3 && xmlPullParser.getName().equals("LineStyle")) {
                                break;
                            }
                            if (eventType4 == 2) {
                                if (xmlPullParser.getName().equals("color")) {
                                    String nextText2 = xmlPullParser.nextText();
                                    PolylineOptions polylineOptions = kmlStyle.mPolylineOptions;
                                    StringBuilder L2 = a2.b.a.a.a.L("#");
                                    L2.append(KmlStyle.a(nextText2));
                                    polylineOptions.color(Color.parseColor(L2.toString()));
                                    PolygonOptions polygonOptions = kmlStyle.mPolygonOptions;
                                    polygonOptions.strokeColor(Color.parseColor("#" + nextText2));
                                    kmlStyle.b.add("outlineColor");
                                } else if (xmlPullParser.getName().equals(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                                    Float valueOf3 = Float.valueOf(xmlPullParser.nextText());
                                    kmlStyle.setLineStringWidth(valueOf3.floatValue());
                                    kmlStyle.setPolygonStrokeWidth(valueOf3.floatValue());
                                    kmlStyle.b.add(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                                } else if (xmlPullParser.getName().equals("colorMode")) {
                                    kmlStyle.i = xmlPullParser.nextText().equals("random");
                                    kmlStyle.b.add("lineColorMode");
                                }
                            }
                            eventType4 = xmlPullParser.next();
                        }
                    } else if (xmlPullParser.getName().equals("PolyStyle")) {
                        int eventType5 = xmlPullParser.getEventType();
                        while (true) {
                            if (eventType5 == 3 && xmlPullParser.getName().equals("PolyStyle")) {
                                break;
                            }
                            if (eventType5 == 2) {
                                if (xmlPullParser.getName().equals("color")) {
                                    String nextText3 = xmlPullParser.nextText();
                                    StringBuilder L3 = a2.b.a.a.a.L("#");
                                    L3.append(KmlStyle.a(nextText3));
                                    kmlStyle.setPolygonFillColor(Color.parseColor(L3.toString()));
                                    kmlStyle.b.add("fillColor");
                                } else if (xmlPullParser.getName().equals("outline")) {
                                    kmlStyle.d = KmlBoolean.parseBoolean(xmlPullParser.nextText());
                                    kmlStyle.b.add("outline");
                                } else if (xmlPullParser.getName().equals("fill")) {
                                    kmlStyle.setFill(KmlBoolean.parseBoolean(xmlPullParser.nextText()));
                                } else if (xmlPullParser.getName().equals("colorMode")) {
                                    kmlStyle.j = xmlPullParser.nextText().equals("random");
                                    kmlStyle.b.add("polyColorMode");
                                }
                            }
                            eventType5 = xmlPullParser.next();
                        }
                    } else if (xmlPullParser.getName().equals("BalloonStyle")) {
                        int eventType6 = xmlPullParser.getEventType();
                        while (true) {
                            if (eventType6 == 3 && xmlPullParser.getName().equals("BalloonStyle")) {
                                break;
                            }
                            if (eventType6 == 2 && xmlPullParser.getName().equals("text")) {
                                kmlStyle.a.put("text", xmlPullParser.nextText());
                            }
                            eventType6 = xmlPullParser.next();
                        }
                    }
                }
                eventType = xmlPullParser.next();
            }
        }

        public static boolean Y0(double d2) {
            return Math.getExponent(d2) <= 1023;
        }

        public static BodyPartID[] Y1(ASN1Sequence aSN1Sequence) {
            BodyPartID[] bodyPartIDArr = new BodyPartID[aSN1Sequence.size()];
            for (int i2 = 0; i2 != aSN1Sequence.size(); i2++) {
                bodyPartIDArr[i2] = BodyPartID.getInstance(aSN1Sequence.getObjectAt(i2));
            }
            return bodyPartIDArr;
        }

        public static HashMap<String, String> Z(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            HashMap<String, String> hashMap = new HashMap<>();
            Boolean bool = Boolean.FALSE;
            StringBuilder L = a2.b.a.a.a.L("#");
            L.append(xmlPullParser.getAttributeValue(null, "id"));
            String sb = L.toString();
            int eventType = xmlPullParser.getEventType();
            while (true) {
                if (eventType == 3 && xmlPullParser.getName().equals("StyleMap")) {
                    return hashMap;
                }
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("key") && xmlPullParser.nextText().equals("normal")) {
                        bool = Boolean.TRUE;
                    } else if (xmlPullParser.getName().equals("styleUrl") && bool.booleanValue()) {
                        hashMap.put(sb, xmlPullParser.nextText());
                        bool = Boolean.FALSE;
                    }
                }
                eventType = xmlPullParser.next();
            }
        }

        public static boolean Z0(byte[] bArr, int i2, int i3) {
            return w1(bArr, i2, i3) == 0;
        }

        public static byte[] Z1(ASN1Primitive aSN1Primitive) {
            try {
                return aSN1Primitive.getEncoded();
            } catch (IOException e2) {
                throw new x6.e.b.f.a(a2.b.a.a.a.A2(e2, a2.b.a.a.a.L("Cannot get encoding: ")), e2);
            }
        }

        public static a2.g.s.k a(Context context) {
            a2.g.s.k kVar;
            synchronized (i.class) {
                if (context == null) {
                    context = FacebookSdk.getApplicationContext();
                }
                if (context == null) {
                    kVar = null;
                } else {
                    if (m == null) {
                        m = new a2.g.s.k(context, FacebookSdk.getApplicationId());
                    }
                    kVar = m;
                }
            }
            return kVar;
        }

        public static String a0(String str) {
            return a2.b.a.a.a.f(".", str, ",.", str, " *");
        }

        public static boolean a1(Context context, Uri uri) {
            if (DocumentsContract.isDocumentUri(context, uri) && (F1(context, uri, "flags", 0) & 512) != 0) {
                return true;
            }
            return false;
        }

        public static String a2(@ColorInt int i2) {
            return Util.formatInvariant("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i2)), Integer.valueOf(Color.green(i2)), Integer.valueOf(Color.blue(i2)), Double.valueOf(((double) Color.alpha(i2)) / 255.0d));
        }

        public static Object b(Multiset.Entry entry) {
            if (entry == null) {
                return null;
            }
            return entry.getElement();
        }

        public static final <T> Flow<T> b0(Flow<? extends T> flow, Function1<? super T, Long> function1) {
            return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$debounceInternal$1(flow, function1, null));
        }

        public static boolean b1(byte[] bArr, int i2, int i3) {
            int min = Math.min(i3, bArr.length);
            for (int max = Math.max(i2, 0); max < min; max++) {
                if (bArr[max] == 1) {
                    return false;
                }
            }
            return true;
        }

        public static MTensor b2(MTensor mTensor) {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            MTensor mTensor2 = new MTensor(new int[]{shape2, shape});
            float[] data = mTensor.getData();
            float[] data2 = mTensor2.getData();
            for (int i2 = 0; i2 < shape; i2++) {
                for (int i3 = 0; i3 < shape2; i3++) {
                    data2[(i3 * shape) + i2] = data[(i2 * shape2) + i3];
                }
            }
            return mTensor2;
        }

        public static Set c(Set set, Object obj) {
            if (set instanceof SortedSet) {
                return new x4((SortedSet) set, obj);
            }
            return new u4(set, obj);
        }

        public static GF2Vector[] c0(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters, GF2Vector gF2Vector) {
            int k2 = mcElieceCCA2PrivateKeyParameters.getK();
            Permutation p = mcElieceCCA2PrivateKeyParameters.getP();
            GF2mField field = mcElieceCCA2PrivateKeyParameters.getField();
            PolynomialGF2mSmallM goppaPoly = mcElieceCCA2PrivateKeyParameters.getGoppaPoly();
            GF2Matrix h2 = mcElieceCCA2PrivateKeyParameters.getH();
            PolynomialGF2mSmallM[] qInv = mcElieceCCA2PrivateKeyParameters.getQInv();
            GF2Vector gF2Vector2 = (GF2Vector) gF2Vector.multiply(p.computeInverse());
            GF2Vector syndromeDecode = GoppaCode.syndromeDecode((GF2Vector) h2.rightMultiply(gF2Vector2), field, goppaPoly, qInv);
            return new GF2Vector[]{((GF2Vector) ((GF2Vector) gF2Vector2.add(syndromeDecode)).multiply(p)).extractRightVector(k2), (GF2Vector) syndromeDecode.multiply(p)};
        }

        public static boolean c1(byte[][] bArr, int i2, int i3, int i4) {
            int min = Math.min(i4, bArr.length);
            for (int max = Math.max(i3, 0); max < min; max++) {
                if (bArr[max][i2] == 1) {
                    return false;
                }
            }
            return true;
        }

        public static MTensor c2(MTensor mTensor) {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            int shape3 = mTensor.getShape(2);
            MTensor mTensor2 = new MTensor(new int[]{shape3, shape2, shape});
            float[] data = mTensor.getData();
            float[] data2 = mTensor2.getData();
            for (int i2 = 0; i2 < shape; i2++) {
                for (int i3 = 0; i3 < shape2; i3++) {
                    for (int i4 = 0; i4 < shape3; i4++) {
                        data2[a2.b.a.a.a.c2(i3, shape, i4 * shape * shape2, i2)] = data[a2.b.a.a.a.c2(i3, shape3, i2 * shape2 * shape3, i4)];
                    }
                }
            }
            return mTensor2;
        }

        public static Collection d(Collection collection, Object obj) {
            if (collection instanceof SortedSet) {
                return new x4((SortedSet) collection, obj);
            }
            if (collection instanceof Set) {
                return new u4((Set) collection, obj);
            }
            if (!(collection instanceof List)) {
                return new h4(collection, obj, null);
            }
            List list = (List) collection;
            return list instanceof RandomAccess ? new t4(list, obj) : new k4(list, obj);
        }

        public static MTensor d0(MTensor mTensor, MTensor mTensor2, MTensor mTensor3) {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor3.getShape(0);
            int shape3 = mTensor.getShape(0);
            int shape4 = mTensor2.getShape(0);
            int shape5 = mTensor2.getShape(1);
            MTensor mTensor4 = new MTensor(new int[]{shape3, shape5});
            float[] data = mTensor.getData();
            float[] data2 = mTensor2.getData();
            float[] data3 = mTensor4.getData();
            for (int i2 = 0; i2 < shape3; i2++) {
                for (int i3 = 0; i3 < shape5; i3++) {
                    int i4 = (i2 * shape5) + i3;
                    data3[i4] = 0.0f;
                    for (int i5 = 0; i5 < shape4; i5++) {
                        data3[i4] = (data[(i2 * shape4) + i5] * data2[(i5 * shape5) + i3]) + data3[i4];
                    }
                }
            }
            float[] data4 = mTensor3.getData();
            float[] data5 = mTensor4.getData();
            for (int i6 = 0; i6 < shape; i6++) {
                for (int i7 = 0; i7 < shape2; i7++) {
                    int i8 = (i6 * shape2) + i7;
                    data5[i8] = data5[i8] + data4[i7];
                }
            }
            return mTensor4;
        }

        public static XMSSNode d1(x6.e.f.a.d.c cVar, x6.e.f.a.d.f fVar, LTreeAddress lTreeAddress) {
            double d2;
            Objects.requireNonNull(lTreeAddress, "address == null");
            int i2 = cVar.a.e;
            byte[][] cloneArray = XMSSUtil.cloneArray(fVar.a);
            XMSSNode[] xMSSNodeArr = new XMSSNode[cloneArray.length];
            for (int i3 = 0; i3 < cloneArray.length; i3++) {
                xMSSNodeArr[i3] = new XMSSNode(0, cloneArray[i3]);
            }
            XMSSAddress build = ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress.getLayerAddress())).withTreeAddress(lTreeAddress.getTreeAddress())).withLTreeAddress(lTreeAddress.e).withTreeHeight(0).withTreeIndex(lTreeAddress.g).withKeyAndMask(lTreeAddress.getKeyAndMask())).build();
            while (true) {
                LTreeAddress lTreeAddress2 = (LTreeAddress) build;
                if (i2 <= 1) {
                    return xMSSNodeArr[0];
                }
                int i4 = 0;
                while (true) {
                    d2 = (double) (i2 / 2);
                    if (i4 >= ((int) Math.floor(d2))) {
                        break;
                    }
                    lTreeAddress2 = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress2.getLayerAddress())).withTreeAddress(lTreeAddress2.getTreeAddress())).withLTreeAddress(lTreeAddress2.e).withTreeHeight(lTreeAddress2.f).withTreeIndex(i4).withKeyAndMask(lTreeAddress2.getKeyAndMask())).build();
                    int i5 = i4 * 2;
                    xMSSNodeArr[i4] = H1(cVar, xMSSNodeArr[i5], xMSSNodeArr[i5 + 1], lTreeAddress2);
                    i4++;
                }
                if (i2 % 2 == 1) {
                    xMSSNodeArr[(int) Math.floor(d2)] = xMSSNodeArr[i2 - 1];
                }
                i2 = (int) Math.ceil(((double) i2) / 2.0d);
                build = ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress2.getLayerAddress())).withTreeAddress(lTreeAddress2.getTreeAddress())).withLTreeAddress(lTreeAddress2.e).withTreeHeight(lTreeAddress2.f + 1).withTreeIndex(lTreeAddress2.g).withKeyAndMask(lTreeAddress2.getKeyAndMask())).build();
            }
        }

        public static <T> boolean d2(Object obj, Function<? super T, ? extends CompletableSource> function, CompletableObserver completableObserver) {
            if (!(obj instanceof Callable)) {
                return false;
            }
            CompletableSource completableSource = null;
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                if (obj2 != 0) {
                    completableSource = (CompletableSource) ObjectHelper.requireNonNull(function.apply(obj2), "The mapper returned a null CompletableSource");
                }
                if (completableSource == null) {
                    EmptyDisposable.complete(completableObserver);
                } else {
                    completableSource.subscribe(completableObserver);
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, completableObserver);
                return true;
            }
        }

        public static Collection e(Collection collection, Object obj) {
            return new h4(collection, obj, null);
        }

        public static int e0(Context context, int i2) {
            return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
        }

        public static final <T> void e1(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Flow<? extends T> flow, MutableSharedFlow<T> mutableSharedFlow, SharingStarted sharingStarted, T t) {
            BuildersKt.launch$default(coroutineScope, coroutineContext, null, new k0(sharingStarted, flow, mutableSharedFlow, t, null), 2, null);
        }

        public static <T> boolean e2(Object obj, io.reactivex.rxjava3.functions.Function<? super T, ? extends io.reactivex.rxjava3.core.CompletableSource> function, io.reactivex.rxjava3.core.CompletableObserver completableObserver) {
            if (!(obj instanceof Supplier)) {
                return false;
            }
            io.reactivex.rxjava3.core.CompletableSource completableSource = null;
            try {
                Object obj2 = (Object) ((Supplier) obj).get();
                if (obj2 != 0) {
                    Object apply = function.apply(obj2);
                    Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                    completableSource = (io.reactivex.rxjava3.core.CompletableSource) apply;
                }
                if (completableSource == null) {
                    io.reactivex.rxjava3.internal.disposables.EmptyDisposable.complete(completableObserver);
                } else {
                    completableSource.subscribe(completableObserver);
                }
                return true;
            } catch (Throwable th) {
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.rxjava3.internal.disposables.EmptyDisposable.error(th, completableObserver);
                return true;
            }
        }

        public static Map.Entry f(Map.Entry entry, Object obj) {
            if (entry == null) {
                return null;
            }
            return new j4(entry, obj);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final /* synthetic */ <T> java.lang.Object f0(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r4, T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
            /*
                boolean r0 = r6 instanceof u6.a.j0.w
                if (r0 == 0) goto L_0x0013
                r0 = r6
                u6.a.j0.w r0 = (u6.a.j0.w) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.b = r1
                goto L_0x0018
            L_0x0013:
                u6.a.j0.w r0 = new u6.a.j0.w
                r0.<init>(r6)
            L_0x0018:
                java.lang.Object r6 = r0.a
                java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                int r2 = r0.b
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 == r3) goto L_0x002d
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L_0x002d:
                java.lang.Object r4 = r0.c
                kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                kotlin.ResultKt.throwOnFailure(r6)
                goto L_0x0045
            L_0x0035:
                kotlin.ResultKt.throwOnFailure(r6)
                r0.c = r4
                r0.d = r5
                r0.b = r3
                java.lang.Object r5 = r4.emit(r5, r0)
                if (r5 != r1) goto L_0x0045
                return r1
            L_0x0045:
                kotlinx.coroutines.flow.internal.AbortFlowException r5 = new kotlinx.coroutines.flow.internal.AbortFlowException
                r5.<init>(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.i.f0(kotlinx.coroutines.flow.FlowCollector, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public static l6.n.a.f f1(@NonNull Context context, @NonNull FragmentContainer fragmentContainer, @NonNull Fragment fragment, boolean z) {
            int i2;
            int nextTransition = fragment.getNextTransition();
            int nextAnim = fragment.getNextAnim();
            boolean z2 = false;
            fragment.setNextAnim(0);
            View onFindViewById = fragmentContainer.onFindViewById(fragment.mContainerId);
            if (onFindViewById != null) {
                int i3 = androidx.fragment.R.id.visible_removing_fragment_view_tag;
                if (onFindViewById.getTag(i3) != null) {
                    onFindViewById.setTag(i3, null);
                }
            }
            ViewGroup viewGroup = fragment.mContainer;
            if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
                return null;
            }
            Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, nextAnim);
            if (onCreateAnimation != null) {
                return new l6.n.a.f(onCreateAnimation);
            }
            Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, nextAnim);
            if (onCreateAnimator != null) {
                return new l6.n.a.f(onCreateAnimator);
            }
            if (nextAnim != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                        if (loadAnimation != null) {
                            return new l6.n.a.f(loadAnimation);
                        }
                        z2 = true;
                    } catch (Resources.NotFoundException e2) {
                        throw e2;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z2) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                        if (loadAnimator != null) {
                            return new l6.n.a.f(loadAnimator);
                        }
                    } catch (RuntimeException e3) {
                        if (!equals) {
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                            if (loadAnimation2 != null) {
                                return new l6.n.a.f(loadAnimation2);
                            }
                        } else {
                            throw e3;
                        }
                    }
                }
            }
            if (nextTransition == 0) {
                return null;
            }
            if (nextTransition != 4097) {
                i2 = nextTransition != 4099 ? nextTransition != 8194 ? -1 : z ? androidx.fragment.R.anim.fragment_close_enter : androidx.fragment.R.anim.fragment_close_exit : z ? androidx.fragment.R.anim.fragment_fade_enter : androidx.fragment.R.anim.fragment_fade_exit;
            } else {
                i2 = z ? androidx.fragment.R.anim.fragment_open_enter : androidx.fragment.R.anim.fragment_open_exit;
            }
            if (i2 < 0) {
                return null;
            }
            return new l6.n.a.f(AnimationUtils.loadAnimation(context, i2));
        }

        public static <T, R> boolean f2(Object obj, Function<? super T, ? extends MaybeSource<? extends R>> function, Observer<? super R> observer) {
            if (!(obj instanceof Callable)) {
                return false;
            }
            MaybeSource maybeSource = null;
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                if (obj2 != 0) {
                    maybeSource = (MaybeSource) ObjectHelper.requireNonNull(function.apply(obj2), "The mapper returned a null MaybeSource");
                }
                if (maybeSource == null) {
                    EmptyDisposable.complete(observer);
                } else {
                    maybeSource.subscribe(MaybeToObservable.create(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return true;
            }
        }

        public static <T> ArrayList<T> g(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0089  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final /* synthetic */ <T> java.lang.Object g0(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r8, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends T> r9, boolean r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
            /*
                boolean r0 = r11 instanceof u6.a.j0.f
                if (r0 == 0) goto L_0x0013
                r0 = r11
                u6.a.j0.f r0 = (u6.a.j0.f) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.b = r1
                goto L_0x0018
            L_0x0013:
                u6.a.j0.f r0 = new u6.a.j0.f
                r0.<init>(r11)
            L_0x0018:
                java.lang.Object r11 = r0.a
                java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                int r2 = r0.b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x005f
                if (r2 == r4) goto L_0x0047
                if (r2 != r3) goto L_0x003f
                java.lang.Object r8 = r0.e
                java.lang.Throwable r8 = (java.lang.Throwable) r8
                boolean r9 = r0.g
                java.lang.Object r10 = r0.d
                kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
                java.lang.Object r2 = r0.c
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x005d }
            L_0x0039:
                r11 = r8
                r8 = r2
                r6 = r10
                r10 = r9
                r9 = r6
                goto L_0x0063
            L_0x003f:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L_0x0047:
                java.lang.Object r8 = r0.f
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                java.lang.Object r8 = r0.e
                java.lang.Throwable r8 = (java.lang.Throwable) r8
                boolean r9 = r0.g
                java.lang.Object r10 = r0.d
                kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
                java.lang.Object r2 = r0.c
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x007d
            L_0x005d:
                r8 = move-exception
                goto L_0x00ad
            L_0x005f:
                kotlin.ResultKt.throwOnFailure(r11)
                r11 = 0
            L_0x0063:
                r0.c = r8     // Catch:{ all -> 0x00a9 }
                r0.d = r9     // Catch:{ all -> 0x00a9 }
                r0.g = r10     // Catch:{ all -> 0x00a9 }
                r0.e = r11     // Catch:{ all -> 0x00a9 }
                r0.f = r8     // Catch:{ all -> 0x00a9 }
                r0.b = r4     // Catch:{ all -> 0x00a9 }
                java.lang.Object r2 = r9.mo500receiveOrClosedZYPwvRU(r0)     // Catch:{ all -> 0x00a9 }
                if (r2 != r1) goto L_0x0076
                return r1
            L_0x0076:
                r6 = r2
                r2 = r8
                r8 = r11
                r11 = r6
                r7 = r10
                r10 = r9
                r9 = r7
            L_0x007d:
                boolean r5 = kotlinx.coroutines.channels.ValueOrClosed.m509isClosedimpl(r11)
                if (r5 == 0) goto L_0x0092
                java.lang.Throwable r11 = kotlinx.coroutines.channels.ValueOrClosed.m505getCloseCauseimpl(r11)
                if (r11 != 0) goto L_0x0091
                if (r9 == 0) goto L_0x008e
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r8)
            L_0x008e:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            L_0x0091:
                throw r11
            L_0x0092:
                java.lang.Object r5 = kotlinx.coroutines.channels.ValueOrClosed.m506getValueimpl(r11)
                r0.c = r2
                r0.d = r10
                r0.g = r9
                r0.e = r8
                r0.f = r11
                r0.b = r3
                java.lang.Object r11 = r2.emit(r5, r0)
                if (r11 != r1) goto L_0x0039
                return r1
            L_0x00a9:
                r8 = move-exception
                r6 = r10
                r10 = r9
                r9 = r6
            L_0x00ad:
                throw r8     // Catch:{ all -> 0x00ae }
            L_0x00ae:
                r11 = move-exception
                if (r9 == 0) goto L_0x00b4
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r8)
            L_0x00b4:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.i.g0(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public static int g1(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
            int i3;
            int i4;
            if (i2 == 17) {
                i4 = rect.left;
                i3 = rect2.right;
            } else if (i2 == 33) {
                i4 = rect.top;
                i3 = rect2.bottom;
            } else if (i2 == 66) {
                i4 = rect2.left;
                i3 = rect.right;
            } else if (i2 == 130) {
                i4 = rect2.top;
                i3 = rect.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            return Math.max(0, i4 - i3);
        }

        public static <T, R> boolean g2(Object obj, io.reactivex.rxjava3.functions.Function<? super T, ? extends io.reactivex.rxjava3.core.MaybeSource<? extends R>> function, io.reactivex.rxjava3.core.Observer<? super R> observer) {
            if (!(obj instanceof Supplier)) {
                return false;
            }
            io.reactivex.rxjava3.core.MaybeSource maybeSource = null;
            try {
                Object obj2 = (Object) ((Supplier) obj).get();
                if (obj2 != 0) {
                    Object apply = function.apply(obj2);
                    Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                    maybeSource = (io.reactivex.rxjava3.core.MaybeSource) apply;
                }
                if (maybeSource == null) {
                    io.reactivex.rxjava3.internal.disposables.EmptyDisposable.complete(observer);
                } else {
                    maybeSource.subscribe(io.reactivex.rxjava3.internal.operators.maybe.MaybeToObservable.create(observer));
                }
                return true;
            } catch (Throwable th) {
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.rxjava3.internal.disposables.EmptyDisposable.error(th, observer);
                return true;
            }
        }

        public static void h(MTensor mTensor, MTensor mTensor2) {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            int shape3 = mTensor.getShape(2);
            float[] data = mTensor.getData();
            float[] data2 = mTensor2.getData();
            for (int i2 = 0; i2 < shape; i2++) {
                for (int i3 = 0; i3 < shape2; i3++) {
                    for (int i4 = 0; i4 < shape3; i4++) {
                        int c2 = a2.b.a.a.a.c2(i3, shape3, i2 * shape2 * shape3, i4);
                        data[c2] = data[c2] + data2[i4];
                    }
                }
            }
        }

        @SuppressLint({"SoonBlockedPrivateApi"})
        public static void h0(@NonNull Canvas canvas, boolean z) {
            Method method;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                if (z) {
                    canvas.enableZ();
                } else {
                    canvas.disableZ();
                }
            } else if (i2 != 28) {
                if (!k) {
                    try {
                        Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                        i = declaredMethod;
                        declaredMethod.setAccessible(true);
                        Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                        j = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                    }
                    k = true;
                }
                if (z) {
                    try {
                        Method method2 = i;
                        if (method2 != null) {
                            method2.invoke(canvas, new Object[0]);
                        }
                    } catch (IllegalAccessException unused2) {
                        return;
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException(e2.getCause());
                    }
                }
                if (!z && (method = j) != null) {
                    method.invoke(canvas, new Object[0]);
                }
            } else {
                throw new IllegalStateException("This method doesn't work on Pie!");
            }
        }

        public static MTensor h1(MTensor mTensor, int i2) {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            int shape3 = mTensor.getShape(2);
            int i3 = (shape2 - i2) + 1;
            MTensor mTensor2 = new MTensor(new int[]{shape, i3, shape3});
            float[] data = mTensor.getData();
            float[] data2 = mTensor2.getData();
            for (int i4 = 0; i4 < shape; i4++) {
                for (int i5 = 0; i5 < shape3; i5++) {
                    for (int i6 = 0; i6 < i3; i6++) {
                        int i7 = i6 * shape3;
                        int i8 = (i4 * i3 * shape3) + i7 + i5;
                        int i9 = (i4 * shape2 * shape3) + i7 + i5;
                        data2[i8] = Float.MIN_VALUE;
                        for (int i10 = 0; i10 < i2; i10++) {
                            data2[i8] = Math.max(data2[i8], data[(i10 * shape3) + i9]);
                        }
                    }
                }
            }
            return mTensor2;
        }

        public static <T, R> boolean h2(Object obj, Function<? super T, ? extends SingleSource<? extends R>> function, Observer<? super R> observer) {
            if (!(obj instanceof Callable)) {
                return false;
            }
            SingleSource singleSource = null;
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                if (obj2 != 0) {
                    singleSource = (SingleSource) ObjectHelper.requireNonNull(function.apply(obj2), "The mapper returned a null SingleSource");
                }
                if (singleSource == null) {
                    EmptyDisposable.complete(observer);
                } else {
                    singleSource.subscribe(SingleToObservable.create(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return true;
            }
        }

        public static int i(ByteMatrix byteMatrix, boolean z) {
            int height = z ? byteMatrix.getHeight() : byteMatrix.getWidth();
            int width = z ? byteMatrix.getWidth() : byteMatrix.getHeight();
            byte[][] array = byteMatrix.getArray();
            int i2 = 0;
            for (int i3 = 0; i3 < height; i3++) {
                byte b2 = -1;
                int i4 = 0;
                for (int i5 = 0; i5 < width; i5++) {
                    byte b3 = z ? array[i3][i5] : array[i5][i3];
                    if (b3 == b2) {
                        i4++;
                    } else {
                        if (i4 >= 5) {
                            i2 += (i4 - 5) + 3;
                        }
                        b2 = b3;
                        i4 = 1;
                    }
                }
                if (i4 >= 5) {
                    i2 = (i4 - 5) + 3 + i2;
                }
            }
            return i2;
        }

        public static GF2Vector i0(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters, GF2Vector gF2Vector, GF2Vector gF2Vector2) {
            return (GF2Vector) mcElieceCCA2PublicKeyParameters.getG().leftMultiplyLeftCompactForm(gF2Vector).add(gF2Vector2);
        }

        public static double i1(double d2) {
            return Math.log(Math.tan((d2 * 0.5d) + 0.7853981633974483d));
        }

        public static <T, R> boolean i2(Object obj, io.reactivex.rxjava3.functions.Function<? super T, ? extends io.reactivex.rxjava3.core.SingleSource<? extends R>> function, io.reactivex.rxjava3.core.Observer<? super R> observer) {
            if (!(obj instanceof Supplier)) {
                return false;
            }
            io.reactivex.rxjava3.core.SingleSource singleSource = null;
            try {
                Object obj2 = (Object) ((Supplier) obj).get();
                if (obj2 != 0) {
                    Object apply = function.apply(obj2);
                    Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                    singleSource = (io.reactivex.rxjava3.core.SingleSource) apply;
                }
                if (singleSource == null) {
                    io.reactivex.rxjava3.internal.disposables.EmptyDisposable.complete(observer);
                } else {
                    singleSource.subscribe(io.reactivex.rxjava3.internal.operators.single.SingleToObservable.create(observer));
                }
                return true;
            } catch (Throwable th) {
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.rxjava3.internal.disposables.EmptyDisposable.error(th, observer);
                return true;
            }
        }

        public static KmlContainer j(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            String name = xmlPullParser.getName();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            ArrayList arrayList = new ArrayList();
            HashMap hashMap4 = new HashMap();
            HashMap hashMap5 = new HashMap();
            String attributeValue = xmlPullParser.getAttributeValue(null, "id") != null ? xmlPullParser.getAttributeValue(null, "id") : null;
            xmlPullParser.next();
            int eventType = xmlPullParser.getEventType();
            while (true) {
                int i2 = 3;
                if (eventType == 3 && xmlPullParser.getName().equals(name)) {
                    return new KmlContainer(hashMap, hashMap2, hashMap3, hashMap4, arrayList, hashMap5, attributeValue);
                }
                if (eventType == 2) {
                    if (xmlPullParser.getName().matches("altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when")) {
                        a2.j.g.a.a.b.a.a(xmlPullParser);
                    } else if (xmlPullParser.getName().matches("Folder|Document")) {
                        arrayList.add(j(xmlPullParser));
                    } else if (xmlPullParser.getName().matches("name|description|visibility|open|address|phoneNumber")) {
                        hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("StyleMap")) {
                        hashMap4.putAll(Z(xmlPullParser));
                    } else if (xmlPullParser.getName().equals("Style")) {
                        if (xmlPullParser.getAttributeValue(null, "id") != null) {
                            KmlStyle Y = Y(xmlPullParser);
                            hashMap2.put(Y.g, Y);
                        }
                    } else if (xmlPullParser.getName().equals("Placemark")) {
                        hashMap3.put(X(xmlPullParser), null);
                    } else if (xmlPullParser.getName().equals("ExtendedData")) {
                        int eventType2 = xmlPullParser.getEventType();
                        String str = null;
                        while (true) {
                            if (eventType2 == i2 && xmlPullParser.getName().equals("ExtendedData")) {
                                break;
                            }
                            if (eventType2 == 2) {
                                if (xmlPullParser.getName().equals("Data")) {
                                    str = xmlPullParser.getAttributeValue(null, "name");
                                } else if (xmlPullParser.getName().equals("value") && str != null) {
                                    hashMap.put(str, xmlPullParser.nextText());
                                    str = null;
                                }
                            }
                            eventType2 = xmlPullParser.next();
                            i2 = 3;
                        }
                    } else if (xmlPullParser.getName().equals("GroundOverlay")) {
                        hashMap5.put(W(xmlPullParser), null);
                    }
                }
                eventType = xmlPullParser.next();
            }
        }

        public static double j0(double d2) {
            Preconditions.checkArgument(!Double.isNaN(d2));
            if (d2 > 0.0d) {
                return d2;
            }
            return 0.0d;
        }

        public static int j1(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
            if (i2 != 17) {
                if (i2 != 33) {
                    if (i2 != 66) {
                        if (i2 != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
            }
            return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
        }

        public static <R> Observable<R> j2(Plan<R>... planArr) {
            Objects.requireNonNull(planArr, "plans");
            List asList = java.util.Arrays.asList(planArr);
            Objects.requireNonNull(asList, "plans");
            return new n(asList);
        }

        public static short k(short s) {
            int i2 = s & UShort.MAX_VALUE;
            return (short) (i2 - (((i2 * 5) >>> 16) * 12289));
        }

        public static String k0(ByteString byteString) {
            StringBuilder sb = new StringBuilder(byteString.size());
            for (int i2 = 0; i2 < byteString.size(); i2++) {
                byte byteAt = byteString.byteAt(i2);
                if (byteAt == 34) {
                    sb.append("\\\"");
                } else if (byteAt == 39) {
                    sb.append("\\'");
                } else if (byteAt != 92) {
                    switch (byteAt) {
                        case 7:
                            sb.append("\\a");
                            continue;
                        case 8:
                            sb.append("\\b");
                            continue;
                        case 9:
                            sb.append("\\t");
                            continue;
                        case 10:
                            sb.append("\\n");
                            continue;
                        case 11:
                            sb.append("\\v");
                            continue;
                        case 12:
                            sb.append("\\f");
                            continue;
                        case 13:
                            sb.append("\\r");
                            continue;
                        default:
                            if (byteAt < 32 || byteAt > 126) {
                                sb.append('\\');
                                sb.append((char) (((byteAt >>> 6) & 3) + 48));
                                sb.append((char) (((byteAt >>> 3) & 7) + 48));
                                sb.append((char) ((byteAt & 7) + 48));
                                break;
                            } else {
                                sb.append((char) byteAt);
                                continue;
                            }
                            break;
                    }
                } else {
                    sb.append("\\\\");
                }
            }
            return sb.toString();
        }

        public static short k1(int i2) {
            return (short) (((((i2 * 12287) & 262143) * 12289) + i2) >>> 18);
        }

        @SafeVarargs
        public static <R> io.reactivex.rxjava3.core.Observable<R> k2(hu.akarnokd.rxjava3.joins.Plan<R>... planArr) {
            Objects.requireNonNull(planArr, "plans");
            List asList = java.util.Arrays.asList(planArr);
            Objects.requireNonNull(asList, "plans");
            return new r6.a.b.g.n(asList);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
            if (r10.right <= r12.left) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
            if (r10.top >= r12.bottom) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
            if (r10.left >= r12.right) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (r10.bottom <= r12.top) goto L_0x0043;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean l(int r9, @androidx.annotation.NonNull android.graphics.Rect r10, @androidx.annotation.NonNull android.graphics.Rect r11, @androidx.annotation.NonNull android.graphics.Rect r12) {
            /*
                boolean r0 = m(r9, r10, r11)
                boolean r1 = m(r9, r10, r12)
                r2 = 0
                if (r1 != 0) goto L_0x007d
                if (r0 != 0) goto L_0x000f
                goto L_0x007d
            L_0x000f:
                java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
                r1 = 130(0x82, float:1.82E-43)
                r3 = 33
                r4 = 66
                r5 = 17
                r6 = 1
                if (r9 == r5) goto L_0x003d
                if (r9 == r3) goto L_0x0036
                if (r9 == r4) goto L_0x002f
                if (r9 != r1) goto L_0x0029
                int r7 = r10.bottom
                int r8 = r12.top
                if (r7 > r8) goto L_0x0045
                goto L_0x0043
            L_0x0029:
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r0)
                throw r9
            L_0x002f:
                int r7 = r10.right
                int r8 = r12.left
                if (r7 > r8) goto L_0x0045
                goto L_0x0043
            L_0x0036:
                int r7 = r10.top
                int r8 = r12.bottom
                if (r7 < r8) goto L_0x0045
                goto L_0x0043
            L_0x003d:
                int r7 = r10.left
                int r8 = r12.right
                if (r7 < r8) goto L_0x0045
            L_0x0043:
                r7 = 1
                goto L_0x0046
            L_0x0045:
                r7 = 0
            L_0x0046:
                if (r7 != 0) goto L_0x0049
                return r6
            L_0x0049:
                if (r9 == r5) goto L_0x007c
                if (r9 != r4) goto L_0x004e
                goto L_0x007c
            L_0x004e:
                int r11 = g1(r9, r10, r11)
                if (r9 == r5) goto L_0x006f
                if (r9 == r3) goto L_0x006a
                if (r9 == r4) goto L_0x0065
                if (r9 != r1) goto L_0x005f
                int r9 = r12.bottom
                int r10 = r10.bottom
                goto L_0x0073
            L_0x005f:
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r0)
                throw r9
            L_0x0065:
                int r9 = r12.right
                int r10 = r10.right
                goto L_0x0073
            L_0x006a:
                int r9 = r10.top
                int r10 = r12.top
                goto L_0x0073
            L_0x006f:
                int r9 = r10.left
                int r10 = r12.left
            L_0x0073:
                int r9 = r9 - r10
                int r9 = java.lang.Math.max(r6, r9)
                if (r11 >= r9) goto L_0x007b
                r2 = 1
            L_0x007b:
                return r2
            L_0x007c:
                return r6
            L_0x007d:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.i.l(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
        }

        public static boolean l0(Context context, Uri uri) {
            ContentResolver contentResolver = context.getContentResolver();
            boolean z = false;
            Cursor cursor = null;
            try {
                cursor = contentResolver.query(uri, new String[]{"document_id"}, null, null, null);
                if (cursor.getCount() > 0) {
                    z = true;
                }
                return z;
            } catch (Exception e2) {
                String str = "Failed query: " + e2;
                return false;
            } finally {
                I(cursor);
            }
        }

        public static boolean l1(int i2, int i3, double d2) {
            return ((double) i2) > d2 * ((double) i3) && i3 < 1073741824;
        }

        public static double l2(double d2, double d3, double d4) {
            if (d2 >= d3 && d2 < d4) {
                return d2;
            }
            double d5 = d4 - d3;
            return ((((d2 - d3) % d5) + d5) % d5) + d3;
        }

        public static boolean m(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
            if (i2 != 17) {
                if (i2 != 33) {
                    if (i2 != 66) {
                        if (i2 != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                if (rect2.right < rect.left || rect2.left > rect.right) {
                    return false;
                }
                return true;
            }
            if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
                return false;
            }
            return true;
        }

        public static void m0(MTensor mTensor, int i2) {
            if (i2 < mTensor.getShapeSize()) {
                int i3 = 1;
                for (int i4 = i2; i4 < mTensor.getShapeSize(); i4++) {
                    i3 *= mTensor.getShape(i4);
                }
                int[] iArr = new int[(i2 + 1)];
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr[i5] = mTensor.getShape(i5);
                }
                iArr[i2] = i3;
                mTensor.reshape(iArr);
            }
        }

        @Nullable
        @RequiresApi(29)
        public static BlendMode m1(@NonNull BlendModeCompat blendModeCompat) {
            switch (blendModeCompat.ordinal()) {
                case 0:
                    return BlendMode.CLEAR;
                case 1:
                    return BlendMode.SRC;
                case 2:
                    return BlendMode.DST;
                case 3:
                    return BlendMode.SRC_OVER;
                case 4:
                    return BlendMode.DST_OVER;
                case 5:
                    return BlendMode.SRC_IN;
                case 6:
                    return BlendMode.DST_IN;
                case 7:
                    return BlendMode.SRC_OUT;
                case 8:
                    return BlendMode.DST_OUT;
                case 9:
                    return BlendMode.SRC_ATOP;
                case 10:
                    return BlendMode.DST_ATOP;
                case 11:
                    return BlendMode.XOR;
                case 12:
                    return BlendMode.PLUS;
                case 13:
                    return BlendMode.MODULATE;
                case 14:
                    return BlendMode.SCREEN;
                case 15:
                    return BlendMode.OVERLAY;
                case 16:
                    return BlendMode.DARKEN;
                case 17:
                    return BlendMode.LIGHTEN;
                case 18:
                    return BlendMode.COLOR_DODGE;
                case 19:
                    return BlendMode.COLOR_BURN;
                case 20:
                    return BlendMode.HARD_LIGHT;
                case 21:
                    return BlendMode.SOFT_LIGHT;
                case 22:
                    return BlendMode.DIFFERENCE;
                case 23:
                    return BlendMode.EXCLUSION;
                case 24:
                    return BlendMode.MULTIPLY;
                case 25:
                    return BlendMode.HUE;
                case 26:
                    return BlendMode.SATURATION;
                case 27:
                    return BlendMode.COLOR;
                case 28:
                    return BlendMode.LUMINOSITY;
                default:
                    return null;
            }
        }

        public static void m2(OutputStream outputStream, JSONObject jSONObject) throws IOException {
            byte[] bytes = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
        }

        public static <E, K extends Comparable> int n(List<E> list, com.google.common.base.Function<? super E, K> function, @NullableDecl K k2, t3 t3Var, s3 s3Var) {
            return o(list, function, k2, Ordering.natural(), t3Var, s3Var);
        }

        @RequiresApi(16)
        public static void n0(@NonNull Object obj) {
            if (!d) {
                try {
                    c = Class.forName("android.content.res.ThemedResourceCache");
                } catch (ClassNotFoundException unused) {
                }
                d = true;
            }
            Class<?> cls = c;
            if (cls != null) {
                if (!f) {
                    try {
                        Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                        e = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused2) {
                    }
                    f = true;
                }
                Field field = e;
                if (field != null) {
                    LongSparseArray longSparseArray = null;
                    try {
                        longSparseArray = (LongSparseArray) field.get(obj);
                    } catch (IllegalAccessException unused3) {
                    }
                    if (longSparseArray != null) {
                        longSparseArray.clear();
                    }
                }
            }
        }

        @Nullable
        public static PorterDuff.Mode n1(@Nullable BlendModeCompat blendModeCompat) {
            if (blendModeCompat == null) {
                return null;
            }
            switch (blendModeCompat.ordinal()) {
                case 0:
                    return PorterDuff.Mode.CLEAR;
                case 1:
                    return PorterDuff.Mode.SRC;
                case 2:
                    return PorterDuff.Mode.DST;
                case 3:
                    return PorterDuff.Mode.SRC_OVER;
                case 4:
                    return PorterDuff.Mode.DST_OVER;
                case 5:
                    return PorterDuff.Mode.SRC_IN;
                case 6:
                    return PorterDuff.Mode.DST_IN;
                case 7:
                    return PorterDuff.Mode.SRC_OUT;
                case 8:
                    return PorterDuff.Mode.DST_OUT;
                case 9:
                    return PorterDuff.Mode.SRC_ATOP;
                case 10:
                    return PorterDuff.Mode.DST_ATOP;
                case 11:
                    return PorterDuff.Mode.XOR;
                case 12:
                    return PorterDuff.Mode.ADD;
                case 13:
                    return PorterDuff.Mode.MULTIPLY;
                case 14:
                    return PorterDuff.Mode.SCREEN;
                case 15:
                    return PorterDuff.Mode.OVERLAY;
                case 16:
                    return PorterDuff.Mode.DARKEN;
                case 17:
                    return PorterDuff.Mode.LIGHTEN;
                default:
                    return null;
            }
        }

        public static final void n2(List list, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
            xmlSerializer.startTag(null, "list");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                w2(list.get(i2), null, xmlSerializer, null);
            }
            xmlSerializer.endTag(null, "list");
        }

        public static <E, K> int o(List<E> list, com.google.common.base.Function<? super E, K> function, @NullableDecl K k2, Comparator<? super K> comparator, t3 t3Var, s3 s3Var) {
            List transform = Lists.transform(list, function);
            Preconditions.checkNotNull(comparator);
            Preconditions.checkNotNull(transform);
            Preconditions.checkNotNull(t3Var);
            Preconditions.checkNotNull(s3Var);
            if (!(transform instanceof RandomAccess)) {
                transform = Lists.newArrayList(transform);
            }
            int i2 = 0;
            int size = transform.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                int compare = comparator.compare(k2, (Object) transform.get(i3));
                if (compare < 0) {
                    size = i3 - 1;
                } else if (compare <= 0) {
                    return t3Var.a(comparator, k2, transform.subList(i2, size + 1), i3 - i2) + i2;
                } else {
                    i2 = i3 + 1;
                }
            }
            return s3Var.a(i2);
        }

        public static void o0(short[] sArr, byte[] bArr) {
            SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
            sHAKEDigest.update(bArr, 0, bArr.length);
            int i2 = 0;
            while (true) {
                byte[] bArr2 = new byte[256];
                sHAKEDigest.doOutput(bArr2, 0, 256);
                int i3 = 0;
                while (true) {
                    if (i3 < 256) {
                        int i4 = ((bArr2[i3] & 255) | ((bArr2[i3 + 1] & 255) << 8)) & 16383;
                        if (i4 < 12289) {
                            int i5 = i2 + 1;
                            sArr[i2] = (short) i4;
                            if (i5 != 1024) {
                                i2 = i5;
                            } else {
                                return;
                            }
                        }
                        i3 += 2;
                    }
                }
            }
        }

        public static <T> ObjectAnimator o1(T t, Property<T, PointF> property, Path path) {
            return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
        }

        public static final void o2(List list, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
            xmlSerializer.startTag(null, "list");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                x2(list.get(i2), null, xmlSerializer, null);
            }
            xmlSerializer.endTag(null, "list");
        }

        public static final String p(String str) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt)) {
                    sb.append("_");
                }
                sb.append(Character.toLowerCase(charAt));
            }
            return sb.toString();
        }

        public static BigInteger p0(BigInteger bigInteger, SecureRandom secureRandom) {
            int bitLength = bigInteger.bitLength();
            while (true) {
                BigInteger bigInteger2 = new BigInteger(bitLength, secureRandom);
                if (!bigInteger2.equals(ECConstants.ZERO) && bigInteger2.compareTo(bigInteger) < 0) {
                    return bigInteger2;
                }
            }
        }

        public static InputConnection p1(InputConnection inputConnection, EditorInfo editorInfo, View view) {
            if (inputConnection != null && editorInfo.hintText == null) {
                ViewParent parent = view.getParent();
                while (true) {
                    if (!(parent instanceof View)) {
                        break;
                    } else if (parent instanceof WithHint) {
                        editorInfo.hintText = ((WithHint) parent).getHint();
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            return inputConnection;
        }

        public static <K, V> void p2(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(map.size());
            for (Map.Entry<K, V> entry : map.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
        }

        public static boolean q(Context context, Uri uri) {
            return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(G1(context, uri, "mime_type", null));
        }

        public static AsymmetricKeyParameter q0(PublicKey publicKey) throws InvalidKeyException {
            if (publicKey instanceof BCECPublicKey) {
                return ((BCECPublicKey) publicKey).c;
            }
            return ECUtil.generatePublicKeyParameter(publicKey);
        }

        public static void q1(View view, Runnable runnable) {
            if (ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0) {
                runnable.run();
                return;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new a2.h.a.e(viewTreeObserver, view, runnable));
        }

        public static final void q2(Map map, OutputStream outputStream) throws XmlPullParserException, IOException {
            a2.f.a.a.i.a.g.a.a aVar = new a2.f.a.a.i.a.g.a.a();
            aVar.setOutput(outputStream, "utf-8");
            aVar.startDocument(null, Boolean.TRUE);
            aVar.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            r2(map, null, aVar);
            aVar.flush();
        }

        public static boolean r(Context context, Uri uri) {
            if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
                return false;
            }
            String G1 = G1(context, uri, "mime_type", null);
            int F1 = (int) F1(context, uri, "flags", (long) 0);
            if (TextUtils.isEmpty(G1)) {
                return false;
            }
            if ((F1 & 4) != 0) {
                return true;
            }
            if ("vnd.android.document/directory".equals(G1) && (F1 & 8) != 0) {
                return true;
            }
            if (TextUtils.isEmpty(G1) || (F1 & 2) == 0) {
                return false;
            }
            return true;
        }

        @Nullable
        public static byte[] r0(Signature signature) {
            try {
                return MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }

        public static final Throwable r1(Throwable th, Job job) {
            return th != null ? th : new JobCancellationException("Job was cancelled", null, job);
        }

        public static final void r2(Map map, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
            if (map == null) {
                xmlSerializer.startTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
                xmlSerializer.endTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
                return;
            }
            xmlSerializer.startTag(null, "map");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            for (Map.Entry entry : map.entrySet()) {
                w2(entry.getValue(), (String) entry.getKey(), xmlSerializer, null);
            }
            xmlSerializer.endTag(null, "map");
        }

        public static void s(Object obj, Object obj2) {
            if (obj == null) {
                throw new NullPointerException(a2.b.a.a.a.b3("null key in entry: null=", obj2));
            } else if (obj2 == null) {
                throw new NullPointerException("null value in entry: " + obj + "=null");
            }
        }

        public static String s0(long j2) {
            return t0(j2, null);
        }

        public static Object s1(JSONArray jSONArray, Class cls) throws JSONException {
            Object newInstance = Array.newInstance(cls.getComponentType(), jSONArray.length());
            Class<?> componentType = cls.getComponentType();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    Object opt = jSONArray.opt(i2);
                    if (VKApiModel.class.isAssignableFrom(componentType) && (opt instanceof JSONObject)) {
                        opt = ((VKApiModel) componentType.newInstance()).parse((JSONObject) opt);
                    }
                    Array.set(newInstance, i2, opt);
                } catch (InstantiationException e2) {
                    throw new JSONException(e2.getMessage());
                } catch (IllegalAccessException e3) {
                    throw new JSONException(e3.getMessage());
                } catch (IllegalArgumentException e4) {
                    throw new JSONException(e4.getMessage());
                }
            }
            return newInstance;
        }

        public static final void s2(Map map, OutputStream outputStream) throws XmlPullParserException, IOException {
            a2.f.a.a.j.a.a aVar = new a2.f.a.a.j.a.a();
            aVar.setOutput(outputStream, "utf-8");
            aVar.startDocument(null, Boolean.TRUE);
            aVar.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            t2(map, null, aVar);
            aVar.flush();
        }

        public static final void t(CoroutineContext coroutineContext) {
            if (!(coroutineContext.get(Job.Key) == null)) {
                throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
            }
        }

        public static String t0(long j2, @Nullable SimpleDateFormat simpleDateFormat) {
            Calendar h2 = t.h();
            Calendar i2 = t.i();
            i2.setTimeInMillis(j2);
            if (simpleDateFormat != null) {
                return simpleDateFormat.format(new Date(j2));
            }
            if (h2.get(1) == i2.get(1)) {
                return F0(j2, Locale.getDefault());
            }
            return K0(j2, Locale.getDefault());
        }

        public static boolean t1(JSONObject jSONObject, String str) {
            return jSONObject != null && jSONObject.optInt(str, 0) == 1;
        }

        public static final void t2(Map map, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
            if (map == null) {
                xmlSerializer.startTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
                xmlSerializer.endTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
                return;
            }
            xmlSerializer.startTag(null, "map");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            for (Map.Entry entry : map.entrySet()) {
                x2(entry.getValue(), (String) entry.getKey(), xmlSerializer, null);
            }
            xmlSerializer.endTag(null, "map");
        }

        public static void u(boolean z, double d2, RoundingMode roundingMode) {
            if (!z) {
                throw new ArithmeticException("rounded value is out of range for input " + d2 + " and rounding mode " + roundingMode);
            }
        }

        public static AlgorithmIdentifier u0(String str) {
            if (str.equals("SHA-1")) {
                return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
            }
            if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA224)) {
                return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, DERNull.INSTANCE);
            }
            if (str.equals("SHA-256")) {
                return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, DERNull.INSTANCE);
            }
            if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA384)) {
                return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, DERNull.INSTANCE);
            }
            if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA512)) {
                return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, DERNull.INSTANCE);
            }
            throw new IllegalArgumentException(a2.b.a.a.a.c3("unrecognised digest algorithm: ", str));
        }

        public static int u1(JSONObject jSONObject, String str) {
            if (jSONObject == null) {
                return 0;
            }
            return jSONObject.optInt(str, 0);
        }

        public static <K, V> void u2(Multimap<K, V> multimap, ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(multimap.asMap().size());
            for (Map.Entry<K, Collection<V>> entry : multimap.asMap().entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeInt(entry.getValue().size());
                for (V v : entry.getValue()) {
                    objectOutputStream.writeObject(v);
                }
            }
        }

        public static void v(boolean z, String str, int i2, int i3) {
            if (!z) {
                throw new ArithmeticException(a2.b.a.a.a.j(a2.b.a.a.a.S("overflow: ", str, "(", i2, ", "), i3, ")"));
            }
        }

        public static Digest v0(String str) {
            if (str.equals("SHA-1")) {
                return new SHA1Digest();
            }
            if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA224)) {
                return new SHA224Digest();
            }
            if (str.equals("SHA-256")) {
                return new SHA256Digest();
            }
            if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA384)) {
                return new SHA384Digest();
            }
            if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA512)) {
                return new SHA512Digest();
            }
            throw new IllegalArgumentException(a2.b.a.a.a.c3("unrecognised digest algorithm: ", str));
        }

        public static Parser v1(Node node) {
            Document ownerDocument = node.ownerDocument();
            return (ownerDocument == null || ownerDocument.parser() == null) ? new Parser(new HtmlTreeBuilder()) : ownerDocument.parser();
        }

        public static <E> void v2(Multiset<E> multiset, ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(multiset.entrySet().size());
            for (Multiset.Entry<E> entry : multiset.entrySet()) {
                objectOutputStream.writeObject(entry.getElement());
                objectOutputStream.writeInt(entry.getCount());
            }
        }

        public static void w(boolean z, String str, long j2, long j3) {
            if (!z) {
                StringBuilder T = a2.b.a.a.a.T("overflow: ", str, "(", j2);
                T.append(", ");
                T.append(j3);
                T.append(")");
                throw new ArithmeticException(T.toString());
            }
        }

        public static Digest w0(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            if (aSN1ObjectIdentifier.equals(NISTObjectIdentifiers.id_sha256)) {
                return new SHA256Digest();
            }
            if (aSN1ObjectIdentifier.equals(NISTObjectIdentifiers.id_sha512)) {
                return new SHA512Digest();
            }
            if (aSN1ObjectIdentifier.equals(NISTObjectIdentifiers.id_shake128)) {
                return new SHAKEDigest(128);
            }
            if (aSN1ObjectIdentifier.equals(NISTObjectIdentifiers.id_shake256)) {
                return new SHAKEDigest(256);
            }
            throw new IllegalArgumentException("unrecognized digest OID: " + aSN1ObjectIdentifier);
        }

        public static int w1(byte[] bArr, int i2, int i3) {
            while (i2 < i3 && bArr[i2] >= 0) {
                i2++;
            }
            if (i2 >= i3) {
                return 0;
            }
            while (i2 < i3) {
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 < 0) {
                    if (b2 < -32) {
                        if (i4 >= i3) {
                            return b2;
                        }
                        if (b2 >= -62) {
                            i2 = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                    } else if (b2 < -16) {
                        if (i4 >= i3 - 1) {
                            return R0(bArr, i4, i3);
                        }
                        int i5 = i4 + 1;
                        byte b3 = bArr[i4];
                        if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                            i2 = i5 + 1;
                            if (bArr[i5] > -65) {
                            }
                        }
                    } else if (i4 >= i3 - 2) {
                        return R0(bArr, i4, i3);
                    } else {
                        int i6 = i4 + 1;
                        byte b4 = bArr[i4];
                        if (b4 <= -65) {
                            if ((((b4 + 112) + (b2 << Ascii.FS)) >> 30) == 0) {
                                int i7 = i6 + 1;
                                if (bArr[i6] <= -65) {
                                    i4 = i7 + 1;
                                    if (bArr[i7] > -65) {
                                    }
                                }
                            }
                        }
                    }
                    return -1;
                }
                i2 = i4;
            }
            return 0;
        }

        public static final void w2(Object obj, String str, XmlSerializer xmlSerializer, XmlUtils$WriteMapCallback xmlUtils$WriteMapCallback) throws XmlPullParserException, IOException {
            String str2;
            if (obj == null) {
                xmlSerializer.startTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
                if (str != null) {
                    xmlSerializer.attribute(null, "name", str);
                }
                xmlSerializer.endTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
            } else if (obj instanceof String) {
                xmlSerializer.startTag(null, Types.STRING);
                if (str != null) {
                    xmlSerializer.attribute(null, "name", str);
                }
                xmlSerializer.text(obj.toString());
                xmlSerializer.endTag(null, Types.STRING);
            } else {
                if (obj instanceof Integer) {
                    str2 = Types.INT;
                } else if (obj instanceof Long) {
                    str2 = "long";
                } else if (obj instanceof Float) {
                    str2 = Types.FLOAT;
                } else if (obj instanceof Double) {
                    str2 = "double";
                } else if (obj instanceof Boolean) {
                    str2 = Types.BOOLEAN;
                } else {
                    int i2 = 0;
                    if (obj instanceof byte[]) {
                        byte[] bArr = (byte[]) obj;
                        xmlSerializer.startTag(null, "byte-array");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        int length = bArr.length;
                        xmlSerializer.attribute(null, "num", Integer.toString(length));
                        StringBuilder sb = new StringBuilder(bArr.length * 2);
                        while (i2 < length) {
                            byte b2 = bArr[i2];
                            int i3 = b2 >> 4;
                            sb.append(i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
                            int i4 = b2 & 255;
                            sb.append(i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
                            i2++;
                        }
                        xmlSerializer.text(sb.toString());
                        xmlSerializer.endTag(null, "byte-array");
                        return;
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        xmlSerializer.startTag(null, "int-array");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        int length2 = iArr.length;
                        xmlSerializer.attribute(null, "num", Integer.toString(length2));
                        while (i2 < length2) {
                            xmlSerializer.startTag(null, "item");
                            xmlSerializer.attribute(null, "value", Integer.toString(iArr[i2]));
                            xmlSerializer.endTag(null, "item");
                            i2++;
                        }
                        xmlSerializer.endTag(null, "int-array");
                        return;
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        xmlSerializer.startTag(null, "long-array");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        int length3 = jArr.length;
                        xmlSerializer.attribute(null, "num", Integer.toString(length3));
                        while (i2 < length3) {
                            xmlSerializer.startTag(null, "item");
                            xmlSerializer.attribute(null, "value", Long.toString(jArr[i2]));
                            xmlSerializer.endTag(null, "item");
                            i2++;
                        }
                        xmlSerializer.endTag(null, "long-array");
                        return;
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        xmlSerializer.startTag(null, "double-array");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        int length4 = dArr.length;
                        xmlSerializer.attribute(null, "num", Integer.toString(length4));
                        while (i2 < length4) {
                            xmlSerializer.startTag(null, "item");
                            xmlSerializer.attribute(null, "value", Double.toString(dArr[i2]));
                            xmlSerializer.endTag(null, "item");
                            i2++;
                        }
                        xmlSerializer.endTag(null, "double-array");
                        return;
                    } else if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        xmlSerializer.startTag(null, "string-array");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        int length5 = strArr.length;
                        xmlSerializer.attribute(null, "num", Integer.toString(length5));
                        while (i2 < length5) {
                            if (strArr[i2] == null) {
                                xmlSerializer.startTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
                                xmlSerializer.endTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
                            } else {
                                xmlSerializer.startTag(null, "item");
                                xmlSerializer.attribute(null, "value", strArr[i2]);
                                xmlSerializer.endTag(null, "item");
                            }
                            i2++;
                        }
                        xmlSerializer.endTag(null, "string-array");
                        return;
                    } else if (obj instanceof Map) {
                        r2((Map) obj, str, xmlSerializer);
                        return;
                    } else if (obj instanceof List) {
                        n2((List) obj, str, xmlSerializer);
                        return;
                    } else if (obj instanceof Set) {
                        Set<Object> set = (Set) obj;
                        xmlSerializer.startTag(null, "set");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        for (Object obj2 : set) {
                            w2(obj2, null, xmlSerializer, null);
                        }
                        xmlSerializer.endTag(null, "set");
                        return;
                    } else if (obj instanceof CharSequence) {
                        xmlSerializer.startTag(null, Types.STRING);
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        xmlSerializer.text(obj.toString());
                        xmlSerializer.endTag(null, Types.STRING);
                        return;
                    } else if (xmlUtils$WriteMapCallback != null) {
                        xmlUtils$WriteMapCallback.writeUnknownObject(obj, str, xmlSerializer);
                        return;
                    } else {
                        throw new RuntimeException(a2.b.a.a.a.b3("writeValueXml: unable to write value ", obj));
                    }
                }
                xmlSerializer.startTag(null, str2);
                if (str != null) {
                    xmlSerializer.attribute(null, "name", str);
                }
                xmlSerializer.attribute(null, "value", obj.toString());
                xmlSerializer.endTag(null, str2);
            }
        }

        public static int x(@NullableDecl String str, int i2) {
            if (i2 >= 0) {
                return i2;
            }
            throw new IllegalArgumentException(str + " (" + i2 + ") must be >= 0");
        }

        public static Digest x0(AlgorithmIdentifier algorithmIdentifier) {
            if (algorithmIdentifier.getAlgorithm().equals(OIWObjectIdentifiers.idSHA1)) {
                return DigestFactory.createSHA1();
            }
            if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha224)) {
                return DigestFactory.createSHA224();
            }
            if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha256)) {
                return DigestFactory.createSHA256();
            }
            if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha384)) {
                return DigestFactory.createSHA384();
            }
            if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha512)) {
                return DigestFactory.createSHA512();
            }
            StringBuilder L = a2.b.a.a.a.L("unrecognised OID in digest algorithm identifier: ");
            L.append(algorithmIdentifier.getAlgorithm());
            throw new IllegalArgumentException(L.toString());
        }

        @Nullable
        public static a2.j.b.b.u0.m.b x1(ExtractorInput extractorInput) throws IOException {
            byte[] bArr;
            Assertions.checkNotNull(extractorInput);
            ParsableByteArray parsableByteArray = new ParsableByteArray(16);
            if (a2.j.b.b.u0.m.c.a(extractorInput, parsableByteArray).a != 1380533830) {
                return null;
            }
            extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
            parsableByteArray.setPosition(0);
            int readInt = parsableByteArray.readInt();
            if (readInt != 1463899717) {
                Log.e("WavHeaderReader", "Unsupported RIFF format: " + readInt);
                return null;
            }
            a2.j.b.b.u0.m.c a3 = a2.j.b.b.u0.m.c.a(extractorInput, parsableByteArray);
            while (a3.a != 1718449184) {
                extractorInput.advancePeekPosition((int) a3.b);
                a3 = a2.j.b.b.u0.m.c.a(extractorInput, parsableByteArray);
            }
            Assertions.checkState(a3.b >= 16);
            extractorInput.peekFully(parsableByteArray.getData(), 0, 16);
            parsableByteArray.setPosition(0);
            int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
            int readLittleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
            int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
            int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
            int readLittleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
            int readLittleEndianUnsignedShort4 = parsableByteArray.readLittleEndianUnsignedShort();
            int i2 = ((int) a3.b) - 16;
            if (i2 > 0) {
                byte[] bArr2 = new byte[i2];
                extractorInput.peekFully(bArr2, 0, i2);
                bArr = bArr2;
            } else {
                bArr = Util.EMPTY_BYTE_ARRAY;
            }
            return new a2.j.b.b.u0.m.b(readLittleEndianUnsignedShort, readLittleEndianUnsignedShort2, readLittleEndianUnsignedIntToInt, readLittleEndianUnsignedIntToInt2, readLittleEndianUnsignedShort3, readLittleEndianUnsignedShort4, bArr);
        }

        public static final void x2(Object obj, String str, XmlSerializer xmlSerializer, com.evernote.android.job.util.support.XmlUtils$WriteMapCallback xmlUtils$WriteMapCallback) throws XmlPullParserException, IOException {
            String str2;
            if (obj == null) {
                xmlSerializer.startTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
                if (str != null) {
                    xmlSerializer.attribute(null, "name", str);
                }
                xmlSerializer.endTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
            } else if (obj instanceof String) {
                xmlSerializer.startTag(null, Types.STRING);
                if (str != null) {
                    xmlSerializer.attribute(null, "name", str);
                }
                xmlSerializer.text(obj.toString());
                xmlSerializer.endTag(null, Types.STRING);
            } else {
                if (obj instanceof Integer) {
                    str2 = Types.INT;
                } else if (obj instanceof Long) {
                    str2 = "long";
                } else if (obj instanceof Float) {
                    str2 = Types.FLOAT;
                } else if (obj instanceof Double) {
                    str2 = "double";
                } else if (obj instanceof Boolean) {
                    str2 = Types.BOOLEAN;
                } else {
                    int i2 = 0;
                    if (obj instanceof byte[]) {
                        byte[] bArr = (byte[]) obj;
                        xmlSerializer.startTag(null, "byte-array");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        int length = bArr.length;
                        xmlSerializer.attribute(null, "num", Integer.toString(length));
                        StringBuilder sb = new StringBuilder(bArr.length * 2);
                        while (i2 < length) {
                            byte b2 = bArr[i2];
                            int i3 = b2 >> 4;
                            sb.append(i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
                            int i4 = b2 & 255;
                            sb.append(i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
                            i2++;
                        }
                        xmlSerializer.text(sb.toString());
                        xmlSerializer.endTag(null, "byte-array");
                        return;
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        xmlSerializer.startTag(null, "int-array");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        int length2 = iArr.length;
                        xmlSerializer.attribute(null, "num", Integer.toString(length2));
                        while (i2 < length2) {
                            xmlSerializer.startTag(null, "item");
                            xmlSerializer.attribute(null, "value", Integer.toString(iArr[i2]));
                            xmlSerializer.endTag(null, "item");
                            i2++;
                        }
                        xmlSerializer.endTag(null, "int-array");
                        return;
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        xmlSerializer.startTag(null, "long-array");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        int length3 = jArr.length;
                        xmlSerializer.attribute(null, "num", Integer.toString(length3));
                        while (i2 < length3) {
                            xmlSerializer.startTag(null, "item");
                            xmlSerializer.attribute(null, "value", Long.toString(jArr[i2]));
                            xmlSerializer.endTag(null, "item");
                            i2++;
                        }
                        xmlSerializer.endTag(null, "long-array");
                        return;
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        xmlSerializer.startTag(null, "double-array");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        int length4 = dArr.length;
                        xmlSerializer.attribute(null, "num", Integer.toString(length4));
                        while (i2 < length4) {
                            xmlSerializer.startTag(null, "item");
                            xmlSerializer.attribute(null, "value", Double.toString(dArr[i2]));
                            xmlSerializer.endTag(null, "item");
                            i2++;
                        }
                        xmlSerializer.endTag(null, "double-array");
                        return;
                    } else if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        xmlSerializer.startTag(null, "string-array");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        int length5 = strArr.length;
                        xmlSerializer.attribute(null, "num", Integer.toString(length5));
                        while (i2 < length5) {
                            if (strArr[i2] == null) {
                                xmlSerializer.startTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
                                xmlSerializer.endTag(null, BuildConfig.ADJUST_DEFAULT_TRACKER);
                            } else {
                                xmlSerializer.startTag(null, "item");
                                xmlSerializer.attribute(null, "value", strArr[i2]);
                                xmlSerializer.endTag(null, "item");
                            }
                            i2++;
                        }
                        xmlSerializer.endTag(null, "string-array");
                        return;
                    } else if (obj instanceof Map) {
                        t2((Map) obj, str, xmlSerializer);
                        return;
                    } else if (obj instanceof List) {
                        o2((List) obj, str, xmlSerializer);
                        return;
                    } else if (obj instanceof Set) {
                        Set<Object> set = (Set) obj;
                        xmlSerializer.startTag(null, "set");
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        for (Object obj2 : set) {
                            x2(obj2, null, xmlSerializer, null);
                        }
                        xmlSerializer.endTag(null, "set");
                        return;
                    } else if (obj instanceof CharSequence) {
                        xmlSerializer.startTag(null, Types.STRING);
                        if (str != null) {
                            xmlSerializer.attribute(null, "name", str);
                        }
                        xmlSerializer.text(obj.toString());
                        xmlSerializer.endTag(null, Types.STRING);
                        return;
                    } else if (xmlUtils$WriteMapCallback != null) {
                        xmlUtils$WriteMapCallback.writeUnknownObject(obj, str, xmlSerializer);
                        return;
                    } else {
                        throw new RuntimeException(a2.b.a.a.a.b3("writeValueXml: unable to write value ", obj));
                    }
                }
                xmlSerializer.startTag(null, str2);
                if (str != null) {
                    xmlSerializer.attribute(null, "name", str);
                }
                xmlSerializer.attribute(null, "value", obj.toString());
                xmlSerializer.endTag(null, str2);
            }
        }

        public static long y(@NullableDecl String str, long j2) {
            if (j2 >= 0) {
                return j2;
            }
            throw new IllegalArgumentException(str + " (" + j2 + ") must be >= 0");
        }

        public static byte[] y0(Digest digest) {
            int i2;
            boolean z = digest instanceof Xof;
            if (z) {
                i2 = digest.getDigestSize() * 2;
            } else {
                i2 = digest.getDigestSize();
            }
            byte[] bArr = new byte[i2];
            if (z) {
                ((Xof) digest).doFinal(bArr, 0, i2);
            } else {
                digest.doFinal(bArr, 0);
            }
            return bArr;
        }

        public static int y1(ExtractorInput extractorInput, byte[] bArr, int i2, int i3) throws IOException {
            int i4 = 0;
            while (i4 < i3) {
                int peek = extractorInput.peek(bArr, i2 + i4, i3 - i4);
                if (peek == -1) {
                    break;
                }
                i4 += peek;
            }
            return i4;
        }

        public static String y2(String str, String str2) {
            int length = str.length() - str2.length();
            if (length < 0 || length > 1) {
                throw new IllegalArgumentException("Invalid input received");
            }
            StringBuilder sb = new StringBuilder(str2.length() + str.length());
            for (int i2 = 0; i2 < str.length(); i2++) {
                sb.append(str.charAt(i2));
                if (str2.length() > i2) {
                    sb.append(str2.charAt(i2));
                }
            }
            return sb.toString();
        }

        @CanIgnoreReturnValue
        public static int z(int i2, String str) {
            if (i2 >= 0) {
                return i2;
            }
            throw new IllegalArgumentException(str + " cannot be negative but was: " + i2);
        }

        public static X962Parameters z0(ECParameterSpec eCParameterSpec, boolean z) {
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                ECNamedCurveSpec eCNamedCurveSpec = (ECNamedCurveSpec) eCParameterSpec;
                ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(eCNamedCurveSpec.getName());
                if (namedCurveOid == null) {
                    namedCurveOid = new ASN1ObjectIdentifier(eCNamedCurveSpec.getName());
                }
                return new X962Parameters(namedCurveOid);
            } else if (eCParameterSpec == null) {
                return new X962Parameters((ASN1Null) DERNull.INSTANCE);
            } else {
                ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
                return new X962Parameters(new X9ECParameters(convertCurve, EC5Util.convertPoint(convertCurve, eCParameterSpec.getGenerator(), z), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed()));
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        public static <K, V> void z1(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            int readInt = objectInputStream.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                map.put(objectInputStream.readObject(), objectInputStream.readObject());
            }
        }
    }

    public class j extends ContentFrameLayout {
        public j(Context context) {
            super(context);
        }

        @Override // android.view.View, android.view.ViewGroup
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.h(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                    appCompatDelegateImpl.f(appCompatDelegateImpl.p(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i2));
        }
    }

    public final class k implements MenuPresenter.Callback {
        public k() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState m = appCompatDelegateImpl.m(menuBuilder);
            if (m == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.d(m.a, m, rootMenu);
                AppCompatDelegateImpl.this.f(m, true);
                return;
            }
            AppCompatDelegateImpl.this.f(m, z);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback q;
            if (menuBuilder != null) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.A || (q = appCompatDelegateImpl.q()) == null || AppCompatDelegateImpl.this.M) {
                return true;
            }
            q.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        SimpleArrayMap<String, Integer> simpleArrayMap;
        Integer num;
        AppCompatActivity appCompatActivity = null;
        this.e = context;
        this.h = appCompatCallback;
        this.d = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof AppCompatActivity)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        }
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        appCompatActivity = (AppCompatActivity) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (appCompatActivity != null) {
                this.N = appCompatActivity.getDelegate().getLocalNightMode();
            }
        }
        if (this.N == -100 && (num = (simpleArrayMap = a0).get(this.d.getClass().getName())) != null) {
            this.N = num.intValue();
            simpleArrayMap.remove(this.d.getClass().getName());
        }
        if (window != null) {
            c(window);
        }
        AppCompatDrawableManager.preload();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k();
        ((ViewGroup) this.v.findViewById(16908290)).addView(view, layoutParams);
        this.g.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        return b(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @NonNull
    @CallSuper
    public Context attachBaseContext2(@NonNull Context context) {
        boolean z2 = true;
        this.J = true;
        int i2 = this.N;
        if (i2 == -100) {
            i2 = AppCompatDelegate.getDefaultNightMode();
        }
        int t2 = t(context, i2);
        Configuration configuration = null;
        if (d0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(g(context, t2, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).applyOverrideConfiguration(g(context, t2, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!c0) {
            return super.attachBaseContext2(context);
        }
        try {
            Configuration configuration2 = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration3 = context.getResources().getConfiguration();
            if (!configuration2.equals(configuration3)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (!(configuration3 == null || configuration2.diff(configuration3) == 0)) {
                    float f2 = configuration2.fontScale;
                    float f3 = configuration3.fontScale;
                    if (f2 != f3) {
                        configuration.fontScale = f3;
                    }
                    int i3 = configuration2.mcc;
                    int i4 = configuration3.mcc;
                    if (i3 != i4) {
                        configuration.mcc = i4;
                    }
                    int i5 = configuration2.mnc;
                    int i6 = configuration3.mnc;
                    if (i5 != i6) {
                        configuration.mnc = i6;
                    }
                    int i7 = Build.VERSION.SDK_INT;
                    if (i7 >= 24) {
                        LocaleList locales = configuration2.getLocales();
                        LocaleList locales2 = configuration3.getLocales();
                        if (!locales.equals(locales2)) {
                            configuration.setLocales(locales2);
                            configuration.locale = configuration3.locale;
                        }
                    } else if (!ObjectsCompat.equals(configuration2.locale, configuration3.locale)) {
                        configuration.locale = configuration3.locale;
                    }
                    int i8 = configuration2.touchscreen;
                    int i9 = configuration3.touchscreen;
                    if (i8 != i9) {
                        configuration.touchscreen = i9;
                    }
                    int i10 = configuration2.keyboard;
                    int i11 = configuration3.keyboard;
                    if (i10 != i11) {
                        configuration.keyboard = i11;
                    }
                    int i12 = configuration2.keyboardHidden;
                    int i13 = configuration3.keyboardHidden;
                    if (i12 != i13) {
                        configuration.keyboardHidden = i13;
                    }
                    int i14 = configuration2.navigation;
                    int i15 = configuration3.navigation;
                    if (i14 != i15) {
                        configuration.navigation = i15;
                    }
                    int i16 = configuration2.navigationHidden;
                    int i17 = configuration3.navigationHidden;
                    if (i16 != i17) {
                        configuration.navigationHidden = i17;
                    }
                    int i18 = configuration2.orientation;
                    int i19 = configuration3.orientation;
                    if (i18 != i19) {
                        configuration.orientation = i19;
                    }
                    int i20 = configuration2.screenLayout & 15;
                    int i21 = configuration3.screenLayout & 15;
                    if (i20 != i21) {
                        configuration.screenLayout |= i21;
                    }
                    int i22 = configuration2.screenLayout & 192;
                    int i23 = configuration3.screenLayout & 192;
                    if (i22 != i23) {
                        configuration.screenLayout |= i23;
                    }
                    int i24 = configuration2.screenLayout & 48;
                    int i25 = configuration3.screenLayout & 48;
                    if (i24 != i25) {
                        configuration.screenLayout |= i25;
                    }
                    int i26 = configuration2.screenLayout & 768;
                    int i27 = configuration3.screenLayout & 768;
                    if (i26 != i27) {
                        configuration.screenLayout |= i27;
                    }
                    if (i7 >= 26) {
                        int i28 = configuration2.colorMode & 3;
                        int i29 = configuration3.colorMode & 3;
                        if (i28 != i29) {
                            configuration.colorMode |= i29;
                        }
                        int i30 = configuration2.colorMode & 12;
                        int i31 = configuration3.colorMode & 12;
                        if (i30 != i31) {
                            configuration.colorMode |= i31;
                        }
                    }
                    int i32 = configuration2.uiMode & 15;
                    int i33 = configuration3.uiMode & 15;
                    if (i32 != i33) {
                        configuration.uiMode |= i33;
                    }
                    int i34 = configuration2.uiMode & 48;
                    int i35 = configuration3.uiMode & 48;
                    if (i34 != i35) {
                        configuration.uiMode |= i35;
                    }
                    int i36 = configuration2.screenWidthDp;
                    int i37 = configuration3.screenWidthDp;
                    if (i36 != i37) {
                        configuration.screenWidthDp = i37;
                    }
                    int i38 = configuration2.screenHeightDp;
                    int i39 = configuration3.screenHeightDp;
                    if (i38 != i39) {
                        configuration.screenHeightDp = i39;
                    }
                    int i40 = configuration2.smallestScreenWidthDp;
                    int i41 = configuration3.smallestScreenWidthDp;
                    if (i40 != i41) {
                        configuration.smallestScreenWidthDp = i41;
                    }
                    int i42 = configuration2.densityDpi;
                    int i43 = configuration3.densityDpi;
                    if (i42 != i43) {
                        configuration.densityDpi = i43;
                    }
                }
            }
            Configuration g2 = g(context, t2, configuration);
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, R.style.Theme_AppCompat_Empty);
            contextThemeWrapper.applyOverrideConfiguration(g2);
            boolean z3 = false;
            try {
                if (context.getTheme() == null) {
                    z2 = false;
                }
                z3 = z2;
            } catch (NullPointerException unused3) {
            }
            if (z3) {
                ResourcesCompat.ThemeCompat.rebase(contextThemeWrapper.getTheme());
            }
            return super.attachBaseContext2(contextThemeWrapper);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Application failed to obtain resources from itself", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(boolean r13) {
        /*
        // Method dump skipped, instructions count: 487
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(boolean):boolean");
    }

    public final void c(@NonNull Window window) {
        if (this.f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof e)) {
                e eVar = new e(callback);
                this.g = eVar;
                window.setCallback(eVar);
                TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.e, (AttributeSet) null, b0);
                Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
                if (drawableIfKnown != null) {
                    window.setBackgroundDrawable(drawableIfKnown);
                }
                obtainStyledAttributes.recycle();
                this.f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public View createView(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        char c2;
        View view2;
        char c3 = 0;
        if (this.Z == null) {
            String string = this.e.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.Z = new AppCompatViewInflater();
            } else {
                try {
                    this.Z = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    this.Z = new AppCompatViewInflater();
                }
            }
        }
        AppCompatViewInflater appCompatViewInflater = this.Z;
        boolean shouldBeUsed = VectorEnabledTintResources.shouldBeUsed();
        Objects.requireNonNull(appCompatViewInflater);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.View, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.View_theme, 0);
        obtainStyledAttributes.recycle();
        Context contextThemeWrapper = (resourceId == 0 || ((context instanceof androidx.appcompat.view.ContextThemeWrapper) && ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId() == resourceId)) ? context : new androidx.appcompat.view.ContextThemeWrapper(context, resourceId);
        if (shouldBeUsed) {
            contextThemeWrapper = TintContextWrapper.wrap(contextThemeWrapper);
        }
        str.hashCode();
        char c4 = 1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                view2 = appCompatViewInflater.createRatingBar(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case 1:
                view2 = appCompatViewInflater.createCheckedTextView(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case 2:
                view2 = appCompatViewInflater.createMultiAutoCompleteTextView(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case 3:
                view2 = appCompatViewInflater.createTextView(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case 4:
                view2 = appCompatViewInflater.createImageButton(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case 5:
                view2 = appCompatViewInflater.createSeekBar(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case 6:
                view2 = appCompatViewInflater.createSpinner(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case 7:
                view2 = appCompatViewInflater.createRadioButton(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case '\b':
                view2 = appCompatViewInflater.createToggleButton(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case '\t':
                view2 = appCompatViewInflater.createImageView(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case '\n':
                view2 = appCompatViewInflater.createAutoCompleteTextView(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case 11:
                view2 = appCompatViewInflater.createCheckBox(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case '\f':
                view2 = appCompatViewInflater.createEditText(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            case '\r':
                view2 = appCompatViewInflater.createButton(contextThemeWrapper, attributeSet);
                appCompatViewInflater.b(view2, str);
                break;
            default:
                view2 = appCompatViewInflater.createView(contextThemeWrapper, str, attributeSet);
                break;
        }
        if (view2 == null && context != contextThemeWrapper) {
            view2 = null;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                Object[] objArr = appCompatViewInflater.a;
                objArr[0] = contextThemeWrapper;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = AppCompatViewInflater.d;
                        if (i2 < strArr.length) {
                            View a3 = appCompatViewInflater.a(contextThemeWrapper, str, strArr[i2]);
                            if (a3 != null) {
                                Object[] objArr2 = appCompatViewInflater.a;
                                objArr2[0] = null;
                                objArr2[1] = null;
                                view2 = a3;
                            } else {
                                i2++;
                            }
                        }
                    }
                } else {
                    View a4 = appCompatViewInflater.a(contextThemeWrapper, str, null);
                    Object[] objArr3 = appCompatViewInflater.a;
                    objArr3[0] = null;
                    objArr3[1] = null;
                    view2 = a4;
                }
            } catch (Exception unused2) {
            } finally {
                Object[] objArr4 = appCompatViewInflater.a;
                objArr4[c3] = view2;
                objArr4[c4] = view2;
            }
        }
        if (view2 != null) {
            Context context2 = view2.getContext();
            if ((context2 instanceof ContextWrapper) && ViewCompat.hasOnClickListeners(view2)) {
                TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, AppCompatViewInflater.c);
                String string2 = obtainStyledAttributes2.getString(0);
                if (string2 != null) {
                    view2.setOnClickListener(new AppCompatViewInflater.a(view2, string2));
                }
                obtainStyledAttributes2.recycle();
            }
        }
        return view2;
    }

    public void d(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null && panelFeatureState != null) {
            menu = panelFeatureState.h;
        }
        if ((panelFeatureState == null || panelFeatureState.m) && !this.M) {
            this.g.getWrapped().onPanelClosed(i2, menu);
        }
    }

    public void e(MenuBuilder menuBuilder) {
        if (!this.F) {
            this.F = true;
            this.l.dismissPopups();
            Window.Callback q2 = q();
            if (q2 != null && !this.M) {
                q2.onPanelClosed(108, menuBuilder);
            }
            this.F = false;
        }
    }

    public void f(PanelFeatureState panelFeatureState, boolean z2) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (!z2 || panelFeatureState.a != 0 || (decorContentParent = this.l) == null || !decorContentParent.isOverflowMenuShowing()) {
            WindowManager windowManager = (WindowManager) this.e.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.m || (viewGroup = panelFeatureState.e) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    d(panelFeatureState.a, panelFeatureState, null);
                }
            }
            panelFeatureState.k = false;
            panelFeatureState.l = false;
            panelFeatureState.m = false;
            panelFeatureState.f = null;
            panelFeatureState.n = true;
            if (this.H == panelFeatureState) {
                this.H = null;
                return;
            }
            return;
        }
        e(panelFeatureState.h);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public <T extends View> T findViewById(@IdRes int i2) {
        k();
        return (T) this.f.findViewById(i2);
    }

    @NonNull
    public final Configuration g(@NonNull Context context, int i2, @Nullable Configuration configuration) {
        int i3 = i2 != 1 ? i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        return configuration2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new b();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int getLocalNightMode() {
        return this.N;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater getMenuInflater() {
        if (this.j == null) {
            r();
            ActionBar actionBar = this.i;
            this.j = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : this.e);
        }
        return this.j;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar getSupportActionBar() {
        r();
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(android.view.KeyEvent r7) {
        /*
        // Method dump skipped, instructions count: 277
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.h(android.view.KeyEvent):boolean");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int i2) {
        boolean z2;
        int i3 = i2 == 8 ? 108 : i2 == 9 ? 109 : i2;
        if (i3 == 1) {
            z2 = this.E;
        } else if (i3 == 2) {
            z2 = this.y;
        } else if (i3 == 5) {
            z2 = this.z;
        } else if (i3 == 10) {
            z2 = this.C;
        } else if (i3 != 108) {
            z2 = i3 != 109 ? false : this.B;
        } else {
            z2 = this.A;
        }
        if (z2 || this.f.hasFeature(i2)) {
            return true;
        }
        return false;
    }

    public void i(int i2) {
        PanelFeatureState p2 = p(i2);
        if (p2.h != null) {
            Bundle bundle = new Bundle();
            p2.h.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                p2.p = bundle;
            }
            p2.h.stopDispatchingItemsChanged();
            p2.h.clear();
        }
        p2.o = true;
        p2.n = true;
        if ((i2 == 108 || i2 == 0) && this.l != null) {
            PanelFeatureState p3 = p(0);
            p3.k = false;
            w(p3, null);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.e);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, this);
        } else {
            boolean z2 = from.getFactory2() instanceof AppCompatDelegateImpl;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        r();
        ActionBar actionBar = this.i;
        if (actionBar == null || !actionBar.invalidateOptionsMenu()) {
            s(0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.t;
    }

    public void j() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.s;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.u) {
            TypedArray obtainStyledAttributes = this.e.obtainStyledAttributes(R.styleable.AppCompatTheme);
            int i2 = R.styleable.AppCompatTheme_windowActionBar;
            if (obtainStyledAttributes.hasValue(i2)) {
                if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(i2, false)) {
                    requestWindowFeature(108);
                }
                if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                    requestWindowFeature(109);
                }
                if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                    requestWindowFeature(10);
                }
                this.D = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                l();
                this.f.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.e);
                if (this.E) {
                    viewGroup = this.C ? (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
                } else if (this.D) {
                    viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                    this.B = false;
                    this.A = false;
                } else if (this.A) {
                    TypedValue typedValue = new TypedValue();
                    this.e.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new androidx.appcompat.view.ContextThemeWrapper(this.e, typedValue.resourceId);
                    } else {
                        context = this.e;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                    DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R.id.decor_content_parent);
                    this.l = decorContentParent;
                    decorContentParent.setWindowCallback(q());
                    if (this.B) {
                        this.l.initFeature(109);
                    }
                    if (this.y) {
                        this.l.initFeature(2);
                    }
                    if (this.z) {
                        this.l.initFeature(5);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new l6.b.a.i(this));
                    if (this.l == null) {
                        this.w = (TextView) viewGroup.findViewById(R.id.title);
                    }
                    ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f.findViewById(16908290);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(16908290);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.f.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new l6.b.a.j(this));
                    this.v = viewGroup;
                    Object obj = this.d;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.k;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        DecorContentParent decorContentParent2 = this.l;
                        if (decorContentParent2 != null) {
                            decorContentParent2.setWindowTitle(charSequence);
                        } else {
                            ActionBar actionBar = this.i;
                            if (actionBar != null) {
                                actionBar.setWindowTitle(charSequence);
                            } else {
                                TextView textView = this.w;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.v.findViewById(16908290);
                    View decorView = this.f.getDecorView();
                    contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    TypedArray obtainStyledAttributes2 = this.e.obtainStyledAttributes(R.styleable.AppCompatTheme);
                    obtainStyledAttributes2.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                    int i3 = R.styleable.AppCompatTheme_windowFixedWidthMajor;
                    if (obtainStyledAttributes2.hasValue(i3)) {
                        obtainStyledAttributes2.getValue(i3, contentFrameLayout2.getFixedWidthMajor());
                    }
                    int i4 = R.styleable.AppCompatTheme_windowFixedWidthMinor;
                    if (obtainStyledAttributes2.hasValue(i4)) {
                        obtainStyledAttributes2.getValue(i4, contentFrameLayout2.getFixedWidthMinor());
                    }
                    int i5 = R.styleable.AppCompatTheme_windowFixedHeightMajor;
                    if (obtainStyledAttributes2.hasValue(i5)) {
                        obtainStyledAttributes2.getValue(i5, contentFrameLayout2.getFixedHeightMajor());
                    }
                    int i6 = R.styleable.AppCompatTheme_windowFixedHeightMinor;
                    if (obtainStyledAttributes2.hasValue(i6)) {
                        obtainStyledAttributes2.getValue(i6, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.u = true;
                    PanelFeatureState p2 = p(0);
                    if (!this.M && p2.h == null) {
                        s(108);
                        return;
                    }
                    return;
                }
                StringBuilder L2 = a2.b.a.a.a.L("AppCompat does not support the current theme features: { windowActionBar: ");
                L2.append(this.A);
                L2.append(", windowActionBarOverlay: ");
                L2.append(this.B);
                L2.append(", android:windowIsFloating: ");
                L2.append(this.D);
                L2.append(", windowActionModeOverlay: ");
                L2.append(this.C);
                L2.append(", windowNoTitle: ");
                throw new IllegalArgumentException(a2.b.a.a.a.B(L2, this.E, " }"));
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void l() {
        if (this.f == null) {
            Object obj = this.d;
            if (obj instanceof Activity) {
                c(((Activity) obj).getWindow());
            }
        }
        if (this.f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public PanelFeatureState m(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.G;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.h == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public final Context n() {
        r();
        ActionBar actionBar = this.i;
        Context themedContext = actionBar != null ? actionBar.getThemedContext() : null;
        return themedContext == null ? this.e : themedContext;
    }

    public final g o(@NonNull Context context) {
        if (this.R == null) {
            if (p.d == null) {
                Context applicationContext = context.getApplicationContext();
                p.d = new p(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.R = new h(p.d);
        }
        return this.R;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration configuration) {
        if (this.A && this.u) {
            r();
            ActionBar actionBar = this.i;
            if (actionBar != null) {
                actionBar.onConfigurationChanged(configuration);
            }
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.e);
        b(false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        this.J = true;
        b(false);
        l();
        Object obj = this.d;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = NavUtils.getParentActivityName((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar actionBar = this.i;
                if (actionBar == null) {
                    this.W = true;
                } else {
                    actionBar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
        }
        synchronized (AppCompatDelegate.c) {
            AppCompatDelegate.a(this);
            AppCompatDelegate.b.add(new WeakReference<>(this));
        }
        this.K = true;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return createView(view, str, context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r3 = this;
            java.lang.Object r0 = androidx.appcompat.app.AppCompatDelegate.c
            monitor-enter(r0)
            androidx.appcompat.app.AppCompatDelegate.a(r3)     // Catch:{ all -> 0x006b }
            monitor-exit(r0)     // Catch:{ all -> 0x006b }
            boolean r0 = r3.T
            if (r0 == 0) goto L_0x0016
            android.view.Window r0 = r3.f
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.V
            r0.removeCallbacks(r1)
        L_0x0016:
            r0 = 0
            r3.L = r0
            r0 = 1
            r3.M = r0
            int r0 = r3.N
            r1 = -100
            if (r0 == r1) goto L_0x0046
            java.lang.Object r0 = r3.d
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0046
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0046
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.a0
            java.lang.Object r1 = r3.d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.N
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0055
        L_0x0046:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.a0
            java.lang.Object r1 = r3.d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0055:
            androidx.appcompat.app.ActionBar r0 = r3.i
            if (r0 == 0) goto L_0x005c
            r0.a()
        L_0x005c:
            androidx.appcompat.app.AppCompatDelegateImpl$g r0 = r3.R
            if (r0 == 0) goto L_0x0063
            r0.a()
        L_0x0063:
            androidx.appcompat.app.AppCompatDelegateImpl$g r0 = r3.S
            if (r0 == 0) goto L_0x006a
            r0.a()
        L_0x006a:
            return
        L_0x006b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onDestroy():void");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState m2;
        Window.Callback q2 = q();
        if (q2 == null || this.M || (m2 = m(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return q2.onMenuItemSelected(m2.a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        DecorContentParent decorContentParent = this.l;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.e).hasPermanentMenuKey() && !this.l.isOverflowMenuShowPending())) {
            PanelFeatureState p2 = p(0);
            p2.n = true;
            f(p2, false);
            u(p2, null);
            return;
        }
        Window.Callback q2 = q();
        if (this.l.isOverflowMenuShowing()) {
            this.l.hideOverflowMenu();
            if (!this.M) {
                q2.onPanelClosed(108, p(0).h);
            }
        } else if (q2 != null && !this.M) {
            if (this.T && (1 & this.U) != 0) {
                this.f.getDecorView().removeCallbacks(this.V);
                this.V.run();
            }
            PanelFeatureState p3 = p(0);
            MenuBuilder menuBuilder2 = p3.h;
            if (menuBuilder2 != null && !p3.o && q2.onPreparePanel(0, p3.g, menuBuilder2)) {
                q2.onMenuOpened(108, p3.h);
                this.l.showOverflowMenu();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(Bundle bundle) {
        k();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        r();
        ActionBar actionBar = this.i;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        this.L = true;
        applyDayNight();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        this.L = false;
        r();
        ActionBar actionBar = this.i;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(false);
        }
    }

    public PanelFeatureState p(int i2) {
        PanelFeatureState[] panelFeatureStateArr = this.G;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i2 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.G = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final Window.Callback q() {
        return this.f.getCallback();
    }

    public final void r() {
        k();
        if (this.A && this.i == null) {
            Object obj = this.d;
            if (obj instanceof Activity) {
                this.i = new WindowDecorActionBar((Activity) this.d, this.B);
            } else if (obj instanceof Dialog) {
                this.i = new WindowDecorActionBar((Dialog) this.d);
            }
            ActionBar actionBar = this.i;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.W);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int i2) {
        if (i2 == 8) {
            i2 = 108;
        } else if (i2 == 9) {
            i2 = 109;
        }
        if (this.E && i2 == 108) {
            return false;
        }
        if (this.A && i2 == 1) {
            this.A = false;
        }
        if (i2 == 1) {
            y();
            this.E = true;
            return true;
        } else if (i2 == 2) {
            y();
            this.y = true;
            return true;
        } else if (i2 == 5) {
            y();
            this.z = true;
            return true;
        } else if (i2 == 10) {
            y();
            this.C = true;
            return true;
        } else if (i2 == 108) {
            y();
            this.A = true;
            return true;
        } else if (i2 != 109) {
            return this.f.requestFeature(i2);
        } else {
            y();
            this.B = true;
            return true;
        }
    }

    public final void s(int i2) {
        this.U = (1 << i2) | this.U;
        if (!this.T) {
            ViewCompat.postOnAnimation(this.f.getDecorView(), this.V);
            this.T = true;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view) {
        k();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.g.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z2) {
        this.t = z2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setLocalNightMode(int i2) {
        if (this.N != i2) {
            this.N = i2;
            applyDayNight();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar toolbar) {
        CharSequence charSequence;
        if (this.d instanceof Activity) {
            r();
            ActionBar actionBar = this.i;
            if (!(actionBar instanceof WindowDecorActionBar)) {
                this.j = null;
                if (actionBar != null) {
                    actionBar.a();
                }
                if (toolbar != null) {
                    Object obj = this.d;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.k;
                    }
                    l6.b.a.n nVar = new l6.b.a.n(toolbar, charSequence, this.g);
                    this.i = nVar;
                    this.f.setCallback(nVar.c);
                } else {
                    this.i = null;
                    this.f.setCallback(this.g);
                }
                invalidateOptionsMenu();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setTheme(@StyleRes int i2) {
        this.O = i2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.k = charSequence;
        DecorContentParent decorContentParent = this.l;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.i;
        if (actionBar != null) {
            actionBar.setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.w;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.ActionMode startSupportActionMode(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode.Callback r8) {
        /*
        // Method dump skipped, instructions count: 412
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.startSupportActionMode(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    public int t(@NonNull Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (!(i2 == 1 || i2 == 2)) {
                    if (i2 == 3) {
                        if (this.S == null) {
                            this.S = new f(context);
                        }
                        return this.S.c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                return o(context).c();
            } else {
                return -1;
            }
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0126, code lost:
        if (r14 != null) goto L_0x0128;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r13, android.view.KeyEvent r14) {
        /*
        // Method dump skipped, instructions count: 401
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.u(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    public final boolean v(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        MenuBuilder menuBuilder;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.k || w(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.h) != null) {
            z2 = menuBuilder.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.l == null) {
            f(panelFeatureState, true);
        }
        return z2;
    }

    public final boolean w(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        Resources.Theme theme;
        DecorContentParent decorContentParent4;
        if (this.M) {
            return false;
        }
        if (panelFeatureState.k) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.H;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            f(panelFeatureState2, false);
        }
        Window.Callback q2 = q();
        if (q2 != null) {
            panelFeatureState.g = q2.onCreatePanelView(panelFeatureState.a);
        }
        int i2 = panelFeatureState.a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (decorContentParent4 = this.l) != null) {
            decorContentParent4.setMenuPrepared();
        }
        if (panelFeatureState.g == null && (!z2 || !(this.i instanceof l6.b.a.n))) {
            MenuBuilder menuBuilder = panelFeatureState.h;
            if (menuBuilder == null || panelFeatureState.o) {
                if (menuBuilder == null) {
                    Context context = this.e;
                    int i3 = panelFeatureState.a;
                    if ((i3 == 0 || i3 == 108) && this.l != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(theme);
                            context = contextThemeWrapper;
                        }
                    }
                    MenuBuilder menuBuilder2 = new MenuBuilder(context);
                    menuBuilder2.setCallback(this);
                    panelFeatureState.a(menuBuilder2);
                    if (panelFeatureState.h == null) {
                        return false;
                    }
                }
                if (z2 && (decorContentParent3 = this.l) != null) {
                    if (this.m == null) {
                        this.m = new c();
                    }
                    decorContentParent3.setMenu(panelFeatureState.h, this.m);
                }
                panelFeatureState.h.stopDispatchingItemsChanged();
                if (!q2.onCreatePanelMenu(panelFeatureState.a, panelFeatureState.h)) {
                    panelFeatureState.a(null);
                    if (z2 && (decorContentParent2 = this.l) != null) {
                        decorContentParent2.setMenu(null, this.m);
                    }
                    return false;
                }
                panelFeatureState.o = false;
            }
            panelFeatureState.h.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.p;
            if (bundle != null) {
                panelFeatureState.h.restoreActionViewStates(bundle);
                panelFeatureState.p = null;
            }
            if (!q2.onPreparePanel(0, panelFeatureState.g, panelFeatureState.h)) {
                if (z2 && (decorContentParent = this.l) != null) {
                    decorContentParent.setMenu(null, this.m);
                }
                panelFeatureState.h.startDispatchingItemsChanged();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.qwertyMode = z3;
            panelFeatureState.h.setQwertyMode(z3);
            panelFeatureState.h.startDispatchingItemsChanged();
        }
        panelFeatureState.k = true;
        panelFeatureState.l = false;
        this.H = panelFeatureState;
        return true;
    }

    public final boolean x() {
        ViewGroup viewGroup;
        return this.u && (viewGroup = this.v) != null && ViewCompat.isLaidOut(viewGroup);
    }

    public final void y() {
        if (this.u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final int z(@Nullable WindowInsetsCompat windowInsetsCompat, @Nullable Rect rect) {
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        int i4;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i5;
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        ActionBarContextView actionBarContextView = this.p;
        int i6 = 8;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.p.getLayoutParams();
            boolean z4 = true;
            if (this.p.isShown()) {
                if (this.X == null) {
                    this.X = new Rect();
                    this.Y = new Rect();
                }
                Rect rect2 = this.X;
                Rect rect3 = this.Y;
                rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                ViewUtils.computeFitSystemWindows(this.v, rect2, rect3);
                int i7 = rect2.top;
                int i8 = rect2.left;
                int i9 = rect2.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.v);
                if (rootWindowInsets == null) {
                    i2 = 0;
                } else {
                    i2 = rootWindowInsets.getSystemWindowInsetLeft();
                }
                if (rootWindowInsets == null) {
                    i3 = 0;
                } else {
                    i3 = rootWindowInsets.getSystemWindowInsetRight();
                }
                if (marginLayoutParams2.topMargin == i7 && marginLayoutParams2.leftMargin == i8 && marginLayoutParams2.rightMargin == i9) {
                    z3 = false;
                } else {
                    marginLayoutParams2.topMargin = i7;
                    marginLayoutParams2.leftMargin = i8;
                    marginLayoutParams2.rightMargin = i9;
                    z3 = true;
                }
                if (i7 <= 0 || this.x != null) {
                    View view = this.x;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i5 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3))) {
                        marginLayoutParams.height = i5;
                        marginLayoutParams.leftMargin = i2;
                        marginLayoutParams.rightMargin = i3;
                        this.x.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.e);
                    this.x = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = i2;
                    layoutParams.rightMargin = i3;
                    this.v.addView(this.x, -1, layoutParams);
                }
                View view3 = this.x;
                z2 = view3 != null;
                if (z2 && view3.getVisibility() != 0) {
                    View view4 = this.x;
                    if ((ViewCompat.getWindowSystemUiVisibility(view4) & 8192) == 0) {
                        z4 = false;
                    }
                    if (z4) {
                        i4 = ContextCompat.getColor(this.e, R.color.abc_decor_view_status_guard_light);
                    } else {
                        i4 = ContextCompat.getColor(this.e, R.color.abc_decor_view_status_guard);
                    }
                    view4.setBackgroundColor(i4);
                }
                if (!this.C && z2) {
                    systemWindowInsetTop = 0;
                }
                z4 = z3;
            } else {
                if (marginLayoutParams2.topMargin != 0) {
                    marginLayoutParams2.topMargin = 0;
                } else {
                    z4 = false;
                }
                z2 = false;
            }
            if (z4) {
                this.p.setLayoutParams(marginLayoutParams2);
            }
        }
        View view5 = this.x;
        if (view5 != null) {
            if (z2) {
                i6 = 0;
            }
            view5.setVisibility(i6);
        }
        return systemWindowInsetTop;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return createView(null, str, context, attributeSet);
    }

    public class e extends WindowCallbackWrapper {
        public e(Window.Callback callback) {
            super(callback);
        }

        public final android.view.ActionMode a(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.e, callback);
            androidx.appcompat.view.ActionMode startSupportActionMode = AppCompatDelegateImpl.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.h(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
            if (r6 != false) goto L_0x001b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean dispatchKeyShortcutEvent(android.view.KeyEvent r6) {
            /*
                r5 = this;
                boolean r0 = super.dispatchKeyShortcutEvent(r6)
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L_0x004d
                androidx.appcompat.app.AppCompatDelegateImpl r0 = androidx.appcompat.app.AppCompatDelegateImpl.this
                int r3 = r6.getKeyCode()
                r0.r()
                androidx.appcompat.app.ActionBar r4 = r0.i
                if (r4 == 0) goto L_0x001d
                boolean r3 = r4.onKeyShortcut(r3, r6)
                if (r3 == 0) goto L_0x001d
            L_0x001b:
                r6 = 1
                goto L_0x004b
            L_0x001d:
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r3 = r0.H
                if (r3 == 0) goto L_0x0032
                int r4 = r6.getKeyCode()
                boolean r3 = r0.v(r3, r4, r6, r2)
                if (r3 == 0) goto L_0x0032
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r6 = r0.H
                if (r6 == 0) goto L_0x001b
                r6.l = r2
                goto L_0x001b
            L_0x0032:
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r3 = r0.H
                if (r3 != 0) goto L_0x004a
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r3 = r0.p(r1)
                r0.w(r3, r6)
                int r4 = r6.getKeyCode()
                boolean r6 = r0.v(r3, r4, r6, r2)
                r3.k = r1
                if (r6 == 0) goto L_0x004a
                goto L_0x001b
            L_0x004a:
                r6 = 0
            L_0x004b:
                if (r6 == 0) goto L_0x004e
            L_0x004d:
                r1 = 1
            L_0x004e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.e.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            Objects.requireNonNull(appCompatDelegateImpl);
            if (i == 108) {
                appCompatDelegateImpl.r();
                ActionBar actionBar = appCompatDelegateImpl.i;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(true);
                }
            }
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            Objects.requireNonNull(appCompatDelegateImpl);
            if (i == 108) {
                appCompatDelegateImpl.r();
                ActionBar actionBar = appCompatDelegateImpl.i;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(false);
                }
            } else if (i == 0) {
                PanelFeatureState p = appCompatDelegateImpl.p(i);
                if (p.m) {
                    appCompatDelegateImpl.f(p, false);
                }
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            MenuBuilder menuBuilder = AppCompatDelegateImpl.this.p(0).h;
            if (menuBuilder != null) {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.t) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(23)
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!AppCompatDelegateImpl.this.t || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return a(callback);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int i2) {
        k();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.e).inflate(i2, viewGroup);
        this.g.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.g.getWrapped().onContentChanged();
    }
}

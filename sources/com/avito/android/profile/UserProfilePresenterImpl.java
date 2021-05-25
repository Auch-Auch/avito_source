package com.avito.android.profile;

import a2.a.a.b2.a0;
import a2.a.a.b2.a1;
import a2.a.a.b2.b0;
import a2.a.a.b2.b1;
import a2.a.a.b2.c0;
import a2.a.a.b2.c1;
import a2.a.a.b2.d0;
import a2.a.a.b2.d1;
import a2.a.a.b2.e0;
import a2.a.a.b2.f0;
import a2.a.a.b2.g0;
import a2.a.a.b2.h;
import a2.a.a.b2.h0;
import a2.a.a.b2.i;
import a2.a.a.b2.i0;
import a2.a.a.b2.j0;
import a2.a.a.b2.k0;
import a2.a.a.b2.l;
import a2.a.a.b2.l0;
import a2.a.a.b2.m;
import a2.a.a.b2.m0;
import a2.a.a.b2.n;
import a2.a.a.b2.n0;
import a2.a.a.b2.o;
import a2.a.a.b2.o0;
import a2.a.a.b2.p;
import a2.a.a.b2.p0;
import a2.a.a.b2.q;
import a2.a.a.b2.q0;
import a2.a.a.b2.r;
import a2.a.a.b2.r0;
import a2.a.a.b2.s;
import a2.a.a.b2.s0;
import a2.a.a.b2.t;
import a2.a.a.b2.t0;
import a2.a.a.b2.u;
import a2.a.a.b2.u0;
import a2.a.a.b2.v;
import a2.a.a.b2.v0;
import a2.a.a.b2.w;
import a2.a.a.b2.w0;
import a2.a.a.b2.x;
import a2.a.a.b2.x0;
import a2.a.a.b2.y;
import a2.a.a.b2.y0;
import a2.a.a.b2.z;
import a2.a.a.b2.z0;
import a2.g.r.g;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.account.AccountInteractor;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screen.UserProfileTracker;
import com.avito.android.code_confirmation.Source;
import com.avito.android.code_confirmation.timer.RxTimer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.profile.cards.UserProfileResourceProvider;
import com.avito.android.profile.cards.phones.PhonesCardItemPresenterOld;
import com.avito.android.profile.header.ProfileHeaderPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Avatar;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.remote.model.user_profile.UserProfileResult;
import com.avito.android.remote.model.user_profile.items.InfoItem;
import com.avito.android.remote.model.user_profile.items.PhonesItem;
import com.avito.android.remote.model.user_profile.items.UserProfileItem;
import com.avito.android.social.Logoutable;
import com.avito.android.util.Images;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001Bü\u0003\u0012\u0006\u0010z\u001a\u00020w\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010¬\u0001\u001a\u00030©\u0001\u0012\u0006\u0010~\u001a\u00020{\u0012\u0006\u0010/\u001a\u00020,\u0012\b\u0010°\u0001\u001a\u00030­\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u00108\u001a\u000205\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020L00\u0012\r\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020L00\u0012\u000e\u0010¥\u0001\u001a\t\u0012\u0005\u0012\u00030£\u000100\u0012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020p00\u0012\u000e\u0010¢\u0001\u001a\t\u0012\u0005\u0012\u00030 \u000100\u0012\u000e\u0010À\u0001\u001a\t\u0012\u0005\u0012\u00030¾\u000100\u0012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u000100\u0012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020=00\u0012\u0010\u0010@\u001a\f\u0012\u0004\u0012\u00020=00j\u0002`>\u0012\u0010\u0010Z\u001a\f\u0012\u0004\u0012\u00020W00j\u0002`X\u0012\u000e\u0010¸\u0001\u001a\t\u0012\u0005\u0012\u00030¶\u000100\u0012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u000100\u0012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020[00\u0012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u000100\u0012\f\u0010R\u001a\b\u0012\u0004\u0012\u00020P00\u0012\u000e\u0010µ\u0001\u001a\t\u0012\u0005\u0012\u00030³\u000100\u0012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u000100\u0012\f\u0010c\u001a\b\u0012\u0004\u0012\u00020a00\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020100\u0012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u000100\u0012\r\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\u001700\u0012\u000e\u0010¨\u0001\u001a\t\u0012\u0005\u0012\u00030¦\u000100\u0012\r\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c00\u0012\u0006\u0010g\u001a\u00020d\u0012\b\u0010Â\u0001\u001a\u00030Á\u0001\u0012\u0006\u0010o\u001a\u00020l\u0012\u0006\u0010<\u001a\u000209\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\t\u0010Ã\u0001\u001a\u0004\u0018\u00010#\u0012\u0006\u0010K\u001a\u00020F\u0012\u0006\u0010v\u001a\u00020s¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u0019\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004J\u0019\u0010\"\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010\u0004J\u0017\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00104\u001a\b\u0012\u0004\u0012\u000201008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R \u0010@\u001a\f\u0012\u0004\u0012\u00020=00j\u0002`>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u00103R\"\u0010E\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A*\u00020\u00058B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0019\u0010K\u001a\u00020F8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020L008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u00103R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010OR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020P008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u00103R\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR \u0010Z\u001a\f\u0012\u0004\u0012\u00020W00j\u0002`X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u00103R\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020[008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u00103R\u0018\u0010`\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010_R\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020a008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u00103R\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00020p008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u00103R\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00103R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00103R\u001f\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00103R\u001f\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00103R\u001f\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00103R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010\u0001R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020=008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00103R\u001f\u0010¢\u0001\u001a\t\u0012\u0005\u0012\u00030 \u0001008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¡\u0001\u00103R\u001f\u0010¥\u0001\u001a\t\u0012\u0005\u0012\u00030£\u0001008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¤\u0001\u00103R\u001f\u0010¨\u0001\u001a\t\u0012\u0005\u0012\u00030¦\u0001008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b§\u0001\u00103R\u001a\u0010¬\u0001\u001a\u00030©\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001a\u0010°\u0001\u001a\u00030­\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001a\u0010²\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\t\u0010±\u0001R\u001f\u0010µ\u0001\u001a\t\u0012\u0005\u0012\u00030³\u0001008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b´\u0001\u00103R\u001f\u0010¸\u0001\u001a\t\u0012\u0005\u0012\u00030¶\u0001008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b·\u0001\u00103R\u001d\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\u0017008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u00103R\u001e\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020L008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bº\u0001\u00103R\u001e\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¼\u0001\u00103R\u001f\u0010À\u0001\u001a\t\u0012\u0005\u0012\u00030¾\u0001008\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¿\u0001\u00103¨\u0006Æ\u0001"}, d2 = {"Lcom/avito/android/profile/UserProfilePresenterImpl;", "Lcom/avito/android/profile/UserProfilePresenter;", "", AuthSource.BOOKING_ORDER, "()V", "Lcom/avito/android/remote/model/user_profile/UserProfileResult;", "result", "c", "(Lcom/avito/android/remote/model/user_profile/UserProfileResult;)V", "e", "d", "onRetryClicked", "Lcom/avito/android/profile/UserProfileView;", "view", "attachView", "(Lcom/avito/android/profile/UserProfileView;)V", "detachView", "Lcom/avito/android/profile/UserProfilePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/UserProfilePresenter$Router;)V", "detachRouter", "onResume", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onPhoneAttached", "", "message", "onPhoneAdded", "(Ljava/lang/String;)V", "onPhoneRemoved", "onPhoneVerified", "onDeepLinkResult", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onAuthenticationSuccess", "onStateInvalidated", "", VKApiConst.POSITION, "onActionClicked", "(I)V", "Lcom/avito/android/profile/cards/UserProfileResourceProvider;", "l", "Lcom/avito/android/profile/cards/UserProfileResourceProvider;", "resourceProvider", "Lio/reactivex/Observable;", "Lcom/avito/android/profile/cards/CardItem$SubscribersCardItem;", "H", "Lio/reactivex/Observable;", "subscribersCardItemStream", "Lcom/avito/android/social/Logoutable;", "o", "Lcom/avito/android/social/Logoutable;", "logoutable", "Lcom/avito/android/error_helper/ErrorHelper;", "O", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/android/profile/cards/CardItem$PhonesCardItem;", "Lcom/avito/android/profile/PhonesCardActionObservable;", "x", "phonesCardManageStream", "", "Lcom/avito/android/remote/model/user_profile/Phone;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/user_profile/UserProfileResult;)Ljava/util/List;", "phones", "Lcom/avito/android/analytics/screen/UserProfileTracker;", "Q", "Lcom/avito/android/analytics/screen/UserProfileTracker;", "getTracker", "()Lcom/avito/android/analytics/screen/UserProfileTracker;", "tracker", "Lcom/avito/android/profile/cards/CardItem$InfoCardItem;", "p", "infoCardItemStream", "Lcom/avito/android/profile/UserProfilePresenter$Router;", "Lcom/avito/android/profile/cards/CardItem$HelpCenterCardItem;", "D", "helpCenterCardItemStream", "", "f", "Z", "isAuthOpened", "Lcom/avito/android/profile/cards/CardItem$PhonesEmptyCardItem;", "Lcom/avito/android/profile/PhonesEmptyCardActionObservable;", "y", "phonesEmptyCardStream", "Lcom/avito/android/profile/cards/CardItem$DeliverySettingsCardItem;", "B", "deliverySettingsCardItemStream", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "timerDisposable", "Lcom/avito/android/profile/cards/CardItem$SeparateWalletCardItem;", "G", "separateWalletCardItemStream", "Lcom/avito/android/analytics/Analytics;", "M", "Lcom/avito/android/analytics/Analytics;", "analytics", "", g.a, "J", "updateTime", "Lcom/avito/android/dialog/DialogPresenter;", "N", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "Lcom/avito/android/profile/cards/CardItem$SubscriptionCardItem;", "s", "subscriptionsCardItemStream", "Lcom/avito/android/profile/header/ProfileHeaderPresenter;", "R", "Lcom/avito/android/profile/header/ProfileHeaderPresenter;", "headerPresenter", "Lcom/avito/android/profile/UserProfileInteractor;", "h", "Lcom/avito/android/profile/UserProfileInteractor;", "interactor", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "k", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/profile/UserProfileView;", "Lcom/avito/android/account/AccountStorageInteractor;", "n", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/profile/UserProfileItemConverter;", "i", "Lcom/avito/android/profile/UserProfileItemConverter;", "converter", "Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterOld$Action;", "C", "phonesCardActionsStream", "Lcom/avito/android/code_confirmation/timer/RxTimer;", "P", "Lcom/avito/android/code_confirmation/timer/RxTimer;", "rxTimer", "Lcom/avito/android/profile/cards/CardItem$SocialCardItem;", VKApiConst.VERSION, "socialCardItemStream", "Lcom/avito/android/profile/cards/CardItem$ContactsCardItem;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "contactsCardItemStream", "Lcom/avito/android/profile/cards/CardItem$WalletCardItem;", "F", "walletCardItemStream", "Lcom/avito/android/profile/cards/CardItem$IncomeSettingsCardItem;", "I", "incomeSettingsCardItemStream", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "w", "phonesCardItemStream", "Lcom/avito/android/profile/cards/CardItem$LfPackagesCardItem;", "t", "lfPackagesCardItemStream", "Lcom/avito/android/profile/cards/CardItem$AdvertsCardItem;", "r", "advertsCardItemStream", "Lcom/avito/android/profile/cards/CardItem$TfaSettingsCardItem;", "K", "tfaSettingsClicksItemStream", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/account/AccountInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/account/AccountInteractor;", "accountInteractor", "Lcom/avito/android/remote/model/user_profile/UserProfileResult;", "userProfile", "Lcom/avito/android/profile/cards/CardItem$LogoutCardItem;", ExifInterface.LONGITUDE_EAST, "logoutCardItemStream", "Lcom/avito/android/profile/cards/CardItem$ReviewsCardItem;", "z", "reviewsCardItemStream", "deeplinkClicksItemStream", VKApiConst.Q, "infoCardRatingClickStream", "L", "urlClickStream", "Lcom/avito/android/profile/cards/CardItem$ShopSettingsCardItem;", "u", "shopSettingsCardItemStream", "Lcom/avito/android/Features;", "features", "state", "<init>", "(Lcom/avito/android/profile/UserProfileInteractor;Lcom/avito/android/profile/UserProfileItemConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/profile/cards/UserProfileResourceProvider;Lcom/avito/android/account/AccountInteractor;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/social/Logoutable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/code_confirmation/timer/RxTimer;Lcom/avito/android/util/Kundle;Lcom/avito/android/analytics/screen/UserProfileTracker;Lcom/avito/android/profile/header/ProfileHeaderPresenter;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfilePresenterImpl implements UserProfilePresenter {
    public final Observable<CardItem.ContactsCardItem> A;
    public final Observable<CardItem.DeliverySettingsCardItem> B;
    public final Observable<PhonesCardItemPresenterOld.Action> C;
    public final Observable<CardItem.HelpCenterCardItem> D;
    public final Observable<CardItem.LogoutCardItem> E;
    public final Observable<CardItem.WalletCardItem> F;
    public final Observable<CardItem.SeparateWalletCardItem> G;
    public final Observable<CardItem.SubscribersCardItem> H;
    public final Observable<CardItem.IncomeSettingsCardItem> I;
    public final Observable<DeepLink> J;
    public final Observable<CardItem.TfaSettingsCardItem> K;
    public final Observable<String> L;
    public final Analytics M;
    public final DialogPresenter N;
    public final ErrorHelper O;
    public final RxTimer P;
    @NotNull
    public final UserProfileTracker Q;
    public final ProfileHeaderPresenter R;
    public UserProfileView a;
    public UserProfilePresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public Disposable d;
    public UserProfileResult e;
    public boolean f;
    public long g;
    public final UserProfileInteractor h;
    public final UserProfileItemConverter i;
    public final SchedulersFactory j;
    public final AdapterPresenter k;
    public final UserProfileResourceProvider l;
    public final AccountInteractor m;
    public final AccountStorageInteractor n;
    public final Logoutable o;
    public final Observable<CardItem.InfoCardItem> p;
    public final Observable<CardItem.InfoCardItem> q;
    public final Observable<CardItem.AdvertsCardItem> r;
    public final Observable<CardItem.SubscriptionCardItem> s;
    public final Observable<CardItem.LfPackagesCardItem> t;
    public final Observable<CardItem.ShopSettingsCardItem> u;
    public final Observable<CardItem.SocialCardItem> v;
    public final Observable<CardItem.PhonesCardItem> w;
    public final Observable<CardItem.PhonesCardItem> x;
    public final Observable<CardItem.PhonesEmptyCardItem> y;
    public final Observable<CardItem.ReviewsCardItem> z;

    public static final class a<T> implements Consumer<UserProfileResult> {
        public final /* synthetic */ UserProfilePresenterImpl a;

        public a(UserProfilePresenterImpl userProfilePresenterImpl) {
            this.a = userProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(UserProfileResult userProfileResult) {
            UserProfileResult userProfileResult2 = userProfileResult;
            UserProfileTracker tracker = this.a.getTracker();
            tracker.trackProfileLoaded();
            tracker.startProfileDraw();
            UserProfilePresenterImpl userProfilePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(userProfileResult2, "it");
            userProfilePresenterImpl.c(userProfileResult2);
            tracker.trackProfileDraw();
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ UserProfilePresenterImpl a;

        public b(UserProfilePresenterImpl userProfilePresenterImpl) {
            this.a = userProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            UserProfileTracker tracker = this.a.getTracker();
            tracker.trackProfileLoadError();
            tracker.startProfileDraw();
            UserProfilePresenterImpl userProfilePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            UserProfilePresenterImpl.access$onError(userProfilePresenterImpl, th2);
            tracker.trackProfileErrorDraw();
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ UserProfilePresenterImpl a;

        public c(UserProfilePresenterImpl userProfilePresenterImpl) {
            this.a = userProfilePresenterImpl;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.g = 0;
        }
    }

    public static final class d<T> implements Consumer<List<? extends Phone>> {
        public final /* synthetic */ UserProfilePresenterImpl a;

        public d(UserProfilePresenterImpl userProfilePresenterImpl) {
            this.a = userProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends Phone> list) {
            ArrayList arrayList;
            List<UserProfileItem> items;
            List<? extends Phone> list2 = list;
            UserProfileResult userProfileResult = this.a.e;
            UserProfileResult userProfileResult2 = null;
            if (userProfileResult == null || (items = userProfileResult.getItems()) == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(items, 10));
                for (T t : items) {
                    if (t instanceof PhonesItem) {
                        Intrinsics.checkNotNullExpressionValue(list2, "phones");
                        t = (T) new PhonesItem(list2);
                    }
                    arrayList2.add(t);
                }
                arrayList = arrayList2;
            }
            UserProfilePresenterImpl userProfilePresenterImpl = this.a;
            UserProfileResult userProfileResult3 = userProfilePresenterImpl.e;
            if (userProfileResult3 != null) {
                userProfileResult2 = UserProfileResult.copy$default(userProfileResult3, arrayList, null, null, null, 14, null);
            }
            userProfilePresenterImpl.e = userProfileResult2;
            UserProfileResult userProfileResult4 = this.a.e;
            if (userProfileResult4 != null) {
                this.a.c(userProfileResult4);
            }
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ UserProfilePresenterImpl a;

        public e(UserProfilePresenterImpl userProfilePresenterImpl) {
            this.a = userProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.d();
        }
    }

    public UserProfilePresenterImpl(@NotNull UserProfileInteractor userProfileInteractor, @NotNull UserProfileItemConverter userProfileItemConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull AdapterPresenter adapterPresenter, @NotNull UserProfileResourceProvider userProfileResourceProvider, @NotNull AccountInteractor accountInteractor, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull Logoutable logoutable, @NotNull Observable<CardItem.InfoCardItem> observable, @NotNull Observable<CardItem.InfoCardItem> observable2, @NotNull Observable<CardItem.AdvertsCardItem> observable3, @NotNull Observable<CardItem.SubscriptionCardItem> observable4, @NotNull Observable<CardItem.LfPackagesCardItem> observable5, @NotNull Observable<CardItem.ShopSettingsCardItem> observable6, @NotNull Observable<CardItem.SocialCardItem> observable7, @NotNull Observable<CardItem.PhonesCardItem> observable8, @NotNull Observable<CardItem.PhonesCardItem> observable9, @NotNull Observable<CardItem.PhonesEmptyCardItem> observable10, @NotNull Observable<CardItem.ReviewsCardItem> observable11, @NotNull Observable<CardItem.ContactsCardItem> observable12, @NotNull Observable<CardItem.DeliverySettingsCardItem> observable13, @NotNull Observable<PhonesCardItemPresenterOld.Action> observable14, @NotNull Observable<CardItem.HelpCenterCardItem> observable15, @NotNull Observable<CardItem.LogoutCardItem> observable16, @NotNull Observable<CardItem.WalletCardItem> observable17, @NotNull Observable<CardItem.SeparateWalletCardItem> observable18, @NotNull Observable<CardItem.SubscribersCardItem> observable19, @NotNull Observable<CardItem.IncomeSettingsCardItem> observable20, @NotNull Observable<DeepLink> observable21, @NotNull Observable<CardItem.TfaSettingsCardItem> observable22, @NotNull Observable<String> observable23, @NotNull Analytics analytics, @NotNull Features features, @NotNull DialogPresenter dialogPresenter, @NotNull ErrorHelper errorHelper, @NotNull RxTimer rxTimer, @Nullable Kundle kundle, @NotNull UserProfileTracker userProfileTracker, @NotNull ProfileHeaderPresenter profileHeaderPresenter) {
        Long l2;
        Boolean bool;
        Intrinsics.checkNotNullParameter(userProfileInteractor, "interactor");
        Intrinsics.checkNotNullParameter(userProfileItemConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(userProfileResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(accountInteractor, "accountInteractor");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(logoutable, "logoutable");
        Intrinsics.checkNotNullParameter(observable, "infoCardItemStream");
        Intrinsics.checkNotNullParameter(observable2, "infoCardRatingClickStream");
        Intrinsics.checkNotNullParameter(observable3, "advertsCardItemStream");
        Intrinsics.checkNotNullParameter(observable4, "subscriptionsCardItemStream");
        Intrinsics.checkNotNullParameter(observable5, "lfPackagesCardItemStream");
        Intrinsics.checkNotNullParameter(observable6, "shopSettingsCardItemStream");
        Intrinsics.checkNotNullParameter(observable7, "socialCardItemStream");
        Intrinsics.checkNotNullParameter(observable8, "phonesCardItemStream");
        Intrinsics.checkNotNullParameter(observable9, "phonesCardManageStream");
        Intrinsics.checkNotNullParameter(observable10, "phonesEmptyCardStream");
        Intrinsics.checkNotNullParameter(observable11, "reviewsCardItemStream");
        Intrinsics.checkNotNullParameter(observable12, "contactsCardItemStream");
        Intrinsics.checkNotNullParameter(observable13, "deliverySettingsCardItemStream");
        Intrinsics.checkNotNullParameter(observable14, "phonesCardActionsStream");
        Intrinsics.checkNotNullParameter(observable15, "helpCenterCardItemStream");
        Intrinsics.checkNotNullParameter(observable16, "logoutCardItemStream");
        Intrinsics.checkNotNullParameter(observable17, "walletCardItemStream");
        Intrinsics.checkNotNullParameter(observable18, "separateWalletCardItemStream");
        Intrinsics.checkNotNullParameter(observable19, "subscribersCardItemStream");
        Intrinsics.checkNotNullParameter(observable20, "incomeSettingsCardItemStream");
        Intrinsics.checkNotNullParameter(observable21, "deeplinkClicksItemStream");
        Intrinsics.checkNotNullParameter(observable22, "tfaSettingsClicksItemStream");
        Intrinsics.checkNotNullParameter(observable23, "urlClickStream");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(rxTimer, "rxTimer");
        Intrinsics.checkNotNullParameter(userProfileTracker, "tracker");
        Intrinsics.checkNotNullParameter(profileHeaderPresenter, "headerPresenter");
        this.h = userProfileInteractor;
        this.i = userProfileItemConverter;
        this.j = schedulersFactory;
        this.k = adapterPresenter;
        this.l = userProfileResourceProvider;
        this.m = accountInteractor;
        this.n = accountStorageInteractor;
        this.o = logoutable;
        this.p = observable;
        this.q = observable2;
        this.r = observable3;
        this.s = observable4;
        this.t = observable5;
        this.u = observable6;
        this.v = observable7;
        this.w = observable8;
        this.x = observable9;
        this.y = observable10;
        this.z = observable11;
        this.A = observable12;
        this.B = observable13;
        this.C = observable14;
        this.D = observable15;
        this.E = observable16;
        this.F = observable17;
        this.G = observable18;
        this.H = observable19;
        this.I = observable20;
        this.J = observable21;
        this.K = observable22;
        this.L = observable23;
        this.M = analytics;
        this.N = dialogPresenter;
        this.O = errorHelper;
        this.P = rxTimer;
        this.Q = userProfileTracker;
        this.R = profileHeaderPresenter;
        this.e = kundle != null ? (UserProfileResult) kundle.getParcelable("user_profile") : null;
        this.f = (kundle == null || (bool = kundle.getBoolean("auth_opened")) == null) ? false : bool.booleanValue();
        this.g = (kundle == null || (l2 = kundle.getLong("update_time")) == null) ? 0 : l2.longValue();
    }

    public static final void access$handleError(UserProfilePresenterImpl userProfilePresenterImpl, Throwable th) {
        TypedError handle = userProfilePresenterImpl.O.handle(th);
        if (handle instanceof ErrorResult.ErrorDialog) {
            userProfilePresenterImpl.N.showDialog(((ErrorResult.ErrorDialog) handle).getUserDialog()).subscribe(new a2.a.a.b2.a(userProfilePresenterImpl));
        } else if (handle instanceof ErrorResult.IncorrectData) {
            String str = (String) CollectionsKt___CollectionsKt.firstOrNull(((ErrorResult.IncorrectData) handle).getMessages().values());
            if (str != null) {
                CompositeDisposable compositeDisposable = userProfilePresenterImpl.c;
                Disposable subscribe = DialogPresenter.DefaultImpls.showDialog$default(userProfilePresenterImpl.N, null, str, false, 5, null).subscribe();
                Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…message = it).subscribe()");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        } else if (handle instanceof TypedError.ErrorMap) {
            String str2 = (String) CollectionsKt___CollectionsKt.firstOrNull(((TypedError.ErrorMap) handle).getMessages().values());
            if (str2 != null) {
                CompositeDisposable compositeDisposable2 = userProfilePresenterImpl.c;
                Disposable subscribe2 = DialogPresenter.DefaultImpls.showDialog$default(userProfilePresenterImpl.N, null, str2, false, 5, null).subscribe();
                Intrinsics.checkNotNullExpressionValue(subscribe2, "dialogPresenter.showDial…message = it).subscribe()");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            }
        } else {
            UserProfileView userProfileView = userProfilePresenterImpl.a;
            if (userProfileView != null) {
                userProfileView.showSnackbar(userProfilePresenterImpl.O.recycle(handle));
            }
        }
    }

    public static final void access$handleUrl(UserProfilePresenterImpl userProfilePresenterImpl, String str) {
        Objects.requireNonNull(userProfilePresenterImpl);
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, ShareConstants.MEDIA_URI);
        if (Intrinsics.areEqual(parse.getHost(), "support.avito.ru")) {
            String path = new URL(str).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "URL(url).path");
            Objects.requireNonNull(path, "null cannot be cast to non-null type java.lang.String");
            String substring = path.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            UserProfilePresenter.Router router = userProfilePresenterImpl.b;
            if (router != null) {
                router.openHelpCenter(substring);
                return;
            }
            return;
        }
        UserProfilePresenter.Router router2 = userProfilePresenterImpl.b;
        if (router2 != null) {
            router2.openWebViewScreen(str);
        }
    }

    public static final void access$logout(UserProfilePresenterImpl userProfilePresenterImpl) {
        userProfilePresenterImpl.o.logout();
        CompositeDisposable compositeDisposable = userProfilePresenterImpl.c;
        Disposable subscribe = InteropKt.toV2(userProfilePresenterImpl.m.logout(true, "user_action")).observeOn(userProfilePresenterImpl.j.mainThread()).doOnSubscribe(new a2.a.a.b2.b(userProfilePresenterImpl)).subscribe(new a2.a.a.b2.c(userProfilePresenterImpl), new a2.a.a.b2.d(userProfilePresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountInteractor\n      …showError()\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if ((r4.getErrorResult() instanceof com.avito.android.remote.error.ErrorResult.Unauthorized) == false) goto L_0x0021;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$onError(com.avito.android.profile.UserProfilePresenterImpl r3, java.lang.Throwable r4) {
        /*
            java.util.Objects.requireNonNull(r3)
            boolean r0 = r4 instanceof com.avito.android.util.UnauthorizedException
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000a
            goto L_0x0020
        L_0x000a:
            boolean r0 = r4 instanceof com.avito.android.util.TypedResultException
            if (r0 == 0) goto L_0x0021
            com.avito.android.util.TypedResultException r4 = (com.avito.android.util.TypedResultException) r4
            com.avito.android.remote.error.TypedError r0 = r4.getErrorResult()
            boolean r0 = r0 instanceof com.avito.android.remote.error.ErrorResult.Unauthenticated
            if (r0 != 0) goto L_0x0020
            com.avito.android.remote.error.TypedError r4 = r4.getErrorResult()
            boolean r4 = r4 instanceof com.avito.android.remote.error.ErrorResult.Unauthorized
            if (r4 == 0) goto L_0x0021
        L_0x0020:
            r1 = 1
        L_0x0021:
            if (r1 == 0) goto L_0x0031
            boolean r4 = r3.f
            if (r4 != 0) goto L_0x0038
            com.avito.android.profile.UserProfilePresenter$Router r4 = r3.b
            if (r4 == 0) goto L_0x002e
            r4.showLoginScreen()
        L_0x002e:
            r3.f = r2
            goto L_0x0038
        L_0x0031:
            com.avito.android.profile.UserProfileView r3 = r3.a
            if (r3 == 0) goto L_0x0038
            r3.showError()
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile.UserProfilePresenterImpl.access$onError(com.avito.android.profile.UserProfilePresenterImpl, java.lang.Throwable):void");
    }

    public static final void access$onPhoneSetForAll(UserProfilePresenterImpl userProfilePresenterImpl) {
        UserProfileView userProfileView = userProfilePresenterImpl.a;
        if (userProfileView != null) {
            userProfileView.showSnackbar(userProfilePresenterImpl.l.phoneSetForAll());
        }
        userProfilePresenterImpl.onStateInvalidated();
    }

    public static final void access$removePhone(UserProfilePresenterImpl userProfilePresenterImpl, Phone phone) {
        List<Phone> a3;
        UserProfileResult userProfileResult = userProfilePresenterImpl.e;
        if (userProfileResult != null && (a3 = userProfilePresenterImpl.a(userProfileResult)) != null) {
            int size = a3.size();
            Integer itemsCount = phone.getItemsCount();
            if ((itemsCount != null ? itemsCount.intValue() : 0) > 0 || size <= 1) {
                UserProfilePresenter.Router router = userProfilePresenterImpl.b;
                if (router != null) {
                    router.openRemovePhone(phone);
                    return;
                }
                return;
            }
            UserProfileView userProfileView = userProfilePresenterImpl.a;
            if (userProfileView != null) {
                CompositeDisposable compositeDisposable = userProfilePresenterImpl.c;
                Disposable subscribe = DialogPresenter.DefaultImpls.showDialog$default(userProfilePresenterImpl.N, null, userProfilePresenterImpl.l.phoneRemovingMessage(), userProfilePresenterImpl.l.phoneRemovingButton(), false, 9, null).flatMap(new a2.a.a.b2.g(userProfilePresenterImpl, phone, userProfileView)).subscribe(new h(userProfilePresenterImpl), new i(userProfilePresenterImpl));
                Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…      }\n                )");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        }
    }

    public static final void access$setPhoneForAllAdverts(UserProfilePresenterImpl userProfilePresenterImpl, Phone phone) {
        UserProfileView userProfileView = userProfilePresenterImpl.a;
        if (userProfileView != null) {
            CompositeDisposable compositeDisposable = userProfilePresenterImpl.c;
            Disposable subscribe = DialogPresenter.DefaultImpls.showDialog$default(userProfilePresenterImpl.N, null, userProfilePresenterImpl.l.phoneSetForAllItemsMessage(), userProfilePresenterImpl.l.phoneSetForAllItemsButton(), false, 9, null).flatMap(new l(userProfilePresenterImpl, phone, userProfileView)).subscribe(new m(userProfilePresenterImpl), new n(userProfilePresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…          }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public static final void access$verifyPhone(UserProfilePresenterImpl userProfilePresenterImpl, Phone phone) {
        CompositeDisposable compositeDisposable = userProfilePresenterImpl.c;
        Disposable subscribe = userProfilePresenterImpl.h.requestCode(phone.getPhone(), Source.PHONE_VERIFICATION).observeOn(userProfilePresenterImpl.j.mainThread()).doOnSubscribe(new a1(userProfilePresenterImpl)).doAfterTerminate(new b1(userProfilePresenterImpl)).subscribe(new c1(userProfilePresenterImpl, phone), new d1(userProfilePresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.requestCode(p…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final List<Phone> a(UserProfileResult userProfileResult) {
        T t2;
        T t3;
        List<UserProfileItem> items = userProfileResult.getItems();
        if (items != null) {
            Iterator<T> it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t3 = null;
                    break;
                }
                t3 = it.next();
                if (t3 instanceof PhonesItem) {
                    break;
                }
            }
            t2 = t3;
        } else {
            t2 = null;
        }
        PhonesItem phonesItem = (PhonesItem) t2;
        if (phonesItem != null) {
            return phonesItem.getPhones();
        }
        return null;
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void attachRouter(@NotNull UserProfilePresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        this.R.attachRouter(router);
        UserProfileView userProfileView = this.a;
        if (userProfileView != null) {
            userProfileView.hideKeyboard();
        }
        e();
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void attachView(@NotNull UserProfileView userProfileView) {
        Intrinsics.checkNotNullParameter(userProfileView, "view");
        this.a = userProfileView;
        this.R.attachView(userProfileView);
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.p.subscribeOn(this.j.mainThread()).subscribe(new a0(this), b0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "infoCardItemStream\n     …eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = this.r.subscribeOn(this.j.mainThread()).subscribe(new o(this), p.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "advertsCardItemStream\n  …eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.c;
        Disposable subscribe3 = this.s.subscribeOn(this.j.mainThread()).subscribe(new u0(this), v0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "subscriptionsCardItemStr…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.c;
        Disposable subscribe4 = this.t.subscribeOn(this.j.mainThread()).subscribe(new e0(this), f0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "lfPackagesCardItemStream…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.c;
        Disposable subscribe5 = this.u.subscribeOn(this.j.mainThread()).subscribe(new o0(this), p0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe5, "shopSettingsCardItemStre…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        CompositeDisposable compositeDisposable6 = this.c;
        Disposable subscribe6 = this.v.subscribeOn(this.j.mainThread()).subscribe(new q0(this), r0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe6, "socialCardItemStream\n   …eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable6, subscribe6);
        CompositeDisposable compositeDisposable7 = this.c;
        CompositeDisposable compositeDisposable8 = new CompositeDisposable();
        Disposable subscribe7 = this.x.subscribeOn(this.j.mainThread()).subscribe(new x2(0, this), k.b);
        Intrinsics.checkNotNullExpressionValue(subscribe7, "phonesCardManageStream\n …eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable8, subscribe7);
        Disposable subscribe8 = this.y.subscribeOn(this.j.mainThread()).subscribe(new k0(this), k.c);
        Intrinsics.checkNotNullExpressionValue(subscribe8, "phonesEmptyCardStream\n  …eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable8, subscribe8);
        Disposable subscribe9 = this.w.subscribeOn(this.j.mainThread()).subscribe(new x2(1, this), k.d);
        Intrinsics.checkNotNullExpressionValue(subscribe9, "phonesCardItemStream\n   …eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable8, subscribe9);
        Disposable subscribe10 = this.C.subscribeOn(this.j.mainThread()).subscribe(new l0(this), k.e);
        Intrinsics.checkNotNullExpressionValue(subscribe10, "phonesCardActionsStream\n…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable8, subscribe10);
        DisposableKt.plusAssign(compositeDisposable7, compositeDisposable8);
        CompositeDisposable compositeDisposable9 = this.c;
        Disposable subscribe11 = this.z.subscribeOn(this.j.mainThread()).subscribe(new m0(this), n0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe11, "reviewsCardItemStream\n  …t.action.deepLink) }, {})");
        DisposableKt.plusAssign(compositeDisposable9, subscribe11);
        CompositeDisposable compositeDisposable10 = this.c;
        Disposable subscribe12 = this.A.subscribeOn(this.j.mainThread()).subscribe(new q(this), r.a);
        Intrinsics.checkNotNullExpressionValue(subscribe12, "contactsCardItemStream\n …     }\n            }, {})");
        DisposableKt.plusAssign(compositeDisposable10, subscribe12);
        CompositeDisposable compositeDisposable11 = this.c;
        Disposable subscribe13 = this.E.subscribeOn(this.j.mainThread()).subscribe(new i0(this), j0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe13, "logoutCardItemStream\n   …eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable11, subscribe13);
        CompositeDisposable compositeDisposable12 = this.c;
        Disposable subscribe14 = this.q.subscribeOn(this.j.mainThread()).subscribe(new c0(this), d0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe14, "infoCardRatingClickStrea…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable12, subscribe14);
        CompositeDisposable compositeDisposable13 = this.c;
        Disposable subscribe15 = this.B.subscribeOn(this.j.mainThread()).subscribe(new u(this), v.a);
        Intrinsics.checkNotNullExpressionValue(subscribe15, "deliverySettingsCardItem…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable13, subscribe15);
        CompositeDisposable compositeDisposable14 = this.c;
        Disposable subscribe16 = this.D.subscribeOn(this.j.mainThread()).subscribe(new w(this), x.a);
        Intrinsics.checkNotNullExpressionValue(subscribe16, "helpCenterCardItemStream…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable14, subscribe16);
        CompositeDisposable compositeDisposable15 = this.c;
        Disposable subscribe17 = Observable.merge(this.F, this.G).subscribeOn(this.j.mainThread()).subscribe(new y0(this), z0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe17, "Observable.merge(walletC…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable15, subscribe17);
        CompositeDisposable compositeDisposable16 = this.c;
        Disposable subscribe18 = this.H.subscribeOn(this.j.mainThread()).subscribe(new s0(this), t0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe18, "subscribersCardItemStrea…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable16, subscribe18);
        CompositeDisposable compositeDisposable17 = this.c;
        Disposable subscribe19 = this.I.subscribeOn(this.j.mainThread()).subscribe(new y(this), z.a);
        Intrinsics.checkNotNullExpressionValue(subscribe19, "incomeSettingsCardItemSt…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable17, subscribe19);
        CompositeDisposable compositeDisposable18 = this.c;
        Disposable subscribe20 = this.J.observeOn(this.j.mainThread()).subscribe(new s(this), t.a);
        Intrinsics.checkNotNullExpressionValue(subscribe20, "deeplinkClicksItemStream…error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable18, subscribe20);
        CompositeDisposable compositeDisposable19 = this.c;
        Disposable subscribe21 = this.K.subscribeOn(this.j.mainThread()).subscribe(new w0(this), x0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe21, "tfaSettingsClicksItemStr…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable19, subscribe21);
        CompositeDisposable compositeDisposable20 = this.c;
        Disposable subscribe22 = this.L.subscribeOn(this.j.mainThread()).subscribe(new g0(this), h0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe22, "urlClickStream.subscribe…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable20, subscribe22);
        UserProfileResult userProfileResult = this.e;
        if (userProfileResult != null) {
            c(userProfileResult);
        } else {
            b();
        }
    }

    public final void b() {
        this.Q.startProfileLoading();
        UserProfileView userProfileView = this.a;
        if (userProfileView != null) {
            userProfileView.showProgress();
        }
        UserProfileView userProfileView2 = this.a;
        if (userProfileView2 != null) {
            userProfileView2.hideActionsMenu();
        }
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.h.loadProfileInfo().subscribeOn(this.j.io()).observeOn(this.j.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadProfileIn…     }\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void c(UserProfileResult userProfileResult) {
        T t2;
        Image image;
        T t3;
        this.e = userProfileResult;
        List<UserProfileItem> items = userProfileResult.getItems();
        if (items == null) {
            items = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(items, 10));
        int i2 = 0;
        for (T t4 : items) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(this.i.convert(String.valueOf(i2), t4));
            i2 = i3;
        }
        a2.b.a.a.a.s1(CollectionsKt___CollectionsKt.plus((Collection<? extends CardItem.LogoutCardItem>) CollectionsKt___CollectionsKt.filterNotNull(arrayList), new CardItem.LogoutCardItem(String.valueOf(Integer.MAX_VALUE))), this.k);
        UserProfileView userProfileView = this.a;
        if (userProfileView != null) {
            userProfileView.onDataChanged();
        }
        UserProfileView userProfileView2 = this.a;
        if (userProfileView2 != null) {
            userProfileView2.showContent();
        }
        this.R.setup(this.e);
        List<UserProfileItem> items2 = userProfileResult.getItems();
        T t5 = null;
        if (items2 != null) {
            Iterator<T> it = items2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t3 = null;
                    break;
                }
                t3 = it.next();
                if (t3 instanceof InfoItem) {
                    break;
                }
            }
            t2 = t3;
        } else {
            t2 = null;
        }
        InfoItem infoItem = (InfoItem) t2;
        if (infoItem != null) {
            AccountStorageInteractor accountStorageInteractor = this.n;
            String id = infoItem.getId();
            String name = infoItem.getName();
            String email = infoItem.getEmail();
            Avatar avatar = infoItem.getAvatar();
            AccountStorageInteractor.DefaultImpls.save$default(accountStorageInteractor, new ProfileInfo(id, name, email, (avatar == null || (image = avatar.getImage()) == null) ? null : Images.maxSize(image)), null, 2, null).subscribe();
        }
        List<Phone> a3 = a(userProfileResult);
        if (a3 == null) {
            a3 = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterator<T> it2 = a3.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            if (next.isLocked()) {
                t5 = next;
                break;
            }
        }
        if (t5 != null) {
            d();
            return;
        }
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.g = 0;
    }

    public final void d() {
        if (this.g <= 0) {
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
            this.g = instance.getTimeInMillis() + ((long) 3000);
            e();
        }
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void detachRouter() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = null;
        this.R.detachRouter();
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void detachView() {
        this.c.clear();
        this.R.detachView();
        this.a = null;
    }

    public final void e() {
        if (this.g > 0) {
            Disposable disposable = this.d;
            if (disposable == null || disposable.isDisposed()) {
                this.d = this.P.start(this.g).ignoreElements().andThen(this.h.getPhones()).observeOn(this.j.mainThread()).doOnTerminate(new c(this)).subscribe(new d(this), new e(this));
            }
        }
    }

    @NotNull
    public final UserProfileTracker getTracker() {
        return this.Q;
    }

    @Override // com.avito.android.profile.UserProfileView.Presenter
    public void onActionClicked(int i2) {
        this.R.onActionClicked(i2);
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void onAuthenticationSuccess() {
        b();
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        UserProfilePresenter.Router router = this.b;
        if (router != null) {
            router.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void onDeepLinkResult(@Nullable String str) {
        UserProfileView userProfileView;
        if (str != null && (userProfileView = this.a) != null) {
            userProfileView.showSnackbar(str);
        }
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void onPhoneAdded(@Nullable String str) {
        UserProfileView userProfileView;
        if (!(str == null || (userProfileView = this.a) == null)) {
            userProfileView.showSnackbar(str);
        }
        onStateInvalidated();
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void onPhoneAttached() {
        UserProfileView userProfileView = this.a;
        if (userProfileView != null) {
            userProfileView.showSnackbar(this.l.phoneAttached());
        }
        onStateInvalidated();
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void onPhoneRemoved() {
        UserProfileView userProfileView = this.a;
        if (userProfileView != null) {
            userProfileView.showSnackbar(this.l.phoneRemoved());
        }
        onStateInvalidated();
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void onPhoneVerified() {
        UserProfileView userProfileView = this.a;
        if (userProfileView != null) {
            userProfileView.showSnackbar(this.l.phoneVerified());
        }
        onStateInvalidated();
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void onResume() {
        this.R.onResume();
    }

    @Override // com.avito.android.profile.UserProfileView.Presenter
    public void onRetryClicked() {
        b();
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("user_profile", this.e).putBoolean("auth_opened", Boolean.valueOf(this.f)).putLong("update_time", Long.valueOf(this.g));
    }

    @Override // com.avito.android.profile.UserProfilePresenter
    public void onStateInvalidated() {
        b();
    }
}

package com.avito.android.lib.design.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.spinner.Spinner;
import com.avito.android.lib.util.ImageViewExtensionsKt;
import com.avito.android.lib.util.inflater.AvitoLayoutInflater;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Parcels;
import com.avito.android.util.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00022\u00020\u00012\u00020\u0002:\u0004\u0002\u0002B\u0015\b\u0016\u0012\b\u0010\u0002\u001a\u00030\u0002¢\u0006\u0006\b\u0002\u0010\u0002B!\b\u0016\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\n\u0010»\u0001\u001a\u0005\u0018\u00010º\u0001¢\u0006\u0006\b\u0002\u0010\u0002B*\b\u0016\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\n\u0010»\u0001\u001a\u0005\u0018\u00010º\u0001\u0012\u0007\u0010¼\u0001\u001a\u00020!¢\u0006\u0006\b\u0002\u0010\u0002B3\b\u0016\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\n\u0010»\u0001\u001a\u0005\u0018\u00010º\u0001\u0012\u0007\u0010¼\u0001\u001a\u00020!\u0012\u0007\u0010½\u0001\u001a\u00020!¢\u0006\u0006\b\u0002\u0010\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001d\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001d\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001d\u0010 J\u0017\u0010\u001d\u001a\u00020\u00052\b\b\u0001\u0010\"\u001a\u00020!¢\u0006\u0004\b\u001d\u0010#J\u000f\u0010$\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00052\b\b\u0001\u0010&\u001a\u00020!¢\u0006\u0004\b'\u0010#J\r\u0010(\u001a\u00020\u0005¢\u0006\u0004\b(\u0010)J\r\u0010+\u001a\u00020*¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020!¢\u0006\u0004\b.\u0010#J\u0015\u0010/\u001a\u00020\u00052\u0006\u0010-\u001a\u00020!¢\u0006\u0004\b/\u0010#J\r\u00100\u001a\u00020!¢\u0006\u0004\b0\u00101J\u0015\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u00020!¢\u0006\u0004\b3\u0010#J\u001d\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020!¢\u0006\u0004\b3\u00106J\u0015\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0003¢\u0006\u0004\b8\u0010\u0007J\u0015\u0010:\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0003¢\u0006\u0004\b:\u0010\u0007J\r\u0010;\u001a\u00020\u0003¢\u0006\u0004\b;\u0010\rJ\u0015\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0003¢\u0006\u0004\b=\u0010\u0007J\u0015\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0003¢\u0006\u0004\b?\u0010\u0007J\u0015\u0010A\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0003¢\u0006\u0004\bA\u0010\u0007J\u0017\u0010C\u001a\u00020\u00052\b\b\u0001\u0010B\u001a\u00020!¢\u0006\u0004\bC\u0010#J\u0017\u0010C\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u00010D¢\u0006\u0004\bC\u0010FJ\u000f\u0010G\u001a\u0004\u0018\u00010D¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u00052\b\b\u0001\u0010B\u001a\u00020!¢\u0006\u0004\bI\u0010#J\u0017\u0010I\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u00010D¢\u0006\u0004\bI\u0010FJ\u000f\u0010J\u001a\u0004\u0018\u00010D¢\u0006\u0004\bJ\u0010HJ\u0017\u0010K\u001a\u00020\u00052\b\b\u0001\u0010&\u001a\u00020!¢\u0006\u0004\bK\u0010#J\u0017\u0010K\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010L¢\u0006\u0004\bK\u0010MJ\u0017\u0010N\u001a\u00020\u00052\b\b\u0001\u0010&\u001a\u00020!¢\u0006\u0004\bN\u0010#J\u0017\u0010N\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010L¢\u0006\u0004\bN\u0010MJ#\u0010P\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010L2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010L¢\u0006\u0004\bP\u0010QJ#\u0010R\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010L2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010L¢\u0006\u0004\bR\u0010QJ\u0017\u0010T\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010S¢\u0006\u0004\bT\u0010UJ\u0017\u0010W\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010V¢\u0006\u0004\bW\u0010XJ\u0015\u0010[\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b[\u0010\\J\u001f\u0010`\u001a\u00020\u00052\u0006\u0010^\u001a\u00020]2\b\b\u0002\u0010_\u001a\u00020\u0003¢\u0006\u0004\b`\u0010aJ\u0017\u0010b\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\bb\u0010cJ\u0015\u0010e\u001a\u00020\u00052\u0006\u0010d\u001a\u00020!¢\u0006\u0004\be\u0010#J\r\u0010f\u001a\u00020!¢\u0006\u0004\bf\u00101J\u001b\u0010j\u001a\u00020\u00052\f\u0010i\u001a\b\u0012\u0004\u0012\u00020h0g¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\b\u0012\u0004\u0012\u00020h0g¢\u0006\u0004\bl\u0010mJ\u0015\u0010p\u001a\u00020\u00052\u0006\u0010o\u001a\u00020n¢\u0006\u0004\bp\u0010qJ\u0017\u0010r\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\u0004\br\u0010\u000bJ\u0017\u0010s\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bs\u0010\u000bJ\r\u0010t\u001a\u00020\u0005¢\u0006\u0004\bt\u0010)J!\u0010w\u001a\u00020\u00052\b\b\u0002\u0010u\u001a\u00020!2\b\b\u0002\u0010v\u001a\u00020!¢\u0006\u0004\bw\u00106J\u0017\u0010y\u001a\u00020\u00052\b\b\u0001\u0010x\u001a\u00020!¢\u0006\u0004\by\u0010#J\u0017\u0010y\u001a\u00020\u00052\b\u0010x\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\by\u0010cJ\u0015\u0010|\u001a\u00020\u00052\u0006\u0010{\u001a\u00020z¢\u0006\u0004\b|\u0010}J\r\u0010~\u001a\u00020\u0005¢\u0006\u0004\b~\u0010)J\u001a\u0010\u0001\u001a\u00020z2\u0006\u0010\u001a\u00020!H\u0014¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020!H\u0016¢\u0006\u0005\b\u0001\u0010#J\u001a\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020!H\u0016¢\u0006\u0005\b\u0001\u0010#J\u001c\u0010\u0001\u001a\u00020\u00052\t\b\u0001\u0010\u0001\u001a\u00020!H\u0007¢\u0006\u0005\b\u0001\u0010#J\u001a\u0010\u0001\u001a\u00020\u00052\t\b\u0001\u0010\u0001\u001a\u00020!¢\u0006\u0005\b\u0001\u0010#J\u001a\u0010\u0001\u001a\u00020\u00052\u0006\u00109\u001a\u00020*H\u0007¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00052\u0006\u00109\u001a\u00020*H\u0007¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0001\u001a\u00020\u0005¢\u0006\u0005\b\u0001\u0010)J\u000f\u0010\u0001\u001a\u00020\u0005¢\u0006\u0005\b\u0001\u0010)J\u0019\u0010\u0001\u001a\u00020\u00052\b\b\u0001\u0010&\u001a\u00020!¢\u0006\u0005\b\u0001\u0010#J\u0019\u0010\u0001\u001a\u00020\u00052\b\b\u0001\u0010&\u001a\u00020!¢\u0006\u0005\b\u0001\u0010#J\u001c\u0010\u0001\u001a\u00020\u00052\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0005H\u0016¢\u0006\u0005\b\u0001\u0010)J\u001c\u0010\u0001\u001a\u00020\u00052\t\b\u0001\u0010\u0001\u001a\u00020!H\u0016¢\u0006\u0005\b\u0001\u0010#J\u001a\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0003H\u0016¢\u0006\u0005\b\u0001\u0010\u0007J%\u0010\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0001\u001a\u00020!2\t\b\u0002\u0010\u0001\u001a\u00020!¢\u0006\u0005\b\u0001\u00106J6\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!H\u0017¢\u0006\u0006\b\u0001\u0010\u0001J<\u0010\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0001\u001a\u00020!2\t\b\u0002\u0010\u0001\u001a\u00020!2\t\b\u0002\u0010\u0001\u001a\u00020!2\t\b\u0002\u0010\u0001\u001a\u00020!¢\u0006\u0006\b\u0001\u0010\u0001Jj\u0010¥\u0001\u001a\u00020\u00052X\u0010\u0014\u001aT\u0012\u0017\u0012\u0015\u0018\u00010\u001a¢\u0006\u000e\b¡\u0001\u0012\t\b¢\u0001\u0012\u0004\b\b(\u001b\u0012\u0016\u0012\u00140!¢\u0006\u000f\b¡\u0001\u0012\n\b¢\u0001\u0012\u0005\b\b(£\u0001\u0012\u0016\u0012\u00140!¢\u0006\u000f\b¡\u0001\u0012\n\b¢\u0001\u0012\u0005\b\b(¤\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010 \u0001¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u0013\u0010¨\u0001\u001a\u00030§\u0001H\u0016¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u001d\u0010ª\u0001\u001a\u00020\u00052\t\u0010{\u001a\u0005\u0018\u00010§\u0001H\u0016¢\u0006\u0006\bª\u0001\u0010«\u0001J\u0011\u0010¬\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b¬\u0001\u0010)J\u0011\u0010­\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b­\u0001\u0010)J@\u0010²\u0001\u001a\u00020\u0005*\u00030®\u00012\n\u00102\u001a\u00020z\"\u00020!2\u001b\u0010±\u0001\u001a\u0016\u0012\u0005\u0012\u00030®\u0001\u0012\u0004\u0012\u00020\u00050¯\u0001¢\u0006\u0003\b°\u0001H\u0002¢\u0006\u0006\b²\u0001\u0010³\u0001J\u0011\u0010´\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b´\u0001\u0010)J\u0011\u0010µ\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\bµ\u0001\u0010)J\u0011\u0010¶\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b¶\u0001\u0010)J\u001c\u0010¸\u0001\u001a\u00020\u00052\b\u0010·\u0001\u001a\u00030®\u0001H\u0003¢\u0006\u0006\b¸\u0001\u0010¹\u0001J4\u0010¾\u0001\u001a\u00020\u00052\n\u0010»\u0001\u001a\u0005\u0018\u00010º\u00012\t\b\u0002\u0010¼\u0001\u001a\u00020!2\t\b\u0002\u0010½\u0001\u001a\u00020!H\u0002¢\u0006\u0006\b¾\u0001\u0010¿\u0001R\u0018\u0010@\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u0018\u0010>\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Á\u0001R\u0019\u0010Å\u0001\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0018\u0010-\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u0019\u0010È\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010Ç\u0001R\u0019\u0010Ê\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ç\u0001R\u001a\u0010Î\u0001\u001a\u00030Ë\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u001a\u0010Ò\u0001\u001a\u00030Ï\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u0019\u0010\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010Ç\u0001R\u0018\u00107\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Á\u0001R\u0019\u0010Õ\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Ç\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u0016\u0010\u001b\u001a\u00020*8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010,R\u0015\u0010Ø\u0001\u001a\u00020\u00038F@\u0006¢\u0006\u0007\u001a\u0005\bØ\u0001\u0010\rR\u0019\u0010Ù\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b´\u0001\u0010Ç\u0001R\u0019\u0010Û\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Ç\u0001R\u001a\u0010Þ\u0001\u001a\u00030Ü\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010Ý\u0001R\u0019\u0010à\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bß\u0001\u0010Ç\u0001R\u001a\u0010â\u0001\u001a\u00030Ë\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bá\u0001\u0010Í\u0001R\u0019\u0010ä\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bã\u0001\u0010Ç\u0001R\u0019\u0010ç\u0001\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u0018\u0010è\u0001\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\t\u0010æ\u0001R\u0019\u0010ê\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bé\u0001\u0010Ç\u0001R\u0019\u0010ë\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b­\u0001\u0010Ç\u0001R\u0019\u0010í\u0001\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bì\u0001\u0010Á\u0001R\u0019\u0010ï\u0001\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bî\u0001\u0010Á\u0001R\u0019\u0010ð\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010Ç\u0001R\u0019\u0010ñ\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010Ç\u0001R\u001b\u0010ô\u0001\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u0019\u0010ö\u0001\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010Ç\u0001R\u001a\u0010ø\u0001\u001a\u00030Ë\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b÷\u0001\u0010Í\u0001R\u001b\u0010û\u0001\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R\u0019\u0010þ\u0001\u001a\u00020]8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bü\u0001\u0010ý\u0001R\u0019\u0010\u0002\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010Ä\u0001R\u0019\u0010\u0002\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b²\u0001\u0010Ç\u0001R\u0019\u0010\u0002\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010Ç\u0001R\u0019\u0010\u0002\u001a\u00020z8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002¨\u0006\u0002"}, d2 = {"Lcom/avito/android/lib/design/input/Input;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", "singleLine", "", "setSingleLineProperty", "(Z)V", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "isClickable", "()Z", "Landroid/text/TextWatcher;", "watcher", "addTextChangedListener", "(Landroid/text/TextWatcher;)V", "removeTextChangedListener", "Landroid/widget/TextView$OnEditorActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnEditorActionListener", "(Landroid/widget/TextView$OnEditorActionListener;)V", "Landroid/text/method/KeyListener;", "setKeyListener", "(Landroid/text/method/KeyListener;)V", "", "text", "cursorAtEnd", "setText", "(Ljava/lang/CharSequence;Z)V", "Landroid/text/Editable;", "(Landroid/text/Editable;)V", "", "textRes", "(I)V", "getText", "()Landroid/text/Editable;", "color", "setTextColor", "clearInputFocus", "()V", "", "getDeformattedText", "()Ljava/lang/String;", "maxLength", "setFormattedMaxLength", "setMaxLength", "getMaxLength", "()I", FirebaseAnalytics.Param.INDEX, "setSelection", Tracker.Events.CREATIVE_START, "stop", "(II)V", "withClearButton", "setClearButton", "value", "setClearButtonVisibleUnfocused", "getClearButton", "isLoading", "setLoading", "focusByClearButton", "setFocusByClearButton", "selectionToEndOnFocus", "setSelectionToEndOnFocus", "iconRes", "setLeftIcon", "Landroid/graphics/drawable/Drawable;", "icon", "(Landroid/graphics/drawable/Drawable;)V", "getLeftIcon", "()Landroid/graphics/drawable/Drawable;", "setRightIcon", "getRightIcon", "setLeftIconColor", "Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "setRightIconColor", "rippleColor", "setLeftIconBackgroundColor", "(Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V", "setRightIconBackgroundColor", "Landroid/view/View$OnFocusChangeListener;", "setFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "Landroid/view/View$OnTouchListener;", "setTouchListener", "(Landroid/view/View$OnTouchListener;)V", "Lcom/avito/android/lib/design/input/ComponentType;", "componentType", "setComponentType", "(Lcom/avito/android/lib/design/input/ComponentType;)V", "Lcom/avito/android/lib/design/input/FormatterType;", "formatterTypeArg", "overridePrefixAndPostfix", "setFormatterType", "(Lcom/avito/android/lib/design/input/FormatterType;Z)V", "setTextWithoutWatcher", "(Ljava/lang/CharSequence;)V", "inputType", "setInputType", "getInputType", "", "Landroid/text/InputFilter;", "filters", "setFilters", "([Landroid/text/InputFilter;)V", "getFilters", "()[Landroid/text/InputFilter;", "Landroid/text/method/TransformationMethod;", "method", "setTransformationMethod", "(Landroid/text/method/TransformationMethod;)V", "setLeftIconListener", "setRightIconListener", "setSingleLine", "maxLines", "minLines", "setMultiLine", "hint", "setHint", "", "state", "setState", "([I)V", "showKeyboard", "extraSpace", "onCreateDrawableState", "(I)[I", "minHeight", "setMinimumHeight", "minWidth", "setMinimumWidth", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setClearButtonAppearance", "setSpinnerAppearance", "setPostfix", "(Ljava/lang/String;)V", "setPrefix", "removePostfix", "removePrefix", "setPrefixColor", "setPostfixColor", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "refreshDrawableState", "setAppearance", "enabled", "setEnabled", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "setDefaultTextPaddings", "top", "bottom", "setPadding", "(IIII)V", "changePadding", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "selStart", "selEnd", "setOnSelectionChangedListener", "(Lkotlin/jvm/functions/Function3;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "f", "c", "Landroid/content/res/TypedArray;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", AuthSource.BOOKING_ORDER, "(Landroid/content/res/TypedArray;[ILkotlin/jvm/functions/Function1;)V", a2.g.r.g.a, "i", "h", "array", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "d", "(Landroid/util/AttributeSet;II)V", "t", "Z", "s", "B", "Ljava/lang/String;", "postfix", "C", "I", "rightIconContainerHeight", "u", "inputPaddingLeft", "Landroid/widget/ImageView;", "k", "Landroid/widget/ImageView;", "rightIcon", "Lcom/avito/android/lib/design/spinner/Spinner;", "n", "Lcom/avito/android/lib/design/spinner/Spinner;", "spinner", VKApiConst.Q, "H", "prefixColor", "G", "Landroid/text/TextUtils$TruncateAt;", "isEditTextFocused", "iconBackgroundSize", "J", "textAppearance", "Lcom/avito/android/lib/design/input/InputField;", "Lcom/avito/android/lib/design/input/InputField;", "editText", "w", "inputPaddingRight", "o", "clearButton", "e", "rightIconContainerWidth", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/FrameLayout;", "rightContainer", "leftContainer", "x", "inputPaddingBottom", "leftIconContainerWidth", "r", "withClearButtonVisibleUnfocused", ExifInterface.LONGITUDE_EAST, "isSingleLine", "postfixColor", "defaultPaddingLeft", "F", "Landroid/text/method/KeyListener;", "onKeyListener", VKApiConst.VERSION, "inputPaddingTop", "j", "leftIcon", "p", "Landroid/view/View$OnFocusChangeListener;", "focusChangeListener", "D", "Lcom/avito/android/lib/design/input/FormatterType;", "formatterType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "prefix", "defaultPaddingRight", "leftIconContainerHeight", "y", "[I", "currentState", "z", "Landroid/text/TextWatcher;", "maskTextWatcher", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "SavedState", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Input extends FrameLayout implements AppearanceChangeableView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final int[] K = new int[0];
    @NotNull
    public static final int[] L = {R.attr.state_error};
    @NotNull
    public static final int[] M = {R.attr.state_warning};
    @NotNull
    public static final AvitoLayoutInflater.FactoryData N;
    public String A;
    public String B;
    public int C;
    public FormatterType D;
    public boolean E;
    public KeyListener F;
    public TextUtils.TruncateAt G;
    public int H;
    public int I;
    public int J;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final InputField i;
    public final ImageView j;
    public final ImageView k;
    public final FrameLayout l;
    public final FrameLayout m;
    public final Spinner n;
    public final ImageView o;
    public View.OnFocusChangeListener p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int[] y;
    public TextWatcher z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/lib/design/input/Input$Companion;", "", "", "STATE_WARNING", "[I", "getSTATE_WARNING", "()[I", "STATE_NORMAL", "getSTATE_NORMAL", "STATE_ERROR", "getSTATE_ERROR", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "factory", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "getFactory", "()Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final AvitoLayoutInflater.FactoryData getFactory() {
            return Input.N;
        }

        @NotNull
        public final int[] getSTATE_ERROR() {
            return Input.L;
        }

        @NotNull
        public final int[] getSTATE_NORMAL() {
            return Input.K;
        }

        @NotNull
        public final int[] getSTATE_WARNING() {
            return Input.M;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ComponentType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            ComponentType componentType = ComponentType.INPUT;
            iArr[0] = 1;
            ComponentType componentType2 = ComponentType.SELECT;
            iArr[1] = 2;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<TypedArray, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(TypedArray typedArray) {
            int i = this.a;
            if (i == 0) {
                TypedArray typedArray2 = typedArray;
                Intrinsics.checkNotNullParameter(typedArray2, "$receiver");
                Views.setBackgroundCompat(((Input) this.b).i, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, typedArray2.getColorStateList(com.avito.android.lib.design.R.styleable.Input_input_backgroundColor), typedArray2.getColorStateList(com.avito.android.lib.design.R.styleable.Input_input_backgroundRipple), typedArray2.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.Input_input_cornerRadius, 0), typedArray2.getColorStateList(com.avito.android.lib.design.R.styleable.Input_input_borderColor), typedArray2.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.Input_input_borderWidth, 0), 0, 0, 96, null));
                return Unit.INSTANCE;
            } else if (i == 1) {
                TypedArray typedArray3 = typedArray;
                Intrinsics.checkNotNullParameter(typedArray3, "$receiver");
                Input.changePadding$default((Input) this.b, 0, typedArray3.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.Input_android_paddingTop, 0), 0, typedArray3.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.Input_android_paddingBottom, 0), 5, null);
                return Unit.INSTANCE;
            } else if (i == 2) {
                TypedArray typedArray4 = typedArray;
                Intrinsics.checkNotNullParameter(typedArray4, "$receiver");
                ((Input) this.b).d = typedArray4.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.Input_input_iconLeftContainerHeight, 0);
                ((Input) this.b).c = typedArray4.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.Input_input_iconLeftContainerWidth, 0);
                ViewGroup.LayoutParams layoutParams = ((Input) this.b).l.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = ((Input) this.b).d;
                }
                ViewGroup.LayoutParams layoutParams2 = ((Input) this.b).l.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = ((Input) this.b).c;
                }
                ((Input) this.b).l.requestLayout();
                ((Input) this.b).h();
                return Unit.INSTANCE;
            } else if (i == 3) {
                TypedArray typedArray5 = typedArray;
                Intrinsics.checkNotNullParameter(typedArray5, "$receiver");
                ((Input) this.b).f = typedArray5.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.Input_input_iconRightContainerHeight, 0);
                ((Input) this.b).e = typedArray5.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.Input_input_iconRightContainerWidth, 0);
                ViewGroup.LayoutParams layoutParams3 = ((Input) this.b).m.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = ((Input) this.b).f;
                }
                ViewGroup.LayoutParams layoutParams4 = ((Input) this.b).m.getLayoutParams();
                if (layoutParams4 != null) {
                    layoutParams4.width = ((Input) this.b).e;
                }
                ((Input) this.b).m.requestLayout();
                ((Input) this.b).i();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b implements View.OnFocusChangeListener {
        public final /* synthetic */ Input a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.f();
                if (this.a.a.t) {
                    Input.access$setSelectionToTheEnd(this.a.a);
                }
            }
        }

        public b(Input input) {
            this.a = input;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            View.OnFocusChangeListener onFocusChangeListener = this.a.p;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(this.a, z);
            }
            this.a.post(new a(this));
            Input input = this.a;
            input.setText(input.i.getText());
            this.a.c();
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Input a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Input input) {
            super(1);
            this.a = input;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            this.a.post(new a2.a.a.k1.a.d.a(this));
            return Unit.INSTANCE;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ Input a;

        public d(Input input) {
            this.a = input;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.i.setText((CharSequence) null);
            if (this.a.s && this.a.i.isFocusable()) {
                Keyboards.showKeyboard$default(this.a.i, 0, 1, null);
            }
        }
    }

    public static final class f extends Lambda implements Function1<TypedArray, Unit> {
        public final /* synthetic */ Input a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Input input) {
            super(1);
            this.a = input;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(TypedArray typedArray) {
            TypedArray typedArray2 = typedArray;
            Intrinsics.checkNotNullParameter(typedArray2, "$receiver");
            this.a.setMultiLine(typedArray2.getInt(com.avito.android.lib.design.R.styleable.Input_android_maxLines, Integer.MAX_VALUE), typedArray2.getInt(com.avito.android.lib.design.R.styleable.Input_android_minLines, 1));
            return Unit.INSTANCE;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ View.OnClickListener b;

        public g(ImageView imageView, View.OnClickListener onClickListener) {
            this.a = imageView;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.onClick(this.a);
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ View.OnClickListener b;

        public h(ImageView imageView, View.OnClickListener onClickListener) {
            this.a = imageView;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.onClick(this.a);
        }
    }

    static {
        AvitoLayoutInflater avitoLayoutInflater = AvitoLayoutInflater.INSTANCE;
        N = avitoLayoutInflater.create(avitoLayoutInflater.getINPUT(), e.a);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Input(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = getContext().getResources();
        int i2 = com.avito.android.lib.design.R.dimen.input_padding;
        this.a = resources.getDimensionPixelSize(i2);
        this.b = getContext().getResources().getDimensionPixelSize(i2);
        this.q = true;
        this.t = true;
        this.y = new int[0];
        this.A = "";
        this.B = "";
        this.C = Integer.MAX_VALUE;
        this.D = FormatterType.Companion.getSIMPLE();
        this.E = true;
        Context context2 = getContext();
        int i3 = com.avito.android.lib.design.R.attr.black;
        this.H = Contexts.getColorByAttr(context2, i3);
        this.I = Contexts.getColorByAttr(getContext(), i3);
        View inflate = LayoutInflater.from(getContext()).inflate(com.avito.android.lib.design.R.layout.design_input, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        View findViewById = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_value);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.input.InputField");
        InputField inputField = (InputField) findViewById;
        this.i = inputField;
        View findViewById2 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_left_icon);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.j = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_right_icon);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.k = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_clear);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById4;
        this.o = imageView;
        View findViewById5 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_spinner);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.spinner.Spinner");
        this.n = (Spinner) findViewById5;
        View findViewById6 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_left_container);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.l = (FrameLayout) findViewById6;
        View findViewById7 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_right_container);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.m = (FrameLayout) findViewById7;
        inputField.setId(-1);
        this.F = inputField.getKeyListener();
        inputField.setOnFocusChangeListener(new b(this));
        InputExtensionsKt.addTextChangedListener(this, new c(this));
        imageView.setOnClickListener(new d(this));
        e(this, null, 0, 0, 6);
    }

    public static final void access$setSelectionToTheEnd(Input input) {
        String prefix;
        String prefix2;
        if (input.i.hasFocus()) {
            MaskParameters maskParameters = input.D.getMaskParameters();
            int length = (maskParameters == null || (prefix2 = maskParameters.getPrefix()) == null) ? 0 : prefix2.length();
            MaskParameters maskParameters2 = input.D.getMaskParameters();
            int length2 = (maskParameters2 == null || (prefix = maskParameters2.getPrefix()) == null) ? 0 : prefix.length();
            Editable text = input.i.getText();
            input.i.setSelection(Math.max(length, text != null ? text.length() : 0 - length2));
        }
    }

    public static /* synthetic */ void changePadding$default(Input input, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = input.u;
        }
        if ((i6 & 2) != 0) {
            i3 = input.v;
        }
        if ((i6 & 4) != 0) {
            i4 = input.w;
        }
        if ((i6 & 8) != 0) {
            i5 = input.x;
        }
        input.changePadding(i2, i3, i4, i5);
    }

    public static /* synthetic */ void e(Input input, AttributeSet attributeSet, int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        input.d(attributeSet, i2, i3);
    }

    private final String getText() {
        return String.valueOf(this.i.getText());
    }

    public static /* synthetic */ void setDefaultTextPaddings$default(Input input, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = input.a;
        }
        if ((i4 & 2) != 0) {
            i3 = input.b;
        }
        input.setDefaultTextPaddings(i2, i3);
    }

    public static /* synthetic */ void setFormatterType$default(Input input, FormatterType formatterType, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        input.setFormatterType(formatterType, z2);
    }

    public static /* synthetic */ void setLeftIconBackgroundColor$default(Input input, ColorStateList colorStateList, ColorStateList colorStateList2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            colorStateList2 = null;
        }
        input.setLeftIconBackgroundColor(colorStateList, colorStateList2);
    }

    public static /* synthetic */ void setMultiLine$default(Input input, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        input.setMultiLine(i2, i3);
    }

    public static /* synthetic */ void setRightIconBackgroundColor$default(Input input, ColorStateList colorStateList, ColorStateList colorStateList2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            colorStateList2 = null;
        }
        input.setRightIconBackgroundColor(colorStateList, colorStateList2);
    }

    private final void setSingleLineProperty(boolean z2) {
        if (z2) {
            setSingleLine();
        } else {
            setMultiLine$default(this, 0, 0, 3, null);
        }
    }

    public static /* synthetic */ void setText$default(Input input, CharSequence charSequence, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        input.setText(charSequence, z2);
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void a(TypedArray typedArray) {
        int i2 = com.avito.android.lib.design.R.styleable.Input_input_iconLeftColor;
        if (typedArray.hasValue(i2)) {
            setLeftIconColor(typedArray.getColorStateList(i2));
        }
        int i3 = com.avito.android.lib.design.R.styleable.Input_input_iconRightColor;
        if (typedArray.hasValue(i3)) {
            setRightIconColor(typedArray.getColorStateList(i3));
        }
        int i4 = com.avito.android.lib.design.R.styleable.Input_android_inputType;
        if (typedArray.hasValue(i4)) {
            this.i.setInputType(typedArray.getInt(i4, 0));
        }
        int i5 = com.avito.android.lib.design.R.styleable.Input_android_textAppearance;
        if (typedArray.hasValue(i5)) {
            int resourceId = typedArray.getResourceId(i5, 0);
            this.J = resourceId;
            TextViews.setTextAppearanceCompat(this.i, resourceId);
        }
        int i6 = com.avito.android.lib.design.R.styleable.Input_android_textColor;
        if (typedArray.hasValue(i6)) {
            this.i.setTextColor(typedArray.getColorStateList(i6));
        }
        int i7 = com.avito.android.lib.design.R.styleable.Input_android_textColorHint;
        if (typedArray.hasValue(i7)) {
            this.i.setHintTextColor(typedArray.getColorStateList(i7));
        }
        int i8 = com.avito.android.lib.design.R.styleable.Input_input_prefixColor;
        ColorStateList textColors = this.i.getTextColors();
        Intrinsics.checkNotNullExpressionValue(textColors, "editText.textColors");
        this.H = typedArray.getColor(i8, textColors.getDefaultColor());
        int i9 = com.avito.android.lib.design.R.styleable.Input_input_postfixColor;
        ColorStateList textColors2 = this.i.getTextColors();
        Intrinsics.checkNotNullExpressionValue(textColors2, "editText.textColors");
        this.I = typedArray.getColor(i9, textColors2.getDefaultColor());
        b(typedArray, new int[]{com.avito.android.lib.design.R.styleable.Input_input_backgroundColor, com.avito.android.lib.design.R.styleable.Input_input_borderColor}, new a(0, this));
        int i10 = com.avito.android.lib.design.R.styleable.Input_input_formatterType;
        FormatterType.Companion companion = FormatterType.Companion;
        FormatterType byId = companion.byId(typedArray.getInt(i10, companion.getSIMPLE().getId()));
        this.D = byId;
        setFormatterType$default(this, byId, false, 2, null);
        b(typedArray, new int[]{com.avito.android.lib.design.R.styleable.Input_android_paddingTop, com.avito.android.lib.design.R.styleable.Input_android_paddingBottom}, new a(1, this));
        int i11 = com.avito.android.lib.design.R.styleable.Input_input_iconBackgroundSize;
        if (typedArray.hasValue(i11)) {
            this.g = typedArray.getDimensionPixelSize(i11, 0);
        }
        b(typedArray, new int[]{com.avito.android.lib.design.R.styleable.Input_input_iconLeftContainerHeight, com.avito.android.lib.design.R.styleable.Input_input_iconLeftContainerWidth}, new a(2, this));
        b(typedArray, new int[]{com.avito.android.lib.design.R.styleable.Input_input_iconRightContainerHeight, com.avito.android.lib.design.R.styleable.Input_input_iconRightContainerWidth}, new a(3, this));
        int i12 = com.avito.android.lib.design.R.styleable.Input_input_iconLeftBackgroundColor;
        if (typedArray.hasValue(i12)) {
            setLeftIconBackgroundColor(typedArray.getColorStateList(i12), typedArray.getColorStateList(com.avito.android.lib.design.R.styleable.Input_input_iconLeftBackgroundRipple));
        }
        int i13 = com.avito.android.lib.design.R.styleable.Input_input_iconRightBackgroundColor;
        if (typedArray.hasValue(i13)) {
            setRightIconBackgroundColor(typedArray.getColorStateList(i13), typedArray.getColorStateList(com.avito.android.lib.design.R.styleable.Input_input_iconRightBackgroundRipple));
        }
        int i14 = com.avito.android.lib.design.R.styleable.Input_input_clearButtonAppearance;
        if (typedArray.hasValue(i14)) {
            setClearButtonAppearance(typedArray.getResourceId(i14, 0));
        }
        int i15 = com.avito.android.lib.design.R.styleable.Input_input_spinnerStyle;
        if (typedArray.hasValue(i15)) {
            setSpinnerAppearance(typedArray.getResourceId(i15, 0));
        }
        g();
        int i16 = com.avito.android.lib.design.R.styleable.Input_input_componentType;
        if (typedArray.hasValue(i16)) {
            setComponentType(ComponentType.Companion.byId(typedArray.getInt(i16, ComponentType.INPUT.getId())));
        }
        int i17 = com.avito.android.lib.design.R.styleable.Input_android_imeOptions;
        if (typedArray.hasValue(i17)) {
            this.i.setImeOptions(typedArray.getInt(i17, 0));
        }
    }

    public final void addTextChangedListener(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "watcher");
        this.i.addTextChangedListener(textWatcher);
    }

    public final void b(TypedArray typedArray, int[] iArr, Function1<? super TypedArray, Unit> function1) {
        Integer num;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                num = null;
                break;
            }
            int i3 = iArr[i2];
            if (typedArray.hasValue(i3)) {
                num = Integer.valueOf(i3);
                break;
            }
            i2++;
        }
        if (num != null) {
            num.intValue();
            function1.invoke(typedArray);
        }
    }

    public final void c() {
        int inputType = this.i.getInputType();
        if (this.G == null) {
            return;
        }
        if (!this.i.hasFocus()) {
            this.i.setKeyListener(null);
            this.i.setEllipsize(this.G);
            return;
        }
        this.i.setInputType(inputType);
        this.i.setKeyListener(this.F);
    }

    public final void changePadding(int i2, int i3, int i4, int i5) {
        this.u = i2;
        this.w = i4;
        this.v = i3;
        this.x = i5;
        this.i.setPadding(i2, i3, i4, i5);
    }

    public final void clearInputFocus() {
        if (this.i.hasFocus()) {
            this.i.clearFocus();
        }
    }

    public final void d(AttributeSet attributeSet, int i2, int i3) {
        Integer valueOf = Integer.valueOf(i2);
        TextUtils.TruncateAt truncateAt = null;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : com.avito.android.lib.design.R.attr.input;
        Integer valueOf2 = Integer.valueOf(i3);
        if (!(valueOf2.intValue() > 0)) {
            valueOf2 = null;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.avito.android.lib.design.R.styleable.Input, intValue, valueOf2 != null ? valueOf2.intValue() : com.avito.android.lib.design.R.style.Design_Widget_Input);
        this.h = obtainStyledAttributes.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.Input_android_minHeight, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        setLeftIcon(obtainStyledAttributes.getDrawable(com.avito.android.lib.design.R.styleable.Input_android_drawableLeft));
        setRightIcon(obtainStyledAttributes.getDrawable(com.avito.android.lib.design.R.styleable.Input_android_drawableRight));
        setHint(obtainStyledAttributes.getString(com.avito.android.lib.design.R.styleable.Input_android_hint));
        setText$default(this, obtainStyledAttributes.getString(com.avito.android.lib.design.R.styleable.Input_android_text), false, 2, null);
        setLoading(obtainStyledAttributes.getBoolean(com.avito.android.lib.design.R.styleable.Input_input_loading, false));
        setFocusByClearButton(obtainStyledAttributes.getBoolean(com.avito.android.lib.design.R.styleable.Input_input_focusByClearButton, false));
        String string = obtainStyledAttributes.getString(com.avito.android.lib.design.R.styleable.Input_input_postfix);
        String str = "";
        if (string == null) {
            string = str;
        }
        Intrinsics.checkNotNullExpressionValue(string, "getString(it) ?: \"\"");
        setPostfix(string);
        String string2 = obtainStyledAttributes.getString(com.avito.android.lib.design.R.styleable.Input_input_prefix);
        if (string2 != null) {
            str = string2;
        }
        Intrinsics.checkNotNullExpressionValue(str, "getString(it) ?: \"\"");
        setPrefix(str);
        int i4 = com.avito.android.lib.design.R.styleable.Input_input_selectionToEndOnFocus;
        if (obtainStyledAttributes.hasValue(i4)) {
            setSelectionToEndOnFocus(obtainStyledAttributes.getBoolean(i4, true));
        }
        int i5 = com.avito.android.lib.design.R.styleable.Input_input_clearButton;
        if (obtainStyledAttributes.hasValue(i5)) {
            setClearButton(obtainStyledAttributes.getBoolean(i5, true));
        }
        int i6 = com.avito.android.lib.design.R.styleable.Input_input_clearButtonUnfocused;
        if (obtainStyledAttributes.hasValue(i6)) {
            setClearButtonVisibleUnfocused(obtainStyledAttributes.getBoolean(i6, true));
        }
        int i7 = com.avito.android.lib.design.R.styleable.Input_android_maxLength;
        if (obtainStyledAttributes.hasValue(i7)) {
            setMaxLength(obtainStyledAttributes.getInt(i7, this.C));
        }
        int i8 = com.avito.android.lib.design.R.styleable.Input_android_ellipsize;
        if (obtainStyledAttributes.hasValue(i8)) {
            int i9 = obtainStyledAttributes.getInt(i8, 0);
            if (i9 == 1) {
                truncateAt = TextUtils.TruncateAt.START;
            } else if (i9 == 2) {
                truncateAt = TextUtils.TruncateAt.MIDDLE;
            } else if (i9 == 3) {
                truncateAt = TextUtils.TruncateAt.END;
            } else if (i9 == 4) {
                truncateAt = TextUtils.TruncateAt.MARQUEE;
            }
            if (truncateAt == null) {
                truncateAt = this.G;
            }
            setEllipsize(truncateAt);
        }
        setSingleLineProperty(obtainStyledAttributes.getBoolean(com.avito.android.lib.design.R.styleable.Input_android_singleLine, true));
        setMinimumHeight(this.h);
        b(obtainStyledAttributes, new int[]{com.avito.android.lib.design.R.styleable.Input_android_maxLines, com.avito.android.lib.design.R.styleable.Input_android_minLines}, new f(this));
        int i10 = com.avito.android.lib.design.R.styleable.Input_android_autofillHints;
        if (obtainStyledAttributes.hasValue(i10) && Build.VERSION.SDK_INT >= 26) {
            this.i.setAutofillHints(new String[]{obtainStyledAttributes.getString(i10)});
        }
        int i11 = com.avito.android.lib.design.R.styleable.Input_android_importantForAutofill;
        if (obtainStyledAttributes.hasValue(i11) && Build.VERSION.SDK_INT >= 26) {
            this.i.setImportantForAutofill(obtainStyledAttributes.getInt(i11, 0));
        }
        obtainStyledAttributes.recycle();
        super.setPadding(0, 0, 0, 0);
    }

    public final void f() {
        boolean z2;
        boolean z3 = true;
        boolean z4 = getRightIcon() != null;
        String deformattedText = getDeformattedText();
        Objects.requireNonNull(deformattedText, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj = StringsKt__StringsKt.trim(deformattedText).toString();
        if (this.q) {
            if ((obj.length() > 0) && !z4) {
                z2 = true;
                boolean z5 = !z2 && (this.r || (!isEnabled() && this.i.isFocused()));
                Views.setVisible(this.o, z5);
                ImageView imageView = this.k;
                if (!z4 || z5) {
                    z3 = false;
                }
                Views.setVisible(imageView, z3);
                i();
            }
        }
        z2 = false;
        if (!z2) {
        }
        Views.setVisible(this.o, z5);
        ImageView imageView = this.k;
        z3 = false;
        Views.setVisible(imageView, z3);
        i();
    }

    public final void g() {
        int i2;
        int i3;
        FrameLayout frameLayout = this.l;
        FrameLayout frameLayout2 = null;
        if (!Views.isVisible(frameLayout)) {
            frameLayout = null;
        }
        if (frameLayout != null) {
            i2 = this.c;
        } else {
            i2 = this.a;
        }
        FrameLayout frameLayout3 = this.m;
        if (Views.isVisible(frameLayout3)) {
            frameLayout2 = frameLayout3;
        }
        if (frameLayout2 != null) {
            i3 = this.e;
        } else {
            i3 = this.b;
        }
        changePadding$default(this, i2, 0, i3, 0, 10, null);
    }

    public final boolean getClearButton() {
        return this.q;
    }

    @NotNull
    public final String getDeformattedText() {
        String str;
        Editable text = this.i.getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            return str;
        }
        return CustomMaskFormatterKt.deformatText(this.D, str);
    }

    @NotNull
    public final InputFilter[] getFilters() {
        InputFilter[] filters = this.i.getFilters();
        return filters != null ? filters : new InputFilter[0];
    }

    public final int getInputType() {
        return this.i.getInputType();
    }

    @Nullable
    public final Drawable getLeftIcon() {
        return this.j.getDrawable();
    }

    public final int getMaxLength() {
        return this.C;
    }

    @Nullable
    public final Drawable getRightIcon() {
        return this.k.getDrawable();
    }

    public final void h() {
        Views.setVisible(this.l, Views.isVisible(this.j) || Views.isVisible(this.n));
        g();
    }

    public final void i() {
        Views.setVisible(this.m, Views.isVisible(this.k) || Views.isVisible(this.o));
        g();
    }

    @Override // android.view.View
    public boolean isClickable() {
        return this.i.isClickable();
    }

    public final boolean isEditTextFocused() {
        return this.i.isFocused();
    }

    @Override // android.view.View, android.view.ViewGroup
    @NotNull
    public int[] onCreateDrawableState(int i2) {
        int[] mergeDrawableStates = View.mergeDrawableStates(super.onCreateDrawableState(i2 + this.y.length), this.y);
        Intrinsics.checkNotNullExpressionValue(mergeDrawableStates, "View.mergeDrawableStates(states, currentState)");
        return mergeDrawableStates;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.i.onRestoreInstanceState(savedState.getEditState());
            setState(savedState.getCurrentState());
            FormatterType formatterType = this.D;
            this.D = savedState.getFormatterState();
            this.i.removeTextChangedListener(this.z);
            this.i.setText(CustomMaskFormatterKt.deformatText(formatterType, String.valueOf(m90getText())));
            if (this.D.getMaskParameters() != null) {
                InputField inputField = this.i;
                FormatterType formatterType2 = this.D;
                this.z = CustomMaskFormatterKt.afterMaskedTextChanged(inputField, formatterType2, formatterType2, this.H, this.I);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        int[] iArr = this.y;
        Parcelable onSaveInstanceState = this.i.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "editText.onSaveInstanceState()!!");
        FormatterType formatterType = this.D;
        Parcelable onSaveInstanceState2 = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState2);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState2, "super.onSaveInstanceState()!!");
        return new SavedState(iArr, onSaveInstanceState, formatterType, onSaveInstanceState2);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        this.i.refreshDrawableState();
    }

    public final void removePostfix() {
        this.B = "";
        setFormatterType(this.D, true);
    }

    public final void removePrefix() {
        this.A = "";
        setFormatterType(this.D, true);
    }

    public final void removeTextChangedListener(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "watcher");
        this.i.removeTextChangedListener(textWatcher);
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(@StyleRes int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i2, com.avito.android.lib.design.R.styleable.Input);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i2) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i2);
    }

    public final void setClearButton(boolean z2) {
        this.q = z2;
        f();
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void setClearButtonAppearance(@StyleRes int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i2, com.avito.android.lib.design.R.styleable.Input_ClearButton);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        ImageViewsKt.setImageTintListCompat(this.o, obtainStyledAttributes.getColorStateList(com.avito.android.lib.design.R.styleable.Input_ClearButton_input_iconColor));
        ImageViewExtensionsKt.setBackground(this.o, Math.max(0, (this.e - this.g) / 2), Math.max(0, (this.f - this.g) / 2), obtainStyledAttributes.getColorStateList(com.avito.android.lib.design.R.styleable.Input_ClearButton_input_iconBackgroundColor), obtainStyledAttributes.getColorStateList(com.avito.android.lib.design.R.styleable.Input_ClearButton_input_iconBackgroundRipple));
        obtainStyledAttributes.recycle();
    }

    public final void setClearButtonVisibleUnfocused(boolean z2) {
        this.r = z2;
        f();
    }

    public final void setComponentType(@NotNull ComponentType componentType) {
        Intrinsics.checkNotNullParameter(componentType, "componentType");
        int ordinal = componentType.ordinal();
        if (ordinal == 0) {
            this.i.setFocusable(true);
            this.i.setFocusableInTouchMode(true);
            this.i.setCursorVisible(true);
        } else if (ordinal == 1) {
            this.i.setFocusable(false);
            this.i.setFocusableInTouchMode(false);
            this.i.setCursorVisible(false);
        }
    }

    public final void setDefaultTextPaddings(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public final void setEllipsize(@Nullable TextUtils.TruncateAt truncateAt) {
        this.G = truncateAt;
        c();
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.i.setEnabled(z2);
        this.j.setEnabled(z2);
        this.k.setEnabled(z2);
        this.i.setText(getText());
        f();
    }

    public final void setFilters(@NotNull InputFilter[] inputFilterArr) {
        Intrinsics.checkNotNullParameter(inputFilterArr, "filters");
        this.i.setFilters(inputFilterArr);
    }

    public final void setFocusByClearButton(boolean z2) {
        this.s = z2;
    }

    public final void setFocusChangeListener(@Nullable View.OnFocusChangeListener onFocusChangeListener) {
        this.p = onFocusChangeListener;
    }

    public final void setFormattedMaxLength(int i2) {
        this.C = i2;
        this.i.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0088 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0156  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setFormatterType(@org.jetbrains.annotations.NotNull com.avito.android.lib.design.input.FormatterType r27, boolean r28) {
        /*
        // Method dump skipped, instructions count: 367
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.input.Input.setFormatterType(com.avito.android.lib.design.input.FormatterType, boolean):void");
    }

    public final void setHint(@StringRes int i2) {
        setHint(getContext().getString(i2));
    }

    public final void setInputType(int i2) {
        this.i.setInputType(i2);
        TextViews.setTextAppearanceCompat(this.i, this.J);
    }

    public final void setKeyListener(@Nullable KeyListener keyListener) {
        this.F = keyListener;
        this.i.setKeyListener(keyListener);
    }

    public final void setLeftIcon(@DrawableRes int i2) {
        setLeftIcon(getContext().getDrawable(i2));
    }

    public final void setLeftIconBackgroundColor(@Nullable ColorStateList colorStateList, @Nullable ColorStateList colorStateList2) {
        ImageViewExtensionsKt.setBackground(this.j, Math.max(0, (this.c - this.g) / 2), Math.max(0, (this.d - this.g) / 2), colorStateList, colorStateList2);
    }

    public final void setLeftIconColor(@ColorInt int i2) {
        setLeftIconColor(ColorStateList.valueOf(i2));
    }

    public final void setLeftIconListener(@Nullable View.OnClickListener onClickListener) {
        ImageView imageView = this.j;
        if (onClickListener != null) {
            imageView.setOnClickListener(new g(imageView, onClickListener));
        } else {
            imageView.setOnClickListener(null);
        }
        imageView.setClickable(onClickListener != null);
    }

    public final void setLoading(boolean z2) {
        boolean z3 = true;
        boolean z4 = getLeftIcon() != null;
        Views.setVisible(this.n, z2);
        ImageView imageView = this.j;
        if (z2 || !z4) {
            z3 = false;
        }
        Views.setVisible(imageView, z3);
        h();
    }

    public final void setMaxLength(int i2) {
        MaskParameters maskParameters;
        int i3;
        if (!(i2 == Integer.MAX_VALUE || (maskParameters = this.D.getMaskParameters()) == null)) {
            int length = maskParameters.getPostfix().length() + maskParameters.getPrefix().length() + i2;
            if (maskParameters.isReversedMask()) {
                i3 = 0;
                int i4 = 0;
                for (int length2 = maskParameters.getMask().length() - 1; length2 >= 0; length2--) {
                    if (maskParameters.getMask().charAt(length2) == '#') {
                        i4++;
                    } else {
                        i3++;
                    }
                    if (i4 >= i2) {
                        break;
                    }
                }
            } else {
                int length3 = maskParameters.getMask().length();
                i3 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < length3; i6++) {
                    if (maskParameters.getMask().charAt(i6) == '#') {
                        i5++;
                    } else {
                        i3++;
                    }
                    if (i5 >= i2) {
                        break;
                    }
                }
            }
            i2 = length + i3;
        }
        this.C = i2;
        this.i.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.h = i2;
        this.i.setMinHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.i.setMinWidth(i2);
    }

    public final void setMultiLine(int i2, int i3) {
        this.E = false;
        InputField inputField = this.i;
        inputField.setSingleLine(false);
        inputField.setMaxLines(i2);
        inputField.setMinLines(i3);
        inputField.setGravity(48);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
    }

    public final void setOnEditorActionListener(@Nullable TextView.OnEditorActionListener onEditorActionListener) {
        this.i.setOnEditorActionListener(onEditorActionListener);
    }

    public final void setOnSelectionChangedListener(@Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Unit> function3) {
        this.i.setOnSelectionChangedListener(function3);
    }

    @Override // android.view.View
    @Deprecated(message = "Don't use", replaceWith = @ReplaceWith(expression = "changePadding(left = left, top = top, right = right, bottom = bottom)", imports = {}))
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(0, 0, 0, 0);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void setPostfix(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.B = str;
        setFormatterType$default(this, this.D, false, 2, null);
    }

    public final void setPostfixColor(@ColorInt int i2) {
        this.I = i2;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void setPrefix(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.A = str;
        setFormatterType$default(this, this.D, false, 2, null);
    }

    public final void setPrefixColor(@ColorInt int i2) {
        this.H = i2;
    }

    public final void setRightIcon(@DrawableRes int i2) {
        setRightIcon(getContext().getDrawable(i2));
    }

    public final void setRightIconBackgroundColor(@Nullable ColorStateList colorStateList, @Nullable ColorStateList colorStateList2) {
        ImageViewExtensionsKt.setBackground(this.k, Math.max(0, (this.e - this.g) / 2), Math.max(0, (this.f - this.g) / 2), colorStateList, colorStateList2);
    }

    public final void setRightIconColor(@ColorInt int i2) {
        setRightIconColor(ColorStateList.valueOf(i2));
    }

    public final void setRightIconListener(@Nullable View.OnClickListener onClickListener) {
        ImageView imageView = this.k;
        if (onClickListener != null) {
            imageView.setOnClickListener(new h(imageView, onClickListener));
        } else {
            imageView.setOnClickListener(null);
        }
        imageView.setClickable(onClickListener != null);
    }

    public final void setSelection(int i2) {
        this.i.setSelection(i2);
    }

    public final void setSelectionToEndOnFocus(boolean z2) {
        this.t = z2;
    }

    public final void setSingleLine() {
        this.E = true;
        InputField inputField = this.i;
        inputField.setSingleLine(true);
        inputField.setMinLines(1);
        inputField.setMaxLines(1);
        inputField.setGravity(16);
    }

    public final void setSpinnerAppearance(@StyleRes int i2) {
        this.n.setAppearance(i2);
    }

    public final void setState(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "state");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        this.y = copyOf;
        refreshDrawableState();
    }

    public final void setText(@Nullable CharSequence charSequence, boolean z2) {
        this.i.setText(charSequence);
        if (z2) {
            InputField inputField = this.i;
            Editable text = inputField.getText();
            inputField.setSelection(text != null ? text.length() : 0);
        }
    }

    public final void setTextColor(@ColorInt int i2) {
        this.i.setTextColor(i2);
    }

    public final void setTextWithoutWatcher(@Nullable CharSequence charSequence) {
        TextWatcher textWatcher = this.z;
        if (textWatcher != null) {
            removeTextChangedListener(textWatcher);
        }
        setText$default(this, charSequence, false, 2, null);
        setFormatterType$default(this, this.D, false, 2, null);
    }

    public final void setTouchListener(@Nullable View.OnTouchListener onTouchListener) {
        this.i.setOnTouchListener(onTouchListener);
    }

    public final void setTransformationMethod(@NotNull TransformationMethod transformationMethod) {
        Intrinsics.checkNotNullParameter(transformationMethod, "method");
        int selectionEnd = this.i.getSelectionEnd();
        this.i.setTransformationMethod(transformationMethod);
        this.i.setSelection(selectionEnd);
    }

    public final void showKeyboard() {
        Keyboards.showKeyboard$default(this.i, 0, 1, null);
    }

    @Nullable
    /* renamed from: getText */
    public final Editable m90getText() {
        return this.i.getText();
    }

    public final void setHint(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            charSequence.toString();
        }
        this.i.setHint(charSequence);
    }

    public final void setLeftIcon(@Nullable Drawable drawable) {
        this.j.setImageDrawable(drawable);
        Views.setVisible(this.j, drawable != null);
        h();
        g();
    }

    public final void setLeftIconColor(@Nullable ColorStateList colorStateList) {
        ImageViewsKt.setImageTintListCompat(this.j, colorStateList);
    }

    public final void setRightIcon(@Nullable Drawable drawable) {
        this.k.setImageDrawable(drawable);
        Views.setVisible(this.k, drawable != null);
        f();
        g();
    }

    public final void setRightIconColor(@Nullable ColorStateList colorStateList) {
        ImageViewsKt.setImageTintListCompat(this.k, colorStateList);
    }

    public final void setSelection(int i2, int i3) {
        this.i.setSelection(i2, i3);
    }

    public final void setText(@Nullable Editable editable) {
        this.i.setText(editable);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dB)\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001fJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/avito/android/lib/design/input/Input$SavedState;", "Landroid/view/AbsSavedState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "[I", "getCurrentState", "()[I", "currentState", "Lcom/avito/android/lib/design/input/FormatterType;", "c", "Lcom/avito/android/lib/design/input/FormatterType;", "getFormatterState", "()Lcom/avito/android/lib/design/input/FormatterType;", "formatterState", "Landroid/os/Parcelable;", AuthSource.BOOKING_ORDER, "Landroid/os/Parcelable;", "getEditState", "()Landroid/os/Parcelable;", "editState", "parcel", "<init>", "(Landroid/os/Parcel;)V", "superState", "([ILandroid/os/Parcelable;Lcom/avito/android/lib/design/input/FormatterType;Landroid/os/Parcelable;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends AbsSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final int[] a;
        @NotNull
        public final Parcelable b;
        @NotNull
        public final FormatterType c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/input/Input$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/lib/design/input/Input$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, SavedState> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public SavedState invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new SavedState(parcel2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int[] createIntArray = parcel.createIntArray();
            Intrinsics.checkNotNull(createIntArray);
            this.a = createIntArray;
            this.b = a2.b.a.a.a.z1(Parcelable.class, parcel);
            this.c = (FormatterType) a2.b.a.a.a.z1(FormatterType.class, parcel);
        }

        @NotNull
        public final int[] getCurrentState() {
            return this.a;
        }

        @NotNull
        public final Parcelable getEditState() {
            return this.b;
        }

        @NotNull
        public final FormatterType getFormatterState() {
            return this.c;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@Nullable Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            if (parcel != null) {
                parcel.writeIntArray(this.a);
                parcel.writeParcelable(this.b, i);
                parcel.writeParcelable(this.c, i);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull int[] iArr, @NotNull Parcelable parcelable, @NotNull FormatterType formatterType, @NotNull Parcelable parcelable2) {
            super(parcelable2);
            Intrinsics.checkNotNullParameter(iArr, "currentState");
            Intrinsics.checkNotNullParameter(parcelable, "editState");
            Intrinsics.checkNotNullParameter(formatterType, "formatterState");
            Intrinsics.checkNotNullParameter(parcelable2, "superState");
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
            this.a = copyOf;
            this.c = formatterType;
            this.b = parcelable;
        }
    }

    public final void setText(@StringRes int i2) {
        this.i.setText(i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Input(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, com.avito.android.lib.design.R.attr.input);
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = getContext().getResources();
        int i2 = com.avito.android.lib.design.R.dimen.input_padding;
        this.a = resources.getDimensionPixelSize(i2);
        this.b = getContext().getResources().getDimensionPixelSize(i2);
        this.q = true;
        this.t = true;
        this.y = new int[0];
        this.A = "";
        this.B = "";
        this.C = Integer.MAX_VALUE;
        this.D = FormatterType.Companion.getSIMPLE();
        this.E = true;
        Context context2 = getContext();
        int i3 = com.avito.android.lib.design.R.attr.black;
        this.H = Contexts.getColorByAttr(context2, i3);
        this.I = Contexts.getColorByAttr(getContext(), i3);
        View inflate = LayoutInflater.from(getContext()).inflate(com.avito.android.lib.design.R.layout.design_input, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        View findViewById = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_value);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.input.InputField");
        InputField inputField = (InputField) findViewById;
        this.i = inputField;
        View findViewById2 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_left_icon);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.j = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_right_icon);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.k = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_clear);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById4;
        this.o = imageView;
        View findViewById5 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_spinner);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.spinner.Spinner");
        this.n = (Spinner) findViewById5;
        View findViewById6 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_left_container);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.l = (FrameLayout) findViewById6;
        View findViewById7 = inflate.findViewById(com.avito.android.lib.design.R.id.design_input_right_container);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.m = (FrameLayout) findViewById7;
        inputField.setId(-1);
        this.F = inputField.getKeyListener();
        inputField.setOnFocusChangeListener(new b(this));
        InputExtensionsKt.addTextChangedListener(this, new c(this));
        imageView.setOnClickListener(new d(this));
        e(this, attributeSet, 0, 0, 6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Input(@org.jetbrains.annotations.NotNull android.content.Context r6, @org.jetbrains.annotations.Nullable android.util.AttributeSet r7, int r8) {
        /*
        // Method dump skipped, instructions count: 274
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.input.Input.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Input(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.Nullable android.util.AttributeSet r6, int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 273
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.input.Input.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }
}

package okio;

import a2.b.a.a.a;
import com.adjust.sdk.Constants;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;
import okio.internal.BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Î\u0001B\b¢\u0006\u0005\bÍ\u0001\u0010kJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u0017J\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0001H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010&J+\u0010)\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b)\u0010*J'\u0010)\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b)\u0010+J\u001f\u0010)\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u0007¢\u0006\u0004\b)\u0010,J!\u0010-\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b/\u00100J\u001d\u0010/\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b/\u00101J\r\u00102\u001a\u00020\u0007¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0018\u0010:\u001a\u0002042\u0006\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0007H\u0016¢\u0006\u0004\bA\u00103J\u000f\u0010B\u001a\u00020;H\u0016¢\u0006\u0004\bB\u0010=J\u000f\u0010C\u001a\u00020>H\u0016¢\u0006\u0004\bC\u0010@J\u000f\u0010D\u001a\u00020\u0007H\u0016¢\u0006\u0004\bD\u00103J\u000f\u0010E\u001a\u00020\u0007H\u0016¢\u0006\u0004\bE\u00103J\u000f\u0010F\u001a\u00020\u0007H\u0016¢\u0006\u0004\bF\u00103J\u000f\u0010G\u001a\u00020\u0010H\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010G\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bG\u0010IJ\u0017\u0010L\u001a\u00020>2\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\u00072\u0006\u0010N\u001a\u00020QH\u0016¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u000eH\u0016¢\u0006\u0004\bT\u0010UJ\u0017\u0010T\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bT\u0010VJ\u0017\u0010Y\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020WH\u0016¢\u0006\u0004\bY\u0010ZJ\u001f\u0010Y\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010X\u001a\u00020WH\u0016¢\u0006\u0004\bY\u0010[J\u0011\u0010\\\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\\\u0010UJ\u000f\u0010]\u001a\u00020\u000eH\u0016¢\u0006\u0004\b]\u0010UJ\u0017\u0010]\u001a\u00020\u000e2\u0006\u0010^\u001a\u00020\u0007H\u0016¢\u0006\u0004\b]\u0010VJ\u000f\u0010_\u001a\u00020>H\u0016¢\u0006\u0004\b_\u0010@J\u000f\u0010a\u001a\u00020`H\u0016¢\u0006\u0004\ba\u0010bJ\u0017\u0010a\u001a\u00020`2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\ba\u0010cJ\u0017\u0010d\u001a\u00020>2\u0006\u0010N\u001a\u00020`H\u0016¢\u0006\u0004\bd\u0010eJ\u0017\u0010O\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020`H\u0016¢\u0006\u0004\bO\u0010fJ'\u0010d\u001a\u00020>2\u0006\u0010N\u001a\u00020`2\u0006\u0010(\u001a\u00020>2\u0006\u0010\b\u001a\u00020>H\u0016¢\u0006\u0004\bd\u0010gJ\u0017\u0010d\u001a\u00020>2\u0006\u0010N\u001a\u00020hH\u0016¢\u0006\u0004\bd\u0010iJ\r\u0010j\u001a\u00020\u000b¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bl\u0010 J\u0017\u0010n\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u0010H\u0016¢\u0006\u0004\bn\u0010oJ'\u0010n\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u00102\u0006\u0010(\u001a\u00020>2\u0006\u0010\b\u001a\u00020>H\u0016¢\u0006\u0004\bn\u0010pJ\u0017\u0010r\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u000eH\u0016¢\u0006\u0004\br\u0010sJ'\u0010r\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020>2\u0006\u0010u\u001a\u00020>H\u0016¢\u0006\u0004\br\u0010vJ\u0017\u0010x\u001a\u00020\u00002\u0006\u0010w\u001a\u00020>H\u0016¢\u0006\u0004\bx\u0010yJ\u001f\u0010z\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020WH\u0016¢\u0006\u0004\bz\u0010{J/\u0010z\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020>2\u0006\u0010u\u001a\u00020>2\u0006\u0010X\u001a\u00020WH\u0016¢\u0006\u0004\bz\u0010|J\u0017\u0010n\u001a\u00020\u00002\u0006\u0010}\u001a\u00020`H\u0016¢\u0006\u0004\bn\u0010~J'\u0010n\u001a\u00020\u00002\u0006\u0010}\u001a\u00020`2\u0006\u0010(\u001a\u00020>2\u0006\u0010\b\u001a\u00020>H\u0016¢\u0006\u0004\bn\u0010J\u0017\u0010n\u001a\u00020>2\u0006\u0010}\u001a\u00020hH\u0016¢\u0006\u0004\bn\u0010iJ\u001b\u0010\u0001\u001a\u00020\u00072\u0007\u0010}\u001a\u00030\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010n\u001a\u00020\u00002\u0007\u0010}\u001a\u00030\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0005\bn\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020>H\u0016¢\u0006\u0005\b\u0001\u0010yJ\u001a\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020>H\u0016¢\u0006\u0005\b\u0001\u0010yJ\u001a\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020>H\u0016¢\u0006\u0005\b\u0001\u0010yJ\u001a\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020>H\u0016¢\u0006\u0005\b\u0001\u0010yJ\u001a\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020>H\u0016¢\u0006\u0005\b\u0001\u0010yJ\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020>H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010n\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bn\u0010PJ \u0010d\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0005\bd\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u000204H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u0002042\u0007\u0010\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J,\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u0002042\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J$\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010 \u0001\u001a\u00020\u0010H\u0016¢\u0006\u0006\b¡\u0001\u0010\u0001J$\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010 \u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b¡\u0001\u0010\u0001J#\u0010¢\u0001\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0006\b¢\u0001\u0010£\u0001J4\u0010¢\u0001\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00102\u0007\u0010¤\u0001\u001a\u00020>2\u0006\u0010\b\u001a\u00020>H\u0016¢\u0006\u0006\b¢\u0001\u0010¥\u0001J\u0011\u0010¦\u0001\u001a\u00020\u000bH\u0016¢\u0006\u0005\b¦\u0001\u0010kJ\u0011\u0010§\u0001\u001a\u00020\tH\u0016¢\u0006\u0005\b§\u0001\u0010\u001eJ\u0011\u0010¨\u0001\u001a\u00020\u000bH\u0016¢\u0006\u0005\b¨\u0001\u0010kJ\u0013\u0010ª\u0001\u001a\u00030©\u0001H\u0016¢\u0006\u0006\bª\u0001\u0010«\u0001J\u000f\u0010¬\u0001\u001a\u00020\u0010¢\u0006\u0005\b¬\u0001\u0010HJ\u000f\u0010­\u0001\u001a\u00020\u0010¢\u0006\u0005\b­\u0001\u0010HJ\u000f\u0010®\u0001\u001a\u00020\u0010¢\u0006\u0005\b®\u0001\u0010HJ\u000f\u0010¯\u0001\u001a\u00020\u0010¢\u0006\u0005\b¯\u0001\u0010HJ\u0018\u0010°\u0001\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0006\b°\u0001\u0010±\u0001J\u0018\u0010²\u0001\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0006\b²\u0001\u0010±\u0001J\u0018\u0010³\u0001\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0006\b³\u0001\u0010±\u0001J\u001f\u0010¶\u0001\u001a\u00020\t2\n\u0010µ\u0001\u001a\u0005\u0018\u00010´\u0001H\u0002¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u0011\u0010¸\u0001\u001a\u00020>H\u0016¢\u0006\u0005\b¸\u0001\u0010@J\u0011\u0010¹\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b¹\u0001\u0010UJ\u000f\u0010º\u0001\u001a\u00020\u0000¢\u0006\u0005\bº\u0001\u0010\u0017J\u0011\u0010»\u0001\u001a\u00020\u0000H\u0016¢\u0006\u0005\b»\u0001\u0010\u0017J\u000f\u0010¼\u0001\u001a\u00020\u0010¢\u0006\u0005\b¼\u0001\u0010HJ\u0018\u0010¼\u0001\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020>¢\u0006\u0006\b¼\u0001\u0010½\u0001J\u001f\u0010À\u0001\u001a\u00030¾\u00012\n\b\u0002\u0010¿\u0001\u001a\u00030¾\u0001H\u0007¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u001f\u0010Â\u0001\u001a\u00030¾\u00012\n\b\u0002\u0010¿\u0001\u001a\u00030¾\u0001H\u0007¢\u0006\u0006\bÂ\u0001\u0010Á\u0001J\u0019\u00108\u001a\u0002042\u0007\u0010Ã\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0005\bÄ\u0001\u00109J\u0011\u0010Æ\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0005\bÅ\u0001\u00103R/\u0010Æ\u0001\u001a\u00020\u00072\u0007\u0010Ç\u0001\u001a\u00020\u00078G@@X\u000e¢\u0006\u0015\n\u0005\b\u0011\u0010È\u0001\u001a\u0005\bÆ\u0001\u00103\"\u0005\bÉ\u0001\u0010 R\u001c\u0010Ê\u0001\u001a\u0005\u0018\u00010\u00018\u0000@\u0000X\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0017\u0010\u0016\u001a\u00020\u00008V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\bÌ\u0001\u0010\u0017¨\u0006Ï\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "Ljava/io/InputStream;", "input", "", DecodeProducer.EXTRA_BITMAP_BYTES, "", "forever", "", "c", "(Ljava/io/InputStream;JZ)V", "", "algorithm", "Lokio/ByteString;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Lokio/ByteString;", "key", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "buffer", "()Lokio/Buffer;", "Ljava/io/OutputStream;", "outputStream", "()Ljava/io/OutputStream;", "emitCompleteSegments", "emit", "exhausted", "()Z", "require", "(J)V", "request", "(J)Z", "peek", "()Lokio/BufferedSource;", "inputStream", "()Ljava/io/InputStream;", VKApiConst.OUT, "offset", "copyTo", "(Ljava/io/OutputStream;JJ)Lokio/Buffer;", "(Lokio/Buffer;JJ)Lokio/Buffer;", "(Lokio/Buffer;J)Lokio/Buffer;", "writeTo", "(Ljava/io/OutputStream;J)Lokio/Buffer;", "readFrom", "(Ljava/io/InputStream;)Lokio/Buffer;", "(Ljava/io/InputStream;J)Lokio/Buffer;", "completeSegmentByteCount", "()J", "", "readByte", "()B", "pos", "getByte", "(J)B", "get", "", "readShort", "()S", "", "readInt", "()I", "readLong", "readShortLe", "readIntLe", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "readByteString", "()Lokio/ByteString;", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "select", "(Lokio/Options;)I", "sink", "readFully", "(Lokio/Buffer;J)V", "Lokio/Sink;", "readAll", "(Lokio/Sink;)J", "readUtf8", "()Ljava/lang/String;", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "", "readByteArray", "()[B", "(J)[B", "read", "([B)I", "([B)V", "([BII)I", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "clear", "()V", "skip", "byteString", "write", "(Lokio/ByteString;)Lokio/Buffer;", "(Lokio/ByteString;II)Lokio/Buffer;", Types.STRING, "writeUtf8", "(Ljava/lang/String;)Lokio/Buffer;", "beginIndex", "endIndex", "(Ljava/lang/String;II)Lokio/Buffer;", "codePoint", "writeUtf8CodePoint", "(I)Lokio/Buffer;", "writeString", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/Buffer;", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lokio/Buffer;", "source", "([B)Lokio/Buffer;", "([BII)Lokio/Buffer;", "Lokio/Source;", "writeAll", "(Lokio/Source;)J", "(Lokio/Source;J)Lokio/Buffer;", "writeByte", "s", "writeShort", "writeShortLe", "i", "writeInt", "writeIntLe", VKApiConst.VERSION, "writeLong", "(J)Lokio/Buffer;", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "minimumCapacity", "Lokio/Segment;", "writableSegment$okio", "(I)Lokio/Segment;", "writableSegment", "(Lokio/Buffer;J)J", "indexOf", "(B)J", "fromIndex", "(BJ)J", "toIndex", "(BJJ)J", "bytes", "(Lokio/ByteString;)J", "(Lokio/ByteString;J)J", "targetBytes", "indexOfElement", "rangeEquals", "(JLokio/ByteString;)Z", "bytesOffset", "(JLokio/ByteString;II)Z", "flush", "isOpen", "close", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "md5", "sha1", "sha256", "sha512", "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "copy", "clone", "snapshot", "(I)Lokio/ByteString;", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readUnsafe", "(Lokio/Buffer$UnsafeCursor;)Lokio/Buffer$UnsafeCursor;", "readAndWriteUnsafe", FirebaseAnalytics.Param.INDEX, "-deprecated_getByte", "-deprecated_size", "size", "<set-?>", "J", "setSize$okio", "head", "Lokio/Segment;", "getBuffer", "<init>", "UnsafeCursor", "okio"}, k = 1, mv = {1, 4, 0})
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public long a;
    @JvmField
    @Nullable
    public Segment head;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "", "next", "()I", "", "offset", "seek", "(J)I", "newSize", "resizeBuffer", "(J)J", "minByteCount", "expandBuffer", "(I)J", "", "close", "()V", "Lokio/Buffer;", "buffer", "Lokio/Buffer;", "", "data", "[B", "", "readWrite", "Z", "J", "end", "I", Tracker.Events.CREATIVE_START, "Lokio/Segment;", AuthSource.SEND_ABUSE, "Lokio/Segment;", "segment", "<init>", "okio"}, k = 1, mv = {1, 4, 0})
    public static final class UnsafeCursor implements Closeable {
        public Segment a;
        @JvmField
        @Nullable
        public Buffer buffer;
        @JvmField
        @Nullable
        public byte[] data;
        @JvmField
        public int end = -1;
        @JvmField
        public long offset = -1;
        @JvmField
        public boolean readWrite;
        @JvmField
        public int start = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.a = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final long expandBuffer(int i) {
            boolean z = true;
            if (i > 0) {
                if (i > 8192) {
                    z = false;
                }
                if (z) {
                    Buffer buffer2 = this.buffer;
                    if (buffer2 == null) {
                        throw new IllegalStateException("not attached to a buffer".toString());
                    } else if (this.readWrite) {
                        long size = buffer2.size();
                        Segment writableSegment$okio = buffer2.writableSegment$okio(i);
                        int i2 = 8192 - writableSegment$okio.limit;
                        writableSegment$okio.limit = 8192;
                        long j = (long) i2;
                        buffer2.setSize$okio(size + j);
                        this.a = writableSegment$okio;
                        this.offset = size;
                        this.data = writableSegment$okio.data;
                        this.start = 8192 - i2;
                        this.end = 8192;
                        return j;
                    } else {
                        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                    }
                } else {
                    throw new IllegalArgumentException(a.M2("minByteCount > Segment.SIZE: ", i).toString());
                }
            } else {
                throw new IllegalArgumentException(a.M2("minByteCount <= 0: ", i).toString());
            }
        }

        public final int next() {
            long j = this.offset;
            Buffer buffer2 = this.buffer;
            Intrinsics.checkNotNull(buffer2);
            if (j != buffer2.size()) {
                long j2 = this.offset;
                return seek(j2 == -1 ? 0 : j2 + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long resizeBuffer(long j) {
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (this.readWrite) {
                long size = buffer2.size();
                int i = 1;
                int i2 = (j > size ? 1 : (j == size ? 0 : -1));
                if (i2 <= 0) {
                    if (j >= 0) {
                        long j2 = size - j;
                        while (true) {
                            if (j2 <= 0) {
                                break;
                            }
                            Segment segment = buffer2.head;
                            Intrinsics.checkNotNull(segment);
                            Segment segment2 = segment.prev;
                            Intrinsics.checkNotNull(segment2);
                            int i3 = segment2.limit;
                            long j3 = (long) (i3 - segment2.pos);
                            if (j3 > j2) {
                                segment2.limit = i3 - ((int) j2);
                                break;
                            }
                            buffer2.head = segment2.pop();
                            SegmentPool.recycle(segment2);
                            j2 -= j3;
                        }
                        this.a = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException(a.T2("newSize < 0: ", j).toString());
                    }
                } else if (i2 > 0) {
                    long j4 = j - size;
                    boolean z = true;
                    while (j4 > 0) {
                        Segment writableSegment$okio = buffer2.writableSegment$okio(i);
                        int min = (int) Math.min(j4, (long) (8192 - writableSegment$okio.limit));
                        int i4 = writableSegment$okio.limit + min;
                        writableSegment$okio.limit = i4;
                        j4 -= (long) min;
                        if (z) {
                            this.a = writableSegment$okio;
                            this.offset = size;
                            this.data = writableSegment$okio.data;
                            this.start = i4 - min;
                            this.end = i4;
                            z = false;
                        }
                        i = 1;
                    }
                }
                buffer2.setSize$okio(j);
                return size;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
        }

        public final int seek(long j) {
            Segment segment;
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (j < ((long) -1) || j > buffer2.size()) {
                throw new ArrayIndexOutOfBoundsException(a.H(new Object[]{Long.valueOf(j), Long.valueOf(buffer2.size())}, 2, "offset=%s > size=%s", "java.lang.String.format(format, *args)"));
            } else if (j == -1 || j == buffer2.size()) {
                this.a = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            } else {
                long j2 = 0;
                long size = buffer2.size();
                Segment segment2 = buffer2.head;
                Segment segment3 = this.a;
                if (segment3 != null) {
                    long j3 = this.offset;
                    int i = this.start;
                    Intrinsics.checkNotNull(segment3);
                    long j4 = j3 - ((long) (i - segment3.pos));
                    if (j4 > j) {
                        segment = this.a;
                        size = j4;
                    } else {
                        segment = segment2;
                        segment2 = this.a;
                        j2 = j4;
                    }
                } else {
                    segment = segment2;
                }
                if (size - j > j - j2) {
                    while (true) {
                        Intrinsics.checkNotNull(segment2);
                        int i2 = segment2.limit;
                        int i3 = segment2.pos;
                        if (j < ((long) (i2 - i3)) + j2) {
                            break;
                        }
                        j2 += (long) (i2 - i3);
                        segment2 = segment2.next;
                    }
                } else {
                    while (size > j) {
                        Intrinsics.checkNotNull(segment);
                        segment = segment.prev;
                        Intrinsics.checkNotNull(segment);
                        size -= (long) (segment.limit - segment.pos);
                    }
                    j2 = size;
                    segment2 = segment;
                }
                if (this.readWrite) {
                    Intrinsics.checkNotNull(segment2);
                    if (segment2.shared) {
                        Segment unsharedCopy = segment2.unsharedCopy();
                        if (buffer2.head == segment2) {
                            buffer2.head = unsharedCopy;
                        }
                        segment2 = segment2.push(unsharedCopy);
                        Segment segment4 = segment2.prev;
                        Intrinsics.checkNotNull(segment4);
                        segment4.pop();
                    }
                }
                this.a = segment2;
                this.offset = j;
                Intrinsics.checkNotNull(segment2);
                this.data = segment2.data;
                int i4 = segment2.pos + ((int) (j - j2));
                this.start = i4;
                int i5 = segment2.limit;
                this.end = i5;
                return i5 - i4;
            }
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j, long j2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            j2 = buffer.a - j;
        }
        return buffer.copyTo(outputStream, j, j2);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j, j2);
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = buffer.a;
        }
        return buffer.writeTo(outputStream, j);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m678deprecated_getByte(long j) {
        return getByte(j);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m679deprecated_size() {
        return this.a;
    }

    public final ByteString a(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i = segment.pos;
            instance.update(bArr, i, segment.limit - i);
            Segment segment2 = segment.next;
            Intrinsics.checkNotNull(segment2);
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i2 = segment2.pos;
                instance.update(bArr2, i2, segment2.limit - i2);
                segment2 = segment2.next;
                Intrinsics.checkNotNull(segment2);
            }
        }
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    public final ByteString b(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i = segment.pos;
                instance.update(bArr, i, segment.limit - i);
                Segment segment2 = segment.next;
                Intrinsics.checkNotNull(segment2);
                while (segment2 != segment) {
                    byte[] bArr2 = segment2.data;
                    int i2 = segment2.pos;
                    instance.update(bArr2, i2, segment2.limit - i2);
                    segment2 = segment2.next;
                    Intrinsics.checkNotNull(segment2);
                }
            }
            byte[] doFinal = instance.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this;
    }

    public final void c(InputStream inputStream, long j, boolean z) throws IOException {
        while (true) {
            if (j > 0 || z) {
                Segment writableSegment$okio = writableSegment$okio(1);
                int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j, (long) (8192 - writableSegment$okio.limit)));
                if (read == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        this.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    if (!z) {
                        throw new EOFException();
                    }
                    return;
                }
                writableSegment$okio.limit += read;
                long j2 = (long) read;
                this.a += j2;
                j -= j2;
            } else {
                return;
            }
        }
    }

    public final void clear() {
        skip(size());
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0;
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        int i = segment2.limit;
        if (i < 8192 && segment2.owner) {
            size -= (long) (i - segment2.pos);
        }
        return size;
    }

    @NotNull
    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = sharedCopy.prev;
                Intrinsics.checkNotNull(segment3);
                Intrinsics.checkNotNull(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream) throws IOException {
        return copyTo$default(this, outputStream, 0, 0, 6, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream, long j) throws IOException {
        return copyTo$default(this, outputStream, j, 0, 4, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream, long j, long j2) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, VKApiConst.OUT);
        Util.checkOffsetAndCount(this.a, j, j2);
        if (j2 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            Intrinsics.checkNotNull(segment);
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            segment = segment.next;
        }
        while (j2 > 0) {
            Intrinsics.checkNotNull(segment);
            int i3 = (int) (((long) segment.pos) + j);
            int min = (int) Math.min((long) (segment.limit - i3), j2);
            outputStream.write(segment.data, i3, min);
            j2 -= (long) min;
            segment = segment.next;
            j = 0;
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (!(obj instanceof Buffer)) {
                return false;
            }
            Buffer buffer = (Buffer) obj;
            if (size() != buffer.size()) {
                return false;
            }
            if (size() != 0) {
                Segment segment = this.head;
                Intrinsics.checkNotNull(segment);
                Segment segment2 = buffer.head;
                Intrinsics.checkNotNull(segment2);
                int i = segment.pos;
                int i2 = segment2.pos;
                long j = 0;
                while (j < size()) {
                    long min = (long) Math.min(segment.limit - i, segment2.limit - i2);
                    long j2 = 0;
                    while (j2 < min) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (segment.data[i] != segment2.data[i2]) {
                            return false;
                        }
                        j2++;
                        i = i3;
                        i2 = i4;
                    }
                    if (i == segment.limit) {
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        i = segment.pos;
                    }
                    if (i2 == segment2.limit) {
                        segment2 = segment2.next;
                        Intrinsics.checkNotNull(segment2);
                        i2 = segment2.pos;
                    }
                    j += min;
                }
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.a == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this;
    }

    @JvmName(name = "getByte")
    public final byte getByte(long j) {
        Util.checkOffsetAndCount(size(), j, 1);
        Segment segment = this.head;
        if (segment == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        } else if (size() - j < j) {
            long size = size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            Intrinsics.checkNotNull(segment);
            return segment.data[(int) ((((long) segment.pos) + j) - size)];
        } else {
            long j2 = 0;
            while (true) {
                long j3 = ((long) (segment.limit - segment.pos)) + j2;
                if (j3 > j) {
                    Intrinsics.checkNotNull(segment);
                    return segment.data[(int) ((((long) segment.pos) + j) - j2)];
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j2 = j3;
            }
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        } while (segment != this.head);
        return i;
    }

    @NotNull
    public final ByteString hmacSha1(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return b("HmacSHA1", byteString);
    }

    @NotNull
    public final ByteString hmacSha256(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return b("HmacSHA256", byteString);
    }

    @NotNull
    public final ByteString hmacSha512(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return b("HmacSHA512", byteString);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        return indexOfElement(byteString, 0);
    }

    @Override // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new InputStream(this) { // from class: okio.Buffer$inputStream$1
            public final /* synthetic */ Buffer a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(this.a.size(), (long) Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (this.a.size() > 0) {
                    return this.a.readByte() & 255;
                }
                return -1;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return this.a + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(@NotNull byte[] bArr, int i, int i2) {
                Intrinsics.checkNotNullParameter(bArr, "sink");
                return this.a.read(bArr, i, i2);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @NotNull
    public final ByteString md5() {
        return a(Constants.MD5);
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream(this) { // from class: okio.Buffer$outputStream$1
            public final /* synthetic */ Buffer a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return this.a + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                this.a.writeByte(i);
            }

            @Override // java.io.OutputStream
            public void write(@NotNull byte[] bArr, int i, int i2) {
                Intrinsics.checkNotNullParameter(bArr, "data");
                this.a.write(bArr, i, i2);
            }
        };
    }

    @Override // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(byteBuffer, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i = segment.pos + min;
        segment.pos = i;
        this.a -= (long) min;
        if (i == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // okio.BufferedSource
    public long readAll(@NotNull Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            int i3 = i + 1;
            byte b = segment.data[i];
            setSize$okio(size() - 1);
            if (i3 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            return b;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        return readByteString(size());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        r1 = new okio.Buffer().writeDecimalLong(r3).writeByte((int) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r6 != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        r3 = a2.b.a.a.a.L("Number too large: ");
        r3.append(r1.readUtf8());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        throw new java.lang.NumberFormatException(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
        if (r5 == 0) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        r2 = a2.b.a.a.a.L("Expected leading [0-9] or '-' character but was 0x");
        r2.append(okio.Util.toHexString(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0096, code lost:
        throw new java.lang.NumberFormatException(r2.toString());
     */
    @Override // okio.BufferedSource
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            r17 = this;
            r0 = r17
            long r1 = r17.size()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00b9
            r1 = -7
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0011:
            okio.Segment r8 = r0.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L_0x001c:
            if (r10 >= r11) goto L_0x0097
            byte r12 = r9[r10]
            r13 = 48
            byte r13 = (byte) r13
            if (r12 < r13) goto L_0x006c
            r14 = 57
            byte r14 = (byte) r14
            if (r12 > r14) goto L_0x006c
            int r13 = r13 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x0043
            if (r16 != 0) goto L_0x003c
            long r14 = (long) r13
            int r16 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r16 >= 0) goto L_0x003c
            goto L_0x0043
        L_0x003c:
            r14 = 10
            long r3 = r3 * r14
            long r12 = (long) r13
            long r3 = r3 + r12
            goto L_0x0077
        L_0x0043:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong(r3)
            okio.Buffer r1 = r1.writeByte(r12)
            if (r6 != 0) goto L_0x0055
            r1.readByte()
        L_0x0055:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.String r3 = "Number too large: "
            java.lang.StringBuilder r3 = a2.b.a.a.a.L(r3)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006c:
            r13 = 45
            byte r13 = (byte) r13
            if (r12 != r13) goto L_0x007c
            if (r5 != 0) goto L_0x007c
            r12 = 1
            long r1 = r1 - r12
            r6 = 1
        L_0x0077:
            int r10 = r10 + 1
            int r5 = r5 + 1
            goto L_0x001c
        L_0x007c:
            if (r5 == 0) goto L_0x0080
            r7 = 1
            goto L_0x0097
        L_0x0080:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r2 = a2.b.a.a.a.L(r2)
            java.lang.String r3 = okio.Util.toHexString(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0097:
            if (r10 != r11) goto L_0x00a3
            okio.Segment r9 = r8.pop()
            r0.head = r9
            okio.SegmentPool.recycle(r8)
            goto L_0x00a5
        L_0x00a3:
            r8.pos = r10
        L_0x00a5:
            if (r7 != 0) goto L_0x00ab
            okio.Segment r8 = r0.head
            if (r8 != 0) goto L_0x0011
        L_0x00ab:
            long r1 = r17.size()
            long r7 = (long) r5
            long r1 = r1 - r7
            r0.setSize$okio(r1)
            if (r6 == 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            long r3 = -r3
        L_0x00b8:
            return r3
        L_0x00b9:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream inputStream) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        c(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull Buffer buffer, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (size() >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, size());
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws EOFException {
        byte b;
        int i;
        if (size() != 0) {
            int i2 = 0;
            boolean z = false;
            long j = 0;
            do {
                Segment segment = this.head;
                Intrinsics.checkNotNull(segment);
                byte[] bArr = segment.data;
                int i3 = segment.pos;
                int i4 = segment.limit;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    b = bArr[i3];
                    byte b2 = (byte) 48;
                    if (b < b2 || b > ((byte) 57)) {
                        byte b3 = (byte) 97;
                        if ((b < b3 || b > ((byte) 102)) && (b < (b3 = (byte) 65) || b > ((byte) 70))) {
                            break;
                        }
                        i = (b - b3) + 10;
                    } else {
                        i = b - b2;
                    }
                    if ((-1152921504606846976L & j) == 0) {
                        j = (j << 4) | ((long) i);
                        i3++;
                        i2++;
                    } else {
                        Buffer writeByte = new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b);
                        StringBuilder L = a.L("Number too large: ");
                        L.append(writeByte.readUtf8());
                        throw new NumberFormatException(L.toString());
                    }
                }
                if (i2 != 0) {
                    z = true;
                    if (i3 == i4) {
                        this.head = segment.pop();
                        SegmentPool.recycle(segment);
                    } else {
                        segment.pos = i3;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    StringBuilder L2 = a.L("Expected leading [0-9a-fA-F] character but was 0x");
                    L2.append(Util.toHexString(b));
                    throw new NumberFormatException(L2.toString());
                }
            } while (this.head != null);
            setSize$okio(size() - ((long) i2));
            return j;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            setSize$okio(size() - 4);
            if (i8 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i8;
            }
            return i9;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return Util.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 8) {
                return ((((long) readInt()) & BodyPartID.bodyIdMax) << 32) | (BodyPartID.bodyIdMax & ((long) readInt()));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40);
            int i6 = i5 + 1;
            long j2 = ((((long) bArr[i5]) & 255) << 32) | j;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j3 = j2 | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j4 = j3 | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
            setSize$okio(size() - 8);
            if (i10 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i10;
            }
            return j4;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return Util.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            setSize$okio(size() - 2);
            if (i4 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return (short) i5;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return Util.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readString(this.a, charset);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        return readString(this.a, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (size() != 0) {
            byte b = getByte(0);
            if ((b & 128) == 0) {
                i3 = b & Byte.MAX_VALUE;
                i2 = 1;
                i = 0;
            } else if ((b & 224) == 192) {
                i3 = b & Ascii.US;
                i2 = 2;
                i = 128;
            } else if ((b & 240) == 224) {
                i3 = b & Ascii.SI;
                i2 = 3;
                i = 2048;
            } else if ((b & 248) == 240) {
                i3 = b & 7;
                i2 = 4;
                i = 65536;
            } else {
                skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j = (long) i2;
            if (size() >= j) {
                for (int i4 = 1; i4 < i2; i4++) {
                    long j2 = (long) i4;
                    byte b2 = getByte(j2);
                    if ((b2 & 192) == 128) {
                        i3 = (i3 << 6) | (b2 & Utf8.REPLACEMENT_BYTE);
                    } else {
                        skip(j2);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                skip(j);
                if (i3 > 1114111) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                if ((55296 <= i3 && 57343 >= i3) || i3 < i) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                return i3;
            }
            StringBuilder M = a.M("size < ", i2, ": ");
            M.append(size());
            M.append(" (to read code point prefixed 0x");
            M.append(Util.toHexString(b));
            M.append(')');
            throw new EOFException(M.toString());
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.a >= j;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.a < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(@NotNull Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int selectPrefix$default = BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public final void setSize$okio(long j) {
        this.a = j;
    }

    @NotNull
    public final ByteString sha1() {
        return a("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return a("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return a(McElieceCCA2KeyGenParameterSpec.SHA512);
    }

    @JvmName(name = "size")
    public final long size() {
        return this.a;
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                long j2 = (long) min;
                setSize$okio(size() - j2);
                j -= j2;
                int i = segment.pos + min;
                segment.pos = i;
                if (i == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public final ByteString snapshot() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return snapshot((int) size());
        }
        StringBuilder L = a.L("size > Int.MAX_VALUE: ");
        L.append(size());
        throw new IllegalStateException(L.toString().toString());
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return snapshot().toString();
    }

    @NotNull
    public final Segment writableSegment$okio(int i) {
        boolean z = true;
        if (i < 1 || i > 8192) {
            z = false;
        }
        if (z) {
            Segment segment = this.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                this.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            Intrinsics.checkNotNull(segment);
            Segment segment2 = segment.prev;
            Intrinsics.checkNotNull(segment2);
            return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(this, (long) 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream outputStream) throws IOException {
        return writeTo$default(this, outputStream, 0, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream outputStream, long j) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, VKApiConst.OUT);
        Util.checkOffsetAndCount(this.a, 0, j);
        Segment segment = this.head;
        while (j > 0) {
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
            outputStream.write(segment.data, segment.pos, min);
            int i = segment.pos + min;
            segment.pos = i;
            long j2 = (long) min;
            this.a -= j2;
            j -= j2;
            if (i == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    @Override // java.lang.Object
    @NotNull
    public Buffer clone() {
        return copy();
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString byteString, long j) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        long j2 = 0;
        if (j >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            if (size() - j < j) {
                j2 = size();
                while (j2 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j2 -= (long) (segment.limit - segment.pos);
                }
                if (byteString.size() == 2) {
                    byte b = byteString.getByte(0);
                    byte b2 = byteString.getByte(1);
                    while (j2 < size()) {
                        byte[] bArr = segment.data;
                        i = (int) ((((long) segment.pos) + j) - j2);
                        int i3 = segment.limit;
                        while (i < i3) {
                            byte b3 = bArr[i];
                            if (!(b3 == b || b3 == b2)) {
                                i++;
                            }
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j = j2;
                    }
                    return -1;
                }
                byte[] internalArray$okio = byteString.internalArray$okio();
                while (j2 < size()) {
                    byte[] bArr2 = segment.data;
                    i = (int) ((((long) segment.pos) + j) - j2);
                    int i4 = segment.limit;
                    while (i < i4) {
                        byte b4 = bArr2[i];
                        for (byte b5 : internalArray$okio) {
                            if (b4 == b5) {
                                i2 = segment.pos;
                                return ((long) (i - i2)) + j2;
                            }
                        }
                        i++;
                    }
                    j2 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j2;
                }
                return -1;
            }
            while (true) {
                long j3 = ((long) (segment.limit - segment.pos)) + j2;
                if (j3 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j2 = j3;
            }
            if (byteString.size() == 2) {
                byte b6 = byteString.getByte(0);
                byte b8 = byteString.getByte(1);
                while (j2 < size()) {
                    byte[] bArr3 = segment.data;
                    i = (int) ((((long) segment.pos) + j) - j2);
                    int i5 = segment.limit;
                    while (i < i5) {
                        byte b9 = bArr3[i];
                        if (!(b9 == b6 || b9 == b8)) {
                            i++;
                        }
                    }
                    j2 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j2;
                }
                return -1;
            }
            byte[] internalArray$okio2 = byteString.internalArray$okio();
            while (j2 < size()) {
                byte[] bArr4 = segment.data;
                i = (int) ((((long) segment.pos) + j) - j2);
                int i6 = segment.limit;
                while (i < i6) {
                    byte b10 = bArr4[i];
                    for (byte b11 : internalArray$okio2) {
                        if (b10 == b11) {
                            i2 = segment.pos;
                            return ((long) (i - i2)) + j2;
                        }
                    }
                    i++;
                }
                j2 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = j2;
            }
            return -1;
            i2 = segment.pos;
            return ((long) (i - i2)) + j2;
        }
        throw new IllegalArgumentException(a.T2("fromIndex < 0: ", j).toString());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, @NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || size() - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.T2("byteCount: ", j).toString());
        } else if (size() >= j) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.T2("byteCount: ", j).toString());
        } else if (size() < j) {
            throw new EOFException();
        } else if (j < ((long) 4096)) {
            return new ByteString(readByteArray(j));
        } else {
            ByteString snapshot = snapshot((int) j);
            skip(j);
            return snapshot;
        }
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream inputStream, long j) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        if (j >= 0) {
            c(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException(a.T2("byteCount < 0: ", j).toString());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(long j, @NotNull Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.T2("byteCount: ", j).toString());
        } else if (this.a < j) {
            throw new EOFException();
        } else if (i == 0) {
            return "";
        } else {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i2 = segment.pos;
            if (((long) i2) + j > ((long) segment.limit)) {
                return new String(readByteArray(j), charset);
            }
            int i3 = (int) j;
            String str = new String(segment.data, i2, i3, charset);
            int i4 = segment.pos + i3;
            segment.pos = i4;
            this.a -= j;
            if (i4 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8(long j) throws EOFException {
        return readString(j, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            byte b = (byte) 10;
            long indexOf = indexOf(b, 0, j2);
            if (indexOf != -1) {
                return BufferKt.readUtf8Line(this, indexOf);
            }
            if (j2 < size() && getByte(j2 - 1) == ((byte) 13) && getByte(j2) == b) {
                return BufferKt.readUtf8Line(this, j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min((long) 32, size()));
            StringBuilder L = a.L("\\n not found: limit=");
            L.append(Math.min(size(), j));
            L.append(" content=");
            L.append(buffer.readByteString().hex());
            L.append(Typography.ellipsis);
            throw new EOFException(L.toString());
        }
        throw new IllegalArgumentException(a.T2("limit < 0: ", j).toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeByte(int i) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeDecimalLong(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment writableSegment$okio = writableSegment$okio(i2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit + i2;
        while (j != 0) {
            long j2 = (long) 10;
            i3--;
            bArr[i3] = BufferKt.getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i2;
        setSize$okio(size() + ((long) i2));
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment writableSegment$okio = writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        setSize$okio(size() + ((long) i));
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeInt(int i) {
        Segment writableSegment$okio = writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment$okio.limit = i5 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytes(i));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLong(long j) {
        Segment writableSegment$okio = writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i = writableSegment$okio.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        writableSegment$okio.limit = i8 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytes(j));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShort(int i) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment$okio.limit = i3 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShortLe(int i) {
        return writeShort((int) Util.reverseBytes((short) i));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i2 = writableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit = i2 + 2;
            setSize$okio(size() + 2);
        } else if (55296 <= i && 57343 >= i) {
            writeByte(63);
        } else if (i < 65536) {
            Segment writableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i3 = writableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            writableSegment$okio2.limit = i3 + 3;
            setSize$okio(size() + 3);
        } else if (i <= 1114111) {
            Segment writableSegment$okio3 = writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i4 = writableSegment$okio3.limit;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            writableSegment$okio3.limit = i4 + 4;
            setSize$okio(size() + 4);
        } else {
            StringBuilder L = a.L("Unexpected code point: 0x");
            L.append(Util.toHexString(i));
            throw new IllegalArgumentException(L.toString());
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return indexOf(byteString, 0);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String str, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        Intrinsics.checkNotNullParameter(charset, "charset");
        return writeString(str, 0, str.length(), charset);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        return writeUtf8(str, 0, str.length());
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        Segment segment;
        int i;
        long j3 = 0;
        if (0 <= j && j2 >= j) {
            if (j2 > size()) {
                j2 = size();
            }
            if (j == j2 || (segment = this.head) == null) {
                return -1;
            }
            if (size() - j < j) {
                j3 = size();
                while (j3 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j3 -= (long) (segment.limit - segment.pos);
                }
                while (j3 < j2) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                    i = (int) ((((long) segment.pos) + j) - j3);
                    while (i < min) {
                        if (bArr[i] != b) {
                            i++;
                        }
                    }
                    j3 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j3;
                }
                return -1;
            }
            while (true) {
                long j4 = ((long) (segment.limit - segment.pos)) + j3;
                if (j4 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j3 = j4;
            }
            while (j3 < j2) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                i = (int) ((((long) segment.pos) + j) - j3);
                while (i < min2) {
                    if (bArr2[i] != b) {
                        i++;
                    }
                }
                j3 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = j3;
            }
            return -1;
            return ((long) (i - segment.pos)) + j3;
        }
        StringBuilder L = a.L("size=");
        L.append(size());
        L.append(" fromIndex=");
        L.append(j);
        L.append(" toIndex=");
        L.append(j2);
        throw new IllegalArgumentException(L.toString().toString());
    }

    @NotNull
    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(size(), 0, (long) i);
        Segment segment = this.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Intrinsics.checkNotNull(segment);
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[(i4 * 2)];
        Segment segment2 = this.head;
        int i7 = 0;
        while (i2 < i) {
            Intrinsics.checkNotNull(segment2);
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String str, int i, int i2, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        Intrinsics.checkNotNullParameter(charset, "charset");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    z = false;
                }
                if (!z) {
                    StringBuilder M = a.M("endIndex > string.length: ", i2, " > ");
                    M.append(str.length());
                    throw new IllegalArgumentException(M.toString().toString());
                } else if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
                    return writeUtf8(str, i, i2);
                } else {
                    String substring = str.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                    byte[] bytes = substring.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    return write(bytes, 0, bytes.length);
                }
            } else {
                throw new IllegalArgumentException(a.R2("endIndex < beginIndex: ", i2, " < ", i).toString());
            }
        } else {
            throw new IllegalArgumentException(a.M2("beginIndex < 0: ", i).toString());
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String str, int i, int i2) {
        char charAt;
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 <= str.length()) {
                    while (i < i2) {
                        char charAt2 = str.charAt(i);
                        if (charAt2 < 128) {
                            Segment writableSegment$okio = writableSegment$okio(1);
                            byte[] bArr = writableSegment$okio.data;
                            int i3 = writableSegment$okio.limit - i;
                            int min = Math.min(i2, 8192 - i3);
                            int i4 = i + 1;
                            bArr[i + i3] = (byte) charAt2;
                            while (true) {
                                i = i4;
                                if (i >= min || (charAt = str.charAt(i)) >= 128) {
                                    break;
                                }
                                i4 = i + 1;
                                bArr[i + i3] = (byte) charAt;
                            }
                            int i5 = writableSegment$okio.limit;
                            int i6 = (i3 + i) - i5;
                            writableSegment$okio.limit = i5 + i6;
                            setSize$okio(size() + ((long) i6));
                        } else {
                            if (charAt2 < 2048) {
                                Segment writableSegment$okio2 = writableSegment$okio(2);
                                byte[] bArr2 = writableSegment$okio2.data;
                                int i7 = writableSegment$okio2.limit;
                                bArr2[i7] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i7 + 1] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio2.limit = i7 + 2;
                                setSize$okio(size() + 2);
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                Segment writableSegment$okio3 = writableSegment$okio(3);
                                byte[] bArr3 = writableSegment$okio3.data;
                                int i8 = writableSegment$okio3.limit;
                                bArr3[i8] = (byte) ((charAt2 >> '\f') | 224);
                                bArr3[i8 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i8 + 2] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio3.limit = i8 + 3;
                                setSize$okio(size() + 3);
                            } else {
                                int i9 = i + 1;
                                char charAt3 = i9 < i2 ? str.charAt(i9) : 0;
                                if (charAt2 > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                                    writeByte(63);
                                    i = i9;
                                } else {
                                    int i10 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                                    Segment writableSegment$okio4 = writableSegment$okio(4);
                                    byte[] bArr4 = writableSegment$okio4.data;
                                    int i11 = writableSegment$okio4.limit;
                                    bArr4[i11] = (byte) ((i10 >> 18) | 240);
                                    bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                                    bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                                    bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                                    writableSegment$okio4.limit = i11 + 4;
                                    setSize$okio(size() + 4);
                                    i += 2;
                                }
                            }
                            i++;
                        }
                    }
                    return this;
                }
                StringBuilder M = a.M("endIndex > string.length: ", i2, " > ");
                M.append(str.length());
                throw new IllegalArgumentException(M.toString().toString());
            }
            throw new IllegalArgumentException(a.R2("endIndex < beginIndex: ", i2, " < ", i).toString());
        }
        throw new IllegalArgumentException(a.M2("beginIndex < 0: ", i).toString());
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull byte[] bArr) throws EOFException {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i, 8192 - writableSegment$okio.limit);
            byteBuffer.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i -= min;
            writableSegment$okio.limit += min;
        }
        this.a += (long) remaining;
        return remaining;
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, VKApiConst.OUT);
        return copyTo(buffer, j, this.a - j);
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i3 = segment.pos;
        ArraysKt___ArraysJvmKt.copyInto(bArr2, bArr, i, i3, i3 + min);
        segment.pos += min;
        setSize$okio(size() - ((long) min));
        if (segment.pos != segment.limit) {
            return min;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return min;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer buffer, long j, long j2) {
        Intrinsics.checkNotNullParameter(buffer, VKApiConst.OUT);
        Util.checkOffsetAndCount(size(), j, j2);
        if (j2 != 0) {
            buffer.setSize$okio(buffer.size() + j2);
            Segment segment = this.head;
            while (true) {
                Intrinsics.checkNotNull(segment);
                int i = segment.limit;
                int i2 = segment.pos;
                if (j < ((long) (i - i2))) {
                    break;
                }
                j -= (long) (i - i2);
                segment = segment.next;
            }
            while (j2 > 0) {
                Intrinsics.checkNotNull(segment);
                Segment sharedCopy = segment.sharedCopy();
                int i3 = sharedCopy.pos + ((int) j);
                sharedCopy.pos = i3;
                sharedCopy.limit = Math.min(i3 + ((int) j2), sharedCopy.limit);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    buffer.head = sharedCopy;
                } else {
                    Intrinsics.checkNotNull(segment2);
                    Segment segment3 = segment2.prev;
                    Intrinsics.checkNotNull(segment3);
                    segment3.push(sharedCopy);
                }
                j2 -= (long) (sharedCopy.limit - sharedCopy.pos);
                segment = segment.next;
                j = 0;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, i, i2);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        long j = (long) i2;
        Util.checkOffsetAndCount((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            ArraysKt___ArraysJvmKt.copyInto(bArr, writableSegment$okio.data, writableSegment$okio.limit, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        setSize$okio(size() + j);
        return this;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(a.T2("byteCount < 0: ", j).toString());
        } else if (size() == 0) {
            return -1;
        } else {
            if (j > size()) {
                j = size();
            }
            buffer.write(this, j);
            return j;
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull Source source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long read = source.read(this, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString byteString, long j) throws IOException {
        int i;
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (byteString.size() > 0) {
            long j2 = 0;
            if (j >= 0) {
                Segment segment = this.head;
                if (segment != null) {
                    if (size() - j < j) {
                        j2 = size();
                        while (j2 > j) {
                            segment = segment.prev;
                            Intrinsics.checkNotNull(segment);
                            j2 -= (long) (segment.limit - segment.pos);
                        }
                        byte[] internalArray$okio = byteString.internalArray$okio();
                        byte b = internalArray$okio[0];
                        int size = byteString.size();
                        long size2 = (size() - ((long) size)) + 1;
                        while (j2 < size2) {
                            byte[] bArr = segment.data;
                            int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size2) - j2);
                            i = (int) ((((long) segment.pos) + j) - j2);
                            while (i < min) {
                                if (bArr[i] != b || !BufferKt.rangeEquals(segment, i + 1, internalArray$okio, 1, size)) {
                                    i++;
                                }
                            }
                            j2 += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            Intrinsics.checkNotNull(segment);
                            j = j2;
                        }
                    } else {
                        while (true) {
                            long j3 = ((long) (segment.limit - segment.pos)) + j2;
                            if (j3 > j) {
                                break;
                            }
                            segment = segment.next;
                            Intrinsics.checkNotNull(segment);
                            j2 = j3;
                        }
                        byte[] internalArray$okio2 = byteString.internalArray$okio();
                        byte b2 = internalArray$okio2[0];
                        int size3 = byteString.size();
                        long size4 = (size() - ((long) size3)) + 1;
                        while (j2 < size4) {
                            byte[] bArr2 = segment.data;
                            int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size4) - j2);
                            i = (int) ((((long) segment.pos) + j) - j2);
                            while (i < min2) {
                                if (bArr2[i] != b2 || !BufferKt.rangeEquals(segment, i + 1, internalArray$okio2, 1, size3)) {
                                    i++;
                                }
                            }
                            j2 += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            Intrinsics.checkNotNull(segment);
                            j = j2;
                        }
                    }
                    return ((long) (i - segment.pos)) + j2;
                }
                return -1;
            }
            throw new IllegalArgumentException(a.T2("fromIndex < 0: ", j).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer buffer, long j) {
        Segment segment;
        Intrinsics.checkNotNullParameter(buffer, "source");
        if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size(), 0, j);
            while (j > 0) {
                Segment segment2 = buffer.head;
                Intrinsics.checkNotNull(segment2);
                int i = segment2.limit;
                Segment segment3 = buffer.head;
                Intrinsics.checkNotNull(segment3);
                if (j < ((long) (i - segment3.pos))) {
                    Segment segment4 = this.head;
                    if (segment4 != null) {
                        Intrinsics.checkNotNull(segment4);
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j) - ((long) (segment.shared ? 0 : segment.pos)) <= ((long) 8192)) {
                            Segment segment5 = buffer.head;
                            Intrinsics.checkNotNull(segment5);
                            segment5.writeTo(segment, (int) j);
                            buffer.setSize$okio(buffer.size() - j);
                            setSize$okio(size() + j);
                            return;
                        }
                    }
                    Segment segment6 = buffer.head;
                    Intrinsics.checkNotNull(segment6);
                    buffer.head = segment6.split((int) j);
                }
                Segment segment7 = buffer.head;
                Intrinsics.checkNotNull(segment7);
                long j2 = (long) (segment7.limit - segment7.pos);
                buffer.head = segment7.pop();
                Segment segment8 = this.head;
                if (segment8 == null) {
                    this.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    Intrinsics.checkNotNull(segment8);
                    Segment segment9 = segment8.prev;
                    Intrinsics.checkNotNull(segment9);
                    segment9.push(segment7).compact();
                }
                buffer.setSize$okio(buffer.size() - j2);
                setSize$okio(size() + j2);
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }
}

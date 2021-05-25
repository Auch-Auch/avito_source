package a2.b.a.a;

import a2.t.a.c.j0;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.util.StringUtil;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.channels.mvi.common.v2.AbstractMviEvent;
import com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeReadWriteLock;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgentImpl;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2;
import com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoImpl;
import com.avito.android.publish.slots.contact_info.ContactInfoSlotWrapper;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.avito.android.remote.model.category_parameters.slot.SlotWidget;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.tasks.i;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.my.target.ae;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.call.PCStream;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.UUID;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.DKodein;
import org.kodein.di.DKodeinAware;
import org.reactivestreams.Publisher;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.digests.MD4Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.RIPEMD320Digest;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.pqc.crypto.xmss.DefaultXMSSMTOid;
import org.xmlpull.v1.XmlPullParser;
import ru.avito.messenger.internal.gson.TypeId;
import t6.r.a.j;
/* compiled from: outline */
public class a {
    public static String A(StringBuilder sb, boolean z, char c) {
        sb.append(z);
        sb.append(c);
        return sb.toString();
    }

    public static void A0(int i, Canvas canvas, int i2, int i3) {
        InlineMarker.finallyStart(i);
        canvas.restoreToCount(i2);
        InlineMarker.finallyEnd(i3);
    }

    public static RemoteException A1(String str, Throwable th) {
        zzbbd.zzc(str, th);
        return new RemoteException();
    }

    public static String A2(IOException iOException, StringBuilder sb) {
        sb.append(iOException.getMessage());
        return sb.toString();
    }

    public static String B(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        sb.append(str);
        return sb.toString();
    }

    public static int B0(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    public static Timer B1() {
        Timer timer = new TimerFactory().timer();
        timer.start();
        return timer;
    }

    public static String B2(Class cls, StringBuilder sb) {
        sb.append(cls.getName());
        return sb.toString();
    }

    public static String C(ASN1Sequence aSN1Sequence, StringBuilder sb) {
        sb.append(aSN1Sequence.size());
        return sb.toString();
    }

    public static void C0(int i, String str, HashMap hashMap, String str2) {
        hashMap.put(str2, new DefaultXMSSMTOid(i, str));
    }

    public static SlotConfig C1(ContactInfoSlotWrapper contactInfoSlotWrapper) {
        return contactInfoSlotWrapper.getSlot().getWidget().getConfig();
    }

    public static String C2(Class cls, StringBuilder sb, char c, String str) {
        sb.append(cls.getCanonicalName());
        sb.append(c);
        sb.append(str);
        return sb.toString();
    }

    public static String D(ASN1TaggedObject aSN1TaggedObject, StringBuilder sb) {
        sb.append(aSN1TaggedObject.getTagNo());
        return sb.toString();
    }

    public static void D0(int i, HashMap hashMap, String str, int i2, String str2, int i3, String str3, int i4, String str4) {
        hashMap.put(str, Integer.valueOf(i));
        hashMap.put(str2, Integer.valueOf(i2));
        hashMap.put(str3, Integer.valueOf(i3));
        hashMap.put(str4, Integer.valueOf(i4));
    }

    public static SimpleAdapterPresenter D1(ItemBinder itemBinder, String str, ItemBinder itemBinder2, ItemBinder itemBinder3) {
        Intrinsics.checkNotNullParameter(itemBinder, str);
        return new SimpleAdapterPresenter(itemBinder2, itemBinder3);
    }

    public static String D2(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
        return sb.toString();
    }

    public static String E(CipherParameters cipherParameters, StringBuilder sb) {
        sb.append(cipherParameters.getClass().getName());
        return sb.toString();
    }

    public static void E0(int i, ReceiveChannel receiveChannel, Throwable th, int i2) {
        InlineMarker.finallyStart(i);
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(i2);
    }

    public static SimpleRecyclerAdapter E1(AdapterPresenter adapterPresenter, String str, ItemBinder itemBinder, String str2, AdapterPresenter adapterPresenter2, ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(adapterPresenter, str);
        Intrinsics.checkNotNullParameter(itemBinder, str2);
        return new SimpleRecyclerAdapter(adapterPresenter2, itemBinder2);
    }

    public static String E2(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getSimpleName());
        sb.append(str);
        return sb.toString();
    }

    public static String F(ConfigurableProvider configurableProvider, String str, String str2, String str3, String str4) {
        configurableProvider.addAlgorithm(str, str2);
        return str3 + str4;
    }

    public static void F0(Rect rect, String str, View view, String str2, RecyclerView recyclerView, String str3, RecyclerView.State state, String str4) {
        Intrinsics.checkNotNullParameter(rect, str);
        Intrinsics.checkNotNullParameter(view, str2);
        Intrinsics.checkNotNullParameter(recyclerView, str3);
        Intrinsics.checkNotNullParameter(state, str4);
    }

    public static IObjectWrapper F1(Parcel parcel) {
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return asInterface;
    }

    public static String F2(Exception exc, StringBuilder sb) {
        sb.append(exc.getMessage());
        return sb.toString();
    }

    public static String G(XmlPullParser xmlPullParser, StringBuilder sb) {
        sb.append(xmlPullParser.getName());
        return sb.toString();
    }

    public static void G0(Parcel parcel, int i, Boolean bool) {
        parcel.writeInt(i);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public static int G1(int i, int i2, int i3, int i4) {
        return i + i2 + i3 + i4;
    }

    public static String G2(Exception exc, StringBuilder sb) {
        sb.append(exc.toString());
        return sb.toString();
    }

    public static String H(Object[] objArr, int i, String str, String str2) {
        String format = String.format(str, Arrays.copyOf(objArr, i));
        Intrinsics.checkNotNullExpressionValue(format, str2);
        return format;
    }

    public static void H0(Parcel parcel, int i, Integer num) {
        parcel.writeInt(i);
        parcel.writeInt(num.intValue());
    }

    public static i H1(aa aaVar, String str, Object[] objArr) {
        aaVar.c(str, objArr);
        return new i();
    }

    public static String H2(Object obj, StringBuilder sb) {
        sb.append(obj.getClass().getName());
        return sb.toString();
    }

    public static StringBuilder I(char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        return sb;
    }

    public static void I0(Parcel parcel, int i, Long l) {
        parcel.writeInt(i);
        parcel.writeLong(l.longValue());
    }

    public static JsonObject I1(JsonElement jsonElement, String str, Type type, String str2, JsonDeserializationContext jsonDeserializationContext, String str3) {
        Intrinsics.checkNotNullParameter(jsonElement, str);
        Intrinsics.checkNotNullParameter(type, str2);
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, str3);
        return jsonElement.getAsJsonObject();
    }

    public static String I2(String str) {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, str);
        return uuid;
    }

    public static int J(int i, int i2, RIPEMD320Digest rIPEMD320Digest, int i3, int i4) {
        return rIPEMD320Digest.a(i + i2, i3) + i4;
    }

    public static void J0(TrackerInfoProvider trackerInfoProvider, StringBuilder sb, String str, char c) {
        sb.append(trackerInfoProvider.getPrefixStatsd());
        sb.append(str);
        sb.append(c);
    }

    public static Relay J1(String str) {
        Relay serialized = PublishRelay.create().toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, str);
        return serialized;
    }

    public static int J2(int i, int i2, int i3, MD4Digest mD4Digest, int i4) {
        return mD4Digest.d(i + i2 + i3, i4);
    }

    public static StringBuilder K(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    public static void K0(AbstractMviEvent abstractMviEvent, StringBuilder sb, char c) {
        sb.append(abstractMviEvent.getClass().getSimpleName());
        sb.append(c);
    }

    public static Completable K1(ChannelSyncAgentImpl channelSyncAgentImpl, Completable completable, String str) {
        Completable observeOn = completable.observeOn(ChannelSyncAgentImpl.access$getSchedulers$p(channelSyncAgentImpl).computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, str);
        return observeOn;
    }

    public static String K2(String str, char c) {
        return str + c;
    }

    public static StringBuilder L(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static void L0(SimpleDraweeView simpleDraweeView, Picture picture) {
        SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).picture(picture).load();
    }

    public static Completable L1(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, Completable completable, String str) {
        Completable observeOn = completable.observeOn(ChannelsBackendNotificationsHandlerImpl.access$getSchedulers$p(channelsBackendNotificationsHandlerImpl).computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, str);
        return observeOn;
    }

    public static String L2(String str, char c, String str2) {
        return str + c + str2;
    }

    public static StringBuilder M(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static long M0(long j, long j2, long j3, long j4) {
        return (j * j2) + j3 + j4;
    }

    public static Completable M1(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, Completable completable, String str) {
        Completable subscribeOn = completable.subscribeOn(ChannelsBackendNotificationsHandlerImpl.access$getSchedulers$p(channelsBackendNotificationsHandlerImpl).computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, str);
        return subscribeOn;
    }

    public static String M2(String str, int i) {
        return str + i;
    }

    public static StringBuilder N(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static void N0(j0 j0Var, StringBuilder sb, String str) {
        sb.append(j0Var.a());
        sb.append(str);
        Logger.e(sb.toString());
    }

    public static Completable N1(MessageRepoImpl messageRepoImpl, String str, Map map, Completable completable, String str2) {
        Completable retryWhen = completable.retryWhen(new Function<Flowable<Throwable>, Publisher<?>>(str, map) { // from class: com.avito.android.messenger.conversation.mvi.data.MessageRepoImpl$trackError$3
            public final /* synthetic */ String b;
            public final /* synthetic */ Map c;

            {
                this.b = r2;
                this.c = r3;
            }

            public final Publisher<?> apply(@NotNull Flowable<Throwable> flowable) {
                Intrinsics.checkNotNullParameter(flowable, "errors");
                DatabaseErrorHandler databaseErrorHandler = MessageRepoImpl.this.e;
                Observable<Throwable> observable = flowable.toObservable();
                Intrinsics.checkNotNullExpressionValue(observable, "errors.toObservable()");
                return databaseErrorHandler.handleErrors(observable, this.b, this.c).toFlowable(BackpressureStrategy.BUFFER);
            }
        });
        Intrinsics.checkNotNullExpressionValue(retryWhen, str2);
        return retryWhen;
    }

    public static String N2(String str, int i, int i2) {
        return str.substring(str.indexOf(i) + i2);
    }

    public static StringBuilder O(String str, long j, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(j);
        sb.append(str2);
        return sb;
    }

    public static void O0(Call call, StringBuilder sb, String str) {
        sb.append(call.b());
        sb.append(str);
    }

    public static Completable O1(StringBuilder sb, SortedSet sortedSet, char c, ChannelSyncAgentImpl channelSyncAgentImpl, Completable completable) {
        sb.append(sortedSet);
        sb.append(c);
        return channelSyncAgentImpl.log(completable, sb.toString());
    }

    public static String O2(String str, int i, int i2) {
        return str.substring(i2, str.length() + i);
    }

    public static StringBuilder P(String str, JsonToken jsonToken, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(jsonToken);
        sb.append(str2);
        return sb;
    }

    public static void P0(Call call, StringBuilder sb, String str) {
        sb.append(call.b());
        sb.append(str);
        Logger.e(sb.toString());
    }

    public static Observable P1(ChannelSyncAgentImpl channelSyncAgentImpl, Observable observable) {
        return observable.observeOn(ChannelSyncAgentImpl.access$getSchedulers$p(channelSyncAgentImpl).computation());
    }

    public static String P2(String str, int i, int i2) {
        return String.valueOf(str.substring(i, i2).toLowerCase());
    }

    public static StringBuilder Q(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static void Q0(Call call, StringBuilder sb, String str) {
        sb.append(call.b());
        sb.append(str);
        Logger.i(sb.toString());
    }

    public static Observable Q1(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, Observable observable) {
        return observable.observeOn(ChannelsBackendNotificationsHandlerImpl.access$getSchedulers$p(channelsBackendNotificationsHandlerImpl).computation());
    }

    public static String Q2(String str, int i, String str2) {
        return str + i + str2;
    }

    public static StringBuilder R(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void R0(PCStream pCStream, StringBuilder sb, String str) {
        sb.append(pCStream.i());
        sb.append(str);
        Logger.e(sb.toString());
    }

    public static int R1(int i, int i2, int i3, int i4) {
        return ((i - i2) / i3) + i4;
    }

    public static String R2(String str, int i, String str2, int i2) {
        return str + i + str2 + i2;
    }

    public static StringBuilder S(String str, String str2, String str3, int i, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(i);
        sb.append(str4);
        return sb;
    }

    public static void S0(PCStream pCStream, StringBuilder sb, String str) {
        sb.append(pCStream.i());
        sb.append(str);
        Logger.i(sb.toString());
    }

    public static Observable S1(SchedulersFactory schedulersFactory, Observable observable, String str) {
        Observable subscribeOn = observable.subscribeOn(schedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, str);
        return subscribeOn;
    }

    public static String S2(String str, int i, String str2, int i2, String str3) {
        return str + i + str2 + i2 + str3;
    }

    public static StringBuilder T(String str, String str2, String str3, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(j);
        return sb;
    }

    public static void T0(String str, int i, String str2) {
        Log.w(str2, str + i);
    }

    public static Observable T1(SchedulersFactory schedulersFactory, Observable observable, String str) {
        Observable observeOn = observable.observeOn(schedulersFactory.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, str);
        return observeOn;
    }

    public static String T2(String str, long j) {
        return str + j;
    }

    public static int U(Parcel parcel, LinkedHashMap linkedHashMap, String str, int i, int i2) {
        linkedHashMap.put(str, parcel.readString());
        return i + i2;
    }

    public static void U0(String str, String str2) {
        ae.a(str + str2);
    }

    public static Single U1(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, Single single) {
        return single.observeOn(ChannelsBackendNotificationsHandlerImpl.access$getSchedulers$p(channelsBackendNotificationsHandlerImpl).computation());
    }

    public static int U2(int i, int i2, int i3, MD5Digest mD5Digest, int i4, int i5) {
        return mD5Digest.e(i + i2 + i3, i4) + i5;
    }

    public static StringBuilder V(String str, String str2, String str3, String str4, String str5) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append(str);
        newStringBuilder.append(str2);
        newStringBuilder.append(str3);
        newStringBuilder.append(str4);
        newStringBuilder.append(str5);
        return newStringBuilder;
    }

    public static void V0(String str, String str2, String str3) {
        Log.w(str3, str + str2);
    }

    public static Single V1(SchedulersFactory schedulersFactory, Single single, String str) {
        Single subscribeOn = single.subscribeOn(schedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, str);
        return subscribeOn;
    }

    public static String V2(String str, long j, String str2) {
        return str + j + str2;
    }

    public static StringBuilder W(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static void W0(String str, String str2, String str3, String str4, DeepLink deepLink, String str5) {
        Intrinsics.checkNotNullParameter(str, str2);
        Intrinsics.checkNotNullParameter(str3, str4);
        Intrinsics.checkNotNullParameter(deepLink, str5);
    }

    public static Single W1(Observable observable, ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1 channelSyncAgentImpl$getNonEmptyChatIdsFromDb$1, String str) {
        Single firstOrError = observable.filter(channelSyncAgentImpl$getNonEmptyChatIdsFromDb$1).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, str);
        return firstOrError;
    }

    public static String W2(String str, Uri uri) {
        return str + uri;
    }

    public static StringBuilder X(String str, SimpleTypeMarker simpleTypeMarker, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(simpleTypeMarker);
        sb.append(str2);
        return sb;
    }

    public static Intent X0(Context context, String str, Context context2, Class cls) {
        Intrinsics.checkNotNullParameter(context, str);
        return new Intent(context2, cls);
    }

    public static Single X1(Observable observable, ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2 channelSyncAgentImpl$getNonEmptyChatIdsFromDb$2, String str) {
        Single firstOrError = observable.filter(channelSyncAgentImpl$getNonEmptyChatIdsFromDb$2).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, str);
        return firstOrError;
    }

    public static String X2(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static StringBuilder Y(StringBuilder sb, String str, String str2, ConfigurableProvider configurableProvider, String str3) {
        sb.append(str);
        sb.append(str2);
        configurableProvider.addAlgorithm(str3, sb.toString());
        return new StringBuilder();
    }

    public static void Y0(String str, String str2, String str3, String str4, SlotWidget slotWidget, String str5) {
        Intrinsics.checkNotNullParameter(str, str2);
        Intrinsics.checkNotNullParameter(str3, str4);
        Intrinsics.checkNotNullParameter(slotWidget, str5);
    }

    public static Single Y1(StringBuilder sb, SortedSet sortedSet, char c, ChannelSyncAgentImpl channelSyncAgentImpl, Single single) {
        sb.append(sortedSet);
        sb.append(c);
        return channelSyncAgentImpl.log(single, sb.toString());
    }

    public static String Y2(String str, File file) {
        return str + file;
    }

    public static StringBuilder Z(StringBuilder sb, String str, ConfigurableProvider configurableProvider, String str2, String str3) {
        sb.append(str);
        configurableProvider.addAlgorithm(str2, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        return sb2;
    }

    public static void Z0(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, str2);
        Intrinsics.checkNotNullParameter(str3, str4);
        Intrinsics.checkNotNullParameter(str5, str6);
    }

    public static io.reactivex.rxjava3.core.Flowable Z1(SchedulersFactory3 schedulersFactory3, io.reactivex.rxjava3.core.Flowable flowable, String str) {
        io.reactivex.rxjava3.core.Flowable observeOn = flowable.observeOn(schedulersFactory3.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, str);
        return observeOn;
    }

    public static String Z2(String str, IOException iOException) {
        return str + iOException;
    }

    public static double a(double d, double d2, double d3) {
        return (Math.sin(d) * d2) + d3;
    }

    public static StringBuilder a0(StringBuilder sb, String str, ConfigurableProvider configurableProvider, String str2, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        sb.append(str);
        configurableProvider.addAlgorithm(str2, aSN1ObjectIdentifier, sb.toString());
        return new StringBuilder();
    }

    public static void a1(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkParameterIsNotNull(str, str2);
        Intrinsics.checkParameterIsNotNull(str3, str4);
        Intrinsics.checkParameterIsNotNull(str5, str6);
    }

    public static io.reactivex.rxjava3.core.Observable a2(SchedulersFactory3 schedulersFactory3, io.reactivex.rxjava3.core.Observable observable, String str) {
        io.reactivex.rxjava3.core.Observable subscribeOn = observable.subscribeOn(schedulersFactory3.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, str);
        return subscribeOn;
    }

    public static String a3(String str, Exception exc) {
        return str + exc;
    }

    public static float b(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static StringBuilder b0(StringBuilder sb, ASN1ObjectIdentifier aSN1ObjectIdentifier, ConfigurableProvider configurableProvider, String str, String str2) {
        sb.append(aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(sb.toString(), str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        return sb2;
    }

    public static void b1(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, str2);
        Intrinsics.checkNotNullParameter(str3, str4);
        Intrinsics.checkNotNullParameter(str5, str6);
        Intrinsics.checkNotNullParameter(str7, str8);
    }

    public static io.reactivex.rxjava3.core.Observable b2(SchedulersFactory3 schedulersFactory3, io.reactivex.rxjava3.core.Observable observable, String str) {
        io.reactivex.rxjava3.core.Observable observeOn = observable.observeOn(schedulersFactory3.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, str);
        return observeOn;
    }

    public static String b3(String str, Object obj) {
        return str + obj;
    }

    public static int c(int i, int i2, int i3, RIPEMD160Digest rIPEMD160Digest, int i4, int i5) {
        return rIPEMD160Digest.a(i + i2 + i3, i4) + i5;
    }

    public static StringBuilder c0(ConfigurableProvider configurableProvider, String str, String str2, String str3, String str4) {
        configurableProvider.addAlgorithm(str, str2);
        configurableProvider.addAlgorithm(str3, str4);
        return new StringBuilder();
    }

    public static void c1(String str, String str2, String str3, String str4, List list, String str5) {
        Intrinsics.checkNotNullParameter(str, str2);
        Intrinsics.checkNotNullParameter(str3, str4);
        Intrinsics.checkNotNullParameter(list, str5);
    }

    public static int c2(int i, int i2, int i3, int i4) {
        return (i * i2) + i3 + i4;
    }

    public static String c3(String str, String str2) {
        return str + str2;
    }

    public static String d(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static StringBuilder d0(ConfigurableProvider configurableProvider, String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2, String str3) {
        configurableProvider.addAlgorithm(str, aSN1ObjectIdentifier, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        return sb;
    }

    public static void d1(String str, String str2, List list, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, str2);
        Intrinsics.checkNotNullParameter(list, str3);
        Intrinsics.checkNotNullParameter(str4, str5);
    }

    public static io.reactivex.rxjava3.core.Single d2(TypedResult.OfResult ofResult, String str) {
        io.reactivex.rxjava3.core.Single just = io.reactivex.rxjava3.core.Single.just(ofResult.getResult());
        Intrinsics.checkNotNullExpressionValue(just, str);
        return just;
    }

    public static String d3(String str, String str2, char c) {
        return str + str2 + c;
    }

    public static String e(String str, String str2, String str3, String str4, char c) {
        return str + str2 + str3 + str4 + c;
    }

    public static BigInteger e0(ECDomainParameters eCDomainParameters) {
        return eCDomainParameters.getG().getAffineXCoord().toBigInteger();
    }

    public static void e1(String str, String str2, ConfigurableProvider configurableProvider, String str3, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        configurableProvider.addAlgorithm(str3, aSN1ObjectIdentifier, str + str2);
    }

    public static io.reactivex.rxjava3.core.Single e2(SchedulersFactory3 schedulersFactory3, io.reactivex.rxjava3.core.Single single, String str) {
        io.reactivex.rxjava3.core.Single subscribeOn = single.subscribeOn(schedulersFactory3.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, str);
        return subscribeOn;
    }

    public static String e3(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String f(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static int f0(Integer num, String str, int i) {
        Intrinsics.checkNotNullParameter(num, str);
        return Intrinsics.compare(num.intValue(), i);
    }

    public static void f1(String str, StringBuilder sb, char c, StringBuilder sb2, String str2) {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, str);
        sb.append(currentThread.getName());
        sb.append(c);
        sb2.append(sb.toString());
        sb2.append(str2);
    }

    public static io.reactivex.rxjava3.core.Single f2(String str) {
        io.reactivex.rxjava3.core.Single just = io.reactivex.rxjava3.core.Single.just(CollectionsKt__CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(just, str);
        return just;
    }

    public static String g(String str, StringBuilder sb, char c, StringBuilder sb2, String str2) {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, str);
        sb.append(currentThread.getName());
        sb.append(c);
        sb2.append(sb.toString());
        sb2.append(str2);
        return sb2.toString();
    }

    public static BigInteger g0(ECDomainParameters eCDomainParameters) {
        return eCDomainParameters.getG().getAffineYCoord().toBigInteger();
    }

    public static void g1(String str, StringBuilder sb, char c, StringBuilder sb2, String str2, RxFairCompositeReadWriteLock.b bVar) {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, str);
        sb.append(currentThread.getName());
        sb.append(c);
        sb2.append(sb.toString());
        sb2.append(str2);
        sb2.append(bVar);
    }

    public static Object g2(ValueAnimator valueAnimator, String str, String str2) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, str);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, str2);
        return animatedValue;
    }

    public static String h(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2) {
        return str + aSN1ObjectIdentifier + str2;
    }

    public static ArrayList h0(LinkedHashMap linkedHashMap, Object obj) {
        ArrayList arrayList = new ArrayList();
        linkedHashMap.put(obj, arrayList);
        return arrayList;
    }

    public static void h1(StringBuilder sb, int i, String str, SortedSet sortedSet, String str2) {
        sb.append(i);
        sb.append(str);
        sb.append(sortedSet);
        sb.append(str2);
    }

    public static Object h2(CharSequence charSequence, int i, Function1 function1) {
        return function1.invoke(Character.valueOf(charSequence.charAt(i)));
    }

    public static String i(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    public static ArrayList i0(List list, String str) {
        Intrinsics.checkNotNullParameter(list, str);
        return new ArrayList();
    }

    public static int i1(float f, int i, int i2) {
        return (Float.floatToIntBits(f) + i) * i2;
    }

    public static Object i2(String str, Class cls) {
        return new Gson().fromJson(str, (Class<Object>) cls);
    }

    public static String j(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static ArrayList j0(Map map, Object obj) {
        ArrayList arrayList = new ArrayList();
        map.put(obj, arrayList);
        return arrayList;
    }

    public static Intent j1(Context context, String str, String str2, String str3, Context context2, Class cls, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(context, str);
        Intrinsics.checkNotNullParameter(str2, str3);
        Intent putExtra = new Intent(context2, cls).putExtra(str4, str5);
        Intrinsics.checkNotNullExpressionValue(putExtra, str6);
        return putExtra;
    }

    public static Object j2(List list, int i) {
        return list.get(list.size() - i);
    }

    public static String k(StringBuilder sb, long j, char c) {
        sb.append(j);
        sb.append(c);
        return sb.toString();
    }

    public static HashMap k0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        return hashMap;
    }

    public static void k1(StringBuilder sb, String str, char c, String str2) {
        sb.append(str);
        sb.append(c);
        sb.append(str2);
    }

    public static Object k2(Object[] objArr, int i) {
        return Array.newInstance(objArr.getClass().getComponentType(), i);
    }

    public static String l(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static Iterator l0(Parcel parcel, int i, List list) {
        parcel.writeInt(i);
        parcel.writeInt(list.size());
        return list.iterator();
    }

    public static void l1(StringBuilder sb, String str, long j, String str2) {
        sb.append(str);
        sb.append(j);
        sb.append(str2);
    }

    public static String l2(int i, String str, char c, String str2, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(c);
        sb.append(str2);
        sb.append(i2);
        return sb.toString();
    }

    public static String m(StringBuilder sb, DeepLink deepLink, String str) {
        sb.append(deepLink);
        sb.append(str);
        return sb.toString();
    }

    public static Iterator m0(Parcel parcel, int i, Map map) {
        parcel.writeInt(i);
        parcel.writeInt(map.size());
        return map.entrySet().iterator();
    }

    public static void m1(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    public static String m2(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static int n(int i, int i2, int i3, RIPEMD320Digest rIPEMD320Digest, int i4, int i5) {
        return rIPEMD320Digest.a(i + i2 + i3, i4) + i5;
    }

    public static Iterator n0(List list, Parcel parcel) {
        parcel.writeInt(list.size());
        return list.iterator();
    }

    public static void n1(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static int n2(int i, int i2, int i3, int i4) {
        return (i3 - (i * i2)) / i4;
    }

    public static String o(StringBuilder sb, Boolean bool, String str) {
        sb.append(bool);
        sb.append(str);
        return sb.toString();
    }

    public static Iterator o0(Map map, Parcel parcel) {
        parcel.writeInt(map.size());
        return map.entrySet().iterator();
    }

    public static void o1(StringBuilder sb, String str, String str2, ConfigurableProvider configurableProvider, String str3) {
        sb.append(str);
        sb.append(str2);
        configurableProvider.addAlgorithm(str3, sb.toString());
    }

    public static String o2(int i, String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        return sb.toString();
    }

    public static String p(StringBuilder sb, Integer num, String str) {
        sb.append(num);
        sb.append(str);
        return sb.toString();
    }

    public static KotlinNothingValueException p0() {
        FlowKt.noImpl();
        return new KotlinNothingValueException();
    }

    public static void p1(StringBuilder sb, String str, ConfigurableProvider configurableProvider, String str2) {
        sb.append(str);
        configurableProvider.addAlgorithm(str2, sb.toString());
    }

    public static String p2(int i, String str, int i2, String str2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    public static String q(StringBuilder sb, Object obj, char c) {
        sb.append(obj);
        sb.append(c);
        return sb.toString();
    }

    public static int q0(String str, int i) {
        return String.valueOf(str).length() + i;
    }

    public static void q1(Throwable th, StringBuilder sb) {
        sb.append(th.getMessage());
        ae.a(sb.toString());
    }

    public static String q2(int i, String str, long j) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(j);
        return sb.toString();
    }

    public static String r(StringBuilder sb, Object obj, String str) {
        sb.append(obj);
        sb.append(str);
        return sb.toString();
    }

    public static Pair r0(String str, String str2, int i, j jVar, Class cls) {
        return TuplesKt.to(new TypeId(str, str2, i, jVar), cls);
    }

    public static void r1(Throwable th, StringBuilder sb) {
        sb.append(th.toString());
        ae.b(sb.toString());
    }

    public static String r2(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String s(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    public static Ref.IntRef s0(Object obj) {
        ResultKt.throwOnFailure(obj);
        return new Ref.IntRef();
    }

    public static void s1(List list, AdapterPresenter adapterPresenter) {
        adapterPresenter.onDataSourceChanged(new ListDataSource(list));
    }

    public static String s2(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String t(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static Ref.ObjectRef t0(Object obj) {
        ResultKt.throwOnFailure(obj);
        return new Ref.ObjectRef();
    }

    public static void t1(List list, StringBuilder sb, String str, int i, String str2) {
        sb.append(list.size());
        sb.append(str);
        sb.append(i);
        sb.append(str2);
    }

    public static String t2(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static String u(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static KMutableProperty1 u0(Class cls, String str, String str2, int i) {
        return Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, str, str2, i));
    }

    public static Resources u1(View view, String str) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, str);
        return context.getResources();
    }

    public static String u2(Parcel parcel, String str) {
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        Intrinsics.checkNotNullExpressionValue(readString, str);
        return readString;
    }

    public static String v(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static KProperty1 v0(Class cls, String str, String str2, int i) {
        return Reflection.property1(new PropertyReference1Impl(cls, str, str2, i));
    }

    public static void v1(List list, StringBuilder sb, String str, SortedSet sortedSet, String str2) {
        sb.append(list.size());
        sb.append(str);
        sb.append(sortedSet);
        sb.append(str2);
    }

    public static String v2(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.v());
        return sb.toString();
    }

    public static String w(StringBuilder sb, List list, String str) {
        sb.append(list);
        sb.append(str);
        return sb.toString();
    }

    public static DKodein w0(DKodeinAware dKodeinAware, String str) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, str);
        DKodein dkodein = dKodeinAware.getDkodein();
        Intrinsics.needClassReification();
        return dkodein;
    }

    public static boolean w1(Flags.BooleanFlagField booleanFlagField, int i, String str) {
        Boolean bool = booleanFlagField.get(i);
        Intrinsics.checkNotNullExpressionValue(bool, str);
        return bool.booleanValue();
    }

    public static String w2(ChannelFragment channelFragment, String str, ChannelFragment.Params params, String str2, ViewModelFactory viewModelFactory, String str3) {
        Intrinsics.checkNotNullParameter(channelFragment, str);
        Intrinsics.checkNotNullParameter(params, str2);
        Intrinsics.checkNotNullParameter(viewModelFactory, str3);
        return params.getChannelId();
    }

    public static String x(StringBuilder sb, Map map, String str) {
        sb.append(map);
        sb.append(str);
        return sb.toString();
    }

    public static ASN1EncodableVector x0(ASN1EncodableVector aSN1EncodableVector, ASN1EncodableVector aSN1EncodableVector2) {
        aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector));
        return new ASN1EncodableVector();
    }

    public static byte[] x1(ASN1Sequence aSN1Sequence, int i) {
        return org.spongycastle.util.Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i)).getOctets());
    }

    public static String x2(JsonObject jsonObject, String str, String str2) {
        JsonElement jsonElement = jsonObject.get(str);
        Intrinsics.checkNotNullExpressionValue(jsonElement, str2);
        return jsonElement.getAsString();
    }

    public static int y(int i, int i2, RIPEMD160Digest rIPEMD160Digest, int i3, int i4) {
        return rIPEMD160Digest.a(i + i2, i3) + i4;
    }

    public static ASN1ObjectIdentifier y0(String str) {
        return new ASN1ObjectIdentifier(str).intern();
    }

    public static Bundle y1(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    public static int y2(int i, int i2, int i3, int i4) {
        return ((i * i2) / i3) + i4;
    }

    public static String z(StringBuilder sb, SortedSet sortedSet, String str, SortedSet sortedSet2, char c) {
        sb.append(sortedSet);
        sb.append(str);
        sb.append(sortedSet2);
        sb.append(c);
        return sb.toString();
    }

    public static ECFieldElement z0(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return eCFieldElement.square().add(eCFieldElement2).add(eCFieldElement3);
    }

    public static Parcelable z1(Class cls, Parcel parcel) {
        Parcelable readParcelable = parcel.readParcelable(cls.getClassLoader());
        Intrinsics.checkNotNull(readParcelable);
        return readParcelable;
    }

    public static String z2(JsonReader jsonReader, StringBuilder sb, String str, JsonReader jsonReader2) {
        sb.append(jsonReader.peek());
        sb.append(str);
        sb.append(jsonReader2);
        return sb.toString();
    }
}

package com.avito.android.messenger.conversation;

import a2.a.a.o1.d.b;
import a2.a.a.o1.d.c;
import a2.a.a.o1.d.f;
import a2.a.a.o1.d.g;
import a2.a.a.o1.d.h;
import a2.a.a.o1.d.i;
import a2.a.a.o1.d.k;
import a2.a.a.o1.d.l;
import a2.a.a.o1.d.o;
import a2.a.a.o1.d.p;
import a2.a.a.o1.d.q;
import a2.a.a.o1.d.r;
import a2.a.a.o1.d.s;
import a2.a.a.o1.d.t;
import a2.a.a.o1.d.u;
import a2.a.a.o1.d.w;
import a2.a.a.o1.d.x;
import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.CalledFrom;
import com.avito.android.Features;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.app.di.HasComponent;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.AbuseReportLink;
import com.avito.android.deep_linking.links.ChannelDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.messenger.analytics.DisplayChannelEvent;
import com.avito.android.messenger.channels.mvi.common.v2.Differ;
import com.avito.android.messenger.channels.mvi.common.v2.RendererWithDiff;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.ChannelRouter;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenter;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextView;
import com.avito.android.messenger.conversation.mvi.deeplinks.ActivityResult;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenter;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuCallbacks;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuView;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter;
import com.avito.android.messenger.conversation.mvi.messages.MessageListView;
import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenter;
import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di.ItemsList;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsView;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenter;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter;
import com.avito.android.messenger.conversation.mvi.send.SendMessageViewImpl;
import com.avito.android.messenger.di.ChannelActivityComponent;
import com.avito.android.messenger.di.ChannelFragmentComponent;
import com.avito.android.messenger.di.MessageList;
import com.avito.android.messenger.di.RelativeDateFormatterModule;
import com.avito.android.messenger.map.sharing.SharingMapFragmentKt;
import com.avito.android.permissions.FragmentPermissionHelper;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.permissions.PermissionStorage;
import com.avito.android.photo_picker.PhotoPickerActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.notification.NotificationProvider;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Intents;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Logs;
import com.avito.android.util.ToastsKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.facebook.share.internal.ShareConstants;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ú\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0006ú\u0002û\u0002ü\u0002B\b¢\u0006\u0005\bù\u0002\u0010\u000fJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ-\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010!\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J-\u0010(\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000bH\u0016¢\u0006\u0004\b-\u0010\u000fJ\u000f\u0010.\u001a\u00020\u000bH\u0016¢\u0006\u0004\b.\u0010\u000fJ\u000f\u0010/\u001a\u00020\u000bH\u0016¢\u0006\u0004\b/\u0010\u000fJ\u0017\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u000200H\u0017¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020$H\u0016¢\u0006\u0004\b5\u00106J'\u0010;\u001a\u00020\u000b2\u0006\u00101\u001a\u0002072\u000e\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u000108H\u0016¢\u0006\u0004\b;\u0010<J\u0015\u0010?\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020$H\u0016¢\u0006\u0004\bB\u00106J\u0017\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020$H\u0016¢\u0006\u0004\bD\u00106J\u000f\u0010E\u001a\u00020\u000bH\u0016¢\u0006\u0004\bE\u0010\u000fJ\u0017\u0010G\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020$H\u0016¢\u0006\u0004\bG\u00106J!\u0010K\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020H2\b\u0010J\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\bK\u0010LJ'\u0010O\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020$2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020$\u0018\u000108H\u0016¢\u0006\u0004\bO\u0010PJ7\u0010W\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020$2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020R0#2\b\u0010U\u001a\u0004\u0018\u00010T2\u0006\u0010V\u001a\u00020\u0006H\u0016¢\u0006\u0004\bW\u0010XJ\u0019\u0010[\u001a\u00020\u000b2\b\u0010Z\u001a\u0004\u0018\u00010YH\u0016¢\u0006\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bb\u0010cR\"\u0010f\u001a\u00020e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010m\u001a\u00020l8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010t\u001a\u00020s8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR-\u0010\u0001\u001a\u0018\u0012\u0004\u0012\u00020{\u0012\u0006\u0012\u0004\u0018\u00010|\u0018\u00010zj\u0004\u0018\u0001`}8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b~\u0010R\u001b\u0010\u0001\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R*\u0010¥\u0001\u001a\u00030¤\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R*\u0010¬\u0001\u001a\u00030«\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¬\u0001\u0010­\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u001b\u0010³\u0001\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b²\u0001\u0010\u0001R*\u0010µ\u0001\u001a\u00030´\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R*\u0010¼\u0001\u001a\u00030»\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R*\u0010Ã\u0001\u001a\u00030Â\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R*\u0010Ê\u0001\u001a\u00030É\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R\u001a\u0010Ó\u0001\u001a\u00030Ð\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001c\u0010×\u0001\u001a\u0005\u0018\u00010Ô\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u001a\u0010Û\u0001\u001a\u00030Ø\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u001a\u0010ß\u0001\u001a\u00030Ü\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R*\u0010á\u0001\u001a\u00030à\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bá\u0001\u0010â\u0001\u001a\u0006\bã\u0001\u0010ä\u0001\"\u0006\bå\u0001\u0010æ\u0001R*\u0010è\u0001\u001a\u00030ç\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bè\u0001\u0010é\u0001\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R\u001a\u0010ñ\u0001\u001a\u00030î\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R*\u0010ò\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bò\u0001\u0010\u0001\u001a\u0006\bó\u0001\u0010¡\u0001\"\u0006\bô\u0001\u0010£\u0001R&\u0010õ\u0001\u001a\u00020e8\u0006@\u0006X.¢\u0006\u0015\n\u0005\bõ\u0001\u0010g\u001a\u0005\bö\u0001\u0010i\"\u0005\b÷\u0001\u0010kR*\u0010ù\u0001\u001a\u00030ø\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bù\u0001\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001RB\u0010\u0002\u001a+\u0012\r\u0012\u000b \u0002*\u0004\u0018\u00010\u00060\u0006 \u0002*\u0014\u0012\r\u0012\u000b \u0002*\u0004\u0018\u00010\u00060\u0006\u0018\u00010ÿ\u00010ÿ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\u001c\u0010£\u0002\u001a\u0005\u0018\u00010 \u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¡\u0002\u0010¢\u0002R*\u0010¥\u0002\u001a\u00030¤\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¥\u0002\u0010¦\u0002\u001a\u0006\b§\u0002\u0010¨\u0002\"\u0006\b©\u0002\u0010ª\u0002R\u0019\u0010¬\u0002\u001a\u00020$8\u0002@\u0002X.¢\u0006\b\n\u0006\b«\u0002\u0010\u0001R\u001a\u0010°\u0002\u001a\u00030­\u00028\u0002@\u0002X.¢\u0006\b\n\u0006\b®\u0002\u0010¯\u0002R*\u0010²\u0002\u001a\u00030±\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b²\u0002\u0010³\u0002\u001a\u0006\b´\u0002\u0010µ\u0002\"\u0006\b¶\u0002\u0010·\u0002R*\u0010¹\u0002\u001a\u00030¸\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¹\u0002\u0010º\u0002\u001a\u0006\b»\u0002\u0010¼\u0002\"\u0006\b½\u0002\u0010¾\u0002R\u001a\u0010Â\u0002\u001a\u00030¿\u00028\u0002@\u0002X.¢\u0006\b\n\u0006\bÀ\u0002\u0010Á\u0002R*\u0010Ä\u0002\u001a\u00030Ã\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÄ\u0002\u0010Å\u0002\u001a\u0006\bÆ\u0002\u0010Ç\u0002\"\u0006\bÈ\u0002\u0010É\u0002R*\u0010Ë\u0002\u001a\u00030Ê\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bË\u0002\u0010Ì\u0002\u001a\u0006\bÍ\u0002\u0010Î\u0002\"\u0006\bÏ\u0002\u0010Ð\u0002R!\u0010Õ\u0002\u001a\n\u0012\u0005\u0012\u00030Ò\u00020Ñ\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÓ\u0002\u0010Ô\u0002R\u001b\u0010Ø\u0002\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÖ\u0002\u0010×\u0002R\u001a\u0010Ü\u0002\u001a\u00030Ù\u00028\u0002@\u0002X.¢\u0006\b\n\u0006\bÚ\u0002\u0010Û\u0002R*\u0010Þ\u0002\u001a\u00030Ý\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÞ\u0002\u0010ß\u0002\u001a\u0006\bà\u0002\u0010á\u0002\"\u0006\bâ\u0002\u0010ã\u0002R\u0019\u0010æ\u0002\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bä\u0002\u0010å\u0002R\u001c\u0010ê\u0002\u001a\u0005\u0018\u00010ç\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bè\u0002\u0010é\u0002R*\u0010ì\u0002\u001a\u00030ë\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bì\u0002\u0010í\u0002\u001a\u0006\bî\u0002\u0010ï\u0002\"\u0006\bð\u0002\u0010ñ\u0002R*\u0010ó\u0002\u001a\u00030ò\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bó\u0002\u0010ô\u0002\u001a\u0006\bõ\u0002\u0010ö\u0002\"\u0006\b÷\u0002\u0010ø\u0002¨\u0006ý\u0002"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/remote/notification/NotificationProvider$Handler;", "Lcom/avito/android/messenger/conversation/ChannelRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "onDetach", "()V", "onResume", "onPause", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onStart", "onStop", "onDestroyView", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "handleMessage", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", "operationId", "openPhotoPicker", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/AbuseReportLink;", "", "Lcom/avito/android/remote/model/Action;", "actions", "openAbuseReportScreen", "(Lcom/avito/android/deep_linking/links/AbuseReportLink;Ljava/util/List;)V", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "item", "onFeedbackItemSelected", "(Lcom/avito/android/remote/feedback/FeedbackAdvertItem;)V", "phoneNumber", "onCallSellerConfirmed", AnalyticFieldsName.orderId, "showOrderCancelScreen", "openPlayStore", "url", "openUrl", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, MessageBody.File.MIME_TYPE, "openFile", "(Landroid/net/Uri;Ljava/lang/String;)V", "text", "templates", "onReplySuggestClicked", "(Ljava/lang/String;Ljava/util/List;)V", "title", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "initialGeoMarkers", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "markersRequest", "lockBottomSheet", "showPlatformMap", "(Ljava/lang/String;[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;Z)V", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "initialPosition", "openSharingMap", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;)V", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView;", "p", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView;", "channelMenuView", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView;", "k", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView;", "newMessagesView", "Lcom/avito/konveyor/ItemBinder;", "messageListItemBinder", "Lcom/avito/konveyor/ItemBinder;", "getMessageListItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setMessageListItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter;", "sendMessagePresenter", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter;", "getSendMessagePresenter", "()Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter;", "setSendMessagePresenter", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "D", "Lkotlin/Pair;", "fileMessageToDownload", "t", "Ljava/lang/String;", "messageId", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;", "legacyPlatformActionsPresenter", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;", "getLegacyPlatformActionsPresenter", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;", "setLegacyPlatformActionsPresenter", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;)V", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView;", VKApiConst.Q, "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView;", "channelReplySuggestsView", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenter;", "channelMenuPresenter", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenter;", "getChannelMenuPresenter", "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenter;", "setChannelMenuPresenter", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "itemsListAdapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getItemsListAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setItemsListAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/permissions/PermissionStorage;", "permissionStorage", "Lcom/avito/android/permissions/PermissionStorage;", "getPermissionStorage", "()Lcom/avito/android/permissions/PermissionStorage;", "setPermissionStorage", "(Lcom/avito/android/permissions/PermissionStorage;)V", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;", "messageListPresenter", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;", "getMessageListPresenter", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;", "setMessageListPresenter", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;)V", "u", "searchQuery", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "perfTracker", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "getPerfTracker", "()Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "setPerfTracker", "(Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;)V", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "supplier", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "getSupplier", "()Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "setSupplier", "(Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;)V", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;", "messageMenuCallbacks", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;", "getMessageMenuCallbacks", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;", "setMessageMenuCallbacks", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;)V", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;", "contextActionsPresenter", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;", "getContextActionsPresenter", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;", "setContextActionsPresenter", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;)V", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView;", "j", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView;", "messageListView", "Lio/reactivex/disposables/Disposable;", "x", "Lio/reactivex/disposables/Disposable;", "keyboardVisibilitySubscription", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView;", "o", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView;", "channelContextView", "Lio/reactivex/disposables/CompositeDisposable;", "z", "Lio/reactivex/disposables/CompositeDisposable;", "viewSubscriptions", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator;", "platformActionsCoordinator", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator;", "getPlatformActionsCoordinator", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator;", "setPlatformActionsCoordinator", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator;)V", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsView;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsView;", "samplePlatformActionsView", "messageListAdapterPresenter", "getMessageListAdapterPresenter", "setMessageListAdapterPresenter", "itemsListItemBinder", "getItemsListItemBinder", "setItemsListItemBinder", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenter;", "channelContextPresenter", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenter;", "getChannelContextPresenter", "()Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenter;", "setChannelContextPresenter", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenter;)V", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "kotlin.jvm.PlatformType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "keyboardVisibilityRelay", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessorListener;", "deeplinkProcessorListener", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessorListener;", "getDeeplinkProcessorListener", "()Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessorListener;", "setDeeplinkProcessorListener", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessorListener;)V", "Lcom/avito/android/permissions/PermissionHelper;", "permissionHelper", "Lcom/avito/android/permissions/PermissionHelper;", "getPermissionHelper", "()Lcom/avito/android/permissions/PermissionHelper;", "setPermissionHelper", "(Lcom/avito/android/permissions/PermissionHelper;)V", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter;", "itemsListPresenter", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter;", "getItemsListPresenter", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter;", "setItemsListPresenter", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter;)V", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsPresenter;", "channelReplySuggestsPresenter", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsPresenter;", "getChannelReplySuggestsPresenter", "()Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsPresenter;", "setChannelReplySuggestsPresenter", "(Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsPresenter;)V", "Lcom/avito/android/messenger/conversation/ChannelRootRouter;", "y", "Lcom/avito/android/messenger/conversation/ChannelRootRouter;", "rootRouter", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "s", "channelId", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView;", "l", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView;", "legacyPlatformActionsView", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;", "messageMenuPresenter", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;", "getMessageMenuPresenter", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;", "setMessageMenuPresenter", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuView;", "r", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuView;", "messageMenuView", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenter;", "newMessagesPresenter", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenter;", "getNewMessagesPresenter", "()Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenter;", "setNewMessagesPresenter", "(Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenter;)V", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "getConnectivityProvider", "()Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "setConnectivityProvider", "(Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/ActivityResult;", "B", "Landroidx/lifecycle/MutableLiveData;", "activityResultStream", VKApiConst.VERSION, "Ljava/lang/Integer;", "numberInList", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageViewImpl;", "n", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageViewImpl;", "sendMessageView", "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "Lcom/avito/android/ServiceIntentFactory;", "getServiceIntentFactory", "()Lcom/avito/android/ServiceIntentFactory;", "setServiceIntentFactory", "(Lcom/avito/android/ServiceIntentFactory;)V", "C", "Z", "userChangedText", "Lcom/avito/android/CalledFrom;", "w", "Lcom/avito/android/CalledFrom;", "calledFrom", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "deeplinkProcessor", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "getDeeplinkProcessor", "()Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "setDeeplinkProcessor", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;)V", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "getBuildInfo", "()Lcom/avito/android/util/BuildInfo;", "setBuildInfo", "(Lcom/avito/android/util/BuildInfo;)V", "<init>", "Companion", AuthSource.SEND_ABUSE, "Params", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelFragment extends TabBaseFragment implements NotificationProvider.Handler, ChannelRouter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final BehaviorRelay<Boolean> A = BehaviorRelay.createDefault(Boolean.FALSE);
    public final MutableLiveData<ActivityResult> B = new MutableLiveData<>();
    public boolean C;
    public Pair<LocalMessage, MessageMetaInfo> D;
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public BuildInfo buildInfo;
    @Inject
    public ChannelContextPresenter channelContextPresenter;
    @Inject
    public ChannelMenuPresenter channelMenuPresenter;
    @Inject
    public ChannelReplySuggestsPresenter channelReplySuggestsPresenter;
    @Inject
    public ConnectivityProvider connectivityProvider;
    @Inject
    public ContextActionsPresenter contextActionsPresenter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DeeplinkProcessor deeplinkProcessor;
    @Inject
    public DeeplinkProcessorListener deeplinkProcessorListener;
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @ItemsList
    @Inject
    public AdapterPresenter itemsListAdapterPresenter;
    @ItemsList
    @Inject
    public ItemBinder itemsListItemBinder;
    @Inject
    public ItemsListPresenter itemsListPresenter;
    public MessageListView j;
    public NewMessagesView k;
    public LegacyPlatformActionsView l;
    @Inject
    public LegacyPlatformActionsPresenter legacyPlatformActionsPresenter;
    public SamplePlatformActionsView m;
    @Inject
    @MessageList
    public AdapterPresenter messageListAdapterPresenter;
    @Inject
    @MessageList
    public ItemBinder messageListItemBinder;
    @Inject
    public MessageListPresenter messageListPresenter;
    @Inject
    public MessageMenuCallbacks messageMenuCallbacks;
    @Inject
    public MessageMenuPresenter messageMenuPresenter;
    public SendMessageViewImpl n;
    @Inject
    public NewMessagesPresenter newMessagesPresenter;
    public ChannelContextView o;
    public ChannelMenuView p;
    @Inject
    public ChannelTracker perfTracker;
    @Inject
    public PermissionHelper permissionHelper;
    @Inject
    public PermissionStorage permissionStorage;
    @Inject
    public PlatformActionsCoordinator platformActionsCoordinator;
    public ChannelReplySuggestsView q;
    public MessageMenuView r;
    public String s;
    @Inject
    public SendMessagePresenter sendMessagePresenter;
    @Inject
    public ServiceIntentFactory serviceIntentFactory;
    @Inject
    public FpsStateSupplier supplier;
    public String t;
    public String u;
    public Integer v;
    public CalledFrom w;
    public Disposable x;
    public ChannelRootRouter y;
    public final CompositeDisposable z = new CompositeDisposable();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelFragment$Companion;", "", "", "channelId", "", "numberInList", "messageId", "searchQuery", "Lcom/avito/android/messenger/conversation/ChannelFragment;", "newInstance", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/ChannelFragment;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final ChannelFragment newInstance(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            Bundle bundle = new Bundle(1);
            bundle.putString("channelId", str);
            bundle.putString("messageId", str2);
            bundle.putString("searchQuery", str3);
            if (num != null) {
                bundle.putInt("numberInList", num.intValue());
            }
            ChannelFragment channelFragment = new ChannelFragment();
            channelFragment.setArguments(bundle);
            return channelFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelFragment$Params;", "", "", "c", "Ljava/lang/String;", "getSearchQuery", "()Ljava/lang/String;", "searchQuery", AuthSource.SEND_ABUSE, "getChannelId", "channelId", AuthSource.BOOKING_ORDER, "getMessageId", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        @NotNull
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;

        public Params(@NotNull String str, @Nullable String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @NotNull
        public final String getChannelId() {
            return this.a;
        }

        @Nullable
        public final String getMessageId() {
            return this.b;
        }

        @Nullable
        public final String getSearchQuery() {
            return this.c;
        }
    }

    public static final class a extends Differ<MessageListView.State, ChannelItem> {
        @NotNull
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Differ
        public boolean areContentsTheSame(ChannelItem channelItem, ChannelItem channelItem2) {
            ChannelItem channelItem3 = channelItem;
            ChannelItem channelItem4 = channelItem2;
            Intrinsics.checkNotNullParameter(channelItem3, "oldItem");
            Intrinsics.checkNotNullParameter(channelItem4, "newItem");
            return Intrinsics.areEqual(channelItem3, channelItem4);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Differ
        public boolean areItemsTheSame(ChannelItem channelItem, ChannelItem channelItem2) {
            ChannelItem channelItem3 = channelItem;
            ChannelItem channelItem4 = channelItem2;
            Intrinsics.checkNotNullParameter(channelItem3, "oldItem");
            Intrinsics.checkNotNullParameter(channelItem4, "newItem");
            return Intrinsics.areEqual(channelItem3.getStringId(), channelItem4.getStringId());
        }

        /* Return type fixed from 'java.util.List' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Differ
        public List<ChannelItem> getItems(MessageListView.State state) {
            MessageListView.State state2 = state;
            if (state2 == null || !(!Intrinsics.areEqual(state2, MessageListView.State.Companion.getDEFAULT()))) {
                return null;
            }
            return state2.getListState().getItems();
        }
    }

    public static final ChannelItem access$getBottomListItem$p(ChannelFragment channelFragment, MessageListView.State state) {
        Objects.requireNonNull(channelFragment);
        return (ChannelItem) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) state.getListState().getItems());
    }

    public static final /* synthetic */ ChannelContextView access$getChannelContextView$p(ChannelFragment channelFragment) {
        ChannelContextView channelContextView = channelFragment.o;
        if (channelContextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelContextView");
        }
        return channelContextView;
    }

    public static final /* synthetic */ String access$getChannelId$p(ChannelFragment channelFragment) {
        String str = channelFragment.s;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        return str;
    }

    public static final /* synthetic */ ChannelMenuView access$getChannelMenuView$p(ChannelFragment channelFragment) {
        ChannelMenuView channelMenuView = channelFragment.p;
        if (channelMenuView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelMenuView");
        }
        return channelMenuView;
    }

    public static final /* synthetic */ ChannelReplySuggestsView access$getChannelReplySuggestsView$p(ChannelFragment channelFragment) {
        ChannelReplySuggestsView channelReplySuggestsView = channelFragment.q;
        if (channelReplySuggestsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelReplySuggestsView");
        }
        return channelReplySuggestsView;
    }

    public static final /* synthetic */ LegacyPlatformActionsView access$getLegacyPlatformActionsView$p(ChannelFragment channelFragment) {
        LegacyPlatformActionsView legacyPlatformActionsView = channelFragment.l;
        if (legacyPlatformActionsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyPlatformActionsView");
        }
        return legacyPlatformActionsView;
    }

    public static final /* synthetic */ MessageListView access$getMessageListView$p(ChannelFragment channelFragment) {
        MessageListView messageListView = channelFragment.j;
        if (messageListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListView");
        }
        return messageListView;
    }

    public static final /* synthetic */ MessageMenuView access$getMessageMenuView$p(ChannelFragment channelFragment) {
        MessageMenuView messageMenuView = channelFragment.r;
        if (messageMenuView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageMenuView");
        }
        return messageMenuView;
    }

    public static final /* synthetic */ SamplePlatformActionsView access$getSamplePlatformActionsView$p(ChannelFragment channelFragment) {
        SamplePlatformActionsView samplePlatformActionsView = channelFragment.m;
        if (samplePlatformActionsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("samplePlatformActionsView");
        }
        return samplePlatformActionsView;
    }

    public static final /* synthetic */ SendMessageViewImpl access$getSendMessageView$p(ChannelFragment channelFragment) {
        SendMessageViewImpl sendMessageViewImpl = channelFragment.n;
        if (sendMessageViewImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessageView");
        }
        return sendMessageViewImpl;
    }

    public static final void access$openSAFFilePicker(ChannelFragment channelFragment, String[] strArr) {
        ImplicitIntentFactory implicitIntentFactory2 = channelFragment.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        channelFragment.startActivityForResult(implicitIntentFactory2.pickExternalSingleFileOfSpecificFormatsIntent(strArr), 9);
    }

    public static final void access$requestStoragePermissionForDownload(ChannelFragment channelFragment) {
        PermissionHelper permissionHelper2 = channelFragment.permissionHelper;
        if (permissionHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        boolean checkPermission = permissionHelper2.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        Context context = channelFragment.getContext();
        if (!checkPermission && context != null) {
            PermissionStorage permissionStorage2 = channelFragment.permissionStorage;
            if (permissionStorage2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionStorage");
            }
            boolean z2 = true;
            permissionStorage2.setWasStoragePermissionAsked(true);
            PermissionStorage permissionStorage3 = channelFragment.permissionStorage;
            if (permissionStorage3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionStorage");
            }
            boolean wasStoragePermissionForeverDenied = permissionStorage3.getWasStoragePermissionForeverDenied();
            PermissionHelper permissionHelper3 = channelFragment.permissionHelper;
            if (permissionHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
            }
            if (permissionHelper3.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE") || !wasStoragePermissionForeverDenied) {
                z2 = false;
            }
            Dialog.Companion.create$default(Dialog.Companion, context, 0, 0, new w(channelFragment, z2, context), 6, null).show();
        }
    }

    @JvmStatic
    @NotNull
    public static final ChannelFragment newInstance(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3) {
        return Companion.newInstance(str, num, str2, str3);
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final BuildInfo getBuildInfo() {
        BuildInfo buildInfo2 = this.buildInfo;
        if (buildInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildInfo");
        }
        return buildInfo2;
    }

    @NotNull
    public final ChannelContextPresenter getChannelContextPresenter() {
        ChannelContextPresenter channelContextPresenter2 = this.channelContextPresenter;
        if (channelContextPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelContextPresenter");
        }
        return channelContextPresenter2;
    }

    @NotNull
    public final ChannelMenuPresenter getChannelMenuPresenter() {
        ChannelMenuPresenter channelMenuPresenter2 = this.channelMenuPresenter;
        if (channelMenuPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelMenuPresenter");
        }
        return channelMenuPresenter2;
    }

    @NotNull
    public final ChannelReplySuggestsPresenter getChannelReplySuggestsPresenter() {
        ChannelReplySuggestsPresenter channelReplySuggestsPresenter2 = this.channelReplySuggestsPresenter;
        if (channelReplySuggestsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelReplySuggestsPresenter");
        }
        return channelReplySuggestsPresenter2;
    }

    @NotNull
    public final ConnectivityProvider getConnectivityProvider() {
        ConnectivityProvider connectivityProvider2 = this.connectivityProvider;
        if (connectivityProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectivityProvider");
        }
        return connectivityProvider2;
    }

    @NotNull
    public final ContextActionsPresenter getContextActionsPresenter() {
        ContextActionsPresenter contextActionsPresenter2 = this.contextActionsPresenter;
        if (contextActionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contextActionsPresenter");
        }
        return contextActionsPresenter2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final DeeplinkProcessor getDeeplinkProcessor() {
        DeeplinkProcessor deeplinkProcessor2 = this.deeplinkProcessor;
        if (deeplinkProcessor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deeplinkProcessor");
        }
        return deeplinkProcessor2;
    }

    @NotNull
    public final DeeplinkProcessorListener getDeeplinkProcessorListener() {
        DeeplinkProcessorListener deeplinkProcessorListener2 = this.deeplinkProcessorListener;
        if (deeplinkProcessorListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deeplinkProcessorListener");
        }
        return deeplinkProcessorListener2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final AdapterPresenter getItemsListAdapterPresenter() {
        AdapterPresenter adapterPresenter = this.itemsListAdapterPresenter;
        if (adapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsListAdapterPresenter");
        }
        return adapterPresenter;
    }

    @NotNull
    public final ItemBinder getItemsListItemBinder() {
        ItemBinder itemBinder = this.itemsListItemBinder;
        if (itemBinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsListItemBinder");
        }
        return itemBinder;
    }

    @NotNull
    public final ItemsListPresenter getItemsListPresenter() {
        ItemsListPresenter itemsListPresenter2 = this.itemsListPresenter;
        if (itemsListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsListPresenter");
        }
        return itemsListPresenter2;
    }

    @NotNull
    public final LegacyPlatformActionsPresenter getLegacyPlatformActionsPresenter() {
        LegacyPlatformActionsPresenter legacyPlatformActionsPresenter2 = this.legacyPlatformActionsPresenter;
        if (legacyPlatformActionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyPlatformActionsPresenter");
        }
        return legacyPlatformActionsPresenter2;
    }

    @NotNull
    public final AdapterPresenter getMessageListAdapterPresenter() {
        AdapterPresenter adapterPresenter = this.messageListAdapterPresenter;
        if (adapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListAdapterPresenter");
        }
        return adapterPresenter;
    }

    @NotNull
    public final ItemBinder getMessageListItemBinder() {
        ItemBinder itemBinder = this.messageListItemBinder;
        if (itemBinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListItemBinder");
        }
        return itemBinder;
    }

    @NotNull
    public final MessageListPresenter getMessageListPresenter() {
        MessageListPresenter messageListPresenter2 = this.messageListPresenter;
        if (messageListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        return messageListPresenter2;
    }

    @NotNull
    public final MessageMenuCallbacks getMessageMenuCallbacks() {
        MessageMenuCallbacks messageMenuCallbacks2 = this.messageMenuCallbacks;
        if (messageMenuCallbacks2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageMenuCallbacks");
        }
        return messageMenuCallbacks2;
    }

    @NotNull
    public final MessageMenuPresenter getMessageMenuPresenter() {
        MessageMenuPresenter messageMenuPresenter2 = this.messageMenuPresenter;
        if (messageMenuPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageMenuPresenter");
        }
        return messageMenuPresenter2;
    }

    @NotNull
    public final NewMessagesPresenter getNewMessagesPresenter() {
        NewMessagesPresenter newMessagesPresenter2 = this.newMessagesPresenter;
        if (newMessagesPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newMessagesPresenter");
        }
        return newMessagesPresenter2;
    }

    @NotNull
    public final ChannelTracker getPerfTracker() {
        ChannelTracker channelTracker = this.perfTracker;
        if (channelTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        return channelTracker;
    }

    @NotNull
    public final PermissionHelper getPermissionHelper() {
        PermissionHelper permissionHelper2 = this.permissionHelper;
        if (permissionHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        return permissionHelper2;
    }

    @NotNull
    public final PermissionStorage getPermissionStorage() {
        PermissionStorage permissionStorage2 = this.permissionStorage;
        if (permissionStorage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionStorage");
        }
        return permissionStorage2;
    }

    @NotNull
    public final PlatformActionsCoordinator getPlatformActionsCoordinator() {
        PlatformActionsCoordinator platformActionsCoordinator2 = this.platformActionsCoordinator;
        if (platformActionsCoordinator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformActionsCoordinator");
        }
        return platformActionsCoordinator2;
    }

    @NotNull
    public final SendMessagePresenter getSendMessagePresenter() {
        SendMessagePresenter sendMessagePresenter2 = this.sendMessagePresenter;
        if (sendMessagePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessagePresenter");
        }
        return sendMessagePresenter2;
    }

    @NotNull
    public final ServiceIntentFactory getServiceIntentFactory() {
        ServiceIntentFactory serviceIntentFactory2 = this.serviceIntentFactory;
        if (serviceIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceIntentFactory");
        }
        return serviceIntentFactory2;
    }

    @NotNull
    public final FpsStateSupplier getSupplier() {
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        return fpsStateSupplier;
    }

    @Override // com.avito.android.remote.notification.NotificationProvider.Handler
    @SuppressLint({"WrongThread"})
    public boolean handleMessage(@NotNull DeepLink deepLink) {
        String str;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (!(deepLink instanceof ChannelDetailsLink) || (str = this.s) == null) {
            return false;
        }
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        if (!Intrinsics.areEqual(str, ((ChannelDetailsLink) deepLink).getChannelId())) {
            return false;
        }
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        if (lifecycle.getCurrentState() == Lifecycle.State.STARTED) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        this.B.postValue(new ActivityResult(i, i2, intent));
        if (i2 == -1) {
            String str = null;
            Uri uri = null;
            MessageBody.Location location = null;
            DeepLink deepLink = null;
            if (i == 4) {
                if (intent != null) {
                    str = intent.getStringExtra(PhotoPickerActivityKt.EXTRA_OPERATION_ID);
                }
                if (str != null) {
                    SendMessagePresenter sendMessagePresenter2 = this.sendMessagePresenter;
                    if (sendMessagePresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sendMessagePresenter");
                    }
                    sendMessagePresenter2.onPhotosSelected(str);
                }
            } else if (i == 6) {
                if (intent != null) {
                    deepLink = (DeepLink) intent.getParcelableExtra("deep_link");
                }
                if (deepLink != null && !(deepLink instanceof NoMatchLink)) {
                    DeeplinkProcessor deeplinkProcessor2 = this.deeplinkProcessor;
                    if (deeplinkProcessor2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("deeplinkProcessor");
                    }
                    deeplinkProcessor2.process(deepLink);
                }
            } else if (i == 8) {
                if (intent != null) {
                    location = (MessageBody.Location) intent.getParcelableExtra(SharingMapFragmentKt.EXTRA_SHARED_LOCATION);
                }
                if (location != null) {
                    SendMessagePresenter sendMessagePresenter3 = this.sendMessagePresenter;
                    if (sendMessagePresenter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sendMessagePresenter");
                    }
                    sendMessagePresenter3.onLocationSelected(location);
                }
            } else if (i == 9) {
                if (intent != null) {
                    uri = intent.getData();
                }
                Context context = getContext();
                if (uri != null && context != null) {
                    context.getContentResolver().takePersistableUriPermission(uri, 1);
                    SendMessagePresenter sendMessagePresenter4 = this.sendMessagePresenter;
                    if (sendMessagePresenter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sendMessagePresenter");
                    }
                    sendMessagePresenter4.onFilePicked(uri);
                }
            }
        } else if (i == 7) {
            int i3 = R.string.something_went_wrong;
            Context context2 = getContext();
            if (context2 != null) {
                ToastsKt.showToast(context2, i3, 0);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        Objects.requireNonNull(parentFragment, "null cannot be cast to non-null type com.avito.android.messenger.conversation.ChannelRootRouter");
        this.y = (ChannelRootRouter) parentFragment;
    }

    @Override // com.avito.android.messenger.conversation.ChannelRouter
    public void onCallSellerConfirmed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(new PhoneLink.Call(str, null, 2, null));
        if (intent != null) {
            FragmentsKt.startActivitySafely(this, intent, new u(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ChannelTracker channelTracker = this.perfTracker;
        if (channelTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        channelTracker.startInit();
        return layoutInflater.inflate(com.avito.android.messenger.R.layout.messenger_channel, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        MessageListView messageListView = this.j;
        if (messageListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListView");
        }
        messageListView.destroy();
        Disposable disposable = this.x;
        if (disposable != null) {
            disposable.dispose();
        }
        ChannelMenuView channelMenuView = this.p;
        if (channelMenuView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelMenuView");
        }
        channelMenuView.destroyViews();
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getMessengerPlatformActionsCoordinator().invoke().booleanValue()) {
            LegacyPlatformActionsView legacyPlatformActionsView = this.l;
            if (legacyPlatformActionsView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legacyPlatformActionsView");
            }
            legacyPlatformActionsView.destroyViews();
        }
        ChannelContextView channelContextView = this.o;
        if (channelContextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelContextView");
        }
        channelContextView.destroyView();
        ChannelTracker channelTracker = this.perfTracker;
        if (channelTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        channelTracker.destroy();
        super.onDestroyView();
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        this.y = null;
        super.onDetach();
    }

    public final void onFeedbackItemSelected(@NotNull FeedbackAdvertItem feedbackAdvertItem) {
        Intrinsics.checkNotNullParameter(feedbackAdvertItem, "item");
        SendMessagePresenter sendMessagePresenter2 = this.sendMessagePresenter;
        if (sendMessagePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessagePresenter");
        }
        sendMessagePresenter2.onItemSelected(feedbackAdvertItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        fpsStateSupplier.onPause();
        ChannelTracker channelTracker = this.perfTracker;
        if (channelTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        channelTracker.detach();
        super.onPause();
    }

    @Override // com.avito.android.messenger.conversation.ChannelRouter
    public void onReplySuggestClicked(@NotNull String str, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "text");
        SendMessagePresenter sendMessagePresenter2 = this.sendMessagePresenter;
        if (sendMessagePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessagePresenter");
        }
        sendMessagePresenter2.onSendMessageClick(str, list);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i == 11) {
            PermissionHelper permissionHelper2 = this.permissionHelper;
            if (permissionHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
            }
            if (permissionHelper2.checkPermission(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                Pair<LocalMessage, MessageMetaInfo> pair = this.D;
                if (pair != null) {
                    MessageListPresenter messageListPresenter2 = this.messageListPresenter;
                    if (messageListPresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
                    }
                    messageListPresenter2.onMessageClick(new ChannelItem.Message.BodyOrBubble.Body(pair.getFirst().body), pair.getFirst(), pair.getSecond());
                    return;
                }
                return;
            }
            int i2 = com.avito.android.messenger.R.string.messenger_file_download_permission_required;
            Context context = getContext();
            if (context != null) {
                ToastsKt.showToast(context, i2, 0);
            }
            PermissionHelper permissionHelper3 = this.permissionHelper;
            if (permissionHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
            }
            if (!permissionHelper3.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                PermissionStorage permissionStorage2 = this.permissionStorage;
                if (permissionStorage2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("permissionStorage");
                }
                permissionStorage2.setWasStoragePermissionForeverDenied(true);
                return;
            }
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        fpsStateSupplier.onResume();
        super.onResume();
        ChannelTracker channelTracker = this.perfTracker;
        if (channelTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        channelTracker.attach();
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        analytics2.track(new DisplayChannelEvent());
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isChangingConfigurations()) {
            SendMessagePresenter sendMessagePresenter2 = this.sendMessagePresenter;
            if (sendMessagePresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendMessagePresenter");
            }
            bundle.putParcelable("sendMessagePresenter", (Parcelable) sendMessagePresenter2.getStateBlocking());
        }
        bundle.putBoolean("user_changed_text", this.C);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        PublishRelay create = PublishRelay.create();
        MessageListPresenter messageListPresenter2 = this.messageListPresenter;
        if (messageListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        Observable stateObservable = messageListPresenter2.getStateObservable();
        MessageListView messageListView = this.j;
        if (messageListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListView");
        }
        a aVar = a.a;
        BehaviorRelay createDefault = BehaviorRelay.createDefault(Unit.INSTANCE);
        Observable observeOn = stateObservable.observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "observeOn(AndroidSchedulers.mainThread())");
        Intrinsics.checkNotNullExpressionValue(createDefault, "nextStateTrigger");
        Observable zipWith = observeOn.zipWith(createDefault, new BiFunction<MessageListView.State, Unit, R>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$render$1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(MessageListView.State state, Unit unit) {
                RendererWithDiff rendererWithDiff = RendererWithDiff.this;
                return (R) TuplesKt.to(rendererWithDiff.getLastRenderedState(rendererWithDiff), state);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        Disposable subscribe = zipWith.observeOn(Schedulers.computation()).map(new Function<Pair<? extends MessageListView.State, ? extends MessageListView.State>, Pair<? extends MessageListView.State, ? extends DiffUtil.DiffResult>>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$render$2
            public final Pair<MessageListView.State, DiffUtil.DiffResult> apply(@NotNull Pair<? extends MessageListView.State, ? extends MessageListView.State> pair) {
                Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
                Object component1 = pair.component1();
                Object component2 = pair.component2();
                return TuplesKt.to(component2, Differ.calculateDiff$default(Differ.this, component1, component2, false, 4, null));
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Pair<? extends MessageListView.State, ? extends DiffUtil.DiffResult>>("ChannelFragment", createDefault, this, create) { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$render$3
            public final /* synthetic */ String b;
            public final /* synthetic */ BehaviorRelay c;
            public final /* synthetic */ ChannelFragment d;
            public final /* synthetic */ PublishRelay e;

            {
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r7v4, resolved type: com.jakewharton.rxrelay2.PublishRelay */
            /* JADX DEBUG: Multi-variable search result rejected for r7v5, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
            /* JADX WARN: Multi-variable type inference failed */
            public final void accept(Pair<? extends MessageListView.State, ? extends DiffUtil.DiffResult> pair) {
                Object component1 = pair.component1();
                RendererWithDiff rendererWithDiff = RendererWithDiff.this;
                Object lastRenderedState = rendererWithDiff.getLastRenderedState(rendererWithDiff);
                RendererWithDiff.this.render(component1, (DiffUtil.DiffResult) pair.component2());
                String str = this.b;
                StringBuilder sb = new StringBuilder();
                StringBuilder I = a.I('[');
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                I.append(currentThread.getName());
                I.append(']');
                sb.append(I.toString());
                sb.append(" Rendered ");
                sb.append(component1);
                ChannelItem channelItem = null;
                Logs.info$default(str, sb.toString(), null, 4, null);
                MessageListView.State state = (MessageListView.State) component1;
                MessageListView.State state2 = (MessageListView.State) lastRenderedState;
                PublishRelay publishRelay = this.e;
                if (state2 != null) {
                    channelItem = ChannelFragment.access$getBottomListItem$p(this.d, state2);
                }
                publishRelay.accept(TuplesKt.to(channelItem, ChannelFragment.access$getBottomListItem$p(this.d, state)));
                this.c.accept(Unit.INSTANCE);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "observeOn(AndroidSchedul…Trigger += Unit\n        }");
        DisposableKt.addTo(subscribe, this.z);
        Disposable subscribe2 = create.observeOn(Schedulers.computation()).skip(1).filter(a2.a.a.o1.d.j.a).distinctUntilChanged(k.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "newListItemsStream\n     …          }\n            }");
        DisposableKt.addTo(subscribe2, this.z);
        MessageListView messageListView2 = this.j;
        if (messageListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListView");
        }
        Observable<Boolean> observeOn2 = messageListView2.getScrolledToBottomStream().observeOn(Schedulers.computation());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Observable<Boolean> distinctUntilChanged = observeOn2.throttleLatest(200L, timeUnit, true).distinctUntilChanged();
        NewMessagesPresenter newMessagesPresenter2 = this.newMessagesPresenter;
        if (newMessagesPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newMessagesPresenter");
        }
        Disposable subscribe3 = distinctUntilChanged.subscribe(new x(new Function1<Boolean, Unit>(newMessagesPresenter2) { // from class: a2.a.a.o1.d.m
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Boolean bool) {
                ((NewMessagesPresenter) this.receiver).onScrolledToBottomChanged(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "messageListView.scrolled…nScrolledToBottomChanged)");
        DisposableKt.addTo(subscribe3, this.z);
        MessageListView messageListView3 = this.j;
        if (messageListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListView");
        }
        Disposable subscribe4 = messageListView3.getInitialScrollStream().distinctUntilChanged().observeOn(Schedulers.computation()).subscribe(new n3(4, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "messageListView.initialS…nitialScrollPerformed() }");
        DisposableKt.addTo(subscribe4, this.z);
        NewMessagesPresenter newMessagesPresenter3 = this.newMessagesPresenter;
        if (newMessagesPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newMessagesPresenter");
        }
        newMessagesPresenter3.getScrollToBottomStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelFragment.access$getMessageListView$p(ChannelFragment.this).scrollTo(0);
                }
            }
        });
        MessageListPresenter messageListPresenter3 = this.messageListPresenter;
        if (messageListPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter3.getItemMessageClickedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    String component1 = t3.component1();
                    String component2 = t3.component2();
                    String component3 = t3.component3();
                    Keyboards.hideKeyboard(ChannelFragment.this);
                    if (Intrinsics.areEqual(component2, component3)) {
                        ChannelRootRouter channelRootRouter = ChannelFragment.this.y;
                        if (channelRootRouter != null) {
                            channelRootRouter.openMyAdvertScreen(component1);
                            return;
                        }
                        return;
                    }
                    ChannelRootRouter channelRootRouter2 = ChannelFragment.this.y;
                    if (channelRootRouter2 != null) {
                        channelRootRouter2.openAdvertScreen(component1, false);
                    }
                }
            }
        });
        MessageListPresenter messageListPresenter4 = this.messageListPresenter;
        if (messageListPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter4.getImageMessageClickedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    List<Image> component1 = t3.component1();
                    int component2 = t3.component2();
                    if (ChannelFragment.this.getConnectivityProvider().isConnectionAvailable()) {
                        ChannelRootRouter channelRootRouter = ChannelFragment.this.y;
                        if (channelRootRouter != null) {
                            channelRootRouter.openGallery(component1, component2);
                            return;
                        }
                        return;
                    }
                    ChannelFragment channelFragment = ChannelFragment.this;
                    int i = com.avito.android.messenger.R.string.network_unavailable_message;
                    Context context = channelFragment.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, i, 0);
                    }
                }
            }
        });
        MessageListPresenter messageListPresenter5 = this.messageListPresenter;
        if (messageListPresenter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter5.getUnknownMessageClickedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelFragment.this.openPlayStore();
                }
            }
        });
        MessageListPresenter messageListPresenter6 = this.messageListPresenter;
        if (messageListPresenter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter6.getLinkMessageWithUrlClickedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelFragment.this.openUrl(t2);
                }
            }
        });
        MessageListPresenter messageListPresenter7 = this.messageListPresenter;
        if (messageListPresenter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter7.getLocationMessageClickedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    ChannelFragment channelFragment = ChannelFragment.this;
                    String string = channelFragment.getResources().getString(com.avito.android.messenger.R.string.messenger_shared_location_map_view_title);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_location_map_view_title)");
                    channelFragment.showPlatformMap(string, new GeoMarker[]{new GeoMarker(t3.getLatitude(), t3.getLongitude(), null, d.listOf(new AttributedText(t3.getTitle(), CollectionsKt__CollectionsKt.emptyList())))}, null, true);
                }
            }
        });
        MessageListPresenter messageListPresenter8 = this.messageListPresenter;
        if (messageListPresenter8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter8.getFileMessageClickedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    ChannelFragment.this.openFile((Uri) t3.component1(), (String) t3.component2());
                }
            }
        });
        MessageListPresenter messageListPresenter9 = this.messageListPresenter;
        if (messageListPresenter9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter9.getPlatformMapMessageClickedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    ChannelRouter.DefaultImpls.showPlatformMap$default(ChannelFragment.this, t3.component1(), t3.component2(), t3.component3(), false, 8, null);
                }
            }
        });
        MessageListPresenter messageListPresenter10 = this.messageListPresenter;
        if (messageListPresenter10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter10.getSystemUserAvatarClickedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelFragment channelFragment = ChannelFragment.this;
                    int i = com.avito.android.messenger.R.string.messenger_avito_message_description;
                    Context context = channelFragment.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, i, 0);
                    }
                }
            }
        });
        MessageListPresenter messageListPresenter11 = this.messageListPresenter;
        if (messageListPresenter11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter11.getErrorMessageStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    Context context = ChannelFragment.this.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, t3, 0);
                    }
                }
            }
        });
        MessageListPresenter messageListPresenter12 = this.messageListPresenter;
        if (messageListPresenter12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter12.getShowMenuForTextLinkStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    ChannelFragment.this.getMessageMenuPresenter().showMenuForLink(t3.component1(), t3.component2(), t3.component3());
                }
            }
        });
        MessageListPresenter messageListPresenter13 = this.messageListPresenter;
        if (messageListPresenter13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter13.getFileDownloadFailsStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelFragment channelFragment = ChannelFragment.this;
                    int i = com.avito.android.messenger.R.string.messenger_file_download_failed;
                    Context context = channelFragment.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, i, 0);
                    }
                }
            }
        });
        MessageListPresenter messageListPresenter14 = this.messageListPresenter;
        if (messageListPresenter14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListPresenter");
        }
        messageListPresenter14.getRequestPermissionsForFileMessageStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageListView$$inlined$observeNotNull$13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelFragment.this.D = t2;
                    ChannelFragment.access$requestStoragePermissionForDownload(ChannelFragment.this);
                }
            }
        });
        MessageListView messageListView4 = this.j;
        if (messageListView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListView");
        }
        Disposable subscribe5 = messageListView4.getStartPaginationStream().throttleFirst(500, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new n3(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "messageListView.startPag…agination()\n            }");
        DisposableKt.addTo(subscribe5, this.z);
        MessageListView messageListView5 = this.j;
        if (messageListView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListView");
        }
        Disposable subscribe6 = messageListView5.getCallUserClicksStream().throttleFirst(500, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new n3(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe6, "messageListView.callUser….callUser()\n            }");
        DisposableKt.addTo(subscribe6, this.z);
        MessageListView messageListView6 = this.j;
        if (messageListView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListView");
        }
        Disposable subscribe7 = messageListView6.getRefreshClicksStream().throttleFirst(500, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new n3(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe7, "messageListView.refreshC…r.refresh()\n            }");
        DisposableKt.addTo(subscribe7, this.z);
        MessageListView messageListView7 = this.j;
        if (messageListView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageListView");
        }
        Disposable subscribe8 = messageListView7.getUserInteractedWithListStream().throttleFirst(500, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new n3(3, this));
        Intrinsics.checkNotNullExpressionValue(subscribe8, "messageListView.userInte…dWithList()\n            }");
        DisposableKt.addTo(subscribe8, this.z);
        NewMessagesPresenter newMessagesPresenter4 = this.newMessagesPresenter;
        if (newMessagesPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newMessagesPresenter");
        }
        Observable subscribeOn = newMessagesPresenter4.getStateObservable().throttleLatest(200L, timeUnit, true).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.computation());
        NewMessagesView newMessagesView = this.k;
        if (newMessagesView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newMessagesView");
        }
        Disposable subscribe9 = subscribeOn.subscribe(new x(new Function1<NewMessagesView.State, Unit>(newMessagesView) { // from class: a2.a.a.o1.d.n
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(NewMessagesView.State state) {
                NewMessagesView.State state2 = state;
                Intrinsics.checkNotNullParameter(state2, "p1");
                ((NewMessagesView) this.receiver).render(state2);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe9, "newMessagesPresenter.sta…(newMessagesView::render)");
        DisposableKt.addTo(subscribe9, this.z);
        Observable stateObservable2 = getChannelMenuPresenter().getStateObservable();
        Scheduler computation = Schedulers.computation();
        Intrinsics.checkNotNullExpressionValue(computation, "Schedulers.computation()");
        Observable publish = stateObservable2.publish(new Function<Observable<T>, ObservableSource<T>>(1, 200, timeUnit, computation) { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelMenuView$$inlined$debounceAfter$1
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ TimeUnit c;
            public final /* synthetic */ Scheduler d;

            {
                this.a = r1;
                this.b = r3;
                this.c = r5;
                this.d = r6;
            }

            public final ObservableSource<T> apply(@NotNull Observable<T> observable) {
                Intrinsics.checkNotNullParameter(observable, "shared");
                return Observable.merge(observable.take(this.a), observable.skip(this.a).debounce(this.b, this.c, this.d));
            }

            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Observable) ((Observable) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(publish, "publish { shared ->\n    …cheduler)\n        )\n    }");
        Disposable subscribe10 = publish.observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ChannelMenuView.State>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelMenuView$1
            public final void accept(ChannelMenuView.State state) {
                ChannelMenuView access$getChannelMenuView$p = ChannelFragment.access$getChannelMenuView$p(ChannelFragment.this);
                Intrinsics.checkNotNullExpressionValue(state, "curState");
                access$getChannelMenuView$p.render(state);
                StringBuilder sb = new StringBuilder();
                StringBuilder I = a.I('[');
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                I.append(currentThread.getName());
                I.append(']');
                sb.append(I.toString());
                sb.append(" Rendered ");
                sb.append(state);
                Logs.info$default("ChannelFragment", sb.toString(), null, 4, null);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe10, "channelMenuPresenter.sta…$curState\")\n            }");
        DisposableKt.addTo(subscribe10, this.z);
        getChannelMenuPresenter().getUserBlockedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelMenuView$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    Keyboards.hideKeyboard(ChannelFragment.this);
                    ChannelFragment.this.getSendMessagePresenter().onDraftDeletionFromOutside();
                    ChannelRootRouter channelRootRouter = ChannelFragment.this.y;
                    if (channelRootRouter != null) {
                        channelRootRouter.close(3);
                    }
                }
            }
        });
        getChannelMenuPresenter().getChannelDeletedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelMenuView$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelFragment channelFragment = ChannelFragment.this;
                    String string = channelFragment.getResources().getString(com.avito.android.messenger.R.string.channel_deleted);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.channel_deleted)");
                    Context context = channelFragment.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, string, 0);
                    }
                    Keyboards.hideKeyboard(ChannelFragment.this);
                    ChannelFragment.this.getSendMessagePresenter().onDraftDeletionFromOutside();
                    ChannelRootRouter channelRootRouter = ChannelFragment.this.y;
                    if (channelRootRouter != null) {
                        channelRootRouter.close(2);
                    }
                }
            }
        });
        getChannelMenuPresenter().getAbuseReportStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelMenuView$$inlined$observeNotNull$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    Keyboards.hideKeyboard(ChannelFragment.this);
                    ChannelFragment.this.openAbuseReportScreen((AbuseReportLink) t3.component1(), (List) t3.component2());
                }
            }
        });
        getChannelMenuPresenter().getCallUserConfirmedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelMenuView$$inlined$observeNotNull$4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelFragment.this.onCallSellerConfirmed(t2);
                }
            }
        });
        getChannelMenuPresenter().getErrorMessageStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelMenuView$$inlined$observeNotNull$5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    Context context = ChannelFragment.this.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, t3, 0);
                    }
                }
            }
        });
        Disposable subscribe11 = access$getChannelMenuView$p(this).getProfileClicks().debounce(300, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelMenuView$7
            public final void accept(Unit unit) {
                ChannelFragment.this.getChannelMenuPresenter().openProfile();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe11, "channelMenuView.profileC…enProfile()\n            }");
        DisposableKt.addTo(subscribe11, this.z);
        Observable stateObservable3 = getChannelContextPresenter().getStateObservable();
        Scheduler computation2 = Schedulers.computation();
        Intrinsics.checkNotNullExpressionValue(computation2, "Schedulers.computation()");
        Observable publish2 = stateObservable3.publish(new Function<Observable<T>, ObservableSource<T>>(1, 200, timeUnit, computation2) { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelContextView$$inlined$debounceAfter$1
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ TimeUnit c;
            public final /* synthetic */ Scheduler d;

            {
                this.a = r1;
                this.b = r3;
                this.c = r5;
                this.d = r6;
            }

            public final ObservableSource<T> apply(@NotNull Observable<T> observable) {
                Intrinsics.checkNotNullParameter(observable, "shared");
                return Observable.merge(observable.take(this.a), observable.skip(this.a).debounce(this.b, this.c, this.d));
            }

            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Observable) ((Observable) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(publish2, "publish { shared ->\n    …cheduler)\n        )\n    }");
        Disposable subscribe12 = publish2.observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ChannelContextView.State>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelContextView$1
            public final void accept(ChannelContextView.State state) {
                ChannelContextView access$getChannelContextView$p = ChannelFragment.access$getChannelContextView$p(ChannelFragment.this);
                Intrinsics.checkNotNullExpressionValue(state, "state");
                access$getChannelContextView$p.render(state);
                StringBuilder sb = new StringBuilder();
                StringBuilder I = a.I('[');
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                I.append(currentThread.getName());
                I.append(']');
                sb.append(I.toString());
                sb.append(" Rendered ");
                sb.append(state);
                Logs.info$default("ChannelFragment", sb.toString(), null, 4, null);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe12, "channelContextPresenter.…ed $state\")\n            }");
        DisposableKt.addTo(subscribe12, this.z);
        getChannelContextPresenter().getOpenAdvertScreenStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelContextView$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    ChannelRootRouter channelRootRouter = ChannelFragment.this.y;
                    if (channelRootRouter != null) {
                        channelRootRouter.openAdvertScreen(t3, false);
                    }
                }
            }
        });
        getChannelContextPresenter().getOpenMyAdvertScreenStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelContextView$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    ChannelRootRouter channelRootRouter = ChannelFragment.this.y;
                    if (channelRootRouter != null) {
                        channelRootRouter.openMyAdvertScreen(t3);
                    }
                }
            }
        });
        getChannelContextPresenter().getCloseScreenStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelContextView$$inlined$observeNotNull$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                ChannelRootRouter channelRootRouter;
                if (t2 != null && (channelRootRouter = ChannelFragment.this.y) != null) {
                    channelRootRouter.close();
                }
            }
        });
        Disposable subscribe13 = access$getChannelContextView$p(this).getBackClicks().subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelContextView$5
            public final void accept(Unit unit) {
                Keyboards.hideKeyboard(ChannelFragment.this);
                ChannelRootRouter channelRootRouter = ChannelFragment.this.y;
                if (channelRootRouter != null) {
                    channelRootRouter.close();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe13, "channelContextView.backC…er?.close()\n            }");
        DisposableKt.addTo(subscribe13, this.z);
        Disposable subscribe14 = access$getChannelContextView$p(this).getItemImageClicks().debounce(300, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelContextView$6
            public final void accept(Unit unit) {
                ChannelFragment.this.getChannelContextPresenter().openAdvert();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe14, "channelContextView.itemI…penAdvert()\n            }");
        DisposableKt.addTo(subscribe14, this.z);
        Disposable subscribe15 = access$getChannelContextView$p(this).getItemBlockClicks().debounce(300, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelContextView$7
            public final void accept(Unit unit) {
                ChannelFragment.this.getChannelContextPresenter().openDealActionOrAdvert();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe15, "channelContextView.itemB…nOrAdvert()\n            }");
        DisposableKt.addTo(subscribe15, this.z);
        Disposable subscribe16 = access$getChannelContextView$p(this).getTitleClicks().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelContextView$8
            public final void accept(Unit unit) {
                ChannelFragment.this.getChannelMenuPresenter().showChannelMenu();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe16, "channelContextView.title…annelMenu()\n            }");
        DisposableKt.addTo(subscribe16, this.z);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getMessengerPlatformActionsCoordinator().invoke().booleanValue()) {
            SamplePlatformActionsView samplePlatformActionsView = this.m;
            if (samplePlatformActionsView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("samplePlatformActionsView");
            }
            Disposable subscribe17 = samplePlatformActionsView.getBoundStream().observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this));
            Intrinsics.checkNotNullExpressionValue(subscribe17, "samplePlatformActionsVie…          )\n            }");
            DisposableKt.addTo(subscribe17, this.z);
            SamplePlatformActionsView samplePlatformActionsView2 = this.m;
            if (samplePlatformActionsView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("samplePlatformActionsView");
            }
            Disposable subscribe18 = samplePlatformActionsView2.getUnboundStream().observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this));
            Intrinsics.checkNotNullExpressionValue(subscribe18, "samplePlatformActionsVie…dStateKeys)\n            }");
            DisposableKt.addTo(subscribe18, this.z);
            SamplePlatformActionsView samplePlatformActionsView3 = this.m;
            if (samplePlatformActionsView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("samplePlatformActionsView");
            }
            Disposable subscribe19 = samplePlatformActionsView3.getConsumedStream().observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this));
            Intrinsics.checkNotNullExpressionValue(subscribe19, "samplePlatformActionsVie…Key, state)\n            }");
            DisposableKt.addTo(subscribe19, this.z);
            PlatformActionsCoordinator platformActionsCoordinator2 = this.platformActionsCoordinator;
            if (platformActionsCoordinator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformActionsCoordinator");
            }
            Disposable subscribe20 = platformActionsCoordinator2.getStateObservable().observeOn(Schedulers.computation()).distinctUntilChanged(r.a).filter(s.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new t(this));
            Intrinsics.checkNotNullExpressionValue(subscribe20, "platformActionsCoordinat…ucersByKey)\n            }");
            DisposableKt.addTo(subscribe20, this.z);
        } else {
            Observable<Boolean> distinctUntilChanged2 = this.A.distinctUntilChanged();
            LegacyPlatformActionsView legacyPlatformActionsView = this.l;
            if (legacyPlatformActionsView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legacyPlatformActionsView");
            }
            Disposable subscribe21 = distinctUntilChanged2.subscribe(new x(new Function1<Boolean, Unit>(legacyPlatformActionsView) { // from class: a2.a.a.o1.d.e
                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(Boolean bool) {
                    ((LegacyPlatformActionsView) this.receiver).onKeyboardVisibilityChanged(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }));
            Intrinsics.checkNotNullExpressionValue(subscribe21, "keyboardVisibilityRelay.…eyboardVisibilityChanged)");
            DisposableKt.addTo(subscribe21, this.z);
            LegacyPlatformActionsView legacyPlatformActionsView2 = this.l;
            if (legacyPlatformActionsView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legacyPlatformActionsView");
            }
            ContextActionsPresenter contextActionsPresenter2 = this.contextActionsPresenter;
            if (contextActionsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contextActionsPresenter");
            }
            legacyPlatformActionsView2.bindContentPresenter(ContextActionsPresenter.State.class, this, contextActionsPresenter2);
            LegacyPlatformActionsView legacyPlatformActionsView3 = this.l;
            if (legacyPlatformActionsView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legacyPlatformActionsView");
            }
            ItemsListPresenter itemsListPresenter2 = this.itemsListPresenter;
            if (itemsListPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemsListPresenter");
            }
            legacyPlatformActionsView3.bindContentPresenter(ItemsListPresenter.State.class, this, itemsListPresenter2);
            LegacyPlatformActionsPresenter legacyPlatformActionsPresenter2 = this.legacyPlatformActionsPresenter;
            if (legacyPlatformActionsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legacyPlatformActionsPresenter");
            }
            Disposable subscribe22 = legacyPlatformActionsPresenter2.getStateObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this));
            Intrinsics.checkNotNullExpressionValue(subscribe22, "legacyPlatformActionsPre…e: $state\")\n            }");
            DisposableKt.addTo(subscribe22, this.z);
            LegacyPlatformActionsPresenter legacyPlatformActionsPresenter3 = this.legacyPlatformActionsPresenter;
            if (legacyPlatformActionsPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legacyPlatformActionsPresenter");
            }
            legacyPlatformActionsPresenter3.getHideKeyboardStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindLegacyPlatformActionsView$$inlined$observeNotNull$1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(T t2) {
                    if (t2 != null) {
                        Keyboards.hideKeyboard(ChannelFragment.this);
                    }
                }
            });
            LegacyPlatformActionsView legacyPlatformActionsView4 = this.l;
            if (legacyPlatformActionsView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legacyPlatformActionsView");
            }
            Disposable subscribe23 = legacyPlatformActionsView4.getBottomSheetOpenedStream().observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this));
            Intrinsics.checkNotNullExpressionValue(subscribe23, "legacyPlatformActionsVie…eetOpened()\n            }");
            DisposableKt.addTo(subscribe23, this.z);
            ChannelRootRouter channelRootRouter = this.y;
            if (channelRootRouter != null) {
                LegacyPlatformActionsView legacyPlatformActionsView5 = this.l;
                if (legacyPlatformActionsView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("legacyPlatformActionsView");
                }
                channelRootRouter.setOnBackPressedListener(legacyPlatformActionsView5);
            }
        }
        getSendMessagePresenter().getClearTextStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$$inlined$observe$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                ChannelFragment.access$getSendMessageView$p(ChannelFragment.this).clearText();
            }
        });
        getSendMessagePresenter().getShowToastMessageStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    Context context = ChannelFragment.this.getContext();
                    if (context != null) {
                        ToastsKt.showToast$default(context, t3, 0, 2, (Object) null);
                    }
                }
            }
        });
        getSendMessagePresenter().getAttachImageOperationIdStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelFragment.this.openPhotoPicker(t2);
                }
            }
        });
        getSendMessagePresenter().getAttachFileStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$$inlined$observeNotNull$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelFragment.access$openSAFFilePicker(ChannelFragment.this, (String[]) t2);
                }
            }
        });
        getSendMessagePresenter().getAttachItemIdStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$$inlined$observeNotNull$4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    ChannelRootRouter channelRootRouter2 = ChannelFragment.this.y;
                    if (channelRootRouter2 != null) {
                        channelRootRouter2.openAdvertSelectionScreen((String) t3.orNull());
                    }
                }
            }
        });
        getSendMessagePresenter().getSendLocationStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$$inlined$observe$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                ChannelFragment.this.openSharingMap(t2);
            }
        });
        Disposable subscribe24 = access$getSendMessageView$p(this).getAttachmentDialogDismissedStream().subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$7
            public final void accept(Unit unit) {
                ChannelFragment.this.getSendMessagePresenter().onAttachmentDialogDismissed();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe24, "sendMessageView.attachme…chmentDialogDismissed() }");
        DisposableKt.addTo(subscribe24, this.z);
        Disposable subscribe25 = access$getSendMessageView$p(this).getAttachItemClicks().subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$8
            public final void accept(Unit unit) {
                ChannelFragment.this.getSendMessagePresenter().onAttachItemClick();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe25, "sendMessageView.attachIt…ter.onAttachItemClick() }");
        DisposableKt.addTo(subscribe25, this.z);
        Disposable subscribe26 = access$getSendMessageView$p(this).getMessageTextChangesByUser().subscribe(new Consumer<String>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$9
            public final void accept(String str) {
                ChannelFragment.this.C = true;
                SendMessagePresenter sendMessagePresenter2 = ChannelFragment.this.getSendMessagePresenter();
                Intrinsics.checkNotNullExpressionValue(str, "text");
                sendMessagePresenter2.onTextChangedByUser(str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe26, "sendMessageView.messageT…yUser(text)\n            }");
        DisposableKt.addTo(subscribe26, this.z);
        Disposable subscribe27 = access$getSendMessageView$p(this).getSubmitButtonClicks().subscribe(new Consumer<String>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$10
            public final void accept(String str) {
                SendMessagePresenter sendMessagePresenter2 = ChannelFragment.this.getSendMessagePresenter();
                Intrinsics.checkNotNullExpressionValue(str, "text");
                SendMessagePresenter.DefaultImpls.onSendMessageClick$default(sendMessagePresenter2, str, null, 2, null);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe27, "sendMessageView.submitBu…nSendMessageClick(text) }");
        DisposableKt.addTo(subscribe27, this.z);
        Disposable subscribe28 = access$getSendMessageView$p(this).getAttachButtonClicks().subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$11
            public final void accept(Unit unit) {
                ChannelFragment.this.getSendMessagePresenter().onAttachClick();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe28, "sendMessageView.attachBu…esenter.onAttachClick() }");
        DisposableKt.addTo(subscribe28, this.z);
        Disposable subscribe29 = access$getSendMessageView$p(this).getAttachImageClicks().subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$12
            public final void accept(Unit unit) {
                ChannelFragment.this.getSendMessagePresenter().onAttachImageClick();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe29, "sendMessageView.attachIm…er.onAttachImageClick() }");
        DisposableKt.addTo(subscribe29, this.z);
        Disposable subscribe30 = access$getSendMessageView$p(this).getAttachFileClicks().subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$13
            public final void accept(Unit unit) {
                ChannelFragment.this.getSendMessagePresenter().onAttachFileClick();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe30, "sendMessageView.attachFi…ter.onAttachFileClick() }");
        DisposableKt.addTo(subscribe30, this.z);
        Disposable subscribe31 = access$getSendMessageView$p(this).getSendLocationClicks().subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$14
            public final void accept(Unit unit) {
                ChannelFragment.this.getSendMessagePresenter().onSendLocationClick();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe31, "sendMessageView.sendLoca…r.onSendLocationClick() }");
        DisposableKt.addTo(subscribe31, this.z);
        Disposable subscribe32 = getSendMessagePresenter().getStateObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<SendMessagePresenter.State>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindSendMessageView$15
            public final void accept(SendMessagePresenter.State state) {
                SendMessageViewImpl access$getSendMessageView$p = ChannelFragment.access$getSendMessageView$p(ChannelFragment.this);
                Intrinsics.checkNotNullExpressionValue(state, "state");
                access$getSendMessageView$p.render(null, state, ChannelFragment.this.C);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe32, "sendMessagePresenter.sta…          )\n            }");
        DisposableKt.addTo(subscribe32, this.z);
        ChannelReplySuggestsPresenter channelReplySuggestsPresenter2 = this.channelReplySuggestsPresenter;
        if (channelReplySuggestsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelReplySuggestsPresenter");
        }
        Disposable subscribe33 = channelReplySuggestsPresenter2.getStateObservable().observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe33, "channelReplySuggestsPres…ed $state\")\n            }");
        DisposableKt.addTo(subscribe33, this.z);
        ChannelReplySuggestsPresenter channelReplySuggestsPresenter3 = this.channelReplySuggestsPresenter;
        if (channelReplySuggestsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelReplySuggestsPresenter");
        }
        channelReplySuggestsPresenter3.getSendMessageLiveEvents().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindChannelReplySuggestsView$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    ChannelFragment.this.onReplySuggestClicked((String) t3.component1(), (List) t3.component2());
                }
            }
        });
        ChannelReplySuggestsView channelReplySuggestsView = this.q;
        if (channelReplySuggestsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelReplySuggestsView");
        }
        Disposable subscribe34 = channelReplySuggestsView.getReplySuggestClickedObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe34, "channelReplySuggestsView…kedSuggest)\n            }");
        DisposableKt.addTo(subscribe34, this.z);
        ChannelReplySuggestsView channelReplySuggestsView2 = this.q;
        if (channelReplySuggestsView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelReplySuggestsView");
        }
        Disposable subscribe35 = channelReplySuggestsView2.getCloseButtonClickedObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new a2.a.a.o1.d.d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe35, "channelReplySuggestsView…onClicked()\n            }");
        DisposableKt.addTo(subscribe35, this.z);
        MessageMenuPresenter messageMenuPresenter2 = this.messageMenuPresenter;
        if (messageMenuPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageMenuPresenter");
        }
        Disposable subscribe36 = messageMenuPresenter2.getStateObservable().distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe36, "messageMenuPresenter.sta…nder(state)\n            }");
        DisposableKt.addTo(subscribe36, this.z);
        MessageMenuView messageMenuView = this.r;
        if (messageMenuView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageMenuView");
        }
        Disposable subscribe37 = messageMenuView.getDismissStream().throttleFirst(500, timeUnit).subscribe(new m(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe37, "messageMenuView.dismissS…Presenter.dismissMenu() }");
        DisposableKt.addTo(subscribe37, this.z);
        MessageMenuView messageMenuView2 = this.r;
        if (messageMenuView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageMenuView");
        }
        Disposable subscribe38 = messageMenuView2.getActionClickStream().throttleFirst(500, timeUnit).subscribe(new i(this));
        Intrinsics.checkNotNullExpressionValue(subscribe38, "messageMenuView.actionCl…ActionClicked(actionId) }");
        DisposableKt.addTo(subscribe38, this.z);
        MessageMenuView messageMenuView3 = this.r;
        if (messageMenuView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageMenuView");
        }
        Disposable subscribe39 = messageMenuView3.getActionConfirmedStream().throttleFirst(500, timeUnit).subscribe(new m(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe39, "messageMenuView.actionCo…ter.onActionConfirmed() }");
        DisposableKt.addTo(subscribe39, this.z);
        MessageMenuCallbacks messageMenuCallbacks2 = this.messageMenuCallbacks;
        if (messageMenuCallbacks2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageMenuCallbacks");
        }
        messageMenuCallbacks2.getToastStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageActionsMenuView$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    Context context = ChannelFragment.this.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, t3, 0);
                    }
                }
            }
        });
        MessageMenuCallbacks messageMenuCallbacks3 = this.messageMenuCallbacks;
        if (messageMenuCallbacks3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageMenuCallbacks");
        }
        messageMenuCallbacks3.getUrlNavigationStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageActionsMenuView$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelFragment.this.openUrl(t2);
                }
            }
        });
        MessageMenuCallbacks messageMenuCallbacks4 = this.messageMenuCallbacks;
        if (messageMenuCallbacks4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageMenuCallbacks");
        }
        messageMenuCallbacks4.getCopyToClipboardStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.conversation.ChannelFragment$bindMessageActionsMenuView$$inlined$observeNotNull$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    T t3 = t2;
                    FragmentActivity activity = ChannelFragment.this.getActivity();
                    ClipboardManager clipboardManager = null;
                    Object systemService = activity != null ? activity.getSystemService("clipboard") : null;
                    if (systemService instanceof ClipboardManager) {
                        clipboardManager = systemService;
                    }
                    ClipboardManager clipboardManager2 = clipboardManager;
                    if (clipboardManager2 != null) {
                        clipboardManager2.setPrimaryClip(t3);
                    }
                    ChannelFragment channelFragment = ChannelFragment.this;
                    String string = channelFragment.getResources().getString(com.avito.android.messenger.R.string.text_is_copied);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.text_is_copied)");
                    Context context = channelFragment.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, string, 0);
                    }
                }
            }
        });
        DeeplinkProcessorListener deeplinkProcessorListener2 = this.deeplinkProcessorListener;
        if (deeplinkProcessorListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deeplinkProcessorListener");
        }
        DeeplinkProcessor deeplinkProcessor2 = this.deeplinkProcessor;
        if (deeplinkProcessor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deeplinkProcessor");
        }
        deeplinkProcessorListener2.attach(deeplinkProcessor2, requireActivity(), this, this.B);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ChannelTracker channelTracker = this.perfTracker;
        if (channelTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        channelTracker.stopAllSessions();
        this.z.clear();
        ChannelContextView channelContextView = this.o;
        if (channelContextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelContextView");
        }
        channelContextView.clearSubscriptions();
        DeeplinkProcessorListener deeplinkProcessorListener2 = this.deeplinkProcessorListener;
        if (deeplinkProcessorListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deeplinkProcessorListener");
        }
        deeplinkProcessorListener2.detach();
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getMessengerPlatformActionsCoordinator().invoke().booleanValue()) {
            SamplePlatformActionsView samplePlatformActionsView = this.m;
            if (samplePlatformActionsView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("samplePlatformActionsView");
            }
            samplePlatformActionsView.unbind();
        } else {
            LegacyPlatformActionsView legacyPlatformActionsView = this.l;
            if (legacyPlatformActionsView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legacyPlatformActionsView");
            }
            legacyPlatformActionsView.unbindContentPresenters();
        }
        super.onStop();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01cf  */
    @Override // androidx.fragment.app.Fragment
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(@org.jetbrains.annotations.NotNull android.view.View r19, @org.jetbrains.annotations.Nullable android.os.Bundle r20) {
        /*
        // Method dump skipped, instructions count: 470
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.ChannelFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    @Override // com.avito.android.messenger.conversation.ChannelRouter
    public void openAbuseReportScreen(@NotNull AbuseReportLink abuseReportLink, @Nullable List<Action> list) {
        Intrinsics.checkNotNullParameter(abuseReportLink, "deepLink");
        String itemId = abuseReportLink.getItemId();
        String src = abuseReportLink.getSrc();
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.abuseCategoryIntent(itemId, src, list), 6);
    }

    @Override // com.avito.android.messenger.conversation.ChannelRouter
    public void openFile(@NotNull Uri uri, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Context context = getContext();
        if (context != null) {
            ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
            if (implicitIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
            }
            try {
                context.startActivity(implicitIntentFactory2.openExternalFileOfSpecificType(uri, str));
            } catch (Exception unused) {
                int i = com.avito.android.messenger.R.string.messenger_no_application_can_open_file;
                Context context2 = getContext();
                if (context2 != null) {
                    ToastsKt.showToast(context2, i, 0);
                }
            }
        }
    }

    @Override // com.avito.android.messenger.conversation.ChannelRouter
    public void openPhotoPicker(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.createPhotoPickerIntentForMessenger(str, 10, 1), 4);
    }

    @Override // com.avito.android.messenger.conversation.ChannelRouter
    public void openPlayStore() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        FragmentsKt.startActivitySafely(this, implicitIntentFactory2.marketIntent());
    }

    @Override // com.avito.android.messenger.conversation.ChannelRouter
    public void openSharingMap(@Nullable MessageBody.Location location) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        String str = this.s;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        startActivityForResult(activityIntentFactory2.sharingMapIntent(str, location), 8);
    }

    @Override // com.avito.android.messenger.conversation.ChannelRouter
    public void openUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Context context = getContext();
        if (context != null) {
            Uri parse = Uri.parse(str);
            ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
            if (implicitIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
            }
            Intrinsics.checkNotNullExpressionValue(parse, ShareConstants.MEDIA_URI);
            Intent uriIntentCustomChromeTabs = implicitIntentFactory2.uriIntentCustomChromeTabs(parse, true);
            uriIntentCustomChromeTabs.putExtra("com.android.browser.application_id", context.getPackageName());
            try {
                context.startActivity(IntentsKt.makeSafeForExternalApps(uriIntentCustomChromeTabs));
            } catch (Exception unused) {
                int i = R.string.no_application_installed_to_perform_this_action;
                Context context2 = getContext();
                if (context2 != null) {
                    ToastsKt.showToast(context2, i, 0);
                }
            }
        }
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setBuildInfo(@NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(buildInfo2, "<set-?>");
        this.buildInfo = buildInfo2;
    }

    public final void setChannelContextPresenter(@NotNull ChannelContextPresenter channelContextPresenter2) {
        Intrinsics.checkNotNullParameter(channelContextPresenter2, "<set-?>");
        this.channelContextPresenter = channelContextPresenter2;
    }

    public final void setChannelMenuPresenter(@NotNull ChannelMenuPresenter channelMenuPresenter2) {
        Intrinsics.checkNotNullParameter(channelMenuPresenter2, "<set-?>");
        this.channelMenuPresenter = channelMenuPresenter2;
    }

    public final void setChannelReplySuggestsPresenter(@NotNull ChannelReplySuggestsPresenter channelReplySuggestsPresenter2) {
        Intrinsics.checkNotNullParameter(channelReplySuggestsPresenter2, "<set-?>");
        this.channelReplySuggestsPresenter = channelReplySuggestsPresenter2;
    }

    public final void setConnectivityProvider(@NotNull ConnectivityProvider connectivityProvider2) {
        Intrinsics.checkNotNullParameter(connectivityProvider2, "<set-?>");
        this.connectivityProvider = connectivityProvider2;
    }

    public final void setContextActionsPresenter(@NotNull ContextActionsPresenter contextActionsPresenter2) {
        Intrinsics.checkNotNullParameter(contextActionsPresenter2, "<set-?>");
        this.contextActionsPresenter = contextActionsPresenter2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDeeplinkProcessor(@NotNull DeeplinkProcessor deeplinkProcessor2) {
        Intrinsics.checkNotNullParameter(deeplinkProcessor2, "<set-?>");
        this.deeplinkProcessor = deeplinkProcessor2;
    }

    public final void setDeeplinkProcessorListener(@NotNull DeeplinkProcessorListener deeplinkProcessorListener2) {
        Intrinsics.checkNotNullParameter(deeplinkProcessorListener2, "<set-?>");
        this.deeplinkProcessorListener = deeplinkProcessorListener2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setItemsListAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "<set-?>");
        this.itemsListAdapterPresenter = adapterPresenter;
    }

    public final void setItemsListItemBinder(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "<set-?>");
        this.itemsListItemBinder = itemBinder;
    }

    public final void setItemsListPresenter(@NotNull ItemsListPresenter itemsListPresenter2) {
        Intrinsics.checkNotNullParameter(itemsListPresenter2, "<set-?>");
        this.itemsListPresenter = itemsListPresenter2;
    }

    public final void setLegacyPlatformActionsPresenter(@NotNull LegacyPlatformActionsPresenter legacyPlatformActionsPresenter2) {
        Intrinsics.checkNotNullParameter(legacyPlatformActionsPresenter2, "<set-?>");
        this.legacyPlatformActionsPresenter = legacyPlatformActionsPresenter2;
    }

    public final void setMessageListAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "<set-?>");
        this.messageListAdapterPresenter = adapterPresenter;
    }

    public final void setMessageListItemBinder(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "<set-?>");
        this.messageListItemBinder = itemBinder;
    }

    public final void setMessageListPresenter(@NotNull MessageListPresenter messageListPresenter2) {
        Intrinsics.checkNotNullParameter(messageListPresenter2, "<set-?>");
        this.messageListPresenter = messageListPresenter2;
    }

    public final void setMessageMenuCallbacks(@NotNull MessageMenuCallbacks messageMenuCallbacks2) {
        Intrinsics.checkNotNullParameter(messageMenuCallbacks2, "<set-?>");
        this.messageMenuCallbacks = messageMenuCallbacks2;
    }

    public final void setMessageMenuPresenter(@NotNull MessageMenuPresenter messageMenuPresenter2) {
        Intrinsics.checkNotNullParameter(messageMenuPresenter2, "<set-?>");
        this.messageMenuPresenter = messageMenuPresenter2;
    }

    public final void setNewMessagesPresenter(@NotNull NewMessagesPresenter newMessagesPresenter2) {
        Intrinsics.checkNotNullParameter(newMessagesPresenter2, "<set-?>");
        this.newMessagesPresenter = newMessagesPresenter2;
    }

    public final void setPerfTracker(@NotNull ChannelTracker channelTracker) {
        Intrinsics.checkNotNullParameter(channelTracker, "<set-?>");
        this.perfTracker = channelTracker;
    }

    public final void setPermissionHelper(@NotNull PermissionHelper permissionHelper2) {
        Intrinsics.checkNotNullParameter(permissionHelper2, "<set-?>");
        this.permissionHelper = permissionHelper2;
    }

    public final void setPermissionStorage(@NotNull PermissionStorage permissionStorage2) {
        Intrinsics.checkNotNullParameter(permissionStorage2, "<set-?>");
        this.permissionStorage = permissionStorage2;
    }

    public final void setPlatformActionsCoordinator(@NotNull PlatformActionsCoordinator platformActionsCoordinator2) {
        Intrinsics.checkNotNullParameter(platformActionsCoordinator2, "<set-?>");
        this.platformActionsCoordinator = platformActionsCoordinator2;
    }

    public final void setSendMessagePresenter(@NotNull SendMessagePresenter sendMessagePresenter2) {
        Intrinsics.checkNotNullParameter(sendMessagePresenter2, "<set-?>");
        this.sendMessagePresenter = sendMessagePresenter2;
    }

    public final void setServiceIntentFactory(@NotNull ServiceIntentFactory serviceIntentFactory2) {
        Intrinsics.checkNotNullParameter(serviceIntentFactory2, "<set-?>");
        this.serviceIntentFactory = serviceIntentFactory2;
    }

    public final void setSupplier(@NotNull FpsStateSupplier fpsStateSupplier) {
        Intrinsics.checkNotNullParameter(fpsStateSupplier, "<set-?>");
        this.supplier = fpsStateSupplier;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        OpenedFrom openedFrom;
        Intent intent;
        Bundle arguments = getArguments();
        SendMessagePresenter.State state = null;
        String string = arguments != null ? arguments.getString("channelId") : null;
        if (string != null) {
            this.s = string;
            Bundle arguments2 = getArguments();
            this.t = arguments2 != null ? arguments2.getString("messageId") : null;
            Bundle arguments3 = getArguments();
            this.u = arguments3 != null ? arguments3.getString("searchQuery") : null;
            Bundle arguments4 = getArguments();
            this.v = (arguments4 == null || !arguments4.containsKey("numberInList")) ? null : Integer.valueOf(arguments4.getInt("numberInList"));
            FragmentActivity activity = getActivity();
            this.w = (activity == null || (intent = activity.getIntent()) == null) ? null : Intents.getCalledFrom(intent);
            Timer B1 = a2.b.a.a.a.B1();
            if (bundle != null) {
                state = (SendMessagePresenter.State) bundle.getParcelable("sendMessagePresenter");
            }
            if (this.v != null) {
                openedFrom = OpenedFrom.CHAT_LIST;
            } else if (this.w instanceof CalledFrom.Push) {
                openedFrom = OpenedFrom.PUSH;
            } else {
                openedFrom = OpenedFrom.OTHER;
            }
            this.C = bundle != null ? bundle.getBoolean("user_changed_text") : false;
            Fragment parentFragment = getParentFragment();
            Objects.requireNonNull(parentFragment, "null cannot be cast to non-null type com.avito.android.app.di.HasComponent<com.avito.android.messenger.di.ChannelActivityComponent>");
            ChannelFragmentComponent.Builder relativeDateFormatterModule = ((ChannelActivityComponent) ((HasComponent) parentFragment).getComponent()).channelFragmentComponent().fragment(this).relativeDateFormatterModule(RelativeDateFormatterModule.INSTANCE);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            ChannelFragmentComponent.Builder resources2 = relativeDateFormatterModule.resources(resources);
            String str = this.s;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
            }
            ChannelFragmentComponent.Builder openedFrom2 = resources2.params(new Params(str, this.t, this.u)).openedFrom(openedFrom);
            if (state == null) {
                state = new SendMessagePresenter.State(null, null, null, null, null, false, null, null, false, null, false, null, false, false, null, 32767, null);
            }
            openedFrom2.state(state).state(ChannelContextInteractor.State.Companion.getDEFAULT()).state(MessageListInteractor.State.Empty.INSTANCE).state(ChannelContextView.State.Empty.INSTANCE).permissionHelper(new FragmentPermissionHelper(this)).build().inject(this);
            ChannelTracker channelTracker = this.perfTracker;
            if (channelTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
            }
            channelTracker.trackDiInject(B1.elapsed());
            return true;
        }
        throw new IllegalArgumentException("channelId required".toString());
    }

    @Override // com.avito.android.messenger.conversation.ChannelRouter
    public void showOrderCancelScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.deliveryRdsOrderCancellationIntent(str), 7);
    }

    @Override // com.avito.android.messenger.conversation.ChannelRouter
    public void showPlatformMap(@NotNull String str, @NotNull GeoMarker[] geoMarkerArr, @Nullable MarkersRequest markersRequest, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(geoMarkerArr, "initialGeoMarkers");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.messengerPlatformMapIntent(str, geoMarkerArr, markersRequest, z2));
    }
}

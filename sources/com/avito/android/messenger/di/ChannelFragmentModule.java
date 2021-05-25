package com.avito.android.messenger.di;

import a2.b.a.a.a;
import android.app.Application;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.os.Looper;
import android.view.ActionMode;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ChannelScreen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeliveryCourierPayoutInitLink;
import com.avito.android.deep_linking.links.DeliveryPayoutInitLink;
import com.avito.android.deep_linking.links.SafeDealPayoutInitLink;
import com.avito.android.deep_linking.links.StrPayoutInitLink;
import com.avito.android.di.PerFragment;
import com.avito.android.messenger.R;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.analytics.graphite_counter.ChatAppendCounter;
import com.avito.android.messenger.analytics.graphite_counter.ChatLoadingResult;
import com.avito.android.messenger.analytics.graphite_counter.ChatLoadingTimer;
import com.avito.android.messenger.analytics.graphite_counter.SuggestClickCounter;
import com.avito.android.messenger.analytics.graphite_counter.SuggestCloseCounter;
import com.avito.android.messenger.analytics.graphite_counter.SuggestShowCounter;
import com.avito.android.messenger.channels.mvi.data.DraftRepo;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.OpenedFrom;
import com.avito.android.messenger.conversation.adapter.MessageAvatarClickListener;
import com.avito.android.messenger.conversation.adapter.MessageClickListener;
import com.avito.android.messenger.conversation.adapter.MessageClickListenerImpl;
import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageClickListener;
import com.avito.android.messenger.conversation.adapter.file.FileMessageClickListener;
import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorView;
import com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsPresenter;
import com.avito.android.messenger.conversation.adapter.text.MessageLinkClickListener;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.conversation.analytics.ChannelTrackerImpl;
import com.avito.android.messenger.conversation.formatter.MessageDateFormatter;
import com.avito.android.messenger.conversation.formatter.MessageTimeFormatter;
import com.avito.android.messenger.conversation.formatter.UserOnlineStatusFormatter;
import com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor;
import com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractorImpl;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenter;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenterImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.CompositeDeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.CompositeDeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeepLinkProcessingListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.DefaultDeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.DefaultDeeplinkProcessorImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.DefaultDeeplinkProcessorListenerImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessorImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessorListenerImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.delete_channel.DeleteChannelDeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.delete_channel.DeleteChannelDeeplinkProcessorImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.DeliveryCourierPayoutInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.DeliveryPayoutInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessorImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessorKt;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessorListenerImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.SafeDealPayoutInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.StrPayoutInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewInteractorImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorListenerImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessorImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessorListenerImpl;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractor;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractorImpl;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadManager;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadModule;
import com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractor;
import com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractorImpl;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenter;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenterImpl;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageContextDataFactory;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageContextDataFactoryImpl;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenterImpl;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.MessageEraser;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.MessageEraserImpl;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import com.avito.android.messenger.conversation.mvi.messages.MessageListItemConverter;
import com.avito.android.messenger.conversation.mvi.messages.MessageListItemConverterImpl;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenter;
import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenterImpl;
import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinatorImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenterImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsInteractor;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsInteractorImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenterImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducer;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducerFactory;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducerImpl;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsInteractor;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsInteractorImpl;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenter;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenterImpl;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView;
import com.avito.android.messenger.conversation.mvi.send.OnboardingsInteractor;
import com.avito.android.messenger.conversation.mvi.send.OnboardingsInteractorImpl;
import com.avito.android.messenger.conversation.mvi.send.PhotoPickerResultHandler;
import com.avito.android.messenger.conversation.mvi.send.PhotoPickerResultHandlerImpl;
import com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor;
import com.avito.android.messenger.conversation.mvi.send.SendMessageInteractorImpl;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl;
import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgent;
import com.avito.android.messenger.service.OpenErrorTrackerScheduler;
import com.avito.android.messenger.service.OpenErrorTrackerSchedulerImpl;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.PhotoInteractorImpl;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.ImageKt;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.ResourcesKt;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.di.ClipboardModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import javax.inject.Named;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.UserLastActivity;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0004â\u0002ã\u0002B\t¢\u0006\u0006\bà\u0002\u0010á\u0002J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010#\u001a\u00020\"2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160!H\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u0016H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u0016H\u0007¢\u0006\u0004\b)\u0010*J'\u00104\u001a\u0002012\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0004\b2\u00103J'\u00108\u001a\u0002052\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0004\b6\u00107J'\u0010<\u001a\u0002092\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0004\b:\u0010;J'\u0010?\u001a\u00020\u00182\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0004\b=\u0010>J\u0019\u0010C\u001a\u00020B2\b\b\u0001\u0010A\u001a\u00020@H\u0007¢\u0006\u0004\bC\u0010DJ'\u0010L\u001a\u00020I2\u0006\u0010F\u001a\u00020E2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010H\u001a\u00020GH\u0001¢\u0006\u0004\bJ\u0010KJ\u0017\u0010P\u001a\u00020M2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\bN\u0010OJ\u001f\u0010R\u001a\u00020Q2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\bR\u0010SJ\u001f\u0010U\u001a\u00020T2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\bU\u0010VJ%\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0W2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\bY\u0010ZJ\u001f\u0010\\\u001a\u00020[2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\\\u0010]J\u0010u\u001a\u00020r2\u0006\u0010.\u001a\u00020-2\u0006\u0010_\u001a\u00020^2\u0006\u0010a\u001a\u00020`2\u0006\u0010c\u001a\u00020b2\u0006\u0010e\u001a\u00020d2\u0006\u0010g\u001a\u00020f2\u0006\u0010i\u001a\u00020h2\u0006\u0010k\u001a\u00020j2\u0006\u0010H\u001a\u00020G2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010m\u001a\u00020l2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020n2\u0006\u0010q\u001a\u00020pH\u0001¢\u0006\u0004\bs\u0010tJ'\u0010y\u001a\u00020v2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0004\bw\u0010xJ/\u0010|\u001a\u00020d2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\bz\u0010{J(\u0010\u0001\u001a\u00020}2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0004\b~\u0010J+\u0010\u0001\u001a\u00030\u00012\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J3\u0010\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u00010\u00122\u0006\u0010H\u001a\u00020G2\u0006\u0010F\u001a\u00020E2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00122\u0006\u0010H\u001a\u00020GH\u0001¢\u0006\u0006\b\u0001\u0010\u0001J+\u0010\u0001\u001a\u00030\u00012\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0006\b\u0001\u0010\u0001JB\u0010\u0001\u001a\u00030\u00012\u0006\u0010.\u001a\u00020-2\u0006\u0010e\u001a\u00020d2\u0015\u0010\u0001\u001a\u0010\u0012\u000b\u0012\t0\u0001¢\u0006\u0003\b\u00010\u00012\u0006\u0010m\u001a\u00020lH\u0001¢\u0006\u0006\b\u0001\u0010\u0001JX\u0010\u0001\u001a\u00020r2\u0006\u0010m\u001a\u00020l2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020b2\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020T2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0006\b\u0001\u0010\u0001J+\u0010£\u0001\u001a\u00030 \u00012\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0006\b¡\u0001\u0010¢\u0001J-\u0010©\u0001\u001a\u00030¦\u00012\u0007\u0010¤\u0001\u001a\u00020I2\u0007\u0010¥\u0001\u001a\u00020M2\u0006\u0010H\u001a\u00020GH\u0001¢\u0006\u0006\b§\u0001\u0010¨\u0001J+\u0010­\u0001\u001a\u00030ª\u00012\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0006\b«\u0001\u0010¬\u0001J¿\u0001\u0010Ã\u0001\u001a\u00020r2\u0006\u0010.\u001a\u00020-2\b\u0010®\u0001\u001a\u00030ª\u00012\b\u0010¯\u0001\u001a\u00030¦\u00012\u0006\u0010e\u001a\u00020d2\u0007\u0010°\u0001\u001a\u00020}2\u0007\u0010±\u0001\u001a\u0002012\u0006\u0010m\u001a\u00020l2\u0006\u0010H\u001a\u00020G2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010³\u0001\u001a\u00030²\u00012\b\u0010µ\u0001\u001a\u00030´\u00012\u0006\u0010\n\u001a\u00020\t2\u0007\u0010¶\u0001\u001a\u00020[2\b\u0010¸\u0001\u001a\u00030·\u00012\u0006\u0010F\u001a\u00020E2\b\u0010º\u0001\u001a\u00030¹\u00012\b\u0010¼\u0001\u001a\u00030»\u00012\b\u0010¾\u0001\u001a\u00030½\u00012\b\u0010À\u0001\u001a\u00030¿\u0001H\u0001¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J*\u0010Æ\u0001\u001a\u00020\u00162\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J;\u0010Ê\u0001\u001a\u00020r2\u0006\u0010.\u001a\u00020-2\u0007\u0010Ç\u0001\u001a\u00020h2\u0006\u0010e\u001a\u00020d2\u0006\u0010m\u001a\u00020l2\u0006\u0010F\u001a\u00020EH\u0001¢\u0006\u0006\bÈ\u0001\u0010É\u0001J+\u0010Î\u0001\u001a\u00030Ë\u00012\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u001d\u0010Ô\u0001\u001a\u00030Ñ\u00012\b\u0010Ð\u0001\u001a\u00030Ï\u0001H\u0001¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001J\u001a\u0010Ø\u0001\u001a\n\u0012\u0005\u0012\u00030Ñ\u00010Õ\u0001H\u0001¢\u0006\u0006\bÖ\u0001\u0010×\u0001JQ\u0010ä\u0001\u001a\u00030á\u00012\b\u0010Ú\u0001\u001a\u00030Ù\u00012\u0006\u0010m\u001a\u00020l2\b\u0010Ü\u0001\u001a\u00030Û\u00012\b\u0010Þ\u0001\u001a\u00030Ý\u00012\u000e\u0010à\u0001\u001a\t\u0012\u0005\u0012\u00030ß\u00010!2\u0006\u0010H\u001a\u00020GH\u0001¢\u0006\u0006\bâ\u0001\u0010ã\u0001J/\u0010é\u0001\u001a\u00030Ù\u00012\b\u0010æ\u0001\u001a\u00030å\u00012\u0006\u0010m\u001a\u00020l2\b\u0010Ü\u0001\u001a\u00030Û\u0001H\u0001¢\u0006\u0006\bç\u0001\u0010è\u0001J$\u0010ì\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Õ\u00012\b\u0010Ð\u0001\u001a\u00030Ï\u0001H\u0001¢\u0006\u0006\bê\u0001\u0010ë\u0001JQ\u0010ñ\u0001\u001a\u00030á\u00012\b\u0010î\u0001\u001a\u00030í\u00012\u0006\u0010m\u001a\u00020l2\b\u0010Ü\u0001\u001a\u00030Û\u00012\b\u0010Þ\u0001\u001a\u00030Ý\u00012\u000e\u0010à\u0001\u001a\t\u0012\u0005\u0012\u00030ß\u00010!2\u0006\u0010H\u001a\u00020GH\u0001¢\u0006\u0006\bï\u0001\u0010ð\u0001J/\u0010ö\u0001\u001a\u00030í\u00012\b\u0010ó\u0001\u001a\u00030ò\u00012\u0006\u0010m\u001a\u00020l2\b\u0010Ü\u0001\u001a\u00030Û\u0001H\u0001¢\u0006\u0006\bô\u0001\u0010õ\u0001J$\u0010ø\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Õ\u00012\b\u0010Ð\u0001\u001a\u00030Ï\u0001H\u0001¢\u0006\u0006\b÷\u0001\u0010ë\u0001JQ\u0010ý\u0001\u001a\u00030á\u00012\b\u0010ú\u0001\u001a\u00030ù\u00012\u0006\u0010m\u001a\u00020l2\b\u0010Ü\u0001\u001a\u00030Û\u00012\b\u0010Þ\u0001\u001a\u00030Ý\u00012\u000e\u0010à\u0001\u001a\t\u0012\u0005\u0012\u00030ß\u00010!2\u0006\u0010H\u001a\u00020GH\u0001¢\u0006\u0006\bû\u0001\u0010ü\u0001J/\u0010\u0002\u001a\u00030ù\u00012\b\u0010ÿ\u0001\u001a\u00030þ\u00012\u0006\u0010m\u001a\u00020l2\b\u0010Ü\u0001\u001a\u00030Û\u0001H\u0001¢\u0006\u0006\b\u0002\u0010\u0002J$\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030á\u00010Õ\u00012\b\u0010Ð\u0001\u001a\u00030Ï\u0001H\u0001¢\u0006\u0006\b\u0002\u0010ë\u0001J\u001d\u0010\u0002\u001a\u00030\u00022\b\u0010Þ\u0001\u001a\u00030Ý\u0001H\u0001¢\u0006\u0006\b\u0002\u0010\u0002JQ\u0010\u0002\u001a\u00030á\u00012\b\u0010î\u0001\u001a\u00030\u00022\u0006\u0010m\u001a\u00020l2\b\u0010Ü\u0001\u001a\u00030Û\u00012\b\u0010Þ\u0001\u001a\u00030Ý\u00012\u000e\u0010à\u0001\u001a\t\u0012\u0005\u0012\u00030ß\u00010!2\u0006\u0010H\u001a\u00020GH\u0001¢\u0006\u0006\b\u0002\u0010\u0002J/\u0010\u0002\u001a\u00030\u00022\b\u0010ÿ\u0001\u001a\u00030þ\u00012\u0006\u0010m\u001a\u00020l2\b\u0010Ü\u0001\u001a\u00030Û\u0001H\u0001¢\u0006\u0006\b\u0002\u0010\u0002J$\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030á\u00010Õ\u00012\b\u0010Ð\u0001\u001a\u00030Ï\u0001H\u0001¢\u0006\u0006\b\u0002\u0010ë\u0001JN\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020Õ\u00012\b\u0010ÿ\u0001\u001a\u00030þ\u00012\u0006\u0010m\u001a\u00020l2\b\u0010Ü\u0001\u001a\u00030Û\u00012\u000e\u0010à\u0001\u001a\t\u0012\u0005\u0012\u00030ß\u00010!2\u0006\u0010H\u001a\u00020GH\u0001¢\u0006\u0006\b\u0002\u0010\u0002J+\u0010\u0002\u001a\u00030\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0006\b\u0002\u0010\u0002Jt\u0010¦\u0002\u001a\u00020r2\b\u0010\u0002\u001a\u00030Ñ\u00012\n\b\u0001\u0010\u0002\u001a\u00030á\u00012\n\b\u0001\u0010\u0002\u001a\u00030á\u00012\n\b\u0001\u0010\u0002\u001a\u00030á\u00012\n\b\u0001\u0010\u0002\u001a\u00030á\u00012\b\u0010\u0002\u001a\u00030\u00022\b\u0010 \u0002\u001a\u00030\u00022\b\u0010¡\u0002\u001a\u00030\u00022\b\u0010£\u0002\u001a\u00030¢\u0002H\u0001¢\u0006\u0006\b¤\u0002\u0010¥\u0002J+\u0010©\u0002\u001a\u00030´\u00012\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0006\b§\u0002\u0010¨\u0002J\u0001\u0010¶\u0002\u001a\u00020r2\u000f\u0010ª\u0002\u001a\n\u0012\u0005\u0012\u00030Ñ\u00010Õ\u00012\u0011\b\u0001\u0010«\u0002\u001a\n\u0012\u0005\u0012\u00030á\u00010Õ\u00012\u0011\b\u0001\u0010¬\u0002\u001a\n\u0012\u0005\u0012\u00030á\u00010Õ\u00012\u0011\b\u0001\u0010­\u0002\u001a\n\u0012\u0005\u0012\u00030á\u00010Õ\u00012\u0011\b\u0001\u0010®\u0002\u001a\n\u0012\u0005\u0012\u00030á\u00010Õ\u00012\b\u0010°\u0002\u001a\u00030¯\u00022\u000f\u0010±\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020Õ\u00012\b\u0010³\u0002\u001a\u00030²\u0002H\u0001¢\u0006\u0006\b´\u0002\u0010µ\u0002J+\u0010º\u0002\u001a\u00030·\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0006\b¸\u0002\u0010¹\u0002J*\u0010½\u0002\u001a\u00020n2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0006\b»\u0002\u0010¼\u0002J'\u0010Ã\u0002\u001a\u00030Â\u00022\b\u0010¿\u0002\u001a\u00030¾\u00022\b\u0010Á\u0002\u001a\u00030À\u0002H\u0007¢\u0006\u0006\bÃ\u0002\u0010Ä\u0002J'\u0010È\u0002\u001a\u00030Å\u00022\b\u0010¿\u0002\u001a\u00030¾\u00022\b\u0010Á\u0002\u001a\u00030À\u0002H\u0001¢\u0006\u0006\bÆ\u0002\u0010Ç\u0002J'\u0010Ê\u0002\u001a\u00030É\u00022\b\u0010¿\u0002\u001a\u00030¾\u00022\b\u0010Á\u0002\u001a\u00030À\u0002H\u0007¢\u0006\u0006\bÊ\u0002\u0010Ë\u0002J\u001b\u0010Í\u0002\u001a\u00030Ì\u00022\u0006\u0010.\u001a\u00020-H\u0007¢\u0006\u0006\bÍ\u0002\u0010Î\u0002J\u001d\u0010Ï\u0002\u001a\u0005\u0018\u00010Ì\u00022\u0006\u0010.\u001a\u00020-H\u0007¢\u0006\u0006\bÏ\u0002\u0010Î\u0002J+\u0010Ð\u0002\u001a\u00030\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0007¢\u0006\u0006\bÐ\u0002\u0010Ñ\u0002J+\u0010Ò\u0002\u001a\u00030¯\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0007¢\u0006\u0006\bÒ\u0002\u0010Ó\u0002J+\u0010Õ\u0002\u001a\u00030Ô\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0007¢\u0006\u0006\bÕ\u0002\u0010Ö\u0002J+\u0010Ø\u0002\u001a\u00030×\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0007¢\u0006\u0006\bØ\u0002\u0010Ù\u0002J+\u0010Ú\u0002\u001a\u00030¢\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0007¢\u0006\u0006\bÚ\u0002\u0010Û\u0002J+\u0010Ü\u0002\u001a\u00030²\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0007¢\u0006\u0006\bÜ\u0002\u0010Ý\u0002J+\u0010Þ\u0002\u001a\u00030»\u00012\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0007¢\u0006\u0006\bÞ\u0002\u0010ß\u0002¨\u0006ä\u0002"}, d2 = {"Lcom/avito/android/messenger/di/ChannelFragmentModule;", "", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "providePhotoInteractor", "(Lcom/avito/android/util/BuildInfo;Landroid/app/Application;)Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/analytics/graphite_counter/SuggestShowCounter;", "provideSuggestShowCounter", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Lcom/avito/android/messenger/analytics/graphite_counter/SuggestShowCounter;", "Ljava/util/Locale;", "locale", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "provideAdvertPriceFormatter", "(Ljava/util/Locale;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;", "messageListPresenter", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;", "messageMenuPresenter", "Lcom/avito/android/messenger/conversation/adapter/MessageClickListener;", "provideMessageClickListener", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;)Lcom/avito/android/messenger/conversation/adapter/MessageClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/messenger/conversation/adapter/MessageAvatarClickListener;", "provideMessageAvatarClickListener", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;)Lcom/avito/android/messenger/conversation/adapter/MessageAvatarClickListener;", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorView$Listener;", "providePaginationErrorViewListener", "(Ldagger/Lazy;)Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorView$Listener;", "Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessageClickListener;", "provideAppCallMessageClickListener", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;)Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessageClickListener;", "Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenter$Listener;", "provideMessageSpamActionsListener", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;)Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenter$Listener;", "Lcom/avito/android/messenger/conversation/ChannelFragment;", "fragment", "Lcom/avito/android/messenger/conversation/ChannelFragment$Params;", "params", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor;", "provideMessageSpamActionsInteractor$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor;", "provideMessageSpamActionsInteractor", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;", "providePlatformActionsPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;", "providePlatformActionsPresenter", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;", "provideContextActionsPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;", "provideContextActionsPresenter", "provideMessageActionsMenuPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;", "provideMessageActionsMenuPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideMessagesAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/messenger/conversation/formatter/MessageDateFormatter;", "provideMessageDateFormatter$messenger_release", "(Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Landroid/content/res/Resources;)Lcom/avito/android/messenger/conversation/formatter/MessageDateFormatter;", "provideMessageDateFormatter", "Lcom/avito/android/messenger/conversation/formatter/MessageTimeFormatter;", "provideMessageTimeFormatter$messenger_release", "(Ljava/util/Locale;)Lcom/avito/android/messenger/conversation/formatter/MessageTimeFormatter;", "provideMessageTimeFormatter", "Lcom/avito/android/messenger/analytics/graphite_counter/SuggestClickCounter;", "provideSuggestClickCounter", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Lcom/avito/android/messenger/analytics/graphite_counter/SuggestClickCounter;", "Lcom/avito/android/messenger/analytics/graphite_counter/SuggestCloseCounter;", "provideSuggestCloseCounter", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Lcom/avito/android/messenger/analytics/graphite_counter/SuggestCloseCounter;", "Lcom/avito/android/analytics/timer/AnalyticsTimer;", "Lcom/avito/android/messenger/analytics/graphite_counter/ChatLoadingResult;", "provideChatLoadingTimer", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Lcom/avito/android/analytics/timer/AnalyticsTimer;", "Lcom/avito/android/messenger/analytics/graphite_counter/ChatAppendCounter;", "provideChatAppendCounter", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Lcom/avito/android/messenger/analytics/graphite_counter/ChatAppendCounter;", "Lcom/avito/android/messenger/conversation/OpenedFrom;", "openedFrom", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "state", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;", "interactor", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "channelContextInteractor", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractor;", "fileAttachmentInteractor", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor;", "onboardingsInteractor", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepo;", "draftRepo", "Landroidx/lifecycle/ViewModel;", "provideSendMessagePresenterViewModel$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/conversation/OpenedFrom;Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractor;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/util/RandomKeyProvider;Landroid/content/res/Resources;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor;Lcom/avito/android/messenger/channels/mvi/data/DraftRepo;)Landroidx/lifecycle/ViewModel;", "provideSendMessagePresenterViewModel", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter;", "provideSendMessagePresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter;", "provideSendMessagePresenter", "provideChannelContextInteractor$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Lcom/avito/android/Features;)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "provideChannelContextInteractor", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "provideChannelMenuInteractor$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "provideChannelMenuInteractor", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenter;", "provideChannelMenuPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenter;", "provideChannelMenuPresenter", "Lru/avito/messenger/api/entity/UserLastActivity;", "provideUserOnlineStatusFormatter", "(Landroid/content/res/Resources;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;)Lcom/avito/android/util/Formatter;", "", "providerErrorFormatter$messenger_release", "(Landroid/content/res/Resources;)Lcom/avito/android/util/Formatter;", "providerErrorFormatter", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenter;", "provideChannelContextPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenter;", "provideChannelContextPresenter", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "client", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsInteractor;", "provideChannelReplySuggestsInteractor$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lru/avito/messenger/MessengerClient;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsInteractor;", "provideChannelReplySuggestsInteractor", "replySuggestsInteractor", "sendMessageInteractor", "suggestShowCounter", "suggestClickCounter", "suggestCloseCounter", "provideChannelReplySuggestsPresenterViewModel$messenger_release", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsInteractor;Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;Lcom/avito/android/messenger/analytics/graphite_counter/SuggestShowCounter;Lcom/avito/android/messenger/analytics/graphite_counter/SuggestClickCounter;Lcom/avito/android/messenger/analytics/graphite_counter/SuggestCloseCounter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Landroidx/lifecycle/ViewModel;", "provideChannelReplySuggestsPresenterViewModel", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsPresenter;", "provideChannelReplySuggestsPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsPresenter;", "provideChannelReplySuggestsPresenter", "dateFormatter", "timeFormatter", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverter;", "provideMessageListItemConverter$messenger_release", "(Lcom/avito/android/messenger/conversation/formatter/MessageDateFormatter;Lcom/avito/android/messenger/conversation/formatter/MessageTimeFormatter;Landroid/content/res/Resources;)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverter;", "provideMessageListItemConverter", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "provideMessageListInteractor$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "provideMessageListInteractor", "messageListInteractor", "messageListItemConverter", "channelMenuInteractor", "messageSpamActionsInteractor", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "deeplinkProcessor", "appendCounter", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "channelTracker", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "fileDownloadManager", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor;", "fileMessageClickInteractor", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;", "messageEraser", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "missingUsersSyncAgent", "provideMessageListPresenterViewModel$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverter;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor;Lcom/avito/android/util/SchedulersFactory;Landroid/content/res/Resources;Lcom/avito/android/Features;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/analytics/graphite_counter/ChatAppendCounter;Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;)Landroidx/lifecycle/ViewModel;", "provideMessageListPresenterViewModel", "provideMessageListPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;", "provideMessageListPresenter", "repo", "provideNewMessagesPresenterViewModel$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/server_time/TimeSource;)Landroidx/lifecycle/ViewModel;", "provideNewMessagesPresenterViewModel", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenter;", "provideNewMessagesPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesPresenter;", "provideNewMessagesPresenter", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessor;", "provideDefaultDeeplinkProcessor$messenger_release", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessor;", "provideDefaultDeeplinkProcessor", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;", "provideDefaultDeeplinkProcessorListener$messenger_release", "()Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;", "provideDefaultDeeplinkProcessorListener", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/StrPayoutInteractor;", "strPayoutInteractor", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeepLinkProcessingListener;", "processingListener", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;", "provideStrPayoutInitLinkProcessor$messenger_release", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/StrPayoutInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/ActivityIntentFactory;Ldagger/Lazy;Landroid/content/res/Resources;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;", "provideStrPayoutInitLinkProcessor", "Lcom/avito/android/remote/ShortTermRentApi;", "shortTermRentApi", "provideStrPayoutInteractor$messenger_release", "(Lcom/avito/android/remote/ShortTermRentApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/StrPayoutInteractor;", "provideStrPayoutInteractor", "provideStrPayoutInitLinkProcessorListener$messenger_release", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;", "provideStrPayoutInitLinkProcessorListener", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/SafeDealPayoutInteractor;", "payoutInteractor", "provideSafeDealPayoutInitLinkProcessor$messenger_release", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/SafeDealPayoutInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/ActivityIntentFactory;Ldagger/Lazy;Landroid/content/res/Resources;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;", "provideSafeDealPayoutInitLinkProcessor", "Lcom/avito/android/safedeal/remote/SafeDealApi;", "safedealApi", "provideSafeDealPayoutInteractor$messenger_release", "(Lcom/avito/android/safedeal/remote/SafeDealApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/SafeDealPayoutInteractor;", "provideSafeDealPayoutInteractor", "provideSafeDealPayoutInitLinkProcessorListener$messenger_release", "provideSafeDealPayoutInitLinkProcessorListener", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/DeliveryPayoutInteractor;", "deliveryPayoutInteractor", "provideDeliveryPayoutInitLinkProcessor$messenger_release", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/DeliveryPayoutInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/ActivityIntentFactory;Ldagger/Lazy;Landroid/content/res/Resources;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;", "provideDeliveryPayoutInitLinkProcessor", "Lcom/avito/android/remote/DeliveryApi;", "deliveryApi", "provideDeliveryPayoutInteractor$messenger_release", "(Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/DeliveryPayoutInteractor;", "provideDeliveryPayoutInteractor", "provideDeliveryPayoutInitLinkProcessorListener$messenger_release", "provideDeliveryPayoutInitLinkProcessorListener", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/cancel_order/DeliveryOrderCancelLinkProcessor;", "provideDeliveryOrderCancelLinkProcessor$messenger_release", "(Lcom/avito/android/ActivityIntentFactory;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/cancel_order/DeliveryOrderCancelLinkProcessor;", "provideDeliveryOrderCancelLinkProcessor", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/DeliveryCourierPayoutInteractor;", "provideDeliveryCourierPayoutInitLinkProcessor$messenger_release", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/DeliveryCourierPayoutInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/ActivityIntentFactory;Ldagger/Lazy;Landroid/content/res/Resources;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;", "provideDeliveryCourierPayoutInitLinkProcessor", "provideDeliveryCourierPayoutInteractor$messenger_release", "(Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/DeliveryCourierPayoutInteractor;", "provideDeliveryCourierPayoutInteractor", "provideDeliveryCourierPayoutInitLinkProcessorListener$messenger_release", "provideDeliveryCourierPayoutInitLinkProcessorListener", "provideDeliveryOrderCancelLinkProcessorListener$messenger_release", "(Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Ldagger/Lazy;Landroid/content/res/Resources;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;", "provideDeliveryOrderCancelLinkProcessorListener", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/delete_channel/DeleteChannelDeeplinkProcessor;", "provideDeleteChannelDeeplinkProcessor$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/delete_channel/DeleteChannelDeeplinkProcessor;", "provideDeleteChannelDeeplinkProcessor", "defaultProcessor", "strPayoutInitLinkProcessor", "deliveryPayoutInitLinkProcessor", "deliveryCourierPayoutInitLinkProcessor", "safedealPayoutInitLinkProcessor", "deliveryOrderCancelLinkProcessor", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessor;", "requestReviewLinkProcessor", "deleteChannelDeeplinkProcessor", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessor;", "updateFolderTagsLinkProcessor", "provideCompositeDeeplinkProcessorViewModel$messenger_release", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessor;Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;Lcom/avito/android/messenger/conversation/mvi/deeplinks/cancel_order/DeliveryOrderCancelLinkProcessor;Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessor;Lcom/avito/android/messenger/conversation/mvi/deeplinks/delete_channel/DeleteChannelDeeplinkProcessor;Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessor;)Landroidx/lifecycle/ViewModel;", "provideCompositeDeeplinkProcessorViewModel", "provideCompositeDeeplinkProcessor$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "provideCompositeDeeplinkProcessor", "defaultListener", "strPayoutInitLinkProcessorListener", "deliveryPayoutInitLinkProcessorListener", "deliveryCourierPayoutInitLinkProcessorListener", "safedealPayoutInitLinkProcessorListener", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessorListener;", "requestReviewLinkProcessorListener", "deliveryOrderCancelLinkProcessorListener", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessorListener;", "updateFolderTagsLinkProcessorListener", "provideCompositeDeeplinkProcessorListenerViewModel$messenger_release", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessorListener;Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessorListener;)Landroidx/lifecycle/ViewModel;", "provideCompositeDeeplinkProcessorListenerViewModel", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessorListener;", "provideCompositeDeeplinkProcessorListener$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessorListener;", "provideCompositeDeeplinkProcessorListener", "provideOnboardingsInteractor$messenger_release", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor;", "provideOnboardingsInteractor", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$messenger_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "", "provideChannelId", "(Lcom/avito/android/messenger/conversation/ChannelFragment$Params;)Ljava/lang/String;", "provideMessageId", "provideRequestReviewLinkProcessor", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessor;", "provideRequestReviewLinkProcessorListener", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessorListener;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducer;", "provideSamplePlatformActionsStateProducer", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator;", "providePlatformActionsCoordinator", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator;", "provideUpdateFolderTagsLinkProcessor", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessor;", "provideUpdateFolderTagsLinkProcessorListener", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessorListener;", "provideFileMessageClickInteractor", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor;", "<init>", "()V", "Declarations", "Tracker", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ClipboardModule.class, RelativeDateFormatterModule.class, PhoneNumberFormatterModule.class, Declarations.class, MessageMenuModule.class, FileDownloadModule.class})
public final class ChannelFragmentModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0016H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0019H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001cH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001fH'¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\"H'¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020%H'¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020)H'¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020-H'¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u0002022\u0006\u0010\u0003\u001a\u000201H'¢\u0006\u0004\b3\u00104J\u0017\u00108\u001a\u0002072\u0006\u00106\u001a\u000205H'¢\u0006\u0004\b8\u00109J\u0017\u0010=\u001a\u00020<2\u0006\u0010;\u001a\u00020:H'¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020?2\u0006\u0010;\u001a\u00020:H'¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020B2\u0006\u0010;\u001a\u00020:H'¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020F2\u0006\u0010\u0003\u001a\u00020EH'¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020J2\u0006\u0010\u0003\u001a\u00020IH'¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020N2\u0006\u0010\u0003\u001a\u00020MH'¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020R2\u0006\u0010\u0003\u001a\u00020QH'¢\u0006\u0004\bS\u0010TJ\u0017\u0010W\u001a\u00020V2\u0006\u0010\u0003\u001a\u00020UH'¢\u0006\u0004\bW\u0010XJ\u0017\u0010Z\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020YH'¢\u0006\u0004\bZ\u0010[J\u0017\u0010]\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\\H'¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020_H'¢\u0006\u0004\b`\u0010aJ\u0017\u0010c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020bH'¢\u0006\u0004\bc\u0010dJ#\u0010h\u001a\u000e\u0012\u0002\b\u00030fj\u0006\u0012\u0002\b\u0003`g2\u0006\u0010\u0003\u001a\u00020eH'¢\u0006\u0004\bh\u0010iJ\u0017\u0010k\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020jH'¢\u0006\u0004\bk\u0010lJ\u0017\u0010n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020mH'¢\u0006\u0004\bn\u0010oJ\u0017\u0010q\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020pH'¢\u0006\u0004\bq\u0010r¨\u0006s"}, d2 = {"Lcom/avito/android/messenger/di/ChannelFragmentModule$Declarations;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl;", "impl", "Landroidx/lifecycle/ViewModel;", "bindMessageListInteractorViewModel", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/delete_channel/DeleteChannelDeeplinkProcessorImpl;", "bindDeleteChannelDeeplinkProcessorViewModel", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/delete_channel/DeleteChannelDeeplinkProcessorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractorImpl;", "bindOnboardingsInteractorViewModel", "(Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;", "bindChannelContextInteractorImpl", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl;", "bindChannelMenuInteractorViewModel", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl;", "bindChannelMenuPresenterViewModel", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractorImpl;", "bindMessageSpamActionsInteractorViewModel", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenterImpl;", "bindPlatformActionsPresenterViewModel", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenterImpl;", "bindContextActionsPresenterViewModel", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl;", "bindMessageActionsMenuPresenterViewModel", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl;", "bindChannelContextPresenterViewModel", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor;", "bindRequestReviewInteractor", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractorImpl;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsInteractor;", "bindContextActionsInteractor", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsInteractorImpl;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsInteractor;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeepLinkProcessingListener;", "bindDeepLinkProcessingListener", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeepLinkProcessingListener;", "Lcom/avito/android/messenger/service/OpenErrorTrackerSchedulerImpl;", "Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;", "bindOpenErrorTrackerScheduler", "(Lcom/avito/android/messenger/service/OpenErrorTrackerSchedulerImpl;)Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;", "Lcom/avito/android/messenger/conversation/analytics/ChannelTrackerImpl;", "tracker", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "bindTracker", "(Lcom/avito/android/messenger/conversation/analytics/ChannelTrackerImpl;)Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;", "messageListPresenter", "Landroid/view/ActionMode$Callback;", "bindActionModeCallback", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;)Landroid/view/ActionMode$Callback;", "Lcom/avito/android/messenger/conversation/adapter/text/MessageLinkClickListener;", "bindMessageLinkClickListener", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;)Lcom/avito/android/messenger/conversation/adapter/text/MessageLinkClickListener;", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageClickListener;", "bindFileMessageClickListener", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;)Lcom/avito/android/messenger/conversation/adapter/file/FileMessageClickListener;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextDataFactoryImpl;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextDataFactory;", "bindContextDataFactory", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextDataFactoryImpl;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextDataFactory;", "Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandlerImpl;", "Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandler;", "bindPhotoPickerResultHandler", "(Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandlerImpl;)Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandler;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;", "bindSendMessageInteractor", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractorImpl;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractor;", "bindFileAttachmentInteractor", "(Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractorImpl;)Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractor;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraserImpl;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;", "bindMessageEraser", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraserImpl;)Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessorImpl;", "bindRequestReviewLinkProcessorViewModel", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessorListenerImpl;", "bindRequestReviewLinkProcessorListenerViewModel", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessorListenerImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl;", "bindPlatformActionsCoordinatorViewModel", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducerImpl;", "bindSamplePlatformActionsStateProducerViewModel", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducerImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducerFactory;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer$Factory;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASProducerFactory;", "bindSamplePlatformActionsPresenterFactory", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducerFactory;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer$Factory;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessorImpl;", "bindUpdateFolderTagsLinkProcessorViewModel", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessorListenerImpl;", "bindUpdateFolderTagsLinkProcessorListenerViewModel", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessorListenerImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractorImpl;", "bingFileMessageClickInteractorViewModel", "(Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractorImpl;)Landroidx/lifecycle/ViewModel;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ActionMode.Callback bindActionModeCallback(@NotNull MessageListPresenter messageListPresenter);

        @Binds
        @NotNull
        @ClassKey(ChannelContextInteractorImpl.class)
        @IntoMap
        ViewModel bindChannelContextInteractorImpl(@NotNull ChannelContextInteractorImpl channelContextInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(ChannelContextPresenterImpl.class)
        @IntoMap
        ViewModel bindChannelContextPresenterViewModel(@NotNull ChannelContextPresenterImpl channelContextPresenterImpl);

        @Binds
        @NotNull
        @ClassKey(ChannelMenuInteractorImpl.class)
        @IntoMap
        ViewModel bindChannelMenuInteractorViewModel(@NotNull ChannelMenuInteractorImpl channelMenuInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(ChannelMenuPresenterImpl.class)
        @IntoMap
        ViewModel bindChannelMenuPresenterViewModel(@NotNull ChannelMenuPresenterImpl channelMenuPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ContextActionsInteractor bindContextActionsInteractor(@NotNull ContextActionsInteractorImpl contextActionsInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(ContextActionsPresenterImpl.class)
        @IntoMap
        ViewModel bindContextActionsPresenterViewModel(@NotNull ContextActionsPresenterImpl contextActionsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        MessageContextDataFactory bindContextDataFactory(@NotNull MessageContextDataFactoryImpl messageContextDataFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        DeepLinkProcessingListener bindDeepLinkProcessingListener(@NotNull ContextActionsPresenter contextActionsPresenter);

        @Binds
        @NotNull
        @ClassKey(DeleteChannelDeeplinkProcessorImpl.class)
        @IntoMap
        ViewModel bindDeleteChannelDeeplinkProcessorViewModel(@NotNull DeleteChannelDeeplinkProcessorImpl deleteChannelDeeplinkProcessorImpl);

        @PerFragment
        @Binds
        @NotNull
        FileAttachmentInteractor bindFileAttachmentInteractor(@NotNull FileAttachmentInteractorImpl fileAttachmentInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        FileMessageClickListener bindFileMessageClickListener(@NotNull MessageListPresenter messageListPresenter);

        @Binds
        @NotNull
        @ClassKey(MessageMenuPresenterImpl.class)
        @IntoMap
        ViewModel bindMessageActionsMenuPresenterViewModel(@NotNull MessageMenuPresenterImpl messageMenuPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        MessageEraser bindMessageEraser(@NotNull MessageEraserImpl messageEraserImpl);

        @PerFragment
        @Binds
        @NotNull
        MessageLinkClickListener bindMessageLinkClickListener(@NotNull MessageListPresenter messageListPresenter);

        @Binds
        @NotNull
        @ClassKey(MessageListInteractorImpl.class)
        @IntoMap
        ViewModel bindMessageListInteractorViewModel(@NotNull MessageListInteractorImpl messageListInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(MessageSpamActionsInteractorImpl.class)
        @IntoMap
        ViewModel bindMessageSpamActionsInteractorViewModel(@NotNull MessageSpamActionsInteractorImpl messageSpamActionsInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(OnboardingsInteractorImpl.class)
        @IntoMap
        ViewModel bindOnboardingsInteractorViewModel(@NotNull OnboardingsInteractorImpl onboardingsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        OpenErrorTrackerScheduler bindOpenErrorTrackerScheduler(@NotNull OpenErrorTrackerSchedulerImpl openErrorTrackerSchedulerImpl);

        @PerFragment
        @Binds
        @NotNull
        PhotoPickerResultHandler bindPhotoPickerResultHandler(@NotNull PhotoPickerResultHandlerImpl photoPickerResultHandlerImpl);

        @Binds
        @NotNull
        @ClassKey(PlatformActionsCoordinatorImpl.class)
        @IntoMap
        ViewModel bindPlatformActionsCoordinatorViewModel(@NotNull PlatformActionsCoordinatorImpl platformActionsCoordinatorImpl);

        @Binds
        @NotNull
        @ClassKey(LegacyPlatformActionsPresenterImpl.class)
        @IntoMap
        ViewModel bindPlatformActionsPresenterViewModel(@NotNull LegacyPlatformActionsPresenterImpl legacyPlatformActionsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        RequestReviewInteractor bindRequestReviewInteractor(@NotNull RequestReviewInteractorImpl requestReviewInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(RequestReviewLinkProcessorListenerImpl.class)
        @IntoMap
        ViewModel bindRequestReviewLinkProcessorListenerViewModel(@NotNull RequestReviewLinkProcessorListenerImpl requestReviewLinkProcessorListenerImpl);

        @Binds
        @NotNull
        @ClassKey(RequestReviewLinkProcessorImpl.class)
        @IntoMap
        ViewModel bindRequestReviewLinkProcessorViewModel(@NotNull RequestReviewLinkProcessorImpl requestReviewLinkProcessorImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        PlatformActionsStateProducer.Factory<?> bindSamplePlatformActionsPresenterFactory(@NotNull SamplePlatformActionsStateProducerFactory samplePlatformActionsStateProducerFactory);

        @Binds
        @NotNull
        @ClassKey(SamplePlatformActionsStateProducerImpl.class)
        @IntoMap
        ViewModel bindSamplePlatformActionsStateProducerViewModel(@NotNull SamplePlatformActionsStateProducerImpl samplePlatformActionsStateProducerImpl);

        @PerFragment
        @Binds
        @NotNull
        SendMessageInteractor bindSendMessageInteractor(@NotNull SendMessageInteractorImpl sendMessageInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ChannelTracker bindTracker(@NotNull ChannelTrackerImpl channelTrackerImpl);

        @Binds
        @NotNull
        @ClassKey(UpdateFolderTagsLinkProcessorListenerImpl.class)
        @IntoMap
        ViewModel bindUpdateFolderTagsLinkProcessorListenerViewModel(@NotNull UpdateFolderTagsLinkProcessorListenerImpl updateFolderTagsLinkProcessorListenerImpl);

        @Binds
        @NotNull
        @ClassKey(UpdateFolderTagsLinkProcessorImpl.class)
        @IntoMap
        ViewModel bindUpdateFolderTagsLinkProcessorViewModel(@NotNull UpdateFolderTagsLinkProcessorImpl updateFolderTagsLinkProcessorImpl);

        @Binds
        @NotNull
        @ClassKey(FileMessageClickInteractorImpl.class)
        @IntoMap
        ViewModel bingFileMessageClickInteractorViewModel(@NotNull FileMessageClickInteractorImpl fileMessageClickInteractorImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/di/ChannelFragmentModule$Tracker;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Tracker {
    }

    @Provides
    @NotNull
    @PerFragment
    public final Formatter<AdvertPrice> provideAdvertPriceFormatter(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new AdvertPriceFormatter(locale);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AppCallMessageClickListener provideAppCallMessageClickListener(@NotNull MessageListPresenter messageListPresenter) {
        Intrinsics.checkNotNullParameter(messageListPresenter, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return messageListPresenter;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ChannelContextInteractor provideChannelContextInteractor$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(channelFragment, "fragment");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(ChannelContextInteractorImpl.class, new StringBuilder(), ':', params.getChannelId()), ChannelContextInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (ChannelContextInteractor) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ChannelContextPresenter provideChannelContextPresenter$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(ChannelContextPresenterImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), ChannelContextPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (ChannelContextPresenter) viewModel;
    }

    @ChannelId
    @Provides
    @NotNull
    @PerFragment
    public final String provideChannelId(@NotNull ChannelFragment.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return params.getChannelId();
    }

    @Provides
    @PerFragment
    @NotNull
    public final ChannelMenuInteractor provideChannelMenuInteractor$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(ChannelMenuInteractorImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), ChannelMenuInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (ChannelMenuInteractor) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ChannelMenuPresenter provideChannelMenuPresenter$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(ChannelMenuPresenterImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), ChannelMenuPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (ChannelMenuPresenter) viewModel;
    }

    @Provides
    @NotNull
    @PerFragment
    public final ChannelReplySuggestsInteractor provideChannelReplySuggestsInteractor$messenger_release(@NotNull ChannelFragment.Params params, @NotNull ChannelContextInteractor channelContextInteractor, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new ChannelReplySuggestsInteractorImpl(params.getChannelId(), channelContextInteractor, messengerClient, schedulersFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ChannelReplySuggestsPresenter provideChannelReplySuggestsPresenter$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(ChannelReplySuggestsPresenterImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), ChannelReplySuggestsPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (ChannelReplySuggestsPresenter) viewModel;
    }

    @Provides
    @NotNull
    @ClassKey(ChannelReplySuggestsPresenterImpl.class)
    @IntoMap
    public final ViewModel provideChannelReplySuggestsPresenterViewModel$messenger_release(@NotNull SchedulersFactory schedulersFactory, @NotNull ChannelReplySuggestsInteractor channelReplySuggestsInteractor, @NotNull SendMessageInteractor sendMessageInteractor, @NotNull SuggestShowCounter suggestShowCounter, @NotNull SuggestClickCounter suggestClickCounter, @NotNull SuggestCloseCounter suggestCloseCounter, @NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(channelReplySuggestsInteractor, "replySuggestsInteractor");
        Intrinsics.checkNotNullParameter(sendMessageInteractor, "sendMessageInteractor");
        Intrinsics.checkNotNullParameter(suggestShowCounter, "suggestShowCounter");
        Intrinsics.checkNotNullParameter(suggestClickCounter, "suggestClickCounter");
        Intrinsics.checkNotNullParameter(suggestCloseCounter, "suggestCloseCounter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ChannelReplySuggestsPresenterImpl(ChannelReplySuggestsView.State.Empty.INSTANCE, schedulersFactory, channelReplySuggestsInteractor, sendMessageInteractor, suggestShowCounter, suggestClickCounter, suggestCloseCounter, analytics, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ChatAppendCounter provideChatAppendCounter(@NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ChatAppendCounter(analytics, features);
    }

    @Provides
    @NotNull
    @PerFragment
    public final AnalyticsTimer<ChatLoadingResult> provideChatLoadingTimer(@NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ChatLoadingTimer(TimeSource.DEFAULT, analytics, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeeplinkProcessor provideCompositeDeeplinkProcessor$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(CompositeDeeplinkProcessor.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), CompositeDeeplinkProcessor.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (DeeplinkProcessor) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeeplinkProcessorListener provideCompositeDeeplinkProcessorListener$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(CompositeDeeplinkProcessorListener.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), CompositeDeeplinkProcessorListener.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (DeeplinkProcessorListener) viewModel;
    }

    @Provides
    @NotNull
    @ClassKey(CompositeDeeplinkProcessorListener.class)
    @IntoMap
    public final ViewModel provideCompositeDeeplinkProcessorListenerViewModel$messenger_release(@NotNull AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor> abstractDeeplinkProcessorListener, @Named("StrPayoutInitLinkProcessorListener") @NotNull AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> abstractDeeplinkProcessorListener2, @Named("DeliveryPayoutInitLinkProcessorListener") @NotNull AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> abstractDeeplinkProcessorListener3, @Named("DeliveryCourierPayoutInitLinkProcessorListener") @NotNull AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> abstractDeeplinkProcessorListener4, @Named("SafeDealPayoutInitLinkProcessorListener") @NotNull AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> abstractDeeplinkProcessorListener5, @NotNull RequestReviewLinkProcessorListener requestReviewLinkProcessorListener, @NotNull AbstractDeeplinkProcessorListener<DeliveryOrderCancelLinkProcessor> abstractDeeplinkProcessorListener6, @NotNull UpdateFolderTagsLinkProcessorListener updateFolderTagsLinkProcessorListener) {
        Intrinsics.checkNotNullParameter(abstractDeeplinkProcessorListener, "defaultListener");
        Intrinsics.checkNotNullParameter(abstractDeeplinkProcessorListener2, "strPayoutInitLinkProcessorListener");
        Intrinsics.checkNotNullParameter(abstractDeeplinkProcessorListener3, "deliveryPayoutInitLinkProcessorListener");
        Intrinsics.checkNotNullParameter(abstractDeeplinkProcessorListener4, "deliveryCourierPayoutInitLinkProcessorListener");
        Intrinsics.checkNotNullParameter(abstractDeeplinkProcessorListener5, "safedealPayoutInitLinkProcessorListener");
        Intrinsics.checkNotNullParameter(requestReviewLinkProcessorListener, "requestReviewLinkProcessorListener");
        Intrinsics.checkNotNullParameter(abstractDeeplinkProcessorListener6, "deliveryOrderCancelLinkProcessorListener");
        Intrinsics.checkNotNullParameter(updateFolderTagsLinkProcessorListener, "updateFolderTagsLinkProcessorListener");
        return new CompositeDeeplinkProcessorListener(y.setOf((Object[]) new AbstractDeeplinkProcessorListener[]{abstractDeeplinkProcessorListener2, abstractDeeplinkProcessorListener3, abstractDeeplinkProcessorListener4, abstractDeeplinkProcessorListener6, requestReviewLinkProcessorListener, abstractDeeplinkProcessorListener5, updateFolderTagsLinkProcessorListener}), abstractDeeplinkProcessorListener);
    }

    @Provides
    @NotNull
    @ClassKey(CompositeDeeplinkProcessor.class)
    @IntoMap
    public final ViewModel provideCompositeDeeplinkProcessorViewModel$messenger_release(@NotNull DefaultDeeplinkProcessor defaultDeeplinkProcessor, @Named("StrPayoutInitLinkProcessor") @NotNull PayoutInitLinkProcessor payoutInitLinkProcessor, @Named("DeliveryPayoutInitLinkProcessor") @NotNull PayoutInitLinkProcessor payoutInitLinkProcessor2, @Named("DeliveryCourierPayoutInitLinkProcessor") @NotNull PayoutInitLinkProcessor payoutInitLinkProcessor3, @Named("SafeDealPayoutInitLinkProcessor") @NotNull PayoutInitLinkProcessor payoutInitLinkProcessor4, @NotNull DeliveryOrderCancelLinkProcessor deliveryOrderCancelLinkProcessor, @NotNull RequestReviewLinkProcessor requestReviewLinkProcessor, @NotNull DeleteChannelDeeplinkProcessor deleteChannelDeeplinkProcessor, @NotNull UpdateFolderTagsLinkProcessor updateFolderTagsLinkProcessor) {
        Intrinsics.checkNotNullParameter(defaultDeeplinkProcessor, "defaultProcessor");
        Intrinsics.checkNotNullParameter(payoutInitLinkProcessor, "strPayoutInitLinkProcessor");
        Intrinsics.checkNotNullParameter(payoutInitLinkProcessor2, "deliveryPayoutInitLinkProcessor");
        Intrinsics.checkNotNullParameter(payoutInitLinkProcessor3, "deliveryCourierPayoutInitLinkProcessor");
        Intrinsics.checkNotNullParameter(payoutInitLinkProcessor4, "safedealPayoutInitLinkProcessor");
        Intrinsics.checkNotNullParameter(deliveryOrderCancelLinkProcessor, "deliveryOrderCancelLinkProcessor");
        Intrinsics.checkNotNullParameter(requestReviewLinkProcessor, "requestReviewLinkProcessor");
        Intrinsics.checkNotNullParameter(deleteChannelDeeplinkProcessor, "deleteChannelDeeplinkProcessor");
        Intrinsics.checkNotNullParameter(updateFolderTagsLinkProcessor, "updateFolderTagsLinkProcessor");
        return new CompositeDeeplinkProcessor(y.setOf((Object[]) new AbstractDeeplinkProcessor[]{payoutInitLinkProcessor, payoutInitLinkProcessor2, payoutInitLinkProcessor3, deliveryOrderCancelLinkProcessor, payoutInitLinkProcessor4, requestReviewLinkProcessor, deleteChannelDeeplinkProcessor, updateFolderTagsLinkProcessor}), defaultDeeplinkProcessor);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ContextActionsPresenter provideContextActionsPresenter$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(ContextActionsPresenterImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), ContextActionsPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (ContextActionsPresenter) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final DefaultDeeplinkProcessor provideDefaultDeeplinkProcessor$messenger_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        return new DefaultDeeplinkProcessorImpl(deepLinkIntentFactory);
    }

    @Provides
    @NotNull
    @PerFragment
    public final AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor> provideDefaultDeeplinkProcessorListener$messenger_release() {
        return new DefaultDeeplinkProcessorListenerImpl();
    }

    @Provides
    @NotNull
    public final DeleteChannelDeeplinkProcessor provideDeleteChannelDeeplinkProcessor$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(DeleteChannelDeeplinkProcessorImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), DeleteChannelDeeplinkProcessorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (DeleteChannelDeeplinkProcessor) viewModel;
    }

    @Provides
    @Named(PayoutInitLinkProcessorKt.DELIVERY_COURIER_PAYOUT_LINK_PROCESSOR)
    @NotNull
    @PerFragment
    public final PayoutInitLinkProcessor provideDeliveryCourierPayoutInitLinkProcessor$messenger_release(@NotNull DeliveryCourierPayoutInteractor deliveryCourierPayoutInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull Lazy<DeepLinkProcessingListener> lazy, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(deliveryCourierPayoutInteractor, "payoutInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(lazy, "processingListener");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new PayoutInitLinkProcessorImpl(DeliveryCourierPayoutInitLink.class, deliveryCourierPayoutInteractor, schedulersFactory, typedErrorThrowableConverter, activityIntentFactory, resources, lazy);
    }

    @Provides
    @Named(PayoutInitLinkProcessorKt.DELIVERY_COURIER_PAYOUT_LINK_PROCESSOR_LISTENER)
    @NotNull
    @PerFragment
    public final AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> provideDeliveryCourierPayoutInitLinkProcessorListener$messenger_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        return new PayoutInitLinkProcessorListenerImpl(deepLinkIntentFactory, 11);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeliveryCourierPayoutInteractor provideDeliveryCourierPayoutInteractor$messenger_release(@NotNull DeliveryApi deliveryApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(deliveryApi, "deliveryApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        return new DeliveryCourierPayoutInteractor(deliveryApi, schedulersFactory, typedErrorThrowableConverter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeliveryOrderCancelLinkProcessor provideDeliveryOrderCancelLinkProcessor$messenger_release(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        return new DeliveryOrderCancelLinkProcessorImpl(activityIntentFactory);
    }

    @Provides
    @NotNull
    @PerFragment
    public final AbstractDeeplinkProcessorListener<DeliveryOrderCancelLinkProcessor> provideDeliveryOrderCancelLinkProcessorListener$messenger_release(@NotNull DeliveryApi deliveryApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull Lazy<DeepLinkProcessingListener> lazy, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(deliveryApi, "deliveryApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(lazy, "processingListener");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new DeliveryOrderCancelLinkProcessorListenerImpl(deliveryApi, schedulersFactory, typedErrorThrowableConverter, resources, lazy);
    }

    @Provides
    @Named(PayoutInitLinkProcessorKt.DELIVERY_PAYOUT_LINK_PROCESSOR)
    @NotNull
    @PerFragment
    public final PayoutInitLinkProcessor provideDeliveryPayoutInitLinkProcessor$messenger_release(@NotNull DeliveryPayoutInteractor deliveryPayoutInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull Lazy<DeepLinkProcessingListener> lazy, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(deliveryPayoutInteractor, "deliveryPayoutInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(lazy, "processingListener");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new PayoutInitLinkProcessorImpl(DeliveryPayoutInitLink.class, deliveryPayoutInteractor, schedulersFactory, typedErrorThrowableConverter, activityIntentFactory, resources, lazy);
    }

    @Provides
    @Named(PayoutInitLinkProcessorKt.DELIVERY_PAYOUT_LINK_PROCESSOR_LISTENER)
    @NotNull
    @PerFragment
    public final AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> provideDeliveryPayoutInitLinkProcessorListener$messenger_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        return new PayoutInitLinkProcessorListenerImpl(deepLinkIntentFactory, 5);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeliveryPayoutInteractor provideDeliveryPayoutInteractor$messenger_release(@NotNull DeliveryApi deliveryApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(deliveryApi, "deliveryApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        return new DeliveryPayoutInteractor(deliveryApi, schedulersFactory, typedErrorThrowableConverter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final FileMessageClickInteractor provideFileMessageClickInteractor(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(FileMessageClickInteractorImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), FileMessageClickInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (FileMessageClickInteractor) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final MessageMenuPresenter provideMessageActionsMenuPresenter$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(MessageMenuPresenterImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), MessageMenuPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (MessageMenuPresenter) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final MessageAvatarClickListener provideMessageAvatarClickListener(@NotNull MessageListPresenter messageListPresenter) {
        Intrinsics.checkNotNullParameter(messageListPresenter, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return messageListPresenter;
    }

    @Provides
    @PerFragment
    @NotNull
    public final MessageClickListener provideMessageClickListener(@NotNull MessageListPresenter messageListPresenter, @NotNull MessageMenuPresenter messageMenuPresenter) {
        Intrinsics.checkNotNullParameter(messageListPresenter, "messageListPresenter");
        Intrinsics.checkNotNullParameter(messageMenuPresenter, "messageMenuPresenter");
        return new MessageClickListenerImpl(messageListPresenter, messageMenuPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final MessageDateFormatter provideMessageDateFormatter$messenger_release(@NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.messenger_message_date_format_today);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…essage_date_format_today)");
        String string2 = resources.getString(R.string.messenger_message_date_format_week);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…message_date_format_week)");
        String string3 = resources.getString(R.string.messenger_message_date_format_other);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…essage_date_format_other)");
        return new MessageDateFormatter(timeSource, locale, string, string2, string3);
    }

    @Provides
    @SearchMessageId
    @Nullable
    @PerFragment
    public final String provideMessageId(@NotNull ChannelFragment.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return params.getMessageId();
    }

    @Provides
    @PerFragment
    @NotNull
    public final MessageListInteractor provideMessageListInteractor$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(MessageListInteractorImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), MessageListInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (MessageListInteractor) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final MessageListItemConverter provideMessageListItemConverter$messenger_release(@NotNull MessageDateFormatter messageDateFormatter, @NotNull MessageTimeFormatter messageTimeFormatter, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(messageDateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(messageTimeFormatter, "timeFormatter");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new MessageListItemConverterImpl(messageDateFormatter, messageTimeFormatter, ImageKt.toImage(ResourcesKt.getDrawableUri(resources, R.drawable.ic_messenger_avito_avatar_28)));
    }

    @Provides
    @PerFragment
    @NotNull
    public final MessageListPresenter provideMessageListPresenter$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(MessageListPresenterImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), MessageListPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (MessageListPresenter) viewModel;
    }

    @Provides
    @NotNull
    @ClassKey(MessageListPresenterImpl.class)
    @IntoMap
    public final ViewModel provideMessageListPresenterViewModel$messenger_release(@NotNull ChannelFragment.Params params, @NotNull MessageListInteractor messageListInteractor, @NotNull MessageListItemConverter messageListItemConverter, @NotNull ChannelContextInteractor channelContextInteractor, @NotNull ChannelMenuInteractor channelMenuInteractor, @NotNull MessageSpamActionsInteractor messageSpamActionsInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull Resources resources, @NotNull Features features, @NotNull DeepLinkFactory deepLinkFactory, @NotNull DeeplinkProcessor deeplinkProcessor, @NotNull Analytics analytics, @NotNull ChatAppendCounter chatAppendCounter, @NotNull ChannelTracker channelTracker, @NotNull TimeSource timeSource, @NotNull FileDownloadManager fileDownloadManager, @NotNull FileMessageClickInteractor fileMessageClickInteractor, @NotNull MessageEraser messageEraser, @NotNull MissingUsersSyncAgent missingUsersSyncAgent) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(messageListInteractor, "messageListInteractor");
        Intrinsics.checkNotNullParameter(messageListItemConverter, "messageListItemConverter");
        Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
        Intrinsics.checkNotNullParameter(channelMenuInteractor, "channelMenuInteractor");
        Intrinsics.checkNotNullParameter(messageSpamActionsInteractor, "messageSpamActionsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(deeplinkProcessor, "deeplinkProcessor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(chatAppendCounter, "appendCounter");
        Intrinsics.checkNotNullParameter(channelTracker, "channelTracker");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(fileDownloadManager, "fileDownloadManager");
        Intrinsics.checkNotNullParameter(fileMessageClickInteractor, "fileMessageClickInteractor");
        Intrinsics.checkNotNullParameter(messageEraser, "messageEraser");
        Intrinsics.checkNotNullParameter(missingUsersSyncAgent, "missingUsersSyncAgent");
        return new MessageListPresenterImpl(MessageListPresenterImpl.AggregatedState.Companion.getDEFAULT(), new MessageListPresenterImpl.Deps(params.getChannelId(), params.getMessageId(), messageListInteractor, messageListItemConverter, channelContextInteractor, channelMenuInteractor, messageSpamActionsInteractor, deeplinkProcessor, analytics, chatAppendCounter, new SingleLiveEvent(), new SingleLiveEvent(), new SingleLiveEvent(), new SingleLiveEvent(), new SingleLiveEvent(), new SingleLiveEvent(), new SingleLiveEvent(), new SingleLiveEvent(), new ErrorFormatterImpl(resources), new MessengerErrorTracker(analytics), channelTracker, timeSource, fileDownloadManager, missingUsersSyncAgent, features, deepLinkFactory, fileMessageClickInteractor, schedulersFactory));
    }

    @Provides
    @PerFragment
    @NotNull
    public final MessageSpamActionsInteractor provideMessageSpamActionsInteractor$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(MessageSpamActionsInteractorImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), MessageSpamActionsInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (MessageSpamActionsInteractor) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final SpamActionsPresenter.Listener provideMessageSpamActionsListener(@NotNull MessageListPresenter messageListPresenter) {
        Intrinsics.checkNotNullParameter(messageListPresenter, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return messageListPresenter;
    }

    @Provides
    @PerFragment
    @NotNull
    public final MessageTimeFormatter provideMessageTimeFormatter$messenger_release(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new MessageTimeFormatter(locale);
    }

    @Provides
    @NotNull
    @PerFragment
    @MessageList
    public final AdapterPresenter provideMessagesAdapterPresenter(@MessageList @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final NewMessagesPresenter provideNewMessagesPresenter$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(NewMessagesPresenterImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), NewMessagesPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        channelFragment.getLifecycle().addObserver((LifecycleObserver) viewModel);
        return (NewMessagesPresenter) viewModel;
    }

    @Provides
    @NotNull
    @ClassKey(NewMessagesPresenterImpl.class)
    @IntoMap
    public final ViewModel provideNewMessagesPresenterViewModel$messenger_release(@NotNull ChannelFragment.Params params, @NotNull MessageRepo messageRepo, @NotNull ChannelContextInteractor channelContextInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(messageRepo, "repo");
        Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        return new NewMessagesPresenterImpl(params.getChannelId(), messageRepo, timeSource, channelContextInteractor, schedulersFactory, new NewMessagesView.State.Empty(null, 1, null));
    }

    @Provides
    @PerFragment
    @NotNull
    public final OnboardingsInteractor provideOnboardingsInteractor$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(OnboardingsInteractorImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), OnboardingsInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (OnboardingsInteractor) viewModel;
    }

    @Provides
    @NotNull
    @PerFragment
    public final PaginationErrorView.Listener providePaginationErrorViewListener(@NotNull Lazy<MessageListPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        MessageListPresenter messageListPresenter = lazy.get();
        Intrinsics.checkNotNullExpressionValue(messageListPresenter, "listener.get()");
        return messageListPresenter;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhotoInteractor providePhotoInteractor(@NotNull BuildInfo buildInfo, @NotNull Application application) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Looper mainLooper = application.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "application.mainLooper");
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "application.contentResolver");
        return new PhotoInteractorImpl(mainLooper, buildInfo, contentResolver, null, 8, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PlatformActionsCoordinator providePlatformActionsCoordinator(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(PlatformActionsCoordinatorImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), PlatformActionsCoordinatorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (PlatformActionsCoordinator) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final LegacyPlatformActionsPresenter providePlatformActionsPresenter$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(LegacyPlatformActionsPresenterImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), LegacyPlatformActionsPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (LegacyPlatformActionsPresenter) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final RequestReviewLinkProcessor provideRequestReviewLinkProcessor(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(RequestReviewLinkProcessorImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), RequestReviewLinkProcessorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (RequestReviewLinkProcessor) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final RequestReviewLinkProcessorListener provideRequestReviewLinkProcessorListener(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(RequestReviewLinkProcessorListenerImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), RequestReviewLinkProcessorListenerImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (RequestReviewLinkProcessorListener) viewModel;
    }

    @Provides
    @Named(PayoutInitLinkProcessorKt.SAFEDEAL_PAYOUT_LINK_PROCESSOR)
    @NotNull
    @PerFragment
    public final PayoutInitLinkProcessor provideSafeDealPayoutInitLinkProcessor$messenger_release(@NotNull SafeDealPayoutInteractor safeDealPayoutInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull Lazy<DeepLinkProcessingListener> lazy, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(safeDealPayoutInteractor, "payoutInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(lazy, "processingListener");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new PayoutInitLinkProcessorImpl(SafeDealPayoutInitLink.class, safeDealPayoutInteractor, schedulersFactory, typedErrorThrowableConverter, activityIntentFactory, resources, lazy);
    }

    @Provides
    @Named(PayoutInitLinkProcessorKt.SAFEDEAL_PAYOUT_LINK_PROCESSOR_LISTENER)
    @NotNull
    @PerFragment
    public final AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> provideSafeDealPayoutInitLinkProcessorListener$messenger_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        return new PayoutInitLinkProcessorListenerImpl(deepLinkIntentFactory, 13);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SafeDealPayoutInteractor provideSafeDealPayoutInteractor$messenger_release(@NotNull SafeDealApi safeDealApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(safeDealApi, "safedealApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        return new SafeDealPayoutInteractor(safeDealApi, schedulersFactory, typedErrorThrowableConverter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SamplePlatformActionsStateProducer provideSamplePlatformActionsStateProducer(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(SamplePlatformActionsStateProducerImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), SamplePlatformActionsStateProducerImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (SamplePlatformActionsStateProducer) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final SendMessagePresenter provideSendMessagePresenter$messenger_release(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(SendMessagePresenterImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), SendMessagePresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        channelFragment.getLifecycle().addObserver((LifecycleObserver) viewModel);
        return (SendMessagePresenter) viewModel;
    }

    @Provides
    @NotNull
    @ClassKey(SendMessagePresenterImpl.class)
    @IntoMap
    public final ViewModel provideSendMessagePresenterViewModel$messenger_release(@NotNull ChannelFragment.Params params, @NotNull OpenedFrom openedFrom, @NotNull SendMessagePresenter.State state, @NotNull SendMessageInteractor sendMessageInteractor, @NotNull ChannelContextInteractor channelContextInteractor, @NotNull FileAttachmentInteractor fileAttachmentInteractor, @NotNull MessageRepo messageRepo, @NotNull RandomKeyProvider randomKeyProvider, @NotNull Resources resources, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull OnboardingsInteractor onboardingsInteractor, @NotNull DraftRepo draftRepo) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(openedFrom, "openedFrom");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(sendMessageInteractor, "interactor");
        Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
        Intrinsics.checkNotNullParameter(fileAttachmentInteractor, "fileAttachmentInteractor");
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(onboardingsInteractor, "onboardingsInteractor");
        Intrinsics.checkNotNullParameter(draftRepo, "draftRepo");
        return new SendMessagePresenterImpl(sendMessageInteractor, channelContextInteractor, fileAttachmentInteractor, messageRepo, randomKeyProvider, resources, analytics, features, params.getChannelId(), schedulersFactory, state, onboardingsInteractor, openedFrom, draftRepo);
    }

    @Provides
    @Named(PayoutInitLinkProcessorKt.STR_PAYOUT_LINK_PROCESSOR)
    @NotNull
    @PerFragment
    public final PayoutInitLinkProcessor provideStrPayoutInitLinkProcessor$messenger_release(@NotNull StrPayoutInteractor strPayoutInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull Lazy<DeepLinkProcessingListener> lazy, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(strPayoutInteractor, "strPayoutInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(lazy, "processingListener");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new PayoutInitLinkProcessorImpl(StrPayoutInitLink.class, strPayoutInteractor, schedulersFactory, typedErrorThrowableConverter, activityIntentFactory, resources, lazy);
    }

    @Provides
    @Named(PayoutInitLinkProcessorKt.STR_PAYOUT_LINK_PROCESSOR_LISTENER)
    @NotNull
    @PerFragment
    public final AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> provideStrPayoutInitLinkProcessorListener$messenger_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        return new PayoutInitLinkProcessorListenerImpl(deepLinkIntentFactory, 9);
    }

    @Provides
    @PerFragment
    @NotNull
    public final StrPayoutInteractor provideStrPayoutInteractor$messenger_release(@NotNull ShortTermRentApi shortTermRentApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(shortTermRentApi, "shortTermRentApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        return new StrPayoutInteractor(shortTermRentApi, schedulersFactory, typedErrorThrowableConverter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SuggestClickCounter provideSuggestClickCounter(@NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SuggestClickCounter(analytics, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SuggestCloseCounter provideSuggestCloseCounter(@NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SuggestCloseCounter(analytics, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SuggestShowCounter provideSuggestShowCounter(@NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SuggestShowCounter(analytics, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final UpdateFolderTagsLinkProcessor provideUpdateFolderTagsLinkProcessor(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(UpdateFolderTagsLinkProcessorImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), UpdateFolderTagsLinkProcessorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (UpdateFolderTagsLinkProcessor) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final UpdateFolderTagsLinkProcessorListener provideUpdateFolderTagsLinkProcessorListener(@NotNull ChannelFragment channelFragment, @NotNull ChannelFragment.Params params, @NotNull ViewModelFactory viewModelFactory) {
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(a.C2(UpdateFolderTagsLinkProcessorListenerImpl.class, new StringBuilder(), ':', a.w2(channelFragment, "fragment", params, "params", viewModelFactory, "viewModelFactory")), UpdateFolderTagsLinkProcessorListenerImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return (UpdateFolderTagsLinkProcessorListener) viewModel;
    }

    @Provides
    @NotNull
    @PerFragment
    public final Formatter<UserLastActivity> provideUserOnlineStatusFormatter(@NotNull Resources resources, @NotNull TimeSource timeSource, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new UserOnlineStatusFormatter(resources, 150, timeSource, locale);
    }

    @Provides
    @Reusable
    @NotNull
    public final Formatter<Throwable> providerErrorFormatter$messenger_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenDiInjectTracker providesScreenDiInjectTracker$messenger_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, ChannelScreen.INSTANCE, timerFactory, null, 4, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(ChannelScreen.INSTANCE, timerFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenInitTracker providesScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, ChannelScreen.INSTANCE, timerFactory, null, 4, null);
    }
}

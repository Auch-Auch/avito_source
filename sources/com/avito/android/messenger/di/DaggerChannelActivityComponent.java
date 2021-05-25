package com.avito.android.messenger.di;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import androidx.lifecycle.ViewModel;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.groups.PublishReviewFromChatChannelGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.fps.FpsMetricsSupplier;
import com.avito.android.analytics.screens.fps.FpsMetricsTracker;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.messenger.MessageLocalIdGenerator;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.TextToChunkConverter;
import com.avito.android.messenger.analytics.graphite_counter.ChatAppendCounter;
import com.avito.android.messenger.analytics.graphite_counter.ChatLoadingResult;
import com.avito.android.messenger.analytics.graphite_counter.SuggestClickCounter;
import com.avito.android.messenger.analytics.graphite_counter.SuggestCloseCounter;
import com.avito.android.messenger.analytics.graphite_counter.SuggestShowCounter;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.channels.mvi.data.ChannelContextSerializer;
import com.avito.android.messenger.channels.mvi.data.ChannelEntityConverter;
import com.avito.android.messenger.channels.mvi.data.ChannelEntityConverterImpl;
import com.avito.android.messenger.channels.mvi.data.ChannelEntityConverterImpl_Factory;
import com.avito.android.messenger.channels.mvi.data.ChannelPropertySerializer;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoImpl;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoImpl_Factory;
import com.avito.android.messenger.channels.mvi.data.DraftRepoImpl;
import com.avito.android.messenger.channels.mvi.data.DraftRepoImpl_Factory;
import com.avito.android.messenger.channels.mvi.data.UserEntityConverter;
import com.avito.android.messenger.channels.mvi.data.UserEntityConverterImpl;
import com.avito.android.messenger.channels.mvi.data.UserEntityConverterImpl_Factory;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory_Factory;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.ChannelActivityFragment;
import com.avito.android.messenger.conversation.ChannelActivityFragment_MembersInjector;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.ChannelFragment_MembersInjector;
import com.avito.android.messenger.conversation.OpenedFrom;
import com.avito.android.messenger.conversation.adapter.GoogleApiKey;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter_Impl_Factory;
import com.avito.android.messenger.conversation.adapter.MessageAvatarClickListener;
import com.avito.android.messenger.conversation.adapter.MessageClickListener;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter_Impl_Factory;
import com.avito.android.messenger.conversation.adapter.YandexApiKey;
import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageClickListener;
import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessagePresenter;
import com.avito.android.messenger.conversation.adapter.app_call.IncomingAppCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.app_call.OutgoingAppCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.call.CallMessagePresenter;
import com.avito.android.messenger.conversation.adapter.call.IncomingCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.call.OutgoingCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.deleted.DeletedMessagePresenter;
import com.avito.android.messenger.conversation.adapter.deleted.DeletedMessagePresenter_Factory;
import com.avito.android.messenger.conversation.adapter.deleted.IncomingDeletedMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.deleted.IncomingDeletedMessageBlueprint_Factory;
import com.avito.android.messenger.conversation.adapter.deleted.OutgoingDeletedMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.deleted.OutgoingDeletedMessageBlueprint_Factory;
import com.avito.android.messenger.conversation.adapter.file.FileMessagePresenter;
import com.avito.android.messenger.conversation.adapter.file.IncomingFileMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.file.OutgoingFileMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.image.ImageMessagePresenter;
import com.avito.android.messenger.conversation.adapter.image.IncomingImageMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.image.MessagePictureProvider;
import com.avito.android.messenger.conversation.adapter.image.OutgoingImageMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.item.IncomingItemMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.item.ItemMessagePresenter;
import com.avito.android.messenger.conversation.adapter.item.OutgoingItemMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.link.IncomingLinkSnippetMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessagePresenter;
import com.avito.android.messenger.conversation.adapter.link.OutgoingLinkSnippetMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.location.IncomingLocationMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.location.LocationMessagePresenter;
import com.avito.android.messenger.conversation.adapter.location.OutgoingLocationMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.new_messages_divider.NewMessagesDividerBlueprint;
import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorBlueprint;
import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorPresenter;
import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorView;
import com.avito.android.messenger.conversation.adapter.pagination_in_progress.PaginationInProgressBlueprint;
import com.avito.android.messenger.conversation.adapter.pagination_in_progress.PaginationInProgressPresenter;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.geo.PlatformGeoMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.geo.PlatformGeoMessageFromAvitoPresenter;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.image.PlatformImageMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.image.PlatformImageMessageFromAvitoPresenter;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.item.PlatformItemMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.item.PlatformItemMessageFromAvitoPresenter;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.text.PlatformTextMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.text.PlatformTextMessageFromAvitoPresenter;
import com.avito.android.messenger.conversation.adapter.platform.from_user.item.IncomingPlatformItemMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.item.OutgoingPlatformItemMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserPresenter;
import com.avito.android.messenger.conversation.adapter.platform.from_user.text.IncomingPlatformTextMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.text.OutgoingPlatformTextMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserPresenter;
import com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsBlueprint;
import com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsPresenter;
import com.avito.android.messenger.conversation.adapter.system.SystemTextBlueprint;
import com.avito.android.messenger.conversation.adapter.system.SystemTextPresenter;
import com.avito.android.messenger.conversation.adapter.text.IncomingTextMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.text.OutgoingTextMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.text.TextMessagePresenter;
import com.avito.android.messenger.conversation.adapter.typing.TypingIndicatorBlueprint;
import com.avito.android.messenger.conversation.adapter.typing.TypingIndicatorPresenter;
import com.avito.android.messenger.conversation.adapter.unknown.IncomingUnknownMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.unknown.OutgoingUnknownMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.unknown.UnknownMessagePresenter;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.conversation.analytics.ChannelTrackerImpl;
import com.avito.android.messenger.conversation.analytics.ChannelTrackerImpl_Factory;
import com.avito.android.messenger.conversation.formatter.MessageDateFormatter;
import com.avito.android.messenger.conversation.formatter.MessageTimeFormatter;
import com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor;
import com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractorImpl;
import com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenter;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenterImpl;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenterImpl_Factory;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextView;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandler;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandlerImpl;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandlerImpl_Factory;
import com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverter;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverterImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverterImpl_Factory;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoImpl_Factory;
import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.CompositeDeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.CompositeDeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.DefaultDeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.delete_channel.DeleteChannelDeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.delete_channel.DeleteChannelDeeplinkProcessorImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.delete_channel.DeleteChannelDeeplinkProcessorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.DeliveryCourierPayoutInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.DeliveryPayoutInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.SafeDealPayoutInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.StrPayoutInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewInteractorImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorListenerImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorListenerImpl_Factory;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessorImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessorListenerImpl;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessorListenerImpl_Factory;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractor;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractorImpl;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadManager;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadManagerImpl;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadManagerImpl_Factory;
import com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractor;
import com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractorImpl;
import com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadCanceller;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenter;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenterImpl;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenterImpl_Factory;
import com.avito.android.messenger.conversation.mvi.message_menu.MenuElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageContextDataFactory;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageContextDataFactoryImpl;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageContextDataFactoryImpl_Factory;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuCallbacks;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuCallbacksImpl;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuCallbacksImpl_Factory;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenterImpl;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenterImpl_Factory;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.CopyToClipboardElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.CopyToClipboardElementProvider_Factory;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.LinkHintElementProvider_Factory;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.OpenInBrowserElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.OpenInBrowserElementProvider_Factory;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.RetrySendingMessageElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.RetrySendingMessageElementProvider_Factory;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.DeleteLocalMessageElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.DeleteLocalMessageElementProvider_Factory;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.MessageEraser;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.MessageEraserImpl;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.MessageEraserImpl_Factory;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageElementProvider_Factory;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageInteractor;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageInteractorImpl;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.messages.MessageListItemConverter;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenter;
import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenterImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinatorImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinatorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenterImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenterImpl_Factory;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsInteractor;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsInteractorImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenterImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenterImpl_Factory;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListInteractorImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenterImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenterImpl_Factory;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di.ItemsListModule_ProvideAdapterPresenterFactory;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di.ItemsListModule_ProvideItemBinderFactory;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di.ItemsListModule_ProvideItemsListPresenterFactory;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di.ItemsListModule_ProvideItemsListSnippetBlueprintFactory;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di.ItemsListModule_ProvideItemsListSnippetPresenterFactory;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducer;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducerFactory;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducerFactory_Factory;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducerImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducerImpl_Factory;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsInteractor;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenter;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenterImpl;
import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage;
import com.avito.android.messenger.conversation.mvi.send.OnboardingsInteractor;
import com.avito.android.messenger.conversation.mvi.send.OnboardingsInteractorImpl;
import com.avito.android.messenger.conversation.mvi.send.OnboardingsInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.send.PhotoPickerResultHandler;
import com.avito.android.messenger.conversation.mvi.send.PhotoPickerResultHandlerImpl;
import com.avito.android.messenger.conversation.mvi.send.PhotoPickerResultHandlerImpl_Factory;
import com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor;
import com.avito.android.messenger.conversation.mvi.send.SendMessageInteractorImpl;
import com.avito.android.messenger.conversation.mvi.send.SendMessageInteractorImpl_Factory;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent;
import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgent;
import com.avito.android.messenger.di.ChannelActivityComponent;
import com.avito.android.messenger.di.ChannelFragmentComponent;
import com.avito.android.messenger.service.OpenErrorTrackerScheduler;
import com.avito.android.messenger.service.OpenErrorTrackerSchedulerImpl;
import com.avito.android.messenger.service.OpenErrorTrackerSchedulerImpl_Factory;
import com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.permissions.PermissionStorage;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ClipDataFactoryImpl_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.PhoneNumberFormatterModule_ProvideNationalPhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import io.reactivex.Observable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.ChannelDao;
import ru.avito.android.persistence.messenger.ChannelMetaInfoDao;
import ru.avito.android.persistence.messenger.ChannelTagDao;
import ru.avito.android.persistence.messenger.DraftDao;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessageMetaInfoDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.android.persistence.messenger.UserDao;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.MessengerConnection;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.UserLastActivity;
import ru.avito.messenger.config.MessengerConfigProvider;
public final class DaggerChannelActivityComponent implements ChannelActivityComponent {
    public Provider<DraftRepoImpl> A;
    public Provider<Locale> B;
    public Provider<DeepLinkFactory> C;
    public Provider<ScreenTrackerFactory> D;
    public Provider<TimerFactory> E;
    public Provider<MessengerFileUploadCanceller> F;
    public Provider<MissingUsersSyncAgent> G;
    public Provider<DeepLinkIntentFactory> H;
    public Provider<ShortTermRentApi> I;
    public Provider<TypedErrorThrowableConverter> J;
    public Provider<ActivityIntentFactory> K;
    public Provider<DeliveryApi> L;
    public Provider<SafeDealApi> M;
    public Provider<MessageSyncAgent> N;
    public Provider<MessengerConnection> O;
    public Provider<Preferences> P;
    public Provider<AccountStateProvider> Q;
    public Provider<UserLastActivitySyncAgent> R;
    public Provider<ChannelDao> S;
    public Provider<UserDao> T;
    public Provider<ChannelTagDao> U;
    public Provider<ChannelPropertySerializer> V;
    public Provider<ChannelContextSerializer> W;
    public Provider<ChannelSyncAgent> X;
    public Provider<BlockUserInteractor> Y;
    public Provider<MessageEntityConverterImpl> Z;
    public final ChannelActivityDependencies a;
    public Provider<MessageEntityConverter> a0;
    public final ScreenAnalyticsDependencies b;
    public Provider<UserEntityConverterImpl> b0;
    public final Screen c;
    public Provider<UserEntityConverter> c0;
    public Provider<MessengerClient<AvitoMessengerApi>> d;
    public Provider<ChannelEntityConverterImpl> d0;
    public Provider<TextToChunkConverter> e;
    public Provider<ChannelEntityConverter> e0;
    public Provider<BuildInfo> f;
    public Provider<ChannelRepoImpl> f0;
    public Provider<Application> g;
    public Provider<ChannelRepo> g0;
    public Provider<MessengerPhotoStorage> h;
    public Provider<SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup>> h0;
    public Provider<SharedPhotosStorage> i;
    public Provider<BlacklistReasonsProvider> i0;
    public Provider<SchedulersFactory> j;
    public Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> j0;
    public Provider<Analytics> k;
    public Provider<ConnectivityProvider> k0;
    public Provider<MessageLocalIdGenerator> l;
    public Provider<MessengerEntityConverter> l0;
    public Provider<TimeSource> m;
    public Provider<MessageRepoImpl> m0;
    public Provider<MessengerDatabase> n;
    public Provider<MessageRepo> n0;
    public Provider<MessageDao> o;
    public Provider<MessengerConfigProvider> o0;
    public Provider<MessageMetaInfoDao> p = MessengerRepoModule_ProvideMessageMetaInfoDao$messenger_releaseFactory.create(this.n);
    public Provider<RatingApi> p0;
    public Provider<ChannelMetaInfoDao> q = MessengerRepoModule_ProvideChannelMetaInfoDao$messenger_releaseFactory.create(this.n);
    public Provider<PermissionChecker> q0;
    public Provider<MessageBodySerializer> r;
    public Provider<GoogleApiKey> r0;
    public Provider<Context> s;
    public Provider<YandexApiKey> s0;
    public Provider<Features> t;
    public Provider<FileStorageHelper> u;
    public Provider<SchedulersFactory3> v;
    public Provider<RandomKeyProvider> w;
    public Provider<DraftDao> x;
    public Provider<DatabaseErrorHandlerImpl> y;
    public Provider<DatabaseErrorHandler> z;

    public static class a0 implements Provider<MessageLocalIdGenerator> {
        public final ChannelActivityDependencies a;

        public a0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessageLocalIdGenerator get() {
            return (MessageLocalIdGenerator) Preconditions.checkNotNullFromComponent(this.a.messageLocalIdGenerator());
        }
    }

    public static final class b implements ChannelActivityComponent.Builder {
        public ChannelActivityDependencies a;
        public ScreenAnalyticsDependencies b;
        public Screen c;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.di.ChannelActivityComponent.Builder
        public ChannelActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ChannelActivityDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ScreenAnalyticsDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Screen.class);
            return new DaggerChannelActivityComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.messenger.di.ChannelActivityComponent.Builder
        public ChannelActivityComponent.Builder channelActivityDependencies(ChannelActivityDependencies channelActivityDependencies) {
            this.a = (ChannelActivityDependencies) Preconditions.checkNotNull(channelActivityDependencies);
            return this;
        }

        @Override // com.avito.android.messenger.di.ChannelActivityComponent.Builder
        public ChannelActivityComponent.Builder screen(Screen screen) {
            this.c = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.messenger.di.ChannelActivityComponent.Builder
        public ChannelActivityComponent.Builder screenAnalyticsDependencies(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.b = (ScreenAnalyticsDependencies) Preconditions.checkNotNull(screenAnalyticsDependencies);
            return this;
        }
    }

    public static class b0 implements Provider<MessageSyncAgent> {
        public final ChannelActivityDependencies a;

        public b0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessageSyncAgent get() {
            return (MessageSyncAgent) Preconditions.checkNotNullFromComponent(this.a.messageSyncAgent());
        }
    }

    public final class c implements ChannelFragmentComponent.Builder {
        public ChannelFragment a;
        public Resources b;
        public ChannelFragment.Params c;
        public OpenedFrom d;
        public SendMessagePresenter.State e;
        public ChannelContextInteractor.State f;
        public MessageListInteractor.State g;
        public ChannelContextView.State h;
        public PermissionHelper i;

        public c(a aVar) {
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent.Builder
        public ChannelFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ChannelFragment.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, ChannelFragment.Params.class);
            Preconditions.checkBuilderRequirement(this.d, OpenedFrom.class);
            Preconditions.checkBuilderRequirement(this.e, SendMessagePresenter.State.class);
            Preconditions.checkBuilderRequirement(this.f, ChannelContextInteractor.State.class);
            Preconditions.checkBuilderRequirement(this.g, MessageListInteractor.State.class);
            Preconditions.checkBuilderRequirement(this.h, ChannelContextView.State.class);
            Preconditions.checkBuilderRequirement(this.i, PermissionHelper.class);
            return new d(new ChannelFragmentModule(), new MessageAdapterModule(), this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, null);
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent.Builder
        public ChannelFragmentComponent.Builder fragment(ChannelFragment channelFragment) {
            this.a = (ChannelFragment) Preconditions.checkNotNull(channelFragment);
            return this;
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent.Builder
        public ChannelFragmentComponent.Builder openedFrom(OpenedFrom openedFrom) {
            this.d = (OpenedFrom) Preconditions.checkNotNull(openedFrom);
            return this;
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent.Builder
        public ChannelFragmentComponent.Builder params(ChannelFragment.Params params) {
            this.c = (ChannelFragment.Params) Preconditions.checkNotNull(params);
            return this;
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent.Builder
        public ChannelFragmentComponent.Builder permissionHelper(PermissionHelper permissionHelper) {
            this.i = (PermissionHelper) Preconditions.checkNotNull(permissionHelper);
            return this;
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent.Builder
        @Deprecated
        public ChannelFragmentComponent.Builder relativeDateFormatterModule(RelativeDateFormatterModule relativeDateFormatterModule) {
            Preconditions.checkNotNull(relativeDateFormatterModule);
            return this;
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent.Builder
        public ChannelFragmentComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent.Builder
        public ChannelFragmentComponent.Builder state(SendMessagePresenter.State state) {
            this.e = (SendMessagePresenter.State) Preconditions.checkNotNull(state);
            return this;
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent.Builder
        public ChannelFragmentComponent.Builder state(ChannelContextInteractor.State state) {
            this.f = (ChannelContextInteractor.State) Preconditions.checkNotNull(state);
            return this;
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent.Builder
        public ChannelFragmentComponent.Builder state(MessageListInteractor.State state) {
            this.g = (MessageListInteractor.State) Preconditions.checkNotNull(state);
            return this;
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent.Builder
        public ChannelFragmentComponent.Builder state(ChannelContextView.State state) {
            this.h = (ChannelContextView.State) Preconditions.checkNotNull(state);
            return this;
        }
    }

    public static class c0 implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final ChannelActivityDependencies a;

        public c0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public final class d implements ChannelFragmentComponent {
        public Provider<SuggestShowCounter> A;
        public Provider<OnboardingsInteractorImpl> A0;
        public Provider<MessageClickListener> A1;
        public Provider<PlatformGeoMessageFromAvitoBlueprint> A2;
        public Provider<SuggestClickCounter> B;
        public Provider<OpenErrorTrackerSchedulerImpl> B0;
        public Provider<MessageAvatarClickListener> B1;
        public Provider<PlatformImageMessageFromAvitoPresenter> B2;
        public Provider<SuggestCloseCounter> C;
        public Provider<OpenErrorTrackerScheduler> C0;
        public Provider<IncomingMessagePresenter.Impl> C1;
        public Provider<PlatformImageMessageFromAvitoBlueprint> C2;
        public Provider<ViewModel> D;
        public Provider<UserEntityConverterImpl> D0;
        public Provider<IncomingMessagePresenter> D1;
        public Provider<PlatformItemMessageFromAvitoPresenter> D2;
        public Provider<MessageListInteractor> E;
        public Provider<UserEntityConverter> E0;
        public Provider<OutgoingMessagePresenter.Impl> E1;
        public Provider<PlatformItemMessageFromAvitoBlueprint> E2;
        public Provider<MessageDateFormatter> F;
        public Provider<ChannelEntityConverterImpl> F0;
        public Provider<OutgoingMessagePresenter> F1;
        public Provider<PlatformTextMessageFromAvitoPresenter> F2;
        public Provider<MessageTimeFormatter> G;
        public Provider<ChannelEntityConverter> G0;
        public Provider<ItemMessagePresenter> G1;
        public Provider<PlatformTextMessageFromAvitoBlueprint> G2;
        public Provider<MessageListItemConverter> H;
        public Provider<ChannelRepoImpl> H0;
        public Provider<IncomingItemMessageBlueprint> H1;
        public Provider<PlatformTextMessageFromUserPresenter> H2;
        public Provider<ChannelMenuInteractor> I;
        public Provider<ChannelRepo> I0;
        public Provider<OutgoingItemMessageBlueprint> I1;
        public Provider<IncomingPlatformTextMessageFromUserBlueprint> I2;
        public Provider<MessageSpamActionsInteractor> J;
        public Provider<ChannelContextInteractorImpl> J0;
        public Provider<MessagePictureProvider> J1;
        public Provider<OutgoingPlatformTextMessageFromUserBlueprint> J2;
        public Provider<DeeplinkProcessor> K;
        public Provider<ChannelMenuInteractorImpl> K0;
        public Provider<ImageMessagePresenter> K1;
        public Provider<PlatformItemMessageFromUserPresenter> K2;
        public Provider<ChatAppendCounter> L;
        public Provider<Formatter<Throwable>> L0;
        public Provider<IncomingImageMessageBlueprint> L1;
        public Provider<IncomingPlatformItemMessageFromUserBlueprint> L2;
        public Provider<ScreenDiInjectTracker> M;
        public Provider<ChannelMenuPresenterImpl> M0;
        public Provider<OutgoingImageMessageBlueprint> M1;
        public Provider<OutgoingPlatformItemMessageFromUserBlueprint> M2;
        public Provider<ScreenInitTracker> N;
        public Provider<MessageSpamActionsInteractorImpl> N0;
        public Provider<TextMessagePresenter> N1;
        public Provider<ItemBinder> N2;
        public Provider<ScreenFlowTrackerProvider> O;
        public Provider<LegacyPlatformActionsPresenterImpl> O0;
        public Provider<IncomingTextMessageBlueprint> O1;
        public Provider<AdapterPresenter> O2;
        public Provider<ChannelTrackerImpl> P;
        public Provider<LegacyPlatformActionsPresenter> P0;
        public Provider<OutgoingTextMessageBlueprint> P1;
        public Provider<PlatformActionsCoordinator> P2;
        public Provider<ChannelTracker> Q;
        public Provider<ContextActionsInteractorImpl> Q0;
        public Provider<UnknownMessagePresenter> Q1;
        public Provider<ItemsListPresenter> Q2;
        public Provider<FileDownloadManagerImpl> R;
        public Provider<ContextActionsInteractor> R0;
        public Provider<IncomingUnknownMessageBlueprint> R1;
        public Provider<SendMessagePresenter> R2;
        public Provider<FileDownloadManager> S;
        public Provider<ContextActionsPresenterImpl> S0;
        public Provider<OutgoingUnknownMessageBlueprint> S1;
        public Provider<ChannelContextPresenter> S2;
        public Provider<FileMessageClickInteractor> T;
        public Provider<MessageMenuCallbacks> T0;
        public Provider<SystemTextPresenter> T1;
        public Provider<ChannelMenuPresenter> T2;
        public Provider<MessageEraserImpl> U;
        public Provider<CopyToClipboardElementProvider> U0;
        public Provider<SystemTextBlueprint> U1;
        public Provider<ChannelReplySuggestsPresenter> U2;
        public Provider<MessageEraser> V;
        public Provider<OpenInBrowserElementProvider> V0;
        public Provider<NewMessagesDividerBlueprint> V1;
        public Provider<NewMessagesPresenter> V2;
        public Provider<ViewModel> W;
        public Provider<DeleteLocalMessageElementProvider> W0;
        public Provider<PaginationErrorView.Listener> W1;
        public Provider<DeeplinkProcessorListener> W2;
        public Provider<ViewModel> X;
        public Provider<RetrySendingMessageElementProvider> X0;
        public Provider<PaginationErrorPresenter> X1;
        public Provider<DefaultDeeplinkProcessor> Y;
        public Provider<DeleteRemoteMessageInteractorImpl> Y0;
        public Provider<PaginationErrorBlueprint> Y1;
        public Provider<StrPayoutInteractor> Z;
        public Provider<DeleteRemoteMessageInteractor> Z0;
        public Provider<PaginationInProgressPresenter> Z1;
        public final ChannelFragment a;
        public Provider<ContextActionsPresenter> a0;
        public Provider<DeleteRemoteMessageElementProvider> a1;

        /* renamed from: a2  reason: collision with root package name */
        public Provider<PaginationInProgressBlueprint> f56a2;
        public final PermissionHelper b;
        public Provider<PayoutInitLinkProcessor> b0;
        public Provider<List<MenuElementProvider>> b1;
        public Provider<CallMessagePresenter> b2;
        public Provider<ChannelFragment> c;
        public Provider<DeliveryPayoutInteractor> c0;
        public Provider<AttributedTextFormatter> c1;
        public Provider<IncomingCallMessageBlueprint> c2;
        public Provider<ChannelFragment.Params> d;
        public Provider<PayoutInitLinkProcessor> d0;
        public Provider<MessageContextDataFactoryImpl> d1;
        public Provider<OutgoingCallMessageBlueprint> d2;
        public Provider<OpenedFrom> e;
        public Provider<DeliveryCourierPayoutInteractor> e0;
        public Provider<MessageContextDataFactory> e1;
        public Provider<TypingIndicatorPresenter> e2;
        public Provider<SendMessagePresenter.State> f;
        public Provider<PayoutInitLinkProcessor> f0;
        public Provider<MessageMenuPresenterImpl> f1;
        public Provider<TypingIndicatorBlueprint> f2;
        public Provider<String> g;
        public Provider<SafeDealPayoutInteractor> g0;
        public Provider<ChannelContextView.State> g1;
        public Provider<LinkSnippetMessagePresenter> g2;
        public Provider<PhotoInteractor> h;
        public Provider<PayoutInitLinkProcessor> h0;
        public Provider<Formatter<UserLastActivity>> h1;
        public Provider<IncomingLinkSnippetMessageBlueprint> h2;
        public Provider<PhotoPickerResultHandlerImpl> i;
        public Provider<DeliveryOrderCancelLinkProcessor> i0;
        public Provider<ChannelContextPresenterImpl> i1;
        public Provider<OutgoingLinkSnippetMessageBlueprint> i2;
        public Provider<PhotoPickerResultHandler> j;
        public Provider<RequestReviewLinkProcessor> j0;
        public Provider<RequestReviewInteractorImpl> j1;
        public Provider<LocationMessagePresenter> j2;
        public Provider<MessageEntityConverterImpl> k;
        public Provider<DeleteChannelDeeplinkProcessor> k0;
        public Provider<RequestReviewInteractor> k1;
        public Provider<IncomingLocationMessageBlueprint> k2;
        public Provider<MessageEntityConverter> l;
        public Provider<UpdateFolderTagsLinkProcessor> l0;
        public Provider<RequestReviewLinkProcessorImpl> l1;
        public Provider<OutgoingLocationMessageBlueprint> l2;
        public Provider<DatabaseErrorHandlerImpl> m;
        public Provider<ViewModel> m0;
        public Provider<SamplePlatformActionsStateProducer> m1;
        public Provider<FileMessagePresenter> m2;
        public Provider<DatabaseErrorHandler> n;
        public Provider<AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor>> n0;
        public Provider<SamplePlatformActionsStateProducerFactory> n1;
        public Provider<IncomingFileMessageBlueprint> n2;
        public Provider<MessageRepoImpl> o;
        public Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> o0;
        public Provider<PlatformActionsStateProducer.Factory<?>> o1;
        public Provider<OutgoingFileMessageBlueprint> o2;
        public Provider<MessageRepo> p;
        public Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> p0;
        public Provider<Set<PlatformActionsStateProducer.Factory<?>>> p1;
        public Provider<DeletedMessagePresenter> p2;
        public Provider<SendMessageInteractorImpl> q;
        public Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> q0;
        public Provider<PlatformActionsCoordinatorImpl> q1;
        public Provider<IncomingDeletedMessageBlueprint> q2;
        public Provider<SendMessageInteractor> r;
        public Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> r0;
        public Provider<SamplePlatformActionsStateProducerImpl> r1;
        public Provider<OutgoingDeletedMessageBlueprint> r2;
        public Provider<ViewModelFactory> s;
        public Provider<RequestReviewLinkProcessorListener> s0;
        public Provider<UpdateFolderTagsLinkProcessorImpl> s1;
        public Provider<AppCallMessageClickListener> s2;
        public Provider<ChannelContextInteractor> t;
        public Provider<AbstractDeeplinkProcessorListener<DeliveryOrderCancelLinkProcessor>> t0;
        public Provider<FileMessageClickInteractorImpl> t1;
        public Provider<AppCallMessagePresenter> t2;
        public Provider<FileAttachmentInteractorImpl> u;
        public Provider<UpdateFolderTagsLinkProcessorListener> u0;
        public Provider<MessageMenuCallbacksImpl> u1;
        public Provider<IncomingAppCallMessageBlueprint> u2;
        public Provider<FileAttachmentInteractor> v;
        public Provider<ViewModel> v0;
        public Provider<ItemsListInteractorImpl> v1;
        public Provider<OutgoingAppCallMessageBlueprint> v2;
        public Provider<Resources> w;
        public Provider<AnalyticsTimer<ChatLoadingResult>> w0;
        public Provider<ItemsListPresenterImpl> w1;
        public Provider<SpamActionsPresenter.Listener> w2;
        public Provider<OnboardingsInteractor> x;
        public Provider<MessageListInteractor.State> x0;
        public Provider<Map<Class<?>, Provider<ViewModel>>> x1;
        public Provider<SpamActionsPresenter> x2;
        public Provider<ViewModel> y;
        public Provider<MessageListInteractorImpl> y0;
        public Provider<MessageListPresenter> y1;
        public Provider<SpamActionsBlueprint> y2;
        public Provider<ChannelReplySuggestsInteractor> z;
        public Provider<DeleteChannelDeeplinkProcessorImpl> z0 = DeleteChannelDeeplinkProcessorImpl_Factory.create(this.I);
        public Provider<MessageMenuPresenter> z1;
        public Provider<PlatformGeoMessageFromAvitoPresenter> z2;

        public d(ChannelFragmentModule channelFragmentModule, MessageAdapterModule messageAdapterModule, ChannelFragment channelFragment, Resources resources, ChannelFragment.Params params, OpenedFrom openedFrom, SendMessagePresenter.State state, ChannelContextInteractor.State state2, MessageListInteractor.State state3, ChannelContextView.State state4, PermissionHelper permissionHelper, a aVar) {
            this.a = channelFragment;
            this.b = permissionHelper;
            this.c = InstanceFactory.create(channelFragment);
            this.d = InstanceFactory.create(params);
            this.e = InstanceFactory.create(openedFrom);
            this.f = InstanceFactory.create(state);
            this.g = DoubleCheck.provider(ChannelFragmentModule_ProvideChannelIdFactory.create(channelFragmentModule, this.d));
            Provider<PhotoInteractor> provider = DoubleCheck.provider(ChannelFragmentModule_ProvidePhotoInteractorFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.f, DaggerChannelActivityComponent.this.g));
            this.h = provider;
            PhotoPickerResultHandlerImpl_Factory create = PhotoPickerResultHandlerImpl_Factory.create(provider, DaggerChannelActivityComponent.this.h, DaggerChannelActivityComponent.this.i, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.k);
            this.i = create;
            this.j = DoubleCheck.provider(create);
            MessageEntityConverterImpl_Factory create2 = MessageEntityConverterImpl_Factory.create(DaggerChannelActivityComponent.this.r);
            this.k = create2;
            this.l = SingleCheck.provider(create2);
            DatabaseErrorHandlerImpl_Factory create3 = DatabaseErrorHandlerImpl_Factory.create(DaggerChannelActivityComponent.this.s, DaggerChannelActivityComponent.this.n, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.k);
            this.m = create3;
            Provider<DatabaseErrorHandler> provider2 = SingleCheck.provider(create3);
            this.n = provider2;
            MessageRepoImpl_Factory create4 = MessageRepoImpl_Factory.create(DaggerChannelActivityComponent.this.o, DaggerChannelActivityComponent.this.p, DaggerChannelActivityComponent.this.q, this.l, provider2);
            this.o = create4;
            Provider<MessageRepo> provider3 = SingleCheck.provider(create4);
            this.p = provider3;
            SendMessageInteractorImpl_Factory create5 = SendMessageInteractorImpl_Factory.create(this.g, DaggerChannelActivityComponent.this.d, DaggerChannelActivityComponent.this.e, this.j, DaggerChannelActivityComponent.this.l, DaggerChannelActivityComponent.this.m, provider3, DaggerChannelActivityComponent.this.j);
            this.q = create5;
            this.r = DoubleCheck.provider(create5);
            DelegateFactory delegateFactory = new DelegateFactory();
            this.s = delegateFactory;
            this.t = DoubleCheck.provider(ChannelFragmentModule_ProvideChannelContextInteractor$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, delegateFactory, DaggerChannelActivityComponent.this.t));
            FileAttachmentInteractorImpl_Factory create6 = FileAttachmentInteractorImpl_Factory.create(DaggerChannelActivityComponent.this.u, DaggerChannelActivityComponent.this.v);
            this.u = create6;
            this.v = DoubleCheck.provider(create6);
            this.w = InstanceFactory.create(resources);
            Provider<OnboardingsInteractor> provider4 = DoubleCheck.provider(ChannelFragmentModule_ProvideOnboardingsInteractor$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.x = provider4;
            this.y = ChannelFragmentModule_ProvideSendMessagePresenterViewModel$messenger_releaseFactory.create(channelFragmentModule, this.d, this.e, this.f, this.r, this.t, this.v, this.p, DaggerChannelActivityComponent.this.w, this.w, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.t, provider4, DaggerChannelActivityComponent.this.A);
            this.z = DoubleCheck.provider(ChannelFragmentModule_ProvideChannelReplySuggestsInteractor$messenger_releaseFactory.create(channelFragmentModule, this.d, this.t, DaggerChannelActivityComponent.this.d, DaggerChannelActivityComponent.this.j));
            this.A = DoubleCheck.provider(ChannelFragmentModule_ProvideSuggestShowCounterFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.t));
            this.B = DoubleCheck.provider(ChannelFragmentModule_ProvideSuggestClickCounterFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.t));
            Provider<SuggestCloseCounter> provider5 = DoubleCheck.provider(ChannelFragmentModule_ProvideSuggestCloseCounterFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.t));
            this.C = provider5;
            this.D = ChannelFragmentModule_ProvideChannelReplySuggestsPresenterViewModel$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.j, this.z, this.r, this.A, this.B, provider5, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.t);
            this.E = DoubleCheck.provider(ChannelFragmentModule_ProvideMessageListInteractor$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.F = DoubleCheck.provider(ChannelFragmentModule_ProvideMessageDateFormatter$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.m, DaggerChannelActivityComponent.this.B, this.w));
            Provider<MessageTimeFormatter> provider6 = DoubleCheck.provider(ChannelFragmentModule_ProvideMessageTimeFormatter$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.B));
            this.G = provider6;
            this.H = DoubleCheck.provider(ChannelFragmentModule_ProvideMessageListItemConverter$messenger_releaseFactory.create(channelFragmentModule, this.F, provider6, this.w));
            this.I = DoubleCheck.provider(ChannelFragmentModule_ProvideChannelMenuInteractor$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.J = DoubleCheck.provider(ChannelFragmentModule_ProvideMessageSpamActionsInteractor$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.K = DoubleCheck.provider(ChannelFragmentModule_ProvideCompositeDeeplinkProcessor$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.L = DoubleCheck.provider(ChannelFragmentModule_ProvideChatAppendCounterFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.t));
            this.M = DoubleCheck.provider(ChannelFragmentModule_ProvidesScreenDiInjectTracker$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.D, DaggerChannelActivityComponent.this.E));
            this.N = DoubleCheck.provider(ChannelFragmentModule_ProvidesScreenInitTrackerFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.D, DaggerChannelActivityComponent.this.E));
            Provider<ScreenFlowTrackerProvider> provider7 = DoubleCheck.provider(ChannelFragmentModule_ProvidesScreenFlowTrackerProviderFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.D, DaggerChannelActivityComponent.this.E));
            this.O = provider7;
            ChannelTrackerImpl_Factory create7 = ChannelTrackerImpl_Factory.create(this.M, this.N, provider7, DaggerChannelActivityComponent.this.t);
            this.P = create7;
            this.Q = DoubleCheck.provider(create7);
            FileDownloadManagerImpl_Factory create8 = FileDownloadManagerImpl_Factory.create(DaggerChannelActivityComponent.this.s, DaggerChannelActivityComponent.this.v, this.p, DaggerChannelActivityComponent.this.u);
            this.R = create8;
            this.S = SingleCheck.provider(create8);
            this.T = DoubleCheck.provider(ChannelFragmentModule_ProvideFileMessageClickInteractorFactory.create(channelFragmentModule, this.c, this.d, this.s));
            MessageEraserImpl_Factory create9 = MessageEraserImpl_Factory.create(this.p, this.h, DaggerChannelActivityComponent.this.h, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.F);
            this.U = create9;
            Provider<MessageEraser> provider8 = DoubleCheck.provider(create9);
            this.V = provider8;
            this.W = ChannelFragmentModule_ProvideMessageListPresenterViewModel$messenger_releaseFactory.create(channelFragmentModule, this.d, this.E, this.H, this.t, this.I, this.J, DaggerChannelActivityComponent.this.j, this.w, DaggerChannelActivityComponent.this.t, DaggerChannelActivityComponent.this.C, this.K, DaggerChannelActivityComponent.this.k, this.L, this.Q, DaggerChannelActivityComponent.this.m, this.S, this.T, provider8, DaggerChannelActivityComponent.this.G);
            this.X = ChannelFragmentModule_ProvideNewMessagesPresenterViewModel$messenger_releaseFactory.create(channelFragmentModule, this.d, this.p, this.t, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.m);
            this.Y = DoubleCheck.provider(ChannelFragmentModule_ProvideDefaultDeeplinkProcessor$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.H));
            this.Z = DoubleCheck.provider(ChannelFragmentModule_ProvideStrPayoutInteractor$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.I, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.J));
            Provider<ContextActionsPresenter> provider9 = DoubleCheck.provider(ChannelFragmentModule_ProvideContextActionsPresenter$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.a0 = provider9;
            this.b0 = DoubleCheck.provider(ChannelFragmentModule_ProvideStrPayoutInitLinkProcessor$messenger_releaseFactory.create(channelFragmentModule, this.Z, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.J, DaggerChannelActivityComponent.this.K, provider9, this.w));
            Provider<DeliveryPayoutInteractor> provider10 = DoubleCheck.provider(ChannelFragmentModule_ProvideDeliveryPayoutInteractor$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.L, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.J));
            this.c0 = provider10;
            this.d0 = DoubleCheck.provider(ChannelFragmentModule_ProvideDeliveryPayoutInitLinkProcessor$messenger_releaseFactory.create(channelFragmentModule, provider10, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.J, DaggerChannelActivityComponent.this.K, this.a0, this.w));
            Provider<DeliveryCourierPayoutInteractor> provider11 = DoubleCheck.provider(ChannelFragmentModule_ProvideDeliveryCourierPayoutInteractor$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.L, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.J));
            this.e0 = provider11;
            this.f0 = DoubleCheck.provider(ChannelFragmentModule_ProvideDeliveryCourierPayoutInitLinkProcessor$messenger_releaseFactory.create(channelFragmentModule, provider11, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.J, DaggerChannelActivityComponent.this.K, this.a0, this.w));
            Provider<SafeDealPayoutInteractor> provider12 = DoubleCheck.provider(ChannelFragmentModule_ProvideSafeDealPayoutInteractor$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.M, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.J));
            this.g0 = provider12;
            this.h0 = DoubleCheck.provider(ChannelFragmentModule_ProvideSafeDealPayoutInitLinkProcessor$messenger_releaseFactory.create(channelFragmentModule, provider12, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.J, DaggerChannelActivityComponent.this.K, this.a0, this.w));
            this.i0 = DoubleCheck.provider(ChannelFragmentModule_ProvideDeliveryOrderCancelLinkProcessor$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.K));
            this.j0 = DoubleCheck.provider(ChannelFragmentModule_ProvideRequestReviewLinkProcessorFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.k0 = ChannelFragmentModule_ProvideDeleteChannelDeeplinkProcessor$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s);
            Provider<UpdateFolderTagsLinkProcessor> provider13 = DoubleCheck.provider(ChannelFragmentModule_ProvideUpdateFolderTagsLinkProcessorFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.l0 = provider13;
            this.m0 = ChannelFragmentModule_ProvideCompositeDeeplinkProcessorViewModel$messenger_releaseFactory.create(channelFragmentModule, this.Y, this.b0, this.d0, this.f0, this.h0, this.i0, this.j0, this.k0, provider13);
            this.n0 = DoubleCheck.provider(ChannelFragmentModule_ProvideDefaultDeeplinkProcessorListener$messenger_releaseFactory.create(channelFragmentModule));
            this.o0 = DoubleCheck.provider(ChannelFragmentModule_ProvideStrPayoutInitLinkProcessorListener$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.H));
            this.p0 = DoubleCheck.provider(ChannelFragmentModule_ProvideDeliveryPayoutInitLinkProcessorListener$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.H));
            this.q0 = DoubleCheck.provider(ChannelFragmentModule_ProvideDeliveryCourierPayoutInitLinkProcessorListener$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.H));
            this.r0 = DoubleCheck.provider(ChannelFragmentModule_ProvideSafeDealPayoutInitLinkProcessorListener$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.H));
            this.s0 = DoubleCheck.provider(ChannelFragmentModule_ProvideRequestReviewLinkProcessorListenerFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.t0 = DoubleCheck.provider(ChannelFragmentModule_ProvideDeliveryOrderCancelLinkProcessorListener$messenger_releaseFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.L, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.J, this.a0, this.w));
            Provider<UpdateFolderTagsLinkProcessorListener> provider14 = DoubleCheck.provider(ChannelFragmentModule_ProvideUpdateFolderTagsLinkProcessorListenerFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.u0 = provider14;
            this.v0 = ChannelFragmentModule_ProvideCompositeDeeplinkProcessorListenerViewModel$messenger_releaseFactory.create(channelFragmentModule, this.n0, this.o0, this.p0, this.q0, this.r0, this.s0, this.t0, provider14);
            this.w0 = DoubleCheck.provider(ChannelFragmentModule_ProvideChatLoadingTimerFactory.create(channelFragmentModule, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.t));
            Factory create10 = InstanceFactory.create(state3);
            this.x0 = create10;
            this.y0 = MessageListInteractorImpl_Factory.create(this.p, DaggerChannelActivityComponent.this.N, DaggerChannelActivityComponent.this.O, this.w0, DaggerChannelActivityComponent.this.k, this.d, create10, DaggerChannelActivityComponent.this.j);
            this.A0 = OnboardingsInteractorImpl_Factory.create(DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.P);
            OpenErrorTrackerSchedulerImpl_Factory create11 = OpenErrorTrackerSchedulerImpl_Factory.create(DaggerChannelActivityComponent.this.s);
            this.B0 = create11;
            this.C0 = DoubleCheck.provider(create11);
            UserEntityConverterImpl_Factory create12 = UserEntityConverterImpl_Factory.create(DaggerChannelActivityComponent.this.V);
            this.D0 = create12;
            Provider<UserEntityConverter> provider15 = SingleCheck.provider(create12);
            this.E0 = provider15;
            ChannelEntityConverterImpl_Factory create13 = ChannelEntityConverterImpl_Factory.create(this.l, provider15, DaggerChannelActivityComponent.this.W, DaggerChannelActivityComponent.this.V);
            this.F0 = create13;
            Provider<ChannelEntityConverter> provider16 = SingleCheck.provider(create13);
            this.G0 = provider16;
            ChannelRepoImpl_Factory create14 = ChannelRepoImpl_Factory.create(DaggerChannelActivityComponent.this.S, DaggerChannelActivityComponent.this.x, DaggerChannelActivityComponent.this.T, DaggerChannelActivityComponent.this.o, DaggerChannelActivityComponent.this.U, provider16);
            this.H0 = create14;
            Provider<ChannelRepo> provider17 = SingleCheck.provider(create14);
            this.I0 = provider17;
            this.J0 = ChannelContextInteractorImpl_Factory.create(this.g, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.Q, DaggerChannelActivityComponent.this.d, DaggerChannelActivityComponent.this.R, DaggerChannelActivityComponent.this.k, this.C0, this.e, this.Q, provider17, DaggerChannelActivityComponent.this.X);
            this.K0 = ChannelMenuInteractorImpl_Factory.create(DaggerChannelActivityComponent.this.d, DaggerChannelActivityComponent.this.Y, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.j, this.t, DaggerChannelActivityComponent.this.A, DaggerChannelActivityComponent.this.g0, DaggerChannelActivityComponent.this.X, DaggerChannelActivityComponent.this.h0);
            this.L0 = SingleCheck.provider(ChannelFragmentModule_ProviderErrorFormatter$messenger_releaseFactory.create(channelFragmentModule, this.w));
            this.M0 = ChannelMenuPresenterImpl_Factory.create(this.I, DaggerChannelActivityComponent.this.i0, this.K, this.w, PhoneNumberFormatterModule_ProvideNationalPhoneNumberFormatterWithCountryCodeFactory.create(), this.L0, DaggerChannelActivityComponent.this.t, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.j0, DaggerChannelActivityComponent.this.h0);
            this.N0 = MessageSpamActionsInteractorImpl_Factory.create(DaggerChannelActivityComponent.this.Y, this.t, DaggerChannelActivityComponent.this.j);
            this.O0 = LegacyPlatformActionsPresenterImpl_Factory.create(this.t, this.E, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.t);
            this.P0 = DoubleCheck.provider(ChannelFragmentModule_ProvidePlatformActionsPresenter$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            ContextActionsInteractorImpl_Factory create15 = ContextActionsInteractorImpl_Factory.create(DaggerChannelActivityComponent.this.d, DaggerChannelActivityComponent.this.X, this.r);
            this.Q0 = create15;
            Provider<ContextActionsInteractor> provider18 = DoubleCheck.provider(create15);
            this.R0 = provider18;
            this.S0 = ContextActionsPresenterImpl_Factory.create(this.P0, provider18, DaggerChannelActivityComponent.this.C, this.K, DaggerChannelActivityComponent.this.k0, this.w, this.L0, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.j);
            this.T0 = DoubleCheck.provider(MessageMenuModule_ProvideMessageMenuCallbacksFactory.create(this.s, this.c, this.d));
            this.U0 = CopyToClipboardElementProvider_Factory.create(ClipDataFactoryImpl_Factory.create(), DaggerChannelActivityComponent.this.k, this.T0, DaggerChannelActivityComponent.this.e, DaggerChannelActivityComponent.this.t);
            this.V0 = OpenInBrowserElementProvider_Factory.create(this.T0, DaggerChannelActivityComponent.this.k);
            this.W0 = DeleteLocalMessageElementProvider_Factory.create(this.V, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.j, this.T0);
            this.X0 = RetrySendingMessageElementProvider_Factory.create(this.p, DaggerChannelActivityComponent.this.m, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.j, this.T0);
            DeleteRemoteMessageInteractorImpl_Factory create16 = DeleteRemoteMessageInteractorImpl_Factory.create(DaggerChannelActivityComponent.this.d, DaggerChannelActivityComponent.this.l0, DaggerChannelActivityComponent.this.n0);
            this.Y0 = create16;
            Provider<DeleteRemoteMessageInteractor> provider19 = DoubleCheck.provider(create16);
            this.Z0 = provider19;
            this.a1 = DeleteRemoteMessageElementProvider_Factory.create(this.w, this.T0, DaggerChannelActivityComponent.this.m, provider19);
            this.b1 = DoubleCheck.provider(MessageMenuModule_ProvideMessageMenuElementProvidersListFactory.create(this.U0, this.V0, LinkHintElementProvider_Factory.create(), this.W0, this.X0, this.a1));
            Provider<AttributedTextFormatter> provider20 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
            this.c1 = provider20;
            MessageContextDataFactoryImpl_Factory create17 = MessageContextDataFactoryImpl_Factory.create(DaggerChannelActivityComponent.this.s, DaggerChannelActivityComponent.this.t, provider20);
            this.d1 = create17;
            Provider<MessageContextDataFactory> provider21 = DoubleCheck.provider(create17);
            this.e1 = provider21;
            this.f1 = MessageMenuPresenterImpl_Factory.create(this.b1, provider21, DaggerChannelActivityComponent.this.o0, DaggerChannelActivityComponent.this.j);
            this.g1 = InstanceFactory.create(state4);
            Provider<Formatter<UserLastActivity>> provider22 = DoubleCheck.provider(ChannelFragmentModule_ProvideUserOnlineStatusFormatterFactory.create(channelFragmentModule, this.w, DaggerChannelActivityComponent.this.m, DaggerChannelActivityComponent.this.B));
            this.h1 = provider22;
            this.i1 = ChannelContextPresenterImpl_Factory.create(this.g1, DaggerChannelActivityComponent.this.j, this.t, provider22, DaggerChannelActivityComponent.this.k, DaggerChannelActivityComponent.this.C, this.K, this.Q);
            RequestReviewInteractorImpl_Factory create18 = RequestReviewInteractorImpl_Factory.create(DaggerChannelActivityComponent.this.p0);
            this.j1 = create18;
            Provider<RequestReviewInteractor> provider23 = DoubleCheck.provider(create18);
            this.k1 = provider23;
            this.l1 = RequestReviewLinkProcessorImpl_Factory.create(provider23, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.k, this.L0);
            Provider<SamplePlatformActionsStateProducer> provider24 = DoubleCheck.provider(ChannelFragmentModule_ProvideSamplePlatformActionsStateProducerFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.m1 = provider24;
            SamplePlatformActionsStateProducerFactory_Factory create19 = SamplePlatformActionsStateProducerFactory_Factory.create(provider24);
            this.n1 = create19;
            this.o1 = DoubleCheck.provider(create19);
            SetFactory build = SetFactory.builder(1, 0).addProvider(this.o1).build();
            this.p1 = build;
            this.q1 = PlatformActionsCoordinatorImpl_Factory.create(this.t, this.E, DaggerChannelActivityComponent.this.j, DaggerChannelActivityComponent.this.t, build);
            this.r1 = SamplePlatformActionsStateProducerImpl_Factory.create(DaggerChannelActivityComponent.this.j);
            this.s1 = UpdateFolderTagsLinkProcessorImpl_Factory.create(DaggerChannelActivityComponent.this.d, DaggerChannelActivityComponent.this.j, this.L0, DaggerChannelActivityComponent.this.k);
            this.t1 = FileMessageClickInteractorImpl_Factory.create(this.g, DaggerChannelActivityComponent.this.m, DaggerChannelActivityComponent.this.u, this.S, this.V, DaggerChannelActivityComponent.this.q0, DaggerChannelActivityComponent.this.j);
            this.u1 = MessageMenuCallbacksImpl_Factory.create(this.w, DaggerChannelActivityComponent.this.g);
            ItemsListInteractorImpl_Factory create20 = ItemsListInteractorImpl_Factory.create(DaggerChannelActivityComponent.this.d, DaggerChannelActivityComponent.this.j);
            this.v1 = create20;
            this.w1 = ItemsListPresenterImpl_Factory.create(this.P0, DaggerChannelActivityComponent.this.j, create20, DaggerChannelActivityComponent.this.k);
            MapProviderFactory build2 = MapProviderFactory.builder(26).put((MapProviderFactory.Builder) SendMessagePresenterImpl.class, (Provider) this.y).put((MapProviderFactory.Builder) ChannelReplySuggestsPresenterImpl.class, (Provider) this.D).put((MapProviderFactory.Builder) MessageListPresenterImpl.class, (Provider) this.W).put((MapProviderFactory.Builder) NewMessagesPresenterImpl.class, (Provider) this.X).put((MapProviderFactory.Builder) CompositeDeeplinkProcessor.class, (Provider) this.m0).put((MapProviderFactory.Builder) CompositeDeeplinkProcessorListener.class, (Provider) this.v0).put((MapProviderFactory.Builder) MessageListInteractorImpl.class, (Provider) this.y0).put((MapProviderFactory.Builder) DeleteChannelDeeplinkProcessorImpl.class, (Provider) this.z0).put((MapProviderFactory.Builder) OnboardingsInteractorImpl.class, (Provider) this.A0).put((MapProviderFactory.Builder) ChannelContextInteractorImpl.class, (Provider) this.J0).put((MapProviderFactory.Builder) ChannelMenuInteractorImpl.class, (Provider) this.K0).put((MapProviderFactory.Builder) ChannelMenuPresenterImpl.class, (Provider) this.M0).put((MapProviderFactory.Builder) MessageSpamActionsInteractorImpl.class, (Provider) this.N0).put((MapProviderFactory.Builder) LegacyPlatformActionsPresenterImpl.class, (Provider) this.O0).put((MapProviderFactory.Builder) ContextActionsPresenterImpl.class, (Provider) this.S0).put((MapProviderFactory.Builder) MessageMenuPresenterImpl.class, (Provider) this.f1).put((MapProviderFactory.Builder) ChannelContextPresenterImpl.class, (Provider) this.i1).put((MapProviderFactory.Builder) RequestReviewLinkProcessorImpl.class, (Provider) this.l1).put((MapProviderFactory.Builder) RequestReviewLinkProcessorListenerImpl.class, (Provider) RequestReviewLinkProcessorListenerImpl_Factory.create()).put((MapProviderFactory.Builder) PlatformActionsCoordinatorImpl.class, (Provider) this.q1).put((MapProviderFactory.Builder) SamplePlatformActionsStateProducerImpl.class, (Provider) this.r1).put((MapProviderFactory.Builder) UpdateFolderTagsLinkProcessorImpl.class, (Provider) this.s1).put((MapProviderFactory.Builder) UpdateFolderTagsLinkProcessorListenerImpl.class, (Provider) UpdateFolderTagsLinkProcessorListenerImpl_Factory.create()).put((MapProviderFactory.Builder) FileMessageClickInteractorImpl.class, (Provider) this.t1).put((MapProviderFactory.Builder) MessageMenuCallbacksImpl.class, (Provider) this.u1).put((MapProviderFactory.Builder) ItemsListPresenterImpl.class, (Provider) this.w1).build();
            this.x1 = build2;
            DelegateFactory.setDelegate(this.s, SingleCheck.provider(ViewModelFactory_Factory.create(build2)));
            this.y1 = DoubleCheck.provider(ChannelFragmentModule_ProvideMessageListPresenter$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            Provider<MessageMenuPresenter> provider25 = DoubleCheck.provider(ChannelFragmentModule_ProvideMessageActionsMenuPresenter$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.z1 = provider25;
            this.A1 = DoubleCheck.provider(ChannelFragmentModule_ProvideMessageClickListenerFactory.create(channelFragmentModule, this.y1, provider25));
            Provider<MessageAvatarClickListener> provider26 = DoubleCheck.provider(ChannelFragmentModule_ProvideMessageAvatarClickListenerFactory.create(channelFragmentModule, this.y1));
            this.B1 = provider26;
            IncomingMessagePresenter_Impl_Factory create21 = IncomingMessagePresenter_Impl_Factory.create(this.A1, provider26);
            this.C1 = create21;
            this.D1 = DoubleCheck.provider(create21);
            OutgoingMessagePresenter_Impl_Factory create22 = OutgoingMessagePresenter_Impl_Factory.create(this.A1);
            this.E1 = create22;
            Provider<OutgoingMessagePresenter> provider27 = DoubleCheck.provider(create22);
            this.F1 = provider27;
            Provider<ItemMessagePresenter> provider28 = DoubleCheck.provider(MessageAdapterModule_ProvideItemMessagePresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, provider27, DaggerChannelActivityComponent.this.s));
            this.G1 = provider28;
            this.H1 = DoubleCheck.provider(MessageAdapterModule_ProvideIncomingItemMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider28));
            this.I1 = DoubleCheck.provider(MessageAdapterModule_ProvideOutgoingItemMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, this.G1));
            Provider<MessagePictureProvider> provider29 = DoubleCheck.provider(MessageAdapterModule_ProvideMessagePictureProvider$messenger_releaseFactory.create(messageAdapterModule));
            this.J1 = provider29;
            Provider<ImageMessagePresenter> provider30 = DoubleCheck.provider(MessageAdapterModule_ProvideImageMessagePresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.F1, provider29));
            this.K1 = provider30;
            this.L1 = DoubleCheck.provider(MessageAdapterModule_ProvideIncomingImageMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider30));
            this.M1 = DoubleCheck.provider(MessageAdapterModule_ProvideOutgoingImageMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, this.K1));
            Provider<TextMessagePresenter> provider31 = DoubleCheck.provider(MessageAdapterModule_ProvideTextMessagePresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.F1, this.y1, DaggerChannelActivityComponent.this.t));
            this.N1 = provider31;
            this.O1 = DoubleCheck.provider(MessageAdapterModule_ProvideIncomingTextMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider31, DaggerChannelActivityComponent.this.t));
            this.P1 = DoubleCheck.provider(MessageAdapterModule_ProvideOutgoingTextMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, this.N1, DaggerChannelActivityComponent.this.t));
            Provider<UnknownMessagePresenter> provider32 = DoubleCheck.provider(MessageAdapterModule_ProvideUnknownMessagePresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.F1));
            this.Q1 = provider32;
            this.R1 = DoubleCheck.provider(MessageAdapterModule_ProvideIncomingUnknownMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider32));
            this.S1 = DoubleCheck.provider(MessageAdapterModule_ProvideOutgoingUnknownMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, this.Q1));
            Provider<SystemTextPresenter> provider33 = DoubleCheck.provider(MessageAdapterModule_ProvideSystemTextPresenter$messenger_releaseFactory.create(messageAdapterModule));
            this.T1 = provider33;
            this.U1 = DoubleCheck.provider(MessageAdapterModule_ProvideSystemTextBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider33));
            this.V1 = DoubleCheck.provider(MessageAdapterModule_ProvideNewMessagesDividerBlueprint$messenger_releaseFactory.create(messageAdapterModule));
            Provider<PaginationErrorView.Listener> provider34 = DoubleCheck.provider(ChannelFragmentModule_ProvidePaginationErrorViewListenerFactory.create(channelFragmentModule, this.y1));
            this.W1 = provider34;
            Provider<PaginationErrorPresenter> provider35 = DoubleCheck.provider(MessageAdapterModule_ProvidePaginationErrorPresenter$messenger_releaseFactory.create(messageAdapterModule, provider34));
            this.X1 = provider35;
            this.Y1 = DoubleCheck.provider(MessageAdapterModule_ProvidePaginationErrorBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider35));
            Provider<PaginationInProgressPresenter> provider36 = DoubleCheck.provider(MessageAdapterModule_ProvidePaginationInProgressPresenter$messenger_releaseFactory.create(messageAdapterModule));
            this.Z1 = provider36;
            this.f56a2 = DoubleCheck.provider(MessageAdapterModule_ProvidePaginationInProgressBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider36));
            Provider<CallMessagePresenter> provider37 = DoubleCheck.provider(MessageAdapterModule_ProvideCallMessagePresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.F1));
            this.b2 = provider37;
            this.c2 = DoubleCheck.provider(MessageAdapterModule_ProvideIncomingCallMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider37));
            this.d2 = DoubleCheck.provider(MessageAdapterModule_ProvideOutgoingCallMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, this.b2));
            Provider<TypingIndicatorPresenter> provider38 = DoubleCheck.provider(MessageAdapterModule_ProviderTypingIndicatorPresenter$messenger_releaseFactory.create(messageAdapterModule));
            this.e2 = provider38;
            this.f2 = DoubleCheck.provider(MessageAdapterModule_ProvideTypingIndicatorBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider38));
            Provider<LinkSnippetMessagePresenter> provider39 = DoubleCheck.provider(MessageAdapterModule_ProvideLinkSnippetMessagePresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.F1, this.J1));
            this.g2 = provider39;
            this.h2 = DoubleCheck.provider(MessageAdapterModule_ProvideIncomingLinkSnippetMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider39, DaggerChannelActivityComponent.this.t));
            this.i2 = DoubleCheck.provider(MessageAdapterModule_ProvideOutgoingLinkSnippetMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, this.g2, DaggerChannelActivityComponent.this.t));
            Provider<LocationMessagePresenter> provider40 = DoubleCheck.provider(MessageAdapterModule_ProvideLocationMessagePresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.F1, DaggerChannelActivityComponent.this.r0, DaggerChannelActivityComponent.this.s0, DaggerChannelActivityComponent.this.t));
            this.j2 = provider40;
            this.k2 = DoubleCheck.provider(MessageAdapterModule_ProvideIncomingLocationMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider40));
            this.l2 = DoubleCheck.provider(MessageAdapterModule_ProvideOutgoingLocationMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, this.j2));
            Provider<FileMessagePresenter> provider41 = DoubleCheck.provider(MessageAdapterModule_ProvideFileMessagePresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.F1, this.y1));
            this.m2 = provider41;
            this.n2 = DoubleCheck.provider(MessageAdapterModule_ProvideIncomingFileMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider41));
            this.o2 = DoubleCheck.provider(MessageAdapterModule_ProvideOutgoingFileMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, this.m2));
            DeletedMessagePresenter_Factory create23 = DeletedMessagePresenter_Factory.create(this.D1, this.F1);
            this.p2 = create23;
            this.q2 = IncomingDeletedMessageBlueprint_Factory.create(create23);
            this.r2 = OutgoingDeletedMessageBlueprint_Factory.create(this.p2);
            Provider<AppCallMessageClickListener> provider42 = DoubleCheck.provider(ChannelFragmentModule_ProvideAppCallMessageClickListenerFactory.create(channelFragmentModule, this.y1));
            this.s2 = provider42;
            Provider<AppCallMessagePresenter> provider43 = DoubleCheck.provider(MessageAdapterModule_ProvideAppCallMessagePresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.F1, provider42, DaggerChannelActivityComponent.this.t));
            this.t2 = provider43;
            this.u2 = DoubleCheck.provider(MessageAdapterModule_ProvideIncomingAppCallMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider43));
            this.v2 = DoubleCheck.provider(MessageAdapterModule_ProvideOutgoingAppCallMessageBlueprint$messenger_releaseFactory.create(messageAdapterModule, this.t2));
            Provider<SpamActionsPresenter.Listener> provider44 = DoubleCheck.provider(ChannelFragmentModule_ProvideMessageSpamActionsListenerFactory.create(channelFragmentModule, this.y1));
            this.w2 = provider44;
            Provider<SpamActionsPresenter> provider45 = DoubleCheck.provider(MessageAdapterModule_ProvideSpamActionsPresenter$messenger_releaseFactory.create(messageAdapterModule, provider44, DaggerChannelActivityComponent.this.k));
            this.x2 = provider45;
            this.y2 = DoubleCheck.provider(MessageAdapterModule_ProvideSpamActionsBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider45));
            Provider<PlatformGeoMessageFromAvitoPresenter> provider46 = DoubleCheck.provider(MessageAdapterModule_ProvidePlatformGeoMessageFromAvitoPresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, DaggerChannelActivityComponent.this.r0, DaggerChannelActivityComponent.this.s0, DaggerChannelActivityComponent.this.t));
            this.z2 = provider46;
            this.A2 = DoubleCheck.provider(MessageAdapterModule_ProvidePlatformGeoMessageFromAvitoBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider46));
            Provider<PlatformImageMessageFromAvitoPresenter> provider47 = DoubleCheck.provider(MessageAdapterModule_ProvidePlatformImageMessageFromAvitoPresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.J1));
            this.B2 = provider47;
            this.C2 = DoubleCheck.provider(MessageAdapterModule_ProvidePlatformImageMessageFromAvitoBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider47));
            Provider<PlatformItemMessageFromAvitoPresenter> provider48 = DoubleCheck.provider(MessageAdapterModule_ProvidePlatformItemMessageFromAvitoPresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1));
            this.D2 = provider48;
            this.E2 = DoubleCheck.provider(MessageAdapterModule_ProvidePlatformItemMessageFromAvitoBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider48));
            Provider<PlatformTextMessageFromAvitoPresenter> provider49 = DoubleCheck.provider(MessageAdapterModule_ProvidePlatformTextMessageFromAvitoPresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.K, this.c1, this.y1));
            this.F2 = provider49;
            this.G2 = DoubleCheck.provider(MessageAdapterModule_ProvidePlatformTextMessageFromAvitoBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider49));
            Provider<PlatformTextMessageFromUserPresenter> provider50 = DoubleCheck.provider(MessageAdapterModule_ProvidePlatformTextMessageFromUserPresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.F1, this.K, this.y1, this.c1));
            this.H2 = provider50;
            this.I2 = DoubleCheck.provider(MessageAdapterModule_ProvideIncomingPlatformTextMessageFromUserBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider50));
            this.J2 = DoubleCheck.provider(MessageAdapterModule_ProvideOutgoingPlatformTextMessageFromUserBlueprint$messenger_releaseFactory.create(messageAdapterModule, this.H2));
            Provider<PlatformItemMessageFromUserPresenter> provider51 = DoubleCheck.provider(MessageAdapterModule_ProvidePlatformItemMessageFromUserPresenter$messenger_releaseFactory.create(messageAdapterModule, this.D1, this.F1));
            this.K2 = provider51;
            this.L2 = DoubleCheck.provider(MessageAdapterModule_ProvideIncomingPlatformItemMessageFromUserBlueprint$messenger_releaseFactory.create(messageAdapterModule, provider51));
            Provider<OutgoingPlatformItemMessageFromUserBlueprint> provider52 = DoubleCheck.provider(MessageAdapterModule_ProvideOutgoingPlatformItemMessageFromUserBlueprint$messenger_releaseFactory.create(messageAdapterModule, this.K2));
            this.M2 = provider52;
            Provider<ItemBinder> provider53 = DoubleCheck.provider(MessageAdapterModule_ProvideMessageItemBinderFactory.create(messageAdapterModule, this.H1, this.I1, this.L1, this.M1, this.O1, this.P1, this.R1, this.S1, this.U1, this.V1, this.Y1, this.f56a2, this.c2, this.d2, this.f2, this.h2, this.i2, this.k2, this.l2, this.n2, this.o2, this.q2, this.r2, this.u2, this.v2, this.y2, this.A2, this.C2, this.E2, this.G2, this.I2, this.J2, this.L2, provider52));
            this.N2 = provider53;
            this.O2 = DoubleCheck.provider(ChannelFragmentModule_ProvideMessagesAdapterPresenterFactory.create(channelFragmentModule, provider53));
            this.P2 = DoubleCheck.provider(ChannelFragmentModule_ProvidePlatformActionsCoordinatorFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.Q2 = ItemsListModule_ProvideItemsListPresenterFactory.create(this.c, this.s);
            this.R2 = DoubleCheck.provider(ChannelFragmentModule_ProvideSendMessagePresenter$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.S2 = DoubleCheck.provider(ChannelFragmentModule_ProvideChannelContextPresenter$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.T2 = DoubleCheck.provider(ChannelFragmentModule_ProvideChannelMenuPresenter$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.U2 = DoubleCheck.provider(ChannelFragmentModule_ProvideChannelReplySuggestsPresenter$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.V2 = DoubleCheck.provider(ChannelFragmentModule_ProvideNewMessagesPresenter$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
            this.W2 = DoubleCheck.provider(ChannelFragmentModule_ProvideCompositeDeeplinkProcessorListener$messenger_releaseFactory.create(channelFragmentModule, this.c, this.d, this.s));
        }

        @Override // com.avito.android.messenger.di.ChannelFragmentComponent
        public void inject(ChannelFragment channelFragment) {
            ChannelFragment_MembersInjector.injectAnalytics(channelFragment, (Analytics) Preconditions.checkNotNullFromComponent(DaggerChannelActivityComponent.this.a.analytics()));
            ChannelFragment_MembersInjector.injectActivityIntentFactory(channelFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(DaggerChannelActivityComponent.this.a.activityIntentFactory()));
            ChannelFragment_MembersInjector.injectImplicitIntentFactory(channelFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(DaggerChannelActivityComponent.this.a.implicitIntentFactory()));
            ChannelFragment_MembersInjector.injectServiceIntentFactory(channelFragment, (ServiceIntentFactory) Preconditions.checkNotNullFromComponent(DaggerChannelActivityComponent.this.a.serviceIntentFactory()));
            ChannelFragment_MembersInjector.injectDeepLinkIntentFactory(channelFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(DaggerChannelActivityComponent.this.a.deepLinkIntentFactory()));
            ChannelFragment_MembersInjector.injectMessageListAdapterPresenter(channelFragment, this.O2.get());
            ChannelFragment_MembersInjector.injectMessageListItemBinder(channelFragment, this.N2.get());
            ChannelFragment_MembersInjector.injectFeatures(channelFragment, (Features) Preconditions.checkNotNullFromComponent(DaggerChannelActivityComponent.this.a.features()));
            ChannelFragment_MembersInjector.injectMessageListPresenter(channelFragment, this.y1.get());
            ChannelFragment_MembersInjector.injectLegacyPlatformActionsPresenter(channelFragment, this.P0.get());
            ChannelFragment_MembersInjector.injectPlatformActionsCoordinator(channelFragment, this.P2.get());
            ChannelFragment_MembersInjector.injectContextActionsPresenter(channelFragment, this.a0.get());
            ChannelFragment_MembersInjector.injectItemsListAdapterPresenter(channelFragment, ItemsListModule_ProvideAdapterPresenterFactory.provideAdapterPresenter(ItemsListModule_ProvideItemBinderFactory.provideItemBinder(ItemsListModule_ProvideItemsListSnippetBlueprintFactory.provideItemsListSnippetBlueprint(ItemsListModule_ProvideItemsListSnippetPresenterFactory.provideItemsListSnippetPresenter(DoubleCheck.lazy(this.Q2))))));
            ChannelFragment_MembersInjector.injectItemsListItemBinder(channelFragment, ItemsListModule_ProvideItemBinderFactory.provideItemBinder(ItemsListModule_ProvideItemsListSnippetBlueprintFactory.provideItemsListSnippetBlueprint(ItemsListModule_ProvideItemsListSnippetPresenterFactory.provideItemsListSnippetPresenter(DoubleCheck.lazy(this.Q2)))));
            ChannelFragment_MembersInjector.injectItemsListPresenter(channelFragment, ItemsListModule_ProvideItemsListPresenterFactory.provideItemsListPresenter(this.a, this.s.get()));
            ChannelFragment_MembersInjector.injectSendMessagePresenter(channelFragment, this.R2.get());
            ChannelFragment_MembersInjector.injectChannelContextPresenter(channelFragment, this.S2.get());
            ChannelFragment_MembersInjector.injectChannelMenuPresenter(channelFragment, this.T2.get());
            ChannelFragment_MembersInjector.injectChannelReplySuggestsPresenter(channelFragment, this.U2.get());
            ChannelFragment_MembersInjector.injectMessageMenuPresenter(channelFragment, this.z1.get());
            ChannelFragment_MembersInjector.injectMessageMenuCallbacks(channelFragment, this.T0.get());
            ChannelFragment_MembersInjector.injectNewMessagesPresenter(channelFragment, this.V2.get());
            ChannelFragment_MembersInjector.injectConnectivityProvider(channelFragment, (ConnectivityProvider) Preconditions.checkNotNullFromComponent(DaggerChannelActivityComponent.this.a.connectivityProvider()));
            ChannelFragment_MembersInjector.injectDeeplinkProcessor(channelFragment, this.K.get());
            ChannelFragment_MembersInjector.injectDeeplinkProcessorListener(channelFragment, this.W2.get());
            ChannelFragment_MembersInjector.injectBuildInfo(channelFragment, (BuildInfo) Preconditions.checkNotNullFromComponent(DaggerChannelActivityComponent.this.a.buildInfo()));
            ChannelFragment_MembersInjector.injectPerfTracker(channelFragment, this.Q.get());
            ChannelFragment_MembersInjector.injectPermissionHelper(channelFragment, this.b);
            ChannelFragment_MembersInjector.injectPermissionStorage(channelFragment, (PermissionStorage) Preconditions.checkNotNullFromComponent(DaggerChannelActivityComponent.this.a.permissionStorage()));
            DaggerChannelActivityComponent daggerChannelActivityComponent = DaggerChannelActivityComponent.this;
            ChannelFragment_MembersInjector.injectSupplier(channelFragment, new FpsStateSupplier(new FpsMetricsSupplier.Impl((Observable) Preconditions.checkNotNullFromComponent(daggerChannelActivityComponent.b.frameStream()), (FpsMetricsTracker) Preconditions.checkNotNullFromComponent(daggerChannelActivityComponent.b.fpsMetricsTracker()), daggerChannelActivityComponent.c, daggerChannelActivityComponent.b.fpsTrackingThreshold(), (Features) Preconditions.checkNotNullFromComponent(daggerChannelActivityComponent.a.features())), (BuildInfo) Preconditions.checkNotNullFromComponent(DaggerChannelActivityComponent.this.a.buildInfo())));
        }
    }

    public static class d0 implements Provider<MessengerConfigProvider> {
        public final ChannelActivityDependencies a;

        public d0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerConfigProvider get() {
            return (MessengerConfigProvider) Preconditions.checkNotNullFromComponent(this.a.messengerConfigProvider());
        }
    }

    public static class e implements Provider<ScreenTrackerFactory> {
        public final ScreenAnalyticsDependencies a;

        public e(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class e0 implements Provider<MessengerConnection> {
        public final ChannelActivityDependencies a;

        public e0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerConnection get() {
            return (MessengerConnection) Preconditions.checkNotNullFromComponent(this.a.messengerConnection());
        }
    }

    public static class f implements Provider<TimerFactory> {
        public final ScreenAnalyticsDependencies a;

        public f(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class f0 implements Provider<MessengerDatabase> {
        public final ChannelActivityDependencies a;

        public f0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerDatabase get() {
            return (MessengerDatabase) Preconditions.checkNotNullFromComponent(this.a.messengerDatabase());
        }
    }

    public static class g implements Provider<AccountStateProvider> {
        public final ChannelActivityDependencies a;

        public g(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class g0 implements Provider<MessengerEntityConverter> {
        public final ChannelActivityDependencies a;

        public g0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerEntityConverter get() {
            return (MessengerEntityConverter) Preconditions.checkNotNullFromComponent(this.a.messengerEntityConverter());
        }
    }

    public static class h implements Provider<ActivityIntentFactory> {
        public final ChannelActivityDependencies a;

        public h(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ActivityIntentFactory get() {
            return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
        }
    }

    public static class h0 implements Provider<MessengerFileUploadCanceller> {
        public final ChannelActivityDependencies a;

        public h0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerFileUploadCanceller get() {
            return (MessengerFileUploadCanceller) Preconditions.checkNotNullFromComponent(this.a.messengerFileUploadCanceller());
        }
    }

    public static class i implements Provider<Analytics> {
        public final ChannelActivityDependencies a;

        public i(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class i0 implements Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> {
        public final ChannelActivityDependencies a;

        public i0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> get() {
            return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.messengerFolderTabsTestGroup());
        }
    }

    public static class j implements Provider<Application> {
        public final ChannelActivityDependencies a;

        public j(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class j0 implements Provider<MessengerPhotoStorage> {
        public final ChannelActivityDependencies a;

        public j0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerPhotoStorage get() {
            return (MessengerPhotoStorage) Preconditions.checkNotNullFromComponent(this.a.messengerPhotoStorage());
        }
    }

    public static class k implements Provider<BlacklistReasonsProvider> {
        public final ChannelActivityDependencies a;

        public k(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BlacklistReasonsProvider get() {
            return (BlacklistReasonsProvider) Preconditions.checkNotNullFromComponent(this.a.blacklistReasonsProvider());
        }
    }

    public static class k0 implements Provider<MissingUsersSyncAgent> {
        public final ChannelActivityDependencies a;

        public k0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MissingUsersSyncAgent get() {
            return (MissingUsersSyncAgent) Preconditions.checkNotNullFromComponent(this.a.missingUsersSyncAgent());
        }
    }

    public static class l implements Provider<BlockUserInteractor> {
        public final ChannelActivityDependencies a;

        public l(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BlockUserInteractor get() {
            return (BlockUserInteractor) Preconditions.checkNotNullFromComponent(this.a.blockUserInteractor());
        }
    }

    public static class l0 implements Provider<PermissionChecker> {
        public final ChannelActivityDependencies a;

        public l0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PermissionChecker get() {
            return (PermissionChecker) Preconditions.checkNotNullFromComponent(this.a.permissionChecker());
        }
    }

    public static class m implements Provider<BuildInfo> {
        public final ChannelActivityDependencies a;

        public m(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class m0 implements Provider<Preferences> {
        public final ChannelActivityDependencies a;

        public m0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class n implements Provider<ChannelContextSerializer> {
        public final ChannelActivityDependencies a;

        public n(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ChannelContextSerializer get() {
            return (ChannelContextSerializer) Preconditions.checkNotNullFromComponent(this.a.channelContextSerializer());
        }
    }

    public static class n0 implements Provider<SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup>> {
        public final ChannelActivityDependencies a;

        public n0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.publishReviewFromChannelTestGroup());
        }
    }

    public static class o implements Provider<ChannelPropertySerializer> {
        public final ChannelActivityDependencies a;

        public o(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ChannelPropertySerializer get() {
            return (ChannelPropertySerializer) Preconditions.checkNotNullFromComponent(this.a.channelPropertySerializer());
        }
    }

    public static class o0 implements Provider<RandomKeyProvider> {
        public final ChannelActivityDependencies a;

        public o0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class p implements Provider<ChannelSyncAgent> {
        public final ChannelActivityDependencies a;

        public p(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ChannelSyncAgent get() {
            return (ChannelSyncAgent) Preconditions.checkNotNullFromComponent(this.a.channelSyncAgent());
        }
    }

    public static class p0 implements Provider<RatingApi> {
        public final ChannelActivityDependencies a;

        public p0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RatingApi get() {
            return (RatingApi) Preconditions.checkNotNullFromComponent(this.a.ratingApi());
        }
    }

    public static class q implements Provider<ConnectivityProvider> {
        public final ChannelActivityDependencies a;

        public q(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class q0 implements Provider<SafeDealApi> {
        public final ChannelActivityDependencies a;

        public q0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SafeDealApi get() {
            return (SafeDealApi) Preconditions.checkNotNullFromComponent(this.a.safeDealApi());
        }
    }

    public static class r implements Provider<Context> {
        public final ChannelActivityDependencies a;

        public r(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class r0 implements Provider<SchedulersFactory3> {
        public final ChannelActivityDependencies a;

        public r0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class s implements Provider<DeepLinkFactory> {
        public final ChannelActivityDependencies a;

        public s(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class s0 implements Provider<SchedulersFactory> {
        public final ChannelActivityDependencies a;

        public s0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class t implements Provider<DeepLinkIntentFactory> {
        public final ChannelActivityDependencies a;

        public t(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkIntentFactory get() {
            return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory());
        }
    }

    public static class t0 implements Provider<SharedPhotosStorage> {
        public final ChannelActivityDependencies a;

        public t0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SharedPhotosStorage get() {
            return (SharedPhotosStorage) Preconditions.checkNotNullFromComponent(this.a.sharedPhotosStorage());
        }
    }

    public static class u implements Provider<DeliveryApi> {
        public final ChannelActivityDependencies a;

        public u(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeliveryApi get() {
            return (DeliveryApi) Preconditions.checkNotNullFromComponent(this.a.deliveryApi());
        }
    }

    public static class u0 implements Provider<ShortTermRentApi> {
        public final ChannelActivityDependencies a;

        public u0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShortTermRentApi get() {
            return (ShortTermRentApi) Preconditions.checkNotNullFromComponent(this.a.shortTermRentApi());
        }
    }

    public static class v implements Provider<Features> {
        public final ChannelActivityDependencies a;

        public v(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class v0 implements Provider<TextToChunkConverter> {
        public final ChannelActivityDependencies a;

        public v0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TextToChunkConverter get() {
            return (TextToChunkConverter) Preconditions.checkNotNullFromComponent(this.a.textToChunkConverter());
        }
    }

    public static class w implements Provider<FileStorageHelper> {
        public final ChannelActivityDependencies a;

        public w(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FileStorageHelper get() {
            return (FileStorageHelper) Preconditions.checkNotNullFromComponent(this.a.fileStorageHelper());
        }
    }

    public static class w0 implements Provider<TimeSource> {
        public final ChannelActivityDependencies a;

        public w0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class x implements Provider<GoogleApiKey> {
        public final ChannelActivityDependencies a;

        public x(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GoogleApiKey get() {
            return (GoogleApiKey) Preconditions.checkNotNullFromComponent(this.a.googleApiKey());
        }
    }

    public static class x0 implements Provider<TypedErrorThrowableConverter> {
        public final ChannelActivityDependencies a;

        public x0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class y implements Provider<Locale> {
        public final ChannelActivityDependencies a;

        public y(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class y0 implements Provider<UserLastActivitySyncAgent> {
        public final ChannelActivityDependencies a;

        public y0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserLastActivitySyncAgent get() {
            return (UserLastActivitySyncAgent) Preconditions.checkNotNullFromComponent(this.a.userLastActivitySyncAgent());
        }
    }

    public static class z implements Provider<MessageBodySerializer> {
        public final ChannelActivityDependencies a;

        public z(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessageBodySerializer get() {
            return (MessageBodySerializer) Preconditions.checkNotNullFromComponent(this.a.messageBodySerializer());
        }
    }

    public static class z0 implements Provider<YandexApiKey> {
        public final ChannelActivityDependencies a;

        public z0(ChannelActivityDependencies channelActivityDependencies) {
            this.a = channelActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public YandexApiKey get() {
            return (YandexApiKey) Preconditions.checkNotNullFromComponent(this.a.yandexApiKey());
        }
    }

    public DaggerChannelActivityComponent(ChannelActivityDependencies channelActivityDependencies, ScreenAnalyticsDependencies screenAnalyticsDependencies, Screen screen, a aVar) {
        this.a = channelActivityDependencies;
        this.b = screenAnalyticsDependencies;
        this.c = screen;
        this.d = new c0(channelActivityDependencies);
        this.e = new v0(channelActivityDependencies);
        this.f = new m(channelActivityDependencies);
        this.g = new j(channelActivityDependencies);
        this.h = new j0(channelActivityDependencies);
        this.i = new t0(channelActivityDependencies);
        this.j = new s0(channelActivityDependencies);
        this.k = new i(channelActivityDependencies);
        this.l = new a0(channelActivityDependencies);
        this.m = new w0(channelActivityDependencies);
        f0 f0Var = new f0(channelActivityDependencies);
        this.n = f0Var;
        this.o = MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory.create(f0Var);
        this.r = new z(channelActivityDependencies);
        this.s = new r(channelActivityDependencies);
        this.t = new v(channelActivityDependencies);
        this.u = new w(channelActivityDependencies);
        this.v = new r0(channelActivityDependencies);
        this.w = new o0(channelActivityDependencies);
        this.x = MessengerRepoModule_ProvideDraftDao$messenger_releaseFactory.create(this.n);
        DatabaseErrorHandlerImpl_Factory create = DatabaseErrorHandlerImpl_Factory.create(this.s, this.n, this.j, this.k);
        this.y = create;
        Provider<DatabaseErrorHandler> provider = SingleCheck.provider(create);
        this.z = provider;
        this.A = DraftRepoImpl_Factory.create(this.x, provider);
        this.B = new y(channelActivityDependencies);
        this.C = new s(channelActivityDependencies);
        this.D = new e(screenAnalyticsDependencies);
        this.E = new f(screenAnalyticsDependencies);
        this.F = new h0(channelActivityDependencies);
        this.G = new k0(channelActivityDependencies);
        this.H = new t(channelActivityDependencies);
        this.I = new u0(channelActivityDependencies);
        this.J = new x0(channelActivityDependencies);
        this.K = new h(channelActivityDependencies);
        this.L = new u(channelActivityDependencies);
        this.M = new q0(channelActivityDependencies);
        this.N = new b0(channelActivityDependencies);
        this.O = new e0(channelActivityDependencies);
        this.P = new m0(channelActivityDependencies);
        this.Q = new g(channelActivityDependencies);
        this.R = new y0(channelActivityDependencies);
        this.S = MessengerRepoModule_ProvideChannelDao$messenger_releaseFactory.create(this.n);
        this.T = MessengerRepoModule_ProvideUserDao$messenger_releaseFactory.create(this.n);
        this.U = MessengerRepoModule_ProvideChannelTagDao$messenger_releaseFactory.create(this.n);
        this.V = new o(channelActivityDependencies);
        this.W = new n(channelActivityDependencies);
        this.X = new p(channelActivityDependencies);
        this.Y = new l(channelActivityDependencies);
        MessageEntityConverterImpl_Factory create2 = MessageEntityConverterImpl_Factory.create(this.r);
        this.Z = create2;
        this.a0 = SingleCheck.provider(create2);
        UserEntityConverterImpl_Factory create3 = UserEntityConverterImpl_Factory.create(this.V);
        this.b0 = create3;
        Provider<UserEntityConverter> provider2 = SingleCheck.provider(create3);
        this.c0 = provider2;
        ChannelEntityConverterImpl_Factory create4 = ChannelEntityConverterImpl_Factory.create(this.a0, provider2, this.W, this.V);
        this.d0 = create4;
        Provider<ChannelEntityConverter> provider3 = SingleCheck.provider(create4);
        this.e0 = provider3;
        ChannelRepoImpl_Factory create5 = ChannelRepoImpl_Factory.create(this.S, this.x, this.T, this.o, this.U, provider3);
        this.f0 = create5;
        this.g0 = SingleCheck.provider(create5);
        this.h0 = new n0(channelActivityDependencies);
        this.i0 = new k(channelActivityDependencies);
        this.j0 = new i0(channelActivityDependencies);
        this.k0 = new q(channelActivityDependencies);
        this.l0 = new g0(channelActivityDependencies);
        MessageRepoImpl_Factory create6 = MessageRepoImpl_Factory.create(this.o, this.p, this.q, this.a0, this.z);
        this.m0 = create6;
        this.n0 = SingleCheck.provider(create6);
        this.o0 = new d0(channelActivityDependencies);
        this.p0 = new p0(channelActivityDependencies);
        this.q0 = new l0(channelActivityDependencies);
        this.r0 = new x(channelActivityDependencies);
        this.s0 = new z0(channelActivityDependencies);
    }

    public static ChannelActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.di.ChannelActivityComponent
    public ChannelFragmentComponent.Builder channelFragmentComponent() {
        return new c(null);
    }

    @Override // com.avito.android.messenger.di.ChannelActivityComponent
    public void inject(ChannelActivityFragment channelActivityFragment) {
        ChannelActivityFragment_MembersInjector.injectActivityIntentFactory(channelActivityFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ChannelActivityFragment_MembersInjector.injectDeepLinkIntentFactory(channelActivityFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        ChannelActivityFragment_MembersInjector.injectFeatures(channelActivityFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        ChannelActivityFragment_MembersInjector.injectTreeStateIdGenerator(channelActivityFragment, new TreeStateIdGenerator());
        ChannelActivityFragment_MembersInjector.injectServiceIntentFactory(channelActivityFragment, (ServiceIntentFactory) Preconditions.checkNotNullFromComponent(this.a.serviceIntentFactory()));
    }
}

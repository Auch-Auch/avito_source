package com.avito.android.messenger.di;

import android.content.Context;
import android.view.ActionMode;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.PerFragment;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.GoogleApiKey;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.YandexApiKey;
import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageClickListener;
import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessagePresenter;
import com.avito.android.messenger.conversation.adapter.app_call.IncomingAppCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.app_call.OutgoingAppCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.call.CallMessagePresenter;
import com.avito.android.messenger.conversation.adapter.call.IncomingCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.call.OutgoingCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.deleted.IncomingDeletedMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.deleted.OutgoingDeletedMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.file.FileMessageClickListener;
import com.avito.android.messenger.conversation.adapter.file.FileMessagePresenter;
import com.avito.android.messenger.conversation.adapter.file.IncomingFileMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.file.OutgoingFileMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.image.ImageMessagePresenter;
import com.avito.android.messenger.conversation.adapter.image.IncomingImageMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.image.MessagePictureProvider;
import com.avito.android.messenger.conversation.adapter.image.MessagePictureProviderImpl;
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
import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorPresenterImpl;
import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorView;
import com.avito.android.messenger.conversation.adapter.pagination_in_progress.PaginationInProgressBlueprint;
import com.avito.android.messenger.conversation.adapter.pagination_in_progress.PaginationInProgressPresenter;
import com.avito.android.messenger.conversation.adapter.pagination_in_progress.PaginationInProgressPresenterImpl;
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
import com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsPresenterImpl;
import com.avito.android.messenger.conversation.adapter.system.SystemTextBlueprint;
import com.avito.android.messenger.conversation.adapter.system.SystemTextPresenter;
import com.avito.android.messenger.conversation.adapter.system.SystemTextPresenterImpl;
import com.avito.android.messenger.conversation.adapter.text.IncomingTextMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.text.MessageLinkClickListener;
import com.avito.android.messenger.conversation.adapter.text.OutgoingTextMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.text.TextMessagePresenter;
import com.avito.android.messenger.conversation.adapter.typing.TypingIndicatorBlueprint;
import com.avito.android.messenger.conversation.adapter.typing.TypingIndicatorPresenter;
import com.avito.android.messenger.conversation.adapter.unknown.IncomingUnknownMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.unknown.OutgoingUnknownMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.unknown.UnknownMessagePresenter;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0002B\t¢\u0006\u0006\b\u0002\u0010\u0002J/\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010#\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u001cH\u0001¢\u0006\u0004\b!\u0010\"J\u0017\u0010'\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u001cH\u0001¢\u0006\u0004\b%\u0010&J'\u0010-\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b+\u0010,J\u0017\u00101\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020*H\u0001¢\u0006\u0004\b/\u00100J\u0017\u00105\u001a\u0002022\u0006\u0010\u000e\u001a\u00020*H\u0001¢\u0006\u0004\b3\u00104J\u001f\u00109\u001a\u0002062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b7\u00108J\u0017\u0010=\u001a\u00020:2\u0006\u0010\u000e\u001a\u000206H\u0001¢\u0006\u0004\b;\u0010<J\u0017\u0010A\u001a\u00020>2\u0006\u0010\u000e\u001a\u000206H\u0001¢\u0006\u0004\b?\u0010@J\u001f\u0010E\u001a\u00020B2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\bC\u0010DJ\u0017\u0010I\u001a\u00020F2\u0006\u0010\u000e\u001a\u00020BH\u0001¢\u0006\u0004\bG\u0010HJ\u0017\u0010M\u001a\u00020J2\u0006\u0010\u000e\u001a\u00020BH\u0001¢\u0006\u0004\bK\u0010LJ\u000f\u0010Q\u001a\u00020NH\u0001¢\u0006\u0004\bO\u0010PJ\u0017\u0010U\u001a\u00020R2\u0006\u0010\u000e\u001a\u00020NH\u0001¢\u0006\u0004\bS\u0010TJ\u000f\u0010Y\u001a\u00020VH\u0001¢\u0006\u0004\bW\u0010XJ\u000f\u0010]\u001a\u00020ZH\u0001¢\u0006\u0004\b[\u0010\\J\u0017\u0010a\u001a\u00020^2\u0006\u0010\u000e\u001a\u00020ZH\u0001¢\u0006\u0004\b_\u0010`J'\u0010e\u001a\u00020b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0017H\u0001¢\u0006\u0004\bc\u0010dJ\u001f\u0010i\u001a\u00020f2\u0006\u0010\u000e\u001a\u00020b2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\bg\u0010hJ\u001f\u0010m\u001a\u00020j2\u0006\u0010\u000e\u001a\u00020b2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\bk\u0010lJ7\u0010u\u001a\u00020r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010o\u001a\u00020n2\u0006\u0010q\u001a\u00020p2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\bs\u0010tJ\u0017\u0010y\u001a\u00020v2\u0006\u0010\u000e\u001a\u00020rH\u0001¢\u0006\u0004\bw\u0010xJ\u0017\u0010}\u001a\u00020z2\u0006\u0010\u000e\u001a\u00020rH\u0001¢\u0006\u0004\b{\u0010|J+\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u00020~H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u000e\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u000e\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u000e\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J$\u0010\u0001\u001a\u00030\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u000e\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J<\u0010¤\u0001\u001a\u00030¡\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000f\u0010 \u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00012\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001c\u0010¨\u0001\u001a\u00030¥\u00012\u0007\u0010\u000e\u001a\u00030¡\u0001H\u0001¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u001c\u0010¬\u0001\u001a\u00030©\u00012\u0007\u0010\u000e\u001a\u00030¡\u0001H\u0001¢\u0006\u0006\bª\u0001\u0010«\u0001J\u001c\u0010±\u0001\u001a\u00030®\u00012\u0007\u0010\u000e\u001a\u00030­\u0001H\u0001¢\u0006\u0006\b¯\u0001\u0010°\u0001J.\u0010·\u0001\u001a\u00030­\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030²\u00010\u00012\b\u0010´\u0001\u001a\u00030³\u0001H\u0001¢\u0006\u0006\bµ\u0001\u0010¶\u0001J3\u0010»\u0001\u001a\u00030¸\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010o\u001a\u00020n2\u0006\u0010q\u001a\u00020p2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u001c\u0010¿\u0001\u001a\u00030¼\u00012\u0007\u0010\u000e\u001a\u00030¸\u0001H\u0001¢\u0006\u0006\b½\u0001\u0010¾\u0001J#\u0010Ã\u0001\u001a\u00030À\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0017H\u0001¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J\u001c\u0010Ç\u0001\u001a\u00030Ä\u00012\u0007\u0010\u000e\u001a\u00030À\u0001H\u0001¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u001b\u0010Ë\u0001\u001a\u00030È\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u001c\u0010Ï\u0001\u001a\u00030Ì\u00012\u0007\u0010\u000e\u001a\u00030È\u0001H\u0001¢\u0006\u0006\bÍ\u0001\u0010Î\u0001JG\u0010Ù\u0001\u001a\u00030Ö\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000f\u0010Ñ\u0001\u001a\n\u0012\u0005\u0012\u00030Ð\u00010\u00012\b\u0010Ó\u0001\u001a\u00030Ò\u00012\u000f\u0010Õ\u0001\u001a\n\u0012\u0005\u0012\u00030Ô\u00010\u0001H\u0001¢\u0006\u0006\b×\u0001\u0010Ø\u0001J\u001c\u0010Ý\u0001\u001a\u00030Ú\u00012\u0007\u0010\u000e\u001a\u00030Ö\u0001H\u0001¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001JF\u0010á\u0001\u001a\u00030Þ\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000f\u0010Ñ\u0001\u001a\n\u0012\u0005\u0012\u00030Ð\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010Ó\u0001\u001a\u00030Ò\u0001H\u0001¢\u0006\u0006\bß\u0001\u0010à\u0001J\u001c\u0010å\u0001\u001a\u00030â\u00012\u0007\u0010\u000e\u001a\u00030Þ\u0001H\u0001¢\u0006\u0006\bã\u0001\u0010ä\u0001J\u001c\u0010é\u0001\u001a\u00030æ\u00012\u0007\u0010\u000e\u001a\u00030Þ\u0001H\u0001¢\u0006\u0006\bç\u0001\u0010è\u0001J#\u0010í\u0001\u001a\u00030ê\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0006\bë\u0001\u0010ì\u0001J\u001c\u0010ñ\u0001\u001a\u00030î\u00012\u0007\u0010\u000e\u001a\u00030ê\u0001H\u0001¢\u0006\u0006\bï\u0001\u0010ð\u0001J\u001c\u0010õ\u0001\u001a\u00030ò\u00012\u0007\u0010\u000e\u001a\u00030ê\u0001H\u0001¢\u0006\u0006\bó\u0001\u0010ô\u0001JÖ\u0002\u0010\u0002\u001a\u00030\u00022\u0007\u0010ö\u0001\u001a\u00020.2\u0007\u0010÷\u0001\u001a\u0002022\u0007\u0010ø\u0001\u001a\u00020 2\u0007\u0010ù\u0001\u001a\u00020$2\u0007\u0010ú\u0001\u001a\u00020\u000f2\u0007\u0010û\u0001\u001a\u00020\u00132\u0007\u0010ü\u0001\u001a\u00020F2\u0007\u0010ý\u0001\u001a\u00020J2\u0007\u0010þ\u0001\u001a\u00020R2\u0007\u0010ÿ\u0001\u001a\u00020V2\b\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020:2\u0007\u0010\u0002\u001a\u00020>2\u0007\u0010\u0002\u001a\u00020^2\u0007\u0010\u0002\u001a\u00020f2\u0007\u0010\u0002\u001a\u00020j2\u0007\u0010\u0002\u001a\u00020v2\u0007\u0010\u0002\u001a\u00020z2\b\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030¥\u00012\b\u0010\u0002\u001a\u00030©\u00012\b\u0010\u0002\u001a\u00030®\u00012\b\u0010\u0002\u001a\u00030¼\u00012\b\u0010\u0002\u001a\u00030Ä\u00012\b\u0010\u0002\u001a\u00030Ì\u00012\b\u0010\u0002\u001a\u00030Ú\u00012\b\u0010\u0002\u001a\u00030â\u00012\b\u0010\u0002\u001a\u00030æ\u00012\b\u0010\u0002\u001a\u00030î\u00012\b\u0010\u0002\u001a\u00030ò\u0001H\u0007¢\u0006\u0006\b\u0002\u0010\u0002¨\u0006 \u0002"}, d2 = {"Lcom/avito/android/messenger/di/MessageAdapterModule;", "", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "outgoingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/text/MessageLinkClickListener;", "linkClickListener", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/conversation/adapter/text/TextMessagePresenter;", "provideTextMessagePresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/text/MessageLinkClickListener;Lcom/avito/android/Features;)Lcom/avito/android/messenger/conversation/adapter/text/TextMessagePresenter;", "provideTextMessagePresenter", "presenter", "Lcom/avito/android/messenger/conversation/adapter/text/IncomingTextMessageBlueprint;", "provideIncomingTextMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/text/TextMessagePresenter;Lcom/avito/android/Features;)Lcom/avito/android/messenger/conversation/adapter/text/IncomingTextMessageBlueprint;", "provideIncomingTextMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/text/OutgoingTextMessageBlueprint;", "provideOutgoingTextMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/text/TextMessagePresenter;Lcom/avito/android/Features;)Lcom/avito/android/messenger/conversation/adapter/text/OutgoingTextMessageBlueprint;", "provideOutgoingTextMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;", "provideMessagePictureProvider$messenger_release", "()Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;", "provideMessagePictureProvider", "pictureProvider", "Lcom/avito/android/messenger/conversation/adapter/image/ImageMessagePresenter;", "provideImageMessagePresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;)Lcom/avito/android/messenger/conversation/adapter/image/ImageMessagePresenter;", "provideImageMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/image/IncomingImageMessageBlueprint;", "provideIncomingImageMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/image/ImageMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/image/IncomingImageMessageBlueprint;", "provideIncomingImageMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/image/OutgoingImageMessageBlueprint;", "provideOutgoingImageMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/image/ImageMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/image/OutgoingImageMessageBlueprint;", "provideOutgoingImageMessageBlueprint", "Landroid/content/Context;", "context", "Lcom/avito/android/messenger/conversation/adapter/item/ItemMessagePresenter;", "provideItemMessagePresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Landroid/content/Context;)Lcom/avito/android/messenger/conversation/adapter/item/ItemMessagePresenter;", "provideItemMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/item/IncomingItemMessageBlueprint;", "provideIncomingItemMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/item/ItemMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/item/IncomingItemMessageBlueprint;", "provideIncomingItemMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/item/OutgoingItemMessageBlueprint;", "provideOutgoingItemMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/item/ItemMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/item/OutgoingItemMessageBlueprint;", "provideOutgoingItemMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/call/CallMessagePresenter;", "provideCallMessagePresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/call/CallMessagePresenter;", "provideCallMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/call/IncomingCallMessageBlueprint;", "provideIncomingCallMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/call/CallMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/call/IncomingCallMessageBlueprint;", "provideIncomingCallMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/call/OutgoingCallMessageBlueprint;", "provideOutgoingCallMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/call/CallMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/call/OutgoingCallMessageBlueprint;", "provideOutgoingCallMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/unknown/UnknownMessagePresenter;", "provideUnknownMessagePresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/unknown/UnknownMessagePresenter;", "provideUnknownMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/unknown/IncomingUnknownMessageBlueprint;", "provideIncomingUnknownMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/unknown/UnknownMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/unknown/IncomingUnknownMessageBlueprint;", "provideIncomingUnknownMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/unknown/OutgoingUnknownMessageBlueprint;", "provideOutgoingUnknownMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/unknown/UnknownMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/unknown/OutgoingUnknownMessageBlueprint;", "provideOutgoingUnknownMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/system/SystemTextPresenter;", "provideSystemTextPresenter$messenger_release", "()Lcom/avito/android/messenger/conversation/adapter/system/SystemTextPresenter;", "provideSystemTextPresenter", "Lcom/avito/android/messenger/conversation/adapter/system/SystemTextBlueprint;", "provideSystemTextBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/system/SystemTextPresenter;)Lcom/avito/android/messenger/conversation/adapter/system/SystemTextBlueprint;", "provideSystemTextBlueprint", "Lcom/avito/android/messenger/conversation/adapter/new_messages_divider/NewMessagesDividerBlueprint;", "provideNewMessagesDividerBlueprint$messenger_release", "()Lcom/avito/android/messenger/conversation/adapter/new_messages_divider/NewMessagesDividerBlueprint;", "provideNewMessagesDividerBlueprint", "Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorPresenter;", "providerTypingIndicatorPresenter$messenger_release", "()Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorPresenter;", "providerTypingIndicatorPresenter", "Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorBlueprint;", "provideTypingIndicatorBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorPresenter;)Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorBlueprint;", "provideTypingIndicatorBlueprint", "Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessagePresenter;", "provideLinkSnippetMessagePresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;)Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessagePresenter;", "provideLinkSnippetMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/link/IncomingLinkSnippetMessageBlueprint;", "provideIncomingLinkSnippetMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessagePresenter;Lcom/avito/android/Features;)Lcom/avito/android/messenger/conversation/adapter/link/IncomingLinkSnippetMessageBlueprint;", "provideIncomingLinkSnippetMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/link/OutgoingLinkSnippetMessageBlueprint;", "provideOutgoingLinkSnippetMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessagePresenter;Lcom/avito/android/Features;)Lcom/avito/android/messenger/conversation/adapter/link/OutgoingLinkSnippetMessageBlueprint;", "provideOutgoingLinkSnippetMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;", "googleApiKey", "Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;", "yandexApiKey", "Lcom/avito/android/messenger/conversation/adapter/location/LocationMessagePresenter;", "provideLocationMessagePresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;Lcom/avito/android/Features;)Lcom/avito/android/messenger/conversation/adapter/location/LocationMessagePresenter;", "provideLocationMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/location/IncomingLocationMessageBlueprint;", "provideIncomingLocationMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/location/LocationMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/location/IncomingLocationMessageBlueprint;", "provideIncomingLocationMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/location/OutgoingLocationMessageBlueprint;", "provideOutgoingLocationMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/location/LocationMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/location/OutgoingLocationMessageBlueprint;", "provideOutgoingLocationMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageClickListener;", "fileMessageClickListener", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessagePresenter;", "provideFileMessagePresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/file/FileMessageClickListener;)Lcom/avito/android/messenger/conversation/adapter/file/FileMessagePresenter;", "provideFileMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/file/IncomingFileMessageBlueprint;", "provideIncomingFileMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/file/FileMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/file/IncomingFileMessageBlueprint;", "provideIncomingFileMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/file/OutgoingFileMessageBlueprint;", "provideOutgoingFileMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/file/FileMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/file/OutgoingFileMessageBlueprint;", "provideOutgoingFileMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorPresenter;", "Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorBlueprint;", "providePaginationErrorBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorPresenter;)Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorBlueprint;", "providePaginationErrorBlueprint", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "providePaginationErrorPresenter$messenger_release", "(Ldagger/Lazy;)Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorPresenter;", "providePaginationErrorPresenter", "Lcom/avito/android/messenger/conversation/adapter/pagination_in_progress/PaginationInProgressPresenter;", "Lcom/avito/android/messenger/conversation/adapter/pagination_in_progress/PaginationInProgressBlueprint;", "providePaginationInProgressBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/pagination_in_progress/PaginationInProgressPresenter;)Lcom/avito/android/messenger/conversation/adapter/pagination_in_progress/PaginationInProgressBlueprint;", "providePaginationInProgressBlueprint", "providePaginationInProgressPresenter$messenger_release", "()Lcom/avito/android/messenger/conversation/adapter/pagination_in_progress/PaginationInProgressPresenter;", "providePaginationInProgressPresenter", "Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessageClickListener;", "clickListener", "Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessagePresenter;", "provideAppCallMessagePresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Ldagger/Lazy;Lcom/avito/android/Features;)Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessagePresenter;", "provideAppCallMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/app_call/IncomingAppCallMessageBlueprint;", "provideIncomingAppCallMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/app_call/IncomingAppCallMessageBlueprint;", "provideIncomingAppCallMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/app_call/OutgoingAppCallMessageBlueprint;", "provideOutgoingAppCallMessageBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/app_call/OutgoingAppCallMessageBlueprint;", "provideOutgoingAppCallMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenter;", "Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsBlueprint;", "provideSpamActionsBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenter;)Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsBlueprint;", "provideSpamActionsBlueprint", "Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenter$Listener;", "Lcom/avito/android/analytics/Analytics;", "analytics", "provideSpamActionsPresenter$messenger_release", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenter;", "provideSpamActionsPresenter", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoPresenter;", "providePlatformGeoMessageFromAvitoPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;Lcom/avito/android/Features;)Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoPresenter;", "providePlatformGeoMessageFromAvitoPresenter", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoBlueprint;", "providePlatformGeoMessageFromAvitoBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoPresenter;)Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoBlueprint;", "providePlatformGeoMessageFromAvitoBlueprint", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoPresenter;", "providePlatformImageMessageFromAvitoPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;)Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoPresenter;", "providePlatformImageMessageFromAvitoPresenter", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoBlueprint;", "providePlatformImageMessageFromAvitoBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoPresenter;)Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoBlueprint;", "providePlatformImageMessageFromAvitoBlueprint", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoPresenter;", "providePlatformItemMessageFromAvitoPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoPresenter;", "providePlatformItemMessageFromAvitoPresenter", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoBlueprint;", "providePlatformItemMessageFromAvitoBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoPresenter;)Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoBlueprint;", "providePlatformItemMessageFromAvitoBlueprint", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "deeplinkProcessor", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/view/ActionMode$Callback;", "actionModeCallback", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoPresenter;", "providePlatformTextMessageFromAvitoPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Ldagger/Lazy;Lcom/avito/android/util/text/AttributedTextFormatter;Ldagger/Lazy;)Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoPresenter;", "providePlatformTextMessageFromAvitoPresenter", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoBlueprint;", "providePlatformTextMessageFromAvitoBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoPresenter;)Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoBlueprint;", "providePlatformTextMessageFromAvitoBlueprint", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserPresenter;", "providePlatformTextMessageFromUserPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Ldagger/Lazy;Lcom/avito/android/messenger/conversation/adapter/text/MessageLinkClickListener;Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserPresenter;", "providePlatformTextMessageFromUserPresenter", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/IncomingPlatformTextMessageFromUserBlueprint;", "provideIncomingPlatformTextMessageFromUserBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserPresenter;)Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/IncomingPlatformTextMessageFromUserBlueprint;", "provideIncomingPlatformTextMessageFromUserBlueprint", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/OutgoingPlatformTextMessageFromUserBlueprint;", "provideOutgoingPlatformTextMessageFromUserBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserPresenter;)Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/OutgoingPlatformTextMessageFromUserBlueprint;", "provideOutgoingPlatformTextMessageFromUserBlueprint", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/PlatformItemMessageFromUserPresenter;", "providePlatformItemMessageFromUserPresenter$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;)Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/PlatformItemMessageFromUserPresenter;", "providePlatformItemMessageFromUserPresenter", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/IncomingPlatformItemMessageFromUserBlueprint;", "provideIncomingPlatformItemMessageFromUserBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/PlatformItemMessageFromUserPresenter;)Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/IncomingPlatformItemMessageFromUserBlueprint;", "provideIncomingPlatformItemMessageFromUserBlueprint", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/OutgoingPlatformItemMessageFromUserBlueprint;", "provideOutgoingPlatformItemMessageFromUserBlueprint$messenger_release", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/PlatformItemMessageFromUserPresenter;)Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/OutgoingPlatformItemMessageFromUserBlueprint;", "provideOutgoingPlatformItemMessageFromUserBlueprint", "incomingItemMessageBlueprint", "outgoingItemMessageBlueprint", "incomingImageMessageBlueprint", "outgoingImageMessageBlueprint", "incomingTextMessageBlueprint", "outgoingTextMessageBlueprint", "incomingUnknownMessageBlueprint", "outgoingUnknownMessageBlueprint", "systemTextBlueprint", "metadataBlueprint", "paginationErrorBlueprint", "paginationInProgressBlueprint", "incomingCallMessageBlueprint", "outgoingCallMessageBlueprint", "typingIndicatorBlueprint", "incomingLinkSnippetMessageBlueprint", "outgoingLinkSnippetMessageBlueprint", "incomingLocationMessageBlueprint", "outgoingLocationMessageBlueprint", "incomingFileMessageBlueprint", "outgoingFileMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/deleted/IncomingDeletedMessageBlueprint;", "incomingDeletedMessageBlueprint", "Lcom/avito/android/messenger/conversation/adapter/deleted/OutgoingDeletedMessageBlueprint;", "outgoingDeletedMessageBlueprint", "incomingAppCallMessageBlueprint", "outgoingAppCallMessageBlueprint", "spamActionsBlueprint", "platformGeoMessageFromAvitoBlueprint", "platformImageMessageFromAvitoBlueprint", "platformItemMessageFromAvitoBlueprint", "platformTextMessageFromAvitoBlueprint", "incomingPlatformTextMessageFromUserBlueprint", "outgoingPlatformTextMessageFromUserBlueprint", "incomingPlatformItemMessageFromUserBlueprint", "outgoingPlatformItemMessageFromUserBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideMessageItemBinder", "(Lcom/avito/android/messenger/conversation/adapter/item/IncomingItemMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/item/OutgoingItemMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/image/IncomingImageMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/image/OutgoingImageMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/text/IncomingTextMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/text/OutgoingTextMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/unknown/IncomingUnknownMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/unknown/OutgoingUnknownMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/system/SystemTextBlueprint;Lcom/avito/android/messenger/conversation/adapter/new_messages_divider/NewMessagesDividerBlueprint;Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorBlueprint;Lcom/avito/android/messenger/conversation/adapter/pagination_in_progress/PaginationInProgressBlueprint;Lcom/avito/android/messenger/conversation/adapter/call/IncomingCallMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/call/OutgoingCallMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/typing/TypingIndicatorBlueprint;Lcom/avito/android/messenger/conversation/adapter/link/IncomingLinkSnippetMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/link/OutgoingLinkSnippetMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/location/IncomingLocationMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/location/OutgoingLocationMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/file/IncomingFileMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/file/OutgoingFileMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/deleted/IncomingDeletedMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/deleted/OutgoingDeletedMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/app_call/IncomingAppCallMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/app_call/OutgoingAppCallMessageBlueprint;Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsBlueprint;Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoBlueprint;Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoBlueprint;Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoBlueprint;Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoBlueprint;Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/IncomingPlatformTextMessageFromUserBlueprint;Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/OutgoingPlatformTextMessageFromUserBlueprint;Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/IncomingPlatformItemMessageFromUserBlueprint;Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/OutgoingPlatformItemMessageFromUserBlueprint;)Lcom/avito/konveyor/ItemBinder;", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AttributedTextFormatterModule.class})
public final class MessageAdapterModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/di/MessageAdapterModule$Declarations;", "", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter$Impl;", "impl", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "bindIncomingMessagePresenter", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter$Impl;)Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter$Impl;", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "bindOutgoingMessagePresenter", "(Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter$Impl;)Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        IncomingMessagePresenter bindIncomingMessagePresenter(@NotNull IncomingMessagePresenter.Impl impl);

        @PerFragment
        @Binds
        @NotNull
        OutgoingMessagePresenter bindOutgoingMessagePresenter(@NotNull OutgoingMessagePresenter.Impl impl);
    }

    @Provides
    @NotNull
    @PerFragment
    public final AppCallMessagePresenter provideAppCallMessagePresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull Lazy<AppCallMessageClickListener> lazy, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(lazy, "clickListener");
        Intrinsics.checkNotNullParameter(features, "features");
        return new AppCallMessagePresenter(incomingMessagePresenter, outgoingMessagePresenter, lazy, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final CallMessagePresenter provideCallMessagePresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        return new CallMessagePresenter(incomingMessagePresenter, outgoingMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final FileMessagePresenter provideFileMessagePresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull FileMessageClickListener fileMessageClickListener) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(fileMessageClickListener, "fileMessageClickListener");
        return new FileMessagePresenter(incomingMessagePresenter, outgoingMessagePresenter, fileMessageClickListener);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ImageMessagePresenter provideImageMessagePresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull MessagePictureProvider messagePictureProvider) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(messagePictureProvider, "pictureProvider");
        return new ImageMessagePresenter(incomingMessagePresenter, outgoingMessagePresenter, messagePictureProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final IncomingAppCallMessageBlueprint provideIncomingAppCallMessageBlueprint$messenger_release(@NotNull AppCallMessagePresenter appCallMessagePresenter) {
        Intrinsics.checkNotNullParameter(appCallMessagePresenter, "presenter");
        return new IncomingAppCallMessageBlueprint(appCallMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final IncomingCallMessageBlueprint provideIncomingCallMessageBlueprint$messenger_release(@NotNull CallMessagePresenter callMessagePresenter) {
        Intrinsics.checkNotNullParameter(callMessagePresenter, "presenter");
        return new IncomingCallMessageBlueprint(callMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final IncomingFileMessageBlueprint provideIncomingFileMessageBlueprint$messenger_release(@NotNull FileMessagePresenter fileMessagePresenter) {
        Intrinsics.checkNotNullParameter(fileMessagePresenter, "presenter");
        return new IncomingFileMessageBlueprint(fileMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final IncomingImageMessageBlueprint provideIncomingImageMessageBlueprint$messenger_release(@NotNull ImageMessagePresenter imageMessagePresenter) {
        Intrinsics.checkNotNullParameter(imageMessagePresenter, "presenter");
        return new IncomingImageMessageBlueprint(imageMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final IncomingItemMessageBlueprint provideIncomingItemMessageBlueprint$messenger_release(@NotNull ItemMessagePresenter itemMessagePresenter) {
        Intrinsics.checkNotNullParameter(itemMessagePresenter, "presenter");
        return new IncomingItemMessageBlueprint(itemMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final IncomingLinkSnippetMessageBlueprint provideIncomingLinkSnippetMessageBlueprint$messenger_release(@NotNull LinkSnippetMessagePresenter linkSnippetMessagePresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(linkSnippetMessagePresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new IncomingLinkSnippetMessageBlueprint(linkSnippetMessagePresenter, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final IncomingLocationMessageBlueprint provideIncomingLocationMessageBlueprint$messenger_release(@NotNull LocationMessagePresenter locationMessagePresenter) {
        Intrinsics.checkNotNullParameter(locationMessagePresenter, "presenter");
        return new IncomingLocationMessageBlueprint(locationMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final IncomingPlatformItemMessageFromUserBlueprint provideIncomingPlatformItemMessageFromUserBlueprint$messenger_release(@NotNull PlatformItemMessageFromUserPresenter platformItemMessageFromUserPresenter) {
        Intrinsics.checkNotNullParameter(platformItemMessageFromUserPresenter, "presenter");
        return new IncomingPlatformItemMessageFromUserBlueprint(platformItemMessageFromUserPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final IncomingPlatformTextMessageFromUserBlueprint provideIncomingPlatformTextMessageFromUserBlueprint$messenger_release(@NotNull PlatformTextMessageFromUserPresenter platformTextMessageFromUserPresenter) {
        Intrinsics.checkNotNullParameter(platformTextMessageFromUserPresenter, "presenter");
        return new IncomingPlatformTextMessageFromUserBlueprint(platformTextMessageFromUserPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final IncomingTextMessageBlueprint provideIncomingTextMessageBlueprint$messenger_release(@NotNull TextMessagePresenter textMessagePresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(textMessagePresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new IncomingTextMessageBlueprint(textMessagePresenter, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final IncomingUnknownMessageBlueprint provideIncomingUnknownMessageBlueprint$messenger_release(@NotNull UnknownMessagePresenter unknownMessagePresenter) {
        Intrinsics.checkNotNullParameter(unknownMessagePresenter, "presenter");
        return new IncomingUnknownMessageBlueprint(unknownMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemMessagePresenter provideItemMessagePresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.message_body_description_item);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ge_body_description_item)");
        String string2 = context.getString(R.string.messenger_item_body_not_loaded_description);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…y_not_loaded_description)");
        return new ItemMessagePresenter(incomingMessagePresenter, outgoingMessagePresenter, string, string2);
    }

    @Provides
    @PerFragment
    @NotNull
    public final LinkSnippetMessagePresenter provideLinkSnippetMessagePresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull MessagePictureProvider messagePictureProvider) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(messagePictureProvider, "pictureProvider");
        return new LinkSnippetMessagePresenter(incomingMessagePresenter, outgoingMessagePresenter, messagePictureProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final LocationMessagePresenter provideLocationMessagePresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull GoogleApiKey googleApiKey, @NotNull YandexApiKey yandexApiKey, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(googleApiKey, "googleApiKey");
        Intrinsics.checkNotNullParameter(yandexApiKey, "yandexApiKey");
        Intrinsics.checkNotNullParameter(features, "features");
        return new LocationMessagePresenter(incomingMessagePresenter, outgoingMessagePresenter, googleApiKey, yandexApiKey, features);
    }

    @Provides
    @NotNull
    @PerFragment
    @MessageList
    public final ItemBinder provideMessageItemBinder(@NotNull IncomingItemMessageBlueprint incomingItemMessageBlueprint, @NotNull OutgoingItemMessageBlueprint outgoingItemMessageBlueprint, @NotNull IncomingImageMessageBlueprint incomingImageMessageBlueprint, @NotNull OutgoingImageMessageBlueprint outgoingImageMessageBlueprint, @NotNull IncomingTextMessageBlueprint incomingTextMessageBlueprint, @NotNull OutgoingTextMessageBlueprint outgoingTextMessageBlueprint, @NotNull IncomingUnknownMessageBlueprint incomingUnknownMessageBlueprint, @NotNull OutgoingUnknownMessageBlueprint outgoingUnknownMessageBlueprint, @NotNull SystemTextBlueprint systemTextBlueprint, @NotNull NewMessagesDividerBlueprint newMessagesDividerBlueprint, @NotNull PaginationErrorBlueprint paginationErrorBlueprint, @NotNull PaginationInProgressBlueprint paginationInProgressBlueprint, @NotNull IncomingCallMessageBlueprint incomingCallMessageBlueprint, @NotNull OutgoingCallMessageBlueprint outgoingCallMessageBlueprint, @NotNull TypingIndicatorBlueprint typingIndicatorBlueprint, @NotNull IncomingLinkSnippetMessageBlueprint incomingLinkSnippetMessageBlueprint, @NotNull OutgoingLinkSnippetMessageBlueprint outgoingLinkSnippetMessageBlueprint, @NotNull IncomingLocationMessageBlueprint incomingLocationMessageBlueprint, @NotNull OutgoingLocationMessageBlueprint outgoingLocationMessageBlueprint, @NotNull IncomingFileMessageBlueprint incomingFileMessageBlueprint, @NotNull OutgoingFileMessageBlueprint outgoingFileMessageBlueprint, @NotNull IncomingDeletedMessageBlueprint incomingDeletedMessageBlueprint, @NotNull OutgoingDeletedMessageBlueprint outgoingDeletedMessageBlueprint, @NotNull IncomingAppCallMessageBlueprint incomingAppCallMessageBlueprint, @NotNull OutgoingAppCallMessageBlueprint outgoingAppCallMessageBlueprint, @NotNull SpamActionsBlueprint spamActionsBlueprint, @NotNull PlatformGeoMessageFromAvitoBlueprint platformGeoMessageFromAvitoBlueprint, @NotNull PlatformImageMessageFromAvitoBlueprint platformImageMessageFromAvitoBlueprint, @NotNull PlatformItemMessageFromAvitoBlueprint platformItemMessageFromAvitoBlueprint, @NotNull PlatformTextMessageFromAvitoBlueprint platformTextMessageFromAvitoBlueprint, @NotNull IncomingPlatformTextMessageFromUserBlueprint incomingPlatformTextMessageFromUserBlueprint, @NotNull OutgoingPlatformTextMessageFromUserBlueprint outgoingPlatformTextMessageFromUserBlueprint, @NotNull IncomingPlatformItemMessageFromUserBlueprint incomingPlatformItemMessageFromUserBlueprint, @NotNull OutgoingPlatformItemMessageFromUserBlueprint outgoingPlatformItemMessageFromUserBlueprint) {
        Intrinsics.checkNotNullParameter(incomingItemMessageBlueprint, "incomingItemMessageBlueprint");
        Intrinsics.checkNotNullParameter(outgoingItemMessageBlueprint, "outgoingItemMessageBlueprint");
        Intrinsics.checkNotNullParameter(incomingImageMessageBlueprint, "incomingImageMessageBlueprint");
        Intrinsics.checkNotNullParameter(outgoingImageMessageBlueprint, "outgoingImageMessageBlueprint");
        Intrinsics.checkNotNullParameter(incomingTextMessageBlueprint, "incomingTextMessageBlueprint");
        Intrinsics.checkNotNullParameter(outgoingTextMessageBlueprint, "outgoingTextMessageBlueprint");
        Intrinsics.checkNotNullParameter(incomingUnknownMessageBlueprint, "incomingUnknownMessageBlueprint");
        Intrinsics.checkNotNullParameter(outgoingUnknownMessageBlueprint, "outgoingUnknownMessageBlueprint");
        Intrinsics.checkNotNullParameter(systemTextBlueprint, "systemTextBlueprint");
        Intrinsics.checkNotNullParameter(newMessagesDividerBlueprint, "metadataBlueprint");
        Intrinsics.checkNotNullParameter(paginationErrorBlueprint, "paginationErrorBlueprint");
        Intrinsics.checkNotNullParameter(paginationInProgressBlueprint, "paginationInProgressBlueprint");
        Intrinsics.checkNotNullParameter(incomingCallMessageBlueprint, "incomingCallMessageBlueprint");
        Intrinsics.checkNotNullParameter(outgoingCallMessageBlueprint, "outgoingCallMessageBlueprint");
        Intrinsics.checkNotNullParameter(typingIndicatorBlueprint, "typingIndicatorBlueprint");
        Intrinsics.checkNotNullParameter(incomingLinkSnippetMessageBlueprint, "incomingLinkSnippetMessageBlueprint");
        Intrinsics.checkNotNullParameter(outgoingLinkSnippetMessageBlueprint, "outgoingLinkSnippetMessageBlueprint");
        Intrinsics.checkNotNullParameter(incomingLocationMessageBlueprint, "incomingLocationMessageBlueprint");
        Intrinsics.checkNotNullParameter(outgoingLocationMessageBlueprint, "outgoingLocationMessageBlueprint");
        Intrinsics.checkNotNullParameter(incomingFileMessageBlueprint, "incomingFileMessageBlueprint");
        Intrinsics.checkNotNullParameter(outgoingFileMessageBlueprint, "outgoingFileMessageBlueprint");
        Intrinsics.checkNotNullParameter(incomingDeletedMessageBlueprint, "incomingDeletedMessageBlueprint");
        Intrinsics.checkNotNullParameter(outgoingDeletedMessageBlueprint, "outgoingDeletedMessageBlueprint");
        Intrinsics.checkNotNullParameter(incomingAppCallMessageBlueprint, "incomingAppCallMessageBlueprint");
        Intrinsics.checkNotNullParameter(outgoingAppCallMessageBlueprint, "outgoingAppCallMessageBlueprint");
        Intrinsics.checkNotNullParameter(spamActionsBlueprint, "spamActionsBlueprint");
        Intrinsics.checkNotNullParameter(platformGeoMessageFromAvitoBlueprint, "platformGeoMessageFromAvitoBlueprint");
        Intrinsics.checkNotNullParameter(platformImageMessageFromAvitoBlueprint, "platformImageMessageFromAvitoBlueprint");
        Intrinsics.checkNotNullParameter(platformItemMessageFromAvitoBlueprint, "platformItemMessageFromAvitoBlueprint");
        Intrinsics.checkNotNullParameter(platformTextMessageFromAvitoBlueprint, "platformTextMessageFromAvitoBlueprint");
        Intrinsics.checkNotNullParameter(incomingPlatformTextMessageFromUserBlueprint, "incomingPlatformTextMessageFromUserBlueprint");
        Intrinsics.checkNotNullParameter(outgoingPlatformTextMessageFromUserBlueprint, "outgoingPlatformTextMessageFromUserBlueprint");
        Intrinsics.checkNotNullParameter(incomingPlatformItemMessageFromUserBlueprint, "incomingPlatformItemMessageFromUserBlueprint");
        Intrinsics.checkNotNullParameter(outgoingPlatformItemMessageFromUserBlueprint, "outgoingPlatformItemMessageFromUserBlueprint");
        return new ItemBinder.Builder().registerItem(incomingItemMessageBlueprint).registerItem(outgoingItemMessageBlueprint).registerItem(incomingImageMessageBlueprint).registerItem(outgoingImageMessageBlueprint).registerItem(incomingTextMessageBlueprint).registerItem(outgoingTextMessageBlueprint).registerItem(incomingUnknownMessageBlueprint).registerItem(outgoingUnknownMessageBlueprint).registerItem(systemTextBlueprint).registerItem(paginationErrorBlueprint).registerItem(newMessagesDividerBlueprint).registerItem(incomingCallMessageBlueprint).registerItem(outgoingCallMessageBlueprint).registerItem(platformGeoMessageFromAvitoBlueprint).registerItem(platformImageMessageFromAvitoBlueprint).registerItem(platformItemMessageFromAvitoBlueprint).registerItem(platformTextMessageFromAvitoBlueprint).registerItem(typingIndicatorBlueprint).registerItem(paginationInProgressBlueprint).registerItem(incomingLinkSnippetMessageBlueprint).registerItem(outgoingLinkSnippetMessageBlueprint).registerItem(incomingLocationMessageBlueprint).registerItem(outgoingLocationMessageBlueprint).registerItem(incomingFileMessageBlueprint).registerItem(outgoingFileMessageBlueprint).registerItem(spamActionsBlueprint).registerItem(incomingDeletedMessageBlueprint).registerItem(outgoingDeletedMessageBlueprint).registerItem(incomingAppCallMessageBlueprint).registerItem(outgoingAppCallMessageBlueprint).registerItem(incomingPlatformTextMessageFromUserBlueprint).registerItem(outgoingPlatformTextMessageFromUserBlueprint).registerItem(incomingPlatformItemMessageFromUserBlueprint).registerItem(outgoingPlatformItemMessageFromUserBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final MessagePictureProvider provideMessagePictureProvider$messenger_release() {
        return new MessagePictureProviderImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final NewMessagesDividerBlueprint provideNewMessagesDividerBlueprint$messenger_release() {
        return new NewMessagesDividerBlueprint();
    }

    @Provides
    @PerFragment
    @NotNull
    public final OutgoingAppCallMessageBlueprint provideOutgoingAppCallMessageBlueprint$messenger_release(@NotNull AppCallMessagePresenter appCallMessagePresenter) {
        Intrinsics.checkNotNullParameter(appCallMessagePresenter, "presenter");
        return new OutgoingAppCallMessageBlueprint(appCallMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final OutgoingCallMessageBlueprint provideOutgoingCallMessageBlueprint$messenger_release(@NotNull CallMessagePresenter callMessagePresenter) {
        Intrinsics.checkNotNullParameter(callMessagePresenter, "presenter");
        return new OutgoingCallMessageBlueprint(callMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final OutgoingFileMessageBlueprint provideOutgoingFileMessageBlueprint$messenger_release(@NotNull FileMessagePresenter fileMessagePresenter) {
        Intrinsics.checkNotNullParameter(fileMessagePresenter, "presenter");
        return new OutgoingFileMessageBlueprint(fileMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final OutgoingImageMessageBlueprint provideOutgoingImageMessageBlueprint$messenger_release(@NotNull ImageMessagePresenter imageMessagePresenter) {
        Intrinsics.checkNotNullParameter(imageMessagePresenter, "presenter");
        return new OutgoingImageMessageBlueprint(imageMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final OutgoingItemMessageBlueprint provideOutgoingItemMessageBlueprint$messenger_release(@NotNull ItemMessagePresenter itemMessagePresenter) {
        Intrinsics.checkNotNullParameter(itemMessagePresenter, "presenter");
        return new OutgoingItemMessageBlueprint(itemMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final OutgoingLinkSnippetMessageBlueprint provideOutgoingLinkSnippetMessageBlueprint$messenger_release(@NotNull LinkSnippetMessagePresenter linkSnippetMessagePresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(linkSnippetMessagePresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new OutgoingLinkSnippetMessageBlueprint(linkSnippetMessagePresenter, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final OutgoingLocationMessageBlueprint provideOutgoingLocationMessageBlueprint$messenger_release(@NotNull LocationMessagePresenter locationMessagePresenter) {
        Intrinsics.checkNotNullParameter(locationMessagePresenter, "presenter");
        return new OutgoingLocationMessageBlueprint(locationMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final OutgoingPlatformItemMessageFromUserBlueprint provideOutgoingPlatformItemMessageFromUserBlueprint$messenger_release(@NotNull PlatformItemMessageFromUserPresenter platformItemMessageFromUserPresenter) {
        Intrinsics.checkNotNullParameter(platformItemMessageFromUserPresenter, "presenter");
        return new OutgoingPlatformItemMessageFromUserBlueprint(platformItemMessageFromUserPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final OutgoingPlatformTextMessageFromUserBlueprint provideOutgoingPlatformTextMessageFromUserBlueprint$messenger_release(@NotNull PlatformTextMessageFromUserPresenter platformTextMessageFromUserPresenter) {
        Intrinsics.checkNotNullParameter(platformTextMessageFromUserPresenter, "presenter");
        return new OutgoingPlatformTextMessageFromUserBlueprint(platformTextMessageFromUserPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final OutgoingTextMessageBlueprint provideOutgoingTextMessageBlueprint$messenger_release(@NotNull TextMessagePresenter textMessagePresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(textMessagePresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new OutgoingTextMessageBlueprint(textMessagePresenter, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final OutgoingUnknownMessageBlueprint provideOutgoingUnknownMessageBlueprint$messenger_release(@NotNull UnknownMessagePresenter unknownMessagePresenter) {
        Intrinsics.checkNotNullParameter(unknownMessagePresenter, "presenter");
        return new OutgoingUnknownMessageBlueprint(unknownMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PaginationErrorBlueprint providePaginationErrorBlueprint$messenger_release(@NotNull PaginationErrorPresenter paginationErrorPresenter) {
        Intrinsics.checkNotNullParameter(paginationErrorPresenter, "presenter");
        return new PaginationErrorBlueprint(paginationErrorPresenter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final PaginationErrorPresenter providePaginationErrorPresenter$messenger_release(@NotNull Lazy<PaginationErrorView.Listener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new PaginationErrorPresenterImpl(lazy);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PaginationInProgressBlueprint providePaginationInProgressBlueprint$messenger_release(@NotNull PaginationInProgressPresenter paginationInProgressPresenter) {
        Intrinsics.checkNotNullParameter(paginationInProgressPresenter, "presenter");
        return new PaginationInProgressBlueprint(paginationInProgressPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PaginationInProgressPresenter providePaginationInProgressPresenter$messenger_release() {
        return new PaginationInProgressPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final PlatformGeoMessageFromAvitoBlueprint providePlatformGeoMessageFromAvitoBlueprint$messenger_release(@NotNull PlatformGeoMessageFromAvitoPresenter platformGeoMessageFromAvitoPresenter) {
        Intrinsics.checkNotNullParameter(platformGeoMessageFromAvitoPresenter, "presenter");
        return new PlatformGeoMessageFromAvitoBlueprint(platformGeoMessageFromAvitoPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PlatformGeoMessageFromAvitoPresenter providePlatformGeoMessageFromAvitoPresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull GoogleApiKey googleApiKey, @NotNull YandexApiKey yandexApiKey, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(googleApiKey, "googleApiKey");
        Intrinsics.checkNotNullParameter(yandexApiKey, "yandexApiKey");
        Intrinsics.checkNotNullParameter(features, "features");
        return new PlatformGeoMessageFromAvitoPresenter(incomingMessagePresenter, googleApiKey, yandexApiKey, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PlatformImageMessageFromAvitoBlueprint providePlatformImageMessageFromAvitoBlueprint$messenger_release(@NotNull PlatformImageMessageFromAvitoPresenter platformImageMessageFromAvitoPresenter) {
        Intrinsics.checkNotNullParameter(platformImageMessageFromAvitoPresenter, "presenter");
        return new PlatformImageMessageFromAvitoBlueprint(platformImageMessageFromAvitoPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PlatformImageMessageFromAvitoPresenter providePlatformImageMessageFromAvitoPresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull MessagePictureProvider messagePictureProvider) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(messagePictureProvider, "pictureProvider");
        return new PlatformImageMessageFromAvitoPresenter(incomingMessagePresenter, messagePictureProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PlatformItemMessageFromAvitoBlueprint providePlatformItemMessageFromAvitoBlueprint$messenger_release(@NotNull PlatformItemMessageFromAvitoPresenter platformItemMessageFromAvitoPresenter) {
        Intrinsics.checkNotNullParameter(platformItemMessageFromAvitoPresenter, "presenter");
        return new PlatformItemMessageFromAvitoBlueprint(platformItemMessageFromAvitoPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PlatformItemMessageFromAvitoPresenter providePlatformItemMessageFromAvitoPresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        return new PlatformItemMessageFromAvitoPresenter(incomingMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PlatformItemMessageFromUserPresenter providePlatformItemMessageFromUserPresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        return new PlatformItemMessageFromUserPresenter(incomingMessagePresenter, outgoingMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PlatformTextMessageFromAvitoBlueprint providePlatformTextMessageFromAvitoBlueprint$messenger_release(@NotNull PlatformTextMessageFromAvitoPresenter platformTextMessageFromAvitoPresenter) {
        Intrinsics.checkNotNullParameter(platformTextMessageFromAvitoPresenter, "presenter");
        return new PlatformTextMessageFromAvitoBlueprint(platformTextMessageFromAvitoPresenter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final PlatformTextMessageFromAvitoPresenter providePlatformTextMessageFromAvitoPresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull Lazy<DeeplinkProcessor> lazy, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull Lazy<ActionMode.Callback> lazy2) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(lazy, "deeplinkProcessor");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(lazy2, "actionModeCallback");
        return new PlatformTextMessageFromAvitoPresenter(incomingMessagePresenter, lazy, attributedTextFormatter, lazy2);
    }

    @Provides
    @NotNull
    @PerFragment
    public final PlatformTextMessageFromUserPresenter providePlatformTextMessageFromUserPresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull Lazy<DeeplinkProcessor> lazy, @NotNull MessageLinkClickListener messageLinkClickListener, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(lazy, "deeplinkProcessor");
        Intrinsics.checkNotNullParameter(messageLinkClickListener, "linkClickListener");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        return new PlatformTextMessageFromUserPresenter(incomingMessagePresenter, outgoingMessagePresenter, lazy, messageLinkClickListener, attributedTextFormatter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SpamActionsBlueprint provideSpamActionsBlueprint$messenger_release(@NotNull SpamActionsPresenter spamActionsPresenter) {
        Intrinsics.checkNotNullParameter(spamActionsPresenter, "presenter");
        return new SpamActionsBlueprint(spamActionsPresenter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final SpamActionsPresenter provideSpamActionsPresenter$messenger_release(@NotNull Lazy<SpamActionsPresenter.Listener> lazy, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new SpamActionsPresenterImpl(lazy, analytics);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SystemTextBlueprint provideSystemTextBlueprint$messenger_release(@NotNull SystemTextPresenter systemTextPresenter) {
        Intrinsics.checkNotNullParameter(systemTextPresenter, "presenter");
        return new SystemTextBlueprint(systemTextPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SystemTextPresenter provideSystemTextPresenter$messenger_release() {
        return new SystemTextPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final TextMessagePresenter provideTextMessagePresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull MessageLinkClickListener messageLinkClickListener, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(messageLinkClickListener, "linkClickListener");
        Intrinsics.checkNotNullParameter(features, "features");
        return new TextMessagePresenter(incomingMessagePresenter, outgoingMessagePresenter, messageLinkClickListener, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final TypingIndicatorBlueprint provideTypingIndicatorBlueprint$messenger_release(@NotNull TypingIndicatorPresenter typingIndicatorPresenter) {
        Intrinsics.checkNotNullParameter(typingIndicatorPresenter, "presenter");
        return new TypingIndicatorBlueprint(typingIndicatorPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final UnknownMessagePresenter provideUnknownMessagePresenter$messenger_release(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        return new UnknownMessagePresenter(incomingMessagePresenter, outgoingMessagePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final TypingIndicatorPresenter providerTypingIndicatorPresenter$messenger_release() {
        return new TypingIndicatorPresenter();
    }
}

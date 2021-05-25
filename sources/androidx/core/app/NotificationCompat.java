package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.facebook.applinks.AppLinkData;
import com.facebook.share.internal.ShareConstants;
import com.sumsub.sns.R2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import l6.h.a.e;
import l6.h.a.f;
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    public static class Action {
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        public final Bundle a;
        public PendingIntent actionIntent;
        @Nullable
        public IconCompat b;
        public final RemoteInput[] c;
        public final RemoteInput[] d;
        public boolean e;
        public boolean f;
        public final int g;
        public final boolean h;
        @Deprecated
        public int icon;
        public CharSequence title;

        public static final class Builder {
            public final IconCompat a;
            public final CharSequence b;
            public final PendingIntent c;
            public boolean d;
            public final Bundle e;
            public ArrayList<RemoteInput> f;
            public int g;
            public boolean h;
            public boolean i;

            public Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
            }

            public Builder addExtras(Bundle bundle) {
                if (bundle != null) {
                    this.e.putAll(bundle);
                }
                return this;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.f == null) {
                    this.f = new ArrayList<>();
                }
                this.f.add(remoteInput);
                return this;
            }

            public Action build() {
                RemoteInput[] remoteInputArr;
                if (this.i) {
                    Objects.requireNonNull(this.c, "Contextual Actions must contain a valid PendingIntent");
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<RemoteInput> arrayList3 = this.f;
                if (arrayList3 != null) {
                    Iterator<RemoteInput> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        RemoteInput next = it.next();
                        if (next.isDataOnly()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                RemoteInput[] remoteInputArr2 = null;
                if (arrayList.isEmpty()) {
                    remoteInputArr = null;
                } else {
                    remoteInputArr = (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]);
                }
                if (!arrayList2.isEmpty()) {
                    remoteInputArr2 = (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]);
                }
                return new Action(this.a, this.b, this.c, this.e, remoteInputArr2, remoteInputArr, this.d, this.g, this.h, this.i);
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.e;
            }

            public Builder setAllowGeneratedReplies(boolean z) {
                this.d = z;
                return this;
            }

            @NonNull
            public Builder setContextual(boolean z) {
                this.i = z;
                return this;
            }

            public Builder setSemanticAction(int i2) {
                this.g = i2;
                return this;
            }

            public Builder setShowsUserInterface(boolean z) {
                this.h = z;
                return this;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public Builder(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i2 != 0 ? IconCompat.createWithResource(null, "", i2) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
            }

            public Builder(Action action) {
                this(action.getIconCompat(), action.title, action.actionIntent, new Bundle(action.a), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.f, action.isContextual());
            }

            public Builder(@Nullable IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z, int i2, boolean z2, boolean z3) {
                ArrayList<RemoteInput> arrayList;
                this.d = true;
                this.h = true;
                this.a = iconCompat;
                this.b = Builder.limitCharSequenceLength(charSequence);
                this.c = pendingIntent;
                this.e = bundle;
                if (remoteInputArr == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList<>(Arrays.asList(remoteInputArr));
                }
                this.f = arrayList;
                this.d = z;
                this.g = i2;
                this.h = z2;
                this.i = z3;
            }
        }

        public interface Extender {
            Builder extend(Builder builder);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements Extender {
            public int a = 1;
            public CharSequence b;
            public CharSequence c;
            public CharSequence d;

            public WearableExtender() {
            }

            public final void a(int i, boolean z) {
                if (z) {
                    this.a = i | this.a;
                    return;
                }
                this.a = (~i) & this.a;
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            public Builder extend(Builder builder) {
                Bundle bundle = new Bundle();
                int i = this.a;
                if (i != 1) {
                    bundle.putInt("flags", i);
                }
                CharSequence charSequence = this.b;
                if (charSequence != null) {
                    bundle.putCharSequence("inProgressLabel", charSequence);
                }
                CharSequence charSequence2 = this.c;
                if (charSequence2 != null) {
                    bundle.putCharSequence("confirmLabel", charSequence2);
                }
                CharSequence charSequence3 = this.d;
                if (charSequence3 != null) {
                    bundle.putCharSequence("cancelLabel", charSequence3);
                }
                builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
                return builder;
            }

            @Deprecated
            public CharSequence getCancelLabel() {
                return this.d;
            }

            @Deprecated
            public CharSequence getConfirmLabel() {
                return this.c;
            }

            public boolean getHintDisplayActionInline() {
                return (this.a & 4) != 0;
            }

            public boolean getHintLaunchesActivity() {
                return (this.a & 2) != 0;
            }

            @Deprecated
            public CharSequence getInProgressLabel() {
                return this.b;
            }

            public boolean isAvailableOffline() {
                return (this.a & 1) != 0;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                a(1, z);
                return this;
            }

            @Deprecated
            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.d = charSequence;
                return this;
            }

            @Deprecated
            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.c = charSequence;
                return this;
            }

            public WearableExtender setHintDisplayActionInline(boolean z) {
                a(4, z);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean z) {
                a(2, z);
                return this;
            }

            @Deprecated
            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.b = charSequence;
                return this;
            }

            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.a = this.a;
                wearableExtender.b = this.b;
                wearableExtender.c = this.c;
                wearableExtender.d = this.d;
                return wearableExtender;
            }

            public WearableExtender(Action action) {
                Bundle bundle = action.getExtras().getBundle("android.wearable.EXTENSIONS");
                if (bundle != null) {
                    this.a = bundle.getInt("flags", 1);
                    this.b = bundle.getCharSequence("inProgressLabel");
                    this.c = bundle.getCharSequence("confirmLabel");
                    this.d = bundle.getCharSequence("cancelLabel");
                }
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent);
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.e;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.d;
        }

        public Bundle getExtras() {
            return this.a;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        @Nullable
        public IconCompat getIconCompat() {
            int i;
            if (this.b == null && (i = this.icon) != 0) {
                this.b = IconCompat.createWithResource(null, "", i);
            }
            return this.b;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.c;
        }

        public int getSemanticAction() {
            return this.g;
        }

        public boolean getShowsUserInterface() {
            return this.f;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isContextual() {
            return this.h;
        }

        public Action(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true, 0, true, false);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i2, boolean z2, boolean z3) {
            this(i != 0 ? IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, i2, z2, z3);
        }

        public Action(@Nullable IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i, boolean z2, boolean z3) {
            this.f = true;
            this.b = iconCompat;
            if (iconCompat != null && iconCompat.getType() == 2) {
                this.icon = iconCompat.getResId();
            }
            this.title = Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            this.a = bundle == null ? new Bundle() : bundle;
            this.c = remoteInputArr;
            this.d = remoteInputArr2;
            this.e = z;
            this.g = i;
            this.f = z2;
            this.h = z3;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {
        public Bitmap d;
        public Bitmap e;
        public boolean f;

        public BigPictureStyle() {
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.a).bigPicture(this.d);
            if (this.f) {
                bigPicture.bigLargeIcon(this.e);
            }
            if (this.c) {
                bigPicture.setSummaryText(this.b);
            }
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.e = bitmap;
            this.f = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.d = bitmap;
            return this;
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.a = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.b = Builder.limitCharSequenceLength(charSequence);
            this.c = true;
            return this;
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    public static class BigTextStyle extends Style {
        public CharSequence d;

        public BigTextStyle() {
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.a).bigText(this.d);
            if (this.c) {
                bigText.setSummaryText(this.b);
            }
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.d = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.a = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.b = Builder.limitCharSequenceLength(charSequence);
            this.c = true;
            return this;
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    public static final class BubbleMetadata {
        public PendingIntent a;
        public PendingIntent b;
        public IconCompat c;
        public int d;
        @DimenRes
        public int e;
        public int f;

        public static final class Builder {
            public PendingIntent a;
            public IconCompat b;
            public int c;
            @DimenRes
            public int d;
            public int e;
            public PendingIntent f;

            @NonNull
            @SuppressLint({"SyntheticAccessor"})
            public BubbleMetadata build() {
                PendingIntent pendingIntent = this.a;
                if (pendingIntent != null) {
                    IconCompat iconCompat = this.b;
                    if (iconCompat != null) {
                        return new BubbleMetadata(pendingIntent, this.f, iconCompat, this.c, this.d, this.e, null);
                    }
                    throw new IllegalStateException("Must supply an icon for the bubble");
                }
                throw new IllegalStateException("Must supply pending intent to bubble");
            }

            @NonNull
            public Builder setAutoExpandBubble(boolean z) {
                if (z) {
                    this.e |= 1;
                } else {
                    this.e &= -2;
                }
                return this;
            }

            @NonNull
            public Builder setDeleteIntent(@Nullable PendingIntent pendingIntent) {
                this.f = pendingIntent;
                return this;
            }

            @NonNull
            public Builder setDesiredHeight(@Dimension(unit = 0) int i) {
                this.c = Math.max(i, 0);
                this.d = 0;
                return this;
            }

            @NonNull
            public Builder setDesiredHeightResId(@DimenRes int i) {
                this.d = i;
                this.c = 0;
                return this;
            }

            @NonNull
            public Builder setIcon(@NonNull IconCompat iconCompat) {
                if (iconCompat == null) {
                    throw new IllegalArgumentException("Bubbles require non-null icon");
                } else if (iconCompat.getType() != 1) {
                    this.b = iconCompat;
                    return this;
                } else {
                    throw new IllegalArgumentException("When using bitmap based icons, Bubbles require TYPE_ADAPTIVE_BITMAP, please use IconCompat#createWithAdaptiveBitmap instead");
                }
            }

            @NonNull
            public Builder setIntent(@NonNull PendingIntent pendingIntent) {
                if (pendingIntent != null) {
                    this.a = pendingIntent;
                    return this;
                }
                throw new IllegalArgumentException("Bubble requires non-null pending intent");
            }

            @NonNull
            public Builder setSuppressNotification(boolean z) {
                if (z) {
                    this.e |= 2;
                } else {
                    this.e &= -3;
                }
                return this;
            }
        }

        public BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int i, int i2, int i3, a aVar) {
            this.a = pendingIntent;
            this.c = iconCompat;
            this.d = i;
            this.e = i2;
            this.b = pendingIntent2;
            this.f = i3;
        }

        @Nullable
        @RequiresApi(29)
        public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            Builder suppressNotification = new Builder().setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setIcon(IconCompat.createFromIcon(bubbleMetadata.getIcon())).setIntent(bubbleMetadata.getIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
            if (bubbleMetadata.getDesiredHeight() != 0) {
                suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
            }
            if (bubbleMetadata.getDesiredHeightResId() != 0) {
                suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
            }
            return suppressNotification.build();
        }

        @Nullable
        @RequiresApi(29)
        public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setIcon(bubbleMetadata.getIcon().toIcon()).setIntent(bubbleMetadata.getIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
            if (bubbleMetadata.getDesiredHeight() != 0) {
                suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
            }
            if (bubbleMetadata.getDesiredHeightResId() != 0) {
                suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
            }
            return suppressNotification.build();
        }

        public boolean getAutoExpandBubble() {
            return (this.f & 1) != 0;
        }

        @Nullable
        public PendingIntent getDeleteIntent() {
            return this.b;
        }

        @Dimension(unit = 0)
        public int getDesiredHeight() {
            return this.d;
        }

        @DimenRes
        public int getDesiredHeightResId() {
            return this.e;
        }

        @NonNull
        public IconCompat getIcon() {
            return this.c;
        }

        @NonNull
        public PendingIntent getIntent() {
            return this.a;
        }

        public boolean isNotificationSuppressed() {
            return (this.f & 2) != 0;
        }
    }

    public static class Builder {
        public Bundle A;
        public int B;
        public int C;
        public Notification D;
        public RemoteViews E;
        public RemoteViews F;
        public RemoteViews G;
        public String H;
        public int I;
        public String J;
        public long K;
        public int L;
        public boolean M;
        public BubbleMetadata N;
        public Notification O;
        public boolean P;
        public ArrayList<Action> a;
        public CharSequence b;
        public CharSequence c;
        public PendingIntent d;
        public PendingIntent e;
        public RemoteViews f;
        public Bitmap g;
        public CharSequence h;
        public int i;
        public int j;
        public boolean k;
        public boolean l;
        public boolean m;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Action> mActions;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Context mContext;
        @Deprecated
        public ArrayList<String> mPeople;
        public Style n;
        public CharSequence o;
        public CharSequence[] p;
        public int q;
        public int r;
        public boolean s;
        public String t;
        public boolean u;
        public String v;
        public boolean w;
        public boolean x;
        public boolean y;
        public String z;

        public Builder(@NonNull Context context, @NonNull String str) {
            this.mActions = new ArrayList<>();
            this.a = new ArrayList<>();
            this.k = true;
            this.w = false;
            this.B = 0;
            this.C = 0;
            this.I = 0;
            this.L = 0;
            Notification notification = new Notification();
            this.O = notification;
            this.mContext = context;
            this.H = str;
            notification.when = System.currentTimeMillis();
            this.O.audioStreamType = -1;
            this.j = 0;
            this.mPeople = new ArrayList<>();
            this.M = true;
        }

        public static CharSequence limitCharSequenceLength(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, R2.styleable.MockView_mock_labelBackgroundColor) : charSequence;
        }

        public final void a(int i2, boolean z2) {
            if (z2) {
                Notification notification = this.O;
                notification.flags = i2 | notification.flags;
                return;
            }
            Notification notification2 = this.O;
            notification2.flags = (~i2) & notification2.flags;
        }

        public Builder addAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(i2, charSequence, pendingIntent));
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.A;
                if (bundle2 == null) {
                    this.A = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        @RequiresApi(21)
        public Builder addInvisibleAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            return addInvisibleAction(new Action(i2, charSequence, pendingIntent));
        }

        public Builder addPerson(String str) {
            this.mPeople.add(str);
            return this;
        }

        public Notification build() {
            Notification notification;
            Bundle extras;
            RemoteViews makeHeadsUpContentView;
            RemoteViews makeBigContentView;
            e eVar = new e(this);
            Style style = eVar.b.n;
            if (style != null) {
                style.apply(eVar);
            }
            RemoteViews makeContentView = style != null ? style.makeContentView(eVar) : null;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 26) {
                notification = eVar.a.build();
            } else if (i2 >= 24) {
                notification = eVar.a.build();
                if (eVar.g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || eVar.g != 2)) {
                        eVar.a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && eVar.g == 1) {
                        eVar.a(notification);
                    }
                }
            } else {
                eVar.a.setExtras(eVar.f);
                notification = eVar.a.build();
                RemoteViews remoteViews = eVar.c;
                if (remoteViews != null) {
                    notification.contentView = remoteViews;
                }
                RemoteViews remoteViews2 = eVar.d;
                if (remoteViews2 != null) {
                    notification.bigContentView = remoteViews2;
                }
                RemoteViews remoteViews3 = eVar.h;
                if (remoteViews3 != null) {
                    notification.headsUpContentView = remoteViews3;
                }
                if (eVar.g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || eVar.g != 2)) {
                        eVar.a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && eVar.g == 1) {
                        eVar.a(notification);
                    }
                }
            }
            if (makeContentView != null) {
                notification.contentView = makeContentView;
            } else {
                RemoteViews remoteViews4 = eVar.b.E;
                if (remoteViews4 != null) {
                    notification.contentView = remoteViews4;
                }
            }
            if (!(style == null || (makeBigContentView = style.makeBigContentView(eVar)) == null)) {
                notification.bigContentView = makeBigContentView;
            }
            if (!(style == null || (makeHeadsUpContentView = eVar.b.n.makeHeadsUpContentView(eVar)) == null)) {
                notification.headsUpContentView = makeHeadsUpContentView;
            }
            if (!(style == null || (extras = NotificationCompat.getExtras(notification)) == null)) {
                style.addCompatExtras(extras);
            }
            return notification;
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getBigContentView() {
            return this.F;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public BubbleMetadata getBubbleMetadata() {
            return this.N;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getColor() {
            return this.B;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getContentView() {
            return this.E;
        }

        public Bundle getExtras() {
            if (this.A == null) {
                this.A = new Bundle();
            }
            return this.A;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getHeadsUpContentView() {
            return this.G;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getPriority() {
            return this.j;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public long getWhenIfShowing() {
            if (this.k) {
                return this.O.when;
            }
            return 0;
        }

        @NonNull
        public Builder setAllowSystemGeneratedContextualActions(boolean z2) {
            this.M = z2;
            return this;
        }

        public Builder setAutoCancel(boolean z2) {
            a(16, z2);
            return this;
        }

        public Builder setBadgeIconType(int i2) {
            this.I = i2;
            return this;
        }

        @NonNull
        public Builder setBubbleMetadata(@Nullable BubbleMetadata bubbleMetadata) {
            this.N = bubbleMetadata;
            return this;
        }

        public Builder setCategory(String str) {
            this.z = str;
            return this;
        }

        public Builder setChannelId(@NonNull String str) {
            this.H = str;
            return this;
        }

        @NonNull
        @RequiresApi(24)
        public Builder setChronometerCountDown(boolean z2) {
            this.m = z2;
            this.A.putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, z2);
            return this;
        }

        public Builder setColor(@ColorInt int i2) {
            this.B = i2;
            return this;
        }

        public Builder setColorized(boolean z2) {
            this.x = z2;
            this.y = true;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.O.contentView = remoteViews;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.h = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.d = pendingIntent;
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.c = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.b = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.F = remoteViews;
            return this;
        }

        public Builder setCustomContentView(RemoteViews remoteViews) {
            this.E = remoteViews;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.G = remoteViews;
            return this;
        }

        public Builder setDefaults(int i2) {
            Notification notification = this.O;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.O.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.A = bundle;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z2) {
            this.e = pendingIntent;
            a(128, z2);
            return this;
        }

        public Builder setGroup(String str) {
            this.t = str;
            return this;
        }

        public Builder setGroupAlertBehavior(int i2) {
            this.L = i2;
            return this;
        }

        public Builder setGroupSummary(boolean z2) {
            this.u = z2;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            if (bitmap != null && Build.VERSION.SDK_INT < 27) {
                Resources resources = this.mContext.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
                }
            }
            this.g = bitmap;
            return this;
        }

        public Builder setLights(@ColorInt int i2, int i3, int i4) {
            Notification notification = this.O;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            notification.flags = ((i3 == 0 || i4 == 0) ? 0 : 1) | (notification.flags & -2);
            return this;
        }

        public Builder setLocalOnly(boolean z2) {
            this.w = z2;
            return this;
        }

        @NonNull
        public Builder setNotificationSilent() {
            this.P = true;
            return this;
        }

        public Builder setNumber(int i2) {
            this.i = i2;
            return this;
        }

        public Builder setOngoing(boolean z2) {
            a(2, z2);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z2) {
            a(8, z2);
            return this;
        }

        public Builder setPriority(int i2) {
            this.j = i2;
            return this;
        }

        public Builder setProgress(int i2, int i3, boolean z2) {
            this.q = i2;
            this.r = i3;
            this.s = z2;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.D = notification;
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.p = charSequenceArr;
            return this;
        }

        public Builder setShortcutId(String str) {
            this.J = str;
            return this;
        }

        public Builder setShowWhen(boolean z2) {
            this.k = z2;
            return this;
        }

        public Builder setSmallIcon(int i2) {
            this.O.icon = i2;
            return this;
        }

        public Builder setSortKey(String str) {
            this.v = str;
            return this;
        }

        public Builder setSound(Uri uri) {
            Notification notification = this.O;
            notification.sound = uri;
            notification.audioStreamType = -1;
            notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.n != style) {
                this.n = style;
                if (style != null) {
                    style.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.o = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.O.tickerText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setTimeoutAfter(long j2) {
            this.K = j2;
            return this;
        }

        public Builder setUsesChronometer(boolean z2) {
            this.l = z2;
            return this;
        }

        public Builder setVibrate(long[] jArr) {
            this.O.vibrate = jArr;
            return this;
        }

        public Builder setVisibility(int i2) {
            this.C = i2;
            return this;
        }

        public Builder setWhen(long j2) {
            this.O.when = j2;
            return this;
        }

        public Builder addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        @RequiresApi(21)
        public Builder addInvisibleAction(Action action) {
            this.a.add(action);
            return this;
        }

        public Builder setSmallIcon(int i2, int i3) {
            Notification notification = this.O;
            notification.icon = i2;
            notification.iconLevel = i3;
            return this;
        }

        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.O.tickerText = limitCharSequenceLength(charSequence);
            this.f = remoteViews;
            return this;
        }

        public Builder setSound(Uri uri, int i2) {
            Notification notification = this.O;
            notification.sound = uri;
            notification.audioStreamType = i2;
            notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i2).build();
            return this;
        }

        @Deprecated
        public Builder(Context context) {
            this(context, null);
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
            }
        }

        public final RemoteViews c(RemoteViews remoteViews, boolean z) {
            ArrayList arrayList;
            int min;
            int i;
            boolean z2 = true;
            int i2 = 0;
            RemoteViews applyStandardTemplate = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            applyStandardTemplate.removeAllViews(R.id.actions);
            ArrayList<Action> arrayList2 = this.mBuilder.mActions;
            if (arrayList2 == null) {
                arrayList = null;
            } else {
                ArrayList arrayList3 = new ArrayList();
                for (Action action : arrayList2) {
                    if (!action.isContextual()) {
                        arrayList3.add(action);
                    }
                }
                arrayList = arrayList3;
            }
            if (!z || arrayList == null || (min = Math.min(arrayList.size(), 3)) <= 0) {
                z2 = false;
            } else {
                for (int i3 = 0; i3 < min; i3++) {
                    Action action2 = (Action) arrayList.get(i3);
                    boolean z3 = action2.actionIntent == null;
                    String packageName = this.mBuilder.mContext.getPackageName();
                    if (z3) {
                        i = R.layout.notification_action_tombstone;
                    } else {
                        i = R.layout.notification_action;
                    }
                    RemoteViews remoteViews2 = new RemoteViews(packageName, i);
                    remoteViews2.setImageViewBitmap(R.id.action_image, a(action2.getIconCompat(), this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter), 0));
                    remoteViews2.setTextViewText(R.id.action_text, action2.title);
                    if (!z3) {
                        remoteViews2.setOnClickPendingIntent(R.id.action_container, action2.actionIntent);
                    }
                    remoteViews2.setContentDescription(R.id.action_container, action2.title);
                    applyStandardTemplate.addView(R.id.actions, remoteViews2);
                }
            }
            if (!z2) {
                i2 = 8;
            }
            applyStandardTemplate.setViewVisibility(R.id.actions, i2);
            applyStandardTemplate.setViewVisibility(R.id.action_divider, i2);
            buildIntoRemoteViews(applyStandardTemplate, remoteViews);
            return applyStandardTemplate;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView();
            if (bigContentView == null) {
                bigContentView = this.mBuilder.getContentView();
            }
            if (bigContentView == null) {
                return null;
            }
            return c(bigContentView, true);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT < 24 && this.mBuilder.getContentView() != null) {
                return c(this.mBuilder.getContentView(), false);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews remoteViews;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView();
            if (headsUpContentView != null) {
                remoteViews = headsUpContentView;
            } else {
                remoteViews = this.mBuilder.getContentView();
            }
            if (headsUpContentView == null) {
                return null;
            }
            return c(remoteViews, true);
        }
    }

    public interface Extender {
        Builder extend(Builder builder);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface GroupAlertBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface StreamType {
    }

    public static abstract class Style {
        public CharSequence a;
        public CharSequence b;
        public boolean c = false;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder mBuilder;

        public final Bitmap a(IconCompat iconCompat, int i, int i2) {
            Drawable loadDrawable = iconCompat.loadDrawable(this.mBuilder.mContext);
            int intrinsicWidth = i2 == 0 ? loadDrawable.getIntrinsicWidth() : i2;
            if (i2 == 0) {
                i2 = loadDrawable.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i2, Bitmap.Config.ARGB_8888);
            loadDrawable.setBounds(0, 0, intrinsicWidth, i2);
            if (i != 0) {
                loadDrawable.mutate().setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            }
            loadDrawable.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(Bundle bundle) {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0100  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x011d  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0141  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0185  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x018a  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x018c  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0196  */
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.widget.RemoteViews applyStandardTemplate(boolean r13, int r14, boolean r15) {
            /*
            // Method dump skipped, instructions count: 412
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Style.applyStandardTemplate(boolean, int, boolean):android.widget.RemoteViews");
        }

        public final Bitmap b(int i, int i2, int i3, int i4) {
            int i5 = R.drawable.notification_icon_background;
            if (i4 == 0) {
                i4 = 0;
            }
            Bitmap a3 = a(IconCompat.createWithResource(this.mBuilder.mContext, i5), i4, i2);
            Canvas canvas = new Canvas(a3);
            Drawable mutate = this.mBuilder.mContext.getResources().getDrawable(i).mutate();
            mutate.setFilterBitmap(true);
            int i6 = (i2 - i3) / 2;
            int i7 = i3 + i6;
            mutate.setBounds(i6, i6, i7, i7);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return a3;
        }

        public Notification build() {
            Builder builder = this.mBuilder;
            if (builder != null) {
                return builder.build();
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
            remoteViews.setViewVisibility(R.id.title, 8);
            remoteViews.setViewVisibility(R.id.text2, 8);
            remoteViews.setViewVisibility(R.id.text, 8);
            int i = R.id.notification_main_column;
            remoteViews.removeAllViews(i);
            remoteViews.addView(i, remoteViews2.clone());
            remoteViews.setViewVisibility(i, 0);
            int i2 = R.id.notification_main_column_container;
            Resources resources = this.mBuilder.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float f = resources.getConfiguration().fontScale;
            if (f < 1.0f) {
                f = 1.0f;
            } else if (f > 1.3f) {
                f = 1.3f;
            }
            float f2 = (f - 1.0f) / 0.29999995f;
            remoteViews.setViewPadding(i2, 0, Math.round((f2 * ((float) dimensionPixelSize2)) + ((1.0f - f2) * ((float) dimensionPixelSize))), 0, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap createColoredBitmap(int i, int i2) {
            return a(IconCompat.createWithResource(this.mBuilder.mContext, i), i2, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(Bundle bundle) {
        }

        public void setBuilder(Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (builder != null) {
                    builder.setStyle(this);
                }
            }
        }
    }

    public static final class WearableExtender implements Extender {
        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;
        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        @Deprecated
        public static final int SIZE_DEFAULT = 0;
        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;
        @Deprecated
        public static final int SIZE_LARGE = 4;
        @Deprecated
        public static final int SIZE_MEDIUM = 3;
        @Deprecated
        public static final int SIZE_SMALL = 2;
        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        public ArrayList<Action> a = new ArrayList<>();
        public int b = 1;
        public PendingIntent c;
        public ArrayList<Notification> d = new ArrayList<>();
        public Bitmap e;
        public int f;
        public int g = GravityCompat.END;
        public int h = -1;
        public int i = 0;
        public int j;
        public int k = 80;
        public int l;
        public String m;
        public String n;

        public WearableExtender() {
        }

        public final void a(int i2, boolean z) {
            if (z) {
                this.b = i2 | this.b;
                return;
            }
            this.b = (~i2) & this.b;
        }

        public WearableExtender addAction(Action action) {
            this.a.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            this.a.addAll(list);
            return this;
        }

        @Deprecated
        public WearableExtender addPage(Notification notification) {
            this.d.add(notification);
            return this;
        }

        @Deprecated
        public WearableExtender addPages(List<Notification> list) {
            this.d.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.a.clear();
            return this;
        }

        @Deprecated
        public WearableExtender clearPages() {
            this.d.clear();
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            Notification.Action.Builder builder2;
            Bundle bundle;
            Icon icon;
            Bundle bundle2 = new Bundle();
            if (!this.a.isEmpty()) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.a.size());
                Iterator<Action> it = this.a.iterator();
                while (it.hasNext()) {
                    Action next = it.next();
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 23) {
                        IconCompat iconCompat = next.getIconCompat();
                        if (iconCompat == null) {
                            icon = null;
                        } else {
                            icon = iconCompat.toIcon();
                        }
                        builder2 = new Notification.Action.Builder(icon, next.getTitle(), next.getActionIntent());
                    } else {
                        IconCompat iconCompat2 = next.getIconCompat();
                        builder2 = new Notification.Action.Builder((iconCompat2 == null || iconCompat2.getType() != 2) ? 0 : iconCompat2.getResId(), next.getTitle(), next.getActionIntent());
                    }
                    if (next.getExtras() != null) {
                        bundle = new Bundle(next.getExtras());
                    } else {
                        bundle = new Bundle();
                    }
                    bundle.putBoolean("android.support.allowGeneratedReplies", next.getAllowGeneratedReplies());
                    if (i2 >= 24) {
                        builder2.setAllowGeneratedReplies(next.getAllowGeneratedReplies());
                    }
                    builder2.addExtras(bundle);
                    RemoteInput[] remoteInputs = next.getRemoteInputs();
                    if (remoteInputs != null) {
                        for (RemoteInput remoteInput : RemoteInput.b(remoteInputs)) {
                            builder2.addRemoteInput(remoteInput);
                        }
                    }
                    arrayList.add(builder2.build());
                }
                bundle2.putParcelableArrayList("actions", arrayList);
            }
            int i3 = this.b;
            if (i3 != 1) {
                bundle2.putInt("flags", i3);
            }
            PendingIntent pendingIntent = this.c;
            if (pendingIntent != null) {
                bundle2.putParcelable("displayIntent", pendingIntent);
            }
            if (!this.d.isEmpty()) {
                ArrayList<Notification> arrayList2 = this.d;
                bundle2.putParcelableArray("pages", (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
            }
            Bitmap bitmap = this.e;
            if (bitmap != null) {
                bundle2.putParcelable("background", bitmap);
            }
            int i4 = this.f;
            if (i4 != 0) {
                bundle2.putInt("contentIcon", i4);
            }
            int i5 = this.g;
            if (i5 != 8388613) {
                bundle2.putInt("contentIconGravity", i5);
            }
            int i6 = this.h;
            if (i6 != -1) {
                bundle2.putInt("contentActionIndex", i6);
            }
            int i7 = this.i;
            if (i7 != 0) {
                bundle2.putInt("customSizePreset", i7);
            }
            int i8 = this.j;
            if (i8 != 0) {
                bundle2.putInt("customContentHeight", i8);
            }
            int i9 = this.k;
            if (i9 != 80) {
                bundle2.putInt("gravity", i9);
            }
            int i10 = this.l;
            if (i10 != 0) {
                bundle2.putInt("hintScreenTimeout", i10);
            }
            String str = this.m;
            if (str != null) {
                bundle2.putString("dismissalId", str);
            }
            String str2 = this.n;
            if (str2 != null) {
                bundle2.putString("bridgeTag", str2);
            }
            builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle2);
            return builder;
        }

        public List<Action> getActions() {
            return this.a;
        }

        @Deprecated
        public Bitmap getBackground() {
            return this.e;
        }

        public String getBridgeTag() {
            return this.n;
        }

        public int getContentAction() {
            return this.h;
        }

        @Deprecated
        public int getContentIcon() {
            return this.f;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.g;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.b & 1) != 0;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.j;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.i;
        }

        public String getDismissalId() {
            return this.m;
        }

        @Deprecated
        public PendingIntent getDisplayIntent() {
            return this.c;
        }

        @Deprecated
        public int getGravity() {
            return this.k;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            return (this.b & 32) != 0;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            return (this.b & 16) != 0;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.b & 64) != 0;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            return (this.b & 2) != 0;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.l;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            return (this.b & 4) != 0;
        }

        @Deprecated
        public List<Notification> getPages() {
            return this.d;
        }

        public boolean getStartScrollBottom() {
            return (this.b & 8) != 0;
        }

        @Deprecated
        public WearableExtender setBackground(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public WearableExtender setBridgeTag(String str) {
            this.n = str;
            return this;
        }

        public WearableExtender setContentAction(int i2) {
            this.h = i2;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIcon(int i2) {
            this.f = i2;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIconGravity(int i2) {
            this.g = i2;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            a(1, z);
            return this;
        }

        @Deprecated
        public WearableExtender setCustomContentHeight(int i2) {
            this.j = i2;
            return this;
        }

        @Deprecated
        public WearableExtender setCustomSizePreset(int i2) {
            this.i = i2;
            return this;
        }

        public WearableExtender setDismissalId(String str) {
            this.m = str;
            return this;
        }

        @Deprecated
        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.c = pendingIntent;
            return this;
        }

        @Deprecated
        public WearableExtender setGravity(int i2) {
            this.k = i2;
            return this;
        }

        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean z) {
            a(32, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            a(16, z);
            return this;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            a(64, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintHideIcon(boolean z) {
            a(2, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintScreenTimeout(int i2) {
            this.l = i2;
            return this;
        }

        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            a(4, z);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            a(8, z);
            return this;
        }

        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.a = new ArrayList<>(this.a);
            wearableExtender.b = this.b;
            wearableExtender.c = this.c;
            wearableExtender.d = new ArrayList<>(this.d);
            wearableExtender.e = this.e;
            wearableExtender.f = this.f;
            wearableExtender.g = this.g;
            wearableExtender.h = this.h;
            wearableExtender.i = this.i;
            wearableExtender.j = this.j;
            wearableExtender.k = this.k;
            wearableExtender.l = this.l;
            wearableExtender.m = this.m;
            wearableExtender.n = this.n;
            return wearableExtender;
        }

        public WearableExtender(Notification notification) {
            Notification[] notificationArr;
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("actions");
                if (parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    Action[] actionArr = new Action[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        actionArr[i2] = NotificationCompat.a((Notification.Action) parcelableArrayList.get(i2));
                    }
                    Collections.addAll(this.a, actionArr);
                }
                this.b = bundle.getInt("flags", 1);
                this.c = (PendingIntent) bundle.getParcelable("displayIntent");
                Parcelable[] parcelableArray = bundle.getParcelableArray("pages");
                if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
                    notificationArr = (Notification[]) parcelableArray;
                } else {
                    notificationArr = new Notification[parcelableArray.length];
                    for (int i3 = 0; i3 < parcelableArray.length; i3++) {
                        notificationArr[i3] = (Notification) parcelableArray[i3];
                    }
                    bundle.putParcelableArray("pages", notificationArr);
                }
                if (notificationArr != null) {
                    Collections.addAll(this.d, notificationArr);
                }
                this.e = (Bitmap) bundle.getParcelable("background");
                this.f = bundle.getInt("contentIcon");
                this.g = bundle.getInt("contentIconGravity", GravityCompat.END);
                this.h = bundle.getInt("contentActionIndex", -1);
                this.i = bundle.getInt("customSizePreset", 0);
                this.j = bundle.getInt("customContentHeight");
                this.k = bundle.getInt("gravity", 80);
                this.l = bundle.getInt("hintScreenTimeout");
                this.m = bundle.getString("dismissalId");
                this.n = bundle.getString("bridgeTag");
            }
        }
    }

    @RequiresApi(20)
    public static Action a(Notification.Action action) {
        RemoteInput[] remoteInputArr;
        boolean z;
        int i;
        int i2;
        RemoteInput[] remoteInputs = action.getRemoteInputs();
        IconCompat iconCompat = null;
        if (remoteInputs == null) {
            remoteInputArr = null;
        } else {
            RemoteInput[] remoteInputArr2 = new RemoteInput[remoteInputs.length];
            for (int i3 = 0; i3 < remoteInputs.length; i3++) {
                RemoteInput remoteInput = remoteInputs[i3];
                remoteInputArr2[i3] = new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0, remoteInput.getExtras(), null);
            }
            remoteInputArr = remoteInputArr2;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            z = action.getExtras().getBoolean("android.support.allowGeneratedReplies") || action.getAllowGeneratedReplies();
        } else {
            z = action.getExtras().getBoolean("android.support.allowGeneratedReplies");
        }
        boolean z2 = action.getExtras().getBoolean("android.support.action.showsUserInterface", true);
        if (i4 >= 28) {
            i = action.getSemanticAction();
        } else {
            i = action.getExtras().getInt("android.support.action.semanticAction", 0);
        }
        boolean isContextual = i4 >= 29 ? action.isContextual() : false;
        if (i4 < 23) {
            return new Action(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z, i, z2, isContextual);
        }
        if (action.getIcon() == null && (i2 = action.icon) != 0) {
            return new Action(i2, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z, i, z2, isContextual);
        }
        if (action.getIcon() != null) {
            iconCompat = IconCompat.createFromIconOrNullIfZeroResId(action.getIcon());
        }
        return new Action(iconCompat, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z, i, z2, isContextual);
    }

    public static Action getAction(Notification notification, int i) {
        return a(notification.actions[i]);
    }

    public static int getActionCount(Notification notification) {
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return notification.getAllowSystemGeneratedContextualActions();
        }
        return false;
    }

    public static int getBadgeIconType(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getBadgeIconType();
        }
        return 0;
    }

    @Nullable
    public static BubbleMetadata getBubbleMetadata(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return BubbleMetadata.fromPlatform(notification.getBubbleMetadata());
        }
        return null;
    }

    public static String getCategory(Notification notification) {
        return notification.category;
    }

    public static String getChannelId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getChannelId();
        }
        return null;
    }

    @RequiresApi(19)
    public static CharSequence getContentTitle(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    @Nullable
    public static Bundle getExtras(Notification notification) {
        return notification.extras;
    }

    public static String getGroup(Notification notification) {
        return notification.getGroup();
    }

    public static int getGroupAlertBehavior(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getGroupAlertBehavior();
        }
        return 0;
    }

    @RequiresApi(21)
    public static List<Action> getInvisibleActions(Notification notification) {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = notification.extras.getBundle("android.car.EXTENSIONS");
        if (!(bundle2 == null || (bundle = bundle2.getBundle("invisible_actions")) == null)) {
            for (int i = 0; i < bundle.size(); i++) {
                arrayList.add(f.b(bundle.getBundle(Integer.toString(i))));
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(Notification notification) {
        return (notification.flags & 256) != 0;
    }

    public static String getShortcutId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getShortcutId();
        }
        return null;
    }

    public static String getSortKey(Notification notification) {
        return notification.getSortKey();
    }

    public static long getTimeoutAfter(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getTimeoutAfter();
        }
        return 0;
    }

    public static boolean isGroupSummary(Notification notification) {
        return (notification.flags & 512) != 0;
    }

    public static final class CarExtender implements Extender {
        public Bitmap a;
        public UnreadConversation b;
        public int c = 0;

        @Deprecated
        public static class UnreadConversation {
            public final String[] a;
            public final RemoteInput b;
            public final PendingIntent c;
            public final PendingIntent d;
            public final String[] e;
            public final long f;

            public static class Builder {
                public final List<String> a = new ArrayList();
                public final String b;
                public RemoteInput c;
                public PendingIntent d;
                public PendingIntent e;
                public long f;

                public Builder(String str) {
                    this.b = str;
                }

                public Builder addMessage(String str) {
                    this.a.add(str);
                    return this;
                }

                public UnreadConversation build() {
                    List<String> list = this.a;
                    return new UnreadConversation((String[]) list.toArray(new String[list.size()]), this.c, this.e, this.d, new String[]{this.b}, this.f);
                }

                public Builder setLatestTimestamp(long j) {
                    this.f = j;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.d = pendingIntent;
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.c = remoteInput;
                    this.e = pendingIntent;
                    return this;
                }
            }

            public UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.a = strArr;
                this.b = remoteInput;
                this.d = pendingIntent2;
                this.c = pendingIntent;
                this.e = strArr2;
                this.f = j;
            }

            public long getLatestTimestamp() {
                return this.f;
            }

            public String[] getMessages() {
                return this.a;
            }

            public String getParticipant() {
                String[] strArr = this.e;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            public String[] getParticipants() {
                return this.e;
            }

            public PendingIntent getReadPendingIntent() {
                return this.d;
            }

            public RemoteInput getRemoteInput() {
                return this.b;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.c;
            }
        }

        public CarExtender() {
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            Bundle bundle = new Bundle();
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                bundle.putParcelable("large_icon", bitmap);
            }
            int i = this.c;
            if (i != 0) {
                bundle.putInt("app_color", i);
            }
            UnreadConversation unreadConversation = this.b;
            if (unreadConversation != null) {
                Bundle bundle2 = new Bundle();
                String str = (unreadConversation.getParticipants() == null || unreadConversation.getParticipants().length <= 1) ? null : unreadConversation.getParticipants()[0];
                int length = unreadConversation.getMessages().length;
                Parcelable[] parcelableArr = new Parcelable[length];
                for (int i2 = 0; i2 < length; i2++) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("text", unreadConversation.getMessages()[i2]);
                    bundle3.putString("author", str);
                    parcelableArr[i2] = bundle3;
                }
                bundle2.putParcelableArray("messages", parcelableArr);
                RemoteInput remoteInput = unreadConversation.getRemoteInput();
                if (remoteInput != null) {
                    bundle2.putParcelable("remote_input", new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build());
                }
                bundle2.putParcelable("on_reply", unreadConversation.getReplyPendingIntent());
                bundle2.putParcelable("on_read", unreadConversation.getReadPendingIntent());
                bundle2.putStringArray("participants", unreadConversation.getParticipants());
                bundle2.putLong("timestamp", unreadConversation.getLatestTimestamp());
                bundle.putBundle("car_conversation", bundle2);
            }
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
            return builder;
        }

        @ColorInt
        public int getColor() {
            return this.c;
        }

        public Bitmap getLargeIcon() {
            return this.a;
        }

        @Deprecated
        public UnreadConversation getUnreadConversation() {
            return this.b;
        }

        public CarExtender setColor(@ColorInt int i) {
            this.c = i;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            this.a = bitmap;
            return this;
        }

        @Deprecated
        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.b = unreadConversation;
            return this;
        }

        public CarExtender(Notification notification) {
            Bundle bundle;
            String[] strArr;
            boolean z;
            UnreadConversation unreadConversation = null;
            unreadConversation = null;
            RemoteInput remoteInput = null;
            unreadConversation = null;
            unreadConversation = null;
            if (NotificationCompat.getExtras(notification) == null) {
                bundle = null;
            } else {
                bundle = NotificationCompat.getExtras(notification).getBundle("android.car.EXTENSIONS");
            }
            if (bundle != null) {
                this.a = (Bitmap) bundle.getParcelable("large_icon");
                this.c = bundle.getInt("app_color", 0);
                Bundle bundle2 = bundle.getBundle("car_conversation");
                if (bundle2 != null) {
                    Parcelable[] parcelableArray = bundle2.getParcelableArray("messages");
                    if (parcelableArray != null) {
                        int length = parcelableArray.length;
                        String[] strArr2 = new String[length];
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                z = true;
                                break;
                            } else if (!(parcelableArray[i] instanceof Bundle)) {
                                break;
                            } else {
                                strArr2[i] = ((Bundle) parcelableArray[i]).getString("text");
                                if (strArr2[i] == null) {
                                    break;
                                }
                                i++;
                            }
                        }
                        z = false;
                        strArr = z ? strArr2 : strArr;
                    } else {
                        strArr = null;
                    }
                    PendingIntent pendingIntent = (PendingIntent) bundle2.getParcelable("on_read");
                    PendingIntent pendingIntent2 = (PendingIntent) bundle2.getParcelable("on_reply");
                    RemoteInput remoteInput2 = (RemoteInput) bundle2.getParcelable("remote_input");
                    String[] stringArray = bundle2.getStringArray("participants");
                    if (stringArray != null && stringArray.length == 1) {
                        if (remoteInput2 != null) {
                            remoteInput = new RemoteInput(remoteInput2.getResultKey(), remoteInput2.getLabel(), remoteInput2.getChoices(), remoteInput2.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput2.getEditChoicesBeforeSending() : 0, remoteInput2.getExtras(), null);
                        }
                        unreadConversation = new UnreadConversation(strArr, remoteInput, pendingIntent2, pendingIntent, stringArray, bundle2.getLong("timestamp"));
                    }
                }
                this.b = unreadConversation;
            }
        }
    }

    public static class InboxStyle extends Style {
        public ArrayList<CharSequence> d = new ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle addLine(CharSequence charSequence) {
            this.d.add(Builder.limitCharSequenceLength(charSequence));
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.a);
            if (this.c) {
                bigContentTitle.setSummaryText(this.b);
            }
            Iterator<CharSequence> it = this.d.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine(it.next());
            }
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.a = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.b = Builder.limitCharSequenceLength(charSequence);
            this.c = true;
            return this;
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        public final List<Message> d = new ArrayList();
        public Person e;
        @Nullable
        public CharSequence f;
        @Nullable
        public Boolean g;

        public MessagingStyle() {
        }

        @Nullable
        public static MessagingStyle extractMessagingStyleFromNotification(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras != null && !extras.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) && !extras.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                return null;
            }
            try {
                MessagingStyle messagingStyle = new MessagingStyle();
                messagingStyle.restoreFromCompatExtras(extras);
                return messagingStyle;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.e.getName());
            bundle.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.e.toBundle());
            bundle.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.f);
            if (this.f != null && this.g.booleanValue()) {
                bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.f);
            }
            if (!this.d.isEmpty()) {
                List<Message> list = this.d;
                Parcelable[] parcelableArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Message message = list.get(i);
                    Objects.requireNonNull(message);
                    Bundle bundle2 = new Bundle();
                    CharSequence charSequence = message.a;
                    if (charSequence != null) {
                        bundle2.putCharSequence("text", charSequence);
                    }
                    bundle2.putLong("time", message.b);
                    Person person = message.c;
                    if (person != null) {
                        bundle2.putCharSequence("sender", person.getName());
                        if (Build.VERSION.SDK_INT >= 28) {
                            bundle2.putParcelable("sender_person", message.c.toAndroidPerson());
                        } else {
                            bundle2.putBundle("person", message.c.toBundle());
                        }
                    }
                    String str = message.e;
                    if (str != null) {
                        bundle2.putString("type", str);
                    }
                    Uri uri = message.f;
                    if (uri != null) {
                        bundle2.putParcelable(ShareConstants.MEDIA_URI, uri);
                    }
                    Bundle bundle3 = message.d;
                    if (bundle3 != null) {
                        bundle2.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, bundle3);
                    }
                    parcelableArr[i] = bundle2;
                }
                bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, parcelableArr);
            }
            Boolean bool = this.g;
            if (bool != null) {
                bundle.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, bool.booleanValue());
            }
        }

        @Deprecated
        public MessagingStyle addMessage(CharSequence charSequence, long j, CharSequence charSequence2) {
            this.d.add(new Message(charSequence, j, new Person.Builder().setName(charSequence2).build()));
            if (this.d.size() > 25) {
                this.d.remove(0);
            }
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:74:0x017b  */
        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor r11) {
            /*
            // Method dump skipped, instructions count: 435
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.MessagingStyle.apply(androidx.core.app.NotificationBuilderWithBuilderAccessor):void");
        }

        public final CharSequence c(Message message) {
            BidiFormatter instance = BidiFormatter.getInstance();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i = 1 != 0 ? ViewCompat.MEASURED_STATE_MASK : -1;
            CharSequence charSequence = "";
            CharSequence name = message.getPerson() == null ? charSequence : message.getPerson().getName();
            if (TextUtils.isEmpty(name)) {
                name = this.e.getName();
                if (!(1 == 0 || this.mBuilder.getColor() == 0)) {
                    i = this.mBuilder.getColor();
                }
            }
            CharSequence unicodeWrap = instance.unicodeWrap(name);
            spannableStringBuilder.append(unicodeWrap);
            spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
            if (message.getText() != null) {
                charSequence = message.getText();
            }
            spannableStringBuilder.append((CharSequence) "  ").append(instance.unicodeWrap(charSequence));
            return spannableStringBuilder;
        }

        @Nullable
        public CharSequence getConversationTitle() {
            return this.f;
        }

        public List<Message> getMessages() {
            return this.d;
        }

        public Person getUser() {
            return this.e;
        }

        @Deprecated
        public CharSequence getUserDisplayName() {
            return this.e.getName();
        }

        public boolean isGroupConversation() {
            Builder builder = this.mBuilder;
            if (builder == null || builder.mContext.getApplicationInfo().targetSdkVersion >= 28 || this.g != null) {
                Boolean bool = this.g;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } else if (this.f != null) {
                return true;
            } else {
                return false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:45:0x00fd  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0100 A[SYNTHETIC] */
        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void restoreFromCompatExtras(android.os.Bundle r18) {
            /*
            // Method dump skipped, instructions count: 282
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.MessagingStyle.restoreFromCompatExtras(android.os.Bundle):void");
        }

        public MessagingStyle setConversationTitle(@Nullable CharSequence charSequence) {
            this.f = charSequence;
            return this;
        }

        public MessagingStyle setGroupConversation(boolean z) {
            this.g = Boolean.valueOf(z);
            return this;
        }

        @Deprecated
        public MessagingStyle(@NonNull CharSequence charSequence) {
            this.e = new Person.Builder().setName(charSequence).build();
        }

        public static final class Message {
            public final CharSequence a;
            public final long b;
            @Nullable
            public final Person c;
            public Bundle d;
            @Nullable
            public String e;
            @Nullable
            public Uri f;

            public Message(CharSequence charSequence, long j, @Nullable Person person) {
                this.d = new Bundle();
                this.a = charSequence;
                this.b = j;
                this.c = person;
            }

            @Nullable
            public String getDataMimeType() {
                return this.e;
            }

            @Nullable
            public Uri getDataUri() {
                return this.f;
            }

            @NonNull
            public Bundle getExtras() {
                return this.d;
            }

            @Nullable
            public Person getPerson() {
                return this.c;
            }

            @Nullable
            @Deprecated
            public CharSequence getSender() {
                Person person = this.c;
                if (person == null) {
                    return null;
                }
                return person.getName();
            }

            @NonNull
            public CharSequence getText() {
                return this.a;
            }

            public long getTimestamp() {
                return this.b;
            }

            public Message setData(String str, Uri uri) {
                this.e = str;
                this.f = uri;
                return this;
            }

            @Deprecated
            public Message(CharSequence charSequence, long j, CharSequence charSequence2) {
                this(charSequence, j, new Person.Builder().setName(charSequence2).build());
            }
        }

        public MessagingStyle(@NonNull Person person) {
            if (!TextUtils.isEmpty(person.getName())) {
                this.e = person;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        public MessagingStyle addMessage(CharSequence charSequence, long j, Person person) {
            addMessage(new Message(charSequence, j, person));
            return this;
        }

        public MessagingStyle addMessage(Message message) {
            this.d.add(message);
            if (this.d.size() > 25) {
                this.d.remove(0);
            }
            return this;
        }
    }
}

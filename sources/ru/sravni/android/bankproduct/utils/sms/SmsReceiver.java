package ru.sravni.android.bankproduct.utils.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR*\u0010\u0011\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lru/sravni/android/bankproduct/utils/sms/SmsReceiver;", "Landroid/content/BroadcastReceiver;", "Lru/sravni/android/bankproduct/utils/sms/ISmsChannel;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lio/reactivex/subjects/PublishSubject;", "Lru/sravni/android/bankproduct/utils/sms/SmsInfo;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lio/reactivex/subjects/PublishSubject;", "getSmsChannel", "()Lio/reactivex/subjects/PublishSubject;", "smsChannel", "<init>", "()V", "Companion", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SmsReceiver extends BroadcastReceiver implements ISmsChannel {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String b = b;
    @NotNull
    public final PublishSubject<SmsInfo> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/utils/sms/SmsReceiver$Companion;", "", "", "SMS_RECEIVED", "Ljava/lang/String;", "getSMS_RECEIVED", "()Ljava/lang/String;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final String getSMS_RECEIVED() {
            return SmsReceiver.b;
        }

        public Companion(j jVar) {
        }
    }

    public SmsReceiver() {
        PublishSubject<SmsInfo> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<SmsInfo>()");
        this.a = create;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        Bundle extras;
        SmsMessage smsMessage;
        String str = null;
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, b) && (extras = intent.getExtras()) != null) {
            Bundle extras2 = intent.getExtras();
            Object obj = extras2 != null ? extras2.get("pdus") : null;
            if (obj != null) {
                Object[] objArr = (Object[]) obj;
                if (!(objArr.length == 0)) {
                    SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                    StringBuilder sb = new StringBuilder();
                    int length = objArr.length;
                    for (int i = 0; i < length; i++) {
                        Object obj2 = objArr[i];
                        if (Build.VERSION.SDK_INT >= 23) {
                            String string = extras.getString("format");
                            if (!(obj2 instanceof byte[])) {
                                obj2 = null;
                            }
                            smsMessage = SmsMessage.createFromPdu((byte[]) obj2, string);
                            Intrinsics.checkExpressionValueIsNotNull(smsMessage, "SmsMessage.createFromPdu…ct as? ByteArray, format)");
                        } else {
                            if (!(obj2 instanceof byte[])) {
                                obj2 = null;
                            }
                            smsMessage = SmsMessage.createFromPdu((byte[]) obj2);
                            Intrinsics.checkExpressionValueIsNotNull(smsMessage, "SmsMessage.createFromPdu(aObject as? ByteArray)");
                        }
                        smsMessageArr[i] = smsMessage;
                        SmsMessage smsMessage2 = smsMessageArr[i];
                        sb.append(smsMessage2 != null ? smsMessage2.getMessageBody() : null);
                    }
                    SmsMessage smsMessage3 = smsMessageArr[0];
                    if (smsMessage3 != null) {
                        str = smsMessage3.getOriginatingAddress();
                    }
                    String sb2 = sb.toString();
                    Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
                    getSmsChannel().onNext(new SmsInfo(sb2, str));
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.sms.ISmsChannel
    @NotNull
    public PublishSubject<SmsInfo> getSmsChannel() {
        return this.a;
    }
}

package ru.sravni.android.bankproduct.utils.encryption;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u000b8\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/utils/encryption/CryptParamsFormer;", "Lru/sravni/android/bankproduct/utils/encryption/ICryptParamsFormer;", "", "passSize", "ivSize", "saltSize", "Lru/sravni/android/bankproduct/utils/encryption/CryptParams;", "getCryptParams", "(III)Lru/sravni/android/bankproduct/utils/encryption/CryptParams;", "Lkotlin/random/Random;", "rand", "", "source", "needKeySize", AuthSource.SEND_ABUSE, "(Lkotlin/random/Random;Ljava/lang/String;I)Ljava/lang/String;", "Ljava/lang/String;", "pseudoId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class CryptParamsFormer implements ICryptParamsFormer {
    @SuppressLint({"HardwareIds"})
    public final String a;

    public CryptParamsFormer(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        StringBuilder sb = new StringBuilder();
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        String str = "";
        sb.append(string == null ? str : string);
        sb.append("aNE@HJA2831$!^&T");
        String str2 = Build.BOARD;
        sb.append((Object) (str2 == null ? str : str2));
        String str3 = Build.BRAND;
        sb.append((Object) (str3 == null ? str : str3));
        String str4 = Build.DEVICE;
        sb.append((Object) (str4 == null ? str : str4));
        String str5 = Build.DISPLAY;
        sb.append((Object) (str5 == null ? str : str5));
        String str6 = Build.HOST;
        sb.append((Object) (str6 == null ? str : str6));
        String str7 = Build.ID;
        sb.append((Object) (str7 == null ? str : str7));
        String str8 = Build.MANUFACTURER;
        sb.append((Object) (str8 == null ? str : str8));
        String str9 = Build.MODEL;
        sb.append((Object) (str9 == null ? str : str9));
        String str10 = Build.PRODUCT;
        sb.append((Object) (str10 == null ? str : str10));
        String str11 = Build.TAGS;
        sb.append((Object) (str11 == null ? str : str11));
        String str12 = Build.TYPE;
        sb.append((Object) (str12 == null ? str : str12));
        String str13 = Build.USER;
        sb.append((Object) (str13 != null ? str13 : str));
        this.a = sb.toString();
    }

    public final String a(Random random, String str, int i) {
        StringBuilder sb = new StringBuilder();
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                sb.append(str.charAt(random.nextInt(str.length())));
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "keyBuilder.toString()");
        return sb2;
    }

    @Override // ru.sravni.android.bankproduct.utils.encryption.ICryptParamsFormer
    @NotNull
    public CryptParams getCryptParams(int i, int i2, int i3) {
        Random Random = RandomKt.Random(this.a.hashCode());
        return new CryptParams(a(Random, this.a, i), a(Random, this.a, i2), a(Random, this.a, i3));
    }
}

package com.avito.android.remote;

import com.avito.android.remote.model.AuthResult;
import com.avito.android.remote.model.AuthSuggestsResult;
import com.avito.android.remote.model.Avatar;
import com.avito.android.remote.model.ConsultationPhoneConfirmationResult;
import com.avito.android.remote.model.ConsultationPhoneConfirmationStatus;
import com.avito.android.remote.model.LandlinePhoneVerificationStatusResult;
import com.avito.android.remote.model.LoginResult;
import com.avito.android.remote.model.PhoneConfirmationStatus;
import com.avito.android.remote.model.PhoneValidationResult;
import com.avito.android.remote.model.Profile;
import com.avito.android.remote.model.ProfileTab;
import com.avito.android.remote.model.RequestPhoneAntihackCodeResult;
import com.avito.android.remote.model.SendPhoneAntihackCodeResult;
import com.avito.android.remote.model.Social;
import com.avito.android.remote.model.SocialAuthResult;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TfaCodeResult;
import com.avito.android.remote.model.TfaSettingsResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.delivery.DeliveryProfileSettingsResponse;
import com.avito.android.remote.model.password.PasswordChangeResult;
import com.avito.android.remote.model.recover_by_phone.ConfirmPasswordRecoveryByPhoneResult;
import com.avito.android.remote.model.recover_by_phone.RecoverByPhoneResult;
import com.avito.android.remote.model.recover_by_phone.ResetPasswordResult;
import com.avito.android.remote.model.registration.ConfirmCodeResult;
import com.avito.android.remote.model.registration.ListProfilesResult;
import com.avito.android.remote.model.registration.RequestCodeResult;
import com.avito.android.remote.model.user_profile.IncomeProfileSettingsResponse;
import com.avito.android.remote.model.user_profile.PhonesList;
import com.avito.android.remote.model.user_profile.UserProfileResult;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.UrlParams;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.preferences.SessionContract;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H'¢\u0006\u0004\b\b\u0010\u0005JS\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00060\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00060\u00022\b\b\u0001\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00022\b\b\u0003\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0002H'¢\u0006\u0004\b\u001a\u0010\u0005J\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJG\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\u00022\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b#\u0010$J]\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\u00022\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010&\u001a\u00020\u00152\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b'\u0010(J;\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\u00022\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b)\u0010*JQ\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\u00022\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010&\u001a\u00020\u0015H'¢\u0006\u0004\b+\u0010,J;\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\u00022\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b-\u0010*JQ\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\u00022\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010&\u001a\u00020\u0015H'¢\u0006\u0004\b.\u0010,J_\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00060\u00022\b\b\u0001\u0010/\u001a\u00020\t2\b\b\u0001\u00100\u001a\u00020\t2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0001\u00101\u001a\u0004\u0018\u00010\t2\n\b\u0001\u00102\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b4\u00105Ju\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00060\u00022\b\b\u0001\u0010/\u001a\u00020\t2\b\b\u0001\u00100\u001a\u00020\t2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\t2\n\b\u0001\u00101\u001a\u0004\u0018\u00010\t2\n\b\u0001\u00102\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010&\u001a\u00020\u00152\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b6\u00107Ja\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00060\u00022\b\b\u0001\u00108\u001a\u00020\t2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0001\u00109\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010:\u001a\u0004\u0018\u00010\t2\n\b\u0001\u00102\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b;\u00105Jw\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00060\u00022\b\b\u0001\u00108\u001a\u00020\t2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\t2\n\b\u0001\u00109\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010:\u001a\u0004\u0018\u00010\t2\n\b\u0001\u00102\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010&\u001a\u00020\u00152\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b<\u00107J/\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\u00022\b\b\u0001\u0010=\u001a\u00020\t2\b\b\u0001\u0010>\u001a\u00020\tH'¢\u0006\u0004\b@\u0010\u0014J1\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u00060\u00022\u0014\b\u0001\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0AH'¢\u0006\u0004\bD\u0010EJ!\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u00022\n\b\u0001\u0010F\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\bH\u0010IJ7\u0010J\u001a\b\u0012\u0004\u0012\u00020G0\u00022\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010&\u001a\u00020\u0015H'¢\u0006\u0004\bJ\u0010KJk\u0010T\u001a\b\u0012\u0004\u0012\u00020S0\u00022\b\b\u0001\u0010L\u001a\u00020\t2\b\b\u0001\u00101\u001a\u00020\t2\b\b\u0001\u0010M\u001a\u00020\t2\b\b\u0001\u0010N\u001a\u00020\t2\b\b\u0001\u0010O\u001a\u00020\u00152\n\b\u0001\u0010P\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010Q\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010R\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\bT\u0010UJE\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\u00022\b\b\u0001\u0010V\u001a\u00020\t2\b\b\u0001\u0010N\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\bW\u0010$J[\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\u00022\b\b\u0001\u0010V\u001a\u00020\t2\b\b\u0001\u0010N\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010&\u001a\u00020\u0015H'¢\u0006\u0004\bX\u0010YJ-\u0010[\u001a\b\u0012\u0004\u0012\u00020G0\u00022\u0016\b\u0001\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0AH'¢\u0006\u0004\b[\u0010EJ\u001b\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0\u00060\\H'¢\u0006\u0004\b^\u0010_J9\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0\u00060\u00022\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010`\u001a\u00020\u00152\b\b\u0001\u0010a\u001a\u00020\tH'¢\u0006\u0004\bc\u0010dJ9\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0\u00060\\2\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010`\u001a\u00020\u00152\b\b\u0001\u0010a\u001a\u00020\tH'¢\u0006\u0004\be\u0010fJ9\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0\u00060\\2\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010`\u001a\u00020\u00152\b\b\u0001\u0010a\u001a\u00020\tH'¢\u0006\u0004\bg\u0010fJ%\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0\u00060\u00022\b\b\u0001\u0010\u001f\u001a\u00020\tH'¢\u0006\u0004\bi\u0010IJ9\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020k0\u00060\u00022\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010j\u001a\u00020\t2\b\b\u0001\u0010=\u001a\u00020\tH'¢\u0006\u0004\bl\u0010*J9\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020m0\u00060\u00022\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010j\u001a\u00020\t2\b\b\u0001\u0010a\u001a\u00020\tH'¢\u0006\u0004\bn\u0010*J9\u0010o\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020m0\u00060\\2\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010j\u001a\u00020\t2\b\b\u0001\u0010a\u001a\u00020\tH'¢\u0006\u0004\bo\u0010pJ/\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\u00022\b\b\u0001\u0010q\u001a\u00020\t2\b\b\u0001\u0010r\u001a\u00020\tH'¢\u0006\u0004\bs\u0010\u0014J9\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\\2\b\b\u0001\u0010q\u001a\u00020\t2\b\b\u0001\u0010r\u001a\u00020\t2\b\b\u0001\u0010t\u001a\u00020\u0015H'¢\u0006\u0004\bu\u0010vJ%\u0010w\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\u00022\b\b\u0001\u0010M\u001a\u00020\tH'¢\u0006\u0004\bw\u0010IJ%\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\\2\b\b\u0001\u0010M\u001a\u00020\tH'¢\u0006\u0004\bx\u0010yJ%\u0010{\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020z0\u00060\\2\b\b\u0001\u0010M\u001a\u00020\tH'¢\u0006\u0004\b{\u0010yJ&\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020~0\u00060\\2\b\b\u0001\u0010}\u001a\u00020|H'¢\u0006\u0005\b\u0010\u0001J'\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\\2\b\b\u0001\u0010M\u001a\u00020\tH'¢\u0006\u0005\b\u0001\u0010yJ2\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\u00022\b\b\u0001\u0010M\u001a\u00020\t2\t\b\u0001\u0010\u0001\u001a\u00020\tH'¢\u0006\u0005\b\u0001\u0010\u0014J3\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\\2\b\b\u0001\u0010M\u001a\u00020\t2\t\b\u0003\u0010\u0001\u001a\u00020\tH'¢\u0006\u0006\b\u0001\u0010\u0001J(\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010\u00060\u00022\b\b\u0001\u0010V\u001a\u00020\tH'¢\u0006\u0005\b\u0001\u0010IJ!\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020G0\u00022\b\b\u0001\u00101\u001a\u00020\tH'¢\u0006\u0005\b\u0001\u0010IJ(\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010\u00060\u00022\b\b\u0001\u0010M\u001a\u00020\tH'¢\u0006\u0005\b\u0001\u0010IJ2\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010\u00060\u00022\b\b\u0001\u0010M\u001a\u00020\t2\b\b\u0001\u0010j\u001a\u00020\tH'¢\u0006\u0005\b\u0001\u0010\u0014J=\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010\u00060\u00022\b\b\u0001\u0010\u0012\u001a\u00020\t2\b\b\u0001\u0010V\u001a\u00020\t2\t\b\u0001\u0010\u0001\u001a\u00020\tH'¢\u0006\u0005\b\u0001\u0010*JA\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010\u00060\u00022\t\b\u0001\u0010\u0001\u001a\u00020\t2\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010j\u001a\u0004\u0018\u00010\tH'¢\u0006\u0005\b\u0001\u0010*J)\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010\u00060\u00022\t\b\u0001\u0010\u0001\u001a\u00020\tH'¢\u0006\u0005\b\u0001\u0010IJ\u001e\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010\u00060\u0002H'¢\u0006\u0005\b\u0001\u0010\u0005J\u001e\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010\u00060\u0002H'¢\u0006\u0005\b\u0001\u0010\u0005J\u001e\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010\u00060\u0002H'¢\u0006\u0005\b\u0001\u0010\u0005J(\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\u00022\t\b\u0001\u0010\u0001\u001a\u00020\u0015H'¢\u0006\u0005\b\u0001\u0010\u0019J(\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\u00022\t\b\u0001\u0010\u0001\u001a\u00020\u0015H'¢\u0006\u0005\b\u0001\u0010\u0019J-\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020G0\u00022\b\b\u0001\u0010M\u001a\u00020\t2\t\b\u0001\u0010\u0001\u001a\u00020\u0015H'¢\u0006\u0006\b\u0001\u0010\u0001JB\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020G0\u00022\b\b\u0001\u0010M\u001a\u00020\t2\b\b\u0001\u0010j\u001a\u00020\t2\t\b\u0001\u0010\u0001\u001a\u00020\u00152\t\b\u0003\u0010\u0001\u001a\u00020\u0015H'¢\u0006\u0006\b \u0001\u0010¡\u0001J9\u0010£\u0001\u001a\t\u0012\u0005\u0012\u00030¢\u00010\u00022\b\b\u0001\u0010M\u001a\u00020\t2\t\b\u0001\u0010\u0001\u001a\u00020\u00152\t\b\u0003\u0010\u0001\u001a\u00020\u0015H'¢\u0006\u0006\b£\u0001\u0010¤\u0001J(\u0010¦\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¥\u00010\u00060\u00022\b\b\u0001\u0010M\u001a\u00020\tH'¢\u0006\u0005\b¦\u0001\u0010IJ2\u0010¨\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030§\u00010\u00060\u00022\b\b\u0001\u0010M\u001a\u00020\t2\b\b\u0001\u0010j\u001a\u00020\tH'¢\u0006\u0005\b¨\u0001\u0010\u0014J(\u0010ª\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030©\u00010\u00060\u00022\b\b\u0001\u0010M\u001a\u00020\tH'¢\u0006\u0005\bª\u0001\u0010IJ'\u0010«\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\u00022\b\b\u0001\u0010j\u001a\u00020\tH'¢\u0006\u0005\b«\u0001\u0010IJ)\u0010®\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030­\u00010\u00060\u00022\t\b\u0001\u0010¬\u0001\u001a\u00020\u0015H'¢\u0006\u0005\b®\u0001\u0010\u0019JU\u0010¯\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0\u00060\u00022\t\b\u0001\u0010\u0001\u001a\u00020\t2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010&\u001a\u00020\u00152\b\b\u0001\u0010!\u001a\u00020\tH'¢\u0006\u0006\b¯\u0001\u0010°\u0001¨\u0006±\u0001"}, d2 = {"Lcom/avito/android/remote/ProfileApi;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/Profile;", "getProfile", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/user_profile/UserProfileResult;", "getProfileInfoV6", "", "oldPassword", "newPassword", "pushToken", "sessionHashId", "source", "Lcom/avito/android/remote/model/password/PasswordChangeResult;", "changePassword", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", Preference.PASSWORD, "setPassword", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "isPublic", "Lcom/avito/android/remote/model/Avatar;", "getProfileAvatar", "(Z)Lio/reactivex/rxjava3/core/Observable;", "deleteAvatar", "Lokhttp3/MultipartBody$Part;", "file", "uploadAvatar", "(Lokhttp3/MultipartBody$Part;)Lio/reactivex/rxjava3/core/Observable;", "login", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "suggestKey", "Lcom/avito/android/remote/model/LoginResult;", "authenticateWithAntihackProLegacy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", GeoContract.PROVIDER, "isSandbox", "authenticateWithAntihackPro", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "authenticateLegacy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "authenticate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "legacyAuthenticateLegacy", "legacyAuthenticate", "networkType", SDKConstants.PARAM_ACCESS_TOKEN, "email", "socialId", "Lcom/avito/android/remote/model/SocialAuthResult;", "authenticateSocialLegacy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "authenticateSocial", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "authCode", "user", "state", "authenticateWithAppleLegacy", "authenticateWithApple", "challengeId", "passphrase", "", "proviePhone", "", "hashUserIds", "Lcom/avito/android/remote/model/AuthSuggestsResult;", "getAuthSuggests", "(Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "gcmToken", "Lcom/avito/android/remote/model/SuccessResult;", "logoutLegacy", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "logout", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", SessionContract.SESSION, "phone", "name", "subscribe", "locationId", UrlParams.METRO_ID, UrlParams.DISTRICT_ID, "Lcom/avito/android/remote/model/AuthResult;", "registerSocial", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "hash", "completeRegistrationLegacy", "completeRegistration", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "profile", "editProfile", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/user_profile/PhonesList;", "getProfilePhones", "()Lio/reactivex/rxjava3/core/Single;", "retry", "src", "Lcom/avito/android/remote/model/registration/RequestCodeResult;", "requestCode", "(Ljava/lang/String;ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "requestCodeSingle", "(Ljava/lang/String;ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "requestCodeV2", "Lcom/avito/android/remote/model/RequestPhoneAntihackCodeResult;", "requestPhoneAntihackCode", "code", "Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult;", "sendPhoneAntihackCode", "Lcom/avito/android/remote/model/registration/ConfirmCodeResult;", "confirmCode", "confirmCodeSingle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "currentPhone", "targetPhone", "replacePhoneOld", "deleteCurrentPhone", "replacePhone", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "deletePhone", "deletePhoneSingle", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/PhoneValidationResult;", "validatePhone", "", "callId", "Lcom/avito/android/remote/model/LandlinePhoneVerificationStatusResult;", "landlinePhoneVerificationStatus", "(I)Lio/reactivex/rxjava3/core/Single;", "landlinePhoneRequestVerificationCall", "items", "applyPhoneToItems", "applyPhoneToItemsSingle", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/registration/ListProfilesResult;", "listProfiles", "recoverPasswordByEmail", "Lcom/avito/android/remote/model/recover_by_phone/RecoverByPhoneResult;", "recoverPasswordByPhone", "Lcom/avito/android/remote/model/recover_by_phone/ConfirmPasswordRecoveryByPhoneResult;", "confirmRecoverPasswordByPhone", "type", "Lcom/avito/android/remote/model/recover_by_phone/ResetPasswordResult;", "resetPassword", "Lcom/avito/android/remote/model/Social;", "addSocialNetwork", "removeSocialNetwork", "getSocialNetworks", "Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse;", "getDeliveryUserProfile", "Lcom/avito/android/remote/model/user_profile/IncomeProfileSettingsResponse;", "getIncomeUserSettings", "value", "toggleIncomeSettingTo", "enabled", "deliveryToggleUserDefault", "isCompany", "checkPhoneNumber", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "needsAuthentication", "confirmPhone", "(Ljava/lang/String;Ljava/lang/String;ZZ)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/PhoneConfirmationStatus;", "requestPhoneConfirmationCode", "(Ljava/lang/String;ZZ)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/ConsultationPhoneConfirmationStatus;", "getConfirmCodeConsultation", "Lcom/avito/android/remote/model/ConsultationPhoneConfirmationResult;", "confirmPhoneConsultation", "Lcom/avito/android/remote/model/TfaCodeResult;", "requestTfaCode", "authenticateWithTfaCode", "isEnabled", "Lcom/avito/android/remote/model/TfaSettingsResult;", "setTfaEnabled", "createProfile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable addSocialNetwork$default(ProfileApi profileApi, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                return profileApi.addSocialNetwork(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSocialNetwork");
        }

        public static /* synthetic */ Single applyPhoneToItemsSingle$default(ProfileApi profileApi, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = ProfileTab.ALL;
                }
                return profileApi.applyPhoneToItemsSingle(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyPhoneToItemsSingle");
        }

        public static /* synthetic */ Observable authenticateWithApple$default(ProfileApi profileApi, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, int i, Object obj) {
            if (obj == null) {
                return profileApi.authenticateWithApple(str, str2, str3, str4, (i & 16) != 0 ? null : str5, str6, z, str7);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: authenticateWithApple");
        }

        public static /* synthetic */ Observable authenticateWithAppleLegacy$default(ProfileApi profileApi, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    str4 = null;
                }
                return profileApi.authenticateWithAppleLegacy(str, str2, str3, str4, str5, str6);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: authenticateWithAppleLegacy");
        }

        public static /* synthetic */ Observable confirmPhone$default(ProfileApi profileApi, String str, String str2, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z2 = true;
                }
                return profileApi.confirmPhone(str, str2, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: confirmPhone");
        }

        public static /* synthetic */ Observable getProfileAvatar$default(ProfileApi profileApi, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return profileApi.getProfileAvatar(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProfileAvatar");
        }

        public static /* synthetic */ Observable requestPhoneConfirmationCode$default(ProfileApi profileApi, String str, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z2 = true;
                }
                return profileApi.requestPhoneConfirmationCode(str, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestPhoneConfirmationCode");
        }
    }

    @NotNull
    @FormUrlEncoded
    @POST("3/profile/social/{socialNetworkType}")
    Observable<TypedResult<Social>> addSocialNetwork(@Path("socialNetworkType") @NotNull String str, @Field("accessToken") @Nullable String str2, @Field("code") @Nullable String str3);

    @NotNull
    @NetworkRequestEventId(eventId = 3717)
    @FormUrlEncoded
    @POST("1/phones/apply")
    Observable<TypedResult<Unit>> applyPhoneToItems(@Field("phone") @NotNull String str, @Field("items") @NotNull String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3717)
    @FormUrlEncoded
    @POST("1/phones/apply")
    Single<TypedResult<Unit>> applyPhoneToItemsSingle(@Field("phone") @NotNull String str, @Field("items") @NotNull String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3614)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("10/auth")
    Observable<TypedResult<LoginResult>> authenticate(@Field("login") @NotNull String str, @Field("password") @NotNull String str2, @Field("token") @Nullable String str3, @Field("provider") @Nullable String str4, @Field("isSandbox") boolean z);

    @NotNull
    @NetworkRequestEventId(eventId = 3614)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("10/auth")
    Observable<TypedResult<LoginResult>> authenticateLegacy(@Field("login") @NotNull String str, @Field("password") @NotNull String str2, @Field("token") @Nullable String str3);

    @NotNull
    @NetworkRequestEventId(eventId = 3615)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("5/auth/social/{networkType}")
    Observable<TypedResult<SocialAuthResult>> authenticateSocial(@Path("networkType") @NotNull String str, @Field("accessToken") @NotNull String str2, @Field("token") @Nullable String str3, @Field("provider") @Nullable String str4, @Field("email") @Nullable String str5, @Field("socialUserId") @Nullable String str6, @Field("isSandbox") boolean z, @Field("suggestKey") @Nullable String str7);

    @NotNull
    @NetworkRequestEventId(eventId = 3615)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("5/auth/social/{networkType}")
    Observable<TypedResult<SocialAuthResult>> authenticateSocialLegacy(@Path("networkType") @NotNull String str, @Field("accessToken") @NotNull String str2, @Field("token") @Nullable String str3, @Field("email") @Nullable String str4, @Field("socialUserId") @Nullable String str5, @Field("suggestKey") @Nullable String str6);

    @NotNull
    @NetworkRequestEventId(eventId = 3614)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("11/auth")
    Observable<TypedResult<LoginResult>> authenticateWithAntihackPro(@Field("login") @NotNull String str, @Field("password") @NotNull String str2, @Field("token") @Nullable String str3, @Field("provider") @Nullable String str4, @Field("isSandbox") boolean z, @Field("suggestKey") @Nullable String str5);

    @NotNull
    @NetworkRequestEventId(eventId = 3614)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("11/auth")
    Observable<TypedResult<LoginResult>> authenticateWithAntihackProLegacy(@Field("login") @NotNull String str, @Field("password") @NotNull String str2, @Field("token") @Nullable String str3, @Field("suggestKey") @Nullable String str4);

    @NotNull
    @NetworkRequestEventId(eventId = 3615)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("5/auth/social/apple")
    Observable<TypedResult<SocialAuthResult>> authenticateWithApple(@Field("code") @NotNull String str, @Field("token") @Nullable String str2, @Field("provider") @Nullable String str3, @Field("user") @Nullable String str4, @Field("state") @Nullable String str5, @Field("socialUserId") @Nullable String str6, @Field("isSandbox") boolean z, @Field("suggestKey") @Nullable String str7);

    @NotNull
    @NetworkRequestEventId(eventId = 3615)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("5/auth/social/apple")
    Observable<TypedResult<SocialAuthResult>> authenticateWithAppleLegacy(@Field("code") @NotNull String str, @Field("token") @Nullable String str2, @Field("user") @Nullable String str3, @Field("state") @Nullable String str4, @Field("socialUserId") @Nullable String str5, @Field("suggestKey") @Nullable String str6);

    @NotNull
    @FormUrlEncoded
    @POST("1/tfa/auth")
    Observable<TypedResult<LoginResult>> authenticateWithTfaCode(@Field("code") @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/profile/password/change")
    Observable<TypedResult<PasswordChangeResult>> changePassword(@Field("oldpass") @NotNull String str, @Field("password") @NotNull String str2, @Field("token") @Nullable String str3, @Field("sessionHashId") @Nullable String str4, @Field("source") @Nullable String str5);

    @NotNull
    @NetworkRequestEventId(eventId = 3721)
    @FormUrlEncoded
    @POST("2/phones/link/pretend")
    Observable<SuccessResult> checkPhoneNumber(@Field("phone") @NotNull String str, @Field("isCompany") boolean z);

    @NotNull
    @NetworkRequestEventId(eventId = 3804)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("1/register/complete")
    Observable<TypedResult<LoginResult>> completeRegistration(@Field("hash") @NotNull String str, @Field("name") @NotNull String str2, @Field("password") @NotNull String str3, @Field("token") @Nullable String str4, @Field("provider") @Nullable String str5, @Field("isSandbox") boolean z);

    @NotNull
    @NetworkRequestEventId(eventId = 3804)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("1/register/complete")
    Observable<TypedResult<LoginResult>> completeRegistrationLegacy(@Field("hash") @NotNull String str, @Field("name") @NotNull String str2, @Field("password") @NotNull String str3, @Field("token") @Nullable String str4);

    @NotNull
    @NetworkRequestEventId(eventId = 3618)
    @FormUrlEncoded
    @POST("1/code/confirm")
    Observable<TypedResult<ConfirmCodeResult>> confirmCode(@Field("login") @NotNull String str, @Field("code") @NotNull String str2, @Field("src") @NotNull String str3);

    @NotNull
    @NetworkRequestEventId(eventId = 3618)
    @FormUrlEncoded
    @POST("1/code/confirm")
    Single<TypedResult<ConfirmCodeResult>> confirmCodeSingle(@Field("login") @NotNull String str, @Field("code") @NotNull String str2, @Field("src") @NotNull String str3);

    @NotNull
    @NetworkRequestEventId(eventId = 3720)
    @FormUrlEncoded
    @POST("2/phones/link/check")
    Observable<SuccessResult> confirmPhone(@Field("phone") @NotNull String str, @Field("code") @NotNull String str2, @Field("isCompany") boolean z, @Field("needsAuthentication") boolean z2);

    @NotNull
    @FormUrlEncoded
    @POST("1/developments-advice/confirmPhone")
    Observable<TypedResult<ConsultationPhoneConfirmationResult>> confirmPhoneConsultation(@Field("phone") @NotNull String str, @Field("code") @NotNull String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3800)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("1/recover/by_phone/confirm")
    Observable<TypedResult<ConfirmPasswordRecoveryByPhoneResult>> confirmRecoverPasswordByPhone(@Field("phone") @NotNull String str, @Field("code") @NotNull String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/auth/social/register/proceed")
    Observable<TypedResult<AuthResult>> createProfile(@Field("type") @NotNull String str, @Field("token") @Nullable String str2, @Field("provider") @Nullable String str3, @Field("isSandbox") boolean z, @Field("suggestKey") @NotNull String str4);

    @DELETE("1/profile/avatar")
    @NotNull
    Observable<Avatar> deleteAvatar();

    @NotNull
    @NetworkRequestEventId(eventId = 3718)
    @FormUrlEncoded
    @POST("1/phones/delete")
    Observable<TypedResult<Unit>> deletePhone(@Field("phone") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3718)
    @FormUrlEncoded
    @POST("1/phones/delete")
    Single<TypedResult<Unit>> deletePhoneSingle(@Field("phone") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3639)
    @POST("1/delivery/toggleUserDefault")
    Observable<TypedResult<Unit>> deliveryToggleUserDefault(@Query("enabled") boolean z);

    @PATCH("3/profile")
    @NotNull
    @FormUrlEncoded
    Observable<SuccessResult> editProfile(@FieldMap @NotNull Map<String, String> map);

    @GET("1/auth/suggest")
    @NotNull
    Observable<TypedResult<AuthSuggestsResult>> getAuthSuggests(@QueryMap @NotNull Map<String, String> map);

    @NotNull
    @FormUrlEncoded
    @POST("1/developments-advice/getConfirmCode")
    Observable<TypedResult<ConsultationPhoneConfirmationStatus>> getConfirmCodeConsultation(@Field("phone") @NotNull String str);

    @GET("1/delivery/userProfile")
    @NotNull
    @NetworkRequestEventId(eventId = 3640)
    Observable<TypedResult<DeliveryProfileSettingsResponse>> getDeliveryUserProfile();

    @GET("2/profile/income/settings")
    @NotNull
    Observable<TypedResult<IncomeProfileSettingsResponse>> getIncomeUserSettings();

    @GET("4/profile")
    @NotNull
    @NetworkRequestEventId(eventId = 3724)
    Observable<Profile> getProfile();

    @GET("1/profile/avatar")
    @NotNull
    Observable<Avatar> getProfileAvatar(@Query("isPublic") boolean z);

    @GET("6/profile/info")
    @NotNull
    Observable<TypedResult<UserProfileResult>> getProfileInfoV6();

    @GET("3/phones")
    @NotNull
    @NetworkRequestEventId(eventId = 3716)
    Single<TypedResult<PhonesList>> getProfilePhones();

    @GET("3/profile/social")
    @NotNull
    @NetworkRequestEventId(eventId = 3774)
    Observable<TypedResult<Social>> getSocialNetworks();

    @NotNull
    @FormUrlEncoded
    @POST("1/phones/verification/requestCallback")
    Single<TypedResult<Unit>> landlinePhoneRequestVerificationCall(@Field("phone") @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/phones/verification/status")
    Single<TypedResult<LandlinePhoneVerificationStatusResult>> landlinePhoneVerificationStatus(@Field("callID") int i);

    @NotNull
    @NetworkRequestEventId(eventId = 3614)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("9/auth")
    Observable<TypedResult<LoginResult>> legacyAuthenticate(@Field("login") @NotNull String str, @Field("password") @NotNull String str2, @Field("token") @Nullable String str3, @Field("provider") @Nullable String str4, @Field("isSandbox") boolean z);

    @NotNull
    @NetworkRequestEventId(eventId = 3614)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("9/auth")
    Observable<TypedResult<LoginResult>> legacyAuthenticateLegacy(@Field("login") @NotNull String str, @Field("password") @NotNull String str2, @Field("token") @Nullable String str3);

    @GET("1/register/profiles/list")
    @NotNull
    @NetworkRequestEventId(eventId = 3806)
    Observable<TypedResult<ListProfilesResult>> listProfiles(@NotNull @Query("hash") String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3770)
    @FormUrlEncoded
    @POST("2/profile/logout")
    Observable<SuccessResult> logout(@Field("token") @Nullable String str, @Field("provider") @Nullable String str2, @Field("isSandbox") boolean z);

    @NotNull
    @NetworkRequestEventId(eventId = 3770)
    @FormUrlEncoded
    @POST("2/profile/logout")
    Observable<SuccessResult> logoutLegacy(@Field("token") @Nullable String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3616)
    @FormUrlEncoded
    @POST("1/auth/verification")
    Observable<TypedResult<Unit>> proviePhone(@Field("challengeId") @NotNull String str, @Field("passphrase") @NotNull String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3798)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("1/recover/by_email")
    Observable<SuccessResult> recoverPasswordByEmail(@Field("email") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3799)
    @FormUrlEncoded
    @POST("1/recover/by_phone")
    Observable<TypedResult<RecoverByPhoneResult>> recoverPasswordByPhone(@Field("phone") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3807)
    @FormUrlEncoded
    @POST("2/register/social")
    Observable<AuthResult> registerSocial(@Field("session") @NotNull String str, @Field("email") @NotNull String str2, @Field("phone") @NotNull String str3, @Field("name") @NotNull String str4, @Field("subscribe") boolean z, @Field("locationId") @Nullable String str5, @Field("metroId") @Nullable String str6, @Field("districtId") @Nullable String str7);

    @DELETE("3/profile/social/{socialNetworkType}")
    @NotNull
    Observable<TypedResult<Social>> removeSocialNetwork(@Path("socialNetworkType") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3723)
    @FormUrlEncoded
    @POST("2/phones/replace")
    Single<TypedResult<Unit>> replacePhone(@Field("currentPhone") @NotNull String str, @Field("targetPhone") @NotNull String str2, @Field("shouldDeleteAfterReplace") boolean z);

    @NotNull
    @NetworkRequestEventId(eventId = 3723)
    @FormUrlEncoded
    @POST("1/phones/replace")
    Observable<TypedResult<Unit>> replacePhoneOld(@Field("currentPhone") @NotNull String str, @Field("targetPhone") @NotNull String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3619)
    @FormUrlEncoded
    @POST("1/code/request")
    Observable<TypedResult<RequestCodeResult>> requestCode(@Field("login") @NotNull String str, @Field("retry") boolean z, @Field("src") @NotNull String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3619)
    @FormUrlEncoded
    @POST("1/code/request")
    Single<TypedResult<RequestCodeResult>> requestCodeSingle(@Field("login") @NotNull String str, @Field("retry") boolean z, @Field("src") @NotNull String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3619)
    @FormUrlEncoded
    @POST("2/code/request")
    Single<TypedResult<RequestCodeResult>> requestCodeV2(@Field("login") @NotNull String str, @Field("retry") boolean z, @Field("src") @NotNull String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/request/verification_by_phone")
    Observable<TypedResult<RequestPhoneAntihackCodeResult>> requestPhoneAntihackCode(@Field("login") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3719)
    @FormUrlEncoded
    @POST("2/phones/link")
    Observable<PhoneConfirmationStatus> requestPhoneConfirmationCode(@Field("phone") @NotNull String str, @Field("isCompany") boolean z, @Field("needsAuthentication") boolean z2);

    @NotNull
    @FormUrlEncoded
    @POST("1/tfa/request")
    Observable<TypedResult<TfaCodeResult>> requestTfaCode(@Field("phone") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3801)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("1/recover/reset_password")
    Observable<TypedResult<ResetPasswordResult>> resetPassword(@Field("password") @NotNull String str, @Field("hash") @NotNull String str2, @Field("type") @NotNull String str3);

    @NotNull
    @FormUrlEncoded
    @POST("1/auth/verification_by_phone")
    Observable<TypedResult<SendPhoneAntihackCodeResult>> sendPhoneAntihackCode(@Field("login") @NotNull String str, @Field("code") @NotNull String str2, @Field("challengeId") @NotNull String str3);

    @NotNull
    @FormUrlEncoded
    @POST("1/profile/password/set")
    Observable<TypedResult<PasswordChangeResult>> setPassword(@Field("password") @NotNull String str, @Field("token") @Nullable String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/profile/tfa/settings")
    Observable<TypedResult<TfaSettingsResult>> setTfaEnabled(@Field("isEnabled") boolean z);

    @POST("1/income/toggleUserDefault")
    @NotNull
    Observable<TypedResult<Unit>> toggleIncomeSettingTo(@Query("enabled") boolean z);

    @NotNull
    @POST("1/profile/avatar")
    @Multipart
    Observable<Avatar> uploadAvatar(@NotNull @Part MultipartBody.Part part);

    @NotNull
    @FormUrlEncoded
    @POST("1/phones/verification/validate")
    Single<TypedResult<PhoneValidationResult>> validatePhone(@Field("phone") @NotNull String str);
}

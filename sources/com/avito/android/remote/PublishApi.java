package com.avito.android.remote;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.annotations.PretendError;
import com.avito.android.remote.model.CategoriesSuggestResponse;
import com.avito.android.remote.model.CpaContactInfoResponse;
import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PostAdvertResult;
import com.avito.android.remote.model.PublishAnonymousNumber;
import com.avito.android.remote.model.PublishDraftResponse;
import com.avito.android.remote.model.ResidentialComplexResponse;
import com.avito.android.remote.model.SaveDraftResponse;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.VideoPreview;
import com.avito.android.remote.model.WizardParameter;
import com.avito.android.remote.model.adverts.AdvertProactiveModerationResult;
import com.avito.android.remote.model.adverts.EditAdvertResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.slot.auto_publish.AutoPublishResponse;
import com.avito.android.remote.model.category_parameters.slot.market_price.MarketPriceResponse;
import com.avito.android.remote.model.sts_recognition.StsRecognitionResult;
import com.avito.android.remote.model.suggests.TitleSuggestsResponse;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JQ\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0014\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\fJQ\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0014\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\fJI\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u000f\u0010\u0010JI\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0011\u0010\u0010Js\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0003\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0003\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017Js\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0003\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0003\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0014H'¢\u0006\u0004\b\u0018\u0010\u0017J[\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001b2\b\b\u0001\u0010\u0019\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H'¢\u0006\u0004\b\u001c\u0010\u001dJ[\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001b2\b\b\u0001\u0010\u0019\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H'¢\u0006\u0004\b\u001e\u0010\u001dJ[\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\t0\u001b2\b\b\u0001\u0010 \u001a\u00020\u001f2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H'¢\u0006\u0004\b\"\u0010#JQ\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001b2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H'¢\u0006\u0004\b$\u0010%JK\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001b2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\b'\u0010(J;\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\t0\b2\b\b\u0001\u0010)\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00022\n\b\u0001\u0010+\u001a\u0004\u0018\u00010*H'¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001b2\b\b\u0001\u0010/\u001a\u00020\u0002H'¢\u0006\u0004\b1\u00102JS\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\t0\u001b2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0016\b\u0001\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\b4\u0010(J[\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\t0\u001b2\b\b\u0001\u00105\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\b7\u00108J}\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\t0\u001b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010+\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0001\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u00109\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010:\u001a\u00020\u00142\u0014\b\u0001\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H'¢\u0006\u0004\b;\u0010<JW\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u001b2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00022\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b>\u0010?J}\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\t0\u001b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010+\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0001\u00109\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010@\u001a\u0004\u0018\u00010\u00022\u0014\b\u0001\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\bB\u0010CJ}\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\t0\u001b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010+\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0001\u00109\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010@\u001a\u0004\u0018\u00010\u00022\u0014\b\u0001\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\bD\u0010CJ3\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010E\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\bG\u0010HJ]\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\t0\u001b2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\bJ\u0010?J]\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\t0\u001b2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\bL\u0010?J=\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0\t0\u001b2\b\b\u0001\u0010)\u001a\u00020\u00022\n\b\u0003\u0010N\u001a\u0004\u0018\u00010M2\n\b\u0003\u0010O\u001a\u0004\u0018\u00010MH'¢\u0006\u0004\bQ\u0010RJ\u001b\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0\t0\bH'¢\u0006\u0004\bT\u0010UJ·\u0001\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\\0\t0\b2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010V\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0003\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0003\u0010Y\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u00109\u001a\u0004\u0018\u00010*2\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010[\u001a\u0004\u0018\u00010\u0014H'¢\u0006\u0004\b]\u0010^J%\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0\t0\u001b2\b\b\u0001\u0010_\u001a\u00020\u0002H'¢\u0006\u0004\ba\u00102J\u001b\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0\t0\bH'¢\u0006\u0004\bc\u0010UJ\u001b\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0\t0\u001bH'¢\u0006\u0004\be\u0010fJ9\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t0\u001b2\b\b\u0001\u00105\u001a\u00020\u00022\b\b\u0001\u0010g\u001a\u00020\u00022\b\b\u0001\u0010+\u001a\u00020*H'¢\u0006\u0004\bh\u0010i¨\u0006j"}, d2 = {"Lcom/avito/android/remote/PublishApi;", "", "", "itemId", "", "navigation", "stepId", "publishSessionId", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "getCategoryParametersForEditingWithNavigation", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "getCategoryParametersForEditingWithNavigationV6", "draftId", "getStepsAndParametersWithDraftValues", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "getStepsAndParametersWithDraftValuesV6", "params", "slots", "", "isNeedTargetStep", "loadExtraStepsAndParameters", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Single;", "loadExtraStepsAndParametersV6", "vin", "paramsAndSlots", "Lio/reactivex/rxjava3/core/Observable;", "getPublishParametersByVinV3", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "getPublishParametersByVinV4", "Lokhttp3/MultipartBody$Part;", "file", "Lcom/avito/android/remote/model/sts_recognition/StsRecognitionResult;", "getPublishParametersByStsV4", "(Lokhttp3/MultipartBody$Part;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "getPublishParametersByGeo", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/CategoriesSuggestResponse;", "getCategoriesSuggest", "(Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "query", "", "categoryId", "Lcom/avito/android/remote/model/suggests/TitleSuggestsResponse;", "getTitleSuggest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/Single;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/remote/model/SuccessResult;", "publishAdvert", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult;", "checkAdvertProactiveModerationV4", "phone", "Lcom/avito/android/remote/model/PublishAnonymousNumber;", "checkAnonymousNumberPublishV3", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "version", "phoneOnly", "checkAnonymousNumberEditV3", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/PostAdvertResult;", "postAdvertV15", "(Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "postAction", "Lcom/avito/android/remote/model/adverts/EditAdvertResult;", "editItemV13", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "editItemV14", "action", "Lcom/avito/android/remote/model/ItemBrief;", "getItemBriefV2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse;", "getMarketPrice", "Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishResponse;", "checkAutoPublish", "", "lat", "lng", "Lcom/avito/android/remote/model/ResidentialComplexResponse;", "getResidentialComplexSuggest", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/PublishDraftResponse;", "getLatestDraft", "()Lio/reactivex/rxjava3/core/Single;", "deviceId", Navigation.ATTRIBUTES, "state", "id", "activeFieldId", "needsResultMessage", "Lcom/avito/android/remote/model/SaveDraftResponse;", "saveDraft", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Single;", "url", "Lcom/avito/android/remote/model/VideoPreview;", "getVideoPreview", "Lcom/avito/android/remote/model/WizardParameter;", "getRootWizardParameters", "Lcom/avito/android/remote/model/CpaContactInfoResponse;", "getContactInfo", "()Lio/reactivex/rxjava3/core/Observable;", "name", "createCpaTariffRequest", "(Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Observable;", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.PublishApi */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Single getCategoryParametersForEditingWithNavigation$default(PublishApi publishApi, String str, Map map, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map = r.emptyMap();
                }
                if ((i & 4) != 0) {
                    str2 = null;
                }
                return publishApi.getCategoryParametersForEditingWithNavigation(str, map, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCategoryParametersForEditingWithNavigation");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.PublishApi */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Single getCategoryParametersForEditingWithNavigationV6$default(PublishApi publishApi, String str, Map map, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map = r.emptyMap();
                }
                if ((i & 4) != 0) {
                    str2 = null;
                }
                return publishApi.getCategoryParametersForEditingWithNavigationV6(str, map, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCategoryParametersForEditingWithNavigationV6");
        }

        public static /* synthetic */ Single getItemBriefV2$default(PublishApi publishApi, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "edit";
                }
                return publishApi.getItemBriefV2(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getItemBriefV2");
        }

        public static /* synthetic */ Observable getResidentialComplexSuggest$default(PublishApi publishApi, String str, Double d, Double d2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    d = null;
                }
                if ((i & 4) != 0) {
                    d2 = null;
                }
                return publishApi.getResidentialComplexSuggest(str, d, d2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getResidentialComplexSuggest");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.remote.PublishApi */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Single loadExtraStepsAndParameters$default(PublishApi publishApi, String str, Map map, Map map2, Map map3, Boolean bool, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    map2 = r.emptyMap();
                }
                if ((i & 8) != 0) {
                    map3 = r.emptyMap();
                }
                return publishApi.loadExtraStepsAndParameters(str, map, map2, map3, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadExtraStepsAndParameters");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.remote.PublishApi */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Single loadExtraStepsAndParametersV6$default(PublishApi publishApi, String str, Map map, Map map2, Map map3, Boolean bool, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    map2 = r.emptyMap();
                }
                if ((i & 8) != 0) {
                    map3 = r.emptyMap();
                }
                return publishApi.loadExtraStepsAndParametersV6(str, map, map2, map3, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadExtraStepsAndParametersV6");
        }

        public static /* synthetic */ Single saveDraft$default(PublishApi publishApi, String str, String str2, Map map, Map map2, Map map3, Map map4, String str3, Integer num, String str4, Boolean bool, int i, Object obj) {
            if (obj == null) {
                return publishApi.saveDraft(str, str2, map, map2, map3, (i & 32) != 0 ? r.emptyMap() : map4, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : num, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveDraft");
        }
    }

    @NotNull
    @NetworkRequestEventId(eventId = 3660)
    @FormUrlEncoded
    @POST("4/items/check/proactiveModeration")
    Observable<TypedResult<AdvertProactiveModerationResult>> checkAdvertProactiveModerationV4(@FieldMap @NotNull Map<String, String> map, @FieldMap @Nullable Map<String, String> map2, @Field("publishSessionId") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3611)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("3/anonymousNumber/check")
    Observable<TypedResult<PublishAnonymousNumber>> checkAnonymousNumberEditV3(@Field("itemId") @NotNull String str, @Field("categoryId") @NotNull String str2, @FieldMap @NotNull Map<String, String> map, @Field("phone") @Nullable String str3, @Field("version") @Nullable String str4, @Field("phoneOnly") boolean z, @FieldMap @NotNull Map<String, String> map2);

    @NotNull
    @NetworkRequestEventId(eventId = 3611)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @POST("3/anonymousNumber/check")
    Observable<TypedResult<PublishAnonymousNumber>> checkAnonymousNumberPublishV3(@Field("phone") @NotNull String str, @FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2, @Field("publishSessionId") @NotNull String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/autoPublish/check")
    Observable<TypedResult<AutoPublishResponse>> checkAutoPublish(@FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2, @Field("itemId") @Nullable String str, @Field("publishSessionId") @NotNull String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/cpa/create_request")
    Observable<TypedResult<Object>> createCpaTariffRequest(@Field("phone") @NotNull String str, @Field("name") @NotNull String str2, @Field("categoryId") int i);

    @NotNull
    @NetworkRequestEventId(eventId = 3750)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @PretendError
    @POST("13/profile/item/{itemId}/edit")
    Observable<TypedResult<EditAdvertResult>> editItemV13(@Path("itemId") @NotNull String str, @Field("categoryId") @NotNull String str2, @FieldMap @NotNull Map<String, String> map, @Field("version") @Nullable String str3, @Field("postAction") @Nullable String str4, @FieldMap @NotNull Map<String, String> map2, @Field("publishSessionId") @NotNull String str5);

    @NotNull
    @NetworkRequestEventId(eventId = 3750)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @PretendError
    @POST("14/profile/item/{itemId}/edit")
    Observable<TypedResult<EditAdvertResult>> editItemV14(@Path("itemId") @NotNull String str, @Field("categoryId") @NotNull String str2, @FieldMap @NotNull Map<String, String> map, @Field("version") @Nullable String str3, @Field("postAction") @Nullable String str4, @FieldMap @NotNull Map<String, String> map2, @Field("publishSessionId") @NotNull String str5);

    @NotNull
    @NetworkRequestEventId(eventId = 3778)
    @FormUrlEncoded
    @POST("5/publish/categories/suggest/by_params")
    Observable<CategoriesSuggestResponse> getCategoriesSuggest(@FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2, @Field("publishSessionId") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3644)
    @FormUrlEncoded
    @POST("5/dicts/parameters")
    Single<TypedResult<CategoryParameters>> getCategoryParametersForEditingWithNavigation(@Field("itemId") @NotNull String str, @FieldMap @NotNull Map<String, String> map, @Field("stepId") @Nullable String str2, @Field("publishSessionId") @NotNull String str3);

    @NotNull
    @NetworkRequestEventId(eventId = 3644)
    @FormUrlEncoded
    @POST("6/dicts/parameters")
    Single<TypedResult<CategoryParameters>> getCategoryParametersForEditingWithNavigationV6(@Field("itemId") @NotNull String str, @FieldMap @NotNull Map<String, String> map, @Field("stepId") @Nullable String str2, @Field("publishSessionId") @NotNull String str3);

    @POST("1/developments-advice/getContactInfo")
    @NotNull
    Observable<TypedResult<CpaContactInfoResponse>> getContactInfo();

    @NotNull
    @NetworkRequestEventId(eventId = 3748)
    @FormUrlEncoded
    @POST("2/profile/item/{itemId}/brief")
    Single<ItemBrief> getItemBriefV2(@Path("itemId") @NotNull String str, @Field("action") @NotNull String str2, @Field("publishSessionId") @NotNull String str3);

    @GET("1/item/draft/getInitialDialog")
    @NotNull
    Single<TypedResult<PublishDraftResponse>> getLatestDraft();

    @NotNull
    @FormUrlEncoded
    @POST("1/item/publish/getIMVPrice")
    Observable<TypedResult<MarketPriceResponse>> getMarketPrice(@FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2, @Field("itemId") @Nullable String str, @Field("publishSessionId") @NotNull String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/publish/parameters/suggest/by_geo")
    Observable<TypedResult<CategoryParameters>> getPublishParametersByGeo(@NotNull @Query("publishSessionId") String str, @FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2);

    @NotNull
    @NetworkRequestEventId(eventId = 3784)
    @POST("4/publish/parameters/suggest/by_sts")
    @Multipart
    Observable<TypedResult<StsRecognitionResult>> getPublishParametersByStsV4(@NotNull @Part MultipartBody.Part part, @NotNull @Query("publishSessionId") String str, @QueryMap @NotNull Map<String, String> map, @QueryMap @NotNull Map<String, String> map2);

    @NotNull
    @NetworkRequestEventId(eventId = 3785)
    @FormUrlEncoded
    @POST("3/publish/parameters/suggest/by_vin")
    Observable<TypedResult<CategoryParameters>> getPublishParametersByVinV3(@NotNull @Query("vin") String str, @NotNull @Query("publishSessionId") String str2, @FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2);

    @NotNull
    @NetworkRequestEventId(eventId = 3785)
    @FormUrlEncoded
    @POST("4/publish/parameters/suggest/by_vin")
    Observable<TypedResult<CategoryParameters>> getPublishParametersByVinV4(@NotNull @Query("vin") String str, @NotNull @Query("publishSessionId") String str2, @FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2);

    @NotNull
    @FormUrlEncoded
    @POST("1/development/suggest")
    Observable<TypedResult<ResidentialComplexResponse>> getResidentialComplexSuggest(@Field("query") @NotNull String str, @Field("latitude") @Nullable Double d, @Field("longitude") @Nullable Double d2);

    @POST("1/dicts/navigation")
    @NotNull
    Single<TypedResult<WizardParameter>> getRootWizardParameters();

    @NotNull
    @NetworkRequestEventId(eventId = 3644)
    @FormUrlEncoded
    @POST("5/dicts/parameters")
    Single<TypedResult<CategoryParameters>> getStepsAndParametersWithDraftValues(@Field("publishSessionId") @Nullable String str, @FieldMap @NotNull Map<String, String> map, @Field("draftId") @Nullable String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3644)
    @FormUrlEncoded
    @POST("6/dicts/parameters")
    Single<TypedResult<CategoryParameters>> getStepsAndParametersWithDraftValuesV6(@Field("publishSessionId") @Nullable String str, @FieldMap @NotNull Map<String, String> map, @Field("draftId") @Nullable String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3778)
    @FormUrlEncoded
    @POST("1/publish/title/suggest")
    Single<TypedResult<TitleSuggestsResponse>> getTitleSuggest(@Field("query") @NotNull String str, @Field("esid") @NotNull String str2, @Field("categoryId") @Nullable Integer num);

    @GET("1/video")
    @NotNull
    Observable<TypedResult<VideoPreview>> getVideoPreview(@NotNull @Query("url") String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3644)
    @FormUrlEncoded
    @POST("5/dicts/parameters")
    Single<TypedResult<CategoryParameters>> loadExtraStepsAndParameters(@Field("publishSessionId") @NotNull String str, @FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2, @FieldMap @NotNull Map<String, String> map3, @Field("needsTargetStep") @Nullable Boolean bool);

    @NotNull
    @NetworkRequestEventId(eventId = 3644)
    @FormUrlEncoded
    @POST("6/dicts/parameters")
    Single<TypedResult<CategoryParameters>> loadExtraStepsAndParametersV6(@Field("publishSessionId") @NotNull String str, @FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2, @FieldMap @NotNull Map<String, String> map3, @Field("needsTargetStep") @Nullable Boolean bool);

    @NotNull
    @NetworkRequestEventId(eventId = 3657)
    @FormUrlEncoded
    @Headers({ConstsKt.GEO})
    @PretendError
    @POST("15/items/add")
    Observable<PostAdvertResult> postAdvertV15(@FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2, @Field("publishSessionId") @NotNull String str, @Field("draftId") @Nullable String str2);

    @POST("2/profile/item/{itemId}/publish")
    @NotNull
    Observable<SuccessResult> publishAdvert(@Path("itemId") @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/item/draft/save")
    Single<TypedResult<SaveDraftResponse>> saveDraft(@Field("publishSessionId") @NotNull String str, @Field("deviceId") @NotNull String str2, @FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2, @FieldMap @NotNull Map<String, String> map3, @FieldMap @NotNull Map<String, String> map4, @Field("id") @Nullable String str3, @Field("version") @Nullable Integer num, @Field("activeFieldId") @Nullable String str4, @Field("needsResultMessage") @Nullable Boolean bool);
}

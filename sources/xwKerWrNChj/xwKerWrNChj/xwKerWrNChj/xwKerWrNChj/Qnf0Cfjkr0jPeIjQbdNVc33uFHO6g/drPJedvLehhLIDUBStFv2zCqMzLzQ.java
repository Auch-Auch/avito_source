package xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g;

import a2.b.a.a.a;
import androidx.lifecycle.ViewModelKt;
import com.sumsub.sns.core.domain.FaceDetector;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import timber.log.Timber;
import xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo;
public final class drPJedvLehhLIDUBStFv2zCqMzLzQ extends Lambda implements Function1<FaceDetector.FaceDetectorResult, Unit> {
    public final /* synthetic */ tjrpI83q5sk1iMEXPz1hKo Cwa7EHp4RmMFhwpOCPWojiqbo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public drPJedvLehhLIDUBStFv2zCqMzLzQ(tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko) {
        super(1);
        this.Cwa7EHp4RmMFhwpOCPWojiqbo = tjrpi83q5sk1imexpz1hko;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(FaceDetector.FaceDetectorResult faceDetectorResult) {
        FaceDetector.FaceDetectorResult faceDetectorResult2 = faceDetectorResult;
        tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
        FaceDetector.RawImage image = faceDetectorResult2.getImage();
        if (tjrpi83q5sk1imexpz1hko.mdHgHuGChkRJqBUMUk707 <= 0 && tjrpi83q5sk1imexpz1hko.qNDua1J9EaZOsmugz0J != 0 && System.currentTimeMillis() - tjrpi83q5sk1imexpz1hko.aHA7rWvEdW6bbOdx1EKD4aVF0k >= 0) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(tjrpi83q5sk1imexpz1hko), null, null, new djGN3DbfslkNo4T0(tjrpi83q5sk1imexpz1hko, image, new FaceDetector.Size(image.getWidth(), image.getHeight()), "NOT_ALIGNED", null), 3, null);
            tjrpi83q5sk1imexpz1hko.aHA7rWvEdW6bbOdx1EKD4aVF0k = System.currentTimeMillis() + ((long) 8000);
        }
        if (faceDetectorResult2 instanceof FaceDetector.FaceDetectorResult.NoFace) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.cPMlB5HN7W4Ve3yHBwMXNEUvD.postValue(tjrpI83q5sk1iMEXPz1hKo.BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.Cwa7EHp4RmMFhwpOCPWojiqbo);
        } else if (faceDetectorResult2 instanceof FaceDetector.FaceDetectorResult.TooManyFaces) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.cPMlB5HN7W4Ve3yHBwMXNEUvD.postValue(tjrpI83q5sk1iMEXPz1hKo.BYfFGQyI88.alNh9hLeM39.Cwa7EHp4RmMFhwpOCPWojiqbo);
        } else if (faceDetectorResult2 instanceof FaceDetector.FaceDetectorResult.NotInCaptureBox) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.cPMlB5HN7W4Ve3yHBwMXNEUvD.postValue(new tjrpI83q5sk1iMEXPz1hKo.BYfFGQyI88.C0694BYfFGQyI88(((FaceDetector.FaceDetectorResult.NotInCaptureBox) faceDetectorResult2).getFaceBox()));
        } else if (faceDetectorResult2 instanceof FaceDetector.FaceDetectorResult.Error) {
            StringBuilder L = a.L("FaceDetectorResult: ");
            L.append(((FaceDetector.FaceDetectorResult.Error) faceDetectorResult2).getE());
            Timber.e(L.toString(), new Object[0]);
        } else if (faceDetectorResult2 instanceof FaceDetector.FaceDetectorResult.FaceSegment) {
            FaceDetector.FaceDetectorResult.FaceSegment faceSegment = (FaceDetector.FaceDetectorResult.FaceSegment) faceDetectorResult2;
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.cPMlB5HN7W4Ve3yHBwMXNEUvD.postValue(new tjrpI83q5sk1iMEXPz1hKo.BYfFGQyI88.VVeXCTyov0hLti0HOLqom2taL0gk(faceSegment.getFaceBox()));
            tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko2 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            if (!tjrpi83q5sk1imexpz1hko2.YWVVuaVDYicbKjhsZbjQiRooZ) {
                tjrpi83q5sk1imexpz1hko2.idM1z15K75 = System.currentTimeMillis() + ((long) 200);
            } else {
                int i = tjrpi83q5sk1imexpz1hko2.mdHgHuGChkRJqBUMUk707;
                if (i == tjrpi83q5sk1imexpz1hko2.qNDua1J9EaZOsmugz0J && i > 0 && tjrpi83q5sk1imexpz1hko2.lk42nG4RRcMiHe8r6w == null) {
                    Timer timer = new Timer();
                    timer.schedule(new A8EntBCcqmn(tjrpi83q5sk1imexpz1hko2), TimeUnit.SECONDS.toMillis(2));
                    tjrpi83q5sk1imexpz1hko2.lk42nG4RRcMiHe8r6w = timer;
                }
                if (tjrpi83q5sk1imexpz1hko2.mdHgHuGChkRJqBUMUk707 < tjrpi83q5sk1imexpz1hko2.qNDua1J9EaZOsmugz0J && System.currentTimeMillis() - tjrpi83q5sk1imexpz1hko2.idM1z15K75 >= 0) {
                    tjrpi83q5sk1imexpz1hko2.mdHgHuGChkRJqBUMUk707++;
                    BuildersKt.launch$default(ViewModelKt.getViewModelScope(tjrpi83q5sk1imexpz1hko2), null, null, new djGN3DbfslkNo4T0(tjrpi83q5sk1imexpz1hko2, faceSegment.getImage(), faceSegment.getTrackSize(), "OK", null), 3, null);
                    tjrpi83q5sk1imexpz1hko2.idM1z15K75 = System.currentTimeMillis() + ((long) 200);
                    tjrpi83q5sk1imexpz1hko2.M6kaoQeazePMH0Sq8.postValue(new tjrpI83q5sk1iMEXPz1hKo.alNh9hLeM39.C0698alNh9hLeM39(((float) tjrpi83q5sk1imexpz1hko2.mdHgHuGChkRJqBUMUk707) / ((float) tjrpi83q5sk1imexpz1hko2.qNDua1J9EaZOsmugz0J)));
                }
            }
        }
        return Unit.INSTANCE;
    }
}

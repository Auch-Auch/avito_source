package xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.google.gson.Gson;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.IdentityType;
import com.sumsub.sns.core.domain.FaceDetector;
import com.sumsub.sns.core.domain.SendLogUseCase;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88;
import xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.UGPkPVVOmk179tTX8sQoOodQt;
public final class jwhDxwXekejRxO2JfrNpROimz extends AbstractSavedStateViewModelFactory {
    public final ServiceLocator Cwa7EHp4RmMFhwpOCPWojiqbo;

    public jwhDxwXekejRxO2JfrNpROimz(@NotNull SavedStateRegistryOwner savedStateRegistryOwner, @NotNull ServiceLocator serviceLocator, @Nullable Bundle bundle) {
        super(savedStateRegistryOwner, bundle);
        this.Cwa7EHp4RmMFhwpOCPWojiqbo = serviceLocator;
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    public <T extends ViewModel> T create(@NotNull String str, @NotNull Class<T> cls, @NotNull SavedStateHandle savedStateHandle) {
        FaceDetector faceDetector = this.Cwa7EHp4RmMFhwpOCPWojiqbo.getFaceDetector();
        Gson gson = this.Cwa7EHp4RmMFhwpOCPWojiqbo.getGson();
        UGPkPVVOmk179tTX8sQoOodQt uGPkPVVOmk179tTX8sQoOodQt = new UGPkPVVOmk179tTX8sQoOodQt();
        OkHttpClient okHttpClient = this.Cwa7EHp4RmMFhwpOCPWojiqbo.getOkHttpClient();
        String str2 = (String) savedStateHandle.get("EXTRA_ID_DOC_SET_TYPE");
        if (str2 == null) {
            str2 = IdentityType.Companion.m215getSelfieGm96dUI();
        }
        return new tjrpI83q5sk1iMEXPz1hKo(faceDetector, gson, uGPkPVVOmk179tTX8sQoOodQt, new BYfFGQyI88(okHttpClient, str2, this.Cwa7EHp4RmMFhwpOCPWojiqbo.getSession(), this.Cwa7EHp4RmMFhwpOCPWojiqbo.getGson(), this.Cwa7EHp4RmMFhwpOCPWojiqbo.getTokenProvider()), this.Cwa7EHp4RmMFhwpOCPWojiqbo.getSettingsRepository(), this.Cwa7EHp4RmMFhwpOCPWojiqbo.getCommonRepository(), this.Cwa7EHp4RmMFhwpOCPWojiqbo.getSession().getFlowName(), new SendLogUseCase(this.Cwa7EHp4RmMFhwpOCPWojiqbo));
    }
}

package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSApplicantNotFoundException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "applicantId", "<init>", "(Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSApplicantNotFoundException extends Exception {
    public SNSApplicantNotFoundException() {
        this(null, 1, null);
    }

    public SNSApplicantNotFoundException(@Nullable String str) {
        super(a.e3("Applicant(", str, ") is not found"));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantNotFoundException(String str, int i, j jVar) {
        this((i & 1) != 0 ? null : str);
    }
}

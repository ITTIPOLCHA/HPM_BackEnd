package com.gj.hpm.service;

import java.util.List;

import com.gj.hpm.dto.request.CreateBloodPressureRequest;
import com.gj.hpm.dto.request.DeleteBloodPressureByIdRequest;
import com.gj.hpm.dto.request.DeleteBloodPressureByTokenRequest;
import com.gj.hpm.dto.request.GetBloodPressureByTokenPagingRequest;
import com.gj.hpm.dto.request.GetBloodPressureCreateByRequest;
import com.gj.hpm.dto.request.GetBloodPressurePagingRequest;
import com.gj.hpm.dto.request.GetBloodPressureRequest;
import com.gj.hpm.dto.request.UpdateBloodPressureByIdRequest;
import com.gj.hpm.dto.request.UpdateBloodPressureByTokenRequest;
import com.gj.hpm.dto.response.BaseResponse;
import com.gj.hpm.dto.response.GetBloodPressurePagingResponse;
import com.gj.hpm.dto.response.GetBloodPressureResponse;
import com.gj.hpm.dto.response.JwtClaimsDTO;

public interface BloodPressureRecordService {
    BaseResponse createBloodPressure(JwtClaimsDTO dto, CreateBloodPressureRequest request);

    BaseResponse uploadImage(JwtClaimsDTO dto, String base64Image);

    GetBloodPressureResponse getBloodPressureById(GetBloodPressureRequest request);

    List<GetBloodPressureResponse> getBloodPressureByCreateBy(GetBloodPressureCreateByRequest request);

    GetBloodPressureResponse getBloodPressureByToken(String id, GetBloodPressureRequest request);

    GetBloodPressurePagingResponse getBloodPressurePaging(GetBloodPressurePagingRequest request);

    GetBloodPressurePagingResponse getBloodPressurePagingByUserId(String id,
            GetBloodPressureByTokenPagingRequest request);

    BaseResponse updateBloodPressureById(UpdateBloodPressureByIdRequest request);

    BaseResponse updateBloodPressureByToken(String id, UpdateBloodPressureByTokenRequest request);

    BaseResponse deleteBloodPressureById(DeleteBloodPressureByIdRequest request);

    BaseResponse deleteBloodPressureByToken(String id, DeleteBloodPressureByTokenRequest request);

}
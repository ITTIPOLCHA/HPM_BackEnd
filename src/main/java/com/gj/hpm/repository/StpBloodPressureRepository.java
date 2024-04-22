package com.gj.hpm.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.gj.hpm.dto.response.GetBloodPressureCurrentResponse;
import com.gj.hpm.dto.response.GetBloodPressureResponse;
import com.gj.hpm.entity.BloodPressure;

public interface StpBloodPressureRepository extends MongoRepository<BloodPressure, String> {

    @Query("{ '_id': ?0 }")
    Optional<GetBloodPressureResponse> findByIdGetBloodPressureResp(String id);

    Optional<GetBloodPressureResponse> findByIdAndCreateById(String id, String userId);

    @Query("{ '_id': ?0, 'createBy._id': ?1}")
    Optional<BloodPressure> findByIdAndCreateBy_Id(String id, String userId);

    boolean existsByCreateDateAfterAndCreateById(LocalDateTime createDate, String createById);

    boolean existsById(String id);

    boolean existsByIdAndCreateById(String id, String createById);

    @Aggregation(pipeline = { "{ $sort: { 'createAt': -1 } }", "{ $limit: 1 }" })
    GetBloodPressureCurrentResponse findByCurrent();

    void deleteByCreateBy_Id(String createById);
}

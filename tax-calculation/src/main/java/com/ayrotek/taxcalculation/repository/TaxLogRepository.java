package com.ayrotek.taxcalculation.repository;

import com.ayrotek.taxcalculation.model.TaxLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaxLogRepository extends MongoRepository<TaxLog, Long> {
}

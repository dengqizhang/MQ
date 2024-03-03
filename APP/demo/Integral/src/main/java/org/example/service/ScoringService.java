package org.example.service;

import org.apache.ibatis.annotations.Param;

public interface ScoringService {
    int insertScoring(@Param("pid") int pid, @Param("amount") String amount);

}

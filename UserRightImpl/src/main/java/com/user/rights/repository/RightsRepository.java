package com.user.rights.repository;

import com.user.rights.entity.Rights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RightsRepository extends JpaRepository<Rights, Long>, JpaSpecificationExecutor<Rights> {
}

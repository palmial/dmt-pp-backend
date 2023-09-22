package org.dmt.eurostat.dmtpostprocessing.point;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<PointViewEntity, String>, JpaSpecificationExecutor<PointViewEntity> {
}

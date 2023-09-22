package org.dmt.eurostat.dmtpostprocessing.point;

import org.dmt.eurostat.dmtpostprocessing.models.Points;

public interface PointService {

    Points getAllPoints(Integer pageSize, Integer pageNumber);

}

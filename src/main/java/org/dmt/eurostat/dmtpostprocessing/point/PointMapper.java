package org.dmt.eurostat.dmtpostprocessing.point;

import org.dmt.eurostat.dmtpostprocessing.common.page.PageMapper;
import org.dmt.eurostat.dmtpostprocessing.models.Point;
import org.springframework.stereotype.Component;

@Component
public class PointMapper extends PageMapper {
    public Point toPointAPI(PointViewEntity entity) {
        Point point = new Point();
        point.setId(entity.getId());
        point.setUserId(entity.getUserId());
        point.setCountry(entity.getCountry());
        point.setStatus(entity.getStatus());
        point.setLevel(entity.getLevel());
        point.setWorkflow(entity.getWorkflow());
        point.setLatitude(entity.getLatitude());
        point.setLongitude(entity.getLongitude());
        point.setAltitude(entity.getAltitude());
        //TODO Check which are exactly the columns that should be used. The T_SURVEY table contain 585 columns
        return point;
    }
}

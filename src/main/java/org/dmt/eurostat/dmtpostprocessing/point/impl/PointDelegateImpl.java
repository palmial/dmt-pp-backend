package org.dmt.eurostat.dmtpostprocessing.point.impl;

import org.dmt.eurostat.dmtpostprocessing.api.PointsApiDelegate;
import org.dmt.eurostat.dmtpostprocessing.models.Points;
import org.dmt.eurostat.dmtpostprocessing.point.PointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PointDelegateImpl implements PointsApiDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(PointDelegateImpl.class);

    private PointService service;

    public PointDelegateImpl(PointService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Points> getAllPoints(Integer pageNumber, Integer pageSize) {
        try {
            Points points = service.getAllPoints(pageSize, pageNumber);
            LOG.debug("Points: ", points);
            return ResponseEntity.ok(points);
        } catch (Exception e) {
            LOG.error("Points processing error: ", e);
            return ResponseEntity.badRequest().build();
        }
    }
}

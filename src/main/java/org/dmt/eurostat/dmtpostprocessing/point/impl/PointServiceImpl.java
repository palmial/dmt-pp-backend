package org.dmt.eurostat.dmtpostprocessing.point.impl;

import org.dmt.eurostat.dmtpostprocessing.common.page.PageMapper;
import org.dmt.eurostat.dmtpostprocessing.models.Point;
import org.dmt.eurostat.dmtpostprocessing.models.Points;
import org.dmt.eurostat.dmtpostprocessing.point.PointViewEntity;
import org.dmt.eurostat.dmtpostprocessing.point.PointMapper;
import org.dmt.eurostat.dmtpostprocessing.point.PointRepository;
import org.dmt.eurostat.dmtpostprocessing.point.PointService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@Service
public class PointServiceImpl implements PointService {
    private static final Logger LOG = LoggerFactory.getLogger(PointServiceImpl.class);

    private PointRepository repository;
    private PointMapper mapper;

    public PointServiceImpl(PointRepository repository, PointMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Points getAllPoints(Integer pageSize, Integer pageNumber) {
        if (Objects.isNull(pageSize) || pageSize <= 0) {
            pageSize = PageMapper.DEFAULT_PAGE_SIZE;
        }

        if (Objects.isNull(pageNumber) || pageNumber <= 0) {
            pageNumber = PageMapper.DEFAULT_PAGE_NUMBER;
        }

        Pageable pageable = PageMapper.toPageable(pageNumber, pageSize);
        Page<PointViewEntity> pageEntities = repository.findAll(pageable);
        Page<Point> pointsPage = pageEntities.map(point -> mapper.toPointAPI(point));
        Points points = new Points();
        points.setItems(pointsPage.getContent());
        points.setPage(PageMapper.toPageAPI(pointsPage));
        LOG.debug("Getting points");
        return points;
    }
}

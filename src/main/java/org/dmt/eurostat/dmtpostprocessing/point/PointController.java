package org.dmt.eurostat.dmtpostprocessing.point;

import org.dmt.eurostat.dmtpostprocessing.api.PointsApiController;
import org.dmt.eurostat.dmtpostprocessing.api.PointsApiDelegate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** pp means Post Processing routes*/
@RestController
@RequestMapping("/pp")
public class PointController extends PointsApiController {
    public PointController(PointsApiDelegate delegate) {
        super(delegate);
    }
}

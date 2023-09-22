package org.dmt.eurostat.dmtpostprocessing.point;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "V_ALL_POINTS_POST_PROCESSING")
@Data
public class PointViewEntity {

    @Id
    @Column(name = "POINT_ID")
    private String id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "SURVEY_STATUS")
    private Integer status;

    @Column(name = "SURVEY_LEVEL")
    private Integer level;

    @Column(name = "SURVEY_WORKFLOW")
    private String workflow;

    @Column(name = "COUNTRY_CODE")
    private String country;

    @Column(name = "POINT_LAT")
    private Double latitude;

    @Column(name = "POINT_LONG")
    private Double longitude;

    @Column(name = "POINT_ALTITUDE")
    private Double altitude;
}

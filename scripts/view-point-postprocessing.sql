--------------------------------------------------------
--  DDL for View V_ALL_POINTS_POST_PROCESSING
--------------------------------------------------------

CREATE OR REPLACE FORCE EDITIONABLE VIEW "DMT2022"."V_ALL_POINTS_POST_PROCESSING" ("POINT_ID",
                                                    "COUNTRY_CODE",
                                                    "USER_ID",
                                                    "SURVEY_LEVEL",
                                                    "SURVEY_STATUS",
                                                    "SURVEY_WORKFLOW",
                                                    "POINT_LAT",
                                                    "POINT_LONG",
                                                    "POINT_ALTITUDE") AS
SELECT p.POINT_ID,
       p.POINT_NUTS0 AS COUNTRY_CODE,
       p.USER_ID,
       s.SURVEY_LEVEL,
       s.SURVEY_STATUS,
       s.SURVEY_WORKFLOW,
       p.POINT_LAT,
       p.POINT_LONG,
       p.POINT_ALTITUDE
FROM T_POINT p
         INNER JOIN T_SURVEY s ON p.POINT_ID = s.POINT_ID
ORDER BY p.POINT_NUTS0,
         p.POINT_ID;


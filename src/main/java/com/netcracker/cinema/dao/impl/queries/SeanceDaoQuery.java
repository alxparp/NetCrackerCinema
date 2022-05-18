package com.netcracker.cinema.dao.impl.queries;

public interface SeanceDaoQuery {

    String FIND_ALL_SQL =
            " SELECT " +
                    " SEANCE.OBJECT_ID ID " +
                    ", DATE_ATTR.DATE_VALUE START_DATE " +
                    ", SEANCE_MOVIE_REF.OBJECT_ID MOVIE_ID " +
                    ", SEANCE_HALL_REF.OBJECT_ID HALL_ID " +
            " FROM " +
                    " OBJECTS SEANCE " +
                    " LEFT JOIN ATTRIBUTES DATE_ATTR" +
                        " ON  SEANCE.OBJECT_ID = DATE_ATTR.OBJECT_ID " +
                    " LEFT JOIN OBJREFERENCE SEANCE_MOVIE_REF " +
                        " ON SEANCE.OBJECT_ID = SEANCE_MOVIE_REF.REFERENCE " +
                    " LEFT JOIN OBJREFERENCE SEANCE_HALL_REF " +
                        " ON SEANCE.OBJECT_ID = SEANCE_HALL_REF.REFERENCE " +
            " WHERE " +
                    " SEANCE.OBJECT_TYPE_ID = 5 AND " +
                    " DATE_ATTR.ATTR_ID = 13 AND " +
                    " SEANCE_MOVIE_REF.ATTR_ID = 14 AND " +
                    " SEANCE_HALL_REF.ATTR_ID = 15";

    String FIND_SEANCE_BY_ID =
            " SELECT " +
                " SEANCE.OBJECT_ID ID " +
                ", DATE_ATTR.DATE_VALUE START_DATE " +
                ", SEANCE_MOVIE_REF.OBJECT_ID MOVIE_ID " +
                ", SEANCE_HALL_REF.OBJECT_ID HALL_ID " +
            " FROM " +
                " OBJECTS SEANCE " +
                " LEFT JOIN ATTRIBUTES DATE_ATTR" +
                    " ON  SEANCE.OBJECT_ID = DATE_ATTR.OBJECT_ID " +
                " LEFT JOIN OBJREFERENCE SEANCE_MOVIE_REF " +
                    " ON SEANCE.OBJECT_ID = SEANCE_MOVIE_REF.REFERENCE " +
                " LEFT JOIN OBJREFERENCE SEANCE_HALL_REF " +
                    " ON SEANCE.OBJECT_ID = SEANCE_HALL_REF.REFERENCE " +
            " WHERE " +
                " SEANCE.OBJECT_TYPE_ID = 5 AND " +
                " SEANCE.OBJECT_ID = ? AND " +
                " DATE_ATTR.ATTR_ID = 13 AND " +
                " SEANCE_MOVIE_REF.ATTR_ID = 14 AND " +
                " SEANCE_HALL_REF.ATTR_ID = 15";

    String FIND_SEANCE_BY_HALL_AND_DATE =
            "SELECT " +
                    "    SEANCE.OBJECT_ID ID " +
                    "  , DATE_ATTR.DATE_VALUE START_DATE " +
                    "  , SEANCE_MOVIE_REF.OBJECT_ID MOVIE_ID " +
                    "  , SEANCE_HALL_REF.OBJECT_ID HALL_ID " +
                    "FROM " +
                    "  OBJECTS SEANCE " +
                    "  LEFT JOIN ATTRIBUTES DATE_ATTR " +
                    "    ON  SEANCE.OBJECT_ID = DATE_ATTR.OBJECT_ID " +
                    "  LEFT JOIN OBJREFERENCE SEANCE_MOVIE_REF " +
                    "    ON SEANCE.OBJECT_ID = SEANCE_MOVIE_REF.REFERENCE " +
                    "  LEFT JOIN OBJREFERENCE SEANCE_HALL_REF " +
                    "    ON SEANCE.OBJECT_ID = SEANCE_HALL_REF.REFERENCE " +
                    "WHERE " +
                    "  SEANCE.OBJECT_TYPE_ID = 5 AND " +
                    "  DATE_ATTR.ATTR_ID = 13 AND " +
                    "  SEANCE_MOVIE_REF.ATTR_ID = 14 AND " +
                    "  SEANCE_HALL_REF.ATTR_ID = 15 AND " +
                    "  SEANCE_HALL_REF.OBJECT_ID = ? AND " +
                    "  TRUNC(DATE_ATTR.DATE_VALUE) = ?";

    String DELETE_SEANCE =
            " DELETE " +
                " FROM OBJECTS " +
            " WHERE " +
                " OBJECT_ID = ? AND " +
                " OBJECT_TYPE_ID = 5";

    String MERGE_SEANCE_OBJECT =
            " MERGE INTO OBJECTS object " +
            " USING (SELECT ? AS id, 'Seance' AS name FROM dual) obj " +
                " ON(obj.id = object.OBJECT_ID) " +
            " WHEN MATCHED THEN " +
                " UPDATE " +
                    " SET " +
                    " object.NAME = obj.name " +
                " WHERE " +
                    " object.OBJECT_ID = obj.id " +
            " WHEN NOT MATCHED THEN " +
                " INSERT(object.OBJECT_ID, object.PARENT_ID, object.OBJECT_TYPE_ID, object.NAME, object.DESCRIPTION) " +
                " VALUES (GET_OBJ_ID.nextval, NULL, 5, obj.name, NULL)";

    String MERGE_SEANCE_ATTRIBUTE_DATE =
            " MERGE INTO ATTRIBUTES attr " +
            " USING (SELECT obj.OBJECT_ID AS obj_id, ? AS seance_date FROM OBJECTS obj RIGHT JOIN dual ON obj.OBJECT_ID  = ?) object " +
                " ON (object.obj_id = attr.OBJECT_ID AND attr.ATTR_ID = 13) " +
            " WHEN MATCHED THEN " +
                " UPDATE " +
                    " SET attr.DATE_VALUE = object.seance_date " +
                " WHERE " +
                    " attr.ATTR_ID = 13 AND " +
                    " attr.OBJECT_ID = object.obj_id " +
            " WHEN NOT MATCHED THEN " +
                " INSERT(attr.ATTR_ID, attr.OBJECT_ID, attr.VALUE, attr.DATE_VALUE) " +
                " VALUES(13, NVL(object.obj_id, GET_OBJ_ID.currval), NULL, object.seance_date)";

    String MERGE_SEANCE_ATTRIBUTE_MOVIE =
            " MERGE INTO OBJREFERENCE objref " +
                    " USING (SELECT obj.OBJECT_ID AS obj_id, ? AS movie_ref FROM OBJECTS obj RIGHT JOIN dual ON obj.OBJECT_ID  = ?) object " +
                    " ON (object.obj_id = objref.REFERENCE AND objref.ATTR_ID = 14) " +
                    " WHEN MATCHED THEN " +
                    " UPDATE " +
                    " SET objref.OBJECT_ID = object.movie_ref " +
                    " WHERE " +
                    " objref.ATTR_ID = 14 AND " +
                    " objref.REFERENCE = object.obj_id " +
                    " WHEN NOT MATCHED THEN " +
                    " INSERT(objref.ATTR_ID, objref.REFERENCE, objref.OBJECT_ID) " +
                    " VALUES(14, NVL(object.obj_id, GET_OBJ_ID.currval), object.movie_ref)";

    String MERGE_SEANCE_ATTRIBUTE_HALL =
            " MERGE INTO OBJREFERENCE objref " +
                    " USING (SELECT obj.OBJECT_ID AS obj_id, ? AS hall_ref FROM OBJECTS obj RIGHT JOIN dual ON obj.OBJECT_ID  = ?) object " +
                    " ON (object.obj_id = objref.REFERENCE AND objref.ATTR_ID = 15) " +
                    " WHEN MATCHED THEN " +
                    " UPDATE " +
                    " SET objref.OBJECT_ID = object.hall_ref " +
                    " WHERE " +
                    " objref.ATTR_ID = 15 AND " +
                    " objref.REFERENCE = object.obj_id " +
                    " WHEN NOT MATCHED THEN " +
                    " INSERT(objref.ATTR_ID, objref.REFERENCE, objref.OBJECT_ID) " +
                    " VALUES(15, NVL(object.obj_id, GET_OBJ_ID.currval), object.hall_ref)";

    String SELECT_ID_FOR_INSERTED_SEANCE =
            " SELECT GET_OBJ_ID.CURRVAL FROM DUAL ";

    String COUNT_ACTIVE_MOVIES_BY_ID =
            "select count(obj.object_id) count_of_seances\n" +
                    "from objtype otp\n" +
                    "  join objects obj\n" +
                    "    on obj.object_type_id = otp.object_type_id     \n" +
                    "  join attributes attr_date \n" +
                    "    on attr_date.object_id = obj.object_id\n" +
                    "  join attrtype atype_date\n" +
                    "    on atype_date.attr_id = attr_date.attr_id  \n" +
                    "  join objreference ref_movie\n" +
                    "    on ref_movie.reference = obj.object_id\n" +
                    "  join attrtype atype_movie\n" +
                    "    on atype_movie.attr_id = ref_movie.attr_id\n" +
                    "where otp.code = 'SEANCE'\n" +
                    "  and atype_movie.code = 'MOVIE_REF'\n" +
                    "  and atype_date.code = 'DATE'\n" +
                    "  and ref_movie.object_id = ?\n" +
                    "  and to_date(attr_date.date_value, 'DD-MM-YYYY HH24:MI:SS') >= to_date(sysdate, 'DD-MM-YYYY HH24:MI:SS')";
}

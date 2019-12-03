package com.repair.dao.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class DBUtils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("test_c3p0");
    public static QueryRunner getQueryRunner(){
        return new QueryRunner(dataSource);
    }
}

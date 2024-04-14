package com.work.springbatchwork.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class TestClass {

    @Qualifier("h2Datasource")
    private DataSource dsH2;

    @Qualifier("mysqlDatasource")
    private DataSource dsMysql;

    public DataSource getDsH2() {
        return dsH2;
    }

    public void setDsH2(DataSource dsH2) {
        this.dsH2 = dsH2;
    }

    public DataSource getDsMysql() {
        return dsMysql;
    }

    public void setDsMysql(DataSource dsMysql) {
        this.dsMysql = dsMysql;
    }
}


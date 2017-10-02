package main.com.Server;

import java.sql.Types;

public class SqlServerDialectWithNvarchar extends org.hibernate.dialect.SQLServerDialect {

    public SqlServerDialectWithNvarchar() {
        registerHibernateType(Types.NVARCHAR, 4000, "string");
    }

}
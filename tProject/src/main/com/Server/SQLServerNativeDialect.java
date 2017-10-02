package main.com.Server;

import java.sql.Types;
import org.hibernate.dialect.SQLServerDialect;

public class SQLServerNativeDialect extends SQLServerDialect{

    public SQLServerNativeDialect() {
        super();
        registerColumnType(Types.CHAR, "nchar(1)");
        registerColumnType(Types.VARCHAR, "nvarchar($l)");
        registerColumnType(Types.LONGVARCHAR, "nvarchar($l)");
        registerColumnType(Types.CLOB, "ntext");
    }

}
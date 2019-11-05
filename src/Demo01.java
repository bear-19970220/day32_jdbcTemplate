import com.alibaba.druid.util.JdbcUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

import static com.alibaba.druid.pool.DruidDataSourceFactory.createDataSource;

public class Demo01 {

    @Test
    public void test_jdbcTemplate() throws Exception {

        JdbcUtils jdbcUtils = new JdbcUtils();
        Properties props = new Properties();
        props.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));
        DataSource dateSource = createDataSource(props);

        Connection conn = dateSource.getConnection();

        String sql = "";
        Object[] params = {};
        JdbcUtils.executeQuery(dateSource, sql, params);


    }


}

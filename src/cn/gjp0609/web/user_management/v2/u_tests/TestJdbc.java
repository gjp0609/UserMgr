package cn.gjp0609.web.user_management.v2.u_tests;

import cn.gjp0609.web.user_management.v2.utils.Jdbc;
import org.junit.jupiter.api.Test;

/**
 * Created by gjp06 on 17.3.24.
 */
class TestJdbc {

    @Test
    void testConnection() {
        System.out.println(Jdbc.getConnection());
    }

}

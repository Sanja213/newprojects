package education.worker.worceraction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class ChekAction {public static int checkAction(HttpServletRequest req) throws SQLException {
    if (req.getParameter("addworker") != null) {
        return 1;
    }
    if (req.getParameter("delworker") != null) {
        return 2;
    }
    if (req.getParameter("chengedepartament") != null) {
        return 3;
    }
    if (req.getParameter("chengeposition") != null) {
        return 4;
    }
    return 0;

}
}

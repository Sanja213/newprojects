package education.departament.depaction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class ChekAction {
	public static int checkAction(HttpServletRequest req) throws SQLException {
        if (req.getParameter("changedep") != null) {
            return 1;
        }
        if (req.getParameter("changeman") != null) {
            return 2;
        }
        if (req.getParameter("workers") != null) {
            return 3;
        }
        return 0;

}
}

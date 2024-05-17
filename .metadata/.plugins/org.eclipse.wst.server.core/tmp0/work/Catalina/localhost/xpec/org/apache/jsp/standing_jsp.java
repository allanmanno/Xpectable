/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.24
 * Generated at: 2024-05-17 00:09:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class standing_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(5);
    _jspx_imports_classes.add("java.sql.SQLException");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.sql.DriverManager");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>XPectable Standing</title>\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"resources/css/fixture.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css\">\r\n");
      out.write("    \r\n");
      out.write("    <style>\r\n");
      out.write("        table {\r\n");
      out.write("    width: 50%;\r\n");
      out.write("    left: 25%;\r\n");
      out.write("    position: relative;\r\n");
      out.write("    margin-bottom: 20px;\r\n");
      out.write("}\r\n");
      out.write("        th, td {\r\n");
      out.write("            border: 1px solid #dddddd;\r\n");
      out.write("            text-align: left;\r\n");
      out.write("            padding: 8px;\r\n");
      out.write("        }\r\n");
      out.write("        th {\r\n");
      out.write("            background-color: #FC6736;\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script src=\"resources/js/fixture.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"menu_box\">\r\n");
      out.write("      <div class=\"logo\">\r\n");
      out.write("          <hr />\r\n");
      out.write("          <a href=\"index.jsp\"><h3><b style=\"color:#FC6736;font-size:35px\">XP</b>ectable</h3></a>\r\n");
      out.write("          <hr />\r\n");
      out.write("      </div>\r\n");
      out.write("      <ul>\r\n");
      out.write("          <li><a class=\"home\" href=\"index.jsp\"><i class=\"fa fa-home fa-fw\"></i>\r\n");
      out.write("              Home</a></li>\r\n");
      out.write("          <li><a href=\"fixture.jsp\"><i class=\"fa fa-calendar fa-fw\"></i>\r\n");
      out.write("              Fixture</a></li>\r\n");
      out.write("          <li><a href=\"standing.jsp\"><i class=\"fa-solid fa-ranking-star fa-fw\"></i>\r\n");
      out.write("              Standing</a></li>\r\n");
      out.write("          <li><a href=\"stat.jsp\"><i class=\"fa-solid fa-chart-column\"></i>\r\n");
      out.write("              Stats</a></li>\r\n");
      out.write("          <li><a href=\"contact.html\"><i class=\"fa fa-envelope fa-fw\"></i>\r\n");
      out.write("              Contact</a></li>\r\n");
      out.write("          \r\n");
      out.write("          <div class=\"social_media\">\r\n");
      out.write("              <a href=\"#\"><i class=\"fa-brands fa-linkedin\" style=\"color:#EFECEC\"></i></a>\r\n");
      out.write("              <a href=\"#\"><i class=\"fa-brands fa-github\" style=\"color:#EFECEC\"></i></a>\r\n");
      out.write("          </div>\r\n");
      out.write("      </ul>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"filter-dropdown\">\r\n");
      out.write("    <label for=\"drop-btn\" class=\"dropdown-label\">Filter:</label>\r\n");
      out.write("    <button onclick=\"dropdownFunction()\" id=\"drop-btn\" class=\"dropdown-btn\">League</button>\r\n");
      out.write("    <ul id=\"drop-content\" class=\"dropdown-content\">\r\n");
      out.write("        <li><a href=\"standing.jsp?league_id=-1\">All</a></li>\r\n");
      out.write("        <li><a href=\"standing.jsp?league_id=1\">Massachusetts</a>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"standing.jsp?league_id=301\">Division 1</a></li>\r\n");
      out.write("                <li><a href=\"standing.jsp?league_id=302\">Division 2</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li><a href=\"standing.jsp?league_id=2\">New Jersey</a>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"standing.jsp?league_id=201\">Division 1</a></li>\r\n");
      out.write("                <li><a href=\"standing.jsp?league_id=202\">Division 2</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li><a href=\"standing.jsp?league_id=3\">New York</a>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"standing.jsp?league_id=101\">Division 1</a></li>\r\n");
      out.write("                <li><a href=\"standing.jsp?league_id=102\">Division 2</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li><a href=\"standing.jsp?league_id=4\">Pennsylvania</a>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"standing.jsp?league_id=401\">Division 1</a></li>\r\n");
      out.write("                <li><a href=\"standing.jsp?league_id=402\">Division 2</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li><a href=\"standing.jsp?league_id=5\">Virginia</a>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"standing.jsp?league_id=501\">Division 1</a></li>\r\n");
      out.write("                <li><a href=\"standing.jsp?league_id=502\">Division 2</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h2 style=\"padding-top: 200px; padding-left:40%;\">League Standings</h2>\r\n");
      out.write("\r\n");
      out.write("\r\n");

    // Retrieve league_id from request parameters
    int leagueIdFilter = -1; // Default to show all leagues
    String leagueIdParam = request.getParameter("league_id");
    if (leagueIdParam != null && !leagueIdParam.isEmpty()) {
        leagueIdFilter = Integer.parseInt(leagueIdParam);
    }
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xpectable_data", "root", "MyPass123!");

        // Retrieve distinct league ids with their names
        stmt = conn.prepareStatement("SELECT DISTINCT s.league_id, l.league_name FROM standing s JOIN league l ON s.league_id = l.league_id WHERE ? = -1 OR s.league_id = ?");
        stmt.setInt(1, leagueIdFilter);
        stmt.setInt(2, leagueIdFilter);
        rs = stmt.executeQuery();
        while (rs.next()) {
            int leagueId = rs.getInt("league_id");
            String leagueName = rs.getString("league_name");
            

            // Retrieve standings data for the current league
            PreparedStatement stmt2 = conn.prepareStatement("SELECT t.team_name, " +
                                                                   "SUM(s.game_played) AS played, " +
                                                                   "SUM(s.game_won) AS won, " +
                                                                   "SUM(s.game_drawn) AS drawn, " +
                                                                   "SUM(s.game_lost) AS lost, " +
                                                                   "SUM(s.goals_for) AS goals_for, " +
                                                                   "SUM(s.goals_against) AS goals_against, " +
                                                                   "SUM(s.points) AS points, " +
                                                                   "SUM(s.goals_for) - SUM(s.goals_against) AS goal_difference " +
                                                               "FROM team t " +
                                                               "LEFT JOIN standing s ON t.team_id = s.team_id " +
                                                               "WHERE s.league_id = ? " +
                                                               "GROUP BY t.team_name " +
                                                               "ORDER BY points DESC");
            stmt2.setInt(1, leagueId);
            ResultSet rs2 = stmt2.executeQuery();

      out.write("\r\n");
      out.write("<h5 style=\"padding-left: 25%;\">");
      out.print( leagueName );
      out.write("</h5>\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th>Position</th>\r\n");
      out.write("        <th>Team</th>\r\n");
      out.write("        <th>Played</th>\r\n");
      out.write("        <th>Won</th>\r\n");
      out.write("        <th>Drawn</th>\r\n");
      out.write("        <th>Lost</th>\r\n");
      out.write("        <th>Goals For</th>\r\n");
      out.write("        <th>Goals Against</th>\r\n");
      out.write("        <th>Goal Difference</th>\r\n");
      out.write("        <th>Points</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");

            int position = 1;
            while (rs2.next()) {
    
      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td>");
      out.print( position++ );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( rs2.getString("team_name") );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( rs2.getInt("played") );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( rs2.getInt("won") );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( rs2.getInt("drawn") );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( rs2.getInt("lost") );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( rs2.getInt("goals_for") );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( rs2.getInt("goals_against") );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( rs2.getInt("goal_difference") );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( rs2.getInt("points") );
      out.write("</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");

            }
            rs2.close();
            stmt2.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("<script src=\"resources/js/standing.js\"></script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
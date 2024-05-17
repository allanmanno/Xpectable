<%@ page import="java.sql.*" %>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>League Statistics</title>
    <!-- Include Chart.js library -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="stylesheet" href="resources/css/stat.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    
    <style>
        .chart-container {
            width: 20%;
            display: inline-block;
            margin: 0 ;
            padding-top: 200px; /* Add padding to the top */
            text-align: center; /* Center align the charts */
        }
    </style>
</head>

<body>
<div class="menu_box">
      <div class="logo">
          <hr>
          <a href="index.jsp"><h3><b style="color:#FC6736;font-size:35px">XP</b>ectable</h3></a>
          <hr>
      </div>
      <ul>
          <li><a class="home" href="index.jsp"><i class="fa fa-home fa-fw"></i>
              Home</a></li>
          <li><a href="fixture.jsp"><i class="fa fa-calendar fa-fw"></i>
              Fixture</a></li>
          <li><a href="standing.jsp"><i class="fa-solid fa-ranking-star fa-fw"></i>
              Standing</a></li>
          <li><a href="stat.jsp"><i class="fa-solid fa-chart-column"></i>
              Stats</a></li>
          <li><a href="contact.html"><i class="fa fa-envelope fa-fw"></i>
              Contact</a></li>
          
          <div class="social_media">
              <a href="#"><i class="fa-brands fa-linkedin" style="color:#EFECEC"></i></a>
              <a href="#"><i class="fa-brands fa-github" style="color:#EFECEC"></i></a>
          </div>
      </ul>
  </div>

<div class="filter-dropdown">
      <label for="drop-btn" class="dropdown-label">Filter:</label>
      <button onclick="dropdownFunction()" id="drop-btn" class="dropdown-btn">All</button>
      <ul id="drop-content" class="dropdown-content">
        <li><a href="stat.jsp?league_id=-1">All</a></li>
        <li><a href="stat.jsp?league_id=1">Massachusetts</a>
            <ul>
                <li><a href="stat.jsp?league_id=301">Division 1</a></li>
                <li><a href="stat.jsp?league_id=302">Division 2</a></li>
            </ul>
        </li>
        <li><a href="stat.jsp?league_id=2">New Jersey</a>
            <ul>
                <li><a href="stat.jsp?league_id=201">Division 1</a></li>
                <li><a href="stat.jsp?league_id=202">Division 2</a></li>
            </ul>
        </li>
        <li><a href="stat.jsp?league_id=3">New York</a>
            <ul>
                <li><a href="stat.jsp?league_id=101">Division 1</a></li>
                <li><a href="stat.jsp?league_id=102">Division 2</a></li>
            </ul>
        </li>
        <li><a href="stat.jsp?league_id=4">Pennsylvania</a>
            <ul>
                <li><a href="stat.jsp?league_id=401">Division 1</a></li>
                <li><a href="stat.jsp?league_id=402">Division 2</a></li>
            </ul>
        </li>
        <li><a href="stat.jsp?league_id=5">Virginia</a>
            <ul>
                <li><a href="stat.jsp?league_id=501">Division 1</a></li>
                <li><a href="stat.jsp?league_id=502">Division 2</a></li>
            </ul>
        </li>
    </ul>
</div>

<!-- Create chart containers for the charts -->
<div class="charts-container"> <!-- Container for the charts -->
    <!-- Create chart containers for the charts -->
    <div class="chart-container">
        <canvas id="goalsForChart" width="400" height="400"></canvas>
    </div>
    <div class="chart-container">
        <canvas id="goalsAgainstChart" width="400" height="400"></canvas>
    </div>
    <div class="chart-container">
        <canvas id="gamesWonChart" width="400" height="400"></canvas>
    </div>
</div>
   <%
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    // Retrieve league ID parameter from URL
    int leagueIdFilter = -1; // Default to show all leagues
    String leagueIdParam = request.getParameter("league_id");
    if (leagueIdParam != null && !leagueIdParam.isEmpty()) {
        leagueIdFilter = Integer.parseInt(leagueIdParam);
    }

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xpectable_data", "root", "MyPass123!");

        // Retrieve standings data for the current league or all leagues if leagueIdFilter is -1
        String query = "SELECT t.team_name, " +
                                "SUM(s.goals_for) AS goals_for, " +
                                "SUM(s.goals_against) AS goals_against, " +
                                "SUM(s.game_won) AS games_won " +
                        "FROM team t " +
                        "LEFT JOIN standing s ON t.team_id = s.team_id ";
        if (leagueIdFilter != -1) {
            query += "WHERE s.league_id = ? ";
        }
        query += "GROUP BY t.team_name " +
                  "ORDER BY t.team_name ASC";

        stmt = conn.prepareStatement(query);
        if (leagueIdFilter != -1) {
            stmt.setInt(1, leagueIdFilter);
        }
        rs = stmt.executeQuery();

        // Initialize arrays to store data for the charts
        String[] teamNames = new String[10]; // Assuming you're displaying data for top 10 teams
        int[] goalsFor = new int[10];
        int[] goalsAgainst = new int[10];
        int[] gamesWon = new int[10];
        int i = 0;
        while (rs.next() && i < 10) { // Retrieve data for top 10 teams
            teamNames[i] = rs.getString("team_name");
            goalsFor[i] = rs.getInt("goals_for");
            goalsAgainst[i] = rs.getInt("goals_against");
            gamesWon[i] = rs.getInt("games_won");
            i++;
        }
%>



<script>
    // Get data from JSP variables
    var teamNames = <%= new com.google.gson.Gson().toJson(teamNames) %>;
    var goalsFor = <%= new com.google.gson.Gson().toJson(goalsFor) %>;
    var goalsAgainst = <%= new com.google.gson.Gson().toJson(goalsAgainst) %>;
    var gamesWon = <%= new com.google.gson.Gson().toJson(gamesWon) %>;

    // Create bar chart for goals scored
    var ctxGoalsFor = document.getElementById('goalsForChart').getContext('2d');
    var goalsForChart = new Chart(ctxGoalsFor, {
        type: 'bar',
        data: {
            labels: teamNames,
            datasets: [{
                label: 'Goals For',
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1,
                data: goalsFor
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });

    // Create bar chart for goals against
    var ctxGoalsAgainst = document.getElementById('goalsAgainstChart').getContext('2d');
    var goalsAgainstChart = new Chart(ctxGoalsAgainst, {
        type: 'bar',
        data: {
            labels: teamNames,
            datasets: [{
                label: 'Goals Against',
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1,
                data: goalsAgainst
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });

    // Create bar chart for games won
    var ctxGamesWon = document.getElementById('gamesWonChart').getContext('2d');
    var gamesWonChart = new Chart(ctxGamesWon, {
        type: 'bar',
        data: {
            labels: teamNames,
            datasets: [{
                label: 'Games Won',
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1,
            data: gamesWon
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
</script>

<%
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
%>
</body>
<script src="resources/js/fixture.js"></script>
</html>
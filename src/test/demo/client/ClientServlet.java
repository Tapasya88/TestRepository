package test.demo.client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.jdbc.db.Employee;
import com.demo.jdbc.db.JDBCMySQLConnection;
import com.mysql.jdbc.PreparedStatement;
import com.google.gson.Gson;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		ResultSet rs = null;
		Connection connection = null;
		PreparedStatement statement = null; 
		Employee employee = null;
		if(search ==null ){
		String email = request.getParameter("exampleInputEmail");
		String position = request.getParameter("exampleInputPosition");
		String name = request.getParameter("exampleInputName");
		String phone = request.getParameter("exampleInputPhone");
		String loc = request.getParameter("exampleInputLocation");
		String client = request.getParameter("exampleInputClient");
		System.out.println("Data given -"+email+"||"+position+"||"+name+"||"+phone+"||"+loc+"||"+client);
		
		//Employee employee = null;
		final String insert ="insert into tracker(id,name,email,phone,locaion,client,position) values(?,?,?,?,?,?,?)" ;
		try {			
			connection = JDBCMySQLConnection.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insert);
			statement.setInt(1, 6);
			statement.setString(2, name);
			statement.setString(3, email);
			statement.setString(4, phone);
			statement.setString(5, loc);
			statement.setString(6, client);
			statement.setString(7, position);
			statement.execute();
			//connection.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}else{
			String clt = request.getParameter("exampleInputClient");
			String query = "SELECT * FROM tracker WHERE client='"+clt+"'";
			try {			
				connection = JDBCMySQLConnection.getConnection();
				Statement s = connection.createStatement();
				rs = s.executeQuery(query);
						
				if (rs.next()) {
					employee = new Employee();
					//employee.setEmpId(rs.getInt("id"));
					employee.setExampleInputName(rs.getString("name"));
					employee.setExampleInputEmail(rs.getString("email"));
					employee.setExampleInputClient(rs.getString("client"));
					employee.setExampleInputLocation(rs.getString("locaion"));
					employee.setExampleInputPhone(rs.getString("phone"));
					employee.setExampleInputPosition(rs.getString("position"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			Gson gson = new Gson();	
			String json = gson.toJson(employee);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}

}

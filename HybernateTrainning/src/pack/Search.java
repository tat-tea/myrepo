package pack;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserInfoBean;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginid = null;
		String password = null;

		if (request.getParameter("loginid") != null && "".equals(request.getParameter("loginid"))) {
			loginid = request.getParameter("loginid");
		}

		if (request.getParameter("password") != null && "".equals(request.getParameter("password"))) {
			password = request.getParameter("password");
		}

		// DB接続
		MySQLConnector con = new MySQLConnector();
		List<UserInfoBean> user_list = con.select_user_info(loginid, password);
		System.out.println("取得件数：" + user_list.size());

		if (user_list != null && user_list.size() > 0) {

			request.setAttribute("usrlist", user_list);

		}

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);

	}

}

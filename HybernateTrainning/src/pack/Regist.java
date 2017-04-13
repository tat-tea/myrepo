package pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Regist() {
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

		// リクエストの取得
		String loginid = null;
		String password = null;
		String memo = null;

		loginid = request.getParameter("loginid");
		password = request.getParameter("password");
		memo = request.getParameter("memo");

		if ("".equals(loginid) || "".equals(password)) {

			request.setAttribute("errNum", "Y0001");
			request.setAttribute("errMsg", "不正なリクエストを検知しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);

			return;
		}

		// DB接続
		MySQLConnector con = new MySQLConnector();
		con.insert_user_info(loginid, password);

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);

	}

	private void errorPage(HttpServletResponse response, String errorNum, String errorMsg) throws IOException {
		response.sendRedirect("http://localhost:8080/HybernateTrainning/error.jsp");
	}

}

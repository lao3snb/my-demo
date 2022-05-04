package servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

/**
 * Session对象
 *      Session表示一次会话，会话中可以有多次请求，会话保留指定时间段
 *      无论是客户端还是服务端，都能感知Session对象。（服务器和浏览器都会影响Session对象）
 *      获取Session对象 或 创建Session对象
 *          request.getSession()
 *          当Session对象存在时，表示获取Session对象；否则表示创建Session对象
 *
 *      request作用域：
 *          在一次请求中有效
 *          只在请求转发跳转有效
 *
 *      session作用域：
 *          在一次会话中有效，一次会话包含多次请求
 *          在请求转发与重定向跳转中都有效
 */

@WebServlet(name="se02", urlPatterns = ["/se02"])
class Session02 : HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {

         // 创建或获取Session对象
        val session = req?.session

        // request作用域
        req?.setAttribute("requestMsg", "这是request的作用域")

        // session作用域
        session?.setAttribute("sessionMsg", "这是session的作用域")

//        // 请求转发
//        req?.getRequestDispatcher("index.jsp")?.forward(req, resp)

        // 重定向
        resp?.sendRedirect("index.jsp")

    }
}